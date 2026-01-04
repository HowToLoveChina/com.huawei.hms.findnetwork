package p772xe;

import android.content.Context;
import android.location.Location;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.remotecontrol.bluetooth.AlsDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceDBHelper;
import com.huawei.android.remotecontrol.bluetooth.locate.AncillaryDeviceLocationInfo;
import com.huawei.android.remotecontrol.bluetooth.locate.LocateHistoryDbHelper;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.locate.PassiveLocateParam;
import eg.AbstractC9478g;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p366if.AbstractC10482g;
import p366if.C10488m;
import p366if.C10493r;
import p366if.InterfaceC10483h;
import p521og.C11877j;
import p521og.C11881n;
import p616rk.C12515a;
import p774xg.C13812b;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: xe.a */
/* loaded from: classes4.dex */
public class C13776a extends AbstractC10482g implements InterfaceC10483h {

    /* renamed from: P */
    public static final Gson f61885P = new Gson();

    /* renamed from: L */
    public String f61886L;

    /* renamed from: M */
    public List<PassiveLocateParam> f61887M;

    /* renamed from: N */
    public PassiveLocateParam f61888N;

    /* renamed from: O */
    public AlsDeviceInfo f61889O;

    /* renamed from: xe.a$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ SparseIntArray f61890a;

        /* renamed from: b */
        public final /* synthetic */ String f61891b;

        public a(SparseIntArray sparseIntArray, String str) {
            this.f61890a = sparseIntArray;
            this.f61891b = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            for (int i10 = 0; i10 < this.f61890a.size(); i10++) {
                int iKeyAt = this.f61890a.keyAt(i10);
                if (this.f61890a.get(iKeyAt) == 1) {
                    long jM26143w = LocateHistoryDbHelper.m26135e(C13776a.this.f5580a).m26143w(C13776a.this.f5580a, C13776a.this.f61889O.getDeviceID(), String.valueOf(iKeyAt), this.f61891b);
                    C13981a.m83989i(C13776a.this.f61886L, "updateCptLocateInfo to database result:" + jM26143w);
                }
            }
        }
    }

    /* renamed from: xe.a$b */
    public static class b extends TypeToken<List<PassiveLocateParam>> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public C13776a(Context context, AlsDeviceInfo alsDeviceInfo) {
        this((PushCmdParser) null, context);
        this.f61886L = m64466k0(this.f61886L);
        this.f61889O = alsDeviceInfo;
        m82698P0();
        this.f50523I = new C10493r(this, context, this.f61886L, this.f61888N);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: I0 */
    public void mo64403I0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!C4347e.m26238i(this.f5580a)) {
            C13981a.m83988e(this.f61886L, "do not have locate permission");
            mo64414z0();
        } else {
            C13777b.m82708i(this.f5580a, false);
            C13777b.m82700a(this);
            this.f50523I.mo64391g();
        }
    }

    /* renamed from: O0 */
    public String mo82697O0() {
        return "01023";
    }

    /* renamed from: P0 */
    public final void m82698P0() {
        String passiveDeviceId;
        if (this.f61889O == null) {
            C13981a.m83988e(this.f61886L, "getAlsPassiveParams,deviceInfo is null");
            return;
        }
        if (C11881n.m71375y(this.f5580a)) {
            C13981a.m83989i(this.f61886L, "current device is isCharging");
            return;
        }
        try {
            this.f61887M = (List) f61885P.fromJson(C11877j.m71273i0(this.f5580a), new b(null).getType());
        } catch (JsonSyntaxException unused) {
            C13981a.m83988e(this.f61886L, "initAlsPassiveParams JsonSyntaxException");
        }
        List<PassiveLocateParam> list = this.f61887M;
        List<PassiveLocateParam> arrayList = (list == null || list.size() == 0) ? new ArrayList<>() : this.f61887M;
        this.f61887M = arrayList;
        for (PassiveLocateParam passiveLocateParam : arrayList) {
            if (passiveLocateParam != null && (passiveDeviceId = passiveLocateParam.getPassiveDeviceId()) != null && passiveDeviceId.equals(this.f61889O.getDeviceID())) {
                this.f61888N = passiveLocateParam;
            }
        }
        if (this.f61888N == null) {
            this.f61888N = new PassiveLocateParam(this.f61889O.getDeviceID());
        }
    }

    /* renamed from: Q0 */
    public final void m82699Q0() {
        List<PassiveLocateParam> list = this.f61887M;
        if (list == null || this.f61888N == null) {
            C13981a.m83988e(this.f61886L, "saveAlsPassiveParams,passives is null");
            return;
        }
        Iterator<PassiveLocateParam> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.f61887M.add(this.f61888N);
                break;
            }
            PassiveLocateParam next = it.next();
            if (next != null && TextUtils.equals(next.getPassiveDeviceId(), this.f61888N.getPassiveDeviceId())) {
                C13981a.m83989i(this.f61886L, "update slave passive location param");
                next.setNetworkLastTime(this.f61888N.getNetworkLastTime());
                next.setNetworkCount(this.f61888N.getNetworkCount());
                next.setGpsLastTime(this.f61888N.getGpsLastTime());
                next.setGpsCount(this.f61888N.getGpsCount());
                break;
            }
        }
        C11877j.m71288n0(this.f5580a, f61885P.toJson(this.f61887M));
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: b */
    public void mo64422b() {
        C13981a.m83989i(this.f61886L, "locate Terminate");
        C13777b.m82709j(this.f5580a, this);
        m82699Q0();
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: d */
    public void mo64423d(C10488m c10488m) {
        if (c10488m == null) {
            C13981a.m83988e(this.f61886L, "location info is null");
            return;
        }
        mo64422b();
        AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = new AncillaryDeviceLocationInfo();
        ancillaryDeviceLocationInfo.setAccuracy(c10488m.m64550b().getAccuracy());
        ancillaryDeviceLocationInfo.setConnectType(0);
        String strM82704e = C13777b.m82704e(this.f61889O.getConnectStatus(), false);
        if (TextUtils.isEmpty(strM82704e)) {
            C13981a.m83988e(this.f61886L, "disconnected devices is empty");
            return;
        }
        ancillaryDeviceLocationInfo.setCptList(strM82704e);
        ancillaryDeviceLocationInfo.setBattery(C13777b.m82702c("1".equals(AncillaryDeviceDBHelper.m26045e(this.f5580a).m26059z(this.f61889O.getDeviceID())), this.f61889O.getConnectStatus(), this.f61889O.getBattery(), false));
        ancillaryDeviceLocationInfo.setLatitude(c10488m.m64550b().getLatitude());
        ancillaryDeviceLocationInfo.setLongitude(c10488m.m64550b().getLongitude());
        ancillaryDeviceLocationInfo.setFloor(C13812b.m82831b(c10488m.m64550b()));
        ancillaryDeviceLocationInfo.setLocationTime(C13812b.m82837h(c10488m.m64550b()));
        ancillaryDeviceLocationInfo.setLocationRouter(C13812b.m82836g(c10488m.m64550b()));
        ancillaryDeviceLocationInfo.setLocCpTransId(C13812b.m82833d(c10488m.m64550b()));
        ancillaryDeviceLocationInfo.setLocSessionId(C13812b.m82835f(c10488m.m64550b()));
        ancillaryDeviceLocationInfo.setLocFenceTime(C13812b.m82834e(c10488m.m64550b()));
        ancillaryDeviceLocationInfo.setType(!c10488m.m64550b().getProvider().equals("network") ? 1 : 0);
        ancillaryDeviceLocationInfo.setTime(c10488m.m64550b().getTime() + C11881n.m71358h());
        ancillaryDeviceLocationInfo.setOperationType("perDeviceDiscLocate");
        new C13781f(0, c10488m.m64550b().getTime(), this.f61889O.getDeviceID(), "", this.f61889O.getPerDeviceType(), this.f5580a, ancillaryDeviceLocationInfo, C12797b.m76774a("01019"), null, new AbstractC10482g.b(3032)).m82741i();
        m64450B0(c10488m);
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: e */
    public void mo64424e(Location location) {
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: o0 */
    public boolean mo64412o0(Message message, int i10, int i11) {
        C13981a.m83989i(this.f61886L, "HttpCallback->handleMessage->AlsDisconnectLocate");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        String string = message.getData().getString("requestInfo");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        try {
            linkedHashMap.put("perDeviceType", C11881n.m71362l(new JSONObject(string), "perDeviceType"));
        } catch (JSONException e10) {
            C13981a.m83988e(this.f61886L, "parse json exception:" + e10.getMessage());
        }
        C12797b c12797b = new C12797b();
        C13981a.m83989i(this.f61886L, "report AlsDisconnectLocationInfo result:" + iM1685c);
        if (200 == iM1685c || TextUtils.isEmpty(string)) {
            c12797b.m76785k(this.f5580a, this.f61886L, "0", "report disconnect location success,resultCode:" + iM1685c, null, mo82697O0(), null, "local_handleResponse", true, linkedHashMap);
            return true;
        }
        SparseIntArray connectStatus = this.f61889O.getConnectStatus();
        if (connectStatus == null) {
            return false;
        }
        C12515a.m75110o().m75172d(new a(connectStatus, string));
        c12797b.m76785k(this.f5580a, this.f61886L, "001_3004", "report disconnect location fail,resultCode:" + iM1685c, null, mo82697O0(), null, "local_handleResponse", true, linkedHashMap);
        return true;
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: r0 */
    public boolean mo64471r0() {
        return false;
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: z0 */
    public void mo64414z0() {
        new C12797b().m76785k(this.f5580a, this.f61886L, "001_1000", "report disconnect location fail, not locate permission", null, "01023", null, "local_handleResponse", true, null);
    }

    public C13776a(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f61886L = "AlsDisconnectLocate";
    }
}
