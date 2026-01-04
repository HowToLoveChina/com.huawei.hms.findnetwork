package dm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.PmsUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p618rm.C12571m;
import p618rm.C12583q;
import p709vj.C13452e;
import p746wn.C13622a;
import p848zl.C14333b;
import sl.C12816g;

/* renamed from: dm.j1 */
/* loaded from: classes6.dex */
public class C9220j1 {

    /* renamed from: a */
    public C4880b f46314a;

    /* renamed from: b */
    public C12816g f46315b;

    /* renamed from: c */
    public CloneService f46316c;

    /* renamed from: d */
    public String f46317d;

    /* renamed from: f */
    public String f46319f;

    /* renamed from: g */
    public String f46320g;

    /* renamed from: i */
    public int f46322i;

    /* renamed from: e */
    public String f46318e = RestoreCache.getInstance().getEntranceOfRestore();

    /* renamed from: h */
    public Context f46321h = C0213f.m1377a();

    public C9220j1(C4880b c4880b, CloneService cloneService, C12816g c12816g, String str, String str2) {
        this.f46314a = c4880b;
        this.f46315b = c12816g;
        this.f46316c = cloneService;
        this.f46319f = str;
        this.f46320g = str2;
        this.f46317d = c4880b.m29783R();
        this.f46322i = c4880b.getEntryType();
    }

    /* renamed from: b */
    public static Bundle m57963b(Bundle bundle, boolean z10, boolean z11) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("is_notepad_support_tar", FaqConstants.DISABLE_HA_REPORT);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle("Memo", bundle2);
        bundle.putBundle("AllModulesAbility", bundle3);
        bundle.putBoolean("isMemoUsePmsTar", z10);
        bundle.putBoolean("isSupportTar", true);
        bundle.putBoolean("isNewPhonePmsSupportDecompressTarByPath", z11);
        return bundle;
    }

    /* renamed from: a */
    public final boolean m57964a(String str) {
        if (!TextUtils.equals(str, "chatSms") || !PmsUtils.isSupportNewRYFeature()) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C12583q.m75674j(1));
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str);
        File fileM63442h = C10278a.m63442h(sb2.toString() + ICBUtil.ANDROID + ICBUtil.ANDROID_DATA);
        return fileM63442h.exists() && fileM63442h.listFiles() != null;
    }

    /* renamed from: c */
    public final void m57965c(String str) throws IOException {
        File[] fileArrListFiles;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C12583q.m75674j(1));
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str);
        File fileM63442h = C10278a.m63442h(sb2.toString());
        if (fileM63442h.exists()) {
            if (TextUtils.equals(str, "chatSms")) {
                str = "com.android.providers.telephony";
            }
            File fileM63441g = C10278a.m63441g(C10278a.m63437c(fileM63442h), str);
            C11839m.m70686d("CloudRestoreV3ModuleCloneRestore", "rootDir rename result: " + fileM63442h.renameTo(fileM63441g));
            String str3 = C10279b.m63452a(fileM63441g) + ICBUtil.ANDROID + ICBUtil.ANDROID_DATA;
            File[] fileArrListFiles2 = C10278a.m63442h(str3).listFiles();
            if (fileArrListFiles2 == null || fileArrListFiles2.length <= 0) {
                C11839m.m70687e("CloudRestoreV3ModuleCloneRestore", "checkDataCopy file length zero");
                return;
            }
            BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(this.f46321h, this.f46314a, this.f46319f);
            File fileM63442h2 = C10278a.m63442h(str3);
            if (fileM63442h2.exists() && fileM63442h2.listFiles() != null && fileM63442h2.listFiles().length > 0 && (fileArrListFiles = fileM63442h2.listFiles()) != null && fileArrListFiles.length > 0) {
                File fileM63441g2 = C10278a.m63441g(fileM63442h2, str + ".txt");
                if (!fileM63441g2.exists()) {
                    try {
                        C11839m.m70686d("CloudRestoreV3ModuleCloneRestore", "create pms txt file result = " + fileM63441g2.createNewFile());
                    } catch (IOException e10) {
                        C11839m.m70687e("CloudRestoreV3ModuleCloneRestore", "create pms txt file error: " + e10.toString());
                    }
                }
                int iPmsRestore = backupRestoreUtil.pmsRestore(C10279b.m63452a(fileM63442h2), C12583q.m75670f(0, ICBUtil.ANDROID_DATA, str), 0);
                C11839m.m70688i("CloudRestoreV3ModuleCloneRestore", "pms restore code: " + iPmsRestore);
                File fileM63437c = C10278a.m63437c(fileM63442h2);
                if (iPmsRestore == 0) {
                    C12571m.m75547i(C10279b.m63452a(fileM63437c));
                }
            }
            C11839m.m70686d("CloudRestoreV3ModuleCloneRestore", "tempMappingPath rename result: " + fileM63441g.renameTo(fileM63442h));
            if (!fileM63442h.exists() || fileM63442h.listFiles() == null || fileM63442h.listFiles().length > 0) {
                return;
            }
            C12571m.m75547i(C10279b.m63452a(fileM63442h));
        }
    }

    /* renamed from: d */
    public final void m57966d(CloudRestoreStatusV3 cloudRestoreStatusV3, String str, CloneService.CloneErr cloneErr) throws C9721b {
        if (cloneErr.retCode == 15) {
            throw new C9721b(1007, "CloneService return fail, retcode: " + cloneErr.retCode + " | appid: " + str, "doRestoreOneModule");
        }
        if (cloneErr.isBundleAppRestore && cloudRestoreStatusV3.getStatus() == 6 && cloudRestoreStatusV3.getType() == 1) {
            C11839m.m70688i("CloudRestoreV3ModuleCloneRestore", "bundle app already install success :" + str);
            return;
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.f46317d, "restoreOneModuleError", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_2002");
        c11060cM66626a.m66635A("appId=" + str + "&type=" + cloudRestoreStatusV3.getType() + "&status=" + cloudRestoreStatusV3.getStatus() + "&retCode=" + cloneErr.retCode + "&entryType=" + this.f46322i + "&entranceOfRestore=" + this.f46318e + "&isBundleApp=" + cloneErr.isBundleAppRestore + "&versionCode=" + cloudRestoreStatusV3.getVersionCode() + "&localversion=" + cloudRestoreStatusV3.m29466K());
        C13622a.m81968n(this.f46321h, c11060cM66626a);
        this.f46315b.m76955s(str, String.valueOf(cloneErr.retCode), "clone service return fail");
    }

    /* renamed from: e */
    public final CloneService.CloneErr m57967e(Bundle bundle, String str, CloneService.CloneCallback cloneCallback) throws C9721b {
        return m57968f(bundle, str, cloneCallback, this.f46320g + "/" + str + "/apk/", this.f46320g + "/" + str + ".apk");
    }

    /* renamed from: f */
    public final CloneService.CloneErr m57968f(Bundle bundle, String str, CloneService.CloneCallback cloneCallback, String str2, String str3) throws Throwable {
        CloneService.CloneErr cloneErr = new CloneService.CloneErr();
        cloneErr.isSuccess = false;
        cloneErr.isBundleAppRestore = true;
        File fileM63442h = C10278a.m63442h(str3);
        File fileM63442h2 = C10278a.m63442h(str2);
        if (!fileM63442h.exists()) {
            C11839m.m70689w("CloudRestoreV3ModuleCloneRestore", "restoreBundleApp apkOldFile not exist " + str);
            String[] list = fileM63442h2.list();
            cloneErr.retCode = FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH;
            return (!fileM63442h2.exists() || list == null || list.length <= 0) ? cloneErr : this.f46316c.doRestoreOneModule(str, this.f46319f, bundle, cloneCallback);
        }
        try {
            C12571m.m75547i(str2);
            TarFileUtil.unTarAll(fileM63442h, str2);
            C11839m.m70688i("CloudRestoreV3ModuleCloneRestore", "untar success " + str);
            if (!fileM63442h.delete()) {
                C11839m.m70687e("CloudRestoreV3ModuleCloneRestore", "apkFile delete failed");
            }
            return this.f46316c.doRestoreOneModule(str, this.f46319f, bundle, cloneCallback);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreV3ModuleCloneRestore", "untar error: " + e10.toString());
            cloneErr.retCode = e10.m60659c();
            return cloneErr;
        }
    }

    /* renamed from: g */
    public void m57969g(CloudRestoreStatusV3 cloudRestoreStatusV3, CloneService.CloneCallback cloneCallback) throws C9721b, IOException {
        CloneService.CloneErr cloneErrDoRestoreOneModule;
        String appId = cloudRestoreStatusV3.getAppId();
        boolean zM57964a = m57964a(appId);
        Bundle bundleM57970h = m57970h(cloudRestoreStatusV3, this.f46319f, zM57964a);
        if (bundleM57970h == null) {
            return;
        }
        this.f46314a.isRelease();
        if (cloudRestoreStatusV3.m29480R()) {
            cloneErrDoRestoreOneModule = m57967e(bundleM57970h, appId, cloneCallback);
        } else if (cloudRestoreStatusV3.m29482S()) {
            cloneErrDoRestoreOneModule = m57971i(bundleM57970h, appId, cloneCallback);
        } else {
            if (zM57964a) {
                m57965c(appId);
            }
            cloneErrDoRestoreOneModule = this.f46316c.doRestoreOneModule(appId, this.f46319f, bundleM57970h, cloneCallback);
        }
        C11839m.m70688i("CloudRestoreV3ModuleCloneRestore", "clone restore " + appId + " result isSuccess = " + cloneErrDoRestoreOneModule.isSuccess + ",retCode = " + cloneErrDoRestoreOneModule.retCode + ",failedNum: " + cloneErrDoRestoreOneModule.failedRecordsNum);
        this.f46314a.isRelease();
        if (cloneErrDoRestoreOneModule.isSuccess) {
            cloudRestoreStatusV3.setDoneStatusAndType(1, cloudRestoreStatusV3.getType());
        } else {
            m57966d(cloudRestoreStatusV3, appId, cloneErrDoRestoreOneModule);
        }
    }

    /* renamed from: h */
    public Bundle m57970h(CloudRestoreStatusV3 cloudRestoreStatusV3, String str, boolean z10) {
        String appId = cloudRestoreStatusV3.getAppId();
        Bundle bundle = new Bundle();
        bundle.putInt(CloneService.KEY_ACTION_FLAG, 11);
        if (cloudRestoreStatusV3.is3rdAppType()) {
            if (!cloudRestoreStatusV3.m29484T()) {
                cloudRestoreStatusV3.setDoneStatusAndType(1, cloudRestoreStatusV3.getType());
                return null;
            }
            if (C10278a.m63440f(C10278a.m63442h(str + "/" + appId)) != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt(appId, 1);
                bundle.putBundle("app", bundle2);
                return bundle;
            }
            C11839m.m70688i("CloudRestoreV3ModuleCloneRestore", "restoreCloneBundle error, " + appId + " file list is null.");
            return null;
        }
        if (HNConstants.DataType.CONTACT.equals(appId)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("AccountName", "Phone");
            bundle3.putString("AccountType", "com.android.huawei.phone");
            Bundle bundle4 = new Bundle();
            bundle4.putBundle("0", bundle3);
            bundle.putBundle(HNConstants.DataType.CONTACT, bundle4);
            return bundle;
        }
        if (C14333b.m85491z().contains(appId)) {
            if (z10) {
                return bundle;
            }
            C11839m.m70686d("CloudRestoreV3ModuleCloneRestore", "put media restore key!");
            bundle.putInt("key_media_restore_location", 2);
            return bundle;
        }
        if (!"Memo".equalsIgnoreCase(appId) || !"clonePmsFlag".equals(cloudRestoreStatusV3.getData1())) {
            return bundle;
        }
        Bundle bundleM57963b = m57963b(bundle, PmsCheckUtil.m12614h(), C2153l.m13045g0());
        bundleM57963b.putBoolean("isPmsBackupMemoData", true);
        return bundleM57963b;
    }

    /* renamed from: i */
    public final CloneService.CloneErr m57971i(Bundle bundle, String str, CloneService.CloneCallback cloneCallback) throws C9721b {
        return m57968f(bundle, str, cloneCallback, this.f46319f + "/" + str + "/hap/", this.f46320g + "/" + str + ".apk");
    }
}
