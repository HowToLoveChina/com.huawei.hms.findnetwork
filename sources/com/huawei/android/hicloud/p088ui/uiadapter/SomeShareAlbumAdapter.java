package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.router.data.ShareAlbumInfo;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0224k0;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p336he.C10159j;
import p514o9.C11839m;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SomeShareAlbumAdapter extends RecyclerView.AbstractC0838h<C4068b> {

    /* renamed from: d */
    public Context f18867d;

    /* renamed from: e */
    public List<ShareAlbumInfo> f18868e;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SomeShareAlbumAdapter$a */
    public class ViewOnClickListenerC4067a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ShareAlbumInfo f18869a;

        public ViewOnClickListenerC4067a(ShareAlbumInfo shareAlbumInfo) {
            this.f18869a = shareAlbumInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("SomeShareAlbumAdapter", "onBindViewHolder click too fast");
                return;
            }
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("album_count", String.valueOf(SomeShareAlbumAdapter.this.f18868e.size()));
            C13225d.m79490f1().m79594r0("CLICK_MAIN_SHARE_CARD", linkedHashMapM79497A);
            Intent intent = new Intent();
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.setAction("com.huawei.android.cg.activity.ShareAlbumHomePageActivity");
            intent.putExtra("param_album_id", this.f18869a.getAlbumId());
            C0224k0.m1542L(SomeShareAlbumAdapter.this.f18867d, intent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SomeShareAlbumAdapter$b */
    public class C4068b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public RelativeLayout f18871u;

        /* renamed from: v */
        public ImageView f18872v;

        /* renamed from: w */
        public TextView f18873w;

        /* renamed from: x */
        public TextView f18874x;

        public C4068b(View view) {
            super(view);
            if (view == null) {
                C11839m.m70688i("SomeShareAlbumAdapter", "itemView is null");
                return;
            }
            this.f18871u = (RelativeLayout) C12809f.m76831d(view, R$id.some_share_album_item_container);
            this.f18872v = (ImageView) C12809f.m76831d(view, R$id.some_share_album_cover);
            this.f18873w = (TextView) C12809f.m76831d(view, R$id.some_share_album_end_editor_time_tv);
            this.f18874x = (TextView) C12809f.m76831d(view, R$id.some_share_album_name_tv);
        }
    }

    public SomeShareAlbumAdapter(Context context) {
        this.f18867d = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4068b c4068b, int i10) {
        List<ShareAlbumInfo> list = this.f18868e;
        if (list == null) {
            C11839m.m70688i("SomeShareAlbumAdapter", "onBindViewHolder dataList is null.");
            return;
        }
        ShareAlbumInfo shareAlbumInfo = list.get(i10);
        c4068b.f18874x.setText(shareAlbumInfo.getAlbumName());
        c4068b.f18873w.setText(C10159j.m63327c(this.f18867d, shareAlbumInfo.getEndEditorTime()));
        c4068b.f18872v.setImageDrawable(this.f18867d.getDrawable(R$drawable.ic_share_album_main_default));
        ((InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)).mo58395T0(shareAlbumInfo.getMediaId(), c4068b.f18872v);
        c4068b.f18871u.setOnClickListener(new ViewOnClickListenerC4067a(shareAlbumInfo));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public C4068b mo724u(ViewGroup viewGroup, int i10) {
        C11839m.m70689w("SomeShareAlbumAdapter", "onCreateViewHolder");
        return new C4068b(LayoutInflater.from(this.f18867d).inflate(R$layout.some_share_album_item, viewGroup, false));
    }

    /* renamed from: H */
    public void m25225H(List<ShareAlbumInfo> list) {
        this.f18868e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<ShareAlbumInfo> list = this.f18868e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
