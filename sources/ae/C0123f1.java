package ae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.base.bean.ExitSyncInfo;
import java.util.List;
import p015ak.C0209d;
import sk.C12809f;

/* renamed from: ae.f1 */
/* loaded from: classes3.dex */
public class C0123f1 extends RecyclerView.AbstractC0838h<a> {

    /* renamed from: d */
    public final Context f450d;

    /* renamed from: e */
    public final List<ExitSyncInfo> f451e;

    /* renamed from: f */
    public final LayoutInflater f452f;

    /* renamed from: ae.f1$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f453u;

        /* renamed from: v */
        public TextView f454v;

        public a(View view) {
            super(view);
            this.f453u = (ImageView) C12809f.m76831d(view, R$id.exit_icon_img);
            this.f454v = (TextView) C12809f.m76831d(view, R$id.exit_icon_text);
        }
    }

    public C0123f1(Context context, List<ExitSyncInfo> list) {
        this.f450d = context;
        this.f451e = list;
        this.f452f = LayoutInflater.from(context);
    }

    /* renamed from: D */
    public final int m790D() {
        return C0209d.m1195O(this.f450d) >= 1.75f ? R$layout.account_exit_icon_item_3dot2 : R$layout.account_exit_icon_item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void mo723s(a aVar, int i10) {
        m793G(aVar.f453u, i10);
        m794H(aVar.f454v, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public a mo724u(ViewGroup viewGroup, int i10) {
        View viewInflate = this.f452f.inflate(m790D(), viewGroup, false);
        viewInflate.setClickable(false);
        viewInflate.setContextClickable(false);
        viewInflate.setLongClickable(false);
        viewInflate.setPressed(false);
        viewInflate.setEnabled(false);
        return new a(viewInflate);
    }

    /* renamed from: G */
    public final void m793G(ImageView imageView, int i10) {
        ExitSyncInfo exitSyncInfo = this.f451e.get(i10);
        if (exitSyncInfo != null) {
            imageView.setBackground(exitSyncInfo.getIconDrawable());
        }
    }

    /* renamed from: H */
    public final void m794H(TextView textView, int i10) {
        ExitSyncInfo exitSyncInfo = this.f451e.get(i10);
        if (exitSyncInfo != null) {
            textView.setText(exitSyncInfo.getIconText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f451e.size();
    }
}
