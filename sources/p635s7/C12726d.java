package p635s7;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.CategoryInfoResult;
import com.huawei.android.hicloud.album.service.p075vo.SmartAlbumData;
import java.util.ArrayList;
import org.json.JSONObject;
import p031b7.C1120a;

/* renamed from: s7.d */
/* loaded from: classes2.dex */
public class C12726d extends AbstractC12758w {
    public C12726d(Context context, String str) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h("/JPJX/CloudPhoto4Atlas");
        this.f58397k = "atlas.query.category";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("atlasVer", 1);
        C1120a.m6675d("CategoryInfoRequest", "atlas.query.category");
        this.f60188d = jSONObject.toString();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        try {
            CategoryInfoResult categoryInfoResult = (CategoryInfoResult) new Gson().fromJson(str, CategoryInfoResult.class);
            if (categoryInfoResult != null) {
                ArrayList<SmartAlbumData> categoryList = categoryInfoResult.getCategoryList();
                if (categoryList != null) {
                    C1120a.m6677i("CategoryInfoRequest", "categoryInfo size: " + categoryList.size());
                    bundle.putParcelableArrayList("CategoryInfoList", categoryList);
                }
                bundle.putInt("code", categoryInfoResult.getCode());
                bundle.putString("info", categoryInfoResult.getInfo());
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("CategoryInfoRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
