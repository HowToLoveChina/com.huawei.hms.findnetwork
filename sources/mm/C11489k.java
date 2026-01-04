package mm;

import fk.C9721b;
import pl.C12164f;

/* renamed from: mm.k */
/* loaded from: classes6.dex */
public class C11489k extends AbstractC11484f {
    public C11489k(String str, C12164f c12164f) {
        super(str, c12164f);
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        c12164f.build(getTableName(), "select id from snapshot_data where app_id = ? and type in (6,7,8,9) and status in (4,-4,5,-5,6,-6) and data3 != 1 group by file_id || cloud_path;", new String[]{str});
    }
}
