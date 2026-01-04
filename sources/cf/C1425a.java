package cf;

import android.content.Context;
import android.content.Intent;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import p809yg.C13981a;

/* renamed from: cf.a */
/* loaded from: classes4.dex */
public class C1425a extends AbstractC1177c {
    public C1425a(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        C13981a.m83987d("DeviceDel", "handleControlCmd");
        this.f5580a.sendBroadcast(new Intent("com.huawei.remotecontrol.OFF_REMOTE"), "com.huawei.remotocontrol.permission.REMOTECALL");
        this.f5582c = 0;
        m7417D(null);
    }
}
