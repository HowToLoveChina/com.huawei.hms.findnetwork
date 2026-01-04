package com.huawei.opendevice.open;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.opendevice.open.b */
/* loaded from: classes2.dex */
public class C8259b extends ClickableSpan {

    /* renamed from: a */
    public final Context f38481a;

    /* renamed from: b */
    public Class<?> f38482b;

    public C8259b(Context context) {
        this.f38481a = context;
    }

    /* renamed from: a */
    public void m51591a(Class<?> cls) {
        this.f38482b = cls;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        AbstractC7185ho.m43820b("ClickSpan", "onClick");
        if (this.f38482b == null) {
            AbstractC7185ho.m43823c("ClickSpan", "onClick activity is null");
            return;
        }
        try {
            Intent intent = new Intent(this.f38481a, this.f38482b);
            intent.setClipData(Constants.CLIP_DATA);
            this.f38481a.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            str = "onClick startActivity ActivityNotFoundException";
            AbstractC7185ho.m43826d("ClickSpan", str);
        } catch (Exception unused2) {
            str = "onClick startActivity Exception";
            AbstractC7185ho.m43826d("ClickSpan", str);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f38481a.getResources().getColor(C6849R.color.hiad_functional_blue));
        textPaint.setUnderlineText(false);
    }
}
