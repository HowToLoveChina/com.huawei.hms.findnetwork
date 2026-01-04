package cn.com.miaozhen.mobile.tracking.viewability.origin.p059e;

import android.content.Context;
import android.view.View;
import cn.com.miaozhen.mobile.tracking.api.C1480d;
import cn.com.miaozhen.mobile.tracking.viewability.origin.C1499d;
import cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1496a;
import cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack;
import ijiami_release01.NCall;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.e.e */
/* loaded from: classes.dex */
public class C1504e implements InterfaceC1500a {

    /* renamed from: b */
    private Context f6410b;

    /* renamed from: c */
    private long f6411c;

    /* renamed from: f */
    private C1506g f6414f;

    /* renamed from: h */
    private InterfaceC1496a f6416h;

    /* renamed from: i */
    private C1505f f6417i;

    /* renamed from: d */
    private ScheduledFuture<?> f6412d = null;

    /* renamed from: e */
    private int f6413e = 0;

    /* renamed from: a */
    private ScheduledExecutorService f6409a = Executors.newScheduledThreadPool(1);

    /* renamed from: g */
    private HashMap<String, C1507h> f6415g = new HashMap<>();

    /* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.e.e$a */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f6418a;

        /* renamed from: b */
        final /* synthetic */ MzCallBack f6419b;

        /* renamed from: c */
        final /* synthetic */ C1480d.a f6420c;

        public a(String str, MzCallBack mzCallBack, C1480d.a aVar) {
            this.f6418a = str;
            this.f6419b = mzCallBack;
            this.f6420c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.m64618IV(new Object[]{180, this});
        }
    }

    /* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.e.e$b */
    public final class b extends TimerTask {
        private b() {
        }

        /* renamed from: a */
        private void m8544a() {
            NCall.m64618IV(new Object[]{181, this});
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            NCall.m64618IV(new Object[]{182, this});
        }

        public /* synthetic */ b(C1504e c1504e, a aVar) {
            this();
        }
    }

    public C1504e(Context context, InterfaceC1496a interfaceC1496a, C1506g c1506g) {
        this.f6410b = context;
        this.f6414f = c1506g;
        this.f6416h = interfaceC1496a;
        this.f6411c = c1506g.m8550c();
        this.f6417i = new C1505f(context);
        m8536a();
    }

    /* renamed from: e */
    public static /* synthetic */ int m8540e(C1504e c1504e) {
        int i10 = c1504e.f6413e;
        c1504e.f6413e = i10 + 1;
        return i10;
    }

    /* renamed from: b */
    public void m8542b(String str) {
        NCall.m64618IV(new Object[]{187, this, str});
    }

    /* renamed from: a */
    private void m8536a() {
        NCall.m64618IV(new Object[]{183, this});
    }

    /* renamed from: b */
    public void m8543b(String str, MzCallBack mzCallBack, C1480d.a aVar) {
        NCall.m64618IV(new Object[]{188, this, str, mzCallBack, aVar});
    }

    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.p059e.InterfaceC1500a
    /* renamed from: a */
    public void mo8529a(String str) {
        NCall.m64618IV(new Object[]{184, this, str});
    }

    /* renamed from: a */
    public void m8541a(String str, View view, String str2, String str3, C1499d c1499d, MzCallBack mzCallBack, C1480d.a aVar) {
        NCall.m64618IV(new Object[]{185, this, str, view, str2, str3, c1499d, mzCallBack, aVar});
    }

    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.p059e.InterfaceC1500a
    /* renamed from: a */
    public void mo8530a(String str, MzCallBack mzCallBack, C1480d.a aVar) {
        NCall.m64618IV(new Object[]{186, this, str, mzCallBack, aVar});
    }
}
