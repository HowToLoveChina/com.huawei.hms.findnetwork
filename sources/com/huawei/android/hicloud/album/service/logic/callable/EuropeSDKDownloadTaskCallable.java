package com.huawei.android.hicloud.album.service.logic.callable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.drive.asset.AssetDownloaderProgressListener;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.CloudPhotoDownloadProgress;
import com.huawei.android.p069cg.request.callable.EuropeDownloadTaskBaseCallable;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.hicloud.request.opengw.bean.DownloadAddress;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import ga.C9899b;
import hk.C10278a;
import java.util.HashMap;
import p009a8.C0066d;
import p009a8.C0068f;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;
import p804ya.C13927d;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes2.dex */
public class EuropeSDKDownloadTaskCallable extends EuropeDownloadTaskBaseCallable {
    private static final String TAG = "EuropeSDKDownloadTaskCallable";

    public EuropeSDKDownloadTaskCallable(Context context, CallbackHandler callbackHandler, String str, String str2, boolean z10, Object obj, String str3, boolean z11, int i10, String str4, int i11, int i12, boolean z12, String str5, boolean z13) {
        super(obj, i10);
        this.context = context;
        this.savePath = str;
        this.fileInfo = (FileInfo) obj;
        this.saveCachePath = str3;
        this.isNeedDownProgress = z11;
        ((EuropeDownloadTaskBaseCallable) this).thumbType = i10;
        this.taskType = i11;
        this.isForceDownload = z12;
        this.callbackHandler = callbackHandler;
        this.traceId = C1122c.m6755Z0("04004");
        this.asset = this.fileInfo.getAsset();
        this.isAlbumClient = z13;
    }

    private void checkOrgCachePath() {
        String lpath = this.fileInfo.getLpath();
        if (((EuropeDownloadTaskBaseCallable) this).thumbType != 0) {
            return;
        }
        if (TextUtils.isEmpty(this.savePath)) {
            C1120a.m6676e(TAG, "org save path is null:" + C1122c.m6818p0(this.fileInfo.getFileName()));
            return;
        }
        try {
            if (!TextUtils.isEmpty(lpath)) {
                int iIndexOf = this.savePath.indexOf(lpath);
                if (iIndexOf >= 0 && !C10278a.m63442h(this.savePath.substring(0, iIndexOf)).exists()) {
                    C1120a.m6677i(TAG, "root path is not exist:" + C1122c.m6818p0(this.fileInfo.getFileName()));
                    this.saveCachePath = C1124e.m6866j() + "/Pictures/hiddenAlbum/.tmp/" + this.fileInfo.getAlbumId() + "/" + this.fileInfo.getFileName();
                    StringBuilder sb2 = new StringBuilder(C1124e.m6866j());
                    sb2.append(lpath);
                    sb2.append("/");
                    sb2.append(this.fileInfo.getFileName());
                    this.savePath = sb2.toString();
                    return;
                }
                return;
            }
            int iIndexOf2 = this.savePath.indexOf(this.fileInfo.getFileName());
            if (iIndexOf2 < 0) {
                return;
            }
            String strSubstring = this.savePath.substring(0, iIndexOf2 - 1);
            C1120a.m6675d(TAG, "rootPath" + strSubstring);
            if (C10278a.m63442h(strSubstring).exists()) {
                return;
            }
            C1120a.m6677i(TAG, "root path is not exist:" + C1122c.m6818p0(this.fileInfo.getFileName()));
            this.saveCachePath = C1124e.m6866j() + "/Pictures/hiddenAlbum/.tmp/" + this.fileInfo.getAlbumId() + "/" + this.fileInfo.getFileName();
            StringBuilder sb3 = new StringBuilder(C1124e.m6866j());
            sb3.append("/");
            sb3.append(this.fileInfo.getFileName());
            this.savePath = sb3.toString();
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "check org cache error:" + e10.getMessage());
        }
    }

    private String downloadAsset() throws Throwable {
        try {
            C13927d c13927d = new C13927d(this.traceId);
            HashMap map = new HashMap();
            map.put("thumbType", "" + getThumbType());
            map.put("videoThumbId", "" + this.fileInfo.getVideoThumbId());
            map.put("fileType", String.valueOf(this.fileInfo.getFileType()));
            map.put(ContentResource.FILE_NAME, this.fileInfo.getFileName());
            map.put("fileUnique", this.fileInfo.getUploadTime());
            final CloudPhotoDownloadProgress cloudPhotoDownloadProgress = new CloudPhotoDownloadProgress(getThumbType(), this.fileInfo);
            cloudPhotoDownloadProgress.setCallbackHandler(this.callbackHandler);
            c13927d.m83591t(new AssetDownloaderProgressListener() { // from class: com.huawei.android.hicloud.album.service.logic.callable.EuropeSDKDownloadTaskCallable.1
                @Override // com.huawei.android.hicloud.drive.asset.AssetDownloaderProgressListener
                public void progressChanged(C9899b c9899b) {
                    if (((EuropeDownloadTaskBaseCallable) EuropeSDKDownloadTaskCallable.this).isNeedDownProgress && !((AbstractCallableC2320a) EuropeSDKDownloadTaskCallable.this).isCancel) {
                        cloudPhotoDownloadProgress.onProgress(c9899b.m61454S(), c9899b.m61458W());
                    }
                    if (((AbstractCallableC2320a) EuropeSDKDownloadTaskCallable.this).isCancel) {
                        return;
                    }
                    C0068f.m459d().m468l();
                }
            });
            c13927d.m83592u(this.fileInfo.getUserID());
            c13927d.m83587p(this.isAlbumClient);
            c13927d.m83578g(C10278a.m63442h(this.saveCachePath), C1122c.m6814o0(this.fileInfo), this.asset, ((EuropeDownloadTaskBaseCallable) this).thumbType, map, this.fileInfo);
            C1120a.m6677i(TAG, "download file end : " + this.saveCachePath);
            if (C0066d.m437a(this.saveCachePath, this.asset, ((EuropeDownloadTaskBaseCallable) this).thumbType, C1122c.m6814o0(this.fileInfo), this.traceId)) {
                return getDownloadStatus();
            }
            C1120a.m6676e(TAG, "different size delete file isSuccess = " + C1122c.m6694F(this.saveCachePath));
            return "1";
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "downloadAsset Exception:" + e10.toString());
            return "1";
        }
    }

    private void reportEuropeStartDownload(String str) {
        String id2;
        String strValueOf;
        C1120a.m6677i(TAG, "reportEuropeStartDownload " + str);
        if (this.fileInfo == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("thumbType", String.valueOf(((EuropeDownloadTaskBaseCallable) this).thumbType));
        map.put(ContentResource.FILE_NAME, this.fileInfo.getFileName());
        map.put("isForceDownload", String.valueOf(this.isForceDownload ? 1 : 0));
        if (CloudAlbumSettings.m14363h().m14386v()) {
            map.put("galleryNetworkSwitch", String.valueOf(CloudAlbumSettings.m14363h().m14379o() ? 1 : 0));
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.traceId, "reportEuropeStartDownload", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0:1");
        c11060cM66626a.m66635A(str);
        Asset asset = this.asset;
        if (asset != null) {
            String id3 = asset.getId();
            id2 = "";
            if (this.asset.getResource() != null) {
                id2 = this.asset.getResource().getId();
                strValueOf = this.asset.getResource().getType() != null ? String.valueOf(this.asset.getResource().getType()) : "";
            } else {
                strValueOf = "";
            }
            c11060cM66626a.m66638D(id3 + "_" + this.fileInfo.getFileId() + "_" + id2 + "_" + strValueOf);
        } else {
            c11060cM66626a.m66638D(this.fileInfo.getFileId());
        }
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
    }

    @Override // com.huawei.android.p069cg.request.callable.EuropeDownloadTaskBaseCallable, com.huawei.android.p069cg.request.threadpool.AbstractC2328i, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        String downloadResult;
        C1120a.m6675d(TAG, "call savePath: " + this.savePath + ", thumbType: " + ((EuropeDownloadTaskBaseCallable) this).thumbType + ", currentThread id: " + Thread.currentThread().getId());
        if (((EuropeDownloadTaskBaseCallable) this).thumbType == 0) {
            downloadOriginalPhoto();
        }
        String strCheckDownloadCondition = checkDownloadCondition(this.context);
        if (strCheckDownloadCondition != null) {
            reportWithDownloadFail(strCheckDownloadCondition);
            this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
            return this.res;
        }
        boolean zCheckDir = checkDir(this.savePath, ((EuropeDownloadTaskBaseCallable) this).thumbType != 0);
        boolean zCheckDir2 = checkDir(this.saveCachePath, true);
        C1120a.m6675d(TAG, "call check directory result, checkSavePath: " + zCheckDir + ",checkCachePath:" + zCheckDir2);
        checkOrgCachePath();
        if (!zCheckDir || !zCheckDir2) {
            this.res.put("code", "1");
            this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
            String str = "mkdir error, checkSavePath=" + zCheckDir + ", checkCachePath=" + zCheckDir2 + ", thumbType=" + ((EuropeDownloadTaskBaseCallable) this).thumbType + ", " + C1122c.m6754Z(((EuropeDownloadTaskBaseCallable) this).thumbType) + ", " + C1122c.m6758a0();
            C1120a.m6676e(TAG, str);
            C1122c.m6750X1(this.context, C1122c.m6713L0("3016", true), str, "04004", "checkDir", this.traceId, true);
            return this.res;
        }
        C1120a.m6677i(TAG, "begin EuropeSDKDownload: fileName: " + C1122c.m6818p0(this.fileInfo.getFileName()) + ", thumbType: " + ((EuropeDownloadTaskBaseCallable) this).thumbType);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.asset != null) {
            reportEuropeStartDownload("downloadV2");
            downloadResult = downloadAsset();
        } else {
            reportEuropeStartDownload("downloadV1");
            downloadResult = getDownloadResult();
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        this.res.put("code", downloadResult);
        this.res.put("isForceDownload", Boolean.valueOf(this.isForceDownload));
        C1120a.m6677i(TAG, "end EuropeSDKDownload: fileName: " + C1122c.m6818p0(this.fileInfo.getFileName()) + ", thumbType: " + ((EuropeDownloadTaskBaseCallable) this).thumbType + ", return: " + downloadResult + ", totalTime: " + jCurrentTimeMillis2 + "ms");
        C1120a.m6675d(TAG, "download complete");
        return this.res;
    }

    public EuropeSDKDownloadTaskCallable(Context context, CallbackHandler callbackHandler, String str, boolean z10, Object obj, String str2, boolean z11, int i10, String str3, int i11, int i12, boolean z12, DownloadAddress downloadAddress, String str4) {
        super(obj, i10);
        this.context = context;
        this.savePath = str;
        this.saveCachePath = str2;
        this.fileInfo = (FileInfo) obj;
        this.isNeedDownProgress = z11;
        this.taskType = i11;
        ((EuropeDownloadTaskBaseCallable) this).thumbType = i10;
        this.isForceDownload = z12;
        this.downloadAddress = downloadAddress;
        this.callbackHandler = callbackHandler;
        this.traceId = C1122c.m6755Z0("04004");
        this.asset = this.fileInfo.getAsset();
    }
}
