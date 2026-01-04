package p213d1;

import java.util.HashSet;
import java.util.Set;

/* renamed from: d1.f */
/* loaded from: classes.dex */
public abstract class AbstractC8980f {

    /* renamed from: c */
    public static final Set<AbstractC8980f> f45524c = new HashSet();

    /* renamed from: a */
    public final String f45525a;

    /* renamed from: b */
    public final String f45526b;

    /* renamed from: d1.f$a */
    public static class a extends AbstractC8980f {
        public a(String str, String str2) {
            super(str, str2);
        }
    }

    /* renamed from: d1.f$b */
    public static class b extends AbstractC8980f {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    public AbstractC8980f(String str, String str2) {
        this.f45525a = str;
        this.f45526b = str2;
        f45524c.add(this);
    }
}
