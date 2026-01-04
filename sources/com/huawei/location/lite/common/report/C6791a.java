package com.huawei.location.lite.common.report;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.location.lite.common.adapter.LocationTrackerAdapter;
import es.C9538c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mr.C11506a;
import p531or.C11991a;
import sr.C12847b;

/* renamed from: com.huawei.location.lite.common.report.a */
/* loaded from: classes8.dex */
public class C6791a {

    /* renamed from: f */
    public static volatile C6791a f31380f;

    /* renamed from: g */
    public static final byte[] f31381g = new byte[0];

    /* renamed from: a */
    public AtomicBoolean f31382a = new AtomicBoolean(false);

    /* renamed from: b */
    public final Map<String, LinkedHashMap> f31383b = new HashMap(16, 0.85f);

    /* renamed from: c */
    public final Map<String, LinkedHashMap> f31384c = new HashMap(16, 0.85f);

    /* renamed from: d */
    public volatile boolean f31385d = false;

    /* renamed from: e */
    public a f31386e;

    /* renamed from: com.huawei.location.lite.common.report.a$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                C6791a.this.m38465j();
            } else {
                C1016d.m6181a("LocationTracker", "handleMessage case 1, begin to report");
                C6791a.this.m38469n();
                C6791a.this.f31385d = false;
            }
        }
    }

    public C6791a() {
        HandlerThread handlerThread = new HandlerThread("Location-Full-LocationTracker");
        handlerThread.start();
        this.f31386e = new a(handlerThread.getLooper());
        C1016d.m6186f("LocationTracker", "LocationTracker init");
    }

    /* renamed from: h */
    public static C6791a m38458h() {
        if (f31380f == null) {
            synchronized (f31381g) {
                try {
                    if (f31380f == null) {
                        f31380f = new C6791a();
                    }
                } finally {
                }
            }
        }
        return f31380f;
    }

    /* renamed from: c */
    public final boolean m38459c(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.f31382a.get()) {
            return false;
        }
        C1016d.m6181a("LocationTracker", "checkUninitializedAnalytics not initialized");
        if (i10 == 0) {
            synchronized (this.f31384c) {
                try {
                    if (this.f31384c.size() > 100) {
                        this.f31384c.clear();
                        C1016d.m6181a("LocationTracker", "out of size clear cache");
                    }
                    this.f31384c.put(m38463g(str, i10), linkedHashMap);
                } finally {
                }
            }
        } else if (1 == i10) {
            synchronized (this.f31383b) {
                try {
                    if (this.f31383b.size() > 100) {
                        this.f31383b.clear();
                        C1016d.m6181a("LocationTracker", "out of size clear cache");
                    }
                    this.f31383b.put(m38463g(str, i10), linkedHashMap);
                } finally {
                }
            }
        } else {
            C1016d.m6181a("LocationTracker", "onEvent type =" + i10);
        }
        m38464i();
        return true;
    }

    /* renamed from: d */
    public final String m38460d(String str) {
        return TextUtils.isEmpty(str) ? str : str.split("\\|")[0];
    }

    /* renamed from: e */
    public final String m38461e(String str) {
        return TextUtils.isEmpty(str) ? str : str.split("\\|")[1];
    }

    /* renamed from: f */
    public final void m38462f() {
        a aVar;
        if (this.f31385d || (aVar = this.f31386e) == null) {
            return;
        }
        aVar.sendEmptyMessageDelayed(1, C5863b6.g.f26453g);
        this.f31385d = true;
    }

    /* renamed from: g */
    public final String m38463g(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "|" + i10 + "|" + UUID.randomUUID().toString();
    }

    /* renamed from: i */
    public void m38464i() {
        if (this.f31382a.get()) {
            return;
        }
        this.f31386e.sendEmptyMessage(2);
    }

    /* renamed from: j */
    public final void m38465j() {
        if (this.f31382a.get()) {
            return;
        }
        if (C9538c.m59572k()) {
            C1016d.m6190j("LocationTracker", "not support device,not init");
            this.f31382a.set(true);
            return;
        }
        String strM77150e = C12847b.m77150e(GrsApp.getInstance().getIssueCountryCode(C11991a.m72145a()), "HIANALYTICROUTE");
        C1016d.m6181a("LocationTracker", "hiAnalyticsUrl:" + strM77150e);
        if (TextUtils.isEmpty(strM77150e)) {
            C1016d.m6186f("LocationTracker", "initHiAnalytics  hiAnalyticsUrl is empty.");
            this.f31382a.set(false);
            return;
        }
        C1016d.m6186f("LocationTracker", "initHiAnalytics begin.");
        HmsHiAnalyticsUtils.init(C11991a.m72145a(), false, false, false, strM77150e, C11506a.m68682e().m68686d());
        if (HmsHiAnalyticsUtils.getInitFlag()) {
            this.f31382a.set(true);
        }
        m38470o();
    }

    /* renamed from: k */
    public synchronized void m38466k(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (LocationTrackerAdapter.isLocationTrackerEnable()) {
            if (C9538c.m59572k()) {
                C1016d.m6190j("LocationTracker", "not support device,not event");
                return;
            }
            if (m38459c(i10, str, linkedHashMap)) {
                return;
            }
            if (!HmsHiAnalyticsUtils.getInitFlag()) {
                C1016d.m6181a("LocationTracker", "onEvent HA init is false");
            } else {
                C1016d.m6181a("LocationTracker", "analyticsInstance.onEvent");
                HmsHiAnalyticsUtils.onEvent(i10, str, linkedHashMap);
            }
        }
    }

    /* renamed from: l */
    public void m38467l(ReportBuilder reportBuilder) {
        C1016d.m6186f("LocationTracker", "onMaintEvent:" + reportBuilder.build().toString());
        m38466k(1, reportBuilder.getEventId(), reportBuilder.build());
        m38462f();
    }

    /* renamed from: m */
    public void m38468m(ReportBuilder reportBuilder) {
        m38466k(0, reportBuilder.getEventId(), reportBuilder.build());
    }

    /* renamed from: n */
    public void m38469n() {
        if (LocationTrackerAdapter.isLocationTrackerEnable()) {
            if (C9538c.m59572k()) {
                C1016d.m6190j("LocationTracker", "not support device,not onReport");
            } else if (HmsHiAnalyticsUtils.getInitFlag()) {
                C1016d.m6181a("LocationTracker", "analyticsInstance.onReport");
                HmsHiAnalyticsUtils.onReport();
            }
        }
    }

    /* renamed from: o */
    public final void m38470o() {
        m38471p(this.f31384c);
        m38471p(this.f31383b);
    }

    /* renamed from: p */
    public final void m38471p(Map<String, LinkedHashMap> map) {
        synchronized (map) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, LinkedHashMap> entry : map.entrySet()) {
                        if (TextUtils.isEmpty(entry.getKey())) {
                            C1016d.m6183c("LocationTracker", "mapEntry.getKey() == null");
                        } else {
                            m38466k(Integer.parseInt(m38461e(entry.getKey())), m38460d(entry.getKey()), entry.getValue());
                        }
                    }
                    map.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
