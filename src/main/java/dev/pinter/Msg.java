/*
 * Copyright (C) 2021 - Flavio Freitas Pinter
 */

package dev.pinter;

import org.apache.commons.lang3.StringUtils;

import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Msg {
    public static String getResourceBundleString(String resourceBundleName, String resourceBundleKey)
            throws MissingResourceException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, resourceBundleName);
        return bundle.getString(resourceBundleKey);
    }

    public static String getResourceBundleString(String resourceBundleName, String resourceBundleKey, Locale locale)
            throws MissingResourceException {
        ResourceBundle bundle = ResourceBundle.getBundle(resourceBundleName, locale);
        return bundle.getString(resourceBundleKey);
    }

    public static String getMsgLocale(String resourceBundleKey, Locale locale)
            throws MissingResourceException {
        ResourceBundle bundle = ResourceBundle.getBundle(LanguageBean.RESOURCE_BUNDLE, locale);
        return bundle.getString(resourceBundleKey);
    }

    public static String getResourceBundleString(String resourceBundleName, String resourceBundleKey,
                                                 String[] params) throws MissingResourceException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, resourceBundleName);
        String text = bundle.getString(resourceBundleKey);
        MessageFormat mf = new MessageFormat(text, FacesContext.getCurrentInstance().getViewRoot().getLocale());
        return mf.format(params, new StringBuffer(), null).toString();
    }

    public static String get(String resourceBundleKey) {
        String m = null;
        try {
            m = Msg.getResourceBundleString("msg", resourceBundleKey);
        } catch (MissingResourceException ignored) {
        }

        if (StringUtils.isNotEmpty(m)) {
            return m;
        }
        return resourceBundleKey;
    }

    public static String getMsgEnglish(String resourceBundleKey) {
        String m = null;
        try {
            m = getResourceBundleString(LanguageBean.RESOURCE_BUNDLE, resourceBundleKey, Locale.ENGLISH);
        } catch (MissingResourceException ignored) {
        }

        if (StringUtils.isNotEmpty(m)) {
            return m;
        }
        return resourceBundleKey;
    }
}
