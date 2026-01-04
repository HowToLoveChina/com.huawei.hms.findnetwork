package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import gp.C10028c;
import io.C10582a;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class ReportPushTokenTask extends AbstractC12367d {

    /* renamed from: a */
    public Context f13103a;

    public ReportPushTokenTask(Context context) {
        this.f13103a = context.getApplicationContext();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("ReportPushTokenTask", "ReportPushTokenTask call");
        C10028c.m62182c0().m62332g3(System.currentTimeMillis());
        C10028c.m62182c0().m62327f3();
        new C10582a(C11058a.m66627b("07006")).m64932d0(C13612b.m81829B().m81845H(this.f13103a), false);
    }
}
