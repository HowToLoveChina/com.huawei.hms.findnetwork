package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;

/* renamed from: com.huawei.openalliance.ad.views.ac */
/* loaded from: classes2.dex */
public class C8068ac extends ProgressButton {
    public C8068ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.p169ad.views.ProgressButton
    /* renamed from: a */
    public void mo49848a(int i10, int i11) {
        int width;
        int width2;
        synchronized (this.f37289h) {
            try {
                if (this.f37294m) {
                    width = (getWidth() / 2) - this.f37282a.centerX();
                    if (this.f37293l && width < this.f37290i) {
                        width = getTextStart();
                    }
                    width2 = this.f37282a.width() + width;
                } else {
                    width = (getWidth() - this.f37282a.width()) - AbstractC7741ao.m47535a(getContext(), 1.0f);
                    if (this.f37293l && width < this.f37290i) {
                        width = getTextStart();
                    }
                    width2 = getWidth();
                }
                Drawable drawable = this.f37288g;
                if (drawable != null) {
                    drawable.setBounds(width, 0, width2, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.ProgressButton
    public int getTextStart() {
        if (AbstractC7811dd.m48332h()) {
            return this.f37292k;
        }
        int width = ((getWidth() - this.f37282a.width()) - this.f37295n) - AbstractC7741ao.m47535a(getContext(), 8.0f);
        int i10 = this.f37291j;
        if (width < i10) {
            width = i10;
        }
        AbstractC7185ho.m43821b("ProgressButtonNew", "safeTextStart: %s", Integer.valueOf(width));
        return width;
    }

    @Override // com.huawei.openalliance.p169ad.views.ProgressButton
    /* renamed from: a */
    public void mo49850a(Canvas canvas) {
        int width;
        int height;
        Rect rect;
        synchronized (this.f37289h) {
            try {
                CharSequence charSequence = this.f37284c;
                if (charSequence != null && charSequence.length() > 0) {
                    String strIntern = this.f37284c.toString().intern();
                    if (this.f37294m) {
                        width = (getWidth() / 2) - this.f37282a.centerX();
                        if (this.f37293l && width < this.f37290i) {
                            width = getTextStart();
                        }
                        height = getHeight() / 2;
                        rect = this.f37282a;
                    } else {
                        width = (getWidth() - this.f37282a.width()) - AbstractC7741ao.m47535a(getContext(), 1.0f);
                        if (this.f37293l && width < this.f37290i) {
                            width = getTextStart();
                        }
                        height = getHeight() / 2;
                        rect = this.f37282a;
                    }
                    canvas.drawText((CharSequence) strIntern, 0, strIntern.length(), width, height - rect.centerY(), this.f37283b);
                    mo49848a(getWidth(), getHeight());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
