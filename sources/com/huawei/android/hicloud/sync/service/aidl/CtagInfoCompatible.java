package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class CtagInfoCompatible extends CtagInfo {
    public static final Parcelable.Creator<CtagInfoCompatible> CREATOR = new Parcelable.Creator<CtagInfoCompatible>() { // from class: com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CtagInfoCompatible createFromParcel(Parcel parcel) {
            return new CtagInfoCompatible(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CtagInfoCompatible[] newArray(int i10) {
            return new CtagInfoCompatible[i10];
        }
    };
    private int version;

    private void setCtagInfo(CtagInfo ctagInfo) {
        if (ctagInfo != null) {
            this.ctagName = ctagInfo.getCtagName();
            this.ctagValue = ctagInfo.getCtagValue();
            this.syncToken = ctagInfo.getSyncToken();
            this.status = ctagInfo.getStatus();
            this.expired = ctagInfo.isExpired();
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.CtagInfo
    public void readFromParcel(Parcel parcel) {
        if (parcel.readInt() >= 101) {
            super.readFromParcel(parcel);
            setSyncToken(parcel.readString());
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.CtagInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.version);
        if (this.version >= 101) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(getSyncToken());
        }
    }

    private CtagInfoCompatible() {
        this.version = -1;
    }

    public CtagInfoCompatible(CtagInfo ctagInfo, int i10) {
        this.version = i10;
        setCtagInfo(ctagInfo);
    }

    private CtagInfoCompatible(Parcel parcel) {
        this.version = -1;
        readFromParcel(parcel);
    }
}
