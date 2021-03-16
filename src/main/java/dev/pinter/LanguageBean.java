/*
 * Copyright (C) 2021 - Flavio Freitas Pinter
 */

package dev.pinter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Named("language")
@SessionScoped
public class LanguageBean implements Serializable {
    public static final String RESOURCE_BUNDLE = "dev.pinter.i18n.messages";
    private Locale current = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();

    public static String getMsg(String resourceBundleKey) {
        return Msg.get(resourceBundleKey);
    }

    @PostConstruct
    public void init() {
        Locale fromBrowser = null;
        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
            fromBrowser = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        } else {
            fromBrowser = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
        }

        if (isLocaleSupported(fromBrowser)) {
            current = fromBrowser;
        }
    }

    public Locale getCurrent() {
        return current;
    }

    public List<Locale> getSupported() {
        Iterator<Locale> i = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        List<Locale> supportedLocales = new ArrayList<>();
        while (i.hasNext()) {
            supportedLocales.add(i.next());
        }
        return supportedLocales;
    }

    public boolean isLocaleSupported(Locale locale) {
        if (locale == null || locale.toString().equals("")) {
            return false;
        }
        boolean found;
        if (!(found = getSupported().stream().anyMatch(s -> s.equals(locale)))) {
            found = getSupported().stream().anyMatch(s -> s.getLanguage().equals(locale.getLanguage()));
        }

        return found;
    }

    public void setCurrentLocale(String newLocale) {
        Locale l;
        if (newLocale.contains("_")) {
            String[] languageCountry = newLocale.split("_");
            l = new Locale(languageCountry[0], languageCountry[1].toUpperCase());
        } else {
            l = new Locale(newLocale);
        }
        if (isLocaleSupported(l)) {
            current = l;
            FacesContext.getCurrentInstance().getViewRoot().setLocale(current);
        }
    }
}
