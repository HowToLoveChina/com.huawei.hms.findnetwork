package p281f8;

import android.content.Context;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1123d;

/* renamed from: f8.d */
/* loaded from: classes2.dex */
public class C9667d {

    /* renamed from: a */
    public C9674k f47849a;

    /* renamed from: b */
    public Context f47850b;

    public C9667d(Context context, C9674k c9674k) {
        this.f47850b = context;
        this.f47849a = c9674k;
    }

    /* renamed from: b */
    public static boolean m60368b(int i10) {
        C1120a.m6675d("NetworkProcessor", "isNetworkDisable netType: " + i10);
        return i10 != 4;
    }

    /* renamed from: a */
    public void m60369a() {
        int iM6855a = C1123d.m6855a(this.f47850b);
        boolean zM60368b = true;
        if (iM6855a == 1) {
            C1120a.m6678w("NetworkProcessor", "Unknown network type!");
        } else {
            zM60368b = m60368b(iM6855a);
        }
        this.f47849a.m60427q(16, zM60368b);
    }

    /* renamed from: c */
    public void m60370c(Context context, String str) {
        int iM6855a = C1123d.m6855a(context);
        if (iM6855a == 1) {
            C1120a.m6678w("NetworkProcessor", "processDetail netType not change");
            return;
        }
        if (iM6855a == 0 && !Version.isSupportMobileData()) {
            this.f47849a.m60402H();
        }
        if (!"com.huawei.cg.action.CHECK_WIFI_ENV".equals(str)) {
            CloudAlbumManager.m14456v().m14487g(context);
        }
        C1120a.m6675d("NetworkProcessor", "setNetWorkDisconnected: " + C0209d.m1333z1(context));
        this.f47849a.m60403I(C0209d.m1333z1(context) ^ true);
        this.f47849a.m60404J(m60368b(iM6855a));
    }
}
