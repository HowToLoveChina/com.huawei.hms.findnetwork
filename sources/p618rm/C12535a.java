package p618rm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.core.content.p019pm.PackageInfoCompat;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppCreate;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import fk.C9721b;
import hm.C10321z;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0241z;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;
import sl.C12812c;
import sl.C12815f;
import za.C14164a;

/* renamed from: rm.a */
/* loaded from: classes6.dex */
public class C12535a {

    /* renamed from: a */
    public final C4879a f57867a;

    /* renamed from: b */
    public final String f57868b;

    /* renamed from: c */
    public final String f57869c;

    public C12535a(C4879a c4879a, String str, String str2) {
        this.f57867a = c4879a;
        this.f57868b = str;
        this.f57869c = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0146, code lost:
    
        r4 = new java.util.ArrayList();
        r19 = r30.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x014f, code lost:
    
        r21 = r13;
        r22 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0159, code lost:
    
        if (r19.hasNext() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x015b, code lost:
    
        r20 = r19.next();
        r15 = r20.getUsage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x016b, code lost:
    
        if (com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager.PREFIX_DATABASE_NAME.equalsIgnoreCase(r15) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x016d, code lost:
    
        r14 = new java.lang.StringBuilder();
        r24 = r7;
        r14.append("build attach: ");
        r14.append(r15);
        r14.append(",appId: ");
        r14.append(r1);
        p514o9.C11839m.m70688i("Backup3rdApkUtil", r14.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x018f, code lost:
    
        if ("apk".equalsIgnoreCase(r15) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0195, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x019f, code lost:
    
        if (android.text.TextUtils.isEmpty(r20.getAssetId()) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x01a9, code lost:
    
        if (android.text.TextUtils.isEmpty(r20.getVersionId()) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01ab, code lost:
    
        r28.m29405g2("");
        r28.m29350G1("");
        r3.m76934m(r28);
        p514o9.C11839m.m70688i("Backup3rdApkUtil", "build3rdApkAttachments apkattach and apkserverpath all exist return ,appId: " + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x01c8, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x01c9, code lost:
    
        r7 = new sl.C12810a();
        r13 = r7.m76866q(r1).m76847D(r2).m76848E(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x01de, code lost:
    
        if (r20.getLength() == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01e0, code lost:
    
        r14 = r20.getLength().longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01e9, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01eb, code lost:
    
        r13 = r13.m76845B(r14).m76846C(2).m76874y(1).m76867r(r20.getAssetId()).m76849F(r20.getVersionId()).m76868s(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0211, code lost:
    
        if (r20.getHash() != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0213, code lost:
    
        r14 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0215, code lost:
    
        r14 = r20.getHash();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0219, code lost:
    
        r13 = r13.m76875z(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0221, code lost:
    
        if (r20.getSha256() != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0223, code lost:
    
        r14 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0225, code lost:
    
        r14 = r20.getSha256();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0229, code lost:
    
        r13.m76844A(r14);
        r4.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0230, code lost:
    
        r24 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0232, code lost:
    
        r13 = r21;
        r14 = r22;
        r7 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x023a, code lost:
    
        r24 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x023c, code lost:
    
        if (r8 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x023e, code lost:
    
        r28.m29346E1(new com.google.gson.Gson().toJson(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x024e, code lost:
    
        if (r4.isEmpty() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0250, code lost:
    
        r6.batchReplace(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0257, code lost:
    
        if (r27.m29705f1() != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x025d, code lost:
    
        if (r28.mo29370Q() != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0266, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0268, code lost:
    
        r2 = new sl.C12810a();
        r2.m76866q(r1).m76847D(0).m76848E("apk").m76845B(r11).m76846C(2).m76867r(r10).m76874y(0).m76868s(1);
        r6.m76888g(r2);
        r28.m29441u1(r10);
        r28.mo29318b0(3);
        p514o9.C11839m.m70688i("Backup3rdApkUtil", "appId: " + r1 + "contains apkServerPath");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x02b3, code lost:
    
        if (android.text.TextUtils.isEmpty(r24) != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02b5, code lost:
    
        r2 = new sl.C12810a();
        r2.m76866q(r1).m76847D(0).m76848E("icon").m76845B(r22).m76846C(2).m76867r(r24).m76874y(0).m76868s(1);
        r6.m76888g(r2);
        r28.m29376S1(r24);
        r28.mo29318b0(3);
        p514o9.C11839m.m70688i("Backup3rdApkUtil", "appId: " + r1 + "contains iconServerPath");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0302, code lost:
    
        r28.mo29316a0(r21).m29447w1(r17).m29439t2(java.lang.String.valueOf(r18));
        r28.m29363M1(java.lang.String.valueOf(r16));
        r28.mo29321d0(r11);
        r3.m76934m(r28);
        p514o9.C11839m.m70688i("Backup3rdApkUtil", "build3rdApkAttachment end, appId = " + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0336, code lost:
    
        return;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m75457b(com.huawei.hicloud.cloudbackup.p104v3.core.C4879a r27, com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus r28, java.lang.String r29, java.util.List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment> r30) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 823
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p618rm.C12535a.m75457b(com.huawei.hicloud.cloudbackup.v3.core.a, com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus, java.lang.String, java.util.List):void");
    }

    /* renamed from: d */
    public static String m75458d(String str) {
        try {
            String splitOriAppId = SplitAppUtil.getSplitOriAppId(str);
            PackageInfo packageInfo = m75459e().getPackageManager().getPackageInfo(splitOriAppId, 64);
            if (packageInfo == null) {
                C11839m.m70689w("Backup3rdApkUtil", "error in getAppSignSha256, packageInfo is null");
                return "";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length != 0) {
                String strM75460h = m75460h(C14164a.m85026e(signatureArr[0].toCharsString()));
                C11839m.m70686d("Backup3rdApkUtil", "getAppSSha2: " + splitOriAppId + " sha: " + strM75460h);
                if (!TextUtils.isEmpty(strM75460h)) {
                    return strM75460h;
                }
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02008"), "02008", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66635A("appId: " + splitOriAppId + " appSSha2 is empty");
                c11060cM66626a.m66663s(splitOriAppId);
                c11060cM66626a.m66665u("001_1011");
                c11060cM66626a.m66668x("1");
                C13622a.m81968n(m75459e(), c11060cM66626a);
                return "";
            }
            C11839m.m70689w("Backup3rdApkUtil", "signatures do not exist!");
            return "";
        } catch (Exception unused) {
            C11839m.m70689w("Backup3rdApkUtil", "getAppSignSha256 catch a exception");
            return "";
        }
    }

    /* renamed from: e */
    public static Context m75459e() {
        return C0213f.m1377a();
    }

    /* renamed from: h */
    public static String m75460h(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            StringBuilder sb2 = new StringBuilder(256);
            for (byte b10 : messageDigest.digest()) {
                sb2.append(String.format(Locale.ENGLISH, "%02X", Byte.valueOf(b10)));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            AbstractC10896a.m65886e("Backup3rdApkUtil", "sha256EncryptStr error:NoSuchAlgorithmException");
            return null;
        } catch (IllegalFormatException unused2) {
            AbstractC10896a.m65886e("Backup3rdApkUtil", "sha256EncryptStr error:IllegalFormatException");
            return null;
        } catch (Exception unused3) {
            AbstractC10896a.m65886e("Backup3rdApkUtil", "sha256EncryptStr error:Exception");
            return null;
        }
    }

    /* renamed from: i */
    public static String m75461i(Map<String, String> map, String str) {
        String str2 = map.get(str);
        return str2 == null ? "" : str2;
    }

    /* renamed from: j */
    public static boolean m75462j(String str, int i10) {
        C12812c c12812c = new C12812c();
        return (c12812c.m76886e(str, "apk", i10) != null) && (c12812c.m76886e(str, "icon", i10) != null) && (c12812c.m76886e(str, "xml", i10) != null);
    }

    /* renamed from: a */
    public boolean m75463a(CloudBackupStatus cloudBackupStatus) {
        try {
            String strM29628C0 = this.f57867a.m29628C0();
            boolean zM75873l1 = C12590s0.m75873l1(this.f57867a.m29631D0());
            C12815f c12815f = new C12815f(this.f57867a.m29713i0());
            boolean z10 = this.f57867a.isRefurbishment() || C12590s0.m75811W0(this.f57867a.m29657P0(), this.f57867a.m29626B0());
            if (zM75873l1 && z10 && m75466g()) {
                App appM75464c = m75464c(cloudBackupStatus, strM29628C0);
                if (!TextUtils.isEmpty(appM75464c.getId())) {
                    cloudBackupStatus.m29405g2(appM75464c.getId());
                    cloudBackupStatus.m29350G1(appM75464c.isReuseFileCheck() ? "1" : "0");
                    c12815f.m76934m(cloudBackupStatus);
                    m75457b(this.f57867a, cloudBackupStatus, strM29628C0, appM75464c.getAttachments());
                    if (!TextUtils.isEmpty(cloudBackupStatus.m29398d1()) && m75462j(this.f57868b, cloudBackupStatus.m29861N())) {
                        C11839m.m70688i("Backup3rdApkUtil", "copy app record id: " + appM75464c.getId() + ", app: " + this.f57868b + " ,isReuseFileCheck:" + appM75464c.isReuseFileCheck());
                        return true;
                    }
                }
                C11839m.m70688i("Backup3rdApkUtil", "getAttachments error, appId = " + this.f57868b + ", attachments size = " + appM75464c.getAttachments().size());
            }
        } catch (Exception e10) {
            C11839m.m70689w("Backup3rdApkUtil", "backupDeviceBakAppCopy exception. appId = " + this.f57868b + ", " + e10.getMessage());
        }
        return false;
    }

    /* renamed from: c */
    public App m75464c(CloudBackupStatus cloudBackupStatus, String str) throws C9721b {
        String strM29734p0 = this.f57867a.m29734p0();
        String strM29719k0 = this.f57867a.m29719k0();
        String strM29713i0 = this.f57867a.m29713i0();
        AppCreate appCreate = new AppCreate();
        appCreate.setApkType(Integer.valueOf(cloudBackupStatus.m29872f())).setBackupAppName(this.f57868b).setBackupDeviceId(strM29719k0).setBackupRecordId(strM29734p0).setBackupVersion(CBSBaseReq.CURRENT_API_VERSION).setCreateTime(new C4644l(System.currentTimeMillis())).setFileCount(Integer.valueOf(cloudBackupStatus.m29877l())).setAppTotalSize(Long.valueOf(cloudBackupStatus.m29875i())).setPackageVersion(cloudBackupStatus.m29407h1()).setPackageFileName(this.f57868b + ".apk").setIconFileName(this.f57868b + ".icon").setRuntimeType(Integer.valueOf(cloudBackupStatus.m29400e1()));
        if (cloudBackupStatus.mo29370Q()) {
            appCreate.setSplitApkType(cloudBackupStatus.mo29357K());
        }
        App appM63541E = new C10321z(strM29713i0, this.f57867a.m29636F0(), this.f57867a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f57867a.m29654O0()).m63541E(this.f57867a.m29728n0(), strM29719k0, strM29734p0, str, m75465f(str, this.f57868b), appCreate, m75458d(this.f57869c), 0);
        if (appM63541E == null || appM63541E.getAttachments() == null || appM63541E.getAttachments().isEmpty()) {
            throw new C9721b(3912, "copy apk attachments failed, app getAttachments is null", "Backup3rdApkUtil");
        }
        return appM63541E;
    }

    /* renamed from: f */
    public final String m75465f(String str, String str2) {
        String id2 = "";
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List<App> list = this.f57867a.m29704f0().get(str);
            if (list != null) {
                Iterator<App> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    App next = it.next();
                    String backupAppName = next.getBackupAppName();
                    if (!TextUtils.isEmpty(backupAppName) && TextUtils.equals(backupAppName, str2)) {
                        id2 = next.getId();
                        break;
                    }
                }
            }
            C11839m.m70688i("Backup3rdApkUtil", "get last success app record id: " + id2);
        }
        return id2;
    }

    /* renamed from: g */
    public boolean m75466g() {
        long jM1688f;
        long longVersionCode;
        boolean z10;
        String strM29628C0;
        String installerPackageName = "";
        long j10 = 0;
        try {
            PackageManager packageManager = m75459e().getPackageManager();
            longVersionCode = PackageInfoCompat.getLongVersionCode(packageManager.getPackageInfo(this.f57869c, 16384));
            try {
                installerPackageName = packageManager.getInstallerPackageName(this.f57869c);
                strM29628C0 = this.f57867a.m29628C0();
            } catch (Exception e10) {
                e = e10;
                jM1688f = 0;
            }
        } catch (Exception e11) {
            e = e11;
            jM1688f = 0;
        }
        if (C12590s0.m75873l1(this.f57867a.m29631D0())) {
            List<App> list = this.f57867a.m29704f0().get(strM29628C0);
            if (list == null) {
                C11839m.m70688i("Backup3rdApkUtil", "get backupVersionCode appList = null , lastBackupId = " + strM29628C0);
                return false;
            }
            jM1688f = 0;
            for (App app : list) {
                try {
                    String backupAppName = app.getBackupAppName();
                    if (!TextUtils.isEmpty(backupAppName) && TextUtils.equals(backupAppName, this.f57868b)) {
                        jM1688f = C0241z.m1688f(app.getPackageVersion());
                        if (longVersionCode != 0 && longVersionCode <= jM1688f) {
                            C11839m.m70688i("Backup3rdApkUtil", "subSource: " + installerPackageName + ", curVersionCode: " + longVersionCode + ", backupVersionCode: " + jM1688f + ", isMatch: true , appId: " + this.f57868b);
                            z10 = true;
                            j10 = jM1688f;
                            break;
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                    j10 = longVersionCode;
                    C11839m.m70688i("Backup3rdApkUtil", "get backupVersionCode error, " + e.getMessage());
                    longVersionCode = j10;
                    j10 = jM1688f;
                    z10 = false;
                    C11839m.m70688i("Backup3rdApkUtil", "subSource: " + installerPackageName + ", curVersionCode: " + longVersionCode + ", backupVersionCode: " + j10 + ", isMatch: false , appId: " + this.f57868b);
                    return z10;
                }
            }
            j10 = jM1688f;
            z10 = false;
        } else {
            z10 = false;
        }
        C11839m.m70688i("Backup3rdApkUtil", "subSource: " + installerPackageName + ", curVersionCode: " + longVersionCode + ", backupVersionCode: " + j10 + ", isMatch: false , appId: " + this.f57868b);
        return z10;
    }
}
