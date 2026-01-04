package ae;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: ae.g2 */
/* loaded from: classes3.dex */
public class C0128g2 extends RecyclerView.AbstractC0838h<a> {

    /* renamed from: d */
    public Context f469d;

    /* renamed from: e */
    public List<Drawable> f470e = new ArrayList();

    /* renamed from: f */
    public List<Bitmap> f471f = new ArrayList();

    /* renamed from: g */
    public boolean f472g = true;

    /* renamed from: h */
    public boolean f473h;

    /* renamed from: i */
    public boolean f474i;

    /* renamed from: ae.g2$a */
    public class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f475u;

        public a(View view) {
            super(view);
            this.f475u = (ImageView) C12809f.m76831d(view, R$id.type_image);
        }
    }

    public C0128g2(Context context, boolean z10, boolean z11) {
        this.f469d = context;
        this.f473h = z10;
        this.f474i = z11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void mo723s(a aVar, int i10) {
        if (this.f469d == null) {
            C11839m.m70687e("StorageManageIconListAdapter", "context is null");
            return;
        }
        if (this.f472g) {
            if (this.f470e.size() < 1) {
                C11839m.m70687e("StorageManageIconListAdapter", "icons is null");
                return;
            }
        } else if (this.f471f.size() < 1) {
            C11839m.m70687e("StorageManageIconListAdapter", "icons is null");
            return;
        }
        if (this.f472g) {
            aVar.f475u.setImageDrawable(this.f470e.get(i10));
        } else {
            aVar.f475u.setImageBitmap(this.f471f.get(i10));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public a mo724u(ViewGroup viewGroup, int i10) {
        Context context = this.f469d;
        if (context != null) {
            return new a(this.f474i ? LayoutInflater.from(context).inflate(R$layout.storage_manage_icon_list_item_for_family_share, viewGroup, false) : this.f473h ? LayoutInflater.from(context).inflate(R$layout.storage_manage_icon_list_item_for_cloud, viewGroup, false) : LayoutInflater.from(context).inflate(R$layout.storage_manage_icon_list_item, viewGroup, false));
        }
        C11839m.m70687e("StorageManageIconListAdapter", "context is null");
        return null;
    }

    /* renamed from: F */
    public void m810F(List<Bitmap> list) {
        this.f472g = false;
        this.f471f = list;
    }

    /* renamed from: G */
    public void m811G(List<Drawable> list) {
        this.f472g = true;
        this.f470e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f472g ? this.f470e.size() : this.f471f.size();
    }
}
