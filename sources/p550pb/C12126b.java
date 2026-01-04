package p550pb;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.icloudpay.ICloudPayProtocol;

/* renamed from: pb.b */
/* loaded from: classes3.dex */
public class C12126b {

    /* renamed from: a */
    public static ICloudPayProtocol f56240a;

    /* renamed from: a */
    public static synchronized void m72705a(Context context) {
        C12125a c12125aM72704c = C12125a.m72704c();
        f56240a = c12125aM72704c;
        if (c12125aM72704c != null) {
            c12125aM72704c.mo16406b(context);
        }
    }

    /* renamed from: b */
    public static void m72706b(Context context, String str, Bundle bundle, boolean z10, int i10) {
        ICloudPayProtocol iCloudPayProtocol = f56240a;
        if (iCloudPayProtocol != null) {
            iCloudPayProtocol.mo16405a(context, str, bundle, z10, i10);
        }
    }

    /* renamed from: c */
    public static void m72707c(String str, Bundle bundle) {
        ICloudPayProtocol iCloudPayProtocol = f56240a;
        if (iCloudPayProtocol != null) {
            iCloudPayProtocol.mo16405a(null, str, bundle, false, 0);
        }
    }
}
