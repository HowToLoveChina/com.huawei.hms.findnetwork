package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;

/* renamed from: com.huawei.openalliance.ad.utils.dn */
/* loaded from: classes2.dex */
public class C7821dn {

    /* renamed from: a */
    private static final String f36094a = "dn";

    /* renamed from: a */
    public static boolean m48377a(Context context, String str, long j10) {
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43823c(f36094a, "file path is empty");
            return false;
        }
        File fileM47453b = AbstractC7731ae.m47453b(context, str, Constants.NORMAL_CACHE);
        if ((fileM47453b == null || !AbstractC7731ae.m47457b(fileM47453b, j10)) && (fileM47453b = AbstractC7731ae.m47453b(context, str, Constants.TPLATE_CACHE)) == null) {
            return false;
        }
        return AbstractC7731ae.m47457b(fileM47453b, j10);
    }

    /* renamed from: a */
    public static boolean m48378a(Context context, String str, String str2) {
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43823c(f36094a, "file path is empty");
            return false;
        }
        File fileM47453b = AbstractC7731ae.m47453b(context, str, Constants.NORMAL_CACHE);
        if ((fileM47453b == null || !AbstractC7731ae.m47464d(fileM47453b)) && (fileM47453b = AbstractC7731ae.m47453b(context, str, Constants.TPLATE_CACHE)) == null) {
            return false;
        }
        return AbstractC7731ae.m47452a(str2, fileM47453b);
    }
}
