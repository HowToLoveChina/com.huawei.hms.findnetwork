package mm;

import fk.C9721b;
import pl.C12164f;

/* renamed from: mm.h */
/* loaded from: classes6.dex */
public class C11486h extends AbstractC11484f {

    /* renamed from: c */
    public String f53391c;

    public C11486h(String str, String str2, C12164f c12164f) {
        super(str2, c12164f);
        this.f53391c = str;
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        int[] iArr = {6, 7, 8, 9};
        for (int i10 = 0; i10 < 4; i10++) {
            c12164f.build(getTableName(), "select id from snapshot_data where type = ? and app_id = ? and cloud_path = ?;", new String[]{String.valueOf(iArr[i10]), str, this.f53391c});
        }
    }
}
