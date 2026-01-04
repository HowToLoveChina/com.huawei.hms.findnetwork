package p052cb;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: cb.b */
/* loaded from: classes3.dex */
public final class C1405b {

    /* renamed from: c */
    public static C1405b f6026c = new C1405b();

    /* renamed from: d */
    public static Map<String, Long> f6027d = new HashMap();

    /* renamed from: a */
    public final AtomicBoolean f6028a = new AtomicBoolean(false);

    /* renamed from: b */
    public Application.ActivityLifecycleCallbacks f6029b = null;

    /* renamed from: e */
    public static C1405b m8109e() {
        return f6026c;
    }

    /* renamed from: b */
    public final void m8110b(String str) {
        if (m8113f(str)) {
            return;
        }
        C11839m.m70688i("AnrDetector", "doReport anr question");
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07049"), "07049", "");
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66635A(str);
        if (!TextUtils.isEmpty(C13452e.m80781L().m80971t0())) {
            c11060cM66626a.m66644J(C13452e.m80781L().m80971t0());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("errorReason", str);
        BaseLogger.appendFeedBack("AnrDetector", str);
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: c */
    public Application.ActivityLifecycleCallbacks m8111c() {
        if (this.f6029b == null) {
            this.f6029b = new C1406c();
        }
        return this.f6029b;
    }

    /* renamed from: d */
    public void m8112d(Context context) {
        if (!C0209d.m1309t1(context)) {
            C11839m.m70688i("AnrDetector", "not main process,do not init detector");
        } else if (!this.f6028a.compareAndSet(false, true)) {
            C11839m.m70689w("AnrDetector", "already initialized");
        } else {
            C11839m.m70688i("AnrDetector", "init");
            C1408e.m8126i().m8134n(new Consumer() { // from class: cb.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f6025a.m8114g((String) obj);
                }
            });
        }
    }

    /* renamed from: f */
    public final boolean m8113f(String str) {
        Long l10 = f6027d.get(str);
        if (l10 == null) {
            f6027d.put(str, Long.valueOf(System.currentTimeMillis()));
            return false;
        }
        if (System.currentTimeMillis() - l10.longValue() < 43200000) {
            C11839m.m70689w("AnrDetector", "exception not report in interval");
            return true;
        }
        f6027d.put(str, Long.valueOf(System.currentTimeMillis()));
        return false;
    }

    /* renamed from: g */
    public final void m8114g(String str) {
        if (str == null) {
            C11839m.m70687e("AnrDetector", "reportAnr stackTrace is null");
        } else {
            m8110b(str.substring(0, Math.min(str.length(), 1000)));
        }
    }

    /* renamed from: h */
    public void m8115h() {
        if (!this.f6028a.get()) {
            C11839m.m70689w("AnrDetector", "try to start but has not been initialized");
        } else {
            C11839m.m70688i("AnrDetector", "start");
            C1408e.m8126i().m8135o();
        }
    }

    /* renamed from: i */
    public void m8116i() {
        if (!this.f6028a.get()) {
            C11839m.m70689w("AnrDetector", "try to stop but has not been initialized");
        } else {
            C11839m.m70688i("AnrDetector", "stop");
            C1408e.m8126i().m8136p();
        }
    }
}
