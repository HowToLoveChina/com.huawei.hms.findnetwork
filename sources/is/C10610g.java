package is;

import as.C1016d;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.activity.RiemannSoftArService;
import com.huawei.location.base.activity.ISoftARManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import java.util.List;

/* renamed from: is.g */
/* loaded from: classes8.dex */
public final class C10610g implements ISoftARManager {

    /* renamed from: b */
    public static final byte[] f50999b = new byte[0];

    /* renamed from: c */
    public static volatile C10610g f51000c;

    /* renamed from: a */
    public RiemannSoftArService f51001a = RiemannSoftArService.getInstance();

    /* renamed from: a */
    public static C10610g m65039a() {
        if (f51000c == null) {
            synchronized (f50999b) {
                try {
                    if (f51000c == null) {
                        f51000c = new C10610g();
                    }
                } finally {
                }
            }
        }
        return f51000c;
    }

    @Override // com.huawei.location.base.activity.ISoftARManager
    public final void removeActivityTransitionUpdates(ATCallback aTCallback) {
        C1016d.m6186f("SoftARManagerImpl", "removeActivityTransitionUpdates");
        try {
            this.f51001a.removeActivityTransitionUpdates(aTCallback, null);
        } catch (Exception unused) {
            C1016d.m6185e("SoftARManagerImpl", "removeAT exception", true);
        }
    }

    @Override // com.huawei.location.base.activity.ISoftARManager
    public final void removeActivityUpdates(ARCallback aRCallback) {
        C1016d.m6186f("SoftARManagerImpl", "removeActivityUpdates");
        try {
            this.f51001a.removeActivityUpdates(aRCallback, null);
        } catch (Exception unused) {
            C1016d.m6185e("SoftARManagerImpl", "removeAR exception", true);
        }
    }

    @Override // com.huawei.location.base.activity.ISoftARManager
    public final void requestActivityTransitionUpdates(List<ActivityTransition> list, ATCallback aTCallback) {
        C1016d.m6186f("SoftARManagerImpl", "requestActivityTransitionUpdates");
        ActivityTransitionRequest activityTransitionRequest = new ActivityTransitionRequest();
        activityTransitionRequest.setTransitions(list);
        try {
            this.f51001a.requestActivityTransitionUpdates(activityTransitionRequest, aTCallback, null);
        } catch (Exception unused) {
            C1016d.m6185e("SoftARManagerImpl", "requestAT exception", true);
        }
    }

    @Override // com.huawei.location.base.activity.ISoftARManager
    public final void requestActivityUpdates(long j10, ARCallback aRCallback) {
        C1016d.m6186f("SoftARManagerImpl", "requestActivityUpdates");
        if (j10 <= 0) {
            j10 = 30000;
        }
        try {
            this.f51001a.requestActivityUpdates(j10, aRCallback, null);
        } catch (Exception unused) {
            C1016d.m6185e("SoftARManagerImpl", "requestAR exception", true);
        }
    }
}
