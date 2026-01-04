package com.huawei.updatesdk.service.otaupdate;

import android.text.TextUtils;

/* renamed from: com.huawei.updatesdk.service.otaupdate.f */
/* loaded from: classes9.dex */
public class C8871f {

    /* renamed from: d */
    private static C8871f f45252d = new C8871f();

    /* renamed from: a */
    private String f45253a;

    /* renamed from: b */
    private String f45254b;

    /* renamed from: c */
    private String f45255c;

    private C8871f() {
    }

    /* renamed from: e */
    public static C8871f m56464e() {
        return f45252d;
    }

    /* renamed from: a */
    public String m56465a() {
        return !TextUtils.isEmpty(this.f45253a) ? this.f45253a : this.f45254b;
    }

    /* renamed from: b */
    public String m56467b() {
        return this.f45253a;
    }

    /* renamed from: c */
    public String m56469c() {
        return this.f45255c;
    }

    /* renamed from: d */
    public boolean m56471d() {
        String str = this.f45253a;
        if (str != null) {
            return str.equals(this.f45254b);
        }
        return true;
    }

    /* renamed from: a */
    public void m56466a(String str) {
        this.f45254b = str;
    }

    /* renamed from: b */
    public void m56468b(String str) {
        this.f45253a = str;
    }

    /* renamed from: c */
    public void m56470c(String str) {
        this.f45255c = str;
    }
}
