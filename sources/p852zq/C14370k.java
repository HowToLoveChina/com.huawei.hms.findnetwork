package p852zq;

import android.os.Bundle;
import as.C1016d;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import hu.C10343b;
import org.json.JSONException;
import p854zs.C14373b;

/* renamed from: zq.k */
/* loaded from: classes8.dex */
public final class C14370k extends AbstractC14365f {
    public C14370k(RequestLocationUpdatesRequest requestLocationUpdatesRequest, InterfaceC14367h interfaceC14367h) {
        this.f63722d = new C14373b.a().m85578d("Location_locationCallback").m85575a(requestLocationUpdatesRequest.getTid());
        this.f63719a = interfaceC14367h;
        this.f63723e = requestLocationUpdatesRequest;
    }

    @Override // p852zq.AbstractC14365f
    /* renamed from: g */
    public final void mo85532g(Bundle bundle) throws JSONException {
        C1016d.m6186f("HwCommonCallback", "handlerLocation");
        HwLocationResult hwLocationResult = (HwLocationResult) new C10343b(bundle).m63690l("hwLocationResult");
        if (!m85549a(hwLocationResult) && m85555k(hwLocationResult.getLocation())) {
            m85553h(hwLocationResult);
        }
    }

    @Override // p852zq.AbstractC14365f
    /* renamed from: j */
    public final void mo85533j(boolean z10, boolean z11) {
        if (z10 && z11) {
            return;
        }
        m85554i(false);
    }
}
