package com.huawei.openalliance.p169ad;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.openalliance.ad.gi */
/* loaded from: classes8.dex */
public interface InterfaceC7152gi extends IInterface {

    /* renamed from: com.huawei.openalliance.ad.gi$a */
    public static abstract class a extends Binder implements InterfaceC7152gi {

        /* renamed from: com.huawei.openalliance.ad.gi$a$a, reason: collision with other inner class name */
        public static class C14458a implements InterfaceC7152gi {

            /* renamed from: a */
            public static InterfaceC7152gi f32927a;

            /* renamed from: b */
            private IBinder f32928b;

            public C14458a(IBinder iBinder) {
                this.f32928b = iBinder;
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC7152gi
            /* renamed from: a */
            public void mo43566a(int i10, long j10, boolean z10, float f10, double d10, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeFloat(f10);
                    parcelObtain.writeDouble(d10);
                    parcelObtain.writeString(str);
                    if (this.f32928b.transact(1, parcelObtain, parcelObtain2, 0) || a.m43568a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m43568a().mo43566a(i10, j10, z10, f10, d10, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32928b;
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC7152gi
            /* renamed from: a */
            public void mo43567a(int i10, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    parcelObtain.writeInt(i10);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f32928b.transact(2, parcelObtain, parcelObtain2, 0) || a.m43568a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m43568a().mo43567a(i10, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        public a() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        /* renamed from: a */
        public static InterfaceC7152gi m43568a() {
            return C14458a.f32927a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                mo43566a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
            } else {
                if (i10 != 2) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    return true;
                }
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                mo43567a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: a */
        public static InterfaceC7152gi m43569a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC7152gi)) ? new C14458a(iBinder) : (InterfaceC7152gi) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: a */
    void mo43566a(int i10, long j10, boolean z10, float f10, double d10, String str);

    /* renamed from: a */
    void mo43567a(int i10, Bundle bundle);
}
