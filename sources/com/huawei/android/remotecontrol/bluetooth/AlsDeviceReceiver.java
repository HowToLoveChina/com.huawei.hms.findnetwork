package com.huawei.android.remotecontrol.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseIntArray;
import bf.C1175a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.bluetooth.HwBindDevice;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.secure.android.common.intent.SafeIntent;
import eg.AbstractC9478g;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p521og.C11873f;
import p521og.C11881n;
import p616rk.C12515a;
import p664u0.C13108a;
import p677ue.C13168a;
import p709vj.C13452e;
import p772xe.C13776a;
import p772xe.C13777b;
import p774xg.C13811a;
import p809yg.C13981a;
import ve.C13428t;

/* loaded from: classes4.dex */
public class AlsDeviceReceiver extends BroadcastReceiver {

    /* renamed from: com.huawei.android.remotecontrol.bluetooth.AlsDeviceReceiver$a */
    public class C4330a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ HwBindDevice f19748a;

        /* renamed from: b */
        public final /* synthetic */ int f19749b;

        public C4330a(HwBindDevice hwBindDevice, int i10) {
            this.f19748a = hwBindDevice;
            this.f19749b = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AncillaryDeviceInfo ancillaryDeviceInfoM26038b = AlsDeviceReceiver.this.m26038b(this.f19748a);
            int i10 = this.f19749b;
            if (i10 == 0) {
                C13981a.m83989i("AlsDeviceReceiver", "handleUpdateDeviceInfo ADD_DEVICE");
                AncillaryDeviceManager.m26080y().m26106u(ancillaryDeviceInfoM26038b);
            } else if (2 == i10) {
                C13981a.m83989i("AlsDeviceReceiver", "handleUpdateDeviceInfo UPDATE_DEVICE");
                AncillaryDeviceManager.m26080y().m26100X(ancillaryDeviceInfoM26038b);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.bluetooth.AlsDeviceReceiver$b */
    public static class C4331b extends AbstractC9478g {
        public C4331b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            List<AncillaryDeviceInfo> listM26109x = AncillaryDeviceManager.m26080y().m26109x("1", "1");
            C13981a.m83989i("AlsDeviceReceiver", "receiver broadcast, send find device list");
            AncillaryDeviceManager.m26080y().m26096T(C13168a.m79178e(listM26109x));
        }

        public /* synthetic */ C4331b(C4330a c4330a) {
            this();
        }
    }

    /* renamed from: b */
    public final AncillaryDeviceInfo m26038b(HwBindDevice hwBindDevice) {
        AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
        ancillaryDeviceInfo.setPerDeviceType("1");
        ancillaryDeviceInfo.setDeviceID(hwBindDevice.getDeviceId());
        ancillaryDeviceInfo.setDeviceType(C13168a.m79189t(hwBindDevice.getDeviceType()));
        ancillaryDeviceInfo.setModelId(hwBindDevice.getModelId());
        ancillaryDeviceInfo.setSubModelId(C13168a.m79189t(hwBindDevice.getSubModelId()));
        ancillaryDeviceInfo.setConnectivity(C13168a.m79189t(hwBindDevice.getConnectivity()));
        C13981a.m83989i("AlsDeviceReceiver", "get bluetooth device name:" + hwBindDevice.getDeviceName());
        ancillaryDeviceInfo.setDeviceName(hwBindDevice.getDeviceName());
        ancillaryDeviceInfo.setSubDeviceType(C13168a.m79189t(hwBindDevice.getSubDeviceType()));
        ancillaryDeviceInfo.setWearDetect(C13168a.m79189t(hwBindDevice.getWearDetect()));
        ancillaryDeviceInfo.setTimeStamp(hwBindDevice.getTimeStamp());
        ancillaryDeviceInfo.setFindCapability(C13168a.m79180h(hwBindDevice.getFindCapability()));
        ancillaryDeviceInfo.setDeviceBtMac(hwBindDevice.getDeviceBtMac());
        ancillaryDeviceInfo.setIrk(hwBindDevice.getIrk());
        ancillaryDeviceInfo.setHbkp(hwBindDevice.getHbkP());
        return ancillaryDeviceInfo;
    }

    /* renamed from: c */
    public final void m26039c(SafeIntent safeIntent) {
        if (safeIntent == null) {
            C13981a.m83988e("AlsDeviceReceiver", "handleDeviceControl intent is null");
            return;
        }
        C13981a.m83989i("AlsDeviceReceiver", "handleDeviceControl");
        safeIntent.setAction("com.huawei.android.remotecontrol.action.DEVICE_CONTROL_STATE");
        C13108a.m78878b(C11873f.m71178f().m71181c()).m78881d(safeIntent);
    }

    /* renamed from: d */
    public final void m26040d(Context context, SafeIntent safeIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String stringExtra = safeIntent.getStringExtra("deviceId");
        String stringExtra2 = safeIntent.getStringExtra("disconnectObj");
        String stringExtra3 = safeIntent.hasExtra("battery") ? safeIntent.getStringExtra("battery") : "{\"0x00\" : -1, \"0x01\" : -1}";
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            C13981a.m83988e("AlsDeviceReceiver", "ancillary device status is empty");
            return;
        }
        if (C13777b.m82706g(stringExtra)) {
            C13981a.m83990w("AlsDeviceReceiver", "ancillary disconnect isFlowControl,break");
            return;
        }
        C13811a.m82805b(false, "disconnect_locate");
        AlsDeviceInfo alsDeviceInfo = new AlsDeviceInfo();
        alsDeviceInfo.setDeviceID(stringExtra);
        alsDeviceInfo.setPerDeviceType("1");
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        SparseIntArray sparseIntArray2 = new SparseIntArray(2);
        try {
            JSONObject jSONObject = new JSONObject(stringExtra2);
            String strM71362l = C11881n.m71362l(jSONObject, "0x00");
            if (!TextUtils.isEmpty(strM71362l)) {
                C13981a.m83989i("AlsDeviceReceiver", "cptType:0 state:" + strM71362l);
                sparseIntArray.put(0, C0241z.m1685c(strM71362l));
            }
            String strM71362l2 = C11881n.m71362l(jSONObject, "0x01");
            if (!TextUtils.isEmpty(strM71362l2)) {
                C13981a.m83989i("AlsDeviceReceiver", "cptType:1 state:" + strM71362l2);
                sparseIntArray.put(1, C0241z.m1685c(strM71362l2));
            }
            JSONObject jSONObject2 = new JSONObject(stringExtra3);
            String strM71362l3 = C11881n.m71362l(jSONObject2, "0x00");
            if (!TextUtils.isEmpty(strM71362l3)) {
                C13981a.m83989i("AlsDeviceReceiver", "ancLeftBattery:0 state:" + strM71362l3);
                sparseIntArray2.put(0, C0241z.m1685c(strM71362l3));
            }
            String strM71362l4 = C11881n.m71362l(jSONObject2, "0x01");
            if (!TextUtils.isEmpty(strM71362l4)) {
                C13981a.m83989i("AlsDeviceReceiver", "ancRightBattery:1 state:" + strM71362l4);
                sparseIntArray2.put(1, C0241z.m1685c(strM71362l4));
            }
        } catch (JSONException e10) {
            C13981a.m83988e("AlsDeviceReceiver", "parseDisDevicesState:JSONException=" + e10.getMessage());
        }
        alsDeviceInfo.setConnectStatus(sparseIntArray);
        C13777b.m82710k(stringExtra, sparseIntArray, false);
        alsDeviceInfo.setBattery(sparseIntArray2);
        new C13776a(context, alsDeviceInfo).mo64403I0();
    }

    /* renamed from: e */
    public final void m26041e(SafeIntent safeIntent) {
        if (safeIntent == null) {
            C13981a.m83988e("AlsDeviceReceiver", "handleLocateAncDevice intent is null");
            return;
        }
        C13981a.m83989i("AlsDeviceReceiver", "handleLocateAncDevice");
        safeIntent.setAction("com.huawei.android.remotecontrol.action.SEARCH_RESULT");
        C13108a.m78878b(C11873f.m71178f().m71181c()).m78881d(safeIntent);
    }

    /* renamed from: f */
    public final void m26042f() {
        C12515a.m75110o().m75175e(new C4331b(null), false);
    }

    /* renamed from: g */
    public final void m26043g(SafeIntent safeIntent) {
        C13981a.m83989i("AlsDeviceReceiver", "handleUpdateDeviceInfo");
        try {
            JSONObject jSONObject = new JSONObject(safeIntent.getStringExtra("bindDeviceListUpdate"));
            String string = jSONObject.has("bindDeviceUpdate") ? jSONObject.getString("bindDeviceUpdate") : null;
            int intExtra = safeIntent.getIntExtra("updateMethod", -1);
            C13981a.m83989i("AlsDeviceReceiver", "handleUpdateDeviceInfo flag is:" + intExtra);
            if (TextUtils.isEmpty(string) || -1 == intExtra) {
                C13981a.m83988e("AlsDeviceReceiver", "update device is empty");
                return;
            }
            HwBindDevice hwBindDevice = (HwBindDevice) new Gson().fromJson(string, HwBindDevice.class);
            if (hwBindDevice == null) {
                C13981a.m83988e("AlsDeviceReceiver", "update device is empty");
            } else {
                C12515a.m75110o().m75175e(new C4330a(hwBindDevice, intExtra), false);
            }
        } catch (JsonSyntaxException e10) {
            C13981a.m83988e("AlsDeviceReceiver", "handleUpdateDeviceInfo exception:" + e10.getMessage());
        } catch (Exception e11) {
            C13981a.m83988e("AlsDeviceReceiver", "handleUpdateDeviceInfo Json exception:" + e11.getMessage());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (intent == null || context == null) {
            C13981a.m83988e("AlsDeviceReceiver", "context or intent is null");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String action = safeIntent.getAction();
        if (TextUtils.isEmpty(action)) {
            C13981a.m83988e("AlsDeviceReceiver", "action is empty");
            return;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C13981a.m83990w("AlsDeviceReceiver", "receive ALS device broadcast, cloud not login");
            return;
        }
        if (!C1175a.m7389k(context)) {
            C13981a.m83990w("AlsDeviceReceiver", "receive ALS device broadcast, Client Switch off");
            return;
        }
        C13981a.m83989i("AlsDeviceReceiver", "Receive ALS device broadcast:" + action);
        C13428t.m80716a(safeIntent.getStringExtra("deviceId"), "1", "0", "airLink device onReceive: " + action, "AlsDeviceReceiver", "airLinkDevice", null);
        if ("com.huawei.bluetooth.action.DEVICE_DISCONNECT".equals(action)) {
            m26040d(context, safeIntent);
            return;
        }
        if ("com.huawei.bluetooth.action.DEVICE_CONTROL_STATE".equals(action)) {
            m26039c(safeIntent);
            return;
        }
        if ("com.huawei.bluetooth.action.BIND_DEVICE_LIST_UPDATE".equals(action)) {
            m26043g(safeIntent);
            return;
        }
        if ("com.huawei.bluetooth.action.GET_FIND_DEVICE_LIST".equals(action)) {
            m26042f();
        } else if ("com.huawei.bluetooth.action.SEARCH_RESULT".equals(action)) {
            m26041e(safeIntent);
        } else {
            C13981a.m83990w("AlsDeviceReceiver", "action can't be recognised");
        }
    }
}
