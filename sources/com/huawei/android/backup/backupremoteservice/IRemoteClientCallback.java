package com.huawei.android.backup.backupremoteservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface IRemoteClientCallback extends IInterface {

    /* renamed from: com.huawei.android.backup.backupremoteservice.IRemoteClientCallback$a */
    public static abstract class AbstractBinderC2100a extends Binder implements IRemoteClientCallback {

        /* renamed from: com.huawei.android.backup.backupremoteservice.IRemoteClientCallback$a$a */
        public static class a implements IRemoteClientCallback {

            /* renamed from: a */
            public IBinder f9510a;

            public a(IBinder iBinder) {
                this.f9510a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9510a;
            }
        }

        /* renamed from: a */
        public static IRemoteClientCallback m12575a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.backup.backupremoteservice.IRemoteClientCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteClientCallback)) ? new a(iBinder) : (IRemoteClientCallback) iInterfaceQueryLocalInterface;
        }
    }
}
