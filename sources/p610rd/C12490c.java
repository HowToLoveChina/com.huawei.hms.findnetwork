package p610rd;

import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.drive.clouddisk.util.FileUtil;
import com.huawei.cloud.services.drive.model.File;
import com.huawei.cloud.services.drive.model.FileList;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import je.C10810x;
import p252e9.C9428e;
import p292fn.C9733f;
import p363ia.C10463a;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import pa.C12123a;
import sa.C12766a;

/* renamed from: rd.c */
/* loaded from: classes3.dex */
public class C12490c extends AbstractC12367d {

    /* renamed from: a */
    public CountDownLatch f57504a;

    /* renamed from: b */
    public long f57505b;

    /* renamed from: c */
    public String f57506c;

    /* renamed from: d */
    public boolean f57507d = false;

    /* renamed from: e */
    public volatile boolean f57508e = false;

    public C12490c(long j10) {
        this.f57505b = 0L;
        this.f57505b = j10;
    }

    /* renamed from: d */
    private String m74972d(DriveExpand driveExpand) {
        try {
            File file = (File) new SyncDriveRequest(driveExpand.files().get(SnapshotBackupMeta.DB_ROOT_NODE_APPID).setFields2("id")).execute();
            if (file != null && !TextUtils.isEmpty(file.getId())) {
                C11839m.m70686d("QueryDuplicateFileTask", "rootId: " + file.getId());
                return file.getId();
            }
            C11839m.m70687e("QueryDuplicateFileTask", "checkRootFileId return empty");
            return null;
        } catch (Exception e10) {
            C11839m.m70687e("QueryDuplicateFileTask", "rootId error: " + e10.toString());
            m74973f(this.f57506c, "rootId error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    private void m74973f(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str2);
        C9428e.m59118h().m59135r("query_duplicate_file", str, linkedHashMap);
    }

    /* renamed from: g */
    private void m74974g(String str, String str2, int i10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("next_cursor", str2);
        linkedHashMap.put("list_size", String.valueOf(i10));
        C9428e.m59118h().m59135r("query_duplicate_file", str, linkedHashMap);
    }

    /* renamed from: c */
    public boolean m74975c() {
        return this.f57507d;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        DriveExpand.FilesExpand.ListDuplicate listDuplicate;
        long j10;
        this.f57506c = C11058a.m66627b("07039");
        try {
            try {
                C11839m.m70688i("QueryDuplicateFileTask", "begin");
            } catch (Exception e10) {
                this.f57507d = false;
                C11839m.m70687e("QueryDuplicateFileTask", "file exception: " + e10.toString());
                m74973f(this.f57506c, "queryDuplicateFile error: " + e10.getMessage());
                C11839m.m70688i("QueryDuplicateFileTask", "end");
                CountDownLatch countDownLatch = this.f57504a;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
            if (!C10810x.m65809e(this.f57505b)) {
                C11839m.m70688i("QueryDuplicateFileTask", "current time is not allow request");
                C11839m.m70688i("QueryDuplicateFileTask", "end");
                CountDownLatch countDownLatch2 = this.f57504a;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                this.f57508e = true;
                return;
            }
            C12123a c12123a = new C12123a();
            c12123a.m72693i("UPDATE diskDuplicateFile SET isCloudExist = 0");
            DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
            if (driveExpandM64282d == null) {
                C11839m.m70687e("QueryDuplicateFileTask", "init driveExpand null");
                C11839m.m70688i("QueryDuplicateFileTask", "end");
                CountDownLatch countDownLatch3 = this.f57504a;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                this.f57508e = true;
                return;
            }
            String strM74972d = m74972d(driveExpandM64282d);
            DriveExpand.FilesExpand.ListDuplicate listDuplicate2 = driveExpandM64282d.filesExpand().listDuplicate();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashMap<String, FileModel> mapM72697m = c12123a.m72697m(1);
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                C11839m.m70687e("QueryDuplicateFileTask", "init HiCloudSysParamMap null");
                C11839m.m70688i("QueryDuplicateFileTask", "end");
                CountDownLatch countDownLatch4 = this.f57504a;
                if (countDownLatch4 != null) {
                    countDownLatch4.countDown();
                }
                this.f57508e = true;
                return;
            }
            long spaceCleanDupFileThreshold = hiCloudSysParamMapM60757p.getSpaceCleanDupFileThreshold();
            if (spaceCleanDupFileThreshold <= 0) {
                spaceCleanDupFileThreshold = 2097152;
            }
            int spaceCleanDupFileMaxNum = hiCloudSysParamMapM60757p.getSpaceCleanDupFileMaxNum();
            String nextCursor = null;
            while (true) {
                FileList fileList = (FileList) new SyncDriveRequest(listDuplicate2.setCursor(nextCursor).setPageSize(100).setMinLength(Long.valueOf(spaceCleanDupFileThreshold)).setFields2("nextCursor,files(id,fileName,editedTime,parentFolder,mimeType,size,md5)")).execute();
                List<File> files = fileList.getFiles();
                if (files != null) {
                    listDuplicate = listDuplicate2;
                    StringBuilder sb2 = new StringBuilder();
                    j10 = spaceCleanDupFileThreshold;
                    sb2.append("cloudFileList size: ");
                    sb2.append(files.size());
                    C11839m.m70688i("QueryDuplicateFileTask", sb2.toString());
                    m74974g(this.f57506c, nextCursor, files.size());
                    for (File file : files) {
                        if (file != null) {
                            FileModel fileModelM65816l = C10810x.m65816l(file);
                            FileModel fileModel = mapM72697m.get(fileModelM65816l.getFileId());
                            if (fileModel != null) {
                                if (!TextUtils.isEmpty(fileModel.getThumbnailPath())) {
                                    fileModelM65816l.setThumbnailPath(fileModel.getThumbnailPath());
                                }
                                fileModel.setIsCloudExist("1");
                            }
                            arrayList.add(fileModelM65816l);
                            if (file.getParentFolder() != null && file.getParentFolder().size() > 0) {
                                String str = file.getParentFolder().get(0);
                                if (strM74972d == null || strM74972d.equals(str)) {
                                    fileModelM65816l.setFileParentName(FileUtil.m16353c(true, ""));
                                } else {
                                    arrayList2.add(str);
                                }
                            }
                        }
                    }
                } else {
                    listDuplicate = listDuplicate2;
                    j10 = spaceCleanDupFileThreshold;
                }
                nextCursor = fileList.getNextCursor();
                if (TextUtils.isEmpty(nextCursor) || arrayList.size() > spaceCleanDupFileMaxNum) {
                    break;
                }
                listDuplicate2 = listDuplicate;
                spaceCleanDupFileThreshold = j10;
            }
            if (!arrayList.isEmpty()) {
                c12123a.m72699o(arrayList.size() > spaceCleanDupFileMaxNum ? arrayList.subList(0, spaceCleanDupFileMaxNum) : new ArrayList<>(arrayList), 1);
            }
            c12123a.m72693i("DELETE FROM diskDuplicateFile WHERE isCloudExist = 0");
            if (!arrayList2.isEmpty()) {
                List<String> listSubList = arrayList2.size() > spaceCleanDupFileMaxNum ? arrayList2.subList(0, spaceCleanDupFileMaxNum) : new ArrayList(arrayList2);
                HashMap map = new HashMap();
                for (String str2 : listSubList) {
                    if (!map.containsKey(str2)) {
                        map.put(str2, "");
                    }
                }
                C12766a.m76613b(1, map);
            }
            this.f57507d = true;
            C10028c.m62182c0().m62260P2(System.currentTimeMillis());
            C12766a.m76612a(mapM72697m);
        } finally {
            C11839m.m70688i("QueryDuplicateFileTask", "end");
            CountDownLatch countDownLatch5 = this.f57504a;
            if (countDownLatch5 != null) {
                countDownLatch5.countDown();
            }
            this.f57508e = true;
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        C11839m.m70688i("QueryDuplicateFileTask", "task cancel.");
        this.f57508e = true;
        return super.cancel();
    }

    /* renamed from: e */
    public boolean m74976e() {
        return this.f57508e;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_DUPLICATE_FILE;
    }

    public void setCount(CountDownLatch countDownLatch) {
        this.f57504a = countDownLatch;
    }
}
