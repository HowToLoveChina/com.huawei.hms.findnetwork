package com.huawei.openalliance.p169ad.views.gif;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class GifPlayView extends ImageView {

    /* renamed from: a */
    private InterfaceC8103d f37674a;

    public GifPlayView(Context context) {
        super(context);
    }

    public void setGifDrawable(C8101b c8101b) {
        c8101b.m50248a(this.f37674a);
        setImageDrawable(c8101b);
    }

    public void setPlayerCallback(InterfaceC8103d interfaceC8103d) {
        this.f37674a = interfaceC8103d;
    }

    public GifPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
