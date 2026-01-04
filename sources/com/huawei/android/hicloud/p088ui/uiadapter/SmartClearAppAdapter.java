package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0223k;
import p344hp.C10332a;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SmartClearAppAdapter extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f18854a;

    /* renamed from: b */
    public Context f18855b;

    /* renamed from: c */
    public int f18856c = 0;

    /* renamed from: d */
    public long f18857d = 0;

    /* renamed from: e */
    public List<C10332a> f18858e = new ArrayList();

    /* renamed from: f */
    public CheckedCallback f18859f;

    /* renamed from: g */
    public boolean f18860g;

    public interface CheckedCallback {
        /* renamed from: G */
        void mo22182G(boolean z10, boolean z11);

        /* renamed from: Z */
        void mo22183Z(boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SmartClearAppAdapter$a */
    public static class C4066a {

        /* renamed from: a */
        public TextView f18861a;

        /* renamed from: b */
        public TextView f18862b;

        /* renamed from: c */
        public TextView f18863c;

        /* renamed from: d */
        public View f18864d;

        /* renamed from: e */
        public ImageView f18865e;

        /* renamed from: f */
        public CheckBox f18866f;

        /* renamed from: g */
        public void m25220g(TextView textView, TextView textView2, TextView textView3, View view, ImageView imageView, CheckBox checkBox) {
            this.f18861a = textView;
            this.f18862b = textView2;
            this.f18863c = textView3;
            this.f18864d = view;
            this.f18865e = imageView;
            this.f18866f = checkBox;
        }
    }

    public SmartClearAppAdapter(Context context, CheckedCallback checkedCallback, boolean z10) {
        this.f18854a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f18855b = context;
        this.f18859f = checkedCallback;
        this.f18860g = z10;
    }

    /* renamed from: b */
    public int m25201b() {
        return this.f18856c;
    }

    /* renamed from: c */
    public long m25202c() {
        return this.f18857d;
    }

    /* renamed from: d */
    public List<C10332a> m25203d() {
        return this.f18858e;
    }

    /* renamed from: e */
    public final /* synthetic */ void m25204e(CheckBox checkBox, C10332a c10332a, View view) {
        boolean zIsChecked = checkBox.isChecked();
        c10332a.m63626w(zIsChecked);
        if (zIsChecked) {
            this.f18856c++;
            this.f18857d += c10332a.m63616h();
        } else {
            this.f18856c--;
            this.f18857d -= c10332a.m63616h();
        }
        CheckedCallback checkedCallback = this.f18859f;
        if (checkedCallback == null) {
            return;
        }
        checkedCallback.mo22183Z(this.f18860g);
        if (this.f18856c == this.f18858e.size()) {
            this.f18859f.mo22182G(true, this.f18860g);
        } else {
            this.f18859f.mo22182G(false, this.f18860g);
        }
    }

    /* renamed from: f */
    public void m25205f(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("SmartClearAppAdapter", "appName is empty");
            return;
        }
        Iterator<C10332a> it = this.f18858e.iterator();
        while (it.hasNext()) {
            C10332a next = it.next();
            if (next != null && StringUtil.equals(str, next.m63615f())) {
                if (next.m63620q()) {
                    this.f18856c--;
                    this.f18857d -= next.m63616h();
                }
                it.remove();
            }
        }
    }

    /* renamed from: g */
    public void m25206g(boolean z10) {
        if (this.f18858e.size() <= 0) {
            this.f18856c = 0;
            this.f18857d = 0L;
            return;
        }
        long jM63616h = 0;
        for (C10332a c10332a : this.f18858e) {
            c10332a.m63626w(z10);
            jM63616h += c10332a.m63616h();
        }
        this.f18856c = z10 ? this.f18858e.size() : 0;
        this.f18857d = z10 ? jM63616h : 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18858e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f18858e.size()) {
            return null;
        }
        return this.f18858e.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM76832e;
        C4066a c4066a;
        C10332a c10332a = this.f18858e.get(i10);
        if (view == null) {
            c4066a = new C4066a();
            viewM76832e = C12809f.m76832e(this.f18854a, R$layout.smart_clear_app_list_item);
            ImageView imageView = (ImageView) C12809f.m76831d(viewM76832e, R$id.sca_app_icon);
            c4066a.m25220g((TextView) C12809f.m76831d(viewM76832e, R$id.sca_app_name), (TextView) C12809f.m76831d(viewM76832e, R$id.sca_sub_title), (TextView) C12809f.m76831d(viewM76832e, R$id.sca_app_size), C12809f.m76831d(viewM76832e, R$id.sca_item_divider), imageView, (CheckBox) C12809f.m76831d(viewM76832e, R$id.sca_check_box));
            viewM76832e.setTag(c4066a);
        } else {
            viewM76832e = view;
            c4066a = (C4066a) view.getTag();
        }
        m25207h(c10332a, c4066a.f18865e);
        m25208i(c10332a, c4066a.f18861a);
        m25213n(c10332a, c4066a.f18862b);
        m25209j(c10332a, c4066a.f18863c);
        m25210k(c10332a, c4066a.f18866f);
        m25211l(i10, c4066a.f18864d);
        return viewM76832e;
    }

    /* renamed from: h */
    public final void m25207h(C10332a c10332a, ImageView imageView) {
        imageView.setImageDrawable(c10332a.m63613b());
    }

    /* renamed from: i */
    public final void m25208i(C10332a c10332a, TextView textView) {
        textView.setText(c10332a.m63614e());
    }

    /* renamed from: j */
    public final void m25209j(C10332a c10332a, TextView textView) {
        textView.setText(C0223k.m1524g(this.f18855b, c10332a.m63616h()));
    }

    /* renamed from: k */
    public final void m25210k(final C10332a c10332a, final CheckBox checkBox) {
        if (checkBox == null || c10332a == null) {
            return;
        }
        checkBox.setChecked(c10332a.m63620q());
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: ae.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f408a.m25204e(checkBox, c10332a, view);
            }
        });
    }

    /* renamed from: l */
    public final void m25211l(int i10, View view) {
        if (i10 == this.f18858e.size() - 1) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    /* renamed from: m */
    public void m25212m(List<C10332a> list) {
        this.f18858e = list;
    }

    /* renamed from: n */
    public final void m25213n(C10332a c10332a, TextView textView) {
        if (!this.f18860g) {
            textView.setVisibility(8);
            return;
        }
        int iMin = Math.min(c10332a.m63617i() / 30, 6);
        if (iMin > 0) {
            textView.setText(this.f18855b.getResources().getQuantityString(R$plurals.smart_clear_month_no_used, iMin, Integer.valueOf(iMin)));
        } else {
            textView.setText(this.f18855b.getResources().getQuantityString(R$plurals.smart_clear_day_no_used, c10332a.m63617i(), Integer.valueOf(c10332a.m63617i())));
        }
    }
}
