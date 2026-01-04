package ec;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import p224dc.C9063a;
import p422k9.C11019b;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* renamed from: ec.c */
/* loaded from: classes3.dex */
public class AlertDialogC9444c extends AlertDialogC13154a {

    /* renamed from: a */
    public DialogInterface.OnClickListener f47160a;

    /* renamed from: b */
    public Context f47161b;

    /* renamed from: c */
    public View f47162c;

    /* renamed from: d */
    public SpanClickText f47163d;

    /* renamed from: e */
    public SpanClickText f47164e;

    public AlertDialogC9444c(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        this.f47161b = context;
        this.f47160a = onClickListener;
        initView();
    }

    /* renamed from: a */
    private void m59229a(SpanClickText spanClickText) {
        String string = this.f47161b.getString(R$string.second_data_center_terms_description_5);
        String string2 = this.f47161b.getString(R$string.second_data_center_terms_description_2_new2);
        String string3 = this.f47161b.getString(R$string.second_data_center_terms_description_1_new, string, string2);
        int iIndexOf = string3.indexOf(string);
        int iIndexOf2 = string3.indexOf(string2);
        SpannableString spannableString = new SpannableString(string3);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
        Resources resources = this.f47161b.getResources();
        int i10 = R$color.emui_color_primary;
        spannableString.setSpan(new ForegroundColorSpan(resources.getColor(i10)), iIndexOf, string.length() + iIndexOf, 33);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf2, string2.length() + iIndexOf2, 33);
        spannableString.setSpan(new ForegroundColorSpan(this.f47161b.getResources().getColor(i10)), iIndexOf2, string2.length() + iIndexOf2, 33);
        spanClickText.setText(spannableString);
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.f47161b).inflate(R$layout.second_center_auth_oobe_dialog, (ViewGroup) null);
        this.f47162c = viewInflate;
        this.f47163d = (SpanClickText) C12809f.m76831d(viewInflate, R$id.text_auth_description);
        this.f47164e = (SpanClickText) C12809f.m76831d(this.f47162c, R$id.text_auth_description_link);
        m59229a(this.f47163d);
        m59230b(this.f47164e);
        setView(this.f47162c);
        setCancelable(false);
        setTitle(this.f47161b.getString(R$string.huaweicloud_privacy_notice_title));
        setButton(-2, this.f47161b.getString(R$string.huaweicloud_overseas_disagree), this.f47160a);
        setButton(-1, this.f47161b.getString(R$string.user_permission_ok), this.f47160a);
    }

    /* renamed from: b */
    public final void m59230b(SpanClickText spanClickText) {
        String string = this.f47161b.getString(R$string.cloud_service_privacy_text);
        String string2 = this.f47161b.getString(R$string.cloud_service_terms_text);
        String string3 = this.f47161b.getString(R$string.permission_instruction);
        String string4 = this.f47161b.getString(R$string.second_data_center_terms_description_7, string2, string, string3);
        int iIndexOf = string4.indexOf(string2);
        int iIndexOf2 = string4.indexOf(string);
        int iIndexOf3 = string4.indexOf(string3);
        SpannableString spannableString = new SpannableString(string4);
        ClickableSpan clickableSpanM66405Y = C11019b.m66371t().m66405Y(this.f47161b, "privacy_statement");
        if (clickableSpanM66405Y != null) {
            spannableString.setSpan(clickableSpanM66405Y, iIndexOf2, string.length() + iIndexOf2, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf2, string.length() + iIndexOf2, 33);
        ClickableSpan clickableSpanM66405Y2 = C11019b.m66371t().m66405Y(this.f47161b, "user_agreement");
        if (clickableSpanM66405Y2 != null) {
            spannableString.setSpan(clickableSpanM66405Y2, iIndexOf, string2.length() + iIndexOf, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string2.length() + iIndexOf, 33);
        C9063a c9063a = new C9063a(this.f47161b, "permission_statement");
        if (clickableSpanM66405Y2 != null) {
            spannableString.setSpan(c9063a, iIndexOf3, string3.length() + iIndexOf3, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf3, string3.length() + iIndexOf3, 33);
        spanClickText.setText(spannableString);
        MovementMethod movementMethodM66414d0 = C11019b.m66371t().m66414d0();
        if (movementMethodM66414d0 != null) {
            spanClickText.setMovementMethod(movementMethodM66414d0);
        }
        spanClickText.setHighlightColor(this.f47161b.getColor(R$color.transparent));
    }

    @Override // android.app.Dialog
    public void show() {
        setDialogNoNavBeforeHarmony31();
        super.show();
    }
}
