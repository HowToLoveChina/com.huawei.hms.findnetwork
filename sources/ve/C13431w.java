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

/* renamed from: ve.w */
/* loaded from: classes4.dex */
public class C13431w {

    /* renamed from: a */
    public Context f60524a;

    /* renamed from: b */
    public AncillaryDeviceInfo f60525b;

    /* renamed from: c */
    public Handler.Callback f60526c;

    /* renamed from: ve.w$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, InterruptedException {
            C13981a.m83989i("UpdateAncillaryDeviceInfo", "do update Ancillary Device");
            String strM80728f = C13431w.this.m80728f();
            String strM76774a = C12797b.m76774a("01022");
            RequestModeConfig.getInstance().setMode(3082, true);
            C4346d.m26226e(3082, strM80728f, C13431w.this.f60526c, C13431w.this.f60524a, strM76774a);
        }
    }

    public C13431w(Context context, AncillaryDeviceInfo ancillaryDeviceInfo, Handler.Callback callback) {
        this.f60524a = context;
        this.f60525b = ancillaryDeviceInfo;
        this.f60526c = callback;
    }

    /* renamed from: e */
    public void m80727e() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: f */
    public final String m80728f() throws JSONException, InterruptedException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Connectivity", this.f60525b.getConnectivity());
            jSONObject2.put("IRK", this.f60525b.getIrk());
            jSONObject2.put("DeviceBtMac", this.f60525b.getDeviceBtMac());
            jSONObject2.put("HBPK", this.f60525b.getHbkp());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("perDeviceType", this.f60525b.getPerDeviceType());
            jSONObject3.put("capability", this.f60525b.getFindCapability());
            jSONObject3.put("deviceID", this.f60525b.getDeviceID());
            jSONObject3.put("deviceID_Alias", this.f60525b.getDeviceID());
            jSONObject3.put("deviceName", this.f60525b.getDeviceName());
            jSONObject3.put("goodsType", this.f60525b.getGoodsType());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("DeviceType", this.f60525b.getDeviceType());
            jSONObject4.put("ModelID", this.f60525b.getModelId());
            jSONObject4.put("SubmodelID", this.f60525b.getSubModelId());
            jSONObject4.put("SubDeviceType", this.f60525b.getSubDeviceType());
            jSONObject3.put("perDeviceTypeInfo", jSONObject4.toString());
            jSONObject3.put("extInfo", jSONObject2.toString());
            jSONObject3.put("componentType", this.f60525b.getComponentType());
            jSONObject3.put(VastAttribute.SEQUENCE, this.f60525b.getSequence());
            jSONObject3.put("deviceSn", this.f60525b.getDeviceSn());
            jSONObject3.put("deviceList", this.f60525b.getDeviceList());
            if (C13168a.m79183l(this.f60525b.getPerDeviceType())) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Task<FindNetworkStatusResult> taskAddOnCompleteListener = FindNetwork.getFindNetworkEngine(this.f60524a).queryFindNetworkStatus().addOnCompleteListener(new InterfaceC8937e() { // from class: ve.v
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        countDownLatch.countDown();
                    }
                });
                C13981a.m83989i("UpdateAncillaryDeviceInfo", "countDownLatch wait:" + countDownLatch.await(30L, TimeUnit.SECONDS));
                jSONObject3.put("isContainTeeDevice", taskAddOnCompleteListener.getResult().isSupportCrossDevices());
                jSONObject3.put("masterDeviceId", C13452e.m80781L().m80950o());
            }
            jSONObject.put("version", "v11");
            jSONObject.put("deviceActiveInfo", jSONObject3);
            return jSONObject.toString();
        } catch (Exception e10) {
            C13981a.m83988e("UpdateAncillaryDeviceInfo", "encaseDeviceInfo failed, JSONException:" + e10.getMessage());
            return null;
        }
    }
}
