package p673u9;

import android.database.Cursor;
import android.database.SQLException;
import fk.C9721b;
import java.util.List;
import p514o9.C11839m;
import p704v9.C13385a;

/* renamed from: u9.a */
/* loaded from: classes3.dex */
public class C13136a extends AbstractC13137b<C13385a> {
    /* renamed from: f */
    public void m79011f() {
        try {
            m79017a("delete from t_backup_meta");
        } catch (C9721b e10) {
            C11839m.m70687e("MetaOperator", "clear t_backup_meta error." + e10.getMessage());
        }
    }

    /* renamed from: g */
    public void m79012g(int i10) throws C9721b, SQLException {
        m79018b("delete from t_backup_meta where id = ?;", new Object[]{Integer.valueOf(i10)});
    }

    /* renamed from: h */
    public void m79013h(int i10, String str) throws C9721b, SQLException {
        m79018b("delete from t_backup_meta where id = ? and hash1 = ?;", new Object[]{Integer.valueOf(i10), str});
    }

    @Override // p673u9.AbstractC13137b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C13385a mo79010d(Cursor cursor) {
        C13385a c13385a = new C13385a(cursor.getInt(0));
        c13385a.m80379n(cursor.getString(1));
        c13385a.m80380o(cursor.getString(2));
        c13385a.m80381p(cursor.getString(3));
        c13385a.m80382q(cursor.getString(4));
        c13385a.m80375j(cursor.getLong(5));
        c13385a.m80376k(cursor.getString(6));
        c13385a.m80377l(cursor.getString(7));
        c13385a.m80378m(cursor.getString(8));
        return c13385a;
    }

    /* renamed from: j */
    public C13385a m79015j(int i10, String str) throws Throwable {
        List<C13385a> listM79020e = m79020e("select id, hash1, path, sig, ts, createTime, data1, data2, data3 from t_backup_meta where id = ? and hash1 = ?;", new String[]{String.valueOf(i10), str});
        if (listM79020e != null && !listM79020e.isEmpty()) {
            return listM79020e.get(0);
        }
        throw new C9721b(4007, "query upload result error." + str, "query");
    }

    /* renamed from: k */
    public void m79016k(C13385a c13385a) throws C9721b, SQLException {
        m79018b("replace into t_backup_meta(id, hash1, path, sig, ts, createTime, data1, data2, data3) values(?,?,?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(c13385a.m80371f()), c13385a.m80370e(), c13385a.m80372g(), c13385a.m80373h(), c13385a.m80374i(), Long.valueOf(c13385a.m80366a()), c13385a.m80367b(), c13385a.m80368c(), c13385a.m80369d()});
    }
}
