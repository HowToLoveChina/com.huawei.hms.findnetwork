package p770xc;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.syncutil.C2974c;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import je.C10800n;
import p514o9.C11839m;
import p664u0.C13108a;

@CBServiceTask(request = 55000024, response = 66000024)
/* renamed from: xc.a */
/* loaded from: classes3.dex */
public class C13738a extends AbstractC13752o {

    /* renamed from: A */
    public int f61753A;

    /* renamed from: B */
    public boolean f61754B = false;

    /* renamed from: y */
    public int f61755y;

    /* renamed from: z */
    public int f61756z;

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        C11839m.m70688i("CheckRiskTask", "afterWorkDone isRiskEffective:" + this.f61754B);
        if (this.f61754B) {
            m82563E();
        }
    }

    /* renamed from: C */
    public final void m82561C(int i10) {
        C11839m.m70688i("CheckRiskTask", "CallBack, value = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.f61834s);
        intent.putExtra("msgID", RequestManager.NOTIFY_CONNECT_FAILED);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.f61836u);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f53282a).m78881d(intent);
        CloudSyncUtil.m15993a1(this.f53282a, this.f61834s, i10);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        boolean zM17833f;
        C11839m.m70688i("CheckRiskTask", "Begin doWork");
        int i10 = FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED;
        try {
            try {
                zM17833f = new C2974c(this.f53282a, this.f61834s, this.f61836u, this.f61835t, this.f61755y, this.f61756z, this.f61753A, this.f61833r).m17833f();
                this.f61754B = zM17833f;
            } catch (Exception e10) {
                C11839m.m70687e("CheckRiskTask", "doWork error:" + e10.toString());
                if (this.f61754B) {
                }
            }
            if (zM17833f) {
                C2980i.m17879n(this.f61839x, FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED, "risk effective");
            } else {
                i10 = 0;
            }
            m82561C(i10);
            return Boolean.FALSE;
        } catch (Throwable th2) {
            if (this.f61754B) {
                C2980i.m17879n(this.f61839x, i10, "risk effective");
            } else {
                i10 = 0;
            }
            m82561C(i10);
            throw th2;
        }
    }

    /* renamed from: E */
    public final void m82563E() {
        String str = this.f61834s;
        if (str == null) {
            C11839m.m70687e("CheckRiskTask", "notifyUISyncEnd syncType is null");
        } else {
            CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", str);
        }
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("CheckRiskTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61755y = c10800nM68549a.m65738c("data_add_key", 0);
        this.f61756z = c10800nM68549a.m65738c("data_del_key", 0);
        this.f61753A = c10800nM68549a.m65738c("data_upd_key", 0);
    }
}
