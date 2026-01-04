package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SyncDataCompatible extends SyncData {
    public static final Parcelable.Creator<SyncDataCompatible> CREATOR = new Parcelable.Creator<SyncDataCompatible>() { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncDataCompatible.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncDataCompatible createFromParcel(Parcel parcel) {
            return new SyncDataCompatible(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncDataCompatible[] newArray(int i10) {
            return new SyncDataCompatible[i10];
        }
    };

    private void readFromParcel(Parcel parcel) {
        this.version = parcel.readInt();
        this.luid = parcel.readString();
        this.guid = parcel.readString();
        this.unstructUuid = parcel.readString();
        this.etag = parcel.readString();
        this.data = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.downFileList = arrayList;
        Parcelable.Creator<UnstructData> creator = UnstructData.CREATOR;
        parcel.readTypedList(arrayList, creator);
        ArrayList arrayList2 = new ArrayList();
        this.deleteFileList = arrayList2;
        parcel.readTypedList(arrayList2, creator);
        ArrayList arrayList3 = new ArrayList();
        this.fileList = arrayList3;
        parcel.readTypedList(arrayList3, creator);
        this.recycleStatus = parcel.readInt();
        this.recycleTime = parcel.readLong();
        if (this.version >= 107) {
            this.extensionData = parcel.readString();
            this.extraParam = parcel.readString();
            ArrayList arrayList4 = new ArrayList();
            this.newDownFileList = arrayList4;
            Parcelable.Creator<UnstructDataV107> creator2 = UnstructDataV107.CREATOR;
            parcel.readTypedList(arrayList4, creator2);
            ArrayList arrayList5 = new ArrayList();
            this.newDeleteFileList = arrayList5;
            parcel.readTypedList(arrayList5, creator2);
            ArrayList arrayList6 = new ArrayList();
            this.newFileList = arrayList6;
            parcel.readTypedList(arrayList6, creator2);
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.SyncData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.version);
        parcel.writeString(this.luid);
        parcel.writeString(this.guid);
        parcel.writeString(this.unstructUuid);
        parcel.writeString(this.etag);
        parcel.writeString(this.data);
        parcel.writeTypedList(this.downFileList);
        parcel.writeTypedList(this.deleteFileList);
        parcel.writeTypedList(this.fileList);
        parcel.writeInt(this.recycleStatus);
        parcel.writeLong(this.recycleTime);
        if (this.version >= 107) {
            parcel.writeString(this.extensionData);
            parcel.writeString(this.extraParam);
            parcel.writeTypedList(this.newDownFileList);
            parcel.writeTypedList(this.newDeleteFileList);
            parcel.writeTypedList(this.newFileList);
        }
    }

    private SyncDataCompatible(Parcel parcel) {
        readFromParcel(parcel);
    }
}
