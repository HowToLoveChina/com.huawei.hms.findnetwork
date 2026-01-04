package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import fk.C9721b;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PmsBatchFilesInfoToCopyOperatorV3 extends PmsMetaBaseOperatorV3 {
    public PmsBatchFilesInfoToCopyOperatorV3(String str) {
        super(str);
    }

    public void deleteMetaByStatus() throws C9721b {
        execSQL(formatSql(PmsMetaDBScript.DELETE_BY_STATUS), new String[]{String.valueOf(0)});
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator
    public String initTableName() {
        return PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY_V3;
    }

    public void updateChangedFileInfoStatus() throws C9721b {
        Locale locale = Locale.ENGLISH;
        String str = String.format(locale, PmsMetaDBScript.UPDATE_CHANGED_FILE_INFO_STATUS, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY_V3, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFO_COPY_SUCCESS_V3);
        String[] strArr = {String.valueOf(1), String.valueOf(1)};
        execSQL(str, strArr);
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_CHANGED_FILE_INFO_TIME_SIZE, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY_V3, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFO_COPY_SUCCESS_V3), strArr);
    }

    public void updateNotExistFileInfoStatus() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_NOT_EXIST_FILE_INFO_STATUS, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY_V3, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFO_COPY_SUCCESS_V3), new String[]{String.valueOf(0), String.valueOf(2)});
    }

    public void updateStatusByCopyResult() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPTATE_BATCH_FILES_INFO_TO_COPY_BY_COPY_RESULT_SQL, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFOTO_COPY_V3, PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFO_COPY_SUCCESS_V3), new String[]{String.valueOf(1)});
    }
}
