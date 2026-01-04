package com.huawei.hms.locationSdk;

import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.log.HMSLog;
import es.C9540e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.locationSdk.x0 */
/* loaded from: classes8.dex */
public class C5768x0 extends C5766w1 {

    /* renamed from: c */
    private static volatile C5768x0 f25596c;

    /* renamed from: d */
    private static final byte[] f25597d = new byte[0];

    /* renamed from: b */
    private List<LocationCallback> f25598b = new ArrayList(10);

    /* renamed from: a */
    public static /* synthetic */ void m33196a(C5733l1 c5733l1) {
        C5705d0.m33051b().m33059a(c5733l1.m33186a(), LocationRequestHelper.getCpTid(c5733l1.m33122d()));
    }

    /* renamed from: b */
    public static C5768x0 m33197b() {
        if (f25596c == null) {
            synchronized (f25597d) {
                try {
                    if (f25596c == null) {
                        f25596c = new C5768x0();
                    }
                } finally {
                }
            }
        }
        return f25596c;
    }

    /* renamed from: c */
    public static /* synthetic */ void m33198c() {
        C5705d0.m33051b().m33061j();
    }

    @Override // com.huawei.hms.locationSdk.C5766w1
    /* renamed from: d */
    public void mo33195d(AbstractC5763v1 abstractC5763v1) {
        super.mo33195d(abstractC5763v1);
        if (abstractC5763v1 instanceof C5733l1) {
            final C5733l1 c5733l1 = (C5733l1) abstractC5763v1;
            int priority = c5733l1.m33122d().getPriority();
            if (priority == 200 || priority == 100 || priority == 400) {
                C9540e.m59581d().m59582a(new Runnable() { // from class: com.huawei.hms.locationSdk.e2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C5768x0.m33196a(c5733l1);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public boolean m33202a(LocationCallback locationCallback) {
        synchronized (f25597d) {
            if (locationCallback != null) {
                try {
                    if (!CollectionsUtil.isEmpty(this.f25598b)) {
                        for (LocationCallback locationCallback2 : this.f25598b) {
                            if (locationCallback2.equals(locationCallback)) {
                                this.f25598b.remove(locationCallback2);
                                HMSLocationLog.m36662i("LocationRequestCacheManager", "", "remove callback from removingCallbackList, size is : " + this.f25598b.size());
                                return true;
                            }
                        }
                        return false;
                    }
                } finally {
                }
            }
            return false;
        }
    }

    @Override // com.huawei.hms.locationSdk.C5766w1
    /* renamed from: c */
    public boolean mo33194c(AbstractC5763v1 abstractC5763v1) {
        int priority;
        boolean zMo33194c = super.mo33194c(abstractC5763v1);
        if ((abstractC5763v1 instanceof C5733l1) && ((priority = ((C5733l1) abstractC5763v1).m33122d().getPriority()) == 200 || priority == 100 || priority == 400)) {
            C9540e.m59581d().m59582a(new Runnable() { // from class: com.huawei.hms.locationSdk.f2
                @Override // java.lang.Runnable
                public final void run() {
                    C5768x0.m33198c();
                }
            });
        }
        return zMo33194c;
    }

    /* renamed from: a */
    public void m33201a(C5733l1 c5733l1, int i10) throws IllegalArgumentException {
        if (c5733l1 == null || CollectionsUtil.isEmpty(m33191a())) {
            HMSLog.m36988i("LocationRequestCacheManager", "updateCacheNumUpdates fail, cache or numUpdates is null");
            return;
        }
        for (int i11 = 0; i11 < m33191a().size(); i11++) {
            C5733l1 c5733l12 = m33191a().get(i11) instanceof C5733l1 ? (C5733l1) m33191a().get(i11) : null;
            if (c5733l12 != null && c5733l12.equals(c5733l1)) {
                if (i10 > 0) {
                    c5733l12.m33122d().setNumUpdates(i10);
                }
                c5733l12.m33117a(i10);
            }
        }
    }
}
