package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator;
import fk.C9721b;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class QueryAllPmsMetaIndexBuilder extends PmsDataMetaIndexBuilder {
    protected static final String QUERY_METAS_ID = "select id from %s;";
    private static final String TAG = "QueryAllPmsMetaIndexBuilder";

    public QueryAllPmsMetaIndexBuilder(PmsMetaBaseOperator pmsMetaBaseOperator) {
        super(pmsMetaBaseOperator);
    }

    @Override // mm.AbstractC11494p
    public List<PmsMeta> batchQuery(long j10, long j11) throws C9721b {
        return this.operator.batchQuery(((PmsDataMetaIndexBuilder) this).tableName, getTableName(), j10, j11);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.PmsDataMetaIndexBuilder
    public void build() throws C9721b {
        String str = String.format(Locale.ENGLISH, QUERY_METAS_ID, ((PmsDataMetaIndexBuilder) this).tableName);
        this.operator.build(getTableName(), str, new String[0]);
    }
}
