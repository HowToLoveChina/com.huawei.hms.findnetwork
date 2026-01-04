package cn.com.miaozhen.mobile.tracking.api;

import android.content.Context;
import android.view.View;
import cn.com.miaozhen.mobile.tracking.p055a.C1466c;
import cn.com.miaozhen.mobile.tracking.p055a.C1471h;
import cn.com.miaozhen.mobile.tracking.viewability.origin.C1498c;
import cn.com.miaozhen.mobile.tracking.viewability.origin.C1499d;
import cn.com.miaozhen.mobile.tracking.viewability.origin.InterfaceC1496a;
import cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack;
import cn.com.miaozhen.mobile.tracking.viewability.origin.p059e.C1506g;
import ijiami_release01.NCall;
import java.util.HashMap;

/* renamed from: cn.com.miaozhen.mobile.tracking.api.d */
/* loaded from: classes.dex */
public class C1480d {

    /* renamed from: a */
    private Context f6334a;

    /* renamed from: b */
    private InterfaceC1496a f6335b;

    /* renamed from: c */
    private HashMap<String, String> f6336c;

    /* renamed from: d */
    private C1471h f6337d;

    /* renamed from: e */
    private C1506g f6338e = m8378a();

    /* renamed from: f */
    private C1498c f6339f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: cn.com.miaozhen.mobile.tracking.api.d$a */
    public static final class a {

        /* renamed from: a */
        public static final a f6340a = null;

        /* renamed from: b */
        public static final a f6341b = null;

        /* renamed from: c */
        public static final a f6342c = null;

        /* renamed from: d */
        public static final a f6343d = null;

        /* renamed from: e */
        public static final a f6344e = null;

        /* renamed from: f */
        public static final a f6345f = null;

        /* renamed from: g */
        public static final a f6346g = null;

        /* renamed from: h */
        public static final a f6347h = null;

        /* renamed from: i */
        private static final /* synthetic */ a[] f6348i = null;

        static {
            NCall.m64618IV(new Object[]{7});
        }

        private a(String str, int i10) {
        }

        public static a valueOf(String str) {
            return (a) NCall.m64616IL(new Object[]{8, str});
        }

        public static a[] values() {
            return (a[]) NCall.m64616IL(new Object[]{9});
        }
    }

    public C1480d(Context context, InterfaceC1496a interfaceC1496a, C1471h c1471h) {
        this.f6336c = null;
        this.f6334a = context;
        this.f6335b = interfaceC1496a;
        this.f6336c = new HashMap<>();
        this.f6337d = c1471h;
        this.f6339f = new C1498c(context, interfaceC1496a, this.f6338e);
    }

    /* renamed from: a */
    private C1466c m8377a(String str) {
        return (C1466c) NCall.m64616IL(new Object[]{10, this, str});
    }

    /* renamed from: b */
    private String m8385b(C1466c c1466c) {
        return (String) NCall.m64616IL(new Object[]{18, this, c1466c});
    }

    /* renamed from: c */
    public void m8391c(String str, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{24, this, str, view, Integer.valueOf(i10), mzCallBack});
    }

    /* renamed from: a */
    private C1506g m8378a() {
        return (C1506g) NCall.m64616IL(new Object[]{11, this});
    }

    /* renamed from: b */
    public void m8389b(String str) {
        NCall.m64618IV(new Object[]{22, this, str});
    }

    /* renamed from: a */
    private static String m8379a(Context context, String str, C1466c c1466c) {
        return (String) NCall.m64616IL(new Object[]{12, context, str, c1466c});
    }

    /* renamed from: b */
    public void m8390b(String str, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{23, this, str, view, Integer.valueOf(i10), mzCallBack});
    }

    /* renamed from: a */
    private String m8380a(C1466c c1466c) {
        return (String) NCall.m64616IL(new Object[]{13, this, c1466c});
    }

    /* renamed from: a */
    private String m8381a(C1466c c1466c, C1499d c1499d, String str) {
        return (String) NCall.m64616IL(new Object[]{14, this, c1466c, c1499d, str});
    }

    /* renamed from: a */
    private String m8382a(C1466c c1466c, String str) {
        return (String) NCall.m64616IL(new Object[]{15, this, c1466c, str});
    }

    /* renamed from: a */
    private String m8383a(C1471h c1471h, String str, C1466c c1466c, a aVar, String str2) {
        return (String) NCall.m64616IL(new Object[]{16, this, c1471h, str, c1466c, aVar, str2});
    }

    /* renamed from: a */
    public void m8386a(String str, View view, int i10, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{19, this, str, view, Integer.valueOf(i10), mzCallBack});
    }

    /* renamed from: a */
    public void m8387a(String str, View view, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{20, this, str, view, mzCallBack});
    }

    /* renamed from: a */
    private void m8384a(String str, a aVar, View view, int i10, int i11, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{17, this, str, aVar, view, Integer.valueOf(i10), Integer.valueOf(i11), mzCallBack});
    }

    /* renamed from: a */
    public void m8388a(String str, MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{21, this, str, mzCallBack});
    }
}
