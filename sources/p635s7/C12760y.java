package p635s7;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.ShortLinkResponse;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12990x;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.y */
/* loaded from: classes2.dex */
public class C12760y extends AbstractC12758w {

    /* renamed from: l */
    public String f58398l;

    public C12760y(Context context, String str) throws Throwable {
        this.f60186b = context;
        this.f58398l = str;
        this.f60187c = m80109h(C13720b.m82484e());
        m80115r();
        this.f58397k = "cloudphoto.link.create";
        m80104c(str);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "cloudphoto.link.create");
        jSONObject.put("albumId", this.f58398l);
        C1120a.m6675d("LinkCreateRequest", "cloudphoto.link.create");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Albums.get";
        return new C12990x(this.f58398l);
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("shareId", this.f58398l);
        try {
            ShortLinkResponse shortLinkResponse = (ShortLinkResponse) new Gson().fromJson(str, ShortLinkResponse.class);
            if (shortLinkResponse == null) {
                C1120a.m6676e("LinkCreateRequest", "getResponseBundle response is null");
                return bundle;
            }
            int code = shortLinkResponse.getCode();
            C1120a.m6677i("LinkCreateRequest", "cloudphoto.link.create code: " + code);
            bundle.putInt("code", code);
            bundle.putString("info", shortLinkResponse.getInfo());
            bundle.putString("ShortLink", shortLinkResponse.getLink());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("LinkCreateRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
