package com.huawei.updatesdk.p177a.p186b.p188b;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.p177a.p178a.C8774a;

/* renamed from: com.huawei.updatesdk.a.b.b.b */
/* loaded from: classes9.dex */
public final class C8795b {

    /* renamed from: a */
    private Intent f45104a;

    private C8795b(Intent intent) {
        this.f45104a = intent;
    }

    /* renamed from: a */
    public int m56137a(String str, int i10) {
        if (m56144d()) {
            try {
                return this.f45104a.getIntExtra(str, i10);
            } catch (Throwable unused) {
                C8774a.m56008a("SecureIntent", "getIntExtra exception!");
            }
        }
        return i10;
    }

    /* renamed from: b */
    public long m56141b(String str, int i10) {
        if (m56144d()) {
            try {
                return this.f45104a.getLongExtra(str, i10);
            } catch (Throwable unused) {
                C8774a.m56008a("SecureIntent", "getIntExtra exception!");
            }
        }
        return i10;
    }

    /* renamed from: c */
    public Intent m56143c() {
        return this.f45104a;
    }

    /* renamed from: d */
    public boolean m56144d() {
        return this.f45104a != null;
    }

    /* renamed from: a */
    public static C8795b m56136a(Intent intent) {
        return new C8795b(intent);
    }

    /* renamed from: b */
    public Bundle m56142b() {
        if (m56144d()) {
            return this.f45104a.getExtras();
        }
        return null;
    }

    /* renamed from: a */
    public String m56138a() {
        String action;
        return (!m56144d() || (action = this.f45104a.getAction()) == null) ? "" : action;
    }

    /* renamed from: a */
    public String m56139a(String str) {
        if (!m56144d()) {
            return "";
        }
        try {
            return this.f45104a.getStringExtra(str);
        } catch (Throwable unused) {
            C8774a.m56008a("SecureIntent", "getStringExtra exception!");
            return "";
        }
    }

    /* renamed from: a */
    public boolean m56140a(String str, boolean z10) {
        if (m56144d()) {
            try {
                return this.f45104a.getBooleanExtra(str, z10);
            } catch (Throwable unused) {
                C8774a.m56008a("SecureIntent", "getBooleanExtra exception!");
            }
        }
        return z10;
    }
}
