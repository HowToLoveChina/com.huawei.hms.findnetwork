package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ru */
/* loaded from: classes8.dex */
public class C7645ru {

    /* renamed from: a */
    public static final int[] f35598a = {1, 3, 2, 4};

    /* renamed from: b */
    public static final int[] f35599b = {0, 3, 2, 4};

    /* renamed from: c */
    public static final int[] f35600c = {3, 2, 4};

    /* renamed from: a */
    public static AbstractC7644rt m47117a(Context context, ContentRecord contentRecord, StackTraceElement[] stackTraceElementArr, View view, int[] iArr) {
        if (context == null || contentRecord == null) {
            return new C7643rs();
        }
        List<AbstractC7644rt> listM47118b = m47118b(context, contentRecord, stackTraceElementArr, view, iArr);
        if (AbstractC7760bg.m47767a(listM47118b)) {
            return new C7643rs();
        }
        AbstractC7644rt abstractC7644rt = null;
        for (AbstractC7644rt abstractC7644rt2 : listM47118b) {
            if (abstractC7644rt != null) {
                abstractC7644rt.m47116a(abstractC7644rt2);
            }
            abstractC7644rt = abstractC7644rt2;
        }
        return listM47118b.get(0);
    }

    /* renamed from: b */
    private static List<AbstractC7644rt> m47118b(Context context, ContentRecord contentRecord, StackTraceElement[] stackTraceElementArr, View view, int[] iArr) {
        AbstractC7644rt c7642rr;
        if (iArr == null || iArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            if (i10 == 0) {
                c7642rr = new C7642rr(context, contentRecord, stackTraceElementArr, view);
            } else if (i10 == 1) {
                c7642rr = new C7648rx(context, contentRecord, stackTraceElementArr, view);
            } else if (i10 == 2) {
                c7642rr = new C7641rq(context, contentRecord, view);
            } else if (i10 == 3) {
                c7642rr = new C7647rw(context, contentRecord, view);
            } else if (i10 != 4) {
                AbstractC7185ho.m43823c("SafeDetectorFactory", "create safe detector, fall to default");
                c7642rr = null;
            } else {
                c7642rr = new C7646rv(context, contentRecord, view);
            }
            if (c7642rr != null) {
                arrayList.add(c7642rr);
            }
        }
        return arrayList;
    }
}
