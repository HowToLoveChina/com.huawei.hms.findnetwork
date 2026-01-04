package p348hw;

import android.content.Context;
import android.util.Log;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import com.ultrasoniclibrary.ultrasoundcore.classfun.FreqParam;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import p299fw.C9777c;

/* renamed from: hw.g */
/* loaded from: classes9.dex */
public class C10352g {

    /* renamed from: a */
    public static final String f50061a;

    /* renamed from: b */
    public static final String f50062b;

    /* renamed from: c */
    public static final String f50063c;

    /* renamed from: d */
    public static final String f50064d;

    /* renamed from: e */
    public static final String f50065e;

    /* renamed from: f */
    public static final String f50066f;

    /* renamed from: g */
    public static final String f50067g;

    /* renamed from: h */
    public static final String f50068h;

    /* renamed from: i */
    public static final String f50069i;

    /* renamed from: j */
    public static final String f50070j;

    /* renamed from: k */
    public static final String f50071k;

    /* renamed from: l */
    public static final String f50072l;

    /* renamed from: m */
    public static final String f50073m;

    /* renamed from: n */
    public static final String f50074n;

    /* renamed from: o */
    public static final String f50075o;

    /* renamed from: p */
    public static volatile C10352g f50076p;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ultrasound");
        String str = File.separator;
        sb2.append(str);
        sb2.append("leftOriginalSignal_1418_pianoBox.txt");
        f50061a = sb2.toString();
        f50062b = "ultrasound" + str + "leftOriSigReal_1418_pianoBox.txt";
        f50063c = "ultrasound" + str + "leftOriSigImag_1418_pianoBox.txt";
        f50064d = "ultrasound" + str + "leftOriginalSignal_1620_piano.txt";
        f50065e = "ultrasound" + str + "leftOriSigReal_1620_piano.txt";
        f50066f = "ultrasound" + str + "leftOriSigImag_1620_piano.txt";
        f50067g = "ultrasound" + str + "leftOriginalSignal_1822_piano.txt";
        f50068h = "ultrasound" + str + "leftOriSigReal_1822_piano.txt";
        f50069i = "ultrasound" + str + "leftOriSigImag_1822_piano.txt";
        f50070j = "ultrasound" + str + "leftOriginalSignal_1418_Tag.txt";
        f50071k = "ultrasound" + str + "leftOriSigReal_1418_Tag.txt";
        f50072l = "ultrasound" + str + "leftOriSigImag_1418_Tag.txt";
        f50073m = "ultrasound" + str + "leftOriginalSignal_611_Tag.txt";
        f50074n = "ultrasound" + str + "leftOriSigReal_611_Tag.txt";
        f50075o = "ultrasound" + str + "leftOriSigImag_611_Tag.txt";
    }

    /* renamed from: b */
    public static C10352g m63743b() {
        if (f50076p == null) {
            synchronized (C10352g.class) {
                try {
                    if (f50076p == null) {
                        f50076p = new C10352g();
                    }
                } finally {
                }
            }
        }
        return f50076p;
    }

    /* renamed from: h */
    public static ArrayList<Double> m63744h(Context context, String str) throws IOException {
        ArrayList<Double> arrayList = new ArrayList<>();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open(str), StandardCharsets.UTF_8);
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        arrayList.add(Double.valueOf(Double.parseDouble(line.split(",")[0])));
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException | NumberFormatException e10) {
            C10355j.m63763a("ProductParam", "read source audio txt failed, error message: " + e10.getMessage());
        }
        return arrayList;
    }

    /* renamed from: i */
    public static double[] m63745i(ArrayList<Double> arrayList) {
        double[] dArr = new double[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            dArr[i10] = arrayList.get(i10).doubleValue();
        }
        return dArr;
    }

    /* renamed from: a */
    public FreqParam m63746a(String str, int i10) {
        return str.equals(EnumC10351f.HWTAG.m63742e()) ? i10 == 14000 ? new FreqParam(14000, 4, 50, 1000, 550, 30, 0) : new FreqParam(6000, 5, 50, 1000, 550, 30, 0) : str.equals(EnumC10351f.DOVE.m63742e()) ? new FreqParam(14000, 4, 50, 1000, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 50, 0) : str.equals(EnumC10351f.HARPER.m63742e()) ? new FreqParam(16000, 4, 50, 1000, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 50, 0) : (str.equals(EnumC10351f.PIANO.m63742e()) || str.equals(EnumC10351f.PIANOP.m63742e())) ? new FreqParam(18000, 4, 50, 1000, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 50, 0) : new FreqParam();
    }

    /* renamed from: c */
    public double[] m63747c(Context context, int i10, String str, int i11) {
        return m63750f(context, i10, str, 0, i11);
    }

    /* renamed from: d */
    public double[] m63748d(Context context, int i10, String str, int i11) {
        return m63750f(context, i10, str, 2, i11);
    }

    /* renamed from: e */
    public double[] m63749e(Context context, int i10, String str, int i11) {
        return m63750f(context, i10, str, 1, i11);
    }

    /* renamed from: f */
    public double[] m63750f(Context context, int i10, String str, int i11, int i12) {
        String str2;
        boolean z10 = i12 == 14000;
        String str3 = null;
        if (str.equals(EnumC10351f.HWTAG.m63742e())) {
            if (i10 == 1) {
                if (i11 == 0) {
                    str2 = z10 ? f50070j : f50073m;
                } else if (i11 == 1) {
                    str2 = z10 ? f50071k : f50074n;
                } else if (i11 != 2) {
                    C10355j.m63763a("ProductParam", "can't find signal file");
                } else {
                    str2 = z10 ? f50072l : f50075o;
                }
                str3 = str2;
            } else if (i11 == 0) {
                str3 = z10 ? f50061a : f50073m;
                Log.i("ProductParam", "audio path: " + str3);
            } else if (i11 == 1) {
                str3 = z10 ? f50062b : f50074n;
                Log.i("ProductParam", "audio path: " + str3);
            } else if (i11 != 2) {
                C10355j.m63763a("ProductParam", "can't find signal file");
            } else {
                str3 = z10 ? f50063c : f50075o;
                Log.i("ProductParam", "audio path: " + str3);
            }
            return m63745i(m63744h(context, str3));
        }
        if (str.equals(EnumC10351f.DOVE.m63742e())) {
            if (i11 == 0) {
                str3 = f50061a;
                Log.i("ProductParam", "audio path: " + str3);
            } else if (i11 == 1) {
                str3 = f50062b;
                Log.i("ProductParam", "audio path: " + str3);
            } else if (i11 != 2) {
                C10355j.m63763a("ProductParam", "can't find signal file");
            } else {
                str3 = f50063c;
                Log.i("ProductParam", "audio path: " + str3);
            }
            return m63745i(m63744h(context, str3));
        }
        if (str.equals(EnumC10351f.HARPER.m63742e())) {
            if (i11 == 0) {
                str3 = f50064d;
                Log.i("ProductParam", "audio path: " + str3);
            } else if (i11 == 1) {
                str3 = f50065e;
                Log.i("ProductParam", "audio path: " + str3);
            } else if (i11 != 2) {
                C10355j.m63763a("ProductParam", "can't find signal file");
            } else {
                str3 = f50066f;
                Log.i("ProductParam", "audio path: " + str3);
            }
            return m63745i(m63744h(context, str3));
        }
        if (!str.equals(EnumC10351f.PIANO.m63742e()) && !str.equals(EnumC10351f.PIANOP.m63742e())) {
            double[] dArr = new double[0];
            C10355j.m63763a("ProductParam", "Get oriSig failed");
            return dArr;
        }
        if (i11 == 0) {
            str3 = f50067g;
            Log.i("ProductParam", "audio path: " + str3);
        } else if (i11 == 1) {
            str3 = f50068h;
            Log.i("ProductParam", "audio path: " + str3);
        } else if (i11 != 2) {
            C10355j.m63763a("ProductParam", "can't find signal file");
        } else {
            str3 = f50069i;
            Log.i("ProductParam", "audio path: " + str3);
        }
        return m63745i(m63744h(context, str3));
    }

    /* renamed from: g */
    public C9777c m63751g(String str, int i10, int i11) {
        boolean z10 = i11 == 14000;
        if (str.equals(EnumC10351f.HWTAG.m63742e())) {
            if (i10 == 1 && z10) {
                return new C9777c(2480, 680, 48, 800, 200);
            }
            return new C9777c(2400, 680, 48, 800, 200);
        }
        if (str.equals(EnumC10351f.PIANO.m63742e()) || str.equals(EnumC10351f.DOVE.m63742e()) || str.equals(EnumC10351f.PIANOP.m63742e()) || str.equals(EnumC10351f.HARPER.m63742e())) {
            return new C9777c(2400, 380, 48, 800, 200);
        }
        return null;
    }
}
