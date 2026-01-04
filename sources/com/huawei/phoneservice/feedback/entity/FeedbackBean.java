package com.huawei.phoneservice.feedback.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import java.util.List;

/* loaded from: classes5.dex */
public class FeedbackBean implements Parcelable {
    public static final Parcelable.Creator<FeedbackBean> CREATOR = new C8469a();
    private FeedbackInfo info;
    private List<MediaItem> medias;

    /* renamed from: com.huawei.phoneservice.feedback.entity.FeedbackBean$a */
    public class C8469a implements Parcelable.Creator<FeedbackBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FeedbackBean createFromParcel(Parcel parcel) {
            return new FeedbackBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FeedbackBean[] newArray(int i10) {
            return new FeedbackBean[i10];
        }
    }

    public FeedbackBean() {
        this.info = new FeedbackInfo();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAssociatedId() {
        return this.info.getAssociatedId();
    }

    public String getChildId() {
        return this.info.getChildId();
    }

    public String getContact() {
        return this.info.getContact();
    }

    public long getFilesSize() {
        return this.info.getFilesSize();
    }

    public int getFlag() {
        return this.info.getFlag();
    }

    public FeedbackInfo getInfo() {
        return this.info;
    }

    public long getLogsSize() {
        return this.info.getLogsSize();
    }

    public MediaItem getMediaItem(int i10) {
        List<MediaItem> list = this.medias;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.medias.get(i10);
    }

    public List<MediaItem> getMedias() {
        return this.medias;
    }

    public String getParentId() {
        return this.info.getParentId();
    }

    public String getProblemDesc() {
        return this.info.getProblemDesc();
    }

    public String getProblemId() {
        return this.info.getProblemId();
    }

    public String getProblemName() {
        return this.info.getProblemName();
    }

    public String getProblemType() {
        return this.info.getProblemType();
    }

    public boolean getShowLog() {
        return this.info.getShowLog();
    }

    public String getSrCode() {
        return this.info.getSrCode();
    }

    public String getUniqueCode() {
        return this.info.getUniqueCode();
    }

    public String getZipFileName() {
        return this.info.getZipFileName();
    }

    public boolean haveMedias() {
        return !FaqCommonUtils.isEmpty(this.medias);
    }

    public MediaItem remove(int i10) {
        return this.medias.remove(i10);
    }

    public void setAssociatedId(long j10) {
        this.info.setAssociatedId(j10);
    }

    public void setChildId(String str) {
        this.info.setChildId(str);
    }

    public void setContact(String str) {
        this.info.setContact(str);
    }

    public void setFilesSize(long j10) {
        this.info.setFilesSize(j10);
    }

    public void setFlag(int i10) {
        this.info.setFlag(i10);
    }

    public void setInfo(FeedbackInfo feedbackInfo) {
        this.info = feedbackInfo;
    }

    public void setLogsSize(long j10) {
        this.info.setLogsSize(j10);
    }

    public void setMedias(List<MediaItem> list) {
        this.medias = list;
    }

    public void setParentId(String str) {
        this.info.setParentId(str);
    }

    public void setProblemDesc(String str) {
        this.info.setProblemDesc(str);
    }

    public void setProblemId(String str) {
        this.info.setProblemId(str);
    }

    public void setProblemName(String str) {
        this.info.setProblemName(str);
    }

    public void setProblemType(String str, String str2) {
        this.info.setProblemType(str, str2);
    }

    public void setShowLog(boolean z10) {
        this.info.setShowLog(z10);
    }

    public void setSrCode(String str) {
        this.info.setSrCode(str);
    }

    public void setUniqueCode(String str) {
        this.info.setUniqueCode(str);
    }

    public void setZipFileName(String str) {
        this.info.setZipFileName(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.medias);
        parcel.writeParcelable(this.info, i10);
    }

    public FeedbackBean(Parcel parcel) {
        this.medias = parcel.createTypedArrayList(MediaItem.CREATOR);
        this.info = (FeedbackInfo) parcel.readParcelable(FeedbackInfo.class.getClassLoader());
    }

    public boolean remove(MediaItem mediaItem) {
        return this.medias.remove(mediaItem);
    }

    public FeedbackBean(String str, String str2, String str3, String str4) {
        this.info = new FeedbackInfo(str, str2, str3, str4);
    }

    public FeedbackBean(String str, String str2, String str3, String str4, String str5) {
        this.info = new FeedbackInfo(str, str2, str3, str4, str5);
    }
}
