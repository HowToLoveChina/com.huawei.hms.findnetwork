package p011aa;

import com.huawei.android.hicloud.datamigration.bean.DataStatusResp;
import fk.C9721b;
import gp.C10028c;
import p015ak.C0213f;
import p422k9.C11019b;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p837z9.C14162c;
import p837z9.C14163d;

/* renamed from: aa.b */
/* loaded from: classes3.dex */
public class C0082b extends AbstractC12369f {
    public C0082b(long j10, long j11) {
        super(j10, j11);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            if (c10028cM62182c0.m62219H() == 5) {
                C11839m.m70688i("DataStatusQueryTask", "the migration process has been completed.");
                cancel();
                return;
            }
            DataStatusResp dataStatusRespM84982n = new C14162c().m84982n();
            if (dataStatusRespM84982n == null || dataStatusRespM84982n.getCode() != 0) {
                return;
            }
            C11839m.m70688i("DataStatusQueryTask", "get data status " + dataStatusRespM84982n.getDataStatus());
            if (dataStatusRespM84982n.getDataStatus() == 3) {
                c10028cM62182c0.m62416x2(dataStatusRespM84982n.getDataStatus());
                return;
            }
            if (dataStatusRespM84982n.getDataStatus() == 4) {
                c10028cM62182c0.m62416x2(dataStatusRespM84982n.getDataStatus());
                C14163d.m84990g().m85017w();
                cancel();
            } else if (dataStatusRespM84982n.getDataStatus() == 5) {
                C11019b.m66371t().m66375B0(C0213f.m1377a());
                cancel();
            }
        } catch (C9721b e10) {
            C11839m.m70689w("DataStatusQueryTask", "get data status error!" + e10.m60659c() + ", " + e10.toString());
        }
    }
}
