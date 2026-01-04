package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.http.response.BaseResponse;

/* loaded from: classes8.dex */
public class DownLoadFileBean extends BaseResponse implements Parcelable {
    public static final Parcelable.Creator<DownLoadFileBean> CREATOR = new Parcelable.Creator<DownLoadFileBean>() { // from class: com.huawei.location.lite.common.util.filedownload.DownLoadFileBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownLoadFileBean createFromParcel(Parcel parcel) {
            return new DownLoadFileBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownLoadFileBean[] newArray(int i10) {
            return new DownLoadFileBean[i10];
        }
    };

    @SerializedName("fileAccessInfo")
    private FileAccessInfo fileAccessInfo;

    public static class FileAccessInfo implements Parcelable {
        public static final Parcelable.Creator<FileAccessInfo> CREATOR = new Parcelable.Creator<FileAccessInfo>() { // from class: com.huawei.location.lite.common.util.filedownload.DownLoadFileBean.FileAccessInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FileAccessInfo createFromParcel(Parcel parcel) {
                return new FileAccessInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FileAccessInfo[] newArray(int i10) {
                return new FileAccessInfo[i10];
            }
        };

        @SerializedName("field")
        private String field;

        @SerializedName("fileSha256")
        private String fileSha256;

        @SerializedName("method")
        private String method;

        @SerializedName("url")
        private String url;

        @SerializedName("version")
        private String version;

        public FileAccessInfo() {
        }

        public FileAccessInfo(Parcel parcel) {
            this.url = parcel.readString();
            this.field = parcel.readString();
            this.method = parcel.readString();
            this.version = parcel.readString();
            this.fileSha256 = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getField() {
            return this.field;
        }

        public String getFileSha256() {
            return this.fileSha256;
        }

        public String getMethod() {
            return this.method;
        }

        public String getUrl() {
            return this.url;
        }

        public String getVersion() {
            return this.version;
        }

        public void setField(String str) {
            this.field = str;
        }

        public void setFileSha256(String str) {
            this.fileSha256 = str;
        }

        public void setMethod(String str) {
            this.method = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.url);
            parcel.writeString(this.field);
            parcel.writeString(this.method);
            parcel.writeString(this.version);
            parcel.writeString(this.fileSha256);
        }
    }

    public DownLoadFileBean(Parcel parcel) {
        this.fileAccessInfo = (FileAccessInfo) parcel.readParcelable(FileAccessInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public String getApiCode() {
        return this.code;
    }

    public FileAccessInfo getFileAccessInfo() {
        FileAccessInfo fileAccessInfo = this.fileAccessInfo;
        return fileAccessInfo == null ? new FileAccessInfo() : fileAccessInfo;
    }

    public void setFileAccessInfo(FileAccessInfo fileAccessInfo) {
        this.fileAccessInfo = fileAccessInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.fileAccessInfo, i10);
    }
}
