package p692uw;

import p824yw.InterfaceC14049a;
import p824yw.InterfaceC14055g;

/* renamed from: uw.o */
/* loaded from: classes9.dex */
public abstract class AbstractC13272o extends AbstractC13260c implements InterfaceC14055g {
    public AbstractC13272o(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC13272o) {
            AbstractC13272o abstractC13272o = (AbstractC13272o) obj;
            return m79665g().equals(abstractC13272o.m79665g()) && m79664f().equals(abstractC13272o.m79664f()) && m79666h().equals(abstractC13272o.m79666h()) && C13267j.m79673a(m79663e(), abstractC13272o.m79663e());
        }
        if (obj instanceof InterfaceC14055g) {
            return obj.equals(m79661c());
        }
        return false;
    }

    public int hashCode() {
        return (((m79665g().hashCode() * 31) + m79664f().hashCode()) * 31) + m79666h().hashCode();
    }

    public String toString() {
        InterfaceC14049a interfaceC14049aM79661c = m79661c();
        if (interfaceC14049aM79661c != this) {
            return interfaceC14049aM79661c.toString();
        }
        return "property " + m79664f() + " (Kotlin reflection is not available)";
    }

    public AbstractC13272o() {
    }
}
