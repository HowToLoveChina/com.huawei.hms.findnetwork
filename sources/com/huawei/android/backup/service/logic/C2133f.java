package com.huawei.android.backup.service.logic;

import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.backup.service.logic.installedapps.C2146d;
import com.huawei.android.backup.service.model.BackupFileModuleInfo;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import gy.C10065d;
import gy.C10067f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import p006a5.AbstractC0048c;
import p248e5.C9409b;
import p248e5.C9414g;
import p386j6.C10717g;
import p699v4.C13334c;

/* renamed from: com.huawei.android.backup.service.logic.f */
/* loaded from: classes.dex */
public class C2133f extends C2135h {

    /* renamed from: a */
    public File f9617a;

    /* renamed from: N */
    public final void m12822N(C2153l.b bVar) throws Throwable {
        File file;
        File file2;
        if (C2157a.m13203k().contains(bVar.f9686b[0])) {
            C2111d.m12654j("ControlBranchCloud", "arthiveFile skip:", bVar.f9686b[0]);
            return;
        }
        C10067f c10067f = null;
        try {
            try {
                try {
                    File file3 = new File(bVar.f9688d, bVar.f9686b[0]);
                    file = new File(file3.getCanonicalPath(), bVar.f9686b[0]);
                    file2 = new File(file3.getCanonicalPath(), bVar.f9686b[0] + ".tar");
                } catch (IOException unused) {
                }
                if (file.exists()) {
                    if (!file2.exists() && !file2.createNewFile()) {
                        C2111d.m12648d("ControlBranchCloud", "arthiveFile createFile fail");
                    }
                    C10067f c10067f2 = new C10067f(new FileOutputStream(file2));
                    try {
                        c10067f2.m62642F(2);
                        C10717g.m65407a(file, c10067f2, file.getParent());
                        C13334c.m79979l(file);
                        c10067f2.close();
                    } catch (IOException unused2) {
                        c10067f = c10067f2;
                        C2111d.m12648d("TAG", "arthiveFile IO fail");
                        if (c10067f != null) {
                            c10067f.close();
                        }
                    } catch (Throwable th2) {
                        c10067f = c10067f2;
                        th = th2;
                        if (c10067f != null) {
                            try {
                                c10067f.close();
                            } catch (IOException unused3) {
                                C2111d.m12648d("TAG", "stream closed fail");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused4) {
            C2111d.m12648d("TAG", "stream closed fail");
        }
    }

    /* renamed from: O */
    public final void m12823O(File file, C2153l.b bVar) throws Throwable {
        File file2;
        File[] fileArrListFiles;
        C10065d c10065d = null;
        try {
            try {
                try {
                    file2 = new File(file.getCanonicalPath());
                    fileArrListFiles = file2.listFiles();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused) {
            }
            if (fileArrListFiles == null) {
                return;
            }
            for (File file3 : fileArrListFiles) {
                if (file3.getName().equals(bVar.f9689e + ".tar")) {
                    this.f9617a = file3;
                }
            }
            if (this.f9617a == null) {
                return;
            }
            C10065d c10065d2 = new C10065d(new FileInputStream(this.f9617a));
            try {
                C10717g.m65410d(file2, c10065d2);
                C13334c.m79979l(this.f9617a);
                c10065d2.close();
            } catch (IOException unused2) {
                c10065d = c10065d2;
                C2111d.m12648d("ControlBranchCloud", "dearChive file IOException");
                if (c10065d != null) {
                    c10065d.close();
                }
            } catch (Throwable th3) {
                th = th3;
                c10065d = c10065d2;
                if (c10065d != null) {
                    try {
                        c10065d.close();
                    } catch (IOException unused3) {
                        C2111d.m12648d("ControlBranchCloud", "close stream Exception");
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
            C2111d.m12648d("ControlBranchCloud", "close stream Exception");
        }
    }

    @Override // com.huawei.android.backup.service.logic.C2135h, com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: b */
    public void mo12776b(C2153l.b bVar) throws Throwable {
        if (bVar == null) {
            C2111d.m12648d("ControlBranchCloud", "backupImp: cmd is null");
            return;
        }
        File file = new File(bVar.f9688d, ".tempFiles");
        C13334c.m79977j(file);
        AbstractC0048c abstractC0048cM59020a = C9409b.m59020a(new C9414g(bVar.f9688d, ".tempFiles", "info", "storHandlerForInfo", bVar.f9687c), m12790p());
        if (!mo12826G(abstractC0048cM59020a, bVar)) {
            C2153l.m13076w(bVar.f9687c, 4);
            return;
        }
        String[] strArr = bVar.f9686b;
        if (strArr == null) {
            abstractC0048cM59020a.mo170b();
            return;
        }
        int length = strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            int iM12777c = m12777c(bVar, ".tempFiles", strArr[i10], abstractC0048cM59020a);
            if (iM12777c < 0) {
                i11 = -1;
                break;
            }
            i11 += iM12777c;
            if (C2153l.m13035b0()) {
                abstractC0048cM59020a.mo170b();
                C13334c.m79979l(file);
                return;
            }
            i10++;
        }
        abstractC0048cM59020a.mo170b();
        m12823O(file, bVar);
        m12791q(bVar, file, i11);
        C2153l.m13076w(bVar.f9687c, 4);
    }

    @Override // com.huawei.android.backup.service.logic.C2135h, com.huawei.android.backup.service.logic.AbstractC2136i, com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: r */
    public BackupObject mo12792r(String str, Handler.Callback callback) {
        return super.m12793s(str, BackupConstant.m13131e(), C2146d.class.getName());
    }

    @Override // com.huawei.android.backup.service.logic.C2135h, com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: w */
    public void mo12797w(C2153l.b bVar) throws Throwable {
        boolean z10;
        if (bVar == null) {
            C2111d.m12648d("ControlBranchCloud", "restoreImp: cmd is null");
            return;
        }
        String[] strArr = bVar.f9686b;
        if (strArr == null || strArr.length <= 0) {
            z10 = false;
        } else {
            m12822N(bVar);
            z10 = true;
        }
        AbstractC0048c abstractC0048cM59024e = C9409b.m59024e(new C9414g(bVar.f9688d, bVar.f9689e, "info", "storHandlerForInfo", bVar.f9687c), null, m12790p());
        if (abstractC0048cM59024e == null || !mo12830L(bVar.f9685a, abstractC0048cM59024e)) {
            C2153l.m13076w(bVar.f9687c, 3);
            return;
        }
        HashMap<String, BackupFileModuleInfo> mapMo12828I = mo12828I(abstractC0048cM59024e);
        if (!z10) {
            abstractC0048cM59024e.mo170b();
            return;
        }
        for (String str : bVar.f9686b) {
            if (!mo12827H(bVar, mapMo12828I, str)) {
                abstractC0048cM59024e.mo170b();
                return;
            }
        }
        abstractC0048cM59024e.mo170b();
        if (C2153l.m13035b0()) {
            return;
        }
        C2153l.m13076w(bVar.f9687c, 5);
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: z */
    public void mo12800z(C2153l.b bVar) {
        C9409b.m59026g(false, null, null);
    }
}
