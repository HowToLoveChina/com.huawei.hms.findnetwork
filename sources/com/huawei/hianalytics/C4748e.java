package com.huawei.hianalytics;

import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import java.io.File;

/* renamed from: com.huawei.hianalytics.e */
/* loaded from: classes5.dex */
public class C4748e implements IStoragePolicy {

    /* renamed from: a */
    public File f21705a;

    /* renamed from: a */
    public final String f21706a;

    public C4748e(String str) {
        this.f21706a = str;
    }

    @Override // com.huawei.hianalytics.framework.policy.IStoragePolicy
    public boolean decide(String str, String str2) {
        str.hashCode();
        if (str.equals(IStoragePolicy.PolicyType.STORAGE_LENGTH)) {
            if (this.f21705a == null) {
                this.f21705a = new File(EnvUtils.getAppContext().getDatabasePath("haformal_event.db").getPath());
            }
            return this.f21705a.length() > C4782i.m28891a().m28893a().f21845a;
        }
        if (str.equals(IStoragePolicy.PolicyType.NETWORK)) {
            return C4785j.m28936b(EnvUtils.getAppContext());
        }
        return true;
    }

    @Override // com.huawei.hianalytics.framework.policy.IStoragePolicy
    public int getDecryptBatchSize(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21706a, str);
        if (c4728a1M28900a == null) {
            return 500;
        }
        return c4728a1M28900a.f21636e;
    }

    @Override // com.huawei.hianalytics.framework.policy.IStoragePolicy
    public int getDecryptBatchSleepTime(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21706a, str);
        if (c4728a1M28900a == null) {
            return 0;
        }
        return c4728a1M28900a.f21638f;
    }

    @Override // com.huawei.hianalytics.framework.policy.IStoragePolicy
    public int getDecryptMaxBatchSize(String str) {
        C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21706a, str);
        if (c4728a1M28900a == null) {
            return 500;
        }
        return c4728a1M28900a.f21633d;
    }

    @Override // com.huawei.hianalytics.framework.policy.IStoragePolicy
    public boolean decide(String str, String str2, long j10) {
        str.hashCode();
        if (str.equals(IStoragePolicy.PolicyType.STORAGE_CYCLE)) {
            long jCurrentTimeMillis = System.currentTimeMillis() - j10;
            C4728a1 c4728a1M28900a = C4785j.m28900a(this.f21706a, str2);
            return jCurrentTimeMillis > ((long) (c4728a1M28900a != null ? c4728a1M28900a.f21625b : 7)) * 86400000;
        }
        if (!str.equals(IStoragePolicy.PolicyType.STORAGE_SIZE)) {
            return false;
        }
        C4728a1 c4728a1M28900a2 = C4785j.m28900a(this.f21706a, str2);
        return j10 >= ((long) (c4728a1M28900a2 != null ? c4728a1M28900a2.f21619a : 30));
    }
}
