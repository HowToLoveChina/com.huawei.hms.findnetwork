package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: t6.c */
/* loaded from: classes2.dex */
public class C12943c extends AbstractC12949i<String> {
    /* renamed from: i */
    public void m77758i() throws SQLException {
        m77847a("DELETE FROM albumV2Cache ", null);
    }

    /* renamed from: j */
    public void m77759j(String str) throws SQLException {
        m77847a("DELETE FROM albumV2Cache WHERE id = ? ", new String[]{str});
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
    public void m77762m(String str, String str2, String str3, String str4) throws SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            return;
        }
        m77847a("INSERT OR IGNORE INTO albumV2Cache(id,albumName,albumVersion,flversion) VALUES(?,?,?,?)", new String[]{str, str2, str3, str4});
    }

    /* renamed from: n */
    public String m77763n(String str) throws Throwable {
        ArrayList<String> arrayListM77851g = m77851g("SELECT albumVersion FROM albumV2Cache WHERE id = ?", new String[]{str});
        String next = null;
        if (arrayListM77851g != null) {
            Iterator<String> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                next = it.next();
            }
        }
        return next;
    }

    /* renamed from: o */
    public String m77764o(String str) throws Throwable {
        ArrayList<String> arrayListM77851g = m77851g("SELECT flversion FROM albumV2Cache WHERE id = ?", new String[]{str});
        String next = null;
        if (arrayListM77851g != null) {
            Iterator<String> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                next = it.next();
            }
        }
        return next;
    }

    /* renamed from: p */
    public void m77765p(String str, String str2, String str3, String str4) throws SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            return;
        }
        m77847a("UPDATE albumV2Cache SET albumName = ? , albumVersion = ? , flversion = ? WHERE id = ?", new String[]{str2, str3, str4, str});
    }
}
