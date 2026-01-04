package vg;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkScanResult;
import eg.AbstractC9478g;
import fk.C9721b;
import java.util.function.Consumer;
import p015ak.C0225l;
import p227dg.C9120m0;
import p575qe.C12347f;
import p616rk.C12515a;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import vg.C13435b;

/* renamed from: vg.b */
/* loaded from: classes4.dex */
public class C13435b {

    /* renamed from: a */
    public static FindNetworkCallback<FindNetworkScanResult> f60536a;

    /* renamed from: b */
    public static WapFindPhoneActivity.HandlerC4536g f60537b;

    /* renamed from: c */
    public static Consumer<FindNetworkResult<FindNetworkScanResult>> f60538c;

    /* renamed from: vg.b$a */
    public class a extends FindNetworkCallback<FindNetworkScanResult> {
        /* renamed from: b */
        public static /* synthetic */ void m80745b(Boolean bool) {
            C13981a.m83989i("DeviceScanManager", "statScanDevice sendFindNetworkStatusToNearby result: " + bool);
            if (bool.booleanValue()) {
                C13435b.m80741e().m80743g(C13435b.f60538c, C13435b.f60537b);
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<FindNetworkScanResult> findNetworkResult) {
            C13981a.m83988e("DeviceScanManager", "statScanDevice onFail: " + findNetworkResult.getRespCode());
            if (findNetworkResult.getRespCode() == 907201003) {
                if (C13435b.f60538c != null) {
                    C13435b.f60538c.accept(null);
                }
            } else if (findNetworkResult.getRespCode() == 907201000) {
                C4375j.m26396J(C12347f.m74285n().m74301m(), true, new Consumer() { // from class: vg.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C13435b.a.m80745b((Boolean) obj);
                    }
                });
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onUpdate(FindNetworkResult<FindNetworkScanResult> findNetworkResult) {
            C13981a.m83989i("DeviceScanManager", "statScanDevice onUpdate, deviceSn: " + C9120m0.m57351R(findNetworkResult.getData().getmSN()) + ", deviceResult: " + findNetworkResult.getData().getmStatus());
            if (C13435b.f60537b != null) {
                C13435b.m80742f(findNetworkResult.getData().getmSN(), findNetworkResult.getData().getmStatus(), C13435b.f60537b);
            }
            if (C13435b.f60538c != null) {
                C13435b.f60538c.accept(findNetworkResult);
            }
        }
    }

    /* renamed from: vg.b$b */
    public class b extends AbstractC9478g {
        public b() {
        }

        /* renamed from: e */
        public static /* synthetic */ Task m80748e(Context context) throws Exception {
            return FindNetwork.getFindNetworkEngine(context).startFastScan(C13435b.f60536a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public static /* synthetic */ void m80749f(Exception exc) {
            C13981a.m83988e("DeviceScanManager", "statScanDevice exception:" + exc.getMessage());
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C13981a.m83989i("DeviceScanManager", "statScanDevice");
            final Context contextM74301m = C12347f.m74285n().m74301m();
            C0225l.m1577a(new InterfaceC14356c() { // from class: vg.c
                @Override // p851zp.InterfaceC14356c
                public final Object execute() {
                    return C13435b.b.m80748e(contextM74301m);
                }
            }, new Consumer() { // from class: vg.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C13435b.b.m80749f((Exception) obj);
                }
            });
        }
    }

    /* renamed from: vg.b$c */
    public static class c {

        /* renamed from: a */
        public static final C13435b f60540a = new C13435b();
    }

    /* renamed from: e */
    public static C13435b m80741e() {
        if (f60536a == null) {
            f60536a = new a();
        }
        return c.f60540a;
    }

    /* renamed from: f */
    public static void m80742f(String str, int i10, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        C13981a.m83989i("DeviceScanManager", "sendFastDiscoveryDeviceResult, deviceId: " + C9120m0.m57351R(str) + ", connectStatus: " + i10);
        try {
            Message message = new Message();
            message.what = FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN;
            Bundle bundle = new Bundle();
            bundle.putString("tagSn", str);
            bundle.putInt("exeResult", i10);
            message.obj = bundle;
            f60537b.handleMessage(message);
        } catch (Exception e10) {
            C13981a.m83988e("DeviceScanManager", "sendFastDiscoveryDeviceResult, exception: " + e10.getMessage());
        }
    }

    /* renamed from: g */
    public void m80743g(Consumer<FindNetworkResult<FindNetworkScanResult>> consumer, WapFindPhoneActivity.HandlerC4536g handlerC4536g) {
        if (handlerC4536g != null) {
            f60537b = handlerC4536g;
        }
        if (consumer != null) {
            f60538c = consumer;
        }
        C12515a.m75110o().m75172d(new b());
    }
}
