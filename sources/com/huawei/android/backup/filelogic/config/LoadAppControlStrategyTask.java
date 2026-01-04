package com.huawei.android.backup.filelogic.config;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.C2157a;
import p029b5.C1110c;
import p029b5.C1111d;
import p029b5.C1114g;
import p832z4.C14127a;

/* loaded from: classes.dex */
public class LoadAppControlStrategyTask extends LoadConfigTask implements Runnable {
    public LoadAppControlStrategyTask(Context context) {
        super(context);
    }

    /* renamed from: c */
    public final void m12604c(C1110c.a aVar) {
        C2111d.m12653i("LoadAppControlStrategyTask", "addGmsAppToBlockList start");
        for (C1114g.b bVar : aVar.f5289d.f5307a) {
            C1111d.b bVar2 = new C1111d.b();
            bVar2.f5295a = bVar.f5308a;
            bVar2.f5296b = bVar.f5309b;
            aVar.f5286a.f5294a.add(bVar2);
        }
    }

    /* renamed from: d */
    public final void m12605d(C1110c.a aVar) {
        if (!C2157a.m13173H(this.f9525a)) {
            C2111d.m12653i("LoadAppControlStrategyTask", "gms is not install, need to add gmsApp to blockList.");
            m12604c(aVar);
        }
        C14127a.m84764d().m84771h(aVar.f5286a);
        C14127a.m84764d().m84774k(aVar.f5287b);
        C14127a.m84764d().m84772i(aVar.f5288c);
        C14127a.m84764d().m84773j(aVar.f5289d);
        C14127a.m84764d().m84776m(aVar.f5290e);
        C14127a.m84764d().m84775l(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9525a == null) {
            C2111d.m12648d("LoadAppControlStrategyTask", "context is null.");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C2111d.m12653i("LoadAppControlStrategyTask", "begin parse param.");
        C1110c c1110c = new C1110c();
        boolean zM12606a = m12606a(c1110c, null, "configParam/control_strategy.xml");
        Object objMo6616h = c1110c.mo6616h();
        if (zM12606a && (objMo6616h instanceof C1110c.a)) {
            m12605d((C1110c.a) objMo6616h);
        }
        C2111d.m12654j("LoadAppControlStrategyTask", "end parse param, result is:", Boolean.valueOf(zM12606a), ", cost time: ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
