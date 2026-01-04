package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.PlayUrlResponse;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12986t;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* renamed from: s7.t */
/* loaded from: classes2.dex */
public class C12755t extends AbstractC12758w {

    /* renamed from: l */
    public String f58390l;

    /* renamed from: m */
    public String f58391m;

    /* renamed from: n */
    public String f58392n;

    /* renamed from: o */
    public String f58393o;

    /* renamed from: p */
    public FileData f58394p;

    public C12755t(Context context, FileData fileData) {
        this(context, fileData.getAlbumId(), fileData.getUniqueId(), fileData.getHash(), fileData.getUserID(), "");
        this.f58394p = fileData;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("albumId", this.f58390l);
        if (TextUtils.isEmpty(this.f58391m)) {
            jSONObject.put(HicloudH5ConfigManager.KEY_HASH, this.f58392n);
            jSONObject.put("ownerId", this.f58393o);
        } else {
            jSONObject.put(ContentRecord.UNIQUE_ID, this.f58391m);
        }
        C1120a.m6675d("GetVideoPlayUrlRequest", "cloudphoto.mo.getPlayUrl");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Play.Media.get";
        return new C12986t(this.f58394p);
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("GetVideoPlayUrlRequest", "responseBody is empty");
            return C13721c.m82487c(101, "responseBody is empty");
        }
        try {
            PlayUrlResponse playUrlResponse = (PlayUrlResponse) new Gson().fromJson(str, PlayUrlResponse.class);
            if (playUrlResponse == null) {
                C1120a.m6676e("GetVideoPlayUrlRequest", "playUrlResponse is empty");
                return C13721c.m82487c(101, "playUrlResponse is null");
            }
            Bundle bundle = new Bundle();
            bundle.putInt("code", playUrlResponse.getCode());
            bundle.putString("info", playUrlResponse.getInfo());
            bundle.putParcelable("FileInfo", this.f58394p);
            bundle.putString("PlayUrl", playUrlResponse.getPlayUrl());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("GetVideoPlayUrlRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return C13721c.m82487c(101, "getResponseBundle json syntax exception");
        }
    }

    public C12755t(Context context, String str, String str2, String str3, String str4, String str5) throws Throwable {
        this.f60186b = context;
        this.f58390l = str;
        this.f58391m = str2;
        this.f58392n = str3;
        this.f58393o = str4;
        this.f60187c = m80109h(C13720b.m82481b());
        this.f60189e = str5;
        m80115r();
        this.f58397k = "cloudphoto.mo.getPlayUrl";
        m80104c(str);
    }
}
