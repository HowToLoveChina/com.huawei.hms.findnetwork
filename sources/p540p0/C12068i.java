package p540p0;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import p692uw.C13267j;

/* renamed from: p0.i */
/* loaded from: classes.dex */
public final class C12068i extends AbstractC12067h {

    /* renamed from: b */
    public final ViewGroup f55879b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12068i(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
        C13267j.m79677e(fragment, "fragment");
        C13267j.m79677e(viewGroup, "container");
        this.f55879b = viewGroup;
    }
}
