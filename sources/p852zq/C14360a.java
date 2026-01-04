package p852zq;

import android.location.Location;
import as.C1016d;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import is.C10606c;
import p622rr.C12619b;
import p854zs.C14373b;
import p854zs.C14374c;

/* renamed from: zq.a */
/* loaded from: classes8.dex */
public final class C14360a extends AbstractC14365f {
    public C14360a(RequestLocationUpdatesRequest requestLocationUpdatesRequest, InterfaceC14367h interfaceC14367h) {
        this.f63722d = new C14373b.a().m85578d("Location_locationCallbackEx").m85575a(requestLocationUpdatesRequest.getTid());
        this.f63719a = interfaceC14367h;
        this.f63723e = requestLocationUpdatesRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // p852zq.AbstractC14365f
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo85532g(android.os.Bundle r6) throws org.json.JSONException {
        /*
            r5 = this;
            java.lang.String r0 = "handlerLocation"
            java.lang.String r1 = "HDLocationCallback"
            as.C1016d.m6186f(r1, r0)
            hu.b r0 = new hu.b
            r0.<init>(r6)
            java.lang.String r6 = "hwLocationResult"
            android.os.Parcelable r6 = r0.m63690l(r6)
            com.huawei.hms.location.HwLocationResult r6 = (com.huawei.hms.location.HwLocationResult) r6
            boolean r0 = r5.m85549a(r6)
            if (r0 == 0) goto L1b
            return
        L1b:
            android.location.Location r0 = r6.getLocation()
            if (r0 != 0) goto L27
            java.lang.String r0 = "modifySourceType location is Empty, modifySourceType fail."
        L23:
            as.C1016d.m6183c(r1, r0)
            goto L4d
        L27:
            android.os.Bundle r2 = r0.getExtras()
            if (r2 != 0) goto L30
            java.lang.String r0 = "modifySourceType extras is Empty, modifySourceType fail."
            goto L23
        L30:
            hu.b r1 = new hu.b
            r1.<init>(r2)
            java.lang.String r3 = "SourceType"
            boolean r4 = r1.m63679a(r3)
            if (r4 == 0) goto L46
            int r2 = r2.getInt(r3)
            r2 = r2 & 247(0xf7, float:3.46E-43)
            r1.m63698t(r3, r2)
        L46:
            android.os.Bundle r1 = r1.m63683e()
            r0.setExtras(r1)
        L4d:
            android.location.Location r0 = r6.getLocation()
            boolean r0 = r5.m85555k(r0)
            if (r0 == 0) goto L5a
            r5.m85553h(r6)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p852zq.C14360a.mo85532g(android.os.Bundle):void");
    }

    @Override // p852zq.AbstractC14365f
    /* renamed from: j */
    public final void mo85533j(boolean z10, boolean z11) {
        if (z10) {
            return;
        }
        m85554i(false);
    }

    @Override // p852zq.AbstractC14365f, android.location.LocationListener
    public final void onLocationChanged(Location location) {
        C1016d.m6186f("HDLocationCallback", "gnss location successful");
        if (C14374c.m85586d(this.f63723e)) {
            HwLocationResult hwLocationResult = new HwLocationResult();
            hwLocationResult.setLocation(location);
            mo85544b(hwLocationResult);
        } else {
            try {
                C10606c.m65019d().m65025g(this.f63723e.getUuid());
                C1016d.m6186f("HDLocationCallback", "request expiration and remove");
            } catch (C12619b unused) {
                C1016d.m6183c("HDLocationCallback", "HDLocationCallback throw locationServiceException");
            }
        }
    }
}
