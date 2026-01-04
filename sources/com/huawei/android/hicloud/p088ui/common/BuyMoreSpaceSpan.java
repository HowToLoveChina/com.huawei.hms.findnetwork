package com.huawei.android.hicloud.p088ui.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.hicloud.sync.R$color;
import java.lang.reflect.InvocationTargetException;
import p422k9.C11019b;
import p684un.C13230i;

/* loaded from: classes3.dex */
public class BuyMoreSpaceSpan extends ClickableSpan {

    /* renamed from: a */
    public Context f17841a;

    public BuyMoreSpaceSpan(Context context) {
        this.f17841a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Bundle bundle = new Bundle();
        C13230i.m79522d1(bundle, "1", "15");
        C11019b.m66371t().m66377C0("2", bundle);
        new HwAnimationReflection(this.f17841a).m15927c(1);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f17841a.getColor(R$color.emui_functional_blue));
        textPaint.setUnderlineText(false);
    }
}
