package p840zd;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.ArrayList;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: zd.a */
/* loaded from: classes3.dex */
public class C14186a extends AbstractC12367d {

    /* renamed from: a */
    public final C14229k2 f63353a = new C14229k2();

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        PackageManager packageManager;
        try {
            C11839m.m70688i("GetApkInfoTask", "get app info task start");
            packageManager = C0213f.m1377a().getPackageManager();
        } catch (Exception e10) {
            C11839m.m70687e("GetApkInfoTask", "getApkSizeAndIcon Exception: " + e10.toString());
        }
        if (packageManager == null) {
            C11839m.m70689w("GetApkInfoTask", "packageManager is null");
            return;
        }
        ArrayList<BackupOptionItem> arrayList = new ArrayList();
        arrayList.addAll(this.f63353a.m78400x("thirdAppData"));
        arrayList.addAll(this.f63353a.m78400x("thirdApp"));
        for (BackupOptionItem backupOptionItem : arrayList) {
            try {
                if (packageManager.getPackageInfo(backupOptionItem.getOriBackupAppName(), 16384) != null) {
                    long versionCode = ICBUtil.getVersionCode(packageManager, backupOptionItem.getOriBackupAppName());
                    if (TextUtils.isEmpty(backupOptionItem.getData4()) || Long.parseLong(backupOptionItem.getData4()) != versionCode) {
                        CloudBackup3rdIconUtil.cache3rdDrawable(backupOptionItem.getAppId());
                        this.f63353a.m78371F(versionCode, backupOptionItem.getAppId(), backupOptionItem.getUid());
                    }
                }
            } catch (Exception e11) {
                C11839m.m70687e("GetApkInfoTask", backupOptionItem.getAppId() + " Exception: " + e11.toString());
            }
        }
        C11839m.m70688i("GetApkInfoTask", "get app info task end ");
    }
}
