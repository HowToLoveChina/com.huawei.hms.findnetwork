package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;

/* renamed from: com.huawei.openalliance.ad.ts */
/* loaded from: classes8.dex */
public class C7697ts {
    /* renamed from: a */
    public static void m47307a(Context context, int i10, AbstractC8104h abstractC8104h, ImageView imageView, int i11) {
        m47308a(context, i10, abstractC8104h, imageView, i11, 0);
    }

    /* renamed from: a */
    public static void m47308a(Context context, int i10, AbstractC8104h abstractC8104h, ImageView imageView, int i11, int i12) {
        int i13;
        int iM47535a;
        int viewWith;
        AbstractC7185ho.m43821b("PPSDialogUtil", "getRealOrientation orientation %s", Integer.valueOf(i10));
        if (context == null || abstractC8104h == null || imageView == null) {
            AbstractC7185ho.m43823c("PPSDialogUtil", "param is invalid, return");
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) abstractC8104h.getLayoutParams();
        int iAbs = Math.abs((int) imageView.getX());
        int iM47535a2 = AbstractC7741ao.m47535a(context, 36.0f);
        int i14 = (iM47535a2 >> 1) + iAbs;
        double d10 = iM47535a2 * 0.5d;
        int viewWidthPercent = (int) ((i11 * (1.0f - abstractC8104h.getViewWidthPercent()) * 0.5d) + AbstractC7741ao.m47535a(context, 16.0f) + d10);
        int viewWidthPercent2 = (int) (((i11 * ((abstractC8104h.getViewWidthPercent() * 0.5d) + 0.5d)) - AbstractC7741ao.m47535a(context, 16.0f)) - d10);
        AbstractC7185ho.m43818a("PPSDialogUtil", "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        AbstractC7185ho.m43818a("PPSDialogUtil", "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(iAbs), Integer.valueOf(iM47535a2), Integer.valueOf(i14));
        if (1 == i10 || 9 == i10) {
            i13 = i12;
            if (i14 < viewWidthPercent) {
                AbstractC7185ho.m43817a("PPSDialogUtil", "curImgCenter < locationX");
                layoutParams.removeRule(14);
                abstractC8104h.setLayoutParams(layoutParams);
                iM47535a = iAbs - AbstractC7741ao.m47535a(context, 16.0f);
            } else if (i14 <= viewWidthPercent2) {
                AbstractC7185ho.m43817a("PPSDialogUtil", "locationX =< curImgCenter =< locationX2");
                layoutParams.addRule(14);
                abstractC8104h.setLayoutParams(layoutParams);
                return;
            } else {
                AbstractC7185ho.m43817a("PPSDialogUtil", "curImgCenter > locationX2");
                layoutParams.removeRule(14);
                abstractC8104h.setLayoutParams(layoutParams);
                iM47535a = ((iAbs + iM47535a2) + AbstractC7741ao.m47535a(context, 16.0f)) - abstractC8104h.getViewWith();
                AbstractC7185ho.m43818a("PPSDialogUtil", "paddingStart: %s", Integer.valueOf(iM47535a));
            }
        } else {
            layoutParams.removeRule(14);
            abstractC8104h.setLayoutParams(layoutParams);
            if (i14 < i11 / 3) {
                viewWith = AbstractC7741ao.m47535a(context, 16.0f);
            } else if (i14 < (i11 * 2) / 3) {
                iM47535a = i14 - (abstractC8104h.getViewWith() >> 1);
                i13 = i12;
            } else {
                iAbs = iAbs + iM47535a2 + AbstractC7741ao.m47535a(context, 16.0f);
                viewWith = abstractC8104h.getViewWith();
            }
            iM47535a = iAbs - viewWith;
            i13 = i12;
        }
        abstractC8104h.setPaddingStart(iM47535a - AbstractC7741ao.m47535a(context, i13));
    }
}
