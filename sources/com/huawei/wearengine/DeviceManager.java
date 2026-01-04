package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.device.Device;
import java.util.List;

/* loaded from: classes9.dex */
public interface DeviceManager extends IInterface {

    /* renamed from: com.huawei.wearengine.DeviceManager$a */
    public static abstract class AbstractBinderC8877a extends Binder implements DeviceManager {

        /* renamed from: com.huawei.wearengine.DeviceManager$a$a */
        public static class a implements DeviceManager {

            /* renamed from: a */
            public IBinder f45258a;

            public a(IBinder iBinder) {
                this.f45258a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f45258a;
            }

            @Override // com.huawei.wearengine.DeviceManager
            public List<Device> getBondedDeviceEx() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.DeviceManager");
                    this.f45258a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Device.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.DeviceManager
            public List<Device> getBondedDevices() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.DeviceManager");
                    this.f45258a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Device.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.DeviceManager
            public boolean hasAvailableDevices() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.DeviceManager");
                    this.f45258a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static DeviceManager m56493a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.wearengine.DeviceManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof DeviceManager)) ? new a(iBinder) : (DeviceManager) iInterfaceQueryLocalInterface;
        }
    }

    List<Device> getBondedDeviceEx();

    List<Device> getBondedDevices();

    boolean hasAvailableDevices();
}
