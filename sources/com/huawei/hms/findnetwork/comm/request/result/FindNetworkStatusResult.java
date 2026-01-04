package com.huawei.hms.findnetwork.comm.request.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes8.dex */
public class FindNetworkStatusResult implements Parcelable {
    public static final Parcelable.Creator<FindNetworkStatusResult> CREATOR = new C5341a();

    @SerializedName("isKeyringSupport")
    private boolean mIsKeyringSupport;

    @SerializedName("supportCrossDevices")
    private boolean mIsSupportCrossDevices;

    @SerializedName("switchEnabled")
    private boolean mIsSwitchEnabled;
    private int respCode;
    private String version;

    /* renamed from: com.huawei.hms.findnetwork.comm.request.result.FindNetworkStatusResult$a */
    public class C5341a implements Parcelable.Creator<FindNetworkStatusResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FindNetworkStatusResult createFromParcel(Parcel parcel) {
            return new FindNetworkStatusResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FindNetworkStatusResult[] newArray(int i10) {
            return new FindNetworkStatusResult[i10];
        }
    }

    public FindNetworkStatusResult(int i10) {
        this.respCode = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRespCode() {
        return this.respCode;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isKeyringSupport() {
        return this.mIsKeyringSupport;
    }

    public boolean isSupportCrossDevices() {
        return this.mIsSupportCrossDevices;
    }

    public boolean isSwitchEnabled() {
        return this.mIsSwitchEnabled;
    }

    public void setKeyringSupport(boolean z10) {
        this.mIsKeyringSupport = z10;
    }

    public void setSupportCrossDevices(boolean z10) {
        this.mIsSupportCrossDevices = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.respCode);
        parcel.writeString(this.version);
        parcel.writeByte(this.mIsSwitchEnabled ? (byte) 1 : (byte) 0);
    }

    public FindNetworkStatusResult(int i10, String str, boolean z10) {
        this.respCode = i10;
        this.version = str;
        this.mIsSwitchEnabled = z10;
    }

    public FindNetworkStatusResult(Parcel parcel) {
        this.respCode = parcel.readInt();
        this.version = parcel.readString();
        this.mIsSwitchEnabled = parcel.readByte() != 0;
    }
}
