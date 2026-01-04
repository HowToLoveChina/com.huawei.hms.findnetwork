package ni;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4637f0;
import com.huawei.cloud.base.util.C4638g;
import com.huawei.cloud.base.util.C4642j;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.C4645m;
import com.huawei.cloud.base.util.C4646n;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ni.d */
/* loaded from: classes.dex */
public abstract class AbstractC11709d {
    /* renamed from: a */
    public abstract void mo69837a() throws IOException;

    /* renamed from: b */
    public abstract void mo69838b() throws IOException;

    /* renamed from: c */
    public final void m69839c(Object obj) throws IOException {
        m69840d(false, obj);
    }

    /* renamed from: d */
    public final void m69840d(boolean z10, Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (C4642j.m28441d(obj)) {
            mo69847k();
            return;
        }
        if (obj instanceof String) {
            mo69856t((String) obj);
            return;
        }
        if (obj instanceof Number) {
            m69841e(z10, obj);
            return;
        }
        if (obj instanceof Boolean) {
            mo69843g(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof C4644l) {
            mo69856t(((C4644l) obj).m28459e());
            return;
        }
        if ((obj instanceof Iterable) || cls.isArray()) {
            mo69854r();
            Iterator it = C4637f0.m28423l(obj).iterator();
            while (it.hasNext()) {
                m69840d(z10, it.next());
            }
            mo69844h();
            return;
        }
        if (!cls.isEnum()) {
            m69842f(z10, obj);
            return;
        }
        String strM28467e = C4645m.m28461j((Enum) obj).m28467e();
        if (strM28467e == null) {
            mo69847k();
        } else {
            mo69856t(strM28467e);
        }
    }

    /* renamed from: e */
    public final void m69841e(boolean z10, Object obj) throws IOException {
        if (z10) {
            mo69856t(obj.toString());
            return;
        }
        if (obj instanceof BigDecimal) {
            mo69852p((BigDecimal) obj);
            return;
        }
        if (obj instanceof BigInteger) {
            mo69853q((BigInteger) obj);
            return;
        }
        if (obj instanceof Long) {
            mo69851o(((Long) obj).longValue());
            return;
        }
        boolean z11 = false;
        if (obj instanceof Float) {
            float fFloatValue = ((Number) obj).floatValue();
            if (!Float.isInfinite(fFloatValue) && !Float.isNaN(fFloatValue)) {
                z11 = true;
            }
            C4627a0.m28388a(z11);
            mo69849m(fFloatValue);
            return;
        }
        if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            mo69850n(((Number) obj).intValue());
            return;
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (!Double.isInfinite(dDoubleValue) && !Double.isNaN(dDoubleValue)) {
            z11 = true;
        }
        C4627a0.m28388a(z11);
        mo69848l(dDoubleValue);
    }

    /* renamed from: f */
    public final void m69842f(boolean z10, Object obj) throws IOException {
        boolean z11;
        Class<?> cls = obj.getClass();
        mo69855s();
        boolean z12 = (obj instanceof Map) && !(obj instanceof C4646n);
        C4638g c4638gM28427f = z12 ? null : C4638g.m28427f(cls);
        for (Map.Entry<String, Object> entry : C4642j.m28444g(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                if (z12) {
                    z11 = z10;
                } else {
                    Field fieldM28429a = c4638gM28427f != null ? c4638gM28427f.m28429a(key) : null;
                    z11 = (fieldM28429a == null || fieldM28429a.getAnnotation(InterfaceC11712g.class) == null) ? false : true;
                }
                mo69846j(key);
                m69840d(z11, value);
            }
        }
        mo69845i();
    }

    /* renamed from: g */
    public abstract void mo69843g(boolean z10) throws IOException;

    /* renamed from: h */
    public abstract void mo69844h() throws IOException;

    /* renamed from: i */
    public abstract void mo69845i() throws IOException;

    /* renamed from: j */
    public abstract void mo69846j(String str) throws IOException;

    /* renamed from: k */
    public abstract void mo69847k() throws IOException;

    /* renamed from: l */
    public abstract void mo69848l(double d10) throws IOException;

    /* renamed from: m */
    public abstract void mo69849m(float f10) throws IOException;

    /* renamed from: n */
    public abstract void mo69850n(int i10) throws IOException;

    /* renamed from: o */
    public abstract void mo69851o(long j10) throws IOException;

    /* renamed from: p */
    public abstract void mo69852p(BigDecimal bigDecimal) throws IOException;

    /* renamed from: q */
    public abstract void mo69853q(BigInteger bigInteger) throws IOException;

    /* renamed from: r */
    public abstract void mo69854r() throws IOException;

    /* renamed from: s */
    public abstract void mo69855s() throws IOException;

    /* renamed from: t */
    public abstract void mo69856t(String str) throws IOException;
}
