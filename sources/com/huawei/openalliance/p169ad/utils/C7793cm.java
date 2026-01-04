package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.utils.cm */
/* loaded from: classes2.dex */
public class C7793cm {
    /* renamed from: a */
    public static String m48073a(Context context, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return "0";
        }
        String strM41585m = contentRecord.m41585m();
        return AbstractC7806cz.m48165b(strM41585m) ? "0" : C7124fh.m43316b(context).mo43426c(strM41585m);
    }

    /* renamed from: a */
    public static boolean m48074a(Context context, String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return false;
        }
        return !AbstractC7806cz.m48165b(C7124fh.m43316b(context).mo43444d(str));
    }
}
