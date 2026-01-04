package p221d9;

import android.os.Bundle;
import com.huawei.android.hicloud.task.simple.FullReportSwitchStatusTask;
import gp.C10028c;
import mn.InterfaceC11499c;
import p015ak.C0213f;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: d9.a */
/* loaded from: classes3.dex */
public class C9053a implements InterfaceC11499c {
    @Override // mn.InterfaceC11499c
    /* renamed from: a */
    public String mo57108a() {
        return "FullReportSwitchStatusCallback";
    }

    @Override // mn.InterfaceC11499c
    /* renamed from: b */
    public void mo57109b(Bundle bundle) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e("FullReportSwitchStatusCallback", "hicloud is not login!");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - C10028c.m62183d0(C0213f.m1377a()).m62344j0();
        C11839m.m70688i("FullReportSwitchStatusCallback", "onDailyExecute duration=" + jCurrentTimeMillis);
        if (jCurrentTimeMillis > 604800000) {
            C12515a.m75110o().m75172d(new FullReportSwitchStatusTask(C0213f.m1377a()));
        }
    }
}
