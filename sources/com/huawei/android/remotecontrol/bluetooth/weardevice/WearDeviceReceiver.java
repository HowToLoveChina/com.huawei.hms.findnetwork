package com.huawei.android.remotecontrol.bluetooth.weardevice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseIntArray;
import bf.C1175a;
import com.huawei.android.remotecontrol.bluetooth.AlsDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceDBHelper;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import eg.AbstractC9478g;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0210d0;
import p015ak.C0226l0;
import p521og.C11877j;
import p616rk.C12515a;
import p709vj.C13452e;
import p772xe.C13776a;
import p772xe.C13777b;
import p774xg.C13811a;
import p809yg.C13981a;
import ve.C13428t;

/* loaded from: classes4.dex */
public class WearDeviceReceiver extends BroadcastReceiver {

    /* renamed from: com.huawei.android.remotecontrol.bluetooth.weardevice.WearDeviceReceiver$a */
    public static class C4336a extends AbstractC9478g {

        /* renamed from: a */
        public Context f19777a;

        /* renamed from: b */
        public AncillaryDeviceInfo f19778b;

        public C4336a(Context context, AncillaryDeviceInfo ancillaryDeviceInfo) {
            this.f19777a = context;
            this.f19778b = ancillaryDeviceInfo;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (StringUtil.equals("1", AncillaryDeviceDBHelper.m26045e(this.f19777a).m26053t(this.f19778b.getDeviceID()))) {
                C13981a.m83989i("WearDeviceReceiver", "already has this device, doesn't need add");
                return;
            }
            this.f19778b.setConnected(true);
            C13981a.m83989i("WearDeviceReceiver", "handleUpdateDeviceInfo ADD_DEVICE");
            AncillaryDeviceManager.m26080y().m26106u(this.f19778b);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.bluetooth.weardevice.WearDeviceReceiver$b */
    public class C4337b extends AbstractC9478g {

        /* renamed from: a */
        public Context f19779a;

        /* renamed from: b */
        public AncillaryDeviceInfo f19780b;

        public C4337b(Context context, AncillaryDeviceInfo ancillaryDeviceInfo) {
            this.f19779a = context;
            this.f19780b = ancillaryDeviceInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            WearDeviceReceiver.this.m26146c(this.f19779a, this.f19780b);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (AncillaryDeviceDBHelper.m26045e(this.f19779a).m26057x(this.f19780b.getDeviceID())) {
                C0226l0.m1584d(new Runnable() { // from class: ye.b0
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        this.f62593a.lambda$call$0();
                    }
                });
            } else {
                C13981a.m83989i("WearDeviceReceiver", "the local device list doesn't have this device, doesn't need report");
            }
        }
    }

    /* renamed from: b */
    public final AncillaryDeviceInfo m26145b(SafeIntent safeIntent) {
        AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
        String stringExtra = safeIntent.getStringExtra("deviceId");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        ancillaryDeviceInfo.setDeviceID(stringExtra);
        if (safeIntent.hasExtra("deviceName")) {
            ancillaryDeviceInfo.setDeviceName(safeIntent.getStringExtra("deviceName"));
        }
        if (safeIntent.hasExtra("deviceModule")) {
            ancillaryDeviceInfo.setModelId(safeIntent.getStringExtra("deviceModule"));
        }
        ancillaryDeviceInfo.setPerDeviceType("2");
        ancillaryDeviceInfo.setSubDeviceType("1");
        ancillaryDeviceInfo.setDeviceType("0");
        return ancillaryDeviceInfo;
    }

    /* renamed from: c */
    public final void m26146c(Context context, AncillaryDeviceInfo ancillaryDeviceInfo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("WearDeviceReceiver", "doDeviceDisconnect");
        C13811a.m82805b(false, "disconnect_locate");
        AlsDeviceInfo alsDeviceInfo = new AlsDeviceInfo();
        alsDeviceInfo.setDeviceID(ancillaryDeviceInfo.getDeviceID());
        alsDeviceInfo.setPerDeviceType(ancillaryDeviceInfo.getPerDeviceType());
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        sparseIntArray.put(0, 1);
        alsDeviceInfo.setConnectStatus(sparseIntArray);
        C13777b.m82710k(ancillaryDeviceInfo.getDeviceID(), sparseIntArray, false);
        new C13776a(context, alsDeviceInfo).mo64403I0();
        C13428t.m80716a("", "2", "0", "doDeviceDisconnect", "WearDeviceReceiver", "wearEngineDevice", null);
    }

    /* renamed from: d */
    public final void m26147d(Context context, AncillaryDeviceInfo ancillaryDeviceInfo) {
        C13981a.m83989i("WearDeviceReceiver", "handleAddNewWearDevice");
        if (ancillaryDeviceInfo == null) {
            C13981a.m83988e("WearDeviceReceiver", "connected device is empty");
        } else {
            C12515a.m75110o().m75175e(new C4336a(context, ancillaryDeviceInfo), false);
        }
    }

    /* renamed from: e */
    public final void m26148e(Context context, AncillaryDeviceInfo ancillaryDeviceInfo) {
        C13981a.m83989i("WearDeviceReceiver", "handleWearDeviceDisconnect");
        if (ancillaryDeviceInfo == null) {
            C13981a.m83988e("WearDeviceReceiver", "disconnected device is empty");
        } else if (C13777b.m82706g(ancillaryDeviceInfo.getDeviceID())) {
            C13981a.m83990w("WearDeviceReceiver", "wearDevice disconnect isFlowControl, break");
        } else {
            C12515a.m75110o().m75175e(new C4337b(context, ancillaryDeviceInfo), false);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            C13981a.m83988e("WearDeviceReceiver", "context or intent is null");
            return;
        }
        if (!C0210d0.m1338f().m1341b(context, "com.huawei.health", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05")) {
            C13981a.m83988e("WearDeviceReceiver", "checkPkgNameAndSign fail");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String action = safeIntent.getAction();
        if (TextUtils.isEmpty(action)) {
            C13981a.m83988e("WearDeviceReceiver", "huawei health action is empty");
            return;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C13981a.m83990w("WearDeviceReceiver", "receive wear device broadcast, cloud not login");
            return;
        }
        if (!C1175a.m7389k(context)) {
            C13981a.m83990w("WearDeviceReceiver", "receive wear device broadcast, Client Switch off");
            return;
        }
        AncillaryDeviceInfo ancillaryDeviceInfoM26145b = m26145b(safeIntent);
        if (ancillaryDeviceInfoM26145b == null) {
            C13428t.m80716a("", "2", "0", "ancillaryDevice receive wear device broadcast: " + action + ",deviceInfo is null", "WearDeviceReceiver", "wearEngineDevice", null);
            return;
        }
        String stringExtra = safeIntent.getStringExtra("connectType");
        C13428t.m80716a(ancillaryDeviceInfoM26145b.getDeviceID(), "2", "0", "ancillaryDevice receive wear device broadcast: " + action + ", connectType: " + stringExtra, "WearDeviceReceiver", "wearEngineDevice", null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("receive wear device broadcast, connectType: ");
        sb2.append(stringExtra);
        C13981a.m83989i("WearDeviceReceiver", sb2.toString());
        if ("1".equals(stringExtra)) {
            C13981a.m83989i("WearDeviceReceiver", "has wear device connected");
            m26147d(context, ancillaryDeviceInfoM26145b);
            C11877j.m71217K0(context, true);
        } else {
            if (!"0".equals(stringExtra)) {
                C13981a.m83988e("WearDeviceReceiver", "connectType can not be recognised");
                return;
            }
            C13981a.m83989i("WearDeviceReceiver", "has wear device disconnected");
            if (C11877j.m71319z(context)) {
                C11877j.m71217K0(context, false);
                m26148e(context, ancillaryDeviceInfoM26145b);
            } else {
                C13981a.m83989i("WearDeviceReceiver", "wear device already report disconnect location");
                C13428t.m80716a("", "2", "0", "wear device already report disconnect location", "WearDeviceReceiver", "wearEngineDevice", null);
            }
        }
    }
}
