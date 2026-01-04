package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p650t7.C12992z;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.b0 */
/* loaded from: classes2.dex */
public class C12723b0 extends AbstractC12758w {

    /* renamed from: l */
    public List<GeneralAlbumData> f58297l;

    public C12723b0(Context context, String str, List<GeneralAlbumData> list, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f58297l = list;
        m76585v(str2);
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.album.batchupdate";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        Gson gson = new Gson();
        JSONArray jSONArray = new JSONArray();
        for (GeneralAlbumData generalAlbumData : this.f58297l) {
            jSONArray = m76549w(gson.toJson(generalAlbumData), jSONArray, generalAlbumData);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("albumList", jSONArray);
        jSONObject.put("galleryVer", C1122c.m6833t0(this.f60186b));
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Albums.update.patchmetadata";
        C12992z c12992z = new C12992z(this.f58297l);
        c12992z.m82456i(this.f60189e);
        return c12992z;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        return C12734h.m76559x("ModifyGeneralAlbumsRequest", this.f58297l, str);
    }

    /* renamed from: w */
    public final JSONArray m76549w(String str, JSONArray jSONArray, GeneralAlbumData generalAlbumData) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(generalAlbumData.getExpandString())) {
                jSONObject.put("expand", new JSONObject(generalAlbumData.getExpandString()));
                jSONObject.remove("expandString");
            }
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
            C1120a.m6676e("ModifyGeneralAlbumsRequest", "getAlbumList error");
        }
        return jSONArray;
    }
}
