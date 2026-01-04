package p540p0;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import p692uw.C13267j;

/* renamed from: p0.d */
/* loaded from: classes.dex */
public final class C12063d extends AbstractC12067h {

    /* renamed from: b */
    public final ViewGroup f55876b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12063d(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        C13267j.m79677e(fragment, "fragment");
        this.f55876b = viewGroup;
    }
}
