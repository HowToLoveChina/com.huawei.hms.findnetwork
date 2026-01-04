package com.huawei.hms.drive;

import android.content.Context;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.http.AbstractC4619v;
import com.huawei.cloud.base.util.C4627a0;
import java.io.IOException;
import java.util.Arrays;
import p741wi.C13609a;
import p811yi.C13987b;

/* renamed from: com.huawei.hms.drive.k */
/* loaded from: classes8.dex */
public final class C5289k extends AbstractC4619v {

    /* renamed from: a */
    private static final String[] f24513a;

    /* renamed from: b */
    private final InterfaceC5288j f24514b;

    /* renamed from: c */
    private Context f24515c;

    static {
        String[] strArr = {"DELETE", "GET", "HEAD", "POST", "PUT", RequestMethod.PATCH};
        f24513a = strArr;
        Arrays.sort(strArr);
    }

    public C5289k(Context context) {
        this.f24515c = context;
        this.f24514b = new C5286h(context);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4619v
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C13609a buildRequest(String str, String str2) throws IOException, ClassCastException {
        C4627a0.m28390c(supportsMethod(str), "HTTP method %s not supported", str);
        return new C13609a(this.f24515c, this.f24514b.mo31723a(C13987b.m84004a()), str, str2);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4619v
    public boolean supportsMethod(String str) {
        return Arrays.binarySearch(f24513a, str) >= 0;
    }
}
