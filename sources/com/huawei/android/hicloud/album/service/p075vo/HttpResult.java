package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class HttpResult implements Parcelable {
    public static final Parcelable.Creator<HttpResult> CREATOR = new Parcelable.Creator<HttpResult>() { // from class: com.huawei.android.hicloud.album.service.vo.HttpResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HttpResult createFromParcel(Parcel parcel) {
            return new HttpResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HttpResult[] newArray(int i10) {
            return new HttpResult[i10];
        }
    };
    private int code;
    private String cursor;
    private String info;
    private int responseCode;

    public HttpResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public String getCursor() {
        return this.cursor;
    }

    public String getInfo() {
        return this.info;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public boolean isSuccess() {
        return this.responseCode == 200 && this.code == 0;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setResponseCode(int i10) {
        this.responseCode = i10;
    }

    public String toString() {
        return "HttpResult{responseCode=" + this.responseCode + ", code=" + this.code + ", info='" + this.info + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.responseCode);
        parcel.writeInt(this.code);
        parcel.writeString(this.info);
    }

    public HttpResult(int i10, int i11, String str) {
        this.responseCode = i10;
        this.code = i11;
        this.info = str;
    }

    public HttpResult(Parcel parcel) {
        this.responseCode = parcel.readInt();
        this.code = parcel.readInt();
        this.info = parcel.readString();
    }
}
