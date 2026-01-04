package com.huawei.hwcloudjs.p164f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hwcloudjs.p151b.C6617a;

/* renamed from: com.huawei.hwcloudjs.f.f */
/* loaded from: classes8.dex */
public class C6661f {

    /* renamed from: a */
    private static final String f30879a = "NetUtils";

    /* renamed from: b */
    public static final String f30880b = "none";

    /* renamed from: c */
    public static final String f30881c = "unknown";

    /* renamed from: d */
    public static final String f30882d = "2g";

    /* renamed from: e */
    public static final String f30883e = "3g";

    /* renamed from: f */
    public static final String f30884f = "4g";

    /* renamed from: g */
    public static final String f30885g = "wifi";

    /* renamed from: h */
    public static final int f30886h = 16;

    /* renamed from: i */
    public static final int f30887i = 17;

    /* renamed from: j */
    public static final int f30888j = 18;

    /* renamed from: a */
    public static String m37887a() {
        Context contextM37753a = C6617a.m37753a();
        if (!(contextM37753a.getSystemService("connectivity") instanceof ConnectivityManager)) {
            return "none";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) contextM37753a.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return "none";
        }
        if (!"mobile".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
            return f30885g;
        }
        switch (activeNetworkInfo.getSubtype()) {
        }
        return "none";
    }

    /* renamed from: b */
    public static boolean m37888b() {
        return !m37887a().equalsIgnoreCase("none");
    }
}
