package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.io.File;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PmsFullBriefFilesInfoOperator extends PmsMetaBaseOperator {
    private static final String TAG = "PmsFullBriefFilesInfoOperator";

    public PmsFullBriefFilesInfoOperator(String str) {
        super(str);
    }

    public void createTable() throws C9721b {
        execSQL(PmsMetaDBScript.CREATE_FULL_BRIEF_FILES_INFO_SQL);
        execSQL(PmsMetaDBScript.CREATE_INDEX_FULL_BRIEF_FILES_SQL);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator
    public String initTableName() {
        return PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO;
    }

    public void pmsMetaToSnapshot(String str) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.PMS_META_TO_SNAPSHOT, SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, this.tableName), new String[]{ICBUtil.RELATIVE_SDATA_PATH + File.separator, str, String.valueOf(System.currentTimeMillis())});
    }

    public void pmsMetaToV3Snapshot(String str, String str2) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.PMS_META_TO_V3_SNAPSHOT, SnapshotBackupMetaScript.TABLE_NAME_SNAPSHOT_BACKUP_META, this.tableName), new String[]{ICBUtil.RELATIVE_SDATA_PATH + File.separator, str, str2, String.valueOf(System.currentTimeMillis())});
    }

    public void updateFileMetaBySnapshot(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "full_brief_files_info updateMetaBySnapshot error, snapshotDbName is null");
        }
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FILE_META_BY_SNAPSHOT, this.tableName, str), new String[]{str2});
    }

    public void updateFolderMetaBySnapshot(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "full_brief_files_info updateMetaBySnapshot error, snapshotDbName is null");
        }
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FOLDER_META_BY_SNAPSHOT, this.tableName, str), new String[]{str2});
    }

    public void updateFullBriefStatusByToCopyResult() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FULL_BRIEF_FILES_INFO_STATUS_BY_TO_COPY_RESULT, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY));
    }

    public void updateMetaByInvalidFullBrief() throws C9721b {
        Locale locale = Locale.ENGLISH;
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_FILE_META_BY_INVALID_FULL_BRIEF, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO, "full_brief_files_info_temp"), new String[]{String.valueOf(1)});
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_DIR_META_BY_INVALID_FULL_BRIEF, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO, "full_brief_files_info_temp"), new String[]{String.valueOf(1)});
    }

    public void updateStatusByCopyResult() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FULL_BRIEF_FILES_INFO_STATUS, PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY));
    }

    public void updateTempMetaToDelete() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_TEMP_FILE_META_TO_DELETE, "full_brief_files_info_temp", PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO), new String[]{String.valueOf(2), String.valueOf(1)});
    }
}
