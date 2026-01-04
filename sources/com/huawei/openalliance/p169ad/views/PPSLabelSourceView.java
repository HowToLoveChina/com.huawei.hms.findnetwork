package com.huawei.openalliance.p169ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* loaded from: classes2.dex */
public class PPSLabelSourceView extends RelativeLayout {

    /* renamed from: a */
    private PPSLabelView f36770a;

    /* renamed from: b */
    private TextView f36771b;

    /* renamed from: c */
    private TextView f36772c;

    /* renamed from: d */
    private boolean f36773d;

    /* renamed from: e */
    private boolean f36774e;

    public PPSLabelSourceView(Context context) {
        super(context, null);
        this.f36773d = false;
        this.f36774e = false;
    }

    /* renamed from: b */
    private int m49195b(boolean z10) {
        return z10 ? C6849R.layout.hiad_ad_label_source_with_click : C6849R.layout.hiad_ad_label_source;
    }

    /* renamed from: a */
    public void m49196a(Context context, boolean z10) {
        if (!this.f36773d) {
            this.f36774e = z10;
        }
        m49198b(context, z10);
        if (this.f36774e != z10) {
            this.f36774e = z10;
            m49194a(z10);
        }
    }

    public TextView getAdJumpText() {
        return this.f36772c;
    }

    public PPSLabelView getAdLabel() {
        return this.f36770a;
    }

    public TextView getAdSource() {
        return this.f36771b;
    }

    public PPSLabelSourceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36773d = false;
        this.f36774e = false;
    }

    /* renamed from: a */
    public void m49197a(InterfaceC7337jk interfaceC7337jk, ContentRecord contentRecord, boolean z10) {
        PPSLabelView pPSLabelView = this.f36770a;
        if (pPSLabelView != null) {
            pPSLabelView.m49211a(interfaceC7337jk, contentRecord, z10);
        }
    }

    /* renamed from: b */
    public void m49198b(Context context, boolean z10) {
        if (!this.f36773d) {
            View.inflate(context, m49195b(z10), this);
        }
        this.f36773d = true;
        this.f36770a = (PPSLabelView) findViewById(C6849R.id.hiad_ad_label);
        this.f36771b = (TextView) findViewById(C6849R.id.hiad_ad_source);
        this.f36772c = (TextView) findViewById(C6849R.id.hiad_ad_jump_text);
    }

    public PPSLabelSourceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36773d = false;
        this.f36774e = false;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: a */
    private void m49194a(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f36770a.getParent();
        TextView textView = this.f36772c;
        Resources resources = getResources();
        int i10 = C6849R.color.hiad_transparent;
        textView.setBackgroundColor(resources.getColor(i10));
        Resources resources2 = getResources();
        if (z10) {
            viewGroup.setBackgroundColor(resources2.getColor(i10));
            PPSLabelView pPSLabelView = this.f36770a;
            Resources resources3 = getResources();
            int i11 = C6849R.drawable.hiad_bg_ad_source;
            pPSLabelView.setBackground(resources3.getDrawable(i11));
            this.f36771b.setBackground(getResources().getDrawable(i11));
        } else {
            viewGroup.setBackground(resources2.getDrawable(C6849R.drawable.hiad_bg_ad_source));
            this.f36770a.setBackgroundColor(getResources().getColor(i10));
            this.f36771b.setBackgroundColor(getResources().getColor(i10));
        }
        int iM47535a = AbstractC7741ao.m47535a(getContext(), getResources().getDimension(C6849R.dimen.hiad_1_dp));
        viewGroup.setPadding(0, 0, 0, 0);
        this.f36770a.setPadding(iM47535a, 0, z10 ? iM47535a : 0, 0);
        this.f36772c.setPadding(0, 0, iM47535a, 0);
        this.f36771b.setPadding(z10 ? iM47535a : 0, 0, iM47535a, 0);
        this.f36772c.setTextAlignment(5);
    }

    public PPSLabelSourceView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.f36773d = false;
        this.f36774e = false;
    }
}
