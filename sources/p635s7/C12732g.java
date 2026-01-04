package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.AlbumUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p650t7.C12961e;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.g */
/* loaded from: classes2.dex */
public class C12732g extends AbstractC12758w {

    /* renamed from: l */
    public List<GeneralAlbumData> f58318l;

    public C12732g(Context context, String str, List<GeneralAlbumData> list, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.album.batchcreate";
        this.f58318l = list;
        m76585v(str2);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        Gson gson = new Gson();
        JSONArray jSONArray = new JSONArray();
        for (GeneralAlbumData generalAlbumData : this.f58318l) {
            try {
                JSONObject jSONObject2 = new JSONObject(gson.toJson(generalAlbumData));
                if (!TextUtils.isEmpty(generalAlbumData.getExpandString())) {
                    JSONObject jSONObject3 = new JSONObject(generalAlbumData.getExpandString());
                    jSONObject2.remove("expandString");
                    jSONObject2.put("expand", jSONObject3);
                }
                jSONArray.put(jSONObject2);
            } catch (JSONException unused) {
                C1120a.m6676e("CreateGeneralAlbumsRequest", "appendMainBody error");
            }
        }
        jSONObject.put("albumList", jSONArray);
        jSONObject.put("galleryVer", C1122c.m6833t0(this.f60186b));
        this.f60188d = jSONObject.toString();
        C1120a.m6675d("CreateGeneralAlbumsRequest", this.f58397k);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Albums.create";
        C12961e c12961e = new C12961e(this.f58318l, this.f60189e);
        c12961e.m82456i(this.f60189e);
        return c12961e;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundleM76559x = C12734h.m76559x("CreateGeneralAlbumsRequest", this.f58318l, str);
        ArrayList parcelableArrayList = bundleM76559x.getParcelableArrayList("AlbumUpdatedResultList");
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                AlbumUpdatedResult albumUpdatedResult = (AlbumUpdatedResult) it.next();
                int errCode = albumUpdatedResult.getErrCode();
                if (errCode == 21 || errCode == 4 || errCode == 2) {
                    SyncSessionManager.m15153t().m15177a("cloudphoto.album.batchcreate", this.f60189e, albumUpdatedResult.getAlbumId());
                }
            }
        }
        return bundleM76559x;
    }
}
