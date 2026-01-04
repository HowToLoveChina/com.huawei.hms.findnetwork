package p610rd;

import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.drive.clouddisk.util.FileUtil;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.model.File;
import com.huawei.cloud.services.drive.model.FileList;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

/* renamed from: rd.b */
/* loaded from: classes3.dex */
public class C12489b extends AbstractC12367d {

    /* renamed from: a */
    public CountDownLatch f57499a;

    /* renamed from: b */
    public long f57500b;

    /* renamed from: c */
    public String f57501c;

    /* renamed from: d */
    public boolean f57502d = false;

    /* renamed from: e */
    public volatile boolean f57503e = false;

    public C12489b(long j10) {
        this.f57500b = 0L;
        this.f57500b = j10;
    }

    /* renamed from: c */
    public boolean m74967c() {
        return this.f57502d;
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.huawei.cloud.services.drive.Drive$Files$List] */
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        Drive.Files.List list;
        Iterator<File> it;
        this.f57501c = C11058a.m66627b("07039");
        try {
            try {
                C11839m.m70688i("QueryBigFileTask", "begin");
            } catch (Exception e10) {
                C11839m.m70688i("QueryBigFileTask", "exception: " + e10.getMessage());
                this.f57502d = false;
                m74970f(this.f57501c, "queryBigFile error: " + e10.getMessage());
                C11839m.m70688i("QueryBigFileTask", "end");
                CountDownLatch countDownLatch = this.f57499a;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
            if (!C10810x.m65808d(this.f57500b)) {
                C11839m.m70688i("QueryBigFileTask", "current time is not allow request");
                C11839m.m70688i("QueryBigFileTask", "end");
                CountDownLatch countDownLatch2 = this.f57499a;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                this.f57503e = true;
                return;
            }
            C12123a c12123a = new C12123a();
            c12123a.m72693i("UPDATE diskBigFile SET isCloudExist = 0");
            DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
            if (driveExpandM64282d == null) {
                C11839m.m70687e("QueryBigFileTask", "init driveExpand null");
                C11839m.m70688i("QueryBigFileTask", "end");
                CountDownLatch countDownLatch3 = this.f57499a;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                this.f57503e = true;
                return;
            }
            Drive.Files.List list2 = driveExpandM64282d.files().list();
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                C11839m.m70687e("QueryBigFileTask", "init HiCloudSysParamMap null");
                C11839m.m70688i("QueryBigFileTask", "end");
                CountDownLatch countDownLatch4 = this.f57499a;
                if (countDownLatch4 != null) {
                    countDownLatch4.countDown();
                }
                this.f57503e = true;
                return;
            }
            long spaceCleanDiskBigFileThreshold = hiCloudSysParamMapM60757p.getSpaceCleanDiskBigFileThreshold();
            if (spaceCleanDiskBigFileThreshold <= 0) {
                spaceCleanDiskBigFileThreshold = 52428800;
            }
            int spaceCleanBigFileMaxNum = hiCloudSysParamMapM60757p.getSpaceCleanBigFileMaxNum();
            String str = "fileSize >= " + String.valueOf(spaceCleanDiskBigFileThreshold);
            ArrayList arrayList = new ArrayList();
            String strM74968d = m74968d(driveExpandM64282d);
            C11839m.m70686d("QueryBigFileTask", "getRootId: " + strM74968d);
            ArrayList arrayList2 = new ArrayList();
            HashMap<String, FileModel> mapM72697m = c12123a.m72697m(0);
            String nextCursor = null;
            while (true) {
                FileList fileList = (FileList) new SyncDriveRequest(list2.setCursor(nextCursor).setPageSize(100).setFields2("nextCursor,files/id,files/fileName,files/editedTime,files/parentFolder,files/mimeType,files/size,files/md5").setQueryParam(str)).execute();
                List<File> files = fileList.getFiles();
                if (files != null) {
                    StringBuilder sb2 = new StringBuilder();
                    list = list2;
                    sb2.append("cloudFileList size: ");
                    sb2.append(files.size());
                    C11839m.m70688i("QueryBigFileTask", sb2.toString());
                    m74971g(this.f57501c, nextCursor, files.size());
                    Iterator<File> it2 = files.iterator();
                    while (it2.hasNext()) {
                        File next = it2.next();
                        if (next != null) {
                            FileModel fileModelM65816l = C10810x.m65816l(next);
                            FileModel fileModel = mapM72697m.get(fileModelM65816l.getFileId());
                            if (fileModel != null) {
                                if (TextUtils.isEmpty(fileModel.getThumbnailPath())) {
                                    it = it2;
                                } else {
                                    it = it2;
                                    fileModelM65816l.setThumbnailPath(fileModel.getThumbnailPath());
                                }
                                fileModel.setIsCloudExist("1");
                            } else {
                                it = it2;
                            }
                            arrayList.add(fileModelM65816l);
                            if (next.getParentFolder() != null && next.getParentFolder().size() > 0) {
                                String str2 = next.getParentFolder().get(0);
                                if (strM74968d == null || strM74968d.equals(str2)) {
                                    fileModelM65816l.setFileParentName(FileUtil.m16353c(true, ""));
                                } else {
                                    arrayList2.add(str2);
                                }
                            }
                            it2 = it;
                        }
                    }
                } else {
                    list = list2;
                }
                nextCursor = fileList.getNextCursor();
                if (TextUtils.isEmpty(nextCursor) || arrayList.size() > spaceCleanBigFileMaxNum) {
                    break;
                } else {
                    list2 = list;
                }
            }
            if (!arrayList.isEmpty()) {
                c12123a.m72699o(arrayList.size() > spaceCleanBigFileMaxNum ? arrayList.subList(0, spaceCleanBigFileMaxNum) : new ArrayList<>(arrayList), 0);
            }
            c12123a.m72693i("DELETE FROM diskBigFile WHERE isCloudExist = 0");
            if (!arrayList2.isEmpty()) {
                List<String> listSubList = arrayList2.size() > spaceCleanBigFileMaxNum ? arrayList2.subList(0, spaceCleanBigFileMaxNum) : new ArrayList(arrayList2);
                HashMap map = new HashMap();
                for (String str3 : listSubList) {
                    if (!map.containsKey(str3)) {
                        map.put(str3, "");
                    }
                }
                C12766a.m76613b(0, map);
            }
            this.f57502d = true;
            C10028c.m62182c0().m62250N2(System.currentTimeMillis());
            C12766a.m76612a(mapM72697m);
        } finally {
            C11839m.m70688i("QueryBigFileTask", "end");
            CountDownLatch countDownLatch5 = this.f57499a;
            if (countDownLatch5 != null) {
                countDownLatch5.countDown();
            }
            this.f57503e = true;
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        C11839m.m70688i("QueryBigFileTask", "task cancel.");
        this.f57503e = true;
        return super.cancel();
    }

    /* renamed from: d */
    public final String m74968d(DriveExpand driveExpand) {
        try {
            File file = (File) new SyncDriveRequest(driveExpand.files().get(SnapshotBackupMeta.DB_ROOT_NODE_APPID).setFields2("id")).execute();
            if (file != null && !TextUtils.isEmpty(file.getId())) {
                C11839m.m70686d("QueryBigFileTask", "rootId: " + file.getId());
                return file.getId();
            }
            C11839m.m70687e("QueryBigFileTask", "checkRootFileId return empty");
            return null;
        } catch (Exception e10) {
            C11839m.m70687e("QueryBigFileTask", "rootId error: " + e10.toString());
            m74970f(this.f57501c, "rootId error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: e */
    public boolean m74969e() {
        return this.f57503e;
    }

    /* renamed from: f */
    public final void m74970f(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str2);
        C9428e.m59118h().m59135r("query_big_file", str, linkedHashMap);
    }

    /* renamed from: g */
    public final void m74971g(String str, String str2, int i10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("next_cursor", str2);
        linkedHashMap.put("list_size", String.valueOf(i10));
        C9428e.m59118h().m59135r("query_big_file", str, linkedHashMap);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_BIG_FILE;
    }

    public void setCount(CountDownLatch countDownLatch) {
        this.f57499a = countDownLatch;
    }
}
