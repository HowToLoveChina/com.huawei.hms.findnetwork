package p243e0;

import android.annotation.SuppressLint;
import java.util.Objects;

@SuppressLint({"UnknownNullness"})
/* renamed from: e0.j */
/* loaded from: classes.dex */
public interface InterfaceC9375j<T> {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    /* synthetic */ default boolean m58750a(InterfaceC9375j interfaceC9375j, Object obj) {
        return test(obj) || interfaceC9375j.test(obj);
    }

    @SuppressLint({"MissingNullability"})
    /* renamed from: c */
    default InterfaceC9375j<T> m58751c(@SuppressLint({"MissingNullability"}) final InterfaceC9375j<? super T> interfaceC9375j) {
        Objects.requireNonNull(interfaceC9375j);
        return new InterfaceC9375j() { // from class: e0.i
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return super.m58750a(interfaceC9375j, obj);
            }
        };
    }

    boolean test(T t10);
}
