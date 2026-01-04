package p772xe;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceDBHelper;
import com.huawei.android.remotecontrol.bluetooth.locate.AncillaryDeviceLocationInfo;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.controller.PhoneFinderEncryptData;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.tag.bean.TagLocalFindResult;
import com.huawei.gson.JsonArray;
import com.huawei.gson.JsonObject;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.TagStatus;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import eg.AbstractC9478g;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p227dg.C9120m0;
import p366if.C10487l;
import p520of.C11860j;
import p521og.C11869b;
import p521og.C11881n;
import p616rk.C12515a;
import p677ue.C13168a;
import p809yg.C13981a;
import p842zf.C14298f;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: xe.f */
/* loaded from: classes4.dex */
public class C13781f {

    /* renamed from: m */
    public static final Gson f61912m = new Gson();

    /* renamed from: a */
    public Handler.Callback f61913a;

    /* renamed from: b */
    public int f61914b;

    /* renamed from: c */
    public long f61915c;

    /* renamed from: d */
    public String f61916d;

    /* renamed from: e */
    public String f61917e;

    /* renamed from: f */
    public String f61918f;

    /* renamed from: g */
    public Context f61919g;

    /* renamed from: h */
    public String f61920h;

    /* renamed from: i */
    public AncillaryDeviceLocationInfo f61921i;

    /* renamed from: j */
    public String f61922j;

    /* renamed from: k */
    public String f61923k;

    /* renamed from: l */
    public C14298f f61924l;

    /* renamed from: xe.f$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13781f.this.m82750s();
            if (TextUtils.isEmpty(C13781f.this.f61922j)) {
                C13981a.m83988e("AncillaryDeviceLocationReport", "report ancillary locate data is empty");
                return;
            }
            if (C13781f.this.m82749q().m85162e()) {
                TagLocalFindResult tagLocalFindResultM85159b = C13781f.this.m82749q().m85159b(C13781f.this.f61922j);
                C13781f c13781f = C13781f.this;
                C13781f.this.m82749q().m85163g(C13781f.this.f61919g, tagLocalFindResultM85159b, c13781f.m82743k(c13781f.f61922j, tagLocalFindResultM85159b));
            }
            RequestModeConfig.getInstance().setMode(3032, false);
            C4346d.m26226e(3032, C13781f.this.f61922j, C13781f.this.f61913a, C13781f.this.f61919g, C13781f.this.f61923k);
        }
    }

    /* renamed from: xe.f$b */
    public class b extends AbstractC9478g {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13781f.this.m82750s();
            if (TextUtils.isEmpty(C13781f.this.f61922j)) {
                C13981a.m83988e("AncillaryDeviceLocationReport", "report ancillary locate data is empty");
                return;
            }
            TagLocalFindResult tagLocalFindResultM85159b = C13781f.this.m82749q().m85159b(C13781f.this.f61922j);
            C13781f c13781f = C13781f.this;
            C13781f.this.m82749q().m85163g(C13781f.this.f61919g, tagLocalFindResultM85159b, c13781f.m82743k(c13781f.f61922j, tagLocalFindResultM85159b));
        }
    }

    public C13781f(int i10, long j10, String str, String str2, String str3, Context context, AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo, String str4, String str5, Handler.Callback callback) {
        this.f61924l = new C14298f();
        this.f61914b = i10;
        this.f61915c = j10;
        this.f61916d = str;
        this.f61917e = str2;
        this.f61918f = str3;
        this.f61919g = context;
        this.f61921i = ancillaryDeviceLocationInfo;
        this.f61923k = str4;
        this.f61920h = str5;
        this.f61913a = callback;
    }

    /* renamed from: r */
    public static /* synthetic */ void m82739r(boolean z10) {
        if (z10) {
            return;
        }
        C11860j.m71010N0("updateUserKey report ancillary location");
    }

    /* renamed from: h */
    public void m82740h() {
        C13981a.m83989i("AncillaryDeviceLocationReport", "doLocalReport");
        if (Math.abs(this.f61921i.getLatitude()) > 90.0d || Math.abs(this.f61921i.getLongitude()) > 180.0d) {
            C13981a.m83988e("AncillaryDeviceLocationReport", "location illegal");
        } else {
            C12515a.m75110o().m75175e(new b(), false);
        }
    }

    /* renamed from: i */
    public void m82741i() {
        C13981a.m83989i("AncillaryDeviceLocationReport", "doReport");
        if (Math.abs(this.f61921i.getLatitude()) > 90.0d || Math.abs(this.f61921i.getLongitude()) > 180.0d) {
            C13981a.m83988e("AncillaryDeviceLocationReport", "location illegal");
        } else {
            C12515a.m75110o().m75175e(new a(), false);
        }
    }

    /* renamed from: j */
    public final String m82742j(String str) throws JSONException, InterruptedException, IOException {
        DeviceDetail deviceDetailM57366Y0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mStandbyDevice", this.f61921i.getStandbyDevice());
            jSONObject.put("operation", this.f61921i.getOperationType());
            jSONObject.put("result", this.f61914b);
            if (!C13168a.m79181j(this.f61918f) && !C13168a.m79186o(this.f61918f)) {
                jSONObject.put("reportTime", this.f61915c);
            } else if (this.f61914b != 900) {
                jSONObject.put("reportTime", this.f61915c);
            }
            jSONObject.put("perDeviceType", this.f61918f);
            jSONObject.put("perDeviceId", this.f61916d);
            JSONObject jSONObject2 = new JSONObject();
            if (C13168a.m79183l(this.f61918f)) {
                String strM85160c = m82749q().m85160c();
                C13981a.m83989i("AncillaryDeviceLocationReport", "queryDeviceDetail tagOperation: " + strM85160c);
                if (this.f61914b == 11 || !("tagLocate".equals(strM85160c) || "queryTagDisconnectLocation".equals(strM85160c) || "queryGoodsOfflineLocation".equals(strM85160c))) {
                    deviceDetailM57366Y0 = null;
                } else {
                    deviceDetailM57366Y0 = C9120m0.m57366Y0(this.f61919g, this.f61916d);
                    C12797b c12797b = new C12797b();
                    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                    if (deviceDetailM57366Y0 != null) {
                        String strValueOf = String.valueOf(deviceDetailM57366Y0.getBatteryLevel());
                        linkedHashMap.put("version", deviceDetailM57366Y0.getFirmwareVersion() == null ? "" : deviceDetailM57366Y0.getFirmwareVersion());
                        linkedHashMap.put("batteryStatus", strValueOf);
                    } else {
                        linkedHashMap.put("version", "");
                        linkedHashMap.put("batteryStatus", "-1");
                    }
                    linkedHashMap.put("perDeviceId", C9120m0.m57351R(this.f61916d));
                    c12797b.m76785k(this.f61919g, "AncillaryDeviceLocationReport", "0", "queryDeviceDetail", null, "01061", null, null, true, linkedHashMap);
                }
                if (deviceDetailM57366Y0 != null) {
                    String strValueOf2 = String.valueOf(deviceDetailM57366Y0.getBatteryLevel());
                    String firmwareVersion = deviceDetailM57366Y0.getFirmwareVersion() == null ? "" : deviceDetailM57366Y0.getFirmwareVersion();
                    C13981a.m83989i("AncillaryDeviceLocationReport", "tag deviceDetail sn: " + C9120m0.m57351R(deviceDetailM57366Y0.getSn()) + ", battery:" + strValueOf2 + ", version:" + firmwareVersion);
                    this.f61921i.setBattery(strValueOf2);
                    jSONObject2.put("version", firmwareVersion);
                    jSONObject.put("componentType", deviceDetailM57366Y0.getComponentType());
                    jSONObject.put("accessoryCapabilities", deviceDetailM57366Y0.getAccessoryCapabilities());
                } else {
                    this.f61921i.setBattery("-1");
                    jSONObject2.put("version", "");
                }
                if ("tagLocate".equals(this.f61920h)) {
                    TagStatus tagStatusM57361W = C9120m0.m57361W(this.f61919g, this.f61916d);
                    C13981a.m83989i("AncillaryDeviceLocationReport", "checkTagStatus tagStatus: " + tagStatusM57361W);
                    if (tagStatusM57361W != null) {
                        jSONObject.put("exceptionStatus", tagStatusM57361W.getExceptionStatus());
                        jSONObject.put("standbyStatus", tagStatusM57361W.getStandbyStatus());
                    }
                }
            }
            if (this.f61914b != 0) {
                jSONObject2.put("cptList", this.f61921i.getCptList());
            } else {
                jSONObject2.put("connectType", this.f61921i.getConnectType());
                String cptList = "0";
                if (!C13168a.m79183l(this.f61918f)) {
                    if ("perDeviceDiscLocate".equals(this.f61921i.getOperationType())) {
                        String strM26059z = AncillaryDeviceDBHelper.m26045e(this.f61919g).m26059z(this.f61916d);
                        C13981a.m83989i("AncillaryDeviceLocationReport", "subDeviceType form DB is:" + strM26059z);
                        if (TextUtils.isEmpty(strM26059z)) {
                            return null;
                        }
                        if (!"1".equals(strM26059z)) {
                            cptList = this.f61921i.getCptList();
                        }
                    } else {
                        C13981a.m83989i("AncillaryDeviceLocationReport", "cptList form cmd is:" + this.f61917e);
                        if (!"0".equals(this.f61917e)) {
                            cptList = this.f61921i.getCptList();
                        }
                    }
                }
                jSONObject2.put("cptList", cptList);
                C13981a.m83989i("AncillaryDeviceLocationReport", "cptList form report is:" + cptList);
                String strM82748p = m82748p(this.f61921i.getLatitude(), this.f61921i.getLongitude());
                if (TextUtils.isEmpty(strM82748p)) {
                    C13981a.m83989i("AncillaryDeviceLocationReport", "reverse GeoCode empty");
                    jSONObject2.put("country", "");
                } else {
                    jSONObject2.put("country", !"CN".equalsIgnoreCase(strM82748p) ? 1 : 0);
                }
                JSONObject jSONObject3 = new JSONObject();
                C13981a.m83989i("AncillaryDeviceLocationReport", "ancillary battery is:" + this.f61921i.getBattery());
                jSONObject3.put("percentage", this.f61921i.getBattery());
                jSONObject2.put("batteryStatus", jSONObject3);
                jSONObject2.put("coordinateInfoList", m82744l(str));
                jSONObject2.put("confidence", this.f61921i.getConfidence());
                jSONObject2.put("distance", this.f61921i.getDistance());
            }
            jSONObject.put("cptLocateInfo", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("AncillaryDeviceLocationReport", "encaseLocationInfo failed! JSONException");
            return null;
        }
    }

    /* renamed from: k */
    public final String m82743k(String str, TagLocalFindResult tagLocalFindResult) throws JSONException {
        if (tagLocalFindResult == null) {
            C13981a.m83988e("AncillaryDeviceLocationReport", "encaseTagLocalLocateResult result is null");
            return "";
        }
        JsonObject jsonObject = new JsonObject();
        try {
            String operation = tagLocalFindResult.getOperation();
            jsonObject.addProperty("tagSn", tagLocalFindResult.getTagSn());
            jsonObject.addProperty("operation", operation);
            jsonObject.addProperty("info", tagLocalFindResult.getInfo());
            jsonObject.addProperty("exeResult", tagLocalFindResult.getExeResult());
            jsonObject.addProperty("executeTime", Long.valueOf(tagLocalFindResult.getExecuteTime()));
            jsonObject.addProperty("currentTime", Long.valueOf(tagLocalFindResult.getCurrentTime()));
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("cptLocateInfo");
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("connectType", Integer.valueOf(jSONObject2.optInt("connectType")));
            jsonObject2.addProperty("cptList", jSONObject2.optString("cptList"));
            jsonObject2.addProperty("country", jSONObject2.optString("country"));
            jsonObject2.addProperty("batteryStatus", jSONObject2.optString("batteryStatus"));
            jsonObject2.add("coordinateInfoList", m82745m());
            jsonObject2.addProperty("version", jSONObject2.optString("version"));
            if (jSONObject.has("standbyStatus")) {
                jsonObject2.addProperty("standbyStatus", jSONObject.optString("standbyStatus"));
            }
            if (jSONObject.has("exceptionStatus")) {
                jsonObject2.addProperty("exceptionStatus", jSONObject.optString("exceptionStatus"));
            }
            if (!TextUtils.equals(operation, "tagLocate") && !TextUtils.equals(operation, "tagListLocate") && jSONObject.has("mStandbyDevice")) {
                C13981a.m83989i("AncillaryDeviceLocationReport", "encaseTagLocalLocateResult, operation: " + operation);
                jsonObject2.addProperty("mStandbyDevice", jSONObject.optString("mStandbyDevice"));
            }
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(jsonObject2);
            jsonObject.add("cptLocateInfoList", jsonArray);
            return jsonObject.toString();
        } catch (Exception e10) {
            C13981a.m83988e("AncillaryDeviceLocationReport", "genTagCoordinateInfoList Exception" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: l */
    public final JSONArray m82744l(String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        String str5;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str6 = "locSessionId";
        JSONArray jSONArray3 = new JSONArray();
        if (AbstractC12139d.m72769h(this.f61919g)) {
            try {
                double[] dArrM64544k = C10487l.m64544k(this.f61921i.getLatitude(), this.f61921i.getLongitude());
                if (dArrM64544k == null || dArrM64544k.length <= 1) {
                    str2 = "encryptVersion";
                    str3 = "locFenceTime";
                    str6 = "locSessionId";
                    str4 = "locCpTransId";
                    str5 = "time";
                    jSONArray = jSONArray3;
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", this.f61921i.getType());
                    jSONObject.put("sysType", 2);
                    jSONObject.put(JsbMapKeyNames.H5_LOC_LAT, m82746n(dArrM64544k[0], str));
                    jSONObject.put(JsbMapKeyNames.H5_LOC_LON, m82746n(dArrM64544k[1], str));
                    jSONObject.put("accuracy", this.f61921i.getAccuracy());
                    jSONObject.put("time", this.f61921i.getTime());
                    if (!StringUtil.isBlank(this.f61921i.getFloor())) {
                        jSONObject.put("floor", m82747o(this.f61921i.getFloor(), str));
                    }
                    jSONObject.put("locationTime", this.f61921i.getLocationTime());
                    jSONObject.put("locationRouter", this.f61921i.getLocationRouter());
                    str4 = "locCpTransId";
                    jSONObject.put(str4, this.f61921i.getLocCpTransId());
                    str6 = "locSessionId";
                    jSONObject.put(str6, this.f61921i.getLocSessionId());
                    str3 = "locFenceTime";
                    jSONObject.put(str3, this.f61921i.getLocFenceTime());
                    str2 = "encryptVersion";
                    str5 = "time";
                    jSONObject.put(str2, 2);
                    jSONArray = jSONArray3;
                    try {
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                        jSONArray2 = jSONArray;
                        C13981a.m83988e("AncillaryDeviceLocationReport", "genCoordinateInfoList failed! JSONException");
                        return jSONArray2;
                    }
                }
            } catch (JSONException unused2) {
                jSONArray2 = jSONArray3;
                C13981a.m83988e("AncillaryDeviceLocationReport", "genCoordinateInfoList failed! JSONException");
                return jSONArray2;
            }
        } else {
            str2 = "encryptVersion";
            str5 = "time";
            jSONArray = jSONArray3;
            str3 = "locFenceTime";
            str4 = "locCpTransId";
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONArray3 = jSONArray;
        jSONObject2.put("type", this.f61921i.getType());
        jSONObject2.put("sysType", 1);
        jSONObject2.put(JsbMapKeyNames.H5_LOC_LAT, m82746n(this.f61921i.getLatitude(), str));
        jSONObject2.put(JsbMapKeyNames.H5_LOC_LON, m82746n(this.f61921i.getLongitude(), str));
        jSONObject2.put("floor", m82747o(this.f61921i.getFloor(), str));
        jSONObject2.put("locationTime", this.f61921i.getLocationTime());
        jSONObject2.put("locationRouter", this.f61921i.getLocationRouter());
        jSONObject2.put(str4, this.f61921i.getLocCpTransId());
        jSONObject2.put(str6, this.f61921i.getLocSessionId());
        jSONObject2.put(str3, this.f61921i.getLocFenceTime());
        jSONObject2.put("accuracy", this.f61921i.getAccuracy());
        jSONObject2.put(str5, this.f61921i.getTime());
        jSONObject2.put(str2, 2);
        jSONArray2 = jSONArray3;
        try {
            jSONArray2.put(jSONObject2);
        } catch (JSONException unused3) {
            C13981a.m83988e("AncillaryDeviceLocationReport", "genCoordinateInfoList failed! JSONException");
            return jSONArray2;
        }
        return jSONArray2;
    }

    /* renamed from: m */
    public final JsonArray m82745m() {
        JsonArray jsonArray = new JsonArray();
        if (AbstractC12139d.m72769h(this.f61919g)) {
            try {
                double[] dArrM64544k = C10487l.m64544k(this.f61921i.getLatitude(), this.f61921i.getLongitude());
                if (dArrM64544k != null && dArrM64544k.length > 1) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("type", String.valueOf(this.f61921i.getType()));
                    jsonObject.addProperty("sysType", "2");
                    jsonObject.addProperty(JsbMapKeyNames.H5_LOC_LAT, Double.valueOf(dArrM64544k[0]));
                    jsonObject.addProperty(JsbMapKeyNames.H5_LOC_LON, Double.valueOf(dArrM64544k[1]));
                    jsonObject.addProperty("accuracy", String.valueOf(this.f61921i.getAccuracy()));
                    jsonObject.addProperty("time", String.valueOf(this.f61915c));
                    jsonArray.add(jsonObject.toString());
                }
            } catch (Exception e10) {
                C13981a.m83988e("AncillaryDeviceLocationReport", "genTagCoordinateInfoList Exception" + e10.getMessage());
            }
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("type", String.valueOf(this.f61921i.getType()));
        jsonObject2.addProperty("sysType", "1");
        jsonObject2.addProperty(JsbMapKeyNames.H5_LOC_LAT, Double.valueOf(this.f61921i.getLatitude()));
        jsonObject2.addProperty(JsbMapKeyNames.H5_LOC_LON, Double.valueOf(this.f61921i.getLongitude()));
        jsonObject2.addProperty("accuracy", String.valueOf(this.f61921i.getAccuracy()));
        jsonObject2.addProperty("time", String.valueOf(this.f61915c));
        jsonObject2.addProperty("floor", this.f61921i.getFloor());
        jsonArray.add(jsonObject2.toString());
        return jsonArray;
    }

    /* renamed from: n */
    public final String m82746n(double d10, String str) {
        return m82747o(String.valueOf(d10), str);
    }

    /* renamed from: o */
    public final String m82747o(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C13981a.m83988e("AncillaryDeviceLocationReport", "userKey is empty");
            return "";
        }
        PhoneFinderEncryptData phoneFinderEncryptDataM71144k = C11869b.m71144k(String.valueOf(str), C11881n.m71352b(str2));
        if (phoneFinderEncryptDataM71144k != null) {
            return f61912m.toJson(phoneFinderEncryptDataM71144k);
        }
        C13981a.m83988e("AncillaryDeviceLocationReport", "encryptData error");
        return "";
    }

    /* renamed from: p */
    public final String m82748p(double d10, double d11) throws IOException {
        List<Address> fromLocation;
        try {
            fromLocation = new Geocoder(this.f61919g).getFromLocation(d10, d11, 3);
        } catch (IOException e10) {
            C13981a.m83988e("AncillaryDeviceLocationReport", "get address from location error:" + e10.getMessage());
            fromLocation = null;
        }
        return (fromLocation == null || fromLocation.size() <= 0) ? "" : fromLocation.get(0).getCountryCode();
    }

    /* renamed from: q */
    public C14298f m82749q() {
        return this.f61924l;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m82750s() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "do ancillary locate report, resultCode:"
            r0.append(r1)
            int r1 = r6.f61914b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "AncillaryDeviceLocationReport"
            p809yg.C13981a.m83989i(r1, r0)
            android.content.Context r0 = r6.f61919g
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r0 = pg.AbstractC12139d.m72766e(r0)
            java.lang.String r0 = r0.getUserKey()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto Lac
            java.lang.String r2 = "encryptData userKey is empty"
            p809yg.C13981a.m83988e(r1, r2)
            ab.b r2 = new ab.b     // Catch: java.lang.Exception -> L89
            fa.b r3 = p283fa.C9679b.m60452d()     // Catch: java.lang.Exception -> L89
            ab.a r3 = r3.m60455e()     // Catch: java.lang.Exception -> L89
            r2.<init>(r3)     // Catch: java.lang.Exception -> L89
            java.lang.String r3 = "01019"
            java.lang.String r4 = "AES_128"
            r5 = 10
            com.huawei.android.hicloud.security.bean.UserKeyObject r2 = r2.m680c(r3, r5, r4)     // Catch: java.lang.Exception -> L89
            byte[] r2 = r2.getUserKey()     // Catch: java.lang.Exception -> L89
            if (r2 == 0) goto L8d
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L89
            r4 = 0
            byte[] r2 = android.util.Base64.encode(r2, r4)     // Catch: java.lang.Exception -> L89
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Exception -> L89
            r3.<init>(r2, r4)     // Catch: java.lang.Exception -> L89
            android.content.Context r0 = r6.f61919g     // Catch: java.lang.Exception -> L87
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r0 = pg.AbstractC12139d.m72766e(r0)     // Catch: java.lang.Exception -> L87
            r0.setUserKey(r3)     // Catch: java.lang.Exception -> L87
            android.content.Context r0 = p015ak.C0213f.m1377a()     // Catch: java.lang.Exception -> L87
            boolean r0 = bf.C1175a.m7389k(r0)     // Catch: java.lang.Exception -> L87
            if (r0 == 0) goto Lab
            android.content.Context r0 = r6.f61919g     // Catch: java.lang.Exception -> L87
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r0 = pg.AbstractC12139d.m72766e(r0)     // Catch: java.lang.Exception -> L87
            java.lang.String r0 = r0.getDeviceID()     // Catch: java.lang.Exception -> L87
            java.lang.String r2 = "ancillary locate report, update User Key"
            p520of.C11860j.m71000I0(r0, r2)     // Catch: java.lang.Exception -> L87
            android.content.Context r0 = r6.f61919g     // Catch: java.lang.Exception -> L87
            android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Exception -> L87
            xe.e r2 = new xe.e     // Catch: java.lang.Exception -> L87
            r2.<init>()     // Catch: java.lang.Exception -> L87
            pg.AbstractC12139d.m72772k(r0, r2)     // Catch: java.lang.Exception -> L87
            goto Lab
        L87:
            r0 = move-exception
            goto L93
        L89:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L93
        L8d:
            java.lang.String r2 = "getUserKey is empty again"
            p809yg.C13981a.m83988e(r1, r2)     // Catch: java.lang.Exception -> L89
            goto Lac
        L93:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getUserKey again error,"
            r2.append(r4)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            p809yg.C13981a.m83988e(r1, r0)
        Lab:
            r0 = r3
        Lac:
            java.lang.String r1 = r6.f61922j
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto Lba
            java.lang.String r0 = r6.m82742j(r0)
            r6.f61922j = r0
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p772xe.C13781f.m82750s():void");
    }

    public C13781f(String str, Context context, Handler.Callback callback) {
        this.f61924l = new C14298f();
        this.f61922j = str;
        this.f61919g = context;
        this.f61913a = callback;
        this.f61923k = "";
    }
}
