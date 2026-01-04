package com.huawei.secure.android.common.detect;

import p039bu.C1288a;

/* renamed from: com.huawei.secure.android.common.detect.SD */
/* loaded from: classes5.dex */
public final class C8684SD {

    /* renamed from: a */
    private static final String f40663a = "aegissec";

    static {
        try {
            System.loadLibrary(f40663a);
        } catch (UnsatisfiedLinkError unused) {
            C1288a.m7641b("SD", "load so UnsatisfiedLinkError");
        } catch (Throwable th2) {
            C1288a.m7641b("SD", "load so throwable : " + th2.getMessage());
        }
    }

    private C8684SD() {
    }

    public static native boolean idj();

    public static native boolean iej();

    public static native boolean irpj();

    public static native boolean irtj();
}
