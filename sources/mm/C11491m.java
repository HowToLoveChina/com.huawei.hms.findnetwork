package mm;

import fk.C9721b;
import pl.C12164f;

/* renamed from: mm.m */
/* loaded from: classes6.dex */
public class C11491m extends AbstractC11484f {
    public C11491m(String str, C12164f c12164f) {
        super(str, c12164f);
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        int[] iArr = {5, 6, 7, 8, 9};
        for (int i10 = 0; i10 < 5; i10++) {
            int i11 = iArr[i10];
            if (i11 == 7) {
                c12164f.build(getTableName(), "select id from snapshot_data where id >= 0 and status = ? and type = ? and flag = ? and app_id = ? and trim(cloud_path) != '' and cloud_path not null group by cloud_path;", new String[]{String.valueOf(0), String.valueOf(i11), String.valueOf(0), str});
                c12164f.build(getTableName(), "select id from snapshot_data where id >= 0 and status = ? and type = ? and flag = ? and app_id = ? and trim(file_id) != '' and file_id not null group by file_id;", new String[]{String.valueOf(0), String.valueOf(i11), String.valueOf(1), str});
            } else {
                c12164f.build(getTableName(), "select id from snapshot_data where id>=0 and status = ? and type = ? and app_id = ?;", new String[]{String.valueOf(0), String.valueOf(i11), str});
            }
        }
    }
}
