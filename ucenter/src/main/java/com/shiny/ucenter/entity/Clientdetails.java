package com.shiny.ucenter.entity;

public class Clientdetails {
    private String appid;

    private String resourceids;

    private String appsecret;

    private String scope;

    private String granttypes;

    private String redirecturl;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalinformation;

    private String autoapprovescopes;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getResourceids() {
        return resourceids;
    }

    public void setResourceids(String resourceids) {
        this.resourceids = resourceids == null ? null : resourceids.trim();
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret == null ? null : appsecret.trim();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getGranttypes() {
        return granttypes;
    }

    public void setGranttypes(String granttypes) {
        this.granttypes = granttypes == null ? null : granttypes.trim();
    }

    public String getRedirecturl() {
        return redirecturl;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl == null ? null : redirecturl.trim();
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities == null ? null : authorities.trim();
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalinformation() {
        return additionalinformation;
    }

    public void setAdditionalinformation(String additionalinformation) {
        this.additionalinformation = additionalinformation == null ? null : additionalinformation.trim();
    }

    public String getAutoapprovescopes() {
        return autoapprovescopes;
    }

    public void setAutoapprovescopes(String autoapprovescopes) {
        this.autoapprovescopes = autoapprovescopes == null ? null : autoapprovescopes.trim();
    }
}