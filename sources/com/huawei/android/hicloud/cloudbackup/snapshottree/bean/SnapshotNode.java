package com.huawei.android.hicloud.cloudbackup.snapshottree.bean;

import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SnapshotNode {
    private SnapshotBackupMeta backupMeta;
    private List<SnapshotNode> childs = new ArrayList();
    private SnapshotNode parent;

    public void addChild(SnapshotNode snapshotNode) {
        getChilds().add(snapshotNode);
    }

    public SnapshotBackupMeta getBackupMeta() {
        return this.backupMeta;
    }

    public List<SnapshotNode> getChilds() {
        if (this.childs == null) {
            this.childs = new ArrayList();
        }
        return this.childs;
    }

    public int getLeafsCount() {
        List<SnapshotNode> list = this.childs;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public SnapshotNode getParent() {
        return this.parent;
    }

    public boolean isLeaf() {
        SnapshotBackupMeta snapshotBackupMeta = this.backupMeta;
        return snapshotBackupMeta != null && snapshotBackupMeta.getRight() - this.backupMeta.getLeft() == 1;
    }

    public void setBackupMeta(SnapshotBackupMeta snapshotBackupMeta) {
        this.backupMeta = snapshotBackupMeta;
    }

    public void setChilds(List<SnapshotNode> list) {
        this.childs = list;
    }

    public void setParent(SnapshotNode snapshotNode) {
        this.parent = snapshotNode;
    }
}
