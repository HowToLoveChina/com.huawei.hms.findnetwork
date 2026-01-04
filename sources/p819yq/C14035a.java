package p819yq;

import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import p852zq.AbstractC14365f;

/* renamed from: yq.a */
/* loaded from: classes8.dex */
public final class C14035a {

    /* renamed from: a */
    public RequestLocationUpdatesRequest f62801a;

    /* renamed from: b */
    public AbstractC14365f f62802b;

    public C14035a() {
        this(new RequestLocationUpdatesRequest());
    }

    /* renamed from: a */
    public final String m84181a() {
        return this.f62801a.getTid();
    }

    /* renamed from: b */
    public final int m84182b() {
        LocationRequest locationRequest = this.f62801a.getLocationRequest();
        if (locationRequest == null) {
            return -1;
        }
        return locationRequest.getPriority();
    }

    /* renamed from: c */
    public final String m84183c() {
        LocationRequest locationRequest = this.f62801a.getLocationRequest();
        if (locationRequest == null) {
            return "";
        }
        int priority = locationRequest.getPriority();
        if (priority != 100) {
            if (priority != 102) {
                if (priority == 200) {
                    return "gps";
                }
                if (priority != 300) {
                    if (priority != 400) {
                        if (priority != 104) {
                            return priority != 105 ? "" : "passive";
                        }
                    }
                }
            }
            return "network";
        }
        return "fused";
    }

    /* renamed from: d */
    public final LocationRequest m84184d() {
        return this.f62801a.getLocationRequest();
    }

    /* renamed from: e */
    public final String m84185e() {
        return this.f62801a.getUuid();
    }

    /* renamed from: f */
    public final RequestLocationUpdatesRequest m84186f() {
        return this.f62801a;
    }

    /* renamed from: g */
    public final AbstractC14365f m84187g() {
        return this.f62802b;
    }

    /* renamed from: h */
    public final void m84188h(AbstractC14365f abstractC14365f) {
        this.f62802b = abstractC14365f;
    }

    public C14035a(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        this.f62801a = requestLocationUpdatesRequest;
    }
}
