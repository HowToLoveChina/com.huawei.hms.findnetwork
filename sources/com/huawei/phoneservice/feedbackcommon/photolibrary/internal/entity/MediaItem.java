package com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.feedbackcommon.photolibrary.MimeType;

@Keep
/* loaded from: classes5.dex */
public class MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaItem> CREATOR = new C8645a();
    private static final String TAG = "MediaItem---";
    private String attachId;
    private long bucketId;
    private long dateAddedTime;
    private long duration;
    private String fileName;
    private String filePath;
    private int mediaHeight;
    private long mediaId;
    private int mediaWidth;
    private String mimeType;
    private long parentBucketId;
    private String parentFolderName;
    private String realPath;
    private long size;
    private String uri;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem$a */
    public class C8645a implements Parcelable.Creator<MediaItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaItem createFromParcel(Parcel parcel) {
            return new MediaItem(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaItem[] newArray(int i10) {
            return new MediaItem[i10];
        }
    }

    public MediaItem() {
    }

    private MediaItem(Parcel parcel) {
        this.mimeType = parcel.readString();
        this.attachId = parcel.readString();
        this.size = parcel.readLong();
        this.duration = parcel.readLong();
        this.filePath = parcel.readString();
        this.fileName = parcel.readString();
        this.mediaWidth = parcel.readInt();
        this.mediaHeight = parcel.readInt();
        this.bucketId = parcel.readLong();
        this.mediaId = parcel.readLong();
        this.parentFolderName = parcel.readString();
        this.parentBucketId = parcel.readLong();
        this.realPath = parcel.readString();
        this.dateAddedTime = parcel.readLong();
        this.uri = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        String str = this.mimeType;
        return ((str != null && str.equals(mediaItem.mimeType)) || (this.mimeType == null && mediaItem.mimeType == null)) && this.duration == mediaItem.duration && this.size == mediaItem.size;
    }

    public String getAttachId() {
        return this.attachId;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public long getDateAddedTime() {
        return this.dateAddedTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getMediaHeight() {
        return this.mediaHeight;
    }

    public long getMediaId() {
        return this.mediaId;
    }

    public int getMediaWidth() {
        return this.mediaWidth;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public long getParentBucketId() {
        return this.parentBucketId;
    }

    public String getParentFolderName() {
        return this.parentFolderName;
    }

    public String getRealPath() {
        return this.realPath;
    }

    public long getSize() {
        return this.size;
    }

    public String getUri() {
        return this.uri;
    }

    public int hashCode() throws Throwable {
        try {
            String str = this.mimeType;
            iHashCode = Long.valueOf(this.size).hashCode() + ((str != null ? str.hashCode() + 31 : 1) * 31);
            return (iHashCode * 31) + Long.valueOf(this.duration).hashCode();
        } catch (Exception e10) {
            FaqLogger.m51840e(TAG, e10.getMessage());
            return iHashCode;
        }
    }

    public boolean isImage() {
        return MimeType.m53313k(this.mimeType);
    }

    public boolean isVideo() {
        return MimeType.isVideo(this.mimeType);
    }

    public void setAttachId(String str) {
        this.attachId = str;
    }

    public void setBucketId(long j10) {
        this.bucketId = j10;
    }

    public void setDateAddedTime(long j10) {
        this.dateAddedTime = j10;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setMediaHeight(int i10) {
        this.mediaHeight = i10;
    }

    public void setMediaId(long j10) {
        this.mediaId = j10;
    }

    public void setMediaWidth(int i10) {
        this.mediaWidth = i10;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setParentBucketId(long j10) {
        this.parentBucketId = j10;
    }

    public void setParentFolderName(String str) {
        this.parentFolderName = str;
    }

    public void setRealPath(String str) {
        this.realPath = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.attachId);
        parcel.writeLong(this.size);
        parcel.writeLong(this.duration);
        parcel.writeString(this.filePath);
        parcel.writeString(this.fileName);
        parcel.writeInt(this.mediaWidth);
        parcel.writeInt(this.mediaHeight);
        parcel.writeLong(this.bucketId);
        parcel.writeLong(this.mediaId);
        parcel.writeString(this.parentFolderName);
        parcel.writeLong(this.parentBucketId);
        parcel.writeString(this.realPath);
        parcel.writeLong(this.dateAddedTime);
        parcel.writeString(this.uri);
    }

    public /* synthetic */ MediaItem(Parcel parcel, C8645a c8645a) {
        this(parcel);
    }

    public MediaItem(String str, String str2, long j10) {
        this.filePath = str;
        this.mimeType = str2;
        this.size = j10;
    }

    public MediaItem(String str, String str2, long j10, long j11, String str3, String str4) {
        this.mimeType = TextUtils.isEmpty(str) ? MimeType.getMimeType(str2) : str;
        this.size = j10;
        this.duration = j11;
        this.attachId = str3;
        this.filePath = str2;
        this.uri = str4;
    }

    public MediaItem(String str, String str2, String str3, long j10) {
        this.uri = str;
        this.filePath = str2;
        this.mimeType = str3;
        this.size = j10;
    }
}
