package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AccountCheckResult implements Parcelable {
    public static final Parcelable.Creator<AccountCheckResult> CREATOR = new Parcelable.Creator<AccountCheckResult>() { // from class: com.huawei.android.hicloud.album.service.vo.AccountCheckResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountCheckResult createFromParcel(Parcel parcel) {
            return new AccountCheckResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountCheckResult[] newArray(int i10) {
            return new AccountCheckResult[i10];
        }
    };
    private String accountName;
    private String accountUid;

    public AccountCheckResult(String str, String str2) {
        this.accountName = str;
        this.accountUid = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountUid() {
        return this.accountUid;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAccountUid(String str) {
        this.accountUid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.accountName);
        parcel.writeString(this.accountUid);
    }

    public AccountCheckResult(Parcel parcel) {
        this.accountName = parcel.readString();
        this.accountUid = parcel.readString();
    }
}
