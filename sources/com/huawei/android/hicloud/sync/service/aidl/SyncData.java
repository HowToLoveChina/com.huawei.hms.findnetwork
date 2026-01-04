package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SyncData implements Parcelable {
    public static final Parcelable.Creator<SyncData> CREATOR = new Parcelable.Creator<SyncData>() { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncData createFromParcel(Parcel parcel) {
            return new SyncData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncData[] newArray(int i10) {
            return new SyncData[i10];
        }
    };
    protected String data;
    protected List<UnstructData> deleteFileList;
    protected List<UnstructData> downFileList;
    protected String etag;
    protected String extensionData;
    protected String extraParam;
    protected List<UnstructData> fileList;
    protected String guid;
    protected String hash;
    protected String luid;
    protected List<UnstructDataV107> newDeleteFileList;
    protected List<UnstructDataV107> newDownFileList;
    protected List<UnstructDataV107> newFileList;
    protected int recycleStatus;
    protected long recycleTime;
    public int responseCode;
    protected int status;
    protected String unstructUuid;
    protected String uuid;
    protected int version;

    public static Parcelable.Creator<SyncData> getCreator() {
        return CREATOR;
    }

    private void readFromParcel(Parcel parcel) {
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
        if (this.version >= 104) {
            this.recycleStatus = parcel.readInt();
            this.recycleTime = parcel.readLong();
        }
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getData() {
        return this.data;
    }

    public List<UnstructData> getDeleteFileList() {
        return this.deleteFileList;
    }

    public List<UnstructData> getDownFileList() {
        return this.downFileList;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getExtensionData() {
        return this.extensionData;
    }

    public String getExtraParam() {
        return this.extraParam;
    }

    public List<UnstructData> getFileList() {
        return this.fileList;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getHash() {
        return this.hash;
    }

    public String getLuid() {
        return this.luid;
    }

    public List<UnstructDataV107> getNewDeleteFileList() {
        return this.newDeleteFileList;
    }

    public List<UnstructDataV107> getNewDownFileList() {
        return this.newDownFileList;
    }

    public List<UnstructDataV107> getNewFileList() {
        return this.newFileList;
    }

    public int getRecycleStatus() {
        return this.recycleStatus;
    }

    public long getRecycleTime() {
        return this.recycleTime;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUnstructUuid() {
        return this.unstructUuid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getVersion() {
        return this.version;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDeleteFileList(List<UnstructData> list) {
        this.deleteFileList = list;
    }

    public void setDownFileList(List<UnstructData> list) {
        this.downFileList = list;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setExtensionData(String str) {
        this.extensionData = str;
    }

    public void setExtraParam(String str) {
        this.extraParam = str;
    }

    public void setFileList(List<UnstructData> list) {
        this.fileList = list;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setLuid(String str) {
        this.luid = str;
    }

    public void setNewDeleteFileList(List<UnstructDataV107> list) {
        this.newDeleteFileList = list;
    }

    public void setNewDownFileList(List<UnstructDataV107> list) {
        this.newDownFileList = list;
    }

    public void setNewFileList(List<UnstructDataV107> list) {
        this.newFileList = list;
    }

    public void setRecycleStatus(int i10) {
        this.recycleStatus = i10;
    }

    public void setRecycleTime(long j10) {
        this.recycleTime = j10;
    }

    public void setResponseCode(int i10) {
        this.responseCode = i10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setUnstructUuid(String str) {
        this.unstructUuid = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVersion(int i10) {
        this.version = i10;
    }

    public String toString() {
        return "LocalId [luid=" + this.luid + ", guid=" + this.guid + ", etag=" + this.etag + ", unstruct uuid=" + this.unstructUuid + ", recycleStatus=" + this.recycleStatus + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.luid);
        parcel.writeString(this.guid);
        parcel.writeString(this.unstructUuid);
        parcel.writeString(this.etag);
        parcel.writeString(this.data);
        parcel.writeTypedList(this.downFileList);
        parcel.writeTypedList(this.deleteFileList);
        parcel.writeTypedList(this.fileList);
        if (this.version >= 104) {
            parcel.writeInt(this.recycleStatus);
            parcel.writeLong(this.recycleTime);
        }
        if (this.version >= 107) {
            parcel.writeString(this.extensionData);
            parcel.writeString(this.extraParam);
            parcel.writeTypedList(this.newDownFileList);
            parcel.writeTypedList(this.newDeleteFileList);
            parcel.writeTypedList(this.newFileList);
        }
    }

    private SyncData(Parcel parcel) {
        this.responseCode = -1;
        this.status = -1;
        this.uuid = null;
        this.hash = null;
        this.version = -1;
        readFromParcel(parcel);
    }

    public SyncData() {
        this.responseCode = -1;
        this.status = -1;
        this.uuid = null;
        this.hash = null;
        this.version = -1;
    }
}
