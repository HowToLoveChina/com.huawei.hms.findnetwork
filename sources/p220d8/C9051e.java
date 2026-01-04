package p220d8;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.able.Requestable;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.p069cg.logic.app.HmsSnsApp;
import com.huawei.hms.api.ConnectionResult;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0074l;
import p031b7.C1120a;
import p635s7.C12729e0;
import p635s7.C12731f0;
import p635s7.C12733g0;
import p635s7.C12735h0;
import p635s7.C12737i0;
import p635s7.C12743l0;
import p635s7.C12752q;
import p635s7.C12756u;
import p731w7.AbstractC13546m;
import p731w7.C13536c;

/* renamed from: d8.e */
/* loaded from: classes2.dex */
public class C9051e {

    /* renamed from: a */
    public Context f45730a;

    /* renamed from: b */
    public CallbackHandler f45731b;

    /* renamed from: c */
    public Requestable f45732c;

    /* renamed from: d */
    public AbstractC13546m<Bundle> f45733d = new a();

    /* renamed from: d8.e$a */
    public class a extends AbstractC13546m<Bundle> {
        public a() {
        }

        @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
        /* renamed from: a */
        public void mo15144a(int i10, Response<Bundle> response) {
            int i11 = i10 + 100;
            C1120a.m6676e("ShareSyncLogic", "Request Failed, Id: " + i11);
            C9051e.this.f45731b.sendMessage(i11, response.get());
        }

        @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
        /* renamed from: e */
        public void mo15148e(int i10, Response<Bundle> response) {
            C1120a.m6675d("ShareSyncLogic", "Request Succeed, Id: " + i10);
            C9051e.this.f45731b.sendMessage(i10, response.get());
        }
    }

    public C9051e(Context context, CallbackHandler callbackHandler, Requestable requestable) {
        this.f45730a = context;
        this.f45731b = callbackHandler;
        this.f45732c = requestable;
    }

    /* renamed from: b */
    public void m57094b(ShareAlbumData shareAlbumData, String str) {
        this.f45732c.request(9028, str, new C13536c(), new C12729e0(this.f45730a, str, shareAlbumData), this.f45733d);
    }

    /* renamed from: c */
    public void m57095c(String str, String str2, List<FileData> list, String str3) {
        C0074l.m603c().m611i(true);
        this.f45732c.request(9038, str3, new C13536c(), new C12731f0(this.f45730a, str3, str, str2, list), this.f45733d);
    }

    /* renamed from: d */
    public void m57096d(ShareAlbumData shareAlbumData, int i10, String str) {
        this.f45732c.request(9017, str, new C13536c(), new C12735h0(this.f45730a, str, shareAlbumData.getOwnerId(), shareAlbumData.getShareId(), shareAlbumData.getResource(), i10), this.f45733d);
    }

    /* renamed from: e */
    public void m57097e(ShareAlbumData shareAlbumData, String str, String str2) {
        this.f45732c.request(9018, str2, new C13536c(), new C12733g0(this.f45730a, str2, shareAlbumData, str), this.f45733d);
    }

    /* renamed from: f */
    public void m57098f(String str) {
        String[] strArrM14425e = HmsSnsApp.m14419h().m14425e();
        if (strArrM14425e.length >= 1) {
            this.f45732c.request(9015, str, new C13536c(), new C12756u(this.f45730a, strArrM14425e, str), this.f45733d);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("GroupInfoList", new ArrayList<>());
        bundle.putInt("code", 0);
        bundle.putString("info", "no groupList");
        bundle.putParcelable("HttpResult", new HttpResult(200, 0, "no groupList"));
        bundle.putString("sessionId", str);
        this.f45731b.sendMessage(9015, bundle);
    }

    /* renamed from: g */
    public void m57099g(String str) {
        this.f45732c.request(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, str, new C13536c(), new C12737i0(this.f45730a, str, "3"), this.f45733d);
    }

    /* renamed from: h */
    public void m57100h(String str) {
        this.f45732c.request(9016, str, new C13536c(), new C12752q(this.f45730a, str), this.f45733d);
    }

    /* renamed from: i */
    public void m57101i(ShareAlbumData shareAlbumData, String str) {
        this.f45732c.request(9027, str, new C13536c(), new C12743l0(this.f45730a, str, shareAlbumData), this.f45733d);
    }
}
