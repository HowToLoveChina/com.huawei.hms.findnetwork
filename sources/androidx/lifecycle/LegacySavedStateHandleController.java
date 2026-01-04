package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0791h;
import java.util.Iterator;
import p724w0.C13512b;
import p724w0.InterfaceC13514d;

/* loaded from: classes.dex */
public class LegacySavedStateHandleController {

    /* renamed from: androidx.lifecycle.LegacySavedStateHandleController$a */
    public static final class C0771a implements C13512b.a {
        @Override // p724w0.C13512b.a
        /* renamed from: a */
        public void mo4883a(InterfaceC13514d interfaceC13514d) throws NoSuchMethodException, SecurityException {
            if (!(interfaceC13514d instanceof InterfaceC0788f0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            C0786e0 viewModelStore = ((InterfaceC0788f0) interfaceC13514d).getViewModelStore();
            C13512b c13512bMo1909J = interfaceC13514d.mo1909J();
            Iterator<String> it = viewModelStore.m4944c().iterator();
            while (it.hasNext()) {
                LegacySavedStateHandleController.m4880a(viewModelStore.m4943b(it.next()), c13512bMo1909J, interfaceC13514d.mo1915g());
            }
            if (viewModelStore.m4944c().isEmpty()) {
                return;
            }
            c13512bMo1909J.m81268i(C0771a.class);
        }
    }

    /* renamed from: a */
    public static void m4880a(AbstractC0780b0 abstractC0780b0, C13512b c13512b, AbstractC0791h abstractC0791h) throws NoSuchMethodException, SecurityException {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) abstractC0780b0.m4925c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.m4910g()) {
            return;
        }
        savedStateHandleController.m4908e(c13512b, abstractC0791h);
        m4882c(c13512b, abstractC0791h);
    }

    /* renamed from: b */
    public static SavedStateHandleController m4881b(C13512b c13512b, AbstractC0791h abstractC0791h, String str, Bundle bundle) throws NoSuchMethodException, SecurityException {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, C0806v.m4989c(c13512b.m81262b(str), bundle));
        savedStateHandleController.m4908e(c13512b, abstractC0791h);
        m4882c(c13512b, abstractC0791h);
        return savedStateHandleController;
    }

    /* renamed from: c */
    public static void m4882c(final C13512b c13512b, final AbstractC0791h abstractC0791h) throws NoSuchMethodException, SecurityException {
        AbstractC0791h.c cVarMo4949b = abstractC0791h.mo4949b();
        if (cVarMo4949b == AbstractC0791h.c.INITIALIZED || cVarMo4949b.m4954b(AbstractC0791h.c.STARTED)) {
            c13512b.m81268i(C0771a.class);
        } else {
            abstractC0791h.mo4948a(new InterfaceC0794j() { // from class: androidx.lifecycle.LegacySavedStateHandleController.1
                @Override // androidx.lifecycle.InterfaceC0794j
                /* renamed from: d */
                public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) throws NoSuchMethodException, SecurityException {
                    if (bVar == AbstractC0791h.b.ON_START) {
                        abstractC0791h.mo4950c(this);
                        c13512b.m81268i(C0771a.class);
                    }
                }
            });
        }
    }
}
