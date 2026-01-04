package com.huawei.android.backup.service.logic.installedapps;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2132e;
import com.huawei.android.backup.service.logic.PMSbackupRestoreUtil;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import p006a5.AbstractC0048c;
import p229di.C9153r;
import p386j6.C10715e;
import p544p4.C12086a;
import p699v4.C13334c;
import p699v4.C13345n;

/* renamed from: com.huawei.android.backup.service.logic.installedapps.g */
/* loaded from: classes.dex */
public class C2149g extends C2148f {
    /* renamed from: d1 */
    public final void m12956d1(Context context, String str, int i10) {
        if (m12925D0(context, str, i10)) {
            C2111d.m12647c("BackupInstallTwinAppImp", "clean Data Success:", str);
        }
    }

    /* renamed from: e1 */
    public final void m12957e1(Context context, String str, int i10, String str2) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        File file = new File(str2 + File.separator + this.f9621d + ".tar");
        if (file.exists() && !file.delete()) {
            C2111d.m12648d("BackupInstallTwinAppImp", " file delete failed");
        }
        m12937Q0(i10, context, str, C9153r.m57494b());
    }

    /* renamed from: f1 */
    public final String m12958f1(int i10, String str, String str2, int i11) {
        String str3 = str2 + File.separator + str;
        if (i11 != i10) {
            return str3;
        }
        return str3 + "#TwinApp";
    }

    /* renamed from: g1 */
    public final PMSbackupRestoreUtil m12959g1(Context context, String str, boolean z10) {
        PMSbackupRestoreUtil.m12715i(str, context);
        PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
        pMSbackupRestoreUtil.m12735z(z10);
        if (BackupObject.isSplitTarModule(this.f9621d)) {
            pMSbackupRestoreUtil.m12734y(true);
        }
        return pMSbackupRestoreUtil;
    }

    /* renamed from: h1 */
    public final boolean m12960h1() {
        if (BackupObject.isBothSupportSplitTar() || !"com.tencent.mm".equals(this.f9621d) || !isWechatTwinUsePmsFile()) {
            return true;
        }
        C2111d.m12653i("BackupInstallTwinAppImp", "restore twin app by pms file");
        return false;
    }

    /* renamed from: i1 */
    public final boolean m12961i1(Context context, Handler.Callback callback, Object obj, int i10) {
        if (m12964l1(context, i10)) {
            return true;
        }
        sendMsg(5, 0, 0, callback, obj);
        return false;
    }

    /* renamed from: j1 */
    public final boolean m12962j1(Handler.Callback callback, Object obj, int i10) {
        if (i10 != -1) {
            return true;
        }
        C2111d.m12653i("BackupInstallTwinAppImp", "PMS restore file fail");
        sendMsg(5, 0, 0, callback, obj);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2 */
    @Override // com.huawei.android.backup.service.logic.installedapps.C2148f, com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: k0 */
    public void mo12877k0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws Throwable {
        String str;
        String str2;
        int i10;
        boolean z10;
        String str3;
        int i11;
        int i12;
        int[] iArr;
        boolean z11;
        if (m12963k1(abstractC0048c)) {
            int iM72256c = C12086a.m72256c(context);
            if (m12961i1(context, callback, obj, iM72256c)) {
                String name = this.backupFileModuleInfo.getName();
                m12949c1(name);
                if (m12944X0(context, callback, obj)) {
                    boolean zM12960h1 = m12960h1();
                    PMSbackupRestoreUtil pMSbackupRestoreUtilM12959g1 = m12959g1(context, name, zM12960h1);
                    int[] iArrM72258e = C12086a.m72258e(context);
                    String parent = new File(abstractC0048c.m196n()).getParent();
                    int i13 = 1;
                    int i14 = 0;
                    String length = iArrM72258e.length;
                    while (i14 < length) {
                        int i15 = iArrM72258e[i14];
                        String strM12958f1 = m12958f1(iM72256c, name, parent, i15);
                        try {
                            try {
                                m12956d1(context, name, i15);
                                if (zM12960h1) {
                                    i10 = i14;
                                    z10 = length;
                                    str3 = parent;
                                    i11 = iM72256c;
                                    i12 = i13;
                                } else {
                                    String strM80070i = C13345n.m80070i(context);
                                    i10 = i14;
                                    i11 = iM72256c;
                                    i12 = i13;
                                    z10 = length;
                                    str3 = parent;
                                    try {
                                        m12941U0(context, callback, obj, parent, i15);
                                        i15 = i15;
                                        if (!C12086a.m72263j(strM80070i, name, i15)) {
                                            sendMsg(5, 0, 0, callback, obj);
                                            m12957e1(context, name, i12, strM80070i);
                                            return;
                                        }
                                        strM12958f1 = strM80070i;
                                    } catch (IllegalArgumentException unused) {
                                        strM12958f1 = strM80070i;
                                        i13 = i12;
                                        str2 = name;
                                        C2111d.m12653i("BackupInstallTwinAppImp", "PMS IllegalArgumentException");
                                        m12957e1(context, str2, i13, strM12958f1);
                                        return;
                                    } catch (Exception unused2) {
                                        strM12958f1 = strM80070i;
                                        i13 = i12;
                                        str = name;
                                        C2111d.m12653i("BackupInstallTwinAppImp", "PMS Exception");
                                        m12957e1(context, str, i13, strM12958f1);
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        strM12958f1 = strM80070i;
                                        i13 = i12;
                                        length = name;
                                        m12957e1(context, length, i13, strM12958f1);
                                        throw th;
                                    }
                                }
                                try {
                                    m12842B(context, name, i15);
                                    iArr = iArrM72258e;
                                    z11 = zM12960h1;
                                    length = name;
                                } catch (IllegalArgumentException unused3) {
                                    length = name;
                                } catch (Exception unused4) {
                                    length = name;
                                } catch (Throwable th3) {
                                    th = th3;
                                    length = name;
                                }
                            } catch (IllegalArgumentException unused5) {
                            } catch (Exception unused6) {
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                int iM12730u = pMSbackupRestoreUtilM12959g1.m12730u(name, i15, 0, strM12958f1, null);
                                try {
                                    if (!m12962j1(callback, obj, iM12730u)) {
                                        m12957e1(context, length, iM12730u, strM12958f1);
                                        return;
                                    }
                                    m12957e1(context, length, iM12730u, strM12958f1);
                                    m12946Z0(context, abstractC0048c, callback, obj);
                                    iArrM72258e = iArr;
                                    zM12960h1 = z11;
                                    name = length;
                                    iM72256c = i11;
                                    length = z10;
                                    parent = str3;
                                    i14 = i10 + 1;
                                    i13 = iM12730u;
                                } catch (IllegalArgumentException unused7) {
                                    i13 = iM12730u;
                                    str2 = length;
                                    C2111d.m12653i("BackupInstallTwinAppImp", "PMS IllegalArgumentException");
                                    m12957e1(context, str2, i13, strM12958f1);
                                    return;
                                } catch (Exception unused8) {
                                    i13 = iM12730u;
                                    str = length;
                                    C2111d.m12653i("BackupInstallTwinAppImp", "PMS Exception");
                                    m12957e1(context, str, i13, strM12958f1);
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    i13 = iM12730u;
                                    m12957e1(context, length, i13, strM12958f1);
                                    throw th;
                                }
                            } catch (IllegalArgumentException unused9) {
                                i13 = i12;
                                str2 = length;
                                C2111d.m12653i("BackupInstallTwinAppImp", "PMS IllegalArgumentException");
                                m12957e1(context, str2, i13, strM12958f1);
                                return;
                            } catch (Exception unused10) {
                                i13 = i12;
                                str = length;
                                C2111d.m12653i("BackupInstallTwinAppImp", "PMS Exception");
                                m12957e1(context, str, i13, strM12958f1);
                                return;
                            } catch (Throwable th6) {
                                th = th6;
                                i13 = i12;
                                m12957e1(context, length, i13, strM12958f1);
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: k1 */
    public final boolean m12963k1(AbstractC0048c abstractC0048c) {
        C2111d.m12654j("BackupInstallTwinAppImp", "restore twin app begin:", this.backupFileModuleInfo.getName());
        if (abstractC0048c != null && abstractC0048c.m196n() != null) {
            return true;
        }
        C2111d.m12648d("BackupInstallTwinAppImp", "restoreData : storeHandler or getFullFileName is null");
        return false;
    }

    /* renamed from: l1 */
    public final boolean m12964l1(Context context, int i10) {
        if (!m12864X(context)) {
            C2111d.m12653i("BackupInstallTwinAppImp", "apk not installed, can't restore data");
            return false;
        }
        if (!C12086a.m72261h(context)) {
            C2111d.m12653i("BackupInstallTwinAppImp", "clone user is not exist, can't restore data");
            return false;
        }
        if (m12865Y(context, i10)) {
            return true;
        }
        C2111d.m12653i("BackupInstallTwinAppImp", "twin app is not install");
        if (C12086a.m72260g(context, this.f9621d, i10)) {
            return true;
        }
        C2111d.m12653i("BackupInstallTwinAppImp", "twin app install fail");
        return false;
    }

    /* renamed from: m1 */
    public final void m12965m1(Context context, String str, int[] iArr) {
        for (int i10 : iArr) {
            m12842B(context, str, i10);
        }
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.C2148f, com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: p */
    public void mo12884p(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        boolean z10;
        C2111d.m12653i("BackupInstallTwinAppImp", "backup twin app begin " + this.backupFileModuleInfo.getName());
        String name = this.backupFileModuleInfo.getName();
        int[] iArrM72258e = C12086a.m72258e(context);
        m12965m1(context, name, iArrM72258e);
        if (BackupObject.isSplitTarModule(name)) {
            C2111d.m12654j("BackupInstallTwinAppImp", "[SplitTar], backupData use split tar mode, get tar later ", name);
            return;
        }
        if (!BackupObject.isBothSupportSplitTar() && "com.tencent.mm".equals(this.f9621d) && isWechatTwinUsePmsFile()) {
            C2111d.m12653i("BackupInstallTwinAppImp", "backup twin app by pms file");
            z10 = false;
        } else {
            z10 = true;
        }
        try {
            PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
            pMSbackupRestoreUtil.m12735z(z10);
            C10715e.m65405b(C2132e.m12804K());
            C2111d.m12653i("BackupInstallTwinAppImp", "setPMSAppDataWeight finish , weight: " + C2132e.m12804K());
            int length = iArrM72258e.length;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = iArrM72258e[i10];
                if (pMSbackupRestoreUtil.m12728s(name, 0, i11) == -1) {
                    C2111d.m12653i("BackupInstallTwinAppImp", "PMS backup file fail");
                    sendMsg(2, 0, 0, callback, obj);
                    return;
                } else {
                    if (!z10) {
                        m12951u0(context, i11, callback, obj);
                    }
                }
            }
            mo12954x0(context);
            m12966z0(context, abstractC0048c, callback, obj);
        } catch (IllegalArgumentException unused) {
            C2111d.m12653i("BackupInstallTwinAppImp", "PMS IllegalArgumentException");
        } catch (Exception unused2) {
            C2111d.m12653i("BackupInstallTwinAppImp", "PMS Exception");
        }
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.C2148f
    /* renamed from: x0 */
    public void mo12954x0(Context context) throws PackageManager.NameNotFoundException {
        super.mo12954x0(context);
        this.backupFliedList.addAll(C13334c.m79985r(C13345n.m80070i(context) + this.f9621d + "#TwinApp"));
    }

    /* renamed from: z0 */
    public final void m12966z0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        C2111d.m12653i("BackupInstallTwinAppImp", "backupExternalData");
        C2145c c2145c = new C2145c();
        c2145c.m12907e0();
        c2145c.onBackup(context, abstractC0048c, callback, obj, this.f9621d);
    }
}
