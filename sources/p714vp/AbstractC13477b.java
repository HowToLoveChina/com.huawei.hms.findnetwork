package p714vp;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import p399jk.AbstractC10896a;
import p639sp.C12820a;
import p686up.InterfaceC13233a;

/* renamed from: vp.b */
/* loaded from: classes8.dex */
public abstract class AbstractC13477b implements InterfaceC13233a, Serializable {
    private static final String TAG = "AbstractConfigurable";
    private static final long serialVersionUID = -4036013555904290919L;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$copy$0(Field field) throws SecurityException {
        AbstractC10896a.m65885d(TAG, "getDeclaredField name:");
        field.setAccessible(true);
        return null;
    }

    public boolean copy(InterfaceC13233a interfaceC13233a) throws IllegalAccessException, IllegalArgumentException {
        if (interfaceC13233a == null || !getClass().equals(interfaceC13233a.getClass())) {
            return false;
        }
        for (final Field field : getClass().getDeclaredFields()) {
            if (!field.isAccessible()) {
                AccessController.doPrivileged(new PrivilegedAction() { // from class: vp.a
                    @Override // java.security.PrivilegedAction
                    public final Object run() {
                        return AbstractC13477b.lambda$copy$0(field);
                    }
                });
            }
            try {
                field.set(this, field.get(interfaceC13233a));
            } catch (IllegalAccessException unused) {
                AbstractC10896a.m65886e(TAG, "IllegalAccessException ");
                AbstractC10896a.m65885d(TAG, "IllegalAccessException :" + field.getName());
            }
        }
        return true;
    }

    @Override // p686up.InterfaceC13233a
    public InterfaceC13233a getClone() {
        try {
            return (InterfaceC13233a) clone();
        } catch (CloneNotSupportedException unused) {
            throw new C12820a("Current AbstractConfigurable class " + getClass().getSimpleName() + " is not cloneable!");
        }
    }
}
