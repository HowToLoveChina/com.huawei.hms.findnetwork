package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.analysis.C6920a;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.download.app.C7055l;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7739am;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.ng */
/* loaded from: classes8.dex */
public class C7512ng {

    /* renamed from: a */
    private Context f34890a;

    /* renamed from: b */
    private ContentRecord f34891b;

    /* renamed from: c */
    private InterfaceC7002cs f34892c;

    /* renamed from: d */
    private AppInfo f34893d;

    /* renamed from: e */
    private int f34894e;

    /* renamed from: f */
    private int f34895f;

    public C7512ng(Context context, ContentRecord contentRecord, int i10) {
        this.f34890a = context;
        this.f34891b = contentRecord;
        this.f34895f = i10;
        m46101a(context);
    }

    /* renamed from: a */
    public void m46104a(int i10) {
        this.f34894e = i10;
    }

    /* renamed from: b */
    public void m46106b(int i10) {
        String packageName = this.f34893d.getPackageName();
        Context context = this.f34890a;
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, this.f34891b.m41552f()));
        c7560ou.mo46590a(this.f34891b);
        C6920a c6920a = new C6920a();
        c6920a.m38872c(AbstractC7806cz.m48153a(Integer.valueOf(i10)));
        c6920a.m38870b(AbstractC7806cz.m48153a(Integer.valueOf(this.f34895f)));
        if (C7739am.m47530b(this.f34890a, packageName)) {
            m46102a(this.f34890a, c6920a);
        } else {
            m46103a(this.f34890a, packageName, c7560ou, c6920a);
        }
    }

    /* renamed from: a */
    private void m46101a(Context context) {
        this.f34892c = new C6922c(context);
        this.f34893d = this.f34891b.m41484af();
    }

    /* renamed from: a */
    private void m46102a(Context context, C6920a c6920a) {
        if (new C7677sz(context, this.f34891b).mo47233a()) {
            this.f34892c.mo39078a(this.f34891b, "1", c6920a);
        }
    }

    /* renamed from: a */
    private void m46103a(Context context, String str, C7560ou c7560ou, C6920a c6920a) {
        C7692tn.a aVar = new C7692tn.a();
        AppInfo appInfo = this.f34893d;
        if (appInfo != null) {
            aVar.m47275a(appInfo);
        }
        aVar.m47274a(this.f34891b).m47279c(str);
        if (C7830i.m48421a(context, str, this.f34893d.getIntentUri(), aVar.m47277a())) {
            C7055l.m42499a(context, this.f34893d);
            c7560ou.mo46588a(EventType.INTENTSUCCESS, (Integer) 1, (Integer) null);
        } else {
            AbstractC7185ho.m43820b("PPSAppActivatePresenter", "handleClick, openAppIntent failed");
            c7560ou.mo46588a(EventType.INTENTFAIL, (Integer) 1, Integer.valueOf(C7830i.m48419a(context, str) ? 2 : 1));
            if (!C7830i.m48420a(context, str, aVar.m47277a())) {
                AbstractC7185ho.m43820b("PPSAppActivatePresenter", "handleClick, openAppMainPage failed");
                return;
            } else {
                c7560ou.mo46595a(Integer.valueOf(this.f34894e));
                C7055l.m42499a(context, this.f34893d);
            }
        }
        this.f34892c.mo39078a(this.f34891b, "1", c6920a);
    }

    /* renamed from: a */
    public void m46105a(String str) {
        C6920a c6920a = new C6920a();
        c6920a.m38870b(AbstractC7806cz.m48153a(Integer.valueOf(this.f34895f)));
        this.f34892c.mo39078a(this.f34891b, str, c6920a);
    }
}
