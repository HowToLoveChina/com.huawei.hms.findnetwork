package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetFreePackageResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import fk.C9721b;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p292fn.C9733f;
import p315gj.C9948a;
import p336he.C10155f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.a0 */
/* loaded from: classes5.dex */
public class C10211a0 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49538b;

    public C10211a0(Handler handler) {
        this.f49538b = handler;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        Filter filter;
        HiCloudSysParamMap hiCloudSysParamMapM60758q;
        boolean zM63289m = C10155f.m63289m();
        if (C13452e.m80781L().m80803F0().booleanValue() && zM63289m) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06019"), "getFreePackage", C13452e.m80781L().m80971t0());
            C1442a.m8290i("GetFreePackageTask", "GetFreePackageTask start");
            try {
                try {
                    c11060cM66626a.m66665u(String.valueOf(0));
                    c11060cM66626a.m66635A("success");
                    m63380f(this.f49538b, 7048, C9948a.m61631C().m61633A(c11060cM66626a));
                } catch (C9721b e10) {
                    C1442a.m8291w("GetFreePackageTask", "GetFreePackageTask err. " + e10.m60659c() + " " + e10.getMessage());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("114_");
                    sb2.append(e10.m60659c());
                    c11060cM66626a.m66665u(sb2.toString());
                    c11060cM66626a.m66635A(e10.getMessage());
                    m63379e(this.f49538b, 7049, e10);
                }
                return;
            } finally {
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                C1442a.m8290i("GetFreePackageTask", "GetFreePackageTask end");
            }
        }
        C11060c c11060cM66626a2 = C11058a.m66626a(C11058a.m66627b("06008"), "getAvailableGradePackages", C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a2.m66665u(String.valueOf(0));
                c11060cM66626a2.m66635A("success");
                filter = new Filter();
                hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
            } catch (C9721b e11) {
                C1442a.m8289e("GetFreePackageTask", "getAvailableGradePackages err. " + e11.m60659c() + " " + e11.getMessage());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("114_");
                sb3.append(e11.m60659c());
                c11060cM66626a2.m66665u(sb3.toString());
                c11060cM66626a2.m66635A(e11.getMessage());
                m63379e(this.f49538b, 7049, new C9721b(e11.m60659c(), e11.getMessage()));
            }
            if (hiCloudSysParamMapM60758q == null) {
                C1442a.m8289e("GetFreePackageTask", "sysParamMap is null");
                m63379e(this.f49538b, 7049, new C9721b(2, "sysParamMap is null"));
            } else {
                String spaceExperienceGiftPackagePackageId = hiCloudSysParamMapM60758q.getSpaceExperienceGiftPackagePackageId();
                C1442a.m8288d("GetFreePackageTask", "experienceGiftPackagePackageId: " + spaceExperienceGiftPackagePackageId);
                if (TextUtils.isEmpty(spaceExperienceGiftPackagePackageId)) {
                    C1442a.m8289e("GetFreePackageTask", "experienceGiftPackagePackageId is empty");
                    m63379e(this.f49538b, 7049, new C9721b(2, "experienceGiftPackagePackageId is empty"));
                } else {
                    filter.setPackageId(spaceExperienceGiftPackagePackageId);
                    GetAvailableGradePackagesResp getAvailableGradePackagesRespM61697u = C9948a.m61631C().m61697u(c11060cM66626a2, filter, null, new ChannelInfo());
                    if (getAvailableGradePackagesRespM61697u == null) {
                        C1442a.m8289e("GetFreePackageTask", "resp is null");
                        m63379e(this.f49538b, 7049, new C9721b(2, "resp is null"));
                    } else {
                        List<CloudPackage> spacePackages = getAvailableGradePackagesRespM61697u.getSpacePackages();
                        if (spacePackages == null || spacePackages.isEmpty()) {
                            C1442a.m8289e("GetFreePackageTask", "response spacePackages is null or empty");
                            m63379e(this.f49538b, 7049, new C9721b(2, "response spacePackages is null or empty"));
                        } else if (C11829c.m70526J0()) {
                            C1442a.m8289e("GetFreePackageTask", "is FamilyShare user");
                            m63379e(this.f49538b, 7049, new C9721b(2, "is FamilyShare user"));
                        } else {
                            UserPackage userPackageM61644M = C9948a.m61631C().m61644M(c11060cM66626a2, "GetFreePackageTask");
                            if (userPackageM61644M != null) {
                                C1442a.m8290i("GetFreePackageTask", "getUserPackage UserPayType: " + userPackageM61644M.getUserPayType());
                                if (userPackageM61644M.getUserPayType() == 0) {
                                    m63380f(this.f49538b, 7048, new GetFreePackageResp());
                                } else {
                                    m63379e(this.f49538b, 7049, new C9721b(2, "vip UserPayType: " + userPackageM61644M.getUserPayType()));
                                }
                                return;
                            }
                            C1442a.m8289e("GetFreePackageTask", "getUserPackage userPackage is null");
                            m63379e(this.f49538b, 7049, new C9721b(2, "getUserPackage userPackage is null"));
                        }
                    }
                }
            }
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a2);
        }
    }
}
