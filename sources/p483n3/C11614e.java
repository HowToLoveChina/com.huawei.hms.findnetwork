package p483n3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: n3.e */
/* loaded from: classes.dex */
public final class C11614e<K, V> extends AbstractC11615f<K, V> {
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public transient int f53932e;

    public C11614e() {
        this(12, 3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f53932e = 3;
        int iM69490b = C11629t.m69490b(objectInputStream);
        m69376u(C11618i.m69414t());
        C11629t.m69489a(this, objectInputStream, iM69490b);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        C11629t.m69491c(this, objectOutputStream);
    }

    /* renamed from: y */
    public static <K, V> C11614e<K, V> m69396y() {
        return new C11614e<>();
    }

    @Override // p483n3.AbstractC11610a, p483n3.AbstractC11613d, p483n3.InterfaceC11624o
    /* renamed from: b */
    public /* bridge */ /* synthetic */ Map mo69358b() {
        return super.mo69358b();
    }

    @Override // p483n3.AbstractC11613d
    /* renamed from: e */
    public /* bridge */ /* synthetic */ Set mo69394e() {
        return super.mo69394e();
    }

    @Override // p483n3.AbstractC11610a, p483n3.AbstractC11613d
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p483n3.AbstractC11613d
    /* renamed from: f */
    public /* bridge */ /* synthetic */ boolean mo69395f(Object obj, Iterable iterable) {
        return super.mo69395f(obj, iterable);
    }

    @Override // p483n3.AbstractC11613d
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // p483n3.AbstractC11611b
    /* renamed from: o */
    public /* bridge */ /* synthetic */ void mo69372o() {
        super.mo69372o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p483n3.AbstractC11610a, p483n3.AbstractC11611b
    /* renamed from: s */
    public /* bridge */ /* synthetic */ boolean mo69359s(Object obj, Object obj2) {
        return super.mo69359s(obj, obj2);
    }

    @Override // p483n3.AbstractC11613d
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p483n3.AbstractC11610a
    /* renamed from: x */
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return super.get(obj);
    }

    @Override // p483n3.AbstractC11611b
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public List<V> mo69373p() {
        return new ArrayList(this.f53932e);
    }

    public C11614e(int i10, int i11) {
        super(C11628s.m69488a(i10));
        C11616g.m69398a(i11, "expectedValuesPerKey");
        this.f53932e = i11;
    }
}
