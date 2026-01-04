package p495nm;

import java.util.Objects;

/* renamed from: nm.d */
/* loaded from: classes6.dex */
public class C11723d {

    /* renamed from: a */
    public String f54239a;

    /* renamed from: b */
    public Integer f54240b;

    /* renamed from: a */
    public String m69946a() {
        return this.f54239a;
    }

    /* renamed from: b */
    public Integer m69947b() {
        return this.f54240b;
    }

    /* renamed from: c */
    public void m69948c(String str) {
        this.f54239a = str;
    }

    /* renamed from: d */
    public void m69949d(Integer num) {
        this.f54240b = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C11723d c11723d = (C11723d) obj;
        return Objects.equals(this.f54239a, c11723d.f54239a) && Objects.equals(this.f54240b, c11723d.f54240b);
    }

    public int hashCode() {
        return Objects.hash(this.f54239a, this.f54240b);
    }

    public String toString() {
        return "BackupUnbacked{appName='" + this.f54239a + "', reason=" + this.f54240b + '}';
    }
}
