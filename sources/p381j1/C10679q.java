package p381j1;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;

/* renamed from: j1.q */
/* loaded from: classes.dex */
public class C10679q implements InterfaceC10408t {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static <T> T m65311d(C10077a c10077a) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 4) {
            String strMo62763J = interfaceC10079c.mo62763J();
            interfaceC10079c.mo62756D(16);
            return (T) strMo62763J.toCharArray();
        }
        if (interfaceC10079c.mo62768a0() == 2) {
            Number numberMo62765X = interfaceC10079c.mo62765X();
            interfaceC10079c.mo62756D(16);
            return (T) numberMo62765X.toString().toCharArray();
        }
        Object objM62712G = c10077a.m62712G();
        if (objM62712G instanceof String) {
            return (T) ((String) objM62712G).toCharArray();
        }
        if (!(objM62712G instanceof Collection)) {
            if (objM62712G == null) {
                return null;
            }
            return (T) AbstractC9377a.m58774x(objM62712G).toCharArray();
        }
        Collection collection = (Collection) objM62712G;
        for (Object obj : collection) {
            if ((obj instanceof String) && ((String) obj).length() != 1) {
                throw new C9380d("can not cast to char[]");
            }
        }
        char[] cArr = new char[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            cArr[i10] = ((String) it.next()).charAt(0);
            i10++;
        }
        return cArr;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        return (T) m65311d(c10077a);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 4;
    }
}
