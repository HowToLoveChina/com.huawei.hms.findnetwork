package p301fy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* renamed from: fy.d */
/* loaded from: classes9.dex */
public abstract class AbstractC9786d {

    /* renamed from: a */
    public final Class<?>[] f48122a;

    public AbstractC9786d(Class<?>... clsArr) {
        Objects.requireNonNull(clsArr, "optionClasses");
        this.f48122a = clsArr;
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m60861e(Object obj, Class cls) {
        return cls.isInstance(obj);
    }

    /* renamed from: b */
    public abstract InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException;

    /* renamed from: c */
    public Object mo60862c(C9790h c9790h, InputStream inputStream) throws IOException {
        return null;
    }

    /* renamed from: d */
    public boolean m60863d(final Object obj) {
        return Stream.of((Object[]) this.f48122a).anyMatch(new Predicate() { // from class: fy.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj2) {
                return AbstractC9786d.m60861e(obj, (Class) obj2);
            }
        });
    }
}
