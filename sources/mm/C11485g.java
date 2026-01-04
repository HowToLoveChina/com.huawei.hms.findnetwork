package mm;

import fk.C9721b;
import pl.C12164f;

/* renamed from: mm.g */
/* loaded from: classes6.dex */
public class C11485g extends AbstractC11484f {
    public C11485g(String str, C12164f c12164f) {
        super(str, c12164f);
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        c12164f.build(getTableName(), "select id from snapshot_data where app_id = ? and type in (0,1,2,3,6,7,8,9) and data2 = 'delete' order by id;", new String[]{str});
    }
}
