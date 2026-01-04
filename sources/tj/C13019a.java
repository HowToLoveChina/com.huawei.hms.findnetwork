package tj;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ck.C1443a;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hms.support.log.HMSDebugger;
import java.util.Iterator;
import java.util.LinkedList;
import p015ak.C0212e0;
import p015ak.C0213f;
import p664u0.C13108a;
import p681uj.C13192i;

/* renamed from: tj.a */
/* loaded from: classes5.dex */
public class C13019a {

    /* renamed from: f */
    public static final C13019a f59276f = new C13019a();

    /* renamed from: a */
    public Activity f59277a = null;

    /* renamed from: b */
    public Activity f59278b = null;

    /* renamed from: c */
    public Application.ActivityLifecycleCallbacks f59279c = null;

    /* renamed from: d */
    public LinkedList<Activity> f59280d = new LinkedList<>();

    /* renamed from: e */
    public int f59281e = 0;

    @SuppressLint({"NewApi"})
    /* renamed from: tj.a$b */
    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (C13019a.this.f59280d.contains(activity)) {
                return;
            }
            BaseLogger.m28733i("AccountApplication", "onActivityCreated: add Activity");
            C13019a.this.f59280d.add(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            BaseLogger.m28729d("AccountApplication", "onActivityDestroyed activity = " + activity.getLocalClassName());
            C13019a.this.m78353p(activity);
            C13019a.this.f59280d.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            BaseLogger.m28729d("AccountApplication", "onActivityPaused activity = " + activity.getLocalClassName());
            if (activity == C13019a.this.f59277a) {
                C13019a.this.f59277a = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            BaseLogger.m28729d("AccountApplication", "onActivityResumed activity = " + activity.getLocalClassName());
            if (activity != C13019a.this.f59278b) {
                C13019a.this.f59277a = activity;
            }
            BaseLogger.m28729d("AccountApplication", "onActivityResumed currActivity = " + C13019a.this.f59277a);
            C13019a.this.m78356s(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            C13019a.m78340c(C13019a.this);
            BaseLogger.m28729d("AccountApplication", "onActivityStarted activity = " + activity.getLocalClassName());
            C13108a.m78878b(activity.getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.APP_BACKGROUND_TO_FOREGROUND"));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (!C13192i.m79258g().m79263i()) {
                C13019a.this.m78353p(activity);
            }
            C13019a.m78341d(C13019a.this);
            if (C13019a.this.f59281e == 0) {
                BaseLogger.m28729d("AccountApplication", "process Background");
                C13108a.m78878b(activity.getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.APP_FOREGROUND_TO_BACKGROUND"));
            }
        }

        public /* synthetic */ b(C13019a c13019a, a aVar) {
            this();
        }
    }

    /* renamed from: c */
    public static /* synthetic */ int m78340c(C13019a c13019a) {
        int i10 = c13019a.f59281e;
        c13019a.f59281e = i10 + 1;
        return i10;
    }

    /* renamed from: d */
    public static /* synthetic */ int m78341d(C13019a c13019a) {
        int i10 = c13019a.f59281e;
        c13019a.f59281e = i10 - 1;
        return i10;
    }

    /* renamed from: n */
    public static C13019a m78347n() {
        return f59276f;
    }

    /* renamed from: j */
    public Application.ActivityLifecycleCallbacks m78348j() {
        if (this.f59279c == null) {
            this.f59279c = new b();
        }
        return this.f59279c;
    }

    /* renamed from: k */
    public LinkedList<Activity> m78349k() {
        return this.f59280d;
    }

    /* renamed from: l */
    public int m78350l() {
        return this.f59281e;
    }

    /* renamed from: m */
    public Activity m78351m() {
        return this.f59277a;
    }

    /* renamed from: o */
    public void m78352o(Context context) {
        if (C1443a.f6214b.booleanValue()) {
            HMSDebugger.init(context, 3);
        }
    }

    /* renamed from: p */
    public final void m78353p(Activity activity) {
        if (activity == this.f59277a) {
            this.f59277a = null;
        }
        if (activity == this.f59278b) {
            this.f59278b = null;
        }
    }

    /* renamed from: q */
    public void m78354q(Activity activity) {
        BaseLogger.m28733i("AccountApplication", "removeActivity: " + activity);
        this.f59280d.remove(activity);
    }

    /* renamed from: r */
    public void m78355r() {
        BaseLogger.m28733i("AccountApplication", "removeAllActivity");
        Iterator<Activity> it = this.f59280d.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            BaseLogger.m28729d("AccountApplication", "removeAllActivity: " + next);
            next.finish();
        }
    }

    /* renamed from: s */
    public final void m78356s(Activity activity) {
        if (activity == null) {
            return;
        }
        String localClassName = activity.getLocalClassName();
        BaseLogger.m28729d("AccountApplication", "last_resume_activity: " + localClassName);
        C0212e0.m1373w(C0213f.m1377a(), "common_account_app", "last_resume_activity", localClassName);
    }

    /* renamed from: t */
    public void m78357t(Activity activity) {
        this.f59278b = activity;
        this.f59277a = null;
    }
}
