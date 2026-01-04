package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator;
import fk.C9721b;
import java.util.Locale;

/* loaded from: classes2.dex */
public class QueryDeletePmsMetaIndexBuilder extends PmsDataMetaIndexBuilder {
    private static final String QUERY_DELETE_METAS = "select id from %s where status in (?, ?) and isvalid = ?;";
    private static final String TAG = "QueryDeletePmsMetaIndexBuilder";

    public QueryDeletePmsMetaIndexBuilder(PmsMetaBaseOperator pmsMetaBaseOperator) {
        super(pmsMetaBaseOperator);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.PmsDataMetaIndexBuilder
    public void build() throws C9721b {
        String[] strArr = {String.valueOf(1), String.valueOf(3), String.valueOf(2)};
        this.operator.build(getTableName(), String.format(Locale.ENGLISH, QUERY_DELETE_METAS, ((PmsDataMetaIndexBuilder) this).tableName), strArr);
    }
}
