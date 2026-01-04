package com.huawei.appgallery.coreservice.internal.support.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import gh.C9944e;
import java.lang.reflect.Array;

/* loaded from: classes4.dex */
public abstract class AutoParcelable implements Parcelable {

    public static class AutoCreator<T extends AutoParcelable> implements Parcelable.Creator<T> {

        /* renamed from: a */
        public final Class<T> f20996a;

        public AutoCreator(Class<T> cls) {
            this.f20996a = cls;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return (T) C9944e.m61617a(this.f20996a, parcel);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i10) {
            return (T[]) ((AutoParcelable[]) Array.newInstance((Class<?>) this.f20996a, i10));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        C9944e.m61621e(this, parcel, i10);
    }
}
