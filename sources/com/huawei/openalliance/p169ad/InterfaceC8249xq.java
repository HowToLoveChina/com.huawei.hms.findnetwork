package com.huawei.openalliance.p169ad;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.openalliance.ad.xq */
/* loaded from: classes8.dex */
public interface InterfaceC8249xq extends IInterface {

    /* renamed from: com.huawei.openalliance.ad.xq$a */
    public static abstract class a extends Binder implements InterfaceC8249xq {

        /* renamed from: com.huawei.openalliance.ad.xq$a$a, reason: collision with other inner class name */
        public static class C14484a implements InterfaceC8249xq {

            /* renamed from: a */
            public static InterfaceC8249xq f38436a;

            /* renamed from: b */
            private IBinder f38437b;

            public C14484a(IBinder iBinder) {
                this.f38437b = iBinder;
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC8249xq
            /* renamed from: a */
            public String mo51542a(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.f38437b.transact(1, parcelObtain, parcelObtain2, 0) && a.m51543a() != null) {
                        return a.m51543a().mo51542a(str, str2, str3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38437b;
            }
        }

        public a() {
            attachInterface(this, "com.heytap.openid.IOpenID");
        }

        /* renamed from: a */
        public static InterfaceC8249xq m51543a() {
            return C14484a.f38436a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String strMo51542a = mo51542a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strMo51542a);
            return true;
        }

        /* renamed from: a */
        public static InterfaceC8249xq m51544a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC8249xq)) ? new C14484a(iBinder) : (InterfaceC8249xq) iInterfaceQueryLocalInterface;
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("IOpenID", "IOpenID err: " + th2.getClass().getSimpleName());
                return null;
            }
        }
    }

    /* renamed from: a */
    String mo51542a(String str, String str2, String str3);
}
