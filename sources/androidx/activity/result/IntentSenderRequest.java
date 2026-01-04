package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new C0340a();

    /* renamed from: a */
    public final IntentSender f1124a;

    /* renamed from: b */
    public final Intent f1125b;

    /* renamed from: c */
    public final int f1126c;

    /* renamed from: d */
    public final int f1127d;

    /* renamed from: androidx.activity.result.IntentSenderRequest$a */
    public class C0340a implements Parcelable.Creator<IntentSenderRequest> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i10) {
            return new IntentSenderRequest[i10];
        }
    }

    public IntentSenderRequest(Parcel parcel) {
        this.f1124a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f1125b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f1126c = parcel.readInt();
        this.f1127d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f1124a, i10);
        parcel.writeParcelable(this.f1125b, i10);
        parcel.writeInt(this.f1126c);
        parcel.writeInt(this.f1127d);
    }
}
