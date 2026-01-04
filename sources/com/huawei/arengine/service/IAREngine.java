package com.huawei.arengine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* loaded from: classes4.dex */
public interface IAREngine extends IInterface {

    /* renamed from: com.huawei.arengine.service.IAREngine$a */
    public static abstract class AbstractBinderC4593a extends Binder implements IAREngine {

        /* renamed from: com.huawei.arengine.service.IAREngine$a$a */
        public static class a implements IAREngine {

            /* renamed from: b */
            public static IAREngine f21117b;

            /* renamed from: a */
            public IBinder f21118a;

            public a(IBinder iBinder) {
                this.f21118a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21118a;
            }

            @Override // com.huawei.arengine.service.IAREngine
            public int[] getMetaData() {
                int[] iArrCreateIntArray;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
                    if (this.f21118a.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC4593a.m28131g() == null) {
                        parcelObtain2.readException();
                        iArrCreateIntArray = parcelObtain2.createIntArray();
                    } else {
                        iArrCreateIntArray = AbstractBinderC4593a.m28131g().getMetaData();
                    }
                    return iArrCreateIntArray;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.arengine.service.IAREngine
            public ParcelFileDescriptor getSharedFile(String str) {
                ParcelFileDescriptor sharedFile;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
                    parcelObtain.writeString(str);
                    if (this.f21118a.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC4593a.m28131g() == null) {
                        parcelObtain2.readException();
                        sharedFile = parcelObtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        sharedFile = AbstractBinderC4593a.m28131g().getSharedFile(str);
                    }
                    return sharedFile;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.arengine.service.IAREngine
            public int getVersionCode() {
                int versionCode;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
                    if (this.f21118a.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC4593a.m28131g() == null) {
                        parcelObtain2.readException();
                        versionCode = parcelObtain2.readInt();
                    } else {
                        versionCode = AbstractBinderC4593a.m28131g().getVersionCode();
                    }
                    return versionCode;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.arengine.service.IAREngine
            public String getVersionName() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
                    if (this.f21118a.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC4593a.m28131g() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC4593a.m28131g().getVersionName();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: g */
        public static IAREngine m28131g() {
            return a.f21117b;
        }

        /* renamed from: h */
        public static IAREngine m28132h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.arengine.service.IAREngine");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAREngine)) ? new a(iBinder) : (IAREngine) iInterfaceQueryLocalInterface;
        }
    }

    int[] getMetaData();

    ParcelFileDescriptor getSharedFile(String str);

    int getVersionCode();

    String getVersionName();
}
