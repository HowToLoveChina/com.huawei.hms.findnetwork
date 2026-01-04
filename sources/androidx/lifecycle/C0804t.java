package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.ReportFragment;

/* renamed from: androidx.lifecycle.t */
/* loaded from: classes.dex */
public class C0804t implements InterfaceC0796l {

    /* renamed from: i */
    public static final C0804t f4188i = new C0804t();

    /* renamed from: e */
    public Handler f4193e;

    /* renamed from: a */
    public int f4189a = 0;

    /* renamed from: b */
    public int f4190b = 0;

    /* renamed from: c */
    public boolean f4191c = true;

    /* renamed from: d */
    public boolean f4192d = true;

    /* renamed from: f */
    public final C0797m f4194f = new C0797m(this);

    /* renamed from: g */
    public Runnable f4195g = new a();

    /* renamed from: h */
    public ReportFragment.InterfaceC0775a f4196h = new b();

    /* renamed from: androidx.lifecycle.t$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0804t.this.m4985f();
            C0804t.this.m4986i();
        }
    }

    /* renamed from: androidx.lifecycle.t$b */
    public class b implements ReportFragment.InterfaceC0775a {
        public b() {
        }

        @Override // androidx.lifecycle.ReportFragment.InterfaceC0775a
        public void onCreate() {
        }

        @Override // androidx.lifecycle.ReportFragment.InterfaceC0775a
        public void onResume() {
            C0804t.this.m4981b();
        }

        @Override // androidx.lifecycle.ReportFragment.InterfaceC0775a
        public void onStart() {
            C0804t.this.m4982c();
        }
    }

    /* renamed from: androidx.lifecycle.t$c */
    public class c extends C0783d {

        /* renamed from: androidx.lifecycle.t$c$a */
        public class a extends C0783d {
            public a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                C0804t.this.m4981b();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                C0804t.this.m4982c();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.C0783d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.C0783d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            C0804t.this.m4980a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.C0783d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            C0804t.this.m4983d();
        }
    }

    /* renamed from: j */
    public static InterfaceC0796l m4978j() {
        return f4188i;
    }

    /* renamed from: k */
    public static void m4979k(Context context) {
        f4188i.m4984e(context);
    }

    /* renamed from: a */
    public void m4980a() {
        int i10 = this.f4190b - 1;
        this.f4190b = i10;
        if (i10 == 0) {
            this.f4193e.postDelayed(this.f4195g, 700L);
        }
    }

    /* renamed from: b */
    public void m4981b() {
        int i10 = this.f4190b + 1;
        this.f4190b = i10;
        if (i10 == 1) {
            if (!this.f4191c) {
                this.f4193e.removeCallbacks(this.f4195g);
            } else {
                this.f4194f.m4962h(AbstractC0791h.b.ON_RESUME);
                this.f4191c = false;
            }
        }
    }

    /* renamed from: c */
    public void m4982c() {
        int i10 = this.f4189a + 1;
        this.f4189a = i10;
        if (i10 == 1 && this.f4192d) {
            this.f4194f.m4962h(AbstractC0791h.b.ON_START);
            this.f4192d = false;
        }
    }

    /* renamed from: d */
    public void m4983d() {
        this.f4189a--;
        m4986i();
    }

    /* renamed from: e */
    public void m4984e(Context context) {
        this.f4193e = new Handler();
        this.f4194f.m4962h(AbstractC0791h.b.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    /* renamed from: f */
    public void m4985f() {
        if (this.f4190b == 0) {
            this.f4191c = true;
            this.f4194f.m4962h(AbstractC0791h.b.ON_PAUSE);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0796l
    /* renamed from: g */
    public AbstractC0791h mo1915g() {
        return this.f4194f;
    }

    /* renamed from: i */
    public void m4986i() {
        if (this.f4189a == 0 && this.f4191c) {
            this.f4194f.m4962h(AbstractC0791h.b.ON_STOP);
            this.f4192d = true;
        }
    }
}
