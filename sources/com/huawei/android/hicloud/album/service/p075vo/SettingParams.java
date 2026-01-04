package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SettingParams extends AbstractSettingParams {
    public static final Parcelable.Creator<SettingParams> CREATOR = new Parcelable.Creator<SettingParams>() { // from class: com.huawei.android.hicloud.album.service.vo.SettingParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingParams createFromParcel(Parcel parcel) {
            return new SettingParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingParams[] newArray(int i10) {
            return new SettingParams[i10];
        }
    };

    public String toString() {
        return "SettingParams [thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", lcdWidth=" + this.lcdWidth + ", lcdHeight=" + this.lcdHeight + ", internalRootPath=" + this.internalRootPath + ", externalRootPath=" + this.externalRootPath + ", thumbCachePath=" + this.thumbCachePath + ", lcdCachePath=" + this.lcdCachePath + ", downloadPath=" + this.downloadPath + "]";
    }

    public SettingParams() {
    }

    private SettingParams(Parcel parcel) {
        readFromParcel(parcel);
    }
}
