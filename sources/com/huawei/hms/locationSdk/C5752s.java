package com.huawei.hms.locationSdk;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import p531or.C11991a;

@SuppressLint({"MissingPermission", "NewApi"})
/* renamed from: com.huawei.hms.locationSdk.s */
/* loaded from: classes8.dex */
public class C5752s {

    /* renamed from: a */
    private LinkedBlockingQueue<C5749r> f25570a;

    /* renamed from: b */
    private final AtomicBoolean f25571b = new AtomicBoolean(false);

    /* renamed from: c */
    private int f25572c;

    /* renamed from: d */
    private Handler f25573d;

    /* renamed from: e */
    private GnssStatus.Callback f25574e;

    /* renamed from: f */
    private int f25575f;

    /* renamed from: g */
    private boolean f25576g;

    /* renamed from: com.huawei.hms.locationSdk.s$a */
    public class a extends GnssStatus.Callback {
        public a() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            C5752s.this.m33152a(gnssStatus);
        }
    }

    public C5752s(C5746q c5746q) {
        this.f25575f = c5746q.m33149g();
    }

    /* renamed from: b */
    private LocationManager m33156b() {
        Object systemService = C11991a.m72145a().getSystemService(JsbMapKeyNames.H5_LOC);
        if (systemService instanceof LocationManager) {
            return (LocationManager) systemService;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ int m33155b(C5755t c5755t, C5755t c5755t2) {
        return Float.compare(c5755t2.m33162a(), c5755t.m33162a());
    }

    /* renamed from: a */
    public String m33159a() {
        if (!this.f25571b.get() || this.f25570a.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<C5749r> it = this.f25570a.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
            sb2.append(",");
        }
        sb2.deleteCharAt(sb2.length() - 1);
        this.f25570a.clear();
        return sb2.toString();
    }

    /* renamed from: c */
    public void m33161c() {
        HMSLocationLog.m36657d("GnssStatusCollector", "", "stop");
        this.f25571b.set(false);
        this.f25570a.clear();
        LocationManager locationManagerM33156b = m33156b();
        if (locationManagerM33156b == null) {
            return;
        }
        locationManagerM33156b.unregisterGnssStatusCallback(this.f25574e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m33151a(C5755t c5755t, C5755t c5755t2) {
        return Double.compare(c5755t2.m33162a(), c5755t.m33162a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m33152a(GnssStatus gnssStatus) {
        try {
            int satelliteCount = gnssStatus.getSatelliteCount();
            long jCurrentTimeMillis = System.currentTimeMillis();
            PriorityQueue priorityQueue = new PriorityQueue(new Comparator() { // from class: com.huawei.hms.locationSdk.c2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C5752s.m33151a((C5755t) obj, (C5755t) obj2);
                }
            });
            for (int i10 = 0; i10 < satelliteCount; i10++) {
                priorityQueue.add(new C5755t().m33164a(gnssStatus.getSvid(i10)).m33166b(gnssStatus.getCn0DbHz(i10)).m33165a(gnssStatus.usedInFix(i10)).m33167c(gnssStatus.getElevationDegrees(i10)).m33163a(gnssStatus.getAzimuthDegrees(i10)));
            }
            C5749r c5749r = new C5749r(satelliteCount, jCurrentTimeMillis, (List) priorityQueue.stream().sorted(new Comparator() { // from class: com.huawei.hms.locationSdk.d2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C5752s.m33155b((C5755t) obj, (C5755t) obj2);
                }
            }).limit(this.f25575f).collect(Collectors.toList()));
            if (this.f25570a.size() == this.f25572c) {
                this.f25570a.poll();
            }
            this.f25570a.offer(c5749r);
            if (this.f25576g) {
                HMSLocationLog.m36662i("GnssStatusCollector", "", "gnssStatusChanged:" + c5749r);
            } else {
                HMSLocationLog.m36662i("GnssStatusCollector", "", "gnssStatusChanged");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public boolean m33160a(int i10, Looper looper, boolean z10) {
        if (this.f25571b.get()) {
            return true;
        }
        this.f25576g = z10;
        this.f25571b.set(true);
        if (this.f25570a == null) {
            this.f25570a = new LinkedBlockingQueue<>(i10);
        }
        this.f25572c = i10;
        HMSLocationLog.m36662i("GnssStatusCollector", "", "start gnss");
        return m33154a(looper);
    }

    /* renamed from: a */
    private boolean m33154a(Looper looper) {
        LocationManager locationManagerM33156b = m33156b();
        if (locationManagerM33156b == null) {
            return false;
        }
        if (this.f25573d == null) {
            this.f25573d = new Handler(looper);
        }
        if (this.f25574e == null) {
            this.f25574e = new a();
        }
        return locationManagerM33156b.registerGnssStatusCallback(this.f25574e, this.f25573d);
    }
}
