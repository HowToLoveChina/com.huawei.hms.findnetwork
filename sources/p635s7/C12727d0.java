package p635s7;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.CreateShareAlbumResult;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p650t7.C12961e;
import p709vj.C13452e;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.d0 */
/* loaded from: classes2.dex */
public class C12727d0 extends AbstractC12758w {

    /* renamed from: l */
    public ShareAlbumData f58304l;

    public C12727d0(Context context, ShareAlbumData shareAlbumData) {
        this.f60186b = context;
        this.f58304l = shareAlbumData;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "share.createAlbum";
        m80115r();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80900d = C13452e.m80781L().m80900d();
        this.f58304l.setOwnerId(strM80971t0);
        this.f58304l.setOwnerAcc(strM80900d);
        jSONObject2.put("resource", PowerKitApplyUtil.GROUP_ALBUM);
        jSONObject2.put("shareName", this.f58304l.getShareName());
        jSONObject2.put("ownerAcc", this.f58304l.getOwnerAcc());
        if (this.f58304l.getShareId() != null && this.f58304l.getShareId().startsWith("default-album-")) {
            jSONObject2.put("shareId", this.f58304l.getShareId());
        }
        List<ShareReceiverData> receiverList = this.f58304l.getReceiverList();
        if (receiverList != null && receiverList.size() > 0) {
            for (ShareReceiverData shareReceiverData : receiverList) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("receiverId", shareReceiverData.getReceiverId());
                jSONObject3.put("receiverAcc", shareReceiverData.getReceiverAcc());
                jSONArray.put(jSONObject3);
            }
        }
        jSONObject2.put("receiverList", jSONArray);
        jSONObject.put("shareInfo", jSONObject2);
        jSONObject.put("source", Build.MODEL);
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("galleryVer", C1122c.m6833t0(this.f60186b));
        if (!TextUtils.isEmpty(this.f58304l.getExpandString())) {
            jSONObject.put("expand", new JSONObject(this.f58304l.getExpandString()));
        }
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Albums.create";
        return new C12961e(this.f58304l);
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        try {
            CreateShareAlbumResult createShareAlbumResult = (CreateShareAlbumResult) new Gson().fromJson(str, CreateShareAlbumResult.class);
            if (createShareAlbumResult != null) {
                int code = createShareAlbumResult.getCode();
                C1120a.m6677i("ShareAlbumCreateRequest", "share.createAlbum" + code);
                this.f58304l.setShareId(createShareAlbumResult.getShareId());
                bundle.putInt("code", code);
                bundle.putString("info", createShareAlbumResult.getInfo());
            }
            bundle.putParcelable("ShareInfo", this.f58304l);
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("ShareAlbumCreateRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
