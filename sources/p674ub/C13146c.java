package p674ub;

import android.database.SQLException;
import com.huawei.android.hicloud.cloudbackup.process.CloudAlbumNotificationManager;
import com.huawei.android.hicloud.task.simple.C3103z1;
import com.huawei.hicloud.notification.ICloudBackupNotifyProxy;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import fj.C9718g;
import java.util.LinkedHashMap;
import org.json.JSONException;
import p015ak.C0213f;
import p020ap.C1006a;
import p315gj.C9949b;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: ub.c */
/* loaded from: classes3.dex */
public class C13146c implements ICloudBackupNotifyProxy {
    /* renamed from: a */
    public final boolean m79051a(long j10) {
        return j10 > 0 && C1006a.m5936k().m5937A(C0213f.m1377a(), j10);
    }

    @Override // com.huawei.hicloud.notification.ICloudBackupNotifyProxy
    public NotifyNeedData buildAlbumSpaceNeedData(SpaceNotification spaceNotification, String str, long j10) {
        return new CloudAlbumNotificationManager(C0213f.m1377a().getApplicationContext()).buildNotifyNeedData(spaceNotification, str, j10);
    }

    @Override // com.huawei.hicloud.notification.ICloudBackupNotifyProxy
    public boolean isAlbumOn() {
        return C1006a.m5936k().m5975v(C0213f.m1377a());
    }

    @Override // com.huawei.hicloud.notification.ICloudBackupNotifyProxy
    public boolean isBackupClearsConditionAllow() {
        return C3103z1.m18444e(RecommendCardConstants.Entrance.HOMEPAGE);
    }

    @Override // com.huawei.hicloud.notification.ICloudBackupNotifyProxy
    public boolean isHasActivityEntry(int i10) {
        C11839m.m70688i("CloudBackupNotifyProxyImp", "isHasActivityEntry desktopSource: " + i10);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        return RecommendCardManager.getInstance().getIncentiveObjectWithException(RecommendCardConstants.Entrance.HOMEPAGE, RecommendCardManager.getInstance().getIncentiveCardActivityEntryEx(RecommendCardConstants.Entrance.DESKTOP_DIALOG, linkedHashMapM79497A, i10), linkedHashMapM79497A) != null;
    }

    @Override // com.huawei.hicloud.notification.ICloudBackupNotifyProxy
    public boolean isHasCampaignActivityData(int i10) {
        C11839m.m70688i("CloudBackupNotifyProxyImp", "isHasCampaignActivityData desktopSource: " + i10);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06028"), "/activity/entry", C13452e.m80781L().m80971t0());
        HiCloudAllOMConfigManager.getInstance().queryConfigSync("HiCloudCampaignQuests");
        try {
            c11060cM66626a.m66665u(String.valueOf(0));
            c11060cM66626a.m66635A("success");
            if (i10 <= 0) {
                i10 = 5;
            }
            C9718g.m60602t().m60620V(C0213f.m1377a(), C9949b.m61704j().m61712h(c11060cM66626a, i10));
            if (C9718g.m60602t().m60608F(C0213f.m1377a())) {
                C11839m.m70689w("CloudBackupNotifyProxyImp", "isHasCampaignActivityData exceed redemption limit");
                return false;
            }
            if (CampaignCheckUtil.checkCampaignEntryCondition(C0213f.m1377a())) {
                return true;
            }
            C11839m.m70689w("CloudBackupNotifyProxyImp", "isHasCampaignActivityData checkCampaignEntryCondition false");
            return false;
        } catch (Exception unused) {
            C11839m.m70687e("CloudBackupNotifyProxyImp", "isHasCampaignActivityData request failed");
            return false;
        }
    }

    @Override // com.huawei.hicloud.notification.ICloudBackupNotifyProxy
    public boolean showNotify(boolean z10, long j10) throws JSONException, SQLException {
        if (!m79051a(j10)) {
            return false;
        }
        new CloudAlbumNotificationManager(C0213f.m1377a().getApplicationContext()).showNotify(z10, j10);
        return true;
    }
}
