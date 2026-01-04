package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.C0782c0;
import com.huawei.android.hicloud.drive.cloudphoto.model.Role;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.IOException;
import java.lang.reflect.Constructor;
import p597r0.AbstractC12450a;
import p692uw.C13267j;
import p724w0.C13512b;
import p724w0.InterfaceC13514d;

/* renamed from: androidx.lifecycle.z */
/* loaded from: classes.dex */
public final class C0810z extends C0782c0.d implements C0782c0.b {

    /* renamed from: b */
    public Application f4217b;

    /* renamed from: c */
    public final C0782c0.b f4218c;

    /* renamed from: d */
    public Bundle f4219d;

    /* renamed from: e */
    public AbstractC0791h f4220e;

    /* renamed from: f */
    public C13512b f4221f;

    @SuppressLint({"LambdaLast"})
    public C0810z(Application application, InterfaceC13514d interfaceC13514d, Bundle bundle) {
        C13267j.m79677e(interfaceC13514d, Role.OWNER);
        this.f4221f = interfaceC13514d.mo1909J();
        this.f4220e = interfaceC13514d.mo1915g();
        this.f4219d = bundle;
        this.f4217b = application;
        this.f4218c = application != null ? C0782c0.a.f4153f.m4936b(application) : new C0782c0.a();
    }

    @Override // androidx.lifecycle.C0782c0.b
    /* renamed from: a */
    public <T extends AbstractC0780b0> T mo4828a(Class<T> cls) {
        C13267j.m79677e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) m5008d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.C0782c0.b
    /* renamed from: b */
    public <T extends AbstractC0780b0> T mo4933b(Class<T> cls, AbstractC12450a abstractC12450a) {
        C13267j.m79677e(cls, "modelClass");
        C13267j.m79677e(abstractC12450a, JsbMapKeyNames.H5_EXTRAS);
        String str = (String) abstractC12450a.mo74704a(C0782c0.c.f4162d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (abstractC12450a.mo74704a(C0807w.f4207a) == null || abstractC12450a.mo74704a(C0807w.f4208b) == null) {
            if (this.f4220e != null) {
                return (T) m5008d(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) abstractC12450a.mo74704a(C0782c0.a.f4155h);
        boolean zIsAssignableFrom = C0777a.class.isAssignableFrom(cls);
        Constructor constructorM4913c = (!zIsAssignableFrom || application == null) ? C0778a0.m4913c(cls, C0778a0.f4139b) : C0778a0.m4913c(cls, C0778a0.f4138a);
        return constructorM4913c == null ? (T) this.f4218c.mo4933b(cls, abstractC12450a) : (!zIsAssignableFrom || application == null) ? (T) C0778a0.m4914d(cls, constructorM4913c, C0807w.m4995a(abstractC12450a)) : (T) C0778a0.m4914d(cls, constructorM4913c, application, C0807w.m4995a(abstractC12450a));
    }

    @Override // androidx.lifecycle.C0782c0.d
    /* renamed from: c */
    public void mo4940c(AbstractC0780b0 abstractC0780b0) throws NoSuchMethodException, SecurityException {
        C13267j.m79677e(abstractC0780b0, "viewModel");
        AbstractC0791h abstractC0791h = this.f4220e;
        if (abstractC0791h != null) {
            LegacySavedStateHandleController.m4880a(abstractC0780b0, this.f4221f, abstractC0791h);
        }
    }

    /* renamed from: d */
    public final <T extends AbstractC0780b0> T m5008d(String str, Class<T> cls) throws NoSuchMethodException, SecurityException, IOException {
        T t10;
        Application application;
        C13267j.m79677e(str, "key");
        C13267j.m79677e(cls, "modelClass");
        if (this.f4220e == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = C0777a.class.isAssignableFrom(cls);
        Constructor constructorM4913c = (!zIsAssignableFrom || this.f4217b == null) ? C0778a0.m4913c(cls, C0778a0.f4139b) : C0778a0.m4913c(cls, C0778a0.f4138a);
        if (constructorM4913c == null) {
            return this.f4217b != null ? (T) this.f4218c.mo4828a(cls) : (T) C0782c0.c.f4160b.m4939a().mo4828a(cls);
        }
        SavedStateHandleController savedStateHandleControllerM4881b = LegacySavedStateHandleController.m4881b(this.f4221f, this.f4220e, str, this.f4219d);
        if (!zIsAssignableFrom || (application = this.f4217b) == null) {
            C0806v c0806vM4909f = savedStateHandleControllerM4881b.m4909f();
            C13267j.m79676d(c0806vM4909f, "controller.handle");
            t10 = (T) C0778a0.m4914d(cls, constructorM4913c, c0806vM4909f);
        } else {
            C13267j.m79674b(application);
            C0806v c0806vM4909f2 = savedStateHandleControllerM4881b.m4909f();
            C13267j.m79676d(c0806vM4909f2, "controller.handle");
            t10 = (T) C0778a0.m4914d(cls, constructorM4913c, application, c0806vM4909f2);
        }
        t10.m4926e("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerM4881b);
        return t10;
    }
}
