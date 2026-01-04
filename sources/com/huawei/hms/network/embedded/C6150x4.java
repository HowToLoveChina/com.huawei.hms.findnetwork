package com.huawei.hms.network.embedded;

import android.text.TextUtils;

/* renamed from: com.huawei.hms.network.embedded.x4 */
/* loaded from: classes8.dex */
public class C6150x4 implements InterfaceC6163y4 {

    /* renamed from: a */
    public int f28918a;

    /* renamed from: b */
    public int f28919b;

    /* renamed from: c */
    public long f28920c;

    /* renamed from: d */
    public long f28921d;

    /* renamed from: e */
    public String f28922e;

    public C6150x4() {
        this.f28922e = "unknown";
        this.f28918a = -1;
        this.f28921d = System.currentTimeMillis();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6163y4
    /* renamed from: a */
    public String mo35772a() {
        return this.f28922e;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6163y4
    /* renamed from: b */
    public long mo35776b() {
        return this.f28921d;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6163y4
    /* renamed from: c */
    public int mo35778c() {
        return this.f28919b;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6163y4
    /* renamed from: d */
    public int mo35779d() {
        return this.f28918a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6163y4
    /* renamed from: e */
    public long mo35780e() {
        return this.f28920c;
    }

    public String toString() {
        return "DetectImpl{detectType=" + this.f28918a + ", statusCode=" + this.f28919b + ", totalTime=" + this.f28920c + ", detectStartTime=" + this.f28921d + ", domain=" + this.f28922e + '}';
    }

    public C6150x4(int i10) {
        this.f28922e = "unknown";
        this.f28918a = i10;
        this.f28921d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m35773a(int i10) {
        this.f28918a = i10;
    }

    /* renamed from: b */
    public void m35777b(int i10) {
        this.f28919b = i10;
    }

    /* renamed from: a */
    public void m35774a(long j10) {
        this.f28920c = j10;
    }

    /* renamed from: a */
    public void m35775a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28922e = str;
    }
}
