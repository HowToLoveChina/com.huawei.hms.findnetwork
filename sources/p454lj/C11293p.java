package p454lj;

import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.UserPackage;
import java.util.List;
import p054cj.C1442a;

/* renamed from: lj.p */
/* loaded from: classes5.dex */
public class C11293p {
    /* renamed from: a */
    public static CloudSpace m67757a(UserPackage userPackage) {
        if (userPackage == null) {
            return null;
        }
        CloudSpace cloudSpaceM67760d = m67760d(userPackage.getEffectivePackages(), 0);
        return cloudSpaceM67760d == null ? userPackage.getEffectivePackage() : cloudSpaceM67760d;
    }

    /* renamed from: b */
    public static CloudSpace m67758b(UserPackage userPackage) {
        if (userPackage == null) {
            return null;
        }
        return m67760d(userPackage.getEffectivePackages(), 2);
    }

    /* renamed from: c */
    public static CloudSpace m67759c(UserPackage userPackage, int i10) {
        if (userPackage == null) {
            return null;
        }
        return m67760d(userPackage.getEffectivePackages(), i10);
    }

    /* renamed from: d */
    public static CloudSpace m67760d(List<CloudSpace> list, int i10) {
        if (list == null) {
            return null;
        }
        for (CloudSpace cloudSpace : list) {
            if (cloudSpace != null && cloudSpace.getScheme() == i10) {
                return cloudSpace;
            }
        }
        return null;
    }

    /* renamed from: e */
    public static CloudSpace m67761e(List<CloudSpace> list, int i10) {
        if (list == null) {
            return null;
        }
        for (CloudSpace cloudSpace : list) {
            if (cloudSpace != null && cloudSpace.getType() == i10) {
                return cloudSpace;
            }
        }
        return null;
    }

    /* renamed from: f */
    public static long m67762f(UserPackage userPackage) {
        long totalCapacity = 0;
        if (userPackage == null) {
            return 0L;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (effectivePackages == null) {
            CloudSpace effectivePackage = userPackage.getEffectivePackage();
            if (effectivePackage != null) {
                return effectivePackage.getTotalCapacity();
            }
            return 0L;
        }
        for (CloudSpace cloudSpace : effectivePackages) {
            if (cloudSpace != null) {
                totalCapacity += cloudSpace.getTotalCapacity();
            }
        }
        return totalCapacity;
    }

    /* renamed from: g */
    public static String m67763g(UserPackage userPackage) {
        if (userPackage == null) {
            return null;
        }
        CloudSpace cloudSpaceM67760d = m67760d(userPackage.getEffectivePackages(), 0);
        if (cloudSpaceM67760d != null) {
            return cloudSpaceM67760d.getGradeName();
        }
        MemGradeRights gradeRights = userPackage.getGradeRights();
        return gradeRights != null ? gradeRights.getGradeName() : "";
    }

    /* renamed from: h */
    public static String m67764h(UserPackage userPackage, int i10) {
        if (userPackage == null) {
            return null;
        }
        CloudSpace cloudSpaceM67761e = m67761e(userPackage.getEffectivePackages(), i10);
        if (cloudSpaceM67761e != null) {
            return cloudSpaceM67761e.getGradeName();
        }
        MemGradeRights gradeRights = userPackage.getGradeRights();
        return gradeRights != null ? gradeRights.getGradeName() : "";
    }

    /* renamed from: i */
    public static long m67765i(UserPackage userPackage) {
        long capacity = 0;
        if (userPackage == null) {
            C1442a.m8290i("UserPackageUtil", "getWorryFreeCheckTotal user is null");
            return 0L;
        }
        for (CloudSpace cloudSpace : userPackage.getEffectivePackages()) {
            if (cloudSpace != null && (cloudSpace.getScheme() == 0 || cloudSpace.getScheme() == 2)) {
                capacity += cloudSpace.getCapacity();
            }
        }
        return capacity;
    }

    /* renamed from: j */
    public static String m67766j(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8291w("UserPackageUtil", "getUserGradeName user is null");
            return "";
        }
        MemGradeRights gradeRights = userPackage.getGradeRights();
        if (gradeRights != null) {
            return gradeRights.getGradeName();
        }
        C1442a.m8291w("UserPackageUtil", "getUserGradeName rights is null");
        return "";
    }

    /* renamed from: k */
    public static int m67767k(UserPackage userPackage) {
        if (userPackage == null) {
            return 0;
        }
        CloudSpace cloudSpaceM67760d = m67760d(userPackage.getEffectivePackages(), 0);
        return cloudSpaceM67760d != null ? cloudSpaceM67760d.getUserPayType() : userPackage.getUserPayType();
    }

    /* renamed from: l */
    public static long m67768l(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8290i("UserPackageUtil", "getWorryFreeCheckTotal user is null");
            return 0L;
        }
        CloudSpace effectivePackage = userPackage.getEffectivePackage();
        if (effectivePackage == null) {
            C1442a.m8290i("UserPackageUtil", "getWorryFreeCheckTotal effectivePackage is null");
            return 0L;
        }
        CloudSpace cloudSpaceM67761e = m67761e(userPackage.getEffectivePackages(), 12);
        return cloudSpaceM67761e != null ? effectivePackage.getTotalCapacity() - cloudSpaceM67761e.getCapacity() : effectivePackage.getTotalCapacity();
    }

    /* renamed from: m */
    public static boolean m67769m(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8289e("UserPackageUtil", "hasOnlyPetalOne2Pg user is null");
            return false;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (effectivePackages != null && !effectivePackages.isEmpty()) {
            return effectivePackages.size() == 1 && effectivePackages.get(0).getScheme() == 1 && m67776t(effectivePackages.get(0).getPetalOneMemberType());
        }
        C1442a.m8289e("UserPackageUtil", "hasOnlyPetalOne2Pg effectivePackages is null or empty.");
        return false;
    }

    /* renamed from: n */
    public static boolean m67770n(UserPackage userPackage) {
        List<CloudSpace> effectivePackages;
        return (userPackage == null || (effectivePackages = userPackage.getEffectivePackages()) == null || effectivePackages.size() <= 0 || m67760d(effectivePackages, 1) == null) ? false : true;
    }

    /* renamed from: o */
    public static boolean m67771o(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8289e("UserPackageUtil", "hasPetalOne2Pg user is null");
            return false;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (effectivePackages == null || effectivePackages.isEmpty()) {
            C1442a.m8289e("UserPackageUtil", "hasPetalOne2Pg effectivePackages is null or empty.");
            return false;
        }
        for (CloudSpace cloudSpace : effectivePackages) {
            if (cloudSpace.getScheme() == 1 && m67776t(cloudSpace.getPetalOneMemberType())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: p */
    public static boolean m67772p(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8290i("UserPackageUtil", "user is null");
            return false;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (effectivePackages != null && effectivePackages.size() >= 1) {
            return m67761e(effectivePackages, 12) != null;
        }
        C1442a.m8290i("UserPackageUtil", "effectivePackages is null or empty");
        return false;
    }

    /* renamed from: q */
    public static boolean m67773q(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8291w("UserPackageUtil", "user is null");
            return false;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (effectivePackages == null || effectivePackages.size() < 1) {
            C1442a.m8291w("UserPackageUtil", "effectivePackages is null or empty");
            return false;
        }
        CloudSpace cloudSpaceM67761e = m67761e(effectivePackages, 12);
        return cloudSpaceM67761e != null && cloudSpaceM67761e.getDurationMonth() == 1 && cloudSpaceM67761e.getIsAutoPay() == 1;
    }

    /* renamed from: r */
    public static boolean m67774r(UserPackage userPackage) {
        CloudSpace cloudSpaceM67759c = m67759c(userPackage, 0);
        if (cloudSpaceM67759c != null) {
            return cloudSpaceM67759c.getType() == 0;
        }
        C1442a.m8291w("UserPackageUtil", "isCloudSpaceFree user is null");
        return false;
    }

    /* renamed from: s */
    public static boolean m67775s(UserPackage userPackage) {
        if (userPackage == null) {
            return false;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (CloudSpace cloudSpace : userPackage.getEffectivePackages()) {
            int scheme = cloudSpace.getScheme();
            if (scheme == 0 && cloudSpace.getType() != 0) {
                z10 = true;
            } else if (scheme == 2) {
                z11 = true;
            }
        }
        return !z10 && z11;
    }

    /* renamed from: t */
    public static boolean m67776t(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 3;
    }
}
