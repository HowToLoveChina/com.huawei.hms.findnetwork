package com.huawei.location.resp;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: com.huawei.location.resp.Vw */
/* loaded from: classes8.dex */
public final class C6804Vw implements Parcelable {
    public static final Parcelable.Creator<C6804Vw> CREATOR = new a();

    /* renamed from: a */
    public ArrayList f31395a;

    /* renamed from: com.huawei.location.resp.Vw$a */
    public class a implements Parcelable.Creator<C6804Vw> {
        @Override // android.os.Parcelable.Creator
        public final C6804Vw createFromParcel(Parcel parcel) {
            return new C6804Vw(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final C6804Vw[] newArray(int i10) {
            return new C6804Vw[i10];
        }
    }

    public C6804Vw() {
        this.f31395a = new ArrayList();
    }

    /* renamed from: a */
    public final ArrayList m38487a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f31395a.iterator();
        while (it.hasNext()) {
            Location locationM38490a = ((C6805yn) it.next()).m38490a();
            if (locationM38490a != null) {
                arrayList.add(locationM38490a);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final List<C6805yn> m38488c() {
        return this.f31395a;
    }

    /* renamed from: d */
    public final void m38489d(Location location) {
        if (location == null) {
            return;
        }
        C6805yn c6805yn = new C6805yn(location);
        if (this.f31395a == null) {
            this.f31395a = new ArrayList();
        }
        this.f31395a.add(c6805yn);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C6804Vw) {
            return Objects.equals(this.f31395a, ((C6804Vw) obj).f31395a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f31395a);
    }

    public final String toString() {
        return "LocationResult{locations=" + this.f31395a + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f31395a);
    }

    public C6804Vw(Parcel parcel) {
        this.f31395a = parcel.createTypedArrayList(C6805yn.CREATOR);
    }
}
