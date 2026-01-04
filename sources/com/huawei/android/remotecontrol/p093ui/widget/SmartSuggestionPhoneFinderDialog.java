package com.huawei.android.remotecontrol.p093ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.MoreInformationSpan;
import java.util.Locale;
import p514o9.C11842p;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class SmartSuggestionPhoneFinderDialog extends AlertDialogC13154a {
    public static final String FEATURE_ID = "SF-10044536_f001";
    private SmartSuggestionPhoneFinderCallback mCallback;
    private Context mContext;

    public SmartSuggestionPhoneFinderDialog(Context context, SmartSuggestionPhoneFinderCallback smartSuggestionPhoneFinderCallback) {
        super(context);
        this.mCallback = smartSuggestionPhoneFinderCallback;
        this.mContext = context;
        initView();
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.phonefinder_show_smart_suggestion_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.phonefinder_dialog_title);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.phonefinder_dialog_content);
        Locale locale = Locale.ENGLISH;
        String string = this.mContext.getString(C11842p.m70762R0() ? R$string.phonefinder_dialog_content_value_new_pad : R$string.phonefinder_dialog_content_value_new);
        Context context = this.mContext;
        int i10 = R$string.phonefinder_dialog_information;
        String str = String.format(locale, string, context.getString(i10));
        textView.setText(this.mContext.getString(R$string.phonefinder_dialog_title_value_new));
        SpannableString spannableString = new SpannableString(str);
        String string2 = this.mContext.getString(i10);
        int iIndexOf = str.indexOf(string2);
        spannableString.setSpan(new MoreInformationSpan(this.mContext, FEATURE_ID), iIndexOf, string2.length() + iIndexOf, 33);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string2.length() + iIndexOf, 33);
        textView2.setText(spannableString);
        textView2.append(" ");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        setCancelable(false);
        setView(viewInflate);
        TextView textView3 = (TextView) C12809f.m76831d(viewInflate, R$id.know_btn);
        TextView textView4 = (TextView) C12809f.m76831d(viewInflate, R$id.enable_btn);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.remotecontrol.ui.widget.SmartSuggestionPhoneFinderDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SmartSuggestionPhoneFinderDialog.this.cancel();
                if (SmartSuggestionPhoneFinderDialog.this.mCallback != null) {
                    SmartSuggestionPhoneFinderDialog.this.mCallback.onClickKnow();
                }
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.remotecontrol.ui.widget.SmartSuggestionPhoneFinderDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SmartSuggestionPhoneFinderDialog.this.cancel();
                if (SmartSuggestionPhoneFinderDialog.this.mCallback != null) {
                    SmartSuggestionPhoneFinderDialog.this.mCallback.onClickEnable();
                }
            }
        });
    }
}
