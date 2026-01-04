package p644t1;

import android.p018os.DynamicEffect;
import android.p018os.HapticPlayer;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p629s1.C12663b;
import p629s1.C12665d;

/* renamed from: t1.g */
/* loaded from: classes.dex */
public class C12919g implements InterfaceC12914b {

    /* renamed from: a */
    public HapticPlayer f58937a;

    @Override // p644t1.InterfaceC12914b
    /* renamed from: a */
    public void mo8618a(String str) {
        try {
            HapticPlayer hapticPlayer = new HapticPlayer(DynamicEffect.create(C12663b.m76217d(str, true)));
            this.f58937a = hapticPlayer;
            try {
                hapticPlayer.start(1, 0, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            } catch (NoSuchMethodError unused) {
                C12665d.a.m76245d("IHapticEffectPerformer", "no method HapticPlayer.start(loop, interval, amplitude), in TIMED_VIBRATION");
                this.f58937a.start(1);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // p644t1.InterfaceC12914b
    public void stop() {
        try {
            HapticPlayer hapticPlayer = this.f58937a;
            if (hapticPlayer == null) {
                C12665d.a.m76243b("IHapticEffectPerformer", "stop(), HapticsPlayer is null");
            } else {
                hapticPlayer.stop();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
