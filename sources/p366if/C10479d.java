package p366if;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Message;
import bf.AbstractC1177c;
import bf.C1175a;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.LinkedHashMap;
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

/* renamed from: if.d */
/* loaded from: classes4.dex */
public class C10479d extends AbstractC10482g implements InterfaceC10483h {

    /* renamed from: L */
    public String f50506L;

    public C10479d(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f50506L = "G_Locate";
        String strM64466k0 = m64466k0("G_Locate");
        this.f50506L = strM64466k0;
        this.f50523I = new C10492q(this, this.f5580a, strM64466k0);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: I0 */
    public void mo64403I0() {
        this.f50538y = System.currentTimeMillis();
        this.f50523I.mo64391g();
        m64473t0();
    }

    /* renamed from: L0 */
    public final boolean m64415L0(Message message, int i10) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50506L, "handleCapabilityReportCallback result:" + iM1685c);
        if (200 == iM1685c) {
            try {
                JSONObject jSONObject = new JSONObject(message.getData().getString("response_info"));
                if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                    int i11 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
                    C13981a.m83989i(this.f50506L, "handleCapabilityReportCallback resultCode:= " + i11);
                    if (i11 == 0) {
                        m7427Q(this.f50506L, "0", -1, this.f5586g + "G_Locate handleCapabilityReportCallback success", null, this.f50531r, "capability_reported", false, null);
                        C13172b.m79213i(this.f5580a, i10);
                        m64469n0();
                        C10481f.m64439o(this.f5580a, this, false);
                    } else if (401 == i11) {
                        m64420Q0(1);
                        m7426P(this.f50506L, "hisync.findmyphone_locate", 1, i11, "001_3004", i11, this.f5586g + "phoneFinder G_Locate handleCapabilityReportCallback fail,resultCode:" + i11, this.f50531r, "capability_reported", true);
                        m64470p0();
                    } else {
                        m64420Q0(1);
                        m7426P(this.f50506L, "hisync.findmyphone_locate", 1, i11, "001_3004", i11, this.f5586g + "phoneFinder G_Locate handleCapabilityReportCallback fail,resultCode:" + i11, this.f50531r, "capability_reported", true);
                    }
                }
            } catch (JSONException unused) {
                C13981a.m83988e(this.f50506L, "handleClientCapabilityReport JSONException");
                m64420Q0(1);
                m7426P(this.f50506L, "hisync.findmyphone_locate", 1, iM1685c, "001_1014", -1, this.f5586g + "handleClientCapabilityReport JSONException", this.f50531r, "capability_reported", true);
            }
        } else {
            m64420Q0(1);
            m7426P(this.f50506L, "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "phoneFinder G_Locate handleCapabilityReportCallback fail,result:" + iM1685c, this.f50531r, "capability_reported", true);
        }
        return true;
    }

    /* renamed from: M0 */
    public final void m64416M0(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50506L, "handleReportG_LocateCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83989i(this.f50506L, "handleReportG_LocateCallback->report error");
            m7426P(this.f50506L, "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "G_Locate handleReportG_LocateCallback fail,result:" + iM1685c, this.f50531r, "pushLocate", false);
            this.f50536w = true;
            return;
        }
        String string = message.getData().getString("response_info");
        int iM7438x = m7438x(string);
        C13981a.m83989i(this.f50506L, "handleReportG_LocateCallback->resultCode =" + iM7438x);
        if (iM7438x == 0) {
            m64458K0();
            new C10813a(this.f5580a, new AbstractC10482g.b(3020)).m65856d();
            if (!this.f50534u) {
                this.f50515A = System.currentTimeMillis() - this.f50538y;
                this.f50534u = true;
            }
            String strM7439y = m7439y(string);
            C13981a.m83989i(this.f50506L, "handleReportG_LocateCallback->result:" + strM7439y);
            m7424L("hisync.findmyphone_locate", 1, 0);
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
            m7426P(this.f50506L, "hisync.findmyphone_locate", 1, iM7438x, "001_3004", iM7438x, this.f5586g + "G_Locate handleReportG_LocateCallback fail,resultCode:" + iM7438x, this.f50531r, "pushLocate", true);
        }
    }

    /* renamed from: N0 */
    public final void m64417N0(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50506L, "handleReportG_LocateFailCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83989i(this.f50506L, "handleReportG_LocateFailCallback->report error");
            m7426P(this.f50506L, "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "phoneFinder G_Locate handleReportG_LocateFailCallback fail,result:" + iM1685c, this.f50531r, "pushLocate", true);
            return;
        }
        int iM7438x = m7438x(message.getData().getString("response_info"));
        C13981a.m83989i(this.f50506L, "handleReportG_LocateFailCallback->resultCode =" + iM7438x);
        if (iM7438x != 0) {
            m7426P(this.f50506L, "hisync.findmyphone_locate", 1, iM7438x, "001_3004", iM7438x, this.f5586g + "phoneFinder G_Locate handleReportG_LocateFailCallback fail,resultCode:" + iM7438x, this.f50531r, "pushLocate", true);
        }
        if (401 == iM7438x) {
            m64470p0();
        }
    }

    /* renamed from: O0 */
    public final boolean m64418O0() {
        if (this.f50534u) {
            long j10 = this.f50515A;
            if (j10 <= this.f50529p && j10 != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: P0 */
    public final void m64419P0() {
        if (this.f50532s.m64479a()) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("providerType", this.f50526m);
        linkedHashMap.put("satelliteCount", String.valueOf(this.f50527n));
        linkedHashMap.put("accuracy", String.valueOf(this.f50528o));
        linkedHashMap.put("source", "system");
        if (m64418O0()) {
            m7427Q(this.f50506L, "0", -1, "G_Locate success, uuid:" + C10487l.m64536b().m64547d(), null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (this.f50534u && this.f50539z > this.f50529p) {
            m7427Q(this.f50506L, "001_82", -1, "G_Locate success but over one duration", null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (m64472s0()) {
            m7427Q(this.f50506L, "001_81", -1, "G_Locate get location in one duration but report late", null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (!this.f50534u && this.f50535v) {
            m7427Q(this.f50506L, "001_84", -1, "G_Locate get location over one duration and report late", null, this.f50531r, "pushLocate", true, linkedHashMap);
            return;
        }
        if (this.f50534u || this.f50535v) {
            m64421R0(linkedHashMap);
            return;
        }
        long j10 = this.f50537x;
        if (j10 == 0) {
            m7427Q(this.f50506L, "001_85", -1, "G_Locate could not get cache location", null, this.f50531r, "pushLocate", true, linkedHashMap);
        } else if (j10 <= this.f50529p) {
            m7427Q(this.f50506L, "001_80", -1, "G_Locate location overdue in one duration", null, this.f50531r, "pushLocate", true, linkedHashMap);
        } else {
            m7427Q(this.f50506L, "001_83", -1, "G_Locate location overdue over one duration", null, this.f50531r, "pushLocate", true, linkedHashMap);
        }
    }

    /* renamed from: Q0 */
    public void m64420Q0(int i10) throws JSONException {
        C10481f.m64439o(this.f5580a, this, true);
        if (!C1175a.m7389k(this.f5580a)) {
            m7425M();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject.put(JsbMapKeyNames.H5_LOC_LON, 0.0d);
            jSONObject.put(JsbMapKeyNames.H5_LOC_LAT, 0.0d);
            jSONObject.put("longitude_WGS", 0.0d);
            jSONObject.put("latitude_WGS", 0.0d);
            jSONObject.put("accuracy", 0.0d);
            jSONObject.put("maptype", 2);
            jSONObject.put("simSn", "");
            jSONObject.put("batteryStatus", C13811a.m82816m(this.f5580a));
            this.f5582c = i10;
            this.f5583d = jSONObject;
            m7417D(new AbstractC10482g.b(3026));
        } catch (JSONException unused) {
            C13981a.m83988e(this.f50506L, "reportG_LocateFailResult JSONException");
        }
    }

    /* renamed from: R0 */
    public final void m64421R0(LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f50534u);
        sb2.append('|');
        sb2.append(this.f50535v);
        sb2.append('|');
        sb2.append(this.f50515A);
        sb2.append('|');
        sb2.append(this.f50539z);
        sb2.append('|');
        sb2.append(this.f50537x);
        m7427Q(this.f50506L, "001_1014", -1, "G_Locate location result error: " + sb2.toString(), null, this.f50531r, "pushLocate", true, linkedHashMap);
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: b */
    public void mo64422b() {
        C10481f.m64439o(this.f5580a, this, true);
        if (!this.f50535v && !this.f50532s.m64480b()) {
            C13981a.m83989i(this.f50506L, "get no location finally");
            this.f5582c = 68;
            this.f5583d = null;
            m7417D(null);
            m7427Q(this.f50506L, "001_2001", 68, this.f5586g + "G_Locate get no location finally", null, this.f50531r, "pushLocate", true, null);
        }
        m64419P0();
        m64461f0();
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: d */
    public void mo64423d(C10488m c10488m) throws JSONException {
        if (c10488m == null || c10488m.m64550b() == null) {
            C13981a.m83990w(this.f50506L, "location info is null");
            return;
        }
        C13981a.m83989i(this.f50506L, "onLocateUpdate:" + c10488m.m64550b().getProvider() + "," + c10488m.m64550b().getAccuracy());
        C10489n.m64552d().m64553a(c10488m.m64550b());
        C10489n.m64552d().m64556e(c10488m.m64549a());
        m64475v0(c10488m.m64550b());
        m64449A0(c10488m, C13811a.m82820q(this.f5580a), System.currentTimeMillis());
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: e */
    public void mo64424e(Location location) {
        C13981a.m83989i(this.f50506L, "locateAgain");
        if (!this.f50535v && !this.f50532s.m64480b()) {
            C13981a.m83989i(this.f50506L, "get no location in 30s");
            this.f5582c = 67;
            this.f5583d = null;
            m7417D(null);
            m7427Q(this.f50506L, "001_2001", 67, this.f5586g + "G_Locate get no location in 30s", null, this.f50531r, "pushLocate", false, null);
        }
        if (this.f50535v && !this.f50534u && this.f50536w && !this.f50532s.m64480b()) {
            C13981a.m83989i(this.f50506L, "has exception in 30s");
            m7427Q(this.f50506L, "001_2001", 70, this.f5586g, null, this.f50531r, "pushLocate", false, null);
        }
        m64451C0(location);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: o0 */
    public boolean mo64412o0(Message message, int i10, int i11) throws JSONException {
        C13981a.m83989i(this.f50506L, "HttpCallback->handleMessage:" + i10);
        if (3011 == i10) {
            return m64415L0(message, i11);
        }
        if (3020 == i10) {
            C10813a.m65855g(message, this.f5580a);
            return true;
        }
        if (3025 == i10) {
            m64416M0(message);
            return false;
        }
        if (3026 != i10) {
            return false;
        }
        m64417N0(message);
        return false;
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: q0 */
    public void mo64413q0() {
        super.mo64413q0();
        AbstractC1177c.f5579k = C0209d.m1206R1(C0213f.m1377a()) ? "Desktop" : "OOBE";
        C13981a.m83989i(this.f50506L, "initParams clientStatus:" + AbstractC1177c.f5579k);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: z0 */
    public void mo64414z0() throws JSONException {
        C13981a.m83988e(this.f50506L, "G_Locate hasPermissions = false");
        m64420Q0(66);
        m7426P(this.f50506L, "hisync.findmyphone_locate", 1, 66, "001_2001", 66, this.f5586g + "phoneFinder G_Locate fail", this.f50531r, "pushLocate", false);
    }
}
