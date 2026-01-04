package com.huawei.android.hicloud.album.service.hihttp.request;

import android.content.Context;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import org.json.JSONObject;
import p650t7.C12969i;
import p701v6.AbstractC13354a;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* loaded from: classes2.dex */
public class DisuseRequest extends AbstractC13354a<BaseResponse> {
    public DisuseRequest(Context context) {
        this.f60186b = context;
        this.f60187c = m80109h(C13720b.m82484e());
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "cloudphoto.status.disable");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a<BaseResponse> mo14591n() {
        return new C12969i();
    }
}
