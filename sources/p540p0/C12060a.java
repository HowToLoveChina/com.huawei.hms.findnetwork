package p540p0;

import androidx.fragment.app.Fragment;
import p692uw.C13267j;

/* renamed from: p0.a */
/* loaded from: classes.dex */
public final class C12060a extends AbstractC12067h {

    /* renamed from: b */
    public final String f55858b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12060a(Fragment fragment, String str) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str);
        C13267j.m79677e(fragment, "fragment");
        C13267j.m79677e(str, "previousFragmentId");
        this.f55858b = str;
    }
}
