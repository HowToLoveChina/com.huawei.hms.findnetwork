package com.huawei.android.hicloud.cloudbackup.process.task;

import android.database.SQLException;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.hicloud.request.opengw.bean.MakeFileReq;
import fk.C9721b;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import to.C13049a;

/* loaded from: classes2.dex */
public class CloudBackupOneCreateTask extends CloudBackupBaseTask {
    private static final String TAG = "CloudBackupMakeFileTask";
    private String appId;
    private String backupId;
    private CloudBackupOneCreateCallback callback;
    private List<String> pathList;
    private List<MakeFileReq> requestList;
    private String traceID;

    public interface CloudBackupOneCreateCallback {
        void onError(C9721b c9721b);
    }

    public CloudBackupOneCreateTask(String str, String str2, String str3, List<MakeFileReq> list, List<String> list2, CloudBackupOneCreateCallback cloudBackupOneCreateCallback) {
        this.appId = str;
        this.traceID = str2;
        this.backupId = str3;
        this.requestList = list;
        this.pathList = list2;
        this.callback = cloudBackupOneCreateCallback;
    }

    private void fixMkFileError(String str, C9721b c9721b) throws SQLException {
        if (c9721b.m60659c() == 4002 || c9721b.m60659c() == 3207) {
            SnapshotTreeManagementService.getInstance().defaultRootNodeStatus(str, this.backupId);
            C11839m.m70689w(TAG, "fixMkFileError, appId = " + str);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        try {
            try {
                new C13049a(EnumC12999a.CLOUD_BACKUP, this.traceID).m78720V(this.requestList, null);
                SnapshotTreeManagementService snapshotTreeManagementService = SnapshotTreeManagementService.getInstance();
                Iterator<String> it = this.pathList.iterator();
                while (it.hasNext()) {
                    snapshotTreeManagementService.updateLeafNodeStatusByAppIdAndCloudPath(5, it.next(), this.appId, this.backupId);
                }
            } catch (C9721b e10) {
                fixMkFileError(this.appId, e10);
                this.callback.onError(e10);
            }
        } finally {
            this.requestList.clear();
            this.pathList.clear();
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void release() {
        CloudBackupCreateManager.getInstance().removeTask(this.appId, this);
    }
}
