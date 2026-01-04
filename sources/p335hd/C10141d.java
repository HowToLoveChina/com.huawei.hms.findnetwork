package p335hd;

import android.content.Context;
import com.huawei.hms.network.embedded.C5843a0;
import p015ak.C0209d;
import p514o9.C11839m;

/* renamed from: hd.d */
/* loaded from: classes3.dex */
public class C10141d extends C10145h {
    public C10141d(Context context, boolean z10) {
        super(context, z10);
    }

    @Override // p335hd.C10145h, p616rk.AbstractRunnableC12516b
    public void call() throws InterruptedException {
        C11839m.m70688i("DelayedPushNotifyControlTask", "DelayedPushNotifyControlTask start");
        int iM1260h0 = C0209d.m1260h0(0, C5843a0.f26297c);
        C11839m.m70688i("DelayedPushNotifyControlTask", "DelayedPushNotifyControlTask delay time millisecond: " + iM1260h0);
        try {
            Thread.sleep(iM1260h0);
        } catch (Exception e10) {
            C11839m.m70689w("DelayedPushNotifyControlTask", "DelayedPushNotifyControlTask sleep exception " + e10.toString());
        }
        super.call();
        C11839m.m70688i("DelayedPushNotifyControlTask", "DelayedPushNotifyControlTask end");
    }
}
