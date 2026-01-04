package p635s7;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.GroupQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p649t6.C12943c;
import p650t7.C12987u;
import p709vj.C13452e;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.u */
/* loaded from: classes2.dex */
public class C12756u extends AbstractC12758w {

    /* renamed from: l */
    public String[] f58395l;

    public C12756u(Context context, String[] strArr, String str) {
        this.f60186b = context;
        this.f58395l = strArr;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "share.group.query";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (this.f58395l != null) {
            int i10 = 0;
            while (true) {
                String[] strArr = this.f58395l;
                if (i10 >= strArr.length) {
                    break;
                }
                jSONArray.put(strArr[i10]);
                i10++;
            }
            jSONObject.put("groupId", jSONArray);
        }
        jSONObject.put("cmd", this.f58397k);
        C1120a.m6675d("GroupAlbumsRequest", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Albums.list";
        C12987u c12987u = new C12987u();
        c12987u.m82456i(this.f60189e);
        return c12987u;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) throws SQLException {
        ArrayList<ShareAlbumData> groupList;
        Bundle bundle = new Bundle();
        ArrayList<ShareAlbumData> arrayList = new ArrayList<>();
        C12943c c12943c = new C12943c();
        try {
            GroupQueryResponse groupQueryResponse = (GroupQueryResponse) new Gson().fromJson(str, GroupQueryResponse.class);
            if (groupQueryResponse == null) {
                groupList = null;
            } else {
                if (groupQueryResponse.getCode() != 0) {
                    C1120a.m6676e("GroupAlbumsRequest", "share.group.query code: " + groupQueryResponse.getCode());
                    bundle.putParcelableArrayList("GroupInfoList", new ArrayList<>());
                    bundle.putInt("code", groupQueryResponse.getCode());
                    bundle.putString("info", groupQueryResponse.getInfo());
                    return bundle;
                }
                groupList = groupQueryResponse.getGroupList();
            }
            try {
                C1120a.m6675d("GroupAlbumsRequest", "getResponseBundle V2 GroupAlbumsExecutor start");
                GroupQueryResponse groupQueryResponseMo77904k = new C12987u().mo77904k(BaseResponse.class);
                if (groupQueryResponseMo77904k.getCode() != 0) {
                    C1120a.m6676e("GroupAlbumsRequest", "albums.list code: " + groupQueryResponseMo77904k.getCode());
                    bundle.putParcelableArrayList("GroupInfoList", new ArrayList<>());
                    bundle.putInt("code", groupQueryResponseMo77904k.getCode());
                    bundle.putString("info", groupQueryResponseMo77904k.getInfo());
                    return bundle;
                }
                ArrayList<ShareAlbumData> groupList2 = groupQueryResponseMo77904k.getGroupList();
                m76582w(groupList, arrayList, c12943c);
                if (groupList2 != null && !groupList2.isEmpty()) {
                    Iterator<ShareAlbumData> it = groupList2.iterator();
                    while (it.hasNext()) {
                        ShareAlbumData next = it.next();
                        if (next != null) {
                            arrayList.add(next);
                        }
                    }
                }
                bundle.putParcelableArrayList("GroupInfoList", arrayList);
                bundle.putInt("code", 0);
                bundle.putString("info", "OK");
                return bundle;
            } catch (Exception e10) {
                C1120a.m6676e("GroupAlbumsRequest", "GroupAlbumsExecutor error" + e10.toString());
                return bundle;
            }
        } catch (JsonSyntaxException e11) {
            C1120a.m6676e("GroupAlbumsRequest", "getResponseBundle json syntax exception: " + e11.toString());
            return bundle;
        }
    }

    /* renamed from: w */
    public final void m76582w(ArrayList<ShareAlbumData> arrayList, ArrayList<ShareAlbumData> arrayList2, C12943c c12943c) throws SQLException {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<ShareAlbumData> it = arrayList.iterator();
        while (it.hasNext()) {
            ShareAlbumData next = it.next();
            if (next != null && C13452e.m80781L().m80971t0().equals(next.getOwnerId())) {
                arrayList2.add(next);
                if (TextUtils.isEmpty(c12943c.m77764o(next.getShareId()))) {
                    c12943c.m77762m(next.getShareId(), next.getShareName(), "1.0", String.valueOf(next.getFlversion()));
                } else {
                    c12943c.m77765p(next.getShareId(), next.getShareName(), "1.0", String.valueOf(next.getFlversion()));
                }
            }
        }
    }
}
