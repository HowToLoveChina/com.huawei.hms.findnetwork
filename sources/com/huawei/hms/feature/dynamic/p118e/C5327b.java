package com.huawei.hms.feature.dynamic.p118e;

import android.util.Log;
import dalvik.system.DexClassLoader;

/* renamed from: com.huawei.hms.feature.dynamic.e.b */
/* loaded from: classes8.dex */
public final class C5327b extends DexClassLoader {

    /* renamed from: a */
    public static final String f24709a = "b";

    public C5327b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                Log.w(f24709a, "Cannot find The class:" + str);
            }
        }
        return super.loadClass(str, z10);
    }
}
