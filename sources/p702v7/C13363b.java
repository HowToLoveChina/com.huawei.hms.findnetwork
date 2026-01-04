package p702v7;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import com.huawei.android.p069cg.request.threadpool.C2333n;
import p031b7.C1120a;
import p801y7.C13916d;

/* renamed from: v7.b */
/* loaded from: classes2.dex */
public class C13363b extends C13362a {

    /* renamed from: c */
    public static int f60243c;

    public C13363b(Context context, CallbackHandler callbackHandler) {
        super(context, callbackHandler);
    }

    /* renamed from: h */
    public static int m80155h() {
        return f60243c;
    }

    /* renamed from: j */
    public static void m80156j(int i10) {
        f60243c = i10;
    }

    @Override // p702v7.C13362a, p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
    /* renamed from: a */
    public void mo15144a(int i10, Response<Bundle> response) {
        C1120a.m6675d("KeepLockResponseListener", "Request result, Id: " + i10);
        if (34 == response.mo15149a()) {
            C13916d.m83407q(this.f60242b, this.f60241a, 34);
        }
        super.mo15144a(i10, response);
    }

    @Override // p702v7.C13362a, p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
    /* renamed from: e */
    public void mo15148e(int i10, Response<Bundle> response) {
        C1120a.m6675d("KeepLockResponseListener", "Request result, Id: " + i10);
        super.mo15148e(i10, response);
        String string = response.get().getString("sessionId");
        if (C13916d.m83409y(string)) {
            C13916d c13916d = new C13916d(this.f60242b, this.f60241a, null, string);
            if (m80157i()) {
                m80156j(0);
                return;
            }
            m80156j(m80155h() + 1);
            if (f60243c > 3) {
                c13916d.m83418r(Boolean.FALSE, string);
            }
        }
    }

    /* renamed from: i */
    public final boolean m80157i() {
        return (C2333n.m14663f().m14668g().isEmpty() && C2333n.m14663f().m14669h().isEmpty()) ? false : true;
    }
}
