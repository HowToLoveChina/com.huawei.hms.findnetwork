package mm;

import fk.C9721b;
import pl.C12164f;

/* renamed from: mm.j */
/* loaded from: classes6.dex */
public class C11488j extends AbstractC11484f {
    public C11488j(String str, C12164f c12164f) {
        super(str, c12164f);
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        int[] iArr = {6, 7, 8, 9};
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            c12164f.build(getTableName(), i11 == 7 ? "select id from snapshot_data where id >= 0 and status = ? and type = ? and app_id = ?;" : "select id from snapshot_data where id>=0 and status = ? and type = ? and app_id = ?;", new String[]{String.valueOf(0), String.valueOf(i11), str});
        }
    }
}
