package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.QuerySpaceResponse;
import com.huawei.android.hicloud.album.service.p075vo.UserSpace;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12960d0;
import p764x6.AbstractC13709a;
import p765x7.C13721c;

/* renamed from: s7.c0 */
/* loaded from: classes2.dex */
public class C12725c0 extends AbstractC12758w {

    /* renamed from: l */
    public int f58300l;

    /* renamed from: m */
    public String f58301m;

    /* renamed from: n */
    public String f58302n;

    /* renamed from: o */
    public String f58303o;

    public C12725c0(Context context, String str, int i10, String str2, String str3, String str4) {
        this.f60186b = context;
        this.f60189e = str;
        this.f58300l = i10;
        this.f58301m = str2;
        this.f58302n = str3;
        this.f58303o = str4;
        this.f60187c = m80109h("/JPJX/BaseAPI");
        this.f58397k = "bapi.dbank.queryspace";
        m80107f();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("queryType", this.f58300l);
        if (!TextUtils.isEmpty(this.f58301m) && !TextUtils.isEmpty(this.f58302n) && !TextUtils.isEmpty(this.f58303o)) {
            jSONObject.put("ownerId", this.f58301m);
            jSONObject.put("resource", this.f58302n);
            jSONObject.put("shareId", this.f58303o);
        }
        C1120a.m6675d("QueryUserSpaceRequest", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Basic.Quota.Summary";
        C12960d0 c12960d0 = new C12960d0(this.f58303o, this.f58301m);
        c12960d0.m82456i(this.f60189e);
        return c12960d0;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("QueryUserSpaceRequest", "getResponseBundle body is empty!");
            return C13721c.m82487c(101, "body is empty!");
        }
        try {
            QuerySpaceResponse querySpaceResponse = (QuerySpaceResponse) new Gson().fromJson(str, QuerySpaceResponse.class);
            if (querySpaceResponse == null) {
                C1120a.m6676e("QueryUserSpaceRequest", "getResponseBundle response is null!");
                return C13721c.m82487c(130, "json syntax error!");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("UserSpace", new UserSpace(querySpaceResponse.getUseSpaceSize(), querySpaceResponse.getTotalSpaceSize(), querySpaceResponse.getCloudPhotoSize(), querySpaceResponse.getRecyclePhotoSize()));
            bundle.putInt("code", querySpaceResponse.getCode());
            bundle.putString("info", querySpaceResponse.getInfo());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("QueryUserSpaceRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return null;
        }
    }
}
