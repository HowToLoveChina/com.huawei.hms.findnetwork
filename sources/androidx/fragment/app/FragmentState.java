package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AbstractC0791h;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new C0731a();

    /* renamed from: a */
    public final String f3860a;

    /* renamed from: b */
    public final String f3861b;

    /* renamed from: c */
    public final boolean f3862c;

    /* renamed from: d */
    public final int f3863d;

    /* renamed from: e */
    public final int f3864e;

    /* renamed from: f */
    public final String f3865f;

    /* renamed from: g */
    public final boolean f3866g;

    /* renamed from: h */
    public final boolean f3867h;

    /* renamed from: i */
    public final boolean f3868i;

    /* renamed from: j */
    public final Bundle f3869j;

    /* renamed from: k */
    public final boolean f3870k;

    /* renamed from: l */
    public final int f3871l;

    /* renamed from: m */
    public Bundle f3872m;

    /* renamed from: androidx.fragment.app.FragmentState$a */
    public class C0731a implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f3860a = fragment.getClass().getName();
        this.f3861b = fragment.f3728f;
        this.f3862c = fragment.f3737o;
        this.f3863d = fragment.f3746x;
        this.f3864e = fragment.f3747y;
        this.f3865f = fragment.f3748z;
        this.f3866g = fragment.f3698C;
        this.f3867h = fragment.f3735m;
        this.f3868i = fragment.f3697B;
        this.f3869j = fragment.f3729g;
        this.f3870k = fragment.f3696A;
        this.f3871l = fragment.f3713R.ordinal();
    }

    /* renamed from: a */
    public Fragment m4633a(C0753k c0753k, ClassLoader classLoader) {
        Fragment fragmentMo4623a = c0753k.mo4623a(classLoader, this.f3860a);
        Bundle bundle = this.f3869j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentMo4623a.m4437s1(this.f3869j);
        fragmentMo4623a.f3728f = this.f3861b;
        fragmentMo4623a.f3737o = this.f3862c;
        fragmentMo4623a.f3739q = true;
        fragmentMo4623a.f3746x = this.f3863d;
        fragmentMo4623a.f3747y = this.f3864e;
        fragmentMo4623a.f3748z = this.f3865f;
        fragmentMo4623a.f3698C = this.f3866g;
        fragmentMo4623a.f3735m = this.f3867h;
        fragmentMo4623a.f3697B = this.f3868i;
        fragmentMo4623a.f3696A = this.f3870k;
        fragmentMo4623a.f3713R = AbstractC0791h.c.values()[this.f3871l];
        Bundle bundle2 = this.f3872m;
        if (bundle2 != null) {
            fragmentMo4623a.f3724b = bundle2;
        } else {
            fragmentMo4623a.f3724b = new Bundle();
        }
        return fragmentMo4623a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f3860a);
        sb2.append(" (");
        sb2.append(this.f3861b);
        sb2.append(")}:");
        if (this.f3862c) {
            sb2.append(" fromLayout");
        }
        if (this.f3864e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f3864e));
        }
        String str = this.f3865f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f3865f);
        }
        if (this.f3866g) {
            sb2.append(" retainInstance");
        }
        if (this.f3867h) {
            sb2.append(" removing");
        }
        if (this.f3868i) {
            sb2.append(" detached");
        }
        if (this.f3870k) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f3860a);
        parcel.writeString(this.f3861b);
        parcel.writeInt(this.f3862c ? 1 : 0);
        parcel.writeInt(this.f3863d);
        parcel.writeInt(this.f3864e);
        parcel.writeString(this.f3865f);
        parcel.writeInt(this.f3866g ? 1 : 0);
        parcel.writeInt(this.f3867h ? 1 : 0);
        parcel.writeInt(this.f3868i ? 1 : 0);
        parcel.writeBundle(this.f3869j);
        parcel.writeInt(this.f3870k ? 1 : 0);
        parcel.writeBundle(this.f3872m);
        parcel.writeInt(this.f3871l);
    }

    public FragmentState(Parcel parcel) {
        this.f3860a = parcel.readString();
        this.f3861b = parcel.readString();
        this.f3862c = parcel.readInt() != 0;
        this.f3863d = parcel.readInt();
        this.f3864e = parcel.readInt();
        this.f3865f = parcel.readString();
        this.f3866g = parcel.readInt() != 0;
        this.f3867h = parcel.readInt() != 0;
        this.f3868i = parcel.readInt() != 0;
        this.f3869j = parcel.readBundle();
        this.f3870k = parcel.readInt() != 0;
        this.f3872m = parcel.readBundle();
        this.f3871l = parcel.readInt();
    }
}
