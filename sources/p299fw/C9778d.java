package p299fw;

import com.ultrasoniclibrary.ultrasoundcore.classfun.FreqParam;

/* renamed from: fw.d */
/* loaded from: classes9.dex */
public class C9778d {

    /* renamed from: a */
    public int f48099a;

    /* renamed from: b */
    public float[] f48100b;

    /* renamed from: c */
    public FreqParam f48101c;

    public C9778d() {
    }

    /* renamed from: a */
    public FreqParam m60838a() {
        return this.f48101c;
    }

    public String toString() {
        return "PositioningResult flag: " + this.f48099a + " mValue: " + this.f48100b[0] + " freqParam: " + this.f48101c.toString();
    }

    public C9778d(int i10, float[] fArr, FreqParam freqParam) {
        this.f48099a = i10;
        this.f48100b = fArr;
        this.f48101c = freqParam;
    }
}
