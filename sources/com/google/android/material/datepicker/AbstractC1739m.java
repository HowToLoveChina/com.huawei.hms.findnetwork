package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* renamed from: com.google.android.material.datepicker.m */
/* loaded from: classes.dex */
public abstract class AbstractC1739m<S> extends Fragment {

    /* renamed from: c0 */
    public final LinkedHashSet<AbstractC1738l<S>> f8035c0 = new LinkedHashSet<>();

    /* renamed from: C1 */
    public boolean mo10311C1(AbstractC1738l<S> abstractC1738l) {
        return this.f8035c0.add(abstractC1738l);
    }

    /* renamed from: D1 */
    public void m10370D1() {
        this.f8035c0.clear();
    }
}
