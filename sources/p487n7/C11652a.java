package p487n7;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import p031b7.C1120a;
import p031b7.C1122c;

/* renamed from: n7.a */
/* loaded from: classes2.dex */
public class C11652a {

    /* renamed from: c */
    public static final C11652a f54056c = new C11652a();

    /* renamed from: a */
    public int f54057a = 0;

    /* renamed from: b */
    public Application.ActivityLifecycleCallbacks f54058b = null;

    /* renamed from: n7.a$b */
    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            C11652a.m69577b(C11652a.this);
            if (C11652a.this.f54057a == 1) {
                C1120a.m6677i("AlbumActivityLifecycleCallbacks", "process Foreground");
                C1122c.m6741U1();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            C11652a.m69578c(C11652a.this);
            if (C11652a.this.f54057a == 0) {
                C1120a.m6677i("AlbumActivityLifecycleCallbacks", "process Background");
            }
        }
    }

    /* renamed from: b */
    public static /* synthetic */ int m69577b(C11652a c11652a) {
        int i10 = c11652a.f54057a;
        c11652a.f54057a = i10 + 1;
        return i10;
    }

    /* renamed from: c */
    public static /* synthetic */ int m69578c(C11652a c11652a) {
        int i10 = c11652a.f54057a;
        c11652a.f54057a = i10 - 1;
        return i10;
    }

    /* renamed from: e */
    public static C11652a m69579e() {
        return f54056c;
    }

    /* renamed from: d */
    public Application.ActivityLifecycleCallbacks m69580d() {
        if (this.f54058b == null) {
            this.f54058b = new b();
        }
        return this.f54058b;
    }

    /* renamed from: f */
    public boolean m69581f() {
        C1120a.m6675d("CloudAlbumApplication", "activityStartCount " + this.f54057a);
        return this.f54057a > 0;
    }
}
