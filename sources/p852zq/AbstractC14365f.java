package p852zq;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.resp.C6804Vw;
import com.huawei.location.resp.C6805yn;
import com.huawei.location.resp.LocationAvailabilityInfo;
import com.huawei.location.resp.ResponseInfo;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9542g;
import is.C10612i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p819yq.C14036b;
import p854zs.C14373b;
import p854zs.C14374c;

/* renamed from: zq.f */
/* loaded from: classes8.dex */
public abstract class AbstractC14365f implements LocationListener {

    /* renamed from: a */
    public InterfaceC14367h f63719a;

    /* renamed from: b */
    public Location f63720b;

    /* renamed from: c */
    public Handler f63721c;

    /* renamed from: d */
    public C14373b.a f63722d;

    /* renamed from: e */
    public RequestLocationUpdatesRequest f63723e;

    /* renamed from: f */
    public long f63724f = SystemClock.elapsedRealtimeNanos();

    /* renamed from: g */
    public boolean f63725g = false;

    /* renamed from: zq.f$a */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1001) {
                AbstractC14365f.this.mo85532g(message.getData());
                return false;
            }
            if (i10 == 1002) {
                AbstractC14365f.this.mo85545f();
                return false;
            }
            C1016d.m6190j("HwBaseCallback", "handleMessage error");
            return false;
        }
    }

    public AbstractC14365f() {
        HandlerThread handlerThread = new HandlerThread("HwBaseCallback");
        handlerThread.start();
        this.f63721c = new Handler(handlerThread.getLooper(), new a());
    }

    /* renamed from: a */
    public final boolean m85549a(HwLocationResult hwLocationResult) {
        String str;
        if (hwLocationResult == null || hwLocationResult.getCode() != 0) {
            str = "checkLocationResult fail, hwLocationResult is invalid";
        } else if (hwLocationResult.getLocation() == null) {
            str = "checkLocationResult fail, location is null";
        } else {
            RequestLocationUpdatesRequest requestLocationUpdatesRequest = this.f63723e;
            if (requestLocationUpdatesRequest != null && !TextUtils.isEmpty(requestLocationUpdatesRequest.getUuid())) {
                return false;
            }
            str = "checkLocationResult fail, request is invalid";
        }
        C1016d.m6183c("HwBaseCallback", str);
        return true;
    }

    /* renamed from: b */
    public void mo85544b(HwLocationResult hwLocationResult) {
        Message messageObtainMessage = this.f63721c.obtainMessage(1001);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        messageObtainMessage.setData(bundle);
        this.f63721c.sendMessage(messageObtainMessage);
    }

    /* renamed from: c */
    public final void m85550c() {
        Handler handler = this.f63721c;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.f63721c.getLooper().quitSafely();
        C1016d.m6186f("HwBaseCallback", "handler quitSafely");
    }

    /* renamed from: d */
    public final void m85551d(HwLocationResult hwLocationResult) throws JSONException {
        ResponseInfo responseInfo = new ResponseInfo();
        StatusInfo statusInfo = new StatusInfo(0, 0, hwLocationResult.getMessage());
        C6804Vw c6804Vw = new C6804Vw();
        c6804Vw.m38489d(this.f63720b);
        responseInfo.setLocationResult(c6804Vw);
        List<C6805yn> arrayList = new ArrayList<>();
        if (responseInfo.getLocationResult() != null) {
            arrayList = responseInfo.getLocationResult().m38488c();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<C6805yn> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(C14374c.m85584b(it.next().m38490a()));
            }
            jSONObject2.put("locations", jSONArray);
            jSONObject.put("locationResult", jSONObject2);
        } catch (JSONException unused) {
            C1016d.m6183c("LocationInnerUtil", "buildEntityFromResponse get jsonException .");
        }
        String string = jSONObject.toString();
        C1016d.m6186f("HwBaseCallback", "callJson to cp, tid is " + this.f63723e.getTid() + ", uuid is " + this.f63723e.getUuid() + ", provider is " + this.f63720b.getProvider());
        this.f63719a.mo38279b(new RouterResponse(string, statusInfo));
        C14036b.m84189d().m84191b(this.f63723e.getUuid());
        C14373b.a aVar = this.f63722d;
        if (aVar != null) {
            aVar.m85582h(c6804Vw);
            this.f63722d.m85579e().m85573a(String.valueOf(0));
        }
    }

    /* renamed from: e */
    public final void m85552e(boolean z10) {
        this.f63725g = z10;
    }

    /* renamed from: f */
    public void mo85545f() {
    }

    /* renamed from: g */
    public abstract void mo85532g(Bundle bundle);

    /* renamed from: h */
    public final void m85553h(HwLocationResult hwLocationResult) throws JSONException {
        if (C14374c.m85585c()) {
            C1016d.m6183c("HwBaseCallback", "no precise location permission");
            return;
        }
        Location location = this.f63720b;
        if (this.f63725g && location != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(location);
            if (C10612i.m65050a().m65055f(this.f63723e.getTid(), this, arrayList)) {
                C1016d.m6186f("HwBaseCallback", "this locationResult add maxWaitTimeQueue , not need callback");
                if (this.f63720b != null) {
                    this.f63724f = SystemClock.elapsedRealtimeNanos();
                }
                this.f63720b = location;
                C14036b.m84189d().m84194f(location);
                return;
            }
        }
        Location location2 = hwLocationResult.getLocation();
        if (this.f63720b != null) {
            this.f63724f = SystemClock.elapsedRealtimeNanos();
        }
        this.f63720b = location2;
        C14036b.m84189d().m84194f(location2);
        m85551d(hwLocationResult);
    }

    /* renamed from: i */
    public final void m85554i(boolean z10) {
        ResponseInfo responseInfo = new ResponseInfo();
        LocationAvailabilityInfo locationAvailabilityInfo = new LocationAvailabilityInfo();
        locationAvailabilityInfo.setLocationStatus(z10 ? 0 : 1001);
        responseInfo.setLocationAvailability(locationAvailabilityInfo);
        this.f63719a.mo38279b(new RouterResponse(C9542g.m59588a().toJson(responseInfo), new StatusInfo(0, 0, "success")));
    }

    /* renamed from: j */
    public void mo85533j(boolean z10, boolean z11) {
    }

    /* renamed from: k */
    public final boolean m85555k(Location location) {
        LocationRequest locationRequest = this.f63723e.getLocationRequest();
        if (locationRequest == null) {
            C1016d.m6186f("HwBaseCallback", "report location fail, locationRequest is null");
            return false;
        }
        if (this.f63720b == null) {
            return true;
        }
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.f63724f) / 1000000;
        double dMin = Math.min(locationRequest.getInterval(), locationRequest.getFastestInterval());
        double d10 = 0.9d * dMin;
        if (dMin >= 2000.0d) {
            d10 = dMin - 1000.0d;
        }
        if (jElapsedRealtimeNanos < d10) {
            C1016d.m6183c("HwBaseCallback", "report location fail, timeDifference is " + jElapsedRealtimeNanos + ", provider is " + location.getProvider());
            return false;
        }
        if (locationRequest.getNumUpdates() < 1) {
            C1016d.m6183c("HwBaseCallback", "report location fail, numUpdate < 1");
            return false;
        }
        double smallestDisplacement = locationRequest.getSmallestDisplacement();
        if (smallestDisplacement > 0.0d && location.distanceTo(this.f63720b) <= smallestDisplacement) {
            C1016d.m6186f("HwBaseCallback", "report location fail, minDistance is not met");
            return false;
        }
        if (locationRequest.getExpirationTime() >= SystemClock.elapsedRealtime()) {
            return true;
        }
        C1016d.m6186f("HwBaseCallback", "report location fail, expirationTime is not met");
        return false;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        C1016d.m6186f("HwBaseCallback", "gnss location successful");
        HwLocationResult hwLocationResult = new HwLocationResult();
        hwLocationResult.setLocation(location);
        mo85544b(hwLocationResult);
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i10, Bundle bundle) {
    }
}
