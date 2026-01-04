package p508o3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import p508o3.AbstractC11813r;

/* renamed from: o3.o */
/* loaded from: classes.dex */
public final class C11810o extends AbstractC11813r implements Serializable, InterfaceC11808m {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f54704c = 0;
        this.f54702a = null;
        this.f54703b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(m70362k());
    }

    @Override // p508o3.InterfaceC11808m
    /* renamed from: b */
    public void mo70356b() {
        mo70357c(1L);
    }

    @Override // p508o3.InterfaceC11808m
    /* renamed from: c */
    public void mo70357c(long j10) {
        int length;
        AbstractC11813r.b bVar;
        AbstractC11813r.b[] bVarArr = this.f54702a;
        if (bVarArr == null) {
            long j11 = this.f54703b;
            if (m70369e(j11, j11 + j10)) {
                return;
            }
        }
        int[] iArr = AbstractC11813r.f54696d.get();
        boolean zM70373a = true;
        if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
            long j12 = bVar.f54707a;
            zM70373a = bVar.m70373a(j12, j12 + j10);
            if (zM70373a) {
                return;
            }
        }
        m70371j(j10, iArr, zM70373a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return m70362k();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return m70362k();
    }

    @Override // p508o3.AbstractC11813r
    /* renamed from: g */
    public final long mo70361g(long j10, long j11) {
        return j10 + j11;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) m70362k();
    }

    /* renamed from: k */
    public long m70362k() {
        long j10 = this.f54703b;
        AbstractC11813r.b[] bVarArr = this.f54702a;
        if (bVarArr != null) {
            for (AbstractC11813r.b bVar : bVarArr) {
                if (bVar != null) {
                    j10 += bVar.f54707a;
                }
            }
        }
        return j10;
    }

    @Override // java.lang.Number
    public long longValue() {
        return m70362k();
    }

    public String toString() {
        return Long.toString(m70362k());
    }
}
