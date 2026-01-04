package mm;

import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import fk.C9721b;
import java.util.List;
import pl.C12161c;
import pl.C12164f;

/* renamed from: mm.f */
/* loaded from: classes6.dex */
public abstract class AbstractC11484f extends AbstractC11494p<C12161c> {

    /* renamed from: a */
    public String f53389a;

    /* renamed from: b */
    public C12164f f53390b;

    public AbstractC11484f(String str, C12164f c12164f) {
        this.f53389a = str;
        this.f53390b = c12164f;
    }

    /* renamed from: a */
    public abstract void mo68638a(String str, C12164f c12164f) throws C9721b;

    /* renamed from: b */
    public C12164f m68642b() {
        return this.f53390b;
    }

    @Override // mm.AbstractC11494p
    public List<C12161c> batchQuery(long j10, long j11) throws C9721b {
        return this.f53390b.batchQuery(SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, getTableName(), j10, j11);
    }

    @Override // mm.AbstractC11494p
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C12161c query(int i10) throws C9721b {
        return this.f53390b.query(SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, getTableName(), i10);
    }

    @Override // mm.AbstractC11494p
    public void create() throws C9721b {
        this.f53390b.m73041I0();
        mo68638a(this.f53389a, this.f53390b);
    }

    @Override // mm.AbstractC11494p
    public void drop() throws C9721b {
        this.f53390b.dropIdx(getTableName());
    }

    @Override // mm.AbstractC11494p
    public int summary() throws C9721b {
        return this.f53390b.summary(getTableName());
    }
}
