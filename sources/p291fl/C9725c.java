package p291fl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import p291fl.C9725c;
import p514o9.C11839m;

/* renamed from: fl.c */
/* loaded from: classes6.dex */
public final class C9725c implements Handler.Callback {

    /* renamed from: d */
    public static volatile C9725c f47956d;

    /* renamed from: a */
    public Handler f47957a = null;

    /* renamed from: b */
    public final Object f47958b = new Object();

    /* renamed from: c */
    public final Map<Integer, WeakReference<a>> f47959c = new ConcurrentHashMap();

    /* renamed from: fl.c$a */
    public interface a {
        /* renamed from: a */
        void mo7500a();

        /* renamed from: b */
        long mo7501b();
    }

    public C9725c() {
        m60673b();
    }

    /* renamed from: a */
    public static C9725c m60672a() {
        if (f47956d == null) {
            synchronized (C9725c.class) {
                try {
                    if (f47956d == null) {
                        f47956d = new C9725c();
                    }
                } finally {
                }
            }
        }
        return f47956d;
    }

    /* renamed from: b */
    public final void m60673b() {
        C11839m.m70688i("WatchDog", "init");
        HandlerThread handlerThread = new HandlerThread("WatchMan", 5);
        handlerThread.setDaemon(true);
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.f47957a = new Handler(handlerThread.getLooper(), this);
        }
    }

    /* renamed from: c */
    public void m60674c(int i10, a aVar) {
        synchronized (this.f47958b) {
            C11839m.m70686d("WatchDog", "onHeartBeat hashCode:" + i10);
            this.f47957a.removeMessages(i10);
            this.f47959c.put(Integer.valueOf(i10), new WeakReference<>(aVar));
            this.f47957a.sendEmptyMessageDelayed(i10, aVar.mo7501b());
        }
    }

    /* renamed from: d */
    public void m60675d(int i10) {
        synchronized (this.f47958b) {
            C11839m.m70688i("WatchDog", "onTermination hashCode:" + i10);
            this.f47959c.remove(Integer.valueOf(i10));
            this.f47957a.removeMessages(i10);
        }
    }

    /* renamed from: e */
    public final void m60676e(int i10) {
        synchronized (this.f47958b) {
            C11839m.m70688i("WatchDog", "onTimeout hashCode:" + i10);
            Optional.ofNullable(this.f47959c.get(Integer.valueOf(i10))).map(new Function() { // from class: fl.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return (C9725c.a) ((WeakReference) obj).get();
                }
            }).ifPresent(new Consumer() { // from class: fl.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((C9725c.a) obj).mo7500a();
                }
            });
            this.f47959c.remove(Integer.valueOf(i10));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            m60676e(message.what);
            return true;
        } catch (Exception e10) {
            C11839m.m70686d("WatchDog", "onTimeout Exception:" + e10.getMessage());
            return true;
        }
    }
}
