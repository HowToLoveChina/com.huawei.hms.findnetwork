package p702v7;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import p031b7.C1120a;
import p731w7.AbstractC13546m;

/* renamed from: v7.a */
/* loaded from: classes2.dex */
public class C13362a extends AbstractC13546m<Bundle> {

    /* renamed from: a */
    public CallbackHandler f60241a;

    /* renamed from: b */
    public Context f60242b;

    public C13362a(Context context, CallbackHandler callbackHandler) {
        this.f60241a = callbackHandler;
        this.f60242b = context;
    }

    @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
    /* renamed from: a */
    public void mo15144a(int i10, Response<Bundle> response) {
        C1120a.m6676e("CommonResponseListener", "Network Request or Business Failed, Id: " + i10);
        m80154g(i10, true, response.get());
    }

    @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
    /* renamed from: e */
    public void mo15148e(int i10, Response<Bundle> response) {
        C1120a.m6675d("CommonResponseListener", "Request Succeed, Id: " + i10);
        m80153f(i10, response.get());
    }

    /* renamed from: f */
    public final void m80153f(int i10, Bundle bundle) {
        m80154g(i10, false, bundle);
    }

    /* renamed from: g */
    public final void m80154g(int i10, boolean z10, Bundle bundle) {
        CallbackHandler callbackHandler = this.f60241a;
        if (callbackHandler == null) {
            return;
        }
        if (z10) {
            i10 += 100;
        }
        callbackHandler.sendMessage(i10, bundle);
    }
}
