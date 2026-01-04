package com.huawei.hicloud.bean;

import com.google.gson.Gson;
import com.huawei.openalliance.p169ad.constant.OsType;

/* loaded from: classes6.dex */
public class Device {
    private int androidApiLevel;
    private String deviceType;
    private String emuiVersion;
    private String gaid;
    private String homeCountry;
    private String imei;
    private String lang;
    private String model;
    private String network;
    private String oaid;
    private String osVersion;
    private String plmn;
    private String registerCountry;
    private String romVersion;
    private int screenHeight;
    private int screenWidth;

    /* renamed from: sn */
    private String f22226sn;
    private String udid;
    private String deliveryPlace = "CN";
    private String platform = OsType.ANDROID;

    public int getAndroidApiLevel() {
        return this.androidApiLevel;
    }

    public String getDeliveryPlace() {
        return this.deliveryPlace;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getEmuiVersion() {
        return this.emuiVersion;
    }

    public String getGaid() {
        return this.gaid;
    }

    public String getHomeCountry() {
        return this.homeCountry;
    }

    public String getImei() {
        return this.imei;
    }

    public String getLang() {
        return this.lang;
    }

    public String getModel() {
        return this.model;
    }

    public String getNetwork() {
        return this.network;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPlmn() {
        return this.plmn;
    }

    public String getRegisterCountry() {
        return this.registerCountry;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public String getSn() {
        return this.f22226sn;
    }

    public String getUdid() {
        return this.udid;
    }

    public void setAndroidApiLevel(int i10) {
        this.androidApiLevel = i10;
    }

    public void setDeliveryPlace(String str) {
        this.deliveryPlace = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setEmuiVersion(String str) {
        this.emuiVersion = str;
    }

    public void setGaid(String str) {
        this.gaid = str;
    }

    public void setHomeCountry(String str) {
        this.homeCountry = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setNetwork(String str) {
        this.network = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPlmn(String str) {
        this.plmn = str;
    }

    public void setRegisterCountry(String str) {
        this.registerCountry = str;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public void setScreenHeight(int i10) {
        this.screenHeight = i10;
    }

    public void setScreenWidth(int i10) {
        this.screenWidth = i10;
    }

    public void setSn(String str) {
        this.f22226sn = str;
    }

    public void setUdid(String str) {
        this.udid = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
