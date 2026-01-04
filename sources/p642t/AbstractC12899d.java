package p642t;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.C0583a;
import java.util.HashMap;
import java.util.HashSet;
import p627s.AbstractC12657d;

/* renamed from: t.d */
/* loaded from: classes.dex */
public abstract class AbstractC12899d {

    /* renamed from: f */
    public static int f58688f = -1;

    /* renamed from: a */
    public int f58689a;

    /* renamed from: b */
    public int f58690b;

    /* renamed from: c */
    public String f58691c;

    /* renamed from: d */
    public int f58692d;

    /* renamed from: e */
    public HashMap<String, C0583a> f58693e;

    public AbstractC12899d() {
        int i10 = f58688f;
        this.f58689a = i10;
        this.f58690b = i10;
        this.f58691c = null;
    }

    /* renamed from: a */
    public abstract void mo77322a(HashMap<String, AbstractC12657d> map);

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract AbstractC12899d clone();

    /* renamed from: c */
    public AbstractC12899d mo77324c(AbstractC12899d abstractC12899d) {
        this.f58689a = abstractC12899d.f58689a;
        this.f58690b = abstractC12899d.f58690b;
        this.f58691c = abstractC12899d.f58691c;
        this.f58692d = abstractC12899d.f58692d;
        this.f58693e = abstractC12899d.f58693e;
        return this;
    }

    /* renamed from: d */
    public abstract void mo77325d(HashSet<String> hashSet);

    /* renamed from: e */
    public abstract void mo77326e(Context context, AttributeSet attributeSet);

    /* renamed from: f */
    public boolean m77327f(String str) {
        String str2 = this.f58691c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    /* renamed from: g */
    public void m77328g(int i10) {
        this.f58689a = i10;
    }

    /* renamed from: h */
    public void mo77329h(HashMap<String, Integer> map) {
    }

    /* renamed from: i */
    public AbstractC12899d m77330i(int i10) {
        this.f58690b = i10;
        return this;
    }

    /* renamed from: j */
    public boolean m77331j(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    /* renamed from: k */
    public float m77332k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    /* renamed from: l */
    public int m77333l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
