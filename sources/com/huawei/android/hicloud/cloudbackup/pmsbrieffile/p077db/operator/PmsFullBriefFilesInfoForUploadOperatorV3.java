package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* loaded from: classes2.dex */
public class PmsFullBriefFilesInfoForUploadOperatorV3 extends AbstractC11478a<PmsMetaV3> {
    private static final String TAG = "PmsFullBriefFilesInfoForUploadOperatorV3";
    protected String tableName;

    public PmsFullBriefFilesInfoForUploadOperatorV3(String str) {
        super(C13216j.m79427l(C13216j.c.PMSBRIEF, str));
        this.tableName = initTableName();
    }

    public String formatSql(String str) {
        return String.format(Locale.ENGLISH, str, this.tableName);
    }

    public String initTableName() {
        return PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3;
    }

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
            C11839m.m70689w(TAG, "check table exists error." + e10.toString());
        }
        return false;
    }

    public List<PmsMetaV3> queryByLimitOffsetForUploadMetas(int i10, int i11, long j10, long j11) throws C9721b {
        return query(formatSql(PmsMetaDBScript.QUERY_BY_LIMIT_OFFSET_FOR_UPLOADMETAS), new String[]{String.valueOf(1), String.valueOf(-3), String.valueOf(-2), String.valueOf(0), "1", "2", String.valueOf(0), String.valueOf(j10), String.valueOf(j11), String.valueOf(i10), String.valueOf(i11)});
    }

    public int queryCountForUploadMetas(long j10, long j11) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_COUNT_FOR_UPLOADMETAS), new String[]{String.valueOf(1), String.valueOf(-3), String.valueOf(-2), String.valueOf(0), "1", "2", String.valueOf(0), String.valueOf(j10), String.valueOf(j11)});
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
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryCountForUploadMetas error.", "queryCount");
    }

    public List<PmsMetaV3> queryMetaByFileId(String str) throws C9721b {
        return query(formatSql(PmsMetaDBScript.QUERY_META_BY_FILEID), new String[]{str});
    }

    public List<PmsMetaV3> queryMetaByFileIdByLimit(String str, long j10, long j11) throws C9721b {
        return query(formatSql(PmsMetaDBScript.QUERY_META_BY_FILEID_BY_LIMIT), new String[]{str, String.valueOf(j10), String.valueOf(j11)});
    }

    public long queryMetaByFileIdCount(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_META_BY_FILEID_COUNT), new String[]{str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getInt(0);
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
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryCountForUploadMetas error.", "queryCount");
    }

    public PmsMetaV3 queryMetaByFilePath(String str) throws C9721b {
        List<PmsMetaV3> listQuery = query(formatSql(PmsMetaDBScript.QUERY_META_BY_FILEPATH), new String[]{str});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    public long queryMetaSumsizeByFileId(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_META_SUMSIZE_BY_FILEID), new String[]{str});
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
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryMetaSumsizeByFileId( error.", "sumSize");
    }

    public List<PmsMetaV3> queryTarWaitDeleteMetaByLimit(long j10) throws C9721b {
        return query(formatSql(PmsMetaDBScript.QUERY_TAR_WAIT_DELETE_META_BY_LIMIT), new String[]{String.valueOf(7), "1", String.valueOf(3), String.valueOf(-3), String.valueOf(j10)});
    }

    public long queryZeroMetaCountByFileId(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_ZERO_META_COUNT_BY_FILEID), new String[]{str});
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
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryZeroMetaCountByFileId error.", "queryCount");
    }

    public void updateAttrByPaths(List<PmsMetaV3> list) throws C9721b {
        execute(formatSql(PmsMetaDBScript.UPDATE_TYPE_DIR_BY_FILEPATH), new ArrayList());
    }

    public void updateDeleteFlagByFilePath(String str) throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_DATA1_BY_FILE_PATH), new String[]{"1", str});
    }

    public void updateFileInfoByFilePath(String str, PmsMetaV3 pmsMetaV3) throws C9721b {
        String filePath = pmsMetaV3.getFilePath();
        String cloudHash = pmsMetaV3.getCloudHash();
        execSQL(formatSql(PmsMetaDBScript.UPDATE_FILE_ID_BY_FILE_PATH), new String[]{str, pmsMetaV3.getHash1(), pmsMetaV3.getHash2(), cloudHash, filePath});
    }

    public void updateHashAndUploadInfoByFilePath(PmsMetaV3 pmsMetaV3) throws C9721b {
        if (pmsMetaV3.getFlag() == 0) {
            execSQL(formatSql(PmsMetaDBScript.UPDATE_HASH_AND_UPLOADINFO_V2_BY_FILEPATH), new String[]{String.valueOf(pmsMetaV3.getHash1()), String.valueOf(pmsMetaV3.getHash2()), String.valueOf(pmsMetaV3.getCloudHash()), String.valueOf(pmsMetaV3.getCloudPath()), String.valueOf(pmsMetaV3.getType()), String.valueOf(pmsMetaV3.getFlag()), String.valueOf(pmsMetaV3.getStatus()), String.valueOf(pmsMetaV3.getFilePath())});
        } else {
            execSQL(formatSql(PmsMetaDBScript.UPDATE_HASH_AND_UPLOADINFO_V3_BY_FILEPATH), new String[]{String.valueOf(pmsMetaV3.getHash1()), String.valueOf(pmsMetaV3.getHash2()), String.valueOf(pmsMetaV3.getCloudHash()), String.valueOf(pmsMetaV3.getFileId()), String.valueOf(pmsMetaV3.getAssertId()), String.valueOf(pmsMetaV3.getVersionId()), String.valueOf(pmsMetaV3.getType()), String.valueOf(pmsMetaV3.getFlag()), String.valueOf(pmsMetaV3.getStatus()), pmsMetaV3.getData4(), String.valueOf(pmsMetaV3.getFilePath())});
        }
    }

    public void updateHashByFilePath(String str, String str2, String str3, String str4) throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_HASH_BY_FILE_PATH), new String[]{str2, str3, str4, str});
    }

    public void updateInfoByFileId(String str, String str2, String str3, String str4, long j10, int i10, long j11) throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_UPLOAD_INFO_BY_FILE_ID), new String[]{String.valueOf(i10), String.valueOf(7), str2, str3, str4, String.valueOf(1), String.valueOf(j10), String.valueOf(j11), str});
    }

    public void updateInfoByFilePath(String str, String str2, String str3, String str4, long j10, int i10) throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_UPLOAD_INFO_BY_FILE_PATH), new String[]{String.valueOf(i10), str2, str3, str4, String.valueOf(1), String.valueOf(j10), str});
    }

    public void updateIsValidByFilePath(int i10, int i11, String str) throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_ISVALID_BY_FILEPATH), new String[]{String.valueOf(i10), String.valueOf(i11), str});
    }

    public void updateLastExistMidStatus() throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_UPLOAD_MID_STATUS), new String[]{String.valueOf(2), String.valueOf(-2)});
    }

    public void updateNotExistFileUUIDByIsValid() throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_NOT_EXIST_FILE_UUID), new String[]{"", "1", String.valueOf(2)});
    }

    public void updateStatusByFilePath(String str, int i10) throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_STATUS_AND_ISVALID_BY_FILEPATH), new String[]{String.valueOf(i10), str});
    }

    public void updateUploadMidStatus() throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_UPLOAD_MID_STATUS), new String[]{String.valueOf(3), String.valueOf(-3)});
    }

    @Override // ml.AbstractC11478a
    public String[] getColumns(PmsMetaV3 pmsMetaV3) {
        return pmsMetaV3.getColumns();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // ml.AbstractC11478a
    public PmsMetaV3 getObject(Cursor cursor) {
        return PmsMetaV3.getObject(cursor);
    }
}
