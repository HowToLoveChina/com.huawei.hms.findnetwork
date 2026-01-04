package p307g3;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p723w.C13503b;

/* renamed from: g3.b */
/* loaded from: classes.dex */
public class C9876b {

    /* renamed from: a */
    public static final boolean f48499a = true;

    /* renamed from: b */
    public static final int[] f48500b = {R.attr.state_pressed};

    /* renamed from: c */
    public static final int[] f48501c = {R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: d */
    public static final int[] f48502d = {R.attr.state_focused};

    /* renamed from: e */
    public static final int[] f48503e = {R.attr.state_hovered};

    /* renamed from: f */
    public static final int[] f48504f = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: g */
    public static final int[] f48505g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: h */
    public static final int[] f48506h = {R.attr.state_selected, R.attr.state_focused};

    /* renamed from: i */
    public static final int[] f48507i = {R.attr.state_selected, R.attr.state_hovered};

    /* renamed from: j */
    public static final int[] f48508j = {R.attr.state_selected};

    /* renamed from: k */
    public static final int[] f48509k = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: l */
    public static final String f48510l = C9876b.class.getSimpleName();

    /* renamed from: a */
    public static ColorStateList m61322a(ColorStateList colorStateList) {
        if (f48499a) {
            return new ColorStateList(new int[][]{f48508j, StateSet.NOTHING}, new int[]{m61324c(colorStateList, f48504f), m61324c(colorStateList, f48500b)});
        }
        int[] iArr = f48504f;
        int[] iArr2 = f48505g;
        int[] iArr3 = f48506h;
        int[] iArr4 = f48507i;
        int[] iArr5 = f48500b;
        int[] iArr6 = f48501c;
        int[] iArr7 = f48502d;
        int[] iArr8 = f48503e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f48508j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{m61324c(colorStateList, iArr), m61324c(colorStateList, iArr2), m61324c(colorStateList, iArr3), m61324c(colorStateList, iArr4), 0, m61324c(colorStateList, iArr5), m61324c(colorStateList, iArr6), m61324c(colorStateList, iArr7), m61324c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    /* renamed from: b */
    public static int m61323b(int i10) {
        return C13503b.m81226j(i10, Math.min(Color.alpha(i10) * 2, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA));
    }

    /* renamed from: c */
    public static int m61324c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f48499a ? m61323b(colorForState) : colorForState;
    }

    /* renamed from: d */
    public static ColorStateList m61325d(ColorStateList colorStateList) {
        return colorStateList != null ? colorStateList : ColorStateList.valueOf(0);
    }

    /* renamed from: e */
    public static boolean m61326e(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
