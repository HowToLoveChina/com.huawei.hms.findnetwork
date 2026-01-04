package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* renamed from: com.huawei.openalliance.ad.ro */
/* loaded from: classes8.dex */
public class C7639ro implements SensorEventListener {

    /* renamed from: a */
    private SensorManager f35579a;

    /* renamed from: b */
    private Sensor f35580b;

    /* renamed from: c */
    private a f35581c;

    /* renamed from: com.huawei.openalliance.ad.ro$a */
    public interface a {
        /* renamed from: a */
        void mo47106a(float f10, float f11, float f12);
    }

    public C7639ro(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f35579a = sensorManager;
        this.f35580b = sensorManager.getDefaultSensor(1);
    }

    /* renamed from: a */
    public void m47103a() {
        Sensor sensor = this.f35580b;
        if (sensor != null) {
            try {
                this.f35579a.registerListener(this, sensor, 2);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("PhoneAccelerometerDetec", "registerListener exception: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: b */
    public void m47105b() {
        try {
            this.f35579a.unregisterListener(this, this.f35580b);
            this.f35581c = null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PhoneAccelerometerDetec", "unregister err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (1 == sensorEvent.sensor.getType()) {
            float[] fArr = sensorEvent.values;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PhoneAccelerometerDetec", "onSensorChanged x: %s, y: %s, z: %s", Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12));
            }
            a aVar = this.f35581c;
            if (aVar != null) {
                aVar.mo47106a(f10, f11, f12);
            }
        }
    }

    /* renamed from: a */
    public void m47104a(a aVar) {
        this.f35581c = aVar;
    }
}
