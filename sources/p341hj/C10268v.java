package p341hj;

import android.os.Handler;
import com.google.gson.Gson;
import com.huawei.cloud.pay.config.bean.BannerAfterPayItem;
import com.huawei.cloud.pay.config.bean.BannerAfterPayRealtePackage;
import com.huawei.cloud.pay.config.bean.HiCloudPayBanners;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0236u;
import p054cj.C1442a;
import p454lj.C11278a;
import p709vj.C13452e;

/* renamed from: hj.v */
/* loaded from: classes5.dex */
public class C10268v extends AbstractC10222e {

    /* renamed from: b */
    public BannerAfterPayRealtePackage f49732b;

    /* renamed from: c */
    public Handler f49733c;

    public C10268v(BannerAfterPayRealtePackage bannerAfterPayRealtePackage, Handler handler) {
        this.f49732b = bannerAfterPayRealtePackage;
        this.f49733c = handler;
    }

    /* renamed from: h */
    public static boolean m63431h(List<PortraitAndGrade.UserTag> list, BannerAfterPayItem bannerAfterPayItem) {
        long jM1651b = C0236u.m1651b();
        List<String> userGroupExtIDs = bannerAfterPayItem.getUserGroupExtIDs();
        float percentage = bannerAfterPayItem.getPercentage();
        if (userGroupExtIDs == null || userGroupExtIDs.isEmpty()) {
            return percentage == -1.0f || ((float) (jM1651b % 100)) <= percentage;
        }
        if (!AdSwitchManager.getInstance().canDisplayAd(NotifyConstants.CommonReportConstants.SRC_AD_SWITCH_GET_ABNNER)) {
            C1442a.m8291w("GetBannerAfterPayParamsTask", "can't display ad");
            return false;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : userGroupExtIDs) {
                Iterator<PortraitAndGrade.UserTag> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserGroupExtID().equals(str) && jM1651b % 100 <= percentage) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() throws Throwable {
        if (this.f49732b == null) {
            C1442a.m8289e("GetBannerAfterPayParamsTask", "getBannerParams buyPackage is null.");
            m63379e(this.f49733c, 7031, new C9721b(4001, ""));
        }
        try {
            ArrayList<BannerAfterPayItem> bannerAfterPay = ((HiCloudPayBanners) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(new File(C0213f.m1377a().getFilesDir() + "/HiCloudPayBanners.json"))), HiCloudPayBanners.class)).getBannerAfterPay();
            if (bannerAfterPay.isEmpty()) {
                C1442a.m8289e("GetBannerAfterPayParamsTask", "getBannerParams banners is empty.");
                m63379e(this.f49733c, 7031, new C9721b(4001, ""));
            }
            List<PortraitAndGrade.UserTag> listM67689g = C11278a.m67689g();
            if (C13452e.m80781L().m80971t0() == null) {
                C1442a.m8289e("GetBannerAfterPayParamsTask", "getBannerParams userID is null.");
                m63379e(this.f49733c, 7031, new C9721b(4001, ""));
            }
            m63380f(this.f49733c, 7030, m63432i(this.f49732b, bannerAfterPay, listM67689g));
        } catch (Exception e10) {
            C1442a.m8289e("GetBannerAfterPayParamsTask", "getBannerParams failed : " + e10.toString());
            C1442a.m8291w("GetBannerAfterPayParamsTask", "getBannerParams has not data.");
            m63379e(this.f49733c, 7031, new C9721b(4001, ""));
        }
    }

    /* renamed from: i */
    public final BannerAfterPayItem m63432i(BannerAfterPayRealtePackage bannerAfterPayRealtePackage, List<BannerAfterPayItem> list, List<PortraitAndGrade.UserTag> list2) {
        if (bannerAfterPayRealtePackage == null) {
            C1442a.m8289e("GetBannerAfterPayParamsTask", "getBannerAfterPayItem buyPackage is null.");
            return null;
        }
        for (BannerAfterPayItem bannerAfterPayItem : list) {
            if (C11278a.m67691i(bannerAfterPayItem.getBeginTime(), bannerAfterPayItem.getEndTime())) {
                ArrayList<BannerAfterPayRealtePackage> realtePackages = bannerAfterPayItem.getRealtePackages();
                if (realtePackages.isEmpty()) {
                    continue;
                } else {
                    Iterator<BannerAfterPayRealtePackage> it = realtePackages.iterator();
                    while (it.hasNext()) {
                        BannerAfterPayRealtePackage next = it.next();
                        if (C11278a.m67690h(bannerAfterPayRealtePackage.getCycleType(), next.getCycleType()) && bannerAfterPayRealtePackage.getDurationMonth() == next.getDurationMonth() && bannerAfterPayRealtePackage.getDurationUnit() == next.getDurationUnit() && bannerAfterPayRealtePackage.getSize() == next.getSize() && m63431h(list2, bannerAfterPayItem)) {
                            return bannerAfterPayItem;
                        }
                    }
                }
            }
        }
        return null;
    }
}
