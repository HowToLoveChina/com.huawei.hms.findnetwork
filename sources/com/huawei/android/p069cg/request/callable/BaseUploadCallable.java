package com.huawei.android.p069cg.request.callable;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0076n;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p037bp.C1270a;
import p232dp.InterfaceC9285d;
import p606r9.C12478a;
import p652t9.EnumC12999a;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class BaseUploadCallable extends AbstractCallableC2320a {
    private static final String CONNECT_SUCCESS = "200";
    private static final String ERROR_FILE_NAME = "_1_1_1_1_1_1_1_1_1_1_1";
    private static final Pattern ILLEGAL_PATTERN = Pattern.compile("[\\\\<>|:\"*?/\t\r\n]");
    private static final String PARTIAL_SUCCESS = "201";
    protected static final String STR_CHECKSUM = "checksum";
    protected static final String STR_ERROR_VFS_CODE = "vfs_error_code";
    protected static final String STR_FILEID = "fileId";
    protected static final String STR_MD5 = "md5";
    protected static final String STR_SIZE = "size";
    private static final String TAG = "BaseUploadCallable";
    public static final String UPLOAD_BASIC_BUSINESS_STOP = "8";
    protected static final String UPLOAD_ERROR = "1";
    public static final String UPLOAD_ERROR_CHECKSPACE = "7";
    public static final String UPLOAD_ERROR_CONDITION = "2";
    protected static final String UPLOAD_ERROR_CREATEFILE = "4";
    protected static final String UPLOAD_ERROR_HTTP = "3";
    public static final String UPLOAD_ERROR_SPACE_NOT_ENOUGH = "5";
    protected static final String UPLOAD_NO_NEED = "6";
    public static final String UPLOAD_SUC = "0";
    private static final String UPLOAD_UNKNOW_CODE = "0";
    protected CallbackHandler callbackHandler;
    protected Context context;
    protected FileInfo preFileInfo;
    protected String traceId;

    public BaseUploadCallable(Object obj) {
        super(obj, -1L);
        this.traceId = "";
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        return null;
    }

    public boolean checkFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        return fileM63442h.exists() && fileM63442h.isFile() && fileM63442h.length() > 0;
    }

    public int checkFileInvalid(FileInfo fileInfo) {
        if (!checkFileExists(fileInfo.getLocalRealPath())) {
            C1120a.m6676e(TAG, "org file not exists, path: " + fileInfo.getLocalRealPath());
            return 116;
        }
        String fileName = fileInfo.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            C1120a.m6676e(TAG, "contain empty file name:" + C1122c.m6818p0(fileName));
            return 123;
        }
        if (fileName.contains(ERROR_FILE_NAME) && !CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e(TAG, "contain error file name:" + C1122c.m6818p0(fileInfo.getFileName()));
            return 10;
        }
        if (ILLEGAL_PATTERN.matcher(fileName).find()) {
            C1120a.m6676e(TAG, "contain illegal file name:" + fileName);
            return 1001;
        }
        long length = C10278a.m63442h(fileInfo.getLocalRealPath()).length();
        if (length == fileInfo.getSize()) {
            return 0;
        }
        C1120a.m6678w(TAG, "sizeVfs is " + length + " not equals " + fileInfo.getSize());
        return SyncType.AUTO_SYNC_PHONE_MANAGER;
    }

    public String checkUserSpaceEnough() {
        long jM7089q = C1136q.b.m7089q(this.context, "userCapacityRecordTime");
        long jM7089q2 = C1136q.b.m7089q(this.context, "userCapacityUsed");
        long jM7089q3 = C1136q.b.m7089q(this.context, "userCapacityTotal");
        if (jM7089q3 > 0) {
            long j10 = jM7089q3 - jM7089q2;
            if (j10 > 314572800 && System.currentTimeMillis() - jM7089q < 1200000) {
                File fileM63442h = C10278a.m63442h(this.preFileInfo.getLocalRealPath());
                C1120a.m6675d(TAG, "totalSpaceSize:" + jM7089q3 + " useSpaceSize:" + jM7089q2 + " preUploadFile.length:" + fileM63442h.length());
                if (jM7089q3 > jM7089q2 && fileM63442h.length() <= j10) {
                    if (C1136q.b.m7072k0(this.context)) {
                        C1120a.m6675d(TAG, "clear user space too low flag");
                        C1136q.b.m7082n1(this.context, false);
                    }
                    return String.valueOf(0);
                }
                C0076n.m619a().m627i(fileM63442h.length() + jM7089q2);
                C1120a.m6678w(TAG, "checkUserLocalSpaceEnough low space");
                C1122c.m6750X1(this.context, C1122c.m6713L0("3015", true), "U:" + jM7089q2 + ", T:" + jM7089q3, "04005", "checkUserSpaceEnough", this.traceId, true);
                return "5";
            }
        }
        return checkUserYunSpaceEnough();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public String checkUserYunSpaceEnough() throws Throwable {
        String str;
        String str2;
        String string;
        String str3;
        String strM6713L0 = "0:1";
        String str4 = "OK";
        try {
            try {
                InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
                if (interfaceC9285d != null) {
                    QuotaSpaceInfo quotaSpaceInfoMo17175h = interfaceC9285d.mo17175h();
                    if (quotaSpaceInfoMo17175h != null) {
                        long total = quotaSpaceInfoMo17175h.getTotal();
                        long used = quotaSpaceInfoMo17175h.getUsed();
                        C1120a.m6677i(TAG, "checkUserYunSpaceEnough spaceTotal=" + total + ", spaceUsed=" + used);
                        C1136q.b.m7112x1(this.context, "userCapacityUsed", used);
                        C1136q.b.m7112x1(this.context, "userCapacityTotal", total);
                        C1136q.b.m7112x1(this.context, "userCapacityRecordTime", System.currentTimeMillis());
                        File fileM63442h = C10278a.m63442h(this.preFileInfo.getLocalRealPath());
                        if (total > used && fileM63442h.length() <= total - used) {
                            if (C1136q.b.m7072k0(this.context)) {
                                C1120a.m6675d(TAG, "clear user space too low flag");
                                C1136q.b.m7082n1(this.context, false);
                            }
                            C1122c.m6747W1(this.context, "0:1", "OK", "04005", "quota.summary", this.traceId);
                            return "0";
                        }
                        C0076n.m619a().m627i(fileM63442h.length() + used);
                        C1120a.m6678w(TAG, "space too low, total: " + total + ", used: " + used + ", upload size: " + fileM63442h.length());
                        String strM6713L02 = C1122c.m6713L0("3015", true);
                        try {
                            C1122c.m6747W1(this.context, strM6713L02, "U:" + used + ", T:" + total, "04005", "quota.summary", this.traceId);
                            return "5";
                        } catch (Exception e10) {
                            e = e10;
                            C1120a.m6676e(TAG, "queryUserSpace error,error message:" + e.toString());
                            str3 = "001_1007:1";
                            try {
                                string = e.toString();
                                C1122c.m6747W1(this.context, str3, string, "04005", "quota.summary", this.traceId);
                                return "7";
                            } catch (Throwable th2) {
                                th = th2;
                                str2 = "OK";
                                str = "001_1007:1";
                                C1122c.m6747W1(this.context, str, str2, "04005", "quota.summary", this.traceId);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str2 = "OK";
                            str = strM6713L02;
                            C1122c.m6747W1(this.context, str, str2, "04005", "quota.summary", this.traceId);
                            throw th;
                        }
                    }
                    strM6713L0 = C1122c.m6713L0(String.valueOf(1), false);
                    str4 = "queryUserSpace error";
                }
                str3 = strM6713L0;
                string = str4;
            } catch (Exception e11) {
                e = e11;
            }
            C1122c.m6747W1(this.context, str3, string, "04005", "quota.summary", this.traceId);
            return "7";
        } catch (Throwable th4) {
            th = th4;
            str = "0:1";
            str2 = "OK";
        }
    }

    public void closeInputStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e10) {
            C1120a.m6676e(TAG, "upload finally exute ioException,error message:" + e10.toString());
        }
    }

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
        CloudPhotoUploadProgress cloudPhotoUploadProgress = new CloudPhotoUploadProgress(context, this, this.preFileInfo, this.callbackHandler);
        try {
            C12478a c12478a = new C12478a(EnumC12999a.CLOUD_ALBUM, this.traceId);
            UploadReq uploadReq = new UploadReq();
            uploadReq.setFile(file);
            uploadReq.setCallback(cloudPhotoUploadProgress);
            uploadReq.setExtraStatKeyValues(map2);
            c12478a.m74907c(uploadReq);
            String result = uploadReq.getResult();
            C1120a.m6675d(TAG, "upload result" + result);
            if (result != null) {
                JSONObject jSONObject = new JSONObject(result);
                map.put(STR_FILEID, jSONObject.getString("fileid"));
                map.put(STR_CHECKSUM, jSONObject.getString(STR_CHECKSUM));
                map.put(STR_MD5, jSONObject.getString(STR_MD5));
                map.put(STR_SIZE, jSONObject.getString(STR_SIZE));
            }
        } catch (C9721b e10) {
            C1120a.m6677i(TAG, "cloudPhotoUpload CException:" + C1122c.m6818p0(str) + " error:" + e10.getMessage());
            int iM60663g = e10.m60663g();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(iM60663g);
            map.put(STR_ERROR_VFS_CODE, sb2.toString());
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

    public void handleHttpError(boolean z10, String str) {
    }

    public boolean isCloudSyncAllowed() {
        if (C10028c.m62182c0().m62375p1()) {
            C1120a.m6678w(TAG, "sync isForceUpgradeOrCancelHiCloud upload stop");
            C1122c.m6738T1(this.context, this.traceId);
            return false;
        }
        if (!C13452e.m80781L().m80932j1()) {
            return true;
        }
        C1120a.m6678w(TAG, "sync  StInvalid upload stop");
        C1122c.m6738T1(this.context, this.traceId);
        return false;
    }

    public int uploadFileDataToCloud(String str, String str2, String str3) {
        return 0;
    }
}
