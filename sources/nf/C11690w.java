package nf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.fastengine.fastview.RouterEventReceiver;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkScanResult;
import com.huawei.hms.network.p129ai.C5807k0;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import eg.AbstractC9478g;
import fk.C9721b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0225l;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p227dg.C9120m0;
import p292fn.C9733f;
import p476mf.C11464r;
import p575qe.C12347f;
import p616rk.C12515a;
import p664u0.C13108a;
import p677ue.C13168a;
import p684un.C13222a;
import p709vj.C13452e;
import p772xe.C13779d;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import sg.C12797b;
import vg.C13435b;
import vg.C13442i;

/* renamed from: nf.w */
/* loaded from: classes4.dex */
public class C11690w {

    /* renamed from: a */
    public static long f54154a;

    /* renamed from: b */
    public static long f54155b;

    /* renamed from: c */
    public static final Map<String, FindNetworkScanResult> f54156c = new ConcurrentHashMap();

    /* renamed from: d */
    public static final Map<String, C13779d> f54157d = new ConcurrentHashMap();

    /* renamed from: e */
    public static String f54158e = "";

    /* renamed from: f */
    public static boolean f54159f = false;

    /* renamed from: nf.w$a */
    public class a implements FindNetworkSoundCallback {

        /* renamed from: a */
        public final /* synthetic */ WapFindPhoneActivity.HandlerC4536g f54160a;

        public a(WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
            this.f54160a = handlerC4536g;
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83988e("FindNetworkUtil", "startSound onFail:" + findNetworkConfigResult.getDescription() + ",Code:" + findNetworkConfigResult.getRespCode());
            C11690w.m69721i0(this.f54160a, 1);
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("FindNetworkUtil", "startSound onFinished");
            C11690w.m69723j0(this.f54160a, 0);
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("FindNetworkUtil", "startSound onSuccess:" + findNetworkConfigResult.getRespCode());
            C11690w.m69721i0(this.f54160a, 0);
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("FindNetworkUtil", "startSound onUpdate");
        }
    }

    /* renamed from: nf.w$b */
    public class b implements FindNetworkSoundCallback {

        /* renamed from: a */
        public final /* synthetic */ WapFindPhoneActivity.HandlerC4536g f54161a;

        public b(WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
            this.f54161a = handlerC4536g;
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83988e("FindNetworkUtil", "stopSound onFail:" + findNetworkConfigResult.getDescription() + ",Code:" + findNetworkConfigResult.getRespCode());
            C11690w.m69723j0(this.f54161a, 1);
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("FindNetworkUtil", "stopSound onFinished");
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("FindNetworkUtil", "stopSound onSuccess:" + findNetworkConfigResult.getRespCode());
            C11690w.m69723j0(this.f54161a, 0);
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("FindNetworkUtil", "stopSound onUpdate");
        }
    }

    /* renamed from: nf.w$c */
    public class c extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ WapFindPhoneActivity.HandlerC4536g f54162a;

        /* renamed from: nf.w$c$a */
        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                int i10 = (C13168a.m79182k() && C13168a.m79185n()) ? 0 : 1;
                C13981a.m83989i("FindNetworkUtil", "openCurrentDeviceSwitch openResult: " + i10);
                if (c.this.f54162a != null) {
                    Message message = new Message();
                    message.what = 1018;
                    Bundle bundle = new Bundle();
                    bundle.putInt(RouterEventReceiver.KEY_PARAMS, i10);
                    message.obj = bundle;
                    c.this.f54162a.handleMessage(message);
                }
            }
        }

        public c(WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
            this.f54162a = handlerC4536g;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C13981a.m83989i("FindNetworkUtil", "openCurrentDeviceSwitch");
            if (!C13168a.m79182k()) {
                C13168a.m79187p();
            }
            if (!C13168a.m79185n()) {
                C13168a.m79188q();
            }
            new Timer().schedule(new a(), 300L);
        }
    }

    /* renamed from: A */
    public static boolean m69678A(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getInt(str) == 1;
            } catch (JSONException e10) {
                C13981a.m83988e("FindNetworkUtil", "getParamsFromFN e: " + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: B */
    public static /* synthetic */ void m69679B(String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g, Integer num) {
        C13981a.m83989i("FindNetworkUtil", "createLongConnect, connectStatus: " + num);
        if (907201121 == num.intValue()) {
            m69744y(str);
        }
        m69717g0(str, num.intValue(), handlerC4536g);
    }

    /* renamed from: C */
    public static /* synthetic */ void m69680C(Consumer consumer, Void r22) {
        C13981a.m83989i("FindNetworkUtil", "pullUpFindNetwork setFindeeMode success");
        if (consumer != null) {
            consumer.accept(Boolean.TRUE);
        }
    }

    /* renamed from: D */
    public static /* synthetic */ void m69681D(Consumer consumer, Exception exc) {
        C13981a.m83988e("FindNetworkUtil", "pullUpFindNetwork setFindeeMode error: " + exc);
        if (consumer != null) {
            consumer.accept(Boolean.FALSE);
        }
    }

    /* renamed from: E */
    public static /* synthetic */ Task m69682E(Context context, int i10, final Consumer consumer) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).setFindeeMode(i10 / 60).addOnSuccessListener(new InterfaceC8939g() { // from class: nf.j
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                C11690w.m69680C(consumer, (Void) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: nf.k
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                C11690w.m69681D(consumer, exc);
            }
        });
    }

    /* renamed from: F */
    public static /* synthetic */ void m69683F(Consumer consumer, Exception exc) {
        C13981a.m83988e("FindNetworkUtil", "pullUpFindNetwork setFindeeMode exception:" + exc.getMessage());
        if (consumer != null) {
            consumer.accept(Boolean.FALSE);
        }
    }

    /* renamed from: G */
    public static /* synthetic */ void m69684G(WapFindPhoneActivity.HandlerC4536g handlerC4536g, FindNetworkResult findNetworkResult) {
        C13981a.m83989i("FindNetworkUtil", "queryCurrentDeviceDetail success, result: " + findNetworkResult.getRespCode());
        try {
            if (findNetworkResult.getRespCode() == 0) {
                String accessoryCapabilities = ((DeviceDetail) findNetworkResult.getData()).getAccessoryCapabilities();
                C13981a.m83989i("FindNetworkUtil", "queryCurrentDeviceDetail localCapabilities: " + accessoryCapabilities);
                m69702Y(m69678A(new JSONObject(accessoryCapabilities), DeviceDetail.CAP_KEY_LOST_NEAR_LINK_NAVIGATION), handlerC4536g);
            } else {
                m69702Y(false, handlerC4536g);
            }
        } catch (Exception e10) {
            C13981a.m83988e("FindNetworkUtil", "queryCurrentDeviceDetail e: " + e10.getMessage());
            m69702Y(false, handlerC4536g);
        }
    }

    /* renamed from: H */
    public static /* synthetic */ void m69685H(WapFindPhoneActivity.HandlerC4536g handlerC4536g, Exception exc) {
        C13981a.m83988e("FindNetworkUtil", "queryCurrentDeviceDetail fail");
        m69702Y(false, handlerC4536g);
    }

    /* renamed from: I */
    public static /* synthetic */ void m69686I(long j10, Context context, String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g, FindNetworkResult findNetworkResult) {
        String str2 = "queryRemoteDeviceCap success, during: " + (System.currentTimeMillis() - j10);
        C13981a.m83989i("FindNetworkUtil", str2);
        if (findNetworkResult.getRespCode() == 0) {
            C13442i.m80758j().m80766p((DeviceDetail) findNetworkResult.getData());
            m69713e0(context, str, (DeviceDetail) findNetworkResult.getData(), handlerC4536g, j10);
        } else {
            C13981a.m83988e("FindNetworkUtil", "queryRemoteDeviceCap resultCode: " + findNetworkResult.getRespCode());
            m69711d0(str, handlerC4536g);
        }
        m69700W(str, "deviceDetailResult", "deviceDetailBusiness", str2, String.valueOf(findNetworkResult.getRespCode()), null);
    }

    /* renamed from: J */
    public static /* synthetic */ void m69687J(String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g, Exception exc) {
        C13981a.m83988e("FindNetworkUtil", "queryRemoteDeviceCap fail");
        m69711d0(str, handlerC4536g);
    }

    /* renamed from: K */
    public static /* synthetic */ Boolean m69688K(final Context context, final String str, final long j10, final WapFindPhoneActivity.HandlerC4536g handlerC4536g) throws Exception {
        C13981a.m83989i("FindNetworkUtil", "queryRemoteDeviceCap start");
        FindNetwork.getFindNetworkEngine(context).queryDeviceDetail(str).addOnSuccessListener(new InterfaceC8939g() { // from class: nf.h
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                C11690w.m69686I(j10, context, str, handlerC4536g, (FindNetworkResult) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: nf.i
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                C11690w.m69687J(str, handlerC4536g, exc);
            }
        });
        return Boolean.TRUE;
    }

    /* renamed from: L */
    public static /* synthetic */ void m69689L(Exception exc) {
        C13981a.m83988e("FindNetworkUtil", "queryRemoteDeviceCap exception:" + exc.getMessage());
    }

    /* renamed from: M */
    public static /* synthetic */ void m69690M(long j10, String str, Context context, WapFindPhoneActivity.HandlerC4536g handlerC4536g, Integer num) {
        String str2 = "queryDeviceDetail, connectStatus: " + num + ", duringTime: " + (System.currentTimeMillis() - j10);
        C13981a.m83989i("FindNetworkUtil", str2);
        m69700W(str, "createLongConnect", "deviceDetailBusiness", str2, String.valueOf(num), null);
        if (907201121 == num.intValue()) {
            m69744y(str);
        }
        if (num.intValue() == 0) {
            m69707b0(context, str, handlerC4536g, j10);
        } else if (num.intValue() != 907201165) {
            m69711d0(str, handlerC4536g);
        }
    }

    /* renamed from: N */
    public static /* synthetic */ void m69691N(long j10, String str, DeviceDetail deviceDetail, WapFindPhoneActivity.HandlerC4536g handlerC4536g, FindNetworkResult findNetworkResult) {
        String str2 = "queryLocalDeviceCap success, result: " + findNetworkResult.getRespCode() + ", during: " + (System.currentTimeMillis() - j10);
        C13981a.m83989i("FindNetworkUtil", str2);
        if (findNetworkResult.getRespCode() == 0) {
            m69701X(str, deviceDetail, ((DeviceDetail) findNetworkResult.getData()).getAccessoryCapabilities(), handlerC4536g, j10);
        } else {
            m69711d0(str, handlerC4536g);
        }
        m69700W(str, "deviceDetailResult", "deviceDetailBusiness", str2, String.valueOf(findNetworkResult.getRespCode()), null);
    }

    /* renamed from: O */
    public static /* synthetic */ void m69692O(String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g, Exception exc) {
        C13981a.m83988e("FindNetworkUtil", "queryLocalDeviceCap fail");
        m69711d0(str, handlerC4536g);
    }

    /* renamed from: Q */
    public static /* synthetic */ void m69694Q(final Context context, FindNetworkResult findNetworkResult) {
        if (findNetworkResult == null) {
            C13981a.m83988e("FindNetworkUtil", "startScanAncillaryDevice result is null");
            f54157d.keySet().forEach(new Consumer() { // from class: nf.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C11690w.m69715f0((String) obj, -1, null, context);
                }
            });
            m69743x();
            return;
        }
        String str = ((FindNetworkScanResult) findNetworkResult.getData()).getmSN();
        FindNetworkScanResult findNetworkScanResult = (FindNetworkScanResult) findNetworkResult.getData();
        int i10 = findNetworkScanResult.getmStatus();
        String standbyDevice = findNetworkScanResult.getStandbyDevice();
        C13981a.m83989i("FindNetworkUtil", "startScanAncillaryDevice onUpdate：" + C9120m0.m57351R(str) + " status: " + i10);
        if (i10 == 1) {
            f54156c.put(str, findNetworkScanResult);
            Map<String, C13779d> map = f54157d;
            if (map.containsKey(str)) {
                map.remove(str).m82723X0(findNetworkScanResult);
            }
        } else {
            f54156c.remove(str);
        }
        m69715f0(str, i10, standbyDevice, context);
    }

    /* renamed from: R */
    public static /* synthetic */ Task m69695R(Context context, String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).startSound(str, true, new a(handlerC4536g));
    }

    /* renamed from: S */
    public static /* synthetic */ void m69696S(Exception exc) {
        C13981a.m83988e("FindNetworkUtil", "startSound error：" + exc.getMessage());
    }

    /* renamed from: T */
    public static /* synthetic */ Task m69697T(Context context, String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).stopSound(str, true, new b(handlerC4536g));
    }

    /* renamed from: U */
    public static /* synthetic */ void m69698U(Exception exc) {
        C13981a.m83988e("FindNetworkUtil", "stopSound error：" + exc.getMessage());
    }

    /* renamed from: V */
    public static void m69699V(WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C12515a.m75110o().m75172d(new c(handlerC4536g));
    }

    /* renamed from: W */
    public static void m69700W(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        try {
            Context contextM74301m = C12347f.m74285n().m74301m();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("deviceId", C9120m0.m57351R(str));
            if (jSONObject != null) {
                linkedHashMap.put("info", jSONObject.toString());
            }
            new C12797b().m76785k(contextM74301m, "FindNetworkUtil", str5, str4, "", str2, "", str3, true, linkedHashMap);
            UBAAnalyze.m29963X("CKP", str2, "1", str3, jSONObject);
            if (jSONObject != null) {
                jSONObject.put("operationType", str2);
                jSONObject.put(C5807k0.f25949l, str3);
                jSONObject.put("deviceId", C9120m0.m57351R(str));
            }
            C13222a.m79461c(contextM74301m, jSONObject);
        } catch (Exception unused) {
            C13981a.m83988e("FindNetworkUtil", "operationEventReport exception");
        }
    }

    /* renamed from: X */
    public static void m69701X(String str, DeviceDetail deviceDetail, String str2, WapFindPhoneActivity.HandlerC4536g handlerC4536g, long j10) {
        C13981a.m83989i("FindNetworkUtil", "parseDeviceCapabilities, deviceId: " + C9120m0.m57351R(str));
        if (deviceDetail == null) {
            C13981a.m83988e("FindNetworkUtil", "parseDeviceCapabilities detail is null");
            m69711d0(str, handlerC4536g);
            return;
        }
        try {
            boolean zM69678A = m69678A(new JSONObject(str2), DeviceDetail.CAP_KEY_LOST_NEAR_LINK_NAVIGATION);
            String accessoryCapabilities = deviceDetail.getAccessoryCapabilities();
            JSONObject jSONObject = new JSONObject(accessoryCapabilities);
            boolean zM69678A2 = m69678A(jSONObject, DeviceDetail.CAP_KEY_LOST_NEAR_LINK_NAVIGATION);
            String str3 = "parseDeviceCapabilities, localCapabilities: " + str2 + ", remoteCapabilities: " + accessoryCapabilities + ", locNearLinkSwitch: on, locBluetoothSwitch: on";
            C13981a.m83989i("FindNetworkUtil", str3);
            if (zM69678A && zM69678A2) {
                String str4 = "nearLinkTime: " + (System.currentTimeMillis() - j10);
                C13981a.m83989i("FindNetworkUtil", "");
                m69700W(str, "deviceDetailResult", "deviceDetailBusiness", str4, "0", null);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{\\\"deviceId\\\":\\\"");
            sb2.append(str);
            sb2.append("\\\",\\\"bluetoothSwitch\\\":\\\"");
            sb2.append("on");
            sb2.append("\\\",\\\"nearLinkSwitch\\\":\\\"");
            sb2.append("on");
            sb2.append("\\\",\\\"capability\\\":{\\\"blue\\\":");
            sb2.append(m69678A(jSONObject, DeviceDetail.CAP_KEY_BLE_MEASURE_DISTANCE));
            sb2.append(",\\\"navi\\\":");
            sb2.append(m69678A(jSONObject, DeviceDetail.CAP_KEY_ULTRA_SOUND));
            sb2.append(",\\\"nearLink\\\":");
            sb2.append(zM69678A && zM69678A2);
            sb2.append(",\\\"bell\\\":");
            sb2.append(m69678A(jSONObject, DeviceDetail.CAP_KEY_RING));
            sb2.append(",\\\"ultraSound\\\":");
            sb2.append(m69678A(jSONObject, DeviceDetail.CAP_KEY_ULTRA_SOUND));
            sb2.append("}}");
            String string = sb2.toString();
            C11464r.m68569b(m69678A(jSONObject, DeviceDetail.CAP_KEY_RING));
            C13981a.m83989i("FindNetworkUtil", "parseDeviceCapabilities, Ring: " + m69678A(jSONObject, DeviceDetail.CAP_KEY_RING));
            m69719h0(handlerC4536g, string);
            m69700W(str, "deviceDetailResult", "deviceDetailBusiness", str3, "0", null);
        } catch (Exception e10) {
            C13981a.m83988e("FindNetworkUtil", "parseDeviceCapabilities e:" + e10.getMessage());
            m69711d0(str, handlerC4536g);
        }
    }

    /* renamed from: Y */
    public static void m69702Y(boolean z10, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        String str = "{\\\"capability\\\":{\\\"nearLink\\\":" + z10 + ",\\\"bluetooth\\\":true},\\\"localSwitch\\\":{\\\"nearLink\\\":" + C13168a.m79185n() + ",\\\"bluetooth\\\":" + C13168a.m79182k() + "}}";
        C13981a.m83989i("FindNetworkUtil", "parseLocalSwitchState, switchStateResult: " + str);
        if (handlerC4536g != null) {
            Message message = new Message();
            message.what = 1017;
            Bundle bundle = new Bundle();
            bundle.putString(RouterEventReceiver.KEY_PARAMS, str);
            message.obj = bundle;
            handlerC4536g.handleMessage(message);
        }
    }

    /* renamed from: Z */
    public static void m69703Z(final Consumer<Boolean> consumer) {
        final int nearLinkWakeUpDuration;
        C13981a.m83989i("FindNetworkUtil", "pullUpFindNetwork");
        final Context contextM74301m = C12347f.m74285n().m74301m();
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            nearLinkWakeUpDuration = hiCloudSysParamMapM60757p.getNearLinkWakeUpDuration();
        } else {
            C13981a.m83989i("FindNetworkUtil", "pullUpFindNetwork has default");
            nearLinkWakeUpDuration = ErrorCode.ERROR_REWARD_AD_NO;
        }
        C13981a.m83989i("FindNetworkUtil", "pullUpFindNetwork time: " + (nearLinkWakeUpDuration / 60));
        C0225l.m1577a(new InterfaceC14356c() { // from class: nf.f
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C11690w.m69682E(contextM74301m, nearLinkWakeUpDuration, consumer);
            }
        }, new Consumer() { // from class: nf.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C11690w.m69683F(consumer, (Exception) obj);
            }
        });
    }

    /* renamed from: a0 */
    public static void m69705a0(final WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        try {
            Context contextM74301m = C12347f.m74285n().m74301m();
            String strM80950o = C13452e.m80781L().m80950o();
            C13981a.m83989i("FindNetworkUtil", "queryCurrentDeviceDetail, localDeviceId: " + C9120m0.m57351R(strM80950o));
            FindNetwork.getFindNetworkEngine(contextM74301m).queryDeviceDetail(strM80950o).addOnSuccessListener(new InterfaceC8939g() { // from class: nf.c
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    C11690w.m69684G(handlerC4536g, (FindNetworkResult) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: nf.n
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C11690w.m69685H(handlerC4536g, exc);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("FindNetworkUtil", "queryCurrentDeviceDetail Exception: " + e10.getMessage());
            m69702Y(false, handlerC4536g);
        }
    }

    /* renamed from: b0 */
    public static void m69707b0(final Context context, final String str, final WapFindPhoneActivity.HandlerC4536g handlerC4536g, final long j10) {
        C13981a.m83989i("FindNetworkUtil", "queryDeviceCap start");
        C0225l.m1577a(new InterfaceC14356c() { // from class: nf.v
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C11690w.m69688K(context, str, j10, handlerC4536g);
            }
        }, new Consumer() { // from class: nf.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C11690w.m69689L((Exception) obj);
            }
        });
    }

    /* renamed from: c0 */
    public static void m69709c0(final Context context, final String str, final WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("FindNetworkUtil", "queryDeviceDetail, deviceId: " + C9120m0.m57351R(str));
        final long jCurrentTimeMillis = System.currentTimeMillis();
        C13442i.m80758j().m80763h(str, null, new Consumer() { // from class: nf.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C11690w.m69690M(jCurrentTimeMillis, str, context, handlerC4536g, (Integer) obj);
            }
        });
    }

    /* renamed from: d0 */
    public static void m69711d0(String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("FindNetworkUtil", "queryDeviceDetailFail");
        m69719h0(handlerC4536g, "{\\\"deviceId\\\":\\\"" + str + "\\\",\\\"bluetoothSwitch\\\":\\\"on\\\",\\\"nearLinkSwitch\\\":\\\"on\\\",\\\"capability\\\":{\\\"blue\\\":false,\\\"navi\\\":false,\\\"nearLink\\\":false,\\\"bell\\\":false}}");
        m69700W(str, "deviceDetailResult", "deviceDetailBusiness", "queryDeviceDetailFail", "-1", null);
    }

    /* renamed from: e0 */
    public static void m69713e0(Context context, final String str, final DeviceDetail deviceDetail, final WapFindPhoneActivity.HandlerC4536g handlerC4536g, final long j10) {
        try {
            String strM80950o = C13452e.m80781L().m80950o();
            C13981a.m83989i("FindNetworkUtil", "queryLocalDeviceCap, deviceId: " + C9120m0.m57351R(str) + ", localDeviceId: " + C9120m0.m57351R(strM80950o));
            FindNetwork.getFindNetworkEngine(context).queryDeviceDetail(strM80950o).addOnSuccessListener(new InterfaceC8939g() { // from class: nf.l
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    C11690w.m69691N(j10, str, deviceDetail, handlerC4536g, (FindNetworkResult) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: nf.m
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C11690w.m69692O(str, handlerC4536g, exc);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("FindNetworkUtil", "queryLocalDeviceCap Exception: " + e10.getMessage());
            m69711d0(str, handlerC4536g);
        }
    }

    /* renamed from: f0 */
    public static void m69715f0(String str, int i10, String str2, Context context) {
        C13981a.m83989i("FindNetworkUtil", "sendBroadcastToPortal: " + C9120m0.m57351R(str) + " ,status: " + i10);
        Intent intent = new Intent("com.huawei.hidisk.remotecontrol.intent.TAG_FASTSCAN_RESULT");
        intent.putExtra("exeResult", i10);
        intent.putExtra("tagSn", str);
        if (str2 != null) {
            intent.putExtra("standbyDevice", str2);
        }
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: g0 */
    public static void m69717g0(String str, int i10, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        if (handlerC4536g != null) {
            Message message = new Message();
            message.what = FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED;
            Bundle bundle = new Bundle();
            bundle.putString("deviceId", str);
            bundle.putInt(RouterEventReceiver.KEY_PARAMS, i10);
            message.obj = bundle;
            handlerC4536g.handleMessage(message);
        }
    }

    /* renamed from: h0 */
    public static void m69719h0(WapFindPhoneActivity.HandlerC4536g handlerC4536g, String str) {
        if (handlerC4536g != null) {
            C13981a.m83989i("FindNetworkUtil", "sendMsgDeviceCapabilityDetail");
            Message message = new Message();
            message.what = FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED;
            Bundle bundle = new Bundle();
            bundle.putString(RouterEventReceiver.KEY_PARAMS, str);
            message.obj = bundle;
            handlerC4536g.handleMessage(message);
        }
    }

    /* renamed from: i0 */
    public static void m69721i0(WapFindPhoneActivity.HandlerC4536g handlerC4536g, int i10) {
        if (handlerC4536g != null) {
            Message message = new Message();
            message.what = FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH;
            Bundle bundle = new Bundle();
            bundle.putInt(RouterEventReceiver.KEY_PARAMS, i10);
            message.obj = bundle;
            handlerC4536g.handleMessage(message);
        }
    }

    /* renamed from: j0 */
    public static void m69723j0(WapFindPhoneActivity.HandlerC4536g handlerC4536g, int i10) {
        if (handlerC4536g != null) {
            Message message = new Message();
            message.what = FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH;
            Bundle bundle = new Bundle();
            bundle.putInt(RouterEventReceiver.KEY_PARAMS, i10);
            message.obj = bundle;
            handlerC4536g.handleMessage(message);
        }
    }

    /* renamed from: k0 */
    public static void m69725k0(String str, boolean z10) {
        C13981a.m83989i("FindNetworkUtil", "setAncDeviceSoundStatus, deviceId: " + C9120m0.m57351R(str) + ", soundStatus: " + z10);
        f54158e = str;
        f54159f = z10;
    }

    /* renamed from: l0 */
    public static void m69727l0(String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("FindNetworkUtil", "startFastDiscovery, deviceId: " + C9120m0.m57351R(str));
        C13435b.m80741e().m80743g(null, handlerC4536g);
    }

    /* renamed from: m0 */
    public static void m69729m0(final Context context, String str, C13779d c13779d) {
        C13981a.m83989i("FindNetworkUtil", "startScanAncillaryDevice tagSn: " + C9120m0.m57351R(str));
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f54155b > 300000) {
            f54155b = jCurrentTimeMillis;
            f54156c.clear();
        }
        if (jCurrentTimeMillis - f54154a > 60000) {
            m69743x();
            f54157d.put(str, c13779d);
            f54154a = jCurrentTimeMillis;
            C13435b.m80741e().m80743g(new Consumer() { // from class: nf.o
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C11690w.m69694Q(context, (FindNetworkResult) obj);
                }
            }, null);
            return;
        }
        Map<String, FindNetworkScanResult> map = f54156c;
        if (map.containsKey(str)) {
            C13981a.m83989i("FindNetworkUtil", "startScan hit cache");
            c13779d.m82723X0(map.get(str));
        } else {
            C13981a.m83989i("FindNetworkUtil", "startScan wait");
            f54157d.put(str, c13779d);
        }
    }

    /* renamed from: n0 */
    public static void m69731n0(final Context context, final String str, final WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("FindNetworkUtil", "to startSound");
        C0225l.m1577a(new InterfaceC14356c() { // from class: nf.s
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C11690w.m69695R(context, str, handlerC4536g);
            }
        }, new Consumer() { // from class: nf.t
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C11690w.m69696S((Exception) obj);
            }
        });
    }

    /* renamed from: o0 */
    public static void m69733o0(final Context context, final String str, final WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("FindNetworkUtil", "to stopSound");
        C0225l.m1577a(new InterfaceC14356c() { // from class: nf.p
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C11690w.m69697T(context, str, handlerC4536g);
            }
        }, new Consumer() { // from class: nf.q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C11690w.m69698U((Exception) obj);
            }
        });
    }

    /* renamed from: p0 */
    public static void m69735p0(Context context, String str) {
        C13981a.m83989i("FindNetworkUtil", "updateLongConnection, deviceId: " + C9120m0.m57351R(str));
        C13442i.m80758j().m80767q(context, str);
    }

    /* renamed from: w */
    public static boolean m69742w(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, f54158e)) {
            f54158e = "";
            f54159f = false;
            return false;
        }
        boolean z10 = f54159f;
        C13981a.m83989i("FindNetworkUtil", "checkAncDeviceSoundStatus, deviceId: " + C9120m0.m57351R(str) + ", status: " + z10);
        f54158e = "";
        f54159f = false;
        return z10;
    }

    /* renamed from: x */
    public static void m69743x() {
        C13981a.m83989i("FindNetworkUtil", CloudBackupConstant.REPORT_TYPE_BASE_CLEAR_CACHE);
        f54154a = 0L;
    }

    /* renamed from: y */
    public static void m69744y(String str) {
        f54156c.remove(str);
    }

    /* renamed from: z */
    public static void m69745z(final String str, final WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("FindNetworkUtil", "createLongConnect, deviceId: " + C9120m0.m57351R(str));
        C13442i.m80758j().m80763h(str, new Consumer() { // from class: nf.r
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C11690w.m69679B(str, handlerC4536g, (Integer) obj);
            }
        }, null);
    }
}
