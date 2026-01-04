package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.album.service.report.OpsReport;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p220d8.C9049c;
import p429kk.C11058a;
import p429kk.C11060c;
import p511o6.C11822d;
import p709vj.C13452e;
import p746wn.C13622a;
import p801y7.C13914b;

/* loaded from: classes2.dex */
public class SDKDownloadCheckCallable extends AbstractCallableC2320a {
    private static final int DOWNLOAD_NEED = 1;
    private static final int DOWNLOAD_UNNEED = 0;
    private static final int DOWNLOAD_UPDATE_ALBUMANDCLOUD = 2;
    protected static final int LENGTH_CONST = 6;
    private static final String TAG = "SDKDownloadCheckCallable";
    private CallbackHandler callbackHandler;
    private Context context;
    private int defaultDownloadFileNum;
    private ArrayList<String> failList;
    private ArrayList<FileInfo> fileList;
    private boolean identifyShare;
    private boolean isAllowRepeat;
    private boolean isForceDownload;
    private boolean isNeedDownProgress;
    private boolean isPriority;
    private boolean isShare;
    private boolean isSpaceTooLow;
    private String sessionId;
    private ArrayList<String> successList;
    private int taskType;
    private int thumbType;

    public SDKDownloadCheckCallable(Context context, CallbackHandler callbackHandler, Object obj, boolean z10, ArrayList<FileInfo> arrayList, int i10, boolean z11, boolean z12, boolean z13, boolean z14, int i11, boolean z15, String str) {
        super(obj);
        this.thumbType = -1;
        this.isShare = false;
        this.isAllowRepeat = false;
        this.taskType = -1;
        this.isForceDownload = false;
        this.defaultDownloadFileNum = 100;
        this.failList = new ArrayList<>();
        this.successList = new ArrayList<>();
        this.context = context;
        this.callbackHandler = callbackHandler;
        this.identifyShare = z10;
        this.fileList = arrayList;
        this.thumbType = i10;
        this.isPriority = z11;
        this.isNeedDownProgress = z12;
        this.isShare = z13;
        this.isAllowRepeat = z14;
        this.taskType = i11;
        this.isForceDownload = z15;
        this.sessionId = str;
    }

    private void addOriginalTask(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11, boolean z12) {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C13914b c13914b = new C13914b(this.context, this.callbackHandler);
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            if (!z12) {
                next.setUserID(strM80971t0);
            } else if (TextUtils.isEmpty(next.getUserID()) && TextUtils.isEmpty(next.getFileId())) {
                recordCheckFailData(next, 123);
                C1120a.m6676e(TAG, "userId is null fileName is: " + C1122c.m6818p0(next.getFileName()));
                c13914b.m83365F(next, i10, 123, z12);
            }
            next.setAlbumId(z12 ? next.getShareId() : next.getAlbumId());
            c13914b.m83371m(next, i10, z10, z11, z12, 0, this.taskType, this.isForceDownload, this.sessionId);
        }
    }

    private int checkDownloadCondition(FileInfo fileInfo, boolean z10) {
        if (fileInfo == null || ((!z10 && TextUtils.isEmpty(fileInfo.getAlbumId())) || ((z10 && TextUtils.isEmpty(fileInfo.getShareId())) || TextUtils.isEmpty(fileInfo.getFileName()) || TextUtils.isEmpty(fileInfo.getHash())))) {
            return 0;
        }
        return this.thumbType == 0 ? TextUtils.isEmpty(fileInfo.getFileId()) ? 0 : 1 : (TextUtils.isEmpty(fileInfo.getFileId()) && TextUtils.isEmpty(fileInfo.getVideoThumbId()) && TextUtils.isEmpty(fileInfo.getLcdFileId()) && TextUtils.isEmpty(fileInfo.getThumbFileId())) ? 0 : 1;
    }

    private int checkDownloadFileInfo(FileInfo fileInfo, int i10, boolean z10, boolean z11) {
        if (checkDownloadCondition(fileInfo, z10) == 0) {
            C1120a.m6677i(TAG, "params error, unneed download");
            recordCheckFailData(fileInfo, 123);
            return 123;
        }
        long jM6698G0 = C1122c.m6698G0(C1124e.m6871o(this.context));
        if (C1122c.m6681A1(i10, jM6698G0, fileInfo == null ? 0L : fileInfo.getSize())) {
            C1120a.m6676e(TAG, "checkDownload LocalSpaceTooLow, availSize:" + jM6698G0);
            this.isSpaceTooLow = true;
            return 126;
        }
        String shareId = z10 ? fileInfo.getShareId() : fileInfo.getAlbumId();
        if (TextUtils.isEmpty(fileInfo.getAlbumId()) && z10) {
            fileInfo.setAlbumId(fileInfo.getShareId());
        }
        String localBigThumbPath = i10 == 1 ? fileInfo.getLocalBigThumbPath() : i10 == 0 ? fileInfo.getLocalRealPath() : fileInfo.getLocalThumbPath();
        if (TextUtils.isEmpty(localBigThumbPath)) {
            recordCheckFailData(fileInfo, 124);
            C1120a.m6676e(TAG, "thumbSavePath is null:" + C1122c.m6818p0(fileInfo.getFileName()));
            return 124;
        }
        if (!checkIsCanAdd(fileInfo, i10, z10, z11)) {
            recordCheckFailData(fileInfo, 149);
            C1120a.m6675d(TAG, "can not add: " + C1122c.m6818p0(fileInfo.getFileName()) + " thumbType:" + i10);
            return 149;
        }
        if (checkFile(fileInfo, shareId, localBigThumbPath) == 1) {
            return 1;
        }
        recordCheckFailData(fileInfo, 2);
        C1120a.m6678w(TAG, "download file is exist: " + C1122c.m6818p0(fileInfo.getFileName()) + "thumbType:" + i10 + " thumbSavePath:" + localBigThumbPath);
        return 2;
    }

    private int checkFile(FileInfo fileInfo, String str, String str2) {
        if (fileInfo.getFileType() != 7 || this.thumbType != 0) {
            return checkSavePathExist(str2) ? 0 : 1;
        }
        fileInfo.setLocalRealPath(str2);
        return 1;
    }

    private boolean checkIsCanAdd(FileInfo fileInfo, int i10, boolean z10, boolean z11) {
        return z11 || !DownloadPhotoBase.m14410e(this.context, fileInfo, i10, z10, false);
    }

    private boolean checkSavePathExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        return fileM63442h.exists() && fileM63442h.isFile();
    }

    private void downloadFileByPage(Context context, ArrayList<FileInfo> arrayList, int i10) {
        C13914b c13914b = new C13914b(context, this.callbackHandler);
        ArrayList<FileInfo> arrayList2 = new ArrayList<>();
        ArrayList<FileInfo> arrayList3 = new ArrayList<>();
        ArrayList<FileInfo> arrayList4 = new ArrayList<>();
        ArrayList<FileInfo> arrayList5 = new ArrayList<>();
        for (int i11 = i10; i11 < arrayList.size() && i11 < this.defaultDownloadFileNum + i10; i11++) {
            FileInfo fileInfo = arrayList.get(i11);
            if (fileInfo != null) {
                boolean z10 = this.identifyShare ? this.isShare : !TextUtils.isEmpty(fileInfo.getShareId());
                int iCheckDownloadFileInfo = checkDownloadFileInfo(fileInfo, this.thumbType, z10, this.isAllowRepeat);
                if (z10) {
                    singleFileShare(arrayList3, arrayList4, fileInfo, iCheckDownloadFileInfo);
                } else if (iCheckDownloadFileInfo == 1) {
                    if (this.thumbType == 0) {
                        this.successList.add(fileInfo.getUniqueId());
                    }
                    arrayList2.add(fileInfo);
                } else if (iCheckDownloadFileInfo == 2) {
                    arrayList5.add(fileInfo);
                } else if (iCheckDownloadFileInfo == 149) {
                    if (C11822d.m70440d(fileInfo, this.thumbType)) {
                        c13914b.m83364E(fileInfo, this.thumbType, false, 1);
                    } else {
                        c13914b.m83364E(fileInfo, this.thumbType, false, 2);
                    }
                    C1120a.m6678w(TAG, "General file has in download file list, fileName: " + C1122c.m6818p0(fileInfo.getFileName()));
                } else {
                    c13914b.m83365F(fileInfo, this.thumbType, iCheckDownloadFileInfo, this.isShare);
                    C1120a.m6678w(TAG, "checkDownloadFileInfo, fileName: " + C1122c.m6818p0(fileInfo.getFileName()) + " downloadCheck:" + iCheckDownloadFileInfo);
                }
            }
        }
        c13914b.m83369N(arrayList5, this.thumbType, false);
        c13914b.m83369N(arrayList4, this.thumbType, true);
        if (arrayList2.size() == 0 && arrayList3.size() == 0 && this.thumbType == 0 && Version.isDropDownloadFileInfo() && !this.isSpaceTooLow) {
            C13914b.m83358q(this.callbackHandler, this.thumbType, Boolean.valueOf(this.isShare));
        }
        downloadFileInfoAndGetUrl(arrayList2, this.thumbType, this.isPriority, this.isNeedDownProgress, false);
        downloadFileInfoAndGetUrl(arrayList3, this.thumbType, this.isPriority, this.isNeedDownProgress, true);
    }

    private void downloadFileInfoAndGetUrl(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11, boolean z12) {
        if (arrayList == null || arrayList.isEmpty()) {
            C1120a.m6677i(TAG, "downFileList is empty");
        } else if (i10 == 0) {
            addOriginalTask(arrayList, i10, z10, z11, z12);
        } else {
            getUrlAndAddTask(arrayList, i10, z10, z11, z12);
        }
    }

    private void getUrlAndAddTask(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11, boolean z12) {
        C1120a.m6677i(TAG, "getUrlAndAddTask size: " + arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            if (next.isMigratedData()) {
                arrayList3.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        C1120a.m6677i(TAG, "downFileListV1: " + arrayList2.size() + ", downFileListV2: " + arrayList3.size());
        if (z12 || !CloudAlbumSettings.m14363h().m14376l()) {
            C9049c.m57060u(this.context, arrayList2, i10, z12, this.sessionId, false);
        } else if (!arrayList2.isEmpty()) {
            C1122c.m6750X1(this.context, C1122c.m6713L0(String.valueOf(141), false), "getDownloadUrl error original:" + ((FileInfo) arrayList2.get(0)).getFileId() + " thumbType:" + i10, "04004", OpsReport.m15253b("cloudphoto.file.geturl"), this.sessionId, true);
        }
        C9049c.m57060u(this.context, arrayList3, i10, z12, this.sessionId, false);
        C13914b c13914b = new C13914b(this.context, this.callbackHandler);
        Iterator<FileInfo> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            FileInfo next2 = it2.next();
            if (TextUtils.isEmpty(next2.getThumbUrl()) && next2.getAsset() == null) {
                recordCheckFailData(next2, 125);
                C1120a.m6678w(TAG, "thumb url is empty, filename:" + C1122c.m6818p0(next2.getFileName()));
                c13914b.m83365F(next2, i10, 125, z12);
                if (CloudAlbumSettings.m14363h().m14376l()) {
                    C1122c.m6765c(i10, next2);
                }
            } else if (TextUtils.isEmpty(next2.getThumbUrl())) {
                c13914b.m83371m(next2, i10, z10, z11, z12, 0, this.taskType, this.isForceDownload, this.sessionId);
            } else {
                c13914b.m83373o(next2, i10, z10, z12, this.taskType, this.sessionId, 0, this.isForceDownload, false);
            }
        }
        if (z10) {
            C2332m.m14608s().m14614G();
        }
    }

    private void recordCheckFailData(FileInfo fileInfo, int i10) {
        if (this.thumbType != 0) {
            return;
        }
        if (fileInfo == null) {
            C1120a.m6678w(TAG, "fileInfo is null");
            return;
        }
        if (this.isShare || TextUtils.isEmpty(fileInfo.getUniqueId())) {
            this.failList.add(C1122c.m6743V0(fileInfo.getFileId(), 6) + "_" + i10);
            return;
        }
        this.failList.add(C1122c.m6743V0(fileInfo.getUniqueId(), 6) + "_" + i10);
    }

    private void report() {
        C11060c c11060cM66626a = C11058a.m66626a(this.sessionId, "checkDownloadCondition", C13452e.m80781L().m80971t0());
        StringBuffer stringBuffer = new StringBuffer();
        c11060cM66626a.m66665u("0:1");
        if (this.failList.size() > 0) {
            stringBuffer.append("Fails number:" + this.failList.size() + " :uniqueIds:");
            for (int i10 = 0; i10 < 25 && i10 < this.failList.size(); i10++) {
                stringBuffer.append(this.failList.get(i10));
                stringBuffer.append(",");
            }
            c11060cM66626a.m66665u("101_4002");
            c11060cM66626a.m66635A(stringBuffer.toString());
            C13622a.m81969o(this.context, c11060cM66626a, null);
        }
    }

    private void singleFileShare(ArrayList<FileInfo> arrayList, ArrayList<FileInfo> arrayList2, FileInfo fileInfo, int i10) {
        C13914b c13914b = new C13914b(this.context, this.callbackHandler);
        if (i10 == 1) {
            this.successList.add(fileInfo.getUniqueId());
            arrayList.add(fileInfo);
            return;
        }
        if (i10 == 2) {
            arrayList2.add(fileInfo);
            return;
        }
        if (i10 == 149) {
            c13914b.m83364E(fileInfo, this.thumbType, true, 2);
            C1120a.m6678w(TAG, "Share file has in download file list, fileName: " + C1122c.m6818p0(fileInfo.getFileName()));
            return;
        }
        c13914b.m83365F(fileInfo, this.thumbType, i10, true);
        C1120a.m6678w(TAG, "checkDownloadFileInfo, Share fileName: " + C1122c.m6818p0(fileInfo.getFileName()) + " downloadCheck:" + i10);
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        ArrayList<FileInfo> arrayList = this.fileList;
        if (arrayList == null || arrayList.isEmpty()) {
            C1120a.m6676e(TAG, "downloadPhoto list is null");
            return 1;
        }
        C1120a.m6677i(TAG, "DownloadPhoto size:" + this.fileList.size() + ", thumbType: " + this.thumbType + ", isPriority: " + this.isPriority + " fileList[0]: " + C1122c.m6818p0(this.fileList.get(0).getFileName()) + ":" + this.fileList.get(0).getUniqueId());
        if (this.thumbType != 0) {
            this.defaultDownloadFileNum = 100;
        }
        int i10 = 0;
        while (i10 < this.fileList.size()) {
            downloadFileByPage(this.context, this.fileList, i10);
            C0068f.m459d().m468l();
            i10 += this.defaultDownloadFileNum;
        }
        if (this.thumbType == 0) {
            report();
        }
        if (!this.isSpaceTooLow) {
            C13914b.m83357p(this.callbackHandler, this.thumbType, Boolean.valueOf(this.isShare));
        }
        C1120a.m6677i(TAG, "DownloadPhoto size:" + this.fileList.size() + " end");
        return 0;
    }
}
