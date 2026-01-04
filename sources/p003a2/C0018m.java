package p003a2;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import p630s2.C12677l;

/* renamed from: a2.m */
/* loaded from: classes.dex */
public class C0018m implements InterfaceC0016k {

    /* renamed from: d */
    public static final Bitmap.Config[] f27d;

    /* renamed from: e */
    public static final Bitmap.Config[] f28e;

    /* renamed from: f */
    public static final Bitmap.Config[] f29f;

    /* renamed from: g */
    public static final Bitmap.Config[] f30g;

    /* renamed from: h */
    public static final Bitmap.Config[] f31h;

    /* renamed from: a */
    public final c f32a = new c();

    /* renamed from: b */
    public final C0012g<b, Bitmap> f33b = new C0012g<>();

    /* renamed from: c */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f34c = new HashMap();

    /* renamed from: a2.m$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f35a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f35a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a2.m$b */
    public static final class b implements InterfaceC0017l {

        /* renamed from: a */
        public final c f36a;

        /* renamed from: b */
        public int f37b;

        /* renamed from: c */
        public Bitmap.Config f38c;

        public b(c cVar) {
            this.f36a = cVar;
        }

        @Override // p003a2.InterfaceC0017l
        /* renamed from: a */
        public void mo43a() {
            this.f36a.m13c(this);
        }

        /* renamed from: b */
        public void m72b(int i10, Bitmap.Config config) {
            this.f37b = i10;
            this.f38c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f37b == bVar.f37b && C12677l.m76280c(this.f38c, bVar.f38c);
        }

        public int hashCode() {
            int i10 = this.f37b * 31;
            Bitmap.Config config = this.f38c;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return C0018m.m67i(this.f37b, this.f38c);
        }
    }

    /* renamed from: a2.m$c */
    public static class c extends AbstractC0008c<b> {
        @Override // p003a2.AbstractC0008c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b mo11a() {
            return new b(this);
        }

        /* renamed from: e */
        public b m74e(int i10, Bitmap.Config config) {
            b bVarM12b = m12b();
            bVarM12b.m72b(i10, config);
            return bVarM12b;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        f27d = configArr;
        f28e = configArr;
        f29f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f30g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f31h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    /* renamed from: i */
    public static String m67i(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    /* renamed from: j */
    public static Bitmap.Config[] m68j(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return f28e;
        }
        int i10 = a.f35a[config.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new Bitmap.Config[]{config} : f31h : f30g : f29f : f27d;
    }

    @Override // p003a2.InterfaceC0016k
    /* renamed from: a */
    public Bitmap mo61a() {
        Bitmap bitmapM26f = this.f33b.m26f();
        if (bitmapM26f != null) {
            m69g(Integer.valueOf(C12677l.m76284g(bitmapM26f)), bitmapM26f);
        }
        return bitmapM26f;
    }

    @Override // p003a2.InterfaceC0016k
    /* renamed from: b */
    public void mo62b(Bitmap bitmap) {
        b bVarM74e = this.f32a.m74e(C12677l.m76284g(bitmap), bitmap.getConfig());
        this.f33b.m25d(bVarM74e, bitmap);
        NavigableMap<Integer, Integer> navigableMapM71k = m71k(bitmap.getConfig());
        Integer num = navigableMapM71k.get(Integer.valueOf(bVarM74e.f37b));
        navigableMapM71k.put(Integer.valueOf(bVarM74e.f37b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // p003a2.InterfaceC0016k
    /* renamed from: c */
    public Bitmap mo63c(int i10, int i11, Bitmap.Config config) {
        b bVarM70h = m70h(C12677l.m76283f(i10, i11, config), config);
        Bitmap bitmapM22a = this.f33b.m22a(bVarM70h);
        if (bitmapM22a != null) {
            m69g(Integer.valueOf(bVarM70h.f37b), bitmapM22a);
            bitmapM22a.reconfigure(i10, i11, config);
        }
        return bitmapM22a;
    }

    @Override // p003a2.InterfaceC0016k
    /* renamed from: d */
    public String mo64d(int i10, int i11, Bitmap.Config config) {
        return m67i(C12677l.m76283f(i10, i11, config), config);
    }

    @Override // p003a2.InterfaceC0016k
    /* renamed from: e */
    public int mo65e(Bitmap bitmap) {
        return C12677l.m76284g(bitmap);
    }

    @Override // p003a2.InterfaceC0016k
    /* renamed from: f */
    public String mo66f(Bitmap bitmap) {
        return m67i(C12677l.m76284g(bitmap), bitmap.getConfig());
    }

    /* renamed from: g */
    public final void m69g(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapM71k = m71k(bitmap.getConfig());
        Integer num2 = navigableMapM71k.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapM71k.remove(num);
                return;
            } else {
                navigableMapM71k.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + mo66f(bitmap) + ", this: " + this);
    }

    /* renamed from: h */
    public final b m70h(int i10, Bitmap.Config config) {
        b bVarM74e = this.f32a.m74e(i10, config);
        for (Bitmap.Config config2 : m68j(config)) {
            Integer numCeilingKey = m71k(config2).ceilingKey(Integer.valueOf(i10));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i10 * 8) {
                if (numCeilingKey.intValue() == i10) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVarM74e;
                        }
                    } else if (config2.equals(config)) {
                        return bVarM74e;
                    }
                }
                this.f32a.m13c(bVarM74e);
                return this.f32a.m74e(numCeilingKey.intValue(), config2);
            }
        }
        return bVarM74e;
    }

    /* renamed from: k */
    public final NavigableMap<Integer, Integer> m71k(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f34c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f34c.put(config, treeMap);
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SizeConfigStrategy{groupedMap=");
        sb2.append(this.f33b);
        sb2.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f34c.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append('[');
            sb2.append(entry.getValue());
            sb2.append("], ");
        }
        if (!this.f34c.isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(")}");
        return sb2.toString();
    }
}
