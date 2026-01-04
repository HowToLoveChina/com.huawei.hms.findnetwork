package p520of;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.huawei.android.remotecontrol.phonefinder.AbstractC4380a;
import java.lang.ref.WeakReference;
import java.util.function.Consumer;
import p774xg.C13811a;
import p809yg.C13981a;

/* renamed from: of.q */
/* loaded from: classes4.dex */
public class C11867q extends AbstractC4380a {

    /* renamed from: c */
    public WeakReference<Activity> f54920c;

    /* renamed from: d */
    public Consumer<Location> f54921d;

    /* renamed from: of.q$a */
    public static class a {

        /* renamed from: a */
        public static C11867q f54922a = new C11867q();
    }

    /* renamed from: d */
    public static C11867q m71126d() {
        return a.f54922a;
    }

    @Override // com.huawei.android.remotecontrol.phonefinder.AbstractC4380a
    /* renamed from: c */
    public void mo26440c(Context context) {
        WeakReference<Activity> weakReference = this.f54920c;
        if (weakReference == null) {
            C13981a.m83988e("UpdateMapRetry", "the activity is null");
            return;
        }
        Activity activity = weakReference.get();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            C13981a.m83988e("UpdateMapRetry", "the activity is not available");
        } else {
            C13981a.m83989i("UpdateMapRetry", "NetworkChangeReceiver release, retry update phone finder map");
            C13811a.m82802T(this.f54921d, activity);
        }
    }

    /* renamed from: e */
    public void m71127e(Activity activity, Consumer<Location> consumer) {
        super.m26439b(activity);
        this.f54920c = new WeakReference<>(activity);
        this.f54921d = consumer;
    }
}
