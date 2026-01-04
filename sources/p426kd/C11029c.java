package p426kd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import com.huawei.hicloud.request.opengw.bean.Result;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import ke.C11046a;
import p015ak.AbstractC0218h0;
import p015ak.C0221j;
import p015ak.C0227m;
import p514o9.C11829c;
import p514o9.C11839m;
import p605r8.C12476a;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import to.C13049a;

@CBServiceTask(request = 55000021, response = 66000021)
/* renamed from: kd.c */
/* loaded from: classes3.dex */
public class C11029c extends AbstractC11027a {
    @Override // p426kd.AbstractC11027a
    /* renamed from: C */
    public CloudDiskModuleRst mo66478C() throws C9721b {
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        if (!C10028c.m62182c0().m62420y1() && !m66496O()) {
            C11839m.m70689w("BackupPhoneManagerTask", "dealWithCompatibility fail no backup");
            cloudDiskModuleRst.setRetCode(2);
            cloudDiskModuleRst.setFailReason("dealWithCompatibility fail no backup");
            return cloudDiskModuleRst;
        }
        cloudDiskModuleRst.setRetCode(0);
        if (this.f53298n == -1) {
            cloudDiskModuleRst.setRetCode(-1);
            return cloudDiskModuleRst;
        }
        if (m68511i()) {
            C11839m.m70688i("BackupPhoneManagerTask", "backupData is aborted");
            cloudDiskModuleRst.setRetCode(3);
            return cloudDiskModuleRst;
        }
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70687e("BackupPhoneManagerTask", "Sync risk");
            cloudDiskModuleRst.setRetCode(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED);
            cloudDiskModuleRst.setFailReason("Sync risk");
            return cloudDiskModuleRst;
        }
        if (C13452e.m80781L().m80917g1()) {
            C11839m.m70687e("BackupPhoneManagerTask", "Local ST invalid flag is true");
            cloudDiskModuleRst.setRetCode(2001);
            cloudDiskModuleRst.setFailReason("Local ST invalid flag is true");
            return cloudDiskModuleRst;
        }
        String strM66497P = m66497P();
        C12476a.a aVarM66495N = m66495N(this.f53297m, this.f52112v, cloudDiskModuleRst);
        if (aVarM66495N == null) {
            cloudDiskModuleRst.setRetCode(-1);
            cloudDiskModuleRst.setFailReason("backupInfo is null");
            C11839m.m70688i("BackupPhoneManagerTask", "backupInfo is null");
            return cloudDiskModuleRst;
        }
        String str = this.f52106p + File.separator + this.f52112v + SnapshotDBManager.SUFFIX_DATABASE_NAME;
        int iM74880c = aVarM66495N.m74880c();
        C11046a.m66594b(this.f53297m, C11046a.m66595c(iM74880c, this.f52112v, true));
        cloudDiskModuleRst.setTotalNum(iM74880c);
        C11839m.m70688i("BackupPhoneManagerTask", "backupData,totalNum:" + iM74880c);
        if (iM74880c == 0) {
            cloudDiskModuleRst.setRetCode(1);
            cloudDiskModuleRst.setFailReason("backupInfo totalNum is 0, no change occurred");
            C11839m.m70688i("BackupPhoneManagerTask", "backupInfo totalNum is 0, no change occurred");
            return cloudDiskModuleRst;
        }
        CloudDiskModuleRst cloudDiskModuleRstM66498Q = m66498Q(iM74880c, str, strM66497P, this.f52112v + SnapshotDBManager.SUFFIX_DATABASE_NAME, cloudDiskModuleRst, this.f52112v);
        if (cloudDiskModuleRstM66498Q.getRetCode() == -1) {
            return cloudDiskModuleRstM66498Q;
        }
        if (this.f53298n == -1) {
            cloudDiskModuleRstM66498Q.setSuccessNum(aVarM66495N.m74880c());
            cloudDiskModuleRstM66498Q.setRetCode(-1);
            C11839m.m70688i("BackupPhoneManagerTask", "backupData failed,returnCode:" + cloudDiskModuleRstM66498Q.getRetCode());
            return cloudDiskModuleRstM66498Q;
        }
        if (m68511i()) {
            cloudDiskModuleRstM66498Q.setSuccessNum(aVarM66495N.m74880c());
            cloudDiskModuleRstM66498Q.setRetCode(3);
            C11839m.m70688i("BackupPhoneManagerTask", "backupData is aborted");
            return cloudDiskModuleRstM66498Q;
        }
        cloudDiskModuleRstM66498Q.setRetCode(0);
        cloudDiskModuleRstM66498Q.setSuccessNum(aVarM66495N.m74880c());
        C11839m.m70688i("BackupPhoneManagerTask", "backupData success,successNum:" + iM74880c);
        return cloudDiskModuleRstM66498Q;
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: D */
    public void mo66479D(int i10, int i11, boolean z10) {
        SharedPreferences.Editor editorEdit = this.f53286e.edit();
        editorEdit.putString("autophonemanagerkey_endtime", String.valueOf(System.currentTimeMillis()));
        if (this.f53286e.getBoolean("autophonemanagerkeynotAllSucess", false)) {
            editorEdit.remove("autophonemanagerkeynotAllSucess");
            editorEdit.commit();
        }
        if (i10 == 1 || i11 > 0) {
            editorEdit.putString("autophonemanagerkey_time", String.valueOf(System.currentTimeMillis()));
            editorEdit.putInt("autophonemanagerkey_retcode", i10);
            editorEdit.commit();
        } else {
            editorEdit.putInt("autophonemanagerkey_retcode", i10);
            editorEdit.commit();
        }
        if (z10) {
            editorEdit.putBoolean("autophonemanagerkeynotAllSucess", true);
            editorEdit.commit();
        }
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: E */
    public void mo66480E() {
        SharedPreferences.Editor editorEdit = this.f53286e.edit();
        editorEdit.putInt("autophonemanagerkey_retcode", 4);
        editorEdit.commit();
        this.f52116z = "112";
        if (C11829c.m70611r0()) {
            return;
        }
        editorEdit.putBoolean("autophonemanagerkeynotAllSucess", true);
        editorEdit.commit();
    }

    /* renamed from: M */
    public final C12476a.a m66494M(Context context, String str, String str2) {
        if (m68511i() || this.f53298n == -1) {
            return null;
        }
        C12476a c12476a = new C12476a();
        AbstractC0218h0 abstractC0218h0M1484L = C0221j.m1484L(str, str2, "storHandlerForData");
        if (abstractC0218h0M1484L == null) {
            return null;
        }
        C12476a.a aVarM74875c = c12476a.m74875c(context, abstractC0218h0M1484L, null, str2);
        if (aVarM74875c.m74880c() < 1 && aVarM74875c.m74879b() <= 0) {
            abstractC0218h0M1484L.m1453b();
        }
        abstractC0218h0M1484L.mo1452a();
        return aVarM74875c;
    }

    /* renamed from: N */
    public final C12476a.a m66495N(Handler.Callback callback, String str, CloudDiskModuleRst cloudDiskModuleRst) {
        if (!C0221j.m1492b(this.f52106p, callback)) {
            return null;
        }
        C12476a.a aVarM66494M = m66494M(this.f53282a, this.f52106p, str);
        if (this.f53298n == -1) {
            cloudDiskModuleRst.setRetCode(-1);
            return aVarM66494M;
        }
        if (m68511i()) {
            C11839m.m70688i("BackupPhoneManagerTask", "backupData is aborted during createModuleDb");
            cloudDiskModuleRst.setRetCode(3);
        }
        return aVarM66494M;
    }

    /* renamed from: O */
    public final boolean m66496O() {
        String strM80950o = C13452e.m80781L().m80950o();
        String strM1593f = C0227m.m1593f(strM80950o);
        String strM1592e = C0227m.m1592e(strM80950o);
        boolean z10 = false;
        try {
            C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
            LsRequest lsRequest = new LsRequest();
            lsRequest.setServerPath("/BlockedBackup");
            boolean z11 = true;
            lsRequest.setFields(new String[]{"name"});
            lsRequest.setType(2);
            lsRequest.setRecursive(1);
            Iterator<Map<String, Object>> it = c13049a.m78718T(lsRequest).iterator();
            while (it.hasNext()) {
                if (String.valueOf(it.next().get("name")).equals(strM1592e)) {
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    map2.put("name", strM1593f);
                    map.put("/BlockedBackup/" + strM1592e, map2);
                    Result resultM78744j0 = c13049a.m78744j0(map);
                    int size = resultM78744j0.getSuccessList().size();
                    int size2 = resultM78744j0.getFailList().size();
                    C11839m.m70688i("BackupPhoneManagerTask", "rename file copyOfMoveRequest end, successList size = " + size + ", failList size = " + size2);
                    if (size2 > 0) {
                        z11 = false;
                    }
                }
            }
            z10 = z11;
        } catch (C9721b e10) {
            C11839m.m70688i("BackupPhoneManagerTask", "get dealWithCompatibility CException :" + e10.toString());
        } catch (Exception e11) {
            C11839m.m70688i("BackupPhoneManagerTask", "get dealWithCompatibility Exception :" + e11.toString());
        }
        C11839m.m70688i("BackupPhoneManagerTask", "dealWithCompatibility end isSuccess :" + z10);
        return z10;
    }

    /* renamed from: P */
    public final String m66497P() {
        if (C10028c.m62182c0().m62420y1()) {
            return "/Hicloud" + File.separator + C0227m.m1592e(C13452e.m80781L().m80950o());
        }
        return "/BlockedBackup" + File.separator + C0227m.m1593f(C13452e.m80781L().m80950o());
    }

    /* renamed from: Q */
    public final CloudDiskModuleRst m66498Q(int i10, String str, String str2, String str3, CloudDiskModuleRst cloudDiskModuleRst, String str4) {
        UploadReq uploadReq = new UploadReq();
        uploadReq.setFile(new File(str));
        TreeMap treeMap = new TreeMap();
        treeMap.put("itemcount", String.valueOf(i10));
        uploadReq.setAttribute(treeMap);
        if (C10028c.m62182c0().m62420y1()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            String str5 = File.separator;
            sb2.append(str5);
            sb2.append("sysdata");
            sb2.append(str5);
            sb2.append(str3);
            uploadReq.setServer(sb2.toString());
        } else {
            uploadReq.setServer(str2 + File.separator + str3);
        }
        uploadReq.setCallback(this.f52105B);
        try {
            this.f52114x.m74908d(uploadReq);
            cloudDiskModuleRst.setRetCode(0);
            return cloudDiskModuleRst;
        } catch (C9721b e10) {
            cloudDiskModuleRst.setRetCode(-1);
            cloudDiskModuleRst.setFailReason(e10.getMessage());
            C11839m.m70687e("BackupPhoneManagerTask", "upLoadSystemDataDb: " + e10.getMessage());
            return cloudDiskModuleRst;
        }
    }
}
