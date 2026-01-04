package com.huawei.hms.network.p129ai;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextCompat;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.ComposedNetworkKit;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.RequestContext;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.ai.c0 */
/* loaded from: classes8.dex */
public class C5791c0 extends SafeBroadcastReceiver implements InterfaceC5802i {

    /* renamed from: j */
    public static final String f25767j = "EventModel";

    /* renamed from: c */
    public long f25770c;

    /* renamed from: d */
    public long f25771d;

    /* renamed from: a */
    public int f25768a = -1;

    /* renamed from: b */
    public boolean f25769b = true;

    /* renamed from: e */
    public long f25772e = 120000;

    /* renamed from: f */
    public long f25773f = 360000;

    /* renamed from: g */
    public List<String> f25774g = new ArrayList();

    /* renamed from: h */
    public boolean f25775h = false;

    /* renamed from: i */
    public boolean f25776i = false;

    /* renamed from: com.huawei.hms.network.ai.c0$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ContextCompat.checkSelfPermission(ContextHolder.getAppContext(), "android.permission.ACCESS_NETWORK_STATE")) {
                Logger.m32136d(C5791c0.f25767j, "has no pomission to access network state");
                return;
            }
            C5791c0.this.m33277g();
            C5791c0.this.f25770c = System.currentTimeMillis();
        }
    }

    /* renamed from: com.huawei.hms.network.ai.c0$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C5791c0.this.m33278h()) {
                return;
            }
            C5791c0.this.m33276f();
            C5791c0.this.f25775h = true;
        }
    }

    /* renamed from: com.huawei.hms.network.ai.c0$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f25779a;

        /* renamed from: b */
        public final /* synthetic */ Intent f25780b;

        public c(Context context, Intent intent) {
            this.f25779a = context;
            this.f25780b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5791c0.this.m33280a(this.f25779a, this.f25780b);
        }
    }

    /* renamed from: f */
    public void m33276f() {
        ContextHolder.getAppContext().unregisterReceiver(this);
    }

    /* renamed from: g */
    public void m33277g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ContextHolder.getAppContext().registerReceiver(this, intentFilter);
    }

    /* renamed from: h */
    public boolean m33278h() {
        return this.f25775h;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: b */
    public void mo33283b() {
        C5794e.m33310a().m33311a(new b());
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: c */
    public void mo33284c() {
        this.f25774g.clear();
        this.f25776i = true;
    }

    /* renamed from: d */
    public void m33285d() {
        this.f25774g = NetworkKitInnerImpl.getInstance().getHostsInConnectionPool();
    }

    /* renamed from: e */
    public void m33286e() throws JSONException {
        if (this.f25776i) {
            return;
        }
        if (System.currentTimeMillis() - this.f25771d > this.f25773f) {
            Logger.m32141i(f25767j, "long time no request, no need to prefetch when network change");
        } else {
            Logger.m32141i(f25767j, "prefetch size:" + this.f25774g.size());
            for (String str : this.f25774g) {
                if (!TextUtils.isEmpty(str)) {
                    Logger.m32136d(f25767j, "prefetch domain : " + str);
                    PreConnectManager.getInstance().connect(str, new PreConnectManager.ConnectCallBack());
                }
            }
        }
        this.f25774g.clear();
    }

    @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
    public void onReceiveMsg(Context context, Intent intent) {
        C5794e.m33310a().m33312b(new c(context, intent));
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33279a() {
        C5794e.m33310a().m33311a(new a());
    }

    /* renamed from: a */
    public synchronized void m33280a(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            int primaryNetworkType = NetworkUtil.getPrimaryNetworkType(context);
            boolean zIsNetworkAvailable = NetworkUtil.isNetworkAvailable(context);
            if (this.f25769b) {
                this.f25768a = primaryNetworkType;
                this.f25769b = false;
                return;
            }
            int i10 = this.f25768a;
            if (i10 == primaryNetworkType) {
                return;
            }
            if (i10 == -1 || i10 == 0) {
                Logger.m32141i(f25767j, "network recovery");
                if (System.currentTimeMillis() - this.f25770c < this.f25772e && zIsNetworkAvailable) {
                    m33286e();
                }
            } else {
                m33285d();
                ComposedNetworkKit.getInstance().evictAllConnections();
                if (zIsNetworkAvailable) {
                    Logger.m32141i(f25767j, "network type changed");
                    m33286e();
                } else {
                    Logger.m32141i(f25767j, "network disconnected");
                    this.f25770c = System.currentTimeMillis();
                }
            }
            this.f25768a = primaryNetworkType;
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33281a(C5808l c5808l) {
        if (c5808l != null) {
            this.f25771d = System.currentTimeMillis();
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33282a(RequestContext requestContext) {
    }
}
