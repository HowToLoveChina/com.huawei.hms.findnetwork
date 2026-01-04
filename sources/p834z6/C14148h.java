package p834z6;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import java.util.List;
import p031b7.C1140u;
import p471m6.C11415a;
import p471m6.C11422h;
import p546p6.C12091d;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: z6.h */
/* loaded from: classes2.dex */
public class C14148h extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public final LayoutInflater f63266d;

    /* renamed from: e */
    public final Context f63267e;

    /* renamed from: f */
    public List<C11422h> f63268f;

    /* renamed from: g */
    public C11415a f63269g;

    /* renamed from: h */
    public View.OnClickListener f63270h;

    /* renamed from: z6.h$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f63271u;

        /* renamed from: v */
        public TextView f63272v;

        /* renamed from: w */
        public RelativeLayout f63273w;

        /* renamed from: x */
        public RelativeLayout f63274x;

        /* renamed from: y */
        public ImageView f63275y;

        /* renamed from: z */
        public ImageView f63276z;

        public a(View view) {
            super(view);
            this.f63271u = (TextView) C12809f.m76831d(view, R$id.tv_member_name);
            this.f63275y = (ImageView) C12809f.m76831d(view, R$id.ic_member_head);
            this.f63276z = (ImageView) C12809f.m76831d(view, R$id.ic_owner);
            this.f63272v = (TextView) C12809f.m76831d(view, R$id.tv_add);
            this.f63273w = (RelativeLayout) C12809f.m76831d(view, R$id.rl_add);
            this.f63274x = (RelativeLayout) C12809f.m76831d(view, R$id.rl_member_head);
        }
    }

    public C14148h(Context context, View.OnClickListener onClickListener) {
        this.f63270h = onClickListener;
        this.f63266d = LayoutInflater.from(context);
        this.f63267e = context;
    }

    /* renamed from: D */
    public void m84928D(List<C11422h> list) {
        if (this.f63267e == null) {
            return;
        }
        this.f63268f = list;
        m5213j();
    }

    /* renamed from: E */
    public void m84929E(C11415a c11415a) {
        this.f63269g = c11415a;
    }

    /* renamed from: F */
    public final void m84930F(a aVar, C11422h c11422h, boolean z10, String str) {
        if (z10) {
            TextView textView = aVar.f63271u;
            Context context = this.f63267e;
            int i10 = R$string.album_member_me;
            textView.setText(context.getString(i10, C1140u.m7193e(context, str)));
            if (TextUtils.equals(str, "other")) {
                aVar.f63271u.setText(this.f63267e.getString(i10, c11422h.m68436b().getRemark()));
                return;
            }
            return;
        }
        aVar.f63271u.setText(C1140u.m7193e(this.f63267e, c11422h.m68436b().getKinship()));
        if (TextUtils.equals(str, "other") || TextUtils.isEmpty(c11422h.m68436b().getKinship())) {
            String remark = c11422h.m68436b().getRemark();
            if (TextUtils.isEmpty(remark)) {
                aVar.f63271u.setText(c11422h.m68436b().getDisplayName());
            } else {
                aVar.f63271u.setText(remark);
            }
        }
    }

    /* renamed from: G */
    public final void m84931G(a aVar, C11422h c11422h, boolean z10) {
        if (TextUtils.isEmpty(c11422h.m68436b().getRemark())) {
            if (z10) {
                aVar.f63271u.setText(this.f63267e.getString(R$string.album_member_me, c11422h.m68436b().getDisplayName()));
                return;
            } else {
                aVar.f63271u.setText(c11422h.m68436b().getDisplayName());
                return;
            }
        }
        if (z10) {
            aVar.f63271u.setText(this.f63267e.getString(R$string.album_member_me, c11422h.m68436b().getRemark()));
        } else {
            aVar.f63271u.setText(c11422h.m68436b().getRemark());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<C11422h> list = this.f63268f;
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
            C11422h c11422h = this.f63268f.get(i10);
            if (c11422h.m68438d()) {
                aVar.f63271u.setVisibility(8);
                aVar.f63274x.setVisibility(8);
                aVar.f63272v.setVisibility(0);
                aVar.f63273w.setVisibility(0);
                aVar.f63273w.setOnClickListener(this.f63270h);
                aVar.f63272v.setText(C1140u.m7193e(this.f63267e, c11422h.m68435a()));
                aVar.f63273w.setTag(Integer.valueOf(i10));
                return;
            }
            if (c11422h.m68437c()) {
                aVar.f63271u.setVisibility(8);
                aVar.f63274x.setVisibility(8);
                aVar.f63272v.setVisibility(0);
                aVar.f63273w.setVisibility(0);
                aVar.f63273w.setOnClickListener(this.f63270h);
                aVar.f63273w.setTag(Integer.valueOf(i10));
                return;
            }
            aVar.f63271u.setVisibility(0);
            aVar.f63274x.setVisibility(0);
            aVar.f63272v.setVisibility(8);
            aVar.f63273w.setVisibility(8);
            if (c11422h.m68436b() == null) {
                return;
            }
            String userId = c11422h.m68436b().getUserId();
            boolean zEquals = TextUtils.equals(userId, C13452e.m80781L().m80971t0());
            aVar.f63275y.setOnClickListener(this.f63270h);
            aVar.f63275y.setTag(Integer.valueOf(i10));
            C12091d.m72280a0().m72296B(userId, aVar.f63275y);
            aVar.f63273w.setOnClickListener(this.f63270h);
            aVar.f63273w.setTag(Integer.valueOf(i10));
            boolean zEquals2 = TextUtils.equals(this.f63269g.m68362a().getAlbumOwnerId(), userId);
            boolean z10 = this.f63269g.m68362a().getShareType().intValue() == 1;
            if (zEquals2) {
                aVar.f63276z.setVisibility(0);
            } else {
                aVar.f63276z.setVisibility(8);
            }
            String kinship = c11422h.m68436b().getKinship();
            if (z10) {
                m84930F(aVar, c11422h, zEquals, kinship);
            } else {
                m84931G(aVar, c11422h, zEquals);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new a(this.f63266d.inflate(R$layout.album_member_item, viewGroup, false));
    }
}
