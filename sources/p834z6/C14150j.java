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
import com.huawei.android.hicloud.drive.cloudphoto.model.Applicant;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import java.util.List;
import p031b7.C1140u;
import p471m6.C11416b;
import p514o9.C11839m;
import p546p6.C12091d;
import sk.C12809f;

/* renamed from: z6.j */
/* loaded from: classes2.dex */
public class C14150j extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public final LayoutInflater f63290d;

    /* renamed from: e */
    public final Context f63291e;

    /* renamed from: f */
    public List<C11416b> f63292f;

    /* renamed from: g */
    public View.OnClickListener f63293g;

    /* renamed from: z6.j$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f63294u;

        /* renamed from: v */
        public TextView f63295v;

        /* renamed from: w */
        public ImageView f63296w;

        /* renamed from: x */
        public RelativeLayout f63297x;

        public a(View view) {
            super(view);
            this.f63294u = (TextView) C12809f.m76831d(view, R$id.tv_member_nick_name);
            this.f63295v = (TextView) C12809f.m76831d(view, R$id.tv_member_id);
            this.f63296w = (ImageView) C12809f.m76831d(view, R$id.ic_head);
            this.f63297x = (RelativeLayout) C12809f.m76831d(view, R$id.rl_approval_item);
        }
    }

    public C14150j(Context context, View.OnClickListener onClickListener) {
        this.f63290d = LayoutInflater.from(context);
        this.f63291e = context;
        this.f63293g = onClickListener;
    }

    /* renamed from: D */
    public void m84935D(List<C11416b> list) {
        if (this.f63291e == null) {
            return;
        }
        C11839m.m70688i("ShareApprovalAdapter", "addData: " + list.size());
        this.f63292f = list;
        m5213j();
    }

    /* renamed from: E */
    public C11416b m84936E(int i10) {
        List<C11416b> list = this.f63292f;
        if (list == null || i10 >= list.size()) {
            return null;
        }
        return this.f63292f.get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<C11416b> list = this.f63292f;
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
        C11416b c11416b = this.f63292f.get(i10);
        if (abstractC0833c0 instanceof a) {
            a aVar = (a) abstractC0833c0;
            Applicant applicantM68379b = c11416b.m68379b();
            String remark = applicantM68379b.getRemark();
            if (TextUtils.isEmpty(applicantM68379b.getKinship()) || TextUtils.equals(applicantM68379b.getKinship(), "other")) {
                aVar.f63294u.setText(remark);
            } else {
                aVar.f63294u.setText(C1140u.m7193e(this.f63291e, applicantM68379b.getKinship()));
            }
            String strM68378a = c11416b.m68378a();
            aVar.f63295v.setText((TextUtils.isEmpty(strM68378a) && strM68378a.contains("*")) ? this.f63291e.getString(R$string.baby_album_title_partly_age, c11416b.m68378a(), c11416b.m68380c()) : c11416b.m68380c());
            aVar.f63297x.setTag(Integer.valueOf(i10));
            aVar.f63297x.setOnClickListener(this.f63293g);
            C12091d.m72280a0().m72296B(c11416b.m68379b().getUserId(), aVar.f63296w);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new a(this.f63290d.inflate(R$layout.share_approval_item, viewGroup, false));
    }
}
