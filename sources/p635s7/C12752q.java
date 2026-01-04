package p635s7;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.ShareQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import p031b7.C1120a;
import p649t6.C12943c;
import p650t7.C12984r;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.q */
/* loaded from: classes2.dex */
public class C12752q extends AbstractC12758w {
    public C12752q(Context context, String str) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "share.query";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("resource", PowerKitApplyUtil.GROUP_ALBUM);
        jSONObject.put("scope", 1);
        jSONObject.put("flag", 3);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Albums.list";
        C12984r c12984r = new C12984r();
        c12984r.m82456i(this.f60189e);
        return c12984r;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) throws SQLException {
        Bundle bundle = new Bundle();
        try {
            ShareQueryResponse shareQueryResponse = (ShareQueryResponse) new Gson().fromJson(str, ShareQueryResponse.class);
            if (shareQueryResponse == null) {
                return bundle;
            }
            if (shareQueryResponse.getCode() != 0) {
                C1120a.m6676e("GetShareAlbumsRequest", "share.query code: " + shareQueryResponse.getCode());
                bundle.putInt("code", shareQueryResponse.getCode());
                bundle.putString("info", shareQueryResponse.getInfo());
                return bundle;
            }
            try {
                C1120a.m6675d("GetShareAlbumsRequest", "getResponseBundle V2 getShareAlbumsExecutor start get recShareList");
                ShareQueryResponse shareQueryResponseMo77904k = new C12984r().mo77904k(BaseResponse.class);
                if (shareQueryResponseMo77904k.getCode() != 0) {
                    C1120a.m6676e("GetShareAlbumsRequest", "albums.list code: " + shareQueryResponseMo77904k.getCode());
                    bundle.putInt("code", shareQueryResponseMo77904k.getCode());
                    bundle.putString("info", shareQueryResponseMo77904k.getInfo());
                    return bundle;
                }
                shareQueryResponse.setRecShareList(shareQueryResponseMo77904k.getRecShareList());
                shareQueryResponse.setInfo(shareQueryResponseMo77904k.getInfo());
                int code = shareQueryResponse.getCode();
                C1120a.m6677i("GetShareAlbumsRequest", "share.query code: " + code);
                ArrayList<ShareAlbumData> ownShareList = shareQueryResponse.getOwnShareList();
                m76580w(ownShareList);
                ArrayList<ShareAlbumData> recShareList = shareQueryResponse.getRecShareList();
                if (recShareList != null && !recShareList.isEmpty()) {
                    Iterator<ShareAlbumData> it = recShareList.iterator();
                    while (it.hasNext()) {
                        ShareAlbumData next = it.next();
                        if (next.getExpand() != null) {
                            next.setExpandString(next.getExpand().toString());
                        }
                    }
                }
                bundle.putParcelableArrayList("OwnShareList", ownShareList);
                bundle.putParcelableArrayList("RecShareList", recShareList);
                bundle.putInt("code", code);
                bundle.putString("info", shareQueryResponse.getInfo());
                return bundle;
            } catch (Exception e10) {
                C1120a.m6676e("GetShareAlbumsRequest", "getShareAlbumsExecutor error" + e10.toString());
                return bundle;
            }
        } catch (JsonSyntaxException e11) {
            C1120a.m6676e("GetShareAlbumsRequest", "getResponseBundle json syntax exception: " + e11.toString());
            return bundle;
        }
    }

    /* renamed from: w */
    public final void m76580w(ArrayList<ShareAlbumData> arrayList) throws SQLException {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<ShareAlbumData> it = arrayList.iterator();
        while (it.hasNext()) {
            ShareAlbumData next = it.next();
            if (next.getExpand() != null) {
                next.setExpandString(next.getExpand().toString());
            }
            C12943c c12943c = new C12943c();
            if (TextUtils.isEmpty(c12943c.m77764o(next.getShareId()))) {
                c12943c.m77762m(next.getShareId(), next.getShareName(), "1.0", String.valueOf(next.getFlversion()));
            } else {
                c12943c.m77765p(next.getShareId(), next.getShareName(), "1.0", String.valueOf(next.getFlversion()));
            }
        }
    }
}
