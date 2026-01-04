package com.huawei.hms.network.file.core;

import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.hms.network.file.core.util.FLogger;

/* renamed from: com.huawei.hms.network.file.core.b */
/* loaded from: classes8.dex */
public class C6224b {

    /* renamed from: a */
    private static final a f29377a = new a("file_manager|filemanager_slice_threshold", Integer.valueOf(C5976k.e.f27211b), new Pair(1024, 1073741824));

    /* renamed from: b */
    private static final a f29378b = new a("file_manager|filemanager_slice_num", 2, new Pair(0, 11));

    /* renamed from: c */
    private static final a f29379c;

    /* renamed from: com.huawei.hms.network.file.core.b$a */
    public static class a<T> {

        /* renamed from: a */
        String f29380a;

        /* renamed from: b */
        T f29381b;

        /* renamed from: c */
        Pair<Integer, Integer> f29382c;

        public a(String str, T t10, Pair<Integer, Integer> pair) {
            this.f29380a = str;
            this.f29381b = t10;
            this.f29382c = pair;
        }
    }

    static {
        new a("file_manager|filemanager_auto_slice", Boolean.FALSE, new Pair(0, 0));
        f29379c = new a("file_manager|filemanager_executor_num", -100, new Pair(0, 101));
    }

    /* renamed from: a */
    public static String m36177a() {
        return m36178a("file_manager|ABTest_dyFrag_groupid");
    }

    /* renamed from: b */
    public static int m36181b() {
        Object objM36183b = m36183b(f29378b.f29380a);
        if (objM36183b == null) {
            return 0;
        }
        if (objM36183b instanceof String) {
            try {
                return Integer.parseInt((String) objM36183b);
            } catch (NumberFormatException unused) {
                FLogger.m36355w("DynamicConfigManager", "getNumericalConfigValue NumberFormatException", new Object[0]);
                return 0;
            }
        }
        if (objM36183b instanceof Integer) {
            return ((Integer) objM36183b).intValue();
        }
        return 0;
    }

    /* renamed from: c */
    public static int m36184c() {
        return ((Integer) m36182b(f29379c)).intValue();
    }

    /* renamed from: d */
    public static int m36185d() {
        return ((Integer) m36182b(f29378b)).intValue();
    }

    /* renamed from: e */
    public static int m36186e() {
        return ((Integer) m36182b(f29377a)).intValue();
    }

    /* renamed from: a */
    public static String m36178a(String str) {
        Object objM36183b;
        return (TextUtils.isEmpty(str) || (objM36183b = m36183b(str)) == null || !(objM36183b instanceof String)) ? "" : (String) objM36183b;
    }

    /* renamed from: b */
    private static Object m36182b(a aVar) throws NumberFormatException {
        if (aVar == null) {
            return null;
        }
        T t10 = aVar.f29381b;
        Object objM36183b = m36183b(aVar.f29380a);
        if (objM36183b == null || !(objM36183b instanceof String)) {
            return t10;
        }
        if (aVar.f29382c == null) {
            return objM36183b;
        }
        try {
            int i10 = Integer.parseInt((String) objM36183b);
            return (i10 <= ((Integer) aVar.f29382c.first).intValue() || i10 >= ((Integer) aVar.f29382c.second).intValue()) ? t10 : Integer.valueOf(i10);
        } catch (NumberFormatException unused) {
            FLogger.m36355w("DynamicConfigManager", "getNumericalConfigValue NumberFormatException", new Object[0]);
            return t10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static boolean m36179a(a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean zBooleanValue = ((Boolean) aVar.f29381b).booleanValue();
        Object objM36183b = m36183b(aVar.f29380a);
        return (objM36183b == null || !(objM36183b instanceof String)) ? zBooleanValue : Boolean.parseBoolean((String) objM36183b);
    }

    /* renamed from: b */
    private static Object m36183b(String str) {
        return NetworkKit.getInstance().getOption(str);
    }

    /* renamed from: a */
    public static boolean m36180a(String str, boolean z10) {
        return m36179a(new a(str, Boolean.valueOf(z10), new Pair(0, 0)));
    }
}
