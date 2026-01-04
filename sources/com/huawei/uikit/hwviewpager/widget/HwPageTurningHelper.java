package com.huawei.uikit.hwviewpager.widget;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* loaded from: classes9.dex */
public class HwPageTurningHelper {
    public static final float DEFAULT_THRESHOLD_RATIO = 0.125f;

    /* renamed from: f */
    private static final String f44599f = "HwPageTurningHelper";

    /* renamed from: a */
    private float f44600a = 0.125f;

    /* renamed from: b */
    private float f44601b = 0.125f;

    /* renamed from: c */
    private float f44602c;

    /* renamed from: d */
    private float f44603d;

    /* renamed from: e */
    private HwViewPager f44604e;

    public HwPageTurningHelper(HwViewPager hwViewPager) {
        this.f44604e = hwViewPager;
    }

    /* renamed from: a */
    public void m55776a(MotionEvent motionEvent) {
        this.f44602c = motionEvent.getX();
        this.f44603d = motionEvent.getY();
    }

    /* renamed from: b */
    public void m55777b(MotionEvent motionEvent) {
        if (this.f44604e == null) {
            return;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (!this.f44604e.isPageScrollHorizontal()) {
            m55775b(this.f44603d - y10);
            return;
        }
        float f10 = this.f44602c - x10;
        if (m55774a()) {
            f10 = -f10;
        }
        m55773a(f10);
    }

    /* renamed from: c */
    public void m55778c(float f10) {
        this.f44601b = f10;
    }

    /* renamed from: d */
    public void m55779d(float f10) {
        this.f44600a = f10;
    }

    /* renamed from: a */
    private void m55773a(float f10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44604e == null) {
            return;
        }
        if (Float.compare(Math.abs(f10), ((this.f44604e.getWidth() - this.f44604e.getPaddingLeft()) - r0.getPaddingRight()) * this.f44601b) < 0) {
            Log.w(f44599f, "the horizontal condition is not met.");
            return;
        }
        if (f10 < 0.0f) {
            this.f44604e.prePage(false);
        } else if (f10 > 0.0f) {
            this.f44604e.nextPage(false, false);
        } else {
            Log.d(f44599f, "the horizontal deltaX is zero.");
        }
    }

    /* renamed from: b */
    private void m55775b(float f10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44604e == null) {
            return;
        }
        if (Float.compare(Math.abs(f10), ((this.f44604e.getHeight() - this.f44604e.getPaddingTop()) - r0.getPaddingBottom()) * this.f44600a) < 0) {
            Log.w(f44599f, "the vertical condition is not met.");
            return;
        }
        if (f10 < 0.0f) {
            this.f44604e.prePage(false);
        } else if (f10 > 0.0f) {
            this.f44604e.nextPage(false, false);
        } else {
            Log.d(f44599f, "the vertical deltaY is zero.");
        }
    }

    /* renamed from: a */
    private boolean m55774a() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
}
