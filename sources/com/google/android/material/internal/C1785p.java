package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.google.android.material.internal.p */
/* loaded from: classes.dex */
public class C1785p {

    /* renamed from: a */
    public static final Comparator<View> f8406a = new a();

    /* renamed from: com.google.android.material.internal.p$a */
    public class a implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    }

    /* renamed from: a */
    public static ImageView m10772a(Toolbar toolbar, Drawable drawable) {
        ImageView imageView;
        Drawable drawable2;
        if (drawable == null) {
            return null;
        }
        for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
            View childAt = toolbar.getChildAt(i10);
            if ((childAt instanceof ImageView) && (drawable2 = (imageView = (ImageView) childAt).getDrawable()) != null && drawable2.getConstantState() != null && drawable2.getConstantState().equals(drawable.getConstantState())) {
                return imageView;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static ImageView m10773b(Toolbar toolbar) {
        return m10772a(toolbar, toolbar.getLogo());
    }

    /* renamed from: c */
    public static TextView m10774c(Toolbar toolbar) {
        List<TextView> listM10775d = m10775d(toolbar, toolbar.getSubtitle());
        if (listM10775d.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(listM10775d, f8406a);
    }

    /* renamed from: d */
    public static List<TextView> m10775d(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
            View childAt = toolbar.getChildAt(i10);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static TextView m10776e(Toolbar toolbar) {
        List<TextView> listM10775d = m10775d(toolbar, toolbar.getTitle());
        if (listM10775d.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(listM10775d, f8406a);
    }
}
