package com.huawei.android.p069cg.request;

import android.content.Context;
import com.huawei.android.p069cg.request.response.FileCountResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p701v6.AbstractC13354a;
import p764x6.AbstractC13709a;
import p764x6.C13716h;
import p765x7.C13720b;

/* loaded from: classes2.dex */
public class FileCountQueryRequest extends AbstractC13354a<FileCountResponse> {
    public FileCountQueryRequest(Context context) {
        this.f60186b = context;
        this.f60187c = m80109h(C13720b.m82480a());
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("pictureCount", new JSONArray(new String[]{String.valueOf(1), String.valueOf(2), String.valueOf(3), String.valueOf(4), String.valueOf(5), String.valueOf(6), String.valueOf(7), String.valueOf(8), String.valueOf(9), String.valueOf(10), String.valueOf(11), String.valueOf(12), String.valueOf(13), String.valueOf(14)}));
        jSONObject2.put("videoCount", new JSONArray(new String[]{"4"}));
        jSONObject.put("fileTypeList", jSONObject2);
        jSONObject.put("cmd", "bapi.cloudphoto.getFileNum");
        C1120a.m6675d("FileCountQueryRequest", "bapi.cloudphoto.getFileNum");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a<FileCountResponse> mo14591n() {
        return new C13716h(this.f60189e);
    }
}
