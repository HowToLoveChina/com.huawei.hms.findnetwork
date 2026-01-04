package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.utils.ad */
/* loaded from: classes2.dex */
public class C7730ad {

    /* renamed from: a */
    private static long f35801a;

    /* renamed from: b */
    private static long f35802b;

    /* renamed from: a */
    public static boolean m47434a() {
        if (Math.abs(System.currentTimeMillis() - f35801a) < 500 || Math.abs(System.currentTimeMillis() - f35802b) < 1500) {
            return true;
        }
        f35801a = System.currentTimeMillis();
        return false;
    }

    /* renamed from: b */
    public static void m47436b() {
        f35802b = System.currentTimeMillis();
    }

    /* renamed from: a */
    public static boolean m47435a(List<FeedbackInfo> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return false;
        }
        for (FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && feedbackInfo.m44468b()) {
                return true;
            }
        }
        return false;
    }
}
