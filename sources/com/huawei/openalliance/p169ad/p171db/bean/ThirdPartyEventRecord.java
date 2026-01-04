package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;

@DataKeep
/* loaded from: classes2.dex */
public class ThirdPartyEventRecord extends C7013a {
    public static final String AD_TYPE = "adType";
    public static final String LAST_REPORT_TIME = "lastReportTime";
    public static final String LOCK_TIME = "lockTime";
    public static final String REQUEST_ID = "requestId";
    public static final String TIME = "time";

    @InterfaceC6933e
    private String _id;
    private int adType;
    private String contentId;
    private String eventType;
    private long lastReportTime;
    private long lockTime;
    private String requestId;
    private int requestType;
    private String slotId;
    private long startShowTime;
    private long time;
    private EncryptionField<String> url;

    public ThirdPartyEventRecord() {
        this.lockTime = 0L;
        this.requestType = 0;
        this.startShowTime = -111111L;
    }

    /* renamed from: a */
    public String m41829a() {
        return this._id;
    }

    /* renamed from: b */
    public EncryptionField<String> m41833b() {
        return this.url;
    }

    /* renamed from: c */
    public int m41837c() {
        return this.adType;
    }

    /* renamed from: d */
    public String m41839d() {
        return this.requestId;
    }

    /* renamed from: e */
    public String m41841e() {
        return this.slotId;
    }

    /* renamed from: f */
    public String m41843f() {
        return this.contentId;
    }

    /* renamed from: g */
    public String m41844g() {
        return this.eventType;
    }

    /* renamed from: h */
    public int m41845h() {
        return this.requestType;
    }

    /* renamed from: i */
    public long m41846i() {
        return this.startShowTime;
    }

    public ThirdPartyEventRecord(int i10, String str, String str2) {
        this();
        this.adType = i10;
        m41832a(str);
        m41836b(str2);
        this.time = System.currentTimeMillis();
        this.lastReportTime = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m41830a(int i10) {
        this.adType = i10;
    }

    /* renamed from: b */
    public void m41834b(int i10) {
        this.requestType = i10;
    }

    /* renamed from: c */
    public void m41838c(String str) {
        this.slotId = str;
    }

    /* renamed from: d */
    public void m41840d(String str) {
        this.contentId = str;
    }

    /* renamed from: e */
    public void m41842e(String str) {
        this.eventType = str;
    }

    /* renamed from: a */
    public void m41831a(long j10) {
        this.lockTime = j10;
    }

    /* renamed from: b */
    public void m41835b(long j10) {
        this.startShowTime = j10;
    }

    /* renamed from: a */
    public final void m41832a(String str) {
        if (this.url == null) {
            this.url = new EncryptionField<>(String.class);
        }
        this.url.m41655a((EncryptionField<String>) str);
    }

    /* renamed from: b */
    public final void m41836b(String str) {
        this.requestId = str;
    }
}
