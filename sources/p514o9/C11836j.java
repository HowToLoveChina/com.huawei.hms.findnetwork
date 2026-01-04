package p514o9;

import android.app.Activity;
import android.graphics.Movie;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordOperation;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceOperation;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: o9.j */
/* loaded from: classes3.dex */
public class C11836j {

    /* renamed from: l */
    public static final C11836j f54768l = new C11836j();

    /* renamed from: a */
    public Activity f54769a;

    /* renamed from: b */
    public Activity f54770b;

    /* renamed from: c */
    public String f54771c;

    /* renamed from: d */
    public String f54772d;

    /* renamed from: e */
    public float f54773e;

    /* renamed from: f */
    public long f54774f;

    /* renamed from: g */
    public List<CBSDeviceOperation> f54775g;

    /* renamed from: h */
    public Map<Activity, Integer> f54776h = new HashMap();

    /* renamed from: i */
    public List<CBSSyncRecordOperation> f54777i;

    /* renamed from: j */
    public WeakReference<Movie> f54778j;

    /* renamed from: k */
    public WeakReference<Movie> f54779k;

    /* renamed from: k */
    public static C11836j m70658k() {
        return f54768l;
    }

    /* renamed from: a */
    public synchronized void m70659a(Activity activity) {
        C11839m.m70688i("HisyncUIManager", "specialActivitys size = " + this.f54776h.size());
        if (activity != null && !this.f54776h.keySet().contains(activity)) {
            this.f54776h.put(activity, 0);
            this.f54770b = activity;
        }
    }

    /* renamed from: b */
    public synchronized void m70660b(Activity activity, int i10) {
        C11839m.m70688i("HisyncUIManager", "specialActivitys size = " + this.f54776h.size());
        if (activity != null && !this.f54776h.keySet().contains(activity)) {
            this.f54776h.put(activity, Integer.valueOf(i10));
            this.f54770b = activity;
        }
    }

    /* renamed from: c */
    public void m70661c(String str, String str2, float f10, long j10) {
        this.f54771c = str;
        this.f54772d = str2;
        this.f54773e = f10;
        this.f54774f = j10;
    }

    /* renamed from: d */
    public void m70662d() {
        this.f54777i = null;
    }

    /* renamed from: e */
    public void m70663e() {
        this.f54775g = null;
    }

    /* renamed from: f */
    public synchronized void m70664f() {
        try {
            C11839m.m70688i("HisyncUIManager", "finish");
            if (this.f54769a != null) {
                C11839m.m70688i("HisyncUIManager", "currentActivity not null");
                if (m70669l(this.f54769a)) {
                    return;
                } else {
                    this.f54769a.finishAffinity();
                }
            }
            m70666h();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: g */
    public synchronized void m70665g() {
        try {
            C11839m.m70688i("HisyncUIManager", "finishExceptSplitMode");
            Activity activity = this.f54769a;
            if (activity != null && !C11842p.m70774V0(activity)) {
                C11839m.m70688i("HisyncUIManager", "finishExceptSplitMode, finishAffinity");
                this.f54769a.setResult(0);
                this.f54769a.finishAffinity();
            }
            Activity activity2 = this.f54770b;
            if (activity2 != null && !C11842p.m70774V0(activity2)) {
                m70666h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: h */
    public final void m70666h() {
        C11839m.m70688i("HisyncUIManager", "finishSpecialActivity size=" + this.f54776h.size());
        for (Map.Entry<Activity, Integer> entry : this.f54776h.entrySet()) {
            Activity key = entry.getKey();
            key.setResult(entry.getValue().intValue());
            key.finish();
        }
    }

    /* renamed from: i */
    public List<CBSSyncRecordOperation> m70667i() {
        return this.f54777i;
    }

    /* renamed from: j */
    public float m70668j() {
        return this.f54773e;
    }

    /* renamed from: l */
    public final boolean m70669l(Activity activity) {
        String stringExtra;
        if (C11842p.m70762R0() && activity != null && "com.huawei.android.remotecontrol.ui.PhoneFinderActivity".equalsIgnoreCase(activity.getClass().getName())) {
            try {
                stringExtra = activity.getIntent().getStringExtra(RemoteMessageConst.FROM);
            } catch (RuntimeException unused) {
                C11839m.m70688i("HisyncUIManager", "currentActivity intent error");
                stringExtra = null;
            }
            if (stringExtra == null || "com.android.settings".equalsIgnoreCase(stringExtra)) {
                activity.finish();
                m70666h();
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public synchronized void m70670m(Activity activity) {
        if (this.f54769a == activity) {
            this.f54769a = null;
        }
    }

    /* renamed from: n */
    public void m70671n() {
        WeakReference<Movie> weakReference = this.f54778j;
        if (weakReference != null) {
            weakReference.clear();
            this.f54778j = null;
        }
        WeakReference<Movie> weakReference2 = this.f54779k;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.f54779k = null;
        }
    }

    /* renamed from: o */
    public synchronized void m70672o(Activity activity) {
        C11839m.m70688i("HisyncUIManager", "removeSpecialActivity");
        if (activity != null) {
            this.f54776h.remove(activity);
            this.f54770b = null;
        }
    }

    /* renamed from: p */
    public void m70673p(List<CBSSyncRecordOperation> list) {
        this.f54777i = list;
    }

    /* renamed from: q */
    public void m70674q(List<CBSDeviceOperation> list) {
        this.f54775g = list;
    }

    /* renamed from: r */
    public void m70675r(WeakReference<Movie> weakReference) {
        this.f54778j = weakReference;
    }

    /* renamed from: s */
    public void m70676s(WeakReference<Movie> weakReference) {
        this.f54779k = weakReference;
    }

    /* renamed from: t */
    public synchronized void m70677t(Activity activity) {
        this.f54769a = activity;
    }
}
