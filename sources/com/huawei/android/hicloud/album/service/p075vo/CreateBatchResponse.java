package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CreateBatchResponse implements Parcelable {
    public static final Parcelable.Creator<CreateBatchResponse> CREATOR = new Parcelable.Creator<CreateBatchResponse>() { // from class: com.huawei.android.hicloud.album.service.vo.CreateBatchResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CreateBatchResponse createFromParcel(Parcel parcel) {
            return new CreateBatchResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CreateBatchResponse[] newArray(int i10) {
            return new CreateBatchResponse[i10];
        }
    };
    private long batchCtime;
    private long batchId;
    private int code;
    private String info;

    public CreateBatchResponse(int i10, String str) {
        this.code = i10;
        this.info = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getBatchCtime() {
        return this.batchCtime;
    }

    public long getBatchId() {
        return this.batchId;
    }

    public int getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public void setBatchCtime(long j10) {
        this.batchCtime = j10;
    }

    public void setBatchId(long j10) {
        this.batchId = j10;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.code);
        parcel.writeString(this.info);
        parcel.writeLong(this.batchId);
        parcel.writeLong(this.batchCtime);
    }

    public CreateBatchResponse(Parcel parcel) {
        this.code = parcel.readInt();
        this.info = parcel.readString();
        this.batchId = parcel.readLong();
        this.batchCtime = parcel.readLong();
    }
}
