package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Serializable;

@Keep
/* loaded from: classes5.dex */
public class QueryNoticeResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<QueryNoticeResponse> CREATOR = new C8610a();
    private static final long serialVersionUID = -3769914540947941717L;

    @SerializedName("content")
    private String content;

    @SerializedName("countryCode")
    private String countryCode;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String language;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.QueryNoticeResponse$a */
    public class C8610a implements Parcelable.Creator<QueryNoticeResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QueryNoticeResponse createFromParcel(Parcel parcel) {
            return new QueryNoticeResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QueryNoticeResponse[] newArray(int i10) {
            return new QueryNoticeResponse[i10];
        }
    }

    public QueryNoticeResponse(Parcel parcel) {
        this.countryCode = parcel.readString();
        this.language = parcel.readString();
        this.content = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.countryCode);
        parcel.writeString(this.language);
        parcel.writeString(this.content);
    }
}
