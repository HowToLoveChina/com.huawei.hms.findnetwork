package p034bc;

import android.content.Context;
import gp.C10028c;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: bc.c */
/* loaded from: classes3.dex */
public class C1163c {

    /* renamed from: a */
    public static boolean f5463a = false;

    /* renamed from: a */
    public static void m7262a(Context context) {
        if (context != null) {
            C10028c c10028cM62183d0 = C10028c.m62183d0(context);
            boolean zM62221H1 = c10028cM62183d0.m62221H1();
            C11839m.m70688i("OOBEHelper", "checkAgreementStatus: " + zM62221H1);
            if (zM62221H1 || f5463a) {
                return;
            }
            C13452e.m80781L().m80885a();
            c10028cM62183d0.m62338i();
        }
    }

    /* renamed from: b */
    public static void m7263b(boolean z10) {
        C11839m.m70688i("OOBEHelper", "setOOBEQuery: " + z10);
        f5463a = z10;
    }
}
