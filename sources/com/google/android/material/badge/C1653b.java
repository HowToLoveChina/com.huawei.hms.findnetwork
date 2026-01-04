package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;

/* renamed from: com.google.android.material.badge.b */
/* loaded from: classes.dex */
public class C1653b {

    /* renamed from: a */
    public static final boolean f7497a = false;

    /* renamed from: a */
    public static void m9699a(C1652a c1652a, View view, FrameLayout frameLayout) {
        m9703e(c1652a, view, frameLayout);
        if (c1652a.m9682h() != null) {
            c1652a.m9682h().setForeground(c1652a);
        } else {
            if (f7497a) {
                throw new IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(c1652a);
        }
    }

    /* renamed from: b */
    public static SparseArray<C1652a> m9700b(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray<C1652a> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i10 = 0; i10 < parcelableSparseArray.size(); i10++) {
            int iKeyAt = parcelableSparseArray.keyAt(i10);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i10);
            if (state == null) {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
            sparseArray.put(iKeyAt, C1652a.m9671d(context, state));
        }
        return sparseArray;
    }

    /* renamed from: c */
    public static ParcelableSparseArray m9701c(SparseArray<C1652a> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int iKeyAt = sparseArray.keyAt(i10);
            C1652a c1652aValueAt = sparseArray.valueAt(i10);
            if (c1652aValueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(iKeyAt, c1652aValueAt.m9686l());
        }
        return parcelableSparseArray;
    }

    /* renamed from: d */
    public static void m9702d(C1652a c1652a, View view) {
        if (c1652a == null) {
            return;
        }
        if (f7497a || c1652a.m9682h() != null) {
            c1652a.m9682h().setForeground(null);
        } else {
            view.getOverlay().remove(c1652a);
        }
    }

    /* renamed from: e */
    public static void m9703e(C1652a c1652a, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        c1652a.setBounds(rect);
        c1652a.m9675B(view, frameLayout);
    }

    /* renamed from: f */
    public static void m9704f(Rect rect, float f10, float f11, float f12, float f13) {
        rect.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
    }
}
