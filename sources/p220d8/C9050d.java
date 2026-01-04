package p220d8;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.able.Requestable;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import com.huawei.android.hicloud.album.service.logic.callable.GroupIdCallable;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.request.threadpool.C2333n;
import java.util.ArrayList;
import java.util.List;
import p031b7.C1120a;
import p031b7.C1122c;
import p635s7.C12720a;
import p635s7.C12724c;
import p635s7.C12727d0;
import p635s7.C12739j0;
import p635s7.C12741k0;
import p635s7.C12743l0;
import p635s7.C12751p0;
import p635s7.C12752q;
import p635s7.C12755t;
import p635s7.C12760y;
import p709vj.C13452e;
import p731w7.AbstractC13546m;
import p731w7.C13536c;

/* renamed from: d8.d */
/* loaded from: classes2.dex */
public class C9050d {

    /* renamed from: a */
    public Context f45725a;

    /* renamed from: b */
    public CallbackHandler f45726b;

    /* renamed from: c */
    public Requestable f45727c;

    /* renamed from: d */
    public AbstractC13546m<Bundle> f45728d = new a();

    /* renamed from: d8.d$a */
    public class a extends AbstractC13546m<Bundle> {
        public a() {
        }

        @Override // p731w7.AbstractC13546m, com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener
        /* renamed from: d */
        public void mo15147d(int i10, Response<Bundle> response) {
            C1120a.m6675d("ShareServiceLogic", "Request result, Id: " + i10);
            C9050d.this.f45726b.sendMessage(i10, response.get());
        }
    }

    public C9050d(Context context, CallbackHandler callbackHandler, Requestable requestable) {
        this.f45725a = context;
        this.f45726b = callbackHandler;
        this.f45727c = requestable;
    }

    /* renamed from: j */
    public static String m57079j(Context context, Media media) {
        FileData fileData = new FileData();
        fileData.setUniqueId(media.getId());
        fileData.setHash(media.getHashId());
        fileData.setUserID(media.getMediaOwnerId());
        fileData.setAlbumId(media.getAlbumId());
        C12755t c12755t = new C12755t(context, fileData);
        try {
            Bundle bundleM76583s = c12755t.m76583s(c12755t.mo76565p());
            if (bundleM76583s != null) {
                return bundleM76583s.getString("PlayUrl", "");
            }
            C1120a.m6675d("ShareServiceLogic", "bundle is null");
            return null;
        } catch (Exception e10) {
            C1120a.m6676e("ShareServiceLogic", "getVideoPlayUrl error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: b */
    public void m57080b(ShareAlbumData shareAlbumData) {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        ArrayList arrayList = new ArrayList();
        ShareReceiverData shareReceiverData = new ShareReceiverData();
        shareReceiverData.setReceiverId(strM80971t0);
        arrayList.add(shareReceiverData);
        this.f45727c.requestSingle(9075, new C13536c(), new C12743l0(this.f45725a, shareAlbumData, arrayList, null, 2, this.f45726b), this.f45728d);
    }

    /* renamed from: c */
    public void m57081c(List<String> list) {
        this.f45727c.requestSingle(9086, new C13536c(), new C12720a(this.f45725a, list), this.f45728d);
    }

    /* renamed from: d */
    public void m57082d(String str, String str2, String str3) {
        this.f45727c.request(9036, str3, new C13536c(), new C12724c(this.f45725a, str, str2), this.f45728d);
    }

    /* renamed from: e */
    public void m57083e(ShareAlbumData shareAlbumData) {
        this.f45727c.requestSingle(9071, new C13536c(), new C12727d0(this.f45725a, shareAlbumData), this.f45728d);
    }

    /* renamed from: f */
    public void m57084f(String str) {
        this.f45727c.requestSingle(9076, new C13536c(), new C12760y(this.f45725a, str), this.f45728d);
    }

    /* renamed from: g */
    public void m57085g(List<String> list) {
        String strM6755Z0 = C1122c.m6755Z0("04007");
        this.f45727c.request(9078, strM6755Z0, new C13536c(), new C12751p0(this.f45725a, list, strM6755Z0), this.f45728d);
    }

    /* renamed from: h */
    public void m57086h() {
        C2333n.m14663f().m14673l(new GroupIdCallable(this.f45726b), true);
    }

    /* renamed from: i */
    public void m57087i() {
        String strM6755Z0 = C1122c.m6755Z0("04007");
        this.f45727c.request(9203, strM6755Z0, new C13536c(), new C12752q(this.f45725a, strM6755Z0), this.f45728d);
    }

    /* renamed from: k */
    public void m57088k(FileData fileData) {
        this.f45727c.request(9201, C1122c.m6755Z0("04001"), new C13536c(), new C12755t(this.f45725a, fileData), this.f45728d);
    }

    /* renamed from: l */
    public void m57089l(ShareAlbumData shareAlbumData) {
        String strM6755Z0 = C1122c.m6755Z0("04007");
        this.f45727c.request(9206, strM6755Z0, new C13536c(), new C12743l0(this.f45725a, strM6755Z0, shareAlbumData), this.f45728d);
    }

    /* renamed from: m */
    public void m57090m(String str, int i10) {
        this.f45727c.requestSingle(9077, new C13536c(), new C12739j0(this.f45725a, str, i10), this.f45728d);
    }

    /* renamed from: n */
    public void m57091n(ShareAlbumData shareAlbumData, List<ShareReceiverData> list, int i10) {
        if (i10 == 0) {
            this.f45727c.requestSingle(9072, new C13536c(), new C12743l0(this.f45725a, shareAlbumData, null, list, i10, this.f45726b), this.f45728d);
        } else if (1 == i10) {
            this.f45727c.requestSingle(9072, new C13536c(), new C12743l0(this.f45725a, shareAlbumData, list, null, i10, this.f45726b), this.f45728d);
        }
    }

    /* renamed from: o */
    public void m57092o(String str, String str2, int i10) {
        this.f45727c.requestSingle(9074, new C13536c(), new C12741k0(this.f45725a, str, str2, i10), this.f45728d);
    }
}
