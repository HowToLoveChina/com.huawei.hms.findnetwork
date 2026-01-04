package com.huawei.android.p069cg.request.callable;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.connect.progress.Retry;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.p069cg.event.HttpEventManager;
import com.huawei.android.p069cg.logic.CommonRequestOperator;
import com.huawei.android.p069cg.logic.app.C2290i;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2328i;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;
import okhttp3.C11922g0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0066d;
import p009a8.C0067e;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p220d8.C9049c;
import p429kk.C11058a;
import p429kk.C11060c;
import p701v6.C13356c;
import p709vj.C13452e;
import p712vm.C13468a;
import p746wn.C13622a;
import p783xp.C13843a;

/* loaded from: classes2.dex */
public abstract class DownloadTaskBaseCallable extends AbstractC2328i {
    protected static final String DEFAULT_RETURN_VALUE = "";
    public static final String DOWNLOAD_CANCEL = "11";
    protected static final int DOWNLOAD_CONNECT_SUCCESS = 200;
    public static final String DOWNLOAD_FAIL = "1";
    public static final String DOWNLOAD_FAIL_CONDITION = "10";
    public static final int DOWNLOAD_FAIL_OVER = 14;
    protected static final int DOWNLOAD_FORBIDDEN = 403;
    protected static final int DOWNLOAD_NOT_FOUND = 404;
    protected static final int DOWNLOAD_PARTIAL_SUCCESS = 206;
    public static final String DOWNLOAD_POOL_SHUTDOWN = "13";
    protected static final int DOWNLOAD_RANGE_INVALID = 416;
    public static final String DOWNLOAD_RETRY_CODE = "7";
    public static final String DOWNLOAD_RUNNING = "12";
    public static final String DOWNLOAD_SUCCESS = "0";
    protected static final int DOWN_EXEC_FAIL = 1;
    protected static final int DOWN_EXEC_FAIL_CANCEL = 3;
    protected static final int DOWN_EXEC_FAIL_IOEXCEPTION = 4;
    protected static final int DOWN_EXEC_FAIL_SIZENOTEQUAL = 2;
    protected static final int DOWN_EXEC_RETRY = 7;
    protected static final int DOWN_EXEC_SUC = 0;
    private static final String TAG = "DownloadTaskBaseCallable";
    protected Asset asset;
    protected int code;
    protected String conditionCode;
    protected String conditionInfo;
    protected long contentLength;
    protected Context context;
    protected int curRetryTimes;
    protected String downloadURL;
    protected C13356c fileDownloadV2;
    protected FileInfo fileInfo;
    protected String fileInfoKey;
    protected boolean isAlbumClient;
    protected boolean isForceDownload;
    protected boolean isNeedDownProgress;
    protected boolean isReplaceDownload;
    protected String msg;
    protected String range;
    protected HashMap<String, Object> res;
    protected String resource;
    protected String saveCachePath;
    protected String savePath;
    protected int taskType;
    protected String tempFilePath;
    protected int thumbType;
    protected String traceId;
    protected long writecount;

    public DownloadTaskBaseCallable(Object obj) {
        super(obj);
        this.fileInfo = null;
        this.resource = PowerKitApplyUtil.GROUP_ALBUM;
        this.res = new HashMap<>();
        this.fileDownloadV2 = null;
        this.isNeedDownProgress = false;
        this.thumbType = -1;
        this.taskType = -1;
        this.isForceDownload = false;
        this.isReplaceDownload = false;
        this.traceId = "";
        this.conditionInfo = "";
        this.conditionCode = "";
        this.curRetryTimes = 0;
        this.writecount = 0L;
        this.code = 1;
        this.msg = "";
        this.range = "'";
        this.contentLength = 0L;
        this.isAlbumClient = false;
    }

    private void callbackDownProgress(boolean z10, long j10) throws Exception {
        if (this.isNeedDownProgress) {
            handleProgressWhileExecuting(this.fileInfo, getDownloadDisplayTotalSize(j10, z10), this.tempFilePath, this.thumbType, z10);
        }
    }

    private boolean checkDownload() {
        return (TextUtils.isEmpty(this.downloadURL) && this.asset == null) ? false : true;
    }

    private void checkNet(Exception exc, HashMap<String, String> map) {
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
            C1120a.m6677i(TAG, sb2.toString());
            boolean zM81101b = C13468a.m81100c().m81101b();
            C1120a.m6677i(TAG, "ping result is:" + zM81101b);
            if (zM81101b) {
                return;
            }
            map.put("S-U-ERRORCODE", "1013");
        }
    }

    private void closeResponse(C11922g0 c11922g0) {
        if (c11922g0 != null) {
            c11922g0.close();
        }
    }

    private int downloadRequest(Context context, long j10, long j11) throws JSONException {
        int iDownloadRequestSingle;
        HashMap<String, String> map = new HashMap<>();
        Retry retry = new Retry(2);
        long jLongValue = j10;
        int i10 = 0;
        while (true) {
            iDownloadRequestSingle = downloadRequestSingle(context, map, jLongValue, j11);
            C1120a.m6677i(TAG, "current task retry counts:" + this.curRetryTimes + "downloadRequest retry counts:" + i10 + ", downloadResult: " + iDownloadRequestSingle + ", breakPointSize: " + j11);
            if (isRetryGetUrl()) {
                C1120a.m6677i(TAG, "code:" + this.code + " retry get url");
                if (C9049c.m57058s(context, this.fileInfo, this.thumbType, !TextUtils.isEmpty(r1.getShareId()), this.traceId, this.isAlbumClient) == 0 && !TextUtils.isEmpty(this.fileInfo.getFileUrl())) {
                    this.downloadURL = this.fileInfo.getFileUrl();
                }
                iDownloadRequestSingle = 4;
            }
            if (this.isCancel) {
                if (this.thumbType == 0) {
                    this.code = getCancelCode();
                } else {
                    this.code = 3;
                }
                this.msg = "downloadRequest cancel";
                C1120a.m6677i(TAG, "downloadRequest cancel break savePath:" + C1122c.m6818p0(this.savePath));
            } else {
                if (isNotNeedRetry(iDownloadRequestSingle)) {
                    break;
                }
                retry.m16238g(this.code);
                if (!retry.m16232a()) {
                    C1120a.m6676e(TAG, "retry not allowed end download savePath:" + C1122c.m6818p0(this.savePath));
                    break;
                }
                HashMap<String, Long> mapCheckFileBreakSize = checkFileBreakSize();
                j11 = mapCheckFileBreakSize.get("breakPointSize").longValue();
                jLongValue = mapCheckFileBreakSize.get("fileSize").longValue();
                i10++;
            }
        }
        if (this.fileInfo != null) {
            if (isReport()) {
                String secondErrorCode = getSecondErrorCode(this.msg);
                if (!TextUtils.isEmpty(secondErrorCode)) {
                    map.put("key_error_second_code", secondErrorCode);
                }
            }
            C0067e.m443e().m444a(this.fileInfo, this.thumbType, this.code);
            if (this.code == 404) {
                if (this.fileInfo.isNotEncrypted()) {
                    this.code = 4315;
                    map.put("S-U-ERRORCODE", String.valueOf(4315));
                }
                reportObjectInfo(this.downloadURL, this.fileInfo.getFileId(), this.traceId);
            }
            reportOperationData(map, this.writecount, this.code, this.msg, this.fileInfo, this.range);
        }
        return iDownloadRequestSingle;
    }

    private int downloadRequestSingle(Context context, HashMap<String, String> map, long j10, long j11) {
        int iDownloadExecuting;
        try {
            iDownloadExecuting = downloadExecuting(map, false, j11, j10);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "download executing error,error message:" + e10.getMessage());
            iDownloadExecuting = 1;
        }
        if (this.curRetryTimes > 0 || this.thumbType == 0 || iDownloadExecuting != 4) {
            return iDownloadExecuting;
        }
        return 7;
    }

    private long get3DPhotoDataSize() {
        String expand = this.fileInfo.getExpand();
        if (TextUtils.isEmpty(expand)) {
            return 0L;
        }
        try {
            JSONArray jSONArray = new JSONArray(new JSONObject(expand).getString("attach"));
            if (jSONArray.length() < 1) {
                return 0L;
            }
            return C0241z.m1688f(jSONArray.getJSONObject(0).optString("size"));
        } catch (JSONException unused) {
            C1120a.m6676e(TAG, "get3DPhoto expand JSONException");
            return 0L;
        }
    }

    private long getDownloadDisplayTotalSize(long j10, boolean z10) {
        if (this.fileInfo.getFileType() != 7 || this.thumbType != 0 || !C2290i.m14440e(this.context)) {
            return j10;
        }
        long j11 = get3DPhotoDataSize();
        C1120a.m6677i(TAG, "get3DPhotoDataSize is:" + j11);
        return z10 ? this.fileInfo.getSize() + j11 : j10 + j11;
    }

    private long getFileSize(long j10, long j11, long j12) {
        if (j10 == 0 || this.tempFilePath == null || j11 == 0) {
            String str = this.saveCachePath + ".tmp_h." + j12;
            this.tempFilePath = str;
            C1122c.m6694F(str);
            j11 = j12;
        }
        this.tempFilePath = C1122c.m6732R1(this.tempFilePath);
        return j11;
    }

    private String getNewTempFilePath(C11922g0 c11922g0) {
        this.saveCachePath = C1124e.m6866j() + "/Pictures/hiddenAlbum/.tmp/" + this.fileInfo.getAlbumId() + "/" + C0227m.m1592e(this.fileInfo.getFileName());
        C1120a.m6678w(TAG, "tempFilePath length too long update tempFilePath" + this.saveCachePath);
        String str = this.saveCachePath + ".tmp_h." + c11922g0.m71595s().mo71634u();
        this.tempFilePath = str;
        return str;
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

    private String[] getTempSaveFileInfo(String str, FileInfo fileInfo) {
        File[] fileArrListFiles;
        String strSubstring;
        String[] strArr = {null, String.valueOf(fileInfo.getSize())};
        if (isCachePathEmpty(str) || (fileArrListFiles = C10278a.m63442h(str).getParentFile().listFiles()) == null) {
            return strArr;
        }
        int length = fileArrListFiles.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            File file = fileArrListFiles[i10];
            String name = file.getName();
            if (name.startsWith(fileInfo.getFileName()) && !name.equals(fileInfo.getFileName())) {
                C1120a.m6675d(TAG, "getTempSaveFileInfo local fileName: " + name + ", handleing fileName: " + fileInfo.getFileName());
                int iLastIndexOf = name.lastIndexOf(".tmp_h");
                if (iLastIndexOf > 0) {
                    try {
                        strSubstring = name.substring(iLastIndexOf + 7);
                    } catch (IndexOutOfBoundsException e10) {
                        C1120a.m6676e(TAG, "IndexOutOfBoundsException: " + e10.toString());
                        strSubstring = null;
                    }
                    if (strSubstring != null && !strSubstring.isEmpty()) {
                        strArr[0] = C10279b.m63452a(file);
                        strArr[1] = strSubstring;
                        StringBuilder sb2 = new StringBuilder(128);
                        sb2.append("getTempSaveFileInfo local tempFilePath: ");
                        sb2.append(strArr[0]);
                        sb2.append(", file size: ");
                        sb2.append(strArr[1]);
                        sb2.append(", handleing fileName: ");
                        sb2.append(fileInfo.getFileName());
                        C1120a.m6675d(TAG, sb2.toString());
                        break;
                    }
                } else {
                    continue;
                }
            }
            i10++;
        }
        return strArr;
    }

    private int getiRet(HashMap<String, String> map, IOException iOException) {
        C1120a.m6676e(TAG, "download file IOException:" + iOException.toString());
        String iOErrorCode = getIOErrorCode(iOException);
        map.put("S-U-ERRORCODE", iOErrorCode);
        map.put("S-U-RESULT", "1");
        map.put("S-U-ERRORMSG", iOException.toString());
        if (iOErrorCode.equals("1011")) {
            return 3;
        }
        checkNet(iOException, map);
        return 4;
    }

    private void initRequest(long j10, long j11) {
        C13356c c13356c = new C13356c(this.downloadURL, j10, j11, this.traceId);
        this.fileDownloadV2 = c13356c;
        c13356c.m80137k(getNeedAT());
    }

    private boolean isCachePathEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isContentLengthError(long j10, long j11) {
        return j10 + this.contentLength > j11;
    }

    private boolean isFileNameTooLong(IOException iOException) {
        return iOException.toString().contains("ENAMETOOLONG") || iOException.toString().contains("File name too long");
    }

    private boolean isNeedCheckFileSize(long j10) {
        return this.thumbType == 0 && j10 != this.fileInfo.getSize();
    }

    private boolean isNotNeedRetry(int i10) {
        return (i10 == 4 && this.thumbType == 0) ? false : true;
    }

    private boolean isReport() {
        return this.code == 404 && this.thumbType != 0;
    }

    private boolean isRetryGetUrl() {
        int i10 = this.code;
        return (i10 == 404 || i10 == 403) && this.thumbType == 0;
    }

    private boolean isTempSizeInvalid(String str, boolean z10) {
        return str == null || z10;
    }

    private void reportHttpEvent(String str, long j10) {
        HttpEventManager.HttpEvent httpEventM14398c;
        try {
            if (TextUtils.isEmpty(this.fileInfoKey) || (httpEventM14398c = HttpEventManager.m14396b().m14398c(this.fileInfoKey)) == null) {
                return;
            }
            C1120a.m6678w(TAG, this.fileInfoKey + " httpEvent " + httpEventM14398c);
            C11060c c11060cM66626a = C11058a.m66626a(this.traceId, "download_httpEvent", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0:1");
            c11060cM66626a.m66635A(httpEventM14398c.toString());
            c11060cM66626a.m66640F(String.valueOf(this.writecount));
            c11060cM66626a.m66642H(String.valueOf(j10));
            c11060cM66626a.m66638D(this.fileInfoKey);
            c11060cM66626a.m66667w(C13843a.m83101w(str));
            HashMap map = new HashMap();
            map.put("thumbType", String.valueOf(this.thumbType));
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "reportHttpEvent Exception: " + e10);
        }
    }

    private void setTaskInfo(String str, HashMap<String, String> map) {
        map.put("S-U-UID", C13452e.m80781L().m80971t0());
        map.put("S-U-UPORDOWN", "1");
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo != null && fileInfo.getHash() != null) {
            map.put("S-U-MD5", String.valueOf(this.fileInfo.getHash()));
        }
        map.put("S-U-FILETYPE", String.valueOf(this.thumbType));
        map.put("S-U-SERVERIP", str);
    }

    private int writeResponseFinishHandle(long j10, C2290i c2290i, HashMap<String, String> map) {
        if (this.isCancel) {
            closeConnect();
            return 3;
        }
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo != null && fileInfo.getFileType() == 7) {
            c2290i.m14445f(this.context, this.tempFilePath);
            return 0;
        }
        long downloadFinishSize = getDownloadFinishSize(j10);
        map.put("S-U-SIZE", String.valueOf(downloadFinishSize));
        if ((downloadFinishSize < 100 || !(downloadFinishSize == j10 || isLostData())) && !getNeedAT()) {
            map.put("S-U-RESULT", "1");
            return 2;
        }
        map.put("S-U-RESULT", "0");
        return 0;
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2328i, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public abstract Object call() throws Exception;

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public boolean cancel(int i10) {
        boolean zCancel = super.cancel(i10);
        C1120a.m6675d(TAG, "cancel:" + this.savePath + "cancelCode:" + i10 + " thumbType:" + this.thumbType);
        closeConnect();
        setCancel(true);
        setCancelCode(i10);
        return zCancel;
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
        synchronized (DownloadTaskBaseCallable.class) {
            zMkdirs = fileM63437c.mkdirs();
        }
        if (!zMkdirs) {
            if (!fileM63437c.exists()) {
                C1120a.m6676e(TAG, "mkdirs error need check system storage or permissions");
                return false;
            }
            C1120a.m6677i(TAG, "directory already exist" + C1122c.m6818p0(fileM63437c.getPath()));
        }
        if (!z10) {
            return true;
        }
        File fileM63442h = C10278a.m63442h(fileM63437c.toString() + "/.nomedia");
        if (fileM63442h.exists()) {
            return true;
        }
        try {
            synchronized (DownloadTaskBaseCallable.class) {
                try {
                    if (!fileM63442h.exists()) {
                        return fileM63442h.createNewFile();
                    }
                    C1120a.m6676e(TAG, ".nomedia already exist");
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

    public int checkDownloadUrl() {
        if (checkDownload()) {
            return 0;
        }
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo == null) {
            return 125;
        }
        if (this.isCancel) {
            closeConnect();
            return 115;
        }
        int iM57058s = C9049c.m57058s(this.context, fileInfo, this.thumbType, !TextUtils.isEmpty(fileInfo.getShareId()), this.traceId, this.isAlbumClient);
        if (iM57058s == 0) {
            int i10 = this.thumbType;
            if (i10 == 0) {
                if (TextUtils.isEmpty(this.fileInfo.getFileUrl())) {
                    this.asset = this.fileInfo.getAsset();
                } else {
                    this.downloadURL = this.fileInfo.getFileUrl();
                }
            } else if (i10 == 1 || i10 == 2) {
                if (TextUtils.isEmpty(this.fileInfo.getThumbUrl())) {
                    this.asset = this.fileInfo.getAsset();
                } else {
                    this.downloadURL = this.fileInfo.getThumbUrl();
                }
            }
            if (TextUtils.isEmpty(this.downloadURL) && this.asset == null) {
                return 125;
            }
        }
        return iM57058s;
    }

    public HashMap<String, Long> checkFileBreakSize() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("fileSize", 0L);
        map.put("breakPointSize", 0L);
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo == null) {
            return map;
        }
        String[] tempSaveFileInfo = getTempSaveFileInfo(this.saveCachePath, fileInfo);
        long jM1688f = C0241z.m1688f(tempSaveFileInfo[1]);
        if (isTempSizeInvalid(tempSaveFileInfo[0], jM1688f <= 0)) {
            return map;
        }
        this.tempFilePath = tempSaveFileInfo[0];
        if (isNeedCheckFileSize(jM1688f)) {
            long size = this.fileInfo.getSize();
            if (size <= 0) {
                C1120a.m6678w(TAG, "fileInfo size is illegal: " + size);
            } else if (jM1688f != this.fileInfo.getSize()) {
                C1120a.m6678w(TAG, "fileInfo size is not equal to fileTempSize " + this.fileInfo.getSize() + ":" + jM1688f);
                C1122c.m6694F(this.tempFilePath);
                return map;
            }
        }
        map.put("fileSize", Long.valueOf(jM1688f));
        File fileM63442h = C10278a.m63442h(this.tempFilePath);
        if (fileM63442h.exists() && fileM63442h.isFile()) {
            map.put("breakPointSize", Long.valueOf(fileM63442h.length()));
            if (fileM63442h.length() >= jM1688f) {
                C1122c.m6694F(this.tempFilePath);
                map.put("fileSize", 0L);
                map.put("breakPointSize", 0L);
            }
        }
        return map;
    }

    public void closeConnect() {
        C13356c c13356c = this.fileDownloadV2;
        if (c13356c != null) {
            c13356c.m80129c();
        }
    }

    public void closeInputStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                C1120a.m6676e(TAG, "download file close input Stream error,error message:" + e10.getMessage());
            }
        }
    }

    public void closeOutputStream(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e10) {
                C1120a.m6676e(TAG, "download file outputStream close error!error message:" + e10.getMessage());
            }
        }
    }

    public boolean downloadAttachRes() throws JSONException {
        int iDownloadExecuting;
        FileInfo fileInfo = this.fileInfo;
        if (fileInfo == null || this.thumbType != 0 || fileInfo.getFileType() != 7 || !C2290i.m14440e(this.context)) {
            return true;
        }
        String fyuseDownloadUrl = getFyuseDownloadUrl();
        this.downloadURL = fyuseDownloadUrl;
        if (TextUtils.isEmpty(fyuseDownloadUrl)) {
            return false;
        }
        try {
            iDownloadExecuting = downloadExecuting(new HashMap<>(), true, 0L, 0L);
            C1120a.m6677i(TAG, "downloadAttachRes fyuse finish! downloadAttach result: " + iDownloadExecuting);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "download 3d exeuting error,error message:" + e10.getMessage());
        }
        return iDownloadExecuting == 0;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public int downloadExecuting(java.util.HashMap<java.lang.String, java.lang.String> r31, boolean r32, long r33, long r35) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1749
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable.downloadExecuting(java.util.HashMap, boolean, long, long):int");
    }

    public abstract String downloadFinishRename(String str);

    public String downloadResult(Context context, long j10, long j11) throws JSONException {
        int iDownloadRequest = downloadRequest(context, j10, j11);
        if (iDownloadRequest == 0) {
            String str = this.tempFilePath;
            if (!downloadAttachRes()) {
                return "1";
            }
            if (C0066d.m438b(this.tempFilePath, this.fileInfo, this.thumbType, this.traceId)) {
                return downloadFinishRename(str);
            }
            C1120a.m6676e(TAG, "different size delete file isSuccess = " + C1122c.m6694F(this.tempFilePath));
            this.res.put("DownloadFailReason", 128);
            return "1";
        }
        if (iDownloadRequest != 2) {
            return iDownloadRequest == 3 ? this.thumbType == 0 ? "10" : "1" : iDownloadRequest == 7 ? "7" : "1";
        }
        File fileM63442h = C10278a.m63442h(this.tempFilePath);
        C1120a.m6676e(TAG, "download exeute finish and file write error:size not equal!file name:" + fileM63442h.getName() + ";download total file size is:" + j10 + ";download real file size is:" + fileM63442h.length());
        C1122c.m6694F(this.tempFilePath);
        this.res.put("DownloadFailReason", 128);
        return "1";
    }

    public long getCurrentSize(String str, boolean z10) {
        if (z10) {
            return this.fileInfo.getSize() + this.writecount;
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists()) {
            return fileM63442h.length();
        }
        return -1L;
    }

    public long getDownloadFinishSize(long j10) {
        File fileM63442h = C10278a.m63442h(this.tempFilePath);
        if (!fileM63442h.exists()) {
            return 0L;
        }
        long length = fileM63442h.length();
        if (fileM63442h.length() != j10) {
            C1120a.m6676e(TAG, "download file error:size not equal!file name:" + fileM63442h.getName() + ";download total file size is:" + j10 + ";download real file size is:" + fileM63442h.length());
        }
        return length;
    }

    public long getDownloadResponseSize(C11922g0 c11922g0, long j10, long j11, boolean z10) {
        if (c11922g0 == null) {
            return j11;
        }
        long jMo71634u = c11922g0.m71595s().mo71634u();
        this.contentLength = jMo71634u;
        return (jMo71634u > 0 || getNeedAT()) ? z10 ? j11 > 0 ? j11 : jMo71634u : getFileSize(j10, j11, jMo71634u) : j11;
    }

    public String getFyuseDownloadUrl() throws JSONException {
        C1120a.m6677i(TAG, "getFyuseDownloadUrl source photo path:" + this.tempFilePath);
        if (this.fileInfo != null && !TextUtils.isEmpty(this.tempFilePath)) {
            FileInfo fileInfoM14404a = new CommonRequestOperator(this.context).m14404a(String.valueOf(1), this.fileInfo, this.resource);
            if (fileInfoM14404a != null && !TextUtils.isEmpty(fileInfoM14404a.getFileUrl())) {
                return fileInfoM14404a.getFileUrl();
            }
        }
        return null;
    }

    public String getIOErrorCode(Exception exc) {
        return exc instanceof UnknownHostException ? "1003" : exc instanceof ProtocolException ? "1005" : exc instanceof SocketTimeoutException ? "1006" : exc instanceof TimeoutException ? "1010" : exc instanceof NoRouteToHostException ? FaqConstants.CHANNEL_HICARE : exc instanceof MalformedURLException ? "1002" : exc instanceof ConnectException ? "1001" : exc instanceof SocketException ? "1008" : exc instanceof SSLException ? "1009" : exc instanceof InterruptedIOException ? "1011" : "1000";
    }

    public abstract boolean getNeedAT();

    public String getRange() {
        C13356c c13356c = this.fileDownloadV2;
        return c13356c != null ? c13356c.m80131e() : "";
    }

    public int getResponseCode() {
        C13356c c13356c = this.fileDownloadV2;
        if (c13356c != null) {
            return c13356c.m80132f();
        }
        return 0;
    }

    public String getResponseMsg() {
        C13356c c13356c = this.fileDownloadV2;
        return c13356c != null ? c13356c.m80133g() : "";
    }

    public abstract void handleAuthFailed();

    public abstract void handleCloseExecuting() throws Exception;

    public abstract void handleDownloadWrite(InputStream inputStream, OutputStream outputStream) throws IOException;

    public abstract void handleProgressWhileExecuting(FileInfo fileInfo, long j10, String str, int i10, boolean z10) throws Exception;

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public boolean isCancel() {
        return this.isCancel;
    }

    public boolean isCloudSyncAllowed() {
        if (C10028c.m62182c0().m62375p1()) {
            C1120a.m6678w(TAG, "sync isForceUpgradeOrCancelHiCloud download stop");
            C1122c.m6738T1(this.context, this.traceId);
            return false;
        }
        if (!C13452e.m80781L().m80932j1()) {
            return true;
        }
        C1120a.m6678w(TAG, "sync  StInvalid download stop");
        C1122c.m6738T1(this.context, this.traceId);
        return false;
    }

    public abstract boolean isLostData();

    public String parseDownloadHost(String str) {
        if (str == null || "".equals(str.trim()) || !str.contains("/")) {
            return "";
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length < 6) {
            return "";
        }
        return strArrSplit[0] + "/" + strArrSplit[1] + "/" + strArrSplit[2] + "/*/" + strArrSplit[5];
    }

    public void reportObjectInfo(String str, String str2, String str3) {
        try {
            String strM83101w = C13843a.m83101w(str);
            C1120a.m6675d(TAG, "reportObjectInfo " + str2 + ", " + strM83101w);
            HashMap map = new HashMap();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(getThumbType());
            map.put("thumbType", sb2.toString());
            C11060c c11060cM66626a = C11058a.m66626a(str3, "reportObjectInfo", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0:1");
            c11060cM66626a.m66635A(str2);
            c11060cM66626a.m66667w(strM83101w);
            c11060cM66626a.m66638D(str);
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "reportObjectInfo Exception " + e10);
        }
    }

    public abstract void reportOperationData(HashMap<String, String> map, long j10, int i10, String str, FileInfo fileInfo, String str2);

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a
    public void setCancel(boolean z10) {
        this.isCancel = z10;
    }

    public abstract void updateRestoreSuccessFile(FileInfo fileInfo);

    public DownloadTaskBaseCallable(Object obj, int i10) {
        super(obj, i10, -1L);
        this.fileInfo = null;
        this.resource = PowerKitApplyUtil.GROUP_ALBUM;
        this.res = new HashMap<>();
        this.fileDownloadV2 = null;
        this.isNeedDownProgress = false;
        this.thumbType = -1;
        this.taskType = -1;
        this.isForceDownload = false;
        this.isReplaceDownload = false;
        this.traceId = "";
        this.conditionInfo = "";
        this.conditionCode = "";
        this.curRetryTimes = 0;
        this.writecount = 0L;
        this.code = 1;
        this.msg = "";
        this.range = "'";
        this.contentLength = 0L;
        this.isAlbumClient = false;
    }
}
