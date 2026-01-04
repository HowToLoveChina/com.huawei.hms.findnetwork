package com.huawei.openalliance.p169ad.download.p172ag;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6971bo;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.analysis.BaseAnalysisInfo;
import com.huawei.openalliance.p169ad.analysis.C6921b;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.InterfaceC7068k;
import com.huawei.openalliance.p169ad.download.InterfaceC7069l;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.download.ag.e */
/* loaded from: classes2.dex */
public class C7037e {

    /* renamed from: a */
    private static final byte[] f32319a = new byte[0];

    /* renamed from: b */
    private static C7037e f32320b;

    /* renamed from: c */
    private a f32321c;

    /* renamed from: d */
    private c f32322d;

    /* renamed from: e */
    private InterfaceC7068k f32323e;

    /* renamed from: f */
    private Context f32324f;

    /* renamed from: g */
    private Map<String, WeakHashMap<InterfaceC7069l, Object>> f32325g = new ConcurrentHashMap();

    /* renamed from: com.huawei.openalliance.ad.download.ag.e$a */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC7185ho.m43820b("AgReserveDownloadManager", "reserve broadcast.");
            try {
                SafeIntent safeIntent = new SafeIntent(intent);
                String action = safeIntent.getAction();
                if ("com.huawei.appgallery.reserveappstatus".equals(action)) {
                    C7037e.this.m42191a(safeIntent);
                } else {
                    AbstractC7185ho.m43824c("AgReserveDownloadManager", "inValid para %s.", action);
                }
            } catch (IllegalStateException e10) {
                AbstractC7185ho.m43824c("AgReserveDownloadManager", "reserve onReceive IllegalStateException: %s", e10.getClass().getSimpleName());
            } catch (Exception e11) {
                AbstractC7185ho.m43824c("AgReserveDownloadManager", "reserve onReceive Exception: %s", e11.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.e$b */
    public static class b implements RemoteCallResultCallback<String> {
        private b() {
        }

        @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            AbstractC7185ho.m43821b("AgReserveDownloadManager", "reserve app %s.", Integer.valueOf(callResult.getCode()));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.ag.e$c */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC7185ho.m43820b("AgReserveDownloadManager", "silent reserve broadcast.");
            C7037e.this.m42190a(context, intent);
        }
    }

    private C7037e(Context context) {
        String str;
        this.f32324f = context.getApplicationContext();
        try {
            m42189a();
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            AbstractC7185ho.m43823c("AgReserveDownloadManager", str);
        } catch (Exception unused2) {
            str = "registerReceiver Exception";
            AbstractC7185ho.m43823c("AgReserveDownloadManager", str);
        }
    }

    /* renamed from: a */
    public static C7037e m42187a(Context context) {
        C7037e c7037e;
        synchronized (f32319a) {
            try {
                if (f32320b == null) {
                    f32320b = new C7037e(context);
                }
                c7037e = f32320b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7037e;
    }

    /* renamed from: b */
    private void m42195b(String str, int i10) {
        AbstractC7185ho.m43820b("AgReserveDownloadManager", "start report reserve result");
        C6971bo c6971bo = new C6971bo(this.f32324f);
        BaseAnalysisInfo baseAnalysisInfo = new BaseAnalysisInfo();
        baseAnalysisInfo.m38827ak("2100020");
        baseAnalysisInfo.m38828al(str);
        baseAnalysisInfo.m38829am(String.valueOf(i10));
        AbstractC7185ho.m43818a("AgReserveDownloadManager", "report reserve result analysis: %s", AbstractC7758be.m47742b(baseAnalysisInfo));
        C6921b c6921bM41052a = c6971bo.m41052a(baseAnalysisInfo);
        Context context = this.f32324f;
        new C7560ou(context, C7662sk.m47225a(context, c6921bM41052a.m39040t().intValue())).mo46609b(c6921bM41052a, false, false);
    }

    /* renamed from: a */
    private synchronized WeakHashMap<InterfaceC7069l, Object> m42188a(String str) {
        return this.f32325g.get(str);
    }

    /* renamed from: b */
    public synchronized void m42199b(String str, InterfaceC7069l interfaceC7069l) {
        WeakHashMap<InterfaceC7069l, Object> weakHashMap = this.f32325g.get(str);
        if (weakHashMap != null && weakHashMap.size() > 0) {
            weakHashMap.remove(interfaceC7069l);
            if (weakHashMap.size() <= 0) {
                this.f32325g.remove(str);
            }
        }
    }

    /* renamed from: a */
    private void m42189a() {
        this.f32321c = new a();
        AbstractC7741ao.m47537a(this.f32324f, this.f32321c, new IntentFilter("com.huawei.appgallery.reserveappstatus"), "com.huawei.appmarket.RECV_THIRD_COMMON_MSG", null);
        this.f32322d = new c();
        AbstractC7741ao.m47537a(this.f32324f, this.f32322d, new IntentFilter("com.huawei.hms.pps.action.APP_RESERVE_STATUS_CHANGED"), Constants.PERMISSION_PPS_DOWNLOAD, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42190a(Context context, Intent intent) {
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if ("com.huawei.hms.pps.action.APP_RESERVE_STATUS_CHANGED".equals(action) && context != null) {
                String stringExtra = safeIntent.getStringExtra("callerpackage");
                String packageName = context.getPackageName();
                if (!AbstractC7806cz.m48173e(stringExtra, packageName)) {
                    AbstractC7185ho.m43821b("AgReserveDownloadManager", "caller does not match, caller %s, currentPackage %s.", stringExtra, packageName);
                    return;
                } else if (safeIntent.getIntExtra("reserveappstatus", -1) == 0) {
                    AbstractC7185ho.m43820b("AgReserveDownloadManager", "silent reserve failed no need to notify");
                    return;
                } else {
                    m42191a(safeIntent);
                    return;
                }
            }
            AbstractC7185ho.m43824c("AgReserveDownloadManager", "reserve onReceive inValid para %s.", action);
        } catch (IllegalStateException e10) {
            AbstractC7185ho.m43824c("AgReserveDownloadManager", "silent reserve onReceive IllegalStateException: %s", e10.getClass().getSimpleName());
        } catch (Exception e11) {
            AbstractC7185ho.m43824c("AgReserveDownloadManager", "silent reserve onReceive Exception: %s", e11.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42191a(Intent intent) {
        String stringExtra = intent.getStringExtra("reserveapp");
        int intExtra = intent.getIntExtra("reserveappstatus", -1);
        AbstractC7185ho.m43821b("AgReserveDownloadManager", "reserve status: %s", Integer.valueOf(intExtra));
        if (intExtra == 1 || intExtra == 0) {
            m42195b(stringExtra, intExtra);
        }
        if (intExtra == 2) {
            intExtra = 1;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            AbstractC7185ho.m43820b("AgReserveDownloadManager", "pkg is null");
        } else {
            m42194a(stringExtra, intExtra);
        }
    }

    /* renamed from: a */
    public void m42196a(AppDownloadTask appDownloadTask) {
        C7038f.m42212d(this.f32324f, appDownloadTask, new b(), String.class);
    }

    /* renamed from: a */
    public void m42197a(InterfaceC7068k interfaceC7068k) {
        this.f32323e = interfaceC7068k;
    }

    /* renamed from: a */
    private void m42194a(String str, int i10) {
        WeakHashMap<InterfaceC7069l, Object> weakHashMapM42188a = m42188a(str);
        if (weakHashMapM42188a != null && weakHashMapM42188a.size() > 0) {
            for (InterfaceC7069l interfaceC7069l : weakHashMapM42188a.keySet()) {
                if (interfaceC7069l != null) {
                    interfaceC7069l.mo38799a(str, i10);
                }
            }
        }
        InterfaceC7068k interfaceC7068k = this.f32323e;
        if (interfaceC7068k != null) {
            interfaceC7068k.mo38799a(str, i10);
        }
    }

    /* renamed from: a */
    public synchronized void m42198a(String str, InterfaceC7069l interfaceC7069l) {
        try {
            WeakHashMap<InterfaceC7069l, Object> weakHashMap = this.f32325g.get(str);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<>();
                this.f32325g.put(str, weakHashMap);
            }
            weakHashMap.put(interfaceC7069l, null);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
