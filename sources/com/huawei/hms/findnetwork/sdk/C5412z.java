package com.huawei.hms.findnetwork.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.huawei.hiar.ARTrackable;
import com.huawei.hms.findnetwork.bean.BtMeasureResult;
import com.huawei.hms.findnetwork.comm.request.bean.NearLinkNavigationResult;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;

/* renamed from: com.huawei.hms.findnetwork.sdk.z */
/* loaded from: classes8.dex */
public class C5412z {

    /* renamed from: a */
    public BtMeasureResult f24863a;

    /* renamed from: b */
    public NearLinkNavigationResult f24864b;

    /* renamed from: c */
    public long f24865c;

    /* renamed from: d */
    public long f24866d;

    /* renamed from: e */
    public Handler f24867e;

    /* renamed from: f */
    public HandlerThread f24868f;

    /* renamed from: g */
    public long f24869g;

    /* renamed from: com.huawei.hms.findnetwork.sdk.z$a */
    public class a extends Handler {

        /* renamed from: a */
        public final /* synthetic */ c f24870a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, c cVar) {
            super(looper);
            this.f24870a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1 || this.f24870a == null) {
                return;
            }
            Pair<Integer, NearLinkNavigationResult> pairM32121c = C5412z.this.m32121c();
            NearLinkNavigationResult nearLinkNavigationResult = (NearLinkNavigationResult) pairM32121c.second;
            if (nearLinkNavigationResult != null) {
                if (nearLinkNavigationResult.getStage() != -1.0f) {
                    this.f24870a.mo31982a(((Integer) pairM32121c.first).intValue(), nearLinkNavigationResult);
                } else {
                    HmsFindSDKLog.m32127i("NearLinkDataPresent", "no valid range result.");
                }
                C5412z.this.f24867e.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (System.currentTimeMillis() - C5412z.this.f24869g < 10000) {
                C5412z.this.f24867e.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            HmsFindSDKLog.m32128w("NearLinkDataPresent", "remote process maybe killed.");
            C5412z.this.m32122d();
            this.f24870a.mo31981a();
        }
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.z$b */
    public static final class b {

        /* renamed from: a */
        public static final C5412z f24872a = new C5412z(null);
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.z$c */
    public interface c {
        /* renamed from: a */
        void mo31981a();

        /* renamed from: a */
        void mo31982a(int i10, NearLinkNavigationResult nearLinkNavigationResult);
    }

    public C5412z() {
    }

    public /* synthetic */ C5412z(a aVar) {
        this();
    }

    /* renamed from: a */
    public final int m32115a(int i10) {
        if (i10 == 1) {
            return 10;
        }
        if (i10 != 5) {
            return i10 != 10 ? -1 : 12;
        }
        return 11;
    }

    /* renamed from: c */
    public Pair<Integer, NearLinkNavigationResult> m32121c() {
        if (this.f24864b == null || Math.abs(System.currentTimeMillis() - this.f24866d) >= 1600) {
            return new Pair<>(-1, null);
        }
        float stage = this.f24864b.getStage();
        if (stage != -1.0f && stage != 3.0f) {
            return new Pair<>(Integer.valueOf(ARTrackable.TrackingState.PAUSED == C5342a.m31942c().m31948d() ? ErrorCode.CODE_AR_ENVIRONMENT_NOT_SATISFIED : 0), this.f24864b);
        }
        NearLinkNavigationResult nearLinkNavigationResultM32116a = m32116a();
        if (nearLinkNavigationResultM32116a == null) {
            nearLinkNavigationResultM32116a = this.f24864b;
        }
        return new Pair<>(0, nearLinkNavigationResultM32116a);
    }

    /* renamed from: d */
    public void m32122d() {
        HmsFindSDKLog.m32127i("NearLinkDataPresent", "releaseTimer");
        Handler handler = this.f24867e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f24867e = null;
        }
        HandlerThread handlerThread = this.f24868f;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f24868f = null;
        }
        this.f24864b = null;
        this.f24863a = null;
    }

    /* renamed from: b */
    public static C5412z m32114b() {
        return b.f24872a;
    }

    /* renamed from: a */
    public final NearLinkNavigationResult m32116a() {
        if (this.f24863a == null || Math.abs(System.currentTimeMillis() - this.f24865c) >= 6100) {
            return null;
        }
        NearLinkNavigationResult nearLinkNavigationResult = new NearLinkNavigationResult();
        nearLinkNavigationResult.setDeviceId(this.f24863a.getSn());
        nearLinkNavigationResult.setStage(0.0f);
        nearLinkNavigationResult.setDirection(m32115a(this.f24863a.getFlag()));
        nearLinkNavigationResult.setAngleAccuracy(this.f24863a.getPercentage());
        return nearLinkNavigationResult;
    }

    /* renamed from: a */
    public void m32117a(BtMeasureResult btMeasureResult) {
        this.f24863a = btMeasureResult;
        this.f24865c = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m32118a(NearLinkNavigationResult nearLinkNavigationResult) {
        this.f24864b = nearLinkNavigationResult;
        this.f24866d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m32119a(c cVar) {
        HmsFindSDKLog.m32127i("NearLinkDataPresent", "startTimer");
        if (this.f24867e != null) {
            HmsFindSDKLog.m32127i("NearLinkDataPresent", "startTimer ignore, have started");
            return;
        }
        this.f24869g = System.currentTimeMillis();
        if (this.f24868f == null) {
            this.f24868f = new HandlerThread("NearLinkDataPresent");
        }
        this.f24868f.start();
        a aVar = new a(this.f24868f.getLooper(), cVar);
        this.f24867e = aVar;
        aVar.sendEmptyMessageDelayed(1, 500L);
    }

    /* renamed from: a */
    public void m32120a(Runnable runnable, long j10) {
        Handler handler = this.f24867e;
        if (handler == null) {
            return;
        }
        handler.postDelayed(runnable, j10);
    }
}
