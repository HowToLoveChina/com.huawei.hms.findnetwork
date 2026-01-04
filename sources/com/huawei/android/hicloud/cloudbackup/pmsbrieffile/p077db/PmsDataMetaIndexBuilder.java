package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator;
import fk.C9721b;
import mm.AbstractC11494p;

/* loaded from: classes2.dex */
public abstract class PmsDataMetaIndexBuilder extends AbstractC11494p<PmsMeta> {
    private static final String TAG = "PmsDataMetaIndexBuilder";
    public PmsMetaBaseOperator operator;
    public String tableName;

    public PmsDataMetaIndexBuilder(PmsMetaBaseOperator pmsMetaBaseOperator) {
        this.operator = pmsMetaBaseOperator;
        this.tableName = pmsMetaBaseOperator.getTableName();
    }

    public abstract void build() throws C9721b;

    @Override // mm.AbstractC11494p
    public void create() throws C9721b {
        build();
    }

    @Override // mm.AbstractC11494p
    public void drop() throws C9721b {
        this.operator.dropIdx(getTableName());
    }

    @Override // mm.AbstractC11494p
    public int summary() throws C9721b {
        return this.operator.summary(getTableName());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // mm.AbstractC11494p
    public PmsMeta query(int i10) throws C9721b {
        return this.operator.query(this.tableName, getTableName(), i10);
    }
}
