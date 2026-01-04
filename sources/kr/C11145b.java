package kr;

import android.location.Location;
import android.location.LocationManager;
import android.os.HandlerThread;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import es.C9548m;
import java.util.ArrayList;
import java.util.Map;
import lr.C11338c;
import p531or.C11991a;
import p852zq.AbstractC14365f;

/* renamed from: kr.b */
/* loaded from: classes8.dex */
public final class C11145b {

    /* renamed from: e */
    public static final byte[] f52485e = new byte[0];

    /* renamed from: f */
    public static volatile C11145b f52486f;

    /* renamed from: a */
    public LocationManager f52487a;

    /* renamed from: b */
    public ArrayList f52488b = null;

    /* renamed from: c */
    public HandlerThread f52489c;

    /* renamed from: d */
    public C11338c f52490d;

    public C11145b() {
        HandlerThread handlerThread = new HandlerThread("Loc-GNSS");
        this.f52489c = handlerThread;
        handlerThread.start();
        Object systemService = C11991a.m72145a().getSystemService(JsbMapKeyNames.H5_LOC);
        if (systemService instanceof LocationManager) {
            this.f52487a = (LocationManager) systemService;
        }
    }

    /* renamed from: b */
    public static C11145b m67054b() {
        if (f52486f == null) {
            synchronized (f52485e) {
                try {
                    if (f52486f == null) {
                        f52486f = new C11145b();
                    }
                } finally {
                }
            }
        }
        return f52486f;
    }

    /* renamed from: a */
    public final synchronized Location m67055a(String str) {
        Location lastKnownLocation;
        try {
            lastKnownLocation = this.f52487a.getLastKnownLocation(str);
        } catch (SecurityException unused) {
            C1016d.m6183c("GnssClient", "getLastKnownLocation, security exception");
            lastKnownLocation = null;
        }
        return lastKnownLocation;
    }

    /* renamed from: c */
    public final synchronized void m67056c(RequestLocationUpdatesRequest requestLocationUpdatesRequest, AbstractC14365f abstractC14365f) {
        String str;
        String str2;
        Map<String, String> extras;
        if (!C9548m.m59619b(C11991a.m72145a(), "android.permission.ACCESS_FINE_LOCATION")) {
            C1016d.m6183c("GnssClient", "checkSelfPermission fail");
            return;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequest.getLocationRequest();
        if (!TextUtils.isEmpty(requestLocationUpdatesRequest.getTid()) && locationRequest != null) {
            C1016d.m6186f("GnssClient", "requestLocationUpdates, priority is " + locationRequest.getPriority() + ", interval is " + locationRequest.getInterval() + ", smallestDisplacement is " + locationRequest.getSmallestDisplacement());
            int priority = locationRequest.getPriority();
            String str3 = (priority == 100 || priority == 200 || priority == 400) ? "gps" : priority == 105 ? "passive" : "";
            if (TextUtils.isEmpty(str3)) {
                C1016d.m6183c("GnssClient", "priority is invalid");
                return;
            }
            if (str3.equals("gps") && (extras = locationRequest.getExtras()) != null && "1".equals(extras.get("SuperGnssEnable"))) {
                if (this.f52488b == null) {
                    this.f52488b = new ArrayList();
                }
                if (this.f52490d == null) {
                    this.f52490d = new C11338c();
                }
                if (this.f52490d.m68125d(locationRequest.getInterval(), locationRequest.getSmallestDisplacement(), abstractC14365f)) {
                    this.f52488b.remove(abstractC14365f);
                    this.f52488b.add(abstractC14365f);
                    return;
                }
            }
            if (this.f52489c == null) {
                HandlerThread handlerThread = new HandlerThread("Loc-GNSS");
                this.f52489c = handlerThread;
                handlerThread.start();
            }
            try {
                this.f52487a.requestLocationUpdates(str3, locationRequest.getInterval(), locationRequest.getSmallestDisplacement(), abstractC14365f, this.f52489c.getLooper());
            } catch (IllegalArgumentException unused) {
                str = "GnssClient";
                str2 = "LocationManager requestLocationUpdates throw IllegalArgumentException";
                C1016d.m6183c(str, str2);
                return;
            } catch (SecurityException unused2) {
                str = "GnssClient";
                str2 = "LocationManager requestLocationUpdates throw SecurityException";
                C1016d.m6183c(str, str2);
                return;
            } catch (Exception unused3) {
                str = "GnssClient";
                str2 = "LocationManager requestLocationUpdates throw other exception";
                C1016d.m6183c(str, str2);
                return;
            }
            return;
        }
        C1016d.m6183c("GnssClient", "requestLocationUpdatesRequest is invalid");
    }

    /* renamed from: d */
    public final synchronized void m67057d(AbstractC14365f abstractC14365f) {
        C1016d.m6186f("GnssClient", "removeLocationUpdates");
        if (!C9548m.m59619b(C11991a.m72145a(), "android.permission.ACCESS_FINE_LOCATION")) {
            C1016d.m6183c("GnssClient", "checkSelfPermission fail");
            return;
        }
        ArrayList arrayList = this.f52488b;
        if (arrayList == null || !arrayList.remove(abstractC14365f)) {
            this.f52487a.removeUpdates(abstractC14365f);
        } else {
            this.f52490d.m68124b(abstractC14365f);
        }
    }
}
