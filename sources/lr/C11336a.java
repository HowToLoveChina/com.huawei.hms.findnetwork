package lr;

import android.location.Location;
import com.huawei.location.sdm.InterfaceC6822i;
import lr.C11337b;

/* renamed from: lr.a */
/* loaded from: classes8.dex */
public final class C11336a implements InterfaceC6822i {

    /* renamed from: a */
    public final /* synthetic */ C11337b.a f53034a;

    public C11336a(C11339d c11339d) {
        this.f53034a = c11339d;
    }

    @Override // com.huawei.location.sdm.InterfaceC6822i
    public final void onLocationChanged(Location location) {
        C11338c.m68122a(((C11339d) this.f53034a).f53047a, location);
    }
}
