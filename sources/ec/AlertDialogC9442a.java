package ec;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import p422k9.C11019b;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* renamed from: ec.a */
/* loaded from: classes3.dex */
public class AlertDialogC9442a extends AlertDialogC13154a {

    /* renamed from: a */
    public DialogInterface.OnClickListener f47156a;

    /* renamed from: b */
    public Context f47157b;

    public AlertDialogC9442a(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        this.f47157b = context;
        this.f47156a = onClickListener;
        initView();
    }

    private void initView() {
        Context context = this.f47157b;
        if (context == null) {
            C11839m.m70687e("AuthPrivacyOOBEDialog", "mContext is null");
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.auth_privacy_oobe_dialog, (ViewGroup) null);
        String string = this.f47157b.getString(R$string.huaweicloud_notice_here);
        SpannableString spannableString = new SpannableString(this.f47157b.getString(R$string.huaweicloud_notice_confirm, string));
        int iLastIndexOf = spannableString.toString().lastIndexOf(string);
        ClickableSpan clickableSpanM66405Y = C11019b.m66371t().m66405Y(this.f47157b, "privacy_statement");
        if (clickableSpanM66405Y != null) {
            spannableString.setSpan(clickableSpanM66405Y, iLastIndexOf, string.length() + iLastIndexOf, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iLastIndexOf, string.length() + iLastIndexOf, 33);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76831d(viewInflate, R$id.more_info);
        spanClickText.setText(spannableString);
        LinkMovementMethod linkMovementMethodM66414d0 = C11019b.m66371t().m66414d0();
        if (linkMovementMethodM66414d0 != null) {
            spanClickText.setMovementMethod(linkMovementMethodM66414d0);
        }
        spanClickText.setHighlightColor(this.f47157b.getColor(R$color.transparent));
        setView(viewInflate);
        setCancelable(false);
        setTitle(this.f47157b.getString(R$string.huaweicloud_privacy_notice_title));
        setButton(-2, this.f47157b.getString(R$string.cloudbackup_cancel_btn), this.f47156a);
        setButton(-1, this.f47157b.getString(R$string.next_step), this.f47156a);
    }

    @Override // android.app.Dialog
    public void show() {
        setDialogNoNavBeforeHarmony31();
        super.show();
    }
}
