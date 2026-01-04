package com.huawei.hicloud.request.cbs.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes6.dex */
public class CBSFileInfo implements Parcelable {
    public static final Parcelable.Creator<CBSFileInfo> CREATOR = new Parcelable.Creator<CBSFileInfo>() { // from class: com.huawei.hicloud.request.cbs.bean.CBSFileInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CBSFileInfo createFromParcel(Parcel parcel) {
            CBSFileInfo cBSFileInfo = new CBSFileInfo();
            cBSFileInfo.setHash(parcel.readString());
            cBSFileInfo.setFileName(parcel.readString());
            cBSFileInfo.setMkFile((MkFile) parcel.readValue(MkFile.class.getClassLoader()));
            cBSFileInfo.setIsApkOrIcon(parcel.readInt());
            cBSFileInfo.setExpand(parcel.readString());
            return cBSFileInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CBSFileInfo[] newArray(int i10) {
            return new CBSFileInfo[i10];
        }
    };
    private String expand = "";
    private String fileName;
    private String hash;
    private int isApkOrIcon;
    private MkFile mkFile;

    public String[] convert(Map<String, String> map, String str, String str2) {
        String str3 = map.get("modifiedtime");
        String str4 = map.get("datetaken");
        String[] strArr = new String[4];
        if (str3 == null) {
            str3 = "";
        }
        strArr[0] = str3;
        if (str4 == null) {
            str4 = "";
        }
        strArr[1] = str4;
        if (str == null) {
            str = "";
        }
        strArr[2] = str;
        if (str2 == null) {
            str2 = "";
        }
        strArr[3] = str2;
        return strArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getExpand() {
        return this.expand;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getHash() {
        return this.hash;
    }

    public int getIsApkOrIcon() {
        return this.isApkOrIcon;
    }

    public MkFile getMkFile() {
        return this.mkFile;
    }

    public void setExpand(String str) {
        this.expand = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setIsApkOrIcon(int i10) {
        this.isApkOrIcon = i10;
    }

    public void setMkFile(MkFile mkFile) {
        this.mkFile = mkFile;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.hash);
        parcel.writeString(this.fileName);
        parcel.writeValue(this.mkFile);
        parcel.writeInt(this.isApkOrIcon);
        parcel.writeString(this.expand);
    }
}
