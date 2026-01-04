package com.huawei.updatesdk.p177a.p178a.p183d.p184i;

import android.car.Car;
import android.car.CarInfoManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.updatesdk.p177a.p178a.C8774a;

/* renamed from: com.huawei.updatesdk.a.a.d.i.a */
/* loaded from: classes9.dex */
public class C8787a {

    /* renamed from: a */
    private static Car f45079a = null;

    /* renamed from: b */
    private static String f45080b = null;

    /* renamed from: c */
    private static String f45081c = null;

    /* renamed from: d */
    private static boolean f45082d = false;

    /* renamed from: com.huawei.updatesdk.a.a.d.i.a$a */
    public static class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                CarInfoManager carInfoManager = (CarInfoManager) C8787a.f45079a.getCarManager("info");
                String unused = C8787a.f45081c = carInfoManager.getManufacturer();
                String unused2 = C8787a.f45080b = carInfoManager.getModel();
                C8774a.m56009b("CarInfoUtil", "car getManufacturer = " + C8787a.f45081c + "  getModel = " + C8787a.f45080b);
            } catch (Throwable th2) {
                C8774a.m56008a("CarInfoUtil", "Car not connected in onServiceConnected" + th2.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C8774a.m56009b("CarInfoUtil", "onServiceDisconnected");
        }
    }

    /* renamed from: d */
    public static String m56077d() {
        return f45081c;
    }

    /* renamed from: e */
    public static String m56078e() {
        return f45080b;
    }

    /* renamed from: a */
    private static void m56072a(Context context) {
        if (context == null || f45082d) {
            return;
        }
        try {
            f45082d = true;
            Car carCreateCar = Car.createCar(context.getApplicationContext(), new a());
            f45079a = carCreateCar;
            if (carCreateCar != null) {
                carCreateCar.connect();
            }
        } catch (Throwable th2) {
            C8774a.m56008a("CarInfoUtil", "Car Service Connect Error" + th2.getMessage());
        }
    }

    /* renamed from: b */
    public static void m56075b(Context context) {
        m56072a(context);
    }
}
