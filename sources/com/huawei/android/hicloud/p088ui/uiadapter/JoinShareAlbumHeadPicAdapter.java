package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import java.util.List;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class JoinShareAlbumHeadPicAdapter extends RecyclerView.AbstractC0838h<C4054a> {

    /* renamed from: d */
    public Context f18761d;

    /* renamed from: e */
    public List<String> f18762e;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.JoinShareAlbumHeadPicAdapter$a */
    public class C4054a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f18763u;

        public C4054a(View view) {
            super(view);
            if (view == null) {
                C11839m.m70688i("JoinShareAlbumHeadPicAdapter", "itemView is null");
            } else {
                this.f18763u = (ImageView) C12809f.m76831d(view, R$id.share_album_user_pic_iv);
            }
        }
    }

    public JoinShareAlbumHeadPicAdapter(Context context) {
        this.f18761d = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4054a c4054a, int i10) {
        List<String> list = this.f18762e;
        if (list == null || i10 >= list.size()) {
            return;
        }
        String str = this.f18762e.get(i10);
        if (TextUtils.equals(str, "share_system")) {
            c4054a.f18763u.setImageResource(R$drawable.ic_share_album_jun);
        } else {
            ((InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)).mo58440l0(str, c4054a.f18763u);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public C4054a mo724u(ViewGroup viewGroup, int i10) {
        C11839m.m70689w("JoinShareAlbumHeadPicAdapter", "onCreateViewHolder");
        return new C4054a(LayoutInflater.from(this.f18761d).inflate(R$layout.join_share_album_head_pic_item, viewGroup, false));
    }

    /* renamed from: F */
    public void m25056F(List<String> list) {
        this.f18762e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<String> list = this.f18762e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
