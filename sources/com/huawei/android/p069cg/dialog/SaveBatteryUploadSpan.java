package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.android.p069cg.R$color;

/* loaded from: classes2.dex */
public class SaveBatteryUploadSpan extends ClickableSpan {

    /* renamed from: a */
    public Context f10961a;

    /* renamed from: b */
    public UploadContinueDialog f10962b;

    public SaveBatteryUploadSpan(Context context) {
        this.f10961a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.f10962b == null) {
            this.f10962b = new UploadContinueDialog(this.f10961a);
        }
        this.f10962b.show();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f10961a.getColor(R$color.attention_color));
        textPaint.setUnderlineText(false);
    }
}
