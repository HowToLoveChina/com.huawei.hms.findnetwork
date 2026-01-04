package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* loaded from: classes.dex */
public class CoreComponentFactory extends AppComponentFactory {

    /* renamed from: androidx.core.app.CoreComponentFactory$a */
    public interface InterfaceC0597a {
        /* renamed from: a */
        Object m3780a();
    }

    /* renamed from: a */
    public static <T> T m3779a(T t10) {
        T t11;
        return (!(t10 instanceof InterfaceC0597a) || (t11 = (T) ((InterfaceC0597a) t10).m3780a()) == null) ? t10 : t11;
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Activity) m3779a(super.instantiateActivity(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader classLoader, String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Application) m3779a(super.instantiateApplication(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader classLoader, String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (ContentProvider) m3779a(super.instantiateProvider(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (BroadcastReceiver) m3779a(super.instantiateReceiver(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader classLoader, String str, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Service) m3779a(super.instantiateService(classLoader, str, intent));
    }
}
