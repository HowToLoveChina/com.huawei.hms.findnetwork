package com.huawei.hms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6983c;
import com.huawei.openalliance.p169ad.C7010d;
import com.huawei.openalliance.p169ad.EnumC6949b;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.ads.a */
/* loaded from: classes8.dex */
public class C5063a extends RelativeLayout {

    /* renamed from: a */
    private RelativeLayout f23154a;

    /* renamed from: b */
    private RelativeLayout f23155b;

    /* renamed from: c */
    private HorizontalScrollView f23156c;

    /* renamed from: d */
    private ScrollView f23157d;

    /* renamed from: e */
    private LinearLayout f23158e;

    /* renamed from: f */
    private LinearLayout f23159f;

    /* renamed from: g */
    private C6983c f23160g;

    /* renamed from: h */
    private RelativeLayout f23161h;

    /* renamed from: i */
    private HorizontalScrollView f23162i;

    /* renamed from: j */
    private ScrollView f23163j;

    /* renamed from: k */
    private LinearLayout f23164k;

    /* renamed from: l */
    private LinearLayout f23165l;

    /* renamed from: m */
    private C6983c f23166m;

    /* renamed from: n */
    private TextView f23167n;

    /* renamed from: o */
    private InterfaceC5064b f23168o;

    /* renamed from: com.huawei.hms.ads.a$a */
    public enum a {
        NONE,
        INIT,
        SHOWN,
        DISLIKED
    }

    public C5063a(Context context, RelativeLayout relativeLayout) {
        super(context);
        this.f23154a = relativeLayout;
        m30233a(context, null);
    }

    /* renamed from: a */
    public void m30234a() {
        this.f23155b.setVisibility(8);
        this.f23162i.setVisibility(8);
        this.f23163j.setVisibility(8);
        this.f23156c.setVisibility(8);
        this.f23157d.setVisibility(8);
        this.f23161h.setVisibility(8);
        this.f23167n.setVisibility(8);
    }

    /* renamed from: b */
    public void m30236b() {
        RelativeLayout relativeLayout = this.f23161h;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        boolean z10 = false;
        this.f23155b.setVisibility(0);
        C7010d c7010d = new C7010d(getContext().getString(C6849R.string.hiad_choices_hide), EnumC6949b.HIDE_AD);
        C7010d c7010d2 = new C7010d(getContext().getString(C6849R.string.hiad_choices_whythisad), EnumC6949b.WHY_THIS_AD);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c7010d);
        arrayList.add(c7010d2);
        if (this.f23154a.getWidth() > this.f23154a.getHeight()) {
            this.f23166m = new C6983c(getContext(), this, this.f23164k);
            this.f23162i.setVisibility(0);
            this.f23163j.setVisibility(8);
            z10 = true;
        } else {
            this.f23166m = new C6983c(getContext(), this, this.f23165l);
            this.f23162i.setVisibility(8);
            this.f23163j.setVisibility(0);
        }
        this.f23166m.m41164a(arrayList, z10);
        AbstractC7185ho.m43817a("CusWhyView", "SDK showWhyThisAd end");
    }

    /* renamed from: c */
    public void m30237c() {
        InterfaceC5064b interfaceC5064b = this.f23168o;
        if (interfaceC5064b != null) {
            interfaceC5064b.mo30242b();
        }
    }

    /* renamed from: d */
    public void m30238d() {
        InterfaceC5064b interfaceC5064b = this.f23168o;
        if (interfaceC5064b != null) {
            interfaceC5064b.mo30240a();
        }
        TextView textView = this.f23167n;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.f23155b;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.f23161h;
        boolean z10 = false;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        HorizontalScrollView horizontalScrollView = this.f23156c;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(0);
        }
        List<String> arrayList = new ArrayList<>();
        InterfaceC5064b interfaceC5064b2 = this.f23168o;
        if (interfaceC5064b2 != null) {
            arrayList = interfaceC5064b2.mo30243c();
        }
        ArrayList arrayList2 = new ArrayList();
        if (AbstractC7760bg.m47767a(arrayList)) {
            m30235a(null);
            return;
        }
        arrayList2.add(new C7010d(getContext().getString(C6849R.string.hiad_choices_ad_no_interest), EnumC6949b.NOT_INTEREST));
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new C7010d(it.next(), EnumC6949b.CLOSE_AD));
        }
        if (this.f23154a.getWidth() > this.f23154a.getHeight()) {
            this.f23160g = new C6983c(getContext(), this, this.f23158e);
            this.f23156c.setVisibility(0);
            this.f23157d.setVisibility(8);
            z10 = true;
        } else {
            this.f23160g = new C6983c(getContext(), this, this.f23159f);
            this.f23156c.setVisibility(8);
            this.f23157d.setVisibility(0);
        }
        this.f23160g.m41164a(arrayList2, z10);
        AbstractC7185ho.m43817a("CusWhyView", "SDK showFeedBackList end");
    }

    /* renamed from: e */
    public void m30239e() {
        m30238d();
    }

    public void setOnCloseCallBack(InterfaceC5064b interfaceC5064b) {
        this.f23168o = interfaceC5064b;
    }

    /* renamed from: a */
    private void m30233a(Context context, AttributeSet attributeSet) {
        View.inflate(context, C6849R.layout.hiad_choices_whythisad_root, this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C6849R.id.hiad_whythisad_wrapper);
        this.f23155b = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f23162i = (HorizontalScrollView) findViewById(C6849R.id.hiad_whythisad_horizontal_List);
        this.f23164k = (LinearLayout) findViewById(C6849R.id.hiad_whythisad_horizional_ll_wrapper);
        this.f23162i.setVisibility(8);
        this.f23163j = (ScrollView) findViewById(C6849R.id.hiad_whythisad_vertical_feedback_List);
        this.f23165l = (LinearLayout) findViewById(C6849R.id.hiad_whythisad_vertical_ll_wrapper);
        this.f23163j.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(C6849R.id.hiad_feedback_wrapper);
        this.f23161h = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.f23156c = (HorizontalScrollView) findViewById(C6849R.id.hiad_feedback_horizontal_List);
        this.f23158e = (LinearLayout) findViewById(C6849R.id.hiad_feedback_horizional_ll_wrapper);
        this.f23156c.setVisibility(8);
        this.f23157d = (ScrollView) findViewById(C6849R.id.hiad_feedback_vertical_feedback_List);
        this.f23159f = (LinearLayout) findViewById(C6849R.id.hiad_feedback_vertical_ll_wrapper);
        this.f23157d.setVisibility(8);
        TextView textView = (TextView) findViewById(C6849R.id.hiad_closed_hint);
        this.f23167n = textView;
        textView.setVisibility(8);
    }

    /* renamed from: a */
    public void m30235a(String str) {
        HorizontalScrollView horizontalScrollView = this.f23156c;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(8);
        }
        ScrollView scrollView = this.f23157d;
        if (scrollView != null) {
            scrollView.setVisibility(8);
        }
        HorizontalScrollView horizontalScrollView2 = this.f23162i;
        if (horizontalScrollView2 != null) {
            horizontalScrollView2.setVisibility(8);
        }
        ScrollView scrollView2 = this.f23163j;
        if (scrollView2 != null) {
            scrollView2.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.f23161h;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        TextView textView = this.f23167n;
        if (textView != null) {
            textView.setVisibility(0);
        }
        this.f23168o.mo30241a(str);
        AbstractC7185ho.m43817a("CusWhyView", "SDK processCloseEvent");
    }
}
