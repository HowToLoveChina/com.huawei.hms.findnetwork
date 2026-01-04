package p529op;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p529op.C11984f;
import p815ym.AbstractC14026a;

/* renamed from: op.f */
/* loaded from: classes8.dex */
public class C11984f {

    /* renamed from: b */
    public AtomicBoolean f55774b = new AtomicBoolean(false);

    /* renamed from: c */
    public final CopyOnWriteArrayList<d> f55775c = new CopyOnWriteArrayList<>();

    /* renamed from: a */
    public b f55773a = new b();

    /* renamed from: op.f$b */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (!AbstractC14026a.m84159a(C11984f.this.f55775c)) {
                        String action = new SafeIntent(intent).getAction();
                        if ("android.intent.action.SCREEN_ON".equals(action)) {
                            C11984f.this.f55775c.forEach(new Consumer() { // from class: op.g
                                @Override // java.util.function.Consumer
                                public final void accept(Object obj) {
                                    ((C11984f.d) obj).onScreenOn();
                                }
                            });
                            return;
                        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                            C11984f.this.f55775c.forEach(new Consumer() { // from class: op.h
                                @Override // java.util.function.Consumer
                                public final void accept(Object obj) {
                                    ((C11984f.d) obj).onScreenOff();
                                }
                            });
                            return;
                        } else {
                            if ("android.intent.action.USER_PRESENT".equals(action)) {
                                C11984f.this.f55775c.forEach(new Consumer() { // from class: op.i
                                    @Override // java.util.function.Consumer
                                    public final void accept(Object obj) {
                                        ((C11984f.d) obj).onUserPresent();
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    }
                } catch (Exception e10) {
                    AbstractC10896a.m65886e("ScreenListenerV2", "onReceive exception: " + e10.getMessage());
                    return;
                }
            }
            AbstractC10896a.m65887i("ScreenListenerV2", "intent is null or mScreenListenerMap is empty.");
        }
    }

    /* renamed from: op.f$c */
    public static class c {

        /* renamed from: a */
        public static final C11984f f55777a = new C11984f();
    }

    /* renamed from: op.f$d */
    public interface d {
        void onScreenOff();

        void onScreenOn();

        void onUserPresent();
    }

    /* renamed from: c */
    public static C11984f m72128c() {
        return c.f55777a;
    }

    /* renamed from: b */
    public void m72129b(d dVar) {
        m72130d(dVar);
    }

    /* renamed from: d */
    public final void m72130d(d dVar) {
        try {
            if (this.f55775c.contains(dVar)) {
                AbstractC10896a.m65887i("ScreenListenerV2", "already register Listener:" + dVar);
                return;
            }
            this.f55775c.add(dVar);
            if (!this.f55774b.compareAndSet(false, true)) {
                AbstractC10896a.m65887i("ScreenListenerV2", "already register receiver.");
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            C0213f.m1377a().registerReceiver(this.f55773a, intentFilter);
            AbstractC10896a.m65887i("ScreenListenerV2", "registerListener,screenListenerList size is:" + this.f55775c.size());
        } catch (Exception e10) {
            AbstractC10896a.m65886e("ScreenListenerV2", "registerListener exception: " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public void m72131e(d dVar) {
        try {
            if (AbstractC14026a.m84159a(this.f55775c)) {
                AbstractC10896a.m65888w("ScreenListenerV2", "unregisterListener error,list is empty.");
                return;
            }
            if (this.f55775c.contains(dVar)) {
                this.f55775c.remove(dVar);
                if (AbstractC14026a.m84159a(this.f55775c)) {
                    AbstractC10896a.m65887i("ScreenListenerV2", "screenListenerList is empty,unregister screen receiver");
                    C0213f.m1377a().unregisterReceiver(this.f55773a);
                    this.f55774b.compareAndSet(true, false);
                }
                AbstractC10896a.m65887i("ScreenListenerV2", "unregister listener finished,screenListenerList size is:" + this.f55775c.size());
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("ScreenListenerV2", "unregisterListener exception: " + e10.getMessage());
        }
    }
}
