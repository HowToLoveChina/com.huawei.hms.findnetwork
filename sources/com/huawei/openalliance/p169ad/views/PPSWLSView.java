package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.LabelPosition;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PPSWLSView extends RelativeLayout {

    /* renamed from: a */
    private PPSSplashLabelView f37197a;

    /* renamed from: b */
    private TextView f37198b;

    /* renamed from: c */
    private ChoicesView f37199c;

    /* renamed from: d */
    private InterfaceC7328jb f37200d;

    /* renamed from: e */
    private WeakReference<PPSLinkedView> f37201e;

    /* renamed from: f */
    private Integer f37202f;

    /* renamed from: g */
    private Integer f37203g;

    /* renamed from: h */
    private View.OnClickListener f37204h;

    public PPSWLSView(Context context) {
        super(context, null);
        m49721a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PPSLinkedView getPpsLinkedView() {
        WeakReference<PPSLinkedView> weakReference = this.f37201e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int[] getChoiceViewLoc() {
        return AbstractC7811dd.m48312b(this.f37199c);
    }

    public int[] getChoiceViewSize() {
        return AbstractC7811dd.m48318c(this.f37199c);
    }

    public void setAdMediator(InterfaceC7328jb interfaceC7328jb) {
        this.f37200d = interfaceC7328jb;
    }

    public void setChoiceViewOnClickListener(View.OnClickListener onClickListener) {
        this.f37204h = onClickListener;
    }

    public void setPpsLinkedView(PPSLinkedView pPSLinkedView) {
        this.f37201e = new WeakReference<>(pPSLinkedView);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m49721a(context);
    }

    /* renamed from: a */
    private void m49721a(Context context) {
        View.inflate(context, C6849R.layout.hiad_wls_view, this);
        ChoicesView choicesView = (ChoicesView) findViewById(C6849R.id.splash_why_this_ad);
        this.f37199c = choicesView;
        choicesView.setVisibility(8);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(C6849R.id.hiad_ad_label_wls);
        this.f37197a = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(C6849R.id.hiad_ad_source_wls);
        this.f37198b = textView;
        textView.setVisibility(8);
    }

    /* renamed from: b */
    private void m49727b(final ContentRecord contentRecord, String str) {
        m49724a(str);
        String strM48168c = AbstractC7806cz.m48168c(contentRecord.m41490al());
        String strM48168c2 = AbstractC7806cz.m48168c(contentRecord.m41491am());
        if (!TextUtils.isEmpty(strM48168c)) {
            if (TextUtils.isEmpty(strM48168c2)) {
                this.f37199c.m30230b();
            } else {
                this.f37199c.setAdChoiceIcon(strM48168c2);
            }
        }
        this.f37199c.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSWLSView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSWLSView", "choiceView onclick");
                }
                if (PPSWLSView.this.f37204h != null) {
                    PPSWLSView.this.f37204h.onClick(view);
                    return;
                }
                if (AbstractC7741ao.m47548a(PPSWLSView.this.getContext(), contentRecord)) {
                    if (PPSWLSView.this.f37200d != null) {
                        PPSWLSView.this.f37200d.mo45173e();
                    }
                    if (PPSWLSView.this.getPpsLinkedView() != null) {
                        PPSWLSView.this.getPpsLinkedView().mo49292a((Integer) 10, true);
                    }
                }
            }
        });
    }

    /* renamed from: c */
    private void m49730c(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37198b.getLayoutParams();
        int i10 = C6849R.id.hiad_ad_label_wls;
        layoutParams.addRule(6, i10);
        layoutParams.addRule(8, i10);
        if (!this.f37197a.m49215a()) {
            layoutParams.addRule(15);
        }
        layoutParams.addRule("tr".equals(str) ? 16 : 17, i10);
        this.f37198b.setLayoutParams(layoutParams);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m49721a(context);
    }

    /* renamed from: a */
    private void m49722a(ContentRecord contentRecord) {
        MetaData metaDataM41568i = contentRecord.m41568i();
        if (metaDataM41568i != null) {
            String strM48168c = AbstractC7806cz.m48168c(metaDataM41568i.m40326l());
            if (TextUtils.isEmpty(strM48168c)) {
                this.f37198b.setVisibility(8);
                return;
            }
            this.f37198b.setText(strM48168c);
            this.f37198b.setVisibility(0);
            m49730c(contentRecord.m41415Q());
        }
    }

    /* renamed from: b */
    private void m49728b(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37197a.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.addRule("tr".equals(str) ? 16 : 17, C6849R.id.splash_why_this_ad);
        this.f37197a.setLayoutParams(layoutParams);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        m49721a(context);
    }

    /* renamed from: a */
    private void m49723a(ContentRecord contentRecord, String str) {
        m49728b(str);
        String strM41411O = !AbstractC7806cz.m48165b(contentRecord.m41411O()) ? contentRecord.m41411O() : getResources().getString(C6849R.string.hiad_ad_label_new);
        this.f37197a.setDataAndRefreshUi(contentRecord);
        if (this.f37197a.m49215a()) {
            this.f37197a.m49649a(null, strM41411O, this.f37202f, false);
            this.f37197a.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams = this.f37197a.getLayoutParams();
            layoutParams.width = 0;
            this.f37197a.setLayoutParams(layoutParams);
            this.f37197a.setVisibility(4);
        }
    }

    /* renamed from: a */
    public void m49731a(ContentRecord contentRecord, boolean z10, int i10, int i11, boolean z11) {
        ViewGroup.LayoutParams layoutParams;
        AbstractC7185ho.m43820b("PPSWLSView", "positionAndSet. ");
        String strM41415Q = contentRecord.m41415Q() == null ? LabelPosition.LOWER_LEFT : contentRecord.m41415Q();
        this.f37199c.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C6849R.dimen.hiad_splash_wls_side_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C6849R.dimen.hiad_splash_wls_vertical_margin);
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
            if ("tr".equals(strM41415Q)) {
                C7822do.m48379a(getContext(), i10, i11, z11, dimensionPixelSize, dimensionPixelSize2, layoutParams3);
                layoutParams = layoutParams3;
            } else {
                layoutParams = layoutParams3;
                m49725a(z10, i10, i11, z11, dimensionPixelSize, dimensionPixelSize2, layoutParams3);
            }
            setLayoutParams(layoutParams);
        }
        m49727b(contentRecord, strM41415Q);
        m49723a(contentRecord, strM41415Q);
        m49722a(contentRecord);
    }

    /* renamed from: a */
    public void m49732a(Integer num, Integer num2) {
        this.f37202f = num;
        this.f37203g = num2;
    }

    /* renamed from: a */
    private void m49724a(String str) {
        Resources resources = getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37199c.getLayoutParams();
        if ("tr".equals(str)) {
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMarginStart(resources.getDimensionPixelSize(C6849R.dimen.hiad_8_dp));
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(20);
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(C6849R.dimen.hiad_8_dp));
        }
        this.f37199c.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m49725a(boolean z10, int i10, int i11, boolean z11, int i12, int i13, RelativeLayout.LayoutParams layoutParams) {
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
}
