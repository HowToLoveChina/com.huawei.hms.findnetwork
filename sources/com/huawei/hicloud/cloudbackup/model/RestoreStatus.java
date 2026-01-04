package com.huawei.hicloud.cloudbackup.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import java.util.Objects;
import p618rm.C12580p;
import p848zl.C14333b;

/* loaded from: classes6.dex */
public class RestoreStatus implements Comparable<RestoreStatus>, Parcelable {
    private int action;
    private String appId;
    private String appName;
    private int appType;
    private long asize;
    private int bmAppDataType;
    private String combineUid;
    private int count;
    private int current;
    private long size;
    private int status;
    private int type;
    private int uid;
    private static final Object LOCK = new Object();
    private static final Object PMS_LOCK = new Object();
    public static final Parcelable.Creator<RestoreStatus> CREATOR = new C4866a();
    private String subStatus = "";
    private long bytesDownloadedApp = 0;
    private long bytesDownloadedFiles = 0;
    private long pmsAlreadyBytes = 0;
    private boolean isCompatible = true;
    private boolean isHarmonyNext = false;
    private int appShowType = 0;
    private String aggVirtualAppId = "";
    private String splitApkType = "";
    private String oriBackupAppName = "";

    /* renamed from: com.huawei.hicloud.cloudbackup.model.RestoreStatus$a */
    public class C4866a implements Parcelable.Creator<RestoreStatus> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RestoreStatus createFromParcel(Parcel parcel) {
            RestoreStatus restoreStatus = new RestoreStatus();
            restoreStatus.setAppId(parcel.readString());
            restoreStatus.setAppName(parcel.readString());
            restoreStatus.setAppType(parcel.readInt());
            restoreStatus.setAction(parcel.readInt());
            restoreStatus.setStatus(parcel.readInt());
            restoreStatus.setType(parcel.readInt());
            restoreStatus.setCurrent(parcel.readInt());
            restoreStatus.setCount(parcel.readInt());
            restoreStatus.setSize(parcel.readLong());
            restoreStatus.setAsize(parcel.readLong());
            restoreStatus.setUid(parcel.readInt());
            restoreStatus.setCombineUid(parcel.readString());
            restoreStatus.setSubStatus(parcel.readString());
            restoreStatus.setBytesDownloadedFiles(parcel.readLong());
            restoreStatus.setBytesDownloadedApp(parcel.readLong());
            restoreStatus.setPmsAlreadyBytes(parcel.readLong());
            restoreStatus.setBmAppDataType(parcel.readInt());
            restoreStatus.setSplitApkType(parcel.readString());
            restoreStatus.setOriBackupAppName(parcel.readString());
            return restoreStatus;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RestoreStatus[] newArray(int i10) {
            return new RestoreStatus[i10];
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private long getRestoreDataSize(boolean z10, long j10, CloudRestoreItem cloudRestoreItem) {
        int i10;
        String str = this.subStatus;
        str.hashCode();
        switch (str) {
            case "prepareDownloadBegin":
            case "prepareDownloadInfo":
                int i11 = this.count;
                if (i11 != 0 && (i10 = this.current) != 0) {
                    return z10 ? i10 : i11;
                }
                return 0L;
            case "prepareDownloadSnapshot":
            case "downloadFiles":
                long j11 = this.bytesDownloadedFiles;
                if (j11 != 0) {
                    return z10 ? j11 : j10;
                }
                int i12 = this.count;
                if (i12 != 0) {
                    return z10 ? this.current : i12;
                }
                return 0L;
            case "downloadApp":
                return z10 ? this.bytesDownloadedApp : j10;
            case "done":
                return j10;
            case "restoreFiles":
                if (this.pmsAlreadyBytes == 0 && !cloudRestoreItem.m29187M() && cloudRestoreItem.getUid() == 0) {
                    return z10 ? this.current : this.count;
                }
                return z10 ? this.pmsAlreadyBytes : getSize();
            default:
                return 0L;
        }
    }

    public void addBytesDownloaded(boolean z10, long j10) {
        if (j10 < 0) {
            return;
        }
        synchronized (LOCK) {
            try {
                if (z10) {
                    this.bytesDownloadedApp += j10;
                } else {
                    this.bytesDownloadedFiles += j10;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addPmsAlreadyBytes(long j10) {
        if (j10 < 0) {
            return;
        }
        synchronized (PMS_LOCK) {
            this.pmsAlreadyBytes += j10;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RestoreStatus restoreStatus = (RestoreStatus) obj;
        return this.appType == restoreStatus.appType && this.size == restoreStatus.size && this.asize == restoreStatus.asize && Objects.equals(this.appId, restoreStatus.appId) && Integer.valueOf(this.uid).equals(Integer.valueOf(restoreStatus.uid)) && Objects.equals(this.appName, restoreStatus.appName);
    }

    public int getAction() {
        return this.action % 10;
    }

    public String getAggVirtualAppId() {
        String str = this.aggVirtualAppId;
        return str == null ? "" : str;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        String str = this.appName;
        return str == null ? "" : str;
    }

    public int getAppShowType() {
        return this.appShowType;
    }

    public int getAppType() {
        return this.appType;
    }

    public long getAsize() {
        return this.asize;
    }

    public int getBmAppDataType() {
        return this.bmAppDataType;
    }

    public long getBytesDownloaded() {
        return this.bytesDownloadedFiles + this.bytesDownloadedApp;
    }

    public long getBytesDownloadedApp() {
        return this.bytesDownloadedApp;
    }

    public long getBytesDownloadedFiles() {
        return this.bytesDownloadedFiles;
    }

    public String getCombineUid() {
        return this.combineUid;
    }

    public int getCount() {
        return this.count;
    }

    public int getCurrent() {
        return this.current;
    }

    public int getDoneStatus() {
        return this.type / 10;
    }

    public float getModuleProgress(long j10, CloudRestoreItem cloudRestoreItem) {
        int[] restoreModulePhaseRatio;
        if (!RestoreProgress.isValidSubStatus(this.subStatus) || (restoreModulePhaseRatio = RestoreProgress.getRestoreModulePhaseRatio(this.subStatus)) == null || restoreModulePhaseRatio.length != 2) {
            return 0.0f;
        }
        long restoreDataSize = getRestoreDataSize(true, j10, cloudRestoreItem);
        long restoreDataSize2 = getRestoreDataSize(false, j10, cloudRestoreItem);
        int i10 = restoreModulePhaseRatio[0];
        int i11 = restoreModulePhaseRatio[1];
        float f10 = i10;
        return (restoreDataSize == 0 || restoreDataSize2 == 0) ? f10 : restoreDataSize > restoreDataSize2 ? i10 + i11 : ((restoreDataSize / restoreDataSize2) * i11) + f10;
    }

    public String getOriBackupAppName() {
        String str = this.oriBackupAppName;
        return str == null ? "" : str;
    }

    public long getPmsAlreadyBytes() {
        return this.pmsAlreadyBytes;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:47:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getProgress() {
        /*
            r6 = this;
            int r0 = r6.status
            r1 = 1
            r2 = 4636385447633747968(0x4057c00000000000, double:95.0)
            r4 = 95
            if (r0 == r1) goto L2a
            switch(r0) {
                case 4: goto L16;
                case 5: goto L16;
                case 6: goto L13;
                case 7: goto L10;
                case 8: goto L2a;
                default: goto Lf;
            }
        Lf:
            goto L41
        L10:
            r6 = 97
            goto L45
        L13:
            r6 = 96
            goto L45
        L16:
            int r0 = r6.count
            if (r0 == 0) goto L41
            int r6 = r6.current
            if (r6 <= r0) goto L1f
            goto L28
        L1f:
            double r4 = (double) r6
            double r0 = (double) r0
            double r4 = r4 / r0
            double r4 = r4 * r2
            double r0 = java.lang.Math.floor(r4)
        L27:
            int r4 = (int) r0
        L28:
            r6 = r4
            goto L45
        L2a:
            int r0 = r6.type
            r1 = 2
            if (r0 != r1) goto L43
            int r0 = r6.count
            if (r0 == 0) goto L41
            int r6 = r6.current
            if (r6 <= r0) goto L38
            goto L28
        L38:
            double r4 = (double) r6
            double r0 = (double) r0
            double r4 = r4 / r0
            double r4 = r4 * r2
            double r0 = java.lang.Math.floor(r4)
            goto L27
        L41:
            r6 = 0
            goto L45
        L43:
            r6 = 100
        L45:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.cloudbackup.model.RestoreStatus.getProgress():int");
    }

    public int getProgressShowType() {
        return this.action / 10;
    }

    public long getSize() {
        return this.size;
    }

    public String getSplitApkType() {
        String str = this.splitApkType;
        return str == null ? "" : str;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSubStatus() {
        return this.subStatus;
    }

    public int getType() {
        return this.type % 10;
    }

    public int getUid() {
        return this.uid;
    }

    public boolean hasAppData() {
        return this.appType == 1;
    }

    public int hashCode() {
        return Objects.hash(this.appId, Integer.valueOf(this.uid), this.appName, Integer.valueOf(this.appType), Long.valueOf(this.size), Long.valueOf(this.asize));
    }

    public boolean is3rdAppType() {
        int i10 = this.appType;
        return (i10 == 1 || i10 == 2 || i10 == 3) || (i10 == 4 || i10 == 6 || i10 == 7);
    }

    public boolean isCompatible() {
        return this.isCompatible;
    }

    public boolean isHarmonyNext() {
        return this.isHarmonyNext;
    }

    public boolean isShowChildList() {
        String str = this.appId;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "sysdata":
            case "thirdAppData":
            case "bmBaseData":
            case "thirdApp":
                return true;
            default:
                return false;
        }
    }

    public boolean isShowRestoreProgressTotal() {
        return isVirtual() && getProgressShowType() > 0;
    }

    public boolean isSkipDownload(boolean z10) {
        int status = getStatus();
        if (status == -8 || status == 8 || status == -6 || status == -5 || status == -4 || status == -3 || status == -1) {
            return true;
        }
        if (status != 0) {
            if (status == 1 || status == 2) {
                return true;
            }
            if (status != 3 && z10 && (!"setting".equals(this.appId) || !"HWlanucher".equals(this.appId))) {
                return true;
            }
        }
        return false;
    }

    public boolean isSuccess() {
        int i10 = this.status;
        if (i10 == -1 || i10 == 1) {
            return true;
        }
        if (i10 == 8) {
            return this.type == 1;
        }
        switch (i10) {
        }
        return false;
    }

    public boolean isSuccessWithoutUnSupport() {
        int i10 = this.status;
        if (i10 != 1) {
            return i10 == 8 && this.type == 1;
        }
        return true;
    }

    public boolean isSystemShowModule() {
        return this.appType == 0;
    }

    public boolean isTwinApp() {
        return (TextUtils.isEmpty(this.oriBackupAppName) || TextUtils.isEmpty(this.splitApkType)) ? false : true;
    }

    public boolean isUnSupport() {
        int i10 = this.status;
        return i10 == -8 || i10 == -1 || i10 == -6 || i10 == -5 || i10 == -4 || i10 == -3;
    }

    public boolean isVirtual() {
        return (this.appType == 0 && !C14333b.m85486u().containsKey(this.appId)) || (this.appType == 5 && !C14333b.m85486u().containsKey(this.appId));
    }

    public RestoreStatus setAction(int i10) {
        return setActionAndShowType(i10, getProgressShowType());
    }

    public RestoreStatus setActionAndShowType(int i10, int i11) {
        this.action = (i11 * 10) + i10;
        return this;
    }

    public RestoreStatus setAggVirtualAppId(String str) {
        this.aggVirtualAppId = str;
        return this;
    }

    public RestoreStatus setAppId(String str) {
        this.appId = str;
        return this;
    }

    public RestoreStatus setAppName(String str) {
        this.appName = str;
        return this;
    }

    public RestoreStatus setAppShowType(int i10) {
        this.appShowType = i10;
        return this;
    }

    public RestoreStatus setAppType(int i10) {
        this.appType = i10;
        return this;
    }

    public RestoreStatus setAsize(long j10) {
        this.asize = j10;
        return this;
    }

    public RestoreStatus setBmAppDataType(int i10) {
        this.bmAppDataType = i10;
        return this;
    }

    public void setBytesDownloadedApp(long j10) {
        this.bytesDownloadedApp = j10;
    }

    public void setBytesDownloadedFiles(long j10) {
        this.bytesDownloadedFiles = j10;
    }

    public RestoreStatus setCombineUid(String str) {
        this.combineUid = str;
        return this;
    }

    public RestoreStatus setCompatible(boolean z10) {
        this.isCompatible = z10;
        return this;
    }

    public RestoreStatus setCount(int i10) {
        this.count = i10;
        return this;
    }

    public RestoreStatus setCurrent(int i10) {
        this.current = i10;
        return this;
    }

    public RestoreStatus setDoneStatusAndType(int i10, int i11) {
        this.type = (i10 * 10) + i11;
        return this;
    }

    public RestoreStatus setHarmonyNext(boolean z10) {
        this.isHarmonyNext = z10;
        return this;
    }

    public RestoreStatus setOriBackupAppName(String str) {
        this.oriBackupAppName = str;
        return this;
    }

    public void setPmsAlreadyBytes(long j10) {
        this.pmsAlreadyBytes = j10;
    }

    public RestoreStatus setProgressShowType(int i10) {
        return setActionAndShowType(getAction(), i10);
    }

    public RestoreStatus setSize(long j10) {
        this.size = j10;
        return this;
    }

    public RestoreStatus setSplitApkType(String str) {
        this.splitApkType = str;
        return this;
    }

    public RestoreStatus setStatus(int i10) {
        this.status = i10;
        if (6 == i10) {
            this.subStatus = "installer";
        } else if (7 == i10) {
            this.subStatus = "restoreFiles";
        } else if (8 == i10 || i10 < 0) {
            this.subStatus = "done";
        }
        return this;
    }

    public void setSubStatus(String str) {
        this.subStatus = str;
    }

    public RestoreStatus setType(int i10) {
        return setDoneStatusAndType(getDoneStatus(), i10);
    }

    public RestoreStatus setUid(int i10) {
        this.uid = i10;
        return this;
    }

    public void update(RestoreStatus restoreStatus) {
        String str = this.appId;
        if (str != null && str.equals(restoreStatus.appId)) {
            this.action = restoreStatus.action;
            this.status = restoreStatus.status;
            this.type = restoreStatus.type;
            this.count = restoreStatus.count;
            this.current = restoreStatus.current;
            this.size = restoreStatus.size;
            this.asize = restoreStatus.asize;
            this.uid = restoreStatus.uid;
            this.combineUid = restoreStatus.combineUid;
            this.subStatus = restoreStatus.subStatus;
            this.bytesDownloadedFiles = restoreStatus.bytesDownloadedFiles;
            this.bytesDownloadedApp = restoreStatus.bytesDownloadedApp;
            this.pmsAlreadyBytes = restoreStatus.pmsAlreadyBytes;
            if (!SplitAppUtil.isTwinApp(restoreStatus.getSplitApkType(), restoreStatus.getOriBackupAppName())) {
                this.oriBackupAppName = restoreStatus.getAppId();
            } else {
                this.splitApkType = restoreStatus.getSplitApkType();
                this.oriBackupAppName = restoreStatus.getOriBackupAppName();
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appName);
        parcel.writeInt(this.appType);
        parcel.writeInt(this.action);
        parcel.writeInt(this.status);
        parcel.writeInt(this.type);
        parcel.writeInt(this.current);
        parcel.writeInt(this.count);
        parcel.writeLong(this.size);
        parcel.writeLong(this.asize);
        parcel.writeInt(this.uid);
        parcel.writeString(this.combineUid);
        parcel.writeString(this.subStatus);
        parcel.writeLong(this.bytesDownloadedFiles);
        parcel.writeLong(this.bytesDownloadedApp);
        parcel.writeLong(this.pmsAlreadyBytes);
        parcel.writeInt(this.bmAppDataType);
        parcel.writeString(this.splitApkType);
        parcel.writeString(this.oriBackupAppName);
    }

    @Override // java.lang.Comparable
    public int compareTo(RestoreStatus restoreStatus) {
        return C12580p.m75581o(this, restoreStatus);
    }
}
