package p757x;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: x.b */
/* loaded from: classes.dex */
public class C13670b extends AbstractC13671c {
    public C13670b(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // p757x.AbstractC13671c
    /* renamed from: c */
    public void mo82248c(int i10, int i11, int i12, Rect rect, Rect rect2) {
        Gravity.apply(i10, i11, i12, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        m82254g();
        outline.setRoundRect(this.f61563h, m82251b());
    }
}
