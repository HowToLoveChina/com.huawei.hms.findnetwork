package p635s7;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.TagVersionResponse;
import org.json.JSONObject;
import p031b7.C1120a;

/* renamed from: s7.n0 */
/* loaded from: classes2.dex */
public class C12747n0 extends AbstractC12758w {
    public C12747n0(Context context, String str) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h("/JPJX/CloudPhoto4Atlas");
        this.f58397k = "atlas.query.version";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        C1120a.m6675d("TagVersionRequest", "atlas.query.version");
        this.f60188d = jSONObject.toString();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        try {
            TagVersionResponse tagVersionResponse = (TagVersionResponse) new Gson().fromJson(str, TagVersionResponse.class);
            if (tagVersionResponse != null) {
                bundle.putString("tagVersion", tagVersionResponse.getTversion());
                bundle.putInt("code", tagVersionResponse.getCode());
                bundle.putString("info", tagVersionResponse.getInfo());
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("TagVersionRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
