package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import fk.C9721b;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PmsBatchFastTarOperatorV3 extends PmsMetaBaseOperator {
    public PmsBatchFastTarOperatorV3(String str) {
        super(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator
    public String initTableName() {
        return PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_V3;
    }

    public void updateStatusByFastTarResult(String str) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, PmsMetaDBScript.UPDATE_BATCH_BRIEF_FILES_INFO_STATUS_BY_FAST_TAR_RESULT, str, PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_V3));
    }
}
