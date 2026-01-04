package p367ig;

import android.os.Handler;
import java.util.TimerTask;

/* renamed from: ig.f */
/* loaded from: classes4.dex */
public class C10501f extends TimerTask {

    /* renamed from: a */
    public Handler f50666a;

    public C10501f(Handler handler) {
        this.f50666a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler handler = this.f50666a;
        if (handler != null) {
            handler.obtainMessage(4021).sendToTarget();
        }
    }
}
