package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;

/* renamed from: com.huawei.openalliance.ad.utils.dg */
/* loaded from: classes2.dex */
public class C7814dg {

    /* renamed from: a */
    private static String f36091a;

    /* renamed from: a */
    public static Pair<String, Boolean> m48357a(Context context) {
        String strM47835a = C7776bw.m47835a(context);
        f36091a = strM47835a;
        if (!TextUtils.isEmpty(strM47835a)) {
            return new Pair<>(f36091a, Boolean.FALSE);
        }
        String strM47800a = C7764bk.m47800a(context);
        f36091a = strM47800a;
        if (!TextUtils.isEmpty(strM47800a)) {
            return new Pair<>(f36091a, Boolean.FALSE);
        }
        String strM48376a = C7820dm.m48376a(context);
        f36091a = strM48376a;
        return !TextUtils.isEmpty(strM48376a) ? new Pair<>(f36091a, Boolean.FALSE) : C7743aq.m47599a(context, true);
    }
}
