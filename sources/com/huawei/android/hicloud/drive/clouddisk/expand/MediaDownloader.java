package com.huawei.android.hicloud.drive.clouddisk.expand;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bb.C1160a;
import ck.C1444b;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.p085db.DriveDBManager;
import com.huawei.android.hicloud.drive.clouddisk.expand.p085db.Status;
import com.huawei.android.hicloud.drive.clouddisk.expand.p085db.StatusDownload;
import com.huawei.android.hicloud.drive.clouddisk.model.DownloadBuilder;
import com.huawei.android.hicloud.drive.clouddisk.model.FileExpand;
import com.huawei.android.hicloud.drive.clouddisk.model.ObjectStorageAddress;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceEnumeration;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.base.slice.StrLengthGetter;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.download.api.DownloadManager;
import com.huawei.hms.network.file.download.api.FileRequestCallback;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import fk.C9721b;
import hk.C10279b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p012ab.C0087b;
import p015ak.C0209d;
import p283fa.C9679b;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p653ta.C13000a;
import p653ta.C13001b;
import p709vj.C13452e;
import p733w9.C13576a;
import p767x9.C13735d;
import ua.C13142a;
import za.C14164a;
import za.C14165b;

/* loaded from: classes3.dex */
public class MediaDownloader extends MediaBase {
    private static final Object ERROR_LOCK = new Object();
    private static final String GETREQUEST_URL = "https://temp";
    private static final String TAG = "MediaDownloader";
    String attachmentName;
    private DownloadBuilder builder;
    private CountDownLatch downLatch;
    private DriveExpand drive;
    private byte[] fek;
    private FileExpand fileContent;
    private C4602e fileStream;
    private List<SliceItem<String>> items;

    /* renamed from: iv */
    private byte[] f12203iv;
    private C13001b mReporter;
    private String mTraceId;
    private String md5;
    private List<String> objectKeys;
    private MediaDownloaderProgressListener progressListener;
    private List<String> syncKeys;
    private String timeStamp;
    private long totalSliceLength;
    private boolean isCancel = false;
    private List<DownloadBuilder> builders = new ArrayList();
    private List<Long> taskIds = new ArrayList();
    private ExecutorService executor = Executors.newFixedThreadPool(C1444b.m8314t());
    private Map<String, Long> sliceOffsets = new HashMap();
    private C9721b exception = null;
    private File baseDirectory = getBaseCacheDir();
    private SQLiteDatabase database = DriveDBManager.getDB();

    public class SliceTask implements Runnable {
        private CountDownLatch latch;
        private boolean needAddOpenId;
        private DownloadBuilder statusDownload;

        public SliceTask(DownloadBuilder downloadBuilder, CountDownLatch countDownLatch, boolean z10) {
            this.statusDownload = downloadBuilder;
            this.latch = countDownLatch;
            this.needAddOpenId = z10;
        }

        private void retryDecrypt(File file, boolean z10) throws Throwable {
            try {
                C11839m.m70688i(MediaDownloader.TAG, "fileMd5 retryDecrypt start.");
                if (TextUtils.isEmpty(MediaDownloader.this.md5)) {
                    C11839m.m70688i(MediaDownloader.TAG, "fileMd5 retryDecrypt query.");
                    Drive.Files.Get get = MediaDownloader.this.drive.files().get(MediaDownloader.this.fileContent.getId());
                    get.setFields2("id,size,sha256,md5");
                    if (z10) {
                        C4609l headers = get.getHeaders();
                        headers.set("x-hw-open-app-id", C13142a.f59637b);
                        get.setHeaders(headers);
                    }
                    com.huawei.cloud.services.drive.model.File file2 = (com.huawei.cloud.services.drive.model.File) new SyncDriveRequest(get).execute();
                    if (file2.get("md5") instanceof String) {
                        String str = (String) file2.get("md5");
                        MediaDownloader.this.md5 = str;
                        if (!TextUtils.isEmpty(str)) {
                            C14165b.m85029b(MediaDownloader.this.fileStream.m28187f(), file, this.statusDownload.getOffset(), C14165b.m85032e(str), C14165b.m85034g(str));
                            C11839m.m70688i(MediaDownloader.TAG, "fileMd5 retryDecrypt success.");
                        }
                    }
                } else {
                    C14165b.m85029b(MediaDownloader.this.fileStream.m28187f(), file, this.statusDownload.getOffset(), C14165b.m85032e(MediaDownloader.this.md5), C14165b.m85034g(MediaDownloader.this.md5));
                }
                C11839m.m70687e(MediaDownloader.TAG, "retry decrypt success.");
            } catch (C9721b e10) {
                C11839m.m70687e(MediaDownloader.TAG, "fileMd5 retry decrypt file error: " + e10.toString());
                MediaDownloader.this.error(e10);
            } catch (Exception e11) {
                C11839m.m70687e(MediaDownloader.TAG, "retry decrypt file exception error: " + e11.toString());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb2;
            File file = new File(MediaDownloader.this.baseDirectory, this.statusDownload.getUuid());
            try {
                try {
                    MediaDownloader.this.isInterrupted();
                    C14165b.m85029b(MediaDownloader.this.fileStream.m28187f(), file, this.statusDownload.getOffset(), MediaDownloader.this.fek, MediaDownloader.this.f12203iv);
                } catch (C9721b e10) {
                    String string = e10.toString();
                    C11839m.m70687e(MediaDownloader.TAG, "decrypt file exception error: " + string);
                    if (!TextUtils.isEmpty(string) && string.contains("ENOSPC")) {
                        C11839m.m70689w(MediaDownloader.TAG, "decrypt file has no enough space.");
                        MediaDownloader.this.error(new C9721b(1007, e10.toString(), "Download"));
                        if (file.exists()) {
                            C11839m.m70686d(MediaDownloader.TAG, "decrypt file exits, delete = " + file.delete());
                        }
                        this.latch.countDown();
                        return;
                    }
                    if (e10.m60659c() == 4005) {
                        retryDecrypt(file, this.needAddOpenId);
                    } else {
                        MediaDownloader.this.error(e10);
                    }
                    if (file.exists()) {
                        sb2 = new StringBuilder();
                    }
                } catch (Exception e11) {
                    C11839m.m70687e(MediaDownloader.TAG, "decrypt file exception error: " + e11.toString());
                    if (file.exists()) {
                        sb2 = new StringBuilder();
                    }
                }
                if (file.exists()) {
                    sb2 = new StringBuilder();
                    sb2.append("decrypt file exits, delete = ");
                    sb2.append(file.delete());
                    C11839m.m70686d(MediaDownloader.TAG, sb2.toString());
                }
                this.latch.countDown();
            } catch (Throwable th2) {
                if (file.exists()) {
                    C11839m.m70686d(MediaDownloader.TAG, "decrypt file exits, delete = " + file.delete());
                }
                this.latch.countDown();
                throw th2;
            }
        }
    }

    public class TaskCallback extends FileRequestCallback {
        private CountDownLatch latch;
        private boolean needAddOpenId;
        private DownloadBuilder slice;

        public TaskCallback(DownloadBuilder downloadBuilder, CountDownLatch countDownLatch, boolean z10) {
            this.slice = downloadBuilder;
            this.latch = countDownLatch;
            this.needAddOpenId = z10;
        }

        private void release() {
            CountDownLatch countDownLatch = this.latch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            C11839m.m70688i(MediaDownloader.TAG, "onCompleted taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.slice.getObject() + "] cache [" + this.slice.getUuid() + "] download end.");
            try {
                try {
                    MediaDownloader.this.isInterrupted();
                    int status = this.slice.getStatus();
                    Status status2 = Status.SUCCESS;
                    if (status != status2.value()) {
                        new StatusDownload(this.slice.setStatus(status2.value())).replace(MediaDownloader.this.database);
                        C11839m.m70688i(MediaDownloader.TAG, "onCompleted taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.slice.getObject() + "] cache [" + this.slice.getUuid() + "] download success");
                    }
                } catch (C9721b e10) {
                    C11839m.m70687e(MediaDownloader.TAG, "onCompleted taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.slice.getObject() + "] cache [" + this.slice.getUuid() + "] download error." + e10);
                    MediaDownloader.this.error(e10);
                }
            } finally {
                release();
            }
        }

        public void onException(GetRequest getRequest, NetworkException networkException, Response<GetRequest, File, Closeable> response) {
            if (this.slice.getStatus() == Status.SUCCESS.value()) {
                return;
            }
            C11839m.m70687e(MediaDownloader.TAG, "onException taskId [" + getRequest.getId() + "]slice object [" + this.slice.getObject() + "] cache [" + this.slice.getUuid() + "] download error. " + networkException.toString());
            int iM1331z = C0209d.m1331z(networkException.getMessage());
            if (iM1331z == 431 || iM1331z == 1102) {
                MediaDownloader.this.error(new C9721b(431, networkException.toString(), "Download"));
            } else if (iM1331z == 10043005) {
                MediaDownloader.this.error(new C9721b(1007, networkException.toString(), "Download"));
            } else {
                MediaDownloader.this.error(new C9721b(4309, networkException.toString(), "Download"));
            }
            release();
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C11839m.m70686d(MediaDownloader.TAG, "slice object [" + this.slice.getObject() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
            MediaDownloader.this.sliceOffsets.put(this.slice.getObject(), Long.valueOf(progress.getFinishedSize()));
            if (MediaDownloader.this.progressListener != null) {
                MediaDownloader.this.progressListener.progressChanged(MediaDownloader.this);
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) {
            C11839m.m70688i(MediaDownloader.TAG, "updateTaskBean taskId [" + getRequest.getId() + "]slice object [" + this.slice.getObject() + "] cache [" + this.slice.getUuid() + "] get download address.");
            try {
                DriveExpand.Objects.GetObsAddress obsAddress = MediaDownloader.this.drive.objects().getObsAddress();
                obsAddress.setObjectBucketId(MediaDownloader.this.fileContent.getObjectInfoList().get(0).getObjectBucketId()).setObjectId(this.slice.getObject()).setLoadType("download").setSynckey(this.slice.getSynckey()).setObjectSize(Long.valueOf(getRequest.getFileSize())).setTimeStamp(MediaDownloader.this.timeStamp).setRecordCursor(MediaDownloader.this.fileContent.getRecordCursor());
                if (this.needAddOpenId) {
                    C4609l headers = obsAddress.getHeaders();
                    headers.set("x-hw-open-app-id", C13142a.f59637b);
                    obsAddress.setHeaders(headers);
                }
                ObjectStorageAddress objectStorageAddress = (ObjectStorageAddress) new SyncDriveRequest(obsAddress).execute();
                String url = objectStorageAddress.getUrl();
                Map<String, String> headers2 = objectStorageAddress.getHeaders();
                C11839m.m70686d(MediaDownloader.TAG, "updateTaskBean originUrl: " + url);
                return getRequest.newBuilder().headers(headers2).url(url).build();
            } catch (C4616s e10) {
                C11839m.m70687e(MediaDownloader.TAG, "updateTaskBean getObsAddress HttpResponseException result : " + e10.toString());
                MediaDownloader.this.error(new C9721b(4309, e10.m28322f(), e10.m28319c(), MediaDownloader.this.mReporter.m78151a(), C1160a.m7253d(e10)));
                return getRequest;
            } catch (C9721b e11) {
                C11839m.m70687e(MediaDownloader.TAG, "updateTaskBean CException : " + e11.toString());
                MediaDownloader.this.error(e11);
                return getRequest;
            } catch (IOException e12) {
                C11839m.m70687e(MediaDownloader.TAG, "updateTaskBean taskId [" + getRequest.getId() + "]slice object [" + this.slice.getObject() + "] cache [" + this.slice.getUuid() + "] get download address error." + e12);
                MediaDownloader.this.error(new C9721b(4309, e12.toString()));
                return getRequest;
            }
        }
    }

    public MediaDownloader(DriveExpand driveExpand, FileExpand fileExpand, String str, String str2, String str3) {
        this.drive = driveExpand;
        this.fileContent = fileExpand;
        this.attachmentName = str;
        this.mTraceId = str2;
        this.md5 = str3;
    }

    private void decryptSlices(byte[] bArr, boolean z10) throws C9721b {
        C11839m.m70688i(TAG, "encrypt file [" + this.fileStream.m28187f().getName() + "] all slices download success, begin to decrpyt slices.");
        isInterrupted();
        try {
            this.fek = C14164a.m85026e(C14164a.m85023b(this.fileContent.getEncFekList().get(0).getEncFek(), bArr));
            this.f12203iv = C14164a.m85026e(this.fileContent.getEncFekList().get(0).getIV());
            try {
                this.downLatch = new CountDownLatch(this.builders.size());
                Iterator<DownloadBuilder> it = this.builders.iterator();
                while (it.hasNext()) {
                    this.executor.execute(new SliceTask(it.next(), this.downLatch, z10));
                }
                syncLock();
                trash();
                this.executor.shutdown();
            } catch (Throwable th2) {
                this.executor.shutdown();
                throw th2;
            }
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file key and iv error: " + e10.getMessage());
        }
    }

    private static void deleteFile(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            deleteFile(file2);
        }
    }

    private void doDownload(boolean z10) throws InterruptedException, C9721b, SQLException {
        int size = this.items.size();
        List<DownloadBuilder> listQuery = new StatusDownload(this.builder).query(this.database);
        this.downLatch = new CountDownLatch(size);
        this.builders.clear();
        long length = 0;
        for (int i10 = 0; i10 < size; i10++) {
            SliceItem<String> sliceItem = this.items.get(i10);
            String object = sliceItem.getObject();
            DownloadBuilder synckey = new DownloadBuilder(this.fileContent.getId()).setPath(this.builder.getPath()).setNum(i10).setOffset(length).setUuid(UUID.randomUUID().toString()).setObject(object).setSynckey(this.syncKeys.get(this.objectKeys.indexOf(object)));
            length += !TextUtils.isEmpty(this.attachmentName) ? sliceItem.getLength() : this.fileContent.getObjectInfoList().get(0).getSliceSize().longValue();
            Iterator<DownloadBuilder> it = listQuery.iterator();
            while (it.hasNext() && !synckey.equals(it.next())) {
            }
            this.builders.add(synckey);
            if (synckey.getStatus() == Status.SUCCESS.value()) {
                if (new File(this.baseDirectory + "/" + synckey.getUuid()).exists()) {
                    this.downLatch.countDown();
                    this.sliceOffsets.put(sliceItem.getObject(), Long.valueOf(sliceItem.getLength()));
                    MediaDownloaderProgressListener mediaDownloaderProgressListener = this.progressListener;
                    if (mediaDownloaderProgressListener != null) {
                        mediaDownloaderProgressListener.progressChanged(this);
                    }
                    C11839m.m70686d(TAG, "slice object [" + synckey.getObject() + "] already download.");
                } else {
                    C11839m.m70686d(TAG, "slice object [" + synckey.getObject() + "] download cache has been deleted.");
                    synckey.reset();
                    new StatusDownload(synckey.setTaskId(C13735d.m82531s().m82541k(EnumC12999a.CLOUD_DISK_BITMAP, DownloadManager.newGetRequestBuilder().url(GETREQUEST_URL).filePath(this.baseDirectory + "/" + synckey.getUuid()).offset(sliceItem.getOffset()).fileSize(sliceItem.getLength()).name(synckey.getUuid()).config(C13735d.m82528e()).enableSlice(false), synckey.getTaskId(), new TaskCallback(synckey, this.downLatch, z10)).getId())).replace(this.database);
                }
            } else {
                new StatusDownload(synckey.setTaskId(C13735d.m82531s().m82541k(EnumC12999a.CLOUD_DISK_BITMAP, DownloadManager.newGetRequestBuilder().url(GETREQUEST_URL).filePath(this.baseDirectory + "/" + synckey.getUuid()).offset(sliceItem.getOffset()).fileSize(sliceItem.getLength()).name(synckey.getUuid()).config(C13735d.m82528e()).enableSlice(false), synckey.getTaskId(), new TaskCallback(synckey, this.downLatch, z10)).getId())).replace(this.database);
            }
        }
        try {
            syncLock();
        } catch (C9721b e10) {
            C13735d.m82531s().m82545o(EnumC12999a.CLOUD_DISK_BITMAP, this.taskIds);
            C11839m.m70687e(TAG, e10.toString());
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void error(C9721b c9721b) {
        synchronized (ERROR_LOCK) {
            try {
                if (this.exception == null) {
                    this.exception = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private long getAttachmentSize(List<FileExpand.Attribute> list, String str) {
        if (TextUtils.isEmpty(str)) {
            return list.get(0).getLength().longValue();
        }
        for (int i10 = 1; i10 < list.size(); i10++) {
            FileExpand.Attribute attribute = list.get(i10);
            if (str.equals(attribute.getName())) {
                return attribute.getLength().longValue();
            }
        }
        return -1L;
    }

    private List<SliceItem<String>> getAttachmentSliceItems(List<FileExpand.Attribute> list) {
        ArrayList arrayList = new ArrayList();
        SliceEnumeration<String> sliceEnumeration = getSliceEnumeration(this.objectKeys, list, false);
        for (int i10 = 1; i10 < list.size(); i10++) {
            FileExpand.Attribute attribute = list.get(i10);
            if (sliceEnumeration.hasMoreSlices()) {
                for (SliceItem<String> sliceItem : sliceEnumeration.nextSlice(attribute.getLength().longValue()).getSliceItems()) {
                    if (!this.attachmentName.equals(attribute.getName())) {
                        break;
                    }
                    arrayList.add(sliceItem);
                }
            }
        }
        return arrayList;
    }

    private SliceEnumeration<String> getSliceEnumeration(List<String> list, List<FileExpand.Attribute> list2, boolean z10) {
        List<String> listSubList;
        long j10;
        long j11;
        C11839m.m70686d(TAG, "get slice enumeration by objects.");
        long jLongValue = list2.get(0).getLength().longValue();
        long jLongValue2 = this.fileContent.getObjectInfoList().get(0).getSliceSize().longValue();
        long j12 = ((jLongValue - 1) / jLongValue2) + 1;
        C4627a0.m28395h(((long) list.size()) >= j12, "objects is not valid.");
        if (z10) {
            listSubList = list.subList(0, (int) j12);
            long j13 = jLongValue % jLongValue2;
            if (j13 == 0) {
                j13 = jLongValue2;
            }
            j10 = j12;
            j11 = j13;
        } else {
            C4627a0.m28395h(((long) list.size()) > j12, "no thumnails in cloud.");
            listSubList = list.subList((int) j12, list.size());
            int size = list2.size();
            long jLongValue3 = 0;
            for (int i10 = 1; i10 < size; i10++) {
                jLongValue3 += list2.get(i10).getLength().longValue();
            }
            long j14 = ((jLongValue3 - 1) / jLongValue2) + 1;
            long j15 = jLongValue3 % jLongValue2;
            if (j15 == 0) {
                j15 = jLongValue2;
            }
            j10 = j14;
            j11 = j15;
        }
        return new SliceEnumeration<>(listSubList, new StrLengthGetter(j10, jLongValue2, j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isInterrupted() throws C9721b {
        if (this.isCancel) {
            throw new C9721b(1001, "user cancel.");
        }
    }

    private void prepare() throws C9721b {
        this.exception = null;
        this.builder = new DownloadBuilder(this.fileContent.getId()).setPath(C10279b.m63452a(this.fileStream.m28187f()));
        List<FileExpand.ObjectDetailInfo> objectInfoList = this.fileContent.getObjectInfoList();
        if (objectInfoList == null || objectInfoList.size() == 0) {
            throw new C9721b(4001, "file content has no objectInfoList");
        }
        this.objectKeys = objectInfoList.get(0).getObjectKeys();
        this.syncKeys = objectInfoList.get(0).getSyncKeys();
        this.timeStamp = objectInfoList.get(0).getTimeStamp();
        List<FileExpand.Attribute> attributes = objectInfoList.get(0).getAttributes();
        boolean zIsEmpty = TextUtils.isEmpty(this.attachmentName);
        long attachmentSize = getAttachmentSize(attributes, this.attachmentName);
        if (!zIsEmpty) {
            if (attachmentSize == -1) {
                throw new C9721b(4310, "no attachment length");
            }
            this.items = getAttachmentSliceItems(attributes);
        } else {
            SliceEnumeration<String> sliceEnumeration = getSliceEnumeration(this.objectKeys, attributes, true);
            if (!sliceEnumeration.hasMoreSlices()) {
                throw new C9721b(4001, "amount of files does not match with dbank_s3_file");
            }
            Slice<String> sliceNextSlice = sliceEnumeration.nextSlice(attachmentSize);
            this.totalSliceLength = sliceNextSlice.getLength();
            this.items = sliceNextSlice.getSliceItems();
        }
    }

    private void syncLock() throws InterruptedException, C9721b {
        isInterrupted();
        while (this.downLatch.getCount() > 0 && !this.isCancel && this.exception == null) {
            try {
                C11839m.m70686d(TAG, "syncLock await" + this.downLatch.await(400L, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e10) {
                C11839m.m70689w(TAG, "lock wait error." + e10);
                this.exception = new C9721b(1001, "thread has been interrupted");
            }
        }
        C9721b c9721b = this.exception;
        if (c9721b != null) {
            throw c9721b;
        }
        isInterrupted();
    }

    private void trash() throws SQLException {
        Iterator<DownloadBuilder> it = this.builders.iterator();
        while (it.hasNext()) {
            String uuid = it.next().getUuid();
            if (uuid != null && !uuid.isEmpty()) {
                File file = new File(this.baseDirectory, uuid);
                if (file.exists()) {
                    C11839m.m70686d(TAG, "finally cache file exits, delete = " + file.delete());
                }
            }
        }
        DownloadBuilder downloadBuilder = this.builder;
        if (downloadBuilder != null) {
            new StatusDownload(downloadBuilder).delete(this.database);
        }
    }

    public void cancel() {
        this.isCancel = true;
    }

    public void download(boolean z10) throws C9721b {
        byte[] userKey;
        C11839m.m70688i(TAG, "file download start " + this.attachmentName);
        String absolutePath = this.fileStream.m28187f().getAbsolutePath();
        C11839m.m70686d(TAG, "file download path:" + absolutePath + " size:" + this.fileStream.m28187f().length());
        C13576a c13576aM81565a = C13576a.m81565a();
        try {
            if (!c13576aM81565a.m81566b(absolutePath)) {
                C11839m.m70687e(TAG, "download file path repeat.");
                throw new C9721b(4002, "download file path repeat.");
            }
            try {
                try {
                    C13001b c13001b = new C13001b();
                    this.mReporter = c13001b;
                    c13001b.m78164n(this.mTraceId);
                    if (TextUtils.isEmpty(this.attachmentName)) {
                        this.mReporter.m78162l("09002");
                    } else {
                        this.mReporter.m78162l("09003");
                    }
                    this.mReporter.m78164n(this.mTraceId);
                    this.mReporter.m78163m("com.huawei.hidisk\u0001_syncdisk");
                    this.mReporter.m78165o(C13452e.m80781L().m80971t0());
                    this.mReporter.m78159i("download_init");
                    prepare();
                    isInterrupted();
                    this.mReporter.m78159i("object_download");
                    doDownload(z10);
                    this.mReporter.m78159i("deal_userkey");
                    String keyUuid = this.fileContent.getEncFekList().get(0).getKeyUuid();
                    C0087b c0087b = new C0087b(C9679b.m60452d().m60455e());
                    UserKeyObject userKeyObjectM680c = c0087b.m680c("", 11, UserKeyBaseReq.KEY_TYPE_AES_128);
                    if (TextUtils.isEmpty(keyUuid) || keyUuid.equals(userKeyObjectM680c.getUserKeyGuid())) {
                        userKey = userKeyObjectM680c.getUserKey();
                    } else {
                        UserKeyObject userKeyObjectM682e = c0087b.m682e("", 11, UserKeyBaseReq.KEY_TYPE_AES_256);
                        if (!keyUuid.equals(userKeyObjectM682e.getUserKeyGuid())) {
                            throw new C9721b(4001, "no match userKey.");
                        }
                        userKey = userKeyObjectM682e.getUserKey();
                    }
                    this.mReporter.m78159i("download_decrypt");
                    decryptSlices(userKey, z10);
                    this.mReporter.m78159i("download");
                    this.mReporter.m78160j("200");
                    this.mReporter.m78161k("success");
                    C11839m.m70688i(TAG, "file download end success.");
                    c13576aM81565a.m81568d(absolutePath);
                    if ("09002".equals(this.mReporter.m78154d())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put(ContentResource.FILE_NAME, this.fileStream.m28187f().getName());
                        linkedHashMap.put("downloadType", "v1");
                        C13000a.m78149d(this.mReporter, linkedHashMap);
                    }
                } catch (C9721b e10) {
                    e = e10;
                    C11839m.m70687e(TAG, "file download end CException： " + e.toString());
                    if (e.m60659c() == 1535) {
                        e = new C9721b(430, e.getMessage());
                    }
                    if (TextUtils.isEmpty(e.m60660d())) {
                        this.mReporter.m78160j(String.valueOf(e.m60659c()));
                    } else {
                        this.mReporter.m78160j(e.m60660d());
                    }
                    this.mReporter.m78161k(e.getMessage());
                    throw e;
                }
            } catch (Exception e11) {
                C11839m.m70687e(TAG, "file download end Exception： " + e11.toString());
                this.mReporter.m78160j("-1");
                this.mReporter.m78161k(e11.getMessage());
                throw e11;
            }
        } catch (Throwable th2) {
            c13576aM81565a.m81568d(absolutePath);
            if ("09002".equals(this.mReporter.m78154d())) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put(ContentResource.FILE_NAME, this.fileStream.m28187f().getName());
                linkedHashMap2.put("downloadType", "v1");
                C13000a.m78149d(this.mReporter, linkedHashMap2);
            }
            throw th2;
        }
    }

    public int getProgress() {
        Iterator<Long> it = this.sliceOffsets.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return (int) Math.floor((jLongValue / this.totalSliceLength) * 100.0d);
    }

    public long getProgressValue() {
        Iterator<Long> it = this.sliceOffsets.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public long getTotalValue() {
        return this.totalSliceLength;
    }

    public void setFileContent(C4602e c4602e) {
        this.fileStream = c4602e;
    }

    public MediaDownloader setProgressListener(MediaDownloaderProgressListener mediaDownloaderProgressListener) {
        this.progressListener = mediaDownloaderProgressListener;
        return this;
    }
}
