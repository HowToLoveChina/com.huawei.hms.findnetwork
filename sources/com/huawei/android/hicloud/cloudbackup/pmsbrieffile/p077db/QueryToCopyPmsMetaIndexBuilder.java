package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator;
import fk.C9721b;
import java.util.Locale;

/* loaded from: classes2.dex */
public class QueryToCopyPmsMetaIndexBuilder extends PmsDataMetaIndexBuilder {
    public static final String QUERY_TO_COPY_METAS = "select id from %s where status = ? and isvalid = ? order by id asc;";
    private static final String TAG = "QueryToCopyPmsMetaIndexBuilder";

    public QueryToCopyPmsMetaIndexBuilder(PmsMetaBaseOperator pmsMetaBaseOperator) {
        super(pmsMetaBaseOperator);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.PmsDataMetaIndexBuilder
    public void build() throws C9721b {
        String[] strArr = {String.valueOf(0), String.valueOf(0)};
        this.operator.build(getTableName(), String.format(Locale.ENGLISH, QUERY_TO_COPY_METAS, ((PmsDataMetaIndexBuilder) this).tableName), strArr);
    }
}
