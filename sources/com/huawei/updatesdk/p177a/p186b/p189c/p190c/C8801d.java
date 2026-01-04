package com.huawei.updatesdk.p177a.p186b.p189c.p190c;

import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;

/* renamed from: com.huawei.updatesdk.a.b.c.c.d */
/* loaded from: classes9.dex */
public class C8801d extends AbstractC8799b {
    public static final int ERROR = 1;
    public static final int NETWORK_ERROR = 3;

    /* renamed from: OK */
    public static final int f45112OK = 0;
    public static final int PROGUARD_ERROR = 6;
    public static final int REQ_PARAM_ERROR = 5;
    public static final int RTN_CODE_OK = 0;
    public static final int TIMEOUT = 2;
    private String reason;
    private int responseCode = 1;

    @SDKNetTransmission
    private int rtnCode = 0;
    private a errCause = a.NORMAL;
    private int httpRespondeCode = 0;

    /* renamed from: com.huawei.updatesdk.a.b.c.c.d$a */
    public enum a {
        NORMAL,
        NO_NETWORK,
        JSON_ERROR,
        PARAM_ERROR,
        IO_EXCEPTION,
        CONNECT_EXCEPTION,
        UNKNOWN_EXCEPTION,
        NO_PROGUARD
    }

    /* renamed from: a */
    public a m56175a() {
        return this.errCause;
    }

    /* renamed from: b */
    public int m56179b() {
        return this.httpRespondeCode;
    }

    /* renamed from: c */
    public String m56181c() {
        return this.reason;
    }

    /* renamed from: d */
    public int m56182d() {
        return this.responseCode;
    }

    /* renamed from: e */
    public boolean m56183e() {
        return m56182d() == 0 && this.rtnCode == 0;
    }

    public String toString() {
        return " {responseCode: " + m56182d() + ",rtnCode_: " + this.rtnCode + ",errCause: " + m56175a() + "}";
    }

    /* renamed from: a */
    public void m56176a(int i10) {
        this.httpRespondeCode = i10;
    }

    /* renamed from: b */
    public void m56180b(int i10) {
        this.responseCode = i10;
    }

    /* renamed from: a */
    public void m56177a(a aVar) {
        this.errCause = aVar;
    }

    /* renamed from: a */
    public void m56178a(String str) {
        this.reason = str;
    }
}
