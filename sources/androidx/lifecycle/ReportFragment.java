package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0791h;

/* loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* renamed from: a */
    public InterfaceC0775a f4132a;

    /* renamed from: androidx.lifecycle.ReportFragment$a */
    public interface InterfaceC0775a {
        void onCreate();

        void onResume();

        void onStart();
    }

    /* renamed from: androidx.lifecycle.ReportFragment$b */
    public static class C0776b implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new C0776b());
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
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            ReportFragment.m4902a(activity, AbstractC0791h.b.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            ReportFragment.m4902a(activity, AbstractC0791h.b.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            ReportFragment.m4902a(activity, AbstractC0791h.b.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            ReportFragment.m4902a(activity, AbstractC0791h.b.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            ReportFragment.m4902a(activity, AbstractC0791h.b.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            ReportFragment.m4902a(activity, AbstractC0791h.b.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m4902a(Activity activity, AbstractC0791h.b bVar) {
        if (activity instanceof InterfaceC0798n) {
            ((InterfaceC0798n) activity).mo1915g().m4962h(bVar);
        } else if (activity instanceof InterfaceC0796l) {
            AbstractC0791h abstractC0791hMo1915g = ((InterfaceC0796l) activity).mo1915g();
            if (abstractC0791hMo1915g instanceof C0797m) {
                ((C0797m) abstractC0791hMo1915g).m4962h(bVar);
            }
        }
    }

    /* renamed from: f */
    public static void m4903f(Activity activity) {
        C0776b.registerIn(activity);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: b */
    public final void m4904b(AbstractC0791h.b bVar) {
    }

    /* renamed from: c */
    public final void m4905c(InterfaceC0775a interfaceC0775a) {
        if (interfaceC0775a != null) {
            interfaceC0775a.onCreate();
        }
    }

    /* renamed from: d */
    public final void m4906d(InterfaceC0775a interfaceC0775a) {
        if (interfaceC0775a != null) {
            interfaceC0775a.onResume();
        }
    }

    /* renamed from: e */
    public final void m4907e(InterfaceC0775a interfaceC0775a) {
        if (interfaceC0775a != null) {
            interfaceC0775a.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m4905c(this.f4132a);
        m4904b(AbstractC0791h.b.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m4904b(AbstractC0791h.b.ON_DESTROY);
        this.f4132a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m4904b(AbstractC0791h.b.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m4906d(this.f4132a);
        m4904b(AbstractC0791h.b.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m4907e(this.f4132a);
        m4904b(AbstractC0791h.b.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        m4904b(AbstractC0791h.b.ON_STOP);
    }
}
