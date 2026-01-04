package p772xe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.huawei.android.remotecontrol.bluetooth.AlsDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.locate.AncillaryDeviceLocationInfo;
import com.huawei.android.remotecontrol.bluetooth.locate.LocateHistoryDbHelper;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkScanResult;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import eg.AbstractC9478g;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import nf.C11690w;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0241z;
import p227dg.C9120m0;
import p366if.AbstractC10482g;
import p366if.C10481f;
import p366if.C10488m;
import p366if.C10489n;
import p366if.C10492q;
import p366if.InterfaceC10483h;
import p521og.C11881n;
import p616rk.C12515a;
import p664u0.C13108a;
import p677ue.C13168a;
import p738we.InterfaceC13594a;
import p774xg.C13812b;
import p809yg.C13981a;
import ve.C13428t;
import ye.C13978y;

/* renamed from: xe.d */
/* loaded from: classes4.dex */
public class C13779d extends AbstractC10482g implements InterfaceC10483h, InterfaceC13594a {

    /* renamed from: L */
    public String f61897L;

    /* renamed from: M */
    public Timer f61898M;

    /* renamed from: N */
    public String f61899N;

    /* renamed from: O */
    public String f61900O;

    /* renamed from: P */
    public String f61901P;

    /* renamed from: Q */
    public int f61902Q;

    /* renamed from: R */
    public boolean f61903R;

    /* renamed from: S */
    public c f61904S;

    /* renamed from: T */
    public AlsDeviceInfo f61905T;

    /* renamed from: U */
    public AncillaryDeviceLocationInfo f61906U;

    /* renamed from: V */
    public String f61907V;

    /* renamed from: xe.d$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13779d.this.m82728c1();
        }
    }

    /* renamed from: xe.d$b */
    public class b extends AbstractC9478g {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13779d.this.m82728c1();
        }
    }

    /* renamed from: xe.d$c */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (context == null || intent == null) {
                C13981a.m83988e(C13779d.this.f61897L, "Als locate receiver:context or intent is empty");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            C13981a.m83989i(C13779d.this.f61897L, "AlsDeviceLocateReceiver action = " + action);
            if ("com.huawei.android.remotecontrol.action.SEARCH_RESULT".equals(action)) {
                C13779d.this.m82720U0(hiCloudSafeIntent);
            } else if ("com.huawei.android.remotecontrol.action.LOCATE_WEAR_DEVICE_RESULT".equals(action)) {
                C13779d.this.m82721V0(hiCloudSafeIntent);
            }
        }
    }

    /* renamed from: xe.d$d */
    public class d extends TimerTask {
        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13779d.this.m82731f1();
            C13779d.this.m82728c1();
        }
    }

    public C13779d(PushCmdParser pushCmdParser, Context context, String str) {
        super(pushCmdParser, context);
        this.f61897L = "AncillaryDeviceLocate";
        this.f61899N = "";
        this.f61903R = false;
        this.f61905T = new AlsDeviceInfo();
        String strM64466k0 = m64466k0(this.f61897L);
        this.f61897L = strM64466k0;
        this.f61907V = str;
        this.f50523I = new C10492q(this, this.f5580a, strM64466k0);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: I0 */
    public void mo64403I0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("AncillaryDeviceOperate", "startLocate, perDeviceId: " + C9120m0.m57351R(this.f61899N));
        C13777b.m82708i(this.f5580a, true);
        C13777b.m82700a(this);
        this.f50523I.mo64391g();
    }

    @Override // bf.AbstractC1177c
    /* renamed from: J */
    public boolean mo7422J() {
        this.f61899N = this.f5581b.getCmdParamValue("perDeviceId");
        this.f61900O = this.f5581b.getCmdParamValue("cptList");
        this.f61901P = this.f5581b.getCmdParamValue("perDeviceType");
        if (!TextUtils.isEmpty(this.f61899N)) {
            return true;
        }
        C13981a.m83988e(this.f61897L, "Cmd param: perDeviceId is empty");
        return false;
    }

    /* renamed from: R0 */
    public final void m82717R0() {
        C13981a.m83989i(this.f61897L, "cancelTimer");
        Timer timer = this.f61898M;
        if (timer != null) {
            timer.cancel();
            this.f61898M = null;
        }
    }

    /* renamed from: S0 */
    public final void m82718S0() {
        if (!mo7422J()) {
            m82727b1(9);
            return;
        }
        if (!C13168a.m79182k()) {
            C13981a.m83990w(this.f61897L, "bluetooth is closed");
            m82727b1(11);
        } else if (m81752h(this.f61901P)) {
            m82726a1();
        }
    }

    /* renamed from: T0 */
    public final void m82719T0(Location location) {
        C13981a.m83989i(this.f61897L, "genDeviceLocationInfoAndReport, perDeviceId: " + C9120m0.m57351R(this.f61899N));
        if (C13777b.m82705f(this.f61899N)) {
            C13981a.m83990w(this.f61897L, "locate device is disconnect, stop report");
            return;
        }
        String deviceID = this.f61899N;
        if (this.f61906U == null) {
            this.f61906U = new AncillaryDeviceLocationInfo();
        }
        this.f61906U.setAccuracy(location.getAccuracy());
        this.f61906U.setConnectType(this.f61902Q);
        if (!C13168a.m79183l(this.f61901P)) {
            String strM82704e = C13777b.m82704e(C13777b.m82703d(this.f61899N), true);
            if (TextUtils.isEmpty(strM82704e)) {
                C13981a.m83988e(this.f61897L, "Connected devices is empty");
                return;
            }
            this.f61906U.setCptList(strM82704e);
            this.f61906U.setBattery(C13777b.m82702c("0".equals(this.f61900O), C13777b.m82703d(this.f61899N), this.f61905T.getBattery(), true));
            deviceID = this.f61905T.getDeviceID();
        }
        String str = deviceID;
        this.f61906U.setLatitude(location.getLatitude());
        this.f61906U.setLongitude(location.getLongitude());
        this.f61906U.setFloor(C13812b.m82831b(location));
        this.f61906U.setLocationTime(C13812b.m82837h(location));
        this.f61906U.setLocationRouter(C13812b.m82836g(location));
        this.f61906U.setLocCpTransId(C13812b.m82833d(location));
        this.f61906U.setLocSessionId(C13812b.m82835f(location));
        this.f61906U.setLocFenceTime(C13812b.m82834e(location));
        this.f61906U.setType(!location.getProvider().equals("network") ? 1 : 0);
        this.f61906U.setTime(location.getTime() + C11881n.m71358h());
        this.f61906U.setOperationType("perDevicelocate");
        C13781f c13781f = new C13781f(0, location.getTime(), str, this.f61900O, this.f61901P, this.f5580a, this.f61906U, this.f5581b.getTraceID(), this.f61907V, new AbstractC10482g.b(3032));
        if (C13168a.m79183l(this.f61901P)) {
            c13781f.m82749q().m85164h(this.f5581b.getTagOperation());
        }
        c13781f.m82741i();
    }

    /* renamed from: U0 */
    public final void m82720U0(SafeIntent safeIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        String strM71362l;
        JSONObject jSONObject;
        String strM71362l2 = "";
        C13981a.m83989i(this.f61897L, "handleLocateBluetoothDevice");
        String stringExtra = safeIntent.getStringExtra("deviceId");
        String stringExtra2 = safeIntent.getStringExtra("connectionState");
        String stringExtra3 = safeIntent.getStringExtra("battery");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            C13981a.m83988e(this.f61897L, "ancillary device status is empty");
            return;
        }
        if (!this.f61899N.equals(stringExtra)) {
            C13981a.m83989i(this.f61897L, "receive other ancillary device locate broadcast");
            return;
        }
        m82731f1();
        m82717R0();
        this.f61905T.setDeviceID(stringExtra);
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        SparseIntArray sparseIntArray2 = new SparseIntArray(2);
        try {
            jSONObject = new JSONObject(stringExtra2);
            C13981a.m83989i(this.f61897L, "handleLocateBluetoothDevice, connectStatus: " + jSONObject);
            strM71362l = C11881n.m71362l(jSONObject, "0x00");
        } catch (JSONException e10) {
            e = e10;
            str = "";
        }
        try {
            if (!TextUtils.isEmpty(strM71362l)) {
                C13981a.m83989i(this.f61897L, "cptType:0 state:" + strM71362l);
                sparseIntArray.put(0, C0241z.m1685c(strM71362l));
            }
            strM71362l2 = C11881n.m71362l(jSONObject, "0x01");
            if (!TextUtils.isEmpty(strM71362l2)) {
                C13981a.m83989i(this.f61897L, "cptType:1 state:" + strM71362l2);
                sparseIntArray.put(1, C0241z.m1685c(strM71362l2));
            }
            JSONObject jSONObject2 = new JSONObject(stringExtra3);
            String strM71362l3 = C11881n.m71362l(jSONObject2, "0x00");
            if (!TextUtils.isEmpty(strM71362l3)) {
                C13981a.m83989i(this.f61897L, "ancLeftBattery:0 state:" + strM71362l3);
                sparseIntArray2.put(0, C0241z.m1685c(strM71362l3));
            }
            String strM71362l4 = C11881n.m71362l(jSONObject2, "0x01");
            if (!TextUtils.isEmpty(strM71362l4)) {
                C13981a.m83989i(this.f61897L, "ancRightBattery:1 state:" + strM71362l4);
                sparseIntArray2.put(1, C0241z.m1685c(strM71362l4));
            }
        } catch (JSONException e11) {
            e = e11;
            str = strM71362l2;
            strM71362l2 = strM71362l;
            C13981a.m83988e(this.f61897L, "parseDevicesState:JSONException=" + e.getMessage());
            strM71362l = strM71362l2;
            strM71362l2 = str;
            this.f61905T.setConnectStatus(sparseIntArray);
            C13777b.m82710k(this.f61899N, sparseIntArray, true);
            this.f61905T.setBattery(sparseIntArray2);
            m82730e1(stringExtra, strM71362l, strM71362l2);
        }
        this.f61905T.setConnectStatus(sparseIntArray);
        C13777b.m82710k(this.f61899N, sparseIntArray, true);
        this.f61905T.setBattery(sparseIntArray2);
        m82730e1(stringExtra, strM71362l, strM71362l2);
    }

    /* renamed from: V0 */
    public final void m82721V0(SafeIntent safeIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String stringExtra = safeIntent.getStringExtra("deviceId");
        boolean booleanExtra = safeIntent.getBooleanExtra("isConnect", false);
        C13981a.m83989i(this.f61897L, "handleLocateWearDevice, deviceId: " + C9120m0.m57351R(stringExtra) + ", isConnect: " + booleanExtra);
        int intExtra = safeIntent.getIntExtra("battery", -1);
        int intExtra2 = safeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 0);
        if (TextUtils.isEmpty(stringExtra)) {
            C13981a.m83988e(this.f61897L, "wear device id is empty");
            return;
        }
        if (!this.f61899N.equals(stringExtra)) {
            C13981a.m83989i(this.f61897L, "receive other wear device locate broadcast");
            return;
        }
        C13978y.m83903T().m83940B0(stringExtra + JsbMapKeyNames.H5_LOC);
        m82731f1();
        m82717R0();
        if (intExtra2 != 0) {
            m82727b1(intExtra2);
            return;
        }
        this.f61905T.setDeviceID(stringExtra);
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        sparseIntArray.put(0, booleanExtra ? C0241z.m1685c("2") : C0241z.m1685c("0"));
        this.f61905T.setConnectStatus(sparseIntArray);
        C13777b.m82710k(this.f61899N, sparseIntArray, true);
        SparseIntArray sparseIntArray2 = new SparseIntArray(2);
        sparseIntArray2.put(0, intExtra);
        this.f61905T.setBattery(sparseIntArray2);
        if (!booleanExtra) {
            C13981a.m83989i(this.f61897L, "device disconnect, report history location");
            C12515a.m75110o().m75172d(new b());
            return;
        }
        this.f61902Q = C0241z.m1685c("2");
        Location locationM64555c = C10489n.m64552d().m64555c();
        if (locationM64555c == null) {
            mo64403I0();
            C13428t.m80716a(stringExtra, "2", "0", "ancillaryDevice startLocate", "ancillaryDeviceLocate", "wearEngineDevice", null);
        } else {
            C13981a.m83989i(this.f61897L, "report global cache location");
            m82719T0(locationM64555c);
            C13428t.m80716a(stringExtra, "2", "0", "ancillaryDevice report global cache location", "ancillaryDeviceLocate", "wearEngineDevice", null);
        }
    }

    /* renamed from: W0 */
    public final boolean m82722W0(String str) {
        return (TextUtils.isEmpty(str) || "0".equals(str)) ? false : true;
    }

    /* renamed from: X0 */
    public void m82723X0(FindNetworkScanResult findNetworkScanResult) {
        C13981a.m83989i(this.f61897L, "onScanResult");
        m82717R0();
        this.f61902Q = C0241z.m1685c("2");
        AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = new AncillaryDeviceLocationInfo();
        this.f61906U = ancillaryDeviceLocationInfo;
        ancillaryDeviceLocationInfo.setConfidence(findNetworkScanResult.getmRssi());
        this.f61906U.setStandbyDevice(findNetworkScanResult.getStandbyDevice());
        this.f61906U.setDistance(-1.0f);
        mo64403I0();
    }

    /* renamed from: Y0 */
    public final void m82724Y0(String str) {
        C13981a.m83989i(this.f61897L, "query wear device state, deviceId: " + C9120m0.m57351R(str) + ", traceId: " + this.f5581b.getTraceID());
        if (str == null) {
            C13981a.m83988e(this.f61897L, "query wear device perDeviceId is null");
            return;
        }
        try {
            C13978y.m83903T().m83956N(str, JsbMapKeyNames.H5_LOC, this.f5581b.getTraceID());
        } catch (Exception e10) {
            C13981a.m83988e(this.f61897L, "queryWearDeviceState error:" + e10.getMessage());
        }
    }

    /* renamed from: Z0 */
    public final void m82725Z0() {
        if (this.f61904S == null) {
            this.f61904S = new c();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.remotecontrol.action.SEARCH_RESULT");
        intentFilter.addAction("com.huawei.android.remotecontrol.action.LOCATE_WEAR_DEVICE_RESULT");
        C13108a.m78878b(this.f5580a).m78880c(this.f61904S, intentFilter);
    }

    /* renamed from: a1 */
    public final void m82726a1() {
        if (this.f61898M == null) {
            this.f61898M = new Timer();
        }
        this.f61898M.schedule(new d(), ParamConfig.getInstance().getBtLocationInterval());
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: b */
    public void mo64422b() {
        C13981a.m83989i(this.f61897L, "locate Terminate");
        if (!this.f61903R) {
            m82727b1(68);
        }
        C13777b.m82709j(this.f5580a, this);
    }

    /* renamed from: b1 */
    public final void m82727b1(int i10) {
        AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = new AncillaryDeviceLocationInfo();
        ancillaryDeviceLocationInfo.setOperationType("perDevicelocate");
        ancillaryDeviceLocationInfo.setCptList(this.f5581b.getCmdParamValue("cptList"));
        C13781f c13781f = new C13781f(i10, 0L, this.f61899N, this.f61900O, this.f61901P, this.f5580a, ancillaryDeviceLocationInfo, this.f5581b.getTraceID(), this.f61907V, new AbstractC10482g.b(3032));
        if (C13168a.m79183l(this.f61901P)) {
            c13781f.m82749q().m85164h(this.f5581b.getTagOperation());
        }
        c13781f.m82741i();
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: c */
    public boolean mo26024c() {
        C13981a.m83989i(this.f61897L, "startScan");
        C11690w.m69729m0(this.f5580a, this.f61899N, this);
        return true;
    }

    /* renamed from: c1 */
    public final void m82728c1() {
        List<String> listM26142u = LocateHistoryDbHelper.m26135e(this.f5580a).m26142u(this.f5580a, this.f61899N, "1");
        if (listM26142u.isEmpty()) {
            C13981a.m83988e(this.f61897L, "Locate history list is empty");
            C13428t.m80716a("", this.f61899N, "1", "locate history list is empty", "ancillaryDeviceLocate", "ancillaryDeviceLocate", null);
            return;
        }
        Iterator<String> it = listM26142u.iterator();
        while (it.hasNext()) {
            C13781f c13781f = new C13781f(it.next(), this.f5580a, new AbstractC10482g.b(3032));
            if (C13168a.m79183l(this.f61901P)) {
                c13781f.m82749q().m85164h(this.f5581b.getTagOperation());
            }
            c13781f.m82741i();
            C13428t.m80716a("", "1", "0", "ancillaryDevice report history location", "ancillaryDeviceLocate", "airLinkDevice", null);
        }
        LocateHistoryDbHelper.m26135e(this.f5580a).m26138c(this.f61899N, "1");
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: d */
    public void mo64423d(C10488m c10488m) {
        if (c10488m == null) {
            C13981a.m83988e(this.f61897L, "location info is null");
        } else {
            m82719T0(c10488m.m64550b());
            this.f61903R = true;
        }
    }

    /* renamed from: d1 */
    public final void m82729d1(String str) throws JSONException {
        C13981a.m83989i(this.f61897L, "sendOperation, startSearch deviceId: " + C9120m0.m57351R(str));
        long btLocationInterval = ParamConfig.getInstance().getBtLocationInterval();
        long btTimeOffset = ParamConfig.getInstance().getBtTimeOffset();
        Bundle bundle = new Bundle();
        bundle.putLong("searchTime", btLocationInterval);
        bundle.putLong("reportInterval", btTimeOffset);
        bundle.putString("deviceId", str);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject2.put(String.valueOf(0), ParamConfig.getInstance().getBtLocDisInterval());
            jSONObject2.put(String.valueOf(1), ParamConfig.getInstance().getBtLocDisInterval());
            jSONObject3.put(String.valueOf(0), ParamConfig.getInstance().getBtLocAglInterval());
            jSONObject3.put(String.valueOf(1), ParamConfig.getInstance().getBtLocAglInterval());
            jSONObject.put("distance", jSONObject2);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, jSONObject3);
        } catch (JSONException e10) {
            C13981a.m83988e(this.f61897L, "JSONException: " + e10.getMessage());
        }
        bundle.putString("threshold", jSONObject.toString());
        new C13168a("startSearch", bundle).m79190g();
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: e */
    public void mo64424e(Location location) {
    }

    /* renamed from: e1 */
    public final void m82730e1(String str, String str2, String str3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m82722W0(str2) && !m82722W0(str3)) {
            C13981a.m83989i(this.f61897L, "device disconnect, report history location");
            C12515a.m75110o().m75172d(new a());
            return;
        }
        this.f61902Q = ("2".equals(str2) || "2".equals(str3)) ? C0241z.m1685c("2") : C0241z.m1685c("3");
        if ("1".equals(str2) && "1".equals(str3)) {
            this.f61902Q = C0241z.m1685c("1");
        }
        Location locationM64555c = C10489n.m64552d().m64555c();
        if (locationM64555c == null) {
            C13428t.m80716a(str, "1", "0", "ancillaryDevice start locate", "ancillaryDeviceLocate", "airLinkDevice", null);
            mo64403I0();
        } else {
            C13981a.m83989i(this.f61897L, "report global cache location");
            m82719T0(locationM64555c);
            C13428t.m80716a(str, "1", "0", "ancillaryDevice report global cache location", "ancillaryDeviceLocate", "airLinkDevice", null);
        }
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: f */
    public boolean mo26025f() {
        if (C0209d.m1184K0(this.f5580a, C13978y.m83902S())) {
            m82725Z0();
            m82724Y0(this.f61899N);
            return true;
        }
        C13981a.m83990w(this.f61897L, "health not install");
        m82727b1(13);
        return false;
    }

    /* renamed from: f1 */
    public final void m82731f1() {
        if (this.f61904S != null) {
            C13108a.m78878b(this.f5580a).m78883f(this.f61904S);
        }
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: g */
    public boolean mo26026g() throws JSONException {
        C13981a.m83989i(this.f61897L, "operateBluetoothDevice, perDeviceId: " + C9120m0.m57351R(this.f61899N));
        m82725Z0();
        m82729d1(this.f61899N);
        return true;
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: o0 */
    public boolean mo64412o0(Message message, int i10, int i11) throws JSONException {
        C13981a.m83989i(this.f61897L, "HttpCallback->handleMessage->AncillaryDeviceLocateReport");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("perDeviceType", this.f5581b.getCmdParamValue("perDeviceType"));
        if (200 != iM1685c) {
            C13981a.m83988e(this.f61897L, "handleLocateReportResult->report error, result:" + iM1685c);
            m7427Q(this.f61897L, "001_3003", -1, "handleLocateReportResult callback error,result:" + iM1685c, null, this.f5581b.getOperation(), "ancillaryLocate", true, linkedHashMap);
            return true;
        }
        String string = message.getData().getString("response_info");
        int iM7438x = m7438x(string);
        C13981a.m83989i(this.f61897L, "handleAncillaryDeviceLocateReport resultCode =" + iM7438x);
        if (iM7438x != 0) {
            m7427Q(this.f61897L, "001_3004", iM7438x, "handleLocateReportResult callback fail,resultCode:" + iM7438x, null, this.f5581b.getOperation(), "ancillaryLocate", true, linkedHashMap);
            return true;
        }
        String strM7439y = m7439y(string);
        C13981a.m83989i(this.f61897L, "handleAncillaryDeviceLocateReport,AppEventLogParam report success" + strM7439y);
        m7427Q(this.f61897L, "0", -1, "handleLocateReportResult callback success", null, this.f5581b.getOperation(), "ancillaryLocate", true, linkedHashMap);
        return true;
    }

    @Override // p366if.AbstractC10482g, bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (!C4347e.m26238i(this.f5580a)) {
            C13981a.m83988e(this.f61897L, "do not have locate permission");
            mo64414z0();
        } else if (C10481f.m64435k()) {
            new Handler().postDelayed(new Runnable() { // from class: xe.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61896a.m82718S0();
                }
            }, 1000L);
        } else {
            m82718S0();
        }
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: z0 */
    public void mo64414z0() {
        m82727b1(66);
    }
}
