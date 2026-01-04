package com.huawei.updatesdk.p191b.p196c;

import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.c.d */
/* loaded from: classes9.dex */
public class C8813d extends AbstractC8812c {
    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: a */
    public String mo56229a() {
        String strM56089a = C8789c.m56089a("ro.product.hw_model", "");
        return (TextUtils.isEmpty(strM56089a) || TextUtils.equals(strM56089a, "unknown")) ? C8789c.m56089a("ro.product.hn_model", "") : strM56089a;
    }

    @Override // com.huawei.updatesdk.p191b.p196c.AbstractC8812c
    /* renamed from: b */
    public String mo56230b() {
        return "com.huawei.appmarket";
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
        arrayList.add("3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F");
        arrayList.add("FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212");
        arrayList.add("A9436644E0BD71FF512C63839F8AC27114399F36956958688555DFCC63257EDE");
        return arrayList;
    }
}
