package mm;

import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import fk.C9721b;
import java.util.List;
import pl.C12161c;
import pl.C12164f;

/* renamed from: mm.a */
/* loaded from: classes6.dex */
public class C11479a extends AbstractC11484f {

    /* renamed from: c */
    public int f53384c;

    public C11479a(String str, C12164f c12164f, int i10) {
        super(str, c12164f);
        this.f53384c = i10;
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        c12164f.build(getTableName(), "SELECT id FROM snapshot_data WHERE app_id = ? AND flag = ? AND file_id IS NOT NULL AND file_id != '' group by file_id;", new String[]{str, String.valueOf(this.f53384c)});
    }

    @Override // mm.AbstractC11484f, mm.AbstractC11494p
    public List<C12161c> batchQuery(long j10, long j11) throws C9721b {
        return m68642b().batchQuery(SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, getTableName(), j10, j11);
    }
}
