package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.TarRefRatioDBScript;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p744wl.C13617a;

/* loaded from: classes2.dex */
public class PmsFullBriefFilesInfoOperatorV3 extends PmsMetaBaseOperatorV3 {
    private static final String CLEAR_PMS_TAR_REFRATIO = "update %1$s set data5 = '';";
    private static final String QUERY_TAR_REFRATIO_BY_FILEID = "select tar_ref_ratio from %1$s where file_id = ?;";
    private static final String QUERY_TAR_REFRATIO_BY_LIMIT = "select tar_ref_ratio from %1$s limit ?;";
    private static final String RESET_META_BACKUP_STATUS = "UPDATE %1$s SET status = ?,          cloud_path = '',file_id = '', assert_id = '', version_id = '', flag = ?, type = ?, hash1 = '', hash2 = '', cloud_hash = '' WHERE status in(?,?)         AND type = ?         AND EXISTS      (SELECT tar_ref_ratio     FROM %2$s     WHERE ((%2$s.tar_ref_ratio < ?             AND is_new_tar = ?)             OR (%2$s.tar_ref_ratio < ?             AND is_new_tar = ?))             AND %1$s.file_id||cloud_path = %2$s.file_id);";
    private static final String TAG = "PmsFullBriefFilesInfoOperatorV3";
    private static final String UPDATESTATU_SNAPSHOT_SQL_BY_LOST = "UPDATE full_brief_files_info_v3 SET status = ?, cloud_path = '', file_id = '', assert_id = '', version_id = '', flag = ?, type = ?, hash1 = '', hash2 = '', cloud_hash = '' , data2 = '' WHERE isdir = 0    AND status = ?    AND ((file_id != ''          AND file_id IS NOT NULL          AND file_id = (             SELECT last.t_backup_lost_file_meta.file_id             FROM last.t_backup_lost_file_meta             WHERE last.t_backup_lost_file_meta.app_id = ?                AND full_brief_files_info_v3.file_id = last.t_backup_lost_file_meta.file_id          ))       OR (cloud_path != ''          AND cloud_path IS NOT NULL          AND cloud_path = (             SELECT last.t_backup_lost_file_meta.cloud_path             FROM last.t_backup_lost_file_meta             WHERE last.t_backup_lost_file_meta.app_id = ?                AND full_brief_files_info_v3.cloud_path = last.t_backup_lost_file_meta.cloud_path          )));";
    private static final String UPDATE_TAR_REF_TO_SNAPSHOT = "update %1$s set data5 = (select tar_ref_ratio from %2$s where %1$s.file_id||cloud_path = %2$s.file_id) where exists (select tar_ref_ratio from %2$s where %1$s.file_id||cloud_path = %2$s.file_id);";

    public PmsFullBriefFilesInfoOperatorV3(String str) {
        super(str);
    }

    private void clearPmsTarRefRatio() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, CLEAR_PMS_TAR_REFRATIO, this.tableName));
    }

    private void replaceIntoTarRefTable() throws C9721b {
        String[] strArr = {String.valueOf(1), String.valueOf(0), String.valueOf(7), String.valueOf(2), String.valueOf(-2)};
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, TarRefRatioDBScript.REPLACE_INTO_TAR_REF_SUM_SIZE_FROM_FULLDB, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE, this.tableName), strArr);
        execSQL(String.format(locale, TarRefRatioDBScript.REPLACE_INTO_TAR_REF_ZERO_FILE_COUNT_FROM_FULLDB, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE, this.tableName), strArr);
        execSQL(String.format(locale, TarRefRatioDBScript.UPDATA_ORIGIN_SIZE_FLAG_BY_ORIGIN_SIZE, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(RuleConfig.DEFAULT_TAR_SIZE), String.valueOf(0)});
    }

    private void resetMetaBackupStatus(double d10, double d11) throws C9721b {
        C11839m.m70688i(TAG, "resetMetaBackupStatus start");
        execSQL(String.format(Locale.ENGLISH, RESET_META_BACKUP_STATUS, this.tableName, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(0), String.valueOf(0), String.valueOf(7), String.valueOf(2), String.valueOf(-2), String.valueOf(7), String.valueOf(d10), String.valueOf(0), String.valueOf(d11), String.valueOf(1)});
    }

    private void tarRateCaclExecute() throws C9721b {
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, TarRefRatioDBScript.CACL_TAR_RATIO_AND_MARK, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(1)});
        execSQL(String.format(locale, TarRefRatioDBScript.DELETE_NOT_CACL_END_ROW, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(0)});
    }

    private void updateTarRefToPmsDb() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, UPDATE_TAR_REF_TO_SNAPSHOT, this.tableName, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE));
    }

    public void caclTarRefrenceRote(double d10, double d11) throws C9721b {
        dropCaclTarRefRatioTable();
        createCaclTarRefRatioTable();
        replaceIntoTarRefTable();
        tarRateCaclExecute();
        clearPmsTarRefRatio();
        updateTarRefToPmsDb();
        resetMetaBackupStatus(d10, d11);
    }

    public void createTable() throws C9721b {
        execSQL(PmsMetaDBScript.CREATE_FULL_BRIEF_FILES_INFO_V3_SQL);
        execSQL(PmsMetaDBScript.CREATE_INDEX_FULL_BRIEF_FILES_V3_SQL);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator
    public String initTableName() {
        return PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3;
    }

    public void pmsMetaToSnapshot(String str, String str2) throws C9721b {
        Locale locale = Locale.ENGLISH;
        String str3 = String.format(locale, PmsMetaDBScript.PMS_META_V3_TO_V3_SNAPSHOT_BY_STATUS_DEFAULT, SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, this.tableName);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ICBUtil.RELATIVE_SDATA_PATH);
        String str4 = File.separator;
        sb2.append(str4);
        execSQL(str3, new String[]{sb2.toString(), str, str2, String.valueOf(System.currentTimeMillis())});
        execSQL(String.format(locale, PmsMetaDBScript.PMS_META_V3_TO_V3_SNAPSHOT_BY_STATUS_MKFILE, SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, this.tableName), new String[]{ICBUtil.RELATIVE_SDATA_PATH + str4, str, str2, String.valueOf(System.currentTimeMillis())});
        execSQL(String.format(locale, PmsMetaDBScript.PMS_META_V3_TO_V3_SNAPSHOT_BY_STATUS_UPLOAD, SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, this.tableName), new String[]{ICBUtil.RELATIVE_SDATA_PATH + str4, str, str2, String.valueOf(System.currentTimeMillis())});
    }

    public long queryBackupTotalSize() throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_BACKUP_TOTAL_SIZE_BY_STATUS), null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<java.lang.Integer, java.lang.Integer> queryCopiedFilesIndex() throws fk.C9721b {
        /*
            r5 = this;
            r0 = 1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String[] r0 = new java.lang.String[]{r0}
            java.lang.String r1 = "select id from %s where status = ? and isdir = 0 order by id asc limit 1;"
            java.lang.String r1 = r5.formatSql(r1)
            android.database.Cursor r1 = r5.rawQuery(r1, r0)
            r2 = -1
            r3 = 0
            if (r1 == 0) goto L2c
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L22
            if (r4 == 0) goto L2c
            int r4 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L22
            goto L2d
        L22:
            r5 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L27
            goto L2b
        L27:
            r0 = move-exception
            r5.addSuppressed(r0)
        L2b:
            throw r5
        L2c:
            r4 = r2
        L2d:
            if (r1 == 0) goto L32
            r1.close()
        L32:
            java.lang.String r1 = "select id from %s where status = ? and isdir = 0 order by id desc limit 1;"
            java.lang.String r1 = r5.formatSql(r1)
            android.database.Cursor r5 = r5.rawQuery(r1, r0)
            if (r5 == 0) goto L53
            boolean r0 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L53
            int r2 = r5.getInt(r3)     // Catch: java.lang.Throwable -> L49
            goto L53
        L49:
            r0 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L4e
            goto L52
        L4e:
            r5 = move-exception
            r0.addSuppressed(r5)
        L52:
            throw r0
        L53:
            if (r5 == 0) goto L58
            r5.close()
        L58:
            android.util.Pair r5 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r5.<init>(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3.queryCopiedFilesIndex():android.util.Pair");
    }

    public long queryCopiedFilesTotalSize() throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql("select sum(size) from %s where status = ? and isdir = 0;"), new String[]{String.valueOf(1)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    public long queryFilesSizeByStatus(int i10) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql("select sum(size) from %s where status = ? and isdir = 0;"), new String[]{String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery == null) {
            return 0L;
        }
        cursorRawQuery.close();
        return 0L;
    }

    public List<String> queryInvalidUploadMeta(long j10) throws C9721b {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, PmsMetaDBScript.QUERY_INVALID_UPLOAD_META, this.tableName), new String[]{String.valueOf(j10)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(cursorRawQuery.getString(0));
                        } while (cursorRawQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "queryInvalidUploadMeta error: " + e10.toString());
        }
        return arrayList;
    }

    public String queryPmsCopyTypeByFilePath(String str) throws C9721b {
        Cursor cursorRawQuery = rawQuery(formatSql(PmsMetaDBScript.QUERY_PMS_COPY_TYPE_BY_FILEPATH), new String[]{str});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
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
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return "";
    }

    public long querySumFreeSizeByRatio(double d10, double d11) {
        long j10 = 0;
        if (isTableExist(AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE)) {
            try {
                Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, TarRefRatioDBScript.SUM_FREE_SIZE_BY_RATIO, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(0), String.valueOf(d10), String.valueOf(1), String.valueOf(d11)});
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.moveToFirst()) {
                            j10 = cursorRawQuery.getLong(0);
                        }
                    } finally {
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "queryTarRefRatioByFileId error: " + e10);
            }
        }
        return j10;
    }

    public double queryTarRefRatioByFileId(String str) {
        double d10 = -1.0d;
        if (isTableExist(AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE)) {
            try {
                Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, QUERY_TAR_REFRATIO_BY_FILEID, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{str});
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.moveToFirst()) {
                            d10 = cursorRawQuery.getDouble(0);
                        }
                    } finally {
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "queryTarRefRatioByFileId error: " + e10);
            }
        }
        C11839m.m70686d(TAG, "fileIdOrCloudPath: " + str + " ,result: " + d10);
        return d10;
    }

    public List<Double> queryTarRefRatioByLimit(int i10) {
        ArrayList arrayList = new ArrayList();
        if (isTableExist(AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE)) {
            try {
                Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, QUERY_TAR_REFRATIO_BY_LIMIT, AbstractC11478a.TABLE_NAME_CACL_TAR_RATIO_TABLE), new String[]{String.valueOf(i10)});
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.moveToFirst()) {
                            do {
                                arrayList.add(Double.valueOf(new BigDecimal(cursorRawQuery.getDouble(0)).setScale(4, 4).doubleValue()));
                            } while (cursorRawQuery.moveToNext());
                        }
                    } finally {
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "queryTarRefRatioByLimit error: " + e10.toString());
            }
        }
        return arrayList;
    }

    public void updateCopyTypeByLastSuccessBackupRecord(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "updateCopyTypeByLastSuccessBackupRecord snapshotDbName is empty");
        } else {
            execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_TAR_COPY_TYPE_BY_SNAPSHOT, this.tableName, str), new String[]{str2});
        }
    }

    public void updateFileMetaByV2Snapshot(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "full_brief_files_info_v3 updateMetaBySnapshot error, snapshotDbName is null");
        }
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FILE_META_BY_SNAPSHOT_V3, this.tableName, str), new String[]{str2});
    }

    public void updateFileMetaByV2SnapshotModifytime(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateFileMetaByV2SnapshotModifytime error, snapshotDbName is null");
        }
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FILE_META_BY_V2_SNAPSHOT_DATE_MODIFY, this.tableName, str), new String[]{str2});
    }

    public void updateFileMetaByV3Snapshot(String str, String str2, boolean z10) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "full_brief_files_info_v3 updateMetaBySnapshot error, snapshotDbName is null");
        }
        Locale locale = Locale.ENGLISH;
        String[] strArr = {str2};
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_FILE_ID_META_BY_SNAPSHOT_V3, this.tableName, str), strArr);
        if (z10) {
            C11839m.m70688i(TAG, "updateFileMetaByV3Snapshot ignoreVfsBK");
        } else {
            execSQL(String.format(locale, PmsMetaDBScript.UPDATE_CLOUDPATH_META_BY_SNAPSHOT_V3, this.tableName, str), strArr);
        }
    }

    public void updateFileMetaByV3SnapshotModifytime(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateFileMetaByV2SnapshotModifytime error, snapshotDbName is null");
        }
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FILE_META_BY_V3_SNAPSHOT_DATE_MODIFY, this.tableName, str), new String[]{str2});
    }

    public void updateFolderMetaBySnapshot(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "full_brief_files_info_v3 updateMetaBySnapshot error, snapshotDbName is null");
        }
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FOLDER_META_BY_SNAPSHOT, this.tableName, str), new String[]{str2});
    }

    public void updateFullBriefStatusByToCopyResult() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FULL_BRIEF_FILES_INFO_STATUS_BY_TO_COPY_RESULT, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY_V3));
    }

    public void updateInvalidUploadMetaDefault(String str) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_INVALID_UPLOAD_META, this.tableName), new String[]{str});
    }

    public void updateMetaByInvalidFullBrief() throws C9721b {
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_FILE_META_BY_INVALID_FULL_BRIEF, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3, "full_brief_files_info_v3_temp"), new String[]{String.valueOf(1)});
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_FILE_META_UPLOADED_BY_INVALID_FULL_BRIEF, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3, "full_brief_files_info_v3_temp"), new String[0]);
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_DIR_META_BY_INVALID_FULL_BRIEF, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3, "full_brief_files_info_v3_temp"), new String[]{String.valueOf(1)});
    }

    public void updateMetaFileType() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_META_TYPE_BY_ISDIR, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3));
    }

    public void updateNotExistFileInfoStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "updateNotExistFileInfoStatus filepath is null.");
            return;
        }
        try {
            execSQL(formatSql(PmsMetaDBScript.UPDATE_PMS__NOT_EXIST_FILE_INFO_STATUS_BY_FILEPATH), new String[]{String.valueOf(0), String.valueOf(2), "", str});
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "updateNotExistFileInfoStatus error: " + e10.toString());
        }
    }

    public boolean updatePmsCopyTypeByFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70689w(TAG, "updatePmsCopyTypeByFilePath filepath is null.");
            return false;
        }
        try {
            execSQL(formatSql(PmsMetaDBScript.UPDATE_PMS_COPY_TYPE_BY_FILEPATH), new String[]{str, str2});
            return true;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "updatePmsCopyTypeByFilePath error: " + e10.toString());
            return false;
        }
    }

    public void updatePmsMetaStatusByLostFile(String str, int i10) throws C9721b, SQLException {
        C11839m.m70688i(TAG, "updatePmsMetaStatusByLostFile appId: " + str + " uid: " + i10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C13617a.m81941w());
        sb2.append(File.separator);
        sb2.append("cloudbackup_status.db");
        attach(sb2.toString());
        try {
            try {
                execSQL(UPDATESTATU_SNAPSHOT_SQL_BY_LOST, new String[]{String.valueOf(0), String.valueOf(0), String.valueOf(6), String.valueOf(2), str, str});
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "updatePmsStatusByLostFile error." + e10.getMessage());
                throw e10;
            }
        } finally {
            detach();
        }
    }

    public void updateStatusByCopyResult(String str) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FULL_BRIEF_FILES_INFO_STATUS, str, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY_V3));
    }

    public void updateStatusByData(String str, int i10) throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.UPDATE_STATUS_AND_ISVALID_BY_DATA), new String[]{String.valueOf(i10), str});
    }

    public void updateTempMetaToDelete() throws C9721b {
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_TEMP_FILE_META_TO_DELETE, "full_brief_files_info_v3_temp", PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3), new String[]{String.valueOf(2), String.valueOf(1)});
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_TEMP_FILE_META_UPLOADED_TO_DELETE, "full_brief_files_info_v3_temp", PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3), new String[]{String.valueOf(2), String.valueOf(3)});
    }
}
