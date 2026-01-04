package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.p120e.C5434a;
import com.huawei.hms.framework.network.grs.p120e.C5436c;
import com.huawei.hms.framework.network.grs.p121f.C5438b;
import com.huawei.hms.framework.network.grs.p122g.C5448g;
import com.huawei.hms.framework.network.grs.p122g.C5449h;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5453c;
import com.huawei.hms.framework.network.grs.p125h.C5455a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.framework.network.grs.c */
/* loaded from: classes8.dex */
public class C5431c {

    /* renamed from: i */
    private static final String f24895i = "c";

    /* renamed from: j */
    private static final ExecutorService f24896j = ExecutorsUtils.newSingleThreadExecutor("GrsInit");

    /* renamed from: k */
    private static long f24897k = 0;

    /* renamed from: a */
    private GrsBaseInfo f24898a;

    /* renamed from: b */
    private Context f24899b;

    /* renamed from: c */
    private C5448g f24900c;

    /* renamed from: d */
    private C5434a f24901d;

    /* renamed from: e */
    private C5436c f24902e;

    /* renamed from: f */
    private C5436c f24903f;

    /* renamed from: g */
    private C5429a f24904g;

    /* renamed from: h */
    private FutureTask<Boolean> f24905h;

    /* renamed from: com.huawei.hms.framework.network.grs.c$a */
    public class a implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ Context f24906a;

        /* renamed from: b */
        final /* synthetic */ GrsBaseInfo f24907b;

        /* renamed from: com.huawei.hms.framework.network.grs.c$a$a, reason: collision with other inner class name */
        public class RunnableC14439a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C5438b f24909a;

            /* renamed from: b */
            final /* synthetic */ C5436c f24910b;

            public RunnableC14439a(C5438b c5438b, C5436c c5436c) {
                this.f24909a = c5438b;
                this.f24910b = c5436c;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f24909a.m32231a(a.this.f24906a.getPackageName(), this.f24910b);
            }
        }

        public a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f24906a = context;
            this.f24907b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws NumberFormatException {
            C5431c.this.f24900c = new C5448g();
            C5431c.this.f24902e = new C5436c(this.f24906a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            C5431c.this.f24903f = new C5436c(this.f24906a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            C5431c c5431c = C5431c.this;
            c5431c.f24901d = new C5434a(c5431c.f24902e, C5431c.this.f24903f, C5431c.this.f24900c);
            C5431c c5431c2 = C5431c.this;
            c5431c2.f24904g = new C5429a(c5431c2.f24898a, C5431c.this.f24901d, C5431c.this.f24900c, C5431c.this.f24903f);
            if (C5438b.m32226a(this.f24906a.getPackageName()) == null) {
                C5436c c5436c = new C5436c(this.f24906a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_local_conf_");
                String strM32200a = c5436c.m32200a(this.f24906a.getPackageName() + "#localConfig", "");
                if (TextUtils.isEmpty(strM32200a) || !new C5438b().m32232a(this.f24906a, strM32200a)) {
                    C5431c.f24896j.execute(new RunnableC14439a(new C5438b(this.f24906a, true), c5436c));
                }
            }
            String strM32311c = new C5453c(this.f24907b, this.f24906a).m32311c();
            Logger.m32143v(C5431c.f24895i, "scan serviceSet is: " + strM32311c);
            String strM32200a2 = C5431c.this.f24903f.m32200a("services", "");
            String strM32301a = C5449h.m32301a(strM32200a2, strM32311c);
            if (!TextUtils.isEmpty(strM32301a)) {
                C5431c.this.f24903f.m32204b("services", strM32301a);
                Logger.m32141i(C5431c.f24895i, "postList is:" + StringUtils.anonymizeMessage(strM32301a));
                Logger.m32136d(C5431c.f24895i, "currentServices:" + StringUtils.anonymizeMessage(strM32200a2));
                if (!strM32301a.equals(strM32200a2)) {
                    C5431c.this.f24900c.m32300a(C5431c.this.f24898a.getGrsParasKey(true, true, this.f24906a));
                    C5431c.this.f24900c.m32299a(new C5453c(this.f24907b, this.f24906a), null, null, C5431c.this.f24903f, C5431c.this.f24898a.getQueryTimeout());
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - C5431c.f24897k;
            if (C5431c.f24897k == 0 || TimeUnit.MILLISECONDS.toHours(jElapsedRealtime) > 24) {
                Logger.m32141i(C5431c.f24895i, "Try to clear unUsed sp data.");
                long unused = C5431c.f24897k = SystemClock.elapsedRealtime();
                C5431c c5431c3 = C5431c.this;
                c5431c3.m32169a(c5431c3.f24902e.m32201a());
            }
            C5431c.this.f24901d.m32195b(this.f24907b, this.f24906a);
            return Boolean.TRUE;
        }
    }

    public C5431c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f24905h = null;
        String str = f24895i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GrsClientImpl context pkg:");
        sb2.append(context == null ? "" : context.getPackageName());
        Logger.m32141i(str, sb2.toString());
        this.f24899b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        m32167a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f24898a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.f24899b, grsBaseInfo2));
        this.f24905h = futureTask;
        f24896j.execute(futureTask);
        Logger.m32142i(str, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", C5455a.m32319a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    /* renamed from: f */
    private boolean m32179f() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f24905h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e10) {
            e = e10;
            str = f24895i;
            str2 = "init compute task interrupted.";
            Logger.m32146w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.m32141i(f24895i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e11) {
            e = e11;
            str = f24895i;
            str2 = "init compute task failed.";
            Logger.m32146w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.m32145w(f24895i, "init compute task timed out");
            return false;
        } catch (Exception e12) {
            e = e12;
            str = f24895i;
            str2 = "init compute task occur unknown Exception";
            Logger.m32146w(str, str2, e);
            return false;
        }
    }

    public C5431c(GrsBaseInfo grsBaseInfo) {
        this.f24905h = null;
        m32167a(grsBaseInfo);
    }

    /* renamed from: b */
    public boolean m32186b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!m32179f() || (grsBaseInfo = this.f24898a) == null || (context = this.f24899b) == null) {
            return false;
        }
        this.f24901d.m32192a(grsBaseInfo, context);
        return true;
    }

    /* renamed from: b */
    private boolean m32172b(long j10) {
        return System.currentTimeMillis() - j10 <= 604800000;
    }

    /* renamed from: a */
    public String m32180a(String str, String str2, int i10) {
        if (this.f24898a == null || str == null || str2 == null) {
            Logger.m32145w(f24895i, "invalid para!");
            return null;
        }
        if (m32179f()) {
            return this.f24904g.m32155a(str, str2, this.f24899b, i10);
        }
        return null;
    }

    /* renamed from: a */
    public Map<String, String> m32181a(String str, int i10) {
        if (this.f24898a != null && str != null) {
            return m32179f() ? this.f24904g.m32156a(str, this.f24899b, i10) : new HashMap();
        }
        Logger.m32145w(f24895i, "invalid para!");
        return new HashMap();
    }

    /* renamed from: a */
    public void m32182a() {
        if (m32179f()) {
            String grsParasKey = this.f24898a.getGrsParasKey(true, true, this.f24899b);
            this.f24902e.m32202a(grsParasKey);
            this.f24902e.m32202a(grsParasKey + "time");
            this.f24902e.m32202a(grsParasKey + "ETag");
            this.f24900c.m32300a(grsParasKey);
        }
    }

    /* renamed from: a */
    private void m32167a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f24898a = grsBaseInfo.m85649clone();
        } catch (CloneNotSupportedException e10) {
            Logger.m32146w(f24895i, "GrsClient catch CloneNotSupportedException", e10);
            this.f24898a = grsBaseInfo.copy();
        }
    }

    /* renamed from: a */
    public void m32183a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i10) {
        if (iQueryUrlsCallBack == null) {
            Logger.m32145w(f24895i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f24898a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (m32179f()) {
            this.f24904g.m32157a(str, iQueryUrlsCallBack, this.f24899b, i10);
        } else {
            Logger.m32141i(f24895i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    /* renamed from: a */
    public void m32184a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i10) {
        if (iQueryUrlCallBack == null) {
            Logger.m32145w(f24895i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f24898a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (m32179f()) {
            this.f24904g.m32158a(str, str2, iQueryUrlCallBack, this.f24899b, i10);
        } else {
            Logger.m32141i(f24895i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m32169a(Map<String, ?> map) throws NumberFormatException {
        if (map == null || map.isEmpty()) {
            Logger.m32143v(f24895i, "sp's content is empty.");
            return;
        }
        Set<String> setKeySet = map.keySet();
        for (String str : setKeySet) {
            if (str.endsWith(this.f24899b.getPackageName() + "time")) {
                String strM32200a = this.f24902e.m32200a(str, "");
                long j10 = 0;
                if (!TextUtils.isEmpty(strM32200a) && strM32200a.matches("\\d+")) {
                    try {
                        j10 = Long.parseLong(strM32200a);
                    } catch (NumberFormatException e10) {
                        Logger.m32146w(f24895i, "convert expire time from String to Long catch NumberFormatException.", e10);
                    }
                }
                String strSubstring = str.substring(0, str.length() - 4);
                String str2 = strSubstring + "ETag";
                if (!m32172b(j10) || !setKeySet.contains(strSubstring) || !setKeySet.contains(str2)) {
                    Logger.m32141i(f24895i, "init interface auto clear some invalid sp's data: " + str);
                    this.f24902e.m32202a(strSubstring);
                    this.f24902e.m32202a(str);
                    this.f24902e.m32202a(str2);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m32185a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C5431c.class == obj.getClass() && (obj instanceof C5431c)) {
            return this.f24898a.compare(((C5431c) obj).f24898a);
        }
        return false;
    }
}
