package com.huawei.updatesdk.p191b.p198e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8778b;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8800c;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d;
import com.huawei.updatesdk.p191b.p195b.C8807a;
import com.huawei.updatesdk.p191b.p196c.AbstractC8812c;
import com.huawei.updatesdk.p191b.p196c.C8811b;
import com.huawei.updatesdk.p191b.p200g.C8831b;
import com.huawei.updatesdk.p191b.p201h.C8834b;
import com.huawei.updatesdk.p191b.p201h.C8836d;
import com.huawei.updatesdk.service.appmgr.bean.C8842a;
import com.huawei.updatesdk.service.appmgr.bean.C8843b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.e.c */
/* loaded from: classes9.dex */
public class C8824c extends AbstractC8822a {

    /* renamed from: c */
    private String f45164c = null;

    /* renamed from: d */
    private String f45165d = "";

    /* renamed from: c */
    private void m56283c() {
        C8800c.m56167c(m56279b(C8793a.m56132c().m56133a()));
        C8801d c8801dM56298a = C8831b.m56298a(new C8842a(null));
        if (c8801dM56298a.m56183e()) {
            C8843b c8843b = (C8843b) c8801dM56298a;
            if (c8843b.m56367f() != null) {
                this.f45164c = c8843b.m56367f().m56371d();
            } else {
                C8774a.m56009b("DefaultTaskInit", "can not getPackageName from store, HiApp info is null.");
            }
        }
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public int mo56273a(Context context, String str) {
        return C8834b.m56322c(context, str);
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: b */
    public String mo56278b() {
        if (TextUtils.isEmpty(this.f45164c)) {
            C8774a.m56009b("DefaultTaskInit", "appgallery packagename is null and query again!");
            this.f45164c = m56282b(new ArrayList());
        }
        return this.f45164c;
    }

    /* renamed from: b */
    private String m56282b(List<String> list) {
        String strM28093b = null;
        try {
            Context contextM56133a = C8793a.m56132c().m56133a();
            ServiceVerifyKit.C4580a c4580a = new ServiceVerifyKit.C4580a();
            c4580a.m28096e(contextM56133a).m28098g(new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId"), ServiceVerifyKit.C4580a.a.ACTIVITY);
            m56281a(list, contextM56133a, c4580a);
            AbstractC8812c abstractC8812cM56233a = C8811b.m56233a();
            Iterator<String> it = abstractC8812cM56233a.mo56232f().iterator();
            while (it.hasNext()) {
                c4580a.m28092a(abstractC8812cM56233a.mo56230b(), it.next());
            }
            strM28093b = c4580a.m28093b();
            C8774a.m56009b("DefaultTaskInit", "get market packagename from verify kit is: " + strM28093b);
            return strM28093b;
        } catch (Throwable th2) {
            C8774a.m56010c("DefaultTaskInit", "genVerifiedPackageName error: " + th2.getMessage());
            return strM28093b;
        }
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public String mo56274a() {
        return "com.huawei.updatesdk";
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: c */
    public boolean mo56280c(Context context) {
        return C8834b.m56326f(context, mo56278b()) > 100200000;
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public String mo56275a(Context context) {
        if (!TextUtils.isEmpty(this.f45165d)) {
            return this.f45165d;
        }
        if (TextUtils.equals("SECURITY", C8778b.m56031a())) {
            this.f45165d = C8825d.m56285a(context, "grs_sdk_global_route_config_updatesdk.json", "SECURITY");
            C8774a.m56009b("DefaultTaskInit", "UpdateSDK Get url is security url");
        } else {
            this.f45165d = C8825d.m56285a(context, "grs_sdk_global_route_config_updatesdk.json", "DR3");
        }
        return this.f45165d;
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public void mo56276a(String str) {
        C8774a.m56009b("DefaultTaskInit", "resetMarketPkgName: " + str);
        this.f45164c = str;
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public void mo56277a(List<String> list) {
        Context contextM56133a = C8793a.m56132c().m56133a();
        if (!TextUtils.isEmpty(this.f45164c) && C8834b.m56327g(contextM56133a, this.f45164c)) {
            C8774a.m56009b("DefaultTaskInit", "AppMarket packageName has been obtained and is: " + this.f45164c);
            C8807a.m56209d().m56218d(this.f45164c);
            return;
        }
        String strM56282b = m56282b(list);
        this.f45164c = strM56282b;
        if (TextUtils.isEmpty(strM56282b)) {
            m56283c();
        }
        C8807a.m56209d().m56218d(this.f45164c);
        C8774a.m56009b("DefaultTaskInit", "initAppGalleryPkg and get AppMarket packageName is: " + this.f45164c);
    }

    /* renamed from: a */
    private void m56281a(List<String> list, Context context, ServiceVerifyKit.C4580a c4580a) {
        if (C8836d.m56342a(list) || list.size() >= 2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strM56314a = C8834b.m56314a(context, it.next());
            if (!TextUtils.isEmpty(strM56314a)) {
                arrayList.add(strM56314a);
            }
        }
        if (C8836d.m56342a(arrayList)) {
            return;
        }
        c4580a.m28097f(arrayList);
    }
}
