package p366if;

import android.content.Context;
import android.location.Location;
import android.os.Message;
import android.text.TextUtils;
import bf.AbstractC1177c;
import bf.C1175a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.locate.PassiveLocateParam;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p366if.AbstractC10482g;
import p521og.C11877j;
import p774xg.C13811a;
import p809yg.C13981a;
import ug.C13172b;

/* renamed from: if.o */
/* loaded from: classes4.dex */
public class C10490o extends AbstractC10482g implements InterfaceC10483h {

    /* renamed from: N */
    public static final Gson f50630N = new Gson();

    /* renamed from: L */
    public String f50631L;

    /* renamed from: M */
    public PassiveLocateParam f50632M;

    public C10490o(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f50631L = "LowPowerLocation";
        this.f50631L = m64466k0("LowPowerLocation");
        m64561O0();
        this.f50523I = new C10493r(this, this.f5580a, this.f50631L, this.f50632M);
    }

    /* renamed from: L0 */
    private boolean m64557L0(Message message, int i10) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50631L, "handleCapabilityReportCallback result:" + iM1685c);
        if (200 == iM1685c) {
            try {
                JSONObject jSONObject = new JSONObject(message.getData().getString("response_info"));
                if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                    int i11 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
                    C13981a.m83989i(this.f50631L, "handleCapabilityReportCallback resultCode:= " + i11);
                    if (i11 == 0) {
                        C13172b.m79213i(this.f5580a, i10);
                        m64469n0();
                        C10481f.m64439o(this.f5580a, this, false);
                    } else if (401 == i11) {
                        m64562P0(1);
                        m64470p0();
                    } else {
                        m64562P0(1);
                    }
                }
            } catch (JSONException unused) {
                C13981a.m83988e(this.f50631L, "handleClientCapabilityReport JSONException");
                m64562P0(1);
            }
        } else {
            m64562P0(1);
        }
        return true;
    }

    /* renamed from: M0 */
    private void m64558M0(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50631L, "handleReportG_LocateCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83989i(this.f50631L, "handleReportG_LocateCallback->report error");
            this.f50536w = true;
            return;
        }
        String string = message.getData().getString("response_info");
        int iM7438x = m7438x(string);
        C13981a.m83989i(this.f50631L, "handleReportG_LocateCallback->resultCode =" + iM7438x);
        if (iM7438x == 0) {
            m64458K0();
            String strM7439y = m7439y(string);
            C13981a.m83989i(this.f50631L, "handleReportG_LocateCallback->result:" + strM7439y);
        }
        if (401 == iM7438x) {
            m64470p0();
        }
    }

    /* renamed from: N0 */
    private void m64559N0(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50631L, "handleReportG_LocateFailCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83989i(this.f50631L, "handleReportG_LocateFailCallback->report error");
            return;
        }
        int iM7438x = m7438x(message.getData().getString("response_info"));
        C13981a.m83989i(this.f50631L, "handleReportG_LocateFailCallback->resultCode =" + iM7438x);
        if (401 == iM7438x) {
            m64470p0();
        }
    }

    /* renamed from: Q0 */
    private void m64560Q0() {
        PassiveLocateParam passiveLocateParam = this.f50632M;
        if (passiveLocateParam == null) {
            C13981a.m83988e(this.f50631L, "saveAlsPassiveParams,curPassiveLocateParam is null");
        } else {
            C11877j.m71285m0(this.f5580a, f50630N.toJson(passiveLocateParam));
        }
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: I0 */
    public void mo64403I0() {
        this.f50523I.mo64391g();
        m64473t0();
    }

    /* renamed from: O0 */
    public final void m64561O0() {
        String strM71240W = C11877j.m71240W(this.f5580a);
        if (TextUtils.isEmpty(strM71240W)) {
            this.f50632M = new PassiveLocateParam(null);
            return;
        }
        try {
            this.f50632M = (PassiveLocateParam) f50630N.fromJson(strM71240W, PassiveLocateParam.class);
        } catch (JsonSyntaxException e10) {
            C13981a.m83989i(this.f50631L, "initPassiveParams e:" + e10.getMessage());
        }
        if (this.f50632M == null) {
            this.f50632M = new PassiveLocateParam(null);
        }
    }

    /* renamed from: P0 */
    public final void m64562P0(int i10) throws JSONException {
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
            C13981a.m83988e(this.f50631L, "reportG_LocateFailResult JSONException");
        }
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: b */
    public void mo64422b() {
        C10481f.m64439o(this.f5580a, this, true);
        m64560Q0();
        m64461f0();
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: d */
    public void mo64423d(C10488m c10488m) throws JSONException {
        if (c10488m == null) {
            C13981a.m83988e(this.f50631L, "location info is null");
        } else {
            m64449A0(c10488m, C13811a.m82820q(this.f5580a), System.currentTimeMillis());
            mo64422b();
        }
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: e */
    public void mo64424e(Location location) {
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: o0 */
    public boolean mo64412o0(Message message, int i10, int i11) throws JSONException {
        if (3011 == i10) {
            return m64557L0(message, i11);
        }
        if (3025 == i10) {
            m64558M0(message);
            return false;
        }
        if (3026 != i10) {
            return false;
        }
        m64559N0(message);
        return false;
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: q0 */
    public void mo64413q0() {
        super.mo64413q0();
        AbstractC1177c.f5579k = "LowPower";
        C13981a.m83989i(this.f50631L, "initParams clientStatus:" + AbstractC1177c.f5579k);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: r0 */
    public boolean mo64471r0() {
        return false;
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: z0 */
    public void mo64414z0() throws JSONException {
        C13981a.m83988e(this.f50631L, "LowPowerLocation hasPermissions = false");
        m64562P0(66);
    }
}
