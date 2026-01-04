package com.huawei.android.hicloud.cloudbackup.snapshottree.method;

import com.huawei.android.hicloud.cloudbackup.snapshottree.bean.SnapshotNode;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import fk.C9721b;
import java.util.List;

/* loaded from: classes2.dex */
public interface SnapshotTreeInterface {
    List<SnapshotBackupMeta> addTree(String str, SnapshotNode snapshotNode, String str2) throws C9721b;

    void deleteNode(String str, String str2, String str3, String str4) throws C9721b;

    SnapshotBackupMeta getRootNode(String str, String str2) throws C9721b;

    List<SnapshotBackupMeta> getRoots(String str) throws C9721b;

    void updateCache(String str, String str2, String str3) throws C9721b;
}
