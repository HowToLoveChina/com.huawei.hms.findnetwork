package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.BackupRecordMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.messagecenter.richmessage.TextItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p514o9.C11839m;
import p815ym.AbstractC14026a;

/* loaded from: classes2.dex */
public class SnapshotBackupMetaOperator extends BaseOperator<SnapshotBackupMeta> {
    public static final String ALIAS_HISTORY_SNAPSHOT_DB_NAME = "last";
    private static final int ATTACHED_DB_NUM = 2;
    private static final String TAG = "SnapshotBackupMetaOperator";
    BackupRecordMetaOperator backupRecordMetaOperator;
    private String recordId;

    public SnapshotBackupMetaOperator(String str) {
        super(str);
        this.recordId = str;
        this.backupRecordMetaOperator = new BackupRecordMetaOperator(str);
    }

    private String getTableName(String str) {
        C11839m.m70686d(TAG, "get snaoshot data table name, recordId = " + str);
        return SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META;
    }

    private boolean isContainsLast(List<Pair<String, String>> list) {
        for (Pair<String, String> pair : list) {
            if (pair != null) {
                C11839m.m70688i(TAG, "isContainsLast: " + ((String) pair.first));
                if ("last".equals(pair.first)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void attachHistorySnapshotDB(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.recordId) || TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "attachHistorySnapshotDB error, recordId or backupId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "attachHistorySnapshotDB error, recordId is null.");
        }
        List<Pair<String, String>> attachedDbs = getAttachedDbs();
        if (attachedDbs != null && attachedDbs.size() >= 2 && isContainsLast(attachedDbs)) {
            detachHistorySnapshotDB();
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.ATTACH_HISTORY_SUCCESS_SNAPSHOT_DATABASE, str, "last"));
    }

    public void batchReplace(List<SnapshotBackupMeta> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (SnapshotBackupMeta snapshotBackupMeta : list) {
                arrayList.add(new String[]{snapshotBackupMeta.getData(), snapshotBackupMeta.getRoot(), snapshotBackupMeta.getName(), String.valueOf(snapshotBackupMeta.getType()), String.valueOf(snapshotBackupMeta.getLeft()), String.valueOf(snapshotBackupMeta.getRight()), snapshotBackupMeta.getAppId(), snapshotBackupMeta.getHash1(), snapshotBackupMeta.getHash2(), String.valueOf(snapshotBackupMeta.getStatus()), String.valueOf(snapshotBackupMeta.getSize()), String.valueOf(snapshotBackupMeta.getCount()), snapshotBackupMeta.getCloudPath(), String.valueOf(snapshotBackupMeta.getCloudSize()), snapshotBackupMeta.getCloudHash(), String.valueOf(snapshotBackupMeta.getCloudEncoded()), String.valueOf(snapshotBackupMeta.getAppType()), snapshotBackupMeta.getAppSlice(), String.valueOf(snapshotBackupMeta.getDateCreate()), String.valueOf(snapshotBackupMeta.getDateModify()), String.valueOf(snapshotBackupMeta.getDateInvalid()), String.valueOf(snapshotBackupMeta.getDateTaken()), snapshotBackupMeta.getExtend(), snapshotBackupMeta.getData1(), snapshotBackupMeta.getData2(), snapshotBackupMeta.getData3(), snapshotBackupMeta.getData4(), snapshotBackupMeta.getData5(), snapshotBackupMeta.getData6()});
            }
            execSQL4Batch(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.REPLACE_BY_APPID, getTableName(this.recordId)), arrayList);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "replace status error." + e10.getMessage());
            throw e10;
        }
    }

    public boolean checkTableExist() {
        try {
            Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_ALL_ROOT_NODES_TEST_EXIST, getTableName(this.recordId)), null);
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
            C11839m.m70689w(TAG, "recordId:" + this.recordId + " checkTableExist exists error." + e10.toString());
        }
        return false;
    }

    public void clearNotExistFileFlag() throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATA_DATA2_BY_DATA2, getTableName(this.recordId)), new String[]{""});
    }

    public void createSnapshotBackupMetaTable() throws C9721b, SQLException {
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, SnapshotBackupMetaScript.CREATE_TABLE_SNAPSHOT_BACKUP_META, getTableName(this.recordId)));
        execSQL(String.format(locale, SnapshotBackupMetaScript.CREATE_INDEX_TABLE_SNAPSHOT_BACKUP_META, getTableName(this.recordId)));
    }

    public void defaultNotSuccessModuleStatus() throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DEFAULT_NOT_SUCCESS_MODULE_STATUS, getTableName(this.recordId)), new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(2), String.valueOf(3)});
    }

    public void deleteData(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            C11839m.m70686d(TAG, "deletNodes data and hash error");
            return;
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DELETE_DATA_BY_APPID_AND_ROOT, getTableName(this.recordId)), new String[]{str, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
    }

    public void deleteLargeDbDiffIncMetaByAppId(String str, String str2, String str3) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DELETE_LARGE_DB_META_BY_APPID, getTableName(this.recordId)), new String[]{String.valueOf(str), str2, str3});
    }

    public void deleteLeafNode(String str, String str2, String str3) throws C9721b, SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70686d(TAG, "deletNodes data and hash error");
        } else {
            execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DELETE_NODE_BY_DATA_AND_HASH, getTableName(this.recordId)), new String[]{str, str2, str3});
        }
    }

    public void deleteMetaByAppId(String str) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DELETE_META_BY_APPID, getTableName(this.recordId)), new String[]{String.valueOf(str)});
    }

    public void deleteMetas() throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, "delete from %s", getTableName(this.recordId)));
        this.backupRecordMetaOperator.deleteTable();
    }

    public void deleteNodes(String str) throws C9721b, SQLException {
        execSQL(SnapshotBackupMetaScript.DELETE_NODES_BY_APPID, new String[]{str});
    }

    public void deleteNotExistFile() throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DELETE_NODE_BY_DATA2, getTableName(this.recordId)));
    }

    public void deleteNotExistFileByAppId(String str) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DELETE_NODE_BY_APPID_DATA2, getTableName(this.recordId)), new String[]{str});
    }

    public void deleteSdcard(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            C11839m.m70686d(TAG, "deletNodes data and hash error");
            return;
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DELETE_SDCARD_BY_APPID_AND_ROOT, getTableName(this.recordId)), new String[]{str, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
    }

    public void detachHistorySnapshotDB() throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DETACH_HISTORY_SUCCESS_SNAPSHOT_DATABASE, "last"));
    }

    public void dropTable() throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.DROP_TABLE_SNAPSHOT_BACKUP_META, getTableName(this.recordId)));
        this.backupRecordMetaOperator.deleteTable();
    }

    public void integrityRepaired() throws SQLException {
        try {
            execSQL(SnapshotBackupMetaScript.RENAME_SNAPSHOT);
            Locale locale = Locale.ENGLISH;
            execSQL(String.format(locale, SnapshotBackupMetaScript.CREATE_TABLE_SNAPSHOT_BACKUP_META, getTableName(this.recordId)));
            execSQL(SnapshotBackupMetaScript.TRANSLATE_SNAPSHOT);
            execSQL(SnapshotBackupMetaScript.DROP_OLD_SNAPSHOT);
            execSQL(String.format(locale, SnapshotBackupMetaScript.CREATE_INDEX_TABLE_SNAPSHOT_BACKUP_META, getTableName(this.recordId)));
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "integrity check error: " + e10.toString());
        }
    }

    public boolean isOldSnapshot() throws Throwable {
        List<String> listQueryResult4List = queryResult4List(SnapshotBackupMetaScript.QUERY_OLD_SNAPSHOT_FLAG_BY_UNIQUE, new String[]{SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, SnapshotBackupMetaScript.OLD_SNAPSHOT_CREATE_CONDITION});
        return listQueryResult4List != null && listQueryResult4List.size() > 0;
    }

    public int queryAllFileMetasCountSafety() throws C9721b {
        try {
            Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_ALL_FILE_NODES_COUNT, getTableName(this.recordId)), null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        int i10 = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        return i10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "recordId:" + this.recordId + " checkTableExist exists error." + e10);
        }
        return 0;
    }

    public long queryAllMetasNum() throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_ALL_MEATS_NUM, getTableName(this.recordId)), new String[0]);
    }

    public List<SnapshotBackupMeta> queryAllRootNodeMetas() throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_ALL_ROOT_NODES, getTableName(this.recordId)), new String[0]);
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "qurey app root node eror");
        }
        return listQueryResult4Vo;
    }

    public List<SnapshotBackupMeta> queryAllRootNodeMetasSafety() throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_ALL_ROOT_NODES, getTableName(this.recordId)), new String[0]);
        return listQueryResult4Vo == null ? new ArrayList() : listQueryResult4Vo;
    }

    public long queryAllSizeSumByAppId(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_ALL_SIZE_BYAPPID, getTableName(this.recordId)), new String[]{String.valueOf(str)});
    }

    public List<SnapshotBackupMeta> queryApkFileMetaByAppId(String str) throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_APK_META_BY_APPID, getTableName(this.recordId)), new String[]{String.valueOf(str)});
        return listQueryResult4Vo == null ? new ArrayList() : listQueryResult4Vo;
    }

    public SnapshotBackupMeta queryAppApkFile(String str, String str2) throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_APP_APK_FILE, getTableName(this.recordId)), new String[]{str, str2});
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            throw new C9721b(1109, "query app apk file error.");
        }
        return listQueryResult4Vo.get(0);
    }

    public SnapshotBackupMeta queryAppInfoFile(String str, String str2) throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, "select id,data,root,name,type,left,right,app_id,hash1,hash2,status,size,count,cloud_path,cloud_size,cloud_hash,cloud_encoded,app_type,app_slice,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from %s where app_id = ? and data = ?;", getTableName(this.recordId)), new String[]{str, str2});
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "query app info.xml file error.");
        }
        return listQueryResult4Vo.get(0);
    }

    public Map<String, List<String>> queryDeletedLeafNodes() throws C9721b {
        if (TextUtils.isEmpty(this.recordId)) {
            C11839m.m70687e(TAG, "queryDeletedLeafNodesByStatus error, recordId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "queryDeletedLeafNodesByStatus error, recordId is null.");
        }
        String tableName = getTableName(this.recordId);
        HashMap map = new HashMap();
        Cursor cursorRawQuery = rawQuery(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_DELETED_META_NODES, tableName), new String[0]);
        if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
            do {
                String string = cursorRawQuery.getString(0);
                String string2 = cursorRawQuery.getString(1);
                List arrayList = (List) map.get(string2);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(string);
                map.put(string2, arrayList);
            } while (cursorRawQuery.moveToNext());
        }
        return map;
    }

    public int queryHashInvalidCount(String str) throws C9721b {
        return (int) queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_COUNT_DATA_HASH_NULL_BY_APPID, getTableName(this.recordId)), new String[]{str, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
    }

    public List<SnapshotBackupMeta> queryHashInvalidMetasByLimit(String str, int i10) throws C9721b {
        return queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_META_DATA_HASH_NULL_BY_APPID, getTableName(this.recordId)), new String[]{str, ICBUtil.RELATIVE_SDATA_PATH + File.separator, String.valueOf(i10)});
    }

    public int queryInternalFilesCount(String str) throws C9721b {
        return (int) queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_INCREMENT_FILES_COUNT, getTableName(this.recordId)), new String[]{str, "/sdata/"});
    }

    public long queryInternalFilesSize(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_INCREMENT_FILES_SIZE, getTableName(this.recordId)), new String[]{str, "/sdata/"});
    }

    public int queryInternalUploadMetasNum(String str) throws C9721b {
        return (int) queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_INTERNAL_METAS_TO_UPLOAD_NUM_BYAPPID, getTableName(this.recordId)), new String[]{str, String.valueOf(4), String.valueOf(5), String.valueOf(6), "/sdata/"});
    }

    public long queryInternalWaitBackupSize(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_INTERNAL_SIZE_BY_NOT_IN_STATUS, getTableName(this.recordId)), new String[]{str, String.valueOf(4), String.valueOf(5), String.valueOf(6), "/sdata/"});
    }

    public boolean queryIsHaveAppDataFile(String str, String str2, String str3) throws C9721b {
        return queryResult(SnapshotBackupMetaScript.QUERY_APP_DATA_FILE, new String[]{str, str2, str3}) > 0;
    }

    public long queryLargeDbFilesCount(String str, long j10) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_LARGE_DB_FILE_COUNT, getTableName(this.recordId)), new String[]{str, "/sdata/", "%.db", String.valueOf(j10)});
    }

    public BackupRecordMeta queryLastBackupRecordMeta() throws C9721b {
        List<BackupRecordMeta> listQueryAllMetas = this.backupRecordMetaOperator.queryAllMetas();
        if (listQueryAllMetas == null || listQueryAllMetas.isEmpty()) {
            return null;
        }
        return listQueryAllMetas.get(0);
    }

    public long queryMaxRightIndex() throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_MAX_RIGHT_INDEX, getTableName(this.recordId)), new String[0]);
    }

    public SnapshotBackupMeta queryMetaByHash(String str, String str2, String str3) throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_META_INFO_BY_HASH, getTableName(this.recordId)), new String[]{str3, str2, str});
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "query meta by hash error.");
        }
        return listQueryResult4Vo.get(0);
    }

    public List<SnapshotBackupMeta> queryMetasByAppIdLimit(String str, long j10, long j11) throws C9721b {
        return queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_META_BY_LIMIT, getTableName(this.recordId)), new String[]{str, String.valueOf(j10), String.valueOf(j11)});
    }

    public List<SnapshotBackupMeta> queryMetasByName(String str, String str2, String str3) throws C9721b {
        return queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_METAS_BY_APPID_AND_NAME, getTableName(this.recordId)), new String[]{str, str2, str3});
    }

    public List<SnapshotBackupMeta> queryMetasByType(String str, int i10) throws C9721b {
        return queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_METAS_BY_APPID_AND_TYPE, getTableName(this.recordId)), new String[]{str, String.valueOf(i10)});
    }

    public List<SnapshotBackupMeta> queryMetasExcludeTarByAppIdLimit(String str, long j10, long j11) throws C9721b {
        return queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_META_EXCLUDETAR_BY_LIMIT, getTableName(this.recordId)), new String[]{str, String.valueOf(j10), String.valueOf(j11)});
    }

    public long queryMetasSizeByAppId(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_SIZE_BY_APP_ID, getTableName(this.recordId)), new String[]{String.valueOf(str)});
    }

    public long queryMetasSizeByCloudPath(String str, String str2) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_METAS_SIZE_BY_CLOUDPATH, getTableName(this.recordId)), new String[]{String.valueOf(str), String.valueOf(str2)});
    }

    public long queryMetasSizeExcludeTarByAppId(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_META_COUNT_EXCLUDETAR_BYAPPID, getTableName(this.recordId)), new String[]{str});
    }

    public List<SnapshotBackupMeta> queryMetasTarByCloudPathLimit(String str, String str2, long j10, long j11) throws C9721b {
        return queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_META_BY_CLOUDPATH_LIMIT, getTableName(this.recordId)), new String[]{String.valueOf(str), String.valueOf(str2), String.valueOf(j10), String.valueOf(j11)});
    }

    public long queryMkfileBackupSize(String str) {
        try {
            return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_STATUS_MKFILE_SUCCESS_SIZE_BY_APPID, getTableName(this.recordId)), new String[]{str, String.valueOf(6), String.valueOf(5)});
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "queryMkfileBackupSize error: " + e10.toString());
            return 0L;
        }
    }

    public long queryMkfileSizeByAppIdExcludeApk(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_MKFILE_SIZE_BYAPPID_MKFILE, getTableName(this.recordId)), new String[]{String.valueOf(str)});
    }

    public long queryNeedUploadSize(String str) {
        try {
            return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_STATUS_DEFAULT_SIZE_BY_APPID, getTableName(this.recordId)), new String[]{str, String.valueOf(0)});
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "queryNeedUploadSize error: " + e10.toString());
            return 0L;
        }
    }

    public long queryNotMkfileSizeExcludeApk() throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_NOT_MKFILE_SIZE, getTableName(this.recordId)), new String[0]);
    }

    public SnapshotBackupMeta queryRootNodeMeta(String str) throws C9721b {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, "select id,data,root,name,type,left,right,app_id,hash1,hash2,status,size,count,cloud_path,cloud_size,cloud_hash,cloud_encoded,app_type,app_slice,date_create,date_modify,date_invalid,date_taken,extend,data1,data2,data3,data4,data5,data6 from %s where app_id = ? and data = ?;", getTableName(this.recordId)), new String[]{str, str});
        if (listQueryResult4Vo != null && !listQueryResult4Vo.isEmpty()) {
            return listQueryResult4Vo.get(0);
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "qurey app root node error , appid: " + str);
    }

    public boolean querySameAppFile(String str, String str2) throws Throwable {
        try {
            C11839m.m70686d(TAG, "querySameAppFile appId: " + str + " ,serverPath: " + str2 + " ,result: " + queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_APP_SERVER_INFO, getTableName(this.recordId)), new String[]{str, str2}));
            return !AbstractC14026a.m84159a(r4);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "querySameAppFile error: " + e10);
            return false;
        }
    }

    public int querySdcardCountByAppId(String str) throws C9721b {
        return (int) queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_SDCARD_META_COUNT_BY_APPID, getTableName(this.recordId)), new String[]{str, ICBUtil.RELATIVE_SDATA_PATH + File.separator});
    }

    public long querySizeByAppIdExcludeStandApk(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_SIZE_BYAPPID_EXCLUDE_STANDAPK, getTableName(this.recordId)), new String[]{String.valueOf(str)});
    }

    public long querySizeExcludeStandApk() throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_SIZE_EXCLUDE_STANDAPK, getTableName(this.recordId)), new String[0]);
    }

    public long queryStatusMetaCount(String str, int i10) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_META_COUNT_BY_APPID_STATUS, getTableName(this.recordId)), new String[]{str, String.valueOf(i10)});
    }

    public List<SnapshotBackupMeta> queryStatusNotSuccessMetas(String str) throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_STATUS_NOT_SUCCESS_NODES, getTableName(this.recordId)), new String[]{str});
        return (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) ? new ArrayList() : listQueryResult4Vo;
    }

    public List<SnapshotBackupMeta> queryStatusNotSuccessNodeMetas() throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_STATUS_NOT_SUCCESS_ROOT_NODES, getTableName(this.recordId)), new String[0]);
        return (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) ? new ArrayList() : listQueryResult4Vo;
    }

    public int queryStatusSuccessCountByAppId(String str) throws C9721b {
        return (int) queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_STATUS_SUCCESS_COUNT_BY_APPID, getTableName(this.recordId)), new String[]{str, String.valueOf(4), String.valueOf(5), String.valueOf(6)});
    }

    public long queryStatusSuccessSizeByAppId(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_STATUS_SUCCESS_SIZE_BY_APPID, getTableName(this.recordId)), new String[]{str, String.valueOf(4), String.valueOf(5), String.valueOf(6)});
    }

    public List<String> queryTarCloudPathByAppId(String str) throws C9721b {
        return queryResult4List(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_TARCLOUDPATH_BYAPPID, getTableName(this.recordId)), new String[]{str});
    }

    public List<SnapshotBackupMeta> queryUploadMetasBylimit(String str, long j10, long j11) throws C9721b {
        return queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_UPLOAD_METAS_BY_APPID_LIMIT_OFFSET, getTableName(this.recordId)), new String[]{str, String.valueOf(4), String.valueOf(5), String.valueOf(6), String.valueOf(j10), String.valueOf(j11)});
    }

    public long queryUploadMetasSizeByAppId(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_UPLOAD_METAS_SIZE_BY_APPID, getTableName(this.recordId)), new String[]{str, String.valueOf(4), String.valueOf(5), String.valueOf(6)});
    }

    public long queryWaitBackupSize(String str) throws C9721b {
        return queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_SIZE_BY_NOT_IN_STATUS, getTableName(this.recordId)), new String[]{str, String.valueOf(4), String.valueOf(5), String.valueOf(6)});
    }

    public int queryWaitDeleteFileCount(String str) throws C9721b {
        return (int) queryResult(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_WAIT_DELETE_FILE_COUNT_BY_APPID, getTableName(this.recordId)), new String[]{str});
    }

    public List<SnapshotBackupMeta> queryWaitDeleteRetryFilesLimitByAppId(String str, long j10, long j11) throws Throwable {
        List<SnapshotBackupMeta> listQueryResult4Vo = queryResult4Vo(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.QUERY_WAIT_DELETE_RETRY_FILES_LIMIT_BY_APPID, getTableName(this.recordId)), new String[]{String.valueOf(str), String.valueOf(j10), String.valueOf(j11)});
        return listQueryResult4Vo == null ? new ArrayList() : listQueryResult4Vo;
    }

    public void replaceDataToAppMetaInfo(String str, String str2) throws C9721b, SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70687e(TAG, "replaceDataToAppMetaInfo error, recordId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "replaceDataToAppMetaInfo error, appId or serverPath is empty.");
        }
        execSQL(SnapshotBackupMetaScript.INSERT_SNAPSHOT_DATA_TO_APP_META_INFO, new String[]{str2, str});
    }

    public void resetApkIconStatus(String str, String str2, String str3, String str4, String str5, String str6) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.RESET_APKICON_STATUS, getTableName(this.recordId)), new String[]{String.valueOf(0), String.valueOf(str), String.valueOf(str2), String.valueOf(str3), String.valueOf(str4), String.valueOf(str5), String.valueOf(str6)});
    }

    public void setLastBackupRecordMeta(BackupRecordMeta backupRecordMeta) throws C9721b, SQLException {
        if (backupRecordMeta != null && !TextUtils.isEmpty(backupRecordMeta.getCurrentRecordId())) {
            this.backupRecordMetaOperator.replace(backupRecordMeta);
            return;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "set last backup record error , recordId: " + this.recordId);
    }

    public void updataCloudPathByPath(String str, String str2, String str3, String str4) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATA_CLOUDPATH_BYPATH, getTableName(this.recordId)), new String[]{String.valueOf(str), String.valueOf(str2), String.valueOf(str3), String.valueOf(str4)});
    }

    public void updateCloudPathByCloudPath(String str, String str2, String str3) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_CLOUDPATH_BYCLOUDPATH, getTableName(this.recordId)), new String[]{String.valueOf(str), String.valueOf(str2), String.valueOf(str3)});
    }

    public void updateDeleteAndClearCloudPath(SnapshotBackupMeta snapshotBackupMeta) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_NODES_DATA2_AND_CLEAR_CLOUDPATH, getTableName(this.recordId)), new String[]{snapshotBackupMeta.getAppId(), snapshotBackupMeta.getData(), snapshotBackupMeta.getRoot()});
    }

    public void updateDeletedLeafNodes() throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.recordId)) {
            C11839m.m70687e(TAG, "updateDeletedLeafNodes error, recordId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateDeletedLeafNodes error, recordId is null.");
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_DELETE_META_NODES, getTableName(this.recordId)), new String[0]);
    }

    public void updateDeletedLeafNodesByCloudPathAndAppId(Map<String, String> map) throws C9721b {
        if (TextUtils.isEmpty(this.recordId)) {
            C11839m.m70687e(TAG, "updateDeletedLeafNodesByCloudPathAndAppId error, recordId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateDeletedLeafNodesByCloudPathAndAppId error, recordId is null.");
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new String[]{entry.getKey(), entry.getValue()});
        }
        execSQL4Batch(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_META_NODES_BY_CLOUDPATH_AND_APPID, getTableName(this.recordId)), arrayList);
    }

    public void updateDeletedLeafNodesByStatus(int i10) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.recordId)) {
            C11839m.m70687e(TAG, "updateDeletedLeafNodesByStatus error, recordId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateDeletedLeafNodesByStatus error, recordId is null.");
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_DELETE_META_NODES_BY_STATUS, getTableName(this.recordId)), new String[]{String.valueOf(i10)});
    }

    public void updateLargeDbFilesType(String str, long j10, int i10) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_LARGE_DB_FILE_TYPE, getTableName(this.recordId)), new String[]{String.valueOf(i10), str, "/sdata/", "%.db", String.valueOf(j10)});
    }

    public void updateLeafNodeInfo(String str, long j10, String str2, int i10, String str3, String str4, String str5, String str6, String str7, String str8, String str9) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_NODE_INFO, getTableName(this.recordId)), new String[]{String.valueOf(j10), str2, String.valueOf(i10), str3, str4, str5, str6, str7, str8, str9, str});
    }

    public void updateLeafNodeStatus(String str, String str2, long j10, String str3) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_NODE_STATUS, getTableName(this.recordId)), new String[]{String.valueOf(j10), str, str2, str3});
    }

    public void updateLeafNodeStatusByAppIdAndCloudPath(String str, String str2, int i10) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_METADATA_STATUS_BY_APPID_AND_CLOUDPATH, getTableName(this.recordId)), new String[]{String.valueOf(i10), String.valueOf(str2), String.valueOf(str)});
    }

    public void updateMetaMkInfo(String str, String str2, String str3) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATA_DATA1_BY_CLOUD_PATH_AND_APPID, getTableName(this.recordId)), new String[]{String.valueOf(str3), String.valueOf(str), String.valueOf(str2)});
    }

    public void updateNodeStatus(long j10) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_ALL_NODES_STATUS, getTableName(this.recordId)), new String[]{String.valueOf(j10)});
    }

    public void updateRootDateCreate(String str, long j10) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_ROOT_NODE_DATE_CREATE, getTableName(this.recordId)), new String[]{String.valueOf(j10), String.valueOf(str)});
    }

    public void updateRootNodeCountAndSize(String str, long j10, long j11) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_ROOT_NODE_COUNT_SIZE, getTableName(this.recordId)), new String[]{String.valueOf(j10), String.valueOf(j11), String.valueOf(str)});
    }

    public void updateRootNodeDateInvalid(String str, long j10) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_ROOT_NODE_DATE_INVALID, getTableName(this.recordId)), new String[]{String.valueOf(j10), String.valueOf(str)});
    }

    public void updateRootNodeStatus(String str, long j10) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_ROOT_NODE_STATUS, getTableName(this.recordId)), new String[]{String.valueOf(j10), String.valueOf(str)});
    }

    public void updateSameSnapshotBackupMetas(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.recordId) || TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "updateSameSnapshotBackupMetas error, recordId or histroyDBName is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "snapshot_backup_meta updateSameSnapshotBackupMetas error, recordId or histroyDBName is null.");
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_SAME_META_NODES_IN_OTHER_SNAPSHOT_TABLES, getTableName(this.recordId), str), new String[0]);
    }

    public void updateSnapshotBackupMetaCache(String str, String str2) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.recordId)) {
            C11839m.m70687e(TAG, "updateSnapshotBackupMetaCache error, recordId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateSnapshotBackupMetaCache error, recordId is null.");
        }
        String tableName = getTableName(this.recordId);
        String[] strArr = {str2};
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, SnapshotBackupMetaScript.UPDATE_SNAPSHOT_BACKUP_META_NODES_STATUS_BY_HASH, tableName, str), strArr);
        execSQL(String.format(locale, SnapshotBackupMetaScript.UPDATE_SNAPSHOT_BACKUP_META_NODES_STATUS_BY_DATA_INVALID, tableName, str), strArr);
        execSQL(String.format(locale, SnapshotBackupMetaScript.UPDATE_SNAPSHOT_BACKUP_META_NODES_STATUS, tableName, str), strArr);
    }

    public void updateTarLeafNodeInfo(String str, long j10, long j11, String str2, String str3, String str4, String str5, String str6, String str7) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_TAR_NODE_CLOUD_PATH, getTableName(this.recordId)), new String[]{String.valueOf(j10), String.valueOf(j11), str2, str3, str4, str5, str6, str7, str});
    }

    public void updateUploadMidStatus(int i10, int i11) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_UPLOAD_MID_STATUS, getTableName(this.recordId)), new String[]{String.valueOf(i11), String.valueOf(i10)});
    }

    public void updateUploadMidStatusByAppId(String str, int i10, int i11) throws C9721b, SQLException {
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_UPLOAD_MID_STATUS_BY_APPID, getTableName(this.recordId)), new String[]{String.valueOf(i11), str, String.valueOf(i10)});
    }

    public void updateV2AllWithApp(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.recordId) || TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "updateV2SameMetasByV3 error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV2SameMetasByV3 error, recordId or appId is null.");
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_META_NODES_WITH_APPID, getTableName(this.recordId)), new String[]{str});
    }

    public void updateV2SameFileMetasByV3(String str) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.recordId) || TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "updateV2SameMetasByV3 error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV2SameMetasByV3 error, recordId or appId is null.");
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_V2_SAME_FILE_METAS_BY_V3, getTableName(this.recordId), "last"), new String[]{str});
    }

    public void updateV2SameNotStandApkByV3(String str, String str2) throws C9721b, SQLException {
        if (TextUtils.isEmpty(this.recordId) || TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "updateV2SameMetasByV3 error, recordId or appId is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV2SameMetasByV3 error, recordId or appId is null.");
        }
        execSQL(String.format(Locale.ENGLISH, SnapshotBackupMetaScript.UPDATE_V2_SAME_NOT_STAND_APK_BY_V3, getTableName(this.recordId)), new String[]{str, str2});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.BaseOperator
    public SnapshotBackupMeta getVo(Cursor cursor) {
        SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
        snapshotBackupMeta.setId(cursor.getLong(cursor.getColumnIndex("id")));
        snapshotBackupMeta.setData(cursor.getString(cursor.getColumnIndex("data")));
        snapshotBackupMeta.setRoot(cursor.getString(cursor.getColumnIndex(SnapshotBackupMeta.DB_ROOT_NODE_APPID)));
        snapshotBackupMeta.setName(cursor.getString(cursor.getColumnIndex("name")));
        snapshotBackupMeta.setType(cursor.getLong(cursor.getColumnIndex("type")));
        snapshotBackupMeta.setLeft(cursor.getLong(cursor.getColumnIndex("left")));
        snapshotBackupMeta.setRight(cursor.getLong(cursor.getColumnIndex(TextItem.RIGHT)));
        snapshotBackupMeta.setAppId(cursor.getString(cursor.getColumnIndex("app_id")));
        snapshotBackupMeta.setHash1(cursor.getString(cursor.getColumnIndex("hash1")));
        snapshotBackupMeta.setHash2(cursor.getString(cursor.getColumnIndex("hash2")));
        snapshotBackupMeta.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
        snapshotBackupMeta.setSize(cursor.getLong(cursor.getColumnIndex("size")));
        snapshotBackupMeta.setCount(cursor.getLong(cursor.getColumnIndex("count")));
        snapshotBackupMeta.setCloudPath(cursor.getString(cursor.getColumnIndex("cloud_path")));
        snapshotBackupMeta.setCloudSize(cursor.getLong(cursor.getColumnIndex("cloud_size")));
        snapshotBackupMeta.setCloudHash(cursor.getString(cursor.getColumnIndex("cloud_hash")));
        snapshotBackupMeta.setCloudEncoded(cursor.getLong(cursor.getColumnIndex("cloud_encoded")));
        snapshotBackupMeta.setAppType(cursor.getLong(cursor.getColumnIndex("app_type")));
        snapshotBackupMeta.setAppSlice(cursor.getString(cursor.getColumnIndex("app_slice")));
        snapshotBackupMeta.setDateCreate(cursor.getLong(cursor.getColumnIndex("date_create")));
        snapshotBackupMeta.setDateModify(cursor.getLong(cursor.getColumnIndex("date_modify")));
        snapshotBackupMeta.setDateInvalid(cursor.getLong(cursor.getColumnIndex("date_invalid")));
        snapshotBackupMeta.setDateTaken(cursor.getLong(cursor.getColumnIndex("date_taken")));
        snapshotBackupMeta.setExtend(cursor.getString(cursor.getColumnIndex("extend")));
        snapshotBackupMeta.setData1(cursor.getString(cursor.getColumnIndex("data1")));
        snapshotBackupMeta.setData2(cursor.getString(cursor.getColumnIndex("data2")));
        snapshotBackupMeta.setData3(cursor.getString(cursor.getColumnIndex("data3")));
        snapshotBackupMeta.setData4(cursor.getString(cursor.getColumnIndex("data4")));
        snapshotBackupMeta.setData5(cursor.getString(cursor.getColumnIndex("data5")));
        snapshotBackupMeta.setData6(cursor.getString(cursor.getColumnIndex("data6")));
        return snapshotBackupMeta;
    }
}
