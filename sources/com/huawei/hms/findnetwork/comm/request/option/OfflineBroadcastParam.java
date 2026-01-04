package com.huawei.hms.findnetwork.comm.request.option;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.findnetwork.comm.util.ByteUtil;
import com.huawei.hms.findnetwork.comm.util.MaskUtil;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class OfflineBroadcastParam implements Parcelable {
    public static final Parcelable.Creator<OfflineBroadcastParam> CREATOR = new C5340a();
    private String mDeviceId;
    private byte[] mMac;
    private String mPubKeyDate;
    private byte[] mPublicKey;

    /* renamed from: com.huawei.hms.findnetwork.comm.request.option.OfflineBroadcastParam$a */
    public class C5340a implements Parcelable.Creator<OfflineBroadcastParam> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OfflineBroadcastParam createFromParcel(Parcel parcel) {
            return new OfflineBroadcastParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OfflineBroadcastParam[] newArray(int i10) {
            return new OfflineBroadcastParam[i10];
        }
    }

    public OfflineBroadcastParam() {
    }

    public OfflineBroadcastParam(Parcel parcel) {
        this.mPubKeyDate = parcel.readString();
        this.mPublicKey = parcel.createByteArray();
        this.mMac = parcel.createByteArray();
        this.mDeviceId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getMac() {
        return (byte[]) this.mMac.clone();
    }

    public String getPubKeyDate() {
        return this.mPubKeyDate;
    }

    public byte[] getPublicKey() {
        return (byte[]) this.mPublicKey.clone();
    }

    public String getmDeviceId() {
        return this.mDeviceId;
    }

    public void setMac(byte[] bArr) {
        if (bArr != null) {
            this.mMac = (byte[]) bArr.clone();
        }
    }

    public void setPubKeyDate(String str) {
        this.mPubKeyDate = str;
    }

    public void setPublicKey(byte[] bArr) {
        if (bArr != null) {
            this.mPublicKey = (byte[]) bArr.clone();
        }
    }

    public void setmDeviceId(String str) {
        this.mDeviceId = str;
    }

    public String toString() {
        return "OfflineBroadcastParam{mPubKeyDate='" + this.mPubKeyDate + "', mPublicKeyHash=" + ByteUtil.getSHA256Str(this.mPublicKey) + ", mMacKey=" + Arrays.toString(this.mMac) + ", mDeviceId=" + MaskUtil.maskSn(this.mDeviceId) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mPubKeyDate);
        parcel.writeByteArray(this.mPublicKey);
        parcel.writeByteArray(this.mMac);
        parcel.writeString(this.mDeviceId);
    }
}
