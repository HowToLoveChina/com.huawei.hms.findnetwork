package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new C0730a();

    /* renamed from: a */
    public ArrayList<String> f3852a;

    /* renamed from: b */
    public ArrayList<String> f3853b;

    /* renamed from: c */
    public BackStackRecordState[] f3854c;

    /* renamed from: d */
    public int f3855d;

    /* renamed from: e */
    public String f3856e;

    /* renamed from: f */
    public ArrayList<String> f3857f;

    /* renamed from: g */
    public ArrayList<BackStackState> f3858g;

    /* renamed from: h */
    public ArrayList<FragmentManager.LaunchedFragmentInfo> f3859h;

    /* renamed from: androidx.fragment.app.FragmentManagerState$a */
    public class C0730a implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
        this.f3856e = null;
        this.f3857f = new ArrayList<>();
        this.f3858g = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f3852a);
        parcel.writeStringList(this.f3853b);
        parcel.writeTypedArray(this.f3854c, i10);
        parcel.writeInt(this.f3855d);
        parcel.writeString(this.f3856e);
        parcel.writeStringList(this.f3857f);
        parcel.writeTypedList(this.f3858g);
        parcel.writeTypedList(this.f3859h);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f3856e = null;
        this.f3857f = new ArrayList<>();
        this.f3858g = new ArrayList<>();
        this.f3852a = parcel.createStringArrayList();
        this.f3853b = parcel.createStringArrayList();
        this.f3854c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f3855d = parcel.readInt();
        this.f3856e = parcel.readString();
        this.f3857f = parcel.createStringArrayList();
        this.f3858g = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f3859h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
