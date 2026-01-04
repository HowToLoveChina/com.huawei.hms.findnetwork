package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.LabelPosition;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PPSSplashAdSourceView extends RelativeLayout {

    /* renamed from: a */
    private PPSSplashLabelView f37076a;

    /* renamed from: b */
    private TextView f37077b;

    /* renamed from: c */
    private Integer f37078c;

    /* renamed from: d */
    private Integer f37079d;

    /* renamed from: e */
    private WeakReference<InterfaceC7337jk> f37080e;

    /* renamed from: f */
    private boolean f37081f;

    /* renamed from: g */
    private boolean f37082g;

    public PPSSplashAdSourceView(Context context) {
        super(context, null);
        this.f37081f = false;
        this.f37082g = false;
    }

    /* renamed from: b */
    private void m49614b(ContentRecord contentRecord) {
        TextView textView;
        int i10;
        MetaData metaDataM41568i = contentRecord.m41568i();
        if (metaDataM41568i == null || this.f37077b == null) {
            return;
        }
        String strM48168c = AbstractC7806cz.m48168c(metaDataM41568i.m40326l());
        if (TextUtils.isEmpty(strM48168c)) {
            textView = this.f37077b;
            i10 = 8;
        } else {
            this.f37077b.setText(strM48168c);
            textView = this.f37077b;
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    /* renamed from: a */
    public void m49616a() {
        PPSSplashLabelView pPSSplashLabelView = this.f37076a;
        if (pPSSplashLabelView != null) {
            pPSSplashLabelView.m49216b();
        }
    }

    public int getRootLayoutId() {
        this.f37082g = m49613a(getContext(), this.f37078c, this.f37079d);
        return m49615b() ? C6849R.layout.hiad_splash_ad_source_with_click : C6849R.layout.hiad_splash_ad_source;
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37081f = false;
        this.f37082g = false;
    }

    /* renamed from: a */
    private void m49609a(int i10, int i11, boolean z10, int i12, int i13, RelativeLayout.LayoutParams layoutParams) {
        int iM48326f;
        layoutParams.addRule(10);
        layoutParams.addRule(21);
        layoutParams.rightMargin = i12;
        layoutParams.setMarginEnd(i12);
        layoutParams.topMargin = i13;
        if (i11 != 0) {
            layoutParams.topMargin = i13 + i10;
            return;
        }
        if (!z10) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + i10);
            layoutParams.rightMargin += i10;
        }
        if (C6982bz.m41152b(getContext())) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + AbstractC7811dd.m48326f(getContext()));
            iM48326f = layoutParams.rightMargin + AbstractC7811dd.m48326f(getContext());
        } else {
            layoutParams.setMarginEnd(AbstractC7811dd.m48326f(getContext()));
            iM48326f = AbstractC7811dd.m48326f(getContext());
        }
        layoutParams.rightMargin = iM48326f;
        layoutParams.topMargin += AbstractC7741ao.m47535a(getContext(), 12.0f);
    }

    /* renamed from: b */
    private boolean m49615b() {
        AbstractC7185ho.m43821b("PPSSplashAdSourceView", "isSplashClickable: %s, isShowTransparency: %s", Boolean.valueOf(this.f37082g), Boolean.valueOf(this.f37081f));
        return this.f37082g || this.f37081f;
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37081f = false;
        this.f37082g = false;
    }

    /* renamed from: a */
    private void m49610a(Context context) {
        AbstractC7185ho.m43820b("PPSSplashAdSourceView", "init");
        View.inflate(context, getRootLayoutId(), this);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(C6849R.id.hiad_ad_label);
        this.f37076a = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(C6849R.id.hiad_ad_source);
        this.f37077b = textView;
        textView.setVisibility(8);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.f37081f = false;
        this.f37082g = false;
    }

    /* renamed from: a */
    private void m49611a(ContentRecord contentRecord) {
        PPSSplashLabelView pPSSplashLabelView;
        int i10;
        String strM41411O = !AbstractC7806cz.m48165b(contentRecord.m41411O()) ? contentRecord.m41411O() : getResources().getString(C6849R.string.hiad_ad_label_new);
        MetaData metaDataM41568i = contentRecord.m41568i();
        AdSource adSourceM39547a = (metaDataM41568i == null || metaDataM41568i.m40275L() == null) ? null : AdSource.m39547a(metaDataM41568i.m40275L());
        this.f37076a.setDataAndRefreshUi(contentRecord);
        if (this.f37076a.m49215a()) {
            PPSSplashLabelView pPSSplashLabelView2 = this.f37076a;
            WeakReference<InterfaceC7337jk> weakReference = this.f37080e;
            pPSSplashLabelView2.m49211a(weakReference != null ? weakReference.get() : null, contentRecord, this.f37081f);
            this.f37076a.m49649a(adSourceM39547a, strM41411O, this.f37078c, this.f37082g);
            pPSSplashLabelView = this.f37076a;
            i10 = 0;
        } else {
            pPSSplashLabelView = this.f37076a;
            i10 = 8;
        }
        pPSSplashLabelView.setVisibility(i10);
    }

    /* renamed from: a */
    public void m49617a(ContentRecord contentRecord, boolean z10, int i10, int i11, boolean z11) {
        AbstractC7185ho.m43820b("PPSSplashAdSourceView", "positionAndSet");
        m49610a(getContext());
        String strM41415Q = contentRecord.m41415Q() == null ? LabelPosition.LOWER_LEFT : contentRecord.m41415Q();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Resources resources = getResources();
        int i12 = C6849R.dimen.hiad_splash_label_side_margin;
        int dimensionPixelSize = resources.getDimensionPixelSize(i12);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i12);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if ("tr".equals(strM41415Q)) {
                m49609a(i10, i11, z11, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            } else {
                m49612a(z10, i10, i11, z11, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            }
            setLayoutParams(layoutParams2);
        }
        m49611a(contentRecord);
        m49614b(contentRecord);
    }

    /* renamed from: a */
    public void m49618a(InterfaceC7337jk interfaceC7337jk, Integer num, Integer num2, boolean z10) {
        AbstractC7185ho.m43821b("PPSSplashAdSourceView", "setAdLabelConfig %s %s %s", num, num2, Boolean.valueOf(z10));
        this.f37080e = new WeakReference<>(interfaceC7337jk);
        this.f37078c = num;
        this.f37079d = num2;
        this.f37081f = z10;
    }

    /* renamed from: a */
    private void m49612a(boolean z10, int i10, int i11, boolean z11, int i12, int i13, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        layoutParams.leftMargin = i12;
        layoutParams.setMarginStart(i12);
        layoutParams.bottomMargin = i13;
        if (i11 != 0) {
            if (z10) {
                return;
            }
            layoutParams.bottomMargin = i13 + AbstractC7811dd.m48326f(getContext());
            return;
        }
        if (C6982bz.m41152b(getContext()) && z11) {
            layoutParams.setMarginStart(layoutParams.leftMargin + i10);
            layoutParams.leftMargin += i10;
        } else if (!C6982bz.m41152b(getContext()) || (C6982bz.m41152b(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1)) {
            layoutParams.setMarginStart(AbstractC7811dd.m48326f(getContext()));
            layoutParams.leftMargin = AbstractC7811dd.m48326f(getContext());
        }
        if (z10) {
            return;
        }
        if (C7845x.m48587n(getContext()) || C7845x.m48595q(getContext())) {
            layoutParams.bottomMargin += AbstractC7811dd.m48326f(getContext());
        }
    }

    /* renamed from: a */
    public static boolean m49613a(Context context, Integer num, Integer num2) {
        if (!C6982bz.m41148a(context).mo41175d() || num == null || num2 == null) {
            return false;
        }
        return ((num.intValue() == 1 || num.intValue() == 4) && (num2.intValue() == 2 || num2.intValue() == 3)) || ((num.intValue() == 2 || num.intValue() == 3) && (num2.intValue() == 1 || num2.intValue() == 3));
    }
}
