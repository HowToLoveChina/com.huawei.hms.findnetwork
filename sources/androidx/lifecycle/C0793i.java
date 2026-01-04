package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.lifecycle.i */
/* loaded from: classes.dex */
public class C0793i {

    /* renamed from: a */
    public static AtomicBoolean f4174a = new AtomicBoolean(false);

    /* renamed from: androidx.lifecycle.i$a */
    public static class a extends C0783d {
        @Override // androidx.lifecycle.C0783d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ReportFragment.m4903f(activity);
        }

        @Override // androidx.lifecycle.C0783d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.C0783d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: a */
    public static void m4956a(Context context) {
        if (f4174a.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
    }
}
