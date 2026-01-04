package p673u9;

import android.database.Cursor;
import android.database.SQLException;
import fk.C9721b;
import java.util.List;
import p514o9.C11839m;
import p704v9.C13387c;

/* renamed from: u9.f */
/* loaded from: classes3.dex */
public class C13141f extends AbstractC13137b<C13387c> {
    /* renamed from: f */
    public void m79039f() {
        try {
            m79017a("delete from t_backup_status");
        } catch (C9721b e10) {
            C11839m.m70687e("StatusOperator", "clear t_backup_status error." + e10.getMessage());
        }
    }

    /* renamed from: g */
    public void m79040g(int i10) throws C9721b, SQLException {
        m79018b("delete from t_backup_status where id = ?;", new Object[]{Integer.valueOf(i10)});
    }

    /* renamed from: h */
    public void m79041h(int i10, String str) throws C9721b, SQLException {
        m79018b("delete from t_backup_status where id = ? and hash1 = ?;", new Object[]{Integer.valueOf(i10), str});
    }

    @Override // p673u9.AbstractC13137b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C13387c mo79010d(Cursor cursor) {
        C13387c c13387c = new C13387c(cursor.getInt(0));
        c13387c.m80439x(cursor.getString(1));
        c13387c.m80440y(cursor.getString(2));
        c13387c.m80408B(cursor.getString(3));
        c13387c.m80409C(cursor.getLong(4));
        c13387c.m80412F(cursor.getInt(5));
        c13387c.m80434s(cursor.getLong(6));
        c13387c.m80414H(cursor.getLong(7));
        c13387c.m80410D(cursor.getInt(8));
        c13387c.m80413G(cursor.getInt(9));
        c13387c.m80415I(cursor.getLong(10));
        c13387c.m80411E(cursor.getInt(11));
        c13387c.m80441z(cursor.getString(12));
        c13387c.m80438w(cursor.getString(13));
        c13387c.m80407A(cursor.getString(14));
        c13387c.m80435t(cursor.getString(15));
        c13387c.m80436u(cursor.getString(16));
        c13387c.m80437v(cursor.getString(17));
        return c13387c;
    }

    /* renamed from: j */
    public C13387c m79043j(int i10, String str) throws Throwable {
        List<C13387c> listM79020e = m79020e("select id, hash1, hash2, path, size, status, createTime, updateTime, slice, type, version, sliceSize, hmac, efek, iv, data1, data2, data3 from t_backup_status where id = ? and hash1 = ?;", new String[]{String.valueOf(i10), str});
        if (listM79020e == null || listM79020e.isEmpty()) {
            return null;
        }
        return listM79020e.get(0);
    }

    /* renamed from: k */
    public void m79044k(C13387c c13387c) throws C9721b, SQLException {
        m79018b("replace into t_backup_status(id, hash1, hash2, path, size, status, createTime, updateTime, slice, type, version, sliceSize, hmac, efek, iv, data1, data2, data3) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(c13387c.m80424i()), c13387c.m80421f(), c13387c.m80422g(), c13387c.m80426k(), Long.valueOf(c13387c.m80427l()), Integer.valueOf(c13387c.m80430o()), Long.valueOf(c13387c.m80416a()), Long.valueOf(c13387c.m80432q()), Integer.valueOf(c13387c.m80428m()), Integer.valueOf(c13387c.m80431p()), Long.valueOf(c13387c.m80433r()), Long.valueOf(c13387c.m80429n()), c13387c.m80423h(), c13387c.m80420e(), c13387c.m80425j(), c13387c.m80417b(), c13387c.m80418c(), c13387c.m80419d()});
    }
}
