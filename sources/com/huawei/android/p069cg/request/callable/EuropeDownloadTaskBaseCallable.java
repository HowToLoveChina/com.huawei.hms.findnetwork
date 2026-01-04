package com.huawei.android.p069cg.request.callable;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileDownloadProgress;
import com.huawei.android.hicloud.album.service.report.DownloadOpsReport;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.logic.app.C2290i;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2328i;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.hicloud.request.opengw.bean.DownloadAddress;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1136q;
import p511o6.C11820b;
import p511o6.C11821c;
import p511o6.C11822d;
import p606r9.C12478a;
import p652t9.EnumC12999a;
import p733w9.C13576a;
import p801y7.C13914b;

/* loaded from: classes2.dex */
public abstract class EuropeDownloadTaskBaseCallable extends AbstractC2328i {
    public static final String DOWNLOAD_CANCEL = "11";
    public static final String DOWNLOAD_FAIL = "1";
    public static final String DOWNLOAD_FAIL_CONDITION = "10";
    public static final String DOWNLOAD_NO_DEAL = "12";
    public static final String DOWNLOAD_RETRY_CODE = "7";
    public static final String DOWNLOAD_SUCCESS = "0";
    private static final String TAG = "EuropeDownloadTaskBaseCallable";
    protected Asset asset;
    protected CallbackHandler callbackHandler;
    private int code;
    protected String conditionCode;
    protected String conditionInfo;
    protected Context context;
    protected DownloadAddress downloadAddress;
    protected FileInfo fileInfo;
    protected boolean isAlbumClient;
    private boolean isExceptionCancel;
    protected boolean isForceDownload;
    protected boolean isNeedDownProgress;
    private String msg;
    protected HashMap<String, Object> res;
    protected String saveCachePath;
    protected String savePath;
    protected long startDownloadTime;
    protected int taskType;
    private long tempSize;
    protected int thumbType;
    protected String traceId;

    public class DownloadRequestCallBack implements ICallback {
        private DownloadRequestCallBack() {
        }

        public boolean onPause() {
            return false;
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public void onProgress(long j10, long j11) {
            EuropeDownloadTaskBaseCallable europeDownloadTaskBaseCallable = EuropeDownloadTaskBaseCallable.this;
            if (europeDownloadTaskBaseCallable.isNeedDownProgress && !((AbstractCallableC2320a) europeDownloadTaskBaseCallable).isCancel) {
                EuropeDownloadTaskBaseCallable.this.sendSdkProgress(j10, j11);
            }
            if (((AbstractCallableC2320a) EuropeDownloadTaskBaseCallable.this).isCancel) {
                return;
            }
            C0068f.m459d().m468l();
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public boolean onStop() {
            return ((AbstractCallableC2320a) EuropeDownloadTaskBaseCallable.this).isCancel;
        }
    }

    public EuropeDownloadTaskBaseCallable(Object obj, int i10) {
        super(obj, i10, -1L);
        this.fileInfo = null;
        this.thumbType = -1;
        this.conditionInfo = "";
        this.conditionCode = "";
        this.res = new HashMap<>();
        this.isForceDownload = false;
        this.taskType = -1;
        this.traceId = "";
        this.isNeedDownProgress = false;
        this.tempSize = 0L;
        this.isExceptionCancel = false;
        this.code = 0;
        this.msg = "";
        this.isAlbumClient = false;
    }

    private String checkDownloadPath() {
        String str = this.savePath;
        if (str == null) {
            return "1";
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && fileM63442h.isFile()) {
            FileInfo fileInfo = this.fileInfo;
            if (fileInfo == null || this.thumbType != 0 || fileInfo.getFileType() != 7 || new C2290i().m14446g(this.context, this.savePath)) {
                return "0";
            }
            return null;
        }
        String strM6871o = C1124e.m6871o(this.context);
        FileInfo fileInfo2 = this.fileInfo;
        if (fileInfo2 != null && this.thumbType == 0) {
            strM6871o = C1124e.m6874r(this.context, fileInfo2.getAlbumId(), this.fileInfo.getSize());
        }
        long jM6698G0 = C1122c.m6698G0(strM6871o);
        FileInfo fileInfo3 = this.fileInfo;
        if (fileInfo3 == null || !C1122c.m6681A1(this.thumbType, jM6698G0, fileInfo3.getSize())) {
            return null;
        }
        this.res.put("DownloadFailReason", 126);
        C11822d.m70439c(this.context, this.thumbType, 126);
        C1120a.m6676e(TAG, "checkDownload LocalSpaceTooLow, availSize:" + jM6698G0);
        this.conditionInfo = "LocalSpaceTooLow, availSize:" + jM6698G0;
        this.conditionCode = "3014";
        return "10";
    }

    private boolean checkPathExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        return fileM63442h.exists() && fileM63442h.isFile();
    }

    private boolean checkSwitch(Context context, String str) {
        if (str == null || !str.startsWith("default-album-")) {
            if (C1136q.e.m7166d(context)) {
                return false;
            }
            C1120a.m6675d(TAG, "General switch and share swich is off");
            this.conditionInfo = "switch off";
            this.conditionCode = "3000";
            return true;
        }
        if (C1136q.e.m7166d(context)) {
            return false;
        }
        C1120a.m6675d(TAG, "General switch is off");
        this.conditionInfo = "switch off";
        this.conditionCode = "3000";
        return true;
    }

    private String downloadResult() {
        String str;
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo == null) {
            return "1";
        }
        String fileName = fileInfo.getFileName();
        C1120a.m6675d(TAG, "downloadResult start : " + C1122c.m6818p0(fileName));
        if (this.fileInfo.getFileAttribute() == 0) {
            str = "/GallerySync/" + this.fileInfo.getAlbumId() + "/" + fileName;
        } else {
            if (this.fileInfo.getFileAttribute() != 1) {
                if (this.thumbType != 0) {
                    this.res.put("code", "10");
                    this.res.put(C2126b.ERROR_MESSAGE_INFO, "download path err:" + this.fileInfo.getFileAttribute());
                }
                C1120a.m6676e(TAG, "download path err,fileAttribute err: " + this.fileInfo.getFileAttribute());
                return "1";
            }
            str = "/GallerySyncRecycle/" + this.fileInfo.getFileName();
        }
        String str2 = str;
        C1120a.m6675d(TAG, "download serverPath: " + str2);
        HashMap map = new HashMap();
        map.put("thumbType", "" + getThumbType());
        map.put("videoThumbId", "" + this.fileInfo.getVideoThumbId());
        map.put("fileType", String.valueOf(this.fileInfo.getFileType()));
        map.put("fileUnique", this.fileInfo.getUploadTime());
        try {
            try {
                this.startDownloadTime = System.currentTimeMillis();
                if (this.thumbType != 0) {
                    new C12478a(EnumC12999a.CLOUD_THUMNAIL, this.traceId).m74917m(str2, getName(), this.saveCachePath, new DownloadRequestCallBack(), map);
                } else {
                    new C12478a(EnumC12999a.CLOUD_ALBUM, this.traceId).m74914j(str2, this.saveCachePath, new DownloadRequestCallBack(), map);
                }
                C1120a.m6677i(TAG, "download file end : " + this.saveCachePath);
                String downloadStatus = getDownloadStatus();
                C1120a.m6677i(TAG, "downloadResult finally.");
                return downloadStatus;
            } catch (C9721b e10) {
                this.processException(e10);
                C1120a.m6677i(TAG, "downloadResult finally.");
                return "1";
            }
        } catch (Throwable th2) {
            C1120a.m6677i(TAG, "downloadResult finally.");
            throw th2;
        }
    }

    private String downloadWithAddress() {
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_THUMNAIL, this.traceId);
        HashMap map = new HashMap();
        try {
            map.put("thumbType", "" + getThumbType());
            map.put("videoThumbId", "" + this.fileInfo.getVideoThumbId());
            c12478a.m74916l(this.savePath, new DownloadRequestCallBack(), this.downloadAddress, map);
            if (C10278a.m63442h(this.savePath).isFile()) {
                this.code = 200;
                this.msg = "success";
                return "0";
            }
            this.res.put("code", "1");
            this.res.put(C2126b.ERROR_MESSAGE_INFO, "downloadWithAddress is not file");
            C1120a.m6676e(TAG, "downloadWithAddress is not file");
            return "1";
        } catch (C9721b e10) {
            this.res.put("code", e10.m60659c() + "_" + e10.m60663g());
            this.res.put(C2126b.ERROR_MESSAGE_INFO, e10.getMessage());
            C1120a.m6676e(TAG, "downloadWithAddress error, fileName :" + C1122c.m6818p0(this.fileInfo.getFileName()) + ", thumbType : " + this.thumbType + ", error : " + e10.toString());
            return "1";
        } finally {
            this.res.putAll(map);
        }
    }

    private String getAlbumId() {
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo != null) {
            return !TextUtils.isEmpty(fileInfo.getShareId()) ? this.fileInfo.getShareId() : this.fileInfo.getAlbumId();
        }
        return null;
    }

    private String getDownLoadFileStatus() {
        File fileM63442h = C10278a.m63442h(this.savePath);
        File fileM63442h2 = C10278a.m63442h(this.saveCachePath);
        if (!getMoveResult(fileM63442h)) {
            C1120a.m6676e(TAG, "move file error");
            C1120a.m6678w(TAG, "deleteResult is:" + fileM63442h2.delete());
        } else {
            if (fileM63442h.isFile()) {
                if (this.thumbType != 0) {
                    return "0";
                }
                MediaScannerConnection.scanFile(this.context, new String[]{this.savePath}, null, null);
                return "0";
            }
            C1120a.m6676e(TAG, "download file is not file");
        }
        return null;
    }

    private boolean getMoveResult(File file) {
        if (this.saveCachePath.equals(this.savePath)) {
            return true;
        }
        if (file.exists()) {
            C1120a.m6678w(TAG, "deleteFileResult is:" + file.delete());
        }
        return C1122c.m6735S1(this.saveCachePath, this.savePath);
    }

    private String getName() {
        return this.thumbType == 2 ? "small" : "large";
    }

    private String getUniqueId() {
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo != null) {
            return fileInfo.getUniqueId();
        }
        return null;
    }

    private void processException(C9721b c9721b) {
        if (this.thumbType != 0) {
            this.res.put("code", Integer.valueOf(c9721b.m60663g()));
            this.res.put(C2126b.ERROR_MESSAGE_INFO, c9721b.getMessage());
        }
        C1120a.m6676e(TAG, "download file error!  thumbType = " + this.thumbType + c9721b.toString());
        if (this.isCancel) {
            cancel();
        }
        String strM6871o = C1124e.m6871o(this.context);
        if (this.thumbType == 0) {
            strM6871o = C1124e.m6874r(this.context, this.fileInfo.getAlbumId(), this.fileInfo.getSize());
        }
        putSpaceTooLow(C1122c.m6698G0(strM6871o));
    }

    private void putSpaceTooLow(long j10) {
        if (C1122c.m6681A1(this.thumbType, j10, this.fileInfo.getSize())) {
            this.res.put("DownloadFailReason", 126);
        }
    }

    private void reportData(FileInfo fileInfo) {
        new DownloadOpsReport(this.context).m15218D(this.code, this.msg, this.traceId, this.thumbType, fileInfo, this.savePath, this.res.containsKey("code") ? String.valueOf(this.res.get("code")) : "", this.res.containsKey(C2126b.ERROR_MESSAGE_INFO) ? String.valueOf(this.res.get(C2126b.ERROR_MESSAGE_INFO)) : "");
    }

    private void sendMsgUpdateFileStatus(FileInfo fileInfo, int i10, boolean z10, int i11) {
        new C13914b(this.context, this.callbackHandler).m83364E(fileInfo, i10, z10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSdkProgress(long j10, long j11) {
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.startDownloadTime < 500) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("download total: ");
        sb2.append(j11);
        sb2.append(", current: ");
        sb2.append(j10);
        sb2.append(",tempSize: ");
        sb2.append(this.tempSize);
        if (this.fileInfo != null) {
            str = " ;fileName is:" + C1122c.m6818p0(this.fileInfo.getFileName());
        } else {
            str = "fileInfo is null";
        }
        sb2.append(str);
        C1120a.m6675d(TAG, sb2.toString());
        long j12 = this.tempSize;
        if (j12 > j10) {
            j10 = j12;
        } else {
            this.tempSize = j10;
        }
        if (this.fileInfo == null) {
            C1120a.m6676e(TAG, "fileInfo is null");
            return;
        }
        SyncSessionManager.m15153t().m15164K(2);
        Bundle bundle = new Bundle();
        FileDownloadProgress fileDownloadProgress = new FileDownloadProgress();
        fileDownloadProgress.setUniqueId(this.fileInfo.getUniqueId());
        fileDownloadProgress.setFileId(this.fileInfo.getFileId());
        fileDownloadProgress.setFileSizeByte(j11);
        fileDownloadProgress.setFileLoadSizeByte(j10);
        fileDownloadProgress.setResolutionType(this.thumbType);
        this.fileInfo.setSizeProgress(j10);
        bundle.putParcelable("FileLoadProgress", fileDownloadProgress);
        this.callbackHandler.sendMessage(9042, bundle);
        this.startDownloadTime = jCurrentTimeMillis;
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2328i, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public abstract Object call() throws Exception;

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public boolean cancel() {
        int i10 = this.isExceptionCancel ? 143 : 115;
        C1120a.m6678w(TAG, "cancel this.cancelCode: " + this.cancelCode);
        return this.cancelCode != 115 ? super.cancel() : super.cancel(i10);
    }

    public boolean checkDir(String str, boolean z10) {
        File fileM63437c;
        boolean zMkdirs;
        C1120a.m6675d(TAG, "checkDir check directory: " + str);
        if (str == null || (fileM63437c = C10278a.m63437c(C10278a.m63442h(str))) == null) {
            return false;
        }
        if (fileM63437c.exists()) {
            return true;
        }
        C1120a.m6675d(TAG, "checkDir create directory: " + fileM63437c.getPath());
        synchronized (EuropeDownloadTaskBaseCallable.class) {
            zMkdirs = fileM63437c.mkdirs();
        }
        if (!zMkdirs) {
            if (!fileM63437c.exists()) {
                C1120a.m6676e(TAG, "mkdirs error need check system storage or permissions");
                return false;
            }
            C1120a.m6677i(TAG, "directory already exist" + fileM63437c.getPath());
        }
        if (!z10) {
            return true;
        }
        File fileM63442h = C10278a.m63442h(fileM63437c.toString() + "/.nomedia");
        if (fileM63442h.exists()) {
            return true;
        }
        try {
            synchronized (EuropeDownloadTaskBaseCallable.class) {
                try {
                    if (!fileM63442h.exists()) {
                        return fileM63442h.createNewFile();
                    }
                    C1120a.m6678w(TAG, ".nomedia already exist");
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (IOException e10) {
            C1120a.m6676e(TAG, "DownloadTaskCallable:create .nomedia file error!error message:" + e10.getMessage());
            return false;
        }
    }

    public String checkDownloadCondition(Context context) {
        String albumId = getAlbumId();
        if (checkSwitch(context, albumId)) {
            return "10";
        }
        String uniqueId = getUniqueId();
        int i10 = this.taskType;
        if (i10 == 2 || i10 == 1) {
            boolean z10 = i10 != 2;
            C1120a.m6675d(TAG, "albumId== " + albumId + "  uniqueId== " + uniqueId + "  thumbType==" + this.thumbType);
            String strM70401f = C11820b.m70401f(albumId, uniqueId, this.thumbType);
            if (strM70401f == null) {
                C1120a.m6676e(TAG, "fileInfoKey is null");
                return "10";
            }
            if ((z10 ? DownloadPhotoBase.m14407b(strM70401f) : DownloadPhotoBase.m14408c(strM70401f)) != null && C11821c.m70430t(this.fileInfo, this.thumbType, z10)) {
                this.res.put("DownloadFailReason", 149);
                return "12";
            }
        } else {
            int i11 = this.thumbType;
            if (i11 == 1) {
                if (C11821c.m70430t(this.fileInfo, i11, i10 == 3)) {
                    this.res.put("DownloadFailReason", 149);
                    return "12";
                }
            }
        }
        return checkDownloadPath();
    }

    public void downloadOriginalPhoto() {
        sendMsgUpdateFileStatus(this.fileInfo, this.thumbType, false, 1);
    }

    public String getDownloadResult() {
        String strDownloadWithAddress;
        if (this.downloadAddress != null) {
            strDownloadWithAddress = downloadWithAddress();
        } else {
            if (this.isCancel) {
                return "11";
            }
            strDownloadWithAddress = "1";
            boolean z10 = false;
            while (!z10 && !this.isCancel) {
                C13576a c13576aM81565a = C13576a.m81565a();
                String str = TAG + this.savePath + this.thumbType;
                if (c13576aM81565a.m81566b(str)) {
                    strDownloadWithAddress = downloadResult();
                    c13576aM81565a.m81568d(str);
                    z10 = true;
                } else {
                    C1120a.m6678w(TAG, "file already in download, wait for result.");
                    c13576aM81565a.m81570f(str);
                    if (checkPathExist(this.savePath)) {
                        strDownloadWithAddress = "0";
                        z10 = true;
                    }
                    if (!checkPathExist(this.savePath) && this.isCancel) {
                        z10 = false;
                        strDownloadWithAddress = "11";
                    }
                }
            }
        }
        if (this.thumbType != 0) {
            reportData(this.fileInfo);
        }
        return strDownloadWithAddress;
    }

    public String getDownloadStatus() {
        String downLoadFileStatus = getDownLoadFileStatus();
        if (downLoadFileStatus != null && "0".equals(downLoadFileStatus) && this.thumbType != 0) {
            this.code = 200;
            this.msg = "success";
        }
        return downLoadFileStatus;
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public void handleCallException(Exception exc) {
        super.handleCallException(exc);
        this.isCancel = true;
        this.isExceptionCancel = true;
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public boolean isCancel() {
        return this.isCancel;
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public void onTimeout() {
        super.onTimeout();
        this.isCancel = true;
        this.isExceptionCancel = true;
    }

    public void reportWithDownloadFail(String str) {
        this.res.put("code", str);
        if ("10".equals(str)) {
            C1122c.m6750X1(this.context, TextUtils.isEmpty(this.conditionCode) ? "001_3002:1" : C1122c.m6713L0(this.conditionCode, true), TextUtils.isEmpty(this.conditionInfo) ? "condition invalid" : this.conditionInfo, "04004", "checkDownloadCondition", this.traceId, true);
        }
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public void setCancel(boolean z10) {
        this.isCancel = z10;
    }
}
