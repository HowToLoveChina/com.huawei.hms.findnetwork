package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

/* loaded from: classes8.dex */
public class AutoLifecycleFragment extends Fragment {

    /* renamed from: a */
    private final SparseArray<C5144a> f23455a = new SparseArray<>();

    /* renamed from: b */
    private boolean f23456b;

    /* renamed from: com.huawei.hms.common.internal.AutoLifecycleFragment$a */
    public static class C5144a {

        /* renamed from: a */
        public final HuaweiApiClient f23457a;

        /* renamed from: b */
        protected final int f23458b;

        public C5144a(int i10, HuaweiApiClient huaweiApiClient) {
            this.f23457a = huaweiApiClient;
            this.f23458b = i10;
        }

        /* renamed from: a */
        public void m30668a() {
            this.f23457a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e10);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f23456b = true;
        for (int i10 = 0; i10 < this.f23455a.size(); i10++) {
            this.f23455a.valueAt(i10).f23457a.connect((Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f23456b = false;
        for (int i10 = 0; i10 < this.f23455a.size(); i10++) {
            this.f23455a.valueAt(i10).f23457a.disconnect();
        }
    }

    public void startAutoMange(int i10, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        Preconditions.checkState(this.f23455a.indexOfKey(i10) < 0, "Already managing a HuaweiApiClient with this clientId: " + i10);
        this.f23455a.put(i10, new C5144a(i10, huaweiApiClient));
        if (this.f23456b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i10) {
        C5144a c5144a = this.f23455a.get(i10);
        this.f23455a.remove(i10);
        if (c5144a != null) {
            c5144a.m30668a();
        }
    }
}
