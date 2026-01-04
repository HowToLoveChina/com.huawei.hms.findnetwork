package com.huawei.uikit.hweventbadge.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.uikit.hweventbadge.C8714R;
import com.huawei.uikit.hweventbadge.drawable.HwEventBadgeDrawable;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes7.dex */
public class HwEventBadge extends View {

    /* renamed from: b */
    private static final int f42837b = 1;

    /* renamed from: c */
    private static final int f42838c = -1;

    /* renamed from: a */
    private HwEventBadgeDrawable f42839a;

    public HwEventBadge(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private static Context m54676a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8714R.style.Theme_Emui_HwEventBadge);
    }

    public static HwEventBadge instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwEventBadge.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwEventBadge.class);
        if (objInstantiate instanceof HwEventBadge) {
            return (HwEventBadge) objInstantiate;
        }
        return null;
    }

    public HwEventBadgeDrawable getHwEventBadgeDrawable() {
        return this.f42839a;
    }

    public int getMode() {
        HwEventBadgeDrawable hwEventBadgeDrawable = this.f42839a;
        if (hwEventBadgeDrawable != null) {
            return hwEventBadgeDrawable.getBadgeMode();
        }
        return -1;
    }

    public TextPaint getTextPaint() {
        HwEventBadgeDrawable hwEventBadgeDrawable = this.f42839a;
        if (hwEventBadgeDrawable == null) {
            return null;
        }
        return hwEventBadgeDrawable.getTextPaint();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(m54675a(getSuggestedMinimumWidth(), i10), m54675a(getSuggestedMinimumHeight(), i11));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        HwEventBadgeDrawable hwEventBadgeDrawable = this.f42839a;
        if (hwEventBadgeDrawable != null) {
            hwEventBadgeDrawable.setBackgroundColor(i10);
        }
    }

    public void setCount(int i10) {
        HwEventBadgeDrawable hwEventBadgeDrawable = this.f42839a;
        if (hwEventBadgeDrawable == null || hwEventBadgeDrawable.getBadgeCount() == i10) {
            return;
        }
        this.f42839a.setBadgeCount(i10);
        if (this.f42839a.getBadgeMode() == 2) {
            requestLayout();
            invalidate();
        }
    }

    public void setHwEventBadgeDrawable(HwEventBadgeDrawable hwEventBadgeDrawable) {
        this.f42839a = hwEventBadgeDrawable;
    }

    public void setMode(int i10) {
        HwEventBadgeDrawable hwEventBadgeDrawable = this.f42839a;
        if (hwEventBadgeDrawable == null || hwEventBadgeDrawable.getBadgeMode() == i10) {
            return;
        }
        this.f42839a.setBadgeMode(i10);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i10) {
        HwEventBadgeDrawable hwEventBadgeDrawable = this.f42839a;
        if (hwEventBadgeDrawable != null) {
            hwEventBadgeDrawable.setTextColor(i10);
        }
    }

    public HwEventBadge(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8714R.attr.hwEventBadgeStyle);
    }

    /* renamed from: a */
    private int m54675a(int i10, int i11) {
        return View.MeasureSpec.getMode(i11) != 1073741824 ? i10 : View.MeasureSpec.getSize(i11);
    }

    public HwEventBadge(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(m54676a(context, i10), attributeSet, i10);
        HwEventBadgeDrawable hwEventBadgeDrawable = new HwEventBadgeDrawable();
        this.f42839a = hwEventBadgeDrawable;
        hwEventBadgeDrawable.parseAttrsAndInit(super.getContext(), attributeSet, i10);
        setBackground(this.f42839a);
    }

    public void setCount(int i10, int i11) {
        HwEventBadgeDrawable hwEventBadgeDrawable = this.f42839a;
        if (hwEventBadgeDrawable != null) {
            int badgeCount = hwEventBadgeDrawable.getBadgeCount();
            int badgeMaxNumber = this.f42839a.getBadgeMaxNumber();
            if (badgeCount == i10 && badgeMaxNumber == i11) {
                return;
            }
            this.f42839a.setBadgeCount(i10, i11);
            if (this.f42839a.getBadgeMode() == 2) {
                requestLayout();
                invalidate();
            }
        }
    }
}
