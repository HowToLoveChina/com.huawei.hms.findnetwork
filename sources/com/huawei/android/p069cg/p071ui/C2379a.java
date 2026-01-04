package com.huawei.android.p069cg.p071ui;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.huawei.android.p069cg.p071ui.InvitationCodeView;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.android.cg.ui.a */
/* loaded from: classes2.dex */
public class C2379a implements InputFilter {

    /* renamed from: a */
    public Pattern f11334a = Pattern.compile("[0-9]*[a-z|A-Z]*");

    /* renamed from: b */
    public Pattern f11335b = Pattern.compile("[a-z]*");

    /* renamed from: c */
    public InvitationCodeView.InterfaceC2341c f11336c;

    public C2379a(InvitationCodeView.InterfaceC2341c interfaceC2341c) {
        this.f11336c = interfaceC2341c;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        String string = charSequence.toString();
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        Matcher matcher = this.f11334a.matcher(charSequence);
        if (this.f11335b.matcher(charSequence).matches()) {
            string = string.toUpperCase(Locale.US);
        }
        if (matcher.matches()) {
            this.f11336c.onResult(true);
            return string;
        }
        this.f11336c.onResult(false);
        return "";
    }
}
