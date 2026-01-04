package com.huawei.secure.android.common.detect;

import p039bu.C1288a;

/* loaded from: classes5.dex */
public class SecurityDetect {

    /* renamed from: a */
    private static final String f40664a = "SecurityDetect";

    public static boolean idj() {
        try {
            return C8684SD.idj();
        } catch (Throwable th2) {
            C1288a.m7641b(f40664a, "idj: " + th2.getMessage());
            return false;
        }
    }

    public static boolean iej() {
        try {
            return C8684SD.iej();
        } catch (Throwable th2) {
            C1288a.m7641b(f40664a, "iej: " + th2.getMessage());
            return false;
        }
    }

    public static boolean irpj() {
        try {
            return C8684SD.irpj();
        } catch (Throwable th2) {
            C1288a.m7641b(f40664a, "irpj: " + th2.getMessage());
            return false;
        }
    }
}
