package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.download.app.C7047f;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.lg */
/* loaded from: classes8.dex */
public class C7387lg extends C7388lh {
    @Override // com.huawei.openalliance.p169ad.C7388lh
    /* renamed from: a */
    public void mo45484a(Context context, AppInfo appInfo, ContentRecord contentRecord, int i10) {
        new C7047f().m42417a(context, appInfo, new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()), contentRecord), Integer.valueOf(i10), false);
        new C6928i(context).m39216c(contentRecord, "1");
    }
}
