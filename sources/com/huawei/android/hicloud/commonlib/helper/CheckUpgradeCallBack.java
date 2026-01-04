package com.huawei.android.hicloud.commonlib.helper;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface CheckUpgradeCallBack extends IInterface {

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.CheckUpgradeCallBack$a */
    public static abstract class AbstractBinderC2764a extends Binder implements CheckUpgradeCallBack {

        /* renamed from: com.huawei.android.hicloud.commonlib.helper.CheckUpgradeCallBack$a$a */
        public static class a implements CheckUpgradeCallBack {

            /* renamed from: a */
            public IBinder f12021a;

            public a(IBinder iBinder) {
                this.f12021a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12021a;
            }

            @Override // com.huawei.android.hicloud.commonlib.helper.CheckUpgradeCallBack
            public void onUpdateInfo(boolean z10, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hicloud.commonlib.helper.CheckUpgradeCallBack");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.f12021a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static CheckUpgradeCallBack m15812a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hicloud.commonlib.helper.CheckUpgradeCallBack");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof CheckUpgradeCallBack)) ? new a(iBinder) : (CheckUpgradeCallBack) iInterfaceQueryLocalInterface;
        }
    }

    void onUpdateInfo(boolean z10, String str, String str2, String str3, String str4) throws RemoteException;
}
