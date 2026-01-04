package com.huawei.android.p069cg.p072vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.AbstractFileData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cipher;
import com.huawei.cloud.base.util.C4644l;

/* loaded from: classes2.dex */
public class FileInfo extends AbstractFileData {
    public static final Parcelable.Creator<FileInfo> CREATOR = new Parcelable.Creator<FileInfo>() { // from class: com.huawei.android.cg.vo.FileInfo.1
        @Override // android.os.Parcelable.Creator
        public FileInfo createFromParcel(Parcel parcel) {
            return new FileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FileInfo[] newArray(int i10) {
            return new FileInfo[i10];
        }
    };
    protected String albumId;
    private Asset asset;
    protected long batchCtime;
    protected int batchId;
    protected String categoryId;
    private Cipher cipher;
    protected long createTime;
    protected String createrAccount;
    protected String createrId;
    private String dataVersion;
    protected String deviceId;
    protected Long downloadCheckSize;
    protected int duration;
    protected String expand;
    protected boolean favorite;
    protected int fileAttribute;
    protected String fileId;
    protected String fileName;
    protected int fileType;
    protected String fileUploadType;
    protected String fileUrl;
    protected String fyuseAttach;
    protected String hash;
    protected String hashId;
    private boolean isLostData;
    private boolean isNeedAT;
    protected int isNew;
    private boolean isNotEncrypted;
    private boolean isRename;
    private boolean isUseQuic;
    protected double latitude;
    protected String lcdFileId;
    private long localBatchId;
    protected String localBigThumbPath;
    private String localId;
    protected String localRealPath;
    protected String localThumbPath;
    protected double longtitude;
    private String lpath;
    protected int orientation;
    protected int otype;
    protected long oversion;
    private String positionGallery;
    protected String recycleAlbumId;
    protected long recycletime;
    protected String replaceUrl;
    private String resource;
    protected long sdsTime;
    protected String sha256;
    protected String shareId;
    protected long size;
    protected String source;
    protected String thumbFileId;
    protected String thumbUrl;
    private long timeStamp;
    protected String uniqueId;
    private C4644l uploadTime;
    protected String userId;
    protected String videoThumbId;

    /* renamed from: com.huawei.android.cg.vo.FileInfo$1 */
    public class C23881 implements Parcelable.Creator<FileInfo> {
        @Override // android.os.Parcelable.Creator
        public FileInfo createFromParcel(Parcel parcel) {
            return new FileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FileInfo[] newArray(int i10) {
            return new FileInfo[i10];
        }
    }

    public /* synthetic */ FileInfo(Parcel parcel, C23881 c23881) {
        this(parcel);
    }

    private <T> T commonSetFunction(T t10) {
        if (t10 == null) {
            return null;
        }
        return t10;
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

    public Asset getAsset() {
        return this.asset;
    }

    public long getBatchCtime() {
        return ((Long) commonSetFunction(Long.valueOf(this.batchCtime))).longValue();
    }

    public int getBatchId() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.batchId))).intValue();
    }

    public String getCategoryId() {
        return (String) commonSetFunction(this.categoryId);
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public long getCreateTime() {
        return ((Long) commonSetFunction(Long.valueOf(this.createTime))).longValue();
    }

    public String getCreaterAccount() {
        return (String) commonSetFunction(this.createrAccount);
    }

    public String getCreaterId() {
        return (String) commonSetFunction(this.createrId);
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public String getDeviceId() {
        return (String) commonSetFunction(this.deviceId);
    }

    public Long getDownloadCheckSize() {
        return this.downloadCheckSize;
    }

    public int getDuration() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.duration))).intValue();
    }

    public String getExpand() {
        return (String) commonSetFunction(this.expand);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public String getExt1() {
        return (String) commonSetFunction(this.ext1);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public String getExt2() {
        return (String) commonSetFunction(this.ext2);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public String getExt3() {
        return (String) commonSetFunction(this.ext3);
    }

    public int getFileAttribute() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.fileAttribute))).intValue();
    }

    public String getFileId() {
        return (String) commonSetFunction(this.fileId);
    }

    public String getFileName() {
        return (String) commonSetFunction(this.fileName);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public int getFileStatus() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.fileStatus))).intValue();
    }

    public int getFileType() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.fileType))).intValue();
    }

    public String getFileUploadType() {
        return (String) commonSetFunction(this.fileUploadType);
    }

    public String getFileUrl() {
        return (String) commonSetFunction(this.fileUrl);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public long getFinishTime() {
        return ((Long) commonSetFunction(Long.valueOf(this.finishTime))).longValue();
    }

    public String getFyuseAttach() {
        return (String) commonSetFunction(this.fyuseAttach);
    }

    public String getHash() {
        return (String) commonSetFunction(this.hash);
    }

    public String getHashId() {
        return this.hashId;
    }

    public int getIsNew() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.isNew))).intValue();
    }

    public double getLatitude() {
        return ((Double) commonSetFunction(Double.valueOf(this.latitude))).doubleValue();
    }

    public String getLcdFileId() {
        return (String) commonSetFunction(this.lcdFileId);
    }

    public long getLocalBatchId() {
        return this.localBatchId;
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

    public double getLongtitude() {
        return ((Double) commonSetFunction(Double.valueOf(this.longtitude))).doubleValue();
    }

    public String getLpath() {
        return this.lpath;
    }

    public int getOrientation() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.orientation))).intValue();
    }

    public int getOtype() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.otype))).intValue();
    }

    public long getOversion() {
        return ((Long) commonSetFunction(Long.valueOf(this.oversion))).longValue();
    }

    public String getPositionGallery() {
        return this.positionGallery;
    }

    public String getRecycleAlbumId() {
        return this.recycleAlbumId;
    }

    public long getRecycleTime() {
        return this.recycletime;
    }

    public String getReplaceUrl() {
        return this.replaceUrl;
    }

    public String getResource() {
        return this.resource;
    }

    public long getSdsTime() {
        return ((Long) commonSetFunction(Long.valueOf(this.sdsTime))).longValue();
    }

    public String getSha256() {
        return this.sha256;
    }

    public String getShareId() {
        return (String) commonSetFunction(this.shareId);
    }

    public long getSize() {
        return ((Long) commonSetFunction(Long.valueOf(this.size))).longValue();
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public long getSizeProgress() {
        return ((Long) commonSetFunction(Long.valueOf(this.sizeProgress))).longValue();
    }

    public String getSource() {
        return (String) commonSetFunction(this.source);
    }

    public String getThumbFileId() {
        return (String) commonSetFunction(this.thumbFileId);
    }

    public String getThumbUrl() {
        return (String) commonSetFunction(this.thumbUrl);
    }

    public long getTimestamp() {
        return this.timeStamp;
    }

    public String getUniqueId() {
        return (String) commonSetFunction(this.uniqueId);
    }

    public String getUploadTime() {
        C4644l c4644l = this.uploadTime;
        return c4644l == null ? "" : c4644l.toString();
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

    public boolean isLostData() {
        return this.isLostData;
    }

    public boolean isMigratedData() {
        return !TextUtils.isEmpty(this.dataVersion) && this.dataVersion.equalsIgnoreCase("2.0");
    }

    public boolean isNeedAT() {
        return this.isNeedAT;
    }

    public boolean isNotEncrypted() {
        return this.isNotEncrypted;
    }

    public boolean isRename() {
        return this.isRename;
    }

    public boolean isUseQuic() {
        return this.isUseQuic;
    }

    public String printInfo() {
        return "FileInfo [albumID=" + this.albumId + ", fileName=" + this.fileName + ", size=" + this.size + ", localThumbPath=" + this.localThumbPath + ", localBigPath=" + this.localBigThumbPath + ", localRealThumbPath=" + this.localRealPath + ", source=" + this.source + ", videoThumbId=" + this.videoThumbId + "], localId=" + this.localId + "], timeStamp=" + this.timeStamp + "]";
    }

    public void readFromParcel(Parcel parcel) {
        this.fileId = parcel.readString();
        this.fileName = parcel.readString();
        this.createTime = parcel.readLong();
        this.albumId = parcel.readString();
        this.shareId = parcel.readString();
        this.hash = parcel.readString();
        this.size = parcel.readLong();
        this.source = parcel.readString();
        this.localThumbPath = parcel.readString();
        this.localBigThumbPath = parcel.readString();
        this.localRealPath = parcel.readString();
        this.videoThumbId = parcel.readString();
        this.fileType = parcel.readInt();
        this.expand = parcel.readString();
        this.oversion = parcel.readLong();
        this.orientation = parcel.readInt();
        this.fyuseAttach = parcel.readString();
        this.duration = parcel.readInt();
        this.latitude = parcel.readDouble();
        this.longtitude = parcel.readDouble();
        this.uniqueId = parcel.readString();
        this.fileAttribute = parcel.readInt();
        this.deviceId = parcel.readString();
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public void setAddTime(long j10) {
        this.addTime = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setAlbumId(String str) {
        this.albumId = (String) commonSetFunction(str);
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setBatchCtime(long j10) {
        this.batchCtime = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setBatchId(int i10) {
        this.batchId = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setCategoryId(String str) {
        this.categoryId = (String) commonSetFunction(str);
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public void setCreateTime(long j10) {
        this.createTime = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setCreaterAccount(String str) {
        this.createrAccount = (String) commonSetFunction(str);
    }

    public void setCreaterId(String str) {
        this.createrId = (String) commonSetFunction(str);
    }

    public void setDataVersion(String str) {
        this.dataVersion = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = (String) commonSetFunction(str);
    }

    public void setDownloadCheckSize(Long l10) {
        this.downloadCheckSize = l10;
    }

    public void setDuration(int i10) {
        this.duration = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setExpand(String str) {
        this.expand = (String) commonSetFunction(str);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public void setExt1(String str) {
        this.ext1 = (String) commonSetFunction(str);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public void setExt2(String str) {
        this.ext2 = (String) commonSetFunction(str);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public void setExt3(String str) {
        this.ext3 = (String) commonSetFunction(str);
    }

    public void setFavorite(boolean z10) {
        this.favorite = z10;
    }

    public void setFileAttribute(int i10) {
        this.fileAttribute = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setFileId(String str) {
        this.fileId = (String) commonSetFunction(str);
    }

    public void setFileName(String str) {
        this.fileName = (String) commonSetFunction(str);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public void setFileStatus(int i10) {
        this.fileStatus = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setFileType(int i10) {
        this.fileType = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setFileUploadType(String str) {
        this.fileUploadType = (String) commonSetFunction(str);
    }

    public void setFileUrl(String str) {
        this.fileUrl = (String) commonSetFunction(str);
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public void setFinishTime(long j10) {
        this.finishTime = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setFyuseAttach(String str) {
        this.fyuseAttach = (String) commonSetFunction(str);
    }

    public void setHash(String str) {
        this.hash = (String) commonSetFunction(str);
    }

    public void setHashId(String str) {
        this.hashId = str;
    }

    public void setIsNew(int i10) {
        this.isNew = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setLatitude(double d10) {
        this.latitude = ((Double) commonSetFunction(Double.valueOf(d10))).doubleValue();
    }

    public void setLcdFileId(String str) {
        this.lcdFileId = (String) commonSetFunction(str);
    }

    public void setLocalBatchId(long j10) {
        this.localBatchId = j10;
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

    public void setLongtitude(double d10) {
        this.longtitude = ((Double) commonSetFunction(Double.valueOf(d10))).doubleValue();
    }

    public void setLostData(boolean z10) {
        this.isLostData = z10;
    }

    public void setLpath(String str) {
        this.lpath = str;
    }

    public void setNeedAT(boolean z10) {
        this.isNeedAT = z10;
    }

    public void setNotEncrypted(boolean z10) {
        this.isNotEncrypted = z10;
    }

    public void setOrientation(int i10) {
        this.orientation = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setOtype(int i10) {
        this.otype = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setOversion(long j10) {
        this.oversion = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setPositionGallery(String str) {
        this.positionGallery = str;
    }

    public void setRecycleAlbumId(String str) {
        this.recycleAlbumId = str;
    }

    public void setRecycleTime(long j10) {
        this.recycletime = j10;
    }

    public void setRename(boolean z10) {
        this.isRename = z10;
    }

    public void setReplaceUrl(String str) {
        this.replaceUrl = str;
    }

    public void setResource(String str) {
        this.resource = str;
    }

    public void setSdsTime(long j10) {
        this.sdsTime = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setShareId(String str) {
        this.shareId = (String) commonSetFunction(str);
    }

    public void setSize(long j10) {
        this.size = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.AbstractFileData
    public void setSizeProgress(long j10) {
        this.sizeProgress = ((Long) commonSetFunction(Long.valueOf(j10))).longValue();
    }

    public void setSource(String str) {
        this.source = (String) commonSetFunction(str);
    }

    public void setThumbFileId(String str) {
        this.thumbFileId = (String) commonSetFunction(str);
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = (String) commonSetFunction(str);
    }

    public void setTimestamp(long j10) {
        this.timeStamp = j10;
    }

    public void setUniqueId(String str) {
        this.uniqueId = (String) commonSetFunction(str);
    }

    public void setUploadTime(C4644l c4644l) {
        this.uploadTime = c4644l;
    }

    public void setUseQuic(boolean z10) {
        this.isUseQuic = z10;
    }

    public void setUserID(String str) {
        this.userId = (String) commonSetFunction(str);
    }

    public void setVideoThumbId(String str) {
        this.videoThumbId = (String) commonSetFunction(str);
    }

    public String toString() {
        return "FileInfo{fileId='" + this.fileId + "', fileName='" + this.fileName + "', createTime=" + this.createTime + ", albumId='" + this.albumId + "', shareId='" + this.shareId + "', hash='" + this.hash + "', size=" + this.size + ", source='" + this.source + "', localThumbPath='" + this.localThumbPath + "', localBigThumbPath='" + this.localBigThumbPath + "', localRealPath='" + this.localRealPath + "', fileUrl='" + this.fileUrl + "', thumbUrl='" + this.thumbUrl + "', videoThumbId='" + this.videoThumbId + "', fileType=" + this.fileType + ", fileUploadType='" + this.fileUploadType + "', uniqueId='" + this.uniqueId + "', otype='" + this.otype + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.fileId);
        parcel.writeString(this.fileName);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.albumId);
        parcel.writeString(this.shareId);
        parcel.writeString(this.hash);
        parcel.writeLong(this.size);
        parcel.writeString(this.source);
        parcel.writeString(this.localThumbPath);
        parcel.writeString(this.localBigThumbPath);
        parcel.writeString(this.localRealPath);
        parcel.writeString(this.videoThumbId);
        parcel.writeInt(this.fileType);
        parcel.writeString(this.expand);
        parcel.writeLong(this.oversion);
        parcel.writeInt(this.orientation);
        parcel.writeString(this.fyuseAttach);
        parcel.writeInt(this.duration);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longtitude);
        parcel.writeString(this.uniqueId);
        parcel.writeInt(this.fileAttribute);
        parcel.writeString(this.deviceId);
    }

    public FileInfo() {
        this.isRename = false;
        this.isUseQuic = false;
    }

    private FileInfo(Parcel parcel) {
        this.isRename = false;
        this.isUseQuic = false;
        readFromParcel(parcel);
    }
}
