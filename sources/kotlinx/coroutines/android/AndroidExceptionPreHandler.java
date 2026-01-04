package kotlinx.coroutines.android;

import androidx.annotation.Keep;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import mw.AbstractC11534a;
import mw.InterfaceC11539f;
import p040bx.InterfaceC1346u;

@Keep
/* loaded from: classes9.dex */
public final class AndroidExceptionPreHandler extends AbstractC11534a implements InterfaceC1346u {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(InterfaceC1346u.f5844f2);
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    method = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // p040bx.InterfaceC1346u
    public void handleException(InterfaceC11539f interfaceC11539f, Throwable th2) {
    }
}
