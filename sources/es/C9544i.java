package es;

import android.content.Context;
import android.text.TextUtils;
import as.C1016d;
import java.io.File;
import java.io.IOException;
import p237du.AbstractC9308a;
import p531or.C11991a;

/* renamed from: es.i */
/* loaded from: classes8.dex */
public class C9544i {

    /* renamed from: a */
    public static boolean f47451a = false;

    /* renamed from: a */
    public static String m59592a() {
        try {
            String strM59646a = C9554s.m59646a("ro.product.cpu.abi", "arm64-v8a");
            C1016d.m6186f("LoadSoUtil", "getCpuAbi: " + strM59646a);
            return strM59646a;
        } catch (Exception unused) {
            C1016d.m6186f("LoadSoUtil", "getCpuAbi error");
            return "arm64-v8a";
        }
    }

    /* renamed from: b */
    public static String m59593b(Context context) {
        try {
            String strM59646a = C9554s.m59646a("ro.product.cpu.abi", "arm64-v8a");
            C1016d.m6186f("LoadSoUtil", "getCurrentCpuAbi: " + strM59646a);
            return strM59646a;
        } catch (Exception unused) {
            C1016d.m6186f("LoadSoUtil", "getCurrentCpuAbi error");
            return "arm64-v8a";
        }
    }

    /* renamed from: c */
    public static String m59594c(Context context) {
        try {
            return context.createDeviceProtectedStorageContext().getFilesDir().getCanonicalPath();
        } catch (IOException unused) {
            C1016d.m6183c("LoadSoUtil", "getCanonicalPath is IOException");
            return null;
        }
    }

    /* renamed from: d */
    public static String m59595d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m59594c(C9552q.m59643a() == 200 ? C11991a.m72146b() : C11991a.m72145a()));
        String str = File.separator;
        sb2.append(str);
        sb2.append("kits");
        sb2.append(str);
        sb2.append(C11991a.m72145a().getPackageName());
        sb2.append(str);
        sb2.append(C9536a.m59543c(C11991a.m72145a()));
        sb2.append(str);
        sb2.append("lib");
        return sb2.toString();
    }

    /* renamed from: e */
    public static String m59596e(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".so")) {
            C1016d.m6183c("LoadSoUtil", "so name not valid");
            return "";
        }
        String strM59593b = m59593b(C11991a.m72145a());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m59595d());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(strM59593b);
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: f */
    public static synchronized boolean m59597f(String str) {
        return m59598g(str, "", false);
    }

    /* renamed from: g */
    public static synchronized boolean m59598g(String str, String str2, boolean z10) {
        if (!f47451a) {
            C1016d.m6183c("LoadSoUtil", "init load so fail");
            return false;
        }
        String strM59596e = m59596e(str);
        if (TextUtils.isEmpty(strM59596e)) {
            return false;
        }
        File file = new File(strM59596e);
        if (!file.exists()) {
            C1016d.m6183c("LoadSoUtil", "load Local so error because of so file not exist");
            return false;
        }
        if (z10 && !AbstractC9308a.m58613e(file, str2)) {
            return false;
        }
        System.load(strM59596e);
        return true;
    }

    /* renamed from: h */
    public static boolean m59599h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str2 + File.separator + str);
            if (file.exists() && file.length() > 0) {
                System.load(file.getCanonicalPath());
                return true;
            }
            return false;
        } catch (IOException unused) {
            C1016d.m6181a("LoadSoUtil", "loadSo exception:Invalid file path");
            return false;
        }
    }
}
