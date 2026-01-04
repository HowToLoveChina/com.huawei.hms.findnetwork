package com.huawei.hms.findnetwork.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.findnetwork.FindNetworkEngine;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.request.TextApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.StartNavigateRequestBen;
import com.huawei.hms.findnetwork.comm.request.bean.TagStatus;
import com.huawei.hms.findnetwork.comm.request.bean.UltrasoundSettings;
import com.huawei.hms.findnetwork.comm.request.bean.wear.FidRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.comm.util.MaskUtil;
import com.huawei.hms.findnetwork.sdk.C5381n;
import com.huawei.hms.findnetwork.ultrasound.entity.MeasureResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.findnetwork.util.PermissionUtil;
import com.ultrasoniclibrary.ultrasoundcore.classfun.FreqParam;
import p208cq.C8943k;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p208cq.InterfaceC8940h;
import p268ew.C9570a;
import p379j.InterfaceC10635a;

/* renamed from: com.huawei.hms.findnetwork.sdk.n */
/* loaded from: classes8.dex */
public class C5381n {

    /* renamed from: d */
    public static volatile C5381n f24791d;

    /* renamed from: a */
    public final C5386o1 f24793a = new C5386o1();

    /* renamed from: b */
    public final Handler f24794b = new a(Looper.getMainLooper());

    /* renamed from: c */
    public static final String[] f24790c = {"android.permission.RECORD_AUDIO"};

    /* renamed from: e */
    public static final Object f24792e = new Object();

    /* renamed from: com.huawei.hms.findnetwork.sdk.n$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 35) {
                C5345b.m31985b().m31991a(true);
                C5345b.m31985b().m31989a();
            }
        }
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.n$b */
    public class b implements InterfaceC5346b0 {

        /* renamed from: a */
        public final /* synthetic */ FindNetworkEngine f24796a;

        /* renamed from: b */
        public final /* synthetic */ Context f24797b;

        /* renamed from: c */
        public final /* synthetic */ DeviceDetail f24798c;

        /* renamed from: d */
        public final /* synthetic */ FindNetworkCallback f24799d;

        public b(FindNetworkEngine findNetworkEngine, Context context, DeviceDetail deviceDetail, FindNetworkCallback findNetworkCallback) {
            this.f24796a = findNetworkEngine;
            this.f24797b = context;
            this.f24798c = deviceDetail;
            this.f24799d = findNetworkCallback;
        }

        @Override // com.huawei.hms.findnetwork.sdk.InterfaceC5346b0
        /* renamed from: a */
        public void mo31998a() {
            HmsFindSDKLog.m32128w("FindExactSdkManager", "#OnAudioRecordListener.onStop");
        }

        @Override // com.huawei.hms.findnetwork.sdk.InterfaceC5346b0
        public void onStart() {
            C5381n.this.m32027b(this.f24796a, this.f24797b, this.f24798c, this.f24799d);
        }
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.n$c */
    public class c implements InterfaceC5383n1 {

        /* renamed from: a */
        public Runnable f24801a = null;

        /* renamed from: b */
        public boolean f24802b = false;

        /* renamed from: c */
        public final /* synthetic */ FindNetworkCallback f24803c;

        /* renamed from: d */
        public final /* synthetic */ FindNetworkEngine f24804d;

        /* renamed from: e */
        public final /* synthetic */ String f24805e;

        /* renamed from: f */
        public final /* synthetic */ DeviceDetail f24806f;

        public c(FindNetworkCallback findNetworkCallback, FindNetworkEngine findNetworkEngine, String str, DeviceDetail deviceDetail) {
            this.f24803c = findNetworkCallback;
            this.f24804d = findNetworkEngine;
            this.f24805e = str;
            this.f24806f = deviceDetail;
        }

        /* renamed from: a */
        public final void m32032a() {
            HmsFindSDKLog.m32127i("FindExactSdkManager", "onNavigateStartCompleted");
            this.f24802b = true;
            Runnable runnable = this.f24801a;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.huawei.hms.findnetwork.sdk.InterfaceC5383n1
        /* renamed from: a */
        public void mo32033a(int i10, String str) {
            C5381n.this.m32019a(i10, str, this.f24803c, new Runnable() { // from class: fq.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f48028a.m32032a();
                }
            }, this.f24804d, this.f24805e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m32030a(FindNetworkEngine findNetworkEngine, DeviceDetail deviceDetail, FreqParam freqParam, FindNetworkCallback findNetworkCallback) {
            C5381n.this.m32022a(findNetworkEngine, deviceDetail, freqParam, findNetworkCallback);
            this.f24801a = null;
        }

        @Override // com.huawei.hms.findnetwork.sdk.InterfaceC5383n1
        /* renamed from: a */
        public void mo32034a(MeasureResult measureResult) {
            if (measureResult == null) {
                HmsFindSDKLog.m32127i("FindExactSdkManager", "receive nearby ultrasound measureResult is null");
                return;
            }
            HmsFindSDKLog.m32127i("FindExactSdkManager", "receive Nearby ultrasound measuring ----");
            C5381n.this.f24793a.m32054a(this.f24803c, JsonUtils.object2Json(measureResult));
        }

        @Override // com.huawei.hms.findnetwork.sdk.InterfaceC5383n1
        /* renamed from: a */
        public void mo32035a(final FreqParam freqParam) {
            HmsFindSDKLog.m32127i("FindExactSdkManager", "onFreqParamAdjust");
            if (this.f24802b) {
                C5381n.this.m32022a(this.f24804d, this.f24806f, freqParam, this.f24803c);
                return;
            }
            final FindNetworkEngine findNetworkEngine = this.f24804d;
            final DeviceDetail deviceDetail = this.f24806f;
            final FindNetworkCallback findNetworkCallback = this.f24803c;
            this.f24801a = new Runnable() { // from class: fq.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f48023a.m32030a(findNetworkEngine, deviceDetail, freqParam, findNetworkCallback);
                }
            };
        }
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.n$d */
    public static class d extends FindNetworkResult<DeviceDetail> {
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.n$e */
    public static class e extends FindNetworkResult<TagStatus> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Task m31999a(FindNetworkCallback findNetworkCallback, FindNetworkEngine findNetworkEngine, String str, String str2, String str3) throws Exception {
        e eVar = (e) JsonUtils.json2Object(str3, e.class);
        TagStatus data = eVar != null ? eVar.getData() : null;
        if (data == null) {
            String str4 = "invalid resp: " + str3;
            this.f24793a.m32056c(findNetworkCallback, ErrorCode.STATUS_ERROR_NEARBY_MEASURERESULT, str4);
            return C8943k.m56663c(new FindNetworkException(str4, -1));
        }
        if (m32023a(data.getStatus())) {
            return findNetworkEngine.doWrite(new TextApiCall("findnetwork.queryDeviceDetail", str, str2));
        }
        String str5 = "Accessory busy: " + data.getStatus();
        this.f24793a.m32056c(findNetworkCallback, ErrorCode.CODE_DEVICE_BUSY, str5);
        return C8943k.m56663c(new FindNetworkException(str5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Void m32010b(String str) {
        m32029c(str);
        return null;
    }

    /* renamed from: c */
    public void m32029c(String str) {
        C5389p1 c5389p1M32060a = C5389p1.m32060a();
        if (c5389p1M32060a.m32094c()) {
            this.f24794b.removeMessages(35);
            this.f24794b.sendEmptyMessageDelayed(35, 20000L);
            c5389p1M32060a.m32093b(str);
        }
    }

    /* renamed from: a */
    public final SnRequestBean m32017a(String str, FindNetworkEngine findNetworkEngine) {
        SnRequestBean snRequestBean = new SnRequestBean();
        findNetworkEngine.fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return snRequestBean;
    }

    /* renamed from: b */
    public void m32026b() {
        C5389p1.m32060a().m32096e();
        this.f24794b.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    public static C5381n m32000a() {
        if (f24791d == null) {
            synchronized (f24792e) {
                try {
                    if (f24791d == null) {
                        f24791d = new C5381n();
                    }
                } finally {
                }
            }
        }
        return f24791d;
    }

    /* renamed from: b */
    public void m32027b(FindNetworkEngine findNetworkEngine, Context context, DeviceDetail deviceDetail, FindNetworkCallback findNetworkCallback) {
        if (findNetworkEngine == null) {
            HmsFindSDKLog.m32126e("FindExactSdkManager", "startUltrasonicMeasure engine is null");
            this.f24793a.m32056c(findNetworkCallback, ErrorCode.STATUS_ERROR_NEARBY_MEASURERESULT, "startUltrasonicMeasure engine is null");
            return;
        }
        C5389p1 c5389p1M32060a = C5389p1.m32060a();
        if (c5389p1M32060a.m32094c()) {
            c5389p1M32060a.m32096e();
        }
        String sn2 = deviceDetail.getSn();
        UltrasoundSettings ultrasoundSettings = new UltrasoundSettings();
        ultrasoundSettings.setTagStatus(0);
        ultrasoundSettings.setTemperature(0.0f);
        ultrasoundSettings.setUltrasoundTxTime(-1L);
        ultrasoundSettings.setAlpha(2);
        ultrasoundSettings.setStartUltrasoundMeasuringTime(C5345b.m31985b().m31994c());
        c5389p1M32060a.m32087a(context, deviceDetail, ultrasoundSettings, new c(findNetworkCallback, findNetworkEngine, sn2, deviceDetail));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m32011b(FindNetworkCallback findNetworkCallback, Exception exc) {
        String message = exc.getMessage();
        HmsFindSDKLog.m32128w("FindExactSdkManager", message);
        if (exc instanceof ApiException) {
            this.f24793a.m32056c(findNetworkCallback, ErrorCode.STATUS_ERROR_NEARBY_MEASURERESULT, message);
        }
    }

    /* renamed from: a */
    public final String m32018a(String str, String str2) {
        return TransactionIdCreater.getId(str, str2);
    }

    /* renamed from: b */
    public boolean m32028b(Context context, FindNetworkCallback findNetworkCallback) {
        boolean zCheckAppHavePermission = PermissionUtil.checkAppHavePermission(context, context.getPackageName(), f24790c);
        HmsFindSDKLog.m32127i("FindExactSdkManager", "startNavigate findApp hasPermission: " + zCheckAppHavePermission);
        if (!zCheckAppHavePermission) {
            this.f24793a.m32056c(findNetworkCallback, ErrorCode.STATUS_ERROR_NOT_HAVE_PERMISSION_RECORD_AUDIO, ErrorCode.STR_ERROR_NOT_HAVE_PERMISSION_RECORD_AUDIO);
        }
        return zCheckAppHavePermission;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Void m32002a(FindNetworkCallback findNetworkCallback, Runnable runnable, ResponseErrorCode responseErrorCode) {
        String str;
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setRespCode(responseErrorCode.getStatusCode());
        findNetworkResult.setData(null);
        if (findNetworkResult.getRespCode() == 0) {
            findNetworkCallback.onSuccess(findNetworkResult);
            runnable.run();
            str = "callback.onSuccess over";
        } else {
            C5345b.m31985b().m31997f();
            m32026b();
            findNetworkCallback.onFail(findNetworkResult);
            str = " callback.onFail() over";
        }
        HmsFindSDKLog.m32127i("FindExactSdkManager", str);
        return null;
    }

    /* renamed from: a */
    public final void m32019a(int i10, String str, final FindNetworkCallback findNetworkCallback, final Runnable runnable, FindNetworkEngine findNetworkEngine, String str2) {
        if (i10 != 0) {
            String str3 = "startUltrasoundMeasuring onResult: " + i10 + " " + str;
            HmsFindSDKLog.m32127i("FindExactSdkManager", "startUltrasoundMeasuring msg: " + str3);
            this.f24793a.m32056c(findNetworkCallback, ErrorCode.STATUS_ERROR_NEARBY_MEASURERESULT, str3);
            return;
        }
        StartNavigateRequestBen startNavigateRequestBen = new StartNavigateRequestBen();
        findNetworkEngine.fillRequestBase(startNavigateRequestBen);
        startNavigateRequestBen.setConnectTagSn(str2);
        startNavigateRequestBen.setAdditional(str);
        startNavigateRequestBen.setRestart(C5345b.m31985b().m31995d());
        startNavigateRequestBen.setStartRecordTime(C5345b.m31985b().m31994c());
        findNetworkEngine.doWrite(new C5356e1(startNavigateRequestBen, new InterfaceC10635a() { // from class: fq.r
            @Override // p379j.InterfaceC10635a
            public final Object apply(Object obj) {
                return this.f48019a.m32002a(findNetworkCallback, runnable, (ResponseErrorCode) obj);
            }
        }, new InterfaceC10635a() { // from class: fq.s
            @Override // p379j.InterfaceC10635a
            public final Object apply(Object obj) {
                return this.f48022a.m32010b((String) obj);
            }
        }));
        HmsFindSDKLog.m32127i("FindExactSdkManager", "startRecordTime" + C5345b.m31985b().m31994c());
        this.f24793a.m32055c(findNetworkCallback);
    }

    /* renamed from: a */
    public void m32020a(FindNetworkEngine findNetworkEngine, Context context, DeviceDetail deviceDetail, FindNetworkCallback findNetworkCallback) {
        C5345b.m31985b().m31991a(false);
        C5345b.m31985b().m31993b(new b(findNetworkEngine, context, deviceDetail, findNetworkCallback));
    }

    /* renamed from: a */
    public void m32021a(final FindNetworkEngine findNetworkEngine, final Context context, final String str, final FindNetworkCallback findNetworkCallback) {
        if (!m32028b(context, findNetworkCallback)) {
            HmsFindSDKLog.m32128w("FindExactSdkManager", "isAppHavePermission false");
            return;
        }
        final String strM32018a = m32018a(findNetworkEngine.getAppID(), "findnetwork.start_navigate");
        final String strObject2Json = JsonUtils.object2Json(m32017a(str, findNetworkEngine));
        HmsFindSDKLog.m32127i("FindExactSdkManager", "startupNavigate." + strM32018a);
        findNetworkEngine.doWrite(new TextApiCall("findnetwork.query_tag_derived_status", strObject2Json, strM32018a)).addOnFailureListener(new InterfaceC8938f() { // from class: fq.l
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f48005a.m32004a(findNetworkCallback, exc);
            }
        }).onSuccessTask(new InterfaceC8940h() { // from class: fq.m
            @Override // p208cq.InterfaceC8940h
            /* renamed from: a */
            public final Task mo56654a(Object obj) {
                return this.f48007a.m31999a(findNetworkCallback, findNetworkEngine, strObject2Json, strM32018a, (String) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: fq.n
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f48012a.m32011b(findNetworkCallback, exc);
            }
        }).addOnSuccessListener(new InterfaceC8939g() { // from class: fq.o
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f48014a.m32003a(findNetworkCallback, context, findNetworkEngine, str, (String) obj);
            }
        });
    }

    /* renamed from: a */
    public final void m32022a(FindNetworkEngine findNetworkEngine, DeviceDetail deviceDetail, FreqParam freqParam, FindNetworkCallback findNetworkCallback) {
        FidRequestBean fidRequestBean = new FidRequestBean();
        fidRequestBean.setFid(deviceDetail.getSn());
        fidRequestBean.setAdditional(JsonUtils.object2Json(freqParam));
        findNetworkEngine.fillRequestBase(fidRequestBean);
        HmsFindSDKLog.m32128w("FindExactSdkManager", "adjustFreqParam2Accessory " + MaskUtil.maskSn(fidRequestBean.getFid()) + fidRequestBean.getAdditional());
        findNetworkEngine.doWrite(new TextApiCall("findnetwork.navigate_freqparam_update", JsonUtils.object2Json(fidRequestBean), m32018a(findNetworkEngine.getAppID(), "findnetwork.navigate_freqparam_update"))).addOnFailureListener(new InterfaceC8938f() { // from class: fq.p
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                HmsFindSDKLog.m32126e("FindExactSdkManager", "adjustFreqParam2Accessory.onFailed " + exc.getMessage());
            }
        }).addOnSuccessListener(new InterfaceC8939g() { // from class: fq.q
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                C5381n.m32009a((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32003a(FindNetworkCallback findNetworkCallback, Context context, FindNetworkEngine findNetworkEngine, String str, String str2) {
        d dVar = (d) JsonUtils.json2Object(str2, d.class);
        String str3 = "invalid resp: " + str2;
        if (dVar == null || dVar.getData() == null) {
            HmsFindSDKLog.m32128w("FindExactSdkManager", str3);
            this.f24793a.m32056c(findNetworkCallback, ErrorCode.STATUS_ERROR_NEARBY_MEASURERESULT, str3);
            return;
        }
        DeviceDetail data = dVar.getData();
        if (!m32025a(context, data.getProductId(), data.getSequence())) {
            String str4 = "FindExactSdkManager not support Product." + data.getProductId() + " #" + data.getSequence();
            HmsFindSDKLog.m32128w("FindExactSdkManager", str4);
            this.f24793a.m32056c(findNetworkCallback, ErrorCode.STATUS_ERROR_NOT_SUPPORT_TAG_CURRENT_VERSION, str4);
        }
        if (m32024a(context, findNetworkCallback)) {
            m32020a(findNetworkEngine, context, data, findNetworkCallback);
            C5399t.m32099a().m32105c(str, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32004a(FindNetworkCallback findNetworkCallback, Exception exc) {
        String message = exc.getMessage();
        HmsFindSDKLog.m32128w("FindExactSdkManager", message);
        this.f24793a.m32056c(findNetworkCallback, ErrorCode.STATUS_ERROR_NEARBY_MEASURERESULT, message);
    }

    /* renamed from: a */
    public static /* synthetic */ void m32009a(String str) {
        C5389p1 c5389p1M32060a = C5389p1.m32060a();
        if (c5389p1M32060a.m32094c()) {
            c5389p1M32060a.m32089a(str);
        }
    }

    /* renamed from: a */
    public final boolean m32023a(int i10) {
        return i10 == 7 || i10 == 1;
    }

    /* renamed from: a */
    public boolean m32024a(Context context, FindNetworkCallback findNetworkCallback) throws IllegalStateException {
        C5386o1 c5386o1;
        int i10;
        String str;
        int iM31987a = C5345b.m31985b().m31987a(context, C9570a.m59702t().m59741u());
        if (iM31987a == 0) {
            return true;
        }
        if (iM31987a == -2) {
            HmsFindSDKLog.m32127i("FindExactSdkManager", "the mic is used");
            c5386o1 = this.f24793a;
            i10 = ErrorCode.STATUS_ERROR_MIC_USED;
            str = ErrorCode.STR_ERROR_MIC_USED;
        } else {
            if (iM31987a != -1) {
                return false;
            }
            HmsFindSDKLog.m32127i("FindExactSdkManager", "the audioRecord is not release");
            c5386o1 = this.f24793a;
            i10 = ErrorCode.STATUS_ERROR_START_AUDIO_RECORD_FAILED;
            str = ErrorCode.STR_ERROR_START_AUDIO_RECORD_FAILED;
        }
        c5386o1.m32056c(findNetworkCallback, i10, str);
        return false;
    }

    /* renamed from: a */
    public boolean m32025a(Context context, String str, int i10) {
        return C9570a.m59702t().m59726e(context, str, i10);
    }
}
