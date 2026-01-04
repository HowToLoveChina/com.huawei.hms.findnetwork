package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import fk.C9721b;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PmsBatchFastTarSuccessOperatorV3 extends PmsMetaBaseOperator {
    public PmsBatchFastTarSuccessOperatorV3(String str) {
        super(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator
    public String initTableName() {
        return PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_SUCCESS_V3;
    }

    public void updateTarSuccessChangedFileStatus(String str) throws C9721b {
        Locale locale = Locale.ENGLISH;
        String str2 = String.format(locale, PmsMetaDBScript.UPDATE_CHANGED_FILE_INFO_STATUS, str, PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_SUCCESS_V3);
        String[] strArr = {String.valueOf(0), String.valueOf(1)};
        execSQL(str2, strArr);
        execSQL(String.format(locale, PmsMetaDBScript.UPDATE_CHANGED_FILE_INFO_TIME_SIZE, str, PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_SUCCESS_V3), strArr);
    }

    public void updateTarSuccessNotExistFileStatus(String str) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_FAST_TAR_NOT_EXIST_FILE_INFO_STATUS, str, PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_SUCCESS_V3), new String[]{String.valueOf(0), String.valueOf(2), "1"});
    }
}
