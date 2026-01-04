package com.huawei.hwidauth.p166c;

import android.content.Context;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.io.IOException;
import p432kq.AbstractC11138j;
import p640sq.C12824c;

/* renamed from: com.huawei.hwidauth.c.i */
/* loaded from: classes8.dex */
public class C6694i extends AbstractC11138j {

    /* renamed from: e */
    public Context f31023e;

    public C6694i(Context context) {
        this.f31023e = context;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: a */
    public String mo37999a() throws IllegalStateException, IOException, IllegalArgumentException {
        return "";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: b */
    public String mo38000b() {
        return "";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: c */
    public String mo38001c() {
        return "/oauth2/v3/x509?" + CommonConstant.ReqAccessTokenParam.CLIENT_ID + "=104589299&hms_version=" + C12824c.m77019v(this.f31023e) + "&" + ParamConstants.Param.SDK_VERSION + "=6.12.0.302";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: d */
    public String mo38002d() {
        return "";
    }
}
