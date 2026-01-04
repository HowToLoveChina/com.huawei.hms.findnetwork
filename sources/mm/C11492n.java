package mm;

import fk.C9721b;
import pl.C12164f;

/* renamed from: mm.n */
/* loaded from: classes6.dex */
public class C11492n extends AbstractC11484f {

    /* renamed from: c */
    public String f53393c;

    /* renamed from: d */
    public long f53394d;

    /* renamed from: e */
    public int f53395e;

    public C11492n(C12164f c12164f, String str, String str2, long j10, int i10) {
        super(str, c12164f);
        this.f53393c = str2;
        this.f53394d = j10;
        this.f53395e = i10;
    }

    @Override // mm.AbstractC11484f
    /* renamed from: a */
    public void mo68638a(String str, C12164f c12164f) throws C9721b {
        c12164f.build(getTableName(), this.f53395e == 1 ? "select id from snapshot_data where id >= 0 and app_id = ? and type = ? and file_id = ? and status in (0,1);" : "select id from snapshot_data where id >= 0 and app_id = ? and type = ? and cloud_path = ? and status in (0,1);", new String[]{str, String.valueOf(this.f53394d), this.f53393c});
    }
}
