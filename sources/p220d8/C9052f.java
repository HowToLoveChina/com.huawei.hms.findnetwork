package p220d8;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.able.Requestable;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import com.huawei.android.hicloud.album.service.p075vo.SmartAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.SmartTagData;
import p031b7.C1120a;
import p635s7.C12722b;
import p635s7.C12726d;
import p635s7.C12728e;
import p635s7.C12745m0;
import p635s7.C12747n0;
import p731w7.AbstractC13546m;
import p731w7.C13536c;

/* renamed from: d8.f */
/* loaded from: classes2.dex */
public class C9052f {

    /* renamed from: a */
    public Context f45735a;

    /* renamed from: b */
    public CallbackHandler f45736b;

    /* renamed from: c */
    public Requestable f45737c;

    /* renamed from: d */
    public AbstractC13546m<Bundle> f45738d = new a();

    /* renamed from: d8.f$a */
    public class a extends AbstractC13546m<Bundle> {
        public a() {
        }

        @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
        /* renamed from: a */
        public void mo15144a(int i10, Response<Bundle> response) {
            int i11 = i10 + 100;
            C1120a.m6676e("TagSyncLogic", "Request Failed, Id: " + i11);
            C9052f.this.f45736b.sendMessage(i11, response.get());
        }

        @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
        /* renamed from: e */
        public void mo15148e(int i10, Response<Bundle> response) {
            C1120a.m6675d("TagSyncLogic", "Request Succeed, Id: " + i10);
            C9052f.this.f45736b.sendMessage(i10, response.get());
        }
    }

    public C9052f(Context context, CallbackHandler callbackHandler, Requestable requestable) {
        this.f45735a = context;
        this.f45736b = callbackHandler;
        this.f45737c = requestable;
    }

    /* renamed from: b */
    public void m57103b(SmartTagData smartTagData, String str, String str2) {
        this.f45737c.request(9084, str2, new C13536c(), new C12722b(this.f45735a, str2, smartTagData, str), this.f45738d);
    }

    /* renamed from: c */
    public void m57104c(String str) {
        this.f45737c.request(9081, str, new C13536c(), new C12726d(this.f45735a, str), this.f45738d);
    }

    /* renamed from: d */
    public void m57105d(SmartTagData smartTagData, String str, String str2) {
        this.f45737c.request(9085, str2, new C13536c(), new C12728e(this.f45735a, str2, smartTagData, str), this.f45738d);
    }

    /* renamed from: e */
    public void m57106e(SmartAlbumData smartAlbumData, String str, String str2) {
        this.f45737c.request(9083, str2, new C13536c(), new C12745m0(this.f45735a, str2, smartAlbumData, str), this.f45738d);
    }

    /* renamed from: f */
    public void m57107f(String str) {
        this.f45737c.request(9082, str, new C13536c(), new C12747n0(this.f45735a, str), this.f45738d);
    }
}
