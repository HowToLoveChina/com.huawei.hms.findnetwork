package p834z6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import java.util.List;
import p031b7.C1140u;
import p471m6.C11418d;

/* renamed from: z6.c */
/* loaded from: classes2.dex */
public class C14143c extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public final LayoutInflater f63241d;

    /* renamed from: e */
    public final Context f63242e;

    /* renamed from: f */
    public List<C11418d> f63243f;

    /* renamed from: g */
    public View.OnClickListener f63244g;

    /* renamed from: h */
    public int f63245h = -1;

    /* renamed from: z6.c$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f63246u;

        /* renamed from: v */
        public RelativeLayout f63247v;

        public a(View view) {
            super(view);
            this.f63246u = (TextView) view.findViewById(R$id.tv_relation_0);
            this.f63247v = (RelativeLayout) view.findViewById(R$id.rlay_relation_0);
        }
    }

    public C14143c(Context context, View.OnClickListener onClickListener) {
        this.f63244g = onClickListener;
        this.f63241d = LayoutInflater.from(context);
        this.f63242e = context;
    }

    /* renamed from: D */
    public void m84910D(List<C11418d> list) {
        if (this.f63242e == null) {
            return;
        }
        this.f63243f = list;
        m5213j();
    }

    /* renamed from: E */
    public void m84911E(int i10) {
        this.f63245h = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<C11418d> list = this.f63243f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return super.mo722f(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (abstractC0833c0 instanceof a) {
            a aVar = (a) abstractC0833c0;
            C11418d c11418d = this.f63243f.get(i10);
            aVar.f63246u.setText(C1140u.m7193e(this.f63242e, c11418d.m68410a()));
            aVar.f63247v.setSelected(this.f63245h == i10);
            aVar.f63246u.setSelected(this.f63245h == i10);
            if (c11418d.m68411b() != 0) {
                aVar.f63247v.setClickable(false);
                aVar.f63247v.setAlpha(0.6f);
            } else {
                aVar.f63247v.setOnClickListener(this.f63244g);
                aVar.f63247v.setTag(Integer.valueOf(i10));
                aVar.f63247v.setClickable(true);
                aVar.f63247v.setAlpha(1.0f);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new a(this.f63241d.inflate(R$layout.album_baby_relation_select_item, viewGroup, false));
    }
}
