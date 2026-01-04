package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import com.huawei.android.hicloud.complexutil.C2783d;
import gp.C10028c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* loaded from: classes3.dex */
public class FullReportSwitchStatusTask extends AbstractC12367d {

    /* renamed from: a */
    public Context f13095a;

    public FullReportSwitchStatusTask(Context context) {
        this.f13095a = context.getApplicationContext();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("FullReportSwitchStatusTask", "FullReportSwitchStatusTask call");
        C10028c.m62182c0().m62297Y2(System.currentTimeMillis());
        C2783d.m16150j(this.f13095a);
    }
}
