package com.huawei.hms.feature.dynamic.p118e;

import android.util.Log;
import dalvik.system.PathClassLoader;

/* renamed from: com.huawei.hms.feature.dynamic.e.a */
/* loaded from: classes8.dex */
public final class C5326a extends PathClassLoader {

    /* renamed from: a */
    public static final String f24708a = "a";

    public C5326a(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                Log.w(f24708a, "Cannot find The class:" + str);
            }
        }
        return super.loadClass(str, z10);
    }
}
