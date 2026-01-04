package p770xc;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.ArrayList;
import p514o9.C11839m;
import p664u0.C13108a;
import sc.C12770c;
import tc.C13007b;

@CBServiceTask(request = 55000012, response = 66000012)
/* renamed from: xc.r */
/* loaded from: classes3.dex */
public class C13755r extends AbstractC13752o {
    /* renamed from: C */
    private void m82631C(int i10) {
        C11839m.m70688i("UpdateCtagTask", "Callback, value = " + i10);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.f61836u);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.f61834s);
        intent.putExtra("msgID", NotifyConstants.RequestCode.REQUESTCODE_CAMPAIGN);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f53282a).m78881d(intent);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        C11839m.m70688i("UpdateCtagTask", "End afterWorkDone");
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("UpdateCtagTask", "Begin doWork");
        m82631C(m82634E());
        return Boolean.FALSE;
    }

    /* renamed from: E */
    public int m82634E() {
        C11839m.m70688i("UpdateCtagTask", "Begin updateCtag");
        try {
            C13007b c13007bM78205Y = C13007b.m78205Y(this.f53282a);
            String strM78288u = c13007bM78205Y.m78288u(this.f61835t);
            C12770c c12770c = new C12770c();
            CtagInfo ctagInfo = new CtagInfo();
            ctagInfo.setCtagName(this.f61835t);
            ctagInfo.setCtagValue(strM78288u);
            C11839m.m70686d("UpdateCtagTask", "updateCtag, dataType = " + this.f61835t + ", ctagValue = " + strM78288u);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ctagInfo);
            c12770c.m76642j(arrayList);
            c13007bM78205Y.m78250b(this.f61835t);
            return 0;
        } catch (Exception e10) {
            C11839m.m70687e("UpdateCtagTask", "Exception occour e =" + e10.toString());
            return 5;
        }
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("UpdateCtagTask", "Begin beforeWorkStart");
        super.mo66489c();
    }
}
