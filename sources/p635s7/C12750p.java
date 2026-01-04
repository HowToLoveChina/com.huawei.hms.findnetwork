package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.AlbumQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12982p;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* renamed from: s7.p */
/* loaded from: classes2.dex */
public class C12750p extends AbstractC12758w {

    /* renamed from: l */
    public JSONArray f58378l;

    /* renamed from: m */
    public String f58379m;

    /* renamed from: n */
    public int f58380n = 100;

    /* renamed from: o */
    public ArrayList<GeneralAlbumData> f58381o = new ArrayList<>();

    /* renamed from: p */
    public int f58382p;

    /* renamed from: q */
    public String f58383q;

    public C12750p(Context context, String str) {
        this.f58378l = null;
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.album.batchquery";
        JSONArray jSONArray = new JSONArray();
        this.f58378l = jSONArray;
        jSONArray.put(0);
        this.f58378l.put(3);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("albumType", this.f58378l);
        jSONObject.put(SyncProtocol.Constant.CURSOR, this.f58379m);
        jSONObject.put("limit", this.f58380n);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Albums.list";
        C12982p c12982p = new C12982p();
        c12982p.m82456i(this.f60189e);
        return c12982p;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: p */
    public String mo76565p() throws Exception {
        return CloudAlbumSettings.m14363h().m14376l() ? super.mo76565p() : m76578w();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("GetGeneralAlbumsBatchRequest", "getResponseBundle body is empty!");
            return C13721c.m82487c(101, "body is empty!");
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("AlbumInfoList", this.f58381o);
        bundle.putInt("code", this.f58382p);
        bundle.putString("info", this.f58383q);
        return bundle;
    }

    /* renamed from: w */
    public String m76578w() throws Exception {
        String strMo76565p;
        String cursor;
        do {
            strMo76565p = super.mo76565p();
            if (TextUtils.isEmpty(strMo76565p)) {
                C1120a.m6676e("GetGeneralAlbumsBatchRequest", "responseBody is empty");
                return null;
            }
            try {
                AlbumQueryResponse albumQueryResponse = (AlbumQueryResponse) new Gson().fromJson(strMo76565p, AlbumQueryResponse.class);
                if (albumQueryResponse == null) {
                    C1120a.m6676e("GetGeneralAlbumsBatchRequest", "getResponseBundle response is null!");
                    return null;
                }
                GeneralAlbumData[] albumList = albumQueryResponse.getAlbumList();
                if (albumList != null && albumList.length > 0) {
                    for (GeneralAlbumData generalAlbumData : albumList) {
                        if (generalAlbumData.getExpand() != null) {
                            generalAlbumData.setExpandString(generalAlbumData.getExpand().toString());
                        }
                        this.f58381o.add(new GeneralAlbumData(generalAlbumData));
                    }
                }
                this.f58382p = albumQueryResponse.getCode();
                this.f58383q = albumQueryResponse.getInfo();
                C1120a.m6677i("GetGeneralAlbumsBatchRequest", "album.batchquery code: " + this.f58382p + ", info: " + this.f58383q + ", albumDataInfos size: " + this.f58381o.size());
                if (this.f58382p != 0) {
                    this.f58381o.clear();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", this.f58382p);
                    jSONObject.put("info", this.f58383q);
                    return jSONObject.toString();
                }
                cursor = albumQueryResponse.getCursor();
                this.f58379m = cursor;
            } catch (JsonSyntaxException e10) {
                C1120a.m6676e("GetGeneralAlbumsBatchRequest", "getResponseBundle json syntax exception: " + e10.toString());
                return null;
            }
        } while (!TextUtils.isEmpty(cursor));
        return strMo76565p;
    }
}
