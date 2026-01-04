package com.huawei.android.remotecontrol.facard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sharing.bean.ShareGrantInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import p256ef.C9465f;
import p514o9.C11842p;
import sk.C12809f;
import wf.InterfaceC13596a;

/* loaded from: classes4.dex */
public class FAEditListAdapter extends RecyclerView.AbstractC0838h<C4341a> {

    /* renamed from: d */
    public ArrayList<String> f19783d = new ArrayList<>();

    /* renamed from: e */
    public Context f19784e;

    /* renamed from: f */
    public InterfaceC13596a f19785f;

    /* renamed from: g */
    public String f19786g;

    /* renamed from: h */
    public int f19787h;

    /* renamed from: com.huawei.android.remotecontrol.facard.adapter.FAEditListAdapter$a */
    public static class C4341a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f19788u;

        /* renamed from: v */
        public TextView f19789v;

        /* renamed from: w */
        public View f19790w;

        /* renamed from: com.huawei.android.remotecontrol.facard.adapter.FAEditListAdapter$a$a */
        public class a implements ViewTreeObserver.OnPreDrawListener {
            public a() {
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                C4341a.this.f4327a.getWidth();
                C4341a.this.f19788u.setMaxWidth((int) (r0.f4327a.getWidth() - C11842p.m70844o(C4341a.this.f4327a.getContext(), 158)));
                C4341a.this.f19788u.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        }

        public C4341a(View view) {
            super(view);
            TextView textView = (TextView) C12809f.m76831d(view, R$id.display_value);
            this.f19788u = textView;
            textView.getViewTreeObserver().addOnPreDrawListener(new a());
            this.f19789v = (TextView) C12809f.m76831d(view, R$id.device_name);
            this.f19790w = C12809f.m76831d(view, R$id.divider);
        }
    }

    public FAEditListAdapter(Context context) {
        this.f19784e = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void m26154I(final int i10, final View view) {
        Optional.ofNullable(this.f19785f).ifPresent(new Consumer() { // from class: ef.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((InterfaceC13596a) obj).mo26175a(view, i10, 0);
            }
        });
    }

    /* renamed from: F */
    public String m26155F(int i10) {
        return this.f19783d.size() <= i10 ? "" : this.f19783d.get(i10);
    }

    /* renamed from: G */
    public void m26156G(List<String> list) {
        this.f19783d.clear();
        this.f19783d.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4341a c4341a, final int i10) {
        ShareGrantInfo shareGrantInfoM59291H;
        String str = this.f19783d.get(i10);
        c4341a.f19788u.setText(C9465f.m59265A().m59290G(this.f19783d.get(i10)));
        if (!str.equals(this.f19786g) || (shareGrantInfoM59291H = C9465f.m59265A().m59291H(this.f19786g, this.f19787h)) == null) {
            c4341a.f19789v.setVisibility(8);
        } else {
            c4341a.f19789v.setVisibility(0);
            c4341a.f19789v.setText(shareGrantInfoM59291H.getSenderDeviceName());
        }
        if (i10 == mo721e() - 1) {
            c4341a.f19790w.setVisibility(8);
        } else {
            c4341a.f19790w.setVisibility(0);
        }
        c4341a.f4327a.setOnClickListener(new View.OnClickListener() { // from class: ef.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f47204a.m26154I(i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public C4341a mo724u(ViewGroup viewGroup, int i10) {
        return new C4341a(LayoutInflater.from(this.f19784e).inflate(R$layout.fa_share_item, viewGroup, false));
    }

    /* renamed from: L */
    public void m26159L(InterfaceC13596a interfaceC13596a) {
        this.f19785f = interfaceC13596a;
    }

    /* renamed from: M */
    public void m26160M(String str, int i10) {
        this.f19786g = str;
        this.f19787h = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f19783d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return i10;
    }
}
