package p455ll;

import android.database.Cursor;
import fk.C9721b;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: ll.f */
/* loaded from: classes6.dex */
public class C11313f extends AbstractC11478a<C11312e> {
    public C11313f() {
        super(C13216j.m79427l(C13216j.c.METADATA, null));
    }

    /* renamed from: a */
    public void m67973a(String str) throws C9721b {
        delete("t_restore_asset_slice", "path = ?", new String[]{str});
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C11312e c11312e) {
        return new String[]{c11312e.m67962p(), String.valueOf(c11312e.m67955a0()), c11312e.m67964r(), c11312e.m67961k(), String.valueOf(c11312e.m67966t()), String.valueOf(c11312e.m67963q()), String.valueOf(c11312e.m67967u()), String.valueOf(c11312e.m67965s()), String.valueOf(c11312e.m67968v()), c11312e.m67956b(), c11312e.m67957e(), c11312e.m67958f(), c11312e.m67959h(), c11312e.m67960i()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C11312e getObject(Cursor cursor) {
        C11312e c11312e = new C11312e();
        c11312e.m67946C(cursor.getString(0)).m67948E(cursor.getInt(1)).m67949F(cursor.getString(2)).m67945B(cursor.getString(3)).m67951H(Long.valueOf(cursor.getLong(4))).m67947D(cursor.getLong(5)).m67952I(cursor.getInt(6)).m67950G(cursor.getString(7)).m67953J(cursor.getLong(8)).m67969w(cursor.getString(9)).m67970x(cursor.getString(10)).m67971y(cursor.getString(11)).m67972z(cursor.getString(12)).m67944A(cursor.getString(13));
        return c11312e;
    }

    public void clear() {
        try {
            delete("t_restore_asset_slice", null, null);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreV3AssetSliceOperator", "clear error: " + e10.toString());
        }
    }

    /* renamed from: d */
    public C11312e m67976d(String str, String str2) throws C9721b {
        List<C11312e> listQuery = query("select id, number, objectId, hash, start, length, status, path, taskId, data1, data2, data3, data4, data5 from t_restore_asset_slice where objectId = ? and path = ?", new String[]{str, str2});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: e */
    public void m67977e(C11312e c11312e) throws C9721b {
        execSQL("replace into t_restore_asset_slice(id, number, objectId, hash, start, length, status, path, taskId, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);", getColumns(c11312e));
    }
}
