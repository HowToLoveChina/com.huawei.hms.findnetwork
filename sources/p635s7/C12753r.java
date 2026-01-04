package p635s7;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.p075vo.GetUploadUrlPlv3;
import java.util.HashMap;
import p031b7.C1120a;
import p701v6.AbstractC13354a;

/* renamed from: s7.r */
/* loaded from: classes2.dex */
public class C12753r extends AbstractC13354a {

    /* renamed from: k */
    public HashMap<String, String> f58385k;

    /* renamed from: l */
    public HashMap<String, String> f58386l;

    /* renamed from: m */
    public String f58387m;

    /* renamed from: n */
    public String f58388n;

    /* renamed from: o */
    public String f58389o;

    public C12753r(Context context, String str, HashMap<String, String> map, HashMap<String, String> map2, String str2, String str3, String str4) {
        this.f60186b = context;
        this.f60187c = m80109h("/JPJX/BaseAPI");
        this.f60189e = str;
        this.f58385k = map;
        this.f58386l = map2;
        this.f58387m = str2;
        this.f58388n = str3;
        this.f58389o = str4;
        m80106e();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        C1120a.m6677i("GetUploadUrlPlv3Request", "bapi.cloudphoto.getUploadUrl, traceId: " + this.f60189e);
        GetUploadUrlPlv3 getUploadUrlPlv3 = new GetUploadUrlPlv3();
        getUploadUrlPlv3.setCmd("bapi.cloudphoto.getUploadUrl");
        getUploadUrlPlv3.setMethod("PUT");
        getUploadUrlPlv3.setClientIp(this.f58387m);
        getUploadUrlPlv3.setMapUrlParams(this.f58385k);
        getUploadUrlPlv3.setMapUrlHeaders(this.f58386l);
        if (!TextUtils.isEmpty(this.f58388n)) {
            getUploadUrlPlv3.setHost(this.f58388n);
        }
        if (!TextUtils.isEmpty(this.f58389o)) {
            getUploadUrlPlv3.setObjectId(this.f58389o);
        }
        this.f60188d = new Gson().toJson(getUploadUrlPlv3, GetUploadUrlPlv3.class);
    }
}
