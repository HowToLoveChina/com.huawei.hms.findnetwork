package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: t6.b */
/* loaded from: classes2.dex */
public class C12942b extends AbstractC12949i<String> {
    /* renamed from: i */
    public void m77752i() throws SQLException {
        m77847a("DELETE FROM albumV2Cursor ", null);
    }

    /* renamed from: j */
    public void m77753j(String str) throws SQLException {
        m77847a("DELETE FROM albumV2Cursor WHERE id = ? ", new String[]{str});
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public String mo77732c(Cursor cursor) {
        return cursor.getString(0);
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String mo77733d(Cursor cursor) {
        return null;
    }

    /* renamed from: m */
    public void m77756m(String str, long j10, String str2) throws SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        m77847a("INSERT OR IGNORE INTO albumV2Cursor(id,offset,nextCursor) VALUES(?,?,?)", new String[]{str, String.valueOf(j10), str2});
    }

    /* renamed from: n */
    public String m77757n(String str, long j10) throws Throwable {
        ArrayList<String> arrayListM77851g = m77851g("SELECT nextCursor FROM albumV2Cursor WHERE id = ? AND offset = ? ", new String[]{str, String.valueOf(j10)});
        String next = null;
        if (arrayListM77851g != null) {
            Iterator<String> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                next = it.next();
            }
        }
        return next;
    }
}
