package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.AuthManager;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.monitor.MonitorData;
import com.huawei.wearengine.monitor.MonitorItem;

/* loaded from: classes9.dex */
public interface MonitorManager extends IInterface {

    /* renamed from: com.huawei.wearengine.MonitorManager$a */
    public static abstract class AbstractBinderC8879a extends Binder implements MonitorManager {

        /* renamed from: com.huawei.wearengine.MonitorManager$a$a */
        public static class a implements MonitorManager {

            /* renamed from: a */
            public IBinder f45259a;

            public a(IBinder iBinder) {
                this.f45259a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f45259a;
            }

            @Override // com.huawei.wearengine.MonitorManager
            public MonitorData query(Device device, MonitorItem monitorItem) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.MonitorManager");
                    AuthManager.C8874b.m56489a(parcelObtain, device, 0);
                    AuthManager.C8874b.m56489a(parcelObtain, monitorItem, 0);
                    this.f45259a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    MonitorData monitorDataCreateFromParcel = parcelObtain2.readInt() != 0 ? MonitorData.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return monitorDataCreateFromParcel;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        /* renamed from: a */
        public static MonitorManager m56495a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.wearengine.MonitorManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof MonitorManager)) ? new a(iBinder) : (MonitorManager) iInterfaceQueryLocalInterface;
        }
    }

    MonitorData query(Device device, MonitorItem monitorItem);
}
