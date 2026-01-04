package com.huawei.android.hicloud.p088ui.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.cloud.pay.p098ui.uiextend.view.AutoRenewRuleDialog;
import com.huawei.hicloud.sync.R$styleable;
import com.huawei.openalliance.p169ad.constant.Constants;
import dj.C9158a;
import java.lang.ref.WeakReference;
import p015ak.C0209d;
import p015ak.C0234s;
import p054cj.C1442a;
import p450le.C11273b;
import p514o9.C11827a;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class RenewAgreementTextview extends AppCompatTextView {

    /* renamed from: h */
    public AutoRenewRuleDialog f19532h;

    /* renamed from: i */
    public boolean f19533i;

    /* renamed from: j */
    public boolean f19534j;

    /* renamed from: k */
    public HandlerC4291d f19535k;

    /* renamed from: l */
    public Activity f19536l;

    /* renamed from: m */
    public RenewAgreementTVCallback f19537m;

    /* renamed from: n */
    public ConfirmRenewAgreementDialog.AgreementDlgCallback f19538n;

    /* renamed from: o */
    public boolean f19539o;

    public interface RenewAgreementTVCallback {
        /* renamed from: j0 */
        void mo18858j0(boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.RenewAgreementTextview$a */
    public class C4288a extends ClickableSpan {

        /* renamed from: a */
        public final /* synthetic */ Activity f19540a;

        public C4288a(Activity activity) {
            this.f19540a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            RenewAgreementTextview renewAgreementTextview = RenewAgreementTextview.this;
            if (renewAgreementTextview.f19532h == null) {
                renewAgreementTextview.f19532h = new AutoRenewRuleDialog(this.f19540a);
            }
            RenewAgreementTextview.this.f19532h.show();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.RenewAgreementTextview$b */
    public class C4289b extends ClickableSpan {

        /* renamed from: a */
        public final /* synthetic */ Context f19542a;

        public C4289b(Context context) {
            this.f19542a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            RenewAgreementTextview renewAgreementTextview = RenewAgreementTextview.this;
            if (renewAgreementTextview.f19532h == null) {
                renewAgreementTextview.f19532h = new AutoRenewRuleDialog(this.f19542a);
            }
            RenewAgreementTextview.this.f19532h.show();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.RenewAgreementTextview$d */
    public static class HandlerC4291d extends Handler {

        /* renamed from: a */
        public WeakReference<RenewAgreementTextview> f19548a;

        public HandlerC4291d(RenewAgreementTextview renewAgreementTextview) {
            this.f19548a = new WeakReference<>(renewAgreementTextview);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RenewAgreementTextview renewAgreementTextview = this.f19548a.get();
            if (renewAgreementTextview == null) {
                C1442a.m8289e("RenewAgreementTextview", "RenewAgreementTVHandler, renewAgreementTextview is null.");
                return;
            }
            int i10 = message.what;
            if (i10 == 2128) {
                renewAgreementTextview.m25804u(message.obj.toString());
                return;
            }
            if (i10 == 2129) {
                renewAgreementTextview.m25805v(message.obj.toString());
                return;
            }
            C1442a.m8289e("RenewAgreementTextview", "RenewAgreementTVHandler, invalid what = " + message.what);
        }
    }

    public RenewAgreementTextview(Context context) {
        super(context);
        this.f19533i = true;
        this.f19534j = false;
        this.f19535k = new HandlerC4291d(this);
    }

    public void setShowRuleIcon(boolean z10) {
        this.f19533i = z10;
    }

    public void setWorryCard(boolean z10) {
        this.f19534j = z10;
    }

    public void setmActivity(Activity activity) {
        this.f19536l = activity;
    }

    /* renamed from: t */
    public SpannableString m25803t(SpannableString spannableString, Context context) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(R$drawable.auto_renew_rule_pic);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable);
        C4289b c4289b = new C4289b(context);
        spannableString.setSpan(imageSpan, spannableString.length() - 2, spannableString.length() - 1, 33);
        spannableString.setSpan(c4289b, spannableString.length() - 2, spannableString.length() - 1, 33);
        return spannableString;
    }

    /* renamed from: u */
    public final void m25804u(String str) {
        C1442a.m8290i("RenewAgreementTextview", "handlGetUrlHost");
        if (this.f19536l == null) {
            C1442a.m8289e("RenewAgreementTextview", "handlGetUrlHost, mActivity is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("RenewAgreementTextview", "handlGetUrlHost, host is empty.");
            return;
        }
        C11273b.m67659n(this.f19536l, str + "/payagreement?lang=" + C0234s.m1627e(), this.f19537m);
    }

    /* renamed from: v */
    public final void m25805v(String str) {
        C1442a.m8290i("RenewAgreementTextview", "handleGetConsumerUrlHost");
        if (this.f19536l == null) {
            C1442a.m8289e("RenewAgreementTextview", "handleGetConsumerUrlHost, mActivity is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("RenewAgreementTextview", "handleGetConsumerUrlHost, host is empty.");
            return;
        }
        String str2 = C13452e.m80781L().m80803F0().booleanValue() ? "user_agreement_cn" : "user_agreement";
        C11273b.m67660o(this.f19536l, str + C11827a.m70483h(str2), str2, this.f19537m, this.f19538n);
    }

    /* renamed from: w */
    public void m25806w(String str, String str2, String str3, Activity activity, RenewAgreementTVCallback renewAgreementTVCallback) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("RenewAgreementTextview", "setContent, renewAgreementText is null.");
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            C1442a.m8289e("RenewAgreementTextview", "setContent, renewAgreementStr is null.");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            C1442a.m8289e("RenewAgreementTextview", "setContent, userAgreeStr is null.");
            return;
        }
        if (activity == null) {
            C1442a.m8289e("RenewAgreementTextview", "setContent, activity is null.");
            return;
        }
        this.f19536l = activity;
        this.f19537m = renewAgreementTVCallback;
        String str4 = String.format(str, str2, str3);
        if (this.f19533i) {
            String strM1636n = C0234s.m1636n();
            if (TextUtils.isEmpty(strM1636n) || !strM1636n.equals(Constants.AR_CACHE)) {
                str4 = str4 + "  ";
            } else {
                str4 = str4 + "   ";
            }
        }
        SpannableString spannableString = new SpannableString(str4);
        int iIndexOf = str4.indexOf(str2);
        if (iIndexOf > -1) {
            spannableString.setSpan(new C4290c(activity, this.f19535k, 1, this.f19534j), iIndexOf, str2.length() + iIndexOf, 33);
        }
        int iIndexOf2 = str4.indexOf(str3);
        if (iIndexOf2 > -1) {
            spannableString.setSpan(new C4290c(activity, this.f19535k, 2, this.f19534j), iIndexOf2, str3.length() + iIndexOf2, 33);
        }
        if (this.f19533i) {
            Drawable drawable = this.f19534j ? getResources().getDrawable(R$drawable.worry_card_renew_rule_pic) : getResources().getDrawable(R$drawable.auto_renew_rule_pic);
            float fM1195O = C0209d.m1195O(getContext());
            if (this.f19539o && fM1195O >= 1.75f) {
                fM1195O = 2.0f;
            }
            int intrinsicWidth = (int) (drawable.getIntrinsicWidth() * fM1195O);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicWidth);
            ImageSpan imageSpan = new ImageSpan(drawable);
            C4288a c4288a = new C4288a(activity);
            spannableString.setSpan(imageSpan, str4.length() - 2, str4.length() - 1, 33);
            spannableString.setSpan(c4288a, str4.length() - 2, str4.length() - 1, 33);
        }
        setText(spannableString);
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(0);
    }

    /* renamed from: x */
    public void m25807x(String str, String str2, String str3, ConfirmRenewAgreementDialog.AgreementDlgCallback agreementDlgCallback, Activity activity) {
        this.f19538n = agreementDlgCallback;
        m25806w(str, str2, str3, activity, null);
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.RenewAgreementTextview$c */
    public static class C4290c extends ClickableSpan {

        /* renamed from: a */
        public Context f19544a;

        /* renamed from: b */
        public int f19545b;

        /* renamed from: c */
        public boolean f19546c;

        /* renamed from: d */
        public HandlerC4291d f19547d;

        public C4290c(Context context, HandlerC4291d handlerC4291d, int i10) {
            this.f19544a = context;
            this.f19545b = i10;
            this.f19547d = handlerC4291d;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            int i10 = this.f19545b;
            if (i10 == 1) {
                C9158a.m57503F().m57524V(this.f19547d);
            } else {
                if (i10 != 2) {
                    return;
                }
                C9158a.m57503F().m57527Y(this.f19547d);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            if (this.f19546c) {
                textPaint.setColor(this.f19544a.getResources().getColor(R$color.worry_card_rule_color));
            } else {
                textPaint.setColor(this.f19544a.getResources().getColor(R$color.payment_text_color));
            }
            textPaint.setUnderlineText(false);
        }

        public C4290c(Context context, HandlerC4291d handlerC4291d, int i10, boolean z10) {
            this.f19544a = context;
            this.f19545b = i10;
            this.f19547d = handlerC4291d;
            this.f19546c = z10;
        }
    }

    public RenewAgreementTextview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19533i = true;
        this.f19534j = false;
        this.f19535k = new HandlerC4291d(this);
        if (context != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RenewAgreementTextview);
            this.f19539o = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RenewAgreementTextview_isv5Dialog, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
