package tl;

import android.database.Cursor;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: tl.f */
/* loaded from: classes6.dex */
public class C13027f extends AbstractC11478a<C13028g> {
    public C13027f() {
        super(C13216j.m79427l(C13216j.c.TAG, null));
    }

    /* renamed from: a */
    public void m78403a() {
        try {
            execSQL("update backup_record_infos set lastUploadSpeedFlag = ? where lastUploadSpeedFlag = ?", new String[]{String.valueOf(0), String.valueOf(1)});
        } catch (C9721b e10) {
            C11839m.m70689w("BackupRecordInfoOperator", "clearAllSpeedFlag error." + e10.getMessage());
        }
    }

    /* renamed from: b */
    public void m78404b(long j10) {
        try {
            execSQL("delete from backup_record_infos where lastUploadSpeedFlag = ? and startTime < ?", new String[]{String.valueOf(0), String.valueOf(j10)});
        } catch (C9721b e10) {
            C11839m.m70689w("BackupRecordInfoOperator", "deleteInvalidSpeedFlagBeforeTime error." + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(C13028g c13028g) {
        return new String[]{c13028g.m78413b(), String.valueOf(c13028g.m78421j()), String.valueOf(c13028g.m78419h()), String.valueOf(c13028g.m78414c()), String.valueOf(c13028g.m78423l()), String.valueOf(c13028g.m78422k()), String.valueOf(c13028g.m78415d()), String.valueOf(c13028g.m78420i()), c13028g.m78416e(), c13028g.m78417f(), c13028g.m78418g()};
    }

    public void clear() {
        C11839m.m70688i("BackupRecordInfoOperator", "clear backupinfo.");
        try {
            execSQL("delete from backup_record_infos");
        } catch (C9721b e10) {
            C11839m.m70689w("BackupRecordInfoOperator", "clear error." + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C13028g getObject(Cursor cursor) {
        C13028g c13028g = new C13028g();
        c13028g.m78424m(cursor.getString(0));
        c13028g.m78432u(cursor.getLong(1));
        c13028g.m78430s(cursor.getLong(2));
        c13028g.m78425n(cursor.getInt(3));
        c13028g.m78434w(cursor.getLong(4));
        c13028g.m78433v(cursor.getLong(5));
        c13028g.m78426o(cursor.getInt(6));
        c13028g.m78431t(cursor.getInt(7));
        c13028g.m78427p(cursor.getString(8));
        c13028g.m78428q(cursor.getString(9));
        c13028g.m78429r(cursor.getString(10));
        return c13028g;
    }

    /* renamed from: e */
    public long m78407e(long j10) {
        try {
            Cursor cursorRawQuery = rawQuery("select avg(startTime) from backup_record_infos where backupType = ? and startTime > ?", new String[]{String.valueOf(2), String.valueOf(j10)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j11 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j11;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70689w("BackupRecordInfoOperator", "queryAvgAutoStartTimesByStartTime error." + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: f */
    public C13028g m78408f(String str) {
        try {
            List<C13028g> listQuery = query("select backupId, startTime, endTime, backupStatus, uploadSize, uploadDuration, backupType, lastUploadSpeedFlag, data1, data2, data3 from backup_record_infos where backupId = ? and startTime <= ? order by startTime DESC limit 1", new String[]{str, String.valueOf(System.currentTimeMillis())});
            if (listQuery.size() > 0) {
                return listQuery.get(0);
            }
            return null;
        } catch (C9721b e10) {
            C11839m.m70689w("BackupRecordInfoOperator", "queryLastState error." + e10.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public long m78409g() {
        try {
            Cursor cursorRawQuery = rawQuery("select (uploadSize/uploadDuration) from backup_record_infos where lastUploadSpeedFlag = ? order by startTime limit 1", new String[]{String.valueOf(1)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j10 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70689w("BackupRecordInfoOperator", "queryLastValidSpeed error." + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: h */
    public long m78410h(long j10) {
        try {
            Cursor cursorRawQuery = rawQuery("select sum(endTime-startTime) from backup_record_infos where backupType = ? and startTime > ?", new String[]{String.valueOf(2), String.valueOf(j10)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        long j11 = cursorRawQuery.getLong(0);
                        cursorRawQuery.close();
                        return j11;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } catch (C9721b e10) {
            C11839m.m70689w("BackupRecordInfoOperator", "querySumAutoBackupTimesByStartTime error." + e10.getMessage());
            return 0L;
        }
    }

    /* renamed from: i */
    public void m78411i(C13028g c13028g) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c13028g);
        try {
            batch("replace into backup_record_infos(backupId, startTime, endTime, backupStatus, uploadSize, uploadDuration, backupType, lastUploadSpeedFlag, data1, data2, data3) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupRecordInfoOperator", "replace recordInfos error: " + e10.getMessage());
        }
    }
}
