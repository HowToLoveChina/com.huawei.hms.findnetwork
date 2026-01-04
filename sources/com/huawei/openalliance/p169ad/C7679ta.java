package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.download.app.C7055l;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.C7739am;

/* renamed from: com.huawei.openalliance.ad.ta */
/* loaded from: classes8.dex */
public class C7679ta extends AbstractC7687ti {

    /* renamed from: c */
    private InterfaceC7615qq f35688c;

    public C7679ta(Context context, ContentRecord contentRecord) {
        super(context, contentRecord);
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
        this.f35688c = c7560ou;
        c7560ou.mo46590a(contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        try {
            AbstractC7185ho.m43820b("HarmonyServiceAction", "handle harmony service action");
            AppInfo appInfoM41484af = this.f35701b.m41484af();
            if (appInfoM41484af == null || TextUtils.isEmpty(appInfoM41484af.getPackageName()) || TextUtils.isEmpty(appInfoM41484af.m44340A())) {
                AbstractC7185ho.m43820b("HarmonyServiceAction", "parameters occur error");
            } else {
                String packageName = appInfoM41484af.getPackageName();
                if (C7739am.m47528a(this.f35700a, packageName, appInfoM41484af.m44340A())) {
                    m47248b(ClickDestination.HARMONY_SERVICE);
                    C7055l.m42499a(this.f35700a, this.f35701b.m41484af());
                    this.f35688c.mo46588a(EventType.INTENTSUCCESS, (Integer) 1, (Integer) null);
                    return true;
                }
                this.f35688c.mo46588a(EventType.INTENTFAIL, (Integer) 1, Integer.valueOf(C7739am.m47526a(this.f35700a, packageName) ? 2 : 1));
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("HarmonyServiceAction", "handle uri exception: %s", th2.getClass().getSimpleName());
        }
        return m47249b();
    }
}
