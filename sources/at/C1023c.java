package at;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;
import et.InterfaceC9558c;
import et.InterfaceC9559d;

/* renamed from: at.c */
/* loaded from: classes8.dex */
public final class C1023c implements InterfaceC9559d {

    /* renamed from: a */
    public long f5064a = -1;

    /* renamed from: b */
    public final C1025e f5065b;

    /* renamed from: c */
    public final C1024d f5066c;

    /* renamed from: d */
    public InterfaceC9558c f5067d;

    /* renamed from: e */
    public Handler f5068e;

    /* renamed from: f */
    public Location f5069f;

    /* renamed from: g */
    public GnssRawObservation[] f5070g;

    /* renamed from: h */
    public long f5071h;

    public C1023c() {
        C1025e c1025e = new C1025e();
        this.f5065b = c1025e;
        c1025e.m6216d(this);
        c1025e.m6215b();
        this.f5066c = new C1024d();
        HandlerThread handlerThread = new HandlerThread("Loc-vdr-data");
        handlerThread.start();
        this.f5068e = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: at.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f5063a.m6208h(message);
            }
        });
    }

    /* renamed from: b */
    public final synchronized void m6202b() {
        C1025e c1025e = this.f5065b;
        if (c1025e != null && this.f5066c != null) {
            c1025e.m6214a();
            this.f5066c.m6209a();
            this.f5068e.removeCallbacksAndMessages(null);
            this.f5068e.getLooper().quitSafely();
            this.f5068e = null;
            C1016d.m6186f("VdrDataManager", "stop vdr data");
            return;
        }
        C1016d.m6183c("VdrDataManager", "init fail, try to call start method");
    }

    /* renamed from: c */
    public final void m6203c(GnssRawObservation[] gnssRawObservationArr, long j10) {
        Handler handler = this.f5068e;
        if (handler == null) {
            C1016d.m6183c("VdrDataManager", "handler is null, drop gnss data here.");
            return;
        }
        handler.removeCallbacksAndMessages(null);
        if (this.f5069f != null) {
            m6207g(gnssRawObservationArr, j10);
            return;
        }
        this.f5070g = gnssRawObservationArr;
        this.f5071h = j10;
        Handler handler2 = this.f5068e;
        handler2.sendMessageDelayed(handler2.obtainMessage(11), 40L);
    }

    /* renamed from: d */
    public final Location m6204d() {
        return this.f5069f;
    }

    /* renamed from: e */
    public final void m6205e(Location location) {
        this.f5069f = location;
    }

    /* renamed from: f */
    public final synchronized void m6206f(InterfaceC9558c interfaceC9558c) {
        Handler handler = this.f5068e;
        if (handler == null) {
            C1016d.m6183c("VdrDataManager", "handler is null, setVdrDataListener failed.");
            return;
        }
        this.f5067d = interfaceC9558c;
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.f5068e;
        handler2.sendMessage(handler2.obtainMessage(10));
    }

    /* renamed from: g */
    public final synchronized void m6207g(GnssRawObservation[] gnssRawObservationArr, long j10) {
        InterfaceC9558c interfaceC9558c;
        Handler handler = this.f5068e;
        if (handler == null) {
            C1016d.m6183c("VdrDataManager", "handler is null,can not handler data");
            return;
        }
        handler.removeCallbacksAndMessages(null);
        if (gnssRawObservationArr == null) {
            Handler handler2 = this.f5068e;
            handler2.sendMessageDelayed(handler2.obtainMessage(10), 1000L);
        } else {
            Handler handler3 = this.f5068e;
            handler3.sendMessageDelayed(handler3.obtainMessage(10), 1300L);
        }
        MotionSensors motionSensorsM6210b = this.f5066c.m6210b(this.f5064a, j10);
        this.f5064a = j10;
        if (motionSensorsM6210b != null && (interfaceC9558c = this.f5067d) != null) {
            interfaceC9558c.onVdrDataReceived(new C1021a(gnssRawObservationArr, motionSensorsM6210b, this.f5069f));
            this.f5069f = null;
        }
    }

    /* renamed from: h */
    public final /* synthetic */ boolean m6208h(Message message) {
        int i10 = message.what;
        if (i10 == 10) {
            m6207g(null, SystemClock.elapsedRealtimeNanos());
            return false;
        }
        if (i10 != 11) {
            return false;
        }
        m6207g(this.f5070g, this.f5071h);
        return false;
    }
}
