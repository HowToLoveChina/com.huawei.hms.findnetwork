package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import p399jk.AbstractC10896a;

/* loaded from: classes2.dex */
public class FileData extends AbstractFileData {
    public static final Parcelable.Creator<FileData> CREATOR = new Parcelable.Creator<FileData>() { // from class: com.huawei.android.hicloud.album.service.vo.FileData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileData createFromParcel(Parcel parcel) {
            return new FileData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileData[] newArray(int i10) {
            return new FileData[i10];
        }
    };
    protected String albumId;
    protected String albumName;
    protected long createTime;
    protected String deviceId;
    protected String dstAlbumId;

    @SerializedName("expand")
    private JsonObject expand;
    protected String expandString;
    protected boolean favorite;
    protected String fileId;
    protected String fileName;
    protected int fileType;
    protected String fileUploadType;
    protected String fileUrl;
    protected String hash;
    protected String lcdFileId;
    protected String localBigThumbPath;
    private String localId;
    protected String localRealPath;
    protected String localThumbPath;
    protected String lpath;
    protected String otype;
    protected long oversion;
    protected String recycleAlbumId;
    protected long recycletime;
    private String resource;
    protected String sdsctime;
    private String sdsmtime;
    protected long size;
    protected String source;
    private String srcAlbumId;
    protected String thumbFileId;
    protected String thumbUrl;
    protected long timeStamp;
    protected String uniqueId;
    protected String userId;
    protected String videoThumbId;

    public FileData() {
    }

    private <T> T commonSetFunction(T t10) {
        return t10;
    }

    private void readFromParcel(Parcel parcel) {
        this.fileId = parcel.readString();
        this.videoThumbId = parcel.readString();
        this.fileUrl = parcel.readString();
        this.thumbUrl = parcel.readString();
        this.fileName = parcel.readString();
        this.createTime = parcel.readLong();
        this.albumId = parcel.readString();
        this.hash = parcel.readString();
        this.size = parcel.readLong();
        this.source = parcel.readString();
        this.fileType = parcel.readInt();
        this.expandString = parcel.readString();
        this.oversion = parcel.readLong();
        this.otype = parcel.readString();
        this.sdsctime = parcel.readString();
        this.uniqueId = parcel.readString();
        this.recycleAlbumId = parcel.readString();
        this.recycletime = parcel.readLong();
        this.deviceId = parcel.readString();
        this.favorite = parcel.readByte() != 0;
        this.thumbFileId = parcel.readString();
        this.lcdFileId = parcel.readString();
        this.dstAlbumId = parcel.readString();
        this.userId = parcel.readString();
        this.localThumbPath = parcel.readString();
        this.localBigThumbPath = parcel.readString();
        this.localRealPath = parcel.readString();
        this.fileUploadType = parcel.readString();
        this.addTime = parcel.readLong();
        this.lpath = parcel.readString();
        this.albumName = parcel.readString();
        this.resource = parcel.readString();
        if (Version.isSupportCopy()) {
            this.srcAlbumId = parcel.readString();
            this.localId = parcel.readString();
            this.sdsmtime = parcel.readString();
        }
        if (Version.isSupportTimeStamp()) {
            this.timeStamp = parcel.readLong();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public long getAddTime() {
        return ((Long) commonSetFunction(Long.valueOf(this.addTime))).longValue();
    }

    public String getAlbumId() {
        return (String) commonSetFunction(this.albumId);
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public long getCreateTime() {
        return ((Long) commonSetFunction(Long.valueOf(this.createTime))).longValue();
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDstAlbumId() {
        return this.dstAlbumId;
    }

    public JsonObject getExpand() {
        return this.expand;
    }

    public String getExpandString() {
        return (String) commonSetFunction(this.expandString);
    }

    public String getFileId() {
        return (String) commonSetFunction(this.fileId);
    }

    public String getFileName() {
        return (String) commonSetFunction(this.fileName);
    }

    public int getFileType() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.fileType))).intValue();
    }

    public String getFileUploadType() {
        return (String) commonSetFunction(this.fileUploadType);
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getHash() {
        return (String) commonSetFunction(this.hash);
    }

    public String getLcdFileId() {
        return (String) commonSetFunction(this.lcdFileId);
    }

    public String getLocalBigThumbPath() {
        return (String) commonSetFunction(this.localBigThumbPath);
    }

    public String getLocalId() {
        return this.localId;
    }

    public String getLocalRealPath() {
        return (String) commonSetFunction(this.localRealPath);
    }

    public String getLocalThumbPath() {
        return (String) commonSetFunction(this.localThumbPath);
    }

    public String getLpath() {
        return this.lpath;
    }

    public String getOtype() {
        return this.otype;
    }

    public long getOversion() {
        return this.oversion;
    }

    public String getRecycleAlbumId() {
        return this.recycleAlbumId;
    }

    public long getRecycleTime() {
        return this.recycletime;
    }

    public String getResource() {
        return this.resource;
    }

    public String getSdsctime() {
        return this.sdsctime;
    }

    public String getSdsmtime() {
        return this.sdsmtime;
    }

    public long getSize() {
        return ((Long) commonSetFunction(Long.valueOf(this.size))).longValue();
    }

    public String getSource() {
        return (String) commonSetFunction(this.source);
    }

    public String getSrcAlbumId() {
        return this.srcAlbumId;
    }

    public String getThumbFileId() {
        return this.thumbFileId;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public long getTimestamp() {
        return this.timeStamp;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public String getUserID() {
        return (String) commonSetFunction(this.userId);
    }

    public String getVideoThumbId() {
        return (String) commonSetFunction(this.videoThumbId);
    }

    public boolean isFavorite() {
        return this.favorite;
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public void setAddTime(long j10) {
        this.addTime = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setAlbumId(String str) {
        this.albumId = (String) commonSetFunction(str);
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDstAlbumId(String str) {
        this.dstAlbumId = str;
    }

    public void setExpand(JsonObject jsonObject) {
        this.expand = jsonObject;
    }

    public void setExpandString(String str) {
        this.expandString = (String) commonSetFunction(str);
    }

    public void setFavorite(boolean z10) {
        this.favorite = z10;
    }

    public void setFileId(String str) {
        this.fileId = (String) commonSetFunction(str);
    }

    public void setFileName(String str) {
        this.fileName = (String) commonSetFunction(str);
    }

    public void setFileType(int i10) {
        this.fileType = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setFileUploadType(String str) {
        this.fileUploadType = (String) commonSetFunction(str);
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public void setHash(String str) {
        this.hash = (String) commonSetFunction(str);
    }

    public void setLcdFileId(String str) {
        this.lcdFileId = (String) commonSetFunction(str);
    }

    public void setLocalBigThumbPath(String str) {
        this.localBigThumbPath = (String) commonSetFunction(str);
    }

    public void setLocalId(String str) {
        this.localId = str;
    }

    public void setLocalRealPath(String str) {
        this.localRealPath = (String) commonSetFunction(str);
    }

    public void setLocalThumbPath(String str) {
        this.localThumbPath = (String) commonSetFunction(str);
    }

    public void setLpath(String str) {
        this.lpath = str;
    }

    public void setOtype(String str) {
        this.otype = str;
    }

    public void setOversion(long j10) {
        this.oversion = j10;
    }

    public void setRecycleAlbumId(String str) {
        this.recycleAlbumId = str;
    }

    public void setRecycleTime(long j10) {
        this.recycletime = j10;
    }

    public void setResource(String str) {
        this.resource = str;
    }

    public void setSdsctime(String str) {
        this.sdsctime = str;
    }

    public void setSdsmtime(String str) {
        this.sdsmtime = str;
    }

    public void setSize(long j10) {
        this.size = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setSource(String str) {
        this.source = (String) commonSetFunction(str);
    }

    public void setSrcAlbumId(String str) {
        this.srcAlbumId = str;
    }

    public void setThumbFileId(String str) {
        this.thumbFileId = str;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setTimestamp(long j10) {
        this.timeStamp = j10;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public void setUserID(String str) {
        this.userId = (String) commonSetFunction(str);
    }

    public void setVideoThumbId(String str) {
        this.videoThumbId = (String) commonSetFunction(str);
    }

    public String toString() {
        return "FileData{fileId='" + this.fileId + "', videoThumbId='" + this.videoThumbId + "', fileUrl='" + this.fileUrl + "', thumbUrl='" + this.thumbUrl + "', fileName='" + this.fileName + "', createTime=" + this.createTime + ", albumId='" + this.albumId + "', hash='" + this.hash + "', size=" + this.size + ", source='" + this.source + "', fileType=" + this.fileType + ", expandString='" + this.expandString + "', oversion=" + this.oversion + ", otype='" + this.otype + "', sdsctime='" + this.sdsctime + "', uniqueId='" + this.uniqueId + "', thumbFileId='" + this.thumbFileId + "', lcdFileId='" + this.lcdFileId + "', recycleAlbumId='" + this.recycleAlbumId + "', recycletime=" + this.recycletime + ", deviceId='" + AbstractC10896a.proguardMsg(this.deviceId) + "', favorite=" + this.favorite + ", dstAlbumId='" + this.dstAlbumId + "', userId='" + AbstractC10896a.proguardMsg(this.userId) + "', localThumbPath='" + this.localThumbPath + "', localBigThumbPath='" + this.localBigThumbPath + "', localRealPath='" + this.localRealPath + "', fileUploadType='" + this.fileUploadType + "', addTime=" + this.addTime + ", lpath='" + this.lpath + "', albumName='" + this.albumName + "', resource='" + this.resource + "', localId='" + this.localId + "', sdsmtime='" + this.sdsmtime + "', timeStamp='" + this.timeStamp + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.fileId);
        parcel.writeString(this.videoThumbId);
        parcel.writeString(this.fileUrl);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.fileName);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.albumId);
        parcel.writeString(this.hash);
        parcel.writeLong(this.size);
        parcel.writeString(this.source);
        parcel.writeInt(this.fileType);
        parcel.writeString(this.expandString);
        parcel.writeLong(this.oversion);
        parcel.writeString(this.otype);
        parcel.writeString(this.sdsctime);
        parcel.writeString(this.uniqueId);
        parcel.writeString(this.recycleAlbumId);
        parcel.writeLong(this.recycletime);
        parcel.writeString(this.deviceId);
        parcel.writeByte(this.favorite ? (byte) 1 : (byte) 0);
        parcel.writeString(this.thumbFileId);
        parcel.writeString(this.lcdFileId);
        parcel.writeString(this.dstAlbumId);
        parcel.writeString(this.userId);
        parcel.writeString(this.localThumbPath);
        parcel.writeString(this.localBigThumbPath);
        parcel.writeString(this.localRealPath);
        parcel.writeString(this.fileUploadType);
        parcel.writeLong(this.addTime);
        parcel.writeString(this.lpath);
        parcel.writeString(this.albumName);
        parcel.writeString(this.resource);
        if (Version.isSupportCopy()) {
            parcel.writeString(this.srcAlbumId);
            parcel.writeString(this.localId);
            parcel.writeString(this.sdsmtime);
        }
        if (Version.isSupportTimeStamp()) {
            parcel.writeLong(this.timeStamp);
        }
    }

    public FileData(FileData fileData) {
        if (fileData == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        fileData.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        readFromParcel(parcelObtain);
        parcelObtain.recycle();
    }

    public FileData(Parcel parcel) {
        readFromParcel(parcel);
    }

    public FileData(File file, String str, int i10) {
        this.albumId = str;
        this.fileName = file.getName();
        this.size = file.length();
        this.fileType = i10;
    }
}
