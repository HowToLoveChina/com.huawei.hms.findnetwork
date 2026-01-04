package p635s7;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import org.json.JSONObject;
import p650t7.C12963f;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* renamed from: s7.e0 */
/* loaded from: classes2.dex */
public class C12729e0 extends AbstractC12758w {

    /* renamed from: l */
    public ShareAlbumData f58311l;

    /* renamed from: m */
    public String f58312m = "0";

    public C12729e0(Context context, String str, ShareAlbumData shareAlbumData) throws Throwable {
        this.f60186b = context;
        this.f60189e = str;
        this.f58311l = shareAlbumData;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.album.delete";
        if (shareAlbumData != null) {
            m80104c(shareAlbumData.getShareId());
        }
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        ShareAlbumData shareAlbumData = this.f58311l;
        if (shareAlbumData != null) {
            jSONObject.put("albumId", shareAlbumData.getShareId());
        }
        jSONObject.put("recycle", this.f58312m);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Albums.delete";
        C12963f c12963f = new C12963f(this.f58311l.getShareId(), this.f58311l);
        c12963f.m82456i(this.f60189e);
        return c12963f;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundleM82485a = C13721c.m82485a(str);
        bundleM82485a.putParcelable("ShareInfo", this.f58311l);
        return bundleM82485a;
    }
}
