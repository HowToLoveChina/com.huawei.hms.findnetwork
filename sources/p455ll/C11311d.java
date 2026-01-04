package p455ll;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import fk.C9721b;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;

/* renamed from: ll.d */
/* loaded from: classes6.dex */
public class C11311d extends AbstractC11478a<C11310c> {
    public C11311d(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a */
    public void m67938a(List<C11310c> list) throws C9721b {
        batch("replace into t_asset_slice(id, number, objectId, start, length, status, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    /* renamed from: b */
    public void m67939b(String str) throws C9721b {
        delete("t_asset_slice", "id = ?", new String[]{str});
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C11310c c11310c) {
        return new String[]{c11310c.m67926k(), String.valueOf(c11310c.m67920a0()), c11310c.m67928q(), String.valueOf(c11310c.m67929r()), String.valueOf(c11310c.m67927p()), String.valueOf(c11310c.m67930s()), c11310c.m67921b(), c11310c.m67922e(), c11310c.m67923f(), c11310c.m67924h(), c11310c.m67925i()};
    }

    public void clear() {
        try {
            delete("t_asset_slice", null, null);
        } catch (C9721b e10) {
            C11839m.m70686d("CloudBackupV3AssetSliceOperator", e10.toString());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C11310c getObject(Cursor cursor) {
        C11310c c11310c = new C11310c();
        c11310c.m67936y(cursor.getString(0)).m67915A(cursor.getInt(1)).m67916B(cursor.getString(2)).m67917C(cursor.getLong(3)).m67937z(cursor.getLong(4)).m67918D(cursor.getInt(5)).m67931t(cursor.getString(6)).m67932u(cursor.getString(7)).m67933v(cursor.getString(8)).m67934w(cursor.getString(9)).m67935x(cursor.getString(10));
        return c11310c;
    }

    /* renamed from: e */
    public List<C11310c> m67942e(String str) throws C9721b {
        return query("select id, number, objectId, start, length, status, data1, data2, data3, data4, data5 from t_asset_slice where id = ?;", new String[]{str});
    }

    /* renamed from: f */
    public void m67943f(String str, String str2, int i10) throws C9721b {
        execSQL("update t_asset_slice set status = ? where id = ? and objectId = ?;", new String[]{String.valueOf(i10), str, str2});
    }
}
