package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.p169ad.constant.AdShowExtras;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.lh */
/* loaded from: classes8.dex */
public class C7388lh implements InterfaceC7401lk {
    @Override // com.huawei.openalliance.p169ad.InterfaceC7401lk
    /* renamed from: a */
    public void mo45485a(Context context, Intent intent) {
        StringBuilder sb2;
        String str;
        try {
            AppInfo appInfo = (AppInfo) intent.getSerializableExtra("appInfo");
            ContentRecord contentRecord = (ContentRecord) intent.getSerializableExtra(MapKeyNames.CONTENT_RECORD);
            int intExtra = intent.getIntExtra(AdShowExtras.DOWNLOAD_SOURCE, 1);
            if (appInfo != null && contentRecord != null) {
                if (C7402ll.m45597a(context).m45603c(appInfo.getPackageName())) {
                    mo45484a(context, appInfo, contentRecord, intExtra);
                    C7402ll.m45597a(context).m45602b(appInfo.getPackageName());
                } else {
                    AbstractC7185ho.m43820b("AppNotificationBaseAction", "packageName may be illegal:" + appInfo.getPackageName());
                }
            }
        } catch (IllegalStateException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive IllegalStateException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AppNotificationBaseAction", sb2.toString());
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AppNotificationBaseAction", sb2.toString());
        }
    }

    /* renamed from: a */
    public void mo45484a(Context context, AppInfo appInfo, ContentRecord contentRecord, int i10) {
        AbstractC7185ho.m43820b("AppNotificationBaseAction", "do nothing at base action!");
    }
}
