package com.huawei.updatesdk.p191b.p201h;

import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.b.h.a */
/* loaded from: classes9.dex */
public final class C8833a {

    /* renamed from: d */
    private static final Map<Integer, String> f45176d;

    /* renamed from: e */
    private static C8833a f45177e;

    /* renamed from: a */
    private int f45178a;

    /* renamed from: b */
    private int f45179b = 0;

    /* renamed from: c */
    private String f45180c = "";

    static {
        HashMap map = new HashMap();
        f45176d = map;
        f45177e = new C8833a();
        map.put(1, "1.0");
        map.put(2, "1.5");
        map.put(3, "1.6");
        map.put(4, "2.0");
        map.put(5, "2.0");
        map.put(6, "2.3");
        map.put(7, "3.0");
        map.put(8, "3.0.5");
        map.put(8, "3.1");
        map.put(9, "4.0");
        map.put(10, "4.1");
        map.put(11, "5.0");
        map.put(12, "5.1");
    }

    private C8833a() {
        int iM56304e = m56304e();
        this.f45178a = iM56304e;
        if (iM56304e == 0) {
            this.f45178a = m56303d();
        }
        m56306g();
        m56307h();
        C8774a.m56009b("SystemSupportUtil", "emuiVersion:" + this.f45178a + ", magicApiLevel:" + this.f45179b + ", magicVersion:" + this.f45180c);
    }

    /* renamed from: d */
    private int m56303d() {
        String strM56302a = m56302a(C8789c.m56089a("ro.build.version.emui", ""));
        if (TextUtils.isEmpty(strM56302a)) {
            return 0;
        }
        for (Map.Entry<Integer, String> entry : f45176d.entrySet()) {
            if (strM56302a.equals(entry.getValue())) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    /* renamed from: e */
    private int m56304e() {
        return C8789c.m56086a("ro.build.hw_emui_api_level", 0);
    }

    /* renamed from: f */
    public static C8833a m56305f() {
        return f45177e;
    }

    /* renamed from: g */
    private void m56306g() {
        try {
            Class<?> cls = Class.forName("com.hihonor.android.os.Build$VERSION");
            this.f45179b = cls.getDeclaredField("MAGIC_SDK_INT").getInt(cls);
        } catch (Throwable th2) {
            C8774a.m56010c("SystemSupportUtil", "initMagicApiLevel, error: " + th2.getMessage());
        }
    }

    /* renamed from: h */
    private void m56307h() {
        try {
            Class<?> cls = Class.forName("com.hihonor.android.os.Build");
            String str = (String) cls.getDeclaredField("MAGIC_VERSION").get(cls);
            if (str == null) {
                str = "";
            }
            this.f45180c = str;
        } catch (Throwable th2) {
            C8774a.m56010c("SystemSupportUtil", "initMagicVersion, error: " + th2.getMessage());
        }
    }

    /* renamed from: a */
    public int m56308a() {
        return this.f45178a;
    }

    /* renamed from: b */
    public int m56309b() {
        return this.f45179b;
    }

    /* renamed from: c */
    public String m56310c() {
        return this.f45180c;
    }

    /* renamed from: a */
    private String m56302a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length == 2) {
                return strArrSplit[1];
            }
        }
        return "";
    }
}
