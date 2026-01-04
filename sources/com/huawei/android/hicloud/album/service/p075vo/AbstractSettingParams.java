package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class AbstractSettingParams implements Parcelable {
    protected int autoLcdNum;
    protected String downloadPath;
    protected String externalRootPath;
    protected String internalRootPath;
    protected String lcdCachePath;
    protected int lcdHeight;
    protected int lcdWidth;
    protected String thumbCachePath;
    protected int thumbHeight;
    protected int thumbWidth;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAutoLcdNum() {
        return this.autoLcdNum;
    }

    public String getDownloadPath() {
        return this.downloadPath;
    }

    public String getExternalRootPath() {
        return this.externalRootPath;
    }

    public String getInternalRootPath() {
        return this.internalRootPath;
    }

    public String getLcdCachePath() {
        return this.lcdCachePath;
    }

    public int getLcdHeight() {
        return this.lcdHeight;
    }

    public int getLcdWidth() {
        return this.lcdWidth;
    }

    public String getThumbCachePath() {
        return this.thumbCachePath;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public void readFromParcel(Parcel parcel) {
        this.thumbWidth = parcel.readInt();
        this.thumbHeight = parcel.readInt();
        this.lcdWidth = parcel.readInt();
        this.lcdHeight = parcel.readInt();
        this.internalRootPath = parcel.readString();
        this.externalRootPath = parcel.readString();
        this.thumbCachePath = parcel.readString();
        this.lcdCachePath = parcel.readString();
        this.downloadPath = parcel.readString();
        this.autoLcdNum = parcel.readInt();
    }

    public void setAutoLcdNum(int i10) {
        this.autoLcdNum = i10;
    }

    public void setDownloadPath(String str) {
        this.downloadPath = str;
    }

    public void setExternalRootPath(String str) {
        this.externalRootPath = str;
    }

    public void setInternalRootPath(String str) {
        this.internalRootPath = str;
    }

    public void setLcdCachePath(String str) {
        this.lcdCachePath = str;
    }

    public void setLcdHeight(int i10) {
        this.lcdHeight = i10;
    }

    public void setLcdWidth(int i10) {
        this.lcdWidth = i10;
    }

    public void setThumbCachePath(String str) {
        this.thumbCachePath = str;
    }

    public void setThumbHeight(int i10) {
        this.thumbHeight = i10;
    }

    public void setThumbWidth(int i10) {
        this.thumbWidth = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.thumbWidth);
        parcel.writeInt(this.thumbHeight);
        parcel.writeInt(this.lcdWidth);
        parcel.writeInt(this.lcdHeight);
        parcel.writeString(this.internalRootPath);
        parcel.writeString(this.externalRootPath);
        parcel.writeString(this.thumbCachePath);
        parcel.writeString(this.lcdCachePath);
        parcel.writeString(this.downloadPath);
        parcel.writeInt(this.autoLcdNum);
    }
}
