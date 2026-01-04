package com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean;

/* loaded from: classes4.dex */
public class ResponseBean extends JsonBean {
    public static final int ERROR = 1;
    public static final int NETWORK_ERROR = 3;

    /* renamed from: OK */
    public static final int f21014OK = 0;
    public static final int PARSE_ERROR = 4;
    public static final int READ_CACHE_ERROR = 6;
    public static final int REQUEST_FAILED = 1;
    public static final int REQUEST_SUCCESS = 0;
    public static final int REQ_PARAM_ERROR = 5;
    public static final int RESPONSE_ERROR = 7;
    public static final int TIMEOUT = 2;

    /* renamed from: a */
    public int f21015a = 1;

    /* renamed from: b */
    public EnumC4573a f21016b = EnumC4573a.NORMAL;

    @InstallerNetTransmission
    private int rtnCode;

    @InstallerNetTransmission
    private String rtnDesc;

    /* renamed from: com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean$a */
    public enum EnumC4573a {
        NORMAL,
        NO_NETWORK,
        JSON_ERROR,
        PARAM_ERROR,
        RESPONSE_EXCEPTION,
        IO_EXCEPTION,
        CONNECT_EXCEPTION,
        UNKNOWN_EXCEPTION
    }

    public EnumC4573a getErrCause() {
        return this.f21016b;
    }

    public int getResponseCode() {
        return this.f21015a;
    }

    public int getRtnCode() {
        return this.rtnCode;
    }

    public String getRtnDesc() {
        return this.rtnDesc;
    }

    public void setErrCause(EnumC4573a enumC4573a) {
        this.f21016b = enumC4573a;
    }

    public void setResponseCode(int i10) {
        this.f21015a = i10;
    }

    public void setRtnCode(int i10) {
        this.rtnCode = i10;
    }

    public void setRtnDesc(String str) {
        this.rtnDesc = str;
    }

    public String toString() {
        return "ResponseBean{responseCode=" + this.f21015a + ", rtnCode=" + this.rtnCode + ", rtnDesc='" + this.rtnDesc + "', errCause=" + this.f21016b + '}';
    }
}
