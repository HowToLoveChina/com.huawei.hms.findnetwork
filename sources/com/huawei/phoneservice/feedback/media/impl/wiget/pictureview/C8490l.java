package com.huawei.phoneservice.feedback.media.impl.wiget.pictureview;

import android.widget.ImageView;

/* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.l */
/* loaded from: classes5.dex */
public class C8490l {
    /* renamed from: a */
    public static int m52737a(int i10) {
        return (i10 & 65280) >> 8;
    }

    /* renamed from: b */
    public static void m52738b(float f10, float f11, float f12) {
        if (f10 >= f11) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f11 >= f12) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* renamed from: c */
    public static boolean m52739c(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (scaleType != ImageView.ScaleType.MATRIX) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }

    /* renamed from: d */
    public static boolean m52740d(ImageView imageView) {
        return imageView.getDrawable() != null;
    }
}
