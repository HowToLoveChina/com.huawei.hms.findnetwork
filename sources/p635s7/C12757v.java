package p635s7;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.GroupQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p765x7.C13720b;

/* renamed from: s7.v */
/* loaded from: classes2.dex */
public class C12757v extends AbstractC12758w<GroupQueryResponse> {

    /* renamed from: l */
    public String[] f58396l;

    public C12757v(Context context, String[] strArr, String str) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "share.group.query";
        this.f58396l = strArr;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (this.f58396l != null) {
            int i10 = 0;
            while (true) {
                String[] strArr = this.f58396l;
                if (i10 >= strArr.length) {
                    break;
                }
                jSONArray.put(strArr[i10]);
                i10++;
            }
            jSONObject.put("groupId", jSONArray);
        }
        jSONObject.put("cmd", this.f58397k);
        C1120a.m6675d("GroupQueryRequest", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        String[] strArr = this.f58396l;
        if (strArr == null || strArr.length < 1) {
            bundle.putParcelableArrayList("GroupInfoList", new ArrayList<>());
            bundle.putInt("code", 0);
            bundle.putString("info", "no groupList");
            return bundle;
        }
        try {
            GroupQueryResponse groupQueryResponse = (GroupQueryResponse) new Gson().fromJson(str, GroupQueryResponse.class);
            if (groupQueryResponse != null) {
                ArrayList<ShareAlbumData> groupList = groupQueryResponse.getGroupList();
                if (groupList == null) {
                    groupList = new ArrayList<>();
                }
                bundle.putParcelableArrayList("GroupInfoList", groupList);
                bundle.putInt("code", groupQueryResponse.getCode());
                bundle.putString("info", groupQueryResponse.getInfo());
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("GroupQueryRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
