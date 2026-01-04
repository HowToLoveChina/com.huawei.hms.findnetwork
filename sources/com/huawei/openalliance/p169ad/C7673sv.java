package com.huawei.openalliance.p169ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.C7054k;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* renamed from: com.huawei.openalliance.ad.sv */
/* loaded from: classes8.dex */
public class C7673sv extends AbstractC7687ti {

    /* renamed from: c */
    private InterfaceC7615qq f35684c;

    public C7673sv(Context context, ContentRecord contentRecord) {
        super(context, contentRecord);
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
        this.f35684c = c7560ou;
        c7560ou.mo46590a(contentRecord);
    }

    /* renamed from: d */
    private void m47234d() {
        this.f35684c.mo46588a(EventType.INTENTFAIL, (Integer) 3, Integer.valueOf(C7830i.m48419a(this.f35700a, this.f35701b.m41484af().m44430u()) ? 2 : 1));
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        String str;
        ContentRecord contentRecord;
        AbstractC7185ho.m43820b("AppDeepLinkAction", "handle AppDeepLinkAction");
        try {
            contentRecord = this.f35701b;
        } catch (ActivityNotFoundException unused) {
            str = "activity not exist";
            AbstractC7185ho.m43823c("AppDeepLinkAction", str);
            m47234d();
            return m47249b();
        } catch (Exception unused2) {
            str = "handle intent url fail";
            AbstractC7185ho.m43823c("AppDeepLinkAction", str);
            m47234d();
            return m47249b();
        }
        if (contentRecord != null && contentRecord.m41484af() != null) {
            AppInfo appInfoM41484af = this.f35701b.m41484af();
            C7692tn.a aVar = new C7692tn.a();
            aVar.m47275a(appInfoM41484af).m47274a(this.f35701b);
            Intent intentM48426b = C7830i.m48426b(this.f35700a, appInfoM41484af.m44428t(), appInfoM41484af.m44430u(), aVar.m47277a());
            if (intentM48426b == null) {
                AbstractC7185ho.m43823c("AppDeepLinkAction", "cannot find target activity");
                m47234d();
                return m47249b();
            }
            intentM48426b.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            C7692tn.a aVar2 = new C7692tn.a();
            aVar2.m47274a(this.f35701b).m47275a(appInfoM41484af).m47272a(intentM48426b);
            C7830i.m48412a(this.f35700a, intentM48426b, aVar2.m47277a());
            if (!TextUtils.isEmpty(appInfoM41484af.getPackageName())) {
                AppDownloadTask appDownloadTaskM42269a = new AppDownloadTask.C7040a().m42265a(appInfoM41484af).m42266a(this.f35684c).m42269a();
                appDownloadTaskM42269a.m42249d(System.currentTimeMillis());
                C7054k.m42490a(this.f35700a).m42498a(appInfoM41484af.getPackageName(), appDownloadTaskM42269a);
                C7054k.m42490a(this.f35700a).m42497a();
            }
            m47248b(ClickDestination.APPMARKET);
            this.f35684c.mo46588a(EventType.INTENTSUCCESS, (Integer) 3, (Integer) null);
            return true;
        }
        AbstractC7185ho.m43820b("AppDeepLinkAction", "getAppInfo is null");
        return m47249b();
    }
}
