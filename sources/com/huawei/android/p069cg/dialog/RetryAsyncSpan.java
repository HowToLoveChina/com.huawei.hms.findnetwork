package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.android.p069cg.R$color;
import p031b7.C1120a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;

/* loaded from: classes2.dex */
public class RetryAsyncSpan extends ClickableSpan {

    /* renamed from: a */
    public Context f10957a;

    public RetryAsyncSpan(Context context) {
        this.f10957a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C1120a.m6677i("RetryAsyncSpan", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58433i0(this.f10957a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f10957a.getColor(R$color.attention_color));
        textPaint.setUnderlineText(false);
    }
}
