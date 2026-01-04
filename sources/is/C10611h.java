package is;

import android.os.Handler;
import android.os.HandlerThread;
import as.C1016d;
import as.C1018f;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.activity.RiemannSoftArService;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.lite.common.android.receiver.PackageReceiver;
import es.C9550o;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import p622rr.C12619b;
import pr.InterfaceC12209b;

/* renamed from: is.h */
/* loaded from: classes8.dex */
public final class C10611h {

    /* renamed from: e */
    public static final byte[] f51002e = new byte[0];

    /* renamed from: f */
    public static volatile C10611h f51003f;

    /* renamed from: a */
    public RiemannSoftArService f51004a;

    /* renamed from: b */
    public Handler f51005b;

    /* renamed from: c */
    public HandlerThread f51006c;

    /* renamed from: d */
    public ConcurrentHashMap f51007d = new ConcurrentHashMap();

    /* renamed from: is.h$a */
    public class a implements InterfaceC12209b {

        /* renamed from: is.h$a$a, reason: collision with other inner class name */
        public class RunnableC14505a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f51009a;

            public RunnableC14505a(String str) {
                this.f51009a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C1016d.m6187g("ActivityRecognitionClientImpl", "uninstall:" + this.f51009a + " remove AR and AT request start", true);
                    C10611h.this.f51004a.getRecognitionRequestMapping().removeActivityUpdatesMappingInfoByPackageName(this.f51009a);
                    C10611h.this.f51004a.getTransitionMappingManager().removeActivityTransitionMappingInfoByPackageName(this.f51009a);
                    C10611h.this.f51004a.scheduleTimer();
                    C10611h.this.f51007d.remove(this.f51009a);
                    C10611h.this.f51005b.getLooper().quitSafely();
                    C1016d.m6186f("ActivityRecognitionClientImpl", "uninstall:" + this.f51009a + " remove AR and AT request success!");
                } catch (Exception unused) {
                    C1016d.m6185e("ActivityRecognitionClientImpl", "uninstall:" + this.f51009a + " remove AR and AT exception", true);
                }
            }
        }

        public a() {
        }

        @Override // pr.InterfaceC12209b
        /* renamed from: a */
        public final void mo59557a(String str) {
            C1016d.m6187g("ActivityRecognitionClientImpl", "call onRemoved:" + str, true);
            RunnableC14505a runnableC14505a = new RunnableC14505a(str);
            C10611h.this.f51007d.put(str, runnableC14505a);
            if (C10611h.this.f51005b == null || C10611h.this.f51006c == null || !C10611h.this.f51006c.isAlive()) {
                C10611h.m65043d(C10611h.this);
            }
            C10611h.this.f51005b.postDelayed(runnableC14505a, 60000L);
            C1016d.m6186f("ActivityRecognitionClientImpl", "call onRemoved end:" + str);
        }

        @Override // pr.InterfaceC12209b
        /* renamed from: b */
        public final void mo59558b(String str) {
            C1016d.m6186f("ActivityRecognitionClientImpl", "call onAdded enter:" + str);
        }

        @Override // pr.InterfaceC12209b
        /* renamed from: c */
        public final void mo59559c(String str) {
            C1016d.m6187g("ActivityRecognitionClientImpl", "call onReplaced enter:" + str, true);
            Runnable runnable = (Runnable) C10611h.this.f51007d.get(str);
            if (runnable == null) {
                C1016d.m6187g("ActivityRecognitionClientImpl", "removeThread had deleted or executed", true);
                return;
            }
            C10611h.this.f51005b.removeCallbacks(runnable);
            C1016d.m6186f("ActivityRecognitionClientImpl", "call onReplaced end:" + str + ":cancle removeThread success");
        }
    }

    public C10611h() {
        a aVar = new a();
        this.f51004a = RiemannSoftArService.getInstance();
        PackageReceiver.m38376g().m38381i(aVar);
    }

    /* renamed from: d */
    public static void m65043d(C10611h c10611h) {
        c10611h.getClass();
        HandlerThread handlerThread = new HandlerThread("Location-ARCImp");
        c10611h.f51006c = handlerThread;
        handlerThread.start();
        c10611h.f51005b = new Handler(c10611h.f51006c.getLooper());
    }

    /* renamed from: f */
    public static C10611h m65045f() {
        if (f51003f == null) {
            synchronized (f51002e) {
                try {
                    if (f51003f == null) {
                        f51003f = new C10611h();
                    }
                } finally {
                }
            }
        }
        return f51003f;
    }

    /* renamed from: g */
    public final void m65046g(long j10, ARCallback aRCallback, ClientInfo clientInfo) {
        if (!C9550o.m59635h() || C9550o.m59629b() >= 17) {
            this.f51004a.requestActivityUpdates(j10, aRCallback, clientInfo);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(clientInfo.getPackageName());
        arrayList.add(clientInfo.getTransactionID());
        arrayList.add("ARService is not support");
        C1018f c1018f = new C1018f();
        c1018f.m6192b(arrayList);
        C1016d.m6182b("ActivityRecognitionClientImpl", c1018f, true);
        throw new C12619b(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }

    /* renamed from: h */
    public final void m65047h(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        if (!C9550o.m59635h() || C9550o.m59629b() >= 17) {
            this.f51004a.requestActivityTransitionUpdates(activityTransitionRequest, aTCallback, clientInfo);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(clientInfo.getPackageName());
        arrayList.add(clientInfo.getTransactionID());
        arrayList.add("ARService is not support");
        C1018f c1018f = new C1018f();
        c1018f.m6192b(arrayList);
        C1016d.m6182b("ActivityRecognitionClientImpl", c1018f, true);
        throw new C12619b(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }

    /* renamed from: i */
    public final void m65048i(ARCallback aRCallback, ClientInfo clientInfo) {
        if (!C9550o.m59635h() || C9550o.m59629b() >= 17) {
            this.f51004a.removeActivityUpdates(aRCallback, clientInfo);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(clientInfo.getPackageName());
        arrayList.add(clientInfo.getTransactionID());
        arrayList.add("ARService is not support");
        C1018f c1018f = new C1018f();
        c1018f.m6192b(arrayList);
        C1016d.m6182b("ActivityRecognitionClientImpl", c1018f, true);
        throw new C12619b(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }

    /* renamed from: j */
    public final void m65049j(ATCallback aTCallback, ClientInfo clientInfo) {
        if (!C9550o.m59635h() || C9550o.m59629b() >= 17) {
            this.f51004a.removeActivityTransitionUpdates(aTCallback, clientInfo);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(clientInfo.getPackageName());
        arrayList.add(clientInfo.getTransactionID());
        arrayList.add("ARService is not support");
        C1018f c1018f = new C1018f();
        c1018f.m6192b(arrayList);
        C1016d.m6182b("ActivityRecognitionClientImpl", c1018f, true);
        throw new C12619b(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }
}
