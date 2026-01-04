package com.huawei.cloud.base.util;

import android.util.Log;
import com.huawei.hms.drive.C5171ad;

/* renamed from: com.huawei.cloud.base.util.r */
/* loaded from: classes.dex */
public class C4650r {

    /* renamed from: b */
    public static int f21333b = 4;

    /* renamed from: a */
    public String f21334a;

    public C4650r(String str) {
        this.f21334a = m28484e(str);
    }

    /* renamed from: a */
    public static String m28483a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: e */
    public static String m28484e(String str) {
        return String.format("[%s]%s.%s", "5.2.0", "DriveSDK", str);
    }

    /* renamed from: f */
    public static C4650r m28485f(String str) {
        return new C4650r(str);
    }

    /* renamed from: i */
    public static void m28486i(int i10) {
        f21333b = i10;
    }

    /* renamed from: b */
    public void m28487b(String str) {
        if (m28491h(3)) {
            Log.d(this.f21334a, m28483a(C4633d0.m28405b(str)));
        }
    }

    /* renamed from: c */
    public void m28488c(String str, boolean z10) {
        if (m28491h(3)) {
            C5171ad.m30799a(this.f21334a, m28483a(C4633d0.m28405b(str)), false);
        }
    }

    /* renamed from: d */
    public void m28489d(String str) {
        if (m28491h(6)) {
            Log.e(this.f21334a, m28483a(str));
        }
    }

    /* renamed from: g */
    public void m28490g(String str) {
        if (m28491h(4)) {
            Log.i(this.f21334a, m28483a(str));
        }
    }

    /* renamed from: h */
    public final boolean m28491h(int i10) {
        int i11 = f21333b;
        return i10 >= i11 && i11 != 7;
    }

    /* renamed from: j */
    public void m28492j(String str) {
        if (m28491h(5)) {
            Log.w(this.f21334a, m28483a(str));
        }
    }
}
