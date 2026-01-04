package p677ue;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.airlink.IAirLinkAidlCallBack;
import com.huawei.airlink.IAirLinkAidlInterface;
import com.huawei.android.bluetooth.HwBindDevice;
import com.huawei.android.bluetooth.HwFindDevice;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.sle.precisionfind.PrecisionFindManager;
import huawei.sle.SleAdapterIf;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import p015ak.C0209d;
import p015ak.C0241z;
import p575qe.C12347f;
import p809yg.C13981a;
import ve.C13428t;

/* renamed from: ue.a */
/* loaded from: classes4.dex */
public class C13168a {

    /* renamed from: a */
    public String f59683a;

    /* renamed from: b */
    public Bundle f59684b;

    /* renamed from: c */
    public IAirLinkAidlInterface f59685c;

    /* renamed from: e */
    public Context f59687e = C12347f.m74285n().m74301m();

    /* renamed from: f */
    public ServiceConnection f59688f = new a();

    /* renamed from: d */
    public b f59686d = new b(this, null);

    /* renamed from: ue.a$a */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C13981a.m83989i("AlsDeviceApi", "connect ariLink service success");
            C13168a.this.f59685c = IAirLinkAidlInterface.Stub.asInterface(iBinder);
            C13168a.this.m79192r();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C13981a.m83990w("AlsDeviceApi", "binder ariLink service disconnected");
            C13168a.this.f59685c = null;
        }
    }

    /* renamed from: ue.a$b */
    public class b extends IAirLinkAidlCallBack.Stub {
        public b() {
        }

        @Override // com.huawei.airlink.IAirLinkAidlCallBack
        public void onEventReceived(String str, Bundle bundle) {
            C13981a.m83989i("AlsDeviceApi", "onEventReceived " + str);
            if (str == null || bundle == null) {
                C13981a.m83988e("AlsDeviceApi", "onEventReceived: even is empty");
                return;
            }
            if (str.equals("onGetBindDevList")) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("bindDeviceList");
                if (parcelableArrayList == null) {
                    C13981a.m83988e("AlsDeviceApi", "bluetoothList is empty");
                    return;
                }
                AncillaryDeviceManager.m26080y().m26107v(C13168a.m79179f(parcelableArrayList));
                C13168a.this.m79191i();
            }
        }

        public /* synthetic */ b(C13168a c13168a, a aVar) {
            this();
        }
    }

    public C13168a(String str, Bundle bundle) {
        this.f59683a = str;
        this.f59684b = bundle;
    }

    /* renamed from: e */
    public static ArrayList<HwFindDevice> m79178e(List<AncillaryDeviceInfo> list) {
        if (list == null || list.isEmpty()) {
            C13981a.m83989i("AlsDeviceApi", "Bluetooth Device Info list is empty");
            return new ArrayList<>();
        }
        ArrayList<HwFindDevice> arrayList = new ArrayList<>();
        for (AncillaryDeviceInfo ancillaryDeviceInfo : list) {
            if (ancillaryDeviceInfo != null) {
                arrayList.add(ancillaryDeviceInfo.encaseFindDevice());
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public static List<AncillaryDeviceInfo> m79179f(List<HwBindDevice> list) {
        if (list == null || list.isEmpty()) {
            C13981a.m83988e("AlsDeviceApi", "Bluetooth Device Info list is empty");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (HwBindDevice hwBindDevice : list) {
            AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
            ancillaryDeviceInfo.setPerDeviceType("1");
            ancillaryDeviceInfo.setDeviceID(hwBindDevice.getDeviceId());
            ancillaryDeviceInfo.setDeviceType(m79189t(hwBindDevice.getDeviceType()));
            ancillaryDeviceInfo.setModelId(hwBindDevice.getModelId());
            ancillaryDeviceInfo.setSubModelId(m79189t(hwBindDevice.getSubModelId()));
            ancillaryDeviceInfo.setConnectivity(m79189t(hwBindDevice.getConnectivity()));
            C13981a.m83989i("AlsDeviceApi", "get bluetooth device name:" + hwBindDevice.getDeviceName());
            ancillaryDeviceInfo.setDeviceName(hwBindDevice.getDeviceName());
            ancillaryDeviceInfo.setSubDeviceType(m79189t(hwBindDevice.getSubDeviceType()));
            ancillaryDeviceInfo.setWearDetect(m79189t(hwBindDevice.getWearDetect()));
            ancillaryDeviceInfo.setTimeStamp(hwBindDevice.getTimeStamp());
            ancillaryDeviceInfo.setFindCapability(m79180h(hwBindDevice.getFindCapability()));
            ancillaryDeviceInfo.setDeviceBtMac(hwBindDevice.getDeviceBtMac());
            ancillaryDeviceInfo.setIrk(hwBindDevice.getIrk());
            ancillaryDeviceInfo.setHbkp(hwBindDevice.getHbkP());
            arrayList.add(ancillaryDeviceInfo);
        }
        return arrayList;
    }

    /* renamed from: h */
    public static JSONArray m79180h(String str) throws NumberFormatException {
        JSONArray jSONArray = new JSONArray();
        try {
            int i10 = Integer.parseInt(str, 16);
            if (1 == (i10 & 1)) {
                jSONArray.put("locate");
            }
            if (2 == (i10 & 2)) {
                jSONArray.put("clear");
            }
            if (4 == (i10 & 4)) {
                jSONArray.put("lostPattern");
            }
            if (8 == (i10 & 8)) {
                jSONArray.put("bell");
            }
            if (16 == (i10 & 16)) {
                jSONArray.put("vibration");
            }
            if (32 == (i10 & 32)) {
                jSONArray.put("flash");
            }
        } catch (NumberFormatException unused) {
            C13981a.m83988e("AlsDeviceApi", "parse capability error");
        }
        return jSONArray;
    }

    /* renamed from: j */
    public static boolean m79181j(String str) {
        return "1".equals(str);
    }

    /* renamed from: k */
    public static boolean m79182k() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                return defaultAdapter.isEnabled();
            }
            C13981a.m83988e("AlsDeviceApi", "isBluetoothOpen: bltAdapter is null");
            return false;
        } catch (Exception e10) {
            C13981a.m83988e("AlsDeviceApi", "isBluetoothOpen error: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: l */
    public static boolean m79183l(String str) {
        return "3".equals(str);
    }

    /* renamed from: m */
    public static boolean m79184m() {
        try {
            return PrecisionFindManager.getInstance().isPrecisionFindSupported();
        } catch (Throwable th2) {
            C13981a.m83988e("AlsDeviceApi", "isPrecisionFindSupported err:" + th2.getMessage());
            return false;
        }
    }

    /* renamed from: n */
    public static boolean m79185n() {
        if (!m79184m()) {
            return false;
        }
        try {
            SleAdapterIf sleAdapter = SleAdapterIf.getSleAdapter();
            if (sleAdapter != null) {
                return sleAdapter.getSleState() == 1;
            }
            C13981a.m83988e("AlsDeviceApi", "isSleOn: sleAdapter is null");
            return false;
        } catch (Throwable th2) {
            C13981a.m83988e("AlsDeviceApi", "isSleOn error: " + th2.getMessage());
            return false;
        }
    }

    /* renamed from: o */
    public static boolean m79186o(String str) {
        return "2".equals(str);
    }

    /* renamed from: p */
    public static void m79187p() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                C13981a.m83988e("AlsDeviceApi", "openBluetooth: bltAdapter is null");
            } else {
                defaultAdapter.enable();
            }
        } catch (Exception e10) {
            C13981a.m83988e("AlsDeviceApi", "openBluetooth error: " + e10.getMessage());
        }
    }

    /* renamed from: q */
    public static void m79188q() {
        try {
            SleAdapterIf sleAdapter = SleAdapterIf.getSleAdapter();
            if (sleAdapter == null) {
                C13981a.m83988e("AlsDeviceApi", "openSle: sleAdapter is null");
            } else {
                sleAdapter.enableSle();
            }
        } catch (Throwable th2) {
            C13981a.m83988e("AlsDeviceApi", "openSle error: " + th2.getMessage());
        }
    }

    /* renamed from: t */
    public static String m79189t(String str) {
        return String.valueOf(C0241z.m1687e(str, 16, 1));
    }

    /* renamed from: g */
    public void m79190g() {
        C13981a.m83989i("AlsDeviceApi", "start ariLink service, operation: " + this.f59683a);
        try {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
            hiCloudSafeIntent.setAction("com.huawei.airlink.AirLinkService");
            C0209d.m1302r2(hiCloudSafeIntent, "com.huawei.airlink");
            this.f59687e.bindService(hiCloudSafeIntent, this.f59688f, 1);
        } catch (Exception e10) {
            C13981a.m83988e("AlsDeviceApi", "connectService error:" + e10.getMessage());
        }
        C13428t.m80716a(this.f59684b.getString("deviceId"), "1", "0", "airLink device connectService: " + this.f59683a, this.f59683a, "airLinkDevice", null);
    }

    /* renamed from: i */
    public final void m79191i() {
        C13981a.m83989i("AlsDeviceApi", "disconnect als service");
        if (this.f59688f != null) {
            m79194u();
            this.f59687e.unbindService(this.f59688f);
            this.f59688f = null;
        }
        this.f59685c = null;
        this.f59686d = null;
    }

    /* renamed from: r */
    public final void m79192r() {
        IAirLinkAidlInterface iAirLinkAidlInterface = this.f59685c;
        if (iAirLinkAidlInterface == null) {
            C13981a.m83988e("AlsDeviceApi", "registerCallback got null AirLinkService");
            return;
        }
        try {
            C13981a.m83989i("AlsDeviceApi", "registerCallback result = " + iAirLinkAidlInterface.registerCallback(this.f59686d));
            m79193s(this.f59683a, this.f59684b);
        } catch (Exception e10) {
            C13981a.m83988e("AlsDeviceApi", "registerCallback fail:" + e10.getMessage());
        }
    }

    /* renamed from: s */
    public void m79193s(String str, Bundle bundle) {
        if (this.f59685c == null) {
            C13981a.m83988e("AlsDeviceApi", "sendOperation got null AirLinkService");
            return;
        }
        if (TextUtils.isEmpty(str) || bundle == null) {
            C13981a.m83988e("AlsDeviceApi", "operation or bundle is empty");
            return;
        }
        try {
            this.f59685c.commonOperation(str, bundle);
            C13981a.m83989i("AlsDeviceApi", "sendOperation:" + str);
        } catch (Exception e10) {
            C13981a.m83988e("AlsDeviceApi", "sendOperation fail:" + e10.getMessage());
        }
        if ("getBindDeviceList".equals(str)) {
            return;
        }
        m79191i();
    }

    /* renamed from: u */
    public final void m79194u() {
        IAirLinkAidlInterface iAirLinkAidlInterface = this.f59685c;
        if (iAirLinkAidlInterface == null) {
            C13981a.m83988e("AlsDeviceApi", "unRegisterCallback got null AirLinkService");
            return;
        }
        try {
            C13981a.m83989i("AlsDeviceApi", "unRegisterCallback result = " + iAirLinkAidlInterface.unRegisterCallback());
        } catch (Exception unused) {
            C13981a.m83988e("AlsDeviceApi", "unRegisterCallback fail");
        }
    }
}
