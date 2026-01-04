package cn.com.miaozhen.mobile.tracking.viewability.origin.p059e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import cn.com.miaozhen.mobile.tracking.p056b.p057a.C1481a;
import cn.com.miaozhen.mobile.tracking.viewability.origin.p060f.C1510a;
import cn.com.miaozhen.mobile.tracking.viewability.origin.p060f.C1511b;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.riemann.location.common.utils.Constant;
import ijiami_release01.NCall;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.e.j */
/* loaded from: classes.dex */
public class C1509j implements Serializable {

    /* renamed from: a */
    private long f6460a;

    /* renamed from: b */
    private String f6461b;

    /* renamed from: c */
    private String f6462c;

    /* renamed from: d */
    private String f6463d;

    /* renamed from: e */
    private float f6464e;

    /* renamed from: f */
    private int f6465f;

    /* renamed from: g */
    private int f6466g;

    /* renamed from: h */
    private int f6467h;

    /* renamed from: i */
    private double f6468i;

    /* renamed from: j */
    private int f6469j;

    /* renamed from: k */
    private boolean f6470k;

    /* renamed from: l */
    private List<C1511b> f6471l;

    /* renamed from: m */
    Set<String> f6472m;

    public C1509j(View view, Context context) {
        Rect rectM8572a;
        this.f6470k = false;
        this.f6471l = null;
        this.f6472m = null;
        try {
            this.f6460a = System.currentTimeMillis();
            this.f6471l = new ArrayList();
            this.f6472m = new HashSet();
            this.f6461b = view.getWidth() + Constants.MULTIPLE_SIGN + view.getHeight();
            Rect rectM8393a = C1481a.m8393a(view);
            Point point = new Point();
            point.x = rectM8393a.left;
            point.y = rectM8393a.top;
            this.f6462c = point.x + Constants.MULTIPLE_SIGN + point.y;
            if (!m8575a(view) && (rectM8572a = m8572a(view, rectM8393a)) != null) {
                rectM8393a = rectM8572a;
            }
            this.f6464e = view.getAlpha();
            this.f6465f = view.isShown() ? 1 : 0;
            Rect rectM8392a = C1481a.m8392a(context);
            Rect rect = new Rect();
            rect.setIntersect(rectM8393a, rectM8392a);
            this.f6463d = Math.abs(rect.right - rect.left) + Constants.MULTIPLE_SIGN + Math.abs(rect.bottom - rect.top);
            boolean zM8577c = m8577c(view);
            this.f6470k = zM8577c;
            if (zM8577c) {
                m8579e(view);
                double dM8595a = this.f6471l.size() > 0 ? new C1510a().m8595a(this.f6471l) : 0.0d;
                view.getGlobalVisibleRect(new Rect());
                double width = view.getWidth() * view.getHeight();
                this.f6468i = Math.round(((dM8595a + (width - ((r10.right - r10.left) * (r10.bottom - r10.top)))) / width) * 100.0d) / 100.0d;
            } else {
                this.f6468i = 1.0d;
            }
            this.f6466g = C1481a.m8394b(view) ? 1 : 0;
            this.f6467h = view.hasWindowFocus() ? 1 : 0;
            view.getLocalVisibleRect(new Rect());
            this.f6471l = null;
            this.f6472m = null;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private int m8571a(View view, ViewGroup viewGroup) {
        return NCall.m64614II(new Object[]{Integer.valueOf(PlayerConstants.EventCode.CAN_NOT_SUPPORT_PROXY), this, view, viewGroup});
    }

    /* renamed from: b */
    public float m8584b() {
        return NCall.m64613IF(new Object[]{230, this});
    }

    /* renamed from: c */
    public long m8585c() {
        return NCall.m64615IJ(new Object[]{231, this});
    }

    /* renamed from: d */
    public double m8586d() {
        return NCall.m64612ID(new Object[]{232, this});
    }

    /* renamed from: e */
    public int m8587e() {
        return NCall.m64614II(new Object[]{233, this});
    }

    public boolean equals(Object obj) {
        return NCall.m64619IZ(new Object[]{Integer.valueOf(Constant.ERROR_LOCATION_INVALID), this, obj});
    }

    /* renamed from: f */
    public int m8588f() {
        return NCall.m64614II(new Object[]{235, this});
    }

    /* renamed from: g */
    public int m8589g() {
        return NCall.m64614II(new Object[]{236, this});
    }

    /* renamed from: h */
    public String m8590h() {
        return (String) NCall.m64616IL(new Object[]{237, this});
    }

    public int hashCode() {
        return NCall.m64614II(new Object[]{238, this});
    }

    /* renamed from: i */
    public String m8591i() {
        return (String) NCall.m64616IL(new Object[]{239, this});
    }

    public String toString() {
        return (String) NCall.m64616IL(new Object[]{240, this});
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private Rect m8572a(View view, Rect rect) {
        return (Rect) NCall.m64616IL(new Object[]{Integer.valueOf(PlayerConstants.EventCode.LAYOUT_NOT_SUPPORT_SUBTITLE), this, view, rect});
    }

    /* renamed from: b */
    private boolean m8576b(View view) {
        return NCall.m64619IZ(new Object[]{Integer.valueOf(Constant.ERROR_WSS_LOW_FREQ), this, view});
    }

    /* renamed from: c */
    private boolean m8577c(View view) {
        return NCall.m64619IZ(new Object[]{Integer.valueOf(Constant.ERROR_WSS_TIME_DIFF_LARGE), this, view});
    }

    /* renamed from: d */
    private boolean m8578d(View view) {
        return NCall.m64619IZ(new Object[]{Integer.valueOf(Constant.ERROR_WSS_INVALID), this, view});
    }

    /* renamed from: e */
    private void m8579e(View view) {
        NCall.m64618IV(new Object[]{225, this, view});
    }

    /* renamed from: a */
    public String m8580a() {
        return (String) NCall.m64616IL(new Object[]{Integer.valueOf(Constant.ERROR_WSS_SPEED_JUMP), this});
    }

    /* renamed from: a */
    private void m8573a(Rect rect, Rect rect2) {
        NCall.m64618IV(new Object[]{219, this, rect, rect2});
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m8574a(View view, View view2) {
        NCall.m64618IV(new Object[]{220, this, view, view2});
    }

    /* renamed from: a */
    public void m8581a(View view, ViewGroup viewGroup, Set<String> set) {
        NCall.m64618IV(new Object[]{227, this, view, viewGroup, set});
    }

    /* renamed from: a */
    public boolean m8582a(float f10) {
        return NCall.m64619IZ(new Object[]{228, this, Float.valueOf(f10)});
    }

    /* renamed from: a */
    private boolean m8575a(View view) {
        return NCall.m64619IZ(new Object[]{Integer.valueOf(Constant.ERROR_WSS_NO_DATA), this, view});
    }

    /* renamed from: a */
    public boolean m8583a(C1509j c1509j) {
        return NCall.m64619IZ(new Object[]{229, this, c1509j});
    }
}
