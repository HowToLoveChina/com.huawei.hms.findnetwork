package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.download.app.AbstractC7044c;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;

/* renamed from: com.huawei.openalliance.ad.dq */
/* loaded from: classes8.dex */
public class C7073dq extends AbstractC7026do {
    public C7073dq(Context context) {
        super(context);
    }

    /* renamed from: b */
    private void m42636b(final AppInfo appInfo, final ContentRecord contentRecord, long j10) {
        new C6928i(m42022a()).m39200a(contentRecord, "2");
        AbstractC7044c.m42340a(m42022a(), j10, new AbstractC7846y.a() { // from class: com.huawei.openalliance.ad.dq.1
            @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
            /* renamed from: a */
            public void mo42634a() {
                new C6928i(C7073dq.this.m42022a()).m39211b(contentRecord, "1");
                C7073dq.this.m42024a(appInfo);
            }

            @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
            /* renamed from: a */
            public void mo42635a(boolean z10) {
                ContentRecord contentRecord2;
                String str;
                C6928i c6928i = new C6928i(C7073dq.this.m42022a());
                if (z10) {
                    C7073dq.this.m42027c(appInfo);
                    contentRecord2 = contentRecord;
                    str = "2";
                } else {
                    C7073dq.this.m42026b(appInfo);
                    contentRecord2 = contentRecord;
                    str = "3";
                }
                c6928i.m39211b(contentRecord2, str);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7026do
    /* renamed from: a */
    public void mo42025a(AppInfo appInfo, ContentRecord contentRecord, long j10) {
        if (appInfo != null && contentRecord != null) {
            m42636b(appInfo, contentRecord, j10);
        } else {
            AbstractC7185ho.m43820b("TrafficReminder", "appInfo or contentRecord is empty");
            m42026b(appInfo);
        }
    }
}
