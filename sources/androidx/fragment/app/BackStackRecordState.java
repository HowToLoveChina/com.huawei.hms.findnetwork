package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.AbstractC0735a0;
import androidx.lifecycle.AbstractC0791h;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new C0700a();

    /* renamed from: a */
    public final int[] f3679a;

    /* renamed from: b */
    public final ArrayList<String> f3680b;

    /* renamed from: c */
    public final int[] f3681c;

    /* renamed from: d */
    public final int[] f3682d;

    /* renamed from: e */
    public final int f3683e;

    /* renamed from: f */
    public final String f3684f;

    /* renamed from: g */
    public final int f3685g;

    /* renamed from: h */
    public final int f3686h;

    /* renamed from: i */
    public final CharSequence f3687i;

    /* renamed from: j */
    public final int f3688j;

    /* renamed from: k */
    public final CharSequence f3689k;

    /* renamed from: l */
    public final ArrayList<String> f3690l;

    /* renamed from: m */
    public final ArrayList<String> f3691m;

    /* renamed from: n */
    public final boolean f3692n;

    /* renamed from: androidx.fragment.app.BackStackRecordState$a */
    public class C0700a implements Parcelable.Creator<BackStackRecordState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    public BackStackRecordState(C0734a c0734a) {
        int size = c0734a.f3892c.size();
        this.f3679a = new int[size * 6];
        if (!c0734a.f3898i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f3680b = new ArrayList<>(size);
        this.f3681c = new int[size];
        this.f3682d = new int[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            AbstractC0735a0.a aVar = c0734a.f3892c.get(i11);
            int i12 = i10 + 1;
            this.f3679a[i10] = aVar.f3909a;
            ArrayList<String> arrayList = this.f3680b;
            Fragment fragment = aVar.f3910b;
            arrayList.add(fragment != null ? fragment.f3728f : null);
            int[] iArr = this.f3679a;
            iArr[i12] = aVar.f3911c ? 1 : 0;
            iArr[i10 + 2] = aVar.f3912d;
            iArr[i10 + 3] = aVar.f3913e;
            int i13 = i10 + 5;
            iArr[i10 + 4] = aVar.f3914f;
            i10 += 6;
            iArr[i13] = aVar.f3915g;
            this.f3681c[i11] = aVar.f3916h.ordinal();
            this.f3682d[i11] = aVar.f3917i.ordinal();
        }
        this.f3683e = c0734a.f3897h;
        this.f3684f = c0734a.f3900k;
        this.f3685g = c0734a.f3888v;
        this.f3686h = c0734a.f3901l;
        this.f3687i = c0734a.f3902m;
        this.f3688j = c0734a.f3903n;
        this.f3689k = c0734a.f3904o;
        this.f3690l = c0734a.f3905p;
        this.f3691m = c0734a.f3906q;
        this.f3692n = c0734a.f3907r;
    }

    /* renamed from: a */
    public final void m4326a(C0734a c0734a) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.f3679a.length) {
                c0734a.f3897h = this.f3683e;
                c0734a.f3900k = this.f3684f;
                c0734a.f3898i = true;
                c0734a.f3901l = this.f3686h;
                c0734a.f3902m = this.f3687i;
                c0734a.f3903n = this.f3688j;
                c0734a.f3904o = this.f3689k;
                c0734a.f3905p = this.f3690l;
                c0734a.f3906q = this.f3691m;
                c0734a.f3907r = this.f3692n;
                return;
            }
            AbstractC0735a0.a aVar = new AbstractC0735a0.a();
            int i12 = i10 + 1;
            aVar.f3909a = this.f3679a[i10];
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Instantiate " + c0734a + " op #" + i11 + " base fragment #" + this.f3679a[i12]);
            }
            aVar.f3916h = AbstractC0791h.c.values()[this.f3681c[i11]];
            aVar.f3917i = AbstractC0791h.c.values()[this.f3682d[i11]];
            int[] iArr = this.f3679a;
            int i13 = i10 + 2;
            if (iArr[i12] == 0) {
                z10 = false;
            }
            aVar.f3911c = z10;
            int i14 = iArr[i13];
            aVar.f3912d = i14;
            int i15 = iArr[i10 + 3];
            aVar.f3913e = i15;
            int i16 = i10 + 5;
            int i17 = iArr[i10 + 4];
            aVar.f3914f = i17;
            i10 += 6;
            int i18 = iArr[i16];
            aVar.f3915g = i18;
            c0734a.f3893d = i14;
            c0734a.f3894e = i15;
            c0734a.f3895f = i17;
            c0734a.f3896g = i18;
            c0734a.m4666f(aVar);
            i11++;
        }
    }

    /* renamed from: c */
    public C0734a m4327c(FragmentManager fragmentManager) {
        C0734a c0734a = new C0734a(fragmentManager);
        m4326a(c0734a);
        c0734a.f3888v = this.f3685g;
        for (int i10 = 0; i10 < this.f3680b.size(); i10++) {
            String str = this.f3680b.get(i10);
            if (str != null) {
                c0734a.f3892c.get(i10).f3910b = fragmentManager.m4564f0(str);
            }
        }
        c0734a.m4658w(1);
        return c0734a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f3679a);
        parcel.writeStringList(this.f3680b);
        parcel.writeIntArray(this.f3681c);
        parcel.writeIntArray(this.f3682d);
        parcel.writeInt(this.f3683e);
        parcel.writeString(this.f3684f);
        parcel.writeInt(this.f3685g);
        parcel.writeInt(this.f3686h);
        TextUtils.writeToParcel(this.f3687i, parcel, 0);
        parcel.writeInt(this.f3688j);
        TextUtils.writeToParcel(this.f3689k, parcel, 0);
        parcel.writeStringList(this.f3690l);
        parcel.writeStringList(this.f3691m);
        parcel.writeInt(this.f3692n ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.f3679a = parcel.createIntArray();
        this.f3680b = parcel.createStringArrayList();
        this.f3681c = parcel.createIntArray();
        this.f3682d = parcel.createIntArray();
        this.f3683e = parcel.readInt();
        this.f3684f = parcel.readString();
        this.f3685g = parcel.readInt();
        this.f3686h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f3687i = (CharSequence) creator.createFromParcel(parcel);
        this.f3688j = parcel.readInt();
        this.f3689k = (CharSequence) creator.createFromParcel(parcel);
        this.f3690l = parcel.createStringArrayList();
        this.f3691m = parcel.createStringArrayList();
        this.f3692n = parcel.readInt() != 0;
    }
}
