package p567q5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.PMSbackupRestoreUtil;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p006a5.AbstractC0048c;
import p006a5.C0047b;
import p007a6.AbstractC0053b;
import p386j6.C10713c;
import p633s5.C12718o;
import p669u5.C13124b;
import p669u5.C13125c;
import p699v4.C13334c;
import p699v4.C13348q;

/* renamed from: q5.a */
/* loaded from: classes.dex */
public class C12287a extends C13124b {
    /* renamed from: g0 */
    public static String m73820g0(String str) {
        int iIndexOf = str.indexOf("com.huawei.hicreate");
        if (iIndexOf == -1) {
            return "";
        }
        String strSubstring = str.substring(iIndexOf);
        int iLastIndexOf = strSubstring.lastIndexOf("/");
        return iLastIndexOf != -1 ? strSubstring.substring(0, iLastIndexOf) : strSubstring;
    }

    @Override // p669u5.C13124b, p007a6.AbstractC0053b
    /* renamed from: C */
    public ArrayList<String> mo296C(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null);
        return arrayList;
    }

    /* renamed from: I */
    public final void m73821I(List<String> list) {
        if (list == null) {
            C2111d.m12657m("BackupHiCreateModule", "addBackupFileList dataTarFilePathList is null.");
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.backupFliedList.addAll(C13334c.m79985r("/data/data/com.hicloud.android.clone/files/clone/" + it.next() + "_CloneDataDataPmsTar"));
        }
        C2111d.m12653i("BackupHiCreateModule", "add all pms tar files end.");
    }

    /* renamed from: L */
    public final boolean m73822L(Context context, AbstractC0048c abstractC0048c, ArrayList<String> arrayList) {
        if (arrayList == null) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!m78928K(context, abstractC0048c, next, m78940Z(next))) {
                C2111d.m12648d("BackupHiCreateModule", "attachment backup fail!");
                return false;
            }
        }
        return true;
    }

    /* renamed from: N */
    public final boolean m73823N(Context context, List<String> list) {
        C2111d.m12653i("BackupHiCreateModule", "backup data/data by pms tar memo data Type");
        PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (pMSbackupRestoreUtil.m12729t(it.next(), 2, null, null) == -1) {
                C2111d.m12648d("BackupHiCreateModule", "PMS backup data/data failed.");
                return false;
            }
        }
        return true;
    }

    /* renamed from: O */
    public final boolean m73824O(Context context, ArrayList<String> arrayList, String str) {
        if (!C10713c.m65392b(BackupObject.getExecuteParameter(), "isSupportDataDataPmsTar", false) || C13348q.m80082b(arrayList)) {
            C2111d.m12653i("BackupHiCreateModule", "hiCreate no data tar file to backup.");
            return true;
        }
        if (m73823N(context, arrayList)) {
            m73821I(arrayList);
            return true;
        }
        C2111d.m12648d("BackupHiCreateModule", "backup hiCreate data/data failed.");
        return false;
    }

    /* renamed from: c0 */
    public boolean m73825c0(Context context, AbstractC0048c abstractC0048c, String str, AbstractC0053b.c cVar) {
        if (m73826d0(context, abstractC0048c, cVar.m319D(), str)) {
            return true;
        }
        C2111d.m12648d("BackupHiCreateModule", "restore data/data failed.");
        return false;
    }

    /* renamed from: d0 */
    public final boolean m73826d0(Context context, AbstractC0048c abstractC0048c, Bundle bundle, String str) {
        ArrayList<String> arrayListM79985r = C13334c.m79985r(abstractC0048c.m198p() + File.separator + BackupConstant.m13146t().get(str));
        if (C13348q.m80082b(arrayListM79985r)) {
            C2111d.m12657m("BackupHiCreateModule", "no data/data to restore.");
            return true;
        }
        PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
        for (String str2 : arrayListM79985r) {
            if (str2 == null || !str2.endsWith(".tar")) {
                C2111d.m12657m("BackupHiCreateModule", "not a tar file.");
            } else {
                String strM73820g0 = m73820g0(str2);
                C2111d.m12657m("BackupHiCreateModule", "restoreDataData backupPath:" + strM73820g0);
                if (bundle == null || !bundle.containsKey(strM73820g0)) {
                    C2111d.m12657m("BackupHiCreateModule", "no restorePath for backupPath.");
                    C13334c.m79980m(str2);
                } else if (pMSbackupRestoreUtil.m12731v(str2, 3, C10713c.m65400j(bundle, strM73820g0), null) == -1) {
                    return false;
                }
            }
        }
        C2111d.m12653i("BackupHiCreateModule", "restore data/data successfully.");
        return true;
    }

    @Override // p669u5.C13124b, p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (abstractC0048c == null) {
            C2111d.m12658n("BackupHiCreateModule", "moduleName =", str, " storeHandler is null");
            return 2;
        }
        List<AbstractC0053b.c> listMo301w = mo301w(context, abstractC0048c, new AbstractC0053b.a(callback, obj), str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (listMo301w.isEmpty()) {
            C2111d.m12658n("BackupHiCreateModule", "moduleName =", str, " commonModuleImpList is null");
            return 2;
        }
        if (!m302x(listMo301w)) {
            C2111d.m12657m("BackupHiCreateModule", "onBackup hiCreate data is null");
            return 2;
        }
        boolean z10 = false;
        AbstractC0053b.c cVar = listMo301w.get(0);
        if (cVar == null) {
            C2111d.m12648d("BackupHiCreateModule", "hiCreate backupModule is null");
            return 2;
        }
        ArrayList<String> arrayListM331P = cVar.m331P();
        ArrayList<String> arrayListM318C = cVar.m318C();
        ArrayList<String> arrayListM381y = cVar.m381y();
        this.subKeyTotalNum = m298E(listMo301w);
        if (C13348q.m80082b(arrayListM331P) && C13348q.m80082b(arrayListM381y) && C13348q.m80082b(arrayListM318C)) {
            z10 = true;
        }
        if (this.subKeyTotalNum == 0 && z10) {
            C2111d.m12648d("BackupHiCreateModule", "HiCreate no data need to backup!");
            return 2;
        }
        int iM294A = m294A(listMo301w);
        if (iM294A == 0 && z10) {
            C2111d.m12648d("BackupHiCreateModule", "HiCreate no data need to backup!");
            return 2;
        }
        if (!m73824O(context, arrayListM318C, str)) {
            C2111d.m12648d("BackupHiCreateModule", "HiCreate backup data/data fail!");
            return 2;
        }
        if (!m73822L(context, abstractC0048c, arrayListM331P)) {
            C2111d.m12648d("BackupHiCreateModule", "HiCreate backupAttachments fail");
            return 2;
        }
        m78929M(context, abstractC0048c, str, arrayListM381y);
        m78930P(listMo301w);
        m78941a0(abstractC0048c, listMo301w, z10, iM294A);
        return 1;
    }

    @Override // p669u5.C13124b, p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupHiCreateModule", "Restore HiCreate module.");
        ArrayList<String> arrayListMo296C = mo296C(context, str, "restore");
        if (arrayListMo296C.isEmpty()) {
            C2111d.m12657m("BackupHiCreateModule", "HiCreate uriList is empty");
            return 5;
        }
        List<AbstractC0053b.c> listM78935U = m78935U(callback, obj, new C13124b.a(context, abstractC0048c, str, "restore"));
        if (listM78935U == null || listM78935U.isEmpty()) {
            C2111d.m12658n("BackupHiCreateModule", "moduleName = ", str, " HiCreate impLists is empty ");
            return 5;
        }
        AbstractC0053b.c cVar = listM78935U.get(0);
        if (cVar == null) {
            C2111d.m12649e("BackupHiCreateModule", "moduleName = ", str, " restoreModuleImpl is null.");
            return 5;
        }
        this.subKeyTotalNum = cVar.m325J();
        ArrayList<String> arrayListM13187V = C2157a.m13187V(abstractC0048c, m78933S(arrayListMo296C.get(0), "_copy_file_list_info"));
        if (m78939Y(arrayListM13187V, cVar)) {
            return 4;
        }
        if (!m73825c0(context, abstractC0048c, str, cVar) || m78943e0(context, abstractC0048c, str, cVar)) {
            return 5;
        }
        C2111d.m12653i("BackupHiCreateModule", "on restore HiCreate doRestore");
        cVar.m368n();
        if (arrayListM13187V != null) {
            ArrayList<String> arrayListM78937W = m78937W(cVar);
            C12718o c12718o = new C12718o(context, callback, obj, cVar.m316A());
            c12718o.m76536l(str);
            c12718o.m76538n(abstractC0048c.m193k());
            new C13125c().m78955h0(c12718o, arrayListM13187V, arrayListM78937W);
            if ("galleryData".equals(str)) {
                C0047b.m180h(context);
            }
        }
        C2111d.m12653i("BackupHiCreateModule", "on restore HiCreate doAfterRestore");
        cVar.m356h();
        return 4;
    }
}
