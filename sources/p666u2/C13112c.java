package p666u2;

import android.animation.TypeEvaluator;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: u2.c */
/* loaded from: classes.dex */
public class C13112c implements TypeEvaluator<Integer> {

    /* renamed from: a */
    public static final C13112c f59602a = new C13112c();

    /* renamed from: b */
    public static C13112c m78888b() {
        return f59602a;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer evaluate(float f10, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        float f11 = ((iIntValue >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) / 255.0f;
        float f12 = ((iIntValue >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) / 255.0f;
        float f13 = ((iIntValue >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) / 255.0f;
        int iIntValue2 = num2.intValue();
        float f14 = ((iIntValue2 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) / 255.0f;
        float f15 = ((iIntValue2 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) / 255.0f;
        float f16 = ((iIntValue2 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) / 255.0f;
        float fPow = (float) Math.pow(f12, 2.2d);
        float fPow2 = (float) Math.pow(f13, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(f15, 2.2d);
        float f17 = f11 + ((f14 - f11) * f10);
        float fPow5 = fPow2 + ((((float) Math.pow(f16, 2.2d)) - fPow2) * f10);
        float fPow6 = fPow3 + (f10 * (((float) Math.pow((iIntValue2 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) / 255.0f, 2.2d)) - fPow3));
        float fPow7 = ((float) Math.pow(fPow + ((fPow4 - fPow) * f10), 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fPow5, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fPow6, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(f17 * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
