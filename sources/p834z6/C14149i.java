package p834z6;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import gp.C10028c;
import java.util.List;
import p336he.C10159j;
import p471m6.C11423i;
import p514o9.C11839m;
import p546p6.C12091d;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: z6.i */
/* loaded from: classes2.dex */
public class C14149i extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public final LayoutInflater f63277d;

    /* renamed from: e */
    public final Context f63278e;

    /* renamed from: f */
    public List<C11423i> f63279f;

    /* renamed from: g */
    public View.OnClickListener f63280g;

    /* renamed from: z6.i$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f63281u;

        /* renamed from: v */
        public TextView f63282v;

        public a(View view) {
            super(view);
            this.f63281u = (TextView) C12809f.m76831d(view, R$id.msg_time);
            this.f63282v = (TextView) C12809f.m76831d(view, R$id.view_detail);
        }
    }

    /* renamed from: z6.i$b */
    public static class b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public RelativeLayout f63283A;

        /* renamed from: u */
        public TextView f63284u;

        /* renamed from: v */
        public TextView f63285v;

        /* renamed from: w */
        public TextView f63286w;

        /* renamed from: x */
        public TextView f63287x;

        /* renamed from: y */
        public Button f63288y;

        /* renamed from: z */
        public ImageView f63289z;

        public b(View view) {
            super(view);
            this.f63284u = (TextView) C12809f.m76831d(view, R$id.msg_content);
            this.f63285v = (TextView) C12809f.m76831d(view, R$id.msg_time);
            this.f63286w = (TextView) C12809f.m76831d(view, R$id.msg_status);
            this.f63287x = (TextView) C12809f.m76831d(view, R$id.msg_sender);
            this.f63288y = (Button) C12809f.m76831d(view, R$id.view_button);
            this.f63289z = (ImageView) C12809f.m76831d(view, R$id.image_head);
            this.f63283A = (RelativeLayout) C12809f.m76831d(view, R$id.rl_approval_item);
        }
    }

    public C14149i(Context context, View.OnClickListener onClickListener) {
        this.f63277d = LayoutInflater.from(context);
        this.f63278e = context;
        this.f63280g = onClickListener;
    }

    /* renamed from: D */
    public void m84932D(List<C11423i> list) {
        if (this.f63278e == null) {
            return;
        }
        C11839m.m70688i("ShareApprovalAdapter", "addData: " + list.size());
        this.f63279f = list;
        m5213j();
    }

    /* renamed from: E */
    public C11423i m84933E(int i10) {
        List<C11423i> list = this.f63279f;
        if (list == null || i10 >= list.size()) {
            return null;
        }
        return this.f63279f.get(i10);
    }

    /* renamed from: F */
    public final void m84934F(int i10, b bVar, boolean z10, String str) {
        if (TextUtils.equals(str, "await")) {
            bVar.f63288y.setVisibility(0);
            bVar.f63286w.setVisibility(8);
            bVar.f63288y.setTag(Integer.valueOf(i10));
            bVar.f63288y.setOnClickListener(this.f63280g);
            bVar.f63283A.setOnClickListener(this.f63280g);
            bVar.f63283A.setTag(Integer.valueOf(i10));
            return;
        }
        if (TextUtils.equals(str, "expire")) {
            bVar.f63288y.setVisibility(8);
            bVar.f63286w.setVisibility(0);
            bVar.f63286w.setText(this.f63278e.getString(R$string.album_expired));
            bVar.f63288y.setOnClickListener(this.f63280g);
            bVar.f63283A.setOnClickListener(this.f63280g);
            bVar.f63283A.setTag(Integer.valueOf(i10));
            bVar.f63288y.setVisibility(8);
            return;
        }
        if (TextUtils.equals(str, "accept")) {
            bVar.f63288y.setVisibility(8);
            bVar.f63286w.setVisibility(0);
            bVar.f63286w.setText(this.f63278e.getString(R$string.album_approved));
            bVar.f63288y.setOnClickListener(this.f63280g);
            bVar.f63283A.setOnClickListener(this.f63280g);
            bVar.f63283A.setTag(Integer.valueOf(i10));
            return;
        }
        if (TextUtils.equals(str, "reject")) {
            bVar.f63288y.setVisibility(8);
            bVar.f63286w.setVisibility(0);
            bVar.f63286w.setText(this.f63278e.getString(R$string.album_rejected));
            bVar.f63288y.setOnClickListener(this.f63280g);
            bVar.f63283A.setOnClickListener(this.f63280g);
            bVar.f63283A.setTag(Integer.valueOf(i10));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<C11423i> list = this.f63279f;
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
    /* renamed from: g */
    public int mo749g(int i10) {
        return i10 < this.f63279f.size() - 1 ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        C11423i c11423i = this.f63279f.get(i10);
        if (abstractC0833c0 instanceof b) {
            b bVar = (b) abstractC0833c0;
            if (c11423i.m68446c().getMessageType().intValue() == 1) {
                bVar.f63284u.setText(this.f63278e.getString(R$string.album_applly_jion, c11423i.m68444a()));
                bVar.f63287x.setText(c11423i.m68446c().getSenderName());
                long jM28458c = c11423i.m68446c().getCreatedTime().m28458c();
                boolean z10 = System.currentTimeMillis() > c11423i.m68446c().getExpirationTime().m28458c();
                bVar.f63285v.setText(C10159j.m63330f(this.f63278e, jM28458c, false));
                if (c11423i.m68445b() == null) {
                    bVar.f63288y.setVisibility(8);
                    bVar.f63286w.setVisibility(8);
                    return;
                } else {
                    String status = c11423i.m68445b().getStatus();
                    if (c11423i.m68446c().getMessageType().intValue() == 1) {
                        m84934F(i10, bVar, z10, status);
                    }
                    C12091d.m72280a0().m72296B(c11423i.m68446c().getSenderId(), bVar.f63289z);
                }
            } else if (c11423i.m68446c().getMessageType().intValue() == 2) {
                bVar.f63287x.setText(this.f63278e.getString(R$string.album_share_system_name));
                if (TextUtils.equals(C13452e.m80781L().m80971t0(), c11423i.m68446c().getSenderId())) {
                    bVar.f63284u.setText(this.f63278e.getString(R$string.album_jion_self_msg, c11423i.m68444a()));
                }
                bVar.f63285v.setText(C10159j.m63330f(this.f63278e, c11423i.m68446c().getCreatedTime().m28458c(), false));
                bVar.f63288y.setOnClickListener(this.f63280g);
                bVar.f63288y.setTag(Integer.valueOf(i10));
                bVar.f63288y.setVisibility(0);
                bVar.f63286w.setVisibility(8);
                bVar.f63283A.setOnClickListener(this.f63280g);
                bVar.f63283A.setTag(Integer.valueOf(i10));
                bVar.f63289z.setImageResource(R$drawable.ic_share_album_jun);
            } else if (c11423i.m68446c().getMessageType().intValue() == 7) {
                bVar.f63287x.setText(this.f63278e.getString(R$string.album_share_system_name));
                bVar.f63284u.setText(this.f63278e.getString(R$string.album_jion_deny_msg, c11423i.m68446c().getAlbumName()));
                bVar.f63285v.setText(C10159j.m63330f(this.f63278e, c11423i.m68446c().getCreatedTime().m28458c(), false));
                bVar.f63288y.setOnClickListener(this.f63280g);
                bVar.f63288y.setVisibility(8);
                bVar.f63286w.setVisibility(8);
                bVar.f63283A.setOnClickListener(this.f63280g);
                bVar.f63283A.setTag(Integer.valueOf(i10));
                bVar.f63289z.setImageResource(R$drawable.ic_share_album_jun);
            }
        }
        if (abstractC0833c0 instanceof a) {
            a aVar = (a) abstractC0833c0;
            aVar.f63282v.setOnClickListener(this.f63280g);
            long jM62270S = C10028c.m62182c0().m62270S();
            String strM63330f = C10159j.m63330f(this.f63278e, jM62270S, false);
            if (jM62270S != 0) {
                aVar.f63281u.setText(strM63330f);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return i10 == 2 ? new a(this.f63277d.inflate(R$layout.share_local_msg_item, viewGroup, false)) : new b(this.f63277d.inflate(R$layout.share_application_msg_item, viewGroup, false));
    }
}
