package p455ll;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import fk.C9721b;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;

/* renamed from: ll.b */
/* loaded from: classes6.dex */
public class C11309b extends AbstractC11478a<C11308a> {
    public C11309b(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a */
    public void m67909a(String str) throws C9721b {
        delete("t_asset_status", "id = ?", new String[]{str});
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C11308a c11308a) {
        return new String[]{c11308a.m67892j(), String.valueOf(c11308a.m67894l()), c11308a.m67889g(), c11308a.m67890h(), c11308a.m67891i(), String.valueOf(c11308a.m67897o()), c11308a.m67893k(), c11308a.m67895m(), c11308a.m67883a(), c11308a.m67898p(), String.valueOf(c11308a.m67896n()), c11308a.m67884b(), c11308a.m67885c(), c11308a.m67886d(), c11308a.m67887e(), c11308a.m67888f()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C11308a getObject(Cursor cursor) {
        C11308a c11308a = new C11308a();
        c11308a.m67908z(cursor.getString(0)).m67878B(cursor.getLong(1)).m67905w(cursor.getString(2)).m67906x(cursor.getString(3)).m67907y(cursor.getString(4)).m67881E(cursor.getInt(5)).m67877A(cursor.getString(6)).m67879C(cursor.getString(7)).m67899q(cursor.getString(8)).m67882F(cursor.getString(9)).m67880D(Long.valueOf(cursor.getLong(10))).m67900r(cursor.getString(11)).m67901s(cursor.getString(12)).m67902t(cursor.getString(13)).m67903u(cursor.getString(14)).m67904v(cursor.getString(15));
        return c11308a;
    }

    public void clear() {
        try {
            delete("t_asset_status", null, null);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3AssetOperator", "clear asset status error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public C11308a m67912d(String str) throws C9721b {
        List<C11308a> listQuery = query("select id, length, hash1, hash2, hmac, status, kindId, recordId, assetId, versionId, sliceSize, data1, data2, data3, data4, data5 from t_asset_status where id = ?;", new String[]{str});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: e */
    public List<C11308a> m67913e(String str) throws C9721b {
        return query("select id, length, hash1, hash2, hmac, status, kindId, recordId, assetId, versionId, sliceSize, data1, data2, data3, data4, data5 from t_asset_status where recordId = ?;", new String[]{str});
    }

    /* renamed from: f */
    public void m67914f(C11308a c11308a) throws C9721b {
        execSQL("replace into t_asset_status(id, length, hash1, hash2, hmac, status, kindId, recordId, assetId, versionId, sliceSize, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", getColumns(c11308a));
    }

    public void update(String str, int i10) throws C9721b {
        execSQL("update t_asset_status set status = ? where id = ?;", new String[]{String.valueOf(i10), str});
    }
}
