package com.android.packageinstaller.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface IQueryAppsRiskService extends IInterface {

    /* renamed from: com.android.packageinstaller.aidl.IQueryAppsRiskService$a */
    public static abstract class AbstractBinderC1514a extends Binder implements IQueryAppsRiskService {

        /* renamed from: com.android.packageinstaller.aidl.IQueryAppsRiskService$a$a */
        public static class a implements IQueryAppsRiskService {

            /* renamed from: a */
            public IBinder f6502a;

            public a(IBinder iBinder) {
                this.f6502a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6502a;
            }

            @Override // com.android.packageinstaller.aidl.IQueryAppsRiskService
            public Map getAppsRiskEx(List<AppInfo> list, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.packageinstaller.aidl.IQueryAppsRiskService");
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.f6502a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static IQueryAppsRiskService m8616a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.packageinstaller.aidl.IQueryAppsRiskService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IQueryAppsRiskService)) ? new a(iBinder) : (IQueryAppsRiskService) iInterfaceQueryLocalInterface;
        }
    }

    Map getAppsRiskEx(List<AppInfo> list, boolean z10) throws RemoteException;
}
