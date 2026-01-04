package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;

/* loaded from: classes2.dex */
public class RetryUploadSpan extends ClickableSpan {

    /* renamed from: a */
    public Context f10958a;

    public RetryUploadSpan(Context context) {
        this.f10958a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        CloudAlbumManager.m14456v().m14482c0(this.f10958a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f10958a.getColor(R$color.attention_color));
        textPaint.setUnderlineText(false);
    }
}
