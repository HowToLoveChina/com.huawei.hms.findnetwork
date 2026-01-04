package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator;
import fk.C9721b;
import java.util.List;

/* loaded from: classes2.dex */
public class QueryPmsDataMeta {
    private static final long PAGE = 10000;
    private long allSize;
    private long current = 0;
    protected PmsMetaBaseOperator mMetaOperator;

    public QueryPmsDataMeta(PmsFullBriefFilesInfoOperator pmsFullBriefFilesInfoOperator) throws C9721b {
        initDbOperator(pmsFullBriefFilesInfoOperator);
        this.allSize = initAllSize();
    }

    public long getCurrent() {
        return this.current;
    }

    public long getLimit() {
        return 10000L;
    }

    public List<PmsMeta> getNext() throws C9721b {
        long j10 = this.current;
        long j11 = this.allSize - j10;
        if (j11 >= 10000) {
            j11 = 10000;
        }
        this.current = j10 + j11;
        return queryBylimit(j11, j10);
    }

    public long getSize() {
        return this.allSize;
    }

    public boolean hasNext() {
        return this.current <= this.allSize - 1;
    }

    public long initAllSize() throws C9721b {
        return this.mMetaOperator.queryCount();
    }

    public void initDbOperator(PmsFullBriefFilesInfoOperator pmsFullBriefFilesInfoOperator) {
        if (pmsFullBriefFilesInfoOperator != null) {
            this.mMetaOperator = pmsFullBriefFilesInfoOperator;
        }
    }

    public List<PmsMeta> queryBylimit(long j10, long j11) throws C9721b {
        return this.mMetaOperator.queryBylimit(j10, j11);
    }

    public void setAllSize(long j10) {
        this.allSize = j10;
    }

    public void setCurrent(long j10) {
        this.current = j10;
    }

    public void initDbOperator(PmsMetaBaseOperator pmsMetaBaseOperator) {
        if (pmsMetaBaseOperator != null) {
            this.mMetaOperator = pmsMetaBaseOperator;
        }
    }

    public void initDbOperator(PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3) {
        if (pmsFullBriefFilesInfoOperatorV3 != null) {
            this.mMetaOperator = pmsFullBriefFilesInfoOperatorV3;
        }
    }

    public QueryPmsDataMeta(PmsMetaBaseOperator pmsMetaBaseOperator) throws C9721b {
        initDbOperator(pmsMetaBaseOperator);
        this.allSize = initAllSize();
    }

    public QueryPmsDataMeta(PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3) throws C9721b {
        initDbOperator(pmsFullBriefFilesInfoOperatorV3);
        this.allSize = initAllSize();
    }
}
