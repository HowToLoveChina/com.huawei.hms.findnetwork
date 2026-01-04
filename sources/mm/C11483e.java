package mm;

import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import fk.C9721b;
import java.io.File;
import pl.C12164f;

/* renamed from: mm.e */
/* loaded from: classes6.dex */
public class C11483e extends AbstractC11484f {
    public C11483e(String str, C12164f c12164f) {
        super(str, c12164f);
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        int[] iArr = {6, 7, 8, 9};
        for (int i10 = 0; i10 < 4; i10++) {
            c12164f.build(getTableName(), "select id from snapshot_data where type = ? and app_id = ? and root = ? and (hash1 isnull or hash1 = '' or hash2 isnull or hash2 = '');", new String[]{String.valueOf(iArr[i10]), str, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
        }
    }
}
