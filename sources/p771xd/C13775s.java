package p771xd;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import p459lp.C11333k;
import p514o9.C11839m;
import p654tb.C13003b;
import p654tb.C13004c;
import p654tb.C13005d;
import p703v8.C13368e;
import p709vj.C13452e;

/* renamed from: xd.s */
/* loaded from: classes3.dex */
public class C13775s implements ISpaceRemindHandler {

    /* renamed from: a */
    public String f61882a;

    /* renamed from: b */
    public boolean f61883b;

    /* renamed from: c */
    public final C13003b f61884c;

    public C13775s(C13003b c13003b) {
        this.f61884c = c13003b;
    }

    @Override // com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler
    /* renamed from: a */
    public C13004c mo24386a() {
        try {
            C13003b c13003b = this.f61884c;
            if (c13003b == null) {
                C11839m.m70687e("UserSpaceStateHandler", "context is null");
                return C13004c.m78185a("context is null", null, null, false);
            }
            C13005d c13005dM78178b = c13003b.m78178b();
            if (c13005dM78178b == null) {
                C11839m.m70687e("UserSpaceStateHandler", "spaceRemindUserInfo is null");
                return C13004c.m78185a("spaceRemindUserInfo is null", null, null, false);
            }
            this.f61882a = c13005dM78178b.m78191a();
            this.f61883b = c13005dM78178b.m78192b();
            QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
            if (quotaSpaceInfoM80223L == null) {
                C11839m.m70689w("UserSpaceStateHandler", "spaceInfo is null");
                return C13004c.m78185a("spaceInfo is null", null, null, false);
            }
            String strM82693c = m82693c(C11333k.m68086b().m68088c(quotaSpaceInfoM80223L.getAvailable()));
            C11839m.m70688i("UserSpaceStateHandler", "userSpaceState:" + strM82693c);
            this.f61884c.m78184h(strM82693c);
            return C13004c.m78186f(strM82693c, null, false);
        } catch (Exception e10) {
            C11839m.m70687e("UserSpaceStateHandler", "UserSpaceStateHandler handle error:" + e10.getMessage());
            return C13004c.m78185a("UserSpaceStateHandler handle error", null, null, false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler
    /* renamed from: b */
    public boolean mo24387b() {
        C13003b c13003b = this.f61884c;
        return c13003b != null && c13003b.m78180d();
    }

    /* renamed from: c */
    public final String m82693c(int i10) {
        boolean zM80811H0 = C13452e.m80781L().m80811H0();
        return i10 == 1 ? zM80811H0 ? "almostFullHighLevel" : "almostFull" : i10 == 0 ? zM80811H0 ? "fullHighLevel" : CloudBackupConstant.RestoreDataDictionaryType.FULL : (!this.f61883b || C13452e.m80781L().m80853S() < 0) ? "spaceNormal" : "planAboutToExpire";
    }
}
