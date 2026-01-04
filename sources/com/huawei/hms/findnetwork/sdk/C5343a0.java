package com.huawei.hms.findnetwork.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.huawei.hiar.ARPose;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetworkEngine;
import com.huawei.hms.findnetwork.bean.BtMeasureResult;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.NearLinkNavigationResult;
import com.huawei.hms.findnetwork.comm.request.bean.SetArPoseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.callback.NearLinkNavigationCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkStatusResult;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.comm.util.MaskUtil;
import com.huawei.hms.findnetwork.sdk.C5355e0;
import com.huawei.hms.findnetwork.sdk.C5359f1;
import com.huawei.hms.findnetwork.sdk.C5412z;
import com.huawei.hms.findnetwork.threadpool.ThreadExec;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import java.util.Map;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* renamed from: com.huawei.hms.findnetwork.sdk.a0 */
/* loaded from: classes8.dex */
public class C5343a0 {

    /* renamed from: a */
    public final FindNetworkEngine f24753a;

    /* renamed from: b */
    public final SnRequestBean f24754b;

    /* renamed from: c */
    public final NearLinkNavigationCallback f24755c;

    /* renamed from: d */
    public boolean f24756d = false;

    /* renamed from: e */
    public C5412z.c f24757e = new c();

    /* renamed from: com.huawei.hms.findnetwork.sdk.a0$a */
    public class a extends FindNetworkCallback<BtMeasureResult> {
        public a() {
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<BtMeasureResult> findNetworkResult) {
            HmsFindSDKLog.m32128w("NearLinkNavigationProxy", "startBTMeasure onFail:" + findNetworkResult.getRespCode());
            if (findNetworkResult.getRespCode() != 907201165) {
                C5412z.m32114b().m32120a(new Runnable() { // from class: fq.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f48001a.m31973a();
                    }
                }, 5000L);
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<BtMeasureResult> findNetworkResult) {
            HmsFindSDKLog.m32127i("NearLinkNavigationProxy", "startBTMeasure onSuccess");
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onUpdate(FindNetworkResult<BtMeasureResult> findNetworkResult) {
            if (findNetworkResult != null) {
                C5412z.m32114b().m32117a(findNetworkResult.getData());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m31973a() {
            C5343a0.this.m31970d();
        }
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.a0$b */
    public class b implements C5359f1.a {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m31976c() {
            Pair<Integer, ARPose> pairM31946b = C5342a.m31942c().m31946b();
            C5343a0.this.m31967a(((Integer) pairM31946b.first).intValue() == 0 ? (ARPose) pairM31946b.second : null);
        }

        @Override // com.huawei.hms.findnetwork.sdk.C5359f1.a
        /* renamed from: b */
        public void mo31980b() {
            C5343a0.this.f24755c.onSuccess();
            C5412z.m32114b().m32119a(C5343a0.this.f24757e);
        }

        @Override // com.huawei.hms.findnetwork.sdk.C5359f1.a
        /* renamed from: a */
        public void mo31977a() {
            ThreadExec.execNormalTask("NearLinkNavigationProxy", new Runnable() { // from class: fq.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f48002a.m31976c();
                }
            });
        }

        @Override // com.huawei.hms.findnetwork.sdk.C5359f1.a
        /* renamed from: a */
        public void mo31978a(int i10, String str) {
            if (i10 != 907201165) {
                HmsFindSDKLog.m32126e("NearLinkNavigationProxy", "onFailed errorCode:" + i10);
                C5343a0.this.f24755c.onFail(i10, str);
                C5412z.m32114b().m32122d();
            }
        }

        @Override // com.huawei.hms.findnetwork.sdk.C5359f1.a
        /* renamed from: a */
        public void mo31979a(NearLinkNavigationResult nearLinkNavigationResult) {
            C5412z.m32114b().m32118a(nearLinkNavigationResult);
        }
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.a0$c */
    public class c implements C5412z.c {
        public c() {
        }

        @Override // com.huawei.hms.findnetwork.sdk.C5412z.c
        /* renamed from: a */
        public void mo31981a() {
            HmsFindSDKLog.m32126e("NearLinkNavigationProxy", "onRemoteDied, restartMeasure");
            C5343a0.this.m31969c();
        }

        @Override // com.huawei.hms.findnetwork.sdk.C5412z.c
        /* renamed from: a */
        public void mo31982a(int i10, NearLinkNavigationResult nearLinkNavigationResult) {
            HmsFindSDKLog.m32127i("NearLinkNavigationProxy", "onUpdate, " + nearLinkNavigationResult + ", stateCode:" + i10);
            C5343a0.this.f24755c.onRangingResult(i10, nearLinkNavigationResult);
        }
    }

    public C5343a0(FindNetworkEngine findNetworkEngine, SnRequestBean snRequestBean, NearLinkNavigationCallback nearLinkNavigationCallback) {
        this.f24753a = findNetworkEngine;
        this.f24754b = snRequestBean;
        this.f24755c = nearLinkNavigationCallback;
    }

    /* renamed from: c */
    public final void m31969c() {
        try {
            this.f24753a.queryFindNetworkStatus().addOnSuccessListener(new InterfaceC8939g() { // from class: fq.b
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    this.f47996a.m31951a((FindNetworkStatusResult) obj);
                }
            });
        } catch (FindNetworkException e10) {
            HmsFindSDKLog.m32126e("NearLinkNavigationProxy", "restartMeasure err:" + e10.getMessage());
        }
    }

    /* renamed from: d */
    public final void m31970d() {
        HmsFindSDKLog.m32127i("NearLinkNavigationProxy", MaskUtil.maskSn(this.f24754b.getConnectTagSn()) + " startBTMeasure start.");
        ThreadExec.execNormalTask("NearLinkNavigationProxy", new Runnable() { // from class: fq.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f48000a.m31957b();
            }
        });
    }

    /* renamed from: e */
    public final Task<Void> m31971e() {
        HmsFindSDKLog.m32127i("NearLinkNavigationProxy", "startNearLinkMeasure start.");
        return this.f24753a.doWrite(new C5359f1(this.f24754b, new b()));
    }

    /* renamed from: f */
    public Task<Void> m31972f() {
        HmsFindSDKLog.m32127i("NearLinkNavigationProxy", "stopNearLinkNavigation");
        C5412z.m32114b().m32122d();
        C5342a.m31942c().m31944a();
        this.f24753a.doWrite(new C5368i1(this.f24754b, new FindNetworkCallback()));
        return this.f24753a.doWrite(new C5374k1(this.f24754b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31950a() {
        SystemClock.sleep(100L);
        HmsFindSDKLog.m32127i("NearLinkNavigationProxy", "restartMeasure start.");
        if (this.f24756d) {
            m31970d();
        }
        m31971e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31957b() {
        this.f24753a.doWrite(new C5344a1(this.f24754b, new a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31958b(FindNetworkResult findNetworkResult) {
        if (m31968a((FindNetworkResult<DeviceDetail>) findNetworkResult)) {
            this.f24756d = true;
            m31970d();
        }
        m31971e();
    }

    /* renamed from: a */
    public void m31966a(Context context) throws FindNetworkException {
        int iM31945b = C5342a.m31942c().m31945b(context);
        if (iM31945b != 0) {
            this.f24755c.onFail(iM31945b, ErrorCode.getStatusCode(iM31945b));
        } else {
            HmsFindSDKLog.m32127i("NearLinkNavigationProxy", "startNearLinkNavigation start.");
            this.f24753a.doWrite(new C5355e0(this.f24754b)).addOnSuccessListener(new InterfaceC8939g() { // from class: fq.c
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    this.f47997a.m31958b((FindNetworkResult) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: fq.d
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    this.f47998a.m31960b(exc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31960b(Exception exc) {
        HmsFindSDKLog.m32126e("NearLinkNavigationProxy", "query detail failed:" + exc.getMessage());
        this.f24755c.onFail(-1, exc.getMessage());
    }

    /* renamed from: a */
    public final void m31967a(ARPose aRPose) {
        SetArPoseRequestBean setArPoseRequestBean = new SetArPoseRequestBean();
        setArPoseRequestBean.setDeviceId(this.f24754b.getConnectTagSn());
        if (aRPose != null) {
            setArPoseRequestBean.setOutQx(aRPose.m29067qx());
            setArPoseRequestBean.setOutQy(aRPose.m29068qy());
            setArPoseRequestBean.setOutQz(aRPose.m29069qz());
            setArPoseRequestBean.setOutQw(aRPose.m29066qw());
            setArPoseRequestBean.setOutTx(aRPose.m29070tx());
            setArPoseRequestBean.setOutTy(aRPose.m29071ty());
            setArPoseRequestBean.setOutTz(aRPose.m29072tz());
        }
        this.f24753a.doWrite(new C5400t0(setArPoseRequestBean)).addOnSuccessListener(new InterfaceC8939g() { // from class: fq.e
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                HmsFindSDKLog.m32127i("NearLinkNavigationProxy", "setArPoseDataToFn succeed");
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: fq.f
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                HmsFindSDKLog.m32127i("NearLinkNavigationProxy", "setArPoseDataToFn failed");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31951a(FindNetworkStatusResult findNetworkStatusResult) {
        ThreadExec.execNormalTask("NearLinkNavigationProxy", new Runnable() { // from class: fq.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f47999a.m31950a();
            }
        });
    }

    /* renamed from: a */
    public final boolean m31968a(FindNetworkResult<DeviceDetail> findNetworkResult) {
        String str;
        if (findNetworkResult == null || findNetworkResult.getData() == null) {
            str = "parameter invalid.";
        } else {
            Map map = (Map) JsonUtils.json2Object(findNetworkResult.getData().getAccessoryCapabilities(), C5355e0.b.class);
            if (map != null && map.containsKey(DeviceDetail.CAP_KEY_BLE_MEASURE_DISTANCE) && ((Integer) map.get(DeviceDetail.CAP_KEY_BLE_MEASURE_DISTANCE)).intValue() != 0) {
                return true;
            }
            str = "not support BTMeasure.";
        }
        HmsFindSDKLog.m32128w("NearLinkNavigationProxy", str);
        return false;
    }
}
