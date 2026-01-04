package p341hj;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import fk.C9721b;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: hj.q0 */
/* loaded from: classes5.dex */
public abstract class AbstractC10259q0 extends AbstractC12367d {
    /* renamed from: c */
    public void m63425c(Handler handler, int i10, C9721b c9721b) {
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
    public void m63426d(Handler handler, int i10, C9721b c9721b, Bundle bundle) {
        if (handler == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = c9721b.m60659c();
        messageObtainMessage.obj = c9721b.getMessage();
        messageObtainMessage.setData(bundle);
        handler.sendMessage(messageObtainMessage);
    }

    /* renamed from: e */
    public void m63427e(Handler handler, int i10, Object obj) {
        if (handler == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = 0;
        messageObtainMessage.obj = obj;
        handler.sendMessage(messageObtainMessage);
    }

    /* renamed from: f */
    public void m63428f(Handler handler, int i10, Object obj, Bundle bundle) {
        if (handler == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = 0;
        messageObtainMessage.obj = obj;
        messageObtainMessage.setData(bundle);
        handler.sendMessage(messageObtainMessage);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.MARKETING_REQ_BUSINESS_FIX;
    }
}
