package p618rm;

import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import p514o9.C11839m;
import p617rl.C12526j;

/* renamed from: rm.r1 */
/* loaded from: classes6.dex */
public class C12588r1 {

    /* renamed from: f */
    public static C12588r1 f57960f;

    /* renamed from: a */
    public long f57961a;

    /* renamed from: b */
    public long f57962b;

    /* renamed from: c */
    public double f57963c;

    /* renamed from: d */
    public long f57964d;

    /* renamed from: e */
    public long f57965e;

    /* renamed from: c */
    public static synchronized C12588r1 m75718c() {
        try {
            if (f57960f == null) {
                f57960f = new C12588r1();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f57960f;
    }

    /* renamed from: a */
    public long m75719a() {
        return this.f57961a;
    }

    /* renamed from: b */
    public long m75720b() {
        return this.f57965e;
    }

    /* renamed from: d */
    public long m75721d() {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace == null || localLeftSpace.longValue() <= 0) {
            C11839m.m70689w("QueryBatchSizeUtil", "freeSize is invalid.");
            return 0L;
        }
        C12526j c12526j = new C12526j();
        long jM75330D = c12526j.m75330D();
        this.f57961a = jM75330D;
        if (jM75330D == -1) {
            C11839m.m70688i("QueryBatchSizeUtil", "cacheUpper is invalid.");
            return 0L;
        }
        long jM75411p = c12526j.m75411p();
        this.f57962b = jM75411p;
        if (jM75411p == -1) {
            C11839m.m70688i("QueryBatchSizeUtil", "reservedSize is invalid.");
            return 0L;
        }
        double dM75328C = c12526j.m75328C();
        this.f57963c = dM75328C;
        if (dM75328C == -1.0d) {
            C11839m.m70688i("QueryBatchSizeUtil", "cacheRatio is invalid.");
            return 0L;
        }
        long jM75326B = c12526j.m75326B();
        this.f57964d = jM75326B;
        if (jM75326B == -1) {
            C11839m.m70688i("QueryBatchSizeUtil", "cacheMin is invalid.");
            return 0L;
        }
        this.f57965e = Math.max(this.f57964d, Math.min(this.f57961a + 314572800, localLeftSpace.longValue() - Math.max(this.f57962b, Double.valueOf(localLeftSpace.longValue() * this.f57963c).longValue())) - 314572800);
        C11839m.m70688i("QueryBatchSizeUtil", "cacheUpper: " + (this.f57961a / 1048576) + "MB, reservedSize: " + (this.f57962b / 1048576) + "MB, cacheRatio: " + this.f57963c + ", cacheMin: " + (this.f57964d / 1048576) + "MB, freeSize: " + (localLeftSpace.longValue() / 1048576) + "MB, batchSize: " + (this.f57965e / 1048576) + "MB");
        long jLongValue = localLeftSpace.longValue();
        long j10 = this.f57965e;
        if (jLongValue < this.f57962b + j10) {
            C11839m.m70688i("QueryBatchSizeUtil", "free size is less than batch size and reserved size.");
            return -1L;
        }
        if (j10 <= 0) {
            return 0L;
        }
        C11839m.m70688i("QueryBatchSizeUtil", "query batch size end, out put batch size.");
        return this.f57965e;
    }
}
