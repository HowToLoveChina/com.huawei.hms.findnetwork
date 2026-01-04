package com.huawei.location.ephemeris.net;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.http.response.BaseResponse;

/* loaded from: classes8.dex */
public class EphemerisResponse extends BaseResponse {

    @SerializedName("bdsAlm")
    private String bdsAlm;

    @SerializedName("bdsIon")
    private String bdsIon;

    @SerializedName("bdsNav")
    private String bdsNav;

    @SerializedName("bdsRti")
    private String bdsRti;

    @SerializedName("bdsTim")
    private String bdsTim;

    @SerializedName("galAlm")
    private String galAlm;

    @SerializedName("galNav")
    private String galNav;

    @SerializedName("galRti")
    private String galRti;

    @SerializedName("galTim")
    private String galTim;

    @SerializedName("gloAlm")
    private String gloAlm;

    @SerializedName("gloAux")
    private String gloAux;

    @SerializedName("gloNav")
    private String gloNav;

    @SerializedName("gloRti")
    private String gloRti;

    @SerializedName("gloTim")
    private String gloTim;

    @SerializedName("gpsAlm")
    private String gpsAlm;

    @SerializedName("gpsIon")
    private String gpsIon;

    @SerializedName("gpsNav")
    private String gpsNav;

    @SerializedName("gpsRtc")
    private String gpsRtc;

    @SerializedName("gpsRti")
    private String gpsRti;

    @SerializedName("gpsUtc")
    private String gpsUtc;

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public String getApiCode() {
        return String.valueOf(this.code);
    }

    public String getBdsAlm() {
        return this.bdsAlm;
    }

    public String getBdsIon() {
        return this.bdsIon;
    }

    public String getBdsNav() {
        return this.bdsNav;
    }

    public String getBdsRti() {
        return this.bdsRti;
    }

    public String getBdsTim() {
        return this.bdsTim;
    }

    public String getGalAlm() {
        return this.galAlm;
    }

    public String getGalNav() {
        return this.galNav;
    }

    public String getGalRti() {
        return this.galRti;
    }

    public String getGalTim() {
        return this.galTim;
    }

    public String getGloAlm() {
        return this.gloAlm;
    }

    public String getGloAux() {
        return this.gloAux;
    }

    public String getGloNav() {
        return this.gloNav;
    }

    public String getGloRti() {
        return this.gloRti;
    }

    public String getGloTim() {
        return this.gloTim;
    }

    public String getGpsAlm() {
        return this.gpsAlm;
    }

    public String getGpsIon() {
        return this.gpsIon;
    }

    public String getGpsNav() {
        return this.gpsNav;
    }

    public String getGpsRtc() {
        return this.gpsRtc;
    }

    public String getGpsRti() {
        return this.gpsRti;
    }

    public String getGpsUtc() {
        return this.gpsUtc;
    }

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public boolean isSuccess() {
        return TextUtils.equals(this.code, "0");
    }

    public void setBdsAlm(String str) {
        this.bdsAlm = str;
    }

    public void setBdsIon(String str) {
        this.bdsIon = str;
    }

    public void setBdsNav(String str) {
        this.bdsNav = str;
    }

    public void setBdsRti(String str) {
        this.bdsRti = str;
    }

    public void setBdsTim(String str) {
        this.bdsTim = str;
    }

    public void setGalAlm(String str) {
        this.galAlm = str;
    }

    public void setGalNav(String str) {
        this.galNav = str;
    }

    public void setGalRti(String str) {
        this.galRti = str;
    }

    public void setGalTim(String str) {
        this.galTim = str;
    }

    public void setGloAlm(String str) {
        this.gloAlm = str;
    }

    public void setGloAux(String str) {
        this.gloAux = str;
    }

    public void setGloNav(String str) {
        this.gloNav = str;
    }

    public void setGloRti(String str) {
        this.gloRti = str;
    }

    public void setGloTim(String str) {
        this.gloTim = str;
    }

    public void setGpsAlm(String str) {
        this.gpsAlm = str;
    }

    public void setGpsIon(String str) {
        this.gpsIon = str;
    }

    public void setGpsNav(String str) {
        this.gpsNav = str;
    }

    public void setGpsRtc(String str) {
        this.gpsRtc = str;
    }

    public void setGpsRti(String str) {
        this.gpsRti = str;
    }

    public void setGpsUtc(String str) {
        this.gpsUtc = str;
    }
}
