package p852zq;

import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import as.C1016d;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import hu.C10343b;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import p854zs.C14373b;

/* renamed from: zq.d */
/* loaded from: classes8.dex */
public class C14363d extends AbstractC14365f {

    /* renamed from: h */
    public Location f63713h;

    /* renamed from: i */
    public Location f63714i;

    /* renamed from: j */
    public AtomicBoolean f63715j = new AtomicBoolean(true);

    public C14363d(RequestLocationUpdatesRequest requestLocationUpdatesRequest, InterfaceC14367h interfaceC14367h) {
        this.f63722d = new C14373b.a().m85578d("Location_locationCallback").m85575a(requestLocationUpdatesRequest.getTid());
        this.f63719a = interfaceC14367h;
        this.f63723e = requestLocationUpdatesRequest;
        this.f63721c.sendEmptyMessageDelayed(1002, 3000L);
    }

    /* renamed from: l */
    public static Location m85543l(Location location, Location location2) {
        String str;
        if (location == null && location2 == null) {
            C1016d.m6186f("NLPCallback", "posEngineLoc & nativeNetworkLoc is null");
            return null;
        }
        if (location == null) {
            str = "posEngineLoc is null";
        } else {
            if (location2 == null) {
                C1016d.m6186f("NLPCallback", "nativeNetworkLoc is null");
                return location;
            }
            if (!location.hasAccuracy()) {
                str = "posEngineLoc not hasAccuracy";
            } else {
                if (!location2.hasAccuracy()) {
                    C1016d.m6186f("NLPCallback", "nativeLoc not hasAccuracy");
                    return location;
                }
                if (location.getAccuracy() < location2.getAccuracy()) {
                    C1016d.m6186f("NLPCallback", "posEngineLoc acc is better");
                    return location;
                }
                str = "nativeLoc acc is better";
            }
        }
        C1016d.m6186f("NLPCallback", str);
        return location2;
    }

    @Override // p852zq.AbstractC14365f
    /* renamed from: b */
    public final void mo85544b(HwLocationResult hwLocationResult) {
        String str;
        String str2;
        C1016d.m6186f("NLPCallback", "receive posEngine loc, isFirst is " + this.f63715j);
        if (this.f63715j.get()) {
            this.f63714i = hwLocationResult.getLocation();
            if (this.f63721c.hasMessages(1002) && this.f63713h == null) {
                return;
            }
            this.f63721c.removeMessages(1002);
            this.f63721c.sendEmptyMessage(1002);
            return;
        }
        Location location = hwLocationResult.getLocation();
        Location location2 = this.f63713h;
        if (location == null && location2 == null) {
            C1016d.m6186f("NLPCallback", "compareElapsedRealtimeNanos both is null");
            location = null;
        } else {
            if (location == null) {
                str = "posEngineLoc is null";
            } else {
                if (location2 == null) {
                    str2 = "nativeLoc is null";
                } else if (location.getElapsedRealtimeNanos() > location2.getElapsedRealtimeNanos() + 20000000000L) {
                    str2 = "nativeNetworkLoc elapsedRealtimeNanos is invalid";
                } else if (location2.getElapsedRealtimeNanos() > location.getElapsedRealtimeNanos() + 20000000000L) {
                    str = "posEngineLoc elapsedRealtimeNanos is invalid";
                } else {
                    location = m85543l(location, location2);
                }
                C1016d.m6186f("NLPCallback", str2);
            }
            C1016d.m6186f("NLPCallback", str);
            location = location2;
        }
        if (location == null) {
            C1016d.m6186f("NLPCallback", "onLocationChanged bestLoc is null ");
            return;
        }
        hwLocationResult.setLocation(location);
        hwLocationResult.setCode(0);
        Message messageObtainMessage = this.f63721c.obtainMessage(1001);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        messageObtainMessage.setData(bundle);
        this.f63721c.sendMessage(messageObtainMessage);
    }

    @Override // p852zq.AbstractC14365f
    /* renamed from: f */
    public final void mo85545f() throws JSONException {
        C1016d.m6186f("NLPCallback", "handleFirstDelayMsg");
        Location locationM85543l = m85543l(this.f63714i, this.f63713h);
        if (locationM85543l == null) {
            C1016d.m6183c("NLPCallback", "handleFirstDelayMsg, accLocation is null");
            return;
        }
        HwLocationResult hwLocationResult = new HwLocationResult();
        hwLocationResult.setCode(0);
        hwLocationResult.setLocation(locationM85543l);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        mo85532g(bundle);
    }

    @Override // p852zq.AbstractC14365f
    /* renamed from: g */
    public void mo85532g(Bundle bundle) throws JSONException {
        HwLocationResult hwLocationResult = (HwLocationResult) new C10343b(bundle).m63690l("hwLocationResult");
        if (!m85549a(hwLocationResult) && m85555k(hwLocationResult.getLocation())) {
            this.f63715j.set(false);
            m85553h(hwLocationResult);
        }
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
    public void onLocationChanged(Location location) {
        if (location == null) {
            C1016d.m6183c("NLPCallback", "receive native network loc is null");
            return;
        }
        C10343b c10343b = new C10343b(location.getExtras());
        c10343b.m63698t("vendorType", 32);
        location.setExtras(c10343b.m63683e());
        location.setProvider("network");
        this.f63713h = location;
        C1016d.m6186f("NLPCallback", "receive native network loc, isFirst is " + this.f63715j);
        if (this.f63715j.get() && (!this.f63721c.hasMessages(1002) || this.f63714i != null)) {
            this.f63721c.removeMessages(1002);
            this.f63721c.sendEmptyMessage(1002);
        }
        if (this.f63723e.isResendFromHMS()) {
            HwLocationResult hwLocationResult = new HwLocationResult();
            hwLocationResult.setLocation(this.f63713h);
            Message messageObtainMessage = this.f63721c.obtainMessage(1001);
            Bundle bundle = new Bundle();
            bundle.putParcelable("hwLocationResult", hwLocationResult);
            messageObtainMessage.setData(bundle);
            this.f63721c.sendMessage(messageObtainMessage);
        }
    }
}
