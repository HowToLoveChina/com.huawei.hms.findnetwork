package com.huawei.openalliance.p169ad;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: com.huawei.openalliance.ad.tp */
/* loaded from: classes8.dex */
public class C7694tp extends AbstractC7693to {
    /* renamed from: a */
    public static int m47282a(MotionEvent motionEvent) {
        return motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
    }

    /* renamed from: b */
    public static MaterialClickInfo m47286b(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return new MaterialClickInfo();
        }
        StringBuilder sb2 = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        if (AbstractC7693to.m47280a(view)) {
            return m47288c(view, motionEvent);
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        sb2.append(width);
        sb2.append("*");
        sb2.append(height);
        return new MaterialClickInfo.C7296a().m44532a(Integer.valueOf((int) x10)).m44536b(Integer.valueOf((int) y10)).m44538b(sb2.toString()).m44537b(Long.valueOf(System.currentTimeMillis())).m44535a();
    }

    /* renamed from: c */
    private static MaterialClickInfo m47288c(View view, MotionEvent motionEvent) {
        float left = view.getLeft() + motionEvent.getX();
        float top = view.getTop() + motionEvent.getY();
        StringBuilder sb2 = new StringBuilder();
        ViewParent parent = view.getParent();
        for (int i10 = 0; i10 < 5 && parent != null; i10++) {
            if (AbstractC7693to.m47281a(parent)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                int width = viewGroup.getWidth();
                int height = viewGroup.getHeight();
                sb2.append(width);
                sb2.append("*");
                sb2.append(height);
                return new MaterialClickInfo.C7296a().m44532a(Integer.valueOf((int) left)).m44536b(Integer.valueOf((int) top)).m44538b(sb2.toString()).m44537b(Long.valueOf(System.currentTimeMillis())).m44535a();
            }
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) parent;
                left += viewGroup2.getLeft();
                top += viewGroup2.getTop();
            }
            parent = parent.getParent();
        }
        return new MaterialClickInfo();
    }

    /* renamed from: a */
    public static MaterialClickInfo m47283a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return new MaterialClickInfo();
        }
        StringBuilder sb2 = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        sb2.append(width);
        sb2.append("*");
        sb2.append(height);
        return new MaterialClickInfo.C7296a().m44532a(Integer.valueOf((int) x10)).m44536b(Integer.valueOf((int) y10)).m44538b(sb2.toString()).m44537b(Long.valueOf(System.currentTimeMillis())).m44535a();
    }

    /* renamed from: b */
    public static void m47287b(View view, MotionEvent motionEvent, Integer num, MaterialClickInfo materialClickInfo) {
        m47285a(view, motionEvent, num, materialClickInfo, true);
    }

    /* renamed from: a */
    public static void m47284a(View view, MotionEvent motionEvent, Integer num, MaterialClickInfo materialClickInfo) {
        m47285a(view, motionEvent, num, materialClickInfo, false);
    }

    /* renamed from: a */
    private static void m47285a(View view, MotionEvent motionEvent, Integer num, MaterialClickInfo materialClickInfo, boolean z10) {
        if (materialClickInfo == null || view == null || motionEvent == null) {
            return;
        }
        materialClickInfo.m44504a(Long.valueOf(System.currentTimeMillis()));
        materialClickInfo.m44502a(Float.valueOf(AbstractC7807d.m48245j(view.getContext())));
        if (num != null) {
            materialClickInfo.m44509c(num);
        }
        if (materialClickInfo.m44510d() == null) {
            materialClickInfo.m44509c(0);
        }
        MaterialClickInfo materialClickInfoM47286b = z10 ? m47286b(view, motionEvent) : m47283a(view, motionEvent);
        if (materialClickInfoM47286b != null) {
            materialClickInfo.m44511d(materialClickInfoM47286b.m44501a());
            materialClickInfo.m44513e(materialClickInfoM47286b.m44506b());
        }
    }
}
