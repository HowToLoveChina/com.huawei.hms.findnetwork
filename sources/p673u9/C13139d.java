package p673u9;

import android.database.Cursor;
import android.database.SQLException;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import p704v9.C13388d;

/* renamed from: u9.d */
/* loaded from: classes3.dex */
public class C13139d extends AbstractC13137b<C13388d> {
    /* renamed from: f */
    public void m79027f(List<C13388d> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (C13388d c13388d : list) {
            arrayList.add(new String[]{String.valueOf(c13388d.m80460i()), c13388d.m80465s(), c13388d.m80464r(), c13388d.m80461k(), c13388d.m80468v(), c13388d.m80456b(), c13388d.m80470x(), String.valueOf(c13388d.m80466t()), String.valueOf(c13388d.m80463q()), String.valueOf(c13388d.m80467u()), String.valueOf(c13388d.m80469w()), String.valueOf(c13388d.m80462p()), c13388d.m80457e(), c13388d.m80458f(), c13388d.m80459h()});
        }
        m79019c("replace into t_restore_slice(id, server, path, object, synckey, bucket, time, sliceSize, num, status, taskId, offset, data1, data2, data3) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", arrayList);
    }

    /* renamed from: g */
    public void m79028g() {
        try {
            m79017a("delete from t_restore_slice");
        } catch (C9721b e10) {
            C11839m.m70687e("SliceOperator", "clear t_backup_meta error." + e10.getMessage());
        }
    }

    /* renamed from: h */
    public void m79029h(int i10, String str, String str2) throws C9721b, SQLException {
        m79018b("delete from t_restore_slice where id = ? and server = ? and path = ?;", new Object[]{Integer.valueOf(i10), str, str2});
    }

    @Override // p673u9.AbstractC13137b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C13388d mo79010d(Cursor cursor) {
        C13388d c13388d = new C13388d(cursor.getInt(0));
        c13388d.m80449H(cursor.getString(1));
        c13388d.m80448G(cursor.getString(2));
        c13388d.m80445D(cursor.getString(3));
        c13388d.m80452K(cursor.getString(4));
        c13388d.m80472z(cursor.getString(5));
        c13388d.m80454M(cursor.getString(6));
        c13388d.m80450I(cursor.getLong(7));
        c13388d.m80447F(cursor.getInt(8));
        c13388d.m80451J(cursor.getInt(9));
        c13388d.m80453L(cursor.getLong(10));
        c13388d.m80446E(cursor.getLong(11));
        c13388d.m80442A(cursor.getString(12));
        c13388d.m80443B(cursor.getString(13));
        c13388d.m80444C(cursor.getString(14));
        return c13388d;
    }

    /* renamed from: j */
    public List<C13388d> m79031j(int i10, String str, String str2) throws Throwable {
        List<C13388d> listM79020e = m79020e("select id, server, path, object, synckey, bucket, time, sliceSize, num, status, taskId, offset, data1, data2, data3 from t_restore_slice where id = ? and server = ? and path = ?;", new String[]{String.valueOf(i10), str, str2});
        return listM79020e == null ? new ArrayList() : listM79020e;
    }

    /* renamed from: k */
    public void m79032k(C13388d c13388d) throws C9721b, SQLException {
        m79018b("replace into t_restore_slice(id, server, path, object, synckey, bucket, time, sliceSize, num, status, taskId, offset, data1, data2, data3) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(c13388d.m80460i()), c13388d.m80465s(), c13388d.m80464r(), c13388d.m80461k(), c13388d.m80468v(), c13388d.m80456b(), c13388d.m80470x(), Long.valueOf(c13388d.m80466t()), Integer.valueOf(c13388d.m80463q()), Integer.valueOf(c13388d.m80467u()), Long.valueOf(c13388d.m80469w()), Long.valueOf(c13388d.m80462p()), c13388d.m80457e(), c13388d.m80458f(), c13388d.m80459h()});
    }
}
