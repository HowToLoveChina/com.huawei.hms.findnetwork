package com.huawei.android.hicloud.album.service.hihttp.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.TagTransferResponse;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1136q;
import p635s7.AbstractC12758w;
import p765x7.C13721c;

/* loaded from: classes2.dex */
public class GetTagTransferRequest extends AbstractC12758w {
    public GetTagTransferRequest(Context context) {
        this.f60186b = context;
        this.f60187c = m80109h("/JPJX/CloudPhoto2AtlasServer");
        this.f58397k = "atlas-dbo.querySyncStatus";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("GetTagTransferRequest", "getResponseBundle body is empty!");
            return C13721c.m82487c(101, "body is empty!");
        }
        try {
            TagTransferResponse tagTransferResponse = (TagTransferResponse) new Gson().fromJson(str, TagTransferResponse.class);
            if (tagTransferResponse == null) {
                C1120a.m6676e("GetTagTransferRequest", "getResponseBundle response is null!");
                return C13721c.m82487c(130, "json syntax error!");
            }
            Bundle bundle = new Bundle();
            int code = tagTransferResponse.getCode();
            bundle.putInt("code", code);
            String info = tagTransferResponse.getInfo();
            C1120a.m6677i("GetTagTransferRequest", "get tag transfer code: " + code + ", info: " + info);
            bundle.putString("info", info);
            bundle.putString("TagTransferStatus", tagTransferResponse.getStatus());
            if ("1".equals(tagTransferResponse.getStatus())) {
                C1136q.b.m7081n0(this.f60186b, true);
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("GetTagTransferRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return null;
        }
    }
}
