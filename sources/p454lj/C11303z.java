package p454lj;

import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.hicloud.notification.log.NotifyLogger;
import fk.C9721b;
import java.util.List;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;

/* renamed from: lj.z */
/* loaded from: classes5.dex */
public class C11303z {

    /* renamed from: lj.z$a */
    public static class a {

        /* renamed from: a */
        public static final C11303z f52957a = new C11303z();
    }

    /* renamed from: c */
    public static C11303z m67859c() {
        return a.f52957a;
    }

    /* renamed from: a */
    public boolean m67860a(GetAvailableGradePackagesResp getAvailableGradePackagesResp) {
        if (getAvailableGradePackagesResp == null) {
            NotifyLogger.m29915i("WorryFreePackageHelper", "checkHasWorryFree availableGradePackagesResp is null");
            return false;
        }
        List<CloudPackage> spacePackages = getAvailableGradePackagesResp.getSpacePackages();
        if (spacePackages == null) {
            NotifyLogger.m29915i("WorryFreePackageHelper", "checkHasWorryFree spacePackages is null");
            return false;
        }
        for (int i10 = 0; i10 < spacePackages.size(); i10++) {
            if (spacePackages.get(i10).getProductType() == 12) {
                return true;
            }
        }
        NotifyLogger.m29915i("WorryFreePackageHelper", "checkHasWorryFree no");
        return false;
    }

    /* renamed from: b */
    public GetAvailableGradePackagesResp m67861b() {
        Filter filter = new Filter();
        filter.setShowPlace(2);
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setSalChannel("1");
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06008"), "getAvailableGradePackages", C13452e.m80781L().m80971t0());
        try {
            c11060cM66626a.m66665u(String.valueOf(0));
            c11060cM66626a.m66635A("success");
            return C9948a.m61631C().m61697u(c11060cM66626a, filter, null, channelInfo);
        } catch (C9721b e10) {
            C1442a.m8289e("WorryFreePackageHelper", "getAvailableGradePackages err. " + e10.m60659c() + " " + e10.getMessage());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060cM66626a.m66665u(sb2.toString());
            c11060cM66626a.m66635A(e10.getMessage());
            return null;
        }
    }
}
