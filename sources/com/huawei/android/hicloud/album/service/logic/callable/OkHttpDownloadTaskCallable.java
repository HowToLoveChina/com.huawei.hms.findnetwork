package com.huawei.android.hicloud.album.service.logic.callable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.album.service.report.DownloadOpsReport;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p069cg.request.callable.OkHttpDownloadTaskBaseCallable;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import hk.C10278a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import okhttp3.HttpResponseBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0067e;
import p009a8.C0068f;
import p015ak.C0209d;
import p015ak.C0241z;
import p031b7.AbstractC1139t;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1128i;
import p031b7.C1141v;
import p031b7.InterfaceC1126g;
import p547p7.C12118f;
import p649t6.C12952l;
import p701v6.C13358e;
import p712vm.C13468a;
import p783xp.C13843a;
import p801y7.C13914b;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes2.dex */
public class OkHttpDownloadTaskCallable extends OkHttpDownloadTaskBaseCallable {
    private static final int LAST_RETRY_TIME = 1;
    private static final int MAX_RETRY_TIME = 2;
    private static final long MAX_SIZE = 52428800;
    private static final int ONCE_WAIT_QUEUE_TIME = 200;
    private static final String PROXY_ERROR = "405";
    private static final String TAG = "OkHttpDownloadTaskCallable";
    private CallbackHandler callbackHandler;
    private long downloadStartTime;

    public OkHttpDownloadTaskCallable(Context context, CallbackHandler callbackHandler, String str, String str2, Object obj, String str3, int i10, int i11, boolean z10, String str4, String str5, int i12, boolean z11, boolean z12, boolean z13) {
        super(obj, i10);
        this.downloadStartTime = 0L;
        this.context = context;
        this.callbackHandler = callbackHandler;
        this.savePath = str;
        this.downloadURL = str2;
        this.fileInfo = (FileInfo) obj;
        this.saveCachePath = str3;
        ((DownloadTaskBaseCallable) this).thumbType = i10;
        this.taskType = i11;
        this.isShare = z10;
        this.fileInfoKey = str4;
        this.isPriority = z12;
        if (z12) {
            this.mOkHttpClient = C13358e.m80141d(3);
        } else {
            this.mOkHttpClient = C13358e.m80141d(0);
        }
        this.traceId = str5;
        this.curRetryTimes = i12;
        this.isForceDownload = z11;
        this.isReplaceDownload = z13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNet(Exception exc, HashMap<String, Object> map) {
        if (exc == null) {
            C1120a.m6676e(TAG, "exception is null");
            return;
        }
        if (exc.toString().contains("SocketTimeout") || exc.toString().contains("timeout") || (exc instanceof SocketTimeoutException)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("download file socketTimeout:");
            sb2.append(exc.toString());
            sb2.append(" fileName:");
            FileInfo fileInfo = this.fileInfo;
            sb2.append(fileInfo != null ? C1122c.m6818p0(fileInfo.getFileName()) : "download avatar");
            sb2.append("thumbType:");
            sb2.append(((DownloadTaskBaseCallable) this).thumbType);
            C1120a.m6677i(TAG, sb2.toString());
            boolean zM81101b = C13468a.m81100c().m81101b();
            C1120a.m6677i(TAG, "ping result is:" + zM81101b);
            if (zM81101b) {
                return;
            }
            map.put("S-U-ERRORCODE", "1013");
        }
    }

    private void deleteFile(long j10) {
        if (this.breakPointSize == 0 || this.tempFilePath == null || this.fileSize == 0) {
            String str = this.saveCachePath + ".tmp_h." + j10 + System.currentTimeMillis();
            this.tempFilePath = str;
            this.fileSize = j10;
            C1122c.m6694F(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x026e, code lost:
    
        p031b7.C1120a.m6677i(com.huawei.android.hicloud.album.service.logic.callable.OkHttpDownloadTaskCallable.TAG, "OkHttpClientFactory releaseAllHttpClient");
        p701v6.C13358e.m80142e();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void download() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 731
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.album.service.logic.callable.OkHttpDownloadTaskCallable.download():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadResultHandle(HashMap<String, Object> map, FileInfo fileInfo, int i10, boolean z10, String str) {
        C13914b.m83362u(this.callbackHandler, this.taskType, this.fileInfoKey, 2, null, z10);
        boolean zBooleanValue = map.containsKey("NeedCallback") ? ((Boolean) map.get("NeedCallback")).booleanValue() : true;
        int iIntValue = map.containsKey("httpCode") ? ((Integer) map.get("httpCode")).intValue() : 200;
        if (String.valueOf(0).equals(map.get("code"))) {
            if (zBooleanValue) {
                C13914b.m83353J(this.callbackHandler, fileInfo, str, i10, z10);
                return;
            }
            return;
        }
        if ("11".equals(map.get("code"))) {
            if (zBooleanValue) {
                C13914b.m83352H(this.callbackHandler, fileInfo, i10, 115, z10);
                return;
            }
            return;
        }
        C1120a.m6676e(TAG, "download failed: " + C1122c.m6818p0(fileInfo.getFileName()) + ", thumbType: " + i10);
        int iIntValue2 = map.containsKey("DownloadFailReason") ? ((Integer) map.get("DownloadFailReason")).intValue() : 101;
        if (zBooleanValue) {
            C13914b.m83351G(this.callbackHandler, fileInfo, i10, iIntValue, iIntValue2, z10);
        }
    }

    private String getSecondErrorCode(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6677i(TAG, "errorMsg is null");
            return null;
        }
        if (!str.contains(VastAttribute.ERROR)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(VastAttribute.ERROR)) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(VastAttribute.ERROR);
            if (jSONObject2.has("errorDetail")) {
                return new JSONArray(jSONObject2.getString("errorDetail")).optJSONObject(0).getString(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
            }
            return null;
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "parseErrorByRsp error: " + e10.toString());
            return null;
        }
    }

    private InterfaceC1126g getThumbnailFactory(int i10) {
        return i10 == 4 ? new C1141v() : new C1128i();
    }

    private boolean isSizeInvalid(long j10) {
        if (j10 >= 100) {
            if (!this.isReplaceDownload && !isLostData()) {
                long j11 = this.fileSize;
                if (j10 == j11 || j11 == -1) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.huawei.android.cg.request.callable.DownloadTaskBaseCallable, com.huawei.android.cg.request.callable.OkHttpDownloadTaskBaseCallable, com.huawei.android.hicloud.album.service.logic.callable.OkHttpDownloadTaskCallable] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.InputStream] */
    public void parseSuccessResponse(HttpResponseBuilder HttpResponseBuilder) throws Throwable {
        InputStream inputStream;
        String strM6732R1;
        int iM71597u = HttpResponseBuilder.m71597u();
        String strM71602z = HttpResponseBuilder.m71602z();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onResponse ");
        sb2.append(this.fileInfoKey);
        sb2.append(" code:");
        sb2.append(iM71597u);
        sb2.append(", domain:");
        sb2.append(C13843a.m83101w(this.downloadURL));
        ?? M71632s = ", msg:";
        sb2.append(", msg:");
        sb2.append(strM71602z);
        C1120a.m6675d(TAG, sb2.toString());
        if (iM71597u != 200 && iM71597u != 206) {
            C1120a.m6676e(TAG, "onResponse error code:" + iM71597u + ", domain:" + C13843a.m83101w(this.downloadURL) + ", retry:" + this.curRetryTimes + ", isReplaceDownload:" + this.isReplaceDownload);
            String errorMessage = getErrorMessage(HttpResponseBuilder);
            HttpResponseBuilder.close();
            this.res.put("httpCode", Integer.valueOf(iM71597u));
            this.res.put("code", String.valueOf(iM71597u));
            this.res.put("DownloadFailReason", Integer.valueOf(iM71597u));
            this.res.put(C2126b.ERROR_MESSAGE_INFO, errorMessage);
            C13914b.m83362u(this.callbackHandler, this.taskType, this.fileInfoKey, 2, null, this.isShare);
            downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
            C1120a.m6676e(TAG, "onResponse error code:" + iM71597u + ", domain:" + C13843a.m83101w(this.downloadURL) + "fileName:" + this.fileInfo.getFileName() + " fileInfoKey:" + this.fileInfoKey + ", msg:" + errorMessage);
            if (iM71597u != 404) {
                retryDownloadIfNeeded();
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("fileUnique", this.fileInfo.getUploadTime());
            linkedHashMap.put("thumbType", String.valueOf(this.thumbType));
            linkedHashMap.put(ContentResource.FILE_NAME, this.fileInfo.getFileName());
            linkedHashMap.put("resource_path", this.fileInfoKey);
            C1122c.m6753Y1(this.context, C1122c.m6713L0(String.valueOf(4315), false), "download not found " + this.fileInfoKey, "04004", "download_thumbnail", this.traceId, true, linkedHashMap);
            reportObjectInfo(this.downloadURL, this.fileInfo.getFileId(), this.traceId);
            C0067e.m443e().m444a(this.fileInfo, this.thumbType, iM71597u);
            return;
        }
        C1120a.m6675d(TAG, "currentHttpVersion:" + HttpResponseBuilder.m71591C().toString());
        FileOutputStream fileOutputStreamM63447m = null;
        try {
            try {
            } catch (Exception e10) {
                e = e10;
            } catch (Throwable th2) {
                th = th2;
            }
            if (!this.callbackHandler.canStartDownloading(this.isForceDownload, this.thumbType)) {
                try {
                    String strM60416f = this.callbackHandler.getSyncStrategy().m60416f(this.callbackHandler.getSyncStrategy().m60414d());
                    this.res.put("code", "10");
                    strM71602z = "SyncStrategy not allow, download canceled " + strM60416f;
                    C1120a.m6676e(TAG, "SyncStrategy not allow, download canceled");
                    closeOutputStream(null);
                    closeInputStream(null);
                    HttpResponseBuilder.close();
                    this.res.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - HttpResponseBuilder.m71594F()));
                    this.res.put("size", Long.valueOf(this.writecount));
                    this.res.put(C2126b.ERROR_MESSAGE_INFO, strM71602z);
                    downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
                    retryDownloadIfNeeded();
                    return;
                } catch (Exception e11) {
                    e = e11;
                    M71632s = 0;
                    int iProcessReportCode = processReportCode(e);
                    strM71602z = "parseSuccessResponse Exception " + e.getMessage();
                    C1120a.m6676e(TAG, strM71602z);
                    this.res.put("code", Integer.valueOf(iProcessReportCode));
                    inputStream = M71632s;
                    closeOutputStream(fileOutputStreamM63447m);
                    closeInputStream(inputStream);
                    HttpResponseBuilder.close();
                    this.res.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - HttpResponseBuilder.m71594F()));
                    this.res.put("size", Long.valueOf(this.writecount));
                    this.res.put(C2126b.ERROR_MESSAGE_INFO, strM71602z);
                    downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
                    retryDownloadIfNeeded();
                } catch (Throwable th3) {
                    th = th3;
                    M71632s = 0;
                    closeOutputStream(fileOutputStreamM63447m);
                    closeInputStream(M71632s);
                    HttpResponseBuilder.close();
                    this.res.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - HttpResponseBuilder.m71594F()));
                    this.res.put("size", Long.valueOf(this.writecount));
                    this.res.put(C2126b.ERROR_MESSAGE_INFO, strM71602z);
                    downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
                    retryDownloadIfNeeded();
                    throw th;
                }
            }
            M71632s = HttpResponseBuilder.m71595s().m71632s();
            try {
                long jMo71634u = HttpResponseBuilder.m71595s().mo71634u();
                this.contentLength = jMo71634u;
                deleteFile(jMo71634u);
                strM6732R1 = C1122c.m6732R1(this.tempFilePath);
                this.tempFilePath = strM6732R1;
                try {
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
            } catch (Throwable th4) {
                th = th4;
            }
            if (TextUtils.isEmpty(strM6732R1)) {
                this.res.put("code", "10");
                closeOutputStream(null);
                closeInputStream(M71632s);
                HttpResponseBuilder.close();
                this.res.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - HttpResponseBuilder.m71594F()));
                this.res.put("size", Long.valueOf(this.writecount));
                this.res.put(C2126b.ERROR_MESSAGE_INFO, "tempFilePath is null");
                downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
                retryDownloadIfNeeded();
                return;
            }
            fileOutputStreamM63447m = C10278a.m63447m(this.tempFilePath, true);
            C1120a.m6675d(TAG, "download write filePath:" + this.tempFilePath + "! currentThread id:" + Thread.currentThread().getId());
            downloadWrite(M71632s, fileOutputStreamM63447m);
            if (isSizeInvalid(getDownloadFinishSize(this.fileSize))) {
                File fileM63442h = C10278a.m63442h(this.tempFilePath);
                C1120a.m6676e(TAG, "download exeute finish and file write error:size not equal!file name:" + fileM63442h.getName() + ";download total file size is:" + this.fileSize + ";download real file size is:" + fileM63442h.length());
                C1122c.m6694F(this.tempFilePath);
                this.res.put("code", 2);
                closeOutputStream(fileOutputStreamM63447m);
                closeInputStream(M71632s);
                HttpResponseBuilder.close();
                this.res.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - HttpResponseBuilder.m71594F()));
                this.res.put("size", Long.valueOf(this.writecount));
                this.res.put(C2126b.ERROR_MESSAGE_INFO, "size is not valid");
                downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
                retryDownloadIfNeeded();
                return;
            }
            String str = this.tempFilePath;
            if (this.isReplaceDownload) {
                C1120a.m6678w(TAG, "replaceDownload start create thumbType: " + this.thumbType + ", fileType: " + this.fileInfo.getFileType());
                str = this.saveCachePath + ".thumb_h." + System.currentTimeMillis();
                C1122c.m6694F(str);
                InterfaceC1126g thumbnailFactory = getThumbnailFactory(this.fileInfo.getFileType());
                File fileM63442h2 = C10278a.m63442h(str);
                fileM63442h2.createNewFile();
                File fileM63442h3 = C10278a.m63442h(this.tempFilePath);
                AbstractC1139t abstractC1139tMo6901a = thumbnailFactory.mo6901a();
                FailRet failRet = new FailRet();
                try {
                    if (this.thumbType == 1) {
                        abstractC1139tMo6901a.mo6907b(fileM63442h2, fileM63442h3, 100, failRet);
                    } else {
                        abstractC1139tMo6901a.mo6909e(fileM63442h2, fileM63442h3, 100, failRet);
                    }
                    strM71602z = !TextUtils.isEmpty(failRet.getErrMsg()) ? failRet.getErrMsg() : strM71602z;
                    if (C1122c.m6837u1(str) || this.fileInfo.getFileType() == 4) {
                        C1122c.m6694F(this.tempFilePath);
                    } else {
                        str = this.tempFilePath;
                    }
                } catch (Exception e14) {
                    e = e14;
                    int iProcessReportCode2 = processReportCode(e);
                    strM71602z = "parseSuccessResponse Exception " + e.getMessage();
                    C1120a.m6676e(TAG, strM71602z);
                    this.res.put("code", Integer.valueOf(iProcessReportCode2));
                    inputStream = M71632s;
                    closeOutputStream(fileOutputStreamM63447m);
                    closeInputStream(inputStream);
                    HttpResponseBuilder.close();
                    this.res.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - HttpResponseBuilder.m71594F()));
                    this.res.put("size", Long.valueOf(this.writecount));
                    this.res.put(C2126b.ERROR_MESSAGE_INFO, strM71602z);
                    downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
                    retryDownloadIfNeeded();
                } catch (Throwable th5) {
                    th = th5;
                    strM71602z = strM71602z;
                    closeOutputStream(fileOutputStreamM63447m);
                    closeInputStream(M71632s);
                    HttpResponseBuilder.close();
                    this.res.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - HttpResponseBuilder.m71594F()));
                    this.res.put("size", Long.valueOf(this.writecount));
                    this.res.put(C2126b.ERROR_MESSAGE_INFO, strM71602z);
                    downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
                    retryDownloadIfNeeded();
                    throw th;
                }
            }
            String strDownloadFinishRename = downloadFinishRename(str);
            this.res.put("code", strDownloadFinishRename);
            inputStream = M71632s;
            if (strDownloadFinishRename.equals("1")) {
                this.res.put("code", 127);
                strM71602z = strM71602z + " download file not exists";
                inputStream = M71632s;
            }
            closeOutputStream(fileOutputStreamM63447m);
            closeInputStream(inputStream);
            HttpResponseBuilder.close();
            this.res.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - HttpResponseBuilder.m71594F()));
            this.res.put("size", Long.valueOf(this.writecount));
            this.res.put(C2126b.ERROR_MESSAGE_INFO, strM71602z);
            downloadResultHandle(this.res, this.fileInfo, this.thumbType, this.isShare, this.savePath);
            retryDownloadIfNeeded();
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void reportOperationData(String str, long j10, String str2, int i10, String str3, FileInfo fileInfo, String str4) {
        new DownloadOpsReport(this.context).m15219E(str, str2, j10, i10, str3, fileInfo, this.range, this.traceId, this.contentLength, ((DownloadTaskBaseCallable) this).thumbType, "", "", str4, this.isPriority ? "0" : "1", this.isForceDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryDownloadIfNeeded() {
        try {
            String strValueOf = this.res.containsKey("code") ? String.valueOf(this.res.get("code")) : "1";
            long j10 = this.res.containsKey("size") ? Long.parseLong(String.valueOf(this.res.get("size"))) : 0L;
            String strValueOf2 = this.res.containsKey(WiseOpenHianalyticsData.UNION_COSTTIME) ? String.valueOf(this.res.get(WiseOpenHianalyticsData.UNION_COSTTIME)) : "0";
            String strValueOf3 = this.res.containsKey(C2126b.ERROR_MESSAGE_INFO) ? String.valueOf(this.res.get(C2126b.ERROR_MESSAGE_INFO)) : "unknown";
            if ("0".equals(strValueOf)) {
                reportOperationData(this.downloadURL, j10, strValueOf2, 200, strValueOf3, this.fileInfo, "");
                C1120a.m6675d(TAG, "download complete");
                return;
            }
            int i10 = this.curRetryTimes;
            if (i10 >= 2) {
                reportOperationData(this.downloadURL, j10, strValueOf2, C0241z.m1685c(strValueOf), strValueOf3, this.fileInfo, "404".equals(strValueOf) ? getSecondErrorCode(strValueOf3) : null);
                C0067e.m443e().m444a(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, C0241z.m1685c(strValueOf));
                return;
            }
            boolean z10 = i10 == 1 && PROXY_ERROR.equals(strValueOf);
            C13914b c13914b = new C13914b(this.context, this.callbackHandler);
            FileInfo fileInfo = this.fileInfo;
            int i11 = ((DownloadTaskBaseCallable) this).thumbType;
            boolean z11 = this.isShare;
            int i12 = this.taskType;
            String str = this.traceId;
            int i13 = 1 + this.curRetryTimes;
            this.curRetryTimes = i13;
            c13914b.m83373o(fileInfo, i11, true, z11, i12, str, i13, this.isForceDownload, z10);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "retryDownloadIfNeeded error: " + e10);
        }
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable, com.huawei.android.p069cg.request.threadpool.AbstractC2328i, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        this.downloadStartTime = System.currentTimeMillis();
        C1120a.m6677i(TAG, "download start:" + this.fileInfoKey + ", retry:" + this.curRetryTimes + ", isReplaceDownload:" + this.isReplaceDownload);
        if (this.mOkHttpClient == null) {
            C1120a.m6676e(TAG, "mOkHttpClient is null");
            this.res.put("code", "1");
            downloadResultHandle(this.res, this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, this.isShare, this.savePath);
            C1122c.m6750X1(this.context, C1122c.m6713L0("5004", true), "mOkHttpClient is null", "04004", "checkOkHttp", this.traceId, true);
            return 0;
        }
        if (!isCloudSyncAllowed()) {
            this.res.put("code", "1");
            downloadResultHandle(this.res, this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, this.isShare, this.savePath);
            return 1;
        }
        if (C0067e.m443e().m452j(this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType)) {
            this.res.put("code", "1");
            downloadResultHandle(this.res, this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, this.isShare, this.savePath);
            new CommonOpsReport(this.context).m15209C(this.traceId, "repeat_download_error", FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH, "download error not allowed retry " + this.fileInfoKey);
            return 1;
        }
        String strDownloadCondition = downloadCondition();
        if (strDownloadCondition != null) {
            if (!"12".equals(strDownloadCondition)) {
                this.res.put("code", strDownloadCondition);
                downloadResultHandle(this.res, this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, this.isShare, this.savePath);
                if ("10".equals(strDownloadCondition)) {
                    C1122c.m6750X1(this.context, TextUtils.isEmpty(this.conditionCode) ? "001_3002:1" : C1122c.m6713L0(this.conditionCode, true), TextUtils.isEmpty(this.conditionInfo) ? "condition invalid" : this.conditionInfo, "04004", "downloadCondition", this.traceId, true);
                }
            }
            C1120a.m6678w(TAG, "downCondition: " + strDownloadCondition);
            return 1;
        }
        int iCheckDownloadUrl = checkDownloadUrl();
        if (iCheckDownloadUrl != 0) {
            C1120a.m6676e(TAG, "checkDownloadUrl fail: " + iCheckDownloadUrl);
            this.res.put("code", "1");
            this.res.put("DownloadFailReason", Integer.valueOf(iCheckDownloadUrl));
            downloadResultHandle(this.res, this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, this.isShare, this.savePath);
            C1122c.m6750X1(this.context, C1122c.m6713L0(String.valueOf(iCheckDownloadUrl), false), "checkDownloadUrl error", "04004", "checkDownloadUrl", this.traceId, true);
            return this.res;
        }
        boolean zCheckDir = checkDir(this.savePath, true);
        boolean zCheckDir2 = checkDir(this.saveCachePath, true);
        if (!zCheckDir || !zCheckDir2) {
            this.res.put("code", "1");
            C1120a.m6676e(TAG, "savePath  or cachePath is error");
            downloadResultHandle(this.res, this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, this.isShare, this.savePath);
            String str = "mkdir error, checkSavePath=" + zCheckDir + ", checkCachePath=" + zCheckDir2 + ", thumbType=" + ((DownloadTaskBaseCallable) this).thumbType + ", " + C1122c.m6754Z(((DownloadTaskBaseCallable) this).thumbType) + ", " + C1122c.m6758a0();
            C1120a.m6676e(TAG, str);
            C1122c.m6750X1(this.context, C1122c.m6713L0("3016", true), str, "04004", "checkDir", this.traceId, true);
            return 1;
        }
        if (this.isReplaceDownload) {
            boolean z10 = !TextUtils.isEmpty(this.fileInfo.getReplaceUrl());
            boolean zM1254f2 = C0209d.m1254f2(this.context);
            boolean z11 = this.fileInfo.getSize() != 0 && this.fileInfo.getSize() < MAX_SIZE;
            String str2 = "replaceDownload: " + this.fileInfoKey + ", url: " + z10 + ", wifi: " + zM1254f2 + ", size: " + z11 + ", isShare: " + this.isShare + ", fileType: " + this.fileInfo.getFileType();
            C1120a.m6678w(TAG, str2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("thumbType", String.valueOf(((DownloadTaskBaseCallable) this).thumbType));
            linkedHashMap.put(ContentResource.FILE_NAME, this.fileInfo.getFileName());
            linkedHashMap.put("resource_path", this.fileInfoKey);
            C1122c.m6753Y1(this.context, "0:1", str2, "04004", "replaceDownload", this.traceId, true, linkedHashMap);
            if (z10 && zM1254f2 && z11) {
                this.downloadURL = this.fileInfo.getReplaceUrl();
            } else {
                this.isReplaceDownload = false;
                if (!this.isShare) {
                    C12952l c12952l = new C12952l();
                    C12118f c12118f = new C12118f();
                    c12118f.m72643n(this.fileInfo.getUniqueId()).m72646q(Long.valueOf(this.fileInfo.getSize())).m72640k(Integer.valueOf(this.fileInfo.getFileType()));
                    c12952l.m77873l(c12118f);
                }
            }
        }
        download();
        C1120a.m6675d(TAG, "download end:" + this.fileInfoKey);
        C0068f.m459d().m469m(System.currentTimeMillis() - this.downloadStartTime);
        return 0;
    }

    public void cancelTask(int i10, boolean z10) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "1");
        map.put("DownloadFailReason", Integer.valueOf(i10));
        map.put("NeedCallback", Boolean.valueOf(z10));
        C13914b.m83362u(this.callbackHandler, this.taskType, this.fileInfoKey, 2, null, this.isShare);
        downloadResultHandle(map, this.fileInfo, ((DownloadTaskBaseCallable) this).thumbType, this.isShare, this.savePath);
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public int checkDownloadUrl() {
        if (this.isCancel) {
            closeConnect();
            return 115;
        }
        if (!TextUtils.isEmpty(this.downloadURL)) {
            return 0;
        }
        if (!CloudAlbumSettings.m14363h().m14376l()) {
            return 125;
        }
        C1122c.m6765c(((DownloadTaskBaseCallable) this).thumbType, this.fileInfo);
        return 125;
    }

    public void downloadWrite(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.writecount = 0L;
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                break;
            }
            this.writecount += i10;
            if (!this.callbackHandler.canStartDownloading(this.isForceDownload, ((DownloadTaskBaseCallable) this).thumbType)) {
                C1120a.m6676e(TAG, "SyncStrategy not allow, break");
                this.isCancel = true;
                break;
            } else if (this.isCancel) {
                break;
            } else {
                outputStream.write(bArr, 0, i10);
            }
        }
        C1120a.m6675d(TAG, "downloadFile write,writecount:" + this.writecount + ", thumbType:" + ((DownloadTaskBaseCallable) this).thumbType);
        outputStream.flush();
    }

    @Override // com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable
    public boolean isLostData() {
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo == null) {
            return false;
        }
        return fileInfo.isLostData();
    }
}
