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

/* renamed from: ve.x */
/* loaded from: classes4.dex */
public class C13432x extends AbstractC4380a {

    /* renamed from: c */
    public String f60528c;

    /* renamed from: d */
    public Handler.Callback f60529d;

    /* renamed from: ve.x$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f60530a;

        public a(Context context) {
            this.f60530a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13981a.m83989i("ActiveAncillaryDeviceRetry", "do update ancillary device info");
            String strM76774a = C12797b.m76774a("01022");
            RequestModeConfig.getInstance().setMode(3082, false);
            C4346d.m26226e(3082, C13432x.this.f60528c, C13432x.this.f60529d, this.f60530a, strM76774a);
        }
    }

    public C13432x(String str, Handler.Callback callback) {
        this.f60528c = str;
        this.f60529d = callback;
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
