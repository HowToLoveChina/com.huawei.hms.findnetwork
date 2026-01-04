package mo;

import com.huawei.hicloud.request.cbs.bean.CBSLockAndFlowControlReq;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import fk.C9721b;
import java.io.IOException;
import okhttp3.C11918e0;
import okhttp3.C11922g0;

/* renamed from: mo.b */
/* loaded from: classes6.dex */
public class C11502b extends C11501a {

    /* renamed from: c */
    public CBSbkFlowHead f53402c;

    public C11502b(CBSbkFlowHead cBSbkFlowHead, String str, CBSLockAndFlowControlReq cBSLockAndFlowControlReq) throws C9721b {
        super(cBSbkFlowHead.getAccessToken(), str, cBSLockAndFlowControlReq.toString(), cBSbkFlowHead.getTraceID());
        this.method = "POST";
        this.f53402c = cBSbkFlowHead;
    }

    @Override // mo.C11501a, com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) throws C9721b, IOException {
        if (this.f53402c == null) {
            throw new C9721b(4002, "mCbSvkFlowHead is null");
        }
        super.prepare(aVar);
        aVar.m71578e("x-hw-bkmode", this.f53402c.getBkmode());
        aVar.m71578e("x-hw-flowControlCnt", this.f53402c.getFlowControlCnt());
        aVar.m71578e("x-hw-bkStartDays", this.f53402c.getBkStartDays());
        aVar.m71578e("x-hw-lastbkCompleteDays", this.f53402c.getLastbkCompleteDays());
        aVar.m71578e("x-hw-packageByte", this.f53402c.getPackageByte());
        aVar.m71578e("x-hw-bkByte", this.f53402c.getBkByte());
        aVar.m71578e("x-hw-bkNeedSpace", this.f53402c.getBkNeedSpace());
        aVar.m71578e("x-hw-backupkTimes", String.valueOf(this.f53402c.getBackupkTimes()));
        aVar.m71578e("x-hw-chargeMode", this.f53402c.getChargeMode());
        aVar.m71578e("x-hw-fullBK", String.valueOf(this.f53402c.isFullBK()));
        aVar.m71578e("x-hw-network", this.f53402c.getNetwork());
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public String onResponse(C11922g0 c11922g0) throws C9721b, IOException {
        return c11922g0.m71595s().m71637z();
    }
}
