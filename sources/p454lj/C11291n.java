package p454lj;

import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.notification.IPayNotifyProxy;
import com.huawei.hicloud.notification.bean.NotifyUserCapacity;
import com.huawei.hicloud.notification.log.NotifyLogger;
import fk.C9721b;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p572qb.C12320l0;

/* renamed from: lj.n */
/* loaded from: classes5.dex */
public class C11291n implements IPayNotifyProxy {
    @Override // com.huawei.hicloud.notification.IPayNotifyProxy
    public NotifyUserCapacity getCloudSpace(long j10, int i10) {
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        NotifyUserCapacity notifyUserCapacity = new NotifyUserCapacity();
        notifyUserCapacity.setErrorCode(-1);
        try {
            UserPackage userPackageM61644M = C9948a.m61631C().m61644M(c11060c, "PayNotifyProxyImp");
            if (userPackageM61644M == null) {
                NotifyLogger.m29916w("NotifyProxyImp", "userPackage is null.");
                return notifyUserCapacity;
            }
            if (userPackageM61644M.getIsAutoPay() != 1) {
                if (j10 < 0) {
                    CloudSpace expiredPackage = userPackageM61644M.getExpiredPackage();
                    if (expiredPackage != null) {
                        notifyUserCapacity.setCapacity(expiredPackage.getCapacity());
                        notifyUserCapacity.setErrorCode(0);
                    }
                } else {
                    CloudSpace cloudSpaceM67757a = C11293p.m67757a(userPackageM61644M);
                    if (cloudSpaceM67757a != null) {
                        notifyUserCapacity.setCapacity(cloudSpaceM67757a.getCapacity());
                        notifyUserCapacity.setErrorCode(0);
                    }
                }
                return notifyUserCapacity;
            }
            if (i10 == 1) {
                MemGradeRights gradeRights = userPackageM61644M.getGradeRights();
                if (gradeRights == null) {
                    return notifyUserCapacity;
                }
                if (gradeRights.getGradeType() == 9) {
                    boolean zM67860a = C11303z.m67859c().m67860a(C11303z.m67859c().m67861b());
                    CloudSpace cloudSpaceM67758b = C11293p.m67758b(userPackageM61644M);
                    if (cloudSpaceM67758b != null && cloudSpaceM67758b.getIsAutoPay() == 1) {
                        return notifyUserCapacity;
                    }
                    NotifyLogger.m29915i("NotifyProxyImp", "hasWorryFree: " + zM67860a);
                    if (zM67860a) {
                        notifyUserCapacity.setCapacity(C11293p.m67768l(userPackageM61644M));
                        notifyUserCapacity.setErrorCode(-2);
                    }
                }
            }
            NotifyLogger.m29915i("NotifyProxyImp", "package is month package.");
            return notifyUserCapacity;
        } catch (C9721b e10) {
            NotifyLogger.m29914e("NotifyProxyImp", "getUserCurrentPackageInfo error = " + e10.getMessage());
            return notifyUserCapacity;
        }
    }

    @Override // com.huawei.hicloud.notification.IPayNotifyProxy
    public void refreshTimeZone() {
        C12320l0.m74090a().m74091b();
    }
}
