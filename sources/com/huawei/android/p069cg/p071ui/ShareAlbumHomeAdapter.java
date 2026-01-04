package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import java.util.List;
import p438l.C11214h;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class ShareAlbumHomeAdapter extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public final LayoutInflater f11296d;

    /* renamed from: e */
    public final Context f11297e;

    /* renamed from: f */
    public List<Object> f11298f;

    /* renamed from: g */
    public C11214h<View> f11299g = new C11214h<>();

    /* renamed from: h */
    public C11214h<View> f11300h = new C11214h<>();

    /* renamed from: com.huawei.android.cg.ui.ShareAlbumHomeAdapter$a */
    public static class C2375a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f11301u;

        public C2375a(View view) {
            super(view);
            this.f11301u = (ImageView) view.findViewById(R$id.ic_pic);
        }
    }

    public ShareAlbumHomeAdapter(Context context) {
        this.f11296d = LayoutInflater.from(context);
        this.f11297e = context;
    }

    /* renamed from: D */
    public boolean m14858D(int i10) {
        return i10 < this.f11299g.m67346n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<Object> list = this.f11298f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return m14858D(i10) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        C11839m.m70687e("AlbumHomeAdapter", "pos" + i10);
        if (abstractC0833c0 instanceof C2375a) {
            C11839m.m70687e("AlbumHomeAdapter", "ImageAlpha: " + ((C2375a) abstractC0833c0).f11301u.getImageAlpha());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        C11839m.m70687e("AlbumHomeAdapter", "onCreateViewHolder" + i10);
        return new C2375a(this.f11296d.inflate(R$layout.share_album_pic_item, viewGroup, false));
    }
}
