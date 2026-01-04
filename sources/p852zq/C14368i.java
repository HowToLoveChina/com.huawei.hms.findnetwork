package p852zq;

import android.location.Location;
import as.C1016d;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import is.C10606c;
import p622rr.C12619b;
import p854zs.C14373b;
import p854zs.C14374c;

/* renamed from: zq.i */
/* loaded from: classes8.dex */
public final class C14368i extends AbstractC14365f {

    /* renamed from: h */
    public Location f63729h;

    /* renamed from: i */
    public Location f63730i;

    public C14368i(RequestLocationUpdatesRequest requestLocationUpdatesRequest, InterfaceC14367h interfaceC14367h) {
        this.f63722d = new C14373b.a().m85578d("Location_locationCallback").m85575a(requestLocationUpdatesRequest.getTid());
        this.f63719a = interfaceC14367h;
        this.f63723e = requestLocationUpdatesRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @Override // p852zq.AbstractC14365f
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo85532g(android.os.Bundle r10) throws org.json.JSONException {
        /*
            r9 = this;
            hu.b r0 = new hu.b
            r0.<init>(r10)
            java.lang.String r10 = "hwLocationResult"
            android.os.Parcelable r10 = r0.m63690l(r10)
            com.huawei.hms.location.HwLocationResult r10 = (com.huawei.hms.location.HwLocationResult) r10
            boolean r0 = r9.m85549a(r10)
            if (r0 == 0) goto L14
            return
        L14:
            android.location.Location r0 = r10.getLocation()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "handlerFuesdLocation, location provider is "
            r1.<init>(r2)
            java.lang.String r2 = r0.getProvider()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "HwFusedCallback"
            as.C1016d.m6186f(r2, r1)
            java.lang.String r1 = r0.getProvider()
            java.lang.String r2 = "gps"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L43
            android.location.Location r1 = new android.location.Location
            r1.<init>(r0)
            r9.f63729h = r1
            goto L4a
        L43:
            android.location.Location r1 = new android.location.Location
            r1.<init>(r0)
            r9.f63730i = r1
        L4a:
            android.location.Location r0 = r9.f63729h
            android.location.Location r1 = r9.f63730i
            java.lang.String r2 = "HwBaseCallback"
            if (r0 != 0) goto L58
            java.lang.String r0 = "gnssTempLocation is null"
        L54:
            as.C1016d.m6186f(r2, r0)
            goto L78
        L58:
            if (r1 != 0) goto L60
            java.lang.String r1 = "nlpTempLocation is null"
        L5c:
            as.C1016d.m6186f(r2, r1)
            goto L79
        L60:
            long r3 = r0.getElapsedRealtimeNanos()
            long r5 = android.os.SystemClock.elapsedRealtimeNanos()
            r7 = 20000000000(0x4a817c800, double:9.881312917E-314)
            long r5 = r5 - r7
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L75
            java.lang.String r1 = "gnssLocation is better"
            goto L5c
        L75:
            java.lang.String r0 = "network location is better"
            goto L54
        L78:
            r0 = r1
        L79:
            boolean r1 = r9.m85555k(r0)
            if (r1 == 0) goto L85
            r10.setLocation(r0)
            r9.m85553h(r10)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p852zq.C14368i.mo85532g(android.os.Bundle):void");
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
        C1016d.m6186f("HwFusedCallback", "fused gnss location successful");
        if (C14374c.m85586d(this.f63723e)) {
            HwLocationResult hwLocationResult = new HwLocationResult();
            hwLocationResult.setLocation(location);
            mo85544b(hwLocationResult);
        } else {
            try {
                C10606c.m65019d().m65025g(this.f63723e.getUuid());
                C1016d.m6186f("HwFusedCallback", "request expiration and remove");
            } catch (C12619b unused) {
                C1016d.m6183c("HwFusedCallback", "throw locationServiceException");
            }
        }
    }
}
