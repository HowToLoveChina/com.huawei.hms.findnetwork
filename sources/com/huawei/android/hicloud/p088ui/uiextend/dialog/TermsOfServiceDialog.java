package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bo.InterfaceC1268b;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.os.BuildEx;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p015ak.C0209d;
import p472m7.C11427b;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TermsOfServiceDialog extends AlertDialogC13154a {
    private static final String TAG = "TermsOfServiceDialog";
    Context mContext;
    DialogInterface.OnClickListener mListener;
    View userAgreementView;

    public TermsOfServiceDialog(Context context, InterfaceC1268b interfaceC1268b, DialogInterface.OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.mListener = onClickListener;
        initChinaRegionView();
    }

    private void initChinaRegionView() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.hisync_agreement_dialog, (ViewGroup) null);
        this.userAgreementView = viewInflate;
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.agreement_data_info_content);
        if (textView != null && C0209d.m1202Q0()) {
            textView.setText(R$string.cloud_service_agreement_datainfo_emui9_2);
        }
        setClickableText((SpanClickText) C12809f.m76831d(this.userAgreementView, R$id.content_text_2));
        String string = this.mContext.getString(R$string.cloud_service_content_1_alert_new);
        SpannableString spannableString = new SpannableString(this.mContext.getString(R$string.cloud_service_content_1_upd_new, string));
        int iIndexOf = spannableString.toString().indexOf(string);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
        ((TextView) C12809f.m76831d(this.userAgreementView, R$id.agreement_content_1)).setText(spannableString);
        setView(this.userAgreementView);
        setCancelable(false);
        setTitle(this.mContext.getString(R$string.cloud_service_notice));
        TextView textView2 = (TextView) C12809f.m76831d(this.userAgreementView, R$id.agreement_content_6);
        if (!C0209d.m1277l1() && BuildEx.VERSION.EMUI_SDK_INT < 12) {
            textView2.setText(R$string.cloud_service_content_6_no_switch);
        }
        setButton(-2, this.mContext.getString(R$string.cloudbackup_Cancel), this.mListener);
        setButton(-1, this.mContext.getString(R$string.user_permission_ok), this.mListener);
    }

    private void setClickableText(SpanClickText spanClickText) {
        Context context = this.mContext;
        if (context != null) {
            String string = context.getString(R$string.cloud_service_terms_text);
            String string2 = this.mContext.getString(R$string.cloud_service_privacy_statement);
            String string3 = this.mContext.getString(R$string.cloud_service_content_8, string, string2);
            spanClickText.m15931c(string, new C11427b(this.mContext, "user_agreement"));
            spanClickText.m15931c(string2, new C11427b(this.mContext, "privacy_statement"));
            spanClickText.m15934g(string3, false);
        }
    }
}
