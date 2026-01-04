package p673u9;

import android.database.Cursor;
import android.database.SQLException;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import p704v9.C13386b;

/* renamed from: u9.e */
/* loaded from: classes3.dex */
public class C13140e extends AbstractC13137b<C13386b> {
    /* renamed from: f */
    public void m79033f() {
        try {
            m79017a("delete from t_backup_slice");
        } catch (C9721b e10) {
            C11839m.m70687e("SliceOperator", "clear t_backup_meta error." + e10.getMessage());
        }
    }

    /* renamed from: g */
    public void m79034g(int i10) throws C9721b, SQLException {
        m79018b("delete from t_backup_slice where id = ?;", new Object[]{Integer.valueOf(i10)});
    }

    /* renamed from: h */
    public void m79035h(int i10, String str) throws C9721b, SQLException {
        m79018b("delete from t_backup_slice where id = ? and hash1 = ?;", new Object[]{Integer.valueOf(i10), str});
    }

    @Override // p673u9.AbstractC13137b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C13386b mo79010d(Cursor cursor) {
        C13386b c13386b = new C13386b(cursor.getInt(0));
        c13386b.m80383A(cursor.getString(1));
        c13386b.m80385C(cursor.getInt(2));
        c13386b.m80402v(cursor.getString(3));
        c13386b.m80384B(cursor.getString(4));
        c13386b.m80387E(cursor.getString(5));
        c13386b.m80388F(cursor.getString(6));
        c13386b.m80386D(cursor.getInt(7));
        c13386b.m80403w(cursor.getLong(8));
        c13386b.m80404x(cursor.getString(9));
        c13386b.m80405y(cursor.getString(10));
        c13386b.m80406z(cursor.getString(11));
        return c13386b;
    }

    /* renamed from: j */
    public List<C13386b> m79037j(int i10, String str) throws Throwable {
        List<C13386b> listM79020e = m79020e("select id, hash1, num, bucket, object, synckey, time, status, createTime, data1, data2, data3 from t_backup_slice where id = ? and hash1 = ?;", new String[]{String.valueOf(i10), str});
        return listM79020e == null ? new ArrayList() : listM79020e;
    }

    /* renamed from: k */
    public void m79038k(C13386b c13386b) throws C9721b, SQLException {
        m79018b("replace into t_backup_slice(id, hash1, num, bucket, object, synckey, time, status, createTime, data1, data2, data3) values(?,?,?,?,?,?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(c13386b.m80396p()), c13386b.m80395k(), Integer.valueOf(c13386b.m80398r()), c13386b.m80390b(), c13386b.m80397q(), c13386b.m80400t(), c13386b.m80401u(), Integer.valueOf(c13386b.m80399s()), Long.valueOf(c13386b.m80391e()), c13386b.m80392f(), c13386b.m80393h(), c13386b.m80394i()});
    }
}
