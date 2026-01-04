package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.download.app.AbstractC7044c;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;

/* renamed from: com.huawei.openalliance.ad.dp */
/* loaded from: classes8.dex */
public class C7072dp extends AbstractC7026do {
    public C7072dp(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m42633a(final AppInfo appInfo, final ContentRecord contentRecord) {
        AbstractC7185ho.m43820b("ConfirmDownloadAlertStrategy", "showConfirmDownloadAlert, context:" + m42022a());
        new C6928i(m42022a()).m39198a(contentRecord);
        AbstractC7044c.m42342a(m42022a(), "11".equals(appInfo.m44440z()), new AbstractC7846y.a() { // from class: com.huawei.openalliance.ad.dp.1
            @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
            /* renamed from: a */
            public void mo42634a() {
                new C6928i(C7072dp.this.m42022a()).m39209b(contentRecord);
                C7072dp.this.m42024a(appInfo);
            }

            @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
            /* renamed from: a */
            public void mo42635a(boolean z10) {
                new C6928i(C7072dp.this.m42022a()).m39214c(contentRecord);
                C7072dp.this.m42026b(appInfo);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7026do
    /* renamed from: a */
    public void mo42025a(AppInfo appInfo, ContentRecord contentRecord, long j10) {
        if (appInfo != null && contentRecord != null) {
            m42633a(appInfo, contentRecord);
        } else {
            AbstractC7185ho.m43820b("ConfirmDownloadAlertStrategy", "appInfo or contentRecord is empty");
            m42026b(appInfo);
        }
    }
}
