package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;

/* loaded from: classes2.dex */
public class PmsBatchFilesInfoCopySuccessOperator extends PmsMetaBaseOperator {
    public PmsBatchFilesInfoCopySuccessOperator(String str) {
        super(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator
    public String initTableName() {
        return PmsMetaDBScript.TABLE_NAME_BATCH_FILES_INFO_COPY_SUCCESS;
    }
}
