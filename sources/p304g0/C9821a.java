package p304g0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: g0.a */
/* loaded from: classes.dex */
public final class C9821a extends ClickableSpan {

    /* renamed from: a */
    public final int f48267a;

    /* renamed from: b */
    public final C9832l f48268b;

    /* renamed from: c */
    public final int f48269c;

    public C9821a(int i10, C9832l c9832l, int i11) {
        this.f48267a = i10;
        this.f48268b = c9832l;
        this.f48269c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f48267a);
        this.f48268b.m61056L(this.f48269c, bundle);
    }
}
