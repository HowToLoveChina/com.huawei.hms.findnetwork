package com.huawei.openalliance.p169ad.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.beans.metadata.BluetoothInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.utils.q */
/* loaded from: classes2.dex */
public class C7838q {

    /* renamed from: com.huawei.openalliance.ad.utils.q$a */
    public interface a {
        /* renamed from: a */
        void mo39194a(List<BluetoothInfo> list, int i10);
    }

    /* renamed from: a */
    private static int m48497a(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter.getProfileConnectionState(2) == 2) {
            return 2;
        }
        return bluetoothAdapter.getProfileConnectionState(1) == 2 ? 1 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m48501b(a aVar, List<BluetoothInfo> list) {
        m48500a(aVar, list, AbstractC7760bg.m47767a(list) ? 3 : 0);
    }

    /* renamed from: a */
    public static void m48498a(Context context, final a aVar) {
        final ArrayList arrayList = new ArrayList();
        if (context == null) {
            m48500a(aVar, arrayList, 4);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (!AbstractC7784cd.m47886a(applicationContext)) {
            AbstractC7185ho.m43820b("BluetoothUtils", "missing permissions");
            m48500a(aVar, arrayList, 1);
            return;
        }
        final HashMap map = new HashMap();
        try {
            final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (AbstractC7760bg.m47767a(bondedDevices)) {
                    m48500a(aVar, arrayList, 3);
                    return;
                }
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    if (bluetoothDevice != null) {
                        BluetoothInfo bluetoothInfo = new BluetoothInfo();
                        bluetoothInfo.m39874a(bluetoothDevice.getName());
                        bluetoothInfo.m39875b(bluetoothDevice.getAddress());
                        arrayList.add(bluetoothInfo);
                        map.put(bluetoothInfo.m39872a(), bluetoothInfo);
                    }
                }
                int iM48497a = m48497a(defaultAdapter);
                AbstractC7185ho.m43821b("BluetoothUtils", "BluetoothProfile: %s", Integer.valueOf(iM48497a));
                if (iM48497a == -1) {
                    m48501b(aVar, arrayList);
                    return;
                } else {
                    defaultAdapter.getProfileProxy(applicationContext, new BluetoothProfile.ServiceListener() { // from class: com.huawei.openalliance.ad.utils.q.1
                        @Override // android.bluetooth.BluetoothProfile.ServiceListener
                        public void onServiceConnected(int i10, BluetoothProfile bluetoothProfile) {
                            BluetoothInfo bluetoothInfo2;
                            try {
                                AbstractC7185ho.m43820b("BluetoothUtils", "onServiceConnected");
                                List<BluetoothDevice> connectedDevices = bluetoothProfile.getConnectedDevices();
                                if (!AbstractC7760bg.m47767a(connectedDevices)) {
                                    for (BluetoothDevice bluetoothDevice2 : connectedDevices) {
                                        if (bluetoothDevice2 != null) {
                                            String address = bluetoothDevice2.getAddress();
                                            if (!TextUtils.isEmpty(address) && (bluetoothInfo2 = (BluetoothInfo) map.get(address)) != null) {
                                                bluetoothInfo2.m39873a((Integer) 1);
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                AbstractC7185ho.m43824c("BluetoothUtils", "onServiceConnected exception: %s", th2.getClass().getSimpleName());
                            }
                            defaultAdapter.closeProfileProxy(i10, bluetoothProfile);
                            C7838q.m48501b(aVar, arrayList);
                        }

                        @Override // android.bluetooth.BluetoothProfile.ServiceListener
                        public void onServiceDisconnected(int i10) {
                            AbstractC7185ho.m43820b("BluetoothUtils", "onServiceDisconnected");
                            C7838q.m48501b(aVar, arrayList);
                        }
                    }, iM48497a);
                    return;
                }
            }
            AbstractC7185ho.m43820b("BluetoothUtils", "bluetooth service is unavailable");
            m48500a(aVar, arrayList, 2);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("BluetoothUtils", "getBondedBluetoothDevices exception: %s", th2.getClass().getSimpleName());
            m48500a(aVar, arrayList, 5);
        }
    }

    /* renamed from: a */
    private static void m48500a(a aVar, List<BluetoothInfo> list, int i10) {
        if (aVar != null) {
            try {
                Collections.sort(list);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("BluetoothUtils", "sort bluetoothInfos exception: %s", th2.getClass().getSimpleName());
            }
            aVar.mo39194a(list, i10);
        }
    }
}
