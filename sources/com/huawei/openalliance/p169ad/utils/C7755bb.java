package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.download.app.AlertDialogC7042a;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;

/* renamed from: com.huawei.openalliance.ad.utils.bb */
/* loaded from: classes2.dex */
public class C7755bb {
    /* renamed from: a */
    public static boolean m47705a(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            String strM41427W = appDownloadTask.m42223C().mo46574a().m41427W();
            int iM46455C = AbstractC7558os.m46455C(strM41427W);
            boolean zM46469h = AbstractC7558os.m46469h(strM41427W);
            int iM48347w = AbstractC7811dd.m48347w(context);
            boolean zM48346v = AbstractC7811dd.m48346v(context);
            if ((iM46455C <= 3 || zM46469h) && AlertDialogC7042a.m42271a(iM46455C, iM48347w, zM48346v) > 0) {
                return true;
            }
        }
        return false;
    }
}
