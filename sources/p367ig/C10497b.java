package p367ig;

import android.os.Handler;
import java.util.TimerTask;

/* renamed from: ig.b */
/* loaded from: classes4.dex */
public class C10497b extends TimerTask {

    /* renamed from: a */
    public Handler f50663a;

    public C10497b(Handler handler) {
        this.f50663a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler handler = this.f50663a;
        if (handler != null) {
            handler.obtainMessage(4022).sendToTarget();
        }
    }
}
