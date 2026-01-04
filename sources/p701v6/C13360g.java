package p701v6;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.p069cg.request.response.ShareQueryResponse;
import org.json.JSONObject;
import p031b7.C1120a;

/* renamed from: v6.g */
/* loaded from: classes2.dex */
public class C13360g extends AbstractC13354a<ShareQueryResponse> {

    /* renamed from: k */
    public String f60229k;

    /* renamed from: l */
    public int f60230l;

    /* renamed from: m */
    public String f60231m;

    /* renamed from: n */
    public String f60232n;

    public C13360g(String str, int i10, Context context, String str2, String str3) {
        this.f60229k = str;
        this.f60230l = i10;
        this.f60186b = context;
        this.f60231m = str2;
        this.f60187c = m80109h("/JPJX/CloudPhoto");
        this.f60232n = str3;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "share.query");
        jSONObject.put("resource", this.f60229k);
        jSONObject.put("scope", this.f60230l);
        jSONObject.put("flag", 3);
        if (!TextUtils.isEmpty(this.f60231m)) {
            jSONObject.put("shareId", this.f60231m);
        }
        if (!TextUtils.isEmpty(this.f60232n)) {
            jSONObject.put("ownerId", this.f60232n);
        }
        C1120a.m6675d("ShareQueryRequest", "share.query");
        this.f60188d = jSONObject.toString();
    }
}
