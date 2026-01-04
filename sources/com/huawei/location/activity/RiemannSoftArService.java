package com.huawei.location.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import as.C1016d;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.activity.util.JniUtils;
import com.huawei.location.base.activity.AbstractARServiceManager;
import com.huawei.location.base.activity.ActivityRecognitionConstantsMapping;
import com.huawei.location.base.activity.ActivityRecognitionMappingManager;
import com.huawei.location.base.activity.ActivityTransitionMappingManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.entity.MovementEvent;
import es.C9547l;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p531or.C11991a;
import p622rr.C12619b;
import p749wq.InterfaceC13625a;
import p784xq.C13845a;
import p784xq.C13846b;
import p784xq.C13847c;
import p784xq.C13848d;
import p784xq.C13849e;

/* loaded from: classes8.dex */
public class RiemannSoftArService extends AbstractARServiceManager implements SensorEventListener, InterfaceC13625a {
    private static final int ACQUISITION_FREQUENCY = 10000;
    public static final long ACTIVITY_TRANSITION_UPDATETIMNE = 1000;
    private static final int BASE_CONFIDENCE = 50;
    private static final int FULL_CONFIDENCE = 100;
    private static final long INIT_VALUE = -1;
    private static final int JUDGE_INVALID_TIME = 100000000;
    private static final int MAX_INVALID_TIME = 10000;
    private static final int ONE = 1;
    private static final int SAMPLE_LIST_SIZE = 100;
    private static final int SAMPLE_SIZE = 4;
    private static final int SENSOR_LIST_ALL = 656;
    private static final int SENSOR_LIST_SIZE = 256;
    private static final String TAG = "RiemannSoftArService";
    private static final int ZERO = 0;
    private static volatile RiemannSoftArService instance;
    private Sensor acc;
    private List<C13845a> accRecordList;
    private boolean alreadyRegister;
    private boolean alreadyRequestAR;
    private C13848d atProvider;
    private Context context;
    private long delay;
    private boolean needToWait;
    private Sensor ori;
    private List<C13845a> oriRecordList;
    private SensorManager sensorManager;
    private long updatTime;
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final byte[] SYNC_LIST_LOCK = new byte[0];

    /* renamed from: com.huawei.location.activity.RiemannSoftArService$a */
    public class RunnableC6732a implements Runnable {
        public RunnableC6732a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Thread.currentThread().setName("Location-ACTIVITY-RiemannSoftArService");
                C1016d.m6186f(RiemannSoftArService.TAG, "start to get result when data is enough!");
                ((AbstractARServiceManager) RiemannSoftArService.this).recognitionMappingManager.send(RiemannSoftArService.this.getDetectedActivities());
                C1016d.m6186f(RiemannSoftArService.TAG, "RiemannSoftArService Task run end");
            } catch (C12619b e10) {
                throw e10;
            } catch (Exception unused) {
                C1016d.m6185e(RiemannSoftArService.TAG, "RiemannSoftArService Task run exception", true);
            }
        }

        public /* synthetic */ RunnableC6732a(RiemannSoftArService riemannSoftArService, int i10) {
            this();
        }
    }

    /* renamed from: com.huawei.location.activity.RiemannSoftArService$b */
    public class C6733b implements Comparator<DetectedActivity> {
        @Override // java.util.Comparator
        public final int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            return detectedActivity2.getConfidence() - detectedActivity.getConfidence();
        }
    }

    private RiemannSoftArService() {
        super(new ActivityTransitionMappingManager(), new ActivityRecognitionMappingManager());
        this.accRecordList = new CopyOnWriteArrayList();
        this.oriRecordList = new CopyOnWriteArrayList();
        this.context = C11991a.m72146b();
        this.needToWait = false;
        this.updatTime = System.currentTimeMillis();
        this.alreadyRegister = false;
        this.alreadyRequestAR = false;
        Object systemService = this.context.getSystemService("sensor");
        if (!(systemService instanceof SensorManager)) {
            C1016d.m6181a(TAG, "no sensorManager service");
            return;
        }
        SensorManager sensorManager = (SensorManager) systemService;
        this.sensorManager = sensorManager;
        this.acc = sensorManager.getDefaultSensor(1);
        this.ori = this.sensorManager.getDefaultSensor(3);
        this.atProvider = new C13848d();
    }

    private boolean checkDateVilid(List<C13845a> list, List<C13845a> list2) {
        String str;
        if (Math.abs(list.get(0).m83112j() - list2.get(0).m83112j()) > 100000000) {
            str = "difference time  is : " + (list.get(0).m83112j() - list2.get(0).m83112j());
        } else {
            int size = list.size() - 1;
            if (Math.abs(list.get(size).m83112j() - list2.get(size).m83112j()) <= 100000000) {
                return true;
            }
            str = "difference time  is : " + (list.get(size).m83112j() - list2.get(size).m83112j());
        }
        C1016d.m6186f(TAG, str);
        return false;
    }

    private void checkIfValid() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (SYNC_LIST_LOCK) {
            try {
                if (jCurrentTimeMillis - this.updatTime > 10000) {
                    C1016d.m6186f(TAG, "sensor data is not valid !");
                    this.oriRecordList.clear();
                    this.accRecordList.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private List<DetectedActivity> dealWithDatas() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        RiemannSoftArService riemannSoftArService;
        int i17;
        int i18;
        int i19;
        RiemannSoftArService riemannSoftArService2 = this;
        int i20 = 100;
        int i21 = 3;
        int i22 = 1;
        List<DetectedActivity> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList copyOnWriteArrayList4 = new CopyOnWriteArrayList(riemannSoftArService2.accRecordList);
        CopyOnWriteArrayList copyOnWriteArrayList5 = new CopyOnWriteArrayList(riemannSoftArService2.oriRecordList);
        int i23 = 256;
        int i24 = 256;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (i25 <= 4 && copyOnWriteArrayList4.size() >= i24 && copyOnWriteArrayList5.size() >= i24) {
            if (riemannSoftArService2.checkDateVilid(copyOnWriteArrayList4.subList(i26, i24), copyOnWriteArrayList5.subList(i26, i24))) {
                int i29 = i28 + i22;
                List listSubList = copyOnWriteArrayList4.subList(i26, i24);
                List listSubList2 = copyOnWriteArrayList5.subList(i26, i24);
                C1016d.m6186f("ResultPredict", "predict...");
                ArrayList arrayList = new ArrayList(i23);
                ArrayList arrayList2 = new ArrayList(i23);
                int i30 = 0;
                while (i30 < i23) {
                    float fM83110g = ((C13845a) listSubList.get(i30)).m83110g();
                    float fM83107c = ((C13845a) listSubList.get(i30)).m83107c();
                    float fM83109f = ((C13845a) listSubList.get(i30)).m83109f();
                    float[] fArr = new float[i21];
                    fArr[0] = fM83110g;
                    fArr[1] = fM83107c;
                    fArr[2] = fM83109f;
                    float fM83110g2 = ((C13845a) listSubList2.get(i30)).m83110g();
                    float fM83107c2 = ((C13845a) listSubList2.get(i30)).m83107c();
                    float fM83109f2 = ((C13845a) listSubList2.get(i30)).m83109f();
                    List list = listSubList;
                    float[] fArr2 = new float[i21];
                    fArr2[0] = fM83110g2;
                    fArr2[1] = fM83107c2;
                    fArr2[2] = fM83109f2;
                    arrayList.add(fArr);
                    arrayList2.add(fArr2);
                    i30++;
                    listSubList = list;
                    i21 = 3;
                    i23 = 256;
                }
                ArrayList arrayListM83115a = C13846b.m83115a(arrayList);
                ArrayList arrayListM83115a2 = C13846b.m83115a(arrayList2);
                int[] iArr = {arrayListM83115a.size(), ((float[]) arrayListM83115a.get(0)).length};
                Class cls = Float.TYPE;
                float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) cls, iArr);
                float[][] fArr4 = (float[][]) Array.newInstance((Class<?>) cls, arrayListM83115a2.size(), ((float[]) arrayListM83115a2.get(0)).length);
                int i31 = 0;
                while (i31 < arrayListM83115a.size()) {
                    System.arraycopy(arrayListM83115a.get(i31), 0, fArr3[i31], 0, ((float[]) arrayListM83115a.get(i31)).length);
                    i31++;
                    copyOnWriteArrayList5 = copyOnWriteArrayList5;
                    copyOnWriteArrayList4 = copyOnWriteArrayList4;
                }
                copyOnWriteArrayList = copyOnWriteArrayList4;
                copyOnWriteArrayList2 = copyOnWriteArrayList5;
                int i32 = 1;
                char c10 = 0;
                for (int i33 = 0; i33 < arrayListM83115a2.size(); i33++) {
                    System.arraycopy(arrayListM83115a2.get(i33), 0, fArr4[i33], 0, ((float[]) arrayListM83115a2.get(i33)).length);
                    i32 = 1;
                }
                if (fArr3.length < i32) {
                    i10 = i25;
                    i11 = i24;
                    i12 = i26;
                    i13 = i27;
                    i14 = i29;
                } else {
                    float[][] fArr5 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, fArr3.length, fArr3[0].length);
                    int i34 = 0;
                    while (i34 < fArr3.length) {
                        float[] fArr6 = fArr4[i34];
                        float f10 = fArr6[c10];
                        float f11 = fArr6[1];
                        float f12 = fArr6[2];
                        float[][] fArr7 = fArr4;
                        float[] fArr8 = new float[3];
                        fArr8[c10] = f10;
                        fArr8[1] = f11;
                        fArr8[2] = f12;
                        float[] fArr9 = fArr3[i34];
                        float[][] fArr10 = fArr3;
                        float[] fArr11 = new float[1];
                        fArr11[c10] = fArr9[c10];
                        int i35 = i29;
                        float[] fArr12 = new float[1];
                        fArr12[c10] = fArr9[1];
                        float[] fArr13 = new float[1];
                        fArr13[c10] = fArr9[2];
                        float[][] fArr14 = {fArr11, fArr12, fArr13};
                        float f13 = fArr8[c10];
                        float f14 = fArr8[1];
                        float f15 = fArr8[2] * 0.017453292f;
                        double d10 = f13 * 0.017453292f;
                        float fCos = (float) Math.cos(d10);
                        float fSin = (float) Math.sin(d10);
                        int i36 = i25;
                        double d11 = f15;
                        int i37 = i24;
                        int i38 = i26;
                        float fCos2 = (float) Math.cos(d11);
                        float fSin2 = (float) Math.sin(d11);
                        int i39 = i27;
                        double d12 = f14 * 0.017453292f;
                        ArrayList arrayList3 = arrayListM83115a;
                        float fCos3 = (float) Math.cos(d12);
                        float fSin3 = (float) Math.sin(d12);
                        float[][] fArr15 = {new float[]{fCos, fSin * (-1.0f), 0.0f}, new float[]{fSin, fCos, 0.0f}, new float[]{0.0f, 0.0f, 1.0f}};
                        float[][] fArr16 = {new float[]{fCos2, 0.0f, fSin2}, new float[]{0.0f, 1.0f, 0.0f}, new float[]{fSin2 * (-1.0f), 0.0f, fCos2}};
                        float[][] fArr17 = {new float[]{1.0f, 0.0f, 0.0f}, new float[]{0.0f, fCos3, fSin3 * (-1.0f)}, new float[]{0.0f, fSin3, fCos3}};
                        ArrayList arrayList4 = new ArrayList(3);
                        for (int i40 = 0; i40 < 3; i40++) {
                            arrayList4.add(fArr17[i40]);
                        }
                        ArrayList arrayList5 = new ArrayList(3);
                        for (int i41 = 0; i41 < 3; i41++) {
                            arrayList5.add(fArr16[i41]);
                        }
                        ArrayList arrayList6 = new ArrayList(3);
                        for (int i42 = 0; i42 < 3; i42++) {
                            arrayList6.add(fArr15[i42]);
                        }
                        ArrayList<float[]> arrayListM83116a = C13847c.m83116a(arrayList4, arrayList5, arrayList4.size());
                        ArrayList<float[]> arrayListM83116a2 = C13847c.m83116a(arrayListM83116a, arrayList6, arrayListM83116a.size());
                        new ArrayList(3);
                        float[][] fArr18 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayListM83116a2.size(), arrayListM83116a2.get(0).length);
                        for (int i43 = 0; i43 < arrayListM83116a2.size(); i43++) {
                            System.arraycopy(arrayListM83116a2.get(i43), 0, fArr18[i43], 0, arrayListM83116a2.get(i43).length);
                        }
                        int length = fArr18.length;
                        int length2 = fArr18[0].length;
                        float[][] fArr19 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, length2, length);
                        for (int i44 = 0; i44 < length; i44++) {
                            for (int i45 = 0; i45 < length2; i45++) {
                                fArr19[i45][i44] = fArr18[i44][i45];
                            }
                        }
                        ArrayList arrayList7 = new ArrayList(length);
                        for (float[] fArr20 : fArr19) {
                            arrayList7.add(fArr20);
                        }
                        ArrayList arrayList8 = new ArrayList(3);
                        int i46 = 0;
                        for (int i47 = 3; i46 < i47; i47 = 3) {
                            arrayList8.add(fArr14[i46]);
                            i46++;
                        }
                        float[][] fArr21 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList7.size(), ((float[]) arrayList7.get(0)).length);
                        for (int i48 = 0; i48 < arrayList7.size(); i48++) {
                            System.arraycopy(arrayList7.get(i48), 0, fArr21[i48], 0, ((float[]) arrayList7.get(i48)).length);
                        }
                        float[][] fArr22 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList8.size(), ((float[]) arrayList8.get(0)).length);
                        for (int i49 = 0; i49 < arrayList8.size(); i49++) {
                            System.arraycopy(arrayList8.get(i49), 0, fArr22[i49], 0, ((float[]) arrayList8.get(i49)).length);
                        }
                        int i50 = 0;
                        float[][] fArr23 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, fArr21.length, fArr22[0].length);
                        int i51 = 0;
                        while (i51 < fArr21.length) {
                            int i52 = i50;
                            while (i52 < fArr22[i50].length) {
                                float f16 = 0.0f;
                                for (int i53 = 0; i53 < fArr22.length; i53++) {
                                    f16 += fArr21[i51][i53] * fArr22[i53][i52];
                                }
                                fArr23[i51][i52] = f16;
                                i52++;
                                i50 = 0;
                            }
                            i51++;
                            i50 = 0;
                        }
                        float[] fArr24 = fArr5[i34];
                        fArr24[0] = fArr23[0][0];
                        fArr24[1] = fArr23[1][0];
                        fArr24[2] = fArr23[2][0];
                        i34++;
                        i26 = i38;
                        arrayListM83115a = arrayList3;
                        fArr3 = fArr10;
                        fArr4 = fArr7;
                        i29 = i35;
                        i24 = i37;
                        i25 = i36;
                        i27 = i39;
                        c10 = 0;
                    }
                    i10 = i25;
                    i11 = i24;
                    i12 = i26;
                    i13 = i27;
                    i14 = i29;
                    ArrayList arrayList9 = new ArrayList(arrayListM83115a.size());
                    for (float[] fArr25 : fArr5) {
                        arrayList9.add(fArr25);
                    }
                    arrayListM83115a = arrayList9;
                }
                for (int i54 = 0; i54 < 256; i54++) {
                    ((float[]) arrayListM83115a.get(i54))[2] = (float) (((float[]) arrayListM83115a.get(i54))[2] - 9.81d);
                }
                float[][] fArr26 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayListM83115a.size(), ((float[]) arrayListM83115a.get(0)).length);
                for (int i55 = 0; i55 < arrayListM83115a.size(); i55++) {
                    System.arraycopy(arrayListM83115a.get(i55), 0, fArr26[i55], 0, ((float[]) arrayListM83115a.get(i55)).length);
                }
                if (fArr26.length != 0) {
                    float[][] fArr27 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, fArr26.length, fArr26[0].length);
                    int i56 = 0;
                    for (int i57 = 0; i56 < fArr26[i57].length; i57 = 0) {
                        float[][] fArr28 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayListM83115a.size(), ((float[]) arrayListM83115a.get(i57)).length);
                        for (int i58 = 0; i58 < arrayListM83115a.size(); i58++) {
                            System.arraycopy(arrayListM83115a.get(i58), 0, fArr28[i58], 0, ((float[]) arrayListM83115a.get(i58)).length);
                        }
                        ArrayList arrayList10 = new ArrayList();
                        for (float[] fArr29 : fArr28) {
                            if (i56 >= 0) {
                                if (i56 < fArr29.length) {
                                    arrayList10.add(Float.valueOf(fArr29[i56]));
                                }
                            }
                        }
                        int i59 = (int) 40.5d;
                        ArrayList arrayList11 = new ArrayList();
                        for (int i60 = -i59; i60 < i59 + 1; i60++) {
                            arrayList11.add(Float.valueOf((float) Math.exp(i60 * i60 * (-0.005d))));
                        }
                        int size = (arrayList11.size() - 1) / 2;
                        int size2 = arrayList10.size();
                        int i61 = (size * 2) + size2;
                        ArrayList arrayList12 = new ArrayList(i61);
                        int i62 = 0;
                        while (i62 < i61) {
                            if (i62 < size) {
                                i19 = size - i62;
                            } else {
                                int i63 = size2 + size;
                                if (i62 < i63) {
                                    i19 = i62 - size;
                                } else {
                                    i18 = 1;
                                    if (i62 >= i63) {
                                        arrayList12.add((Float) arrayList10.get((((i63 - 1) * 2) - i62) - size));
                                    }
                                    i62 += i18;
                                }
                            }
                            arrayList12.add((Float) arrayList10.get(i19));
                            i18 = 1;
                            i62 += i18;
                        }
                        int i64 = 1;
                        ArrayList arrayList13 = new ArrayList();
                        int i65 = 0;
                        while (i65 < size2) {
                            int i66 = i65 + size;
                            ArrayList arrayList14 = new ArrayList(arrayList12.subList(i66 - size, i66 + size + i64));
                            double dFloatValue = 0.0d;
                            double dFloatValue2 = 0.0d;
                            int i67 = 0;
                            while (i67 < arrayList11.size()) {
                                dFloatValue += ((Float) arrayList11.get(i67)).floatValue() * ((Float) arrayList14.get(i67)).floatValue();
                                dFloatValue2 += ((Float) arrayList11.get(i67)).floatValue();
                                i67++;
                                size2 = size2;
                                arrayList12 = arrayList12;
                            }
                            arrayList13.add(Float.valueOf((float) (dFloatValue / dFloatValue2)));
                            i65++;
                            i64 = 1;
                            size2 = size2;
                        }
                        int i68 = i64;
                        for (int i69 = 0; i69 < fArr26.length; i69 += i68) {
                            fArr27[i69][i56] = ((Float) arrayList13.get(i69)).floatValue();
                        }
                        i56 += i68;
                    }
                    ArrayList arrayList15 = new ArrayList(arrayListM83115a.size());
                    for (float[] fArr30 : fArr27) {
                        arrayList15.add(fArr30);
                    }
                    arrayListM83115a = arrayList15;
                }
                for (int i70 = 0; i70 < 3; i70++) {
                    float[][] fArr31 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayListM83115a.size(), ((float[]) arrayListM83115a.get(0)).length);
                    for (int i71 = 0; i71 < arrayListM83115a.size(); i71++) {
                        System.arraycopy(arrayListM83115a.get(i71), 0, fArr31[i71], 0, ((float[]) arrayListM83115a.get(i71)).length);
                    }
                    int length3 = fArr31.length;
                    float[] fArr32 = new float[length3];
                    for (int i72 = 0; i72 < fArr31.length; i72++) {
                        if (i70 >= 0) {
                            float[] fArr33 = fArr31[i72];
                            if (i70 < fArr33.length) {
                                fArr32[i72] = fArr33[i70];
                            }
                        }
                    }
                    float f17 = 0.0f;
                    for (int i73 = 0; i73 < length3; i73++) {
                        f17 += fArr32[i73];
                    }
                    float f18 = f17 / length3;
                    for (int i74 = 0; i74 < 256; i74++) {
                        ((float[]) arrayListM83115a.get(i74))[i70] = ((float[]) arrayListM83115a.get(i74))[i70] - f18;
                    }
                }
                i15 = 256;
                float[] fArr34 = new float[768];
                float[][] fArr35 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayListM83115a.size(), ((float[]) arrayListM83115a.get(0)).length);
                for (int i75 = 0; i75 < arrayListM83115a.size(); i75++) {
                    System.arraycopy(arrayListM83115a.get(i75), 0, fArr35[i75], 0, ((float[]) arrayListM83115a.get(i75)).length);
                }
                int i76 = 0;
                int length4 = fArr35.length;
                int i77 = 0;
                int i78 = 0;
                while (i77 < length4) {
                    float[] fArr36 = fArr35[i77];
                    int i79 = i76;
                    int i80 = i78;
                    while (i79 < fArr35[i76].length) {
                        fArr34[i80] = fArr36[i79];
                        i79++;
                        i80++;
                        i76 = 0;
                    }
                    i77++;
                    i78 = i80;
                    i76 = 0;
                }
                float[][] fArr37 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 1, 5);
                if (JniUtils.analysisData(fArr34, fArr37) != 0) {
                    C1016d.m6183c("ResultPredict", "analysis result fail");
                    throw new C12619b(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
                }
                float[] fArr38 = fArr37[0];
                C13849e.f62119a = new CopyOnWriteArrayList();
                for (int i81 = 0; i81 < fArr38.length; i81++) {
                    DetectedActivity detectedActivity = new DetectedActivity();
                    if (i81 == 0) {
                        detectedActivity.setConfidence((int) (fArr38[i81] * 100.0f));
                        detectedActivity.setType(3);
                    }
                    if (i81 == 1) {
                        detectedActivity.setConfidence((int) (fArr38[i81] * 100.0f));
                        detectedActivity.setType(7);
                    }
                    if (i81 == 2) {
                        detectedActivity.setConfidence((int) (fArr38[i81] * 100.0f));
                        detectedActivity.setType(8);
                    }
                    if (i81 == 3) {
                        detectedActivity.setConfidence((int) (fArr38[i81] * 100.0f));
                        detectedActivity.setType(1);
                    }
                    if (i81 == 4) {
                        detectedActivity.setConfidence((int) (fArr38[i81] * 100.0f));
                        detectedActivity.setType(0);
                    }
                    C13849e.f62119a.add(detectedActivity);
                }
                i16 = 3;
                C13849e.f62119a.add(new DetectedActivity(2, (int) ((fArr38[1] + fArr38[2]) * 100.0f)));
                riemannSoftArService = this;
                i26 = i12 + 100;
                i24 = i11 + 100;
                copyOnWriteArrayList3 = riemannSoftArService.mergeList(copyOnWriteArrayList3, C13849e.f62119a);
                i28 = i14;
                i27 = i13;
                i17 = 1;
            } else {
                C1016d.m6186f(TAG, "data not valid ! drop it ");
                i26 += i20;
                i24 += i20;
                riemannSoftArService = riemannSoftArService2;
                i17 = i22;
                i27 = i17;
                copyOnWriteArrayList = copyOnWriteArrayList4;
                copyOnWriteArrayList2 = copyOnWriteArrayList5;
                i15 = i23;
                i10 = i25;
                i16 = i21;
            }
            i25 = i10 + 1;
            i23 = i15;
            i21 = i16;
            copyOnWriteArrayList5 = copyOnWriteArrayList2;
            copyOnWriteArrayList4 = copyOnWriteArrayList;
            i22 = i17;
            riemannSoftArService2 = riemannSoftArService;
            i20 = 100;
        }
        RiemannSoftArService riemannSoftArService3 = riemannSoftArService2;
        int i82 = i27;
        synchronized (SYNC_LIST_LOCK) {
            if (i82 != 0) {
                try {
                    riemannSoftArService3.oriRecordList.clear();
                    riemannSoftArService3.accRecordList.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        for (int i83 = 0; i83 < copyOnWriteArrayList3.size(); i83++) {
            copyOnWriteArrayList3.get(i83).setConfidence(copyOnWriteArrayList3.get(i83).getConfidence() / i28);
        }
        Iterator<DetectedActivity> it = copyOnWriteArrayList3.iterator();
        while (it.hasNext()) {
            if (it.next().getConfidence() >= 50) {
                return copyOnWriteArrayList3;
            }
        }
        copyOnWriteArrayList3.add(new DetectedActivity(4, 100));
        return copyOnWriteArrayList3;
    }

    private C13845a event2Acc(SensorEvent sensorEvent) {
        C13845a c13845a = new C13845a();
        c13845a.m83114l(sensorEvent.timestamp);
        c13845a.m83113k(sensorEvent.values[0]);
        c13845a.m83111i(sensorEvent.values[1]);
        c13845a.m83108d(sensorEvent.values[2]);
        return c13845a;
    }

    private static void freeAssets() {
        JniUtils.freeBuffer();
    }

    public List<DetectedActivity> getDetectedActivities() {
        checkIfValid();
        try {
            if (this.accRecordList.size() < 256 || this.oriRecordList.size() < 256) {
                C1016d.m6186f(TAG, "need to wait for data !");
                this.needToWait = true;
                byte[] bArr = SYNC_LOCK;
                synchronized (bArr) {
                    bArr.wait();
                }
                C1016d.m6186f(TAG, "wait end!");
                this.needToWait = false;
            }
        } catch (InterruptedException unused) {
            C1016d.m6181a(TAG, "InterruptedException ");
        }
        ArrayList arrayList = new ArrayList(dealWithDatas());
        Collections.sort(arrayList, new C6733b());
        return arrayList;
    }

    public static RiemannSoftArService getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new RiemannSoftArService();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private List<DetectedActivity> mergeList(List<DetectedActivity> list, List<DetectedActivity> list2) {
        if (list2 == null || list2.size() == 0) {
            C1016d.m6183c(TAG, "ResultPredict.predict result is null !");
            return list;
        }
        if (list == null || list.size() == 0) {
            return list2;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.get(i10).setConfidence(list2.get(i10).getConfidence() + list.get(i10).getConfidence());
        }
        return list;
    }

    private void register() {
        if (this.alreadyRegister) {
            C1016d.m6186f(TAG, " already registered");
        } else {
            new C6735b().m38289g(this);
        }
    }

    private void unregister() {
        try {
            if (this.alreadyRegister) {
                freeAssets();
                SensorManager sensorManager = this.sensorManager;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.acc);
                    this.sensorManager.unregisterListener(this, this.ori);
                    this.alreadyRegister = false;
                    C1016d.m6186f(TAG, "unregister acc & ori success");
                }
            }
        } catch (C12619b e10) {
            throw e10;
        } catch (Exception unused) {
            C1016d.m6183c(TAG, "unregister sensor listener failed");
        }
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public boolean connectService() {
        return false;
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public boolean disConnectService() {
        return false;
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public ActivityRecognitionResult getDetectedActivity(int i10, int i11) {
        C1016d.m6186f(TAG, "getDetectedActivity");
        return null;
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public RunnableC6732a getTask() {
        return new RunnableC6732a(this, 0);
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public boolean isConnected() {
        return false;
    }

    public void modelFileLoadFail(int i10) {
    }

    @Override // p749wq.InterfaceC13625a
    public void modelFileLoadSuccess() {
        try {
            SensorManager sensorManager = this.sensorManager;
            if (sensorManager == null) {
                C1016d.m6186f(TAG, "sensorManager is null");
                throw new C12619b(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
            }
            boolean zRegisterListener = sensorManager.registerListener(this, this.acc, 10000);
            boolean zRegisterListener2 = this.sensorManager.registerListener(this, this.ori, 10000);
            C1016d.m6186f(TAG, "register accResult: " + zRegisterListener + " register oriResult: " + zRegisterListener2);
            if (!zRegisterListener || !zRegisterListener2) {
                throw new C12619b(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
            }
            this.alreadyRegister = true;
            if (this.scheduledExecutorService == null) {
                this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
            }
            this.scheduledFuture = this.scheduledExecutorService.scheduleWithFixedDelay(getTask(), 0L, this.delay, TimeUnit.MILLISECONDS);
            C1016d.m6186f(TAG, "startScheduled exit");
        } catch (C12619b e10) {
            throw e10;
        } catch (Exception unused) {
            C1016d.m6183c(TAG, "register sensor listener failed");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 || sensorEvent.sensor.getType() == 3) {
            checkIfValid();
            this.updatTime = System.currentTimeMillis();
            if (sensorEvent.sensor.getType() == 1) {
                this.accRecordList.add(event2Acc(sensorEvent));
                synchronized (SYNC_LIST_LOCK) {
                    try {
                        if (this.accRecordList.size() > SENSOR_LIST_ALL) {
                            this.accRecordList.remove(0);
                        }
                    } finally {
                    }
                }
            } else {
                this.oriRecordList.add(event2Acc(sensorEvent));
                synchronized (SYNC_LIST_LOCK) {
                    try {
                        if (this.oriRecordList.size() > SENSOR_LIST_ALL) {
                            this.oriRecordList.remove(0);
                        }
                    } finally {
                    }
                }
            }
            if (!this.needToWait || this.oriRecordList.size() < 256 || this.accRecordList.size() < 256) {
                return;
            }
            byte[] bArr = SYNC_LOCK;
            synchronized (bArr) {
                bArr.notifyAll();
            }
        }
    }

    public void onStatusChanged(int i10, int i11) {
        MovementEvent movementEvent = new MovementEvent(ActivityRecognitionConstantsMapping.getActivityType(Integer.valueOf(i10)), i11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(movementEvent);
        if (i10 == 7 || i10 == 8) {
            arrayList.add(new MovementEvent(ActivityRecognitionConstantsMapping.getActivityType(2), i11));
        }
        this.transitionMappingManager.sendActivityTransitionMappingInfo(arrayList, this.mContext);
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public void removeActivityTransitionUpdates(ATCallback aTCallback, ClientInfo clientInfo) {
        C13848d c13848d;
        C1016d.m6186f(TAG, "removeActivityTransitionUpdates");
        this.transitionMappingManager.removeActivityTransitionMappingInfo(aTCallback);
        if (this.transitionMappingManager.getInfos().size() != 0 || (c13848d = this.atProvider) == null) {
            return;
        }
        this.recognitionMappingManager.removeActivityUpdatesMappingInfo(c13848d.m83119b());
        scheduleTimer();
        this.atProvider.m83118a();
        this.alreadyRequestAR = false;
        C1016d.m6186f(TAG, "no activity transition request ");
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public synchronized void removeActivityUpdates(ARCallback aRCallback, ClientInfo clientInfo) {
        C1016d.m6186f(TAG, "removeActivityUpdates");
        this.recognitionMappingManager.removeActivityUpdatesMappingInfo(aRCallback);
        scheduleTimer();
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public void requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        C13848d c13848d;
        C9547l.m59617c(TAG, activityTransitionRequest, ActivityTransitionRequest.class);
        List<ActivityTransition> transitions = activityTransitionRequest.getTransitions();
        if (transitions == null || transitions.size() < 1) {
            C1016d.m6186f(TAG, "requestActivityTransitionUpdates ,null == transitions || transitions.size() < 1");
            return;
        }
        C1016d.m6186f(TAG, "requestActivityTransitionUpdates");
        this.transitionMappingManager.addActivityTransitionMappingInfo(transitions, aTCallback, clientInfo);
        if (!this.alreadyRequestAR && (c13848d = this.atProvider) != null) {
            this.recognitionMappingManager.addActivityUpdatesMappingInfo(1000L, c13848d.m83119b(), clientInfo);
            this.alreadyRequestAR = true;
        }
        scheduleTimer();
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public synchronized void requestActivityUpdates(long j10, ARCallback aRCallback, ClientInfo clientInfo) {
        C1016d.m6186f(TAG, "requestActivityUpdates");
        this.recognitionMappingManager.addActivityUpdatesMappingInfo(j10, aRCallback, clientInfo);
        scheduleTimer();
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public synchronized void scheduleTimer() {
        long minTime;
        try {
            minTime = this.recognitionMappingManager.getMinTime();
        } catch (C12619b e10) {
            throw e10;
        } catch (Exception unused) {
            C1016d.m6185e(TAG, "scheduleTimer exception", true);
        }
        if (-1 == minTime) {
            C1016d.m6186f(TAG, "scheduleTimer return time is " + minTime);
            this.lastTimeByTimer = -1L;
            stopScheduled();
            return;
        }
        long j10 = this.lastTimeByTimer;
        if (j10 == -1) {
            C1016d.m6186f(TAG, "scheduleTimer begin time is " + minTime);
            this.lastTimeByTimer = minTime;
            startScheduled(minTime);
        } else if (minTime != j10) {
            C1016d.m6186f(TAG, "scheduleTimer begin again time is " + minTime);
            this.lastTimeByTimer = minTime;
            restartScheduled(minTime);
        } else {
            register();
        }
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public void startScheduled(long j10) {
        this.delay = j10;
        C1016d.m6186f(TAG, "startScheduled enter");
        register();
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public void stopScheduled() {
        C1016d.m6186f(TAG, "stopScheduled enter");
        unregister();
        try {
            ScheduledFuture scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                C1016d.m6186f(TAG, "stopScheduled exit:" + this.scheduledFuture.cancel(true));
                return;
            }
            C1016d.m6186f(TAG, "scheduled not init or cancelled");
        } catch (C12619b e10) {
            throw e10;
        } catch (Exception unused) {
            C1016d.m6185e(TAG, "stopScheduled exit exception", true);
        }
    }
}
