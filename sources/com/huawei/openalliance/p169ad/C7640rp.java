package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* renamed from: com.huawei.openalliance.ad.rp */
/* loaded from: classes8.dex */
public class C7640rp implements SensorEventListener {

    /* renamed from: a */
    private SensorManager f35582a;

    /* renamed from: b */
    private Sensor f35583b;

    /* renamed from: c */
    private a f35584c;

    /* renamed from: d */
    private final float[] f35585d;

    /* renamed from: e */
    private float[] f35586e = new float[3];

    /* renamed from: com.huawei.openalliance.ad.rp$a */
    public interface a {
        /* renamed from: a */
        void mo47110a(double d10, double d11, double d12);
    }

    public C7640rp(Context context) {
        float[] fArr = new float[16];
        this.f35585d = fArr;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f35582a = sensorManager;
        this.f35583b = sensorManager.getDefaultSensor(15);
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        fArr[8] = 1.0f;
        fArr[12] = 1.0f;
    }

    /* renamed from: a */
    public void m47107a() {
        try {
            this.f35582a.registerListener(this, this.f35583b, 3);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("RotateDetector", "registerListener exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public void m47109b() {
        try {
            this.f35582a.unregisterListener(this, this.f35583b);
            this.f35584c = null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("RotateDetector", "unregister err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 15) {
            SensorManager.getRotationMatrixFromVector(this.f35585d, sensorEvent.values);
            SensorManager.getOrientation(this.f35585d, this.f35586e);
            double degrees = Math.toDegrees(this.f35586e[0]);
            double degrees2 = Math.toDegrees(this.f35586e[1]);
            double degrees3 = Math.toDegrees(this.f35586e[2]);
            a aVar = this.f35584c;
            if (aVar != null) {
                aVar.mo47110a(degrees2, degrees3, degrees);
            }
        }
    }

    /* renamed from: a */
    public void m47108a(a aVar) {
        this.f35584c = aVar;
    }
}
