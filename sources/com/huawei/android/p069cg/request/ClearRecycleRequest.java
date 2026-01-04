package com.huawei.android.p069cg.request;

import android.content.Context;
import com.huawei.android.p069cg.request.response.BaseResponse;
import org.json.JSONObject;
import p031b7.C1120a;
import p701v6.AbstractC13354a;
import p764x6.AbstractC13709a;
import p764x6.C13711c;
import p765x7.C13720b;

/* loaded from: classes2.dex */
public class ClearRecycleRequest extends AbstractC13354a<BaseResponse> {
    public ClearRecycleRequest(Context context) {
        this.f60186b = context;
        this.f60187c = m80109h(C13720b.m82483d());
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "cloudphoto.recycle.deleteAll");
        C1120a.m6675d("ClearRecycleRequest", "cloudphoto.recycle.deleteAll");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: k */
    public boolean mo14590k() {
        return true;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a<BaseResponse> mo14591n() {
        return new C13711c(this.f60189e);
    }
}
