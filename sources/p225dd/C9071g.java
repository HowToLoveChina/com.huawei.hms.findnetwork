package p225dd;

import android.database.sqlite.SQLiteDatabase;
import fk.C9721b;
import java.util.List;

/* renamed from: dd.g */
/* loaded from: classes3.dex */
public class C9071g extends AbstractC9069e<C9066b> {
    public C9071g(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: f */
    public void m57241f(List<C9066b> list) throws C9721b {
        m57236a("replace into t_sync_slices_upload_status(id, number, objectId, start, length, status, time, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    /* renamed from: g */
    public void m57242g(String str) throws C9721b {
        m57237b("t_sync_slices_upload_status", "id = ?", new String[]{str});
    }

    @Override // p225dd.AbstractC9069e
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public String[] mo57233e(C9066b c9066b) {
        return new String[]{c9066b.m57177k(), String.valueOf(c9066b.m57171a0()), c9066b.m57179q(), String.valueOf(c9066b.m57180r()), String.valueOf(c9066b.m57178p()), String.valueOf(c9066b.m57181s()), c9066b.m57182t(), c9066b.m57172b(), c9066b.m57173e(), c9066b.m57174f(), c9066b.m57175h(), c9066b.m57176i()};
    }

    /* renamed from: i */
    public void m57244i(C9066b c9066b) throws C9721b {
        m57238c("replace into t_sync_slices_upload_status(id, number, objectId, start, length, status, time, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?);", mo57233e(c9066b));
    }
}
