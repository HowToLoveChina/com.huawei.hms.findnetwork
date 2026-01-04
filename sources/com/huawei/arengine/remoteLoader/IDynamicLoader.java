package com.huawei.arengine.remoteLoader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public interface IDynamicLoader extends IInterface {

    /* renamed from: com.huawei.arengine.remoteLoader.IDynamicLoader$a */
    public static abstract class AbstractBinderC4590a extends Binder implements IDynamicLoader {

        /* renamed from: com.huawei.arengine.remoteLoader.IDynamicLoader$a$a */
        public static class a implements IDynamicLoader {

            /* renamed from: b */
            public static IDynamicLoader f21111b;

            /* renamed from: a */
            public IBinder f21112a;

            public a(IBinder iBinder) {
                this.f21112a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21112a;
            }

            @Override // com.huawei.arengine.remoteLoader.IDynamicLoader
            public boolean checkUpdate(long j10, boolean z10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.remoteLoader.IDynamicLoader");
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (!this.f21112a.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC4590a.m28127g() != null) {
                        return AbstractBinderC4590a.m28127g().checkUpdate(j10, z10);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.arengine.remoteLoader.IDynamicLoader
            public void closeLibrary(long j10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.remoteLoader.IDynamicLoader");
                    parcelObtain.writeLong(j10);
                    if (this.f21112a.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC4590a.m28127g() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC4590a.m28127g().closeLibrary(j10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.arengine.remoteLoader.IDynamicLoader
            public long openLibrary(String str) {
                long jOpenLibrary;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.remoteLoader.IDynamicLoader");
                    parcelObtain.writeString(str);
                    if (this.f21112a.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC4590a.m28127g() == null) {
                        parcelObtain2.readException();
                        jOpenLibrary = parcelObtain2.readLong();
                    } else {
                        jOpenLibrary = AbstractBinderC4590a.m28127g().openLibrary(str);
                    }
                    return jOpenLibrary;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.arengine.remoteLoader.IDynamicLoader
            public boolean updateResourceFromRemote(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.remoteLoader.IDynamicLoader");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f21112a.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC4590a.m28127g() != null) {
                        return AbstractBinderC4590a.m28127g().updateResourceFromRemote(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: g */
        public static IDynamicLoader m28127g() {
            return a.f21111b;
        }

        /* renamed from: h */
        public static IDynamicLoader m28128h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDynamicLoader)) ? new a(iBinder) : (IDynamicLoader) iInterfaceQueryLocalInterface;
        }
    }

    boolean checkUpdate(long j10, boolean z10);

    void closeLibrary(long j10);

    long openLibrary(String str);

    boolean updateResourceFromRemote(String str, String str2);
}
