package p426kd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.hicloud.clouddisk.logic.media.model.RemoteFile;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import com.huawei.hicloud.request.opengw.bean.Result;
import fk.C9721b;
import gp.C10028c;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import je.C10812z;
import md.C11439b;
import p015ak.C0227m;
import p020ap.C1007b;
import p513o8.C11826a;
import p514o9.C11839m;
import p548p8.C12120a;
import p652t9.EnumC12999a;
import p684un.C13223b;
import p709vj.C13452e;
import to.C13049a;

@CBServiceTask(request = 55000018, response = 66000018)
/* renamed from: kd.d */
/* loaded from: classes3.dex */
public class C11030d extends AbstractC11027a {

    /* renamed from: C */
    public List<RemoteFile> f52118C;

    /* renamed from: D */
    public C12120a f52119D;

    /* renamed from: E */
    public int f52120E;

    /* renamed from: Q */
    private boolean m66499Q() {
        String strM80950o = C13452e.m80781L().m80950o();
        String strM1593f = C0227m.m1593f(strM80950o);
        String strM1592e = C0227m.m1592e(strM80950o);
        boolean z10 = false;
        try {
            C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
            LsRequest lsRequest = new LsRequest();
            lsRequest.setServerPath("/RecordBackup");
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
                    map.put("/RecordBackup/" + strM1592e, map2);
                    Result resultM78744j0 = c13049a.m78744j0(map);
                    int size = resultM78744j0.getSuccessList().size();
                    int size2 = resultM78744j0.getFailList().size();
                    C11839m.m70688i("BackupRecordingTask", "rename file copyOfMoveRequest end, successList size = " + size + ", failList size = " + size2);
                    if (size2 > 0) {
                        z11 = false;
                    }
                }
            }
            z10 = z11;
        } catch (C9721b e10) {
            C11839m.m70688i("BackupRecordingTask", "get dealWithCompatibility CException" + e10.toString());
        } catch (Exception e11) {
            C11839m.m70688i("BackupRecordingTask", "get dealWithCompatibility Exception" + e11.toString());
        }
        C11839m.m70688i("BackupRecordingTask", "dealWithCompatibility end isSuccess:" + z10);
        return z10;
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: C */
    public CloudDiskModuleRst mo66478C() {
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        if (!m66503P(cloudDiskModuleRst)) {
            return cloudDiskModuleRst;
        }
        ArrayList arrayList = new ArrayList();
        if (!m66500M(this.f53282a, "recording", this.f53297m, arrayList)) {
            C11839m.m70688i("BackupRecordingTask", "backupData done");
            cloudDiskModuleRst.setRetCode(2);
            return cloudDiskModuleRst;
        }
        if (this.f53297m.m68524c(this.f52112v)) {
            C11839m.m70688i("BackupRecordingTask", "backupData is aborted");
            cloudDiskModuleRst.setRetCode(3);
            return cloudDiskModuleRst;
        }
        Map<String, String> mapM72674f = new C12120a().m72674f(this.f53282a);
        m66508V(arrayList, mapM72674f.get("out"), mapM72674f.get("in"));
        try {
            if (!m66501N()) {
                cloudDiskModuleRst.setRetCode(-2);
                cloudDiskModuleRst.setFailReason("start SERVER_STORAGE_LACK");
                C11839m.m70689w("BackupRecordingTask", "start SERVER_STORAGE_LACK");
                return cloudDiskModuleRst;
            }
            if (this.f53297m.m68524c(this.f52112v)) {
                cloudDiskModuleRst.setRetCode(3);
                C11839m.m70689w("BackupRecordingTask", "start wifi disconnected");
                return cloudDiskModuleRst;
            }
            if (this.f53297m.m68523b()) {
                C11839m.m70688i("BackupRecordingTask", "backupData is aborted");
                cloudDiskModuleRst.setRetCode(3);
                return cloudDiskModuleRst;
            }
            int size = this.f52118C.size();
            if (size == 0) {
                C11839m.m70688i("BackupRecordingTask", "backupFilesNum no change");
                cloudDiskModuleRst.setRetCode(1);
                cloudDiskModuleRst.setFailReason("backupFilesNum no change");
                return cloudDiskModuleRst;
            }
            Iterator<RemoteFile> it = this.f52118C.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RemoteFile next = it.next();
                if (m68511i()) {
                    C11839m.m70687e("BackupRecordingTask", "backupData is aborted during user cancel");
                    cloudDiskModuleRst.setRetCode(3);
                    break;
                }
                if (!m66502O(cloudDiskModuleRst)) {
                    return cloudDiskModuleRst;
                }
                if (this.f53297m.m68524c(this.f52112v)) {
                    C11839m.m70689w("BackupRecordingTask", "backupData is aborted during wifi disconnected");
                    cloudDiskModuleRst.setRetCode(3);
                    break;
                }
                try {
                    UploadReq uploadReqM15457b = next.m15457b();
                    uploadReqM15457b.setCallback(this.f52105B);
                    if (CloudSyncUtil.m16010g0(next.m15460e())) {
                        C11839m.m70688i("BackupRecordingTask", "during recording has EmojiCharacter ignore");
                    } else {
                        this.f52114x.m74908d(uploadReqM15457b);
                        i10++;
                    }
                } catch (C9721b e10) {
                    C11839m.m70687e("BackupRecordingTask", "BackupRecordingTask CException = " + e10.getMessage());
                    C10812z.m65838g(this.f53282a, "recording", -1, "112", e10.getMessage(), "03009", "local_upload", this.f52115y);
                }
            }
            m66505S(cloudDiskModuleRst, size, i10);
            C11839m.m70688i("BackupRecordingTask", "backupFilesNum :" + size + ", successNum :" + i10);
            Context context = this.f53282a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(size);
            C13223b.m79473a(context, "CLOUDBACKUP_BACKUPNUM_ALL_RECORDING", sb2.toString());
            UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_BACKUPNUM_ALL_RECORDING", "value", "" + size);
            C13223b.m79473a(this.f53282a, "CLOUDBACKUP_BACKUPNUM_SUCESS_RECORDING", "" + i10);
            UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_BACKUPNUM_SUCESS_RECORDING", "value", "" + i10);
            return cloudDiskModuleRst;
        } catch (C9721b e11) {
            cloudDiskModuleRst.setRetCode(-1);
            cloudDiskModuleRst.setFailReason(e11.getMessage());
            C11839m.m70687e("BackupRecordingTask", "start CException FAILED :" + e11.getMessage());
            return cloudDiskModuleRst;
        }
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: D */
    public void mo66479D(int i10, int i11, boolean z10) {
        SharedPreferences.Editor editorEdit = this.f53286e.edit();
        if (this.f53286e.getBoolean("autorecordingkeynotAllSucess", false)) {
            editorEdit.remove("autorecordingkeynotAllSucess");
            editorEdit.commit();
        }
        if (i10 == 1 || i11 > 0) {
            editorEdit.putString("autorecordingkey_time", String.valueOf(System.currentTimeMillis()));
            editorEdit.putInt("autorecordingkey_retcode", i10);
            editorEdit.commit();
        } else {
            editorEdit.putInt("autorecordingkey_retcode", i10);
            editorEdit.commit();
        }
        if (z10) {
            editorEdit.putBoolean("autorecordingkeynotAllSucess", true);
            editorEdit.commit();
        }
        if (i10 == 0 && CloudSyncUtil.m15954H0(this.f53282a)) {
            editorEdit.putLong("recordingtimestamp", 0L);
            editorEdit.commit();
        }
    }

    @Override // p426kd.AbstractC11027a
    /* renamed from: E */
    public void mo66480E() {
        this.f52118C = new ArrayList(10);
        this.f52119D = new C12120a();
        SharedPreferences.Editor editorEdit = this.f53286e.edit();
        editorEdit.putInt("autorecordingkey_retcode", 4);
        editorEdit.commit();
        this.f52116z = "112";
        editorEdit.putBoolean("autorecordingkeynotAllSucess", true);
        editorEdit.commit();
    }

    /* renamed from: M */
    public final boolean m66500M(Context context, String str, Handler.Callback callback, List<RemoteFile> list) {
        List<RemoteFile> listM70468s;
        C11826a c11826a = new C11826a();
        try {
            if (C10028c.m62182c0().m62420y1()) {
                listM70468s = c11826a.m70468s(str, "/Hicloud/" + C0227m.m1592e(C13452e.m80781L().m80950o()) + "/media/recording");
            } else {
                listM70468s = c11826a.m70468s(str, "/RecordBackup/" + C0227m.m1593f(C13452e.m80781L().m80950o()));
            }
            if (((C11439b.a) callback).m68523b()) {
                return false;
            }
            list.addAll(listM70468s);
            return true;
        } catch (Exception unused) {
            C11839m.m70689w("BackupRecordingTask", "get cloud Exception");
            return false;
        }
    }

    /* renamed from: N */
    public final boolean m66501N() throws C9721b {
        Iterator<RemoteFile> it = this.f52118C.iterator();
        long jM15462g = 0;
        while (it.hasNext()) {
            jM15462g += it.next().m15462g();
        }
        return C1007b.m5980s().m6015f(this.f53282a, jM15462g);
    }

    /* renamed from: O */
    public final boolean m66502O(CloudDiskModuleRst cloudDiskModuleRst) {
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70688i("BackupRecordingTask", "backup reording sync risk");
            C11839m.m70688i("BackupRecordingTask", "Sync risk");
            cloudDiskModuleRst.setRetCode(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED);
            cloudDiskModuleRst.setFailReason("Sync risk");
            return false;
        }
        if (!C13452e.m80781L().m80917g1()) {
            return true;
        }
        C11839m.m70688i("BackupRecordingTask", "backup reording st invalid");
        C11839m.m70688i("BackupRecordingTask", "Local ST invalid flag is true");
        cloudDiskModuleRst.setRetCode(2001);
        cloudDiskModuleRst.setFailReason("Local ST invalid flag is true");
        return false;
    }

    /* renamed from: P */
    public final boolean m66503P(CloudDiskModuleRst cloudDiskModuleRst) {
        if (C10028c.m62182c0().m62420y1() || m66499Q()) {
            return true;
        }
        C11839m.m70689w("BackupRecordingTask", "dealWithCompatibility fail no backup");
        cloudDiskModuleRst.setRetCode(2);
        return false;
    }

    /* renamed from: R */
    public final void m66504R(List<RemoteFile> list, List<RemoteFile> list2, List<RemoteFile> list3) {
        if (list.isEmpty() && list2.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        arrayList.addAll(list);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        arrayList2.retainAll(list3);
        arrayList.removeAll(arrayList2);
        m66511Y(arrayList, list3, m66506T(arrayList));
    }

    /* renamed from: S */
    public final void m66505S(CloudDiskModuleRst cloudDiskModuleRst, int i10, int i11) {
        int i12 = i10 - i11;
        if (cloudDiskModuleRst.getRetCode() != 3) {
            if (i10 == 0) {
                cloudDiskModuleRst.setRetCode(1);
                C11839m.m70688i("BackupRecordingTask", "backupFilesNum noChange");
            } else if (i11 == 0) {
                cloudDiskModuleRst.setRetCode(-1);
                C11839m.m70688i("BackupRecordingTask", "backupFiles failed");
            } else if (i10 == i11) {
                cloudDiskModuleRst.setRetCode(0);
                C11839m.m70688i("BackupRecordingTask", "backupFiles success");
            } else if (i10 != i11) {
                cloudDiskModuleRst.setRetCode(2);
                C11839m.m70688i("BackupRecordingTask", "backupFiles succeed partly , succeedNum is" + i11 + ",failedNum is " + i12 + ",totalNum is " + i10);
            }
        }
        cloudDiskModuleRst.setSuccessNum(i11);
        cloudDiskModuleRst.setFailNum(i12);
        cloudDiskModuleRst.setTotalNum(i10);
    }

    /* renamed from: T */
    public final List<String> m66506T(List<RemoteFile> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<RemoteFile> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m15460e().toLowerCase(Locale.getDefault()));
        }
        return arrayList;
    }

    /* renamed from: U */
    public final String m66507U(String str, List<String> list, List<String> list2) {
        String strM72673e = this.f52119D.m72673e(this.f52120E, str);
        if (this.f52119D.m72675g(strM72673e, list, list2)) {
            this.f52120E++;
            return strM72673e;
        }
        this.f52120E++;
        return m66507U(str, list, list2);
    }

    /* renamed from: V */
    public final void m66508V(List<RemoteFile> list, String str, String str2) {
        C11826a c11826a = new C11826a();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.addAll(c11826a.m70463k(str, "recording"));
        }
        ArrayList arrayList2 = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList2.addAll(c11826a.m70463k(str2, "recording"));
        }
        C11839m.m70688i("BackupRecordingTask", "get sd recording file outMedia:" + arrayList.size() + ", inMedia:" + arrayList2.size() + ", cloud size:" + list.size());
        m66504R(arrayList, arrayList2, list);
    }

    /* renamed from: W */
    public final List<RemoteFile> m66509W(String str, List<RemoteFile> list) {
        ArrayList arrayList = new ArrayList(10);
        for (RemoteFile remoteFile : list) {
            if (remoteFile.m15460e().equalsIgnoreCase(str)) {
                arrayList.add(remoteFile);
            }
        }
        return arrayList;
    }

    /* renamed from: X */
    public final void m66510X(String str, String str2, RemoteFile remoteFile, List<String> list, List<String> list2) {
        List<RemoteFile> listM66509W = m66509W(str2, this.f52118C);
        if (listM66509W.isEmpty()) {
            this.f52118C.add(remoteFile);
            return;
        }
        if (!m66513a0(remoteFile.m15462g(), listM66509W)) {
            String strM66507U = m66507U(str, list, list2);
            File fileM72676h = this.f52119D.m72676h(remoteFile.m15458c(), strM66507U);
            if (!fileM72676h.getName().equalsIgnoreCase(strM66507U)) {
                C11839m.m70687e("BackupRecordingTask", "handerName rename fail!");
                return;
            } else {
                remoteFile.m15467l(fileM72676h, strM66507U, C10279b.m63452a(remoteFile.m15458c()));
                this.f52118C.add(remoteFile);
            }
        }
        C11839m.m70688i("BackupRecordingTask", "handerName mediaSize:" + remoteFile.m15462g());
    }

    /* renamed from: Y */
    public final void m66511Y(List<RemoteFile> list, List<RemoteFile> list2, List<String> list3) {
        List<String> listM66506T = m66506T(list2);
        for (RemoteFile remoteFile : list) {
            String strM15460e = remoteFile.m15460e();
            this.f52120E = 0;
            if (m66512Z(strM15460e, list2)) {
                String strM66507U = m66507U(strM15460e, list3, listM66506T);
                File fileM72676h = this.f52119D.m72676h(remoteFile.m15458c(), strM66507U);
                if (fileM72676h.getName().equalsIgnoreCase(strM66507U)) {
                    remoteFile.m15467l(fileM72676h, strM66507U, C10279b.m63452a(remoteFile.m15458c()));
                    m66510X(strM15460e, strM66507U, remoteFile, list3, listM66506T);
                } else {
                    C11839m.m70687e("BackupRecordingTask", "handleDiffName rename fail!");
                }
            } else {
                m66510X(strM15460e, strM15460e, remoteFile, list3, listM66506T);
            }
        }
        C11839m.m70688i("BackupRecordingTask", "handleDiffName backupfiles:" + this.f52118C.size());
    }

    /* renamed from: Z */
    public final boolean m66512Z(String str, List<RemoteFile> list) {
        Iterator<RemoteFile> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().m15460e().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a0 */
    public final boolean m66513a0(long j10, List<RemoteFile> list) {
        Iterator<RemoteFile> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().m15462g() == j10) {
                return true;
            }
        }
        return false;
    }
}
