package ve;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceDBHelper;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import java.util.List;
import p677ue.C13168a;
import p738we.InterfaceC13594a;
import p809yg.C13981a;

/* renamed from: ve.d */
/* loaded from: classes4.dex */
public class C13412d extends AbstractC1177c implements InterfaceC13594a {
    public C13412d(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
    }

    /* renamed from: W */
    public final void m80715W() {
        List<AncillaryDeviceInfo> listM26109x = AncillaryDeviceManager.m26080y().m26109x("1", "1");
        C13981a.m83989i("AncillaryDeviceDel", "send find device list:" + listM26109x.size());
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("findDeviceList", C13168a.m79178e(listM26109x));
        new C13168a("sendFindDevList", bundle).m79190g();
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: c */
    public boolean mo26024c() {
        return true;
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: f */
    public boolean mo26025f() {
        m80715W();
        return true;
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: g */
    public boolean mo26026g() {
        m80715W();
        return true;
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        String cmdParamValue = this.f5581b.getCmdParamValue("perDeviceType");
        String cmdParamValue2 = this.f5581b.getCmdParamValue("perDeviceId");
        if (TextUtils.isEmpty(cmdParamValue) || TextUtils.isEmpty(cmdParamValue2)) {
            C13981a.m83988e("AncillaryDeviceDel", "Ancillary device id is empty");
        } else {
            if (AncillaryDeviceDBHelper.m26045e(this.f5580a).m26050c(cmdParamValue2) != -1) {
                m81752h(cmdParamValue);
                return;
            }
            this.f5582c = 1;
            m7417D(null);
            C13981a.m83988e("AncillaryDeviceDel", "Delete ancillary device error");
        }
    }
}
