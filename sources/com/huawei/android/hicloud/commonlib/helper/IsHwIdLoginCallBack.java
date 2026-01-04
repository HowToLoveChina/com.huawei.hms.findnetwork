package com.huawei.android.hicloud.commonlib.helper;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IsHwIdLoginCallBack extends IInterface {

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.IsHwIdLoginCallBack$a */
    public static abstract class AbstractBinderC2772a extends Binder implements IsHwIdLoginCallBack {

        /* renamed from: com.huawei.android.hicloud.commonlib.helper.IsHwIdLoginCallBack$a$a */
        public static class a implements IsHwIdLoginCallBack {

            /* renamed from: a */
            public IBinder f12034a;

            public a(IBinder iBinder) {
                this.f12034a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12034a;
            }

            @Override // com.huawei.android.hicloud.commonlib.helper.IsHwIdLoginCallBack
            public void loginResult(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hicloud.commonlib.helper.IsHwIdLoginCallBack");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.f12034a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static IsHwIdLoginCallBack m15900a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hicloud.commonlib.helper.IsHwIdLoginCallBack");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IsHwIdLoginCallBack)) ? new a(iBinder) : (IsHwIdLoginCallBack) iInterfaceQueryLocalInterface;
        }
    }

    void loginResult(boolean z10) throws RemoteException;
}
