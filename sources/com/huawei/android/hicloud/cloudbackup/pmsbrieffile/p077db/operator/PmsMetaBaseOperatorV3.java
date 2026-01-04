package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class PmsMetaBaseOperatorV3 extends PmsMetaBaseOperator {
    public PmsMetaBaseOperatorV3(String str) {
        super(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator
    public void batchReplace(List<PmsMeta> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PmsMeta> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getColumns(it.next()));
        }
        execute(formatSql(PmsMetaDBScript.REPLACE_PMS_META_V3), arrayList);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator
    public PmsMeta getPmsMetaObj() {
        return new PmsMetaV3();
    }
}
