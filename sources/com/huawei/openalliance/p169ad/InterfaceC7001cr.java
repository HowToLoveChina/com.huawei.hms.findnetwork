package com.huawei.openalliance.p169ad;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.openalliance.ad.cr */
/* loaded from: classes8.dex */
public interface InterfaceC7001cr extends IInterface {

    /* renamed from: com.huawei.openalliance.ad.cr$a */
    public static abstract class a {

        /* renamed from: com.huawei.openalliance.ad.cr$a$a, reason: collision with other inner class name */
        public static class C14451a implements InterfaceC7001cr {

            /* renamed from: a */
            private IBinder f32150a;

            public C14451a(IBinder iBinder) {
                this.f32150a = iBinder;
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC7001cr
            /* renamed from: a */
            public String mo41228a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(m41231c());
                    this.f32150a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32150a;
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC7001cr
            /* renamed from: b */
            public boolean mo41229b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(m41231c());
                    this.f32150a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            /* renamed from: c */
            public String m41231c() {
                return "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            }
        }

        /* renamed from: a */
        public static InterfaceC7001cr m41230a(IBinder iBinder) {
            return new C14451a(iBinder);
        }
    }

    /* renamed from: a */
    String mo41228a();

    /* renamed from: b */
    boolean mo41229b();
}
