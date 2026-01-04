package com.huawei.hwcloudjs.service.auth.bean;

import android.text.TextUtils;
import com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6637a;
import com.huawei.hwcloudjs.p154d.p158c.p159a.C6643a;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.http.annotation.RequestField;

/* renamed from: com.huawei.hwcloudjs.service.auth.bean.a */
/* loaded from: classes8.dex */
public class C6665a extends AbstractC6637a<C6666b> {

    /* renamed from: b */
    private static final String f30907b = "AuthRequestBean";

    @RequestField("appid")
    private String appId;

    @RequestField("nsp_svc")
    private String nspSvc = "nsp.scope.app.get";

    @RequestField("type")
    private String type = "9";

    public C6665a() {
    }

    /* renamed from: a */
    public void m37904a(String str) {
        this.appId = str;
    }

    /* renamed from: b */
    public void m37905b(String str) {
        this.nspSvc = str;
    }

    @Override // com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6638b
    /* renamed from: d */
    public String mo37815d() {
        String strM37835c = C6643a.m37830b().m37835c();
        C6659d.m37882c(f30907b, "genUrl url:" + strM37835c, false);
        if (TextUtils.isEmpty(strM37835c)) {
            C6659d.m37881b(f30907b, "AuthRequest url is empty!", true);
        }
        return strM37835c;
    }

    /* renamed from: g */
    public String m37907g() {
        return this.appId;
    }

    /* renamed from: h */
    public String m37908h() {
        return this.nspSvc;
    }

    /* renamed from: i */
    public String m37909i() {
        return this.type;
    }

    public C6665a(String str) {
        this.appId = str;
    }

    @Override // com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6638b
    /* renamed from: c */
    public C6666b mo37814c() {
        return new C6666b();
    }

    /* renamed from: c */
    public void m37906c(String str) {
        this.type = str;
    }
}
