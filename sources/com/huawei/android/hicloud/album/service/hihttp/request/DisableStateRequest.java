package com.huawei.android.hicloud.album.service.hihttp.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.DisableStateResponse;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p635s7.AbstractC12758w;
import p650t7.C12967h;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* loaded from: classes2.dex */
public class DisableStateRequest extends AbstractC12758w<DisableStateResponse> {

    /* renamed from: l */
    public int f11556l;

    /* renamed from: m */
    public String f11557m;

    public DisableStateRequest(Context context) {
        this.f60186b = context;
        this.f60187c = m80109h(C13720b.m82484e());
        m80115r();
        this.f58397k = "cloudphoto.status.querydisabledstatus";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "cloudphoto.status.querydisabledstatus");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Status.About.get";
        C12967h c12967h = new C12967h(this.f11556l);
        c12967h.m82456i(this.f60189e);
        return c12967h;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("DisableQueryType", this.f11556l);
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("DisableStateRequest", "DisableStateRequest responseBody is null");
            return bundle;
        }
        try {
            DisableStateResponse disableStateResponse = (DisableStateResponse) new Gson().fromJson(str, DisableStateResponse.class);
            if (disableStateResponse == null) {
                C1120a.m6676e("DisableStateRequest", "DisableStateRequest disableStateResponse is null");
                return bundle;
            }
            int code = disableStateResponse.getCode();
            int status = disableStateResponse.getStatus();
            if (code == 0) {
                C1136q.b.m6992B0(this.f60186b, status);
                C1136q.b.m7097s1(this.f60186b, status, disableStateResponse.getDeleteTime());
            }
            bundle.putInt("code", code);
            bundle.putString("info", disableStateResponse.getInfo());
            bundle.putString("sessionId", this.f11557m);
            bundle.putInt("disableStatus", status);
            bundle.putLong("DisableTime", disableStateResponse.getDisableTime());
            bundle.putInt("Remain", C1122c.m6683B0(this.f60186b));
            return bundle;
        } catch (JsonSyntaxException unused) {
            C1120a.m6676e("DisableStateRequest", "DisableStateRequest json error");
            return bundle;
        }
    }

    public DisableStateRequest(Context context, int i10, String str) {
        this.f60186b = context;
        this.f11556l = i10;
        this.f11557m = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.status.querydisabledstatus";
        this.f60189e = str;
    }
}
