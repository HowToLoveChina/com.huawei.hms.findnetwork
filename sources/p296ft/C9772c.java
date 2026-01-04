package p296ft;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ft.c */
/* loaded from: classes8.dex */
public final class C9772c {

    /* renamed from: a */
    public static final Map<String, String> f48057a;

    /* renamed from: b */
    public static final Map<String, String> f48058b;

    static {
        HashMap map = new HashMap();
        map.put("kirin990", "Kirin990");
        map.put("kirin980", "Kirin980");
        map.put("lahaina", "Snapdragon888");
        map.put("kona", "Snapdragon865");
        map.put("lito", "Snapdragon765");
        map.put("mt6873", "Dimensity800");
        map.put("mt6853", "Dimensity720");
        map.put("mt6885", "Dimensity1000p");
        map.put("erd9815_r", "Exynos1080");
        f48057a = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("kirin990", "Kirin990");
        map2.put("kirin980", "Kirin980");
        map2.put("lahaina", "snapdragon888");
        map2.put("kona", "snapdragon865");
        map2.put("lito", "snapdragon765");
        map2.put("mt6873", "tj800");
        map2.put("mt6853", "tj720");
        map2.put("mt6885", "tj1000");
        map2.put("erd9815_r", "exynos1080");
        f48058b = Collections.unmodifiableMap(map2);
    }

    /* renamed from: a */
    public static String m60806a(String str) {
        String str2 = f48058b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    /* renamed from: b */
    public static String m60807b(String str) {
        String str2 = f48057a.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
