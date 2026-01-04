package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.utils.CompressUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.drive.cloudphoto.CloudPhotoMediaUploaderProgressListener;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.response.QueryUserSpaceResponse;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0069g;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.AbstractC1139t;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1125f;
import p031b7.C1128i;
import p031b7.C1141v;
import p031b7.InterfaceC1126g;
import p511o6.C11820b;
import p546p6.C12088a;
import p606r9.C12478a;
import p649t6.C12947g;
import p649t6.C12950j;
import p652t9.EnumC12999a;
import p671u7.C13130b;
import p701v6.C13361h;
import p709vj.C13452e;
import p804ya.C13928e;

/* loaded from: classes2.dex */
public class PhotoUploadCallable extends SDKUploadAsyncBaseCallable {
    private static final String TAG = "PhotoUploadCallable";
    private long lastProgress;
    private long lastSpeed;
    private C12947g mediaDataOperator;
    private MediaFileBean uploadItem;

    public PhotoUploadCallable(Context context, Object obj, String str, CallbackHandler callbackHandler) {
        super(obj);
        this.lastProgress = -1L;
        this.lastSpeed = -1L;
        this.context = context;
        this.callbackHandler = callbackHandler;
        MediaFileBean mediaFileBean = (MediaFileBean) obj;
        this.uploadItem = mediaFileBean;
        this.preFileInfo = mediaFileBean.m14329e();
        this.traceId = str;
        this.mediaDataOperator = new C12947g();
    }

    private String checkShareSpaceEnough(String str) {
        QueryUserSpaceResponse queryUserSpaceResponseM80113o;
        int code;
        String shareId = this.preFileInfo.getShareId();
        String resource = this.preFileInfo.getResource();
        C1120a.m6677i(TAG, "checkShareSpaceEnough resource: " + resource);
        if (TextUtils.isEmpty(resource)) {
            C1120a.m6676e(TAG, "checkShareSpaceEnough resource is null or empty");
            return "7";
        }
        try {
            queryUserSpaceResponseM80113o = new C13361h(this.context, str, resource, shareId, this.traceId, true).m80113o(QueryUserSpaceResponse.class);
            code = queryUserSpaceResponseM80113o.getCode();
            C1120a.m6677i(TAG, "checkShareSpaceEnough bapi.dbank.queryspace: " + code);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "checkShareSpaceEnough error: " + e10.toString());
        }
        if (code != 401) {
            String strCheckSpaceResult = checkSpaceResult(queryUserSpaceResponseM80113o, code);
            return strCheckSpaceResult != null ? strCheckSpaceResult : "7";
        }
        this.callbackHandler.stInvalid(true);
        C1120a.m6676e(TAG, "checkShareSpaceEnough auth error");
        return "7";
    }

    private String checkSpaceEnough() {
        String createrId = this.preFileInfo.getCreaterId();
        String userID = this.preFileInfo.getUserID();
        if (TextUtils.isEmpty(createrId) || TextUtils.isEmpty(userID)) {
            C1120a.m6676e(TAG, "upload sharePhoto userId or creatorId illegal");
            return "1";
        }
        C1120a.m6675d(TAG, "upload share info userId: " + this.preFileInfo.getUserID() + ", createId: " + this.preFileInfo.getCreaterId() + ", Source: " + this.preFileInfo.getSource() + ", ShareId: " + this.preFileInfo.getShareId());
        return createrId.equals(userID) ? checkUserSpaceEnough() : checkShareSpaceEnough(userID);
    }

    private String checkSpaceResult(QueryUserSpaceResponse queryUserSpaceResponse, int i10) {
        if (i10 != 0) {
            C1120a.m6676e(TAG, "checkShareSpaceEnough error: " + i10 + ",info: " + queryUserSpaceResponse.getInfo());
            return null;
        }
        long useSpaceSize = queryUserSpaceResponse.getUseSpaceSize();
        long totalSpaceSize = queryUserSpaceResponse.getTotalSpaceSize();
        File fileM63442h = C10278a.m63442h(this.preFileInfo.getLocalRealPath());
        if (totalSpaceSize > useSpaceSize && fileM63442h.length() <= totalSpaceSize - useSpaceSize) {
            return "0";
        }
        C1120a.m6678w(TAG, "checkShareSpace too low, total: " + totalSpaceSize + ", used: " + useSpaceSize + ", upload size: " + fileM63442h.length());
        return "5";
    }

    private int createFileInfoToCloud(FileInfo fileInfo) throws JSONException, NumberFormatException {
        Media mediaM78972a = C13130b.m78972a(fileInfo, isOwner(fileInfo));
        File fileM63442h = C10278a.m63442h(fileInfo.getLocalRealPath());
        File fileM63442h2 = C10278a.m63442h(fileInfo.getLocalThumbPath());
        File fileM63442h3 = C10278a.m63442h(fileInfo.getLocalBigThumbPath());
        try {
            HashMap<String, String> map = new HashMap<>();
            C13928e c13928e = new C13928e(this.traceId, mediaM78972a, fileM63442h, fileM63442h2, fileM63442h3, CompressUtil.m15280b(fileInfo, map, this.traceId));
            C12088a.m72266c().m72270e(C12088a.c.SHARE_PHOTO_UPLOAD, true);
            String albumId = TextUtils.isEmpty(fileInfo.getShareId()) ? fileInfo.getAlbumId() : fileInfo.getShareId();
            Context contextM1377a = C0213f.m1377a();
            map.put("thumbType", "0");
            String lpath = fileInfo.getLpath();
            if (TextUtils.isEmpty(lpath)) {
                lpath = fileInfo.getFileUploadType();
            }
            map.put("fileUnique", "" + albumId + "_" + lpath + "/" + fileInfo.getFileName());
            map.put("battery", C1122c.m6748X(contextM1377a));
            map.put("screen", C1122c.m6725P0(contextM1377a));
            map.put("mobile_network", C1122c.m6851z0(contextM1377a));
            map.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
            map.put("galleryVersion", C1122c.m6833t0(contextM1377a));
            map.put("fileType", String.valueOf(fileInfo.getFileType()));
            map.put("dataVer", "2.0");
            c13928e.m83613L(fileInfo.getUserID());
            c13928e.m83610I(true);
            c13928e.m83614M(new CloudPhotoMediaUploaderProgressListener() { // from class: com.huawei.android.hicloud.album.service.logic.callable.PhotoUploadCallable.2
                @Override // com.huawei.android.hicloud.drive.cloudphoto.CloudPhotoMediaUploaderProgressListener
                public void progressChanged(C13928e c13928e2) {
                    if (!PhotoUploadCallable.this.isCancel()) {
                        PhotoUploadCallable.this.sendProgressMsg(c13928e2.m83635w(), c13928e2.m83633u(), c13928e2.m83632t(), c13928e2.m83634v());
                    } else {
                        c13928e2.m83619c(PhotoUploadCallable.this.getCancelCode(), "upload canceled");
                        C1120a.m6678w(PhotoUploadCallable.TAG, "canceled");
                    }
                }
            });
            this.mediaDataOperator.m77818e0(c13928e.m83615N(map));
            return 0;
        } catch (C9721b e10) {
            int detailErrorCode = getDetailErrorCode(e10);
            C1120a.m6676e(TAG, "createFileInfoToCloud:CException=" + e10.toString());
            return detailErrorCode;
        } catch (IOException e11) {
            int createFileErrorCode = getCreateFileErrorCode(e11);
            C1120a.m6676e(TAG, "createFileInfoToCloud:ex=" + e11.toString());
            return createFileErrorCode;
        } catch (Exception e12) {
            C1120a.m6676e(TAG, "createFileInfoToCloud:Exception=" + e12.toString());
            return 1;
        }
    }

    private void generateThumbnail(MediaFileBean mediaFileBean) {
        FileInfo fileInfoM14329e = mediaFileBean.m14329e();
        int fileType = fileInfoM14329e.getFileType();
        InterfaceC1126g c1141v = fileType != 1 ? fileType != 4 ? null : new C1141v() : new C1128i();
        if (c1141v == null) {
            return;
        }
        AbstractC1139t abstractC1139tMo6901a = c1141v.mo6901a();
        String fileName = fileInfoM14329e.getFileName();
        String strM6786h0 = C1122c.m6786h0(2, fileInfoM14329e.getAlbumId(), fileName);
        String strM6786h02 = C1122c.m6786h0(1, fileInfoM14329e.getAlbumId(), fileName);
        this.preFileInfo.setLocalThumbPath(strM6786h0);
        this.preFileInfo.setLocalBigThumbPath(strM6786h02);
        abstractC1139tMo6901a.mo6908c(fileInfoM14329e.getAlbumId(), fileName, C10278a.m63442h(fileInfoM14329e.getLocalRealPath()), 100);
        abstractC1139tMo6901a.mo6910f(fileInfoM14329e.getAlbumId(), fileName, C10278a.m63442h(fileInfoM14329e.getLocalRealPath()), 100);
        C1120a.m6677i(TAG, "generateThumbnail end");
    }

    private int getCreateFileErrorCode(IOException iOException) {
        return !(iOException instanceof C4616s) ? C1122c.m6845x0(iOException) : C1122c.m6802l0((C4616s) iOException);
    }

    private int getDetailErrorCode(C9721b c9721b) {
        String strM60660d = c9721b.m60660d();
        if ("31084932".equals(strM60660d)) {
            if (TextUtils.isEmpty(this.mediaDataOperator.m77810W(this.preFileInfo.getAlbumId(), this.preFileInfo.getFileName()).getId())) {
                return 1005;
            }
            C1120a.m6675d(TAG, "getDetailErrorCode file has been uploaded");
            return 0;
        }
        if ("31084039".equals(strM60660d)) {
            return 1003;
        }
        if ("31084906".equals(strM60660d)) {
            return 1006;
        }
        if ("31004933".equals(strM60660d) || "31004939".equals(strM60660d)) {
            return 1004;
        }
        if (strM60660d.endsWith("4036")) {
            return 1007;
        }
        return C1122c.m6731R0(strM60660d);
    }

    private boolean isOwner(FileInfo fileInfo) {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0) || TextUtils.isEmpty(fileInfo.getUserID())) {
            return true;
        }
        return strM80971t0.equals(fileInfo.getUserID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendProgressMsg(long j10, long j11, long j12, long j13) {
        if (this.lastProgress == j12 && this.lastSpeed == j13) {
            return;
        }
        this.lastProgress = j12;
        this.lastSpeed = j13;
        C1120a.m6675d(TAG, "sendProgressMsg:file=" + C1122c.m6818p0(this.uploadItem.m14331f()) + " value = " + j10 + ", total = " + j11 + ", progress = " + j12 + ", speed = " + j13);
        String strM518z = C0069g.m479y().m518z(this.uploadItem);
        if (TextUtils.isEmpty(strM518z)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("ALBUM_ID", this.preFileInfo.getAlbumId());
        bundle.putString("FILE_UNIQUE", strM518z);
        bundle.putLong("UPLOADED_SIZE", j10);
        bundle.putLong("TOTAL_SIZE", j11);
        bundle.putLong("UPLOAD_PROGRESS", j12);
        bundle.putLong("UPLOAD_SPEED", j13);
        this.callbackHandler.sendMessage(200, bundle);
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        C1120a.m6675d(TAG, "upload thread start, fileName: " + C1122c.m6818p0(this.preFileInfo.getFileName()) + ", fileHash: " + this.preFileInfo.getHash() + ", fileShareId: " + this.preFileInfo.getShareId() + ", fileStatus: 1");
        if (!isCloudSyncAllowed()) {
            return 1;
        }
        int iCheckFileInvalid = checkFileInvalid(this.preFileInfo);
        if (iCheckFileInvalid != 0) {
            C1122c.m6750X1(this.context, C1122c.m6713L0(String.valueOf(iCheckFileInvalid), true), "check file invalid", "04005", "checkFileInvalid", this.traceId, true);
            return Integer.valueOf(iCheckFileInvalid);
        }
        if (this.preFileInfo.isRename()) {
            String strM6786h0 = C1122c.m6786h0(0, this.preFileInfo.getAlbumId(), this.preFileInfo.getFileName());
            C1120a.m6677i(TAG, "execute rename: " + C1122c.m6818p0(strM6786h0));
            C1125f.m6885f(this.preFileInfo.getLocalRealPath(), strM6786h0, false);
            this.preFileInfo.setLocalRealPath(strM6786h0);
        }
        generateThumbnail(this.uploadItem);
        this.mediaDataOperator.m77819f0(this.preFileInfo);
        new C12950j().m77861q(this.preFileInfo);
        FileInfo fileInfo = this.preFileInfo;
        fileInfo.setShareId(fileInfo.getAlbumId());
        this.preFileInfo.setResource(PowerKitApplyUtil.GROUP_ALBUM);
        String strCheckSpaceEnough = checkSpaceEnough();
        if ("7".equals(strCheckSpaceEnough)) {
            return 121;
        }
        if ("5".equals(strCheckSpaceEnough)) {
            return 122;
        }
        return "8".equals(strCheckSpaceEnough) ? Integer.valueOf(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED) : Integer.valueOf(uploadFromLocal());
    }

    @Override // com.huawei.android.hicloud.album.service.logic.callable.SDKUploadAsyncBaseCallable, com.huawei.android.p069cg.request.callable.BaseUploadCallable
    public int checkFileInvalid(FileInfo fileInfo) {
        if (!TextUtils.isEmpty(fileInfo.getHash()) && ((!TextUtils.isEmpty(fileInfo.getShareId()) || !TextUtils.isEmpty(fileInfo.getAlbumId())) && !TextUtils.isEmpty(fileInfo.getUserID()))) {
            return super.checkFileInvalid(fileInfo);
        }
        C1120a.m6676e(TAG, "share file params error, fileName: " + C1122c.m6818p0(fileInfo.getFileName()));
        return 119;
    }

    @Override // com.huawei.android.p069cg.request.callable.BaseUploadCallable
    public HashMap<String, String> cloudPhotoUpload(Context context, File file, String str) throws Throwable {
        Thread threadCurrentThread = Thread.currentThread();
        HashMap<String, String> map = new HashMap<>();
        HashMap map2 = new HashMap();
        String albumId = TextUtils.isEmpty(this.preFileInfo.getShareId()) ? this.preFileInfo.getAlbumId() : this.preFileInfo.getShareId();
        map2.put("thumbType", "" + getThumbType());
        String lpath = this.preFileInfo.getLpath();
        if (TextUtils.isEmpty(lpath)) {
            lpath = this.preFileInfo.getFileUploadType();
        }
        map2.put("fileUnique", "" + albumId + "_" + lpath + "/" + this.preFileInfo.getFileName());
        map2.put("battery", C1122c.m6748X(context));
        map2.put("screen", C1122c.m6725P0(context));
        map2.put("mobile_network", C1122c.m6851z0(context));
        map2.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
        map2.put("galleryVersion", C1122c.m6833t0(context));
        map2.put("fileType", String.valueOf(this.preFileInfo.getFileType()));
        try {
            C12478a c12478a = new C12478a(EnumC12999a.CLOUD_ALBUM, this.traceId);
            UploadReq uploadReq = new UploadReq();
            uploadReq.setFile(file);
            uploadReq.setCallback(new ICallback() { // from class: com.huawei.android.hicloud.album.service.logic.callable.PhotoUploadCallable.1
                public boolean onPause() {
                    return false;
                }

                @Override // com.huawei.android.hicloud.connect.progress.ICallback
                public void onProgress(long j10, long j11) {
                    PhotoUploadCallable.this.sendProgressMsg(j10, j11, (int) Math.floor((j10 / j11) * 100.0d), 0L);
                }

                @Override // com.huawei.android.hicloud.connect.progress.ICallback
                public boolean onStop() {
                    return false;
                }
            });
            uploadReq.setExtraStatKeyValues(map2);
            c12478a.m74907c(uploadReq);
            String result = uploadReq.getResult();
            C1120a.m6675d(TAG, "upload result" + result);
            if (result != null) {
                JSONObject jSONObject = new JSONObject(result);
                map.put("fileId", jSONObject.getString("fileid"));
                map.put("checksum", jSONObject.getString("checksum"));
                map.put("md5", jSONObject.getString("md5"));
                map.put("size", jSONObject.getString("size"));
            }
        } catch (C9721b e10) {
            C1120a.m6677i(TAG, "cloudPhotoUpload CException:" + C1122c.m6818p0(str) + " error:" + e10.getMessage());
            int iM60663g = e10.m60663g();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(iM60663g);
            map.put("vfs_error_code", sb2.toString());
            if (iM60663g == 507) {
                return map;
            }
            handleHttpError(true, this.preFileInfo.getFileUploadType());
        } catch (JSONException unused) {
            C1120a.m6676e(TAG, "upload file JSONException error;currentThread is:" + threadCurrentThread.getId());
            handleHttpError(false, this.preFileInfo.getFileUploadType());
        } catch (Exception unused2) {
            handleHttpError(true, this.preFileInfo.getFileUploadType());
        }
        return map;
    }

    @Override // com.huawei.android.hicloud.album.service.logic.callable.SDKUploadAsyncBaseCallable
    public int uploadFileDataToCloud() throws Throwable {
        int iCheckSum = checkSum();
        if (iCheckSum != 0) {
            return iCheckSum;
        }
        this.preFileInfo.setFileId(this.resMap.get("orgFileId"));
        this.preFileInfo.setVideoThumbId(this.resMap.get("videoThumbId"));
        this.preFileInfo.setSource(Build.MODEL);
        this.preFileInfo.setExpand(C11820b.m70400e(this.context, this.preFileInfo, null));
        this.preFileInfo.setOversion(0L);
        this.preFileInfo.setAlbumId(this.preFileInfo.getShareId());
        return createFileInfoToCloud(this.preFileInfo);
    }
}
