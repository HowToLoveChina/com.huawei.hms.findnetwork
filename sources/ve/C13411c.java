package ve;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkStatusResult;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import eg.AbstractC9478g;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.InterfaceC8937e;
import p616rk.C12515a;
import p677ue.C13168a;
import p709vj.C13452e;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: ve.c */
/* loaded from: classes4.dex */
public class C13411c {

    /* renamed from: a */
    public Context f60502a;

    /* renamed from: b */
    public AncillaryDeviceInfo f60503b;

    /* renamed from: c */
    public Handler.Callback f60504c;

    /* renamed from: ve.c$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, InterruptedException {
            C13981a.m83989i("AncillaryDeviceActive", "do Active Ancillary Device");
            String strM80714f = C13411c.this.m80714f();
            String strM76774a = C12797b.m76774a("01021");
            RequestModeConfig.getInstance().setMode(3081, true);
            C4346d.m26226e(3081, strM80714f, C13411c.this.f60504c, C13411c.this.f60502a, strM76774a);
        }
    }

    public C13411c(Context context, AncillaryDeviceInfo ancillaryDeviceInfo, Handler.Callback callback) {
        this.f60502a = context;
        this.f60503b = ancillaryDeviceInfo;
        this.f60504c = callback;
    }

    /* renamed from: e */
    public void m80713e() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: f */
    public final String m80714f() throws JSONException, InterruptedException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("perDeviceType", this.f60503b.getPerDeviceType());
            jSONObject2.put("capability", this.f60503b.getFindCapability());
            jSONObject2.put("deviceID", this.f60503b.getDeviceID());
            jSONObject2.put("deviceID_Alias", this.f60503b.getDeviceID());
            jSONObject2.put("deviceName", this.f60503b.getDeviceName());
            jSONObject2.put("goodsType", this.f60503b.getGoodsType());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("DeviceType", this.f60503b.getDeviceType());
            jSONObject3.put("ModelID", this.f60503b.getModelId());
            jSONObject3.put("SubmodelID", this.f60503b.getSubModelId());
            jSONObject3.put("SubDeviceType", this.f60503b.getSubDeviceType());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("Connectivity", this.f60503b.getConnectivity());
            jSONObject4.put("IRK", this.f60503b.getIrk());
            jSONObject4.put("DeviceBtMac", this.f60503b.getDeviceBtMac());
            jSONObject4.put("HBPK", this.f60503b.getHbkp());
            jSONObject2.put("perDeviceTypeInfo", jSONObject3.toString());
            jSONObject2.put("extInfo", jSONObject4.toString());
            jSONObject2.put("componentType", this.f60503b.getComponentType());
            jSONObject2.put(VastAttribute.SEQUENCE, this.f60503b.getSequence());
            jSONObject2.put("deviceSn", this.f60503b.getDeviceSn());
            if (this.f60503b.getDeviceList() != null) {
                jSONObject2.put("deviceList", this.f60503b.getDeviceList());
            }
            if (C13168a.m79183l(this.f60503b.getPerDeviceType())) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Task<FindNetworkStatusResult> taskAddOnCompleteListener = FindNetwork.getFindNetworkEngine(this.f60502a).queryFindNetworkStatus().addOnCompleteListener(new InterfaceC8937e() { // from class: ve.b
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        countDownLatch.countDown();
                    }
                });
                C13981a.m83989i("AncillaryDeviceActive", "countDownLatch wait:" + countDownLatch.await(30L, TimeUnit.SECONDS));
                jSONObject2.put("isContainTeeDevice", taskAddOnCompleteListener.getResult().isSupportCrossDevices());
                jSONObject2.put("masterDeviceId", C13452e.m80781L().m80950o());
            }
            if (C13168a.m79186o(this.f60503b.getPerDeviceType())) {
                boolean zIsConnected = this.f60503b.isConnected();
                jSONObject.put("isConnected", zIsConnected);
                C13981a.m83989i("AncillaryDeviceActive", "encaseDeviceInfo wearDevice is connected: " + zIsConnected);
                new C12797b().m76784j(this.f60502a, "AncillaryDeviceActive", "0", "encaseDeviceInfo wearDevice is connected: " + zIsConnected, null, "01021", null, "active_ancDevice", true);
            }
            jSONObject.put("version", "v11");
            jSONObject.put("active", 1);
            jSONObject.put("deviceActiveInfo", jSONObject2);
            return jSONObject.toString();
        } catch (Exception unused) {
            C13981a.m83988e("AncillaryDeviceActive", "encaseDeviceInfo failed! JSONException");
            return null;
        }
    }
}
