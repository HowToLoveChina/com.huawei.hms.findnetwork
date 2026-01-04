package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.Calendar;

/* renamed from: androidx.appcompat.app.q */
/* loaded from: classes.dex */
public class C0392q {

    /* renamed from: d */
    public static C0392q f1394d;

    /* renamed from: a */
    public final Context f1395a;

    /* renamed from: b */
    public final LocationManager f1396b;

    /* renamed from: c */
    public final a f1397c = new a();

    /* renamed from: androidx.appcompat.app.q$a */
    public static class a {

        /* renamed from: a */
        public boolean f1398a;

        /* renamed from: b */
        public long f1399b;
    }

    public C0392q(Context context, LocationManager locationManager) {
        this.f1395a = context;
        this.f1396b = locationManager;
    }

    /* renamed from: a */
    public static C0392q m2254a(Context context) {
        if (f1394d == null) {
            Context applicationContext = context.getApplicationContext();
            f1394d = new C0392q(applicationContext, (LocationManager) applicationContext.getSystemService(JsbMapKeyNames.H5_LOC));
        }
        return f1394d;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public final Location m2255b() {
        Location locationM2256c = PermissionChecker.checkSelfPermission(this.f1395a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m2256c("network") : null;
        Location locationM2256c2 = PermissionChecker.checkSelfPermission(this.f1395a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? m2256c("gps") : null;
        return (locationM2256c2 == null || locationM2256c == null) ? locationM2256c2 != null ? locationM2256c2 : locationM2256c : locationM2256c2.getTime() > locationM2256c.getTime() ? locationM2256c2 : locationM2256c;
    }

    /* renamed from: c */
    public final Location m2256c(String str) {
        try {
            if (this.f1396b.isProviderEnabled(str)) {
                return this.f1396b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e10) {
            Log.d("TwilightManager", "Failed to get last known location", e10);
            return null;
        }
    }

    /* renamed from: d */
    public boolean m2257d() {
        a aVar = this.f1397c;
        if (m2258e()) {
            return aVar.f1398a;
        }
        Location locationM2255b = m2255b();
        if (locationM2255b != null) {
            m2259f(locationM2255b);
            return aVar.f1398a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i10 = Calendar.getInstance().get(11);
        return i10 < 6 || i10 >= 22;
    }

    /* renamed from: e */
    public final boolean m2258e() {
        return this.f1397c.f1399b > System.currentTimeMillis();
    }

    /* renamed from: f */
    public final void m2259f(Location location) {
        long j10;
        a aVar = this.f1397c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0391p c0391pM2252b = C0391p.m2252b();
        c0391pM2252b.m2253a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        c0391pM2252b.m2253a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = c0391pM2252b.f1393c == 1;
        long j11 = c0391pM2252b.f1392b;
        long j12 = c0391pM2252b.f1391a;
        c0391pM2252b.m2253a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j13 = c0391pM2252b.f1392b;
        if (j11 == -1 || j12 == -1) {
            j10 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis > j12) {
                j11 = j13;
            } else if (jCurrentTimeMillis > j11) {
                j11 = j12;
            }
            j10 = j11 + 60000;
        }
        aVar.f1398a = z10;
        aVar.f1399b = j10;
    }
}
