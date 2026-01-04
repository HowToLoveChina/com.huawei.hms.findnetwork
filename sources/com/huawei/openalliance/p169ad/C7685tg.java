package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.AdShowExtras;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.tg */
/* loaded from: classes8.dex */
public class C7685tg extends AbstractC7687ti {

    /* renamed from: c */
    private int f35697c;

    /* renamed from: d */
    private int f35698d;

    public C7685tg(Context context, ContentRecord contentRecord, Map<String, String> map) {
        super(context, contentRecord);
        this.f35697c = 1;
        this.f35698d = 1;
        if (map == null || AbstractC7806cz.m48165b(map.get(AdShowExtras.DOWNLOAD_SOURCE))) {
            return;
        }
        this.f35697c = Integer.parseInt(map.get(AdShowExtras.DOWNLOAD_SOURCE));
    }

    /* renamed from: a */
    private AppDownloadTask m47244a(AppInfo appInfo) {
        ContentRecord contentRecord;
        C7560ou c7560ou;
        AppDownloadTask appDownloadTaskM42405d = C7046e.m42377h().m42405d(appInfo);
        if (appDownloadTaskM42405d == null) {
            ContentRecord contentRecord2 = this.f35701b;
            if (contentRecord2 != null) {
                Context context = this.f35700a;
                c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord2.m41552f()));
                c7560ou.mo46590a(this.f35701b);
            } else {
                c7560ou = null;
            }
            appDownloadTaskM42405d = new AppDownloadTask.C7040a().m42265a(appInfo).m42266a(c7560ou).m42269a();
            if (appDownloadTaskM42405d != null) {
                appDownloadTaskM42405d.m42245a(Integer.valueOf(this.f35697c));
                appDownloadTaskM42405d.m42247c(Integer.valueOf(this.f35698d));
            }
        }
        if (appDownloadTaskM42405d != null && (contentRecord = this.f35701b) != null) {
            appDownloadTaskM42405d.m42258k(contentRecord.m41585m());
            appDownloadTaskM42405d.m42259l(this.f35701b.m41433Z());
            appDownloadTaskM42405d.m42260m(this.f35701b.m41588n());
            appDownloadTaskM42405d.m42261n(this.f35701b.m41577k());
        }
        return appDownloadTaskM42405d;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        AbstractC7185ho.m43820b("SpecifiedAgdDownloadAction", "handle SpecifiedAgdDownloadAction");
        ContentRecord contentRecord = this.f35701b;
        if (contentRecord == null || contentRecord.m41484af() == null) {
            AbstractC7185ho.m43820b("SpecifiedAgdDownloadAction", "getAppInfo is null");
            return m47249b();
        }
        AppInfo appInfoM41484af = this.f35701b.m41484af();
        if (appInfoM41484af != null && C7830i.m48419a(this.f35700a, appInfoM41484af.getPackageName())) {
            AbstractC7185ho.m43820b("SpecifiedAgdDownloadAction", "app installed");
            return m47249b();
        }
        AppDownloadTask appDownloadTaskM47244a = m47244a(appInfoM41484af);
        if (appDownloadTaskM47244a == null) {
            AbstractC7185ho.m43820b("SpecifiedAgdDownloadAction", "downloadTask is null");
            return m47249b();
        }
        appDownloadTaskM47244a.m42245a(Integer.valueOf(this.f35697c));
        m47248b(ClickDestination.APPMARKET);
        C7046e.m42377h().mo42403c(appDownloadTaskM47244a);
        return true;
    }
}
