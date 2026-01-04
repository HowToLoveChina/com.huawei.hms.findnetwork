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

/* renamed from: com.huawei.openalliance.ad.te */
/* loaded from: classes8.dex */
public class C7683te extends AbstractC7687ti {

    /* renamed from: c */
    private int f35694c;

    /* renamed from: d */
    private boolean f35695d;

    /* renamed from: e */
    private String f35696e;

    public C7683te(Context context, ContentRecord contentRecord, Map<String, String> map) {
        super(context, contentRecord);
        this.f35694c = 1;
        this.f35695d = false;
        if (map == null || AbstractC7806cz.m48165b(map.get(AdShowExtras.DOWNLOAD_SOURCE))) {
            return;
        }
        this.f35694c = Integer.parseInt(map.get(AdShowExtras.DOWNLOAD_SOURCE));
    }

    /* renamed from: a */
    private AppDownloadTask m47239a(AppInfo appInfo) {
        C7560ou c7560ou;
        AppDownloadTask appDownloadTaskM42405d = C7046e.m42377h().m42405d(appInfo);
        if (appDownloadTaskM42405d != null) {
            ContentRecord contentRecord = this.f35701b;
            if (contentRecord != null) {
                appDownloadTaskM42405d.m42258k(contentRecord.m41585m());
                appDownloadTaskM42405d.m42259l(this.f35701b.m41433Z());
                appDownloadTaskM42405d.m42260m(this.f35701b.m41588n());
                appDownloadTaskM42405d.m42261n(this.f35701b.m41577k());
            }
            appDownloadTaskM42405d.m42256i(this.f35696e);
        } else {
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
                appDownloadTaskM42405d.m42245a(Integer.valueOf(this.f35694c));
                appDownloadTaskM42405d.m42253f(this.f35695d);
                appDownloadTaskM42405d.m42256i(this.f35696e);
                ContentRecord contentRecord3 = this.f35701b;
                if (contentRecord3 != null) {
                    appDownloadTaskM42405d.m42259l(contentRecord3.m41433Z());
                    appDownloadTaskM42405d.m42258k(this.f35701b.m41585m());
                    appDownloadTaskM42405d.m42260m(this.f35701b.m41588n());
                    appDownloadTaskM42405d.m42261n(this.f35701b.m41577k());
                }
            }
        }
        return appDownloadTaskM42405d;
    }

    /* renamed from: a */
    public void m47240a(int i10) {
        this.f35694c = i10;
    }

    /* renamed from: a */
    public void m47241a(Boolean bool) {
        this.f35695d = bool.booleanValue();
    }

    /* renamed from: a */
    public void m47242a(String str) {
        this.f35696e = str;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        String str;
        AbstractC7185ho.m43820b("OpenMiniPageAction", "handle OpenMiniPageAction");
        ContentRecord contentRecord = this.f35701b;
        if (contentRecord == null || contentRecord.m41484af() == null) {
            str = "getAppInfo is null";
        } else {
            AppInfo appInfoM41484af = this.f35701b.m41484af();
            if (appInfoM41484af == null || !C7830i.m48419a(this.f35700a, appInfoM41484af.getPackageName())) {
                AppDownloadTask appDownloadTaskM47239a = m47239a(appInfoM41484af);
                if (appDownloadTaskM47239a != null) {
                    appDownloadTaskM47239a.m42245a(Integer.valueOf(this.f35694c));
                    appDownloadTaskM47239a.m42247c((Integer) 1);
                    m47248b(ClickDestination.AGMINIMARKET);
                    C7046e.m42377h().mo42403c(appDownloadTaskM47239a);
                    return true;
                }
                str = "downloadTask is null";
            } else {
                str = "app installed";
            }
        }
        AbstractC7185ho.m43820b("OpenMiniPageAction", str);
        return m47249b();
    }
}
