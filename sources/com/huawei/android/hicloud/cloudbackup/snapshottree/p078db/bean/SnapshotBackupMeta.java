package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.model.AppBaseInfo;
import java.io.Serializable;
import java.util.Objects;
import p015ak.C0241z;
import pl.C12168j;

/* loaded from: classes2.dex */
public class SnapshotBackupMeta extends AppBaseInfo implements Serializable {
    public static final long CLOUD_PATH_ENCODEED = 1;
    public static final long CLOUD_PATH_NOT_ENCODEED = 0;
    public static final String DB_ROOT_NODE_APPID = "root";
    public static final int FLAG_WITH_APP_DATA = 1;
    public static final int FLAG_WITH_APP_DATA_NO_APK = 2;
    public static final int FLAG_WITH_MO_APP_DATA = 0;
    public static final String KEY_FLAG_WITH_APP_DATA = "containsappdata";
    public static final String KEY_SHOW_TYPE = "showType";
    public static final String KEY_STRING_APP_EXTEND = "isbundleapp";
    public static final String KEY_STRING_APP_NAME = "appname";
    public static final String KEY_STRING_APP_SIZE = "appsize";
    public static final String KEY_STRING_APP_SLICE_PATH = "aserverpath";
    public static final String KEY_STRING_APP_VERSION = "avername";
    public static final String KEY_STRING_APP_VERSION_CODE = "appversioncode";
    public static final String KEY_STRING_COUNT = "count";
    public static final int STATUS_CREATE_BACKUP_RECORD_SUCCESS = 6;
    public static final int STATUS_CREATE_BACKUP_RECORD_SUCCESS_MID = -6;
    public static final int STATUS_DATA_PREPARED = 1;
    public static final int STATUS_DATA_SCANNED = 2;
    public static final int STATUS_DEFAULT = 0;
    public static final int STATUS_MKFILE_SUCCESS = 5;
    public static final int STATUS_SDCARD_SCANNED = 3;
    public static final int STATUS_UPLOAD_SUCCESS = 4;
    public static final int STATUS_UPLOAD_SUCCESS_MID = -4;
    public static final int TYPE_META_ANDROID_APK = 0;
    public static final int TYPE_META_ARK_APK = 1;
    public static final int TYPE_META_ARK_MIX_APK = 2;
    public static final int TYPE_META_BIG_DB_FILE = 8;
    public static final int TYPE_META_DB_ROOT = 10;
    public static final int TYPE_META_DIRECTORY = 5;
    public static final int TYPE_META_FILE = 6;
    public static final int TYPE_META_MAPLE_APK = 3;
    public static final int TYPE_META_ROOT_NODE = 4;
    public static final int TYPE_META_SPLIT_DB_FILE = 9;
    public static final int TYPE_META_TINY_FILE = 7;
    private static final long serialVersionUID = -2336905440053266757L;
    private long appType;
    private long cloudEncoded;
    private long cloudSize;
    private long count;
    private long dateCreate;
    private long dateInvalid;
    private long dateModify;
    private long dateTaken;

    /* renamed from: id */
    private long f11795id;
    private long left;
    private long right;
    private long size;
    private int status;
    private long type;
    private String data = "";
    private String root = "";
    private String name = "";
    private String appId = "";
    private String hash1 = "";
    private String hash2 = "";
    private String cloudPath = "";
    private String cloudHash = "";
    private String appSlice = "";
    private String extend = "";
    private String data1 = "";
    private String data2 = "";
    private String data3 = "";
    private String data4 = "";
    private String data5 = "";
    private String data6 = "";

    public C12168j convertToAppRestoreMeta(String str) {
        C12168j c12168j = new C12168j();
        c12168j.m73189r(str);
        c12168j.m73164A(getRoot() + getData());
        c12168j.m73195x(String.valueOf(getCloudEncoded()));
        c12168j.m73196y(String.valueOf(getType()));
        c12168j.m73166C(String.valueOf(getDateCreate()));
        c12168j.m73165B(getSize());
        c12168j.m73167D(getHash1());
        c12168j.m73168E(getHash2());
        c12168j.m73190s(String.valueOf(getDateModify()));
        c12168j.m73191t(String.valueOf(getDateTaken()));
        c12168j.m73170G(0);
        return c12168j;
    }

    public void convertToDirMeta() {
        setType(5L);
        setSize(0L);
        setCloudSize(0L);
        setHash1("");
        setHash2("");
        setCloudHash("");
        setCloudPath("");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SnapshotBackupMeta snapshotBackupMeta = (SnapshotBackupMeta) obj;
        return Objects.equals(this.data, snapshotBackupMeta.data) && Objects.equals(this.root, snapshotBackupMeta.root) && Objects.equals(this.appId, snapshotBackupMeta.appId) && Objects.equals(this.cloudPath, snapshotBackupMeta.cloudPath);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.AppBaseInfo
    public long getAppDataSize() {
        return this.size;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppSlice() {
        String str = this.appSlice;
        return str == null ? "" : str;
    }

    public long getAppType() {
        return this.appType;
    }

    public long getCloudEncoded() {
        return this.cloudEncoded;
    }

    public String getCloudHash() {
        String str = this.cloudHash;
        return str == null ? "" : str;
    }

    public String getCloudPath() {
        String str = this.cloudPath;
        return str == null ? "" : str;
    }

    public long getCloudSize() {
        return this.cloudSize;
    }

    public long getCount() {
        return this.count;
    }

    public String getData() {
        return this.data;
    }

    public String getData1() {
        String str = this.data1;
        return str == null ? "" : str;
    }

    public String getData2() {
        String str = this.data2;
        return str == null ? "" : str;
    }

    public String getData3() {
        String str = this.data3;
        return str == null ? "" : str;
    }

    public String getData4() {
        String str = this.data4;
        return str == null ? "" : str;
    }

    public String getData5() {
        String str = this.data5;
        return str == null ? "" : str;
    }

    public String getData6() {
        String str = this.data6;
        return str == null ? "" : str;
    }

    public long getDateCreate() {
        return this.dateCreate;
    }

    public long getDateInvalid() {
        return this.dateInvalid;
    }

    public long getDateModify() {
        return this.dateModify;
    }

    public long getDateTaken() {
        return this.dateTaken;
    }

    public String getExtend() {
        String str = this.extend;
        return str == null ? "" : str;
    }

    public String getHash1() {
        String str = this.hash1;
        return str == null ? "" : str;
    }

    public String getHash2() {
        String str = this.hash2;
        return str == null ? "" : str;
    }

    public long getId() {
        return this.f11795id;
    }

    public long getLeft() {
        return this.left;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.model.AppBaseInfo
    public String getPackageName() {
        return this.appId;
    }

    public long getRight() {
        return this.right;
    }

    public String getRoot() {
        String str = this.root;
        return str == null ? "" : str;
    }

    public long getSize() {
        return this.size;
    }

    public int getStatus() {
        return this.status;
    }

    public long getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.data, this.root, this.appId, this.cloudPath);
    }

    public boolean is3rd() {
        return this.appType > C0241z.m1688f("0");
    }

    public boolean isEncoded() {
        return this.cloudEncoded == 1;
    }

    public boolean isVirtualApp() {
        return this.appType == C0241z.m1688f("0") && String.valueOf(1).equals(this.data1);
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppSlice(String str) {
        this.appSlice = str;
    }

    public void setAppType(long j10) {
        this.appType = j10;
    }

    public void setCloudEncoded(long j10) {
        this.cloudEncoded = j10;
    }

    public void setCloudHash(String str) {
        this.cloudHash = str;
    }

    public void setCloudPath(String str) {
        this.cloudPath = str;
    }

    public void setCloudSize(long j10) {
        this.cloudSize = j10;
    }

    public void setCount(long j10) {
        this.count = j10;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setData1(String str) {
        this.data1 = str;
    }

    public void setData2(String str) {
        this.data2 = str;
    }

    public void setData3(String str) {
        this.data3 = str;
    }

    public void setData4(String str) {
        this.data4 = str;
    }

    public void setData5(String str) {
        this.data5 = str;
    }

    public void setData6(String str) {
        this.data6 = str;
    }

    public void setDateCreate(long j10) {
        this.dateCreate = j10;
    }

    public void setDateInvalid(long j10) {
        this.dateInvalid = j10;
    }

    public void setDateModify(long j10) {
        this.dateModify = j10;
    }

    public void setDateTaken(long j10) {
        this.dateTaken = j10;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setHash1(String str) {
        this.hash1 = str;
    }

    public void setHash2(String str) {
        this.hash2 = str;
    }

    public void setId(long j10) {
        this.f11795id = j10;
    }

    public void setLeft(long j10) {
        this.left = j10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRight(long j10) {
        this.right = j10;
    }

    public void setRoot(String str) {
        this.root = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setType(long j10) {
        this.type = j10;
    }

    public String[] splitExtend(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? new String[0] : str.split(str2);
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
