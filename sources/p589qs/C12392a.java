package p589qs;

import com.huawei.hms.location.LocationSettingsStates;
import com.huawei.hms.support.api.client.Status;

/* renamed from: qs.a */
/* loaded from: classes8.dex */
public final class C12392a {

    /* renamed from: a */
    public Status f57226a;

    /* renamed from: b */
    public LocationSettingsStates f57227b;

    /* renamed from: a */
    public final Status m74471a() {
        return this.f57226a;
    }

    /* renamed from: b */
    public final LocationSettingsStates m74472b() {
        return this.f57227b;
    }

    /* renamed from: c */
    public final void m74473c(LocationSettingsStates locationSettingsStates) {
        this.f57227b = locationSettingsStates;
    }

    /* renamed from: d */
    public final void m74474d(Status status) {
        this.f57226a = status;
    }
}
