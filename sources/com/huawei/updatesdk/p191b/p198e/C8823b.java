package com.huawei.updatesdk.p191b.p198e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8778b;
import com.huawei.updatesdk.p191b.p201h.C8834b;
import com.huawei.updatesdk.service.otaupdate.C8871f;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.e.b */
/* loaded from: classes9.dex */
public class C8823b extends AbstractC8822a {

    /* renamed from: c */
    private String f45163c = "";

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public int mo56273a(Context context, String str) {
        return 34;
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: b */
    public String mo56278b() {
        return C8871f.m56464e().m56469c();
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: c */
    public boolean mo56280c(Context context) {
        return C8834b.m56327g(context, mo56278b());
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public String mo56274a() {
        return "com.huawei.apptouch.updatesdk";
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public String mo56275a(Context context) {
        if (!TextUtils.isEmpty(this.f45163c)) {
            return this.f45163c;
        }
        this.f45163c = TextUtils.equals("SECURITY", C8778b.m56031a()) ? C8825d.m56285a(context, "grs_sdk_global_route_config_apptouchupdatesdk.json", "SECURITY") : C8825d.m56285a(context, "grs_sdk_global_route_config_apptouchupdatesdk.json", "DR3");
        return this.f45163c;
    }

    @Override // com.huawei.updatesdk.p191b.p198e.AbstractC8822a
    /* renamed from: a */
    public void mo56277a(List<String> list) {
    }
}
