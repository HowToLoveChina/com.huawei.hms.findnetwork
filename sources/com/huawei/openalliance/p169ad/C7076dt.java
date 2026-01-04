package com.huawei.openalliance.p169ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7077du;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.C7059b;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.exception.C7110b;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7801cu;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.openalliance.ad.dt */
/* loaded from: classes8.dex */
public class C7076dt extends C7059b<C7077du> {

    /* renamed from: f */
    private static C7076dt f32583f;

    /* renamed from: g */
    private static final byte[] f32584g = new byte[0];

    /* renamed from: h */
    private C7075ds f32585h;

    /* renamed from: i */
    private C7022dk f32586i;

    /* renamed from: j */
    private a f32587j;

    /* renamed from: k */
    private BroadcastReceiver f32588k;

    /* renamed from: com.huawei.openalliance.ad.dt$a */
    public class a {

        /* renamed from: b */
        private final Context f32597b;

        /* renamed from: c */
        private ConnectivityManager.NetworkCallback f32598c = new ConnectivityManager.NetworkCallback() { // from class: com.huawei.openalliance.ad.dt.a.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                final Context applicationContext = a.this.f32597b.getApplicationContext();
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("VideoDownloadManager", "net onAvailable, active netType: %s, [0:UNKNOWN, 1:ETHERNET, 2:WIFI, 4/5/6/7:2G/3G/4G/5G]", Integer.valueOf(C7775bv.m47830d(applicationContext)));
                }
                if (C7124fh.m43316b(applicationContext).mo43345aL()) {
                    AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.dt.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (C7775bv.m47831e(applicationContext) && C7775bv.m47829c(applicationContext)) {
                                C7076dt.this.m42687j();
                            } else {
                                if (C7775bv.m47831e(applicationContext) && C7775bv.m47829c(applicationContext)) {
                                    return;
                                }
                                C7076dt.this.m42681a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            }
                        }
                    });
                } else {
                    AbstractC7185ho.m43820b("VideoDownloadManager", "user info is not enabled");
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                final Context applicationContext = a.this.f32597b.getApplicationContext();
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("VideoDownloadManager", "net onLost, active netType: %s, [0:UNKNOWN, 1:ETHERNET, 2:WIFI, 4/5/6/7:2G/3G/4G/5G]", Integer.valueOf(C7775bv.m47830d(applicationContext)));
                }
                if (C7124fh.m43316b(applicationContext).mo43345aL()) {
                    AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.dt.a.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (C7775bv.m47831e(applicationContext) && C7775bv.m47829c(applicationContext)) {
                                C7076dt.this.m42687j();
                            } else {
                                if (C7775bv.m47831e(applicationContext) && C7775bv.m47829c(applicationContext)) {
                                    return;
                                }
                                C7076dt.this.m42681a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            }
                        }
                    });
                } else {
                    AbstractC7185ho.m43820b("VideoDownloadManager", "user info is not enabled");
                }
            }
        };

        public a(Context context) {
            this.f32597b = context;
        }

        /* renamed from: a */
        public void m42690a() {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f32597b.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0).addTransportType(3).addTransportType(1);
                connectivityManager.registerNetworkCallback(builder.build(), this.f32598c);
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("VideoDownloadManager", "register all network callback exception.");
            }
        }
    }

    private C7076dt(final Context context) {
        String str;
        super(context);
        this.f32588k = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.dt.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("VideoDownloadManager", "networkReceiver.onReceive, action: %s", intent.getAction());
                }
                final Context applicationContext = context2.getApplicationContext();
                if (C7124fh.m43316b(applicationContext).mo43345aL()) {
                    AbstractC7834m.m48487g(new Runnable() { // from class: com.huawei.openalliance.ad.dt.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!C7775bv.m47831e(applicationContext) || !C7775bv.m47829c(applicationContext)) {
                                C7076dt.this.m42681a(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            } else if (C7775bv.m47829c(applicationContext)) {
                                C7076dt.this.m42685b(DownloadTask.EnumC7031c.NETWORK_CHANGED);
                            }
                        }
                    });
                } else {
                    AbstractC7185ho.m43820b("VideoDownloadManager", "user info is not enabled");
                }
            }
        };
        try {
            super.m42551a();
            C7075ds c7075ds = new C7075ds(context);
            this.f32585h = c7075ds;
            super.m42555a(c7075ds);
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.dt.1
                @Override // java.lang.Runnable
                public void run() {
                    ((C7059b) C7076dt.this).f32506b = C7076dt.m42676c(context);
                }
            });
            a aVar = new a(this.f32505a);
            this.f32587j = aVar;
            aVar.m42690a();
            this.f32586i = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        } catch (IllegalStateException unused) {
            str = "initialize IllegalStateException";
            AbstractC7185ho.m43823c("VideoDownloadManager", str);
        } catch (Exception unused2) {
            str = "initialize exception";
            AbstractC7185ho.m43823c("VideoDownloadManager", str);
        }
    }

    /* renamed from: b */
    private C7077du m42672b(String str, int i10, boolean z10, String str2, String str3, String str4) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C7077du c7077duM42667a = m42667a(str, i10, z10, str2, str3, str4);
        String strM41968c = this.f32586i.m41968c(c7077duM42667a.m42068d());
        File file2 = strM41968c != null ? new File(strM41968c) : null;
        if (file2 == null || !file2.exists()) {
            File file3 = new File(c7077duM42667a.m42071e());
            if (!file3.exists()) {
                return c7077duM42667a;
            }
            file = file3;
        } else {
            file = file2;
        }
        return m42666a(c7077duM42667a, i10, z10, str2, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static String m42676c(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AbstractC7731ae.m47469h(cacheDir));
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str);
        sb2.append("placement");
        return sb2.toString();
    }

    /* renamed from: h */
    public static C7076dt m42678h() {
        C7076dt c7076dt;
        synchronized (f32584g) {
            try {
                c7076dt = f32583f;
                if (c7076dt == null) {
                    throw new C7110b("VideoDownloadManager inst is not initialize!");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7076dt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m42679k() {
        String str;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f32506b);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("tmp");
            sb2.append(str2);
            String string = sb2.toString();
            String[] list = new File(string).list();
            if (list != null && list.length > 0) {
                m42670a(string, list);
            }
        } catch (IllegalStateException unused) {
            str = "deleteTimeoutFile IllegalStateException";
            AbstractC7185ho.m43823c("VideoDownloadManager", str);
        } catch (Exception unused2) {
            str = "deleteTimeoutFile exception";
            AbstractC7185ho.m43823c("VideoDownloadManager", str);
        }
    }

    /* renamed from: i */
    public void m42686i() {
        m42681a(DownloadTask.EnumC7031c.HW_VIDEO);
    }

    /* renamed from: j */
    public void m42687j() {
        List<C7077du> listM42588c = this.f32509e.m42588c();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VideoDownloadManager", "resumeAllTask, task.size: %d", Integer.valueOf(listM42588c.size()));
        }
        if (listM42588c.size() <= 0) {
            return;
        }
        m42671a(listM42588c);
    }

    /* renamed from: a */
    private ContentResource m42665a(C7074dr c7074dr, C7077du c7077du) {
        if (c7077du == null || TextUtils.isEmpty(c7077du.m42691B())) {
            return null;
        }
        ContentResource contentResource = new ContentResource();
        contentResource.m41622a(c7077du.m42696G());
        Integer numM42650m = c7074dr.m42650m();
        if (numM42650m == null) {
            numM42650m = Integer.valueOf(C7021dj.m41949a(c7077du.m42696G()));
        }
        contentResource.m41626b(numM42650m.intValue());
        contentResource.m41630c(c7077du.m42691B());
        contentResource.m41627b(c7077du.m42692C());
        contentResource.m41624a(c7077du.mo42082n());
        contentResource.m41629c(!c7074dr.m42648k() ? 1 : 0);
        contentResource.m41632d(c7074dr.m42648k() ? 3 : 2);
        return contentResource;
    }

    /* renamed from: c */
    private static String m42677c(String str) {
        int iIndexOf = str.indexOf(".tmp");
        if (iIndexOf > 0) {
            return str.substring(0, iIndexOf);
        }
        return null;
    }

    /* renamed from: a */
    public C7077du m42680a(C7074dr c7074dr) {
        if (TextUtils.isEmpty(c7074dr.m42637a())) {
            AbstractC7185ho.m43823c("VideoDownloadManager", "downloadVideo - empty video url");
            return null;
        }
        m42556a(c7074dr.m42642e());
        C7077du c7077duMo42385a = mo42385a(AbstractC7801cu.m48126a(c7074dr.m42637a()));
        C7077du c7077duM42672b = c7077duMo42385a instanceof C7077du ? c7077duMo42385a : null;
        if (c7077duM42672b == null) {
            c7077duM42672b = m42672b(c7074dr.m42637a(), c7074dr.m42639b(), c7074dr.m42640c(), c7074dr.m42641d(), c7074dr.m42645h(), c7074dr.m42646i());
            if (c7077duM42672b == null) {
                return null;
            }
            m42674b(c7074dr, c7077duM42672b);
            if (c7077duM42672b.m42080l() >= 100) {
                C7105eu.m43130a(this.f32505a).m43134a(m42665a(c7074dr, c7077duM42672b), Constants.NORMAL_CACHE);
                Integer numM42650m = c7074dr.m42650m();
                if (numM42650m == null) {
                    numM42650m = Integer.valueOf(C7021dj.m41949a(c7077duM42672b.m42696G()));
                }
                this.f32586i.m41960a(c7077duM42672b.m42068d(), numM42650m.intValue());
                m42572h(c7077duM42672b);
            } else {
                mo42403c(c7077duM42672b);
            }
        } else {
            AbstractC7185ho.m43821b("VideoDownloadManager", "downloadVideo - task %s is already in queue, resume it", AbstractC7819dl.m48375a(c7077duMo42385a.mo42082n()));
            m42674b(c7074dr, c7077duM42672b);
            mo42393a((C7076dt) c7077duM42672b, false);
        }
        c7077duM42672b.m42046a(c7074dr.m42644g());
        c7077duM42672b.m42702e(c7074dr.m42649l());
        return c7077duM42672b;
    }

    /* renamed from: b */
    public String m42684b(String str) {
        if (TextUtils.isEmpty(this.f32506b)) {
            this.f32506b = (String) AbstractC7810dc.m48272b(new Callable<String>() { // from class: com.huawei.openalliance.ad.dt.2
                @Override // java.util.concurrent.Callable
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return C7076dt.m42676c(((C7059b) C7076dt.this).f32505a);
                }
            });
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f32506b);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("tmp");
        sb2.append(str2);
        sb2.append(str);
        sb2.append(".tmp");
        return sb2.toString();
    }

    /* renamed from: a */
    private C7077du m42666a(C7077du c7077du, int i10, boolean z10, String str, File file) {
        long length = file.length();
        c7077du.m42060b(length);
        long j10 = i10;
        if (length == j10 || i10 == 0) {
            if (!z10 || AbstractC7731ae.m47452a(str, file)) {
                c7077du.m42059b(100);
                c7077du.m42054a(EnumC7062e.DOWNLOADED);
            } else {
                c7077du.m42060b(0L);
                c7077du.m42059b(0);
                AbstractC7731ae.m47466e(file);
            }
        } else if (length < j10) {
            c7077du.m42059b((int) ((length * 100) / j10));
        } else {
            AbstractC7731ae.m47466e(file);
            c7077du.m42059b(0);
            c7077du.m42060b(0L);
        }
        return c7077du;
    }

    /* renamed from: b */
    public void m42685b(DownloadTask.EnumC7031c enumC7031c) {
        List<C7077du> listM42588c = this.f32509e.m42588c();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VideoDownloadManager", "resumeAllTask, task.size: %d", Integer.valueOf(listM42588c.size()));
        }
        if (listM42588c.size() <= 0) {
            return;
        }
        Collections.sort(listM42588c);
        for (C7077du c7077du : listM42588c) {
            if (c7077du.m42084p() == enumC7031c) {
                mo42393a((C7076dt) c7077du, false);
            }
        }
    }

    /* renamed from: a */
    public static C7077du m42667a(String str, int i10, boolean z10, String str2, String str3, String str4) {
        C7077du c7077duM42711a = new C7077du.a().m42710a(true).m42709a(str).m42708a(i10).m42712b(str2).m42713c(str3).m42714d(str4).m42711a();
        c7077duM42711a.m42070d(z10);
        return c7077duM42711a;
    }

    /* renamed from: b */
    private void m42674b(C7074dr c7074dr, C7077du c7077du) {
        c7077du.m42057a(c7074dr.m42643f());
        c7077du.m42701d(c7074dr.m42647j());
        c7077du.m42050a(m42665a(c7074dr, c7077du));
    }

    /* renamed from: a */
    public static void m42669a(Context context) {
        synchronized (f32584g) {
            try {
                if (f32583f == null) {
                    f32583f = new C7076dt(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m42681a(DownloadTask.EnumC7031c enumC7031c) {
        List listM42590d = this.f32509e.m42590d();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VideoDownloadManager", "pauseAllTask.begin, task.size: %d", Integer.valueOf(listM42590d.size()));
        }
        Iterator it = listM42590d.iterator();
        while (it.hasNext()) {
            m42554a((C7076dt) it.next(), enumC7031c);
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VideoDownloadManager", "pauseAllTask.end, task.size: %d", Integer.valueOf(listM42590d.size()));
        }
    }

    /* renamed from: a */
    private void m42670a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str2.endsWith(".tmp")) {
                File file = new File(str + str2);
                if (!file.isDirectory() && System.currentTimeMillis() - file.lastModified() > 172800000) {
                    AbstractC7185ho.m43820b("VideoDownloadManager", "remove timeout file");
                    C7077du c7077duMo42385a = mo42385a(m42677c(str2));
                    if (c7077duMo42385a == null || !(c7077duMo42385a instanceof C7077du)) {
                        AbstractC7731ae.m47466e(file);
                    } else {
                        m42683a(c7077duMo42385a, true);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m42671a(List<C7077du> list) {
        Collections.sort(list);
        for (C7077du c7077du : list) {
            DownloadTask.EnumC7031c enumC7031cM42084p = c7077du.m42084p();
            if (enumC7031cM42084p == DownloadTask.EnumC7031c.NETWORK_CHANGED || enumC7031cM42084p == DownloadTask.EnumC7031c.HW_VIDEO) {
                mo42393a((C7076dt) c7077du, false);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.download.C7059b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo42403c(C7077du c7077du) {
        if (c7077du == null) {
            AbstractC7185ho.m43823c("VideoDownloadManager", "cannot add task, task is null");
            return false;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VideoDownloadManager", "addTask, taskid: %s", AbstractC7819dl.m48375a(c7077du.mo42082n()));
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.dt.3
            @Override // java.lang.Runnable
            public void run() {
                C7076dt.this.m42679k();
            }
        });
        return super.mo42403c((C7076dt) c7077du);
    }

    /* renamed from: a */
    public boolean m42683a(C7077du c7077du, boolean z10) {
        return m42557a(c7077du, false, z10, true);
    }
}
