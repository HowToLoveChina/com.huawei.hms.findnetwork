package com.huawei.android.hicloud.common.task;

import android.text.TextUtils;
import com.huawei.android.hicloud.common.task.ClickExchangeTask;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.QueryO2OActivityResp;
import com.huawei.cloud.pay.model.UserPackage;
import fk.C9721b;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.common.task.a */
/* loaded from: classes3.dex */
public class C2763a extends AbstractC12367d {

    /* renamed from: a */
    public ClickExchangeTask.QueryO2OCallback f12017a;

    /* renamed from: b */
    public GetClientUIConfigResp f12018b;

    /* renamed from: c */
    public UserPackage f12019c;

    /* renamed from: d */
    public int f12020d;

    public C2763a(ClickExchangeTask.QueryO2OCallback queryO2OCallback, GetClientUIConfigResp getClientUIConfigResp, UserPackage userPackage, int i10) {
        this.f12017a = queryO2OCallback;
        this.f12018b = getClientUIConfigResp;
        this.f12019c = userPackage;
        this.f12020d = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("QueryO2OActivityTask", "QueryO2OActivityTask");
        C11060c c11060c = new C11060c();
        try {
            c11060c.m66636B("queryO2OActivity");
            c11060c.m66643I(C11058a.m66627b("queryO2OActivity"));
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
            c11060c.m66670z("2.0");
            QueryO2OActivityResp queryO2OActivityRespM61665d0 = C9948a.m61631C().m61665d0(c11060c);
            if (TextUtils.isEmpty(queryO2OActivityRespM61665d0 != null ? queryO2OActivityRespM61665d0.getActivityLinkUrl() : "") && this.f12020d != 3) {
                if (this.f12018b == null) {
                    this.f12018b = C9948a.m61631C().m61703z(c11060c);
                }
                if (this.f12019c == null) {
                    UserPackage userPackageM61644M = C9948a.m61631C().m61644M(c11060c, "ClickExchangeTask");
                    this.f12019c = userPackageM61644M;
                    userPackageM61644M.setUsed(C9948a.m61631C().m61643L(c11060c));
                }
            }
            this.f12017a.mo15793a(queryO2OActivityRespM61665d0, this.f12018b, this.f12019c);
        } catch (Exception e10) {
            C11839m.m70687e("QueryO2OActivityTask", "task err: " + e10.getMessage());
            this.f12017a.mo15793a(null, this.f12018b, this.f12019c);
        }
    }
}
