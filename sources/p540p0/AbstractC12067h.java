package p540p0;

import androidx.fragment.app.Fragment;
import p692uw.C13267j;

/* renamed from: p0.h */
/* loaded from: classes.dex */
public abstract class AbstractC12067h extends RuntimeException {

    /* renamed from: a */
    public final Fragment f55878a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC12067h(Fragment fragment, String str) {
        super(str);
        C13267j.m79677e(fragment, "fragment");
        this.f55878a = fragment;
    }

    /* renamed from: b */
    public final Fragment m72221b() {
        return this.f55878a;
    }
}
