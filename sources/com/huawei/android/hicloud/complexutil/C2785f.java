package com.huawei.android.hicloud.complexutil;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import p514o9.C11839m;
import tc.C13006a;

/* renamed from: com.huawei.android.hicloud.complexutil.f */
/* loaded from: classes3.dex */
public class C2785f {

    /* renamed from: a */
    public static final Map<String, Integer> f12096a = Collections.synchronizedMap(new a(500));

    /* renamed from: com.huawei.android.hicloud.complexutil.f$a */
    public class a extends LinkedHashMap<String, Integer> {
        public a(int i10) {
            super(i10);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
            return size() > 500;
        }
    }

    /* renamed from: a */
    public static void m16205a(String str, String str2, String str3) {
        m16210f();
        f12096a.put(str + "_" + str2 + "_" + str3, 1);
        C13006a.m78193e().m78201i(System.currentTimeMillis());
    }

    /* renamed from: b */
    public static void m16206b() {
        C11839m.m70688i("SyncFileNotFindUtil", "clear all 404 files");
        Map<String, Integer> map = f12096a;
        if (!map.isEmpty()) {
            map.clear();
        }
        C13006a.m78193e().m78194a();
    }

    /* renamed from: c */
    public static void m16207c() {
        long jM78200h = C13006a.m78193e().m78200h();
        if (jM78200h == 0 || System.currentTimeMillis() - jM78200h <= 86400000) {
            return;
        }
        C11839m.m70689w("SyncFileNotFindUtil", "upper 24h, clear 404 files in sp");
        C13006a.m78193e().m78197d();
        C13006a.m78193e().m78196c();
    }

    /* renamed from: d */
    public static Map<String, Integer> m16208d() {
        Map<String, Integer> map = f12096a;
        if (map.isEmpty()) {
            return new LinkedHashMap();
        }
        m16210f();
        return map;
    }

    /* renamed from: e */
    public static boolean m16209e(String str, String str2, String str3) {
        m16210f();
        return f12096a.containsKey(str + "_" + str2 + "_" + str3);
    }

    /* renamed from: f */
    public static void m16210f() {
        try {
            Map<String, Integer> map = f12096a;
            if (map.isEmpty()) {
                m16207c();
                Map<String, Integer> mapM78199g = C13006a.m78193e().m78199g();
                if (mapM78199g.isEmpty()) {
                    return;
                }
                map.putAll(mapM78199g);
                C11839m.m70688i("SyncFileNotFindUtil", "init 404 files to memory, size = " + mapM78199g.size());
            }
        } catch (Exception e10) {
            C11839m.m70687e("SyncFileNotFindUtil", "initNotFindFilesToMemory error " + e10.getMessage());
        }
    }

    /* renamed from: g */
    public static void m16211g() {
        try {
            long jM78198f = C13006a.m78193e().m78198f();
            if (jM78198f == 0 || f12096a.isEmpty()) {
                return;
            }
            C11839m.m70688i("SyncFileNotFindUtil", "memory change, refresh 404 files to sp, memory change time = " + jM78198f);
            C13006a.m78193e().m78196c();
            C13006a.m78193e().m78197d();
            C13006a.m78193e().m78202j(m16208d());
            C13006a.m78193e().m78203k(System.currentTimeMillis());
            C13006a.m78193e().m78195b();
        } catch (Exception e10) {
            C11839m.m70687e("SyncFileNotFindUtil", "refreshSpNotFindFilesByChange error " + e10.getMessage());
        }
    }
}
