package com.huawei.hms.findnetwork.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.os.BuildEx;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.UltrasoundSettings;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.ultrasound.entity.MeasureResult;
import com.huawei.hms.findnetwork.ultrasound.entity.UltrasoundMeasureParam;
import com.huawei.hms.findnetwork.util.CachedThreadPool;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.findnetwork.util.PermissionUtil;
import com.huawei.hms.findnetwork.util.ScheduleThreadPool;
import com.ultrasoniclibrary.ultrasoundcore.classfun.FreqParam;
import hu.C10343b;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import p268ew.C9570a;
import p299fw.C9776b;
import p299fw.C9778d;
import p348hw.C10354i;

/* renamed from: com.huawei.hms.findnetwork.sdk.p1 */
/* loaded from: classes8.dex */
public class C5389p1 {

    /* renamed from: B */
    public static volatile C5389p1 f24819B;

    /* renamed from: b */
    public byte[] f24822b;

    /* renamed from: h */
    public SensorManager f24828h;

    /* renamed from: i */
    public SensorEventListener f24829i;

    /* renamed from: j */
    public float[] f24830j;

    /* renamed from: k */
    public float[] f24831k;

    /* renamed from: q */
    public long f24837q;

    /* renamed from: r */
    public Object f24838r;

    /* renamed from: t */
    public volatile InterfaceC5383n1 f24840t;

    /* renamed from: u */
    public String f24841u;

    /* renamed from: v */
    public String f24842v;

    /* renamed from: a */
    public final AtomicInteger f24821a = new AtomicInteger(1);

    /* renamed from: c */
    public int f24823c = 0;

    /* renamed from: d */
    public long f24824d = -1;

    /* renamed from: e */
    public float f24825e = -100.0f;

    /* renamed from: f */
    public float f24826f = 0.0f;

    /* renamed from: g */
    public int f24827g = 2;

    /* renamed from: p */
    public final ReentrantLock f24836p = new ReentrantLock();

    /* renamed from: s */
    public long f24839s = -1;

    /* renamed from: w */
    public int f24843w = 0;

    /* renamed from: x */
    public int f24844x = 0;

    /* renamed from: y */
    public final AtomicReference<FreqParam> f24845y = new AtomicReference<>();

    /* renamed from: z */
    public final AtomicInteger f24846z = new AtomicInteger(0);

    /* renamed from: A */
    public final Runnable f24820A = new a();

    /* renamed from: l */
    public final CopyOnWriteArrayList<UltrasoundMeasureParam> f24832l = new CopyOnWriteArrayList<>();

    /* renamed from: m */
    public final LinkedList<float[]> f24833m = new LinkedList<>();

    /* renamed from: n */
    public final LinkedList<float[]> f24834n = new LinkedList<>();

    /* renamed from: o */
    public final LinkedList<float[]> f24835o = new LinkedList<>();

    /* renamed from: com.huawei.hms.findnetwork.sdk.p1$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C5389p1.this.f24821a.get() == 2 && C5389p1.this.f24840t != null) {
                if (C5389p1.this.f24832l.isEmpty()) {
                    HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "calculate byte array is null, continue.");
                    C5389p1.this.f24846z.getAndIncrement();
                    if (C5389p1.this.f24846z.get() >= 10) {
                        C5389p1.this.f24846z.set(0);
                        C5389p1.this.f24840t.mo32033a(-3, "can not get record block within3000ms");
                        return;
                    }
                    return;
                }
                C5389p1.this.f24846z.set(0);
                UltrasoundMeasureParam ultrasoundMeasureParam = (UltrasoundMeasureParam) C5389p1.this.f24832l.remove(0);
                HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "param beginRecordTime is: " + ultrasoundMeasureParam.getBeginRecordTime());
                HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "param mTagStatus is: " + C5389p1.this.f24823c);
                HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "param mTagId is: " + C5389p1.this.f24841u);
                HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "param mAccelerationLinkedList is: " + Arrays.toString(C5389p1.this.f24834n.toArray()));
                HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "param mOrientationFloatLinkedList is: " + Arrays.toString(C5389p1.this.f24833m.toArray()));
                HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "param mUltrasoundTxTime: " + C5389p1.this.f24824d);
                HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "param mTemperature: " + C5389p1.this.f24825e);
                HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "param mAlpha: " + C5389p1.this.f24827g);
                FreqParam freqParam = (FreqParam) C5389p1.this.f24845y.get();
                try {
                    C9778d c9778dM59722a = C9570a.m59702t().m59722a(new C9776b.a().m60829i(ultrasoundMeasureParam.getRecordByteArray()).m60831k(C5389p1.this.f24823c).m60830j(C5389p1.this.f24841u).m60822b(C5389p1.this.f24834n).m60827g(C5389p1.this.f24835o).m60828h(C5389p1.this.f24833m).m60824d(ultrasoundMeasureParam.getBeginRecordTime()).m60832l(ultrasoundMeasureParam.getUltrasoundTxTime()).m60825e(C5389p1.this.f24825e).m60823c(C5389p1.this.f24827g).m60826f(freqParam).m60821a());
                    if (c9778dM59722a == null) {
                        C5389p1.this.f24840t.mo32033a(-2, "positioning result is null");
                        return;
                    }
                    FreqParam freqParamM60838a = c9778dM59722a.m60838a();
                    if (freqParamM60838a != null) {
                        HmsFindSDKLog.m32125d("UltrasoundMeasureManager", "freqParam.action*" + freqParam.getActionFlag() + ":" + freqParamM60838a.getActionFlag());
                        if (C5389p1.this.m32090a(freqParamM60838a, freqParam)) {
                            C5389p1.this.f24840t.mo32035a(freqParamM60838a);
                            C5389p1.this.f24845y.set(freqParamM60838a);
                        } else if (freqParam.getActionFlag() == 2) {
                            freqParam.setActionFlag(freqParamM60838a.getActionFlag());
                        }
                    }
                    float[] fArr = c9778dM59722a.f48100b;
                    if (fArr == null) {
                        C5389p1.this.f24840t.mo32033a(-2, "positioning result value is null");
                        return;
                    }
                    MeasureResult measureResult = new MeasureResult(c9778dM59722a.f48099a, fArr);
                    HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "measure result is: " + measureResult);
                    C5389p1.this.f24840t.mo32034a(measureResult);
                } catch (Exception e10) {
                    HmsFindSDKLog.m32126e("UltrasoundMeasureManager", "measure result error: " + e10.getMessage());
                    C5389p1.this.f24840t.mo32033a(-2, e10.getMessage() + ", exception is:" + e10);
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.p1$b */
    public class b implements SensorEventListener {
        public b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (C5389p1.this.f24821a.get() != 2) {
                HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "ultrasound is not running.");
                return;
            }
            float[] fArr = sensorEvent.values;
            if (fArr == null || fArr.length < 3) {
                HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "get event values failed.");
                return;
            }
            C5389p1.this.f24836p.lock();
            try {
                int type = sensorEvent.sensor.getType();
                if (type == 4) {
                    if (C5389p1.this.f24835o.size() < 9) {
                        C5389p1.this.f24831k = new float[3];
                    } else {
                        C5389p1 c5389p1 = C5389p1.this;
                        c5389p1.f24831k = (float[]) c5389p1.f24835o.removeFirst();
                    }
                    System.arraycopy(sensorEvent.values, 0, C5389p1.this.f24831k, 0, C5389p1.this.f24831k.length);
                    C5389p1.this.f24835o.add(C5389p1.this.f24831k);
                } else if (type == 10) {
                    if (C5389p1.this.f24834n.size() < 9) {
                        C5389p1.this.f24831k = new float[3];
                    } else {
                        C5389p1 c5389p12 = C5389p1.this;
                        c5389p12.f24831k = (float[]) c5389p12.f24834n.removeFirst();
                    }
                    System.arraycopy(sensorEvent.values, 0, C5389p1.this.f24831k, 0, C5389p1.this.f24831k.length);
                    C5389p1.this.f24834n.add(C5389p1.this.f24831k);
                } else if (type == 11) {
                    SensorManager.getRotationMatrixFromVector(C5389p1.this.f24830j, sensorEvent.values);
                    if (C5389p1.this.f24833m.size() < 9) {
                        C5389p1.this.f24831k = new float[3];
                    } else {
                        C5389p1 c5389p13 = C5389p1.this;
                        c5389p13.f24831k = (float[]) c5389p13.f24833m.removeFirst();
                    }
                    SensorManager.getOrientation(C5389p1.this.f24830j, C5389p1.this.f24831k);
                    for (int i10 = 0; i10 < C5389p1.this.f24831k.length; i10++) {
                        C5389p1.this.f24831k[i10] = (float) Math.toDegrees(C5389p1.this.f24831k[i10]);
                    }
                    C5389p1.this.f24833m.add(C5389p1.this.f24831k);
                }
            } finally {
                C5389p1.this.f24836p.unlock();
            }
        }
    }

    /* renamed from: a */
    public final int m32082a(Context context) {
        try {
            boolean zCheckAppHavePermission = PermissionUtil.checkAppHavePermission(context, context.getPackageName(), new String[]{"com.huawei.permission.MANAGE_FOLD_SCREEN"});
            if (BuildEx.VERSION.EMUI_SDK_INT >= 19 && zCheckAppHavePermission && HwFoldScreenManagerEx.isFoldable()) {
                int foldableState = HwFoldScreenManagerEx.getFoldableState();
                if (foldableState >= 0 && foldableState <= 3) {
                    return foldableState;
                }
            }
        } catch (NoClassDefFoundError e10) {
            HmsFindSDKLog.m32126e("UltrasoundMeasureManager", "not a collapsible or buildEx phone ,error message: " + e10.getMessage());
        }
        return -1;
    }

    /* renamed from: b */
    public final void m32092b() {
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "initSensor begin.");
        b bVar = new b();
        this.f24829i = bVar;
        SensorManager sensorManager = this.f24828h;
        sensorManager.registerListener(bVar, sensorManager.getDefaultSensor(11), 2);
        SensorManager sensorManager2 = this.f24828h;
        sensorManager2.registerListener(this.f24829i, sensorManager2.getDefaultSensor(10), 2);
        SensorManager sensorManager3 = this.f24828h;
        sensorManager3.registerListener(this.f24829i, sensorManager3.getDefaultSensor(4), 2);
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "initSensor end.");
    }

    /* renamed from: c */
    public boolean m32094c() {
        return this.f24821a.get() == 2;
    }

    /* renamed from: d */
    public final void m32095d() {
        this.f24821a.set(1);
        this.f24823c = 0;
        this.f24824d = -1L;
        this.f24825e = -100.0f;
        this.f24826f = 0.0f;
        this.f24827g = 2;
        SensorManager sensorManager = this.f24828h;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f24829i);
            this.f24828h = null;
        }
        this.f24846z.set(0);
        this.f24822b = null;
        this.f24829i = null;
        this.f24832l.clear();
        this.f24833m.clear();
        this.f24834n.clear();
        this.f24835o.clear();
        this.f24839s = -1L;
        this.f24837q = 0L;
        this.f24830j = null;
        this.f24831k = null;
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "resetAllResource status is: " + this.f24821a.get());
        try {
            Object obj = this.f24838r;
            if (obj instanceof HwFoldScreenManagerEx.FoldableStateListener) {
                HwFoldScreenManagerEx.unregisterFoldableState((HwFoldScreenManagerEx.FoldableStateListener) obj);
                HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "unregister fold state listener success.");
            }
        } catch (NoClassDefFoundError | NullPointerException e10) {
            HmsFindSDKLog.m32126e("UltrasoundMeasureManager", "can not unregister fold listener, error message: " + e10.getMessage());
        }
        this.f24838r = null;
    }

    /* renamed from: e */
    public void m32096e() {
        if (this.f24821a.compareAndSet(2, 1)) {
            m32095d();
            return;
        }
        HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "stopUltrasoundMeasuring error, ultrasound state is: " + this.f24821a.get());
    }

    /* renamed from: a */
    public final int m32083a(FreqParam freqParam) {
        return freqParam.getInterval() + 50;
    }

    /* renamed from: b */
    public void m32093b(String str) {
        UltrasoundSettings ultrasoundSettings = (UltrasoundSettings) JsonUtils.json2Object(str, UltrasoundSettings.class);
        if (ultrasoundSettings == null) {
            HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "json convert failed, so return");
            return;
        }
        if (!m32094c()) {
            HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "refresh settings failed, please start measure first");
            return;
        }
        this.f24824d = ultrasoundSettings.getUltrasoundTxTime();
        this.f24823c = ultrasoundSettings.getTagStatus();
        this.f24825e = ultrasoundSettings.getTemperature();
        this.f24827g = ultrasoundSettings.getAlpha();
    }

    /* renamed from: a */
    public static C5389p1 m32060a() {
        if (f24819B == null) {
            synchronized (C5389p1.class) {
                try {
                    if (f24819B == null) {
                        f24819B = new C5389p1();
                    }
                } finally {
                }
            }
        }
        return f24819B;
    }

    /* renamed from: a */
    public final FreqParam m32084a(Context context, String str, int i10, int i11) {
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "initUltrasonicEngine:prod." + str + " seq." + i10 + " foldState." + i11);
        C9570a c9570aM59702t = C9570a.m59702t();
        if (i11 == -1) {
            i11 = 0;
        }
        return c9570aM59702t.m59745y(new C10354i(str, i10, i11), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32062a(int i10, Context context) {
        if (this.f24821a.get() != 2) {
            HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "onStateChange, ultrasound is not running.");
            return;
        }
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "onStateChange, current fold state is: " + i10);
        m32084a(context, this.f24842v, this.f24843w, i10);
    }

    /* renamed from: a */
    public void m32085a(int i10, byte[] bArr) {
        if (this.f24821a.get() != 2) {
            HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "set record block failed, ultrasound is not running.");
            return;
        }
        if (bArr.length == 0) {
            HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "block length is 0.");
            return;
        }
        long j10 = this.f24837q;
        if (j10 != 0 && j10 >= i10) {
            HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "set record block, mSerialNumber = " + this.f24837q + ", serialNumber = " + i10 + ", block sequence error");
            return;
        }
        if (this.f24832l.size() >= 20 && this.f24832l.remove(0) != null) {
            HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "reach MAX_BLOCKING_QUEUE_SIZE, remove oldest");
        }
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "serialNumber." + i10 + " block.length =" + bArr.length);
        this.f24837q = (long) i10;
        int i11 = this.f24844x;
        boolean z10 = i11 == 300;
        int length = bArr.length + ((int) ((bArr.length / 7.5f) * 2.0f));
        if (!z10) {
            length += bArr.length;
        }
        byte[] bArr2 = new byte[length];
        byte[] bArrM32091a = m32091a(bArr, z10);
        System.arraycopy(bArrM32091a, bArrM32091a.length - length, bArr2, 0, length);
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "#audioInterval= " + i11 + " targetAudio.length= " + length);
        UltrasoundMeasureParam ultrasoundMeasureParam = new UltrasoundMeasureParam();
        ultrasoundMeasureParam.setRecordByteArray(bArr2);
        long j11 = this.f24839s;
        if (j11 != -1) {
            j11 += ((this.f24837q * 300) - 80) * 1000;
            if (!z10) {
                j11 -= 300000;
            }
        }
        ultrasoundMeasureParam.setBeginRecordTime(j11);
        ultrasoundMeasureParam.setUltrasoundTxTime(this.f24824d);
        this.f24832l.add(ultrasoundMeasureParam);
        ScheduleThreadPool.getInstance().scheduleTask(this.f24820A, 0L, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public final void m32086a(final Context context, final int i10) {
        CachedThreadPool.getInstance().execSeqTask("UltrasoundMeasureManager", new Runnable() { // from class: fq.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f48037a.m32062a(i10, context);
            }
        }, new String[0]);
    }

    /* renamed from: a */
    private /* synthetic */ void m32063a(Context context, Bundle bundle) {
        m32086a(context, new C10343b(bundle).m63686h("fold_state"));
    }

    /* renamed from: a */
    public void m32087a(final Context context, DeviceDetail deviceDetail, UltrasoundSettings ultrasoundSettings, InterfaceC5383n1 interfaceC5383n1) {
        if (this.f24821a.get() == 2) {
            interfaceC5383n1.mo32033a(-1, "ultrasound measure is running");
            return;
        }
        if (context == null) {
            this.f24821a.set(1);
            interfaceC5383n1.mo32033a(-1, "hmsContext is null");
            return;
        }
        if (ultrasoundSettings == null) {
            this.f24821a.set(1);
            interfaceC5383n1.mo32033a(-1, "json convert failed");
            return;
        }
        m32095d();
        try {
            boolean zCheckAppHavePermission = PermissionUtil.checkAppHavePermission(context, context.getPackageName(), new String[]{"com.huawei.permission.MANAGE_FOLD_SCREEN"});
            if (BuildEx.VERSION.EMUI_SDK_INT >= 19 && zCheckAppHavePermission && HwFoldScreenManagerEx.isFoldable()) {
                HwFoldScreenManagerEx.FoldableStateListener foldableStateListener = new HwFoldScreenManagerEx.FoldableStateListener() { // from class: fq.x
                };
                HwFoldScreenManagerEx.registerFoldableState(foldableStateListener, 1);
                this.f24838r = foldableStateListener;
            }
        } catch (NoClassDefFoundError e10) {
            HmsFindSDKLog.m32126e("UltrasoundMeasureManager", "not a fold or buildEx phone, error message: " + e10.getMessage());
        }
        Object systemService = context.getSystemService("sensor");
        if (!(systemService instanceof SensorManager)) {
            this.f24821a.set(1);
            interfaceC5383n1.mo32033a(-1, "can not get sensor manager");
            return;
        }
        this.f24840t = interfaceC5383n1;
        this.f24841u = deviceDetail.getSn();
        this.f24842v = deviceDetail.getProductId();
        this.f24843w = deviceDetail.getSequence();
        this.f24828h = (SensorManager) systemService;
        m32088a(ultrasoundSettings);
        m32092b();
        FreqParam freqParamM32084a = m32084a(context, this.f24842v, this.f24843w, m32082a(context));
        this.f24844x = m32083a(freqParamM32084a);
        this.f24845y.set(freqParamM32084a);
        this.f24821a.set(2);
        interfaceC5383n1.mo32033a(0, JsonUtils.object2Json(freqParamM32084a));
    }

    /* renamed from: a */
    public final void m32088a(UltrasoundSettings ultrasoundSettings) {
        this.f24830j = new float[9];
        this.f24839s = ultrasoundSettings.getStartUltrasoundMeasuringTime();
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "start record time is: " + this.f24839s);
        this.f24823c = ultrasoundSettings.getTagStatus();
        this.f24825e = ultrasoundSettings.getTemperature();
        this.f24826f = ultrasoundSettings.getTimeBias();
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "time bias is: " + this.f24826f);
        this.f24827g = ultrasoundSettings.getAlpha();
        this.f24824d = ultrasoundSettings.getUltrasoundTxTime();
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "ultrasound txTime is: " + this.f24824d);
    }

    /* renamed from: a */
    public void m32089a(String str) {
        HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "onFreqParamAdjustedResult " + str);
        FreqParam freqParam = (FreqParam) JsonUtils.json2Object(str, FreqParam.class);
        if (freqParam == null) {
            HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "json convert failed, so return");
            return;
        }
        if (this.f24821a.get() != 2) {
            HmsFindSDKLog.m32128w("UltrasoundMeasureManager", "refresh settings failed, please start measure first");
            return;
        }
        if (freqParam.getActionFlag() == 2) {
            HmsFindSDKLog.m32127i("UltrasoundMeasureManager", "onFreqParamAdjustedResult.freq " + freqParam.getInitFreq() + " success ACK");
        }
        this.f24845y.set(freqParam);
        this.f24844x = m32083a(freqParam);
    }

    /* renamed from: a */
    public final boolean m32090a(FreqParam freqParam, FreqParam freqParam2) {
        if (freqParam.getActionFlag() == 1) {
            return freqParam2 == null || freqParam2.getInitFreq() != freqParam.getInitFreq();
        }
        return false;
    }

    /* renamed from: a */
    public final byte[] m32091a(byte[] bArr, boolean z10) {
        byte[] bArr2 = this.f24822b;
        if (bArr2 == null) {
            bArr2 = new byte[bArr.length * (z10 ? 3 : 4)];
            this.f24822b = bArr2;
        }
        System.arraycopy(bArr2, bArr.length, bArr2, 0, bArr2.length - bArr.length);
        System.arraycopy(bArr, 0, bArr2, bArr2.length - bArr.length, bArr.length);
        return bArr2;
    }
}
