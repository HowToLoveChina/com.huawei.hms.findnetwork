package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class DownloadFileParam implements Parcelable {
    public static final Parcelable.Creator<DownloadFileParam> CREATOR = new C6794a();
    private String fileName;
    private String saveFilePath;
    private String serviceType;
    private String subType;

    /* renamed from: com.huawei.location.lite.common.util.filedownload.DownloadFileParam$a */
    public class C6794a implements Parcelable.Creator<DownloadFileParam> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadFileParam createFromParcel(Parcel parcel) {
            return new DownloadFileParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadFileParam[] newArray(int i10) {
            return new DownloadFileParam[i10];
        }
    }

    public DownloadFileParam() {
    }

    public DownloadFileParam(Parcel parcel) {
        this.serviceType = parcel.readString();
        this.subType = parcel.readString();
        this.saveFilePath = parcel.readString();
        this.fileName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setSaveFilePath(String str) {
        this.saveFilePath = str;
    }

    public void setServiceType(String str) {
        this.serviceType = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.serviceType);
        parcel.writeString(this.subType);
        parcel.writeString(this.saveFilePath);
        parcel.writeString(this.fileName);
    }
}
