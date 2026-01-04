package p618rm;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.bean.SnapshotNode;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.cbs.bean.CBSFileInfo;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p746wn.C13622a;
import to.C13049a;

/* renamed from: rm.y */
/* loaded from: classes6.dex */
public class C12607y {

    /* renamed from: a */
    public CacheTask f58007a;

    /* renamed from: b */
    public List<CBSBackupRecord> f58008b;

    /* renamed from: c */
    public String f58009c;

    /* renamed from: d */
    public int f58010d;

    /* renamed from: e */
    public String f58011e;

    /* renamed from: f */
    public Context f58012f;

    /* renamed from: g */
    public C11322a f58013g;

    /* renamed from: h */
    public C13049a f58014h;

    /* renamed from: i */
    public SnapshotTreeManagementService f58015i;

    public C12607y(CacheTask cacheTask, List<CBSBackupRecord> list, String str, int i10, String str2, String str3, Context context) {
        new ArrayList();
        this.f58007a = cacheTask;
        this.f58008b = list;
        this.f58009c = str;
        this.f58010d = i10;
        this.f58012f = context;
        this.f58011e = str3;
        this.f58014h = new C13049a(EnumC12999a.CLOUD_BACKUP, str2);
        this.f58013g = new C11322a(str2);
        this.f58015i = SnapshotTreeManagementService.getInstance();
    }

    /* renamed from: a */
    public final void m76075a(Map<String, SnapshotBackupMeta> map, List<CBSAppInfo> list, Map<String, SnapshotBackupMeta> map2, String str) throws InterruptedException, C9721b {
        for (CBSAppInfo cBSAppInfo : list) {
            m76078d();
            String appId = cBSAppInfo.getAppId();
            SnapshotNode snapshotNodeCreateTreeRootNode = this.f58015i.createTreeRootNode(appId, map2.get(appId), 0L, this.f58015i.getRootNode(SnapshotBackupMeta.DB_ROOT_NODE_APPID, str).getRight());
            ArrayList arrayList = new ArrayList();
            for (CBSFileInfo cBSFileInfo : cBSAppInfo.getFileInfos()) {
                m76078d();
                arrayList.add(map.get(appId + File.separator + cBSFileInfo.getFileName()));
            }
            arrayList.addAll(SnapshotTreeUtil.getAppinfoMetas(cBSAppInfo));
            long jBuildSnapshotTree = this.f58015i.buildSnapshotTree(appId, snapshotNodeCreateTreeRootNode, arrayList);
            this.f58015i.saveTree(appId, snapshotNodeCreateTreeRootNode, str);
            this.f58015i.endTree(appId, str);
            C11839m.m70686d("CloudBackupV1RecordConvert", "convertCBSBackupRecordToSnapshotMeta appid = " + appId + ", file size = " + jBuildSnapshotTree);
        }
    }

    /* renamed from: b */
    public void m76076b() throws InterruptedException, C9721b, SQLException {
        List<CBSBackupRecord> list = this.f58008b;
        if (list == null || list.size() <= 0) {
            return;
        }
        C11839m.m70688i("CloudBackupV1RecordConvert", "convertCBSBackupRecordToSnapshotMeta begin");
        for (CBSBackupRecord cBSBackupRecord : this.f58008b) {
            m76078d();
            String backupId = cBSBackupRecord.getBackupId();
            try {
            } catch (Exception unused) {
                this.f58015i.deleteSnapshotDatabase(backupId);
                C11839m.m70689w("CloudBackupV1RecordConvert", "old backupRecord Id = " + backupId + ", check snapshot database error.");
            }
            if (this.f58015i.checkSuccessfulBackupRecordStatus(backupId)) {
                C11839m.m70688i("CloudBackupV1RecordConvert", "old backupRecord Id = " + backupId + ", snapshot database already exist.");
            } else {
                m76078d();
                C11839m.m70688i("CloudBackupV1RecordConvert", "convert old backup record Id = " + backupId);
                CBSBackupRecord cBSBackupRecordM76080f = m76080f(this.f58009c, this.f58010d, cBSBackupRecord);
                if (cBSBackupRecordM76080f != null) {
                    m76081g(backupId);
                    m76078d();
                    this.f58015i.createSnapshotBackupMetaTable(backupId);
                    this.f58015i.saveTree(SnapshotBackupMeta.DB_ROOT_NODE_APPID, this.f58015i.createDBRootNode(backupId), backupId);
                    List<CBSAppInfo> appIdInfos = cBSBackupRecordM76080f.getAppIdInfos();
                    if (appIdInfos != null) {
                        HashMap map = new HashMap();
                        ArrayList arrayList = new ArrayList();
                        for (CBSAppInfo cBSAppInfo : appIdInfos) {
                            m76078d();
                            String appId = cBSAppInfo.getAppId();
                            SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
                            snapshotBackupMeta.setData(appId);
                            snapshotBackupMeta.setRoot("");
                            snapshotBackupMeta.setName(appId);
                            snapshotBackupMeta.setSize(cBSAppInfo.getSize());
                            map.put(appId, snapshotBackupMeta);
                            for (CBSFileInfo cBSFileInfo : cBSAppInfo.getFileInfos()) {
                                m76078d();
                                arrayList.add(this.f58011e + appId + File.separator + cBSFileInfo.getFileName());
                            }
                        }
                        m76075a(m76077c(arrayList), appIdInfos, map, backupId);
                        this.f58015i.updateBackupRecordMetaSuccessful(backupId);
                    } else {
                        if (cBSBackupRecord.getStatus() != 1 && cBSBackupRecord.getStatus() != 7) {
                            throw new C9721b(3107, "convert CBSBackupRecords appInfos is null.", "convertOldCBSBackupRecords");
                        }
                        C11839m.m70689w("CloudBackupV1RecordConvert", "convert CBSBackupRecords appInfos is null");
                    }
                } else {
                    if (cBSBackupRecord.getStatus() != 1 && cBSBackupRecord.getStatus() != 7) {
                        throw new C9721b(3107, "convert CBSBackupRecords query backupRecordDetailReq return null.", "convertOldCBSBackupRecords");
                    }
                    C11839m.m70689w("CloudBackupV1RecordConvert", "convert CBSBackupRecords query backupRecordDetailReq return null");
                }
            }
        }
        C11839m.m70688i("CloudBackupV1RecordConvert", "convertCBSBackupRecordToSnapshotMeta end");
    }

    /* renamed from: c */
    public final Map<String, SnapshotBackupMeta> m76077c(List<String> list) throws InterruptedException, C9721b {
        int i10;
        Iterator<Map<String, Object>> it;
        C12607y c12607y = this;
        HashMap map = new HashMap();
        if (list.isEmpty()) {
            return map;
        }
        int size = list.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            m76078d();
            int i13 = i12 * 200;
            int i14 = i13 + 200;
            if (i14 > size) {
                i14 = size;
            }
            List<String> listSubList = list.subList(i13, i14);
            Result resultM78709H = c12607y.f58014h.m78709H((String[]) listSubList.toArray(new String[listSubList.size()]), new String[]{"name", "md5", "size", JsbMapKeyNames.H5_LOC, "encoded"});
            List<Map<String, Object>> successList = resultM78709H.getSuccessList();
            List<Result.ErrMsg> failList = resultM78709H.getFailList();
            if (!failList.isEmpty()) {
                c12607y.m76082h(failList);
            }
            Iterator<Map<String, Object>> it2 = successList.iterator();
            while (it2.hasNext()) {
                Map<String, Object> next = it2.next();
                try {
                    SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
                    String str = (String) next.get(JsbMapKeyNames.H5_LOC);
                    String rootPath = ICBUtil.getRootPath(str);
                    i10 = size;
                    try {
                        String strSubstring = SafeString.substring(str, rootPath.length());
                        snapshotBackupMeta.setRoot(rootPath);
                        snapshotBackupMeta.setData(strSubstring);
                        String str2 = File.separator;
                        int iLastIndexOf = strSubstring.lastIndexOf(str2);
                        snapshotBackupMeta.setName(SafeString.substring(strSubstring, iLastIndexOf <= 0 ? 0 : iLastIndexOf + 1));
                        String strSubstring2 = SafeString.substring((String) next.get("name"), c12607y.f58011e.length());
                        int iIndexOf = strSubstring2.indexOf(str2);
                        snapshotBackupMeta.setCloudPath(SafeString.substring(strSubstring2, iIndexOf <= 0 ? 0 : iIndexOf + 1));
                        snapshotBackupMeta.setStatus(5);
                        it = it2;
                        try {
                            snapshotBackupMeta.setType(6L);
                            snapshotBackupMeta.setSize(C0241z.m1688f((String) next.get("size")));
                            if (m76079e()) {
                                int iLastIndexOf2 = strSubstring2.lastIndexOf(95);
                                String strReplace = iLastIndexOf2 > 0 ? SafeString.substring(strSubstring2, iLastIndexOf2).replace("_", "") : "";
                                snapshotBackupMeta.setHash2(strReplace);
                                snapshotBackupMeta.setCloudHash(strReplace);
                            } else {
                                snapshotBackupMeta.setHash1((String) next.get("md5"));
                                snapshotBackupMeta.setCloudHash((String) next.get("md5"));
                            }
                            String str3 = (String) next.get("encoded");
                            snapshotBackupMeta.setCloudEncoded(TextUtils.isEmpty(str3) ? 0L : C0241z.m1688f(str3));
                            map.put(strSubstring2, snapshotBackupMeta);
                        } catch (Exception unused) {
                            C11839m.m70689w("CloudBackupV1RecordConvert", "getLeafNodeBackupMetas create backup meta error." + next);
                            c12607y = this;
                            it2 = it;
                            size = i10;
                        }
                    } catch (Exception unused2) {
                        it = it2;
                        C11839m.m70689w("CloudBackupV1RecordConvert", "getLeafNodeBackupMetas create backup meta error." + next);
                        c12607y = this;
                        it2 = it;
                        size = i10;
                    }
                } catch (Exception unused3) {
                    i10 = size;
                }
                c12607y = this;
                it2 = it;
                size = i10;
            }
            i12++;
            c12607y = this;
            i11 = i14;
        }
        return map;
    }

    /* renamed from: d */
    public final void m76078d() throws InterruptedException, C9721b {
        CacheTask cacheTask = this.f58007a;
        if (cacheTask != null) {
            cacheTask.isCancel();
        }
    }

    /* renamed from: e */
    public final boolean m76079e() {
        return !C10028c.m62182c0().m62420y1();
    }

    /* renamed from: f */
    public final CBSBackupRecord m76080f(String str, int i10, CBSBackupRecord cBSBackupRecord) throws C9721b {
        try {
            try {
                this.f58013g.m68011R(true);
                return this.f58013g.m68001H(str, i10, cBSBackupRecord.getBackupId(), true, false);
            } catch (C9721b e10) {
                if (cBSBackupRecord.getStatus() != 1) {
                    throw e10;
                }
                C11839m.m70689w("CloudBackupV1RecordConvert", "query old backupRecordDetailReq exception");
                this.f58013g.m68011R(false);
                return null;
            }
        } finally {
            this.f58013g.m68011R(false);
        }
    }

    /* renamed from: g */
    public final void m76081g(String str) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02006"), "querySingleRecordDetail", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66666v("isSuccess", "0", "1", "query one backup record detail, backupId: " + str);
        C13622a.m81968n(this.f58012f, c11060cM66626a);
    }

    /* renamed from: h */
    public final void m76082h(List<Result.ErrMsg> list) throws C9721b {
        C11839m.m70688i("CloudBackupV1RecordConvert", "report getattr fail file");
        int i10 = 0;
        for (Result.ErrMsg errMsg : list) {
            C11839m.m70689w("CloudBackupV1RecordConvert", "getattr fail file err: " + errMsg.toString());
            if (errMsg.getErrCode() != 103) {
                throw new C9721b(3207, errMsg.getErrCode(), errMsg.getErrMsg());
            }
            i10++;
        }
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02009"), "restoreFileExits", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66666v("isSuccess", "0", "1", "query vfs failed, file path is not exits, count: " + i10);
        C13622a.m81968n(this.f58012f, c11060cM66626a);
    }

    public C12607y(List<CBSBackupRecord> list, String str, int i10, String str2, String str3, Context context) {
        new ArrayList();
        this.f58008b = list;
        this.f58009c = str;
        this.f58010d = i10;
        this.f58012f = context;
        this.f58011e = str3;
        this.f58014h = new C13049a(EnumC12999a.CLOUD_BACKUP, str2);
        this.f58013g = new C11322a(str2);
        this.f58015i = SnapshotTreeManagementService.getInstance();
    }
}
