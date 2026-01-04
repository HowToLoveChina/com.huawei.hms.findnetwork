package at;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;
import com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput;
import com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput;
import com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import p531or.C11991a;

/* renamed from: at.d */
/* loaded from: classes8.dex */
public final class C1024d {

    /* renamed from: e */
    public HandlerThread f5076e;

    /* renamed from: f */
    public Handler f5077f;

    /* renamed from: g */
    public SensorManager f5078g;

    /* renamed from: a */
    public final Object f5072a = new Object();

    /* renamed from: b */
    public TreeMap f5073b = new TreeMap();

    /* renamed from: c */
    public TreeMap f5074c = new TreeMap();

    /* renamed from: d */
    public TreeMap f5075d = new TreeMap();

    /* renamed from: h */
    public SensorEventListener f5079h = new a();

    /* renamed from: at.d$a */
    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            C1024d.this.m6212d(sensorEvent);
        }
    }

    public C1024d() {
        m6211c();
    }

    /* renamed from: a */
    public final void m6209a() {
        SensorManager sensorManager = this.f5078g;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f5079h);
        }
        HandlerThread handlerThread = this.f5076e;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.f5077f = null;
    }

    /* renamed from: b */
    public final MotionSensors m6210b(long j10, long j11) {
        synchronized (this.f5072a) {
            try {
                if (this.f5073b.isEmpty() && this.f5074c.isEmpty() && this.f5075d.isEmpty()) {
                    C1016d.m6186f("SensorProvider", "sensor info is not ready!");
                    return null;
                }
                if (j10 > j11) {
                    C1016d.m6183c("SensorProvider", "TimeStamp input illegal.");
                    return null;
                }
                SensorAccInput[] sensorAccInputArr = (SensorAccInput[]) this.f5073b.subMap(Long.valueOf(j10), false, Long.valueOf(j11), true).values().toArray(new SensorAccInput[0]);
                SensorGyroInput[] sensorGyroInputArr = (SensorGyroInput[]) this.f5074c.subMap(Long.valueOf(j10), false, Long.valueOf(j11), true).values().toArray(new SensorGyroInput[0]);
                SensorGyroUncalInput[] sensorGyroUncalInputArr = (SensorGyroUncalInput[]) this.f5075d.subMap(Long.valueOf(j10), false, Long.valueOf(j11), true).values().toArray(new SensorGyroUncalInput[0]);
                C1016d.m6186f("SensorProvider", "vdr sensor info acc: " + sensorAccInputArr.length + ", gyro: " + sensorGyroInputArr.length + ", uncal: " + sensorGyroUncalInputArr.length);
                return MotionSensors.Builder.aSensor().withAccInputs(sensorAccInputArr).withGyroInputs(sensorGyroInputArr).withGyroUncalInputs(sensorGyroUncalInputArr).build();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public final void m6211c() {
        HandlerThread handlerThread = new HandlerThread("Loc-Vdr-sensor");
        this.f5076e = handlerThread;
        handlerThread.start();
        this.f5077f = new Handler(this.f5076e.getLooper());
        Object systemService = C11991a.m72145a().getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.f5078g = sensorManager;
            sensorManager.registerListener(this.f5079h, sensorManager.getDefaultSensor(1), 10000, this.f5077f);
            SensorManager sensorManager2 = this.f5078g;
            sensorManager2.registerListener(this.f5079h, sensorManager2.getDefaultSensor(4), 10000, this.f5077f);
            SensorManager sensorManager3 = this.f5078g;
            sensorManager3.registerListener(this.f5079h, sensorManager3.getDefaultSensor(16), 10000, this.f5077f);
        }
        C1016d.m6186f("SensorProvider", "RegisterSensor success.");
    }

    /* renamed from: d */
    public final void m6212d(SensorEvent sensorEvent) {
        TreeMap treeMap;
        Long lValueOf;
        Object objBuild;
        synchronized (this.f5072a) {
            try {
                int type = sensorEvent.sensor.getType();
                float[] fArr = sensorEvent.values;
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                if (type != 1) {
                    if (type != 4) {
                        if (type != 16) {
                        }
                        if (fArr.length < 6) {
                            return;
                        }
                        if (this.f5075d.size() > 1000) {
                            TreeMap treeMap2 = this.f5075d;
                            treeMap2.remove(treeMap2.firstKey());
                        }
                        treeMap = this.f5075d;
                        lValueOf = Long.valueOf(jElapsedRealtimeNanos);
                        objBuild = SensorGyroUncalInput.Builder.aSensorGyroUncalInput().withUgx(fArr[0]).withUgy(fArr[1]).withUgz(fArr[2]).withBiasx(fArr[3]).withBiasy(fArr[4]).withBiasz(fArr[5]).withBt(TimeUnit.NANOSECONDS.toMillis(jElapsedRealtimeNanos)).build();
                    } else {
                        if (fArr.length < 3) {
                            return;
                        }
                        if (this.f5074c.size() > 1000) {
                            TreeMap treeMap3 = this.f5074c;
                            treeMap3.remove(treeMap3.firstKey());
                        }
                        treeMap = this.f5074c;
                        lValueOf = Long.valueOf(jElapsedRealtimeNanos);
                        objBuild = SensorGyroInput.Builder.aSensorGyroInput().withGx(fArr[0]).withGy(fArr[1]).withGz(fArr[2]).withBootTime(TimeUnit.NANOSECONDS.toMillis(jElapsedRealtimeNanos)).build();
                    }
                } else {
                    if (fArr.length < 3) {
                        return;
                    }
                    if (this.f5073b.size() > 1000) {
                        TreeMap treeMap4 = this.f5073b;
                        treeMap4.remove(treeMap4.firstKey());
                    }
                    treeMap = this.f5073b;
                    lValueOf = Long.valueOf(jElapsedRealtimeNanos);
                    objBuild = SensorAccInput.Builder.aSensorAccInput().withAx(fArr[0]).withAy(fArr[1]).withAz(fArr[2]).withBootTime(TimeUnit.NANOSECONDS.toMillis(jElapsedRealtimeNanos)).build();
                }
                treeMap.put(lValueOf, objBuild);
            } finally {
            }
        }
    }
}
