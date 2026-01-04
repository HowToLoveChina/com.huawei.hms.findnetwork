package ohos.ohos.ohos.ohos.ohos;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import com.huawei.ohos.localability.R$color;

/* renamed from: ohos.ohos.ohos.ohos.ohos.v */
/* loaded from: classes9.dex */
public class C11899v extends UnderlineSpan {

    /* renamed from: a */
    public final /* synthetic */ C11893h f55117a;

    public C11899v(C11893h c11893h) {
        this.f55117a = c11893h;
    }

    @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f55117a.m76172a(R$color.emui_functional_blue));
        textPaint.setUnderlineText(false);
    }
}
