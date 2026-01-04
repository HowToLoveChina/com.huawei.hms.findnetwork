package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.p172ag.C7037e;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.ax */
/* loaded from: classes8.dex */
public class C6946ax extends AbstractC6912ag {
    public C6946ax() {
        super("pps.download.reserveapp");
    }

    /* renamed from: a */
    private AppDownloadTask m39239a(Context context, AppInfo appInfo, ContentRecord contentRecord) {
        C7560ou c7560ou;
        if (contentRecord != null) {
            c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
            c7560ou.mo46590a(contentRecord);
        } else {
            c7560ou = null;
        }
        AppDownloadTask appDownloadTaskM42269a = new AppDownloadTask.C7040a().m42266a(c7560ou).m42265a(appInfo).m42269a();
        appDownloadTaskM42269a.m42250e(contentRecord.m41464aP());
        appDownloadTaskM42269a.m42261n(contentRecord.m41577k());
        appDownloadTaskM42269a.m42258k(contentRecord.m41585m());
        appDownloadTaskM42269a.m42260m(contentRecord.m41588n());
        return appDownloadTaskM42269a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        C7306i c7306iM38795d = m38795d(context, str);
        if (c7306iM38795d == null || c7306iM38795d.getAppInfo() == null) {
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
            return;
        }
        C7037e.m42187a(context).m42196a(m39239a(context, c7306iM38795d.getAppInfo(), c7306iM38795d.m44977a()));
        m45225b(remoteCallResultCallback, true);
    }
}
