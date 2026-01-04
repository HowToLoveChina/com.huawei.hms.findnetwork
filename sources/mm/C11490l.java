package mm;

import fk.C9721b;
import pl.C12164f;

/* renamed from: mm.l */
/* loaded from: classes6.dex */
public class C11490l extends AbstractC11484f {
    public C11490l(String str, C12164f c12164f) {
        super(str, c12164f);
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        c12164f.build(getTableName(), "select id from snapshot_data where id>=0 and status = ? and type = ? and app_id = ?;", new String[]{String.valueOf(0), String.valueOf(5), str});
    }
}
