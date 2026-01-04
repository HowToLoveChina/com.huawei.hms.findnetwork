package p852zq;

import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import is.C10606c;
import p622rr.C12619b;
import p854zs.C14374c;

/* renamed from: zq.g */
/* loaded from: classes8.dex */
public final class C14366g extends C14363d {

    /* renamed from: k */
    public Location f63727k;

    /* renamed from: l */
    public Location f63728l;

    public C14366g(RequestLocationUpdatesRequest requestLocationUpdatesRequest, InterfaceC14367h interfaceC14367h) {
        super(requestLocationUpdatesRequest, interfaceC14367h);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @Override // p852zq.C14363d, p852zq.AbstractC14365f
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
            java.lang.String r2 = "FusedForGCallback"
            as.C1016d.m6186f(r2, r1)
            java.lang.String r1 = r0.getProvider()
            java.lang.String r2 = "gps"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L43
            android.location.Location r1 = new android.location.Location
            r1.<init>(r0)
            r9.f63728l = r1
            goto L4a
        L43:
            android.location.Location r1 = new android.location.Location
            r1.<init>(r0)
            r9.f63727k = r1
        L4a:
            android.location.Location r0 = r9.f63728l
            android.location.Location r1 = r9.f63727k
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
            if (r1 == 0) goto L8b
            r10.setLocation(r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r9.f63715j
            r1 = 0
            r0.set(r1)
            r9.m85553h(r10)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p852zq.C14366g.mo85532g(android.os.Bundle):void");
    }

    @Override // p852zq.C14363d, p852zq.AbstractC14365f, android.location.LocationListener
    public final void onLocationChanged(Location location) {
        C1016d.m6186f("FusedForGCallback", "fusedForG gnss location successful");
        if (!C14374c.m85586d(this.f63723e)) {
            try {
                C10606c.m65019d().m65025g(this.f63723e.getUuid());
                C1016d.m6186f("FusedForGCallback", "request expiration and remove");
                return;
            } catch (C12619b unused) {
                C1016d.m6183c("FusedForGCallback", "throw locationServiceException");
                return;
            }
        }
        if (!TextUtils.equals("gps", location.getProvider())) {
            super.onLocationChanged(location);
            return;
        }
        C1016d.m6186f("FusedForGCallback", "receive native gnss loc");
        HwLocationResult hwLocationResult = new HwLocationResult();
        hwLocationResult.setLocation(location);
        hwLocationResult.setCode(0);
        Message messageObtainMessage = this.f63721c.obtainMessage(1001);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        messageObtainMessage.setData(bundle);
        this.f63721c.sendMessage(messageObtainMessage);
    }
}
