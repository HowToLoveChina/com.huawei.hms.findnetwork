package at;

import android.location.Location;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;

/* renamed from: at.a */
/* loaded from: classes8.dex */
public final class C1021a {

    /* renamed from: a */
    public GnssRawObservation[] f5060a;

    /* renamed from: b */
    public MotionSensors f5061b;

    /* renamed from: c */
    public Location f5062c;

    public C1021a(GnssRawObservation[] gnssRawObservationArr, MotionSensors motionSensors, Location location) {
        this.f5060a = gnssRawObservationArr;
        this.f5061b = motionSensors;
        this.f5062c = location;
    }

    /* renamed from: a */
    public final MotionSensors m6198a() {
        return this.f5061b;
    }

    /* renamed from: b */
    public final Location m6199b() {
        return this.f5062c;
    }

    /* renamed from: c */
    public final GnssRawObservation[] m6200c() {
        return this.f5060a;
    }
}
