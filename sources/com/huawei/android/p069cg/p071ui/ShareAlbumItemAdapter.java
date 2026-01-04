package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.p071ui.ShareAlbumHomeAdapter;
import java.util.ArrayList;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class ShareAlbumItemAdapter extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public final LayoutInflater f11302d;

    /* renamed from: e */
    public final Context f11303e;

    /* renamed from: f */
    public ArrayList<String> f11304f;

    /* renamed from: com.huawei.android.cg.ui.ShareAlbumItemAdapter$a */
    public static class C2376a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f11305u;

        /* renamed from: v */
        public ImageView f11306v;
    }

    public ShareAlbumItemAdapter(Context context) {
        this.f11302d = LayoutInflater.from(context);
        this.f11303e = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f11304f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return super.mo722f(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (abstractC0833c0 instanceof C2376a) {
            C2376a c2376a = (C2376a) abstractC0833c0;
            c2376a.f11305u.setText(this.f11304f.get(i10));
            C11839m.m70688i("AlbumMemberAdapter", "ImageAlpha: " + c2376a.f11306v.getImageAlpha());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new ShareAlbumHomeAdapter.C2375a(this.f11302d.inflate(R$layout.album_member_item, viewGroup, false));
    }
}
