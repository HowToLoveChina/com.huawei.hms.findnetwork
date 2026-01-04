package com.huawei.hms.framework.network.grs.p122g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C5462a;
import com.huawei.hms.framework.network.grs.p120e.C5434a;
import com.huawei.hms.framework.network.grs.p120e.C5436c;
import com.huawei.hms.framework.network.grs.p121f.C5438b;
import com.huawei.hms.framework.network.grs.p122g.p123i.C5450a;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5453c;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5454d;
import com.huawei.hms.framework.network.grs.p125h.C5458d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* renamed from: com.huawei.hms.framework.network.grs.g.c */
/* loaded from: classes8.dex */
public class C5444c {

    /* renamed from: l */
    private static final String f24945l = "c";

    /* renamed from: a */
    private final GrsBaseInfo f24946a;

    /* renamed from: b */
    private final Context f24947b;

    /* renamed from: c */
    private final C5434a f24948c;

    /* renamed from: d */
    private C5445d f24949d;

    /* renamed from: i */
    private final C5453c f24954i;

    /* renamed from: e */
    private final Map<String, Future<C5445d>> f24950e = new ConcurrentHashMap(16);

    /* renamed from: f */
    private final List<C5445d> f24951f = new CopyOnWriteArrayList();

    /* renamed from: g */
    private final JSONArray f24952g = new JSONArray();

    /* renamed from: h */
    private final List<String> f24953h = new CopyOnWriteArrayList();

    /* renamed from: j */
    private String f24955j = "";

    /* renamed from: k */
    private long f24956k = 1;

    public C5444c(C5453c c5453c, C5434a c5434a) {
        this.f24954i = c5453c;
        this.f24946a = c5453c.m32310b();
        this.f24947b = c5453c.m32308a();
        this.f24948c = c5434a;
        m32249b();
        m32250c();
    }

    /* renamed from: b */
    private C5445d m32248b(C5445d c5445d) throws ExecutionException, InterruptedException, TimeoutException {
        String str;
        String str2;
        for (Map.Entry<String, Future<C5445d>> entry : this.f24950e.entrySet()) {
            if (c5445d != null && (c5445d.m32289o() || c5445d.m32287m())) {
                break;
            }
            try {
                c5445d = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                e = e10;
                str = f24945l;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.m32146w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.m32141i(f24945l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e11) {
                e = e11;
                str = f24945l;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.m32146w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.m32145w(f24945l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return c5445d;
    }

    /* renamed from: c */
    private void m32250c() {
        String grsParasKey = this.f24946a.getGrsParasKey(true, true, this.f24947b);
        this.f24955j = this.f24948c.m32190a().m32200a(grsParasKey + "ETag", "");
    }

    /* renamed from: d */
    private String m32251d() {
        C5438b c5438bM32226a = C5438b.m32226a(this.f24947b.getPackageName());
        C5462a c5462aM32228a = c5438bM32226a != null ? c5438bM32226a.m32228a() : null;
        if (c5462aM32228a == null) {
            return "";
        }
        String strM32338a = c5462aM32228a.m32338a();
        Logger.m32144v(f24945l, "get appName from local assets is{%s}", strM32338a);
        return strM32338a;
    }

    /* renamed from: a */
    public C5445d m32252a(ExecutorService executorService, String str, C5436c c5436c) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f24953h.isEmpty()) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C5445d c5445dM32246a = m32246a(executorService, this.f24953h, str, c5436c);
        Logger.m32142i(f24945l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(c5445dM32246a == null ? 0 : c5445dM32246a.m32274b()));
        C5446e.m32291a(new ArrayList(this.f24951f), SystemClock.elapsedRealtime() - jElapsedRealtime, this.f24952g, this.f24947b);
        this.f24951f.clear();
        return c5445dM32246a;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x009c A[LOOP:0: B:50:0x0005->B:83:0x009c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0094 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.framework.network.grs.p122g.C5445d m32246a(java.util.concurrent.ExecutorService r16, java.util.List<java.lang.String> r17, java.lang.String r18, com.huawei.hms.framework.network.grs.p120e.C5436c r19) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r15 = this;
            r9 = r15
            r0 = 0
            r10 = 0
            r11 = r0
            r12 = r10
        L5:
            int r0 = r17.size()
            if (r12 >= r0) goto La0
            r13 = r17
            java.lang.Object r0 = r13.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L8f
            com.huawei.hms.framework.network.grs.g.a r14 = new com.huawei.hms.framework.network.grs.g.a
            android.content.Context r5 = r9.f24947b
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.f24946a
            r1 = r14
            r2 = r0
            r3 = r12
            r4 = r15
            r6 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r1 = r14.m32244g()
            r2 = r16
            java.util.concurrent.Future r1 = r2.submit(r1)
            java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> r3 = r9.f24950e
            r3.put(r0, r1)
            r3 = 1
            long r4 = r9.f24956k     // Catch: java.lang.InterruptedException -> L6a java.util.concurrent.ExecutionException -> L6c java.util.concurrent.TimeoutException -> L6e java.util.concurrent.CancellationException -> L86
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> L6a java.util.concurrent.ExecutionException -> L6c java.util.concurrent.TimeoutException -> L6e java.util.concurrent.CancellationException -> L86
            java.lang.Object r0 = r1.get(r4, r0)     // Catch: java.lang.InterruptedException -> L6a java.util.concurrent.ExecutionException -> L6c java.util.concurrent.TimeoutException -> L6e java.util.concurrent.CancellationException -> L86
            r1 = r0
            com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.p122g.C5445d) r1     // Catch: java.lang.InterruptedException -> L6a java.util.concurrent.ExecutionException -> L6c java.util.concurrent.TimeoutException -> L6e java.util.concurrent.CancellationException -> L86
            if (r1 == 0) goto L67
            boolean r0 = r1.m32289o()     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L57 java.util.concurrent.TimeoutException -> L63 java.util.concurrent.CancellationException -> L65
            if (r0 != 0) goto L5a
            boolean r0 = r1.m32287m()     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L57 java.util.concurrent.TimeoutException -> L63 java.util.concurrent.CancellationException -> L65
            if (r0 == 0) goto L67
            goto L5a
        L54:
            r0 = move-exception
            r11 = r1
            goto L76
        L57:
            r0 = move-exception
            r11 = r1
            goto L7e
        L5a:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p122g.C5444c.f24945l     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L57 java.util.concurrent.TimeoutException -> L63 java.util.concurrent.CancellationException -> L65
            java.lang.String r4 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.m32141i(r0, r4)     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L57 java.util.concurrent.TimeoutException -> L63 java.util.concurrent.CancellationException -> L65
            r11 = r1
            goto L92
        L63:
            r11 = r1
            goto L6e
        L65:
            r11 = r1
            goto L86
        L67:
            r11 = r1
        L68:
            r3 = r10
            goto L92
        L6a:
            r0 = move-exception
            goto L76
        L6c:
            r0 = move-exception
            goto L7e
        L6e:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p122g.C5444c.f24945l
            java.lang.String r1 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.m32145w(r0, r1)
            goto L68
        L76:
            java.lang.String r1 = com.huawei.hms.framework.network.grs.p122g.C5444c.f24945l
            java.lang.String r4 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.m32146w(r1, r4, r0)
            goto L92
        L7e:
            java.lang.String r1 = com.huawei.hms.framework.network.grs.p122g.C5444c.f24945l
            java.lang.String r3 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.m32146w(r1, r3, r0)
            goto L68
        L86:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p122g.C5444c.f24945l
            java.lang.String r1 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.m32141i(r0, r1)
            goto L92
        L8f:
            r2 = r16
            goto L68
        L92:
            if (r3 == 0) goto L9c
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p122g.C5444c.f24945l
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.m32143v(r0, r1)
            goto La0
        L9c:
            int r12 = r12 + 1
            goto L5
        La0:
            com.huawei.hms.framework.network.grs.g.d r0 = r15.m32248b(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p122g.C5444c.m32246a(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    /* renamed from: b */
    private void m32249b() {
        C5454d c5454dM32303a = C5450a.m32303a(this.f24947b);
        if (c5454dM32303a == null) {
            Logger.m32145w(f24945l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        m32255a(c5454dM32303a);
        List<String> listM32313a = c5454dM32303a.m32313a();
        if (listM32313a == null || listM32313a.size() <= 0) {
            Logger.m32143v(f24945l, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (listM32313a.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String strM32317b = c5454dM32303a.m32317b();
        if (listM32313a.size() > 0) {
            for (String str : listM32313a) {
                if (str.startsWith("https://")) {
                    m32247a(strM32317b, str);
                } else {
                    Logger.m32145w(f24945l, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.m32144v(f24945l, "request to GRS server url is {%s}", this.f24953h);
    }

    /* renamed from: a */
    public String m32253a() {
        return this.f24955j;
    }

    /* renamed from: a */
    public synchronized void m32254a(C5445d c5445d) {
        try {
            this.f24951f.add(c5445d);
            C5445d c5445d2 = this.f24949d;
            if (c5445d2 == null || (!c5445d2.m32289o() && !this.f24949d.m32287m())) {
                if (c5445d.m32288n()) {
                    Logger.m32141i(f24945l, "GRS server open 503 limiting strategy.");
                    C5458d.m32329a(this.f24946a.getGrsParasKey(true, true, this.f24947b), new C5458d.a(c5445d.m32285k(), SystemClock.elapsedRealtime()));
                    return;
                }
                if (c5445d.m32287m()) {
                    Logger.m32141i(f24945l, "GRS server open 304 Not Modified.");
                }
                if (!c5445d.m32289o() && !c5445d.m32287m()) {
                    Logger.m32143v(f24945l, "grsResponseResult has exception so need return");
                    return;
                }
                this.f24949d = c5445d;
                this.f24948c.m32193a(this.f24946a, c5445d, this.f24947b, this.f24954i);
                for (Map.Entry<String, Future<C5445d>> entry : this.f24950e.entrySet()) {
                    if (!entry.getKey().equals(c5445d.m32286l()) && !entry.getValue().isCancelled()) {
                        Logger.m32141i(f24945l, "future cancel");
                        entry.getValue().cancel(true);
                    }
                }
                return;
            }
            Logger.m32143v(f24945l, "grsResponseResult is ok");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public void m32255a(C5454d c5454d) {
    }

    /* renamed from: a */
    private void m32247a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        String grsReqParamJoint = this.f24946a.getGrsReqParamJoint(false, false, m32251d(), this.f24947b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb2.append(Constants.QUESTION_STR);
            sb2.append(grsReqParamJoint);
        }
        this.f24953h.add(sb2.toString());
    }
}
