package com.huawei.location.lite.common.android.receiver;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import as.C1016d;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class ScreenStatusBroadcastReceiver extends SafeBroadcastReceiver {

    /* renamed from: e */
    public static long f31338e;

    /* renamed from: f */
    public static List<InterfaceC6773b> f31339f = new CopyOnWriteArrayList();

    /* renamed from: c */
    public Handler f31340c = null;

    /* renamed from: d */
    public HandlerThread f31341d;

    /* renamed from: com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver$a */
    public class HandlerC6772a extends Handler {
        public HandlerC6772a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1005) {
                C1016d.m6183c("ScreenStatusBroadcastReceiver", "message error");
                return;
            }
            C1016d.m6181a("ScreenStatusBroadcastReceiver", "isScreenOn : " + ScreenStatusBroadcastReceiver.m38385g());
        }
    }

    /* renamed from: com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver$b */
    public interface InterfaceC6773b {
        void onScreenOff();

        void onScreenOn();
    }

    /* renamed from: g */
    public static boolean m38385g() {
        Object systemService = C11991a.m72145a().getSystemService("power");
        boolean zIsScreenOn = systemService instanceof PowerManager ? ((PowerManager) systemService).isScreenOn() : false;
        C1016d.m6181a("ScreenStatusBroadcastReceiver", "isCurScreenOn:" + zIsScreenOn);
        return zIsScreenOn;
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    /* renamed from: d */
    public void mo38377d(Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        C1016d.m6181a("ScreenStatusBroadcastReceiver", "onReceive action : " + safeIntent.getAction());
        if ("android.intent.action.SCREEN_OFF".equals(safeIntent.getAction())) {
            m38386h();
            m38388j();
        }
        if ("android.intent.action.SCREEN_ON".equals(safeIntent.getAction())) {
            m38387i();
            Handler handler = this.f31340c;
            if (handler == null || !handler.hasMessages(1005)) {
                return;
            }
            C1016d.m6181a("ScreenStatusBroadcastReceiver", "screen on remove Messages");
            this.f31340c.removeMessages(1005);
        }
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    /* renamed from: e */
    public String mo38378e() {
        return "Loc-Screen-Receive";
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    /* renamed from: f */
    public int mo38379f() {
        return 120000;
    }

    /* renamed from: h */
    public final void m38386h() {
        m38389k(200000000000L);
        C1016d.m6181a("ScreenStatusBroadcastReceiver", "onScreenOff,report latency is:" + (f31338e / 1000000000) + "s");
        try {
            for (InterfaceC6773b interfaceC6773b : f31339f) {
                if (interfaceC6773b != null) {
                    interfaceC6773b.onScreenOff();
                }
            }
        } catch (Exception unused) {
            C1016d.m6185e("ScreenStatusBroadcastReceiver", "exec callback onScreenOff exception", true);
        }
    }

    /* renamed from: i */
    public final void m38387i() {
        m38389k(5000000000L);
        C1016d.m6181a("ScreenStatusBroadcastReceiver", "onScreenOn,report latency is:" + (f31338e / 1000000000) + "s");
        try {
            for (InterfaceC6773b interfaceC6773b : f31339f) {
                if (interfaceC6773b != null) {
                    interfaceC6773b.onScreenOn();
                }
            }
        } catch (Exception unused) {
            C1016d.m6185e("ScreenStatusBroadcastReceiver", "exec callback onScreenOn exception", true);
        }
    }

    /* renamed from: j */
    public final void m38388j() {
        if (this.f31341d == null || this.f31340c == null) {
            C1016d.m6181a("ScreenStatusBroadcastReceiver", "postDelayMsg new handlerThread");
            HandlerThread handlerThread = new HandlerThread("Location_Lite_Broadcast");
            this.f31341d = handlerThread;
            handlerThread.start();
            this.f31340c = new HandlerC6772a(this.f31341d.getLooper());
        } else {
            C1016d.m6181a("ScreenStatusBroadcastReceiver", "screen off remove Messages");
            this.f31340c.removeMessages(1005);
        }
        C1016d.m6181a("ScreenStatusBroadcastReceiver", "sendEmptyMessageDelayed 5 seconds for screenOff. the result is : " + this.f31340c.sendEmptyMessageDelayed(1005, 5000L));
    }

    /* renamed from: k */
    public final void m38389k(long j10) {
        f31338e = j10;
    }
}
