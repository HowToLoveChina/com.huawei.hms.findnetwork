package p420k7;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bo.InterfaceC1268b;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import gp.C10028c;
import p472m7.C11428c;
import p472m7.C11429d;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* renamed from: k7.c */
/* loaded from: classes2.dex */
public class AlertDialogC11016c extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f52086a;

    /* renamed from: b */
    public InterfaceC1268b f52087b;

    /* renamed from: c */
    public boolean f52088c;

    /* renamed from: d */
    public boolean f52089d;

    /* renamed from: e */
    public boolean f52090e;

    /* renamed from: f */
    public View f52091f;

    /* renamed from: k7.c$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70688i("TermsOfServiceUpdDialog", "set MarketingNotifyCheck is true, pushMarketingNotice dialog can show again!");
            C10028c.m62182c0().m62372o3();
            AlertDialogC11016c.this.f52087b.mo7529M(true);
            AlertDialogC11016c.this.cancel();
        }
    }

    /* renamed from: k7.c$b */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70686d("TermsOfServiceUpdDialog", "showDisagreeDialog");
            AlertDialogC11016c.this.f52087b.mo7533z();
            AlertDialogC11016c.this.cancel();
        }
    }

    public AlertDialogC11016c(Context context, InterfaceC1268b interfaceC1268b, boolean z10, boolean z11, boolean z12) {
        super(context);
        this.f52087b = interfaceC1268b;
        this.f52086a = context;
        this.f52088c = z10;
        this.f52089d = z11;
        this.f52090e = z12;
        initView();
    }

    private void initView() {
        C10028c.m62182c0().m62377p3("agr_force_query", true);
        this.f52091f = LayoutInflater.from(this.f52086a).inflate(R$layout.hisync_agreement_upd_dialog, (ViewGroup) null);
        setButton(-1, this.f52086a.getString(R$string.user_permission_ok), new a());
        setButton(-2, this.f52086a.getString(R$string.cloudbackup_Cancel), new b());
        String string = this.f52086a.getString(R$string.cloud_service_terms_text);
        String string2 = this.f52086a.getString(R$string.cloud_service_privacy_statement);
        String string3 = this.f52086a.getString(R$string.cloud_service_legal_privacy_text);
        this.f52086a.getString(R$string.cloud_service_change_notice);
        boolean z10 = this.f52088c;
        if (z10 && !this.f52089d && !this.f52090e) {
            String string4 = this.f52086a.getString(R$string.cloud_service_terms_update, string);
            SpannableString spannableString = new SpannableString(this.f52086a.getString(R$string.cloud_service_agree_confirm, string));
            int iIndexOf = spannableString.toString().indexOf(string);
            spannableString.setSpan(new C11428c(this.f52086a, "user_agreement"), iIndexOf, string.length() + iIndexOf, 33);
            spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
            m66370c(string4, spannableString);
            setTitle(this.f52086a.getString(R$string.user_argeement_cloud_service_change_notice));
            return;
        }
        if (!z10 && this.f52089d && !this.f52090e) {
            String string5 = this.f52086a.getString(R$string.cloud_service_terms_update, string2);
            SpannableString spannableString2 = new SpannableString(this.f52086a.getString(R$string.cloud_service_agree_confirm, string2));
            int iIndexOf2 = spannableString2.toString().indexOf(string2);
            spannableString2.setSpan(new C11428c(this.f52086a, "privacy_statement"), iIndexOf2, string2.length() + iIndexOf2, 33);
            spannableString2.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf2, string2.length() + iIndexOf2, 33);
            m66370c(string5, spannableString2);
            setTitle(this.f52086a.getString(R$string.privacy_statement_cloud_service_change_notice));
            return;
        }
        if (z10 || this.f52089d || !this.f52090e) {
            m66369b(string, string2, string3);
            return;
        }
        String string6 = this.f52086a.getString(R$string.cloud_service_terms_update, string3);
        SpannableString spannableString3 = new SpannableString(this.f52086a.getString(R$string.cloud_service_agree_confirm, string3));
        int iIndexOf3 = spannableString3.toString().indexOf(string3);
        spannableString3.setSpan(new C11428c(this.f52086a, "legal_privacy"), iIndexOf3, string3.length() + iIndexOf3, 33);
        spannableString3.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf3, string3.length() + iIndexOf3, 33);
        m66370c(string6, spannableString3);
        setTitle(this.f52086a.getString(R$string.privacy_statement_cloud_service_change_notice));
    }

    /* renamed from: b */
    public final void m66369b(String str, String str2, String str3) {
        String string = this.f52086a.getString(R$string.cloud_service_change_notice);
        boolean z10 = this.f52088c;
        if (z10 && this.f52089d && !this.f52090e) {
            String string2 = this.f52086a.getString(R$string.about_policy, str, str2);
            String string3 = this.f52086a.getString(R$string.cloud_service_terms_update, string2);
            SpannableString spannableString = new SpannableString(this.f52086a.getString(R$string.cloud_service_agree_confirm, string2));
            int iIndexOf = spannableString.toString().indexOf(str);
            spannableString.setSpan(new C11428c(this.f52086a, "user_agreement"), iIndexOf, str.length() + iIndexOf, 33);
            spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, str.length() + iIndexOf, 33);
            int iIndexOf2 = spannableString.toString().indexOf(str2);
            spannableString.setSpan(new C11428c(this.f52086a, "privacy_statement"), iIndexOf2, str2.length() + iIndexOf2, 33);
            spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf2, str2.length() + iIndexOf2, 33);
            m66370c(string3, spannableString);
            setTitle(string);
            return;
        }
        if (z10 && !this.f52089d && this.f52090e) {
            String string4 = this.f52086a.getString(R$string.about_policy, str, str3);
            String string5 = this.f52086a.getString(R$string.cloud_service_terms_update, string4);
            SpannableString spannableString2 = new SpannableString(this.f52086a.getString(R$string.cloud_service_agree_confirm, string4));
            int iIndexOf3 = spannableString2.toString().indexOf(str);
            spannableString2.setSpan(new C11428c(this.f52086a, "user_agreement"), iIndexOf3, str.length() + iIndexOf3, 33);
            spannableString2.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf3, str.length() + iIndexOf3, 33);
            int iIndexOf4 = spannableString2.toString().indexOf(str3);
            spannableString2.setSpan(new C11428c(this.f52086a, "legal_privacy"), iIndexOf4, str3.length() + iIndexOf4, 33);
            spannableString2.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf4, str3.length() + iIndexOf4, 33);
            m66370c(string5, spannableString2);
            setTitle(string);
            return;
        }
        if (!z10 && this.f52089d && this.f52090e) {
            String string6 = this.f52086a.getString(R$string.about_policy, str2, str3);
            String string7 = this.f52086a.getString(R$string.cloud_service_terms_update, string6);
            SpannableString spannableString3 = new SpannableString(this.f52086a.getString(R$string.cloud_service_agree_confirm, string6));
            int iIndexOf5 = spannableString3.toString().indexOf(str2);
            spannableString3.setSpan(new C11428c(this.f52086a, "privacy_statement"), iIndexOf5, str2.length() + iIndexOf5, 33);
            spannableString3.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf5, str2.length() + iIndexOf5, 33);
            int iIndexOf6 = spannableString3.toString().indexOf(str3);
            spannableString3.setSpan(new C11428c(this.f52086a, "legal_privacy"), iIndexOf6, str3.length() + iIndexOf6, 33);
            spannableString3.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf6, str3.length() + iIndexOf6, 33);
            m66370c(string7, spannableString3);
            setTitle(this.f52086a.getString(R$string.privacy_statement_cloud_service_change_notice));
            return;
        }
        String string8 = this.f52086a.getString(R$string.cloud_service_slight_pause, str, str2, str3);
        String string9 = this.f52086a.getString(R$string.cloud_service_terms_update, string8);
        SpannableString spannableString4 = new SpannableString(this.f52086a.getString(R$string.cloud_service_agree_confirm, string8));
        int iIndexOf7 = spannableString4.toString().indexOf(str);
        spannableString4.setSpan(new C11428c(this.f52086a, "user_agreement"), iIndexOf7, str.length() + iIndexOf7, 33);
        spannableString4.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf7, str.length() + iIndexOf7, 33);
        int iIndexOf8 = spannableString4.toString().indexOf(str2);
        spannableString4.setSpan(new C11428c(this.f52086a, "privacy_statement"), iIndexOf8, str2.length() + iIndexOf8, 33);
        spannableString4.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf8, str2.length() + iIndexOf8, 33);
        int iIndexOf9 = spannableString4.toString().indexOf(str3);
        spannableString4.setSpan(new C11428c(this.f52086a, "legal_privacy"), iIndexOf9, str3.length() + iIndexOf9, 33);
        spannableString4.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf9, str3.length() + iIndexOf9, 33);
        m66370c(string9, spannableString4);
        setTitle(string);
    }

    /* renamed from: c */
    public final void m66370c(String str, SpannableString spannableString) {
        ((TextView) C12809f.m76831d(this.f52091f, R$id.agreement_content)).setText(str);
        TextView textView = (TextView) C12809f.m76831d(this.f52091f, R$id.agreement_confirm);
        textView.setText(spannableString);
        textView.setMovementMethod(new C11429d());
        textView.setHighlightColor(this.f52086a.getColor(R$color.transparent));
        setView(this.f52091f);
        setCancelable(false);
    }
}
