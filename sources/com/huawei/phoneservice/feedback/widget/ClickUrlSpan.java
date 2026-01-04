package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.huawei.phoneservice.feedback.R$color;

/* loaded from: classes5.dex */
public class ClickUrlSpan extends URLSpan {

    /* renamed from: a */
    public final Context f39977a;

    public ClickUrlSpan(String str, Context context) {
        super(str);
        this.f39977a = context;
    }

    /* renamed from: a */
    public static void m53128a(TextView textView) {
        Spannable spannable;
        if (textView == null) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        if (!(textView.getText() instanceof Spannable) || (spannable = (Spannable) textView.getText()) == null) {
            return;
        }
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new ClickUrlSpan(uRLSpan.getURL(), textView.getContext()), spanStart, spanEnd, 33);
        }
        textView.setAutoLinkMask(0);
        textView.setText(spannable);
        textView.setClickable(false);
        textView.setLongClickable(false);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        Context context = this.f39977a;
        if (context != null) {
            textPaint.setColor(context.getResources().getColor(R$color.feedback_sdk_privacy_link_color));
        }
    }
}
