package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes2.dex */
public class AppParams {

    @SerializedName("country")
    private String country;

    @SerializedName("deviceModel")
    private String deviceModel;

    @SerializedName(JsbMapKeyNames.H5_DEVICE_TYPE)
    private int deviceType;

    @SerializedName(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL)
    private String lang;

    @SerializedName("networkingMode")
    private String networkingMode;

    @SerializedName("osName")
    private String osName;

    @SerializedName(FaqConstants.FAQ_OSVERSION)
    private String osVersion;

    @SerializedName(FaqConstants.FAQ_ROMVERSION)
    private String romVersion;

    @SerializedName(ParamConstants.Param.SDK_VERSION)
    private String sdkVersion;

    public String getCountry() {
        return this.country;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getLang() {
        return this.lang;
    }

    public String getNetworkingMode() {
        return this.networkingMode;
    }

    public String getOsName() {
        return this.osName;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setNetworkingMode(String str) {
        this.networkingMode = str;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }
}
