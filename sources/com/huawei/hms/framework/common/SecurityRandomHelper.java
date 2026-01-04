package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import gu.C10048b;

/* loaded from: classes8.dex */
public class SecurityRandomHelper {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile SecurityRandomHelper instance;

    private SecurityRandomHelper() {
    }

    public static SecurityRandomHelper getInstance() {
        if (instance == null) {
            synchronized (SecurityRandomHelper.class) {
                try {
                    if (instance == null) {
                        C10048b.m62475g(true);
                        instance = new SecurityRandomHelper();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public byte[] generateSecureRandom(int i10) {
        return C10048b.m62472d(i10);
    }

    public String generateSecureRandomStr(int i10) {
        return C10048b.m62473e(i10);
    }
}
