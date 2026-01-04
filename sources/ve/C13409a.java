package ve;

import android.content.Context;
import android.os.Handler;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.phonefinder.AbstractC4380a;
import eg.AbstractC9478g;
import p616rk.C12515a;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: ve.a */
/* loaded from: classes4.dex */
public class C13409a extends AbstractC4380a {

    /* renamed from: c */
    public String f60497c;

    /* renamed from: d */
    public Handler.Callback f60498d;

    /* renamed from: ve.a$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f60499a;

        public a(Context context) {
            this.f60499a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13981a.m83989i("ActiveAncillaryDeviceRetry", "do active ancillary device");
            String strM76774a = C12797b.m76774a("01021");
            RequestModeConfig.getInstance().setMode(3081, false);
            C4346d.m26226e(3081, C13409a.this.f60497c, C13409a.this.f60498d, this.f60499a, strM76774a);
        }
    }

    public C13409a(String str, Handler.Callback callback) {
        this.f60497c = str;
        this.f60498d = callback;
    }

    @Override // com.huawei.android.remotecontrol.phonefinder.AbstractC4380a
    /* renamed from: c */
    public void mo26440c(Context context) {
        C13981a.m83989i("ActiveAncillaryDeviceRetry", "NetworkChangeReceiver release, retry active ancillary device info");
        if (C1175a.m7389k(context)) {
            C12515a.m75110o().m75175e(new a(context), false);
        }
    }
}
