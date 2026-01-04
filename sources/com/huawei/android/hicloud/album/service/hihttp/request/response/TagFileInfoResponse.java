package com.huawei.android.hicloud.album.service.hihttp.request.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.album.service.p075vo.AbstractSmartFileData;
import java.util.List;

/* loaded from: classes2.dex */
public class TagFileInfoResponse extends AbstractSmartFileData {
    public static final Parcelable.Creator<TagFileInfoResponse> CREATOR = new Parcelable.Creator<TagFileInfoResponse>() { // from class: com.huawei.android.hicloud.album.service.hihttp.request.response.TagFileInfoResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TagFileInfoResponse createFromParcel(Parcel parcel) {
            return new TagFileInfoResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TagFileInfoResponse[] newArray(int i10) {
            return new TagFileInfoResponse[i10];
        }
    };
    private List<String> albumIdList;
    private Attribute attributes;
    private String orientation;
    private String totalFaceNum;
    private long version;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> getAlbumIdList() {
        return this.albumIdList;
    }

    public Attribute getAttributes() {
        return this.attributes;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getTotalFaceNum() {
        return this.totalFaceNum;
    }

    public long getVersion() {
        return this.version;
    }

    public void setAlbumIdList(List<String> list) {
        this.albumIdList = list;
    }

    public void setAttributes(Attribute attribute) {
        this.attributes = attribute;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setTotalFaceNum(String str) {
        this.totalFaceNum = str;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }

    public String toString() {
        return "SmartFileData{hash='" + this.hash + "', fileId='" + this.fileId + "', createTime=" + this.createTime + ", albumIdList=" + this.albumIdList + ", tagId='" + this.tagId + "', categoryId='" + this.categoryId + "', thumbUrl='" + this.thumbUrl + "', faceId='" + this.faceId + "', x=" + this.f11650x + ", y=" + this.f11651y + ", width=" + this.width + ", height=" + this.height + ", faceFileId='" + this.faceFileId + "', version=" + this.version + ", otype='" + this.otype + "', nlinks=" + this.nlinks + ", localThumbPath='" + this.localThumbPath + "', localBigThumbPath='" + this.localBigThumbPath + "', localRealPath='" + this.localRealPath + "', spConfidence='" + this.spConfidence + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.hash);
    }

    public TagFileInfoResponse() {
    }

    private TagFileInfoResponse(Parcel parcel) {
        this.hash = parcel.readString();
    }
}
