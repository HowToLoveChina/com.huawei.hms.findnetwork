package com.huawei.android.hicloud.cloudbackup.snapshottree;

import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import fk.C9721b;
import java.util.List;

/* loaded from: classes2.dex */
public class QueryUploadBackupMeta extends QueryBackupMeta {
    public QueryUploadBackupMeta(String str, String str2) throws C9721b {
        super(str, str2);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMeta
    public long initAllSize(String str) throws C9721b {
        return this.mMetaOperator.queryUploadMetasSizeByAppId(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMeta
    public List<SnapshotBackupMeta> queryBylimit(String str, long j10, long j11) throws C9721b {
        return this.mMetaOperator.queryUploadMetasBylimit(str, j10, j11);
    }
}
