package p669u5;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.PMSbackupRestoreUtil;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p006a5.AbstractC0048c;
import p006a5.C0047b;
import p007a6.AbstractC0053b;
import p229di.C9142g;
import p229di.C9146k;
import p229di.C9153r;
import p386j6.C10713c;
import p632s4.C12701e;
import p633s5.C12718o;
import p699v4.C13334c;
import p699v4.C13347p;
import p699v4.C13348q;

/* renamed from: u5.b */
/* loaded from: classes.dex */
public class C13124b extends AbstractC0053b {

    /* renamed from: u5.b$a */
    public static class a {

        /* renamed from: a */
        public Context f59624a;

        /* renamed from: b */
        public AbstractC0048c f59625b;

        /* renamed from: c */
        public String f59626c;

        /* renamed from: d */
        public String f59627d;

        public a(Context context, AbstractC0048c abstractC0048c, String str, String str2) {
            this.f59624a = context;
            this.f59625b = abstractC0048c;
            this.f59626c = str;
            this.f59627d = str2;
        }

        /* renamed from: a */
        public String m78945a() {
            return this.f59627d;
        }

        /* renamed from: b */
        public Context m78946b() {
            return this.f59624a;
        }

        /* renamed from: c */
        public String m78947c() {
            return this.f59626c;
        }

        /* renamed from: d */
        public AbstractC0048c m78948d() {
            return this.f59625b;
        }
    }

    /* renamed from: I */
    private void m78922I(List<String> list) {
        if (list == null) {
            C2111d.m12657m("BackupCommonModule", "addBackupFileList dataTarFilePathList is null ");
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.backupFliedList.addAll(C13334c.m79985r("/data/data/com.hicloud.android.clone/files/clone/" + it.next() + "_CloneDataDataPmsTar"));
        }
        C2111d.m12653i("BackupCommonModule", "add all pms tar files end.");
    }

    /* renamed from: L */
    private boolean m78923L(Context context, AbstractC0048c abstractC0048c, ArrayList<String> arrayList) {
        if (arrayList == null) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!m78928K(context, abstractC0048c, next, m78940Z(next))) {
                C2111d.m12648d("BackupCommonModule", "attachment backup fail!");
                return false;
            }
        }
        return true;
    }

    /* renamed from: N */
    private boolean m78924N(Context context, List<String> list) {
        C2111d.m12653i("BackupCommonModule", "backup data/data by pms tar");
        PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (pMSbackupRestoreUtil.m12729t(it.next(), 3, null, null) == -1) {
                C2111d.m12648d("BackupCommonModule", "PMS backup data/data failed.");
                return false;
            }
        }
        return true;
    }

    /* renamed from: O */
    private boolean m78925O(Context context, ArrayList<String> arrayList, String str) {
        boolean zM65392b = C10713c.m65392b(BackupObject.getExecuteParameter(), "isSupportDataDataPmsTar", false);
        if ("galleryData".equals(str)) {
            m78931Q(context, NextRestoreConstants.PKG_NAME_GALLERY_DATA);
            m78931Q(context, "com.hihonor.photos");
            m78931Q(context, NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D);
        }
        if (!zM65392b || C13348q.m80082b(arrayList)) {
            C2111d.m12653i("BackupCommonModule", "no data tar file to backup.");
            return true;
        }
        if (m78924N(context, arrayList)) {
            m78922I(arrayList);
            return true;
        }
        C2111d.m12648d("BackupCommonModule", "backup data/data failed.");
        return false;
    }

    /* renamed from: c0 */
    private boolean m78926c0(Context context, AbstractC0048c abstractC0048c, String str, AbstractC0053b.c cVar) {
        if (m78927d0(context, abstractC0048c, cVar.m319D(), str)) {
            return false;
        }
        C2111d.m12648d("BackupCommonModule", "restore data/data failed.");
        return true;
    }

    /* renamed from: d0 */
    private boolean m78927d0(Context context, AbstractC0048c abstractC0048c, Bundle bundle, String str) {
        String strM78934T = abstractC0048c.m198p() + File.separator + BackupConstant.m13146t().get(str);
        if ("galleryData".equals(str)) {
            strM78934T = m78934T(strM78934T, bundle);
        }
        ArrayList<String> arrayListM79985r = C13334c.m79985r(strM78934T);
        if (C13348q.m80082b(arrayListM79985r)) {
            C2111d.m12657m("BackupCommonModule", "no data/data to restore.");
            return true;
        }
        PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
        for (String str2 : arrayListM79985r) {
            if (str2 == null || !str2.endsWith(".tar")) {
                C2111d.m12657m("BackupCommonModule", "not a tar file");
            } else {
                String strSubstring = (str2.contains(File.separator) && str2.contains("_CloneDataDataPmsTar")) ? str2.substring(abstractC0048c.m198p().length() - 1, str2.lastIndexOf(r2) - 20) : str2.substring(0, str2.length() - 4);
                if (bundle == null || !bundle.containsKey(strSubstring)) {
                    C2111d.m12657m("BackupCommonModule", "no restorePath for backupPath");
                    C13334c.m79980m(str2);
                } else if (pMSbackupRestoreUtil.m12731v(str2, 3, C10713c.m65400j(bundle, strSubstring), null) == -1) {
                    return false;
                }
            }
        }
        C2111d.m12653i("BackupCommonModule", "restore data/data successfully.");
        return true;
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: C */
    public ArrayList<String> mo296C(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        String str3 = BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null;
        if (m300H(context, str3, str, str2) != null) {
            arrayList.add(str3);
        }
        return arrayList;
    }

    /* renamed from: J */
    public boolean mo70391J() {
        return true;
    }

    /* renamed from: K */
    public boolean m78928K(Context context, AbstractC0048c abstractC0048c, String str, String str2) throws IOException {
        int i10;
        if (abstractC0048c == null || str2 == null) {
            return false;
        }
        InputStream inputStreamM78957a = C13126d.m78957a(context, str, new C13123a(this));
        if (inputStreamM78957a == null) {
            return mo70391J();
        }
        byte[] bArr = new byte[RuleConfig.DEFAULT_DB_DIFF_MAX_FILE_SIZE];
        ContentValues contentValues = new ContentValues();
        try {
            abstractC0048c.mo169a();
            int i11 = 0;
            do {
                i10 = inputStreamM78957a.read(bArr);
                if (i10 > 0) {
                    byte[] bArr2 = new byte[i10];
                    System.arraycopy(bArr, 0, bArr2, 0, i10);
                    contentValues.put("file_length", Integer.valueOf(i10));
                    int i12 = i11 + 1;
                    contentValues.put("data_index", Integer.valueOf(i11));
                    contentValues.put("file_data", bArr2);
                    abstractC0048c.m185A(str2, contentValues);
                    contentValues.clear();
                    i11 = i12;
                }
            } while (i10 > 0);
            abstractC0048c.mo171c();
            try {
                inputStreamM78957a.close();
            } catch (IOException unused) {
                C2111d.m12648d("BackupCommonModule", "close InputStream error.");
            }
            return true;
        } catch (IOException unused2) {
            abstractC0048c.mo171c();
            try {
                inputStreamM78957a.close();
                return false;
            } catch (IOException unused3) {
                C2111d.m12648d("BackupCommonModule", "close InputStream error.");
                return false;
            }
        } catch (Throwable th2) {
            abstractC0048c.mo171c();
            try {
                inputStreamM78957a.close();
            } catch (IOException unused4) {
                C2111d.m12648d("BackupCommonModule", "close InputStream error.");
            }
            throw th2;
        }
    }

    /* renamed from: M */
    public void m78929M(Context context, AbstractC0048c abstractC0048c, String str, ArrayList<String> arrayList) {
        if (arrayList != null) {
            C13125c.m78950e0(context, abstractC0048c, arrayList, str);
        } else {
            C12701e.m76424d(context, str);
        }
    }

    /* renamed from: P */
    public void m78930P(List<AbstractC0053b.c> list) {
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null) {
                cVar.m354g();
            }
        }
    }

    /* renamed from: Q */
    public void m78931Q(Context context, String str) {
        m78932R(context, str, C9153r.m57494b());
    }

    /* renamed from: R */
    public void m78932R(Context context, String str, int i10) {
        if (str == null || context == null) {
            C2111d.m12648d("BackupCommonModule", "forceStopAppPackageAsUser : packageName or context is null");
            return;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            C9146k.m57480a(activityManager, str);
        }
    }

    /* renamed from: S */
    public String m78933S(String str, String str2) {
        String strM297D;
        if (str == null || (strM297D = m297D(C13347p.m80079b(str))) == null) {
            return null;
        }
        return strM297D + str2;
    }

    /* renamed from: T */
    public final String m78934T(String str, Bundle bundle) {
        if (C13348q.m80081a(bundle)) {
            return str;
        }
        String str2 = BackupConstant.m13146t().get("galleryData");
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        for (String str3 : bundle.keySet()) {
            if (!TextUtils.isEmpty(str3)) {
                if (m78938X(str3, str, NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D, str2)) {
                    return str.replace(str2, NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D);
                }
                if (m78938X(str3, str, NextRestoreConstants.PKG_NAME_GALLERY_DATA, str2)) {
                    return str.replace(str2, NextRestoreConstants.PKG_NAME_GALLERY_DATA);
                }
                if (m78938X(str3, str, "com.hihonor.photos", str2)) {
                    return str.replace(str2, "com.hihonor.photos");
                }
                C2111d.m12647c("BackupCommonModule", "getGalleryDataSourcePath key is: ", str3);
            }
        }
        return str;
    }

    /* renamed from: U */
    public List<AbstractC0053b.c> m78935U(Handler.Callback callback, Object obj, a aVar) {
        List<AbstractC0053b.c> listMo301w = mo301w(aVar.m78946b(), aVar.m78948d(), new AbstractC0053b.a(callback, obj), aVar.m78947c(), aVar.m78945a());
        if (listMo301w.isEmpty()) {
            C2111d.m12657m("BackupCommonModule", "getImpLists implList is empty");
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (AbstractC0053b.c cVar : listMo301w) {
            if (cVar != null && cVar.mo362k()) {
                if (!cVar.m326K()) {
                    C2111d.m12654j("BackupCommonModule", aVar.m78947c(), " permit is false");
                    sendMsg(7, 0, 0, callback, obj);
                    return new ArrayList(0);
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* renamed from: V */
    public final void m78936V(Cursor cursor, OutputStream outputStream) throws IOException {
        while (!BackupObject.isAbort()) {
            outputStream.write(cursor.getBlob(cursor.getColumnIndexOrThrow("file_data")), 0, cursor.getInt(cursor.getColumnIndexOrThrow("file_length")));
            if (!cursor.moveToNext()) {
                return;
            }
        }
        throw new SQLiteException("Abort!");
    }

    /* renamed from: W */
    public ArrayList<String> m78937W(AbstractC0053b.c cVar) {
        return cVar.m327L();
    }

    /* renamed from: X */
    public final boolean m78938X(String str, String str2, String str3, String str4) {
        return !str3.equals(str4) && str.contains(str3) && str2.contains(str4);
    }

    /* renamed from: Y */
    public boolean m78939Y(ArrayList<String> arrayList, AbstractC0053b.c cVar) {
        boolean z10 = C13348q.m80082b(cVar.m331P()) && C13348q.m80081a(cVar.m319D()) && C13348q.m80081a(cVar.m316A()) && C13348q.m80082b(arrayList);
        if (this.subKeyTotalNum != 0 || !z10) {
            return false;
        }
        C2111d.m12648d("BackupCommonModule", "There is no data need to restore");
        return true;
    }

    /* renamed from: Z */
    public String m78940Z(String str) {
        String strReplace = null;
        if (str == null) {
            C2111d.m12657m("BackupCommonModule", "parseBackupAttachmentTableName uri is null");
            return null;
        }
        String authority = C13347p.m80079b(str).getAuthority();
        if (authority != null) {
            int iIndexOf = str.indexOf(authority);
            if (iIndexOf < 0) {
                return null;
            }
            strReplace = C9142g.m57462a(str.substring(iIndexOf)).replace(".", "").replace("/", "_");
        }
        if (strReplace == null) {
            return strReplace;
        }
        return strReplace + "_attachment";
    }

    /* renamed from: a0 */
    public void m78941a0(AbstractC0048c abstractC0048c, List<AbstractC0053b.c> list, boolean z10, int i10) {
        String strM372p;
        StringBuilder sb2 = new StringBuilder();
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null && (strM372p = cVar.m372p()) != null) {
                sb2.append(strM372p);
                sb2.append(";");
            }
        }
        this.backupFileModuleInfo.updateModuleInfo(i10, 8, sb2.toString());
        if (this.backupFileModuleInfo.hasRecord() || !z10) {
            return;
        }
        C2111d.m12657m("BackupCommonModule", "delete file no record");
        abstractC0048c.m190h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [u5.b] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.OutputStream] */
    /* renamed from: b0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m78942b0(android.content.Context r12, p006a5.AbstractC0048c r13, java.lang.String r14, java.lang.String r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p669u5.C13124b.m78942b0(android.content.Context, a5.c, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: e0 */
    public boolean m78943e0(Context context, AbstractC0048c abstractC0048c, String str, AbstractC0053b.c cVar) {
        if (C13348q.m80082b(cVar.m331P())) {
            return false;
        }
        for (String str2 : cVar.m331P()) {
            if (str2 != null) {
                C2111d.m12654j("BackupCommonModule", "restore openfile uri = ", C13347p.m80078a(str2));
                if (!m78942b0(context, abstractC0048c, str2, str)) {
                    C2111d.m12649e("BackupCommonModule", "attachment restore fail, uri = [", C13347p.m80078a(str2), "].");
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: f0 */
    public final void m78944f0() throws InterruptedException {
        for (int i10 = 0; i10 < 15; i10++) {
            if (BackupObject.isRestoreWifiComplete()) {
                C2111d.m12653i("BackupCommonModule", "settings restore wifi complete.");
                return;
            }
            try {
                Thread.sleep(1000L);
                C2111d.m12654j("BackupCommonModule", "wait settings restore wifi count = ", Integer.valueOf(i10));
            } catch (InterruptedException e10) {
                C2111d.m12649e("BackupCommonModule", "waitSettingsRestoreWifi InterruptedException, info = ", e10.getMessage());
            }
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle notifyModuleStart(Context context, String str, String str2) {
        Bundle bundleM65393c;
        C2111d.m12654j("BackupCommonModule", "notifyModuleStart start, moduleName = ", str, ", backupOrRestore = ", str2);
        String str3 = BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null;
        boolean zM13194b = C2157a.m13194b(context, str3);
        C2111d.m12654j("BackupCommonModule", "query provider module ", str, " result is : ", Boolean.valueOf(zM13194b));
        if (!zM13194b) {
            C2111d.m12653i("BackupCommonModule", "Uri is not exist.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("session", "com.hicloud.android.clone");
        Bundle bundleM65393c2 = C10713c.m65393c(BackupObject.getExecuteParameter(), "AllModulesAbility");
        if (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(str2) && bundleM65393c2 != null && (bundleM65393c = C10713c.m65393c(bundleM65393c2, str)) != null) {
            bundle.putBundle("new_phone_ability_info", bundleM65393c);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle bundleM12616b = C2108a.m12616b(context, str3, "backup_start", str2, reassembleExtra(bundle));
        C2111d.m12654j("BackupCommonModule", "get module info cost time: [", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "] ms.");
        C2111d.m12653i("BackupCommonModule", "notifyModuleStart end.");
        return bundleM12616b;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (abstractC0048c == null) {
            return 2;
        }
        if ("galleryData".equals(str)) {
            notifyModuleStart(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        }
        List<AbstractC0053b.c> listMo301w = mo301w(context, abstractC0048c, new AbstractC0053b.a(callback, obj), str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (listMo301w.isEmpty()) {
            C2111d.m12658n("BackupCommonModule", "moduleName =", str, " commonModuleImpList is null");
            return 2;
        }
        if (!m302x(listMo301w)) {
            C2111d.m12657m("BackupCommonModule", "onBackup data is null");
            return 2;
        }
        boolean z10 = false;
        AbstractC0053b.c cVar = listMo301w.get(0);
        if (cVar == null) {
            C2111d.m12648d("BackupCommonModule", "backupModule is null");
            return 2;
        }
        ArrayList<String> arrayListM331P = cVar.m331P();
        ArrayList<String> arrayListM381y = cVar.m381y();
        ArrayList<String> arrayListM318C = cVar.m318C();
        if (C13348q.m80082b(arrayListM331P) && C13348q.m80082b(arrayListM381y) && C13348q.m80082b(arrayListM318C)) {
            z10 = true;
        }
        int iM298E = m298E(listMo301w);
        this.subKeyTotalNum = iM298E;
        if (iM298E == 0 && z10) {
            C2111d.m12648d("BackupCommonModule", "No data need to backup!");
            return 2;
        }
        int iM294A = m294A(listMo301w);
        if (iM294A == 0 && z10) {
            C2111d.m12648d("BackupCommonModule", "No data need to backup!");
            return 2;
        }
        if (!m78925O(context, arrayListM318C, str)) {
            return 2;
        }
        if (!m78923L(context, abstractC0048c, arrayListM331P)) {
            C2111d.m12648d("BackupCommonModule", "backupAttachments fail");
            return 2;
        }
        m78929M(context, abstractC0048c, str, arrayListM381y);
        m78930P(listMo301w);
        m78941a0(abstractC0048c, listMo301w, z10, iM294A);
        return 1;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) throws InterruptedException {
        C2111d.m12653i("BackupCommonModule", "Restore common module.");
        ArrayList<String> arrayListMo296C = mo296C(context, str, "restore");
        if (arrayListMo296C.isEmpty()) {
            C2111d.m12657m("BackupCommonModule", "uriList is empty");
            return 5;
        }
        List<AbstractC0053b.c> listM78935U = m78935U(callback, obj, new a(context, abstractC0048c, str, "restore"));
        if (listM78935U == null || listM78935U.isEmpty()) {
            C2111d.m12658n("BackupCommonModule", "moduleName = ", str, " impLists is empty ");
            return 5;
        }
        AbstractC0053b.c cVar = listM78935U.get(0);
        if (cVar == null) {
            C2111d.m12649e("BackupCommonModule", "moduleName = ", str, " restoreModuleImp is null");
            return 5;
        }
        this.subKeyTotalNum = cVar.m325J();
        ArrayList<String> arrayListM13187V = C2157a.m13187V(abstractC0048c, m78933S(arrayListMo296C.get(0), "_copy_file_list_info"));
        if (m78939Y(arrayListM13187V, cVar)) {
            return 4;
        }
        if (m78926c0(context, abstractC0048c, str, cVar) || m78943e0(context, abstractC0048c, str, cVar)) {
            return 5;
        }
        cVar.m368n();
        if (arrayListM13187V != null) {
            ArrayList<String> arrayListM78937W = m78937W(cVar);
            C13125c c13125c = new C13125c();
            C12718o c12718o = new C12718o(context, callback, obj, cVar.m316A());
            c12718o.m76536l(str);
            c12718o.m76538n(abstractC0048c.m193k());
            c13125c.m78955h0(c12718o, arrayListM13187V, arrayListM78937W);
            if ("galleryData".equals(str)) {
                C0047b.m180h(context);
            }
        }
        C2111d.m12653i("BackupCommonModule", "on restore doAfterRestore");
        cVar.m356h();
        if ("setting".equals(str)) {
            m78944f0();
        }
        return 4;
    }
}
