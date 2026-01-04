package com.huawei.android.p069cg.p072vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.album.service.p075vo.AbstractSettingParams;

/* loaded from: classes2.dex */
public class SettingsProp extends AbstractSettingParams {
    public static final Parcelable.Creator<SettingsProp> CREATOR = new Parcelable.Creator<SettingsProp>() { // from class: com.huawei.android.cg.vo.SettingsProp.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingsProp createFromParcel(Parcel parcel) {
            return new SettingsProp(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingsProp[] newArray(int i10) {
            return new SettingsProp[i10];
        }
    };

    public String toString() {
        return "SettingsProp [thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", lcdWidth=" + this.lcdWidth + ", lcdHeight=" + this.lcdHeight + ", internalRootPath=" + this.internalRootPath + ", externalRootPath=" + this.externalRootPath + ", thumbCachePath=" + this.thumbCachePath + ", lcdCachePath=" + this.lcdCachePath + ", downloadPath=" + this.downloadPath + "]";
    }

    public SettingsProp() {
    }

    private SettingsProp(Parcel parcel) {
        readFromParcel(parcel);
    }
}
