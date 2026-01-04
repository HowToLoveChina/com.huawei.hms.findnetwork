package p644t1;

import android.os.VibrationEffect;
import android.os.Vibrator;
import java.util.ArrayList;
import p629s1.C12663b;
import p629s1.C12665d;

/* renamed from: t1.e */
/* loaded from: classes.dex */
public class C12917e implements InterfaceC12914b {

    /* renamed from: a */
    public Vibrator f58932a;

    public C12917e(Vibrator vibrator) {
        if (vibrator == null) {
            C12665d.a.m76243b("GooglePerformer", "GooglePerformer(Vibrator), vibrator == null");
        } else {
            this.f58932a = vibrator;
        }
    }

    @Override // p644t1.InterfaceC12914b
    /* renamed from: a */
    public void mo8618a(String str) {
        try {
            String strM76217d = C12663b.m76217d(str, true);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            C12663b.m76222i(strM76217d, arrayList, arrayList2);
            if (arrayList.size() != 0 && arrayList.size() == arrayList2.size()) {
                C12665d.a.m76242a("GooglePerformer", "timings:" + arrayList.toString() + ",amplitudes:" + arrayList2.toString());
                long[] jArr = new long[arrayList.size()];
                int[] iArr = new int[arrayList2.size()];
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    jArr[i10] = ((Long) arrayList.get(i10)).longValue();
                    iArr[i10] = ((Integer) arrayList2.get(i10)).intValue();
                }
                this.f58932a.vibrate(VibrationEffect.createWaveform(jArr, iArr, -1));
                return;
            }
            C12665d.a.m76243b("GooglePerformer", "start(String), invalid timings and amplitudes!");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // p644t1.InterfaceC12914b
    public void stop() {
        Vibrator vibrator = this.f58932a;
        if (vibrator == null) {
            C12665d.a.m76243b("GooglePerformer", "stop(), null == mVibrator!");
        } else {
            vibrator.cancel();
        }
    }
}
