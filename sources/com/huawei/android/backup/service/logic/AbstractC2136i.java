package com.huawei.android.backup.service.logic;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.backup.service.model.BackupFileModuleInfo;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.InfoXmlUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import p006a5.AbstractC0048c;
import p279f6.C9661d;
import p444l5.C11236d;
import p699v4.C13334c;
import p699v4.C13345n;

/* renamed from: com.huawei.android.backup.service.logic.i */
/* loaded from: classes.dex */
public abstract class AbstractC2136i extends AbstractC2131d {
    /* renamed from: E */
    public final void m12831E(AbstractC0048c abstractC0048c) {
        if (abstractC0048c != null) {
            abstractC0048c.mo170b();
        }
    }

    /* renamed from: F */
    public final void m12832F(AbstractC0048c abstractC0048c, AbstractC0048c abstractC0048c2, C2153l.b bVar) {
        m12831E(abstractC0048c2);
        m12831E(abstractC0048c);
        if (C2153l.m13035b0()) {
            C2153l.m13082z(bVar.f9687c, 13, HNConstants.DataType.CONTACT);
        }
        C2153l.m13082z(bVar.f9687c, 3, HNConstants.DataType.CONTACT);
    }

    /* renamed from: G */
    public boolean mo12826G(AbstractC0048c abstractC0048c, C2153l.b bVar) {
        if (abstractC0048c == null || bVar == null) {
            return false;
        }
        InfoXmlUtils.m13153a();
        if (C9661d.m60330a(abstractC0048c) != 1 && !C13334c.m79969b(bVar.f9688d, bVar.f9687c, 115343360L)) {
            C2111d.m12648d("ControlBranchHapBase", "doBackupPerpare err!");
            abstractC0048c.mo170b();
            return false;
        }
        Context context = bVar.f9685a;
        if (context != null) {
            InfoXmlUtils.m13159g(BackupConstant.VersionInfo.getInstance(context).getVersionCode());
        }
        InfoXmlUtils.m13163k(abstractC0048c);
        InfoXmlUtils.m13165m(abstractC0048c);
        InfoXmlUtils.m13161i(abstractC0048c);
        return true;
    }

    /* renamed from: H */
    public boolean mo12827H(C2153l.b bVar, HashMap<String, BackupFileModuleInfo> map, String str) {
        if (bVar == null || map == null) {
            C2111d.m12648d("ControlBranchHapBase", "doRestoreOneModule : cmd or infoMap is null");
            return false;
        }
        if (!C13334c.m79969b(C13345n.m80066e(), bVar.f9687c, 115343360L)) {
            return false;
        }
        if (HNConstants.DataType.CONTACT.equals(str)) {
            mo12829J(bVar, map);
        } else {
            m12798x(bVar, str, map.get(str));
        }
        return !C2153l.m13035b0();
    }

    /* renamed from: I */
    public HashMap<String, BackupFileModuleInfo> mo12828I(AbstractC0048c abstractC0048c) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        HashMap<String, BackupFileModuleInfo> map = new HashMap<>();
        BackupFileModuleInfo[] allModuleInfo = BackupObject.readAllModuleInfo(abstractC0048c);
        if (allModuleInfo != null) {
            for (BackupFileModuleInfo backupFileModuleInfo : allModuleInfo) {
                map.put(backupFileModuleInfo.getName(), backupFileModuleInfo);
            }
        }
        return map;
    }

    /* renamed from: J */
    public void mo12829J(C2153l.b bVar, HashMap<String, BackupFileModuleInfo> map) {
        AbstractC0048c abstractC0048cM12785k;
        AbstractC0048c abstractC0048cM12785k2;
        if (bVar == null || map == null) {
            C2111d.m12648d("ControlBranchHapBase", "restoreContactModule : cmd or infoMap is null");
            return;
        }
        C2153l.m13082z(bVar.f9687c, 29, HNConstants.DataType.CONTACT);
        BackupObject.removeFromFollowingRestoreModules(HNConstants.DataType.CONTACT);
        BackupObject c11236d = new C11236d();
        c11236d.setModuleName(HNConstants.DataType.CONTACT);
        File file = new File(bVar.f9688d, bVar.f9689e);
        File file2 = new File(file, "contact.db");
        File file3 = new File(file, "contact_net.db");
        C2153l.g gVar = new C2153l.g(bVar.f9687c, HNConstants.DataType.CONTACT);
        if (!file2.exists() || file2.length() <= 0) {
            abstractC0048cM12785k = null;
        } else {
            BackupFileModuleInfo backupFileModuleInfo = map.get(HNConstants.DataType.CONTACT);
            if (backupFileModuleInfo == null) {
                return;
            }
            if (backupFileModuleInfo.isLowVersion()) {
                m12834M(c11236d);
            }
            abstractC0048cM12785k = m12785k(bVar.f9688d, bVar.f9689e, HNConstants.DataType.CONTACT, bVar.f9687c);
        }
        if (!file3.exists() || file3.length() <= 0) {
            abstractC0048cM12785k2 = null;
        } else {
            BackupFileModuleInfo backupFileModuleInfo2 = map.get("contact_net");
            if (backupFileModuleInfo2 == null) {
                return;
            }
            abstractC0048cM12785k2 = m12785k(bVar.f9688d, bVar.f9689e, "contact_net", bVar.f9687c);
            m12833K(bVar.f9685a, abstractC0048cM12785k2, c11236d, backupFileModuleInfo2, gVar);
        }
        if (abstractC0048cM12785k != null) {
            c11236d.backupFileModuleInfo = map.get(HNConstants.DataType.CONTACT);
            c11236d.onRestorePro(bVar.f9685a, abstractC0048cM12785k, gVar, null, HNConstants.DataType.CONTACT);
        } else if (abstractC0048cM12785k2 != null) {
            c11236d.onRestore(bVar.f9685a, abstractC0048cM12785k2, gVar, null, HNConstants.DataType.CONTACT);
        } else {
            C2153l.m13078x(bVar.f9687c, 1067, 0, 0, HNConstants.DataType.CONTACT);
        }
        m12832F(abstractC0048cM12785k2, abstractC0048cM12785k, bVar);
    }

    /* renamed from: K */
    public final void m12833K(Context context, AbstractC0048c abstractC0048c, BackupObject backupObject, BackupFileModuleInfo backupFileModuleInfo, C2153l.g gVar) {
        if (abstractC0048c == null) {
            return;
        }
        String strM196n = abstractC0048c.m196n();
        backupObject.backupFileModuleInfo = backupFileModuleInfo;
        if (backupObject.validateRestoreFile(context, gVar, null, strM196n) && abstractC0048c.mo172d(strM196n) && (backupObject instanceof C11236d)) {
            ((C11236d) backupObject).m67520y0(abstractC0048c);
        }
    }

    /* renamed from: L */
    public boolean mo12830L(Context context, AbstractC0048c abstractC0048c) {
        InfoXmlUtils.m13153a();
        InfoXmlUtils.m13159g(BackupConstant.VersionInfo.getInstance(context).getVersionCode());
        return InfoXmlUtils.m13156d(abstractC0048c) && InfoXmlUtils.m13158f(abstractC0048c);
    }

    /* renamed from: M */
    public final void m12834M(BackupObject backupObject) {
        if (backupObject instanceof C11236d) {
            ((C11236d) backupObject).m67519x0(true);
        }
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: g */
    public int mo12781g(Context context, AbstractC0048c abstractC0048c, AbstractC0048c abstractC0048c2, BackupObject backupObject, C2153l.g gVar) {
        if (backupObject != null) {
            return backupObject.onBackupPro(context, abstractC0048c, abstractC0048c2, gVar, gVar.f9698b);
        }
        C2111d.m12648d("ControlBranchHapBase", "executeBackup : object is null");
        return 0;
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: o */
    public ArrayList<String> mo12789o(C2153l.b bVar) {
        return m12786l(bVar);
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: r */
    public BackupObject mo12792r(String str, Handler.Callback callback) {
        return m12794t(str);
    }
}
