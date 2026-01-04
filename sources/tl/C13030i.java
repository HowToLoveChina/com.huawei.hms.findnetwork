package tl;

import android.content.ContentValues;
import android.database.Cursor;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p572qb.C12299b;
import p682ul.C13216j;

/* renamed from: tl.i */
/* loaded from: classes6.dex */
public class C13030i extends AbstractC11478a<C13029h> {
    public C13030i() {
        super(C13216j.m79427l(C13216j.c.TAG, null));
    }

    /* renamed from: a */
    public void m78490a(int i10) {
        String[] strArr = {String.valueOf(i10)};
        try {
            C11839m.m70688i("BackupTagsOperator", "deleteTag begin,tag is:" + i10);
            execSQL("delete from backup_tags where tag = ?;", strArr);
            if (i10 == 1 || i10 == 2) {
                m78498i();
            }
        } catch (C9721b e10) {
            C11839m.m70689w("BackupTagsOperator", "replace backup_tags error." + e10.getMessage());
        }
    }

    /* renamed from: b */
    public void m78491b(int i10, String str) {
        try {
            execSQL("delete from backup_tags where tag = ? and backupId = ?;", new String[]{String.valueOf(i10), str});
        } catch (C9721b e10) {
            C11839m.m70689w("BackupTagsOperator", "replace backup_tags error." + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C13029h c13029h) {
        return new String[]{String.valueOf(c13029h.m78442H()), c13029h.m78436B(), String.valueOf(c13029h.m78441G()), String.valueOf(c13029h.m78435A()), c13029h.m78488y(), String.valueOf(c13029h.m78489z()), c13029h.m78465h(), c13029h.m78444J(), String.valueOf(c13029h.m78476r()), c13029h.m78474q(), String.valueOf(c13029h.m78439E()), String.valueOf(c13029h.m78445K()), String.valueOf(c13029h.m78443I()), String.valueOf(c13029h.m78440F()), String.valueOf(c13029h.m78464f()), String.valueOf(c13029h.m78469k()), c13029h.m78463e(), c13029h.m78472p(), String.valueOf(c13029h.m78437C()), String.valueOf(c13029h.m78438D()), c13029h.m78478s(), c13029h.m78480t(), c13029h.m78482u(), String.valueOf(c13029h.m78466i()), c13029h.m78484v(), c13029h.m78486w(), c13029h.m78487x()};
    }

    public void clear() {
        try {
            execSQL("delete from backup_tags;");
            m78498i();
        } catch (C9721b e10) {
            C11839m.m70689w("BackupTagsOperator", "clear backup_tags error." + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C13029h getObject(Cursor cursor) {
        C13029h c13029h = new C13029h(cursor.getInt(0), cursor.getString(1));
        c13029h.m78477r0(cursor.getInt(2));
        c13029h.m78468j0(cursor.getInt(3));
        c13029h.m78460Z(cursor.getString(4));
        c13029h.m78467i0(cursor.getInt(5));
        c13029h.m78448N(cursor.getString(6));
        c13029h.m78483u0(cursor.getString(7));
        c13029h.m78453S(cursor.getInt(8));
        c13029h.m78452R(cursor.getString(9));
        c13029h.m78473p0(cursor.getLong(10));
        c13029h.m78485v0(cursor.getLong(11));
        c13029h.m78481t0(cursor.getLong(12));
        c13029h.m78475q0(cursor.getLong(13));
        c13029h.m78447M(cursor.getLong(14));
        c13029h.m78450P(cursor.getLong(15));
        c13029h.m78446L(cursor.getString(16));
        c13029h.m78451Q(cursor.getString(17));
        c13029h.m78470m0(cursor.getInt(18));
        c13029h.m78471n0(cursor.getLong(19));
        c13029h.m78454T(cursor.getString(20));
        c13029h.m78455U(cursor.getString(21));
        c13029h.m78456V(cursor.getString(22));
        c13029h.m78449O(cursor.getLong(23));
        c13029h.m78457W(cursor.getString(24));
        c13029h.m78458X(cursor.getString(25));
        c13029h.m78459Y(cursor.getString(26));
        return c13029h;
    }

    /* renamed from: e */
    public List<C13029h> m78494e() {
        try {
            return query("select tag, id, status, dot, deviceId, deviceType, backupId, traceId, count, code, size, used, total, startTime, endTime, beginTime, appId, businessId, isNextShow, localNeedSpace, data1, data2, data3,backupStartTime, data4, data5, data6 from backup_tags", null);
        } catch (C9721b e10) {
            C11839m.m70689w("BackupTagsOperator", "query backup_tags error." + e10.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    public C13029h m78495f(int i10) throws C9721b {
        List<C13029h> listQuery = query("select tag, id, status, dot, deviceId, deviceType, backupId, traceId, count, code, size, used, total, startTime, endTime, beginTime, appId, businessId, isNextShow, localNeedSpace, data1, data2, data3, backupStartTime, data4, data5, data6 from backup_tags where tag = ?", new String[]{String.valueOf(i10)});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: g */
    public void m78496g(C13029h c13029h) {
        try {
            m78497h(c13029h);
        } catch (C9721b e10) {
            C11839m.m70689w("BackupTagsOperator", "replace backup_tags error." + e10.getMessage());
        }
    }

    /* renamed from: h */
    public void m78497h(C13029h c13029h) throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c13029h);
        batch("replace into backup_tags(tag, id, status, dot, deviceId, deviceType, backupId, traceId, count, code, size, used, total, startTime, endTime, beginTime, appId, businessId, isNextShow, localNeedSpace, data1, data2, data3, backupStartTime, data4, data5, data6) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", arrayList);
    }

    /* renamed from: i */
    public final void m78498i() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("backup_end_code", "");
        C12299b.m73929k(contentValues, "backupEndCodePath");
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("backupFailedErrorCode", "");
        C12299b.m73929k(contentValues2, "backupFailedErrorCode");
    }

    /* renamed from: j */
    public void m78499j(int i10, String str, int i11) {
        try {
            execSQL("update backup_tags set isNextShow = ? where tag = ? and id = ?;", new String[]{String.valueOf(i11), String.valueOf(i10), str});
        } catch (C9721b e10) {
            C11839m.m70689w("BackupTagsOperator", "update backup_tags error." + e10.getMessage());
        }
    }

    public void transfer() {
        try {
            Cursor cursorRawQuery = rawQuery("select count(*) from last.sqlite_master where type = 'table' and name = 'backup_tags'", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst() && cursorRawQuery.getInt(0) > 0) {
                        List<C13029h> listQuery = query("select tag, id, status, dot, deviceId, deviceType, backupId, traceId, count, code, size, used, total, startTime, endTime, beginTime, appId, businessId, isNextShow, localNeedSpace, data1, data2, data3, backupStartTime, data4, data5, data6 from last.backup_tags", null);
                        if (listQuery.isEmpty()) {
                            cursorRawQuery.close();
                            return;
                        }
                        C11839m.m70686d("BackupTagsOperator", "onDatabaseTagUpgrade data migration start.");
                        for (C13029h c13029h : listQuery) {
                            if (3 == c13029h.m78442H() && c13029h.m78441G() != 4) {
                                c13029h.m78456V("db_updata");
                                try {
                                    execSQL("replace into app_restore_status select appId, appName, appType, action, status, type, current, count, size, aid, versionName, versionCode, asize, version, flag, apath, aurl, iconPath, iconUrl, iconId, iconLocal, launchFlag, data1, data2, data3, data4, data5 from last.app_restore_status");
                                } catch (C9721b e10) {
                                    C11839m.m70689w("BackupTagsOperator", "transfer app restore status error." + e10.toString());
                                }
                            }
                            m78496g(c13029h);
                        }
                        C11839m.m70686d("BackupTagsOperator", "onDatabaseTagUpgrade data migration end.");
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e11) {
            C11839m.m70689w("BackupTagsOperator", "check old db tag exists error." + e11.toString());
        }
    }
}
