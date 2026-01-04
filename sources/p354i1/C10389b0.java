package p354i1;

import java.lang.reflect.Constructor;
import p323h1.C10085i;

/* renamed from: i1.b0 */
/* loaded from: classes.dex */
public class C10389b0 extends C10403o {
    public C10389b0(C10085i c10085i, Class<?> cls) {
        super(c10085i, cls, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012b  */
    /* JADX WARN: Type inference failed for: r0v8, types: [i1.o] */
    @Override // p354i1.C10403o, p354i1.InterfaceC10408t
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T mo63891b(p323h1.C10077a r17, java.lang.reflect.Type r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10389b0.mo63891b(h1.a, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    @Override // p354i1.C10403o, p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }

    /* renamed from: t */
    public final Throwable m63895t(String str, Throwable th2, Class<?> cls) throws Exception {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th2);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }
}
