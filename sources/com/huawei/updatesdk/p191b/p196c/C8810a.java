package com.huawei.updatesdk.p191b.p196c;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8787a;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p191b.p201h.C8834b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.c.a */
/* loaded from: classes9.dex */
public class C8810a extends AbstractC8812c {
    /* renamed from: g */
    private String m56225g() {
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car.bmw") == null) {
            return null;
        }
        String strM56226h = m56226h();
        String strM56089a = C8789c.m56089a("ro.vendor.build.RSEappstoredistributionscope", "");
        if (TextUtils.isEmpty(strM56089a)) {
            return strM56226h;
        }
        return strM56226h + "_" + strM56089a;
    }

    /* renamed from: h */
    private String m56226h() {
        String str = Build.MODEL;
        return (TextUtils.isEmpty(str) || TextUtils.equals("unknown", str)) ? "default" : str;
    }

    /* renamed from: i */
    private String m56227i() {
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car.landscape") == null) {
            return null;
        }
        String strM56089a = C8789c.m56089a("persist.vendor.vehicle.car_type", "");
        if (!TextUtils.isEmpty(strM56089a)) {
            return strM56089a;
        }
        String strM56089a2 = C8789c.m56089a("ro.product.ext.model", "");
        return !TextUtils.isEmpty(strM56089a2) ? strM56089a2 : m56226h();
    }

    /* renamed from: j */
    private String m56228j() {
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.vehicle") == null) {
            return null;
        }
        return m56226h();
    }

    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: a */
    public String mo56229a() {
        String strM56225g = m56225g();
        if (!TextUtils.isEmpty(strM56225g)) {
            return strM56225g;
        }
        String strM56227i = m56227i();
        if (!TextUtils.isEmpty(strM56227i)) {
            return strM56227i;
        }
        String strM56228j = m56228j();
        if (!TextUtils.isEmpty(strM56228j)) {
            return strM56228j;
        }
        String strM56078e = C8787a.m56078e();
        return TextUtils.isEmpty(strM56078e) ? m56226h() : strM56078e;
    }

    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: b */
    public String mo56230b() {
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car.bmw") != null) {
            return "com.huawei.appmarket.car.bmw";
        }
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.vehicle") != null) {
            return "com.huawei.appmarket.vehicle";
        }
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car.landscape") != null) {
            return "com.huawei.appmarket.car.landscape";
        }
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car.volvo") != null) {
            return "com.huawei.appmarket.car.volvo";
        }
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car.svw") != null) {
            return "com.huawei.appmarket.car.svw";
        }
        if (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car") != null) {
            return "com.huawei.appmarket.car";
        }
        return null;
    }

    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: c */
    public String mo56231c() {
        return (C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car.bmw") == null && C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.car.landscape") == null && C8834b.m56324d(C8793a.m56132c().m56133a(), "com.huawei.appmarket.vehicle") == null) ? C8787a.m56077d() : "default";
    }

    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: f */
    public List<String> mo56232f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("AF31957DA537B4791BD8F0B92B5ADCA38DBEC1743449CE90046CB05632BC02F3");
        return arrayList;
    }
}
