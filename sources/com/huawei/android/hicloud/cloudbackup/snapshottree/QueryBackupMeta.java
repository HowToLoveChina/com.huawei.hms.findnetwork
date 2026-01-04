package com.huawei.android.hicloud.cloudbackup.snapshottree;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.List;

/* loaded from: classes2.dex */
public class QueryBackupMeta {
    private static final int PAGE = 1000;
    private String appId;
    private String backupId;
    protected SnapshotBackupMetaOperator mMetaOperator;
    protected long allSize = 0;
    private long current = 0;

    public QueryBackupMeta(String str, String str2) throws C9721b {
        this.backupId = str2;
        this.appId = str;
        init(str);
    }

    public List<SnapshotBackupMeta> getNext() throws C9721b {
        long j10 = this.current;
        long j11 = this.allSize - j10;
        long j12 = j11 < 1000 ? j11 : 1000L;
        this.current = j10 + j12;
        return queryBylimit(this.appId, j12, j10);
    }

    public long getSize() {
        return this.allSize;
    }

    public boolean hasNext() {
        return this.current <= this.allSize - 1;
    }

    public void init(String str) throws C9721b {
        this.mMetaOperator = new SnapshotBackupMetaOperator(this.backupId);
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "QueryBackupMeta init error appId is empty");
        }
        if (this.mMetaOperator.queryRootNodeMeta(str) != null) {
            this.allSize = initAllSize(str);
            return;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "QueryBackupMeta init error snapshotBackupMeta " + str);
    }

    public long initAllSize(String str) throws C9721b {
        return this.mMetaOperator.queryMetasSizeByAppId(str);
    }

    public List<SnapshotBackupMeta> queryBylimit(String str, long j10, long j11) throws C9721b {
        return this.mMetaOperator.queryMetasByAppIdLimit(str, j10, j11);
    }
}
