package com.huawei.openalliance.p169ad.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.huawei.openalliance.ad.utils.di */
/* loaded from: classes2.dex */
public abstract class AbstractC7816di {
    /* renamed from: a */
    public static String m48360a() {
        return AbstractC7741ao.m47545a("yyyy-MM-dd HH:mm:ss.SSSZ").format(new Date());
    }

    /* renamed from: a */
    public static boolean m48361a(long j10) {
        if (j10 == 0) {
            return false;
        }
        return m48362a("yyyy-MM-dd", j10);
    }

    /* renamed from: a */
    private static boolean m48362a(String str, long j10) {
        Date date = new Date(j10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()));
    }
}
