package com.huawei.updatesdk.p191b.p195b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;

/* renamed from: com.huawei.updatesdk.b.b.a */
/* loaded from: classes9.dex */
public final class C8807a {

    /* renamed from: e */
    private static final Object f45135e = new Object();

    /* renamed from: f */
    private static volatile C8807a f45136f;

    /* renamed from: a */
    private final C8808b f45137a;

    /* renamed from: b */
    private String f45138b;

    /* renamed from: c */
    private String f45139c;

    /* renamed from: d */
    private boolean f45140d = false;

    private C8807a(Context context) {
        this.f45137a = C8808b.m56219a("DeviceSessionUpdateSDK_V1", context);
    }

    /* renamed from: d */
    public static C8807a m56209d() {
        if (f45136f == null) {
            synchronized (f45135e) {
                try {
                    if (f45136f == null) {
                        f45136f = new C8807a(C8793a.m56132c().m56133a());
                    }
                } finally {
                }
            }
        }
        return f45136f;
    }

    /* renamed from: a */
    public String m56210a() {
        return this.f45138b;
    }

    /* renamed from: b */
    public long m56214b() {
        return this.f45137a.m56220a("updatesdk.lastCheckDate", 0L);
    }

    /* renamed from: c */
    public void m56216c() {
        if (this.f45140d) {
            return;
        }
        m56215b("updatesdk.sign.param");
        m56215b("updatesdk.signkey");
        m56215b("updatesdk.signtime");
        m56215b("updatesdk.lastInitAccountTime" + this.f45139c);
        m56215b("updatesdk.lastAccountZone" + this.f45139c);
        this.f45140d = true;
    }

    /* renamed from: a */
    public String m56211a(String str) {
        return TextUtils.isEmpty(str) ? "" : this.f45137a.m56221a(str, "");
    }

    /* renamed from: b */
    public void m56215b(String str) {
        this.f45137a.m56222a(str);
    }

    /* renamed from: c */
    public void m56217c(String str) {
        this.f45138b = str;
    }

    /* renamed from: d */
    public void m56218d(String str) {
        this.f45139c = str;
    }

    /* renamed from: a */
    public void m56212a(long j10) {
        this.f45137a.m56223b("updatesdk.lastCheckDate", j10);
    }

    /* renamed from: a */
    public void m56213a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f45137a.m56224b(str, str2);
    }
}
