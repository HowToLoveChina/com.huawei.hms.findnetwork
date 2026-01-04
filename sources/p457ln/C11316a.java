package p457ln;

import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import p015ak.C0241z;

/* renamed from: ln.a */
/* loaded from: classes6.dex */
public class C11316a implements InterfaceC11317b {

    /* renamed from: a */
    public int f53010a;

    public C11316a(String str) {
        this.f53010a = C0241z.m1685c(str);
    }

    @Override // p457ln.InterfaceC11317b
    public void cancelNotify() {
    }

    @Override // p457ln.InterfaceC11317b
    public void sendNotify() {
        CloudSpaceNotifyUtil.getInstance().getSpaceProxy().sendBackupFailNotify(this.f53010a);
    }
}
