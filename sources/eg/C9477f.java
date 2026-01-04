package eg;

import android.os.Handler;
import android.os.Message;
import p015ak.C0213f;
import p520of.C11852b;
import p520of.C11853c;
import p575qe.C12347f;
import pg.AbstractC12139d;

/* renamed from: eg.f */
/* loaded from: classes4.dex */
public class C9477f extends AbstractC9478g {

    /* renamed from: a */
    public Handler f47248a;

    public C9477f(Handler handler) {
        this.f47248a = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        boolean zM70971f = C11853c.m70968g().m70971f(C0213f.m1377a());
        if (zM70971f) {
            AbstractC12139d.m72767f(C12347f.m74285n().m74301m(), true);
        }
        Handler handler = this.f47248a;
        if (handler != null) {
            this.f47248a.sendMessage(Message.obtain(handler, 3105, Boolean.valueOf(zM70971f)));
        }
        C11852b.m70957b().m70958c(C0213f.m1377a());
    }
}
