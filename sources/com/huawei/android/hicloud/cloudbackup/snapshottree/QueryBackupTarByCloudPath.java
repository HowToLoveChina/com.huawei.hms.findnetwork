package com.huawei.android.hicloud.cloudbackup.snapshottree;

import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import fk.C9721b;
import java.util.List;

/* loaded from: classes2.dex */
public class QueryBackupTarByCloudPath extends QueryBackupMeta {
    private String cloudPath;

    public QueryBackupTarByCloudPath(String str, String str2, String str3) throws C9721b {
        super(str, str2);
        this.cloudPath = str3;
        this.allSize = this.mMetaOperator.queryMetasSizeByCloudPath(str3, str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMeta
    public long initAllSize(String str) {
        return 0L;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMeta
    public List<SnapshotBackupMeta> queryBylimit(String str, long j10, long j11) throws C9721b {
        return this.mMetaOperator.queryMetasTarByCloudPathLimit(this.cloudPath, str, j10, j11);
    }
}
