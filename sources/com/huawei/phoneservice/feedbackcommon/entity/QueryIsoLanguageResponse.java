package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Keep
/* loaded from: classes5.dex */
public class QueryIsoLanguageResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<QueryIsoLanguageResponse> CREATOR = new C8609a();
    private static final long serialVersionUID = 1084303714530711384L;

    @SerializedName("langCode")
    private String langCode;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.QueryIsoLanguageResponse$a */
    public class C8609a implements Parcelable.Creator<QueryIsoLanguageResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QueryIsoLanguageResponse createFromParcel(Parcel parcel) {
            return new QueryIsoLanguageResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QueryIsoLanguageResponse[] newArray(int i10) {
            return new QueryIsoLanguageResponse[i10];
        }
    }

    public QueryIsoLanguageResponse(Parcel parcel) {
        this.langCode = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLangCode() {
        return this.langCode;
    }

    public void setLangCode(String str) {
        this.langCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.langCode);
    }
}
