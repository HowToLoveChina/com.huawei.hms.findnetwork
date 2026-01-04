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
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import p422k9.C11019b;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* renamed from: ec.b */
/* loaded from: classes3.dex */
public class AlertDialogC9443b extends AlertDialogC13154a {

    /* renamed from: a */
    public DialogInterface.OnClickListener f47158a;

    /* renamed from: b */
    public Context f47159b;

    public AlertDialogC9443b(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        this.f47159b = context;
        this.f47158a = onClickListener;
        initView();
    }

    private void initView() {
        Context context = this.f47159b;
        if (context == null) {
            C11839m.m70687e("AuthUserAgreementOOBEDialog", "mContext is null");
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.auth_user_agreement_oobe_dialog, (ViewGroup) null);
        String string = this.f47159b.getString(R$string.user_agreement);
        SpannableString spannableString = new SpannableString(this.f47159b.getString(R$string.huaweicloud_overseas_agreement, string));
        int iIndexOf = spannableString.toString().indexOf(string);
        ClickableSpan clickableSpanM66405Y = C11019b.m66371t().m66405Y(this.f47159b, "user_agreement");
        if (clickableSpanM66405Y != null) {
            spannableString.setSpan(clickableSpanM66405Y, iIndexOf, string.length() + iIndexOf, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.overseas_confirm_text);
        textView.setText(spannableString);
        LinkMovementMethod linkMovementMethodM66414d0 = C11019b.m66371t().m66414d0();
        if (linkMovementMethodM66414d0 != null) {
            textView.setMovementMethod(linkMovementMethodM66414d0);
        }
        textView.setHighlightColor(this.f47159b.getColor(R$color.transparent));
        setView(viewInflate);
        setCancelable(false);
        setTitle(this.f47159b.getString(R$string.huaweicloud_user_agreement_title));
        setButton(-2, this.f47159b.getString(R$string.huaweicloud_overseas_disagree), this.f47158a);
        setButton(-1, this.f47159b.getString(R$string.user_permission_ok), this.f47158a);
    }

    @Override // android.app.Dialog
    public void show() {
        setDialogNoNavBeforeHarmony31();
        super.show();
    }
}
