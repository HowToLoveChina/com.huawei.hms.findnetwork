package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import com.huawei.hicloud.request.opengw.bean.DownloadAddress;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1136q;
import p429kk.C11058a;
import p429kk.C11060c;
import p511o6.C11822d;
import p606r9.C12478a;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p746wn.C13622a;
import p801y7.C13914b;
import p804ya.C13927d;

/* loaded from: classes2.dex */
public class EuropeSDKDownloadCheckCallable extends AbstractCallableC2320a {
    private static final int DOWNLOAD_NEED = 1;
    private static final int DOWNLOAD_UNNEED = 0;
    private static final int DOWNLOAD_UPDATE_ALBUMANDCLOUD = 2;
    protected static final int LENGTH_CONST = 6;
    private static final String TAG = "EuropeSDKDownloadCheckCallable";
    private CallbackHandler callbackHandler;
    private Context context;
    private ArrayList<String> failList;
    private ArrayList<FileInfo> fileList;
    private boolean identifyShare;
    private boolean isAllowRepeat;
    private boolean isForceDownload;
    private boolean isNeedDownProgress;
    private boolean isPriority;
    private boolean isShare;
    private boolean isSpaceTooLow;
    C13914b sdkDownloadPhoto;
    private String sessionId;
    private ArrayList<String> successList;
    private int taskType;
    private int thumbType;

    public EuropeSDKDownloadCheckCallable(Context context, CallbackHandler callbackHandler, Object obj, boolean z10, ArrayList<FileInfo> arrayList, int i10, boolean z11, boolean z12, boolean z13, boolean z14, int i11, boolean z15, String str) {
        super(obj);
        this.thumbType = -1;
        this.isShare = false;
        this.isAllowRepeat = false;
        this.taskType = -1;
        this.isForceDownload = false;
        this.sdkDownloadPhoto = null;
        this.failList = new ArrayList<>();
        this.successList = new ArrayList<>();
        this.context = context;
        this.callbackHandler = callbackHandler;
        this.identifyShare = z10;
        this.fileList = arrayList;
        this.isPriority = z11;
        this.thumbType = i10;
        this.isNeedDownProgress = z12;
        this.isAllowRepeat = z14;
        this.isShare = z13;
        this.taskType = i11;
        this.isForceDownload = z15;
        this.sessionId = str;
    }

    private void addDownloadCallableTask(final FileInfo fileInfo, final int i10, boolean z10, final boolean z11, boolean z12, int i11, final String str, String str2, String str3, final int i12, boolean z13, DownloadAddress downloadAddress) {
        final String str4 = fileInfo.getAlbumId() + "_" + fileInfo.getUniqueId() + "_" + i10 + "_";
        EuropeSDKDownloadTaskCallable europeSDKDownloadTaskCallable = new EuropeSDKDownloadTaskCallable(this.context, this.callbackHandler, str, true, fileInfo, str2, z11, i10, str3, i12, i11, z13, downloadAddress, this.sessionId);
        AbstractC2324e abstractC2324e = new AbstractC2324e("") { // from class: com.huawei.android.hicloud.album.service.logic.callable.EuropeSDKDownloadCheckCallable.1
            @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2324e
            public void handle(Object obj) {
                HashMap<String, Object> map;
                C13914b.m83362u(EuropeSDKDownloadCheckCallable.this.callbackHandler, i12, str4, 2, null, false);
                if (obj != null) {
                    C1120a.m6675d(EuropeSDKDownloadCheckCallable.TAG, "HandleCallable addDownloadCallableTask fileName: " + C1122c.m6818p0(fileInfo.getFileName()) + ", thumbType is: " + i10 + ", download result: " + obj.toString());
                    if (obj instanceof HashMap) {
                        map = (HashMap) obj;
                    } else {
                        map = new HashMap<>();
                        map.put("code", "1");
                    }
                    HashMap<String, Object> map2 = map;
                    EuropeSDKDownloadCheckCallable europeSDKDownloadCheckCallable = EuropeSDKDownloadCheckCallable.this;
                    europeSDKDownloadCheckCallable.sdkDownloadPhoto.m83376x(map2, fileInfo, i10, z11, false, str, i12, europeSDKDownloadCheckCallable.sessionId);
                }
            }
        };
        C13914b.m83362u(this.callbackHandler, i12, str4, 1, new HashMap(), false);
        if (i10 == 2 || (i10 == 1 && !z10)) {
            if (z12) {
                C2332m.m14608s().m14626S(europeSDKDownloadTaskCallable, abstractC2324e, z10);
                return;
            } else if (i12 == 2) {
                C2332m.m14608s().m14627T(europeSDKDownloadTaskCallable, abstractC2324e, z10);
                return;
            } else {
                C2332m.m14608s().m14636b0(europeSDKDownloadTaskCallable, abstractC2324e, z10, fileInfo.getAddTime());
                return;
            }
        }
        if (i10 != 0) {
            C2332m.m14608s().m14633Z(europeSDKDownloadTaskCallable, abstractC2324e, z10);
            return;
        }
        this.sdkDownloadPhoto.m83368M(fileInfo, i10, 2);
        if (Version.isDropDownloadFileInfo()) {
            new C13914b(this.context, this.callbackHandler).m83364E(fileInfo, i10, this.isShare, 2);
        }
        C2332m.m14608s().m14629V(europeSDKDownloadTaskCallable, abstractC2324e, z10);
    }

    private int checkDownloadCondition(FileInfo fileInfo, boolean z10) {
        if (fileInfo == null) {
            return 0;
        }
        if (z10 || !TextUtils.isEmpty(fileInfo.getAlbumId())) {
            return ((z10 && TextUtils.isEmpty(fileInfo.getShareId())) || TextUtils.isEmpty(fileInfo.getFileName())) ? 0 : 1;
        }
        return 0;
    }

    private int checkDownloadFileInfo(FileInfo fileInfo, int i10, boolean z10, boolean z11) {
        if (checkDownloadCondition(fileInfo, z10) == 0) {
            recordFailData(fileInfo, 123);
            C1120a.m6675d(TAG, "params error, unneed download");
            return 123;
        }
        long jM6698G0 = C1122c.m6698G0(C1124e.m6871o(this.context));
        if (C1122c.m6681A1(i10, jM6698G0, fileInfo == null ? 0L : fileInfo.getSize())) {
            C1120a.m6676e(TAG, "checkDownload LocalSpaceTooLow, availSize:" + jM6698G0);
            this.isSpaceTooLow = true;
            return 126;
        }
        String shareId = z10 ? fileInfo.getShareId() : fileInfo.getAlbumId();
        if (z10 && TextUtils.isEmpty(fileInfo.getAlbumId())) {
            fileInfo.setAlbumId(fileInfo.getShareId());
        }
        String localRealPath = i10 == 0 ? fileInfo.getLocalRealPath() : i10 == 1 ? fileInfo.getLocalBigThumbPath() : fileInfo.getLocalThumbPath();
        if (!checkIsCanAdd(fileInfo, i10, z10, z11, shareId, localRealPath)) {
            recordFailData(fileInfo, 149);
            C1120a.m6675d(TAG, "can not add: " + C1122c.m6818p0(fileInfo.getFileName()) + " thumbType:" + i10);
            return 149;
        }
        if (checkFile(fileInfo, shareId, localRealPath, z10) == 1) {
            return 1;
        }
        recordFailData(fileInfo, 2);
        C1120a.m6675d(TAG, "download file is exist: " + C1122c.m6818p0(fileInfo.getFileName()) + "thumbType:" + i10);
        return 2;
    }

    private int checkFile(FileInfo fileInfo, String str, String str2, boolean z10) {
        if (fileInfo.getFileType() != 7 || this.thumbType != 0) {
            return checkSavePathExist(this.context, fileInfo, this.thumbType, str2) ? 0 : 1;
        }
        fileInfo.setLocalRealPath(str2);
        return 1;
    }

    private boolean checkIsCanAdd(FileInfo fileInfo, int i10, boolean z10, boolean z11, String str, String str2) {
        if (str2 != null) {
            return z11 || !DownloadPhotoBase.m14410e(this.context, fileInfo, i10, z10, false);
        }
        C1120a.m6676e(TAG, "thumbSavePath is null");
        return false;
    }

    private boolean checkSavePathExist(Context context, FileInfo fileInfo, int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i10 == 1) {
            fileInfo.setLocalBigThumbPath(str);
        } else if (i10 == 0) {
            fileInfo.setLocalRealPath(str);
        } else if (i10 == 2) {
            fileInfo.setLocalThumbPath(str);
        }
        File fileM63442h = C10278a.m63442h(str);
        return fileM63442h.exists() && fileM63442h.isFile();
    }

    private void downloadFileByPage(Context context, ArrayList<FileInfo> arrayList, int i10) throws Throwable {
        if (arrayList == null) {
            return;
        }
        ArrayList<FileInfo> arrayList2 = new ArrayList<>();
        this.sdkDownloadPhoto = new C13914b(context, this.callbackHandler);
        ArrayList<FileInfo> arrayList3 = new ArrayList<>();
        for (int i11 = i10; i11 < arrayList.size() && i11 < i10 + 100; i11++) {
            FileInfo fileInfo = arrayList.get(i11);
            if (fileInfo != null) {
                int iCheckDownloadFileInfo = checkDownloadFileInfo(fileInfo, this.thumbType, false, this.isAllowRepeat);
                C1120a.m6675d(TAG, "downloadFileByPage result: " + iCheckDownloadFileInfo + ", thumbType: " + this.thumbType + ", thumbPath: " + fileInfo.getLocalThumbPath());
                if (1 == iCheckDownloadFileInfo) {
                    if (this.thumbType == 0) {
                        this.successList.add(fileInfo.getUniqueId());
                    }
                    arrayList3.add(fileInfo);
                } else if (2 == iCheckDownloadFileInfo) {
                    arrayList2.add(fileInfo);
                } else if (iCheckDownloadFileInfo == 149) {
                    if (C11822d.m70440d(fileInfo, this.thumbType)) {
                        this.sdkDownloadPhoto.m83364E(fileInfo, this.thumbType, false, 1);
                    } else {
                        this.sdkDownloadPhoto.m83364E(fileInfo, this.thumbType, false, 2);
                    }
                    C1120a.m6678w(TAG, "General file has in download file list, fileName: " + C1122c.m6818p0(fileInfo.getFileName()));
                } else {
                    this.sdkDownloadPhoto.m83365F(fileInfo, this.thumbType, iCheckDownloadFileInfo, this.isShare);
                    C1120a.m6678w(TAG, "checkDownloadFileInfo, fileName: " + C1122c.m6818p0(fileInfo.getFileName()) + " downloadCheck:" + iCheckDownloadFileInfo);
                }
            }
        }
        this.sdkDownloadPhoto.m83369N(arrayList2, this.thumbType, false);
        if (arrayList3.size() == 0 && this.thumbType == 0 && Version.isDropDownloadFileInfo() && !this.isSpaceTooLow) {
            C13914b.m83358q(this.callbackHandler, this.thumbType, Boolean.valueOf(this.isShare));
        }
        downloadFileInfoAndGetUrl(arrayList3, this.thumbType, this.isPriority, this.isNeedDownProgress);
    }

    private void downloadFileInfo(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11) {
        if (isConditionError(arrayList)) {
            C1120a.m6678w(TAG, "downloadFileInfo condition error");
            return;
        }
        if (i10 == 1 || i10 == 2) {
            downloadThumbnail(arrayList, i10, z10, z11);
            return;
        }
        String strM80971t0 = C13452e.m80781L().m80971t0();
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            next.setUserID(strM80971t0);
            this.sdkDownloadPhoto.m83371m(next, i10, z10, z11, false, 0, this.taskType, this.isForceDownload, this.sessionId);
        }
    }

    private void downloadFileInfoAndGetAsset(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11) throws Throwable {
        if (isConditionError(arrayList)) {
            C1120a.m6678w(TAG, "downloadFileInfoAndGetAsset condition error");
            return;
        }
        Map<String, Asset> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        try {
            C13927d c13927d = new C13927d(C1122c.m6755Z0("04004"));
            c13927d.m83587p(false);
            c13927d.m83579h(arrayList, i10, map, map2, this.isShare);
            C1120a.m6677i(TAG, "getDownloadAddress success");
        } catch (IOException e10) {
            C1120a.m6676e(TAG, "getDownloadAddress Fail, error:" + e10.toString());
        }
        String strM80971t0 = C13452e.m80781L().m80971t0();
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getFileId())) {
                next.setUserID(strM80971t0);
                String fileId = next.getFileId();
                if (C1122c.m6831s1(fileId)) {
                    fileId = next.getUniqueId();
                }
                Asset asset = map.get(fileId);
                String str = map2.get(fileId);
                if (i10 == 0) {
                    next.setFileUrl(str);
                } else {
                    next.setThumbUrl(str);
                }
                next.setAsset(asset);
                if (asset != null) {
                    this.sdkDownloadPhoto.m83371m(next, i10, z10, z11, false, 0, this.taskType, this.isForceDownload, this.sessionId);
                } else if (i10 == 1 || i10 == 2) {
                    this.sdkDownloadPhoto.m83373o(next, i10, z10, this.isShare, this.taskType, this.sessionId, 0, this.isForceDownload, false);
                } else {
                    this.sdkDownloadPhoto.m83371m(next, i10, z10, z11, false, 0, this.taskType, this.isForceDownload, this.sessionId);
                }
            }
        }
        if (z10) {
            C2332m.m14608s().m14614G();
        }
    }

    private void downloadFileInfoAndGetUrl(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11) throws Throwable {
        ArrayList<FileInfo> arrayList2 = new ArrayList<>();
        ArrayList<FileInfo> arrayList3 = new ArrayList<>();
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            if (next.isMigratedData()) {
                arrayList3.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        downloadFileInfo(arrayList2, i10, z10, z11);
        downloadFileInfoAndGetAsset(arrayList3, i10, z10, z11);
    }

    private void downloadThumbnail(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11) {
        Map<String, Map<String, DownloadAddress>> mapM74919p;
        String strM80971t0 = C13452e.m80781L().m80971t0();
        HashMap map = new HashMap();
        String str = i10 == 2 ? "small" : "large";
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_ALBUM, C1122c.m6755Z0("04004"));
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            next.setAlbumId(next.getAlbumId());
            next.setUserID(strM80971t0);
            String serverPath = getServerPath(next);
            if (serverPath != null) {
                C1120a.m6675d(TAG, "download serverpath :" + serverPath);
                next.setThumbUrl(serverPath);
                map.put(serverPath, new String[]{str});
            }
        }
        try {
            mapM74919p = c12478a.m74919p(map);
        } catch (C9721b e10) {
            C1120a.m6676e(TAG, "getDownloadAddress Fail, error:" + e10.toString());
            mapM74919p = null;
        }
        if (mapM74919p == null) {
            Iterator<FileInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.sdkDownloadPhoto.m83371m(it2.next(), i10, z10, z11, false, 0, this.taskType, this.isForceDownload, this.sessionId);
            }
            return;
        }
        C1120a.m6677i(TAG, "addressMap not null , list size is: " + arrayList.size() + ", thumbType: " + i10);
        Iterator<FileInfo> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            FileInfo next2 = it3.next();
            Map<String, DownloadAddress> map2 = mapM74919p.get(next2.getThumbUrl());
            addDownloadThumbPhotoWithAddrTask(next2, i10, z10, z11, false, 0, this.taskType, this.isForceDownload, map2 != null ? map2.get(str) : null);
        }
        C2332m.m14608s().m14615H();
    }

    private String getServerPath(FileInfo fileInfo) {
        if (fileInfo.getFileAttribute() == 1) {
            return "/GallerySyncRecycle/" + fileInfo.getFileName();
        }
        if (fileInfo.getFileAttribute() != 0) {
            return null;
        }
        return "/GallerySync/" + fileInfo.getAlbumId() + "/" + fileInfo.getFileName();
    }

    private boolean isConditionError(ArrayList<FileInfo> arrayList) {
        if (arrayList == null || arrayList.size() < 1) {
            return true;
        }
        if (C1136q.e.m7166d(this.context)) {
            return false;
        }
        C1120a.m6678w(TAG, "generalAlbum swith is off, ignore");
        return true;
    }

    private void recordFailData(FileInfo fileInfo, int i10) {
        if (this.thumbType != 0) {
            return;
        }
        if (fileInfo == null) {
            C1120a.m6678w(TAG, "fileInfo is null");
            return;
        }
        if (TextUtils.isEmpty(fileInfo.getUniqueId())) {
            this.failList.add(C1122c.m6743V0(fileInfo.getFileId(), 6) + "_" + i10);
            return;
        }
        this.failList.add(C1122c.m6743V0(fileInfo.getUniqueId(), 6) + "_" + i10);
    }

    private void report() {
        C11060c c11060cM66626a = C11058a.m66626a(this.sessionId, "checkDownloadCondition", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0:1");
        StringBuffer stringBuffer = new StringBuffer();
        if (this.failList.size() > 0) {
            c11060cM66626a.m66665u("101_4002");
            stringBuffer.append("Fails number:" + this.failList.size() + " uniqueIds:");
            for (int i10 = 0; i10 < 25 && i10 < this.failList.size(); i10++) {
                stringBuffer.append(this.failList.get(i10));
                stringBuffer.append(",");
            }
        }
        if (this.successList.size() > 0) {
            stringBuffer.append("Success number:" + this.successList.size());
            c11060cM66626a.m66635A(stringBuffer.toString());
            c11060cM66626a.m66665u("0:1");
        } else {
            c11060cM66626a.m66635A(stringBuffer.toString());
        }
        C13622a.m81969o(this.context, c11060cM66626a, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addDownloadThumbPhotoWithAddrTask(com.huawei.android.p069cg.p072vo.FileInfo r14, int r15, boolean r16, boolean r17, boolean r18, int r19, int r20, boolean r21, com.huawei.hicloud.request.opengw.bean.DownloadAddress r22) {
        /*
            r13 = this;
            r2 = r15
            java.lang.String r0 = "EuropeSDKDownloadCheckCallable"
            if (r14 == 0) goto L65
            java.lang.String r1 = r14.getAlbumId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L65
            java.lang.String r1 = r14.getFileName()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L1a
            goto L65
        L1a:
            java.lang.String r1 = r14.getUniqueId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L2a
            java.lang.String r1 = "addDownloadThumbPhotoWithAddrTask uniqueId is null"
            p031b7.C1120a.m6676e(r0, r1)
            return
        L2a:
            r0 = 2
            r1 = 1
            if (r2 != r0) goto L39
            java.lang.String r0 = r14.getLocalThumbPath()
            java.lang.String r3 = r14.getLocalThumbPath()
        L36:
            r7 = r0
            r8 = r3
            goto L47
        L39:
            if (r2 != r1) goto L44
            java.lang.String r0 = r14.getLocalBigThumbPath()
            java.lang.String r3 = r14.getLocalBigThumbPath()
            goto L36
        L44:
            r0 = 0
            r7 = r0
            r8 = r7
        L47:
            if (r2 != r1) goto L4e
            if (r16 != 0) goto L4e
            r0 = 3
            r10 = r0
            goto L50
        L4e:
            r10 = r20
        L50:
            java.lang.String r9 = "album"
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r11 = r21
            r12 = r22
            r0.addDownloadCallableTask(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        L65:
            java.lang.String r1 = "addDownloadThumbPhotoWithAddrTask albumId or hash is null"
            p031b7.C1120a.m6676e(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.album.service.logic.callable.EuropeSDKDownloadCheckCallable.addDownloadThumbPhotoWithAddrTask(com.huawei.android.cg.vo.FileInfo, int, boolean, boolean, boolean, int, int, boolean, com.huawei.hicloud.request.opengw.bean.DownloadAddress):void");
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        ArrayList<FileInfo> arrayList = this.fileList;
        if (arrayList == null || arrayList.size() < 1) {
            C1120a.m6676e(TAG, "downloadPhoto list is null");
            return 1;
        }
        C1120a.m6677i(TAG, "DownloadPhoto size:" + this.fileList.size() + ", thumbType: " + this.thumbType + ", identifyShare: " + this.identifyShare);
        for (int i10 = 0; i10 < this.fileList.size(); i10 += 100) {
            downloadFileByPage(this.context, this.fileList, i10);
            C0068f.m459d().m468l();
        }
        if (this.thumbType == 0) {
            report();
        }
        return 0;
    }
}
