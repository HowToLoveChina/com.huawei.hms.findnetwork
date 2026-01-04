package p834z6;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.album.service.logic.callable.LocalPhotoPickerThumbnailTask;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import java.util.ArrayList;
import p009a8.C0069g;
import p031b7.C1120a;
import p031b7.C1133n;
import p031b7.C1138s;
import p616rk.C12515a;
import sk.C12809f;

/* renamed from: z6.g */
/* loaded from: classes2.dex */
public class C14147g extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public final LayoutInflater f63255d;

    /* renamed from: e */
    public final ArrayList<MediaFileBean> f63256e = new ArrayList<>();

    /* renamed from: f */
    public a f63257f;

    /* renamed from: g */
    public final C1133n.c f63258g;

    /* renamed from: z6.g$a */
    public interface a {
        /* renamed from: a */
        void mo13621a(View view, int i10, int i11);
    }

    /* renamed from: z6.g$b */
    public static class b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public View f63259A;

        /* renamed from: u */
        public ImageView f63260u;

        /* renamed from: v */
        public LinearLayout f63261v;

        /* renamed from: w */
        public TextView f63262w;

        /* renamed from: x */
        public View f63263x;

        /* renamed from: y */
        public ImageView f63264y;

        /* renamed from: z */
        public CheckBox f63265z;

        public b(View view) {
            super(view);
            this.f63260u = (ImageView) C12809f.m76831d(view, R$id.img_thumb);
            this.f63261v = (LinearLayout) C12809f.m76831d(view, R$id.ll_video);
            this.f63262w = (TextView) C12809f.m76831d(view, R$id.txt_duration);
            this.f63263x = C12809f.m76831d(view, R$id.view_mask);
            this.f63264y = (ImageView) C12809f.m76831d(view, R$id.img_preview);
            this.f63265z = (CheckBox) C12809f.m76831d(view, R$id.chk_img);
            this.f63259A = C12809f.m76831d(view, R$id.v_check);
        }
    }

    public C14147g(Context context, C1133n.c cVar) {
        this.f63255d = LayoutInflater.from(context);
        this.f63258g = cVar;
    }

    /* renamed from: G */
    public boolean m84915G(MediaFileBean mediaFileBean) {
        return C1133n.m6927e().m6930c(mediaFileBean, this.f63258g) == 0;
    }

    /* renamed from: H */
    public void m84916H() {
        this.f63256e.clear();
        C12515a.m75110o().m75166b(LocalPhotoPickerThumbnailTask.class.getName());
    }

    /* renamed from: I */
    public void m84917I() {
        if (this.f63256e.isEmpty()) {
            return;
        }
        this.f63256e.clear();
        m5213j();
    }

    /* renamed from: J */
    public ArrayList<MediaFileBean> m84918J() {
        return new ArrayList<>(this.f63256e);
    }

    /* renamed from: K */
    public MediaFileBean m84919K(int i10) {
        if (i10 < 0 || i10 >= this.f63256e.size()) {
            return null;
        }
        return this.f63256e.get(i10);
    }

    /* renamed from: L */
    public final /* synthetic */ void m84920L(int i10, View view) {
        a aVar = this.f63257f;
        if (aVar != null) {
            aVar.mo13621a(view, i10, 1);
        }
    }

    /* renamed from: M */
    public final /* synthetic */ void m84921M(int i10, View view) {
        a aVar = this.f63257f;
        if (aVar != null) {
            aVar.mo13621a(view, i10, 2);
        }
    }

    /* renamed from: N */
    public final /* synthetic */ void m84922N(b bVar, int i10, View view) {
        a aVar = this.f63257f;
        if (aVar != null) {
            aVar.mo13621a(bVar.f4327a, i10, 2);
        }
    }

    /* renamed from: O */
    public final void m84923O(b bVar, MediaFileBean mediaFileBean) {
        if (mediaFileBean.m14338j() != 3) {
            bVar.f63261v.setVisibility(8);
            return;
        }
        bVar.f63261v.setVisibility(0);
        bVar.f63262w.setText(RecyclerMediaAdapter.m14745O(mediaFileBean.m14325c()));
    }

    /* renamed from: P */
    public final void m84924P(ImageView imageView, MediaFileBean mediaFileBean) {
        String strM14350s = mediaFileBean.m14350s();
        String strM482C = C0069g.m479y().m482C(mediaFileBean);
        imageView.setTag(strM14350s);
        Bitmap bitmapM7184c = C1138s.m7181d().m7184c(strM482C);
        if (bitmapM7184c != null && !bitmapM7184c.isRecycled()) {
            imageView.setImageBitmap(bitmapM7184c);
            return;
        }
        imageView.setImageBitmap(null);
        C12515a.m75110o().m75175e(new LocalPhotoPickerThumbnailTask(mediaFileBean, imageView), false);
    }

    /* renamed from: Q */
    public final void m84925Q(b bVar, MediaFileBean mediaFileBean) {
        CheckBox checkBox = bVar.f63265z;
        checkBox.setEnabled(m84915G(mediaFileBean));
        if (mediaFileBean.m14311N()) {
            bVar.f63263x.setVisibility(0);
            checkBox.setChecked(true);
        } else {
            bVar.f63263x.setVisibility(8);
            checkBox.setChecked(false);
        }
    }

    /* renamed from: R */
    public void m84926R(a aVar) {
        this.f63257f = aVar;
    }

    /* renamed from: S */
    public void m84927S(ArrayList<MediaFileBean> arrayList) {
        this.f63256e.addAll(arrayList);
        arrayList.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f63256e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, final int i10) {
        if (abstractC0833c0 instanceof b) {
            final b bVar = (b) abstractC0833c0;
            bVar.f63264y.setOnClickListener(new View.OnClickListener() { // from class: z6.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f63248a.m84920L(i10, view);
                }
            });
            bVar.f4327a.setOnClickListener(new View.OnClickListener() { // from class: z6.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f63250a.m84921M(i10, view);
                }
            });
            bVar.f63259A.setOnClickListener(new View.OnClickListener() { // from class: z6.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f63252a.m84922N(bVar, i10, view);
                }
            });
            MediaFileBean mediaFileBean = this.f63256e.get(i10);
            C1120a.m6675d("PhotoPickerAdapter", i10 + " ; " + mediaFileBean.m14350s());
            m84924P(bVar.f63260u, mediaFileBean);
            m84923O(bVar, mediaFileBean);
            m84925Q(bVar, mediaFileBean);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new b(this.f63255d.inflate(R$layout.item_album_photo_picker, viewGroup, false));
    }
}
