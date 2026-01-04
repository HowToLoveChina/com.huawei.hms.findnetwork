package com.huawei.openalliance.p169ad.download.app;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.download.app.f */
/* loaded from: classes2.dex */
public class C7047f {
    /* renamed from: a */
    public boolean m42417a(Context context, AppInfo appInfo, InterfaceC7615qq interfaceC7615qq, Integer num, boolean z10) {
        if (context == null || appInfo == null || interfaceC7615qq == null) {
            AbstractC7185ho.m43820b("AppLauncher", "parameters occur error");
            return false;
        }
        String packageName = appInfo.getPackageName();
        C7692tn.a aVar = new C7692tn.a();
        aVar.m47274a(interfaceC7615qq.mo46574a()).m47275a(appInfo);
        boolean zM48421a = C7830i.m48421a(context, packageName, appInfo.getIntentUri(), aVar.m47277a());
        MaterialClickInfo materialClickInfo = new MaterialClickInfo();
        materialClickInfo.m44515f(1);
        C7587b.a aVar2 = new C7587b.a();
        aVar2.m46920b("app").m46914a(materialClickInfo).m46915a(num);
        if (zM48421a) {
            C7055l.m42499a(context, appInfo);
            interfaceC7615qq.mo46588a(EventType.INTENTSUCCESS, (Integer) 1, (Integer) null);
            if (z10) {
                interfaceC7615qq.mo46594a(aVar2.m46918a());
            }
            return true;
        }
        AbstractC7185ho.m43820b("AppLauncher", "handClick, openAppIntent fail");
        interfaceC7615qq.mo46588a(EventType.INTENTFAIL, (Integer) 1, Integer.valueOf(C7830i.m48419a(context, packageName) ? 2 : 1));
        if (!C7830i.m48420a(context, packageName, aVar.m47277a())) {
            AbstractC7185ho.m43820b("AppLauncher", "handClick, openAppMainPage fail");
            return false;
        }
        interfaceC7615qq.mo46595a(num);
        C7055l.m42499a(context, appInfo);
        if (z10) {
            interfaceC7615qq.mo46594a(aVar2.m46918a());
        }
        return true;
    }
}
