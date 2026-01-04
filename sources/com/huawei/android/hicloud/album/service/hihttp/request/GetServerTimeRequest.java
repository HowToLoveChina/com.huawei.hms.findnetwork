package com.huawei.android.hicloud.album.service.hihttp.request;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
import p635s7.AbstractC12758w;
import p650t7.C12983q;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* loaded from: classes2.dex */
public class GetServerTimeRequest extends AbstractC12758w {
    public GetServerTimeRequest(Context context) {
        this.f60186b = context;
        this.f60187c = m80109h(C13720b.m82483d());
        this.f58397k = "cloudphoto.recycle.getTime";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Time.About.get";
        return new C12983q();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        return C13721c.m82486b(str);
    }
}
