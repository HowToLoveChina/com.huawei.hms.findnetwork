package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.ua */
/* loaded from: classes8.dex */
public class C7706ua {

    /* renamed from: a */
    private String f35755a;

    /* renamed from: b */
    private String f35756b;

    /* renamed from: c */
    private String f35757c;

    /* renamed from: d */
    private Integer f35758d;

    /* renamed from: e */
    private String f35759e;

    /* renamed from: f */
    private ContentRecord f35760f;

    public C7706ua() {
    }

    public C7706ua(String str, String str2, String str3, String str4) {
        this.f35755a = str == null ? "" : str;
        this.f35756b = str2 == null ? "" : str2;
        this.f35757c = str3 == null ? "" : str3;
        this.f35759e = str4 == null ? "" : str4;
    }

    /* renamed from: a */
    public String m47341a() {
        return this.f35757c;
    }

    /* renamed from: b */
    public String m47345b() {
        return this.f35755a;
    }

    /* renamed from: c */
    public String m47346c() {
        return this.f35756b;
    }

    /* renamed from: d */
    public String m47347d() {
        return this.f35759e;
    }

    /* renamed from: e */
    public int m47348e() {
        return this.f35758d.intValue();
    }

    /* renamed from: f */
    public ContentRecord m47349f() {
        return this.f35760f;
    }

    /* renamed from: a */
    public void m47342a(int i10) {
        this.f35758d = Integer.valueOf(i10);
    }

    /* renamed from: a */
    public void m47343a(ContentRecord contentRecord) {
        this.f35760f = contentRecord;
    }

    /* renamed from: a */
    public void m47344a(String str) {
        if (str == null) {
            str = "";
        }
        this.f35757c = str;
    }
}
