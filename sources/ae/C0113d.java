package ae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import java.util.List;
import p015ak.C0213f;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: ae.d */
/* loaded from: classes3.dex */
public class C0113d extends RecyclerView.AbstractC0838h<a> {

    /* renamed from: d */
    public Context f411d;

    /* renamed from: e */
    public List<CloudRestoreItem> f412e;

    /* renamed from: f */
    public boolean f413f;

    /* renamed from: g */
    public View.OnClickListener f414g;

    /* renamed from: h */
    public boolean f415h = false;

    /* renamed from: ae.d$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public RelativeLayout f416u;

        /* renamed from: v */
        public ImageView f417v;

        /* renamed from: w */
        public TextView f418w;

        /* renamed from: x */
        public TextView f419x;

        /* renamed from: y */
        public ImageView f420y;

        /* renamed from: z */
        public View f421z;

        public a(View view) {
            super(view);
            this.f416u = (RelativeLayout) C12809f.m76831d(view, R$id.rl_module_layout);
            this.f417v = (ImageView) C12809f.m76831d(view, R$id.iv_module_icon);
            this.f418w = (TextView) C12809f.m76831d(view, R$id.tv_module_name);
            this.f419x = (TextView) C12809f.m76831d(view, R$id.tv_module_tip);
            this.f420y = (ImageView) C12809f.m76831d(view, R$id.iv_module_arrow);
            this.f421z = C12809f.m76831d(view, R$id.view_divider);
        }
    }

    public C0113d(Context context, List<CloudRestoreItem> list) {
        this.f411d = context;
        this.f412e = list;
    }

    /* renamed from: E */
    public boolean m755E() {
        return this.f413f;
    }

    /* renamed from: F */
    public final /* synthetic */ void m756F(a aVar, View view) {
        View.OnClickListener onClickListener = this.f414g;
        if (onClickListener != null) {
            onClickListener.onClick(view);
            boolean z10 = !this.f413f;
            this.f413f = z10;
            if (z10) {
                aVar.f420y.setImageDrawable(this.f411d.getDrawable(R$drawable.manage_data_list_retract));
                aVar.f421z.setVisibility(0);
            } else {
                aVar.f420y.setImageDrawable(this.f411d.getDrawable(R$drawable.manage_data_list_expand));
                aVar.f421z.setVisibility(8);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: G */
    public void mo723s(final a aVar, int i10) {
        if (i10 == mo721e() - 1 && !this.f413f) {
            aVar.f421z.setVisibility(8);
        }
        CloudRestoreItem cloudRestoreItem = this.f412e.get(i10);
        String appId = cloudRestoreItem.getAppId();
        aVar.f417v.setImageDrawable((cloudRestoreItem.isVirtual() || ("music".equals(appId) && this.f415h)) ? CloudBackup3rdIconUtil.getDrawable(appId, null) : C14333b.m85483r().containsKey(appId) ? CloudBackup3rdIconUtil.getDrawable(appId) : CloudBackup3rdIconUtil.get3rdDrawable(appId));
        aVar.f418w.setText(cloudRestoreItem.getAppName());
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            aVar.f419x.setVisibility(0);
        }
        if ("thirdAppData".equals(cloudRestoreItem.getAppId())) {
            aVar.f420y.setVisibility(0);
            aVar.f416u.setOnClickListener(new View.OnClickListener() { // from class: ae.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f361a.m756F(aVar, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: H */
    public a mo724u(ViewGroup viewGroup, int i10) {
        if (this.f411d == null) {
            this.f411d = C0213f.m1377a();
        }
        return new a(LayoutInflater.from(this.f411d).inflate(R$layout.item_backup_clean_modules, viewGroup, false));
    }

    /* renamed from: I */
    public void m759I(boolean z10) {
        this.f413f = z10;
    }

    /* renamed from: J */
    public void m760J(boolean z10) {
        this.f415h = z10;
    }

    /* renamed from: K */
    public void m761K(View.OnClickListener onClickListener) {
        this.f414g = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<CloudRestoreItem> list = this.f412e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
