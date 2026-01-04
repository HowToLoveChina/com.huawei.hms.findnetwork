package p840zd;

import android.content.pm.PackageManager;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppSwitchStatusBean;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.util.AppDataSizeUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataManager;
import com.huawei.gson.Gson;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p618rm.C12586r;
import p618rm.C12590s0;

/* renamed from: zd.e1 */
/* loaded from: classes3.dex */
public class C14204e1 extends AbstractC12367d {

    /* renamed from: a */
    public final C14229k2 f63388a = new C14229k2();

    /* renamed from: b */
    public final Vector<BackupAppSwitchStatusBean> f63389b;

    public C14204e1(Vector<BackupAppSwitchStatusBean> vector) {
        this.f63389b = vector;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws PackageManager.NameNotFoundException, IOException {
        C11839m.m70688i("TempBackupGetAppDataTask", "begin get app data size task");
        List<BackupOptionItem> listM78399w = this.f63388a.m78399w("thirdAppData");
        if (listM78399w != null && !listM78399w.isEmpty()) {
            List<String> listM16188x = C2783d.m16188x(C0213f.m1377a());
            PackageManager packageManager = C0213f.m1377a().getPackageManager();
            boolean zM75901s1 = C12590s0.m75901s1();
            for (BackupOptionItem backupOptionItem : listM78399w) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!listM16188x.contains(backupOptionItem.getOriBackupAppName())) {
                    this.f63388a.m78386g(backupOptionItem.getAppId());
                } else if (backupOptionItem.isBackupData()) {
                    setAppDataSize(backupOptionItem, ICBUtil.getVersionCode(packageManager, backupOptionItem.getOriBackupAppName()), zM75901s1);
                    backupOptionItem.setIsDataEnable(2);
                    BackupOptionItem backupOptionItemM78401y = this.f63388a.m78401y(backupOptionItem.getAppId());
                    backupOptionItem.setOperateTime(backupOptionItemM78401y.getOperateTime());
                    backupOptionItem.setBackupSwitch(backupOptionItemM78401y.getBackupSwitch());
                    backupOptionItem.setOperateType(backupOptionItemM78401y.getOperateType());
                    this.f63388a.m78382Q(backupOptionItem);
                    TempBackupDataManager.m24501i().m24504f(backupOptionItem);
                    CloudBackupReport.collectModuleInfo(this.f63389b, backupOptionItem.getAppId(), backupOptionItem, jCurrentTimeMillis);
                    C11839m.m70688i("TempBackupGetAppDataTask", "get third app dataSize, appId = " + backupOptionItem.getAppId() + ", time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", values: " + new Gson().toJson(backupOptionItem));
                }
            }
        }
        C11839m.m70688i("TempBackupGetAppDataTask", "end get app data size task");
        TempBackupDataManager.m24501i().m24505g(this.f63388a.m78399w("thirdAppData"));
        C11839m.m70688i("TempBackupGetAppDataTask", String.format(Locale.ENGLISH, "complete scan third data size, apps are %s", new Gson().toJson(this.f63388a.m78397u())));
        new SettingOperator().replace(new Settings[]{new Settings("thirdAppInitTime", String.valueOf(System.currentTimeMillis()), "2")});
        C11839m.m70688i("TempBackupGetAppDataTask", "complete scan third data size");
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.OPTIONS_SIZE_TASK;
    }

    public final void setAppDataSize(BackupOptionItem backupOptionItem, long j10, boolean z10) throws PackageManager.NameNotFoundException {
        long j11;
        long j12;
        long j13 = 0;
        try {
            CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(backupOptionItem.getOriBackupAppName(), C12586r.m75711b(), j10, false, true);
            if (cloudBackupAppDataUtil.isAppDataAble() && PmsCheckUtil.m12611e()) {
                if (backupOptionItem.getUid() != 0) {
                    cloudBackupAppDataUtil.changeToSeparaSetting(backupOptionItem.getUid());
                }
                ScanAppDataUtil scanAppDataUtil = new ScanAppDataUtil(backupOptionItem.getAppId(), backupOptionItem.getUid(), backupOptionItem.getOriBackupAppName(), cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude());
                long[] jArr = scanAppDataUtil.get3rdAppDataSizeInfo(cloudBackupAppDataUtil, z10, backupOptionItem, scanAppDataUtil);
                long j14 = jArr[0];
                try {
                    j12 = jArr[1];
                } catch (C9721b e10) {
                    e = e10;
                    j12 = 0;
                    j13 = j14;
                    j11 = 0;
                }
                try {
                    j13 = jArr[2];
                    backupOptionItem.setBackupData(true);
                    j13 = j14;
                    j11 = j13;
                } catch (C9721b e11) {
                    e = e11;
                    long j15 = j13;
                    j13 = j14;
                    j11 = j15;
                    C11839m.m70687e("TempBackupGetAppDataTask", "getAppDataSize error, msg: " + e.getMessage());
                    long jCalculateApkSize = AppDataSizeUtil.calculateApkSize(C0213f.m1377a(), backupOptionItem.getOriBackupAppName());
                    C11839m.m70688i("TempBackupGetAppDataTask", "getAppDataSize, appId: " + backupOptionItem.getAppId() + " uid: " + backupOptionItem.getUid() + ", dataSize = " + j13 + ", isBackupData: " + backupOptionItem.isBackupData() + " ,apkSize: " + jCalculateApkSize);
                    backupOptionItem.setDataBytes(j13);
                    backupOptionItem.setCodeBytes(jCalculateApkSize);
                    backupOptionItem.setData2(String.valueOf(j12));
                    backupOptionItem.setData3(String.valueOf(j11));
                }
            } else {
                backupOptionItem.setBackupData(false);
                j11 = 0;
                j12 = 0;
            }
        } catch (C9721b e12) {
            e = e12;
            j11 = 0;
            j12 = 0;
        }
        long jCalculateApkSize2 = AppDataSizeUtil.calculateApkSize(C0213f.m1377a(), backupOptionItem.getOriBackupAppName());
        C11839m.m70688i("TempBackupGetAppDataTask", "getAppDataSize, appId: " + backupOptionItem.getAppId() + " uid: " + backupOptionItem.getUid() + ", dataSize = " + j13 + ", isBackupData: " + backupOptionItem.isBackupData() + " ,apkSize: " + jCalculateApkSize2);
        backupOptionItem.setDataBytes(j13);
        backupOptionItem.setCodeBytes(jCalculateApkSize2);
        backupOptionItem.setData2(String.valueOf(j12));
        backupOptionItem.setData3(String.valueOf(j11));
    }
}
