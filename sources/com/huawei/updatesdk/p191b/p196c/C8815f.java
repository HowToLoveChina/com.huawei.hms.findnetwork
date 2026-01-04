package com.huawei.updatesdk.p191b.p196c;

import android.os.Build;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8791e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.c.f */
/* loaded from: classes9.dex */
public class C8815f extends AbstractC8812c {
    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: a */
    public String mo56229a() {
        return C8791e.m56124a() ? Build.PRODUCT : "";
    }

    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: b */
    public String mo56230b() {
        return "com.huawei.appmarketwear";
    }

    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: c */
    public String mo56231c() {
        return C8789c.m56089a("ro.product.manufacturer", "");
    }

    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: f */
    public List<String> mo56232f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("CE1EF7188F820973C191227D95D54311ED3A65EC83E37009E898A1C058BBC775");
        return arrayList;
    }
}
