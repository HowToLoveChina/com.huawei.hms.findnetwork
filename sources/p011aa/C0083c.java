package p011aa;

import com.huawei.android.hicloud.datamigration.bean.KeepLockTokenResp;
import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p837z9.C14162c;

/* renamed from: aa.c */
/* loaded from: classes3.dex */
public class C0083c extends AbstractC12369f {

    /* renamed from: a */
    public String f314a;

    /* renamed from: b */
    public String f315b;

    public C0083c(long j10, long j11, String str, String str2) {
        super(j10, j11);
        this.f314a = str2;
        this.f315b = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            KeepLockTokenResp keepLockTokenRespM84979k = new C14162c(this.f314a).m84979k(this.f315b);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("keep lock result is ");
            sb2.append(keepLockTokenRespM84979k != null ? keepLockTokenRespM84979k.toString() : "null");
            C11839m.m70688i("KeepMigrateLockTimer", sb2.toString());
        } catch (C9721b e10) {
            C11839m.m70687e("KeepMigrateLockTimer", "keep lock error " + e10.getMessage() + e10.m60659c());
        }
    }
}
