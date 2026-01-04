package com.huawei.phoneservice.feedback.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.entity.C8471b;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.adapter.f */
/* loaded from: classes5.dex */
public class C8467f extends RecyclerView.AbstractC0838h<d> {

    /* renamed from: d */
    public List<C8471b> f39520d;

    /* renamed from: e */
    public LayoutInflater f39521e;

    /* renamed from: f */
    public c f39522f;

    /* renamed from: g */
    public int f39523g = -1;

    /* renamed from: com.huawei.phoneservice.feedback.adapter.f$a */
    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f39524a;

        public a(int i10) {
            this.f39524a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C8467f.this.f39523g = this.f39524a;
            C8467f.this.f39522f.mo52631a(this.f39524a);
            C8467f.this.m5213j();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.f$b */
    public class b extends View.AccessibilityDelegate {

        /* renamed from: a */
        public final /* synthetic */ boolean f39526a;

        public b(boolean z10) {
            this.f39526a = z10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.f39526a);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.f$c */
    public interface c {
        /* renamed from: a */
        void mo52631a(int i10);
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.f$d */
    public static class d extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f39528u;

        public d(View view) {
            super(view);
            this.f39528u = (TextView) view.findViewById(R$id.txt_question_type_item);
        }
    }

    public C8467f(List<C8471b> list, Context context) {
        this.f39520d = list;
        this.f39521e = LayoutInflater.from(context);
    }

    /* renamed from: E */
    public final View.AccessibilityDelegate m52626E(boolean z10) {
        return new b(z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public d mo724u(ViewGroup viewGroup, int i10) {
        return new d(this.f39521e.inflate(R$layout.feedback_sdk_question_item_type, viewGroup, false));
    }

    /* renamed from: H */
    public void m52628H(int i10) {
        this.f39523g = i10;
        m5213j();
    }

    /* renamed from: I */
    public void m52629I(c cVar) {
        this.f39522f = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void mo723s(d dVar, int i10) {
        TextView textView;
        int i11;
        if (i10 == this.f39523g) {
            textView = dVar.f39528u;
            i11 = R$drawable.feedback_common_toggle_4_corner_press_bg;
        } else {
            textView = dVar.f39528u;
            i11 = R$drawable.feedback_common_toggle_4_corner_normal_bg;
        }
        textView.setBackgroundResource(i11);
        dVar.f39528u.setAccessibilityDelegate(m52626E(i10 == this.f39523g));
        dVar.f39528u.setText(this.f39520d.get(i10).f39530b);
        dVar.f39528u.setOnClickListener(new a(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f39520d.size();
    }
}
