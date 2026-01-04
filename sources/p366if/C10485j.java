package p366if;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationEnhanceService;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationSceneRequest;
import com.huawei.hms.location.LocationSceneResponse;
import com.huawei.hms.location.LocationServices;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.riemann.location.common.utils.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p774xg.C13812b;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: if.j */
/* loaded from: classes4.dex */
public class C10485j {

    /* renamed from: F */
    public static final List<List<double[]>> f50554F = new ArrayList();

    /* renamed from: G */
    public static Handler f50555G = null;

    /* renamed from: H */
    public static boolean f50556H = false;

    /* renamed from: I */
    public static Location f50557I;

    /* renamed from: A */
    public LocationListener f50558A;

    /* renamed from: B */
    public LocationListener f50559B;

    /* renamed from: i */
    public final Context f50571i;

    /* renamed from: j */
    public final String f50572j;

    /* renamed from: k */
    public final boolean f50573k;

    /* renamed from: l */
    public final int f50574l;

    /* renamed from: m */
    public final LocationEnhanceService f50575m;

    /* renamed from: n */
    public final String f50576n;

    /* renamed from: o */
    public LocationManager f50577o;

    /* renamed from: p */
    public FusedLocationProviderClient f50578p;

    /* renamed from: t */
    public Location f50582t;

    /* renamed from: u */
    public Location f50583u;

    /* renamed from: v */
    public Location f50584v;

    /* renamed from: w */
    public long f50585w;

    /* renamed from: x */
    public long f50586x;

    /* renamed from: z */
    public LocationListener f50588z;

    /* renamed from: a */
    public final int f50563a = 3000;

    /* renamed from: b */
    public final int f50564b = 800;

    /* renamed from: c */
    public final int f50565c = 500;

    /* renamed from: d */
    public final int f50566d = 30000;

    /* renamed from: e */
    public final int f50567e = 20000;

    /* renamed from: f */
    public final int f50568f = 30000;

    /* renamed from: g */
    public final int f50569g = 30;

    /* renamed from: h */
    public final int f50570h = 201;

    /* renamed from: r */
    public boolean f50580r = false;

    /* renamed from: s */
    public long f50581s = 0;

    /* renamed from: y */
    public boolean f50587y = true;

    /* renamed from: C */
    public final LocationCallback f50560C = new a();

    /* renamed from: D */
    public final LocationListener f50561D = new b();

    /* renamed from: E */
    public final LocationListener f50562E = new c();

    /* renamed from: q */
    public j f50579q = new j(m64495v().getLooper());

    /* renamed from: if.j$a */
    public class a extends LocationCallback {
        public a() {
        }

        @Override // com.huawei.hms.location.LocationCallback
        public void onLocationResult(LocationResult locationResult) {
            C13981a.m83989i(C10485j.this.f50572j, "hmsNetworkLocationCallback get hms network location");
            C10485j.this.m64506K(locationResult);
        }
    }

    /* renamed from: if.j$b */
    public class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (C10485j.this.f50588z == null) {
                return;
            }
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putInt("locationRouter", C10485j.this.f50574l);
            extras.putLong("delayTime", System.currentTimeMillis() - C10485j.this.f50586x);
            location.setExtras(extras);
            C10485j.this.f50588z.onLocationChanged(location);
        }
    }

    /* renamed from: if.j$c */
    public class c implements LocationListener {
        public c() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (C10485j.this.f50558A == null) {
                return;
            }
            C13981a.m83989i(C10485j.this.f50572j, "switchGpsListener get gps location: " + C10485j.this.f50573k);
            if (!C10485j.this.f50573k) {
                Bundle extras = location.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putInt("locationRouter", C10485j.this.f50574l);
                extras.putLong("delayTime", System.currentTimeMillis() - C10485j.this.f50585w);
                location.setExtras(extras);
                C10485j.this.f50558A.onLocationChanged(location);
                return;
            }
            if (C10485j.this.f50579q != null) {
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putParcelable(JsbMapKeyNames.H5_LOC, location);
                message.setData(bundle);
                message.what = 3;
                C10485j.this.f50579q.sendMessage(message);
            }
        }
    }

    /* renamed from: if.j$d */
    public class d implements InterfaceC8938f {
        public d() {
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            C10485j.this.m64513R(TrackConstants$Opers.REQUEST, exc == null ? "" : exc.getMessage());
        }
    }

    /* renamed from: if.j$e */
    public class e implements InterfaceC8939g<Void> {
        public e() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(Void r12) {
            C13981a.m83989i(C10485j.this.f50572j, "location request onSuccess");
        }
    }

    /* renamed from: if.j$f */
    public class f implements InterfaceC8938f {
        public f() {
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            BaseLogger.m28732e(C10485j.this.f50572j, "remove location updates onFailure ", exc == null ? "" : exc.getMessage());
            C10485j.this.m64513R(SyncProtocol.Constant.REMOVE, exc != null ? exc.getMessage() : "");
        }
    }

    /* renamed from: if.j$g */
    public class g implements InterfaceC8939g<Void> {
        public g() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(Void r12) {
            C13981a.m83989i(C10485j.this.f50572j, "remove location updates onSuccess");
        }
    }

    /* renamed from: if.j$h */
    public class h implements InterfaceC8938f {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f50596a;

        public h(CountDownLatch countDownLatch) {
            this.f50596a = countDownLatch;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            C13981a.m83988e(C10485j.this.f50572j, "HDPolygon: getLocationSceneResponse " + exc.getMessage());
            this.f50596a.countDown();
        }
    }

    /* renamed from: if.j$i */
    public class i implements InterfaceC8939g<LocationSceneResponse> {

        /* renamed from: a */
        public final /* synthetic */ String[] f50598a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f50599b;

        public i(String[] strArr, CountDownLatch countDownLatch) {
            this.f50598a = strArr;
            this.f50599b = countDownLatch;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(LocationSceneResponse locationSceneResponse) {
            if (locationSceneResponse != null && locationSceneResponse.getResponseMap() != null) {
                HashMap<String, String> responseMap = locationSceneResponse.getResponseMap();
                boolean unused = C10485j.f50556H = responseMap.containsKey("polygons");
                this.f50598a[0] = responseMap.getOrDefault("polygons", "");
            }
            this.f50599b.countDown();
        }
    }

    /* renamed from: if.j$j */
    public class j extends Handler {
        public j(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws InterruptedException {
            C10485j.this.m64505J(message);
        }
    }

    public C10485j(Context context, String str) {
        this.f50571i = context;
        this.f50572j = str;
        this.f50578p = LocationServices.getFusedLocationProviderClient(context);
        int locationRouter = ParamConfig.getInstance().getLocationRouter();
        this.f50574l = locationRouter;
        this.f50573k = locationRouter == 1;
        this.f50575m = new LocationEnhanceService(context);
        this.f50576n = UUID.randomUUID().toString();
    }

    /* renamed from: v */
    public static synchronized Handler m64495v() {
        try {
            if (f50555G == null) {
                HandlerThread handlerThread = new HandlerThread("location-ability");
                handlerThread.start();
                f50555G = new Handler(handlerThread.getLooper());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f50555G;
    }

    /* renamed from: A */
    public final boolean m64496A(Map<String, Object> map) {
        if (map == null || map.isEmpty() || !map.containsKey("isHdNlpLocation")) {
            return false;
        }
        Object obj = map.get("isHdNlpLocation");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    /* renamed from: B */
    public synchronized boolean m64497B() {
        if (!this.f50573k) {
            return false;
        }
        if (Math.abs(System.currentTimeMillis() - this.f50581s) > 30000) {
            return false;
        }
        return this.f50580r;
    }

    /* renamed from: C */
    public boolean m64498C(Location location) throws InterruptedException {
        boolean z10 = false;
        if (location == null) {
            C13981a.m83989i(this.f50572j, "HDPolygon: location is null");
            return false;
        }
        if (f50557I == null) {
            C13981a.m83989i(this.f50572j, "HDPolygon: get plg in this");
            m64526s(location);
        }
        if (!f50556H) {
            C13981a.m83989i(this.f50572j, "HDPolygon: isSupportCacheFence false");
            return false;
        }
        ArrayList arrayList = new ArrayList(f50554F);
        if (arrayList.size() > 500) {
            C13981a.m83989i(this.f50572j, "HDPolygon: polygon too match");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            try {
            } catch (Exception e10) {
                C13981a.m83988e(this.f50572j, "HDPolygon: pointInsidePolygon " + e10.getMessage());
            }
            if (m64502G(location, (List) it.next())) {
                z10 = true;
                break;
            }
        }
        C13981a.m83989i(this.f50572j, "HDPolygon: isInHdFence: res: " + z10);
        return z10;
    }

    /* renamed from: D */
    public boolean m64499D(String str) {
        return C13812b.m82847r(this.f50571i, str);
    }

    /* renamed from: E */
    public final boolean m64500E(Location location) throws InterruptedException {
        Bundle extras = location.getExtras();
        if (extras != null && extras.getInt(Constant.LOCATION_SOURCE_TYPE) == 128) {
            C13981a.m83989i(this.f50572j, "quick gps delay report.");
            return true;
        }
        if (!this.f50587y) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zM64498C = m64498C(location);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("locFenceTime", String.valueOf(jCurrentTimeMillis2));
        location.setExtras(extras);
        C13981a.m83989i(this.f50572j, "HDPolygon: isInHdFence: diffTime: " + jCurrentTimeMillis2);
        return zM64498C;
    }

    /* renamed from: F */
    public final void m64501F(String str) {
        if (str == null || "".equals(str)) {
            return;
        }
        f50554F.clear();
        String[] strArrSplit = str.split("\\|");
        for (String str2 : strArrSplit) {
            if (str2 != null && !"".equals(str2)) {
                ArrayList arrayList = new ArrayList();
                String[] strArrSplit2 = str2.split(",");
                if (strArrSplit2.length > 6) {
                    int length = strArrSplit2.length / 2;
                    double[] dArr = new double[length];
                    double[] dArr2 = new double[length];
                    boolean z10 = true;
                    for (int i10 = 0; i10 < length; i10++) {
                        int i11 = i10 * 2;
                        try {
                            String str3 = strArrSplit2[i11 + 1];
                            String str4 = strArrSplit2[i11];
                            dArr[i10] = Double.parseDouble(str3);
                            dArr2[i10] = Double.parseDouble(str4);
                        } catch (Exception e10) {
                            C13981a.m83988e(this.f50572j, "HDPolygon: parse polygon error " + e10.getMessage());
                            z10 = false;
                        }
                    }
                    if (z10) {
                        arrayList.add(dArr);
                        arrayList.add(dArr2);
                        f50554F.add(arrayList);
                    }
                }
            }
        }
        C13981a.m83989i(this.f50572j, "HDPolygon: get polygon " + f50554F.size() + " raw: " + strArrSplit.length);
    }

    /* renamed from: G */
    public final boolean m64502G(Location location, List<double[]> list) {
        int i10;
        int i11;
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        boolean z10 = false;
        if (!m64521n(latitude, longitude, list)) {
            return false;
        }
        double[] dArr = list.get(1);
        double[] dArr2 = list.get(0);
        int i12 = 0;
        int i13 = 0;
        for (int length = dArr.length; i12 < length - 1; length = i10) {
            if (m64523p(dArr2[i12], longitude) != 0 || m64523p(dArr[i12], latitude) != 0) {
                int i14 = i12 + 1;
                if (m64523p(dArr2[i12], dArr2[i14]) == 0 && m64523p(dArr2[i12], longitude) == 0) {
                    i10 = length;
                    i11 = i12;
                    if (m64530x(latitude, dArr[i12], dArr[i14])) {
                    }
                } else {
                    i10 = length;
                    i11 = i12;
                }
                if (m64523p(dArr[i11], dArr[i14]) != 0 || m64523p(dArr[i11], latitude) != 0 || !m64530x(longitude, dArr2[i11], dArr2[i14])) {
                    double d10 = dArr[i11];
                    if ((latitude > d10 && latitude < dArr[i14]) || (latitude > dArr[i14] && latitude < d10)) {
                        if (m64523p(d10, dArr[i14]) == 0) {
                            break;
                        }
                        double d11 = dArr2[i11];
                        double d12 = d11 - dArr2[i14];
                        double d13 = dArr[i11];
                        if (d11 - ((d12 * (d13 - latitude)) / (d13 - dArr[i14])) < longitude) {
                            i13++;
                        }
                    }
                    i12 = i14;
                }
            }
            z10 = true;
        }
        if (i13 % 2 != 0) {
            return true;
        }
        return z10;
    }

    /* renamed from: H */
    public final void m64503H(Message message) {
        Location location;
        if (message.getData() == null || !(message.getData().getParcelable(JsbMapKeyNames.H5_LOC) instanceof Location)) {
            location = null;
        } else {
            location = (Location) message.getData().getParcelable(JsbMapKeyNames.H5_LOC);
            if (Math.abs(location.getLatitude() - 0.0d) < 1.0E-8d && Math.abs(location.getLongitude() - 0.0d) < 1.0E-8d) {
                C13981a.m83988e(this.f50572j, "invalid longitude and latitude data");
                return;
            }
        }
        if (location == null) {
            return;
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putLong("delayTime", System.currentTimeMillis() - this.f50585w);
        extras.putInt("locationRouter", this.f50574l);
        extras.putString("locCpTransId", this.f50576n);
        location.setExtras(extras);
        this.f50583u = new Location(location);
        if (m64497B()) {
            m64512Q(m64522o());
        } else if (m64500E(location)) {
            C13981a.m83989i(this.f50572j, "needWaitHdLocation ");
            if (!this.f50579q.hasMessages(2)) {
                this.f50579q.sendEmptyMessageDelayed(2, 3000L);
            }
        } else {
            C13981a.m83989i(this.f50572j, "not needWaitHdLocation ");
            m64512Q(location);
        }
        j jVar = this.f50579q;
        if (jVar != null) {
            jVar.obtainMessage(4).sendToTarget();
        }
    }

    /* renamed from: I */
    public final void m64504I(Message message) {
        Location location;
        Map<String, Object> map = new HashMap<>();
        Object obj = message.obj;
        if (obj instanceof Map) {
            map = (Map) obj;
        }
        if (message.getData() == null || !(message.getData().getParcelable(JsbMapKeyNames.H5_LOC) instanceof Location)) {
            location = null;
        } else {
            location = (Location) message.getData().getParcelable(JsbMapKeyNames.H5_LOC);
            if (Math.abs(location.getLatitude() - 0.0d) < 1.0E-8d && Math.abs(location.getLongitude() - 0.0d) < 1.0E-8d) {
                C13981a.m83988e(this.f50572j, "invalid longitude and latitude data");
                return;
            }
        }
        if (location == null) {
            C13981a.m83988e(this.f50572j, "invalid network location data");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("delayTime", System.currentTimeMillis() - this.f50586x);
        bundle.putString("locCpTransId", this.f50576n);
        Object orDefault = map.getOrDefault("session_id", "");
        if (orDefault != null) {
            bundle.putString("locSessionId", orDefault.toString());
        } else {
            bundle.putString("locSessionId", "");
        }
        bundle.putInt("locationRouter", this.f50574l);
        location.setExtras(bundle);
        if (m64496A(map)) {
            m64520m(location, map);
            m64519X(true);
            m64512Q(location);
            this.f50584v = new Location(location);
            this.f50579q.removeMessages(2);
            return;
        }
        this.f50582t = new Location(location);
        if (m64531y(map) || m64498C(location)) {
            m64519X(true);
            if (this.f50579q.hasMessages(2)) {
                return;
            }
            C13981a.m83989i(this.f50572j, "delay report location");
            this.f50579q.sendEmptyMessageDelayed(2, 3000L);
            return;
        }
        if (C13812b.m82837h(location) >= 500) {
            m64512Q(location);
        } else {
            if (this.f50579q.hasMessages(2)) {
                return;
            }
            C13981a.m83989i(this.f50572j, "delay report location case first network");
            this.f50579q.sendEmptyMessageDelayed(2, 800L);
        }
    }

    /* renamed from: J */
    public final void m64505J(Message message) throws InterruptedException {
        if (message == null) {
            return;
        }
        int i10 = message.what;
        if (i10 == 1) {
            m64504I(message);
            return;
        }
        if (i10 == 2) {
            m64514S();
            return;
        }
        if (i10 == 3) {
            m64503H(message);
            return;
        }
        if (i10 == 4) {
            m64526s(this.f50583u);
            return;
        }
        if (i10 != 5) {
            return;
        }
        try {
            Location location = (Location) message.obj;
            if (location != null) {
                m64526s(location);
            }
        } catch (Exception unused) {
            C13981a.m83988e(this.f50572j, "get polygon extra: location error");
        }
    }

    /* renamed from: K */
    public final void m64506K(LocationResult locationResult) {
        if (locationResult == null || locationResult.getLastHWLocation() == null) {
            C13981a.m83989i(this.f50572j, "hwLocation is null");
            return;
        }
        HWLocation lastHWLocation = locationResult.getLastHWLocation();
        Location location = new Location("network");
        location.setLatitude(lastHWLocation.getLatitude());
        location.setLongitude(lastHWLocation.getLongitude());
        location.setAccuracy(lastHWLocation.getAccuracy());
        location.setTime(lastHWLocation.getTime());
        location.setSpeed(lastHWLocation.getSpeed());
        Map<String, Object> extraInfo = lastHWLocation.getExtraInfo();
        HashMap map = new HashMap();
        if (extraInfo != null && !extraInfo.isEmpty()) {
            map.putAll(extraInfo);
        }
        if (this.f50579q != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putParcelable(JsbMapKeyNames.H5_LOC, location);
            message.setData(bundle);
            message.obj = map;
            message.what = 1;
            this.f50579q.sendMessage(message);
        }
    }

    /* renamed from: L */
    public void m64507L(int i10, C10495t c10495t) {
        if (i10 == 1) {
            m64508M(c10495t);
            return;
        }
        if (i10 == 2) {
            m64511P(c10495t);
        } else {
            if (i10 != 3) {
                return;
            }
            m64508M(c10495t);
            m64511P(c10495t);
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: M */
    public synchronized boolean m64508M(LocationListener locationListener) {
        C13981a.m83989i(this.f50572j, "removeGpsLocation useLocationKit " + this.f50573k);
        if (this.f50577o == null) {
            LocationManager locationManager = (LocationManager) this.f50571i.getSystemService(JsbMapKeyNames.H5_LOC);
            this.f50577o = locationManager;
            if (locationManager == null) {
                return false;
            }
        }
        if (locationListener != null) {
            this.f50577o.removeUpdates(locationListener);
        }
        this.f50577o.removeUpdates(this.f50562E);
        return true;
    }

    /* renamed from: N */
    public final void m64509N() {
        m64510O("network", this.f50560C);
    }

    /* renamed from: O */
    public final void m64510O(String str, LocationCallback locationCallback) {
        C13981a.m83989i(this.f50572j, "removeHmsLocation " + str);
        FusedLocationProviderClient fusedLocationProviderClient = this.f50578p;
        if (fusedLocationProviderClient == null) {
            C13981a.m83988e(this.f50572j, "fusedLocationProviderClient is null");
        } else {
            fusedLocationProviderClient.removeLocationUpdates(locationCallback).addOnSuccessListener(new g()).addOnFailureListener(new f());
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: P */
    public synchronized boolean m64511P(LocationListener locationListener) {
        try {
            C13981a.m83989i(this.f50572j, "removeNetworkLocation useLocationKit " + this.f50573k);
            if (this.f50573k) {
                m64509N();
            }
            if (this.f50577o == null) {
                LocationManager locationManager = (LocationManager) this.f50571i.getSystemService(JsbMapKeyNames.H5_LOC);
                this.f50577o = locationManager;
                if (locationManager == null) {
                    return false;
                }
            }
            if (locationListener != null) {
                this.f50577o.removeUpdates(locationListener);
            }
            this.f50577o.removeUpdates(this.f50561D);
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: Q */
    public final void m64512Q(Location location) {
        if (location == null) {
            return;
        }
        C13981a.m83989i(this.f50572j, "reportLocation: hd=" + m64532z(location));
        if ("gps".equals(location.getProvider())) {
            LocationListener locationListener = this.f50558A;
            if (locationListener != null) {
                locationListener.onLocationChanged(location);
            }
        } else {
            LocationListener locationListener2 = this.f50559B;
            if (locationListener2 != null) {
                locationListener2.onLocationChanged(location);
            }
        }
        this.f50587y = false;
    }

    /* renamed from: R */
    public final void m64513R(String str, String str2) {
        C13981a.m83989i(this.f50572j, "reportLocationFailMsg");
        new C12797b().m76785k(this.f50571i, this.f50572j, "-1", str + "location fail : " + str2, null, "01070", null, "location_fail", true, null);
    }

    /* renamed from: S */
    public final void m64514S() {
        m64512Q(m64522o());
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: T */
    public synchronized boolean m64515T(LocationListener locationListener, long j10, int i10) {
        C13981a.m83989i(this.f50572j, "requestGpsLocation useLocationKit " + this.f50573k);
        this.f50585w = System.currentTimeMillis();
        if (this.f50577o == null) {
            LocationManager locationManager = (LocationManager) this.f50571i.getSystemService(JsbMapKeyNames.H5_LOC);
            this.f50577o = locationManager;
            if (locationManager == null) {
                C13981a.m83990w(this.f50572j, "requestGpsLocation locationManager null");
                return false;
            }
        }
        if (!C13812b.m82847r(this.f50571i, "gps")) {
            C13981a.m83990w(this.f50572j, "requestGpsLocation gps_provider not enable");
            return false;
        }
        this.f50558A = locationListener;
        this.f50577o.requestLocationUpdates("gps", j10, i10, this.f50562E);
        return true;
    }

    /* renamed from: U */
    public final void m64516U() throws IllegalArgumentException {
        C13981a.m83989i(this.f50572j, "requestHmsHdNetworkLocation");
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(20000L);
        locationRequest.setPriority(300);
        locationRequest.setExpirationDuration(30000L);
        locationRequest.setFastestInterval(20000L);
        locationRequest.setNumUpdates(30);
        locationRequest.putExtras(LocationRequestHelper.CP_TRANS_ID, this.f50576n);
        m64517V(locationRequest, this.f50560C);
    }

    /* renamed from: V */
    public final void m64517V(LocationRequest locationRequest, LocationCallback locationCallback) {
        FusedLocationProviderClient fusedLocationProviderClient = this.f50578p;
        if (fusedLocationProviderClient == null) {
            C13981a.m83988e(this.f50572j, "fusedLocationProviderClient is null");
        } else {
            fusedLocationProviderClient.requestLocationUpdatesEx(locationRequest, locationCallback, Looper.getMainLooper()).addOnSuccessListener(new e()).addOnFailureListener(new d());
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: W */
    public synchronized boolean m64518W(LocationListener locationListener, long j10, int i10) {
        C13981a.m83989i(this.f50572j, "requestNetworkLocation useLocationKit " + this.f50573k);
        this.f50586x = System.currentTimeMillis();
        if (this.f50573k) {
            m64516U();
            this.f50559B = locationListener;
            return true;
        }
        if (this.f50577o == null) {
            LocationManager locationManager = (LocationManager) this.f50571i.getSystemService(JsbMapKeyNames.H5_LOC);
            this.f50577o = locationManager;
            if (locationManager == null) {
                C13981a.m83990w(this.f50572j, "requestNetworkLocation locationManager null");
                return false;
            }
        }
        if (!C13812b.m82847r(this.f50571i, "network")) {
            C13981a.m83990w(this.f50572j, "requestNetworkLocation network_provider not enable");
            return false;
        }
        this.f50588z = locationListener;
        this.f50577o.requestLocationUpdates("network", j10, i10, this.f50561D);
        return true;
    }

    /* renamed from: X */
    public final void m64519X(boolean z10) {
        this.f50580r = z10;
        this.f50581s = System.currentTimeMillis();
    }

    /* renamed from: m */
    public final void m64520m(Location location, Map<String, Object> map) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        Object obj = map.get("floor");
        if (obj == null) {
            return;
        }
        try {
            extras.putString("floor", ((Integer) obj).intValue() + "F");
            Object obj2 = map.get("floorAcc");
            if (obj2 != null) {
                try {
                    extras.putInt("floorAcc", ((Integer) obj2).intValue());
                } catch (Exception unused) {
                    C13981a.m83988e(this.f50572j, "get floorAcc occur Exception");
                    return;
                }
            }
            location.setExtras(extras);
        } catch (Exception unused2) {
            C13981a.m83988e(this.f50572j, "get floor occur Exception");
        }
    }

    /* renamed from: n */
    public final boolean m64521n(double d10, double d11, List<double[]> list) {
        int length = list.get(0).length;
        if (length <= 2) {
            C13981a.m83989i(this.f50572j, "HDPolygon: the pint less " + length);
            return false;
        }
        double[] dArr = list.get(1);
        double[] dArr2 = list.get(0);
        double d12 = 90.0d;
        double d13 = 180.0d;
        double d14 = -90.0d;
        double d15 = -180.0d;
        for (int i10 = 0; i10 < length; i10++) {
            double d16 = dArr[i10];
            if (d16 >= d14) {
                d14 = d16;
            }
            if (d16 <= d12) {
                d12 = d16;
            }
            double d17 = dArr2[i10];
            if (d17 >= d15) {
                d15 = d17;
            }
            if (d17 <= d13) {
                d13 = d17;
            }
        }
        return d10 > d12 && d10 < d14 && d11 > d13 && d11 < d15;
    }

    /* renamed from: o */
    public final Location m64522o() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Location location = this.f50584v;
        if (location != null && Math.abs(location.getTime() - jCurrentTimeMillis) < 30000) {
            return this.f50584v;
        }
        if (m64497B() && Math.abs(this.f50581s - jCurrentTimeMillis) < 3000) {
            return null;
        }
        Location location2 = this.f50583u;
        if (location2 != null && Math.abs(location2.getTime() - jCurrentTimeMillis) < 30000) {
            return this.f50583u;
        }
        Location location3 = this.f50582t;
        if (location3 == null || Math.abs(location3.getTime() - jCurrentTimeMillis) >= 30000) {
            return null;
        }
        return this.f50582t;
    }

    /* renamed from: p */
    public final int m64523p(double d10, double d11) {
        double d12 = d10 - d11;
        if (Math.abs(d12) < 1.0E-6d) {
            return 0;
        }
        return d12 > 0.0d ? 1 : -1;
    }

    /* renamed from: q */
    public void m64524q(Location location) {
        if (this.f50579q != null) {
            C13981a.m83989i(this.f50572j, "get fence from offline location.");
            this.f50579q.obtainMessage(5, location).sendToTarget();
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: r */
    public synchronized GpsStatus m64525r() {
        GpsStatus gpsStatus = null;
        if (this.f50577o == null) {
            LocationManager locationManager = (LocationManager) this.f50571i.getSystemService(JsbMapKeyNames.H5_LOC);
            this.f50577o = locationManager;
            if (locationManager == null) {
                return null;
            }
        }
        try {
            gpsStatus = this.f50577o.getGpsStatus(null);
        } catch (Exception e10) {
            C13981a.m83988e(this.f50572j, "getGpsStatus error: " + e10.toString());
        }
        return gpsStatus;
    }

    /* renamed from: s */
    public final void m64526s(Location location) throws InterruptedException {
        if (location == null) {
            return;
        }
        Location location2 = f50557I;
        float fDistanceTo = location2 != null ? location.distanceTo(location2) : Float.MAX_VALUE;
        if (fDistanceTo < 2500.0f) {
            C13981a.m83989i(this.f50572j, "HDPolygon: no need refresh polygon " + fDistanceTo);
            return;
        }
        f50557I = location;
        LocationSceneRequest locationSceneRequest = new LocationSceneRequest(201);
        HashMap<String, String> map = new HashMap<>();
        map.put(JsbMapKeyNames.H5_LOC_LAT, String.valueOf(location.getLatitude()));
        map.put(JsbMapKeyNames.H5_LOC_LON, String.valueOf(location.getLongitude()));
        locationSceneRequest.setSceneParam(map);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String[] strArr = {""};
        try {
            this.f50575m.getLocationSceneResponse(locationSceneRequest).addOnSuccessListener(new i(strArr, countDownLatch)).addOnFailureListener(new h(countDownLatch));
            countDownLatch.await(1L, TimeUnit.SECONDS);
        } catch (Exception e10) {
            C13981a.m83988e(this.f50572j, "HDPolygon: getLocationSceneResponse " + e10.getMessage());
        }
        C13981a.m83989i(this.f50572j, "HDPolygon: isSupportFence " + f50556H);
        if (f50556H) {
            m64501F(strArr[0]);
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: t */
    public synchronized Location m64527t(String str) {
        try {
            C13981a.m83989i(this.f50572j, "getLastLocation useLocationKit " + this.f50573k);
            if (!this.f50573k) {
                return m64528u(str);
            }
            Location locationM64522o = m64522o();
            if (locationM64522o == null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!m64497B() || Math.abs(this.f50581s - jCurrentTimeMillis) > 3000) {
                    locationM64522o = m64528u(str);
                }
            }
            if (locationM64522o != null) {
                C13981a.m83989i(this.f50572j, "returnHmsLastLocation: hd=" + m64532z(locationM64522o));
            } else {
                C13981a.m83989i(this.f50572j, "returnHmsLastLocation: hd=null");
            }
            return locationM64522o;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: u */
    public final Location m64528u(String str) {
        if (this.f50577o == null) {
            LocationManager locationManager = (LocationManager) this.f50571i.getSystemService(JsbMapKeyNames.H5_LOC);
            this.f50577o = locationManager;
            if (locationManager == null) {
                return null;
            }
        }
        if (!C13812b.m82847r(this.f50571i, str)) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Location lastKnownLocation = this.f50577o.getLastKnownLocation(str);
        if (lastKnownLocation != null) {
            Bundle extras = lastKnownLocation.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putLong("delayTime", System.currentTimeMillis() - jCurrentTimeMillis);
            extras.putInt("locationRouter", this.f50574l);
            lastKnownLocation.setExtras(extras);
        }
        C13981a.m83989i(this.f50572j, "returnLbsLastLocation " + str);
        return lastKnownLocation;
    }

    /* renamed from: w */
    public boolean m64529w() {
        return f50557I != null;
    }

    /* renamed from: x */
    public final boolean m64530x(double d10, double d11, double d12) {
        if (d11 >= d12) {
            d11 = d12;
            d12 = d11;
        }
        return d10 > d11 && d10 < d12;
    }

    /* renamed from: y */
    public final boolean m64531y(Map<String, Object> map) {
        if (map == null || map.isEmpty() || !map.containsKey("isInHdArea")) {
            return false;
        }
        Object obj = map.get("isInHdArea");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    /* renamed from: z */
    public synchronized boolean m64532z(Location location) {
        if (!this.f50573k) {
            return false;
        }
        if (location == null) {
            return false;
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.containsKey("floor");
    }
}
