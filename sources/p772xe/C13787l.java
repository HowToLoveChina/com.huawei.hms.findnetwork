package p772xe;

import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.geocoder.BaiduGeocodeProvider;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.remotecontrol.bluetooth.AlsDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceDBHelper;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.locate.AncillaryDeviceLocationInfo;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.comm.request.bean.DisConnectLocation;
import com.huawei.hms.findnetwork.comm.request.bean.PairedDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0225l;
import p015ak.C0227m;
import p015ak.C0241z;
import p227dg.C9097b;
import p227dg.C9120m0;
import p366if.AbstractC10482g;
import p366if.C10487l;
import p366if.C10488m;
import p521og.C11869b;
import p521og.C11872e;
import p521og.C11881n;
import p572qb.C12315j;
import p774xg.C13811a;
import p774xg.C13812b;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import p851zp.InterfaceC14358e;
import sg.C12797b;
import ve.C13429u;

/* renamed from: xe.l */
/* loaded from: classes4.dex */
public class C13787l extends C13776a {

    /* renamed from: W */
    public static final Object f61942W = new Object();

    /* renamed from: X */
    public static List<String> f61943X = new ArrayList();

    /* renamed from: Q */
    public Gson f61944Q;

    /* renamed from: R */
    public String f61945R;

    /* renamed from: S */
    public final boolean f61946S;

    /* renamed from: T */
    public final String f61947T;

    /* renamed from: U */
    public AncillaryDeviceLocationInfo f61948U;

    /* renamed from: V */
    public C13429u f61949V;

    /* renamed from: xe.l$a */
    public class a extends FindNetworkCallback<DisConnectLocation> {

        /* renamed from: c */
        public final /* synthetic */ String f61951c;

        /* renamed from: d */
        public final /* synthetic */ Context f61952d;

        /* renamed from: e */
        public final /* synthetic */ AlsDeviceInfo f61953e;

        public a(String str, Context context, AlsDeviceInfo alsDeviceInfo) {
            this.f61951c = str;
            this.f61952d = context;
            this.f61953e = alsDeviceInfo;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<DisConnectLocation> findNetworkResult) {
            C13981a.m83990w("FinderTagActiveLocate", "queryDisconnectLocation fail");
            super.onFail(findNetworkResult);
            C13787l.this.m82776p1(this.f61951c);
            C9120m0.m57380d1(this.f61952d, "QueryDisconnectLocation fail", this.f61953e.getDeviceID(), null, 0);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<DisConnectLocation> findNetworkResult) {
            C13981a.m83989i("FinderTagActiveLocate", "queryDisconnectLocation success");
            super.onSuccess(findNetworkResult);
            DisConnectLocation data = findNetworkResult.getData();
            if (data != null) {
                C13787l.this.m82775n1(data);
            }
            C13787l.this.m82776p1(this.f61951c);
        }
    }

    /* renamed from: xe.l$b */
    public class b extends TimerTask {

        /* renamed from: a */
        public final /* synthetic */ Context f61954a;

        /* renamed from: b */
        public final /* synthetic */ Timer f61955b;

        public b(Context context, Timer timer) {
            this.f61954a = context;
            this.f61955b = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String strM82821r = C13811a.m82821r(false);
            C13981a.m83989i("FinderTagActiveLocate", "disconnectUnApplyActive reason: " + strM82821r);
            C12315j.m74059f().m74071o(this.f61954a.getPackageName(), strM82821r);
            this.f61955b.cancel();
        }
    }

    /* renamed from: xe.l$c */
    public class c implements Handler.Callback {

        /* renamed from: a */
        public Function<JSONObject, Boolean> f61956a;

        /* renamed from: b */
        public InterfaceC14358e f61957b;

        /* renamed from: c */
        public boolean f61958c = false;

        public c(Function<JSONObject, Boolean> function, InterfaceC14358e interfaceC14358e) {
            this.f61956a = function;
            this.f61957b = interfaceC14358e;
        }

        /* renamed from: a */
        public final void m82777a(Message message) throws JSONException {
            C13981a.m83989i(C13787l.this.f61945R, "HttpCallback->handleMessage->handleQueryAncDeviceInfo");
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i(C13787l.this.f61945R, "Query Ancillary Device info result:" + iM1685c);
            C12797b c12797b = new C12797b();
            if (200 == iM1685c) {
                String string = message.getData().getString("response_info");
                if (C4347e.m26233d(string) != 0) {
                    C13981a.m83989i(C13787l.this.f61945R, "handleQueryAncDeviceInfo,AppEventLogParam report fail");
                    return;
                }
                m82778b(string);
                this.f61958c = true;
                C13981a.m83989i(C13787l.this.f61945R, "handleQueryAncDeviceInfo,AppEventLogParam report success");
                c12797b.m76784j(C13787l.this.f5580a, C13787l.this.f61945R, "0", "handleQueryAncDeviceInfo callback success", null, "01020", null, "query_ancDeviceInfo", true);
                return;
            }
            C13981a.m83988e(C13787l.this.f61945R, "handleMsg query activation info error=" + iM1685c);
            C13787l.this.f61949V.m26439b(C13787l.this.f5580a);
            c12797b.m76784j(C13787l.this.f5580a, C13787l.this.f61945R, "001_3003", "handleQueryAncDeviceInfo callback error,result:" + iM1685c, null, "01020", null, "query_ancDeviceInfo", true);
        }

        /* renamed from: b */
        public final void m82778b(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C13981a.m83987d(C13787l.this.f61945R, "handleQueryAncDeviceSuccess--responseInfo=" + str);
                if (jSONObject.has("perDeviceList")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("perDeviceList");
                    C13981a.m83987d(C13787l.this.f61945R, "handleQueryAncDeviceSuccess--jsonArray=" + jSONArray);
                    if (jSONArray.length() != 0) {
                        for (int i10 = 0; i10 < jSONArray.length() && !this.f61956a.apply(jSONArray.getJSONObject(i10)).booleanValue(); i10++) {
                        }
                    }
                }
            } catch (JSONException unused) {
                C13981a.m83988e(C13787l.this.f61945R, "handle QueryAncDevice JSONException");
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Context context;
            String deviceID;
            synchronized (C13787l.f61942W) {
                try {
                    try {
                        try {
                            m82777a(message);
                            if (!this.f61958c) {
                                this.f61957b.execute();
                            }
                            context = C13787l.this.f5580a;
                            deviceID = C13787l.this.f61889O.getDeviceID();
                        } catch (Throwable th2) {
                            if (!this.f61958c) {
                                this.f61957b.execute();
                            }
                            C13787l.m82766f1(C13787l.this.f5580a, C13787l.this.f61889O.getDeviceID());
                            throw th2;
                        }
                    } catch (Exception e10) {
                        String strM82771h1 = C13787l.this.m82771h1(e10);
                        C12797b c12797b = new C12797b();
                        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                        linkedHashMap.put("trace", strM82771h1);
                        c12797b.m76785k(C13787l.this.f5580a, "FinderTagActiveLocate", "0", "QueryAncillaryDeviceCallback exception: " + e10.getMessage(), null, "01059", null, "finderTagSendNotify", true, linkedHashMap);
                        C13981a.m83988e(C13787l.this.f61945R, " handleMessage error: " + e10.getMessage());
                        if (!this.f61958c) {
                            this.f61957b.execute();
                        }
                        context = C13787l.this.f5580a;
                        deviceID = C13787l.this.f61889O.getDeviceID();
                    }
                    C13787l.m82766f1(context, deviceID);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            return true;
        }
    }

    public C13787l(Context context, AlsDeviceInfo alsDeviceInfo, boolean z10, String str) {
        super(context, alsDeviceInfo);
        this.f61944Q = new Gson();
        this.f61945R = "FinderTagActiveLocate";
        this.f61945R = m64466k0("FinderTagActiveLocate");
        this.f61946S = z10;
        this.f61947T = str;
    }

    /* renamed from: e1 */
    public static void m82765e1(Context context, String str) {
        C13981a.m83989i("FinderTagActiveLocate", "disconnectApplyActive perDeviceId: " + C9120m0.m57351R(str));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f61943X.add(str);
        String strM82821r = C13811a.m82821r(false);
        C13981a.m83989i("FinderTagActiveLocate", "disconnectApplyActive reason: " + strM82821r);
        C12315j.m74059f().m74060c(context.getPackageName(), 60000L, strM82821r);
    }

    /* renamed from: f1 */
    public static void m82766f1(Context context, String str) {
        C13981a.m83989i("FinderTagActiveLocate", "disconnectUnApplyActive perDeviceId: " + C9120m0.m57351R(str));
        if (!f61943X.isEmpty()) {
            f61943X.remove(str);
        }
        if (f61943X.isEmpty()) {
            try {
                Timer timer = new Timer();
                timer.schedule(new b(context, timer), 3000L);
            } catch (Exception e10) {
                C13981a.m83988e("FinderTagActiveLocate", "disconnectUnApplyActive exception: " + e10.getMessage());
            }
        }
    }

    /* renamed from: i1 */
    public static /* synthetic */ Task m82767i1(Context context, AlsDeviceInfo alsDeviceInfo, C13787l c13787l, String str) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).queryDisconnectLocation(alsDeviceInfo.getDeviceID(), c13787l.new a(str, context, alsDeviceInfo));
    }

    /* renamed from: j1 */
    public static /* synthetic */ void m82768j1(C13787l c13787l, String str, Exception exc) {
        C13981a.m83988e("FinderTagActiveLocate", "queryDisconnectLocation error: " + exc.getMessage());
        c13787l.m82776p1(str);
    }

    /* renamed from: o1 */
    public static void m82769o1(final Context context, final AlsDeviceInfo alsDeviceInfo, boolean z10, String str, final String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("FinderTagActiveLocate", "procLocate");
        final C13787l c13787l = new C13787l(context, alsDeviceInfo, z10, str);
        if (z10) {
            c13787l.mo64403I0();
        } else {
            C0225l.m1577a(new InterfaceC14356c() { // from class: xe.g
                @Override // p851zp.InterfaceC14356c
                public final Object execute() {
                    return C13787l.m82767i1(context, alsDeviceInfo, c13787l, str2);
                }
            }, new Consumer() { // from class: xe.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C13787l.m82768j1(this.f61931a, str2, (Exception) obj);
                }
            });
        }
    }

    @Override // p772xe.C13776a
    /* renamed from: O0 */
    public String mo82697O0() {
        return this.f61946S ? "01049" : "01023";
    }

    @Override // p772xe.C13776a, p366if.InterfaceC10483h
    /* renamed from: d */
    public void mo64423d(C10488m c10488m) {
        if (c10488m == null) {
            C13981a.m83988e(this.f61945R, "location info is null");
            return;
        }
        mo64422b();
        AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = new AncillaryDeviceLocationInfo();
        this.f61948U = ancillaryDeviceLocationInfo;
        ancillaryDeviceLocationInfo.setAccuracy(c10488m.m64550b().getAccuracy());
        this.f61948U.setConnectType(C0241z.m1685c(this.f61946S ? "2" : "0"));
        this.f61948U.setLatitude(c10488m.m64550b().getLatitude());
        this.f61948U.setLongitude(c10488m.m64550b().getLongitude());
        this.f61948U.setFloor(C13812b.m82831b(c10488m.m64550b()));
        this.f61948U.setLocationTime(C13812b.m82837h(c10488m.m64550b()));
        this.f61948U.setLocationRouter(C13812b.m82836g(c10488m.m64550b()));
        this.f61948U.setLocCpTransId(C13812b.m82833d(c10488m.m64550b()));
        this.f61948U.setLocSessionId(C13812b.m82835f(c10488m.m64550b()));
        this.f61948U.setLocFenceTime(C13812b.m82834e(c10488m.m64550b()));
        this.f61948U.setType(!c10488m.m64550b().getProvider().equals("network") ? 1 : 0);
        this.f61948U.setTime(c10488m.m64550b().getTime() + C11881n.m71358h());
        this.f61948U.setOperationType(this.f61946S ? "perDevicelocate" : "perDeviceDiscLocate");
        this.f61948U.setStandbyDevice(this.f61947T);
        C13781f c13781f = new C13781f(0, c10488m.m64550b().getTime(), this.f61889O.getDeviceID(), "0", this.f61889O.getPerDeviceType(), this.f5580a, this.f61948U, C12797b.m76774a("01019"), null, new AbstractC10482g.b(3032));
        c13781f.m82749q().m85164h("queryGoodsOfflineLocation");
        c13781f.m82741i();
    }

    /* renamed from: g1 */
    public final String m82770g1() {
        AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = this.f61948U;
        if (ancillaryDeviceLocationInfo == null) {
            return null;
        }
        try {
            double latitude = ancillaryDeviceLocationInfo.getLatitude();
            double longitude = this.f61948U.getLongitude();
            Location location = new Location("");
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            ArrayList arrayList = new ArrayList();
            BaiduGeocodeProvider baiduGeocodeProvider = new BaiduGeocodeProvider(this.f5580a);
            baiduGeocodeProvider.setUuid(C10487l.m64536b().m64547d());
            baiduGeocodeProvider.onGetFromLocation(latitude, longitude, 3, arrayList);
            if (arrayList.size() == 0) {
                return null;
            }
            return C10487l.m64537c((Address) arrayList.get(0), !C10487l.m64539f(location));
        } catch (Exception e10) {
            String strM82771h1 = this.m82771h1(e10);
            C12797b c12797b = new C12797b();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("trace", strM82771h1);
            c12797b.m76785k(this.f5580a, "FinderTagActiveLocate", "0", "getAddress exception", null, "01059", null, "finderTagSendNotify", true, linkedHashMap);
            C13981a.m83988e("FinderTagActiveLocate", "getAddress exception：" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: h1 */
    public final String m82771h1(Exception exc) {
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            sb2.append(stackTraceElement);
            sb2.append(System.lineSeparator());
        }
        return sb2.toString();
    }

    /* renamed from: k1 */
    public final /* synthetic */ Boolean m82772k1(String str, JSONObject jSONObject) throws JSONException {
        String strOptString;
        if (!str.equals(jSONObject.optString("deviceID"))) {
            return Boolean.FALSE;
        }
        String strOptString2 = jSONObject.optString("deviceName");
        C13981a.m83989i(this.f61945R, "get tag name: " + strOptString2);
        String strM82770g1 = m82770g1();
        String strOptString3 = jSONObject.optString("perDeviceTypeInfo");
        int iOptInt = jSONObject.optInt("componentType");
        try {
            strOptString = new JSONObject(strOptString3).optString("ModelID");
        } catch (JSONException e10) {
            C13981a.m83988e("FinderTagActiveLocate", "showDisconnectNotify, get goodsModelId exception:" + e10.getMessage());
            strOptString = "";
        }
        String str2 = strOptString;
        StringBuilder sb2 = new StringBuilder(jSONObject.optString(VastAttribute.SEQUENCE));
        if (C9097b.m57307q(sb2, this.f61947T, iOptInt)) {
            C11872e.m71176n(this.f5580a, C9097b.m57297g(this.f5580a, strOptString2, sb2.toString()), strM82770g1, str, str2, sb2.toString(), this.f61947T, true);
        } else {
            C11872e.m71176n(this.f5580a, strOptString2, strM82770g1, str, str2, sb2.toString(), this.f61947T, false);
        }
        String strOptString4 = jSONObject.optString("goodsType");
        String strOptString5 = jSONObject.optString("SubmodelID");
        AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
        ancillaryDeviceInfo.setDeviceID(str);
        ancillaryDeviceInfo.setDeviceName(strOptString2);
        ancillaryDeviceInfo.setGoodsType(strOptString4);
        ancillaryDeviceInfo.setDeviceType("3");
        ancillaryDeviceInfo.setSubDeviceType("1");
        ancillaryDeviceInfo.setModelId(str2);
        ancillaryDeviceInfo.setSubModelId(strOptString5);
        AncillaryDeviceDBHelper.m26045e(this.f5580a).m26048D(this.f5580a, str, "1", this.f61944Q.toJson(ancillaryDeviceInfo), "3");
        return Boolean.TRUE;
    }

    /* renamed from: l1 */
    public final /* synthetic */ Boolean m82773l1(String str, String str2, String str3, PairedDeviceInfo pairedDeviceInfo) throws JSONException {
        if (pairedDeviceInfo == null) {
            C13981a.m83989i("FinderTagActiveLocate", "queryPairedDevicesFromFN info is null");
            return Boolean.FALSE;
        }
        if (!str.equals(pairedDeviceInfo.getSn())) {
            return Boolean.FALSE;
        }
        C13981a.m83989i("FinderTagActiveLocate", "queryPairedDevicesFromFN info match tagSn");
        String strM57298h = C9097b.m57298h(str2);
        if (TextUtils.isEmpty(strM57298h)) {
            C13981a.m83988e("FinderTagActiveLocate", "displayName is empty");
            return Boolean.FALSE;
        }
        C13981a.m83989i("FinderTagActiveLocate", "showDisconnectNotify, deviceDisplayName:" + strM57298h);
        StringBuilder sb2 = new StringBuilder(String.valueOf(pairedDeviceInfo.getSequence()));
        if (C9097b.m57307q(sb2, this.f61947T, pairedDeviceInfo.getComponentType())) {
            C11872e.m71176n(this.f5580a, C9097b.m57297g(this.f5580a, strM57298h, sb2.toString()), str3, str, str2, sb2.toString(), this.f61947T, true);
        } else {
            C11872e.m71176n(this.f5580a, strM57298h, str3, str, str2, sb2.toString(), this.f61947T, false);
        }
        return Boolean.TRUE;
    }

    /* renamed from: m1 */
    public final /* synthetic */ void m82774m1(final String str, final String str2) throws JSONException {
        C13981a.m83989i("FinderTagActiveLocate", "QueryAncillaryDeviceCallback fail");
        C12797b c12797b = new C12797b();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("perDeviceId", C9120m0.m57351R(str));
        linkedHashMap.put("standbyDevice", C9120m0.m57355T(this.f61947T));
        c12797b.m76785k(this.f5580a, "FinderTagActiveLocate", "0", "showDisconnectNotification exception", null, "01059", null, "finderTagSendNotify", true, linkedHashMap);
        final String strM82770g1 = m82770g1();
        Context context = this.f5580a;
        String strM71136c = C11869b.m71136c(context, AncillaryDeviceDBHelper.m26045e(context).m26058y(C0227m.m1593f(str)));
        if (strM71136c == null) {
            C13981a.m83989i("FinderTagActiveLocate", "queryPairedDevicesFromFN");
            C9120m0.m57368Z0(this.f5580a, new Function() { // from class: xe.k
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f61938a.m82773l1(str, str2, strM82770g1, (PairedDeviceInfo) obj);
                }
            });
            return;
        }
        C13981a.m83989i("FinderTagActiveLocate", "queryPairedDevicesFromDB");
        try {
            AncillaryDeviceInfo ancillaryDeviceInfo = (AncillaryDeviceInfo) new Gson().fromJson(strM71136c, AncillaryDeviceInfo.class);
            C13981a.m83989i("FinderTagActiveLocate", "showDisconnectNotify, deviceName: " + ancillaryDeviceInfo.getDeviceName() + ", deviceDisplayName: " + C9097b.m57298h(ancillaryDeviceInfo.getModelId()));
            StringBuilder sb2 = new StringBuilder(String.valueOf(ancillaryDeviceInfo.getSequence()));
            if (C9097b.m57307q(sb2, this.f61947T, ancillaryDeviceInfo.getComponentType())) {
                C11872e.m71176n(this.f5580a, C9097b.m57297g(this.f5580a, ancillaryDeviceInfo.getDeviceName(), sb2.toString()), strM82770g1, str, ancillaryDeviceInfo.getModelId(), sb2.toString(), this.f61947T, true);
            } else {
                C11872e.m71176n(this.f5580a, ancillaryDeviceInfo.getDeviceName(), strM82770g1, str, ancillaryDeviceInfo.getModelId(), sb2.toString(), this.f61947T, false);
            }
        } catch (JsonSyntaxException e10) {
            C13981a.m83988e(this.f61945R, "showDisconnectNotify exception: " + e10.getMessage());
        }
    }

    /* renamed from: n1 */
    public void m82775n1(DisConnectLocation disConnectLocation) {
        C13981a.m83989i(this.f61945R, "onDisconnectLocateUpdate time: " + disConnectLocation.getLocationTime() + ", indoor:" + disConnectLocation.getIndoor() + ", " + disConnectLocation.getFloorAcc());
        AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = new AncillaryDeviceLocationInfo();
        this.f61948U = ancillaryDeviceLocationInfo;
        ancillaryDeviceLocationInfo.setAccuracy(disConnectLocation.getAccuracy());
        this.f61948U.setConnectType(C0241z.m1685c("0"));
        this.f61948U.setLatitude(disConnectLocation.getLatitude());
        this.f61948U.setLongitude(disConnectLocation.getLongitude());
        this.f61948U.setFloor(C13812b.m82830a(disConnectLocation));
        this.f61948U.setType(0);
        this.f61948U.setTime(disConnectLocation.getLocationTime() + C11881n.m71358h());
        this.f61948U.setOperationType(this.f61946S ? "perDevicelocate" : "perDeviceDiscLocate");
        this.f61948U.setStandbyDevice(this.f61947T);
        C13781f c13781f = new C13781f(0, disConnectLocation.getLocationTime(), this.f61889O.getDeviceID(), "0", this.f61889O.getPerDeviceType(), this.f5580a, this.f61948U, C12797b.m76774a("01019"), null, new AbstractC10482g.b(3032));
        c13781f.m82749q().m85164h("queryTagDisconnectLocation");
        c13781f.m82741i();
        C9120m0.m57380d1(this.f5580a, "QueryDisconnectLocation success, floor: " + this.f61948U.getFloor(), this.f61889O.getDeviceID(), null, 0);
    }

    @Override // p772xe.C13776a, p366if.AbstractC10482g
    /* renamed from: o0 */
    public boolean mo64412o0(Message message, int i10, int i11) throws JSONException {
        C13981a.m83989i("FinderTagActiveLocate", "handleCallBackMessage");
        if (!this.f61946S) {
            return super.mo64412o0(message, i10, i11);
        }
        C9120m0.m57365Y(this.f5580a, this.f61889O.getDeviceID(), this.f61947T, false);
        return true;
    }

    /* renamed from: p1 */
    public void m82776p1(final String str) {
        final String deviceID = this.f61889O.getDeviceID();
        C13429u c13429u = new C13429u(this.f5580a, "3", new c(new Function() { // from class: xe.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f61933a.m82772k1(deviceID, (JSONObject) obj);
            }
        }, new InterfaceC14358e() { // from class: xe.j
            @Override // p851zp.InterfaceC14358e
            public final void execute() throws JSONException {
                this.f61935a.m82774m1(deviceID, str);
            }
        }));
        this.f61949V = c13429u;
        c13429u.m80720g();
    }
}
