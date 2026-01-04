package com.huawei.hms.framework.network.grs.p125h;

import com.huawei.hms.framework.common.Logger;

/* renamed from: com.huawei.hms.framework.network.grs.h.e */
/* loaded from: classes8.dex */
public class C5459e {

    /* renamed from: a */
    private static final String f25007a = "e";

    /* renamed from: a */
    public static boolean m32331a(Long l10) {
        if (l10 == null) {
            Logger.m32143v(f25007a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (NumberFormatException unused) {
            Logger.m32143v(f25007a, "isSpExpire spValue NumberFormatException.");
        }
        if (l10.longValue() - System.currentTimeMillis() >= 0) {
            Logger.m32141i(f25007a, "isSpExpire false.");
            return false;
        }
        Logger.m32141i(f25007a, "isSpExpire true.");
        return true;
    }

    /* renamed from: a */
    public static boolean m32332a(Long l10, long j10) {
        if (l10 == null) {
            Logger.m32143v(f25007a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l10.longValue() - (System.currentTimeMillis() + j10) >= 0) {
                Logger.m32143v(f25007a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.m32143v(f25007a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
