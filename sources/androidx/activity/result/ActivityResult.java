package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new C0339a();

    /* renamed from: a */
    public final int f1118a;

    /* renamed from: b */
    public final Intent f1119b;

    /* renamed from: androidx.activity.result.ActivityResult$a */
    public class C0339a implements Parcelable.Creator<ActivityResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult[] newArray(int i10) {
            return new ActivityResult[i10];
        }
    }

    public ActivityResult(int i10, Intent intent) {
        this.f1118a = i10;
        this.f1119b = intent;
    }

    /* renamed from: d */
    public static String m1955d(int i10) {
        return i10 != -1 ? i10 != 0 ? String.valueOf(i10) : "RESULT_CANCELED" : "RESULT_OK";
    }

    /* renamed from: a */
    public Intent m1956a() {
        return this.f1119b;
    }

    /* renamed from: c */
    public int m1957c() {
        return this.f1118a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + m1955d(this.f1118a) + ", data=" + this.f1119b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1118a);
        parcel.writeInt(this.f1119b == null ? 0 : 1);
        Intent intent = this.f1119b;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.f1118a = parcel.readInt();
        this.f1119b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
