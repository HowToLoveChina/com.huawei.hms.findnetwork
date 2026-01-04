package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.android.p069cg.R$color;

/* loaded from: classes2.dex */
public class SaveBatteryAsyncSpan extends ClickableSpan {

    /* renamed from: a */
    public Context f10959a;

    /* renamed from: b */
    public AsyncContinueDialog f10960b;

    public SaveBatteryAsyncSpan(Context context) {
        this.f10959a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.f10960b == null) {
            this.f10960b = new AsyncContinueDialog(this.f10959a);
        }
        this.f10960b.show();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f10959a.getColor(R$color.attention_color));
        textPaint.setUnderlineText(false);
    }
}
