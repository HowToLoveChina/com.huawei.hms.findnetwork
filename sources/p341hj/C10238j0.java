package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.cloud.pay.model.TransactionItem;
import com.huawei.cloud.pay.model.TrxReq;
import fk.C9721b;
import java.util.Collections;
import java.util.List;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p845zi.C14302a;

/* renamed from: hj.j0 */
/* loaded from: classes5.dex */
public class C10238j0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49621b;

    /* renamed from: c */
    public C11060c f49622c;

    /* renamed from: d */
    public boolean f49623d;

    public C10238j0(Handler handler, C11060c c11060c, boolean z10) {
        this.f49621b = handler;
        this.f49622c = c11060c;
        this.f49623d = z10;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            TrxReq trxReq = new TrxReq("4.0");
            String strM85181f = C14302a.m85176d().m85181f();
            if (this.f49623d && TextUtils.isEmpty(strM85181f)) {
                C1442a.m8289e("GetTrxTask", "IncrementalQuery invalid.");
                return;
            }
            if (!TextUtils.isEmpty(strM85181f)) {
                trxReq.setTimeStamp(strM85181f);
            }
            List<TransactionItem> listM61675i0 = C9948a.m61631C().m61675i0(trxReq, this.f49622c);
            Collections.sort(listM61675i0);
            this.f49622c.m66665u(String.valueOf(0));
            this.f49622c.m66635A("success");
            if (!this.f49623d) {
                C14302a.m85176d().m85179c();
            }
            m63380f(this.f49621b, 2007, listM61675i0);
        } catch (Exception e10) {
            C1442a.m8291w("GetTrxTask", "get sign records err. " + e10.getMessage());
            this.f49622c.m66665u("114_");
            this.f49622c.m66635A(e10.getMessage());
            m63379e(this.f49621b, 2107, new C9721b(4000, e10.getMessage()));
        }
    }
}
