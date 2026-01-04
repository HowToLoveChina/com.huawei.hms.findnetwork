package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.transition.t */
/* loaded from: classes.dex */
public class C0959t {

    /* renamed from: b */
    public View f4889b;

    /* renamed from: a */
    public final Map<String, Object> f4888a = new HashMap();

    /* renamed from: c */
    public final ArrayList<Transition> f4890c = new ArrayList<>();

    @Deprecated
    public C0959t() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0959t)) {
            return false;
        }
        C0959t c0959t = (C0959t) obj;
        return this.f4889b == c0959t.f4889b && this.f4888a.equals(c0959t.f4888a);
    }

    public int hashCode() {
        return (this.f4889b.hashCode() * 31) + this.f4888a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f4889b + "\n") + "    values:";
        for (String str2 : this.f4888a.keySet()) {
            str = str + "    " + str2 + ": " + this.f4888a.get(str2) + "\n";
        }
        return str;
    }

    public C0959t(View view) {
        this.f4889b = view;
    }
}
