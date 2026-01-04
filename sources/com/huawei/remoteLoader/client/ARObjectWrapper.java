package com.huawei.remoteLoader.client;

import android.os.IBinder;
import com.huawei.arengine.remoteLoader.IObjectWrapper;
import com.huawei.hiar.annotations.UsedByReflection;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

@UsedByReflection("ARObjectWrapper.java")
/* loaded from: classes5.dex */
public final class ARObjectWrapper<T> extends IObjectWrapper.AbstractBinderC4592a {

    @UsedByReflection("ARObjectWrapper.java")
    private final T wrappedObject;

    private ARObjectWrapper(T t10) {
        this.wrappedObject = t10;
    }

    private static AccessibleObject getAccessibleObject(Class<?> cls) {
        Field field = null;
        for (Field field2 : cls.getDeclaredFields()) {
            if (!field2.isSynthetic()) {
                if (field != null) {
                    return null;
                }
                field = field2;
            }
        }
        return field;
    }

    @UsedByReflection("ARObjectWrapper.java")
    public static <T> T unwrap(IObjectWrapper iObjectWrapper, Class<T> cls) throws SecurityException {
        if (iObjectWrapper == null) {
            return null;
        }
        if (iObjectWrapper instanceof ARObjectWrapper) {
            return ((ARObjectWrapper) iObjectWrapper).wrappedObject;
        }
        IBinder iBinderAsBinder = iObjectWrapper.asBinder();
        if (iBinderAsBinder == null) {
            throw new IllegalArgumentException("Binder object is null.");
        }
        AccessibleObject accessibleObject = getAccessibleObject(iBinderAsBinder.getClass());
        if (accessibleObject == null || accessibleObject.isAccessible()) {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared private field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        accessibleObject.setAccessible(true);
        try {
            Object obj = accessibleObject instanceof Field ? ((Field) accessibleObject).get(iBinderAsBinder) : null;
            if (obj == null) {
                return null;
            }
            if (cls.isInstance(obj)) {
                return cls.cast(obj);
            }
            throw new IllegalArgumentException("remoteBinder is the wrong class.");
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e10);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException("remoteBinder is the wrong class.", e11);
        }
    }

    public static <T> IObjectWrapper wrap(T t10) {
        return new ARObjectWrapper(t10);
    }
}
