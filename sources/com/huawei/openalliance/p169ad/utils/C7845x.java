package com.huawei.openalliance.p169ad.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.system.Os;
import android.system.StructTimespec;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C6985cb;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7483mr;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.constant.SystemProperties;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.utils.C7745as;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* renamed from: com.huawei.openalliance.ad.utils.x */
/* loaded from: classes2.dex */
public class C7845x {

    /* renamed from: com.huawei.openalliance.ad.utils.x$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36159a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36160b;

        public AnonymousClass1(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48604t(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$10 */
    public static class AnonymousClass10 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SensorManager f36161a;

        /* renamed from: b */
        final /* synthetic */ b f36162b;

        public AnonymousClass10(SensorManager sensorManager, b bVar) {
            sensorManager = sensorManager;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sensorManager.unregisterListener(bVar);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$11 */
    public static class AnonymousClass11 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36163a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36164b;

        public AnonymousClass11(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48523E(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$12 */
    public static class AnonymousClass12 implements Runnable {
        public AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48551d(c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$13 */
    public static class AnonymousClass13 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36166a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36167b;

        public AnonymousClass13(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48524F(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$14 */
    public static class AnonymousClass14 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36168a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36169b;

        public AnonymousClass14(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48525G(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$15 */
    public static class AnonymousClass15 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36170a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36171b;

        public AnonymousClass15(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48526H(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$16 */
    public static class AnonymousClass16 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36172a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36173b;

        public AnonymousClass16(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48527I(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$17 */
    public static class AnonymousClass17 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36174a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36175b;

        public AnonymousClass17(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48528J(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$18 */
    public static class AnonymousClass18 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36176a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36177b;

        public AnonymousClass18(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri uriBuild = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/switch/query").build();
            if (!AbstractC7741ao.m47563b(context, uriBuild)) {
                AbstractC7185ho.m43823c("DeviceUtil", "provider uri invalid.");
                return;
            }
            Cursor cursorQuery = null;
            try {
                cursorQuery = context.getContentResolver().query(uriBuild, null, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    AbstractC7185ho.m43823c("DeviceUtil", "loc_tag isBaseLocationSwitch, cursor is null");
                } else {
                    try {
                        c7787cg.m47972b(Boolean.TRUE.toString().equalsIgnoreCase(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("isSwitchChecked"))));
                        cursorQuery.close();
                        return;
                    } catch (Exception unused) {
                        AbstractC7185ho.m43826d("DeviceUtil", "loc_tag isBaseLocationSwitch Exception");
                    }
                }
            } catch (Throwable th2) {
                try {
                    AbstractC7185ho.m43826d("DeviceUtil", "loc_tag isBaseLocationSwitch query error: " + th2.getClass().getSimpleName());
                    if (cursorQuery != null) {
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            c7787cg.m47972b(false);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$19 */
    public static class AnonymousClass19 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36178a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36179b;

        public AnonymousClass19(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48529K(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36180a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36181b;

        public AnonymousClass2(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48616z(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$20 */
    public static class AnonymousClass20 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36182a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36183b;

        public AnonymousClass20(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48530L(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$21 */
    public static class AnonymousClass21 implements Runnable {
        public AnonymousClass21() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48556e(c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$22 */
    public static class AnonymousClass22 implements Runnable {
        public AnonymousClass22() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            C7845x.m48561f(c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$23 */
    public static class AnonymousClass23 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36186a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36187b;

        public AnonymousClass23(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48608u(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$24 */
    public static class AnonymousClass24 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36188a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36189b;

        public AnonymousClass24(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48611v(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$25 */
    public static class AnonymousClass25 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36190a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36191b;

        public AnonymousClass25(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48613w(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$26 */
    public static class AnonymousClass26 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36192a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36193b;

        public AnonymousClass26(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48614x(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$27 */
    public static class AnonymousClass27 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36194a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36195b;

        public AnonymousClass27(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48615y(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$3 */
    public static class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36196a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36197b;

        public AnonymousClass3(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48519A(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$4 */
    public static class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SensorManager f36198a;

        /* renamed from: b */
        final /* synthetic */ b f36199b;

        public AnonymousClass4(SensorManager sensorManager, b bVar) {
            sensorManager = sensorManager;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sensorManager.unregisterListener(bVar);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$5 */
    public static class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36200a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36201b;

        public AnonymousClass5(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48520B(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$6 */
    public static class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SensorManager f36202a;

        /* renamed from: b */
        final /* synthetic */ b f36203b;

        public AnonymousClass6(SensorManager sensorManager, b bVar) {
            sensorManager = sensorManager;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sensorManager.unregisterListener(bVar);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$7 */
    public static class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36204a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36205b;

        public AnonymousClass7(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48521C(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$8 */
    public static class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SensorManager f36206a;

        /* renamed from: b */
        final /* synthetic */ b f36207b;

        public AnonymousClass8(SensorManager sensorManager, b bVar) {
            sensorManager = sensorManager;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sensorManager.unregisterListener(bVar);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$9 */
    public static class AnonymousClass9 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f36208a;

        /* renamed from: b */
        final /* synthetic */ C7787cg f36209b;

        public AnonymousClass9(Context context, C7787cg c7787cg) {
            context = context;
            c7787cg = c7787cg;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7845x.m48522D(context, c7787cg);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$a */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.x$b */
    public static class b implements SensorEventListener {

        /* renamed from: a */
        private SensorManager f36210a;

        /* renamed from: b */
        private C7787cg f36211b;

        public b(SensorManager sensorManager, C7787cg c7787cg) {
            this.f36210a = sensorManager;
            this.f36211b = c7787cg;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 4) {
                float[] fArr = sensorEvent.values;
                this.f36211b.m48019t(AbstractC7806cz.m48153a(Float.valueOf(fArr[0])) + "," + AbstractC7806cz.m48153a(Float.valueOf(fArr[1])) + "," + AbstractC7806cz.m48153a(Float.valueOf(fArr[2])));
                this.f36210a.unregisterListener(this);
                AbstractC7768bo.m47810a("HIADSDK_GROY_DeviceUtil");
            }
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr2 = sensorEvent.values;
                this.f36211b.m48021u(AbstractC7806cz.m48153a(Float.valueOf(fArr2[0])) + "," + AbstractC7806cz.m48153a(Float.valueOf(fArr2[1])) + "," + AbstractC7806cz.m48153a(Float.valueOf(fArr2[2])));
                this.f36210a.unregisterListener(this);
                AbstractC7768bo.m47810a("HIADSDK_ACCELER_DeviceUtil");
            }
            if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                this.f36211b.m48023v(AbstractC7806cz.m48153a(Float.valueOf(fArr3[0])) + "," + AbstractC7806cz.m48153a(Float.valueOf(fArr3[1])) + "," + AbstractC7806cz.m48153a(Float.valueOf(fArr3[2])));
                this.f36210a.unregisterListener(this);
                AbstractC7768bo.m47810a("HIADSDK_MAGNET_DeviceUtil");
            }
            if (sensorEvent.sensor.getType() == 6) {
                this.f36211b.m48025w(AbstractC7806cz.m48153a(Float.valueOf(sensorEvent.values[0])));
                this.f36210a.unregisterListener(this);
                AbstractC7768bo.m47810a("HIADSDK_BARO_DeviceUtil");
            }
        }
    }

    /* renamed from: A */
    public static String m48519A(Context context, C7787cg c7787cg) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(4);
            if (defaultSensor == null) {
                return null;
            }
            b bVar = new b(sensorManager, c7787cg);
            sensorManager.registerListener(bVar, defaultSensor, 3);
            AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.4

                /* renamed from: a */
                final /* synthetic */ SensorManager f36198a;

                /* renamed from: b */
                final /* synthetic */ b f36199b;

                public AnonymousClass4(SensorManager sensorManager2, b bVar2) {
                    sensorManager = sensorManager2;
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    sensorManager.unregisterListener(bVar);
                }
            }, 3000L);
            return c7787cg.m48024w();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DeviceUtil", "getGyroInner exception: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: B */
    public static String m48520B(Context context, C7787cg c7787cg) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                return null;
            }
            b bVar = new b(sensorManager, c7787cg);
            sensorManager.registerListener(bVar, defaultSensor, 3);
            AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.6

                /* renamed from: a */
                final /* synthetic */ SensorManager f36202a;

                /* renamed from: b */
                final /* synthetic */ b f36203b;

                public AnonymousClass6(SensorManager sensorManager2, b bVar2) {
                    sensorManager = sensorManager2;
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    sensorManager.unregisterListener(bVar);
                }
            }, 3000L);
            return c7787cg.m48026x();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DeviceUtil", "getAccelerInner exception: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: C */
    public static String m48521C(Context context, C7787cg c7787cg) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(2);
            if (defaultSensor == null) {
                return null;
            }
            b bVar = new b(sensorManager, c7787cg);
            sensorManager.registerListener(bVar, defaultSensor, 3);
            AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.8

                /* renamed from: a */
                final /* synthetic */ SensorManager f36206a;

                /* renamed from: b */
                final /* synthetic */ b f36207b;

                public AnonymousClass8(SensorManager sensorManager2, b bVar2) {
                    sensorManager = sensorManager2;
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    sensorManager.unregisterListener(bVar);
                }
            }, 3000L);
            return c7787cg.m48028y();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DeviceUtil", "getMagnetInner exception: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: D */
    public static String m48522D(Context context, C7787cg c7787cg) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(6);
            if (defaultSensor == null) {
                return null;
            }
            b bVar = new b(sensorManager, c7787cg);
            sensorManager.registerListener(bVar, defaultSensor, 3);
            AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.10

                /* renamed from: a */
                final /* synthetic */ SensorManager f36161a;

                /* renamed from: b */
                final /* synthetic */ b f36162b;

                public AnonymousClass10(SensorManager sensorManager2, b bVar2) {
                    sensorManager = sensorManager2;
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    sensorManager.unregisterListener(bVar);
                }
            }, 3000L);
            return c7787cg.m48030z();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DeviceUtil", "getBaroInner exception: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: E */
    public static String m48523E(Context context, C7787cg c7787cg) {
        SafeIntent safeIntent = new SafeIntent(AbstractC7741ao.m47536a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
        int intExtra = safeIntent.getIntExtra(FaqConstants.FAQ_LEVEL, -1);
        int intExtra2 = safeIntent.getIntExtra("scale", -1);
        String strM48153a = (intExtra == -1 || intExtra2 == -1) ? Constants.NOT_FOUND : AbstractC7806cz.m48153a(Integer.valueOf((int) ((intExtra / intExtra2) * 100.0f)));
        c7787cg.m48027x(strM48153a);
        return strM48153a;
    }

    /* renamed from: F */
    public static String m48524F(Context context, C7787cg c7787cg) {
        int intExtra = new SafeIntent(AbstractC7741ao.m47536a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))).getIntExtra("status", 1);
        String strM48153a = intExtra == 1 ? Constants.NOT_FOUND : AbstractC7806cz.m48153a(Integer.valueOf(intExtra));
        c7787cg.m48029y(strM48153a);
        return strM48153a;
    }

    /* renamed from: G */
    public static boolean m48525G(Context context, C7787cg c7787cg) {
        String property = System.getProperty("http.proxyPort");
        String property2 = System.getProperty("http.proxyHost");
        if (property == null) {
            property = "-1";
        }
        boolean z10 = (TextUtils.isEmpty(property2) || Integer.parseInt(property) == -1) ? false : true;
        c7787cg.m47974c(Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: H */
    public static boolean m48526H(Context context, C7787cg c7787cg) {
        boolean z10 = Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        c7787cg.m47978d(Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: I */
    public static boolean m48527I(Context context, C7787cg c7787cg) {
        SafeIntent safeIntent = new SafeIntent(AbstractC7741ao.m47536a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
        int intExtra = safeIntent.getIntExtra("status", -1);
        boolean z10 = (intExtra == 2 || intExtra == 5) && (safeIntent.getIntExtra("plugged", -1) == 2);
        c7787cg.m47982e(Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: J */
    public static boolean m48528J(Context context, C7787cg c7787cg) {
        boolean z10;
        int i10;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        arrayList.add("/system/lib/libc_malloc_debug_qemu.so");
        arrayList.add("/sys/qemu_trace");
        arrayList.add("/system/bin/qemu-props");
        arrayList.add("/dev/socket/genyd");
        arrayList.add("/dev/socket/baseband_genyd");
        arrayList.add("/dev/socket/qemud");
        arrayList.add("/dev/qemu_pipe");
        Iterator it = arrayList.iterator();
        while (true) {
            z10 = true;
            if (!it.hasNext()) {
                z11 = false;
                break;
            }
            if (new File((String) it.next()).exists()) {
                z11 = true;
                break;
            }
        }
        String strMo43053aa = C7124fh.m43316b(context).mo43053aa();
        if (TextUtils.isEmpty(strMo43053aa)) {
            z10 = z11;
        } else {
            for (String str : strMo43053aa.split(",")) {
                if (new File(str).exists()) {
                    break;
                }
            }
            z10 = z11;
        }
        c7787cg.m47986f(Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: K */
    public static Boolean m48529K(Context context, C7787cg c7787cg) {
        boolean zM48419a = C7830i.m48419a(context, Constants.WELINK_PKG_NAME);
        c7787cg.m47988f(zM48419a);
        return Boolean.valueOf(zM48419a);
    }

    /* renamed from: L */
    public static Boolean m48530L(Context context, C7787cg c7787cg) {
        try {
            CallResult callResultM45853a = C7483mr.m45852a(context).m45853a(RTCMethods.QUERY_CHILD_MODE, "", String.class);
            if (callResultM45853a != null && 200 == callResultM45853a.getCode()) {
                AbstractC7185ho.m43820b("DeviceUtil", "query child mode success");
                String str = (String) callResultM45853a.getData();
                if (AbstractC7806cz.m48165b(str)) {
                    return Boolean.FALSE;
                }
                boolean z10 = Boolean.parseBoolean(str);
                c7787cg.m47991g(z10);
                return Boolean.valueOf(z10);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DeviceUtil", "query child mode err: %s", th2.getClass().getSimpleName());
        }
        return Boolean.FALSE;
    }

    /* renamed from: a */
    public static String m48531a() {
        return AbstractC7811dd.m48289a(SystemUtils.PRODUCT_BRAND);
    }

    /* renamed from: b */
    public static String m48538b() {
        String strM48289a = AbstractC7811dd.m48289a("ro.product.model");
        return TextUtils.isEmpty(strM48289a) ? Build.MODEL : strM48289a;
    }

    /* renamed from: c */
    public static Integer m48543c(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48010p = c7787cgM47900a.m48010p();
        if (TextUtils.isEmpty(strM48010p)) {
            strM48010p = m48556e(c7787cgM47900a);
        } else if (TextUtils.equals(Constants.NOT_FOUND, strM48010p)) {
            if (AbstractC7815dh.m48359a("getCpuCoreCnt", i10)) {
                AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.21
                    public AnonymousClass21() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7845x.m48556e(c7787cg);
                    }
                });
            }
            strM48010p = null;
        }
        return AbstractC7806cz.m48178h(strM48010p);
    }

    /* renamed from: d */
    public static String m48548d(Context context) {
        return AbstractC7806cz.m48183l(C6982bz.m41148a(context).mo41184m() ? C7124fh.m43316b(context).mo43382bI() : new CountryCodeBean(context).m39390a());
    }

    /* renamed from: e */
    public static Long m48553e(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48014r = c7787cgM47900a.m48014r();
        if (TextUtils.isEmpty(strM48014r)) {
            strM48014r = m48608u(context, c7787cgM47900a);
        } else if (TextUtils.equals(Constants.NOT_FOUND, strM48014r)) {
            if (AbstractC7815dh.m48359a("getTotalMem", i10)) {
                AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.23

                    /* renamed from: a */
                    final /* synthetic */ Context f36186a;

                    /* renamed from: b */
                    final /* synthetic */ C7787cg f36187b;

                    public AnonymousClass23(Context context2, C7787cg c7787cgM47900a2) {
                        context = context2;
                        c7787cg = c7787cgM47900a2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7845x.m48608u(context, c7787cg);
                    }
                });
            }
            strM48014r = null;
        }
        return AbstractC7806cz.m48180i(strM48014r);
    }

    /* renamed from: f */
    public static Long m48558f(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48016s = c7787cgM47900a.m48016s();
        if (TextUtils.isEmpty(strM48016s)) {
            strM48016s = m48611v(context, c7787cgM47900a);
        } else if (TextUtils.equals(Constants.NOT_FOUND, strM48016s)) {
            if (AbstractC7815dh.m48359a("getTotalSto", i10)) {
                AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.24

                    /* renamed from: a */
                    final /* synthetic */ Context f36188a;

                    /* renamed from: b */
                    final /* synthetic */ C7787cg f36189b;

                    public AnonymousClass24(Context context2, C7787cg c7787cgM47900a2) {
                        context = context2;
                        c7787cg = c7787cgM47900a2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7845x.m48611v(context, c7787cg);
                    }
                });
            }
            strM48016s = null;
        }
        return AbstractC7806cz.m48180i(strM48016s);
    }

    /* renamed from: g */
    private static long m48563g() {
        try {
            if (FaqConstants.DISABLE_HA_REPORT.equals(AbstractC7811dd.m48289a(SystemProperties.VICKY_DEMO_6))) {
                return 6442450944L;
            }
            Class<?> cls = Class.forName("com.huawei.android.util.SystemInfo");
            return Long.parseLong((String) cls.getMethod("getDeviceRam", new Class[0]).invoke(cls, new Object[0])) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d("DeviceUtil", "getDeviceRamForHw: %s", th2.getClass().getSimpleName());
            return 0L;
        }
    }

    /* renamed from: h */
    private static long m48567h() {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Object th2;
        Reader inputStreamReader;
        File file;
        String line;
        long j10 = 0;
        try {
            file = new File("/proc/meminfo");
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            bufferedReader = null;
        }
        if (!file.exists()) {
            AbstractC7805cy.m48142a((Closeable) null);
            AbstractC7805cy.m48142a((Closeable) null);
            AbstractC7805cy.m48142a((Closeable) null);
            return 0L;
        }
        fileInputStream = new FileInputStream(file);
        try {
            inputStreamReader = new InputStreamReader(fileInputStream, Constants.UTF_8);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Throwable th4) {
                bufferedReader = null;
                th2 = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            th2 = th;
            inputStreamReader = bufferedReader;
            try {
                AbstractC7185ho.m43827d("DeviceUtil", "getDeviceRamNative: %s", th2.getClass().getSimpleName());
                return j10;
            } finally {
                AbstractC7805cy.m48142a(bufferedReader);
                AbstractC7805cy.m48142a(inputStreamReader);
                AbstractC7805cy.m48142a((Closeable) fileInputStream);
            }
        }
        try {
            line = bufferedReader.readLine();
        } catch (Throwable th6) {
            th2 = th6;
            AbstractC7185ho.m43827d("DeviceUtil", "getDeviceRamNative: %s", th2.getClass().getSimpleName());
            return j10;
        }
        if (AbstractC7806cz.m48165b(line)) {
            return 0L;
        }
        String[] strArrSplit = line.split("\\s+");
        if (strArrSplit.length < 2) {
            return 0L;
        }
        j10 = Long.parseLong(strArrSplit[1]) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        return j10;
    }

    /* renamed from: i */
    public static Context m48571i(Context context) {
        return m48552d() ? context.createDeviceProtectedStorageContext() : context;
    }

    /* renamed from: j */
    public static String m48574j(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48022v = c7787cgM47900a.m48022v();
        if (TextUtils.isEmpty(strM48022v)) {
            return m48616z(context, c7787cgM47900a);
        }
        if (!TextUtils.equals(Constants.NOT_FOUND, strM48022v)) {
            return strM48022v;
        }
        if (AbstractC7815dh.m48359a("getVendCountry", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.2

                /* renamed from: a */
                final /* synthetic */ Context f36180a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36181b;

                public AnonymousClass2(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48616z(context, c7787cg);
                }
            });
        }
        return null;
    }

    /* renamed from: k */
    public static int m48577k(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a.m47922F() != null) {
            return c7787cgM47900a.m47922F().intValue();
        }
        int iM48518c = C7844w.m48512a(context).m48518c();
        c7787cgM47900a.m47949a(iM48518c);
        return iM48518c;
    }

    /* renamed from: l */
    public static String m48580l(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48026x = c7787cgM47900a.m48026x();
        if (TextUtils.isEmpty(strM48026x)) {
            strM48026x = m48520B(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48359a("getAcceler", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.5

                /* renamed from: a */
                final /* synthetic */ Context f36200a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36201b;

                public AnonymousClass5(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48520B(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM48026x)) {
            return null;
        }
        return strM48026x;
    }

    /* renamed from: m */
    public static String m48583m(Context context) {
        String strMo41177f = C6982bz.m41148a(context).mo41177f();
        AbstractC7185ho.m43821b("DeviceUtil", "getHMVerion, ver= %s", strMo41177f);
        if (TextUtils.isEmpty(strMo41177f)) {
            return null;
        }
        return strMo41177f;
    }

    /* renamed from: n */
    public static String m48586n(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48030z = c7787cgM47900a.m48030z();
        if (TextUtils.isEmpty(strM48030z)) {
            strM48030z = m48522D(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48359a("getBaro", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.9

                /* renamed from: a */
                final /* synthetic */ Context f36208a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36209b;

                public AnonymousClass9(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48522D(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM48030z)) {
            return null;
        }
        return strM48030z;
    }

    /* renamed from: o */
    public static Integer m48589o(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47912A = c7787cgM47900a.m47912A();
        if (TextUtils.isEmpty(strM47912A)) {
            strM47912A = m48523E(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48359a("getBattery", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.11

                /* renamed from: a */
                final /* synthetic */ Context f36163a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36164b;

                public AnonymousClass11(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48523E(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47912A)) {
            strM47912A = null;
        }
        return AbstractC7806cz.m48178h(strM47912A);
    }

    /* renamed from: p */
    public static Integer m48592p(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47914B = c7787cgM47900a.m47914B();
        if (TextUtils.isEmpty(strM47914B)) {
            strM47914B = m48524F(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48359a("getCharging", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.13

                /* renamed from: a */
                final /* synthetic */ Context f36166a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36167b;

                public AnonymousClass13(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48524F(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47914B)) {
            strM47914B = null;
        }
        return AbstractC7806cz.m48178h(strM47914B);
    }

    /* renamed from: q */
    public static boolean m48595q(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return C6985cb.m41166a(context).mo41207d();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DeviceUtil", "isFoldablePhone exception: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: s */
    public static int m48601s(Context context) {
        return ((float) AbstractC7807d.m48233e(context)) / ((float) AbstractC7807d.m48229d(context)) > 1.5f ? 2 : 1;
    }

    /* renamed from: t */
    public static String m48604t(Context context, C7787cg c7787cg) {
        String string = Settings.Global.getString(context.getContentResolver(), "unified_device_name");
        if (TextUtils.isEmpty(string)) {
            string = AbstractC7811dd.m48289a("ro.config.marketing_name");
        }
        if (TextUtils.isEmpty(string)) {
            string = AbstractC7811dd.m48289a("ro.product.model");
        }
        if (TextUtils.isEmpty(string)) {
            string = Constants.NOT_FOUND;
        }
        c7787cg.m48001k(string);
        return string;
    }

    /* renamed from: u */
    private static long m48607u(Context context) {
        long jM48563g = C6982bz.m41154d(context) ? m48563g() : 0L;
        return jM48563g <= 0 ? m48567h() : jM48563g;
    }

    /* renamed from: v */
    private static long m48610v(Context context) {
        String strM48136f = AbstractC7803cw.m48136f(context);
        if (TextUtils.isEmpty(strM48136f)) {
            return 0L;
        }
        return AbstractC7731ae.m47463d(strM48136f).longValue();
    }

    /* renamed from: w */
    public static String m48613w(Context context, C7787cg c7787cg) {
        String strM48136f = AbstractC7803cw.m48136f(context);
        String strM48153a = !TextUtils.isEmpty(strM48136f) ? AbstractC7806cz.m48153a(AbstractC7731ae.m47459c(strM48136f)) : null;
        if (TextUtils.isEmpty(strM48153a)) {
            strM48153a = Constants.NOT_FOUND;
        }
        c7787cg.m48013q(strM48153a);
        return strM48153a;
    }

    /* renamed from: x */
    public static String m48614x(Context context, C7787cg c7787cg) {
        String strM48137g = AbstractC7803cw.m48137g(context);
        String strM48153a = !TextUtils.isEmpty(strM48137g) ? AbstractC7806cz.m48153a(AbstractC7731ae.m47459c(strM48137g)) : null;
        if (TextUtils.isEmpty(strM48153a)) {
            strM48153a = Constants.NOT_FOUND;
        }
        c7787cg.m47929I(strM48153a);
        return strM48153a;
    }

    /* renamed from: y */
    public static String m48615y(Context context, C7787cg c7787cg) {
        String strM48183l = AbstractC7806cz.m48183l(C6982bz.m41148a(context).mo41187p());
        if (TextUtils.isEmpty(strM48183l)) {
            strM48183l = Constants.NOT_FOUND;
        }
        c7787cg.m48015r(strM48183l);
        return strM48183l;
    }

    /* renamed from: z */
    public static String m48616z(Context context, C7787cg c7787cg) {
        String strM48183l = AbstractC7806cz.m48183l(C6982bz.m41148a(context).mo41188q());
        if (TextUtils.isEmpty(strM48183l)) {
            strM48183l = Constants.NOT_FOUND;
        }
        c7787cg.m48017s(strM48183l);
        return strM48183l;
    }

    /* renamed from: a */
    public static String m48532a(Context context) {
        return AbstractC7801cu.m48126a(C6982bz.m41148a(context).mo41173b() + AbstractC7807d.m48241h(context));
    }

    /* renamed from: b */
    public static String m48539b(Context context) {
        return AbstractC7731ae.m47454b(m48607u(context));
    }

    /* renamed from: c */
    public static String m48544c(Context context) {
        return AbstractC7731ae.m47460c(m48610v(context));
    }

    /* renamed from: d */
    public static String m48549d(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48012q = c7787cgM47900a.m48012q();
        if (TextUtils.isEmpty(strM48012q)) {
            return m48561f(c7787cgM47900a);
        }
        if (!TextUtils.equals(Constants.NOT_FOUND, strM48012q)) {
            return strM48012q;
        }
        if (AbstractC7815dh.m48359a("getCpuSpeed", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.22
                public AnonymousClass22() {
                }

                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    C7845x.m48561f(c7787cg);
                }
            });
        }
        return null;
    }

    /* renamed from: e */
    public static String m48554e() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Object th2;
        FileInputStream fileInputStream;
        String strTrim = "";
        try {
            fileInputStream = new FileInputStream("/proc/sys/kernel/random/boot_id");
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, Constants.UTF_8);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String line = bufferedReader.readLine();
                        if (!TextUtils.isEmpty(line)) {
                            strTrim = line.trim();
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            AbstractC7185ho.m43827d("DeviceUtil", "get boot mark exception: %s", th2.getClass().getSimpleName());
                            return strTrim;
                        } finally {
                            AbstractC7805cy.m48142a(bufferedReader);
                            AbstractC7805cy.m48142a(inputStreamReader);
                            AbstractC7805cy.m48142a((Closeable) fileInputStream);
                        }
                    }
                } catch (Throwable th4) {
                    bufferedReader = null;
                    th2 = th4;
                }
            } catch (Throwable th5) {
                bufferedReader = null;
                th2 = th5;
                inputStreamReader = null;
            }
        } catch (Throwable th6) {
            inputStreamReader = null;
            bufferedReader = null;
            th2 = th6;
            fileInputStream = null;
        }
        return strTrim;
    }

    /* renamed from: f */
    public static String m48559f() {
        try {
            StructTimespec structTimespec = Os.stat("/data/data").st_atim;
            long j10 = structTimespec.tv_nsec;
            return structTimespec.tv_sec + "." + j10;
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d("DeviceUtil", "get update mark exception: %s", th2.getClass().getSimpleName());
            return "";
        }
    }

    /* renamed from: g */
    public static Long m48564g(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48018t = c7787cgM47900a.m48018t();
        if (TextUtils.isEmpty(strM48018t)) {
            strM48018t = m48613w(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48359a("getFreeSto", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.25

                /* renamed from: a */
                final /* synthetic */ Context f36190a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36191b;

                public AnonymousClass25(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48613w(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM48018t)) {
            strM48018t = null;
        }
        return AbstractC7806cz.m48180i(strM48018t);
    }

    /* renamed from: h */
    public static Long m48568h(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47946Y = c7787cgM47900a.m47946Y();
        if (TextUtils.isEmpty(strM47946Y)) {
            strM47946Y = m48614x(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48359a("getFreeSdcard", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.26

                /* renamed from: a */
                final /* synthetic */ Context f36192a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36193b;

                public AnonymousClass26(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48614x(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM47946Y)) {
            strM47946Y = null;
        }
        return AbstractC7806cz.m48180i(strM47946Y);
    }

    /* renamed from: i */
    public static String m48572i(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48020u = c7787cgM47900a.m48020u();
        if (TextUtils.isEmpty(strM48020u)) {
            return m48615y(context, c7787cgM47900a);
        }
        if (!TextUtils.equals(Constants.NOT_FOUND, strM48020u)) {
            return strM48020u;
        }
        if (AbstractC7815dh.m48359a("getVendor", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.27

                /* renamed from: a */
                final /* synthetic */ Context f36194a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36195b;

                public AnonymousClass27(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48615y(context, c7787cg);
                }
            });
        }
        return null;
    }

    /* renamed from: k */
    public static String m48578k(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48024w = c7787cgM47900a.m48024w();
        if (TextUtils.isEmpty(strM48024w)) {
            strM48024w = m48519A(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48359a("getGyro", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.3

                /* renamed from: a */
                final /* synthetic */ Context f36196a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36197b;

                public AnonymousClass3(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48519A(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM48024w)) {
            return null;
        }
        return strM48024w;
    }

    /* renamed from: m */
    public static String m48584m(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48028y = c7787cgM47900a.m48028y();
        if (TextUtils.isEmpty(strM48028y)) {
            strM48028y = m48521C(context, c7787cgM47900a);
        } else if (AbstractC7815dh.m48359a("getMagnet", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.7

                /* renamed from: a */
                final /* synthetic */ Context f36204a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36205b;

                public AnonymousClass7(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48521C(context, c7787cg);
                }
            });
        }
        if (TextUtils.equals(Constants.NOT_FOUND, strM48028y)) {
            return null;
        }
        return strM48028y;
    }

    /* renamed from: n */
    public static boolean m48587n(Context context) {
        return "1".equalsIgnoreCase(C7844w.m48512a(context).m48516a());
    }

    /* renamed from: o */
    public static boolean m48590o(Context context) {
        return "0".equalsIgnoreCase(C7844w.m48512a(context).m48516a());
    }

    /* renamed from: p */
    public static boolean m48593p(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return C6985cb.m41166a(context).mo41210g();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DeviceUtil", "isEinkDevice exception: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: q */
    public static boolean m48596q(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a.m47936O() == null) {
            return m48525G(context, c7787cgM47900a);
        }
        boolean zBooleanValue = c7787cgM47900a.m47936O().booleanValue();
        if (AbstractC7815dh.m48359a("getProxy", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.14

                /* renamed from: a */
                final /* synthetic */ Context f36168a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36169b;

                public AnonymousClass14(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48525G(context, c7787cg);
                }
            });
        }
        return zBooleanValue;
    }

    /* renamed from: r */
    public static boolean m48599r(Context context) {
        int iM48601s;
        try {
            iM48601s = C6985cb.m41166a(context).mo41206c();
        } catch (Throwable th2) {
            iM48601s = m48601s(context);
            AbstractC7185ho.m43824c("DeviceUtil", "getFoldableStatus %s", th2.getClass().getSimpleName());
        }
        return iM48601s == 1 || iM48601s == 7;
    }

    /* renamed from: t */
    public static boolean m48605t(Context context) {
        String strM48516a = C7844w.m48512a(context).m48516a();
        AbstractC7185ho.m43817a("DeviceUtil", "deviceType: " + strM48516a);
        return "4".equalsIgnoreCase(strM48516a) || "5".equalsIgnoreCase(strM48516a);
    }

    /* renamed from: u */
    public static String m48608u(Context context, C7787cg c7787cg) {
        long jM48607u = m48607u(context);
        String string = jM48607u > 0 ? Long.toString(jM48607u) : Constants.NOT_FOUND;
        c7787cg.m48009o(string);
        return string;
    }

    /* renamed from: v */
    public static String m48611v(Context context, C7787cg c7787cg) {
        String strM48153a = AbstractC7806cz.m48153a(Long.valueOf(m48610v(context)));
        if (TextUtils.isEmpty(strM48153a)) {
            strM48153a = Constants.NOT_FOUND;
        }
        c7787cg.m48011p(strM48153a);
        return strM48153a;
    }

    /* renamed from: a */
    public static String m48533a(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48006n = c7787cgM47900a.m48006n();
        if (TextUtils.isEmpty(strM48006n)) {
            return m48604t(context, c7787cgM47900a);
        }
        if (!TextUtils.equals(Constants.NOT_FOUND, strM48006n)) {
            return strM48006n;
        }
        if (AbstractC7815dh.m48359a("getPdtName", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.1

                /* renamed from: a */
                final /* synthetic */ Context f36159a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36160b;

                public AnonymousClass1(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48604t(context, c7787cg);
                }
            });
        }
        return null;
    }

    /* renamed from: b */
    public static String m48540b(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM48008o = c7787cgM47900a.m48008o();
        if (TextUtils.isEmpty(strM48008o)) {
            return m48551d(c7787cgM47900a);
        }
        if (!TextUtils.equals(Constants.NOT_FOUND, strM48008o)) {
            return strM48008o;
        }
        if (AbstractC7815dh.m48359a("getCpuModel", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.12
                public AnonymousClass12() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48551d(c7787cg);
                }
            });
        }
        return null;
    }

    /* renamed from: j */
    public static boolean m48576j(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a.m47920E() != null) {
            return c7787cgM47900a.m47920E().booleanValue();
        }
        boolean zM48517b = C7844w.m48512a(context).m48517b();
        c7787cgM47900a.m47976c(zM48517b);
        return zM48517b;
    }

    /* renamed from: l */
    public static boolean m48582l(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        boolean z10 = true;
        try {
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DeviceUtil", "getHasAccAndRotate err: %s", th2.getClass().getSimpleName());
        }
        if (c7787cgM47900a.m47933L() != null) {
            return c7787cgM47900a.m47933L().booleanValue();
        }
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(1) == null) {
            z10 = false;
        }
        c7787cgM47900a.m47968b(Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: r */
    public static boolean m48600r(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a.m47937P() == null) {
            return m48526H(context, c7787cgM47900a);
        }
        boolean zBooleanValue = c7787cgM47900a.m47937P().booleanValue();
        if (AbstractC7815dh.m48359a("getDebug", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.15

                /* renamed from: a */
                final /* synthetic */ Context f36170a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36171b;

                public AnonymousClass15(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48526H(context, c7787cg);
                }
            });
        }
        return zBooleanValue;
    }

    /* renamed from: s */
    public static boolean m48603s(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a.m47938Q() == null) {
            return m48527I(context, c7787cgM47900a);
        }
        boolean zBooleanValue = c7787cgM47900a.m47938Q().booleanValue();
        if (AbstractC7815dh.m48359a("getUSB", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.16

                /* renamed from: a */
                final /* synthetic */ Context f36172a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36173b;

                public AnonymousClass16(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48527I(context, c7787cg);
                }
            });
        }
        return zBooleanValue;
    }

    /* renamed from: t */
    public static boolean m48606t(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a.m47939R() == null) {
            return m48528J(context, c7787cgM47900a);
        }
        boolean zBooleanValue = c7787cgM47900a.m47939R().booleanValue();
        if (AbstractC7815dh.m48359a("getEmulator", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.17

                /* renamed from: a */
                final /* synthetic */ Context f36174a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36175b;

                public AnonymousClass17(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48528J(context, c7787cg);
                }
            });
        }
        return zBooleanValue;
    }

    /* renamed from: u */
    public static boolean m48609u(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a.m47961ad() == null) {
            return m48529K(context, c7787cgM47900a).booleanValue();
        }
        boolean zBooleanValue = c7787cgM47900a.m47961ad().booleanValue();
        if (AbstractC7815dh.m48359a("isWelinkUser", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.19

                /* renamed from: a */
                final /* synthetic */ Context f36178a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36179b;

                public AnonymousClass19(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48529K(context, c7787cg);
                }
            });
        }
        return zBooleanValue;
    }

    /* renamed from: v */
    public static boolean m48612v(Context context, int i10) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a.m47962ae() == null) {
            return m48530L(context, c7787cgM47900a).booleanValue();
        }
        boolean zBooleanValue = c7787cgM47900a.m47962ae().booleanValue();
        if (AbstractC7815dh.m48359a("isChildMode", i10)) {
            AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.20

                /* renamed from: a */
                final /* synthetic */ Context f36182a;

                /* renamed from: b */
                final /* synthetic */ C7787cg f36183b;

                public AnonymousClass20(Context context2, C7787cg c7787cgM47900a2) {
                    context = context2;
                    c7787cg = c7787cgM47900a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7845x.m48530L(context, c7787cg);
                }
            });
        }
        return zBooleanValue;
    }

    /* renamed from: d */
    public static String m48551d(C7787cg c7787cg) {
        String strM48289a = AbstractC7811dd.m48289a("ro.product.cpu.abi");
        if (TextUtils.isEmpty(strM48289a)) {
            strM48289a = AbstractC7811dd.m48289a("ro.product.cpu.abilist64");
        }
        if (TextUtils.isEmpty(strM48289a)) {
            strM48289a = Constants.NOT_FOUND;
        }
        c7787cg.m48003l(strM48289a);
        return strM48289a;
    }

    /* renamed from: e */
    public static String m48556e(C7787cg c7787cg) {
        String strM48153a;
        try {
            strM48153a = AbstractC7806cz.m48153a(Integer.valueOf(new File("/sys/devices/system/cpu/").listFiles(new a()).length));
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("DeviceUtil", "get CpuCoreCnt exception");
            strM48153a = null;
        }
        if (strM48153a == null) {
            strM48153a = Constants.NOT_FOUND;
        }
        c7787cg.m48005m(strM48153a);
        return strM48153a;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48561f(com.huawei.openalliance.p169ad.utils.C7787cg r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "DeviceUtil"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.io.FileNotFoundException -> L35
            java.lang.String r3 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.io.FileNotFoundException -> L35
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2b java.io.FileNotFoundException -> L2d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2b java.io.FileNotFoundException -> L2d
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L38 java.io.FileNotFoundException -> L3e
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L38 java.io.FileNotFoundException -> L3e
            if (r5 != 0) goto L21
            java.lang.String r1 = r4.trim()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L38 java.io.FileNotFoundException -> L3e
            goto L21
        L1e:
            r6 = move-exception
        L1f:
            r1 = r2
            goto L68
        L21:
            com.huawei.openalliance.p169ad.utils.AbstractC7805cy.m48142a(r2)
            com.huawei.openalliance.p169ad.utils.AbstractC7805cy.m48142a(r3)
            goto L41
        L28:
            r6 = move-exception
            r3 = r1
            goto L1f
        L2b:
            r3 = r1
            goto L38
        L2d:
            r3 = r1
            goto L3e
        L2f:
            r6 = move-exception
            r3 = r1
            goto L68
        L32:
            r2 = r1
            r3 = r2
            goto L38
        L35:
            r2 = r1
            r3 = r2
            goto L3e
        L38:
            java.lang.String r4 = "get CpuModel exception : IOException"
        L3a:
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r0, r4)     // Catch: java.lang.Throwable -> L1e
            goto L21
        L3e:
            java.lang.String r4 = "get CpuSpeed exception : FileNotFoundException"
            goto L3a
        L41:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r3 = "NOT_FOUND"
            if (r2 == 0) goto L4a
            goto L64
        L4a:
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch: java.lang.NumberFormatException -> L5f
            float r1 = r1.floatValue()     // Catch: java.lang.NumberFormatException -> L5f
            r2 = 1232348160(0x49742400, float:1000000.0)
            float r1 = r1 / r2
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch: java.lang.NumberFormatException -> L5f
            java.lang.String r3 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48153a(r1)     // Catch: java.lang.NumberFormatException -> L5f
            goto L64
        L5f:
            java.lang.String r1 = "getCpuSpeed toInteger NumberFormatException"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r0, r1)
        L64:
            r6.m48007n(r3)
            return r3
        L68:
            com.huawei.openalliance.p169ad.utils.AbstractC7805cy.m48142a(r1)
            com.huawei.openalliance.p169ad.utils.AbstractC7805cy.m48142a(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.C7845x.m48561f(com.huawei.openalliance.ad.utils.cg):java.lang.String");
    }

    /* renamed from: g */
    public static boolean m48566g(Context context) throws Settings.SettingNotFoundException {
        String str;
        if (context == null) {
            str = "loc_tag isGpsSwitchOpen Context is null";
        } else {
            try {
                int i10 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                AbstractC7185ho.m43820b("DeviceUtil", "loc_tag isGpsSwitchOpen locationMode is " + i10);
                return i10 == 3;
            } catch (Settings.SettingNotFoundException unused) {
                str = "loc_tag isGpsSwitchOpen SettingNotFoundException";
            }
        }
        AbstractC7185ho.m43826d("DeviceUtil", str);
        return false;
    }

    /* renamed from: h */
    public static boolean m48570h(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    /* renamed from: a */
    public static String m48535a(Context context, String str) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager != null) {
                return String.valueOf(packageManager.getPackageInfo(str, 128).getLongVersionCode());
            }
            return null;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("DeviceUtil", "fail to get appVerCode");
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m48547c() {
        return C7745as.a.f35839a >= 21 || C7745as.a.f35840b >= 33;
    }

    /* renamed from: d */
    public static boolean m48552d() {
        return true;
    }

    /* renamed from: e */
    public static boolean m48557e(Context context) {
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        boolean zM47917C = c7787cgM47900a.m47917C();
        m48537a(c7787cgM47900a, context);
        return zM47917C;
    }

    /* renamed from: f */
    public static boolean m48562f(Context context) {
        try {
            return m48566g(context);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("DeviceUtil", "get location service switch exception: " + th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    private static void m48537a(C7787cg c7787cg, Context context) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.x.18

            /* renamed from: a */
            final /* synthetic */ Context f36176a;

            /* renamed from: b */
            final /* synthetic */ C7787cg f36177b;

            public AnonymousClass18(Context context2, C7787cg c7787cg2) {
                context = context2;
                c7787cg = c7787cg2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Uri uriBuild = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/switch/query").build();
                if (!AbstractC7741ao.m47563b(context, uriBuild)) {
                    AbstractC7185ho.m43823c("DeviceUtil", "provider uri invalid.");
                    return;
                }
                Cursor cursorQuery = null;
                try {
                    cursorQuery = context.getContentResolver().query(uriBuild, null, null, null, null);
                    if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                        AbstractC7185ho.m43823c("DeviceUtil", "loc_tag isBaseLocationSwitch, cursor is null");
                    } else {
                        try {
                            c7787cg.m47972b(Boolean.TRUE.toString().equalsIgnoreCase(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("isSwitchChecked"))));
                            cursorQuery.close();
                            return;
                        } catch (Exception unused) {
                            AbstractC7185ho.m43826d("DeviceUtil", "loc_tag isBaseLocationSwitch Exception");
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        AbstractC7185ho.m43826d("DeviceUtil", "loc_tag isBaseLocationSwitch query error: " + th2.getClass().getSimpleName());
                        if (cursorQuery != null) {
                        }
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                c7787cg.m47972b(false);
            }
        });
    }
}
