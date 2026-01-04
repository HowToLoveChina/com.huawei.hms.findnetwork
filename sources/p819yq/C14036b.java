package p819yq;

import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: yq.b */
/* loaded from: classes8.dex */
public final class C14036b {

    /* renamed from: c */
    public static final byte[] f62803c = new byte[0];

    /* renamed from: d */
    public static volatile C14036b f62804d;

    /* renamed from: a */
    public ConcurrentHashMap<String, C14035a> f62805a = new ConcurrentHashMap<>(11);

    /* renamed from: b */
    public Location f62806b;

    /* renamed from: d */
    public static C14036b m84189d() {
        if (f62804d == null) {
            synchronized (f62803c) {
                try {
                    if (f62804d == null) {
                        f62804d = new C14036b();
                    }
                } finally {
                }
            }
        }
        return f62804d;
    }

    /* renamed from: a */
    public final Location m84190a() {
        if (this.f62806b == null) {
            C1016d.m6186f("RequestRecordCache", "cached lastLocation is null");
            return null;
        }
        if (SystemClock.elapsedRealtime() - (this.f62806b.getElapsedRealtimeNanos() / 1000000) <= 1200000) {
            C1016d.m6186f("RequestRecordCache", "cached lastLocation is in 20 minutes");
            return this.f62806b;
        }
        C1016d.m6186f("RequestRecordCache", "cached lastLocation is expired");
        this.f62806b = null;
        return null;
    }

    /* renamed from: b */
    public final void m84191b(String str) {
        if (TextUtils.isEmpty(str)) {
            C1016d.m6183c("RequestRecordCache", "updateNumUpdate fail, uuid is null");
            return;
        }
        if (!this.f62805a.containsKey(str)) {
            C1016d.m6183c("RequestRecordCache", "updateNumUpdate fail, requestCache is not contains");
            return;
        }
        C14035a c14035a = this.f62805a.get(str);
        if (c14035a == null) {
            C1016d.m6183c("RequestRecordCache", "updateNumUpdate fail, wrapLocationRequest is null");
            return;
        }
        RequestLocationUpdatesRequest requestLocationUpdatesRequestM84186f = c14035a.m84186f();
        if (requestLocationUpdatesRequestM84186f == null) {
            C1016d.m6183c("RequestRecordCache", "updateNumUpdate fail, requestLocationUpdatesRequest is null");
            return;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequestM84186f.getLocationRequest();
        if (locationRequest == null) {
            C1016d.m6183c("RequestRecordCache", "updateNumUpdate fail, locationRequest is null");
            return;
        }
        int numUpdates = locationRequest.getNumUpdates();
        if (numUpdates <= 1) {
            C1016d.m6183c("RequestRecordCache", "updateNumUpdate fail, numUpdate <= 1");
        } else {
            locationRequest.setNumUpdates(numUpdates - 1);
        }
    }

    /* renamed from: c */
    public final C14035a m84192c(String str) {
        if (TextUtils.isEmpty(str)) {
            C1016d.m6186f("RequestRecordCache", "removeRequestRecord isEmpty uuid");
            return new C14035a();
        }
        if (!this.f62805a.containsKey(str)) {
            return new C14035a();
        }
        C14035a c14035a = this.f62805a.get(str);
        if (c14035a != null && c14035a.m84187g() != null) {
            C1016d.m6186f("RequestRecordCache", "removeRequestRecord getProvider:".concat(c14035a.m84183c()));
            c14035a.m84187g().m85550c();
        }
        return this.f62805a.remove(str);
    }

    /* renamed from: e */
    public final ConcurrentHashMap<String, C14035a> m84193e() {
        return this.f62805a;
    }

    /* renamed from: f */
    public final void m84194f(Location location) {
        this.f62806b = location;
    }

    /* renamed from: g */
    public final void m84195g(C14035a c14035a) {
        if (c14035a.m84187g() == null) {
            return;
        }
        this.f62805a.put(c14035a.m84185e(), c14035a);
        C1016d.m6186f("RequestRecordCache", "add requestCache end, uuid is " + c14035a.m84185e() + "," + this.f62805a.size());
    }

    /* renamed from: h */
    public final boolean m84196h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f62805a.containsKey(str);
    }
}
