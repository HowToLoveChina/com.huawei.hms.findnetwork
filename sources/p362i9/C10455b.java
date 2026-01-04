package p362i9;

import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudspace.bean.TotalStorageInfo;
import com.huawei.hicloud.base.bean.CloudSpace;
import p514o9.C11839m;
import p581qk.AbstractC12368e;
import p684un.C13225d;
import p703v8.C13368e;

/* renamed from: i9.b */
/* loaded from: classes3.dex */
public class C10455b extends AbstractC12368e {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("CloseSwitchTask", "closeSwitchTask");
        long jQueryinitopentime = new SettingOperator().queryinitopentime();
        CloudSpace cloudSpace = new CloudSpace();
        TotalStorageInfo totalInfo = C13368e.m80184F().m80226P().getTotalInfo();
        if (totalInfo != null) {
            long totalSize = totalInfo.getTotalSize();
            long usedSize = totalInfo.getUsedSize();
            C11839m.m70688i("CloseSwitchTask", "exit reportCloseCloudBackup: totalSize=" + totalSize + ", usedSize=" + usedSize);
            cloudSpace.setTotal(totalSize);
            cloudSpace.setUsed(usedSize);
        }
        C13225d.m79490f1().m79601y0(jQueryinitopentime, cloudSpace);
    }
}
