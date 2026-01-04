package p366if;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Message;
import bf.AbstractC1177c;
import bf.C1175a;
import com.baidu.location.LocationClient;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p366if.AbstractC10482g;
import p394jf.C10813a;
import p664u0.C13108a;
import p774xg.C13811a;
import p809yg.C13981a;
import ug.C13172b;

/* renamed from: if.b */
/* loaded from: classes4.dex */
public class C10477b extends AbstractC10482g {

    /* renamed from: L */
    public LocationClient f50500L;

    /* renamed from: M */
    public C10491p f50501M;

    /* renamed from: N */
    public Timer f50502N;

    /* renamed from: O */
    public final boolean f50503O;

    /* renamed from: if.b$b */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83989i("BaiduLocate", "TimeOut-->stopBaiduLocate-->");
            if (!C10477b.this.f50535v) {
                C10477b.this.m64408X0(7);
            }
            C10477b.this.m64411a1(null);
        }
    }

    /* renamed from: if.b$c */
    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!C10477b.this.f50535v) {
                C13981a.m83989i("BaiduLocate", "get no location in 30s");
                if (!C10477b.this.f50532s.m64480b()) {
                    C10477b.this.f5582c = 69;
                    C10477b.this.f5583d = null;
                    C10477b.this.m7417D(null);
                    C10477b.this.m7427Q("BaiduLocate", "001_2001", 69, C10477b.this.f5586g + "BaiduLocate get no location in 30s", null, C10477b.this.f50531r, "pushLocate", false, null);
                }
            }
            if (!C10477b.this.f50535v || C10477b.this.f50534u || !C10477b.this.f50536w || C10477b.this.f50532s.m64480b()) {
                return;
            }
            C13981a.m83989i("BaiduLocate", "has exception in 30s");
            C10477b c10477b = C10477b.this;
            c10477b.m7427Q("BaiduLocate", "001_2001", 71, c10477b.f5586g, null, C10477b.this.f50531r, "pushLocate", false, null);
        }
    }

    public C10477b(PushCmdParser pushCmdParser, Context context, boolean z10) {
        super(pushCmdParser, context);
        this.f50503O = z10;
    }

    /* renamed from: V0 */
    private boolean m64402V0() {
        return this.f50534u && this.f50515A <= this.f50529p;
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: I0 */
    public void mo64403I0() {
        C13981a.m83989i("BaiduLocate", "startBaiduLocation");
        if (this.f50500L == null) {
            this.f50500L = C10487l.m64536b().m64546a();
        }
        if (this.f50501M == null) {
            this.f50501M = new C10491p(this);
        }
        this.f50526m = "network";
        Location location = new Location(this.f50526m);
        this.f50538y = System.currentTimeMillis();
        C10487l.m64538e(this.f50500L, location, this.f50501M);
        Timer timer = this.f50502N;
        if (timer != null) {
            timer.cancel();
        }
        this.f50502N = new Timer("CheckBaiduLocateTimer");
        this.f50502N.schedule(new b(), this.f50529p * this.f50530q);
        this.f50502N.schedule(new c(), this.f50529p);
        m64473t0();
    }

    /* renamed from: S0 */
    public final void m64404S0(Message message, int i10) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("BaiduLocate", "handleCapabilityReportCallback result:" + iM1685c);
        if (200 != iM1685c) {
            m64408X0(1);
            m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "phonefinder handleCapabilityReportCallback fail,result:" + iM1685c, this.f50531r, "capability_reported", true);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(message.getData().getString("response_info"));
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                int i11 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
                C13981a.m83989i("BaiduLocate", "handleCapabilityReportCallback resultCode:= " + i11);
                if (i11 == 0) {
                    m7427Q("BaiduLocate", "0", -1, this.f5586g + "phonefinder handleCapabilityReportCallback success", null, this.f50531r, "capability_reported", false, null);
                    C13172b.m79213i(this.f5580a, i10);
                    m64469n0();
                    C10481f.m64439o(this.f5580a, this, false);
                } else if (401 == i11) {
                    C13172b.m79213i(this.f5580a, i10);
                    m64408X0(1);
                    m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, i11, "001_3004", i11, this.f5586g + "phonefinder handleCapabilityReportCallback fail,result:" + iM1685c + ";resultCode:" + i11, this.f50531r, "capability_reported", false);
                    m64470p0();
                } else {
                    m64408X0(1);
                    m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, i11, "001_3004", i11, this.f5586g + "phonefinder handleCapabilityReportCallback fail,resultCode:" + i11, this.f50531r, "capability_reported", true);
                }
            }
        } catch (JSONException e10) {
            C13981a.m83988e("BaiduLocate", "handleClientCapabilityReport JSONException" + e10.getMessage());
            m64408X0(1);
            m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, iM1685c, "001_1014", -1, this.f5586g + "handleClientCapabilityReport JSONException", this.f50531r, "capability_reported", true);
        }
    }

    /* renamed from: T0 */
    public final void m64405T0(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("BaiduLocate", "handleReportBaiduLocateCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83989i("BaiduLocate", "handleReportBaiduLocateCallback->report error");
            m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "phonefinder handleReportBaiduLocateCallback fail,result:" + iM1685c, this.f50531r, "pushLocate", true);
            if (-100 == iM1685c) {
                this.f50536w = true;
                return;
            }
            return;
        }
        String string = message.getData().getString("response_info");
        int iM7438x = m7438x(string);
        C13981a.m83989i("BaiduLocate", "handleReportBaiduLocateCallback->resultCode =" + iM7438x);
        if (iM7438x == 0) {
            m64458K0();
            new C10813a(this.f5580a, new AbstractC10482g.b(3020)).m65856d();
            m7424L("hisync.findmyphone_locate", 1, 0);
            if (!this.f50534u) {
                this.f50515A = System.currentTimeMillis() - this.f50538y;
                this.f50534u = true;
            }
            C13981a.m83989i("BaiduLocate", "handleReportBaiduLocateCallback->result:" + m7439y(string));
            return;
        }
        if (7 == iM7438x) {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.remotecontrol.PHONEFINDER_DEVICE_DELETE");
            C13108a.m78878b(this.f5580a).m78881d(intent);
        } else {
            if (401 == iM7438x) {
                m64470p0();
                return;
            }
            m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, iM7438x, "001_3004", iM7438x, this.f5586g + "phonefinder handleReportBaiduLocateCallback fail,resultCode:" + iM7438x, this.f50531r, "pushLocate", true);
        }
    }

    /* renamed from: U0 */
    public final void m64406U0(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("BaiduLocate", "handleReportBaiduLocateFailCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83989i("BaiduLocate", "handleReportBaiduLocateFailCallback->report error");
            m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "phonefinder handleReportBaiduLocateFailCallback fail,result:" + iM1685c, this.f50531r, "pushLocate", true);
            return;
        }
        int iM7438x = m7438x(message.getData().getString("response_info"));
        C13981a.m83989i("BaiduLocate", "handleReportBaiduLocateFailCallback->resultCode =" + iM7438x);
        if (iM7438x != 0) {
            m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, iM7438x, "001_3004", iM7438x, this.f5586g + "phonefinder handleReportBaiduLocateFailCallback fail,result:" + iM1685c + ";resultCode:" + iM7438x, this.f50531r, "pushLocate", true);
        }
        if (401 == iM7438x) {
            m64470p0();
        }
    }

    /* renamed from: W0 */
    public final void m64407W0(Location location) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("providerType", this.f50526m);
        linkedHashMap.put("satelliteCount", String.valueOf(this.f50527n));
        linkedHashMap.put("accuracy", String.valueOf(this.f50528o));
        linkedHashMap.put("source", "baidu");
        if (m64402V0()) {
            m7427Q("BaiduLocate", "0", -1, "BaiduLocate success", null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (this.f50534u && this.f50539z > this.f50529p) {
            m7427Q("BaiduLocate", "001_82", -1, "BaiduLocate success but over one duration", null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (m64472s0()) {
            m7427Q("BaiduLocate", "001_81", -1, "BaiduLocate get location in one duration but report late", null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (!this.f50534u && this.f50535v) {
            m7427Q("BaiduLocate", "001_84", -1, "BaiduLocate get location over one duration and report late", null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (!this.f50534u && !this.f50535v && this.f50537x == 0) {
            m7427Q("BaiduLocate", "001_85", -1, "BaiduLocate location failed uuid:" + C10487l.m64536b().m64547d(), null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (location != null) {
            m64451C0(location);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f50534u);
        sb2.append('|');
        sb2.append(this.f50535v);
        sb2.append('|');
        sb2.append(this.f50515A);
        sb2.append('|');
        sb2.append(this.f50539z);
        m7427Q("BaiduLocate", "001_1014", -1, "BaiduLocate location result error: " + sb2.toString(), null, this.f50531r, "pushLocate", true, linkedHashMap);
    }

    /* renamed from: X0 */
    public void m64408X0(int i10) {
        C13981a.m83989i("BaiduLocate", "BaiduLocate reportBaiduFailResult");
        C10481f.m64439o(this.f5580a, this, true);
        if (!C1175a.m7389k(this.f5580a)) {
            C13981a.m83989i("BaiduLocate", "BaiduLocate reportBaiduFailResult fail,switcher is off");
            m7425M();
            m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, 4, "001_2001", 4, this.f5586g + "reportBaiduFailResult fail,switcher is off", this.f50531r, "pushLocate", true);
            return;
        }
        m7426P("BaiduLocate", "hisync.findmyphone_locate", 1, i10, "001_2001", i10, this.f5586g + "reportBaiduFailResult fail,result:" + i10 + ", uuid:" + C10487l.m64536b().m64547d(), this.f50531r, "pushLocate", false);
        this.f5582c = i10;
        this.f5583d = null;
        m7417D(new AbstractC10482g.b(3024));
    }

    /* renamed from: Y0 */
    public void m64409Y0(Location location) {
        int iM82820q = C13811a.m82820q(this.f5580a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!C1175a.m7389k(this.f5580a)) {
            m7425M();
            C13981a.m83988e("BaiduLocate", "reportBaiduResult->switcher of phonefinder is off");
            return;
        }
        if (location != null) {
            JSONObject jSONObject = new JSONObject();
            this.f50526m = location.getProvider();
            this.f50528o = location.getAccuracy();
            try {
                jSONObject.put("type", "network".equals(this.f50526m) ? 0 : "gps".equals(this.f50526m) ? 1 : 2);
                Location locationM64543j = C10487l.m64543j(location);
                if (locationM64543j == null) {
                    C13981a.m83988e("BaiduLocate", "bd location is null");
                } else {
                    jSONObject.put(JsbMapKeyNames.H5_LOC_LON, locationM64543j.getLongitude());
                    jSONObject.put(JsbMapKeyNames.H5_LOC_LAT, locationM64543j.getLatitude());
                }
                jSONObject.put("longitude_WGS", location.getLongitude());
                jSONObject.put("latitude_WGS", location.getLatitude());
                jSONObject.put("accuracy", location.getAccuracy());
                jSONObject.put("maptype", 1);
                jSONObject.put("simSn", "");
                jSONObject.put("isLockScreen", iM82820q);
                jSONObject.put("batteryStatus", C13811a.m82816m(this.f5580a));
                if (!this.f50503O) {
                    jSONObject.put("allowFlowControl", "false");
                    C13981a.m83989i("BaiduLocate", "allowFlowControl is false");
                }
                m64457J0(true, jSONObject, location, jCurrentTimeMillis, new AbstractC10482g.b(SNSCode.Status.USER_SEARCH_FAILED));
            } catch (JSONException unused) {
                C13981a.m83988e("BaiduLocate", "reportBaiduResult JSONException");
            }
        }
    }

    /* renamed from: Z0 */
    public void m64410Z0() {
        if (this.f50500L != null) {
            C13981a.m83987d("BaiduLocate", JsbMapKeyNames.H5_REQUESTLOCATION);
            m64473t0();
            C10487l.m64538e(this.f50500L, new Location(this.f50526m), this.f50501M);
        }
    }

    /* renamed from: a1 */
    public void m64411a1(Location location) {
        Timer timer = this.f50502N;
        if (timer != null) {
            timer.cancel();
            this.f50502N = null;
        }
        LocationClient locationClient = this.f50500L;
        if (locationClient != null) {
            locationClient.destroy();
            this.f50500L = null;
        }
        m64475v0(location);
        m64461f0();
        C10481f.m64439o(this.f5580a, this, true);
        m64407W0(location);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: o0 */
    public boolean mo64412o0(Message message, int i10, int i11) throws JSONException {
        C13981a.m83989i("BaiduLocate", "HttpCallback->handleMessage:" + i10);
        if (3010 == i10) {
            m64405T0(message);
            return true;
        }
        if (3011 == i10) {
            m64404S0(message, i11);
            return true;
        }
        if (3020 == i10) {
            C10813a.m65855g(message, this.f5580a);
            return true;
        }
        if (3024 != i10) {
            return true;
        }
        m64406U0(message);
        return true;
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: q0 */
    public void mo64413q0() {
        super.mo64413q0();
        this.f50532s.m64481c(true);
        if ("[PowerLowMode]".equals(this.f5586g)) {
            this.f50531r = "01014";
        } else {
            this.f50531r = "01001";
        }
        AbstractC1177c.f5579k = C0209d.m1206R1(C0213f.m1377a()) ? "Desktop" : "OOBE";
        C13981a.m83989i("BaiduLocate", "initParams clientStatus:" + AbstractC1177c.f5579k);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: z0 */
    public void mo64414z0() {
        C13981a.m83989i("BaiduLocate", "BaiduLocate hasPermissions = false");
        m64408X0(66);
    }
}
