package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.p075vo.CreateBatchResponse;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12957c;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.c */
/* loaded from: classes2.dex */
public class C12724c extends AbstractC12758w {

    /* renamed from: l */
    public String f58298l;

    /* renamed from: m */
    public String f58299m;

    public C12724c(Context context, String str, String str2) throws Throwable {
        this.f60186b = context;
        this.f58298l = str;
        this.f58299m = str2;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.batch.create";
        m80104c(str2);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ownerId", this.f58298l);
        jSONObject.put("albumId", this.f58299m);
        jSONObject.put("cmd", this.f58397k);
        C1120a.m6675d("BatchCreateRequest", "cloudphoto.batch.create");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        C1120a.m6675d("BatchCreateRequest", "AbstractBaseExecutor batch");
        this.f58397k = "Share.Albums.Batchids.create";
        return new C12957c(this.f58299m, this.f58298l);
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("BatchCreateRequest", "responseBody is empty");
            return m76550w(101, "responseBody is empty");
        }
        try {
            CreateBatchResponse createBatchResponse = (CreateBatchResponse) new Gson().fromJson(str, CreateBatchResponse.class);
            if (createBatchResponse == null) {
                C1120a.m6676e("BatchCreateRequest", "batchResponse is empty");
                return m76550w(101, "batchResponse is null");
            }
            Bundle bundle = new Bundle();
            bundle.putInt("code", createBatchResponse.getCode());
            bundle.putString("info", createBatchResponse.getInfo());
            bundle.putParcelable("CreateBatchResponse", createBatchResponse);
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("BatchCreateRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return m76550w(101, "getResponseBundle json syntax exception");
        }
    }

    /* renamed from: w */
    public final Bundle m76550w(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CreateBatchResponse", new CreateBatchResponse(i10, str));
        return bundle;
    }
}
