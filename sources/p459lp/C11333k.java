package p459lp;

import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.StorageLimitStatusThresholdBean;
import p292fn.C9733f;
import p371ik.C10527a;
import p399jk.AbstractC10896a;
import p709vj.C13452e;

/* renamed from: lp.k */
/* loaded from: classes7.dex */
public class C11333k {

    /* renamed from: lp.k$b */
    public static class b {

        /* renamed from: a */
        public static C11333k f53022a = new C11333k();
    }

    /* renamed from: b */
    public static C11333k m68086b() {
        return b.f53022a;
    }

    /* renamed from: a */
    public final int m68087a(long j10) {
        AbstractC10896a.m65885d("StorageLimitStatusUtils", "getDefaultStorageLimitStatus");
        if (j10 <= 10485760) {
            return 0;
        }
        return j10 <= 524288000 ? 1 : 2;
    }

    /* renamed from: c */
    public int m68088c(long j10) {
        if (C13452e.m80781L().m80791C0()) {
            AbstractC10896a.m65887i("StorageLimitStatusUtils", "getStorageLimitStatus new base user");
            return 2;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            AbstractC10896a.m65888w("StorageLimitStatusUtils", "getStorageLimitStatus, sysParamMap is null!");
            return m68087a(j10);
        }
        StorageLimitStatusThresholdBean storageLimitStatusThresholdBean = (StorageLimitStatusThresholdBean) C10527a.m64629g(hiCloudSysParamMapM60758q.getStorageLimitStatusThreshold(), StorageLimitStatusThresholdBean.class);
        if (storageLimitStatusThresholdBean == null) {
            AbstractC10896a.m65888w("StorageLimitStatusUtils", "getStorageLimitStatus, statusThresholdBean is null!");
            return m68087a(j10);
        }
        long lower = ((long) storageLimitStatusThresholdBean.getLower()) * 1048576 <= 0 ? 10485760L : storageLimitStatusThresholdBean.getLower() * 1048576;
        long upper = ((long) storageLimitStatusThresholdBean.getUpper()) * 1048576 <= 0 ? 524288000L : 1048576 * storageLimitStatusThresholdBean.getUpper();
        if (j10 <= lower) {
            return 0;
        }
        if (j10 <= upper) {
            return 1;
        }
        if (j10 > storageLimitStatusThresholdBean.getUpper()) {
            return 2;
        }
        return m68087a(j10);
    }

    /* renamed from: d */
    public int m68089d() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            AbstractC10896a.m65888w("StorageLimitStatusUtils", "getTimeout, sysParamMap is null!");
            return 3000;
        }
        StorageLimitStatusThresholdBean storageLimitStatusThresholdBean = (StorageLimitStatusThresholdBean) C10527a.m64629g(hiCloudSysParamMapM60758q.getStorageLimitStatusThreshold(), StorageLimitStatusThresholdBean.class);
        if (storageLimitStatusThresholdBean == null) {
            AbstractC10896a.m65888w("StorageLimitStatusUtils", "getTimeout, statusThresholdBean is null!");
            return 3000;
        }
        if (storageLimitStatusThresholdBean.getTimeout() == 0) {
            return 3000;
        }
        return storageLimitStatusThresholdBean.getTimeout();
    }

    /* renamed from: e */
    public boolean m68090e(long j10) {
        return m68088c(j10) == 0;
    }

    /* renamed from: f */
    public boolean m68091f(long j10) {
        return m68088c(j10) == 1 || m68088c(j10) == 0;
    }

    /* renamed from: g */
    public boolean m68092g(long j10) {
        return m68088c(j10) == 1 || m68088c(j10) == 2;
    }

    public C11333k() {
    }
}
