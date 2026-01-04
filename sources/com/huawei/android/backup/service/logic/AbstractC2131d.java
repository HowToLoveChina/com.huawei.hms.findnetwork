package com.huawei.android.backup.service.logic;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.backup.service.logic.installedapps.C2148f;
import com.huawei.android.backup.service.logic.installedapps.C2149g;
import com.huawei.android.backup.service.model.BackupFileModuleInfo;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import p006a5.AbstractC0048c;
import p248e5.C9409b;
import p248e5.C9414g;
import p386j6.C10713c;
import p601r4.C12461a;
import p633s5.AbstractC12706c;
import p699v4.C13334c;

/* renamed from: com.huawei.android.backup.service.logic.d */
/* loaded from: classes.dex */
public abstract class AbstractC2131d {
    /* renamed from: A */
    public abstract void mo12772A(C2153l.b bVar);

    /* renamed from: B */
    public void m12773B(C2153l.b bVar) {
        if (bVar == null) {
            C2111d.m12648d("ControlBranch", "setSupportedModuleExtraInfoRaw: cmd is null");
            return;
        }
        for (String str : m12782h()) {
            BackupObject backupObjectMo12792r = mo12792r(str, bVar.f9687c);
            if (backupObjectMo12792r != null) {
                backupObjectMo12792r.setExtraInfo(bVar.f9685a, str);
            }
        }
    }

    /* renamed from: C */
    public abstract void mo12774C(C2153l.b bVar, String str);

    /* renamed from: D */
    public void m12775D(C2153l.b bVar, String str) {
        if (bVar == null || str == null) {
            C2111d.m12648d("ControlBranch", "toNewSessionForSupportedModules: cmd is null");
            return;
        }
        for (String str2 : m12782h()) {
            BackupObject backupObjectMo12792r = mo12792r(str2, bVar.f9687c);
            if (backupObjectMo12792r != null) {
                backupObjectMo12792r.toNewSession(bVar.f9685a, str2, str);
            }
        }
    }

    /* renamed from: b */
    public abstract void mo12776b(C2153l.b bVar);

    /* renamed from: c */
    public int m12777c(C2153l.b bVar, String str, String str2, AbstractC0048c abstractC0048c) {
        return m12778d(bVar, str, str2, abstractC0048c, bVar.f9687c);
    }

    /* renamed from: d */
    public final int m12778d(C2153l.b bVar, String str, String str2, AbstractC0048c abstractC0048c, Handler.Callback callback) {
        C2153l.m13082z(callback, 28, str2);
        BackupObject backupObjectMo12792r = mo12792r(str2, callback);
        if (backupObjectMo12792r == null) {
            C2153l.m13082z(callback, 2, str2);
            return 0;
        }
        AbstractC0048c abstractC0048cM12784j = m12784j(bVar.f9688d, str, str2, callback);
        if (abstractC0048cM12784j == null) {
            C2153l.m13082z(callback, 2, str2);
            return 0;
        }
        int iMo12781g = mo12781g(bVar.f9685a, abstractC0048cM12784j, abstractC0048c, backupObjectMo12792r, new C2153l.g(callback, str2));
        abstractC0048cM12784j.mo170b();
        C2153l.m13002A(callback, 2, str2, backupObjectMo12792r.getBackupFilesBundle());
        return iMo12781g;
    }

    /* renamed from: e */
    public void mo12779e(C2153l.b bVar, String str, BackupObject backupObject) {
        if (bVar == null || backupObject == null || str == null) {
            C2111d.m12648d("ControlBranch", "doMediaRestore : cmd or object is null");
        } else if (backupObject instanceof AbstractC12706c) {
            backupObject.onRestore(bVar.f9685a, null, new C2153l.g(bVar.f9687c, str), null, str);
        }
    }

    /* renamed from: f */
    public void mo12780f(C2153l.b bVar, String str, BackupObject backupObject) {
        C2111d.m12653i("ControlBranch", "Do restore.");
        if (bVar == null || backupObject == null || str == null) {
            return;
        }
        AbstractC0048c abstractC0048cM12785k = m12785k(bVar.f9688d, bVar.f9689e, str, bVar.f9687c);
        if (abstractC0048cM12785k != null) {
            backupObject.onRestorePro(bVar.f9685a, abstractC0048cM12785k, new C2153l.g(bVar.f9687c, str), null, str);
            abstractC0048cM12785k.mo170b();
        } else {
            C2111d.m12648d("ControlBranch", "restoreOneModule doRestore error!storeHandle is null!");
            C2153l.m13082z(bVar.f9687c, 13, str);
            C2153l.m13082z(bVar.f9687c, 3, str);
        }
    }

    /* renamed from: g */
    public abstract int mo12781g(Context context, AbstractC0048c abstractC0048c, AbstractC0048c abstractC0048c2, BackupObject backupObject, C2153l.g gVar);

    /* renamed from: h */
    public final String[] m12782h() {
        return (String[]) BackupConstant.m13131e().keySet().toArray(new String[0]);
    }

    /* renamed from: i */
    public final String m12783i(String str) {
        return BackupObject.isTwinApp(str) ? C2149g.class.getName() : C2148f.class.getName();
    }

    /* renamed from: j */
    public AbstractC0048c m12784j(String str, String str2, String str3, Handler.Callback callback) {
        return C9409b.m59024e(new C9414g(str, str2, str3, "storHandlerForData", callback), null, m12790p());
    }

    /* renamed from: k */
    public AbstractC0048c m12785k(String str, String str2, String str3, Handler.Callback callback) {
        return C9409b.m59025f(new C9414g(str, str2, str3, "storHandlerForData", callback), m12790p());
    }

    /* renamed from: l */
    public ArrayList<String> m12786l(C2153l.b bVar) {
        C2111d.m12653i("ControlBranch", "getSupportedListRaw begin");
        ArrayList<String> arrayList = new ArrayList<>();
        if (bVar == null) {
            C2111d.m12648d("ControlBranch", "getSupportedListRaw : cmd is null");
            return arrayList;
        }
        for (String str : m12782h()) {
            BackupObject backupObjectMo12792r = mo12792r(str, bVar.f9687c);
            if (backupObjectMo12792r != null && backupObjectMo12792r.isSupported(bVar.f9685a, str)) {
                arrayList.add(str);
            }
        }
        C2111d.m12653i("ControlBranch", "getSupportedListRaw end");
        return arrayList;
    }

    /* renamed from: m */
    public abstract Bundle mo12787m(C2153l.b bVar);

    /* renamed from: n */
    public Bundle m12788n(C2153l.b bVar) {
        Bundle extraInfo;
        if (bVar == null) {
            C2111d.m12648d("ControlBranch", "getSupportedModuleExtraInfoRaw: cmd is null");
            return new Bundle();
        }
        C2111d.m12653i("ControlBranch", "Func ControlBranch:getSupportedModuleExtraInfoRaw() start...");
        String[] strArrM12782h = m12782h();
        Bundle bundle = new Bundle();
        for (String str : strArrM12782h) {
            BackupObject backupObjectMo12792r = mo12792r(str, bVar.f9687c);
            if (backupObjectMo12792r != null && (extraInfo = backupObjectMo12792r.getExtraInfo(bVar.f9685a, str)) != null) {
                bundle.putBundle(str, extraInfo);
            }
        }
        C2111d.m12653i("ControlBranch", "Func ControlBranch:getSupportedModuleExtraInfoRaw() end...");
        return bundle;
    }

    /* renamed from: o */
    public abstract ArrayList<String> mo12789o(C2153l.b bVar);

    /* renamed from: p */
    public boolean m12790p() {
        boolean z10 = !C10713c.m65392b(BackupObject.getExecuteParameter(), "isUseDataTrans", false) || C10713c.m65392b(BackupObject.getExecuteParameter(), "isPerformanceHidiskService", false);
        C2111d.m12653i("ControlBranch", "needEncrypt = " + z10);
        return z10;
    }

    /* renamed from: q */
    public void m12791q(C2153l.b bVar, File file, int i10) {
        if (bVar == null || bVar.f9689e == null || file == null) {
            C2111d.m12648d("ControlBranch", "makeBackupFiles : cmd or fileName or tempFile is null");
            return;
        }
        if (i10 < 0) {
            C13334c.m79979l(file);
            return;
        }
        File file2 = new File(bVar.f9688d, bVar.f9689e);
        C13334c.m79979l(file2);
        if (file.renameTo(file2)) {
            return;
        }
        C2111d.m12648d("ControlBranch", "temp file rename fail!");
    }

    /* renamed from: r */
    public abstract BackupObject mo12792r(String str, Handler.Callback callback);

    /* renamed from: s */
    public BackupObject m12793s(String str, HashMap<String, String> map, String str2) throws ClassNotFoundException {
        Class<?> cls;
        if (C2157a.m13199g().contains(str) || map == null) {
            return null;
        }
        String str3 = map.get(str);
        if (str3 != null) {
            str2 = str3;
        }
        try {
            cls = Class.forName(str2);
        } catch (ClassNotFoundException unused) {
            C2111d.m12649e("ControlBranch", "getClass:", str2);
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            if (!(cls.newInstance() instanceof BackupObject)) {
                return null;
            }
            BackupObject backupObject = (BackupObject) cls.newInstance();
            backupObject.setModuleName(str);
            return backupObject;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException unused2) {
            C2111d.m12648d("ControlBranch", "newBackupObject exception.");
            return null;
        }
    }

    /* renamed from: t */
    public BackupObject m12794t(String str) {
        return m12793s(str, BackupConstant.m13131e(), m12783i(str));
    }

    /* renamed from: u */
    public abstract Bundle mo12795u(C2153l.b bVar, String str);

    /* renamed from: v */
    public Bundle m12796v(C2153l.b bVar, String str) {
        Bundle bundleNotifyModuleStart;
        if (bVar == null || str == null) {
            C2111d.m12648d("ControlBranch", "notifySupportedModulesStart: cmd is null");
            return new Bundle();
        }
        C2111d.m12653i("ControlBranch", "notifySupportedModulesStart start...");
        String[] strArr = (String[]) BackupConstant.m13144r().toArray(new String[0]);
        Bundle bundle = new Bundle();
        for (String str2 : strArr) {
            BackupObject backupObjectMo12792r = mo12792r(str2, bVar.f9687c);
            if (backupObjectMo12792r != null && !"HwIdOobe".equals(str2) && (bundleNotifyModuleStart = backupObjectMo12792r.notifyModuleStart(bVar.f9685a, str2, str)) != null) {
                C2111d.m12654j("ControlBranch", "call backup_start, module [", str2, "] has result.");
                bundle.putBundle(str2, bundleNotifyModuleStart);
            }
        }
        C2111d.m12653i("ControlBranch", "notifySupportedModulesStart end.");
        return bundle;
    }

    /* renamed from: w */
    public abstract void mo12797w(C2153l.b bVar);

    /* renamed from: x */
    public void m12798x(C2153l.b bVar, String str, BackupFileModuleInfo backupFileModuleInfo) {
        C2111d.m12654j("ControlBranch", "restoreOneModule start!moduleName:", str);
        if (bVar == null || str == null) {
            C2111d.m12648d("ControlBranch", "restoreOneModule: cmd is null");
            return;
        }
        C2153l.m13082z(bVar.f9687c, 29, str);
        BackupObject.removeFromFollowingRestoreModules(str);
        BackupObject backupObjectMo12792r = mo12792r(str, bVar.f9687c);
        if (backupObjectMo12792r == null) {
            C2111d.m12648d("ControlBranch", "restoreOneModule fail!backUpOject is null!");
            C2153l.m13082z(bVar.f9687c, 13, str);
            C2153l.m13082z(bVar.f9687c, 3, str);
            return;
        }
        C12461a.m74714a(bVar.f9685a);
        if (backupFileModuleInfo != null) {
            backupObjectMo12792r.backupFileModuleInfo = backupFileModuleInfo;
        }
        if (backupObjectMo12792r instanceof AbstractC12706c) {
            mo12779e(bVar, str, backupObjectMo12792r);
        } else {
            mo12780f(bVar, str, backupObjectMo12792r);
        }
        if (C2153l.m13035b0()) {
            C2153l.m13082z(bVar.f9687c, 13, str);
        }
        C2153l.m13082z(bVar.f9687c, 3, str);
    }

    /* renamed from: y */
    public void mo12799y(C2153l.b bVar) {
        Bundle bundle;
        if (bVar == null || (bundle = bVar.f9690f) == null) {
            C2111d.m12648d("ControlBranch", "setDecryptInfo : cmd or executeParameter is null");
            return;
        }
        Bundle bundleM65393c = C10713c.m65393c(bundle, "key_encrypt");
        if (bundleM65393c == null) {
            C9409b.m59027h();
            return;
        }
        if (C10713c.m65400j(bundleM65393c, "key_word") != null) {
            try {
                AbstractC0048c abstractC0048cM59024e = C9409b.m59024e(new C9414g(bVar.f9688d, bVar.f9689e, "info", "storHandlerForInfo", null), null, m12790p());
                if (abstractC0048cM59024e != null) {
                    abstractC0048cM59024e.mo170b();
                }
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("ControlBranch", "setDecryptInfo IllegalArgumentException");
            } catch (Exception unused2) {
                C2111d.m12648d("ControlBranch", "setDecryptInfo Exception");
            }
        }
        C9409b.m59027h();
    }

    /* renamed from: z */
    public void mo12800z(C2153l.b bVar) {
        Bundle bundle;
        String strM65400j;
        String strM65400j2;
        if (bVar == null || (bundle = bVar.f9690f) == null) {
            C2111d.m12648d("ControlBranch", "setDecryptInfo : cmd or executeParameter is null");
            return;
        }
        Bundle bundleM65393c = C10713c.m65393c(bundle, "key_encrypt");
        boolean z10 = false;
        if (bundleM65393c != null) {
            strM65400j = C10713c.m65400j(bundleM65393c, "key_word");
            strM65400j2 = C10713c.m65400j(bundleM65393c, "key_word_prompt");
            if (strM65400j != null) {
                z10 = true;
            }
        } else {
            strM65400j = null;
            strM65400j2 = null;
        }
        C9409b.m59026g(z10, strM65400j, strM65400j2);
    }
}
