package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes5.dex */
public class ProblemInfo implements Parcelable {
    public static final Parcelable.Creator<ProblemInfo> CREATOR = new C8608a();
    public static final int FEEDBACK = 0;
    public static final int FEEDBACK_BIG_SCREEN = 3;
    public static final int FEEDBACK_DETAIL = 1;
    public static final int FEEDBACK_INTERACT = 2;
    public static final String FEEDBACK_INTERACT_TYPE = "DLHD";
    private String contact;
    private int fromPage;
    private String problemId;
    private String problemName;
    private String problemType;
    private int refresh;
    private String srCode;
    private int unread;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.ProblemInfo$a */
    public class C8608a implements Parcelable.Creator<ProblemInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProblemInfo createFromParcel(Parcel parcel) {
            return new ProblemInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProblemInfo[] newArray(int i10) {
            return new ProblemInfo[i10];
        }
    }

    public ProblemInfo() {
    }

    public ProblemInfo(int i10) {
        this.fromPage = 0;
        this.unread = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContact() {
        return this.contact;
    }

    public int getFromPage() {
        return this.fromPage;
    }

    public String getProblemId() {
        return this.problemId;
    }

    public String getProblemName() {
        return this.problemName;
    }

    public String getProblemType() {
        return this.problemType;
    }

    public int getRefresh() {
        return this.refresh;
    }

    public String getSrCode() {
        return this.srCode;
    }

    public int getUnread() {
        return this.unread;
    }

    public boolean isBigScreen() {
        return this.fromPage == 3;
    }

    public boolean isDetail() {
        return this.fromPage == 1 && !TextUtils.isEmpty(this.problemId);
    }

    public boolean isInteract() {
        return this.fromPage == 2 && !TextUtils.isEmpty(this.srCode);
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public void setFromPage(int i10) {
        this.fromPage = i10;
    }

    public void setProblemId(String str) {
        this.problemId = str;
    }

    public void setProblemName(String str) {
        this.problemName = str;
    }

    public void setProblemType(String str) {
        this.problemType = str;
    }

    public void setRefresh(int i10) {
        this.refresh = i10;
    }

    public void setSrCode(String str) {
        this.srCode = str;
    }

    public void setUnread(int i10) {
        this.unread = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.fromPage);
        parcel.writeString(this.srCode);
        parcel.writeString(this.problemId);
        parcel.writeString(this.problemType);
        parcel.writeString(this.problemName);
        parcel.writeString(this.contact);
        parcel.writeInt(this.unread);
        parcel.writeInt(this.refresh);
    }

    public ProblemInfo(Parcel parcel) {
        this.fromPage = parcel.readInt();
        this.srCode = parcel.readString();
        this.problemId = parcel.readString();
        this.problemType = parcel.readString();
        this.problemName = parcel.readString();
        this.contact = parcel.readString();
        this.unread = parcel.readInt();
        this.refresh = parcel.readInt();
    }

    public ProblemInfo(String str, String str2) {
        this.fromPage = 1;
        this.problemId = str;
        this.problemType = str2;
    }

    public ProblemInfo(String str, String str2, String str3) {
        this.fromPage = 2;
        this.srCode = str;
        this.problemId = str2;
        this.problemType = FEEDBACK_INTERACT_TYPE;
        this.problemName = str3;
    }
}
