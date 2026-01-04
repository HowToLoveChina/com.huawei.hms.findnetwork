package p840zd;

import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppSwitchStatusBean;
import com.huawei.android.hicloud.cloudbackup.model.VirtualAppFileData;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataManager;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import p015ak.C0241z;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12586r;
import p848zl.C14333b;

/* renamed from: zd.w2 */
/* loaded from: classes3.dex */
public class C14277w2 extends AbstractC12367d {

    /* renamed from: b */
    public CountDownLatch f63497b;

    /* renamed from: c */
    public Vector<String> f63498c;

    /* renamed from: d */
    public final Vector<BackupAppSwitchStatusBean> f63499d;

    /* renamed from: a */
    public final C14229k2 f63496a = new C14229k2();

    /* renamed from: e */
    public final List<String> f63500e = new C12526j().m75387e0();

    public C14277w2(CountDownLatch countDownLatch, Vector<String> vector, Vector<BackupAppSwitchStatusBean> vector2) {
        this.f63497b = countDownLatch;
        this.f63498c = vector;
        this.f63499d = vector2;
    }

    /* renamed from: c */
    public final void m85098c(List<String> list, C12519c c12519c) throws C9721b {
        for (String str : list) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(str, C12586r.m75711b(), 0L, false, true);
            C11839m.m70688i("TempBackupVirtualModuleTask", "<initVirtualAppData> isAppDataAble: " + cloudBackupAppDataUtil.isAppDataAble() + ", appId: " + str);
            if (cloudBackupAppDataUtil.isAppDataAble()) {
                String virtualName = CloudBackupLanguageUtil.getVirtualName(str);
                ScanAppDataUtil scanAppDataUtil = new ScanAppDataUtil(str, cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude());
                C11839m.m70688i("TempBackupVirtualModuleTask", "<initVirtualAppData> scanAppDataUtil: " + new Gson().toJson(scanAppDataUtil));
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                VirtualAppFileData sdcardSize = scanAppDataUtil.getSdcardSize(cloudBackupAppDataUtil, atomicBoolean);
                if (atomicBoolean.get()) {
                    C11839m.m70687e("TempBackupVirtualModuleTask", "initVirtualAppData has exception, do skip。 appId:" + str);
                } else {
                    BackupOptionItem backupOptionItemM78401y = this.f63496a.m78401y(str);
                    if (backupOptionItemM78401y == null) {
                        backupOptionItemM78401y = new BackupOptionItem(str, "virtualApp");
                        backupOptionItemM78401y.setBackupSwitch(this.f63500e.contains(str));
                        backupOptionItemM78401y.setBackupData(true);
                        this.f63496a.m78370E(backupOptionItemM78401y);
                    }
                    if (backupOptionItemM78401y.getOperateType() == 0) {
                        backupOptionItemM78401y.setBackupSwitch(this.f63500e.contains(str));
                    }
                    backupOptionItemM78401y.setParent("virtualApp");
                    backupOptionItemM78401y.setAppName(virtualName);
                    backupOptionItemM78401y.setDataBytes(sdcardSize.getFileSize());
                    backupOptionItemM78401y.setItemTotal(sdcardSize.getFileCount());
                    backupOptionItemM78401y.setIsDataEnable(2);
                    this.f63496a.m78382Q(backupOptionItemM78401y);
                    BackupOptionItem backupOptionItemM78401y2 = this.f63496a.m78401y(str);
                    backupOptionItemM78401y2.setShowType(C0241z.m1685c(c12519c.m75305p(str)));
                    CloudBackupReport.collectModuleInfo(this.f63499d, str, backupOptionItemM78401y2, jCurrentTimeMillis);
                    C11839m.m70688i("TempBackupVirtualModuleTask", "initVirtualAppData" + new Gson().toJson(backupOptionItemM78401y2));
                    TempBackupDataManager.m24501i().m24504f(backupOptionItemM78401y2);
                }
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("TempBackupVirtualModuleTask", "TempBackupVirtualModuleTask start");
        try {
            try {
                C12519c c12519c = new C12519c();
                List<String> listM75297h = c12519c.m75297h(2);
                List<String> listM78398v = this.f63496a.m78398v("virtualApp");
                listM78398v.removeAll(listM75297h);
                this.f63496a.m78387h(listM78398v);
                listM75297h.removeAll(C14333b.m85476k());
                this.f63498c.addAll(listM75297h);
                C11839m.m70688i("TempBackupVirtualModuleTask", "<initVirtualAppData> virtuals: " + listM75297h);
                m85098c(listM75297h, c12519c);
                C11839m.m70688i("TempBackupVirtualModuleTask", "<initVirtualAppData> end.");
            } catch (C9721b e10) {
                C11839m.m70687e("TempBackupVirtualModuleTask", "TempBackupVirtualModuleTask error: " + e10.getMessage());
            }
        } finally {
            C11839m.m70688i("TempBackupVirtualModuleTask", "TempBackupVirtualModuleTask end");
            this.f63497b.countDown();
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.OPTIONS_SIZE_TASK;
    }
}
