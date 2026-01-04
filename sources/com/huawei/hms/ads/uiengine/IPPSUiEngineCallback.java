package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes8.dex */
public interface IPPSUiEngineCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IPPSUiEngineCallback";

    /* renamed from: com.huawei.hms.ads.uiengine.IPPSUiEngineCallback$a */
    public static abstract class AbstractBinderC5102a extends Binder implements IPPSUiEngineCallback {

        /* renamed from: com.huawei.hms.ads.uiengine.IPPSUiEngineCallback$a$a */
        public static class a implements IPPSUiEngineCallback {

            /* renamed from: a */
            public static IPPSUiEngineCallback f23292a;

            /* renamed from: b */
            private IBinder f23293b;

            public a(IBinder iBinder) {
                this.f23293b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23293b;
            }

            @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
            public void onCallResult(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPPSUiEngineCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23293b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC5102a.m30457a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5102a.m30457a().onCallResult(str, bundle);
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

        public AbstractBinderC5102a() {
            attachInterface(this, IPPSUiEngineCallback.DESCRIPTOR);
        }

        /* renamed from: a */
        public static IPPSUiEngineCallback m30457a() {
            return a.f23292a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(IPPSUiEngineCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface(IPPSUiEngineCallback.DESCRIPTOR);
            onCallResult(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: a */
        public static IPPSUiEngineCallback m30458a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPPSUiEngineCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPPSUiEngineCallback)) ? new a(iBinder) : (IPPSUiEngineCallback) iInterfaceQueryLocalInterface;
        }
    }

    void onCallResult(String str, Bundle bundle);
}
