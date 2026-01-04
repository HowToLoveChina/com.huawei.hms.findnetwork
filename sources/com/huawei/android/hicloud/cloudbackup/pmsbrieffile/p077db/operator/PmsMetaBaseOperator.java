package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* loaded from: classes2.dex */
public abstract class PmsMetaBaseOperator extends AbstractC11478a<PmsMeta> {
    private static final String TAG = "PmsMetaBaseOperator";
    protected String tableName;

    public PmsMetaBaseOperator(String str) {
        super(C13216j.m79427l(C13216j.c.PMSBRIEF, str));
        this.tableName = initTableName();
    }

    public void batchReplace(List<PmsMeta> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PmsMeta> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getColumns(it.next()));
        }
        execute(formatSql(PmsMetaDBScript.REPLACE_PMS_META), arrayList);
    }

    public void clear() throws C9721b {
        execSQL(formatSql("delete from %s"));
    }

    public void drop() throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.DROP_TABLE_BY_NAME));
    }

    public String formatSql(String str) {
        return String.format(Locale.ENGLISH, str, this.tableName);
    }

    public PmsMeta getPmsMetaObj() {
        return new PmsMeta();
    }

    public String getTableName() {
        return this.tableName;
    }

    public abstract String initTableName();

    public boolean isExistTable() {
        try {
            Cursor cursorRawQuery = rawQuery(PmsMetaDBScript.CHECK_TEMP_TABLE_EXIST, new String[]{this.tableName});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery.getInt(0) > 0) {
                            cursorRawQuery.close();
                            return true;
                        }
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "check old db tag exists error." + e10.toString());
        }
        return false;
    }

    public List<PmsMeta> queryBylimit(long j10, long j11) throws C9721b {
        return query(formatSql(PmsMetaDBScript.QUERY_META_BY_LIMIT_OFFSET), new String[]{String.valueOf(j10), String.valueOf(j11)});
    }

    public int queryCount() throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_COUNT_ALL), null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i10 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i10;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryCounterror.", "queryCount");
    }

    public int queryCountByIsvalid(int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_COUNT_BY_ISVALID), new String[]{String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i11 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i11;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryCountByIsvalid error.", "queryCount");
    }

    public int queryCountByStatus(int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_COUNT_BY_STATUS), new String[]{String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i11 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i11;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryCountByStatus error.", "queryCount");
    }

    public int queryCountByStatusAndIsvalid(int i10, int i11) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_COUNT_BY_STATUS_ISVALID), new String[]{String.valueOf(i10), String.valueOf(i11)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i12 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i12;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryCountByStatusAndIsvalid error.", "queryCount");
    }

    public int queryCountByType(int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_COUNT_BY_ISDIR_TYPE), new String[]{String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    int i11 = cursorRawQuery.getInt(0);
                    cursorRawQuery.close();
                    return i11;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryCountByIsvalid error.", "queryCount");
    }

    public List<PmsMeta> queryMaxSize() throws C9721b {
        return query(formatSql(PmsMetaDBScript.PMS_MAX_SIZE), new String[]{String.valueOf(0)});
    }

    public List<PmsMeta> queryMetasByIsvalid(int i10) throws C9721b {
        return query(formatSql(PmsMetaDBScript.QUERY_META_BY_ISVALID), new String[]{String.valueOf(i10)});
    }

    public long querySum() throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.PMS_SUM_SIZE), null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "querySumerror.", "querySum");
    }

    public long querySumToCopySize() {
        try {
            Cursor cursorRawQuery = rawQuery(formatSql("select sum(size) from %s where status = ? and isdir = 0;"), new String[]{String.valueOf(0)});
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
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "querySumToCopySize error: " + e10.getMessage());
            return 0L;
        }
    }

    public void renameToTemp() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.RENAME_TABLE_TO_TEMP, this.tableName, this.tableName + PmsMetaDBScript.TEMP_SUFFIX));
    }

    public PmsMetaBaseOperator temp() {
        this.tableName += PmsMetaDBScript.TEMP_SUFFIX;
        return this;
    }

    @Override // ml.AbstractC11478a
    public String[] getColumns(PmsMeta pmsMeta) {
        return pmsMeta.getColumns();
    }

    @Override // ml.AbstractC11478a
    public PmsMeta getObject(Cursor cursor) {
        return PmsMeta.getObject(cursor);
    }
}
