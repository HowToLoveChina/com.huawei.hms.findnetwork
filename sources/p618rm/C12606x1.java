package p618rm;

import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.Collections;
import java.util.List;

/* renamed from: rm.x1 */
/* loaded from: classes6.dex */
public class C12606x1 extends AbstractC12603w1<SnapshotBackupMeta> {

    /* renamed from: b */
    public String f58005b;

    /* renamed from: c */
    public SnapshotBackupMetaOperator f58006c;

    public C12606x1(CacheTask cacheTask) {
        super(cacheTask);
    }

    @Override // p618rm.AbstractC12603w1
    /* renamed from: a */
    public List<SnapshotBackupMeta> mo76057a(int i10) throws C9721b {
        return this.f58006c.queryHashInvalidMetasByLimit(this.f58005b, i10);
    }

    @Override // p618rm.AbstractC12603w1
    /* renamed from: b */
    public int mo76058b() throws C9721b {
        return this.f58006c.queryHashInvalidCount(this.f58005b);
    }

    @Override // p618rm.AbstractC12603w1
    /* renamed from: c */
    public void mo76059c(String str, String str2, int i10) {
        this.f58006c = new SnapshotBackupMetaOperator(str);
        this.f58005b = str2;
    }

    @Override // p618rm.AbstractC12603w1
    /* renamed from: e */
    public void mo76061e(List<SnapshotBackupMeta> list, String str) throws InterruptedException, C9721b {
        int i10 = 0;
        for (SnapshotBackupMeta snapshotBackupMeta : list) {
            if (i10 % 500 == 0) {
                this.f58003a.isCancel();
            }
            File fileM63442h = C10278a.m63442h(SnapshotTreeUtil.getLocalPath(snapshotBackupMeta, str));
            if (fileM63442h.exists()) {
                SnapshotTreeUtil.setMetaHashInfo(fileM63442h, snapshotBackupMeta, str);
                this.f58006c.batchReplace(Collections.singletonList(snapshotBackupMeta));
            }
            i10++;
        }
    }
}
