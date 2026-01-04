package am;

import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: am.a */
/* loaded from: classes6.dex */
public abstract class AbstractC0249a extends AbstractC12367d {

    /* renamed from: a */
    public C1457c f877a;

    public void keepLock() {
        try {
            C1457c c1457c = this.f877a;
            if (c1457c == null) {
                C11839m.m70688i(getTag(), "keepLock error, backupV3Lock == null");
            } else {
                c1457c.m8328c();
            }
        } catch (C9721b e10) {
            C11839m.m70687e(getTag(), "keepLock error: " + e10.getMessage());
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public void release() {
        super.release();
        CBAccess.removeDeleteTask(this);
    }
}
