package p221d9;

import android.content.Context;
import android.os.Bundle;
import mn.InterfaceC11499c;
import p015ak.C0213f;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p709vj.C13452e;

/* renamed from: d9.b */
/* loaded from: classes3.dex */
public class C9054b implements InterfaceC11499c {
    @Override // mn.InterfaceC11499c
    /* renamed from: a */
    public String mo57108a() {
        return "LocalDataScanDailyCallback";
    }

    @Override // mn.InterfaceC11499c
    /* renamed from: b */
    public void mo57109b(Bundle bundle) {
        if (C13452e.m80781L().m80842P0()) {
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                interfaceC9282a.mo58406Z(contextM1377a);
            }
        }
    }
}
