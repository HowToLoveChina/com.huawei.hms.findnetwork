package com.huawei.android.hicloud.cloudbackup.process;

import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0213f;
import p429kk.C11058a;
import p514o9.C11839m;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import to.C13049a;

/* loaded from: classes2.dex */
public class CloudBackupCheckTask extends AbstractRunnableC12516b {
    private static final int CHECK_BACKUP_MSG_FAILED = 2;
    private static final String TAG = "CloudBackupCheckTask";
    private Handler mHandler;
    private long incrementSize = 0;
    private List<SnapshotBackupMeta> currentAppMetas = new ArrayList();
    private long repeatCount = 0;
    private String traceID = C11058a.m66627b("02002");
    private C13049a gwService = new C13049a(EnumC12999a.CLOUD_BACKUP, this.traceID);

    public CloudBackupCheckTask(Handler handler) {
        this.mHandler = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        this.incrementSize = CloudBackupService.getInstance().getModuleIncSizeFromOption();
        C11839m.m70688i(TAG, "onStart appsize = " + this.currentAppMetas.size() + " incrementSize = " + this.incrementSize);
        CloudSpace cloudSpaceM78754r = this.gwService.m78754r();
        long total = cloudSpaceM78754r.getTotal() - cloudSpaceM78754r.getUsed();
        C11839m.m70688i(TAG, "quota space total = " + cloudSpaceM78754r.getTotal() + " used = " + cloudSpaceM78754r.getUsed());
        long j10 = this.incrementSize;
        if (total >= j10 || j10 == 0) {
            Message message = new Message();
            message.what = 2;
            this.mHandler.sendMessage(message);
            return;
        }
        C11839m.m70688i(TAG, "service app cloud space start not enough. available = " + total + " backup data size = " + this.incrementSize);
        BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData = new BackupSpaceNotEnoughNeedData();
        backupSpaceNotEnoughNeedData.setTotalNeedSpace(cloudSpaceM78754r.getUsed() + this.incrementSize);
        backupSpaceNotEnoughNeedData.setBackupNeedSpace(this.incrementSize);
        backupSpaceNotEnoughNeedData.setNotUsedSpace(total);
        backupSpaceNotEnoughNeedData.setTotalSpace(cloudSpaceM78754r.getTotal());
        backupSpaceNotEnoughNeedData.setUsedSpace(cloudSpaceM78754r.getUsed());
        long moduleCountFromOption = CloudBackupService.getInstance().getModuleCountFromOption(HNConstants.DataType.MEDIA);
        this.repeatCount = moduleCountFromOption;
        backupSpaceNotEnoughNeedData.setGalleryNum(moduleCountFromOption);
        new UserSpaceUtil(C0213f.m1377a()).serviceApp(backupSpaceNotEnoughNeedData, this.mHandler);
        C11839m.m70689w(TAG, "cloud space not enough. CloudTotalSpace = " + cloudSpaceM78754r.getTotal() + " CloudUsedSpace = " + cloudSpaceM78754r.getUsed() + " current backup size = " + this.incrementSize);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.CACHE;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
