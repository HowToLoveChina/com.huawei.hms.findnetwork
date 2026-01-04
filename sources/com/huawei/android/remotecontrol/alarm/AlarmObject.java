package com.huawei.android.remotecontrol.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback;
import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0241z;
import p664u0.C13108a;
import p677ue.C13168a;
import p772xe.C13788m;
import p809yg.C13981a;
import se.C12791m;
import ye.C13978y;

/* loaded from: classes4.dex */
public abstract class AlarmObject extends AbstractC1177c {

    /* renamed from: l */
    public String f19721l;

    /* renamed from: m */
    public String f19722m;

    /* renamed from: n */
    public String f19723n;

    /* renamed from: o */
    public BluetoothControlReceiver f19724o;

    /* renamed from: p */
    public Timer f19725p;

    /* renamed from: q */
    public boolean f19726q;

    public class BluetoothControlReceiver extends BroadcastReceiver {
        public BluetoothControlReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if ("com.huawei.android.remotecontrol.action.DEVICE_CONTROL_STATE".equals(action)) {
                AlarmObject.this.mo25991i0(safeIntent);
            } else if ("com.huawei.android.remotecontrol.action.WEAR_DEVICE_CONTROL".equals(action)) {
                AlarmObject.this.mo25994l0(safeIntent);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.alarm.AlarmObject$a */
    public class C4322a implements FindNetworkSoundCallback {
        public C4322a() {
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            if (907201121 == findNetworkConfigResult.getRespCode()) {
                C13788m.m82779c().m82781b(AlarmObject.this.f19721l);
            }
            AlarmObject.this.mo25993k0(false, findNetworkConfigResult.getRespCode());
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            AlarmObject.this.mo25992j0(findNetworkConfigResult.getRespCode());
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            AlarmObject.this.mo25993k0(true, findNetworkConfigResult.getRespCode());
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("AlarmObject", "FinderTagAlarmCallback onUpdate");
            AlarmObject.this.mo25993k0(false, findNetworkConfigResult.getRespCode());
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.alarm.AlarmObject$b */
    public class C4323b implements Handler.Callback {

        /* renamed from: a */
        public int f19729a;

        /* renamed from: b */
        public String f19730b;

        public C4323b(int i10, String str) {
            this.f19729a = i10;
            this.f19730b = str;
            C13981a.m83989i("AlarmObject", "HttpCallback operation:" + str);
        }

        /* renamed from: a */
        public final void m26002a(Message message, String str) throws JSONException {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("AlarmObject", "handleAlarmReportResult, result: " + iM1685c);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("perDeviceType", AlarmObject.this.f5581b.getCmdParamValue("perDeviceType"));
            if (200 != iM1685c) {
                C13981a.m83988e("AlarmObject", str + " handleAlarmReportResult->report error, result:" + iM1685c);
                AlarmObject.this.m7427Q("AlarmObject", "001_3003", -1, str + " handleAlarmReportResult callback error,result:" + iM1685c, null, this.f19730b, "ancillaryAlarm", true, linkedHashMap);
                return;
            }
            int iM7438x = AlarmObject.this.m7438x(message.getData().getString("response_info"));
            C13981a.m83989i("AlarmObject", str + " handleAlarmReportResult->resultCode =" + iM7438x);
            if (iM7438x != 0) {
                AlarmObject.this.m7427Q("AlarmObject", "001_3004", iM7438x, str + " handleAlarmReportResult callback fail,resultCode:" + iM7438x, null, this.f19730b, "ancillaryAlarm", true, linkedHashMap);
                return;
            }
            C13981a.m83989i("AlarmObject", str + " handleAlarmReportResult,AppEventLogParam report success");
            AlarmObject.this.m7427Q("AlarmObject", "0", -1, str + " handleAlarmReportResult callback success", null, this.f19730b, "ancillaryAlarm", true, linkedHashMap);
        }

        /* renamed from: b */
        public final void m26003b(Message message, String str) throws JSONException {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("AlarmObject", "handleAlarmReportResultFail, result: " + iM1685c);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("perDeviceType", AlarmObject.this.f5581b.getCmdParamValue("perDeviceType"));
            if (200 != iM1685c) {
                C13981a.m83988e("AlarmObject", str + " handleAlarmReportResultFail->report error, result:" + iM1685c);
                AlarmObject.this.m7427Q("AlarmObject", "001_3003", -1, str + " handleAlarmReportResultFail callback error,result:" + iM1685c, null, this.f19730b, "pushResult_reported", true, linkedHashMap);
                return;
            }
            int iM7438x = AlarmObject.this.m7438x(message.getData().getString("response_info"));
            C13981a.m83989i("AlarmObject", str + " handleAlarmReportResultFail->resultCode =" + iM7438x);
            if (iM7438x != 0) {
                AlarmObject.this.m7427Q("AlarmObject", "001_3004", iM7438x, str + " handleAlarmReportResultFail callback fail,resultCode:" + iM7438x, null, this.f19730b, "pushResult_reported", true, linkedHashMap);
                return;
            }
            C13981a.m83988e("AlarmObject", str + " handleAlarmReportResultFail,AppEventLogParam report success");
            AlarmObject.this.m7427Q("AlarmObject", "0", -1, str + " handleAlarmReportResultFail callback: " + AlarmObject.this.f5582c, null, this.f19730b, "pushResult_reported", true, linkedHashMap);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            C13981a.m83989i("AlarmObject", "Alarm handleMessage, operation: " + this.f19730b + ", mWhat: " + this.f19729a);
            int i10 = this.f19729a;
            if (3076 == i10) {
                m26002a(message, "AncillaryDeviceAlarm");
                return true;
            }
            if (3077 == i10) {
                m26003b(message, "AncillaryDeviceAlarm");
                return true;
            }
            if (3078 == i10) {
                m26002a(message, "AncillaryDeviceAlarmCancel");
                return true;
            }
            if (3079 == i10) {
                m26003b(message, "AncillaryDeviceAlarmCancel");
                return true;
            }
            C13981a.m83989i("AlarmObject", "handleMessage wha=" + this.f19729a);
            return true;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.alarm.AlarmObject$c */
    public class C4324c extends TimerTask {
        public C4324c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AlarmObject.this.m26001s0();
            AlarmObject.this.mo25996n0();
        }
    }

    public AlarmObject(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f19726q = false;
        this.f19721l = this.f5581b.getCmdParamValue("perDeviceId");
        this.f19722m = this.f5581b.getCmdParamValue("cptList");
        this.f19723n = this.f5581b.getCmdParamValue("perDeviceType");
    }

    @Override // bf.AbstractC1177c
    /* renamed from: J */
    public boolean mo7422J() {
        if (!TextUtils.isEmpty(this.f19721l) && !TextUtils.isEmpty(this.f19722m) && !TextUtils.isEmpty(this.f19723n)) {
            return super.mo7422J();
        }
        C13981a.m83988e("AlarmObject", "parseControlCmd error: perDeviceId or cptList is empty");
        return false;
    }

    /* renamed from: f0 */
    public void m25988f0() {
        C13981a.m83989i("AlarmObject", "cancelControlTimer");
        Timer timer = this.f19725p;
        if (timer != null) {
            timer.cancel();
            this.f19725p = null;
        }
    }

    /* renamed from: g0 */
    public String m25989g0(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("AlarmObject", "createStateCptList:state is empty");
            return "-1";
        }
        StringBuilder sb2 = new StringBuilder();
        if (str.equals(str2)) {
            sb2.append("1");
        }
        if (str.equals(str3)) {
            if (str.equals(str2)) {
                sb2.append(",");
                sb2.append("2");
            } else {
                sb2.append("2");
            }
        }
        return sb2.toString();
    }

    /* renamed from: h0 */
    public String m25990h0() {
        return this.f19721l;
    }

    /* renamed from: i0 */
    public abstract void mo25991i0(SafeIntent safeIntent);

    /* renamed from: j0 */
    public abstract void mo25992j0(int i10);

    /* renamed from: k0 */
    public abstract void mo25993k0(boolean z10, int i10);

    /* renamed from: l0 */
    public abstract void mo25994l0(SafeIntent safeIntent);

    /* renamed from: m0 */
    public boolean m25995m0(int i10) {
        if (C0209d.m1184K0(this.f5580a, C13978y.m83902S())) {
            return true;
        }
        C13981a.m83988e("AlarmObject", "health not install");
        mo25999q0(13, this.f19722m, this.f5581b.getOperation(), i10);
        return false;
    }

    /* renamed from: n0 */
    public abstract void mo25996n0();

    /* renamed from: o0 */
    public void m25997o0() {
        if (this.f19724o == null) {
            this.f19724o = new BluetoothControlReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.remotecontrol.action.DEVICE_CONTROL_STATE");
        intentFilter.addAction("com.huawei.android.remotecontrol.action.WEAR_DEVICE_CONTROL");
        C13108a.m78878b(this.f5580a).m78880c(this.f19724o, intentFilter);
    }

    /* renamed from: p0 */
    public void m25998p0() {
        if (this.f19725p == null) {
            this.f19725p = new Timer();
        }
        this.f19725p.schedule(new C4324c(), C13168a.m79183l(this.f19723n) ? 19000L : 20000L);
    }

    /* renamed from: q0 */
    public void mo25999q0(int i10, String str, String str2, int i11) {
        if (TextUtils.isEmpty(str)) {
            str = this.f5581b.getCmdParamValue("cptList");
        }
        C12791m c12791m = new C12791m(this.f5580a, 3032, i10, this.f5581b, str, str2, new C4323b(i11, str2));
        if (C13168a.m79183l(this.f19723n)) {
            c12791m.m76761j().m85164h("perDeviceStopbell".equals(str2) ? "stopTagSound" : this.f5581b.getTagOperation());
        }
        c12791m.m76759h();
    }

    /* renamed from: r0 */
    public String m26000r0(String str) {
        return "255".equals(str) ? "0" : str;
    }

    /* renamed from: s0 */
    public void m26001s0() {
        if (this.f19724o != null) {
            C13108a.m78878b(this.f5580a).m78883f(this.f19724o);
            this.f19724o = null;
        }
    }
}
