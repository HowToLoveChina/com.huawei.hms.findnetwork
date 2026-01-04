package com.huawei.uikit.hwcommon.anim;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.util.Pair;
import android.view.View;
import com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr;
import java.util.Map;

/* loaded from: classes7.dex */
public class HwFocusColorGradientAnimListener implements HwGradientAnimatorMgr.OnAnimatorListener {
    public static final String KEY_ICON_COLOR = "icon_color";
    public static final String KEY_TEXT_COLOR = "text_color";

    /* renamed from: j */
    private static final String f42022j = "background_color";

    /* renamed from: a */
    private View f42023a;

    /* renamed from: b */
    private UpdateColorCallback f42024b;

    /* renamed from: e */
    private ColorStateList f42027e;

    /* renamed from: f */
    private UpdateColorCallback f42028f;

    /* renamed from: h */
    private ColorStateList f42030h;

    /* renamed from: i */
    private UpdateColorCallback f42031i;

    /* renamed from: c */
    private boolean f42025c = true;

    /* renamed from: d */
    private boolean f42026d = true;

    /* renamed from: g */
    private boolean f42029g = true;

    public interface UpdateColorCallback {
        void onEnd(ColorStateList colorStateList);

        void onStart();

        void onUpdate(int i10);
    }

    public HwFocusColorGradientAnimListener(View view, UpdateColorCallback updateColorCallback) {
        this.f42023a = view;
        this.f42024b = updateColorCallback;
    }

    /* renamed from: a */
    private int m54204a(int[] iArr, ColorStateList colorStateList) {
        if (colorStateList != null) {
            return colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        }
        return 0;
    }

    public UpdateColorCallback getExtraColorCallback(String str) {
        if (KEY_ICON_COLOR.equals(str)) {
            return this.f42028f;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            return this.f42031i;
        }
        return null;
    }

    public ColorStateList getExtraColorStateList(String str) {
        if (KEY_ICON_COLOR.equals(str)) {
            return this.f42027e;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            return this.f42030h;
        }
        return null;
    }

    public boolean isEnabled() {
        return this.f42025c;
    }

    public boolean isExtraColorAnimEnabled(String str) {
        if (KEY_ICON_COLOR.equals(str)) {
            return this.f42026d;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            return this.f42029g;
        }
        return false;
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationCancel(Animator animator, String str) {
        onAnimationEnd(animator, str);
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationEnd(Animator animator, String str) {
        UpdateColorCallback updateColorCallback;
        ColorStateList colorStateList;
        UpdateColorCallback updateColorCallback2;
        ColorStateList colorStateList2;
        if (this.f42026d && KEY_ICON_COLOR.equals(str) && (updateColorCallback2 = this.f42028f) != null && (colorStateList2 = this.f42027e) != null) {
            updateColorCallback2.onEnd(colorStateList2);
        }
        if (this.f42029g && KEY_TEXT_COLOR.equals(str) && (updateColorCallback = this.f42031i) != null && (colorStateList = this.f42030h) != null) {
            updateColorCallback.onEnd(colorStateList);
        }
        if (f42022j.equals(str)) {
            ColorStateList backgroundTintList = this.f42023a.getBackgroundTintList();
            UpdateColorCallback updateColorCallback3 = this.f42024b;
            if (updateColorCallback3 == null || backgroundTintList == null) {
                return;
            }
            updateColorCallback3.onEnd(backgroundTintList);
        }
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationStart(Animator animator, String str) {
        UpdateColorCallback updateColorCallback;
        UpdateColorCallback updateColorCallback2;
        UpdateColorCallback updateColorCallback3;
        if (this.f42026d && KEY_ICON_COLOR.equals(str) && (updateColorCallback3 = this.f42028f) != null && this.f42027e != null) {
            updateColorCallback3.onStart();
        }
        if (this.f42029g && KEY_TEXT_COLOR.equals(str) && (updateColorCallback2 = this.f42031i) != null && this.f42030h != null) {
            updateColorCallback2.onStart();
        }
        if (!f42022j.equals(str) || (updateColorCallback = this.f42024b) == null) {
            return;
        }
        updateColorCallback.onStart();
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationUpdate(Animator animator, String str, int i10) {
        UpdateColorCallback updateColorCallback;
        UpdateColorCallback updateColorCallback2;
        if (this.f42026d && KEY_ICON_COLOR.equals(str) && (updateColorCallback2 = this.f42028f) != null && this.f42027e != null) {
            updateColorCallback2.onUpdate(i10);
        }
        if (this.f42029g && KEY_TEXT_COLOR.equals(str) && (updateColorCallback = this.f42031i) != null && this.f42030h != null) {
            updateColorCallback.onUpdate(i10);
        }
        if (f42022j.equals(str)) {
            m54205a(i10);
        }
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public boolean onPrepareAnimation(int[] iArr, int[] iArr2, int i10, int i11, Map<String, Pair<Integer, Integer>> map) {
        int iM54204a;
        int iM54204a2;
        boolean z10;
        int iM54204a3;
        int iM54204a4;
        boolean z11;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        if (!this.f42025c) {
            return false;
        }
        boolean zM54206a = m54206a(iArr2);
        boolean zM54206a2 = m54206a(iArr);
        if ((!zM54206a || zM54206a2) && (zM54206a || !zM54206a2)) {
            m54205a(i10);
            return false;
        }
        boolean z12 = i10 != i11;
        if (!this.f42026d || (colorStateList2 = this.f42027e) == null || this.f42028f == null) {
            iM54204a = 0;
            iM54204a2 = 0;
            z10 = false;
        } else {
            iM54204a = m54204a(iArr2, colorStateList2);
            iM54204a2 = m54204a(iArr, this.f42027e);
            z10 = iM54204a != iM54204a2;
        }
        if (!this.f42029g || (colorStateList = this.f42030h) == null || this.f42031i == null) {
            iM54204a3 = 0;
            iM54204a4 = 0;
            z11 = false;
        } else {
            iM54204a4 = m54204a(iArr2, colorStateList);
            iM54204a3 = m54204a(iArr, this.f42030h);
            z11 = iM54204a4 != iM54204a3;
        }
        if (!z12 && !z10 && !z11) {
            m54205a(i10);
            return false;
        }
        if (z12) {
            map.put(f42022j, new Pair<>(Integer.valueOf(i11), Integer.valueOf(i10)));
        }
        if (z10) {
            map.put(KEY_ICON_COLOR, new Pair<>(Integer.valueOf(iM54204a), Integer.valueOf(iM54204a2)));
        }
        if (z11) {
            map.put(KEY_TEXT_COLOR, new Pair<>(Integer.valueOf(iM54204a4), Integer.valueOf(iM54204a3)));
        }
        return true;
    }

    public void setEnabled(boolean z10) {
        this.f42025c = z10;
    }

    public void setExtraColorAnimEnabled(String str, boolean z10) {
        if (KEY_ICON_COLOR.equals(str)) {
            this.f42026d = z10;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            this.f42029g = z10;
        }
    }

    public void setExtraColorStateList(String str, ColorStateList colorStateList, UpdateColorCallback updateColorCallback) {
        if (KEY_ICON_COLOR.equals(str)) {
            this.f42027e = colorStateList;
            this.f42028f = updateColorCallback;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            this.f42030h = colorStateList;
            this.f42031i = updateColorCallback;
        }
    }

    /* renamed from: a */
    private boolean m54206a(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842908) {
                z10 = true;
            }
            if (i10 == 16842909) {
                z11 = true;
            }
        }
        return z10 && z11;
    }

    /* renamed from: a */
    private void m54205a(int i10) {
        UpdateColorCallback updateColorCallback = this.f42024b;
        if (updateColorCallback == null) {
            this.f42023a.getBackground().setTint(i10);
        } else {
            updateColorCallback.onUpdate(i10);
        }
        this.f42023a.invalidate();
    }
}
