package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.TagInfoResult;
import com.huawei.android.hicloud.album.service.p075vo.SmartAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.SmartTagData;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import java.util.ArrayList;
import org.json.JSONObject;
import p031b7.C1120a;

/* renamed from: s7.m0 */
/* loaded from: classes2.dex */
public class C12745m0 extends AbstractC12758w {

    /* renamed from: l */
    public SmartAlbumData f58365l;

    /* renamed from: m */
    public String f58366m;

    public C12745m0(Context context, String str, SmartAlbumData smartAlbumData, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f58365l = smartAlbumData;
        this.f58366m = str2;
        this.f60187c = m80109h("/JPJX/CloudPhoto4Atlas");
        this.f58397k = "atlas.query.tag";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        SmartAlbumData smartAlbumData = this.f58365l;
        if (smartAlbumData != null) {
            jSONObject.put("categoryId", smartAlbumData.getCategoryId());
        }
        jSONObject.put("queryNum", 100);
        if (!TextUtils.isEmpty(this.f58366m)) {
            jSONObject.put(SyncProtocol.Constant.CURSOR, this.f58366m);
        }
        jSONObject.put("cmd", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CategoryInfo", this.f58365l);
        try {
            TagInfoResult tagInfoResult = (TagInfoResult) new Gson().fromJson(str, TagInfoResult.class);
            if (tagInfoResult != null) {
                ArrayList<SmartTagData> tagList = tagInfoResult.getTagList();
                if (tagList != null) {
                    C1120a.m6677i("TagInfoRequest", "tag info size: " + tagList.size());
                    bundle.putString("Cursor", tagInfoResult.getCursor());
                    bundle.putParcelableArrayList("TagInfoList", tagList);
                }
                bundle.putInt("code", tagInfoResult.getCode());
                bundle.putString("info", tagInfoResult.getInfo());
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("TagInfoRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
