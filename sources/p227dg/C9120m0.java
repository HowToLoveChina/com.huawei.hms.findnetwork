package p227dg;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.remotecontrol.bluetooth.locate.AncillaryDeviceLocationInfo;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.android.remotecontrol.offlinelocate.C4376k;
import com.huawei.android.remotecontrol.offlinelocate.bean.OfflineLocateInfo;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.tag.bean.AncDeviceLocationBean;
import com.huawei.android.remotecontrol.tag.bean.TagOperationResult;
import com.huawei.fastengine.fastview.RouterEventReceiver;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.FindNetworkEngine;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceOtaProgress;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceOtaTargetVersion;
import com.huawei.hms.findnetwork.comm.request.bean.DisConnectLocation;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectNotificationParams;
import com.huawei.hms.findnetwork.comm.request.bean.MultiTerminalDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.bean.PairedDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.bean.TagStatus;
import com.huawei.hms.findnetwork.comm.request.bean.wear.OfflineLocationBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.option.OfflineBroadcastParam;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkScanResult;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import eg.AbstractC9472a;
import eg.AbstractC9478g;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import lt.InterfaceC11341a;
import mk.C11476b;
import mt.C11518e;
import mt.C11519f;
import mt.C11520g;
import mt.C11522i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0225l;
import p015ak.C0226l0;
import p015ak.C0227m;
import p015ak.C0241z;
import p208cq.InterfaceC8937e;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p227dg.C9120m0;
import p521og.C11880m;
import p521og.C11881n;
import p590qt.C12414v;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13222a;
import p684un.C13230i;
import p709vj.C13452e;
import p772xe.C13781f;
import p772xe.C13788m;
import p774xg.C13812b;
import p809yg.C13981a;
import p842zf.C14294b;
import p851zp.InterfaceC14356c;
import sg.C12797b;
import ve.C13429u;
import ye.C13978y;

/* renamed from: dg.m0 */
/* loaded from: classes4.dex */
public class C9120m0 {

    /* renamed from: a */
    public static boolean f45892a = true;

    /* renamed from: b */
    public static AlertDialog.Builder f45893b;

    /* renamed from: c */
    public static AlertDialog f45894c;

    /* renamed from: d */
    public static final ReentrantLock f45895d = new ReentrantLock();

    /* renamed from: dg.m0$a */
    public class a extends AbstractC9472a {

        /* renamed from: a */
        public final /* synthetic */ String f45896a;

        /* renamed from: b */
        public final /* synthetic */ String f45897b;

        /* renamed from: c */
        public final /* synthetic */ Context f45898c;

        /* renamed from: d */
        public final /* synthetic */ String f45899d;

        public a(String str, String str2, Context context, String str3) {
            this.f45896a = str;
            this.f45897b = str2;
            this.f45898c = context;
            this.f45899d = str3;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12797b c12797b;
            C9120m0.f45895d.lock();
            HashMap map = new HashMap();
            try {
                try {
                    C13981a.m83989i("TagUtil", "setDevicesPublicKeyToFn, device: " + C9120m0.m57351R(this.f45896a));
                    c12797b = new C12797b();
                } catch (Exception e10) {
                    C13981a.m83988e("TagUtil", "setDevicesPublicKeyToFn exception: " + e10.getMessage());
                }
                if (TextUtils.isEmpty(this.f45897b)) {
                    C13981a.m83988e("TagUtil", "setDevicesPublicKeyToFn offlinePrivateKey is empty");
                    c12797b.m76784j(this.f45898c, "TagUtil", "", "setDevicesPublicKeyToFn offlinePrivateKey is empty", "", "call_set_public_key", "", "call_set_public_key", true);
                    return;
                }
                List<OfflineBroadcastParam> listM26433i = C4376k.m26433i(this.f45898c, this.f45897b, this.f45896a, this.f45899d, "FindPhoneDevicesKey" + this.f45896a);
                if (listM26433i.isEmpty()) {
                    C13981a.m83988e("TagUtil", "setDevicesPublicKeyToFn offlinePk is empty");
                    c12797b.m76784j(this.f45898c, "TagUtil", "", "setDevicesPublicKeyToFn offlinePk is empty", "", "call_set_public_key", "", "call_set_public_key", true);
                }
                map.put(this.f45896a, listM26433i);
                FindNetwork.getFindNetworkEngine(this.f45898c).setDevicePublicKeys(map);
                c12797b.m76784j(this.f45898c, "TagUtil", "", "setDevicesPublicKeyToFn offlinePk success", "", "call_set_public_key", "", "call_set_public_key", true);
            } finally {
                C13981a.m83989i("TagUtil", "setDevicesPublicKeyToFn unlock");
                C9120m0.f45895d.unlock();
            }
        }
    }

    /* renamed from: dg.m0$b */
    public class b extends FindNetworkCallback<TagStatus> {

        /* renamed from: b */
        public final /* synthetic */ TagStatus[] f45900b;

        /* renamed from: c */
        public final /* synthetic */ CountDownLatch f45901c;

        public b(TagStatus[] tagStatusArr, CountDownLatch countDownLatch) {
            this.f45900b = tagStatusArr;
            this.f45901c = countDownLatch;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<TagStatus> findNetworkResult) {
            super.onFail(findNetworkResult);
            C13981a.m83988e("TagUtil", "checkTagStatus onFail");
            this.f45901c.countDown();
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<TagStatus> findNetworkResult) {
            super.onSuccess(findNetworkResult);
            if (findNetworkResult == null) {
                C13981a.m83988e("TagUtil", "checkTagStatus onSuccess the result is null");
            } else {
                this.f45900b[0] = findNetworkResult.getData();
            }
            this.f45901c.countDown();
        }
    }

    /* renamed from: dg.m0$c */
    public class c extends FindNetworkCallback<DeviceOtaTargetVersion> {

        /* renamed from: b */
        public final /* synthetic */ String f45902b;

        public c(String str) {
            this.f45902b = str;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<DeviceOtaTargetVersion> findNetworkResult) {
            C13981a.m83989i("TagUtil", "checkTagOtaVersion onFail");
            if (findNetworkResult == null) {
                C13981a.m83988e("TagUtil", "checkTagOtaVersion result is null");
            } else {
                C9120m0.m57358U0(this.f45902b, "checkOtaVersion", findNetworkResult);
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<DeviceOtaTargetVersion> findNetworkResult) {
            C13981a.m83989i("TagUtil", "checkTagOtaVersion onSuccess");
            if (findNetworkResult == null || findNetworkResult.getData() == null) {
                C13981a.m83988e("TagUtil", "checkTagOtaVersion result is null");
            } else {
                C9120m0.m57358U0(findNetworkResult.getData().getSn(), "checkOtaVersion", findNetworkResult);
            }
        }
    }

    /* renamed from: dg.m0$d */
    public class d extends FindNetworkCallback<DeviceOtaProgress> {

        /* renamed from: b */
        public final /* synthetic */ String f45903b;

        public d(String str) {
            this.f45903b = str;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<DeviceOtaProgress> findNetworkResult) {
            C13981a.m83989i("TagUtil", "startTagOtaVersion onFail");
            if (findNetworkResult == null) {
                C13981a.m83988e("TagUtil", "startTagOtaVersion result is null");
                return;
            }
            DeviceOtaProgress deviceOtaProgress = new DeviceOtaProgress();
            deviceOtaProgress.setProgress(-1);
            if (findNetworkResult.getData() != null && !TextUtils.isEmpty(findNetworkResult.getData().getSn())) {
                deviceOtaProgress.setSn(findNetworkResult.getData().getSn());
            }
            findNetworkResult.setData(deviceOtaProgress);
            C9120m0.m57358U0(this.f45903b, "startOtaUpgrade", findNetworkResult);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<DeviceOtaProgress> findNetworkResult) {
            C13981a.m83989i("TagUtil", "startTagOtaVersion onSuccess");
            if (findNetworkResult == null || findNetworkResult.getData() == null) {
                C13981a.m83988e("TagUtil", "startTagOtaVersion result is null");
            } else {
                C9120m0.m57358U0(findNetworkResult.getData().getSn(), "startOtaUpgrade", findNetworkResult);
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onUpdate(FindNetworkResult<DeviceOtaProgress> findNetworkResult) {
            C13981a.m83989i("TagUtil", "startTagOtaVersion onUpdate");
            if (findNetworkResult == null || findNetworkResult.getData() == null) {
                C13981a.m83988e("TagUtil", "startTagOtaVersion result is null");
            } else {
                C9120m0.m57358U0(findNetworkResult.getData().getSn(), "startOtaUpgrade", findNetworkResult);
            }
        }
    }

    /* renamed from: dg.m0$e */
    public class e extends FindNetworkCallback<Void> {

        /* renamed from: b */
        public final /* synthetic */ Consumer f45904b;

        public e(Consumer consumer) {
            this.f45904b = consumer;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<Void> findNetworkResult) {
            C13981a.m83989i("TagUtil", "enableGoodsDisconnectNotifyEnhanced onFail");
            if (findNetworkResult == null) {
                C13981a.m83989i("TagUtil", "enableGoodsDisconnectNotifyEnhanced result is null");
            } else {
                this.f45904b.accept(findNetworkResult);
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<Void> findNetworkResult) {
            C13981a.m83989i("TagUtil", "enableGoodsDisconnectNotifyEnhanced onSuccess");
            if (findNetworkResult == null) {
                C13981a.m83989i("TagUtil", "enableGoodsDisconnectNotifyEnhanced result is null");
            } else {
                this.f45904b.accept(findNetworkResult);
            }
        }
    }

    /* renamed from: dg.m0$f */
    public class f extends FindNetworkCallback<DisConnectLocation> {

        /* renamed from: b */
        public final /* synthetic */ String f45905b;

        /* renamed from: c */
        public final /* synthetic */ Context f45906c;

        public f(String str, Context context) {
            this.f45905b = str;
            this.f45906c = context;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<DisConnectLocation> findNetworkResult) {
            super.onFail(findNetworkResult);
            C13981a.m83988e("TagUtil", "queryTagDisconnectLocation fail: " + findNetworkResult.getRespCode());
            AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = new AncillaryDeviceLocationInfo();
            ancillaryDeviceLocationInfo.setConnectType(C0241z.m1685c("0"));
            ancillaryDeviceLocationInfo.setOperationType("perDeviceDiscLocate");
            C13781f c13781f = new C13781f(findNetworkResult.getRespCode(), 0L, this.f45905b, "0", "3", this.f45906c, ancillaryDeviceLocationInfo, C12797b.m76774a("01019"), null, null);
            c13781f.m82749q().m85164h("queryTagDisconnectLocation");
            c13781f.m82740h();
            C9120m0.m57380d1(this.f45906c, "QueryDisconnectLocation fail", this.f45905b, null, 0);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<DisConnectLocation> findNetworkResult) {
            super.onSuccess(findNetworkResult);
            DisConnectLocation data = findNetworkResult.getData();
            String standbyInfo = data.getStandbyInfo();
            C13981a.m83989i("TagUtil", "onDisconnectLocateUpdate time: " + data.getLocationTime() + ", standByDevice: " + C9120m0.m57355T(standbyInfo) + ", indoor:" + data.getIndoor() + ", " + data.getFloorAcc());
            AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = new AncillaryDeviceLocationInfo();
            ancillaryDeviceLocationInfo.setAccuracy(data.getAccuracy());
            ancillaryDeviceLocationInfo.setConnectType(C0241z.m1685c("0"));
            ancillaryDeviceLocationInfo.setLatitude(data.getLatitude());
            ancillaryDeviceLocationInfo.setLongitude(data.getLongitude());
            ancillaryDeviceLocationInfo.setFloor(C13812b.m82830a(data));
            ancillaryDeviceLocationInfo.setType(0);
            ancillaryDeviceLocationInfo.setTime(data.getLocationTime() + C11881n.m71358h());
            ancillaryDeviceLocationInfo.setOperationType("perDeviceDiscLocate");
            ancillaryDeviceLocationInfo.setStandbyDevice(standbyInfo);
            C13781f c13781f = new C13781f(0, data.getLocationTime(), this.f45905b, "0", "3", this.f45906c, ancillaryDeviceLocationInfo, C12797b.m76774a("01019"), null, null);
            c13781f.m82749q().m85164h("queryTagDisconnectLocation");
            c13781f.m82740h();
            C9120m0.m57380d1(this.f45906c, "QueryDisconnectLocation success, floor: " + ancillaryDeviceLocationInfo.getFloor() + ", disconnectTime: " + data.getLocationTime(), this.f45905b, null, 0);
        }
    }

    /* renamed from: dg.m0$g */
    public class g extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f45907a;

        /* renamed from: b */
        public final /* synthetic */ String f45908b;

        /* renamed from: c */
        public final /* synthetic */ FindNetworkResult f45909c;

        /* renamed from: d */
        public final /* synthetic */ WapFindPhoneActivity.HandlerC4536g f45910d;

        public g(Context context, String str, FindNetworkResult findNetworkResult, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
            this.f45907a = context;
            this.f45908b = str;
            this.f45909c = findNetworkResult;
            this.f45910d = handlerC4536g;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C13981a.m83989i("TagUtil", "queryOfflineLocation success");
            Message message = new Message();
            message.what = 1007;
            ArrayList arrayList = new ArrayList();
            String strM57362W0 = C9120m0.m57362W0(this.f45907a, this.f45908b, (OfflineLocationBean) this.f45909c.getData());
            if (TextUtils.isEmpty(strM57362W0)) {
                C13981a.m83988e("TagUtil", "queryOfflineLocation offlineLocation empty");
                return;
            }
            arrayList.add(strM57362W0);
            Bundle bundle = new Bundle();
            bundle.putString("keyUrl", String.valueOf(arrayList));
            bundle.putString("TagSN", this.f45908b);
            message.obj = bundle;
            this.f45910d.handleMessage(message);
        }
    }

    /* renamed from: dg.m0$h */
    public class h extends FindNetworkCallback<List<OfflineLocationBean>> {

        /* renamed from: b */
        public final /* synthetic */ Context f45911b;

        /* renamed from: c */
        public final /* synthetic */ WapFindPhoneActivity.HandlerC4536g f45912c;

        public h(Context context, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
            this.f45911b = context;
            this.f45912c = handlerC4536g;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<List<OfflineLocationBean>> findNetworkResult) {
            C13981a.m83989i("TagUtil", "batchQueryOfflineLocation onFail");
            C9120m0.m57380d1(this.f45911b, "batchQueryOfflineLocation onFailure", "", null, -1);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<List<OfflineLocationBean>> findNetworkResult) {
            C13981a.m83989i("TagUtil", "batchQueryOfflineLocation onSuccess");
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onUpdate(FindNetworkResult<List<OfflineLocationBean>> findNetworkResult) {
            try {
                if (findNetworkResult.getData() == null) {
                    C13981a.m83988e("TagUtil", "batchQueryOfflineLocation onUpdate getData null");
                    return;
                }
                C13981a.m83989i("TagUtil", "batchQueryOfflineLocation onUpdate");
                Message message = new Message();
                message.what = FamilyShareConstants.StatusCode.USER_JOIN_IS_FROZEN;
                Bundle bundle = new Bundle();
                bundle.putString("keyUrl", C9120m0.m57391h0(this.f45911b, findNetworkResult.getData()));
                message.obj = bundle;
                this.f45912c.handleMessage(message);
            } catch (Exception e10) {
                C13981a.m83988e("TagUtil", "batchQueryOfflineLocation onUpdate Exception: " + e10.getMessage());
            }
        }
    }

    /* renamed from: dg.m0$i */
    public class i extends FindNetworkCallback<FindNetworkScanResult> {

        /* renamed from: b */
        public final /* synthetic */ String f45913b;

        /* renamed from: c */
        public final /* synthetic */ Context f45914c;

        /* renamed from: d */
        public final /* synthetic */ Handler f45915d;

        /* renamed from: e */
        public final /* synthetic */ Timer f45916e;

        public i(String str, Context context, Handler handler, Timer timer) {
            this.f45913b = str;
            this.f45914c = context;
            this.f45915d = handler;
            this.f45916e = timer;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<FindNetworkScanResult> findNetworkResult) {
            C13981a.m83988e("TagUtil", "isDeviceStandStatus fastScan fail: " + findNetworkResult.getRespCode());
            C9120m0.m57398j1(this.f45915d, null);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onUpdate(FindNetworkResult<FindNetworkScanResult> findNetworkResult) {
            String str = findNetworkResult.getData().getmSN();
            FindNetworkScanResult data = findNetworkResult.getData();
            int i10 = data.getmStatus();
            String standbyDevice = data.getStandbyDevice();
            C13981a.m83989i("TagUtil", "isDeviceStandStatus fastScan onUpdate：" + C9120m0.m57351R(str) + " status: " + i10 + ", standByDevice: " + C9120m0.m57355T(standbyDevice));
            if (i10 == 1 && C9120m0.m57394i0(this.f45913b, standbyDevice) && C9120m0.f45892a) {
                C9120m0.m57410n1(this.f45914c, this.f45915d);
                boolean unused = C9120m0.f45892a = false;
                this.f45916e.cancel();
            }
        }
    }

    /* renamed from: dg.m0$j */
    public class j implements InterfaceC11341a.a {
        @Override // lt.InterfaceC11341a.a
        /* renamed from: a */
        public void mo57439a(String str, String str2) {
            C13981a.m83988e("TagUtil", "tag: " + str + ", msg:" + str2);
        }

        @Override // lt.InterfaceC11341a.a
        /* renamed from: b */
        public void mo57440b(String str, String str2) {
            C13981a.m83990w("TagUtil", "tag: " + str + ", msg:" + str2);
        }

        @Override // lt.InterfaceC11341a.a
        /* renamed from: c */
        public void mo57441c(String str, String str2) {
            C13981a.m83989i("TagUtil", "tag: " + str + ", msg:" + str2);
        }
    }

    /* renamed from: dg.m0$k */
    public static class k implements Handler.Callback {

        /* renamed from: a */
        public final Context f45917a;

        /* renamed from: b */
        public final int f45918b;

        public /* synthetic */ k(Context context, int i10, b bVar) {
            this(context, i10);
        }

        /* renamed from: d */
        public static /* synthetic */ void m57443d(FindNetworkResult findNetworkResult) {
            C13981a.m83989i("TagUtil", "enableGoodsDisconnectNotifyEnhanced result = " + findNetworkResult.getRespCode());
        }

        /* renamed from: b */
        public void m57444b(Message message) {
            C13981a.m83989i("TagUtil", "handleHttpCallbackMsg");
            if (this.f45918b == 3080) {
                m57445c(message);
            }
        }

        /* renamed from: c */
        public final void m57445c(Message message) {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("TagUtil", "handleQueryAncDeviceInfo result:" + iM1685c);
            C12797b c12797b = new C12797b();
            if (200 != iM1685c) {
                C13981a.m83988e("TagUtil", "handleQueryAncDeviceInfo error=" + iM1685c);
                c12797b.m76784j(this.f45917a, "TagUtil", "001_3003", "handleQueryAncDeviceInfo error,result:" + iM1685c, null, "01020", null, "query_ancDeviceInfo", true);
                return;
            }
            String string = message.getData().getString("response_info");
            int iM26233d = C4347e.m26233d(string);
            if (iM26233d == 0) {
                C13981a.m83989i("TagUtil", "handleQueryAncDeviceInfo report success");
                m57446e(string);
                c12797b.m76784j(this.f45917a, "TagUtil", "0", "handleQueryAncDeviceInfo success", null, "01020", null, "query_ancDeviceInfo", true);
            } else {
                C13981a.m83989i("TagUtil", "handleQueryAncDeviceInfo report fail");
                c12797b.m76784j(this.f45917a, "TagUtil", "001_3004", "handleQueryAncDeviceInfo fail,resultCode:" + iM26233d, null, "01020", null, "query_ancDeviceInfo", true);
            }
        }

        /* renamed from: e */
        public final void m57446e(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("perDeviceList")) {
                    C13981a.m83988e("TagUtil", "handleQueryAncDeviceInfo json has no perDeviceList");
                    return;
                }
                JSONArray jSONArray = (JSONArray) jSONObject.get("perDeviceList");
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        m57447f(jSONArray.getJSONObject(i10));
                    }
                }
            } catch (Exception unused) {
                C13981a.m83988e("TagUtil", "handleQueryAncDeviceInfo JSONException");
            }
        }

        /* renamed from: f */
        public final void m57447f(JSONObject jSONObject) {
            C13981a.m83989i("TagUtil", "onHandleQueryAncDeviceSuccess2");
            try {
                String string = jSONObject.has("deviceID") ? jSONObject.getString("deviceID") : "";
                boolean z10 = jSONObject.has("offlineNotifyEnable") ? jSONObject.getBoolean("offlineNotifyEnable") : false;
                boolean z11 = jSONObject.has("disconnectSwitchEnable") ? jSONObject.getBoolean("disconnectSwitchEnable") : false;
                boolean z12 = jSONObject.has("turboEnable") ? jSONObject.getBoolean("turboEnable") : false;
                if (z10) {
                    C9120m0.m57365Y(this.f45917a, string, "", true);
                } else {
                    C13981a.m83989i("TagUtil", "handleQueryAncDeviceInfo offlineNotifyEnable false");
                }
                if (z11) {
                    C9120m0.m57367Z(this.f45917a, string, z12 ? 2 : 1, "", new Consumer() { // from class: dg.n0
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            C9120m0.k.m57443d((FindNetworkResult) obj);
                        }
                    });
                } else {
                    C13981a.m83989i("TagUtil", "handleQueryAncDeviceInfo disconnectSwitchEnable false");
                }
            } catch (Exception unused) {
                C13981a.m83988e("TagUtil", "handleQueryAncDeviceInfo JSONException");
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            m57444b(message);
            return true;
        }

        public k(Context context, int i10) {
            this.f45917a = context;
            this.f45918b = i10;
        }
    }

    /* renamed from: dg.m0$l */
    public static class l extends TimerTask {

        /* renamed from: a */
        public Handler f45919a;

        public l(Handler handler) {
            this.f45919a = handler;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C9120m0.m57398j1(this.f45919a, null);
        }
    }

    /* renamed from: A0 */
    public static /* synthetic */ void m57318A0(Exception exc) {
        C13981a.m83989i("TagUtil", "queryPairedDevicesFromFN fail. " + exc.getMessage());
    }

    /* renamed from: B0 */
    public static /* synthetic */ Task m57320B0(Context context, String str) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).queryDisconnectLocation(str, new f(str, context));
    }

    /* renamed from: D0 */
    public static /* synthetic */ void m57324D0(Context context, String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g, FindNetworkResult findNetworkResult) {
        C12515a.m75110o().m75172d(new g(context, str, findNetworkResult, handlerC4536g));
    }

    /* renamed from: E0 */
    public static /* synthetic */ void m57326E0(Context context, String str, Exception exc) {
        C13981a.m83988e("TagUtil", "queryOfflineLocation is fail");
        m57380d1(context, "QueryOfflineLocation onFailure", str, null, -1);
    }

    /* renamed from: F0 */
    public static /* synthetic */ void m57328F0(String str, FindNetworkResult findNetworkResult) {
        C13981a.m83989i("TagUtil", "queryTagSyncStatus success");
        if (findNetworkResult == null) {
            C13981a.m83988e("TagUtil", "queryTagSyncStatus result is null");
        } else {
            m57358U0(str, "queryTagSyncStatus", m57382e0(str, findNetworkResult));
        }
    }

    /* renamed from: G0 */
    public static /* synthetic */ void m57330G0(String str, Exception exc) {
        if (exc instanceof ApiException) {
            m57356T0(str, "queryTagSyncStatus", (ApiException) exc);
        }
        C13981a.m83988e("TagUtil", "queryTagSyncStatus fail, exception:" + exc.getMessage());
    }

    /* renamed from: H0 */
    public static /* synthetic */ Boolean m57332H0(Context context, final String str) throws Exception {
        FindNetwork.getFindNetworkEngine(context).queryDeviceListByAccount(str).addOnSuccessListener(new InterfaceC8939g() { // from class: dg.u
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                C9120m0.m57328F0(str, (FindNetworkResult) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: dg.v
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                C9120m0.m57330G0(str, exc);
            }
        });
        return Boolean.TRUE;
    }

    /* renamed from: I0 */
    public static /* synthetic */ void m57334I0(Exception exc) {
        C13981a.m83988e("TagUtil", "queryTagSyncStatus exception:" + exc.getMessage());
    }

    /* renamed from: J0 */
    public static /* synthetic */ Task m57336J0(Context context, String str, Handler handler, Timer timer) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).startFastScan(new i(str, context, handler, timer));
    }

    /* renamed from: K0 */
    public static /* synthetic */ void m57338K0(Exception exc) {
        C13981a.m83988e("TagUtil", "isDeviceStandStatus exception:" + exc.getMessage());
    }

    /* renamed from: L0 */
    public static /* synthetic */ void m57340L0(Handler handler, DialogInterface dialogInterface, int i10) {
        m57398j1(handler, "showDialog");
        dialogInterface.dismiss();
    }

    /* renamed from: N0 */
    public static /* synthetic */ Boolean m57344N0(Context context, String str) throws Exception {
        FindNetwork.getFindNetworkEngine(context).startOta(str, new d(str));
        return Boolean.TRUE;
    }

    /* renamed from: O0 */
    public static /* synthetic */ void m57346O0(Exception exc) {
        C13981a.m83988e("TagUtil", "startTagOtaVersion exception:" + exc.getMessage());
    }

    /* renamed from: P0 */
    public static /* synthetic */ void m57348P0(String str, FindNetworkResult findNetworkResult) {
        C13981a.m83989i("TagUtil", "syncCloudDeviceData success");
        if (findNetworkResult == null) {
            C13981a.m83988e("TagUtil", "syncCloudDeviceData result is null");
        } else {
            m57358U0(str, "syncCloudDeviceData", m57385f0(str, findNetworkResult));
        }
    }

    /* renamed from: Q0 */
    public static /* synthetic */ void m57350Q0(String str, Exception exc) {
        if (exc instanceof ApiException) {
            m57356T0(str, "syncCloudDeviceData", (ApiException) exc);
        }
        C13981a.m83988e("TagUtil", "syncCloudDeviceData exception:" + exc.getMessage());
    }

    /* renamed from: R */
    public static String m57351R(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("*******");
        if (str.length() >= 4) {
            str = str.substring(str.length() - 4);
        }
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: R0 */
    public static /* synthetic */ Boolean m57352R0(Context context, final String str) throws Exception {
        FindNetwork.getFindNetworkEngine(context).syncCloudDeviceData(str).addOnSuccessListener(new InterfaceC8939g() { // from class: dg.s
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                C9120m0.m57348P0(str, (FindNetworkResult) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: dg.t
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                C9120m0.m57350Q0(str, exc);
            }
        });
        return Boolean.TRUE;
    }

    /* renamed from: S */
    public static String m57353S(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject.has("deviceId")) {
                    jSONObjectOptJSONObject.put("deviceId", m57351R(jSONObjectOptJSONObject.getString("deviceId")));
                }
                if (jSONObjectOptJSONObject.has("deviceSn")) {
                    jSONObjectOptJSONObject.put("deviceSn", m57351R(jSONObjectOptJSONObject.getString("deviceSn")));
                }
                jSONArray.put(i10, jSONObjectOptJSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("TagUtil", "anonymousDeviceList, JSONException");
            return "";
        } catch (Exception unused2) {
            C13981a.m83988e("TagUtil", "anonymousDeviceList, Exception");
            return "";
        }
    }

    /* renamed from: S0 */
    public static /* synthetic */ void m57354S0(Exception exc) {
        C13981a.m83988e("TagUtil", "syncCloudDeviceData exception:" + exc.getMessage());
    }

    /* renamed from: T */
    public static String m57355T(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray(str.replace("\\\"", "\""));
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject.has("fid")) {
                    jSONObjectOptJSONObject.put("fid", m57351R(jSONObjectOptJSONObject.getString("fid")));
                }
                jSONArray.put(i10, jSONObjectOptJSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("TagUtil", "anonymousStandByDevice, JSONException");
            return "";
        } catch (Exception unused2) {
            C13981a.m83988e("TagUtil", "anonymousStandByDevice, Exception");
            return "";
        }
    }

    /* renamed from: T0 */
    public static void m57356T0(String str, String str2, ApiException apiException) {
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setRespCode(apiException.getStatusCode());
        m57358U0(str, str2, findNetworkResult);
    }

    /* renamed from: U */
    public static void m57357U(Context context, List<String> list, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("TagUtil", "batchQueryOfflineLocation deviceId length: " + list.size());
        try {
            FindNetwork.getFindNetworkEngine(context).queryOfflineLocation(list, new h(context, handlerC4536g));
        } catch (Exception unused) {
            C13981a.m83988e("TagUtil", "batchQueryOfflineLocation exception");
            m57380d1(context, "batchQueryOfflineLocation exception", "", null, -1);
        }
    }

    /* renamed from: U0 */
    public static <T> void m57358U0(String str, String str2, FindNetworkResult<T> findNetworkResult) {
        C13981a.m83989i("TagUtil", "notifyTagOperationResult");
        if (findNetworkResult == null) {
            C13981a.m83988e("TagUtil", "notifyTagOperationResult result is null");
            return;
        }
        String json = "";
        TagOperationResult tagOperationResult = new TagOperationResult(str, str2, String.valueOf(findNetworkResult.getRespCode()), "");
        tagOperationResult.setExecuteTime(System.currentTimeMillis());
        tagOperationResult.setCurrentTime(System.currentTimeMillis());
        if (findNetworkResult.getData() != null) {
            C13981a.m83989i("TagUtil", "notifyTagOperationResult result.getData success");
            tagOperationResult.setData(findNetworkResult.getData());
        }
        try {
            json = new Gson().toJson(tagOperationResult, TagOperationResult.class);
        } catch (Exception e10) {
            C13981a.m83988e("TagUtil", "encaseTagOperationResult exception:" + e10.getMessage());
        }
        C13981a.m83987d("TagUtil", "encaseTagOperationResult arg:" + json);
        final Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.remotecontrol.intent.TAG_LOCAL_COMMAND_RESULT");
        intent.putExtra("arg", json);
        intent.putExtra("operation", tagOperationResult.getOperation());
        intent.putExtra("exeResult", tagOperationResult.getExeResult());
        intent.putExtra("executeTime", tagOperationResult.getExecuteTime());
        intent.putExtra("tagSn", tagOperationResult.getTagSn());
        C0226l0.m1584d(new Runnable() { // from class: dg.x
            @Override // java.lang.Runnable
            public final void run() {
                C9120m0.m57426t0(intent);
            }
        });
    }

    /* renamed from: V */
    public static void m57359V(final Context context, final String str) {
        C13981a.m83989i("TagUtil", "checkTagOtaVersion");
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.g
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57397j0(context, str);
            }
        }, new Consumer() { // from class: dg.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9120m0.m57400k0((Exception) obj);
            }
        });
    }

    /* renamed from: V0 */
    public static AncDeviceLocationBean m57360V0(Context context, OfflineLocationBean offlineLocationBean) {
        if (offlineLocationBean == null) {
            C13981a.m83988e("TagUtil", "parseOfflineLocation: offlineLocation is null");
            return null;
        }
        String standbyDevice = offlineLocationBean.getStandbyDevice();
        C13981a.m83989i("TagUtil", "parseOfflineLocation standByDevice: " + m57355T(standbyDevice));
        if (standbyDevice == null) {
            standbyDevice = C6010m7.f27500n;
        }
        ArrayList<AncDeviceLocationBean.StandByDevice> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(standbyDevice.replace("\\\"", "\""));
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                AncDeviceLocationBean.StandByDevice standByDevice = new AncDeviceLocationBean.StandByDevice();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                standByDevice.setFid(jSONObjectOptJSONObject.optString("fid"));
                standByDevice.setSequence(jSONObjectOptJSONObject.optInt(VastAttribute.SEQUENCE));
                standByDevice.setStatus(jSONObjectOptJSONObject.optInt("status"));
                arrayList.add(standByDevice);
            }
            AncDeviceLocationBean ancDeviceLocationBean = new AncDeviceLocationBean();
            String strM82838i = C13812b.m82838i(offlineLocationBean);
            ancDeviceLocationBean.setFid(offlineLocationBean.getFid());
            ancDeviceLocationBean.setFoundTime(offlineLocationBean.getFoundTime());
            ancDeviceLocationBean.setAccuracy(offlineLocationBean.getAccuracy());
            ancDeviceLocationBean.setLongitude(offlineLocationBean.getLongitude());
            ancDeviceLocationBean.setLatitude(offlineLocationBean.getLatitude());
            ancDeviceLocationBean.setFloor(strM82838i);
            ancDeviceLocationBean.setStatus(offlineLocationBean.getStatus());
            ancDeviceLocationBean.setBatteryLevel(offlineLocationBean.getBatteryLevel());
            ancDeviceLocationBean.setBatteryDescription(offlineLocationBean.getBatteryDescription());
            ancDeviceLocationBean.setmStandbyDevice(arrayList);
            return ancDeviceLocationBean;
        } catch (Exception unused) {
            C13981a.m83988e("TagUtil", "anonymousStandByDevice, Exception");
            return null;
        }
    }

    /* renamed from: W */
    public static TagStatus m57361W(Context context, String str) throws InterruptedException {
        C13981a.m83989i("TagUtil", "checkTagStatus, deviceId: " + m57351R(str));
        if (context == null || TextUtils.isEmpty(str)) {
            C13981a.m83988e("TagUtil", "checkTagStatus context or deviceId is empty");
            return null;
        }
        TagStatus[] tagStatusArr = new TagStatus[1];
        try {
            FindNetworkEngine findNetworkEngine = FindNetwork.getFindNetworkEngine(context);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            findNetworkEngine.checkTagStatus(str, new b(tagStatusArr, countDownLatch)).addOnCompleteListener(new InterfaceC8937e() { // from class: dg.p
                @Override // p208cq.InterfaceC8937e
                public final void onComplete(Task task) {
                    countDownLatch.countDown();
                }
            });
            C13981a.m83989i("TagUtil", "countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
            TagStatus tagStatus = tagStatusArr[0];
            C13981a.m83989i("TagUtil", "checkTagStatus respCode:" + tagStatus);
            return tagStatus;
        } catch (Exception e10) {
            C13981a.m83988e("TagUtil", "checkTagStatus exception:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: W0 */
    public static String m57362W0(Context context, String str, OfflineLocationBean offlineLocationBean) {
        C13981a.m83989i("TagUtil", "processOfflineLocation deviceId: " + m57351R(str));
        AncDeviceLocationBean ancDeviceLocationBeanM57360V0 = m57360V0(context, offlineLocationBean);
        String json = "";
        if (ancDeviceLocationBeanM57360V0 == null) {
            C13981a.m83988e("TagUtil", "processOfflineLocation offlineLocation is null");
            m57380d1(context, "processOfflineLocation offlineLocation is null", str, null, 0);
            return "";
        }
        try {
            json = new Gson().toJson(ancDeviceLocationBeanM57360V0, AncDeviceLocationBean.class);
        } catch (Exception e10) {
            C13981a.m83988e("TagUtil", "processOfflineLocation exception:" + e10.getMessage());
        }
        String strReplace = json.replace("\"", "\\\"");
        C13981a.m83987d("TagUtil", "queryOfflineLocation ok: " + strReplace + ", indoor:" + offlineLocationBean.getIndoor() + ", " + offlineLocationBean.getFloorAcc());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("QueryOfflineLocation success, floor: ");
        sb2.append(ancDeviceLocationBeanM57360V0.getFloor());
        sb2.append(", foundTime: ");
        sb2.append(offlineLocationBean.getFoundTime());
        m57380d1(context, sb2.toString(), str, null, 0);
        return strReplace;
    }

    /* renamed from: X */
    public static List<C11518e> m57363X(Context context, List<OfflineLocateInfo> list, String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ArrayList arrayList;
        ArrayList arrayList2;
        double d10;
        int i10;
        String string;
        ArrayList arrayList3;
        float f10;
        String str8 = "floorInfo";
        String str9 = "buildingId";
        String str10 = "floorAcc";
        String str11 = "floor";
        String str12 = JsbMapKeyNames.H5_LOC_LAT;
        String str13 = JsbMapKeyNames.H5_LOC_LON;
        ArrayList arrayList4 = new ArrayList();
        Iterator<OfflineLocateInfo> it = list.iterator();
        while (it.hasNext()) {
            OfflineLocateInfo next = it.next();
            long broadcastTime = next.getBroadcastTime();
            double confidence = next.getConfidence();
            Iterator<OfflineLocateInfo> it2 = it;
            try {
                JSONObject jSONObject = new JSONObject(m57373b0(context, next, str));
                if (jSONObject.has(str13)) {
                    arrayList2 = arrayList4;
                    d10 = jSONObject.getDouble(str13);
                } else {
                    arrayList2 = arrayList4;
                    d10 = 0.0d;
                }
                try {
                    str6 = str12;
                    str7 = str13;
                    double d11 = jSONObject.has(str12) ? jSONObject.getDouble(str12) : 0.0d;
                    try {
                        str5 = str11;
                        int i11 = jSONObject.has(str11) ? jSONObject.getInt(str11) : -100;
                        try {
                            int i12 = 0;
                            if (jSONObject.has(str10)) {
                                str4 = str10;
                                i10 = jSONObject.getInt(str10);
                            } else {
                                str4 = str10;
                                i10 = 0;
                            }
                            try {
                                if (jSONObject.has(str9)) {
                                    str3 = str9;
                                    string = jSONObject.getString(str9);
                                } else {
                                    str3 = str9;
                                    string = "";
                                }
                                try {
                                    str2 = str8;
                                    String string2 = jSONObject.has(str8) ? jSONObject.getString(str8) : "";
                                    try {
                                        if (jSONObject.has("accuracy")) {
                                            arrayList3 = arrayList2;
                                            try {
                                                f10 = (float) jSONObject.getDouble("accuracy");
                                            } catch (JSONException unused) {
                                                arrayList = arrayList3;
                                            }
                                        } else {
                                            arrayList3 = arrayList2;
                                            f10 = 0.0f;
                                        }
                                        String extendData = next.getExtendData();
                                        if (extendData.contains("rssi")) {
                                            JSONObject jSONObject2 = new JSONObject(extendData);
                                            if (jSONObject2.has("rssi")) {
                                                i12 = jSONObject2.getInt("rssi");
                                            }
                                        }
                                        C11520g c11520g = new C11520g(d10, d11);
                                        c11520g.m68758r(i11);
                                        c11520g.m68759s(i10);
                                        c11520g.m68756p(string);
                                        c11520g.m68760t(string2);
                                        c11520g.m68755o(f10);
                                        arrayList = arrayList3;
                                        arrayList.add(new C11518e(new C11519f(broadcastTime, i12), c11520g, 0, 0, confidence));
                                    } catch (JSONException unused2) {
                                        arrayList = arrayList2;
                                        it = it2;
                                        arrayList4 = arrayList;
                                        str12 = str6;
                                        str13 = str7;
                                        str11 = str5;
                                        str10 = str4;
                                        str9 = str3;
                                        str8 = str2;
                                    }
                                } catch (JSONException unused3) {
                                    str2 = str8;
                                }
                            } catch (JSONException unused4) {
                                str2 = str8;
                                str3 = str9;
                            }
                        } catch (JSONException unused5) {
                            str2 = str8;
                            str3 = str9;
                            str4 = str10;
                        }
                    } catch (JSONException unused6) {
                        str2 = str8;
                        str3 = str9;
                        str4 = str10;
                        str5 = str11;
                    }
                } catch (JSONException unused7) {
                    str2 = str8;
                    str3 = str9;
                    str4 = str10;
                    str5 = str11;
                    str6 = str12;
                    str7 = str13;
                }
            } catch (JSONException unused8) {
                str2 = str8;
                str3 = str9;
                str4 = str10;
                str5 = str11;
                str6 = str12;
                str7 = str13;
                arrayList = arrayList4;
            }
            it = it2;
            arrayList4 = arrayList;
            str12 = str6;
            str13 = str7;
            str11 = str5;
            str10 = str4;
            str9 = str3;
            str8 = str2;
        }
        return arrayList4;
    }

    /* renamed from: X0 */
    public static void m57364X0(final Context context, final String str, final WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("TagUtil", "queryDeviceCapabilities");
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.j0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57432w0(context, str, handlerC4536g);
            }
        }, new Consumer() { // from class: dg.k0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9120m0.m57434x0((Exception) obj);
            }
        });
        C13981a.m83989i("TagUtil", "queryDeviceCapabilities end");
    }

    /* renamed from: Y */
    public static void m57365Y(final Context context, final String str, String str2, final boolean z10) throws JSONException {
        C13981a.m83989i("TagUtil", "enableAncillaryDeviceFoundSwitch, deviceId: " + m57351R(str) + ", status: " + z10 + ", standByDevice: " + m57355T(str2));
        if (context == null) {
            return;
        }
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.k
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57406m0(context, str, z10);
            }
        }, new Consumer() { // from class: dg.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9120m0.m57409n0((Exception) obj);
            }
        });
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                final JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject.getInt("status") == 1) {
                    C0225l.m1577a(new InterfaceC14356c() { // from class: dg.m
                        @Override // p851zp.InterfaceC14356c
                        public final Object execute() {
                            return C9120m0.m57412o0(context, jSONObject, z10);
                        }
                    }, new Consumer() { // from class: dg.o
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            C9120m0.m57415p0((Exception) obj);
                        }
                    });
                    C13981a.m83989i("TagUtil", "enableAncillaryDeviceFoundSwitch suc i: " + i10);
                }
            }
        } catch (JSONException e10) {
            C13981a.m83988e("TagUtil", "enableAncillaryDeviceFoundSwitch JSONException:" + e10.getMessage());
        }
    }

    /* renamed from: Y0 */
    public static DeviceDetail m57366Y0(Context context, String str) throws InterruptedException {
        if (context == null || TextUtils.isEmpty(str)) {
            C13981a.m83988e("TagUtil", "queryDeviceDetail context or tagSn is empty");
            return null;
        }
        try {
            FindNetworkEngine findNetworkEngine = FindNetwork.getFindNetworkEngine(context);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Task<FindNetworkResult<DeviceDetail>> taskAddOnCompleteListener = findNetworkEngine.queryDeviceDetail(str).addOnCompleteListener(new InterfaceC8937e() { // from class: dg.w
                @Override // p208cq.InterfaceC8937e
                public final void onComplete(Task task) {
                    countDownLatch.countDown();
                }
            });
            C13981a.m83989i("TagUtil", "countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
            C13981a.m83989i("TagUtil", "queryDeviceDetail respCode:" + taskAddOnCompleteListener.getResult().getRespCode());
            return taskAddOnCompleteListener.getResult().getData();
        } catch (Exception e10) {
            C13981a.m83988e("TagUtil", "queryDeviceDetail exception:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: Z */
    public static void m57367Z(final Context context, final String str, final int i10, final String str2, final Consumer<FindNetworkResult<Void>> consumer) {
        String str3 = "enableGoodsDisconnectNotifyEnhanced , status = " + i10 + ", sn = " + m57351R(str);
        C13981a.m83989i("TagUtil", str3);
        new C12797b().m76784j(context, "TagUtil", "", str3, "", "tag_local_find", "", "enableGoodsDisconnectNotifyEnhanced", false);
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.z
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57418q0(context, consumer, str2, str, i10);
            }
        }, new Consumer() { // from class: dg.a0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9120m0.m57421r0((Exception) obj);
            }
        });
    }

    /* renamed from: Z0 */
    public static void m57368Z0(Context context, final Function<PairedDeviceInfo, Boolean> function) {
        C13981a.m83989i("TagUtil", "queryPairedDevicesFromFN");
        try {
            FindNetwork.getFindNetworkEngine(context).queryPairedDevices().addOnSuccessListener(new InterfaceC8939g() { // from class: dg.q
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    C9120m0.m57438z0(function, (FindNetworkResult) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: dg.r
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C9120m0.m57318A0(exc);
                }
            });
        } catch (FindNetworkException e10) {
            C13981a.m83988e("TagUtil", "queryPairedDevicesFromFN Exception: " + e10.getMessage());
        }
    }

    /* renamed from: a0 */
    public static void m57370a0(Context context, String str, String str2, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        str2.hashCode();
        switch (str2) {
            case "stopTagSound":
            case "startTagSound":
            case "tagLocate":
            case "tagListLocate":
                C12515a.m75110o().m75175e(new C14294b(context, str, str2), false);
                break;
            case "syncCloudDeviceData":
                m57416p1(context, str);
                break;
            case "wearDeviceListLocate":
            case "wearDeviceLocate":
                C13978y.m83903T().m83959Q(str, str2, handlerC4536g);
                break;
            case "queryTagDisconnectLocation":
                m57371a1(context, str);
                break;
            case "checkOtaVersion":
                m57359V(context, str);
                break;
            case "startOtaUpgrade":
                m57413o1(context, str);
                break;
            case "queryTagOfflineLocation":
                m57374b1(context, str, handlerC4536g);
                break;
            case "queryTagSyncStatus":
                m57377c1(context, str);
                break;
            default:
                C13981a.m83989i("TagUtil", "executeTagLocalCmd unsupport operation");
                break;
        }
    }

    /* renamed from: a1 */
    public static void m57371a1(final Context context, final String str) {
        C13981a.m83989i("TagUtil", "queryTagDisconnectLocation, deviceId: " + m57351R(str));
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.h0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57320B0(context, str);
            }
        }, new Consumer() { // from class: dg.i0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C13981a.m83988e("TagUtil", "queryTagDisconnectLocation exception");
            }
        });
    }

    /* renamed from: b0 */
    public static String m57373b0(Context context, OfflineLocateInfo offlineLocateInfo, String str) {
        if (C0209d.m1277l1()) {
            return "";
        }
        String createTime = offlineLocateInfo.getCreateTime();
        String encLocation = offlineLocateInfo.getEncLocation();
        String tag = offlineLocateInfo.getTag();
        String tmpPublicKey = offlineLocateInfo.getTmpPublicKey();
        String offlinePublicKey = offlineLocateInfo.getOfflinePublicKey();
        if (TextUtils.isEmpty(createTime) || TextUtils.isEmpty(offlinePublicKey)) {
            C13981a.m83988e("TagUtil", "getDecryptLocationInfo offlineLocateInfo data is empty");
            return "";
        }
        byte[] bArrM68628j = C11476b.m68628j(offlinePublicKey);
        byte[] bArrM26409k = C4375j.m26409k(tmpPublicKey);
        byte[] bArrM26409k2 = C4375j.m26409k(tag);
        byte[] bArrM26409k3 = C4375j.m26409k(encLocation);
        byte[] bArr = new byte[bArrM26409k3.length + bArrM26409k2.length + bArrM26409k.length + bArrM68628j.length];
        System.arraycopy(bArrM68628j, 0, bArr, 0, bArrM68628j.length);
        System.arraycopy(bArrM26409k, 0, bArr, bArrM68628j.length, bArrM26409k.length);
        System.arraycopy(bArrM26409k2, 0, bArr, bArrM26409k.length + bArrM68628j.length, bArrM26409k2.length);
        System.arraycopy(bArrM26409k3, 0, bArr, bArrM26409k.length + bArrM68628j.length + bArrM26409k2.length, bArrM26409k3.length);
        String str2 = str + createTime;
        C4376k.m26430f(context, str2, "FindPhoneSlaveKey");
        C13981a.m83989i("TagUtil", "verifyShaPi = " + offlinePublicKey.equals(C11476b.m68619a(C0227m.m1594g(C4376k.m26436l(context, str2))).toUpperCase(Locale.ENGLISH)));
        String strM26425a = C4376k.m26425a(context.getApplicationContext(), bArr, str2);
        C4376k.m26427c(context, str2);
        return strM26425a;
    }

    /* renamed from: b1 */
    public static void m57374b1(final Context context, final String str, final WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("TagUtil", "queryOfflineLocation start");
        try {
            FindNetwork.getFindNetworkEngine(context).queryOfflineLocation(str).addOnSuccessListener(new InterfaceC8939g() { // from class: dg.l0
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    C9120m0.m57324D0(context, str, handlerC4536g, (FindNetworkResult) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: dg.d
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C9120m0.m57326E0(context, str, exc);
                }
            });
        } catch (Exception unused) {
            C13981a.m83988e("TagUtil", "queryTagOfflineLocation exception");
            m57380d1(context, "QueryOfflineLocation exception", str, null, -1);
        }
    }

    /* renamed from: c0 */
    public static void m57376c0(Context context, List<OfflineLocateInfo> list, String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        String str2;
        C11520g c11520gM68734n;
        C13981a.m83989i("TagUtil", "getOfflineLocation");
        List<C11518e> listM57363X = m57363X(context, list, str);
        for (C11518e c11518e : listM57363X) {
            if (c11518e != null && (c11520gM68734n = c11518e.m68734n()) != null) {
                C13981a.m83989i("TagUtil", "getOfflineLocation floorAcc: " + c11520gM68734n.m68745e() + " " + c11520gM68734n.m68752l() + " " + c11520gM68734n.m68743c());
            }
        }
        C11522i c11522iMo68138a = new C12414v().mo68138a(new j(), listM57363X);
        if (c11522iMo68138a == null) {
            str2 = "[]," + str;
            m57380d1(context, "PositionCalculator fail, size: " + list.size(), str, null, -1);
        } else {
            String strM82842m = C13812b.m82842m(c11522iMo68138a);
            String str3 = "\"[{\\\"broadcastTime\\\":" + c11522iMo68138a.m68774j() + ",\\\"sn\\\":\\\"" + str + "\\\",\\\"accuracy\\\":" + c11522iMo68138a.m68765a() + ",\\\"latitude\\\":" + c11522iMo68138a.m68770f() + ",\\\"longitude\\\":" + c11522iMo68138a.m68771g() + ",\\\"floor\\\":\\\"" + strM82842m + "\\\",\\\"status\\\":-1}]\",\"" + str + "\"";
            C13981a.m83987d("TagUtil", "PositionCalculator success, " + str3 + ", indoor:" + c11522iMo68138a.m68769e() + ", " + c11522iMo68138a.m68768d());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PositionCalculator success, size: ");
            sb2.append(list.size());
            sb2.append(", floor: ");
            sb2.append(strM82842m);
            m57380d1(context, sb2.toString(), str, null, 0);
            str2 = str3;
        }
        C13981a.m83989i("TagUtil", "getOfflineLocation, locateInfoList.size: " + list.size());
        if (handlerC4536g != null) {
            Message message = new Message();
            message.what = 1009;
            Bundle bundle = new Bundle();
            bundle.putString(RouterEventReceiver.KEY_PARAMS, str2);
            message.obj = bundle;
            handlerC4536g.handleMessage(message);
        }
    }

    /* renamed from: c1 */
    public static void m57377c1(final Context context, final String str) {
        C13981a.m83989i("TagUtil", "queryTagSyncStatus");
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.c
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57332H0(context, str);
            }
        }, new Consumer() { // from class: dg.n
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9120m0.m57334I0((Exception) obj);
            }
        });
    }

    /* renamed from: d0 */
    public static int m57379d0(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException e10) {
                C13981a.m83988e("TagUtil", "getParamsFromFN e: " + e10.getMessage());
            }
        }
        return 0;
    }

    /* renamed from: d1 */
    public static void m57380d1(Context context, String str, String str2, String str3, int i10) {
        C13981a.m83989i("TagUtil", "reportTagEvent");
        JSONObject jSONObjectM79464f = C13222a.m79464f(context, str, "1", C13452e.m80781L().m80971t0(), "2");
        if (str2 != null) {
            try {
                jSONObjectM79464f.put("TagSN", m57351R(str2));
            } catch (JSONException e10) {
                C13981a.m83988e("TagUtil", "ERROR OCCUR:" + e10.getMessage());
            }
        }
        jSONObjectM79464f.put("itemName", str3);
        jSONObjectM79464f.put("gradeCode", C13452e.m80781L().m80790C());
        m57389g1(context, str, str3, jSONObjectM79464f, i10);
        UBAAnalyze.m29963X("CKP", str, "1", "76", jSONObjectM79464f);
        C13222a.m79461c(context, jSONObjectM79464f);
    }

    /* renamed from: e0 */
    public static FindNetworkResult<MultiTerminalDeviceInfo> m57382e0(String str, FindNetworkResult<List<MultiTerminalDeviceInfo>> findNetworkResult) {
        FindNetworkResult<MultiTerminalDeviceInfo> findNetworkResult2 = new FindNetworkResult<>();
        findNetworkResult2.setRespCode(findNetworkResult.getRespCode());
        if (findNetworkResult.getData() == null) {
            C13981a.m83989i("TagUtil", "getQueryResultInList getData is null");
            return findNetworkResult2;
        }
        Iterator<MultiTerminalDeviceInfo> it = findNetworkResult.getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MultiTerminalDeviceInfo next = it.next();
            if (str.equals(next.getSn())) {
                C13981a.m83989i("TagUtil", "getQueryResultInList result found");
                findNetworkResult2.setData(next);
                break;
            }
        }
        return findNetworkResult2;
    }

    /* renamed from: e1 */
    public static void m57383e1(Context context, String str, String str2, String str3, String str4, int i10) {
        m57386f1(context, str, str2, str3, str4, i10, null);
    }

    /* renamed from: f0 */
    public static FindNetworkResult<PairedDeviceInfo> m57385f0(String str, FindNetworkResult<List<PairedDeviceInfo>> findNetworkResult) {
        FindNetworkResult<PairedDeviceInfo> findNetworkResult2 = new FindNetworkResult<>();
        findNetworkResult2.setRespCode(findNetworkResult.getRespCode());
        if (findNetworkResult.getData() == null) {
            C13981a.m83989i("TagUtil", "getSyncResultInList getData is null");
            return findNetworkResult2;
        }
        Iterator<PairedDeviceInfo> it = findNetworkResult.getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PairedDeviceInfo next = it.next();
            if (str.equals(next.getSn())) {
                C13981a.m83989i("TagUtil", "getSyncResultInList result found");
                findNetworkResult2.setData(next);
                break;
            }
        }
        return findNetworkResult2;
    }

    /* renamed from: f1 */
    public static void m57386f1(Context context, String str, String str2, String str3, String str4, int i10, String str5) throws JSONException {
        C13981a.m83989i("TagUtil", "reportTagEvent");
        JSONObject jSONObjectM79464f = C13222a.m79464f(context, str, "1", C13452e.m80781L().m80971t0(), "2");
        if (str2 != null) {
            try {
                jSONObjectM79464f.put("TagSN", m57351R(str2));
            } catch (JSONException e10) {
                C13981a.m83988e("TagUtil", "ERROR OCCUR:" + e10.getMessage());
            }
        }
        jSONObjectM79464f.put("itemName", str3);
        if (!TextUtils.isEmpty(str4)) {
            jSONObjectM79464f.put("modelId", str4);
        }
        String strM80950o = C13452e.m80781L().m80950o();
        if (!TextUtils.isEmpty(strM80950o)) {
            jSONObjectM79464f.put("deviceId", strM80950o);
        }
        if (!TextUtils.isEmpty(str5)) {
            jSONObjectM79464f.put("standbyDevice", m57355T(str5));
        }
        jSONObjectM79464f.put("gradeCode", C13452e.m80781L().m80790C());
        m57389g1(context, str, str3, jSONObjectM79464f, i10);
        UBAAnalyze.m29963X("CKP", str, "1", "76", jSONObjectM79464f);
        C13222a.m79461c(context, jSONObjectM79464f);
    }

    /* renamed from: g0 */
    public static String m57388g0(Context context, OfflineLocateInfo offlineLocateInfo, String str) throws InterruptedException {
        String encLocation = offlineLocateInfo.getEncLocation();
        String str2 = offlineLocateInfo.getTag() + "|" + offlineLocateInfo.getTmpPublicKey() + "|" + encLocation;
        try {
            FindNetworkEngine findNetworkEngine = FindNetwork.getFindNetworkEngine(context);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Task<FindNetworkResult<String>> taskAddOnCompleteListener = findNetworkEngine.decryptLocationCipher(str, offlineLocateInfo.getOfflinePublicKey(), str2).addOnCompleteListener(new InterfaceC8937e() { // from class: dg.y
                @Override // p208cq.InterfaceC8937e
                public final void onComplete(Task task) {
                    countDownLatch.countDown();
                }
            });
            C13981a.m83989i("TagUtil", "getTagDecryptLocationInfo, countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
            C13981a.m83989i("TagUtil", "getTagDecryptLocationInfo respCode:" + taskAddOnCompleteListener.getResult().getRespCode());
            new C12797b().m76784j(context, "TagUtil", "", "getTagDecryptLocationInfo, respCode:" + taskAddOnCompleteListener.getResult().getRespCode(), "", "call_nearby_api_result", "", "call_nearby_api_result", true);
            return taskAddOnCompleteListener.getResult().getData();
        } catch (Exception e10) {
            C13981a.m83988e("TagUtil", "getTagDecryptLocationInfo, exception:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: g1 */
    public static void m57389g1(Context context, String str, String str2, JSONObject jSONObject, int i10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("itemName", str2);
        if (jSONObject != null) {
            linkedHashMap.put("info", jSONObject.toString());
        }
        new C12797b().m76785k(context, "TagUtil", String.valueOf(i10), "", "", "tag_local_find", "", str, true, linkedHashMap);
    }

    /* renamed from: h0 */
    public static String m57391h0(Context context, List<OfflineLocationBean> list) {
        C13981a.m83989i("TagUtil", "handleBatchOfflineLocation");
        if (list == null) {
            C13981a.m83988e("TagUtil", "handleBatchOfflineLocation locationBeanList is null");
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String strM57362W0 = m57362W0(context, list.get(i10).getFid(), list.get(i10));
            if (!TextUtils.isEmpty(strM57362W0)) {
                arrayList.add(strM57362W0);
            }
        }
        C13981a.m83989i("TagUtil", "handleBatchOfflineLocation locationList length: " + arrayList.size());
        return String.valueOf(arrayList);
    }

    /* renamed from: h1 */
    public static void m57392h1(String str, DeviceDetail deviceDetail, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("TagUtil", "sendDeviceCapabilities, perDeviceId: " + m57351R(str));
        String str2 = "{\\\"tagSn\\\":\\\"" + str + "\\\",\\\"exeResult\\\":\\\"-1\\\",\\\"executeTime\\\":\\\"" + System.currentTimeMillis() + "\\\"}\"";
        if (deviceDetail == null) {
            m57395i1(handlerC4536g, str2);
            return;
        }
        try {
            String accessoryCapabilities = deviceDetail.getAccessoryCapabilities();
            JSONObject jSONObject = new JSONObject(accessoryCapabilities);
            m57395i1(handlerC4536g, "{\\\"tagSn\\\":\\\"" + str + "\\\",\\\"exeResult\\\":\\\"0\\\",\\\"executeTime\\\":\\\"" + System.currentTimeMillis() + "\\\",\\\"accessoryCapabilities\\\":{\\\"Ble_Measure_Distance\\\":" + m57379d0(jSONObject, DeviceDetail.CAP_KEY_BLE_MEASURE_DISTANCE) + ",\\\"Normal_Lost_Reminder\\\":" + m57379d0(jSONObject, DeviceDetail.CAP_KEY_LOST_REMINDER_NORMAL) + ",\\\"Fast_Lost_Reminder\\\":" + m57379d0(jSONObject, DeviceDetail.CAP_KEY_LOST_REMINDER_FAST) + ",\\\"Ring\\\":" + m57379d0(jSONObject, DeviceDetail.CAP_KEY_RING) + "}}");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sendDeviceCapabilities, capabilities: ");
            sb2.append(accessoryCapabilities);
            C13981a.m83989i("TagUtil", sb2.toString());
        } catch (Exception e10) {
            C13981a.m83988e("TagUtil", "sendDeviceCapabilities e:" + e10.getMessage());
            m57395i1(handlerC4536g, str2);
        }
    }

    /* renamed from: i0 */
    public static boolean m57394i0(String str, String str2) throws JSONException {
        C13981a.m83989i("TagUtil", "isSatisfyStand");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    if (TextUtils.equals(str, jSONObject.getString("fid")) && jSONObject.getInt("status") == 1) {
                        C13981a.m83989i("TagUtil", "isSatisfyStand is true");
                        return true;
                    }
                }
            } catch (JSONException unused) {
                C13981a.m83988e("TagUtil", "isSatisfyStand Exception");
            }
        }
        return false;
    }

    /* renamed from: i1 */
    public static void m57395i1(WapFindPhoneActivity.HandlerC4536g handlerC4536g, String str) {
        if (handlerC4536g != null) {
            C13981a.m83989i("TagUtil", "sendMsgDeviceDetail");
            Message message = new Message();
            message.what = FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST;
            Bundle bundle = new Bundle();
            bundle.putString(RouterEventReceiver.KEY_PARAMS, str);
            message.obj = bundle;
            handlerC4536g.handleMessage(message);
        }
    }

    /* renamed from: j0 */
    public static /* synthetic */ Boolean m57397j0(Context context, String str) throws Exception {
        FindNetwork.getFindNetworkEngine(context).checkOtaVersion(str, new c(str));
        return Boolean.TRUE;
    }

    /* renamed from: j1 */
    public static void m57398j1(Handler handler, String str) {
        if (handler != null) {
            C13981a.m83989i("TagUtil", "sendMsgFinishNavigation");
            Message message = new Message();
            message.what = 1001;
            message.obj = str;
            handler.handleMessage(message);
        }
    }

    /* renamed from: k0 */
    public static /* synthetic */ void m57400k0(Exception exc) {
        C13981a.m83988e("TagUtil", "checkTagOtaVersion exception:" + exc.getMessage());
    }

    /* renamed from: k1 */
    public static void m57401k1(Context context) {
        C13981a.m83989i("TagUtil", "setDeviceDisconnectNotify");
        if (C0209d.m1333z1(context)) {
            new C13429u(context, null, new k(context, 3080, null)).m80720g();
        } else {
            C13981a.m83990w("TagUtil", "network error");
        }
    }

    /* renamed from: l1 */
    public static void m57404l1(Context context, String str, String str2, String str3, long j10) {
        C13981a.m83989i("TagUtil", "setDevicesPublicKeyToFn");
        C12515a.m75110o().m75175e(new a(str2, str, context, str3), false);
    }

    /* renamed from: m0 */
    public static /* synthetic */ Task m57406m0(Context context, String str, boolean z10) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).enableFoundNotification(str, "", z10);
    }

    /* renamed from: m1 */
    public static void m57407m1(final Context context, final String str, final Handler handler) {
        C13981a.m83989i("TagUtil", "isDeviceStandStatus");
        C13788m.m82779c().m82780a();
        final Timer timer = new Timer();
        f45892a = true;
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.b0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57336J0(context, str, handler, timer);
            }
        }, new Consumer() { // from class: dg.c0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9120m0.m57338K0((Exception) obj);
            }
        });
        timer.schedule(new l(handler), 5000L);
    }

    /* renamed from: n0 */
    public static /* synthetic */ void m57409n0(Exception exc) {
        C13981a.m83988e("TagUtil", "enableAncillaryDeviceFoundSwitch error:" + exc.getMessage());
    }

    /* renamed from: n1 */
    public static void m57410n1(Context context, final Handler handler) {
        C13981a.m83989i("TagUtil", "showItemChangeDialog");
        if (context == null) {
            return;
        }
        try {
            f45893b = new AlertDialog.Builder(context);
            f45893b.setTitle(context.getString(R$string.device_status_change_title));
            f45893b.setMessage(R$string.freebuds_pro_status_change_content);
            f45893b.setPositiveButton(R$string.phonefinder_notify_know, new DialogInterface.OnClickListener() { // from class: dg.d0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    C9120m0.m57340L0(handler, dialogInterface, i10);
                }
            });
            f45893b.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: dg.e0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    C9120m0.m57398j1(handler, "showDialog");
                }
            });
            AlertDialog alertDialogCreate = f45893b.create();
            f45894c = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            f45894c.show();
        } catch (Exception unused) {
            C13981a.m83988e("TagUtil", "showItemChangeDialog Exception");
        }
    }

    /* renamed from: o0 */
    public static /* synthetic */ Task m57412o0(Context context, JSONObject jSONObject, boolean z10) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).enableFoundNotification(jSONObject.getString("fid"), "", z10);
    }

    /* renamed from: o1 */
    public static void m57413o1(final Context context, final String str) {
        C13981a.m83989i("TagUtil", "startTagOtaVersion");
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.f0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57344N0(context, str);
            }
        }, new Consumer() { // from class: dg.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9120m0.m57346O0((Exception) obj);
            }
        });
    }

    /* renamed from: p0 */
    public static /* synthetic */ void m57415p0(Exception exc) {
        C13981a.m83988e("TagUtil", "enableAncillaryDeviceFoundSwitch standbyDevice exception:" + exc.getMessage());
    }

    /* renamed from: p1 */
    public static void m57416p1(final Context context, final String str) {
        C13981a.m83989i("TagUtil", "syncCloudDeviceData");
        C0225l.m1577a(new InterfaceC14356c() { // from class: dg.e
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C9120m0.m57352R0(context, str);
            }
        }, new Consumer() { // from class: dg.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9120m0.m57354S0((Exception) obj);
            }
        });
    }

    /* renamed from: q0 */
    public static /* synthetic */ Boolean m57418q0(Context context, Consumer consumer, String str, String str2, int i10) throws Exception {
        DisconnectNotificationParams disconnectNotificationParams;
        FindNetworkEngine findNetworkEngine = FindNetwork.getFindNetworkEngine(context);
        e eVar = new e(consumer);
        if (TextUtils.isEmpty(str)) {
            disconnectNotificationParams = null;
        } else {
            try {
                disconnectNotificationParams = (DisconnectNotificationParams) new Gson().fromJson(str, DisconnectNotificationParams.class);
            } catch (JsonSyntaxException unused) {
                C13981a.m83988e("TagUtil", "DisconnectNotificationParams JsonSyntaxException");
            }
        }
        findNetworkEngine.setDisconnectNotification(str2, i10, disconnectNotificationParams, eVar);
        return Boolean.TRUE;
    }

    /* renamed from: q1 */
    public static void m57419q1(long j10, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("accurate_search_duration", String.valueOf(jCurrentTimeMillis - j10));
        linkedHashMap.put("navigation_mode", str);
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_use_duration", "2", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("CKP", "mecloud_findmyphone_use_duration", "1", "77", "2", "", linkedHashMap);
    }

    /* renamed from: r0 */
    public static /* synthetic */ void m57421r0(Exception exc) {
        C13981a.m83988e("TagUtil", "enableGoodsDisconnectNotifyEnhanced exception:" + exc.getMessage());
    }

    /* renamed from: r1 */
    public static void m57422r1(Context context, int i10, String str) {
        switch (i10) {
            case 0:
            case ErrorCode.CODE_LOCATION_PERMISSION_FAILED /* 907201003 */:
            case ErrorCode.STATUS_ERROR_NOT_HAVE_PERMISSION_RECORD_AUDIO /* 907201005 */:
            case ErrorCode.STATUS_ERROR_START_AUDIO_RECORD_FAILED /* 907201006 */:
            case ErrorCode.STATUS_ERROR_NEARBY_MEASURERESULT /* 907201008 */:
            case ErrorCode.STATUS_ERROR_MEASURERESULT_RUNING /* 907201009 */:
            case 907201010:
            case ErrorCode.STATUS_ERROR_NOT_SUPPORT_TAG_CURRENT_VERSION /* 907201100 */:
            case ErrorCode.CODE_TAG_NOT_EXISTS /* 907201111 */:
            case ErrorCode.CODE_BLUETOOTH_PERMISSION_FAILED /* 907201116 */:
            case ErrorCode.CODE_CONNECT_FAIL /* 907201121 */:
            case ErrorCode.CODE_DECLINE_TAG_SOUND /* 907201127 */:
            case ErrorCode.CODE_DECLINE_TAG_BLE_MEASURE /* 907201128 */:
            case 907201132:
            case 907201133:
            case ErrorCode.CODE_OTA /* 907201155 */:
            case ErrorCode.CODE_DEVICE_BUSY /* 907201157 */:
            case ErrorCode.CODE_FAST_SCAN_TIMEOUT /* 907201161 */:
            case ErrorCode.CODE_TAG_IN_CONNECTING /* 907201165 */:
            case ErrorCode.CODE_TAG_COMMAND_EXECUTE_FAIL /* 907201166 */:
                break;
            case ErrorCode.STATUS_ERROR_MIC_USED /* 907201011 */:
                C11880m.m71337d(context, context.getString(R$string.record_conflict));
                break;
            case ErrorCode.CODE_COMMAND_REPEAT /* 907201137 */:
                C11880m.m71337d(context, context.getString(R$string.please_not_operate_fast));
                break;
            default:
                C11880m.m71337d(context, str);
                break;
        }
    }

    /* renamed from: t0 */
    public static /* synthetic */ void m57426t0(Intent intent) {
        C13108a.m78878b(C0213f.m1377a()).m78882e(intent);
    }

    /* renamed from: u0 */
    public static /* synthetic */ void m57428u0(String str, WapFindPhoneActivity.HandlerC4536g handlerC4536g, FindNetworkResult findNetworkResult) {
        C13981a.m83989i("TagUtil", "queryDeviceCapabilities addOnSuccessListener");
        if (findNetworkResult.getRespCode() == 0) {
            m57392h1(str, (DeviceDetail) findNetworkResult.getData(), handlerC4536g);
            return;
        }
        C13981a.m83988e("TagUtil", "queryDeviceCapabilities resultCode: " + findNetworkResult.getRespCode());
    }

    /* renamed from: w0 */
    public static /* synthetic */ Boolean m57432w0(Context context, final String str, final WapFindPhoneActivity.HandlerC4536g handlerC4536g) throws Exception {
        try {
            FindNetwork.getFindNetworkEngine(context).queryDeviceDetail(str).addOnSuccessListener(new InterfaceC8939g() { // from class: dg.i
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    C9120m0.m57428u0(str, handlerC4536g, (FindNetworkResult) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: dg.j
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C13981a.m83988e("TagUtil", "queryDeviceCapabilities addOnFailureListener");
                }
            });
        } catch (Exception unused) {
            C13981a.m83988e("TagUtil", "queryDeviceCapabilities Exception");
        }
        return Boolean.TRUE;
    }

    /* renamed from: x0 */
    public static /* synthetic */ void m57434x0(Exception exc) {
        C13981a.m83988e("TagUtil", "queryDeviceCapabilities exception:" + exc.getMessage());
    }

    /* renamed from: z0 */
    public static /* synthetic */ void m57438z0(Function function, FindNetworkResult findNetworkResult) {
        C13981a.m83989i("TagUtil", "queryPairedDevicesFromFN success.");
        if (findNetworkResult == null || findNetworkResult.getData() == null) {
            return;
        }
        Iterator it = ((List) findNetworkResult.getData()).iterator();
        while (it.hasNext() && !((Boolean) function.apply((PairedDeviceInfo) it.next())).booleanValue()) {
        }
    }
}
