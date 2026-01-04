package p625rx;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import ohos.ohos.ohos.ohos.ohos.C11889d;
import p625rx.C12645l;

/* renamed from: rx.k */
/* loaded from: classes9.dex */
public class C12644k extends ClickableSpan {

    /* renamed from: a */
    public final /* synthetic */ String f58102a;

    /* renamed from: b */
    public final /* synthetic */ C11889d f58103b;

    public C12644k(C11889d c11889d, String str) {
        this.f58103b = c11889d;
        this.f58102a = str;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        C12645l.a aVar = this.f58103b.f58104a;
        if (aVar != null) {
            aVar.mo38539a();
        }
        if (this.f58102a.startsWith("http://") || this.f58102a.startsWith("https://")) {
            str = this.f58102a;
        } else {
            str = "https://" + this.f58102a;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        this.f58103b.f58105b.startActivity(intent);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
