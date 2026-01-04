package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.MoreInformationSpan;
import java.util.Locale;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class IntelligentRecommendationDialog extends AlertDialogC13154a {
    IntelligentRecommendationCallback mCallback;
    Context mContext;

    public IntelligentRecommendationDialog(Context context, IntelligentRecommendationCallback intelligentRecommendationCallback) {
        super(context);
        this.mCallback = intelligentRecommendationCallback;
        this.mContext = context;
        initView();
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.hicloud_show_intelligent_recommendation_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.cloud_space_dialog_title);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.cloud_space_dialog_content);
        Locale locale = Locale.ENGLISH;
        String string = this.mContext.getString(R$string.cloud_space_dialog_content_value);
        Context context = this.mContext;
        int i10 = R$string.cloud_space_dialog_information;
        String str = String.format(locale, string, context.getString(i10));
        textView.setText(this.mContext.getString(R$string.cloud_space_dialog_title_value));
        SpannableString spannableString = new SpannableString(str);
        String string2 = this.mContext.getString(i10);
        int iIndexOf = str.indexOf(string2);
        spannableString.setSpan(new MoreInformationSpan(this.mContext), iIndexOf, string2.length() + iIndexOf, 33);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string2.length() + iIndexOf, 33);
        textView2.setText(spannableString);
        textView2.append(" ");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        setCancelable(false);
        setView(viewInflate);
        TextView textView3 = (TextView) C12809f.m76831d(viewInflate, R$id.enable_btn);
        TextView textView4 = (TextView) C12809f.m76831d(viewInflate, R$id.know_btn);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.IntelligentRecommendationDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntelligentRecommendationDialog.this.cancel();
                IntelligentRecommendationCallback intelligentRecommendationCallback = IntelligentRecommendationDialog.this.mCallback;
                if (intelligentRecommendationCallback != null) {
                    intelligentRecommendationCallback.onClickEnable();
                }
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.IntelligentRecommendationDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntelligentRecommendationDialog.this.cancel();
                IntelligentRecommendationCallback intelligentRecommendationCallback = IntelligentRecommendationDialog.this.mCallback;
                if (intelligentRecommendationCallback != null) {
                    intelligentRecommendationCallback.onClickKnow();
                }
            }
        });
    }
}
