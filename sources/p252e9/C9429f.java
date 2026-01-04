package p252e9;

import ca.C1399b;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.HiCloudBrandBannerManager;
import com.huawei.hicloud.notification.manager.HiCloudSceneBannerManager;
import com.huawei.hicloud.notification.manager.HicloudPushGuideManager;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.manager.RestoreNotifyConfigManager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3LocalLangExecutor;
import com.huawei.hicloud.notification.spacelanguage.manager.SpaceMultLanguageManager;
import gp.C10028c;
import p015ak.C0213f;
import p284fb.C9681b;
import p336he.C10155f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p674ub.C13152i;
import p742wj.C13612b;

/* renamed from: e9.f */
/* loaded from: classes3.dex */
public class C9429f {

    /* renamed from: e9.f$a */
    public class a extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            new NotificationConfigManager().checkLanguageDataBase();
            C1399b.m8034o().m8039e();
            C9681b.m60470l().m60484d();
            RestoreNotifyConfigManager.checkRestoreNotifyConfig();
            C13152i.m79070o().m79093c();
            HicloudPushGuideManager.getInstance().checkLanguageDataBase();
            SpaceNoticeV3LocalLangExecutor.getInstance().checkLanguageDataBase();
            SpaceMultLanguageManager.getInstance().checkLanguageDataBase();
            HiCloudBrandBannerManager.getInstance().checkLanguageDataBase(RecommendCardConstants.Entrance.HOMEPAGE);
            HiCloudBrandBannerManager.getInstance().checkLanguageDataBase(RecommendCardConstants.Entrance.BUY);
            HiCloudSceneBannerManager.getInstance().checkLanguageDataBase(RecommendCardConstants.Entrance.HOMEPAGE);
            HiCloudSceneBannerManager.getInstance().checkLanguageDataBase(RecommendCardConstants.Entrance.BUY);
        }
    }

    /* renamed from: a */
    public static void m59137a() {
        boolean zIsLogin = C13612b.m81829B().isLogin();
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        boolean zM63259L = C10155f.m63259L(C0213f.m1377a());
        C11839m.m70688i("CommonDataBaseChecker", "checkLanguageDatabase, isHiCloudLogin = " + zIsLogin + ", isAgreedHiCloudTerms = " + zM62221H1 + ", isUserUnlocked = " + zM63259L);
        if (zIsLogin && zM62221H1 && zM63259L) {
            C12515a.m75110o().m75172d(new a());
        }
    }
}
