package p221d9;

import android.os.Bundle;
import com.huawei.android.hicloud.task.simple.ReportPushTokenTask;
import gp.C10028c;
import mn.InterfaceC11499c;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: d9.c */
/* loaded from: classes3.dex */
public class C9055c implements InterfaceC11499c {
    @Override // mn.InterfaceC11499c
    /* renamed from: a */
    public String mo57108a() {
        return "ReportPushTokenCallback";
    }

    @Override // mn.InterfaceC11499c
    /* renamed from: b */
    public void mo57109b(Bundle bundle) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e("ReportPushTokenCallback", "hicloud is not login!");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - C10028c.m62183d0(C0213f.m1377a()).m62384r0();
        C11839m.m70688i("ReportPushTokenCallback", "onDailyExecute duration=" + jCurrentTimeMillis);
        int iM62379q0 = C10028c.m62183d0(C0213f.m1377a()).m62379q0();
        int iM1685c = C0241z.m1685c("160000300");
        C11839m.m70688i("ReportPushTokenCallback", "lastReportAppVersion =" + iM62379q0 + ",currentAppVersion = " + iM1685c);
        if (jCurrentTimeMillis > 604800000 || iM1685c > iM62379q0) {
            C12515a.m75110o().m75172d(new ReportPushTokenTask(C0213f.m1377a()));
        }
    }
}
