package p829z1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: z1.y */
/* loaded from: classes.dex */
public class C14086y {

    /* renamed from: a */
    public boolean f63073a;

    /* renamed from: b */
    public final Handler f63074b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: z1.y$a */
    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((InterfaceC14083v) message.obj).mo60254a();
            return true;
        }
    }

    /* renamed from: a */
    public synchronized void m84423a(InterfaceC14083v<?> interfaceC14083v, boolean z10) {
        try {
            if (this.f63073a || z10) {
                this.f63074b.obtainMessage(1, interfaceC14083v).sendToTarget();
            } else {
                this.f63073a = true;
                interfaceC14083v.mo60254a();
                this.f63073a = false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
