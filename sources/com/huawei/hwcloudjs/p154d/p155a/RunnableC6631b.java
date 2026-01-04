package com.huawei.hwcloudjs.p154d.p155a;

import android.content.Context;
import com.huawei.hwcloudjs.p154d.p155a.C6632c;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.auth.bean.AuthBean;
import java.util.List;

/* renamed from: com.huawei.hwcloudjs.d.a.b */
/* loaded from: classes8.dex */
public class RunnableC6631b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f30818a;

    /* renamed from: b */
    final /* synthetic */ String f30819b;

    /* renamed from: c */
    final /* synthetic */ List f30820c;

    /* renamed from: d */
    final /* synthetic */ C6632c.a f30821d;

    /* renamed from: e */
    final /* synthetic */ Context f30822e;

    /* renamed from: f */
    final /* synthetic */ C6632c f30823f;

    public RunnableC6631b(C6632c c6632c, String str, String str2, List list, C6632c.a aVar, Context context) {
        this.f30823f = c6632c;
        this.f30818a = str;
        this.f30819b = str2;
        this.f30820c = list;
        this.f30821d = aVar;
        this.f30822e = context;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        AuthBean authBeanM37782a = this.f30823f.f30829f.m37782a(this.f30818a);
        C6659d.m37882c("AuthManager", "getValidCache bean", true);
        C6659d.m37882c("AuthManager", "getValidCache bean:" + authBeanM37782a, false);
        if (authBeanM37782a == null || !C6633d.m37801a(this.f30819b, this.f30820c, authBeanM37782a)) {
            C6659d.m37881b("AuthManager", "checkH5App is null", true);
            this.f30823f.m37792b(this.f30818a, this.f30819b, this.f30820c, this.f30821d, this.f30822e);
        } else {
            C6659d.m37882c("AuthManager", "checkH5App is passed", true);
            this.f30821d.mo37752a(0);
            this.f30823f.m37791a(this.f30818a, authBeanM37782a);
        }
    }
}
