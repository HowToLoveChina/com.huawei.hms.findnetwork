package p659ts;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import as.C1016d;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.ISoftARManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver;
import com.huawei.location.router.LocationNaming;
import com.huawei.location.router.RouterTaskHandler;
import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.RouterRequest;
import com.huawei.location.sdm.Config;
import es.C9548m;
import ir.C10603b;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import p531or.C11991a;
import p784xq.C13850f;
import ws.C13635i;

/* renamed from: ts.a */
/* loaded from: classes8.dex */
public final class C13067a {

    /* renamed from: c */
    public boolean f59458c;

    /* renamed from: d */
    public b[] f59459d;

    /* renamed from: e */
    public b[] f59460e;

    /* renamed from: f */
    public b[] f59461f;

    /* renamed from: g */
    public b[] f59462g;

    /* renamed from: h */
    public ISoftARManager f59463h;

    /* renamed from: i */
    public C10603b f59464i;

    /* renamed from: j */
    public a f59465j;

    /* renamed from: k */
    public C13635i f59466k;

    /* renamed from: l */
    public Config f59467l;

    /* renamed from: a */
    public int f59456a = -1;

    /* renamed from: b */
    public long f59457b = 0;

    /* renamed from: m */
    public ARCallback f59468m = new c();

    /* renamed from: ts.a$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                C13067a.this.m78830d();
            }
        }
    }

    /* renamed from: ts.a$b */
    public static class b {

        /* renamed from: a */
        public boolean f59470a;

        /* renamed from: b */
        public boolean f59471b = true;

        /* renamed from: c */
        public int f59472c;
    }

    /* renamed from: ts.a$c */
    public class c implements ARCallback {
        public c() {
        }

        @Override // com.huawei.location.base.activity.callback.ARCallback
        public final void onActivityRecognition(ActivityRecognitionResult activityRecognitionResult) {
            C1016d.m6186f("SDMSupportManager", "onActivityRecognition");
            if (activityRecognitionResult == null || activityRecognitionResult.getProbableActivities() == null || activityRecognitionResult.getProbableActivities().size() <= 0) {
                return;
            }
            DetectedActivity detectedActivity = activityRecognitionResult.getProbableActivities().get(0);
            if (detectedActivity != null) {
                C13067a.this.f59456a = detectedActivity.getType();
            }
            if (C13067a.this.f59456a != 2 || activityRecognitionResult.getProbableActivities().size() <= 1) {
                return;
            }
            DetectedActivity detectedActivity2 = activityRecognitionResult.getProbableActivities().get(1);
            if (detectedActivity != null) {
                C13067a.this.f59456a = detectedActivity2.getType();
            }
        }
    }

    /* renamed from: a */
    public final void m78829a() {
        ISoftARManager iSoftARManager = this.f59463h;
        if (iSoftARManager != null) {
            iSoftARManager.removeActivityUpdates(this.f59468m);
            this.f59456a = -1;
        }
        this.f59465j = null;
    }

    /* renamed from: d */
    public final void m78830d() {
        IRouterResponse iRouterResponseExecute = RouterTaskHandler.getInstance().execute(new RouterRequest(LocationNaming.REQUEST_ADAPTER_SDM, "", UUID.randomUUID().toString(), null));
        if (iRouterResponseExecute instanceof ISoftARManager) {
            this.f59463h = (ISoftARManager) iRouterResponseExecute;
        }
        ISoftARManager iSoftARManager = this.f59463h;
        if (iSoftARManager != null) {
            iSoftARManager.requestActivityUpdates(1000L, this.f59468m);
        }
        this.f59459d = new b[2];
        this.f59460e = new b[2];
        this.f59461f = new b[2];
        this.f59462g = new b[2];
        this.f59466k = new C13635i(25, 30);
    }

    /* renamed from: e */
    public final void m78831e(Looper looper, C10603b c10603b, Config config) {
        this.f59467l = config;
        this.f59464i = c10603b;
        if (this.f59465j == null) {
            this.f59465j = new a(looper);
        }
        if (this.f59465j.hasMessages(11)) {
            C1016d.m6186f("SDMSupportManager", "init failed,caz has msg");
        } else {
            this.f59465j.sendEmptyMessage(11);
        }
    }

    /* renamed from: g */
    public final boolean m78832g(double d10, double d11, float f10) throws JSONException, IOException {
        String str;
        boolean z10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f59457b > 1000) {
            this.f59457b = jCurrentTimeMillis;
            boolean zM78833h = m78833h(this.f59459d, ScreenStatusBroadcastReceiver.m38385g());
            boolean zM78833h2 = m78833h(this.f59460e, !C9548m.m59621d(C11991a.m72145a().getPackageName()));
            b[] bVarArr = this.f59461f;
            C13850f.m83120a(new StringBuilder("currentARType: "), this.f59456a, "SDMSupportManager");
            int i10 = this.f59456a;
            if (i10 == 3 || i10 == 7) {
                Config config = this.f59467l;
                z10 = config == null || f10 < ((float) config.m38497e());
            } else {
                if (this.f59467l != null && f10 < r5.m38497e()) {
                    C1016d.m6186f("SDMSupportManager", "speed: " + f10);
                }
            }
            boolean zM78833h3 = m78833h(bVarArr, z10);
            b[] bVarArr2 = this.f59462g;
            C13635i c13635i = this.f59466k;
            boolean zM78833h4 = m78833h(bVarArr2, c13635i != null ? c13635i.m82001k(d10, d11) : false);
            boolean z11 = zM78833h && zM78833h2 && zM78833h3 && zM78833h4;
            this.f59458c = z11;
            if (z11) {
                C10603b c10603b = this.f59464i;
                if (c10603b == null) {
                    return false;
                }
                boolean zM65016j = c10603b.m65016j();
                this.f59458c = zM65016j;
                str = zM65016j ? "sdm is ok" : "sdm is bad caz EphModule not available";
            } else {
                str = "sdm is bad caz after smooth:   screen[" + zM78833h + "]; isForeground[" + zM78833h2 + "]; ar[" + zM78833h3 + "]; tile[" + zM78833h4 + "]";
            }
        } else {
            str = "sdm check time support: " + this.f59458c;
        }
        C1016d.m6186f("SDMSupportManager", str);
        return this.f59458c;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m78833h(p659ts.C13067a.b[] r8, boolean r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L8f
            int r1 = r8.length
            r2 = 2
            if (r1 >= r2) goto L9
            goto L8f
        L9:
            r1 = r8[r0]
            java.lang.String r2 = "SDMSupportManager"
            r3 = 1
            if (r1 != 0) goto L24
            java.lang.String r7 = "sdm record status[0] first time"
            as.C1016d.m6186f(r2, r7)
            ts.a$b r7 = new ts.a$b
            r7.<init>()
            r8[r0] = r7
            r7.f59470a = r9
            int r8 = r7.f59472c
            int r8 = r8 + r3
            r7.f59472c = r8
            return r9
        L24:
            boolean r4 = r1.f59470a
            r5 = 0
            if (r4 == r9) goto L7a
            r4 = r8[r3]
            if (r4 != 0) goto L41
            java.lang.String r7 = "sdm record status[1] first time"
            as.C1016d.m6186f(r2, r7)
            ts.a$b r7 = new ts.a$b
            r7.<init>()
            r8[r3] = r7
            r7.f59470a = r9
            int r9 = r7.f59472c
            int r9 = r9 + r3
            r7.f59472c = r9
            goto L8a
        L41:
            int r6 = r4.f59472c
            int r6 = r6 + r3
            r4.f59472c = r6
            com.huawei.location.sdm.Config r4 = r7.f59467l
            if (r4 == 0) goto L5c
            boolean r1 = r1.f59471b
            r9 = r9 | r1
            int r1 = r4.m38498f()
            com.huawei.location.sdm.Config r7 = r7.f59467l
            int r7 = r7.m38496d()
            if (r9 == 0) goto L5a
            goto L66
        L5a:
            r1 = r7
            goto L66
        L5c:
            boolean r7 = r1.f59471b
            r7 = r7 | r9
            if (r7 == 0) goto L63
            r1 = 3
            goto L66
        L63:
            r7 = 10
            goto L5a
        L66:
            r7 = r8[r3]
            int r7 = r7.f59472c
            if (r7 < r1) goto L8a
            java.lang.String r7 = "sdm status changed"
            as.C1016d.m6186f(r2, r7)
            r7 = r8[r3]
            r8[r0] = r7
            r7.f59471b = r0
            r8[r3] = r5
            goto L8a
        L7a:
            int r7 = r1.f59472c
            int r7 = r7 + r3
            r1.f59472c = r7
            r7 = r8[r3]
            if (r7 == 0) goto L8a
            java.lang.String r7 = "sdm destroy status[1]"
            as.C1016d.m6186f(r2, r7)
            r8[r3] = r5
        L8a:
            r7 = r8[r0]
            boolean r7 = r7.f59470a
            return r7
        L8f:
            r7.m78830d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p659ts.C13067a.m78833h(ts.a$b[], boolean):boolean");
    }
}
