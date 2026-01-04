package p341hj;

import android.os.Handler;
import android.os.Message;
import fk.C9721b;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: hj.n */
/* loaded from: classes5.dex */
public class C10249n extends AbstractC12367d {

    /* renamed from: a */
    public Handler f49659a;

    /* renamed from: b */
    public String f49660b;

    public C10249n(Handler handler, String str) {
        this.f49659a = handler;
        this.f49660b = str;
    }

    /* renamed from: c */
    private void m63402c(Handler handler, int i10, C9721b c9721b) {
        if (handler == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = c9721b.m60659c();
        messageObtainMessage.obj = c9721b.getMessage();
        handler.sendMessage(messageObtainMessage);
    }

    /* renamed from: d */
    private void m63403d(Handler handler, int i10, Object obj) {
        if (handler == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = 0;
        messageObtainMessage.obj = obj;
        handler.sendMessage(messageObtainMessage);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07041"), "forwardIM", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        try {
            m63403d(this.f49659a, 7032, C9948a.m61631C().m61685o(this.f49660b, c11060cM66626a));
        } catch (C9721b e10) {
            C1442a.m8289e("ForwardIMTask", "ForwardIMTask exception: " + e10.toString());
            m63402c(this.f49659a, 7033, e10);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.FREQUENCY_CONTROL;
    }
}
