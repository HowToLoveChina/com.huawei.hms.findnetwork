package p366if;

import android.app.Application;
import android.location.Address;
import android.location.Location;
import android.text.TextUtils;
import com.baidu.geocoder.BaiduGeocodeProvider;
import com.baidu.location.LocationClient;
import eg.AbstractC9478g;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import p015ak.C0209d;
import p015ak.C0213f;
import p616rk.C12515a;
import p809yg.C13981a;

/* renamed from: if.l */
/* loaded from: classes4.dex */
public class C10487l {

    /* renamed from: c */
    public static final BigDecimal f50602c = new BigDecimal("3.1415926535897932384626");

    /* renamed from: d */
    public static final BigDecimal f50603d = new BigDecimal("6378245");

    /* renamed from: e */
    public static final BigDecimal f50604e = new BigDecimal("0.00669342162296594323");

    /* renamed from: f */
    public static final BigDecimal f50605f = new BigDecimal("10");

    /* renamed from: g */
    public static final BigDecimal f50606g = new BigDecimal("2");

    /* renamed from: h */
    public static final BigDecimal f50607h = new BigDecimal("105");

    /* renamed from: i */
    public static final BigDecimal f50608i = new BigDecimal("3");

    /* renamed from: j */
    public static final BigDecimal f50609j = new BigDecimal("35");

    /* renamed from: k */
    public static final BigDecimal f50610k = new BigDecimal("160");

    /* renamed from: l */
    public static final BigDecimal f50611l = new BigDecimal("1");

    /* renamed from: m */
    public static final BigDecimal f50612m = new BigDecimal("150");

    /* renamed from: n */
    public static final BigDecimal f50613n = new BigDecimal("180");

    /* renamed from: o */
    public static final BigDecimal f50614o = new BigDecimal("72.004");

    /* renamed from: p */
    public static final BigDecimal f50615p = new BigDecimal("137.8347");

    /* renamed from: q */
    public static final BigDecimal f50616q = new BigDecimal("18.2294");

    /* renamed from: r */
    public static final BigDecimal f50617r = new BigDecimal("53.3283");

    /* renamed from: a */
    public LocationClient f50618a;

    /* renamed from: b */
    public String f50619b;

    /* renamed from: if.l$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ LocationClient f50620a;

        /* renamed from: b */
        public final /* synthetic */ Location f50621b;

        /* renamed from: c */
        public final /* synthetic */ b f50622c;

        public a(LocationClient locationClient, Location location, b bVar) {
            this.f50620a = locationClient;
            this.f50621b = location;
            this.f50622c = bVar;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            int iRequestLocation;
            C13981a.m83989i("LocationClientUtils", "start requestLocation ");
            try {
                iRequestLocation = this.f50620a.requestLocation(this.f50621b, 20000);
            } catch (Exception e10) {
                C13981a.m83989i("LocationClientUtils", "requestLocation error: " + e10.getMessage());
                iRequestLocation = -1;
            }
            C13981a.m83989i("LocationClientUtils", "location result:" + iRequestLocation + ",accuracy:" + this.f50621b.getAccuracy());
            b bVar = this.f50622c;
            if (bVar != null) {
                if (iRequestLocation == 66 || iRequestLocation == 161) {
                    bVar.mo26992a(this.f50621b);
                } else {
                    bVar.mo26993b();
                }
            }
        }
    }

    /* renamed from: if.l$b */
    public interface b {
        /* renamed from: a */
        void mo26992a(Location location);

        /* renamed from: b */
        void mo26993b();
    }

    /* renamed from: if.l$c */
    public static class c {

        /* renamed from: a */
        public static C10487l f50623a = new C10487l(null);
    }

    public /* synthetic */ C10487l(a aVar) {
        this();
    }

    /* renamed from: b */
    public static C10487l m64536b() {
        return c.f50623a;
    }

    /* renamed from: c */
    public static String m64537c(Address address, boolean z10) {
        if (address == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            if (!TextUtils.isEmpty(address.getCountryName())) {
                sb2.append(address.getCountryName().trim());
            }
            if (!TextUtils.isEmpty(address.getAdminArea())) {
                sb2.append(address.getAdminArea().trim());
            }
            if (!TextUtils.isEmpty(address.getLocality())) {
                sb2.append(address.getLocality().trim());
            }
            if (!TextUtils.isEmpty(address.getSubLocality())) {
                sb2.append(address.getSubLocality().trim());
            }
            if (!TextUtils.isEmpty(address.getThoroughfare())) {
                sb2.append(address.getThoroughfare().trim());
            }
        } else {
            if (!TextUtils.isEmpty(address.getThoroughfare())) {
                sb2.append(address.getThoroughfare().trim());
                sb2.append(" ");
            }
            if (!TextUtils.isEmpty(address.getSubLocality())) {
                sb2.append(address.getSubLocality().trim());
            }
            if (!TextUtils.isEmpty(address.getLocality())) {
                sb2.append(" ");
                sb2.append(address.getLocality().trim());
            }
            if (!TextUtils.isEmpty(address.getAdminArea())) {
                sb2.append(" ");
                sb2.append(address.getAdminArea().trim());
            }
            if (!TextUtils.isEmpty(address.getCountryName())) {
                sb2.append(" ");
                sb2.append(address.getCountryName().trim());
            }
        }
        return sb2.toString();
    }

    /* renamed from: e */
    public static void m64538e(LocationClient locationClient, Location location, b bVar) {
        if (locationClient != null && location != null) {
            C12515a.m75110o().m75172d(new a(locationClient, location, bVar));
        } else if (bVar != null) {
            bVar.mo26993b();
        }
    }

    /* renamed from: f */
    public static boolean m64539f(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        return m64540g(new BigDecimal(longitude + ""), new BigDecimal(latitude + ""));
    }

    /* renamed from: g */
    public static boolean m64540g(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        ArrayList arrayList = new ArrayList();
        BaiduGeocodeProvider baiduGeocodeProvider = new BaiduGeocodeProvider(C0213f.m1377a());
        baiduGeocodeProvider.setUuid(m64536b().m64547d());
        baiduGeocodeProvider.onGetFromLocation(bigDecimal2.floatValue(), bigDecimal.floatValue(), 3, arrayList);
        if (!C0209d.m1205R0(arrayList)) {
            String str = (String) Optional.ofNullable((Address) arrayList.get(0)).map(new Function() { // from class: if.k
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Address) obj).getCountryCode();
                }
            }).orElse("");
            if (!TextUtils.isEmpty(str)) {
                return ("CN".equalsIgnoreCase(str) || "0".equalsIgnoreCase(str)) ? false : true;
            }
        }
        return bigDecimal.compareTo(f50614o) < 0 || bigDecimal.compareTo(f50615p) > 0 || bigDecimal2.compareTo(f50616q) < 0 || bigDecimal2.compareTo(f50617r) > 0;
    }

    /* renamed from: h */
    public static BigDecimal m64541h(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3 = new BigDecimal("-1");
        BigDecimal bigDecimal4 = f50605f;
        BigDecimal bigDecimalMultiply = bigDecimal3.multiply(bigDecimal4).multiply(bigDecimal4);
        BigDecimal bigDecimal5 = f50606g;
        BigDecimal bigDecimalAdd = bigDecimalMultiply.add(bigDecimal5.multiply(bigDecimal));
        BigDecimal bigDecimal6 = f50608i;
        BigDecimal bigDecimalAdd2 = bigDecimalAdd.add(bigDecimal6.multiply(bigDecimal2)).add(bigDecimal5.divide(bigDecimal4, 15, 4).multiply(bigDecimal2).multiply(bigDecimal2)).add(f50611l.divide(bigDecimal4, 15, 4).multiply(bigDecimal).multiply(bigDecimal2)).add(bigDecimal5.divide(bigDecimal4, 15, 4).multiply(new BigDecimal(Math.sqrt(Math.abs(bigDecimal.doubleValue())))));
        BigDecimal bigDecimalMultiply2 = bigDecimal5.multiply(bigDecimal4);
        BigDecimal bigDecimalMultiply3 = bigDecimal5.multiply(bigDecimal6).multiply(bigDecimal);
        BigDecimal bigDecimal7 = f50602c;
        BigDecimal bigDecimalAdd3 = bigDecimalAdd2.add(bigDecimalMultiply2.multiply(new BigDecimal(Math.sin(bigDecimalMultiply3.multiply(bigDecimal7).doubleValue()))).add(bigDecimal5.multiply(bigDecimal4).multiply(new BigDecimal(Math.sin(bigDecimal5.multiply(bigDecimal).multiply(bigDecimal7).doubleValue())))).multiply(bigDecimal5).divide(bigDecimal6, 15, 4)).add(bigDecimal5.multiply(bigDecimal4).multiply(new BigDecimal(Math.sin(bigDecimal2.multiply(bigDecimal7).doubleValue()))).add(bigDecimal5.multiply(bigDecimal5).multiply(bigDecimal4).multiply(new BigDecimal(Math.sin(bigDecimal2.divide(bigDecimal6, 15, 4).multiply(bigDecimal7).doubleValue())))).multiply(bigDecimal5).divide(bigDecimal6, 15, 4));
        BigDecimal bigDecimal8 = f50610k;
        return bigDecimalAdd3.add(bigDecimal8.multiply(new BigDecimal(Math.sin(bigDecimal2.divide(bigDecimal6.multiply(bigDecimal5).multiply(bigDecimal5), 15, 4).multiply(bigDecimal7).doubleValue()))).add(bigDecimal8.multiply(bigDecimal5).multiply(new BigDecimal(Math.sin(bigDecimal2.multiply(bigDecimal7).divide(bigDecimal6.multiply(bigDecimal4), 15, 4).doubleValue())))).multiply(bigDecimal5).divide(bigDecimal6, 15, 4));
    }

    /* renamed from: i */
    public static BigDecimal m64542i(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3 = f50605f;
        BigDecimal bigDecimalMultiply = bigDecimal3.multiply(bigDecimal3);
        BigDecimal bigDecimal4 = f50608i;
        BigDecimal bigDecimalAdd = bigDecimalMultiply.multiply(bigDecimal4).add(bigDecimal);
        BigDecimal bigDecimal5 = f50606g;
        BigDecimal bigDecimalAdd2 = bigDecimalAdd.add(bigDecimal5.multiply(bigDecimal2));
        BigDecimal bigDecimal6 = f50611l;
        BigDecimal bigDecimalAdd3 = bigDecimalAdd2.add(bigDecimal6.divide(bigDecimal3, 15, 4).multiply(bigDecimal).multiply(bigDecimal)).add(bigDecimal6.divide(bigDecimal3, 15, 4).multiply(bigDecimal).multiply(bigDecimal2)).add(bigDecimal6.divide(bigDecimal3, 15, 4).multiply(new BigDecimal(Math.sqrt(Math.abs(bigDecimal.doubleValue())))));
        BigDecimal bigDecimalMultiply2 = bigDecimal5.multiply(bigDecimal3);
        BigDecimal bigDecimalMultiply3 = bigDecimal5.multiply(bigDecimal4).multiply(bigDecimal);
        BigDecimal bigDecimal7 = f50602c;
        BigDecimal bigDecimalAdd4 = bigDecimalAdd3.add(bigDecimalMultiply2.multiply(new BigDecimal(Math.sin(bigDecimalMultiply3.multiply(bigDecimal7).doubleValue()))).add(bigDecimal5.multiply(bigDecimal3).multiply(new BigDecimal(Math.sin(bigDecimal5.multiply(bigDecimal).multiply(bigDecimal7).doubleValue())))).multiply(bigDecimal5).divide(bigDecimal4, 15, 4)).add(bigDecimal5.multiply(bigDecimal3).multiply(new BigDecimal(Math.sin(bigDecimal.multiply(bigDecimal7).doubleValue()))).add(bigDecimal5.multiply(bigDecimal5).multiply(bigDecimal3).multiply(new BigDecimal(Math.sin(bigDecimal.divide(bigDecimal4, 15, 4).multiply(bigDecimal7).doubleValue())))).multiply(bigDecimal5).divide(bigDecimal4, 15, 4));
        BigDecimal bigDecimal8 = f50612m;
        return bigDecimalAdd4.add(bigDecimal8.multiply(new BigDecimal(Math.sin(bigDecimal.divide(bigDecimal5.multiply(bigDecimal5).multiply(bigDecimal4), 15, 4).multiply(bigDecimal7).doubleValue()))).add(bigDecimal8.multiply(bigDecimal5).multiply(new BigDecimal(Math.sin(bigDecimal.divide(bigDecimal4.multiply(bigDecimal3), 15, 4).multiply(bigDecimal7).doubleValue())))).multiply(bigDecimal5).divide(bigDecimal4, 15, 4));
    }

    /* renamed from: j */
    public static Location m64543j(Location location) {
        if (location == null) {
            C13981a.m83988e("LocationClientUtils", "convert desLatLng error");
            return null;
        }
        double[] dArrWgs842bd09 = m64536b().m64546a().wgs842bd09(location.getLatitude(), location.getLongitude());
        if (dArrWgs842bd09 == null) {
            return location;
        }
        Location location2 = new Location(location);
        location2.setLatitude(dArrWgs842bd09[0]);
        location2.setLongitude(dArrWgs842bd09[1]);
        return location2;
    }

    /* renamed from: k */
    public static double[] m64544k(double d10, double d11) {
        return m64536b().m64546a().wgs842bd09(d10, d11);
    }

    /* renamed from: l */
    public static Location m64545l(Location location) {
        Location location2 = new Location(location);
        if (location == null) {
            C13981a.m83988e("LocationClientUtils", "convert desLatLng error");
            return null;
        }
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        BigDecimal bigDecimal = new BigDecimal(longitude + "");
        BigDecimal bigDecimal2 = new BigDecimal(latitude + "");
        if (m64540g(bigDecimal, bigDecimal2)) {
            return location;
        }
        BigDecimal bigDecimal3 = f50607h;
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(bigDecimal3);
        BigDecimal bigDecimal4 = f50609j;
        BigDecimal bigDecimalM64541h = m64541h(bigDecimalSubtract, bigDecimal2.subtract(bigDecimal4));
        BigDecimal bigDecimalM64542i = m64542i(bigDecimal.subtract(bigDecimal3), bigDecimal2.subtract(bigDecimal4));
        BigDecimal bigDecimal5 = f50613n;
        BigDecimal bigDecimalDivide = bigDecimal2.divide(bigDecimal5, 15, 4);
        BigDecimal bigDecimal6 = f50602c;
        BigDecimal bigDecimalMultiply = bigDecimalDivide.multiply(bigDecimal6);
        BigDecimal bigDecimal7 = new BigDecimal(Math.sin(bigDecimalMultiply.doubleValue()));
        BigDecimal bigDecimal8 = f50611l;
        BigDecimal bigDecimal9 = f50604e;
        BigDecimal bigDecimalSubtract2 = bigDecimal8.subtract(bigDecimal9.multiply(bigDecimal7).multiply(bigDecimal7));
        BigDecimal bigDecimal10 = new BigDecimal(Math.sqrt(bigDecimalSubtract2.doubleValue()));
        BigDecimal bigDecimalMultiply2 = bigDecimalM64541h.multiply(bigDecimal5);
        BigDecimal bigDecimal11 = f50603d;
        BigDecimal bigDecimalDivide2 = bigDecimalMultiply2.divide(bigDecimal11.multiply(bigDecimal8.subtract(bigDecimal9)).divide(bigDecimalSubtract2.multiply(bigDecimal10), 15, 4).multiply(bigDecimal6), 15, 4);
        BigDecimal bigDecimalDivide3 = bigDecimalM64542i.multiply(bigDecimal5).divide(bigDecimal11.divide(bigDecimal10, 15, 4).multiply(new BigDecimal(Math.cos(bigDecimalMultiply.doubleValue())).multiply(bigDecimal6)), 15, 4);
        BigDecimal bigDecimalAdd = bigDecimal2.add(bigDecimalDivide2);
        location2.setLongitude(bigDecimal.add(bigDecimalDivide3).doubleValue());
        location2.setLatitude(bigDecimalAdd.doubleValue());
        return location2;
    }

    /* renamed from: a */
    public LocationClient m64546a() {
        if (this.f50618a == null) {
            this.f50618a = new LocationClient((Application) C0213f.m1377a());
        }
        this.f50618a.setUuid(this.f50619b);
        return this.f50618a;
    }

    /* renamed from: d */
    public String m64547d() {
        return this.f50619b;
    }

    public C10487l() {
        this.f50618a = new LocationClient(C0213f.m1377a());
        this.f50619b = UUID.randomUUID().toString();
    }
}
