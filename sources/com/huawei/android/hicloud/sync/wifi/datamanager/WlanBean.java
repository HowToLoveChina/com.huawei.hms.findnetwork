package com.huawei.android.hicloud.sync.wifi.datamanager;

import com.google.gson.Gson;

/* loaded from: classes3.dex */
public class WlanBean {
    private String dns1;
    private String dns2;
    private String exclusionList;
    private String gateway;
    private String hiddenSSID;
    private String host;

    /* renamed from: ip */
    private String f13029ip;
    private String keyMgmt;
    private String networkPrefixLength;
    private String port;
    private String psk;
    private String ssid;
    private String wepKey;

    public String getDns1() {
        return this.dns1;
    }

    public String getDns2() {
        return this.dns2;
    }

    public String getExclusionList() {
        return this.exclusionList;
    }

    public String getGateway() {
        return this.gateway;
    }

    public String getHiddenSSID() {
        return this.hiddenSSID;
    }

    public String getHost() {
        return this.host;
    }

    public String getIp() {
        return this.f13029ip;
    }

    public String getKeyMgmt() {
        return this.keyMgmt;
    }

    public String getNetworkPrefixLength() {
        return this.networkPrefixLength;
    }

    public String getPort() {
        return this.port;
    }

    public String getPsk() {
        return this.psk;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getWepKey() {
        return this.wepKey;
    }

    public void setDns1(String str) {
        this.dns1 = str;
    }

    public void setDns2(String str) {
        this.dns2 = str;
    }

    public void setExclusionList(String str) {
        this.exclusionList = str;
    }

    public void setGateway(String str) {
        this.gateway = str;
    }

    public void setHiddenSSID(String str) {
        this.hiddenSSID = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setIp(String str) {
        this.f13029ip = str;
    }

    public void setKeyMgmt(String str) {
        this.keyMgmt = str;
    }

    public void setNetworkPrefixLength(String str) {
        this.networkPrefixLength = str;
    }

    public void setPort(String str) {
        this.port = str;
    }

    public void setPsk(String str) {
        this.psk = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setWepKey(String str) {
        this.wepKey = str;
    }

    public String toString() {
        WlanBean wlanBean = new WlanBean();
        wlanBean.setSsid(this.ssid);
        wlanBean.setPsk(this.psk);
        wlanBean.setWepKey(this.wepKey);
        wlanBean.setKeyMgmt(this.keyMgmt);
        wlanBean.setHiddenSSID(this.hiddenSSID);
        wlanBean.setHost(this.host);
        wlanBean.setPort(this.port);
        wlanBean.setExclusionList(this.exclusionList);
        return new Gson().toJson(wlanBean);
    }
}
