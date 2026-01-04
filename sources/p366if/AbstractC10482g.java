package p366if;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import bf.AbstractC1177c;
import com.baidu.geocoder.BaiduGeocodeProvider;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.track.C4443e;
import com.huawei.android.remotecontrol.track.C4450l;
import com.huawei.android.remotecontrol.track.C4452n;
import com.huawei.android.remotecontrol.track.LocateTrackEvent;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;
import p013ah.C0198c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p521og.C11877j;
import p521og.C11879l;
import p521og.C11881n;
import p611rf.C12505m;
import p616rk.C12515a;
import p664u0.C13108a;
import p774xg.C13811a;
import p774xg.C13812b;
import p809yg.C13981a;
import p841ze.InterfaceC14290d;
import pg.AbstractC12139d;
import re.C12492a;
import sg.C12797b;
import ug.C13172b;

/* renamed from: if.g */
/* loaded from: classes4.dex */
public abstract class AbstractC10482g extends AbstractC1177c {

    /* renamed from: K */
    public static final Object f50514K = new Object();

    /* renamed from: A */
    public long f50515A;

    /* renamed from: B */
    public InterfaceC14290d f50516B;

    /* renamed from: C */
    public Consumer<Location> f50517C;

    /* renamed from: D */
    public c f50518D;

    /* renamed from: E */
    public int f50519E;

    /* renamed from: F */
    public boolean f50520F;

    /* renamed from: G */
    public boolean f50521G;

    /* renamed from: H */
    public boolean f50522H;

    /* renamed from: I */
    public AbstractC10476a f50523I;

    /* renamed from: J */
    public String f50524J;

    /* renamed from: l */
    public String f50525l;

    /* renamed from: m */
    public String f50526m;

    /* renamed from: n */
    public int f50527n;

    /* renamed from: o */
    public float f50528o;

    /* renamed from: p */
    public long f50529p;

    /* renamed from: q */
    public int f50530q;

    /* renamed from: r */
    public String f50531r;

    /* renamed from: s */
    public C10484i f50532s;

    /* renamed from: t */
    public boolean f50533t;

    /* renamed from: u */
    public volatile boolean f50534u;

    /* renamed from: v */
    public volatile boolean f50535v;

    /* renamed from: w */
    public volatile boolean f50536w;

    /* renamed from: x */
    public long f50537x;

    /* renamed from: y */
    public volatile long f50538y;

    /* renamed from: z */
    public long f50539z;

    /* renamed from: if.g$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ JSONObject f50540a;

        /* renamed from: b */
        public final /* synthetic */ boolean f50541b;

        /* renamed from: c */
        public final /* synthetic */ double f50542c;

        /* renamed from: d */
        public final /* synthetic */ double f50543d;

        /* renamed from: e */
        public final /* synthetic */ long f50544e;

        /* renamed from: f */
        public final /* synthetic */ b f50545f;

        public a(JSONObject jSONObject, boolean z10, double d10, double d11, long j10, b bVar) {
            this.f50540a = jSONObject;
            this.f50541b = z10;
            this.f50542c = d10;
            this.f50543d = d11;
            this.f50544e = j10;
            this.f50545f = bVar;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            List<Address> fromLocation;
            synchronized (AbstractC10482g.f50514K) {
                try {
                    String strM71330f = C0209d.m1254f2(AbstractC10482g.this.f5580a) ? C11879l.m71330f(AbstractC10482g.this.f5580a) : "";
                    C13981a.m83987d(AbstractC10482g.this.f50525l, "wifiName: " + strM71330f);
                    AbstractC10482g.this.m64456H0(this.f50540a, strM71330f);
                    if (this.f50541b) {
                        ArrayList arrayList = new ArrayList();
                        BaiduGeocodeProvider baiduGeocodeProvider = new BaiduGeocodeProvider(AbstractC10482g.this.f5580a);
                        baiduGeocodeProvider.setUuid(C10487l.m64536b().m64547d());
                        baiduGeocodeProvider.onGetFromLocation(this.f50542c, this.f50543d, 3, arrayList);
                        AbstractC10482g.this.m64474u0(true, this.f50540a, arrayList, this.f50544e, this.f50545f);
                    } else {
                        try {
                            fromLocation = new Geocoder(AbstractC10482g.this.f5580a).getFromLocation(this.f50542c, this.f50543d, 3);
                        } catch (IOException e10) {
                            C13981a.m83988e(AbstractC10482g.this.f50525l, "get address from location error:" + e10.getMessage());
                            fromLocation = null;
                        }
                        AbstractC10482g.this.m64474u0(false, this.f50540a, fromLocation, this.f50544e, this.f50545f);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: if.g$c */
    public class c extends PhoneStateListener {

        /* renamed from: a */
        public TelephonyManager f50550a;

        public c(TelephonyManager telephonyManager) {
            this.f50550a = telephonyManager;
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) throws NoSuchMethodException, SecurityException {
            super.onSignalStrengthsChanged(signalStrength);
            try {
                TelephonyManager telephonyManager = this.f50550a;
                if (telephonyManager != null) {
                    telephonyManager.getNetworkType();
                    AbstractC10482g.this.f50519E = ((Integer) signalStrength.getClass().getMethod("getLevel", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
                }
            } catch (IllegalAccessException e10) {
                C13981a.m83988e(AbstractC10482g.this.f50525l, "IllegalAccessException: " + e10.toString());
            } catch (NoSuchMethodException e11) {
                C13981a.m83988e(AbstractC10482g.this.f50525l, "NoSuchMethodException: " + e11.toString());
            } catch (InvocationTargetException e12) {
                C13981a.m83988e(AbstractC10482g.this.f50525l, "InvocationTargetException: " + e12.toString());
            }
        }
    }

    public AbstractC10482g(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f50525l = "LocateObject";
        this.f50527n = -1;
        this.f50528o = 0.0f;
        this.f50532s = new C10484i();
        this.f50533t = false;
        this.f50534u = false;
        this.f50535v = false;
        this.f50536w = false;
        this.f50537x = 0L;
        this.f50515A = -1L;
        this.f50524J = null;
        this.f50525l = m64466k0(this.f50525l);
    }

    /* renamed from: A0 */
    public void m64449A0(C10488m c10488m, int i10, long j10) throws JSONException {
        if (!AbstractC12139d.m72768g(this.f5580a)) {
            C13981a.m83988e(this.f50525l, "accountInfo not exist");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        boolean zM72769h = AbstractC12139d.m72769h(this.f5580a);
        try {
            if (zM72769h) {
                if (c10488m.m64550b().getProvider().equals("network")) {
                    jSONObject.put("type", 0);
                } else {
                    jSONObject.put("type", 1);
                }
                Location locationM64543j = C10487l.m64543j(c10488m.m64550b());
                if (locationM64543j == null) {
                    C13981a.m83988e(this.f50525l, "bd location is null");
                } else {
                    jSONObject.put(JsbMapKeyNames.H5_LOC_LON, locationM64543j.getLongitude());
                    jSONObject.put(JsbMapKeyNames.H5_LOC_LAT, locationM64543j.getLatitude());
                    jSONObject.put("longitude_WGS", c10488m.m64550b().getLongitude());
                    jSONObject.put("latitude_WGS", c10488m.m64550b().getLatitude());
                    jSONObject.put("locateVersion", 1);
                }
                jSONObject.put("accuracy", c10488m.m64550b().getAccuracy());
            } else {
                JSONObject jSONObject2 = new JSONObject();
                if (c10488m.m64550b().getProvider().equals("network")) {
                    jSONObject2.put("type", 0);
                } else {
                    jSONObject2.put("type", 1);
                }
                jSONObject2.put("sysType", 1);
                jSONObject2.put(JsbMapKeyNames.H5_LOC_LON, m7432q(String.valueOf(c10488m.m64550b().getLongitude())));
                jSONObject2.put(JsbMapKeyNames.H5_LOC_LAT, m7432q(String.valueOf(c10488m.m64550b().getLatitude())));
                jSONObject2.put("accuracy", c10488m.m64550b().getAccuracy());
                jSONObject2.put("time", c10488m.m64550b().getTime() + C11881n.m71358h());
                jSONObject.put("coordinateInfo", jSONObject2);
            }
            jSONObject.put("floor", C13812b.m82831b(c10488m.m64550b()));
            jSONObject.put("locationRouter", C13812b.m82836g(c10488m.m64550b()));
            jSONObject.put("locationTime", C13812b.m82837h(c10488m.m64550b()));
            jSONObject.put("locCpTransId", C13812b.m82833d(c10488m.m64550b()));
            jSONObject.put("locSessionId", C13812b.m82835f(c10488m.m64550b()));
            jSONObject.put("locFenceTime", C13812b.m82834e(c10488m.m64550b()));
            jSONObject.put("maptype", 3);
            jSONObject.put("simSn", "");
            jSONObject.put("isLockScreen", i10);
            jSONObject.put("batteryStatus", C13811a.m82816m(this.f5580a));
            m64457J0(zM72769h, jSONObject, c10488m.m64550b(), j10, new b("01046".equals(this.f50531r) ? 3100 : 3025));
            m64450B0(c10488m);
        } catch (JSONException unused) {
            C13981a.m83988e(this.f50525l, "reportLocationResult JSONException");
        }
    }

    /* renamed from: B0 */
    public synchronized void m64450B0(C10488m c10488m) {
        C13981a.m83989i(this.f50525l, "reportLocationMsg");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("provider", c10488m.m64550b().getProvider());
        linkedHashMap.put("floor", C13812b.m82831b(c10488m.m64550b()));
        linkedHashMap.put("floorAccuracy", C13812b.m82832c(c10488m.m64550b()));
        linkedHashMap.put("locationDelayTime", String.valueOf(C13812b.m82837h(c10488m.m64550b())));
        linkedHashMap.put("locationRouter", String.valueOf(C13812b.m82836g(c10488m.m64550b())));
        linkedHashMap.put("locCpTransId", C13812b.m82833d(c10488m.m64550b()));
        linkedHashMap.put("locSessionId", C13812b.m82835f(c10488m.m64550b()));
        linkedHashMap.put("locFenceTime", C13812b.m82834e(c10488m.m64550b()));
        m7427Q(this.f50525l, "01069", -1, "REPORT_LOCATIO, uuid:" + C10487l.m64536b().m64547d(), null, this.f50531r, "location_report", true, linkedHashMap);
    }

    /* renamed from: C0 */
    public void m64451C0(Location location) {
        if (location == null) {
            C13981a.m83988e(this.f50525l, "reportTrack location is null");
            return;
        }
        if (C11877j.m71236U(this.f5580a)) {
            C13981a.m83989i(this.f50525l, "reportTrack");
            if (!C4452n.m27029i(this.f5580a, location)) {
                C13981a.m83990w(this.f50525l, "reportTrack location is not match track accuracy");
                return;
            }
            LocateTrackEvent locateTrackEvent = new LocateTrackEvent();
            int i10 = !"network".equals(location.getProvider()) ? 1 : 0;
            int iM82820q = C13811a.m82820q(this.f5580a);
            C13981a.m83989i(this.f50525l, "doReport start,locateType:" + i10 + ";isLockScreen:" + iM82820q);
            locateTrackEvent.setTrackLocateType(String.valueOf(i10));
            if (AbstractC12139d.m72769h(this.f5580a)) {
                Location locationM64543j = C10487l.m64543j(location);
                if (locationM64543j == null) {
                    C13981a.m83988e(this.f50525l, "bd location is null");
                } else {
                    locateTrackEvent.setTrackLongtitude(String.valueOf(locationM64543j.getLongitude()));
                    locateTrackEvent.setTrackLatitude(String.valueOf(locationM64543j.getLatitude()));
                    locateTrackEvent.setTrackLatitudeWGS(String.valueOf(location.getLatitude()));
                    locateTrackEvent.setTrackLongtitudeWGS(String.valueOf(location.getLongitude()));
                    locateTrackEvent.setLocationTime(C13812b.m82837h(location));
                    locateTrackEvent.setLocationRouter(C13812b.m82836g(location));
                    locateTrackEvent.setFloor(C13812b.m82831b(location));
                    locateTrackEvent.setFloorAcc(C13812b.m82832c(location));
                    locateTrackEvent.setLocCpTransId(C13812b.m82833d(location));
                    locateTrackEvent.setLocSessionId(C13812b.m82835f(location));
                    locateTrackEvent.setLocFenceTime(C13812b.m82834e(location));
                }
            } else {
                locateTrackEvent.setTrackLongtitudeWGS(String.valueOf(location.getLongitude()));
                locateTrackEvent.setTrackLatitudeWGS(String.valueOf(location.getLatitude()));
            }
            locateTrackEvent.setTrackAccuracy(String.valueOf(location.getAccuracy()));
            locateTrackEvent.setTrackCapabilityIslockscreen(String.valueOf(iM82820q));
            locateTrackEvent.setTrackUTC(location.getTime());
            locateTrackEvent.setTrackMaptype(String.valueOf("01046".equals(this.f50531r) ? 3 : 2));
            C4443e.m26978b(this.f5580a, locateTrackEvent, this.f5581b.getTraceID());
        }
    }

    /* renamed from: D0 */
    public void m64452D0(InterfaceC14290d interfaceC14290d) {
        this.f50516B = interfaceC14290d;
    }

    /* renamed from: E0 */
    public void m64453E0(boolean z10) {
        this.f50533t = z10;
    }

    /* renamed from: F0 */
    public void m64454F0(String str) {
        this.f5586g = str;
    }

    /* renamed from: G0 */
    public void m64455G0(C10484i c10484i) {
        this.f50532s = c10484i;
    }

    /* renamed from: H0 */
    public void m64456H0(JSONObject jSONObject, String str) throws JSONException, NoSuchMethodException, SecurityException {
        C13981a.m83989i(this.f50525l, "setNetworkAndSimInfo");
        try {
            JSONObject jSONObjectM64465j0 = m64465j0(str);
            JSONObject jSONObjectM64467l0 = m64467l0();
            if (!this.f50520F && !this.f50521G) {
                return;
            }
            C13981a.m83989i(this.f50525l, "setNetworkAndSimInfo update network info");
            jSONObject.put("networkInfo", jSONObjectM64465j0);
            jSONObject.put("simInfo", jSONObjectM64467l0);
            this.f50522H = true;
            C11877j.m71219L0(this.f5580a, 0L);
        } catch (JSONException e10) {
            C13981a.m83988e(this.f50525l, "setNetworkAndSimInfo error： " + e10.toString());
        }
    }

    /* renamed from: I0 */
    public abstract void mo64403I0();

    /* renamed from: J0 */
    public void m64457J0(boolean z10, JSONObject jSONObject, Location location, long j10, b bVar) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        if (!this.f50535v) {
            this.f50535v = true;
            this.f50539z = System.currentTimeMillis() - this.f50538y;
            this.f50532s.m64482d(true);
        }
        C13981a.m83989i(this.f50525l, "startReverseGeoCode");
        C12515a.m75110o().m75175e(new a(jSONObject, z10, latitude, longitude, j10, bVar), false);
    }

    /* renamed from: K0 */
    public void m64458K0() {
        if (this.f50522H) {
            C13981a.m83989i(this.f50525l, "report location result success, update report sim and network time");
            C11877j.m71219L0(this.f5580a, System.currentTimeMillis());
            this.f50522H = false;
        }
    }

    /* renamed from: d0 */
    public final boolean m64459d0(String str, String str2) {
        String strM71242X = C11877j.m71242X(this.f5580a, "");
        if (!TextUtils.isEmpty(strM71242X)) {
            String strM1097a = C0198c.m1097a(this.f5580a, strM71242X);
            if (!TextUtils.isEmpty(strM1097a)) {
                if (strM1097a.equals(str) && C11877j.m71206F(this.f5580a)) {
                    C13981a.m83989i(this.f50525l, "checkNetworkInfoNotify wifiInfo not need save");
                    return false;
                }
                if (TextUtils.isEmpty(str2) && C0209d.m1254f2(this.f5580a)) {
                    C13981a.m83989i(this.f50525l, "wifiId is empty,do not save");
                    return false;
                }
            }
        }
        C13981a.m83989i(this.f50525l, "save new networkInfo");
        C13981a.m83987d(this.f50525l, "checkNetworkInfoNotify networkInfo: " + str);
        Context context = this.f5580a;
        C11877j.m71259d1(context, C0198c.m1098b(context, str));
        return true;
    }

    /* renamed from: e0 */
    public final boolean m64460e0(String str) {
        String strM1097a = C0198c.m1097a(this.f5580a, C11877j.m71270h0(this.f5580a, ""));
        if (TextUtils.isEmpty(strM1097a) && TextUtils.isEmpty(str)) {
            C13981a.m83989i(this.f50525l, "checkSimInfoNotify simInfo is empty, not change");
            return false;
        }
        if (!TextUtils.isEmpty(strM1097a) && strM1097a.equals(str) && C11877j.m71206F(this.f5580a)) {
            C13981a.m83989i(this.f50525l, "checkSimInfoNotify simInfo not need change");
            return false;
        }
        C13981a.m83989i(this.f50525l, "save new simInfo");
        C13981a.m83987d(this.f50525l, "checkSimInfoNotify simInfo: " + str);
        Context context = this.f5580a;
        C11877j.m71298q1(context, C0198c.m1098b(context, str));
        return true;
    }

    /* renamed from: f0 */
    public void m64461f0() {
        if (this.f50518D != null) {
            C13981a.m83989i(this.f50525l, "endListenPhoneState");
            ((TelephonyManager) this.f5580a.getSystemService("phone")).listen(this.f50518D, 0);
            this.f50518D = null;
        }
    }

    /* renamed from: g0 */
    public String m64462g0(String str) {
        if (TextUtils.isEmpty(str) && C0209d.m1254f2(this.f5580a)) {
            str = C11879l.m71330f(this.f5580a);
            C13981a.m83987d(this.f50525l, "formatWifiName：" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("\"")) {
            str = str.substring(1);
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }

    /* renamed from: h0 */
    public final long m64463h0() {
        return ParamConfig.getInstance().getLocateDuration();
    }

    /* renamed from: i0 */
    public final int m64464i0() {
        return ParamConfig.getInstance().getLocateTimes();
    }

    /* renamed from: j0 */
    public JSONObject m64465j0(String str) throws JSONException {
        C13981a.m83989i(this.f50525l, "getNetWorkInfo");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!C0209d.m1333z1(this.f5580a)) {
                C13981a.m83988e(this.f50525l, "getNetWorkInfo has not network ");
            } else if (C0209d.m1254f2(this.f5580a)) {
                C13981a.m83989i(this.f50525l, "getNetWorkInfo has wifi network");
                jSONObject2.put("type", 0);
                jSONObject.put("type", 0);
                String strM64462g0 = m64462g0(str);
                jSONObject2.put("name", m7431p(strM64462g0));
                jSONObject.put("name", strM64462g0);
                int iM71325a = C11879l.m71325a(this.f5580a);
                jSONObject2.put("signal", iM71325a);
                jSONObject.put("signal", iM71325a);
            } else {
                C13981a.m83989i(this.f50525l, "getNetWorkInfo has mobile network");
                jSONObject2.put("type", 1);
                jSONObject.put("type", 1);
                String strM71326b = C11879l.m71326b(this.f5580a, C11879l.m71328d(this.f5580a));
                jSONObject2.put("name", m7431p(strM71326b));
                jSONObject.put("name", strM71326b);
                C13981a.m83989i(this.f50525l, "mobileSignalLevel: " + this.f50519E);
                jSONObject2.put("signal", this.f50519E);
                jSONObject.put("signal", this.f50519E);
            }
            this.f50521G = m64459d0(jSONObject.toString(), str);
            C13981a.m83989i(this.f50525l, "isNetworkInfoChanged: " + this.f50521G);
        } catch (SecurityException | JSONException e10) {
            C13981a.m83988e(this.f50525l, "get network info exception occur: " + e10.getMessage());
            new C12797b().m76785k(this.f5580a, this.f50525l, "001_1015", "get network info exception occur: " + e10.toString(), "001_1015", this.f50531r, this.f5581b.getTraceID(), "locate get network info exception", false, null);
        }
        return jSONObject2;
    }

    /* renamed from: k0 */
    public String m64466k0(String str) {
        if (this.f50524J == null) {
            this.f50524J = Long.toString(System.currentTimeMillis() % 1000);
        }
        return str + "-" + this.f50524J;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* renamed from: l0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject m64467l0() throws org.json.JSONException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            r7 = this;
            java.lang.String r0 = r7.f50525l
            java.lang.String r1 = "getSimInfo"
            p809yg.C13981a.m83989i(r0, r1)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            android.content.Context r1 = r7.f5580a
            java.util.Map r1 = p521og.C11879l.m71327c(r1)
            java.lang.String r2 = r7.f50525l
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "phoneNumbers.size(): "
            r3.append(r4)
            int r4 = r1.size()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            p809yg.C13981a.m83989i(r2, r3)
            int r2 = r1.size()
            if (r2 <= 0) goto L74
            java.util.Set r2 = r1.keySet()
            java.util.Iterator r2 = r2.iterator()
            r3 = -1
            r4 = r3
            r5 = r4
        L3d:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L55
            java.lang.Object r6 = r2.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r4 != r3) goto L50
            int r4 = r6.intValue()
            goto L3d
        L50:
            int r5 = r6.intValue()
            goto L3d
        L55:
            if (r4 == r5) goto L74
            int r2 = java.lang.Math.min(r4, r5)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            int r3 = java.lang.Math.max(r4, r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            goto L77
        L74:
            java.lang.String r2 = ""
            r1 = r2
        L77:
            java.lang.StringBuilder r1 = r7.m64468m0(r2, r1)
            java.lang.String r2 = r1.toString()
            boolean r2 = r7.m64460e0(r2)
            r7.f50520F = r2
            java.lang.String r2 = r7.f50525l
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isSimInfoChanged: "
            r3.append(r4)
            boolean r4 = r7.f50520F
            r3.append(r4)
            java.lang.String r4 = ", simNo is empty: "
            r3.append(r4)
            java.lang.String r4 = r1.toString()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            p809yg.C13981a.m83989i(r2, r3)
            java.lang.String r2 = "no"
            java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> Lbb
            java.lang.String r1 = r7.m7431p(r1)     // Catch: org.json.JSONException -> Lbb
            r0.put(r2, r1)     // Catch: org.json.JSONException -> Lbb
            goto Ld6
        Lbb:
            r1 = move-exception
            java.lang.String r7 = r7.f50525l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "JSONException occur: "
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            p809yg.C13981a.m83988e(r7, r1)
        Ld6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p366if.AbstractC10482g.m64467l0():org.json.JSONObject");
    }

    /* renamed from: m0 */
    public final StringBuilder m64468m0(String str, String str2) {
        StringBuilder sb2 = new StringBuilder("");
        if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
            sb2.append(str);
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(",");
                sb2.append(str2);
            }
        } else if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        return sb2;
    }

    /* renamed from: n0 */
    public void m64469n0() {
        if ("[PowerLowMode]".equals(this.f5586g) || "[ClearLocate]".equals(this.f5586g)) {
            mo7440z();
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.remotecontrol.intent.push.message");
        intent.putExtra("msg_data", m7437w());
        C13108a.m78878b(this.f5580a.getApplicationContext()).m78881d(intent);
    }

    /* renamed from: o0 */
    public abstract boolean mo64412o0(Message message, int i10, int i11);

    /* renamed from: p0 */
    public void m64470p0() {
        if ("[PowerLowMode]".equals(this.f5586g)) {
            C13981a.m83989i(this.f50525l, "updateDeviceTicket: low power");
            new C12505m(this.f5581b.getTraceID()).m75087f();
        }
    }

    /* renamed from: q0 */
    public void mo64413q0() {
        if ("[PowerLowMode]".equals(this.f5586g)) {
            this.f50531r = "01014";
            this.f50529p = m64463h0();
            this.f50530q = m64464i0();
        } else if ("[ShareLocate]".equals(this.f5586g)) {
            this.f50531r = "01046";
            this.f50529p = 30000L;
            this.f50530q = 5;
        } else {
            this.f50531r = "01001";
            this.f50529p = 30000L;
            this.f50530q = 5;
        }
    }

    /* renamed from: r0 */
    public boolean mo64471r0() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0029  */
    /* renamed from: s0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m64472s0() {
        /*
            r7 = this;
            boolean r0 = r7.f50534u
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L14
            boolean r0 = r7.f50535v
            if (r0 == 0) goto L14
            long r3 = r7.f50539z
            long r5 = r7.f50529p
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 > 0) goto L14
            r0 = r2
            goto L15
        L14:
            r0 = r1
        L15:
            boolean r3 = r7.f50534u
            if (r3 == 0) goto L29
            long r3 = r7.f50515A
            long r5 = r7.f50529p
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L29
            long r3 = r7.f50539z
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L29
            r7 = r2
            goto L2a
        L29:
            r7 = r1
        L2a:
            if (r0 != 0) goto L2e
            if (r7 == 0) goto L2f
        L2e:
            r1 = r2
        L2f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p366if.AbstractC10482g.m64472s0():boolean");
    }

    /* renamed from: t0 */
    public void m64473t0() {
        C13981a.m83989i(this.f50525l, "listenPhoneState start");
        TelephonyManager telephonyManager = (TelephonyManager) this.f5580a.getSystemService("phone");
        if (this.f50518D == null) {
            this.f50518D = new c(telephonyManager);
        }
        telephonyManager.listen(this.f50518D, 256);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0046 A[Catch: JSONException -> 0x002e, TRY_LEAVE, TryCatch #0 {JSONException -> 0x002e, blocks: (B:24:0x0009, B:26:0x000f, B:28:0x001f, B:31:0x0030, B:32:0x0046), top: B:38:0x0009 }] */
    /* renamed from: u0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m64474u0(boolean r6, org.json.JSONObject r7, java.util.List<android.location.Address> r8, long r9, p366if.AbstractC10482g.b r11) throws org.json.JSONException {
        /*
            r5 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "location"
            java.lang.String r2 = "country"
            r3 = 0
            if (r8 == 0) goto L46
            int r4 = r8.size()     // Catch: org.json.JSONException -> L2e
            if (r4 <= 0) goto L46
            java.lang.Object r8 = r8.get(r3)     // Catch: org.json.JSONException -> L2e
            android.location.Address r8 = (android.location.Address) r8     // Catch: org.json.JSONException -> L2e
            java.lang.String r0 = r5.f50525l     // Catch: org.json.JSONException -> L2e
            java.lang.String r4 = "reverse GeoCode success"
            p809yg.C13981a.m83989i(r0, r4)     // Catch: org.json.JSONException -> L2e
            r0 = 1
            if (r6 == 0) goto L30
            java.lang.String r6 = r8.getCountryCode()     // Catch: org.json.JSONException -> L2e
            r7.put(r2, r6)     // Catch: org.json.JSONException -> L2e
            java.lang.String r6 = p366if.C10487l.m64537c(r8, r0)     // Catch: org.json.JSONException -> L2e
            r7.put(r1, r6)     // Catch: org.json.JSONException -> L2e
            goto L6e
        L2e:
            r6 = move-exception
            goto L54
        L30:
            java.lang.String r6 = p366if.C10487l.m64537c(r8, r3)     // Catch: org.json.JSONException -> L2e
            r7.put(r1, r6)     // Catch: org.json.JSONException -> L2e
            java.lang.String r6 = "CN"
            java.lang.String r8 = r8.getCountryCode()     // Catch: org.json.JSONException -> L2e
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch: org.json.JSONException -> L2e
            r6 = r6 ^ r0
            r7.put(r2, r6)     // Catch: org.json.JSONException -> L2e
            goto L6e
        L46:
            java.lang.String r6 = r5.f50525l     // Catch: org.json.JSONException -> L2e
            java.lang.String r8 = "reverse GeoCode success empty"
            p809yg.C13981a.m83989i(r6, r8)     // Catch: org.json.JSONException -> L2e
            r7.put(r1, r0)     // Catch: org.json.JSONException -> L2e
            r7.put(r2, r0)     // Catch: org.json.JSONException -> L2e
            goto L6e
        L54:
            java.lang.String r8 = r5.f50525l
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "toJson error:"
            r0.append(r1)
            java.lang.String r6 = r6.getMessage()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            p809yg.C13981a.m83988e(r8, r6)
        L6e:
            r5.f5582c = r3
            r5.f5583d = r7
            r5.m7416A(r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p366if.AbstractC10482g.m64474u0(boolean, org.json.JSONObject, java.util.List, long, if.g$b):void");
    }

    /* renamed from: v0 */
    public void m64475v0(Location location) {
        Consumer<Location> consumer;
        if (location == null || (consumer = this.f50517C) == null) {
            return;
        }
        consumer.accept(location);
    }

    /* renamed from: w0 */
    public void m64476w0(Consumer<Location> consumer) {
        this.f50517C = consumer;
    }

    /* renamed from: x0 */
    public void m64477x0() {
        AbstractC10476a abstractC10476a = this.f50523I;
        if (abstractC10476a == null) {
            return;
        }
        abstractC10476a.m64390f();
    }

    /* renamed from: y0 */
    public final void m64478y0() {
        boolean z10;
        String str;
        Context context = this.f5580a;
        if (context == null) {
            C10481f.m64439o(C0213f.m1377a(), this, true);
            m7427Q(this.f50525l, "001_1014", -1, this.f5586g + "mContext is null", null, this.f50531r, "capability_reported", true, null);
            return;
        }
        int iM79205a = C13172b.m79205a(context);
        String deviceID = AbstractC12139d.m72766e(this.f5580a).getDeviceID();
        if (TextUtils.isEmpty(deviceID)) {
            String str2 = this.f50525l;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("reportClientCapability->");
            str = "deviceID is empty";
            sb2.append("deviceID is empty");
            C13981a.m83988e(str2, sb2.toString());
            z10 = true;
        } else {
            z10 = false;
            str = "";
        }
        String deviceType = AbstractC12139d.m72766e(this.f5580a).getDeviceType();
        if (TextUtils.isEmpty(deviceType)) {
            C13981a.m83988e(this.f50525l, "reportClientCapability->deviceType is empty");
            z10 = true;
            str = "deviceType is empty";
        }
        String serviceToken = AbstractC12139d.m72766e(this.f5580a).getServiceToken();
        if (!z10) {
            new C12492a(deviceID, C0241z.m1685c(deviceType), serviceToken, new b(SNSCode.Status.ADD_FRIEND_FAILED, iM79205a), this.f5580a, iM79205a, this.f5581b.getTraceID()).m74985e();
            return;
        }
        C10481f.m64439o(this.f5580a, this, true);
        m7427Q(this.f50525l, "001_1014", -1, this.f5586g + str, null, this.f50531r, "capability_reported", true, null);
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        mo64413q0();
        if (!C4347e.m26238i(this.f5580a)) {
            mo64414z0();
            return;
        }
        if (C13172b.m79211g(this.f5580a) && !this.f50533t) {
            m64478y0();
            return;
        }
        if (C4450l.m27011g(this.f5580a)) {
            C4450l.m27018n(this.f5580a);
            C4443e.m26981e(this.f5580a);
        }
        mo64403I0();
    }

    /* renamed from: z0 */
    public abstract void mo64414z0();

    /* renamed from: if.g$b */
    public class b implements Handler.Callback {

        /* renamed from: a */
        public int f50547a;

        /* renamed from: b */
        public int f50548b;

        public b(int i10) {
            this.f50547a = i10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterfaceC14290d interfaceC14290d;
            boolean zMo64412o0 = AbstractC10482g.this.mo64412o0(message, this.f50547a, this.f50548b);
            int i10 = this.f50547a;
            if ((i10 == 3010 || i10 == 3025 || i10 == 3100) && (interfaceC14290d = AbstractC10482g.this.f50516B) != null) {
                interfaceC14290d.mo85127a();
                AbstractC10482g.this.f50516B = null;
            }
            return zMo64412o0;
        }

        public b(int i10, int i11) {
            this.f50547a = i10;
            this.f50548b = i11;
        }
    }
}
