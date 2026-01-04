package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6980bx;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7699tu;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7752az;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class PPSLabelView extends TextView {

    /* renamed from: a */
    protected ContentRecord f36775a;

    /* renamed from: b */
    protected Integer f36776b;

    /* renamed from: c */
    protected boolean f36777c;

    /* renamed from: d */
    protected boolean f36778d;

    /* renamed from: e */
    protected boolean f36779e;

    /* renamed from: f */
    protected WeakReference<InterfaceC7337jk> f36780f;

    /* renamed from: g */
    private C7959b f36781g;

    /* renamed from: h */
    private boolean f36782h;

    /* renamed from: i */
    private boolean f36783i;

    /* renamed from: j */
    private Drawable f36784j;

    /* renamed from: k */
    private View.OnClickListener f36785k;

    /* renamed from: com.huawei.openalliance.ad.views.PPSLabelView$a */
    public static class C7958a implements C7752az.a {

        /* renamed from: a */
        private final WeakReference<PPSLabelView> f36792a;

        /* renamed from: b */
        private String f36793b;

        public C7958a(PPSLabelView pPSLabelView, String str) {
            this.f36792a = new WeakReference<>(pPSLabelView);
            this.f36793b = str;
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30231a() {
            AbstractC7185ho.m43820b("PPSLabelView", "start - dspLogo load failed");
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.a.2
                @Override // java.lang.Runnable
                public void run() {
                    PPSLabelView pPSLabelView = (PPSLabelView) C7958a.this.f36792a.get();
                    if (pPSLabelView != null) {
                        pPSLabelView.setTextWhenImgLoadFail(C7958a.this.f36793b);
                    }
                }
            });
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30232a(final Drawable drawable) {
            AbstractC7185ho.m43820b("PPSLabelView", "start - dspLogo load onSuccess");
            if (drawable != null) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSLabelView pPSLabelView = (PPSLabelView) C7958a.this.f36792a.get();
                        if (pPSLabelView != null) {
                            pPSLabelView.mo49212a(C7958a.this.f36793b, drawable);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLabelView$b */
    public static class C7959b {

        /* renamed from: a */
        private WeakReference<C7699tu> f36797a;

        private C7959b(C7699tu c7699tu) {
            this.f36797a = new WeakReference<>(c7699tu);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m49221a() {
            C7699tu c7699tu;
            WeakReference<C7699tu> weakReference = this.f36797a;
            if (weakReference == null || (c7699tu = weakReference.get()) == null) {
                return;
            }
            c7699tu.m47305i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public boolean m49223b() {
            C7699tu c7699tu;
            WeakReference<C7699tu> weakReference = this.f36797a;
            if (weakReference == null || (c7699tu = weakReference.get()) == null) {
                return false;
            }
            return c7699tu.m47306j();
        }
    }

    public PPSLabelView(Context context) {
        super(context);
        this.f36777c = false;
        this.f36778d = false;
        this.f36779e = true;
        this.f36782h = true;
        this.f36783i = false;
        this.f36785k = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                WeakReference<InterfaceC7337jk> weakReference = PPSLabelView.this.f36780f;
                if (weakReference != null) {
                    final InterfaceC7337jk interfaceC7337jk = weakReference.get();
                    if (interfaceC7337jk == null) {
                        AbstractC7185ho.m43823c("PPSLabelView", "adView is null");
                        return;
                    }
                    final int[] iArrM48312b = AbstractC7811dd.m48312b(view);
                    final int[] iArrM48318c = AbstractC7811dd.m48318c(view);
                    if (AbstractC7741ao.m47556a(iArrM48312b, 2) && AbstractC7741ao.m47556a(iArrM48318c, 2)) {
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PPSLabelView.this.m49206a(interfaceC7337jk)) {
                                    PPSLabelView pPSLabelView = PPSLabelView.this;
                                    pPSLabelView.m49202a((RelativeLayout) interfaceC7337jk, pPSLabelView.f36775a, pPSLabelView.f36777c, pPSLabelView.f36776b, iArrM48312b, iArrM48318c, 1);
                                    return;
                                }
                                Object obj = interfaceC7337jk;
                                if (!(obj instanceof PPSRewardView) && !(obj instanceof PPSInterstitialView)) {
                                    C6980bx.m41131a(PPSLabelView.this.getContext(), view, PPSLabelView.this.f36775a);
                                } else {
                                    PPSLabelView pPSLabelView2 = PPSLabelView.this;
                                    pPSLabelView2.m49201a((RelativeLayout) obj, pPSLabelView2.f36775a, pPSLabelView2.f36777c, pPSLabelView2.f36776b, iArrM48312b, iArrM48318c);
                                }
                            }
                        });
                    }
                }
            }
        };
        m49200a(context);
    }

    /* renamed from: a */
    private SpannableStringBuilder m49199a(SpannableString spannableString) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
        ImageSpan clickImageSpanRight = getClickImageSpanRight();
        if (clickImageSpanRight != null) {
            spannableStringBuilder.setSpan(clickImageSpanRight, spannableString.length() - 1, spannableString.length(), 33);
        }
        return spannableStringBuilder;
    }

    private ImageSpan getClickImageSpanRight() {
        try {
            Drawable drawable = getResources().getDrawable(C6849R.drawable.hiad_chevron_right);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (!AbstractC7811dd.m48315c()) {
                return new C8079c(drawable, 2, AbstractC7741ao.m47535a(getContext(), 4.0f), 0);
            }
            return new C8079c(getContext(), C7752az.m47693b(drawable), 2, AbstractC7741ao.m47535a(getContext(), 4.0f), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String getDefaultAdSign() {
        return this.f36782h ? getResources().getString(C6849R.string.hiad_ad_label_new) : "";
    }

    /* renamed from: b */
    public void m49216b() {
        C7959b c7959b = this.f36781g;
        if (c7959b != null) {
            c7959b.m49221a();
        }
    }

    /* renamed from: c */
    public boolean m49218c() {
        C7959b c7959b = this.f36781g;
        if (c7959b == null) {
            return false;
        }
        return c7959b.m49223b();
    }

    public void setClick(SpannableStringBuilder spannableStringBuilder) {
        if (!this.f36778d && !this.f36777c) {
            setText(spannableStringBuilder);
            return;
        }
        spannableStringBuilder.append(" ");
        setText(m49199a(new SpannableString(spannableStringBuilder)));
        setOnClickListener(this.f36785k);
    }

    public void setDataAndRefreshUi(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        this.f36775a = contentRecord;
        if (contentRecord.m41568i() != null) {
            this.f36779e = "2".equalsIgnoreCase(contentRecord.m41568i().m40341u());
        }
        if (this.f36779e) {
            return;
        }
        setVisibility(8);
    }

    public void setTextForAppDetailView(AdSource adSource) {
        if (adSource == null) {
            AbstractC7185ho.m43820b("PPSLabelView", "setTextWithDspInfo, use default adSign");
            return;
        }
        this.f36782h = false;
        this.f36783i = true;
        mo49217b(adSource, "");
    }

    public void setTextWhenImgLoadFail(String str) {
        String defaultAdSign = getDefaultAdSign();
        if (TextUtils.isEmpty(str)) {
            str = defaultAdSign;
        }
        if (TextUtils.isEmpty(str) && !this.f36782h) {
            setVisibility(8);
        }
        setText(str);
        setClick(new SpannableStringBuilder(getText()));
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (!this.f36779e) {
            i10 = 8;
        }
        super.setVisibility(i10);
    }

    public PPSLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36777c = false;
        this.f36778d = false;
        this.f36779e = true;
        this.f36782h = true;
        this.f36783i = false;
        this.f36785k = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                WeakReference<InterfaceC7337jk> weakReference = PPSLabelView.this.f36780f;
                if (weakReference != null) {
                    final InterfaceC7337jk interfaceC7337jk = weakReference.get();
                    if (interfaceC7337jk == null) {
                        AbstractC7185ho.m43823c("PPSLabelView", "adView is null");
                        return;
                    }
                    final int[] iArrM48312b = AbstractC7811dd.m48312b(view);
                    final int[] iArrM48318c = AbstractC7811dd.m48318c(view);
                    if (AbstractC7741ao.m47556a(iArrM48312b, 2) && AbstractC7741ao.m47556a(iArrM48318c, 2)) {
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PPSLabelView.this.m49206a(interfaceC7337jk)) {
                                    PPSLabelView pPSLabelView = PPSLabelView.this;
                                    pPSLabelView.m49202a((RelativeLayout) interfaceC7337jk, pPSLabelView.f36775a, pPSLabelView.f36777c, pPSLabelView.f36776b, iArrM48312b, iArrM48318c, 1);
                                    return;
                                }
                                Object obj = interfaceC7337jk;
                                if (!(obj instanceof PPSRewardView) && !(obj instanceof PPSInterstitialView)) {
                                    C6980bx.m41131a(PPSLabelView.this.getContext(), view, PPSLabelView.this.f36775a);
                                } else {
                                    PPSLabelView pPSLabelView2 = PPSLabelView.this;
                                    pPSLabelView2.m49201a((RelativeLayout) obj, pPSLabelView2.f36775a, pPSLabelView2.f36777c, pPSLabelView2.f36776b, iArrM48312b, iArrM48318c);
                                }
                            }
                        });
                    }
                }
            }
        };
        m49200a(context);
    }

    /* renamed from: a */
    public ImageSpan m49209a(Drawable drawable, boolean z10) {
        Bitmap bitmapM47684a = C7752az.m47684a(drawable);
        if (bitmapM47684a == null) {
            AbstractC7185ho.m43820b("PPSLabelView", "originImage bitmap is null");
            return null;
        }
        float textSize = getTextSize();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapM47684a, Math.round(textSize), Math.round(textSize), false));
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        return new C8079c(bitmapDrawable, 2, 0, z10 ? AbstractC7741ao.m47535a(getContext(), 4.0f) : 0);
    }

    /* renamed from: b */
    public void mo49217b(AdSource adSource, String str) {
        SpannableStringBuilder spannableStringBuilder;
        if (adSource == null) {
            return;
        }
        String strM48168c = AbstractC7806cz.m48168c(adSource.m39551a()) == null ? "" : AbstractC7806cz.m48168c(adSource.m39551a());
        if (str == null) {
            str = "";
        }
        String str2 = strM48168c + str;
        String strM39554b = adSource.m39554b();
        if (TextUtils.isEmpty(strM48168c) && TextUtils.isEmpty(strM39554b)) {
            AbstractC7185ho.m43820b("PPSLabelView", "displayTextWithDspInfo, use default adSign");
            spannableStringBuilder = new SpannableStringBuilder(getText());
        } else if (TextUtils.isEmpty(strM48168c) || !TextUtils.isEmpty(strM39554b)) {
            m49213a(str2, strM39554b);
            return;
        } else {
            AbstractC7185ho.m43820b("PPSLabelView", "displayTextWithDspInfo, use dspNameWithAdSign");
            spannableStringBuilder = new SpannableStringBuilder(str2);
        }
        setClick(spannableStringBuilder);
    }

    public PPSLabelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36777c = false;
        this.f36778d = false;
        this.f36779e = true;
        this.f36782h = true;
        this.f36783i = false;
        this.f36785k = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                WeakReference<InterfaceC7337jk> weakReference = PPSLabelView.this.f36780f;
                if (weakReference != null) {
                    final InterfaceC7337jk interfaceC7337jk = weakReference.get();
                    if (interfaceC7337jk == null) {
                        AbstractC7185ho.m43823c("PPSLabelView", "adView is null");
                        return;
                    }
                    final int[] iArrM48312b = AbstractC7811dd.m48312b(view);
                    final int[] iArrM48318c = AbstractC7811dd.m48318c(view);
                    if (AbstractC7741ao.m47556a(iArrM48312b, 2) && AbstractC7741ao.m47556a(iArrM48318c, 2)) {
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PPSLabelView.this.m49206a(interfaceC7337jk)) {
                                    PPSLabelView pPSLabelView = PPSLabelView.this;
                                    pPSLabelView.m49202a((RelativeLayout) interfaceC7337jk, pPSLabelView.f36775a, pPSLabelView.f36777c, pPSLabelView.f36776b, iArrM48312b, iArrM48318c, 1);
                                    return;
                                }
                                Object obj = interfaceC7337jk;
                                if (!(obj instanceof PPSRewardView) && !(obj instanceof PPSInterstitialView)) {
                                    C6980bx.m41131a(PPSLabelView.this.getContext(), view, PPSLabelView.this.f36775a);
                                } else {
                                    PPSLabelView pPSLabelView2 = PPSLabelView.this;
                                    pPSLabelView2.m49201a((RelativeLayout) obj, pPSLabelView2.f36775a, pPSLabelView2.f36777c, pPSLabelView2.f36776b, iArrM48312b, iArrM48318c);
                                }
                            }
                        });
                    }
                }
            }
        };
        m49200a(context);
    }

    /* renamed from: a */
    private void m49200a(Context context) {
        try {
            this.f36784j = context.getResources().getDrawable(C6849R.drawable.hiad_default_dsp_logo);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("PPSLabelView", "init error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49201a(RelativeLayout relativeLayout, ContentRecord contentRecord, boolean z10, Integer num, int[] iArr, int[] iArr2) {
        m49202a(relativeLayout, contentRecord, z10, num, iArr, iArr2, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49202a(RelativeLayout relativeLayout, ContentRecord contentRecord, boolean z10, Integer num, int[] iArr, int[] iArr2, int i10) {
        if (relativeLayout == null || contentRecord == null) {
            return;
        }
        if (!AbstractC7741ao.m47556a(iArr, 2) || !AbstractC7741ao.m47556a(iArr2, 2)) {
            AbstractC7185ho.m43823c("PPSLabelView", "anchor is invalid.");
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSLabelView", "addTransparencyDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            AbstractC7185ho.m43818a("PPSLabelView", "addTransparencyDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
        }
        m49203a(relativeLayout, iArr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        C7699tu c7699tu = new C7699tu(relativeLayout.getContext(), iArr, iArr2, i10);
        this.f36781g = new C7959b(c7699tu);
        if (relativeLayout instanceof PPSSplashView) {
            c7699tu.m47329a(z10, num, ((PPSSplashView) relativeLayout).getAdMediator());
        }
        if (!(relativeLayout instanceof PPSLinkedView)) {
            AbstractC7185ho.m43818a("PPSLabelView", "addTransparencyDialog, adview: %s, %s", Integer.valueOf(relativeLayout.getMeasuredHeight()), Integer.valueOf(relativeLayout.getMeasuredWidth()));
            relativeLayout.addView(c7699tu, layoutParams);
            c7699tu.setScreenHeight(relativeLayout.getMeasuredHeight());
            c7699tu.setScreenWidth(relativeLayout.getMeasuredWidth());
            c7699tu.m47304h();
        } else if (!m49208a((PPSLinkedView) relativeLayout, z10, num, layoutParams, c7699tu)) {
            return;
        }
        c7699tu.setAdContent(contentRecord);
    }

    /* renamed from: a */
    private void m49203a(RelativeLayout relativeLayout, int[] iArr) {
        if (AbstractC7811dd.m48309b(AbstractC7811dd.m48320d(relativeLayout))) {
            int iM48349y = AbstractC7811dd.m48349y(getContext());
            AbstractC7185ho.m43821b("PPSLabelView", "drag H: %s", Integer.valueOf(iM48349y));
            iArr[1] = iArr[1] - iM48349y;
        } else if (relativeLayout instanceof PPSInterstitialView) {
            int iMo41169a = C6982bz.m41148a(getContext()).mo41169a(this);
            AbstractC7185ho.m43821b("PPSLabelView", "notch H: %s", Integer.valueOf(iMo41169a));
            if (AbstractC7811dd.m48336l(getContext())) {
                iArr[1] = iArr[1] - iMo41169a;
            } else {
                iArr[0] = iArr[0] - iMo41169a;
            }
        }
    }

    /* renamed from: a */
    public void m49210a(AdSource adSource, String str) {
        if (this.f36779e) {
            if (adSource != null && !TextUtils.isEmpty(str)) {
                mo49217b(adSource, str);
            } else {
                AbstractC7185ho.m43820b("PPSLabelView", "setTextWithDspInfo, use default adSign");
                setClick(new SpannableStringBuilder(getText()));
            }
        }
    }

    /* renamed from: a */
    public void m49211a(InterfaceC7337jk interfaceC7337jk, ContentRecord contentRecord, boolean z10) {
        this.f36775a = contentRecord;
        this.f36778d = z10;
        this.f36780f = new WeakReference<>(interfaceC7337jk);
    }

    /* renamed from: a */
    public void mo49212a(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            String defaultAdSign = getDefaultAdSign();
            if (TextUtils.isEmpty(str)) {
                str = defaultAdSign;
            }
            boolean z10 = !TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            ImageSpan imageSpanM49209a = m49209a(drawable, z10);
            if (imageSpanM49209a != null) {
                spannableStringBuilder.setSpan(imageSpanM49209a, 0, 1, 33);
            }
            setClick(spannableStringBuilder);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("PPSLabelView", "setTextWhenImgLoaded error");
        }
    }

    /* renamed from: a */
    public void m49213a(String str, String str2) {
        Context context;
        C7958a c7958a;
        if (this.f36779e) {
            AbstractC7185ho.m43820b("PPSLabelView", "loadAndSetDspInfo, start");
            C7022dk c7022dkM41937a = C7019dh.m41937a(getContext(), Constants.NORMAL_CACHE);
            String strM41968c = c7022dkM41937a.m41968c(c7022dkM41937a.m41970e(str2));
            if (this.f36783i) {
                mo49212a(str, this.f36784j);
                if (TextUtils.isEmpty(strM41968c)) {
                    C7653sb c7653sb = new C7653sb();
                    c7653sb.m47181b(false);
                    c7653sb.m47185c(true);
                    c7653sb.m47187d(str2);
                    C7752az.m47689a(getContext(), c7653sb, new C7958a(this, str));
                    return;
                }
                context = getContext();
                c7958a = new C7958a(this, str);
            } else if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(strM41968c)) {
                AbstractC7185ho.m43820b("PPSLabelView", "displayTextWithDspInfo, use dspNameWithAdSign");
                setTextWhenImgLoadFail(str);
                return;
            } else {
                mo49212a(str, this.f36784j);
                context = getContext();
                c7958a = new C7958a(this, str);
            }
            C7752az.m47690a(context, strM41968c, c7958a);
        }
    }

    /* renamed from: a */
    public void m49214a(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder;
        if (this.f36779e) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
                AbstractC7185ho.m43820b("PPSLabelView", "dspInfo all empty or logo2Text is empty");
                AbstractC7185ho.m43820b("PPSLabelView", "setTextWithDspInfo, use default adSign");
                spannableStringBuilder = new SpannableStringBuilder(getText());
            } else {
                if (str == null) {
                    str = "";
                }
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str + str3;
                if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str2)) {
                    AbstractC7185ho.m43820b("PPSLabelView", "setTextWithDspInfo, use default adSign");
                    spannableStringBuilder = new SpannableStringBuilder(getText());
                } else if (TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str2)) {
                    m49213a(str4, str2);
                    return;
                } else {
                    AbstractC7185ho.m43820b("PPSLabelView", "setTextWithDspInfo, use dspNameWithAdSign");
                    setText(str4);
                    spannableStringBuilder = new SpannableStringBuilder(getText());
                }
            }
            setClick(spannableStringBuilder);
        }
    }

    /* renamed from: a */
    public boolean m49215a() {
        return this.f36779e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m49206a(InterfaceC7337jk interfaceC7337jk) {
        return (interfaceC7337jk instanceof PPSSplashView) || (interfaceC7337jk instanceof PPSLinkedView);
    }

    /* renamed from: a */
    private boolean m49208a(PPSLinkedView pPSLinkedView, boolean z10, Integer num, RelativeLayout.LayoutParams layoutParams, C7699tu c7699tu) {
        C8074ai c8074aiMo49301n = pPSLinkedView.mo49301n();
        if (c8074aiMo49301n == null) {
            AbstractC7185ho.m43823c("PPSLabelView", "linked splash container is null");
            return false;
        }
        c7699tu.m47329a(z10, num, pPSLinkedView.mo49300m());
        c8074aiMo49301n.addView(c7699tu, layoutParams);
        c7699tu.setScreenHeight(c8074aiMo49301n.getMeasuredHeight());
        c7699tu.setScreenWidth(c8074aiMo49301n.getMeasuredWidth());
        return true;
    }
}
