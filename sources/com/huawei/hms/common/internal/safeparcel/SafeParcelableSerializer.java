package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public final class SafeParcelableSerializer {
    public static <S extends SafeParcelable> S deserializeFromBytes(byte[] bArr, Parcelable.Creator<S> creator) {
        Preconditions.checkNotNull(creator);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        S sCreateFromParcel = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return sCreateFromParcel;
    }

    public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        byte[] byteArrayExtra;
        if (intent == null || (byteArrayExtra = intent.getByteArrayExtra(str)) == null) {
            return null;
        }
        return (S) deserializeFromBytes(byteArrayExtra, creator);
    }

    public static <S extends SafeParcelable> S deserializeFromString(String str, Parcelable.Creator<S> creator) {
        return (S) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList;
        if (bundle == null || (arrayList = (ArrayList) bundle.getSerializable(str)) == null) {
            return null;
        }
        BackupConstant.C21561 c21561 = (ArrayList<S>) new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c21561.add(deserializeFromBytes((byte[]) it.next(), creator));
        }
        return c21561;
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList;
        if (intent == null || (arrayList = (ArrayList) intent.getSerializableExtra(str)) == null) {
            return null;
        }
        BackupConstant.C21561 c21561 = (ArrayList<S>) new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c21561.add(deserializeFromBytes((byte[]) it.next(), creator));
        }
        return c21561;
    }

    public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> iterable, Bundle bundle, String str) {
        if (iterable == null || bundle == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> iterable, Intent intent, String str) {
        if (iterable == null || intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        intent.putExtra(str, arrayList);
    }

    public static <S extends SafeParcelable> byte[] serializeToBytes(S s10) {
        Parcel parcelObtain = Parcel.obtain();
        if (s10 != null) {
            s10.writeToParcel(parcelObtain, 0);
        }
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static <S extends SafeParcelable> void serializeToIntentExtra(S s10, Intent intent, String str) {
        if (s10 == null || intent == null) {
            return;
        }
        intent.putExtra(str, serializeToBytes(s10));
    }

    public static <S extends SafeParcelable> String serializeToString(S s10) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(s10));
    }
}
