/*
 * Copyright (C) 2021 - Flavio Freitas Pinter
 */

package dev.pinter;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import java.io.Serializable;

public class Config implements Serializable {
    public static final String AUTH_METHOD_NONE = "none";
    public static final String AUTH_SUBJECT_SESSIONVAR = "authenticatedSubjectLoginBean";

    private String authenticationMethod;

    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public boolean isAuthEnabled() {
        return !authenticationMethod.equals(AUTH_METHOD_NONE);
    }

    @PostConstruct
    public void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        authenticationMethod = externalContext.getInitParameter("authenticationMethod");

        if (StringUtils.isBlank(authenticationMethod)) {
            authenticationMethod = AUTH_METHOD_NONE;
        }
    }

}
