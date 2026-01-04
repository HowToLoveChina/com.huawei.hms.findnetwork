package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SmartAlbumData extends AbstractSmartAlbumInfo {
    public static final Parcelable.Creator<SmartAlbumData> CREATOR = new Parcelable.Creator<SmartAlbumData>() { // from class: com.huawei.android.hicloud.album.service.vo.SmartAlbumData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SmartAlbumData createFromParcel(Parcel parcel) {
            return new SmartAlbumData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SmartAlbumData[] newArray(int i10) {
            return new SmartAlbumData[i10];
        }
    };

    public String toString() {
        return "SmartTagData [categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", photoNum=" + this.photoNum + ", tagNum=" + this.tagNum + ", localPath=" + this.localPath + ", hash=" + this.hash + ", albumList=" + this.albumList + "]";
    }

    public SmartAlbumData() {
    }

    private SmartAlbumData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
