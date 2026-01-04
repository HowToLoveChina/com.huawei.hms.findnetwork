package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6980bx;
import com.huawei.openalliance.p169ad.download.app.C7049h;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class SixElementsView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    protected int f37390a;

    /* renamed from: b */
    protected Context f37391b;

    /* renamed from: c */
    protected View f37392c;

    /* renamed from: d */
    protected TextView f37393d;

    /* renamed from: e */
    protected TextView f37394e;

    /* renamed from: f */
    protected TextView f37395f;

    /* renamed from: g */
    protected TextView f37396g;

    /* renamed from: h */
    protected TextView f37397h;

    /* renamed from: i */
    protected TextView f37398i;

    /* renamed from: j */
    protected TextView f37399j;

    /* renamed from: k */
    protected TextView f37400k;

    /* renamed from: l */
    protected TextView f37401l;

    /* renamed from: m */
    protected TextView f37402m;

    /* renamed from: n */
    protected AdLandingPageData f37403n;

    /* renamed from: o */
    protected ContentRecord f37404o;

    /* renamed from: p */
    protected MaterialClickInfo f37405p;

    /* renamed from: q */
    private int f37406q;

    /* renamed from: r */
    private float f37407r;

    /* renamed from: s */
    private AppInfo f37408s;

    /* renamed from: com.huawei.openalliance.ad.views.SixElementsView$4 */
    public static /* synthetic */ class C80614 {

        /* renamed from: a */
        static final /* synthetic */ int[] f37415a;

        static {
            int[] iArr = new int[EnumC8062a.values().length];
            f37415a = iArr;
            try {
                iArr[EnumC8062a.DESC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37415a[EnumC8062a.PERMISSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37415a[EnumC8062a.PRIVACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.SixElementsView$a */
    public enum EnumC8062a {
        DESC,
        PRIVACY,
        PERMISSION
    }

    public SixElementsView(Context context) {
        super(context);
        this.f37406q = 0;
        this.f37390a = 0;
        this.f37407r = 0.0f;
        m49931c(context, null);
    }

    /* renamed from: c */
    private void m49930c() {
        if (TextUtils.isEmpty(this.f37408s.getVersionName())) {
            this.f37395f.setVisibility(8);
        } else {
            this.f37395f.setVisibility(0);
            this.f37395f.setText(this.f37391b.getResources().getString(C6849R.string.hiad_app_detail_version, this.f37408s.getVersionName()));
        }
        boolean z10 = true;
        boolean z11 = this.f37395f.getVisibility() == 0;
        boolean zM49937h = m49937h();
        this.f37399j.setVisibility(zM49937h & z11 ? 0 : 8);
        this.f37396g.setVisibility(zM49937h ? 0 : 8);
        boolean z12 = zM49937h || z11;
        boolean zM49939j = m49939j();
        this.f37400k.setVisibility(zM49939j & z12 ? 0 : 8);
        this.f37397h.setVisibility(zM49939j ? 0 : 8);
        if (!zM49939j && !z12) {
            z10 = false;
        }
        boolean zM49938i = m49938i();
        this.f37398i.setVisibility(zM49938i ? 0 : 8);
        this.f37401l.setVisibility((zM49938i && z10) ? 0 : 8);
    }

    /* renamed from: d */
    private void m49933d() throws Resources.NotFoundException {
        boolean z10;
        String string = this.f37391b.getResources().getString(C6849R.string.hiad_app_detail_version, this.f37408s.getVersionName());
        String string2 = this.f37391b.getResources().getString(C6849R.string.hiad_introductory);
        String string3 = this.f37391b.getResources().getString(C6849R.string.hiad_privacy_policy);
        String string4 = this.f37391b.getResources().getString(C6849R.string.hiad_app_permission);
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        if (TextUtils.isEmpty(this.f37408s.getVersionName())) {
            z10 = false;
        } else {
            sb2.append(string);
            z10 = true;
        }
        boolean zM49937h = m49937h();
        if (zM49937h) {
            if (z10) {
                sb2.append("｜");
            }
            sb2.append(string2);
            z10 = true;
        }
        boolean zM49939j = m49939j();
        if (zM49939j) {
            if (z10) {
                sb2.append("｜");
            }
            sb2.append(string3);
        } else {
            z11 = z10;
        }
        boolean zM49938i = m49938i();
        if (zM49938i) {
            if (z11) {
                sb2.append("｜");
            }
            sb2.append(string4);
        }
        SpannableString spannableString = new SpannableString(sb2.toString());
        if (zM49937h) {
            m49926a(spannableString, sb2.toString(), string2, EnumC8062a.DESC);
        }
        if (zM49939j) {
            m49926a(spannableString, sb2.toString(), string3, EnumC8062a.PRIVACY);
        }
        if (zM49938i) {
            m49926a(spannableString, sb2.toString(), string4, EnumC8062a.PERMISSION);
        }
        m49925a(spannableString, sb2.toString());
        this.f37402m.setText(spannableString);
        this.f37402m.setMovementMethod(LinkMovementMethod.getInstance());
        this.f37402m.setHighlightColor(this.f37391b.getResources().getColor(C6849R.color.hiad_transparent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m49934e() {
        if (TextUtils.isEmpty(this.f37408s.getPrivacyLink())) {
            AbstractC7185ho.m43823c("SixElementsView", "privacyUrl is empty.");
        } else {
            this.f37408s.showPrivacyPolicy(this.f37391b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m49935f() {
        if (TextUtils.isEmpty(this.f37408s.getPermissionUrl())) {
            C7049h.m42419a(this.f37391b, this.f37408s);
        } else {
            this.f37408s.showPermissionPage(this.f37391b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m49936g() {
        C6980bx.m41136a(this.f37391b, this.f37403n, getOrgClickInfo());
    }

    /* renamed from: h */
    private boolean m49937h() {
        AppInfo appInfo = this.f37408s;
        return (appInfo == null || TextUtils.isEmpty(appInfo.getAppDetailUrl())) ? false : true;
    }

    /* renamed from: i */
    private boolean m49938i() {
        AppInfo appInfo = this.f37408s;
        return appInfo != null && (!TextUtils.isEmpty(appInfo.getPermissionUrl()) || this.f37408s.m44435w());
    }

    /* renamed from: j */
    private boolean m49939j() {
        AppInfo appInfo;
        AdLandingPageData adLandingPageData = this.f37403n;
        return (adLandingPageData == null || !adLandingPageData.m44306m() || (appInfo = this.f37408s) == null || TextUtils.isEmpty(appInfo.getPackageName()) || TextUtils.isEmpty(this.f37408s.getPrivacyLink())) ? false : true;
    }

    /* renamed from: a */
    public void m49940a() {
        int i10;
        TextView textView;
        if (Float.compare(this.f37407r, 0.0f) != 0) {
            this.f37393d.setTextSize(0, this.f37407r);
        }
        if (1 != this.f37406q) {
            AbstractC7185ho.m43820b("SixElementsView", "supportElderly is not 0, do not adaptation.");
            return;
        }
        if (m49944b()) {
            textView = this.f37402m;
            i10 = C6849R.dimen.hiad_10_dp;
        } else {
            TextView textView2 = this.f37394e;
            i10 = C6849R.dimen.hiad_10_dp;
            m49927a(textView2, i10);
            m49927a(this.f37395f, i10);
            m49927a(this.f37396g, i10);
            m49927a(this.f37397h, i10);
            m49927a(this.f37398i, i10);
            m49927a(this.f37399j, i10);
            m49927a(this.f37400k, i10);
            textView = this.f37401l;
        }
        m49927a(textView, i10);
    }

    /* renamed from: b */
    public void m49943b(Context context, AttributeSet attributeSet) {
        String str;
        if (attributeSet == null) {
            str = "attrs is null..";
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.SixElementsView);
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    this.f37390a = typedArrayObtainStyledAttributes.getInt(C6849R.styleable.SixElementsView_gravity_style, 0);
                    int i10 = typedArrayObtainStyledAttributes.getInt(C6849R.styleable.SixElementsView_support_elderly, 0);
                    this.f37406q = i10;
                    this.f37407r = typedArrayObtainStyledAttributes.getDimension(C6849R.styleable.SixElementsView_title_text_size, i10 == 1 ? AbstractC7741ao.m47535a(context, 16.0f) : AbstractC7741ao.m47565c(context, 16.0f));
                    typedArrayObtainStyledAttributes.recycle();
                    return;
                } catch (Throwable th2) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th2;
                }
            }
            str = "typedArray null..";
        }
        AbstractC7185ho.m43817a("SixElementsView", str);
    }

    public MaterialClickInfo getOrgClickInfo() {
        return this.f37405p;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == C6849R.id.six_elements_privacy_policy || id2 == C6849R.id.endcard_six_elements_privacy_policy) {
            m49934e();
            return;
        }
        if (id2 == C6849R.id.six_elements_permission || id2 == C6849R.id.endcard_six_elements_permission) {
            m49935f();
        } else if (id2 == C6849R.id.six_elements_desc || id2 == C6849R.id.endcard_six_elements_desc) {
            m49936g();
        }
    }

    public void setOrgClickInfo(MaterialClickInfo materialClickInfo) {
        this.f37405p = materialClickInfo;
    }

    public void setTitleTextVisibility(int i10) {
        this.f37393d.setVisibility(i10);
    }

    public SixElementsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37406q = 0;
        this.f37390a = 0;
        this.f37407r = 0.0f;
        m49931c(context, attributeSet);
    }

    /* renamed from: c */
    private void m49931c(Context context, AttributeSet attributeSet) {
        mo49854a(context, attributeSet);
    }

    /* renamed from: a */
    public void mo49854a(Context context, AttributeSet attributeSet) {
        m49943b(context, attributeSet);
        this.f37391b = context;
        if (m49944b()) {
            View viewInflate = View.inflate(context, C6849R.layout.six_elements_elderly_layout, this);
            this.f37392c = viewInflate;
            this.f37402m = (TextView) viewInflate.findViewById(C6849R.id.six_elements_splicing);
        } else {
            this.f37392c = View.inflate(context, this.f37390a == 1 ? C6849R.layout.six_elements_center_layout : C6849R.layout.six_elements_layout, this);
            this.f37395f = (TextView) this.f37392c.findViewById(C6849R.id.six_elements_version);
            TextView textView = (TextView) this.f37392c.findViewById(C6849R.id.six_elements_desc);
            this.f37396g = textView;
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) this.f37392c.findViewById(C6849R.id.six_elements_privacy_policy);
            this.f37397h = textView2;
            textView2.setOnClickListener(this);
            TextView textView3 = (TextView) this.f37392c.findViewById(C6849R.id.six_elements_permission);
            this.f37398i = textView3;
            textView3.setOnClickListener(this);
            this.f37399j = (TextView) this.f37392c.findViewById(C6849R.id.version_line);
            this.f37400k = (TextView) this.f37392c.findViewById(C6849R.id.privacy_line);
            this.f37401l = (TextView) this.f37392c.findViewById(C6849R.id.permission_line);
            m49941a(this.f37392c, false);
        }
        this.f37393d = (TextView) this.f37392c.findViewById(C6849R.id.six_elements_name);
        this.f37394e = (TextView) this.f37392c.findViewById(C6849R.id.six_elements_develop_name);
        m49940a();
    }

    public SixElementsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37406q = 0;
        this.f37390a = 0;
        this.f37407r = 0.0f;
        m49931c(context, attributeSet);
    }

    /* renamed from: a */
    private void m49925a(SpannableString spannableString, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (str.charAt(i10) == 65372) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            spannableString.setSpan(new AbsoluteSizeSpan(this.f37391b.getResources().getDimensionPixelSize(C6849R.dimen.hiad_text_10_sp)) { // from class: com.huawei.openalliance.ad.views.SixElementsView.2
                @Override // android.text.style.AbsoluteSizeSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(SixElementsView.this.f37391b.getResources().getColor(C6849R.color.hiad_20_percent_black));
                    textPaint.setUnderlineText(false);
                }
            }, ((Integer) arrayList.get(i11)).intValue(), ((Integer) arrayList.get(i11)).intValue() + 1, 33);
        }
    }

    /* renamed from: b */
    public boolean m49944b() {
        return this.f37406q == 0 && AbstractC7741ao.m47592n(this.f37391b);
    }

    /* renamed from: a */
    private void m49926a(SpannableString spannableString, String str, String str2, final EnumC8062a enumC8062a) {
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.huawei.openalliance.ad.views.SixElementsView.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                int i10 = C80614.f37415a[enumC8062a.ordinal()];
                if (i10 == 1) {
                    SixElementsView.this.m49936g();
                } else if (i10 == 2) {
                    SixElementsView.this.m49935f();
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    SixElementsView.this.m49934e();
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SixElementsView.this.f37391b.getResources().getColor(C6849R.color.hiad_40_percent_black));
                textPaint.setUnderlineText(false);
            }
        };
        int iIndexOf = str.indexOf(str2);
        spannableString.setSpan(clickableSpan, iIndexOf, str2.length() + iIndexOf, 33);
    }

    /* renamed from: a */
    public void m49941a(final View view, final boolean z10) {
        if (view == null) {
            AbstractC7185ho.m43820b("SixElementsView", "rootView is null..");
        } else {
            view.postDelayed(new Runnable() { // from class: com.huawei.openalliance.ad.views.SixElementsView.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = view.getWidth();
                    if (width == 0) {
                        AbstractC7185ho.m43820b("SixElementsView", "do not get screen width.");
                        return;
                    }
                    double d10 = width;
                    int i10 = (int) (0.35d * d10);
                    AbstractC7185ho.m43821b("SixElementsView", "larger detail width is %d", Integer.valueOf(i10));
                    int i11 = (int) (0.18d * d10);
                    AbstractC7185ho.m43821b("SixElementsView", "small detail width is %d", Integer.valueOf(i11));
                    if (z10) {
                        SixElementsView.this.f37395f.setMaxWidth((int) (d10 * 0.2d));
                    } else {
                        SixElementsView.this.f37395f.setMaxWidth(i10);
                    }
                    SixElementsView.this.f37396g.setMaxWidth(i11);
                    SixElementsView.this.f37397h.setMaxWidth(i11);
                    SixElementsView.this.f37398i.setMaxWidth(i11);
                    String lowerCase = AbstractC7811dd.m48345u(SixElementsView.this.f37391b).toLowerCase(Locale.getDefault());
                    AbstractC7185ho.m43818a("SixElementsView", " languageCode=%s", lowerCase);
                    if ("bo-cn".equals(lowerCase)) {
                        SixElementsView.this.f37395f.setIncludeFontPadding(true);
                        SixElementsView.this.f37396g.setIncludeFontPadding(true);
                        SixElementsView.this.f37397h.setIncludeFontPadding(true);
                        SixElementsView.this.f37398i.setIncludeFontPadding(true);
                    }
                }
            }, 200L);
        }
    }

    /* renamed from: a */
    private void m49927a(TextView textView, int i10) {
        if (textView == null) {
            return;
        }
        textView.setTextSize(0, this.f37391b.getResources().getDimensionPixelSize(i10));
    }

    /* renamed from: a */
    public void mo49855a(AdLandingPageData adLandingPageData) {
        String str;
        if (adLandingPageData == null) {
            str = "landingPageData is null.";
        } else {
            this.f37403n = adLandingPageData;
            this.f37408s = adLandingPageData.getAppInfo();
            this.f37404o = adLandingPageData.m44329y();
            AppInfo appInfo = this.f37408s;
            if (appInfo != null) {
                this.f37393d.setText(!TextUtils.isEmpty(appInfo.getAppName()) ? this.f37408s.getAppName() : this.f37408s.getAppDesc());
                this.f37394e.setText(this.f37408s.getDeveloperName());
                if (m49944b()) {
                    m49933d();
                    return;
                } else {
                    m49930c();
                    return;
                }
            }
            str = "appInfo is null.";
        }
        AbstractC7185ho.m43823c("SixElementsView", str);
    }

    /* renamed from: a */
    public void m49942a(boolean z10) {
        if (m49944b()) {
            return;
        }
        m49941a(this.f37392c, z10);
    }
}
