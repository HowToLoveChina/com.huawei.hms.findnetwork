package com.huawei.android.p069cg.activity;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.C0867f;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.activity.PhotosTabPresenter;
import com.huawei.android.p069cg.p071ui.PhotosTabAdapter;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1134o;
import p471m6.C11424j;
import p514o9.C11839m;
import p514o9.C11842p;
import p546p6.C12091d;
import p604r7.C12473f;
import sk.C12809f;

/* loaded from: classes2.dex */
public class PhotosTabPresenter extends AlbumManagerBasePresenter implements View.OnClickListener {

    /* renamed from: b */
    public RecyclerView f10254b;

    /* renamed from: c */
    public View f10255c;

    /* renamed from: d */
    public PhotosTabAdapter f10256d;

    /* renamed from: e */
    public GridLayoutManager f10257e;

    /* renamed from: com.huawei.android.cg.activity.PhotosTabPresenter$a */
    public class C2207a extends RecyclerView.AbstractC0850t {
        public C2207a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (PhotosTabPresenter.this.f10256d == null) {
                C1120a.m6676e("PhotosTabPresenter", "onScrollStateChanged photosTabAdapter is null.");
                return;
            }
            if (i10 == 0 || i10 == 2) {
                C1120a.m6675d("PhotosTabPresenter", "onScrollStateChanged,stop scroll");
            } else if (i10 == 1) {
                C1120a.m6675d("PhotosTabPresenter", "onScrollStateChanged,scrolling");
            }
        }
    }

    public PhotosTabPresenter(AlbumManageActivity albumManageActivity) {
        super(albumManageActivity);
        this.f9944a = albumManageActivity;
        m13642f();
    }

    private int getColumnNum() {
        if (this.f9944a.getResources().getConfiguration().orientation == 2) {
            return C11842p.m70771U0() ? 6 : 4;
        }
        if (this.f9944a.getResources().getConfiguration().orientation == 1) {
            return C11842p.m70771U0() ? 4 : 2;
        }
        return 0;
    }

    /* renamed from: h */
    public static /* synthetic */ void m13639h() {
        C12091d.m72280a0().m72328S();
    }

    /* renamed from: d */
    public final void m13640d() {
        if (this.f10256d == null) {
            this.f10256d = new PhotosTabAdapter(this.f9944a);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f9944a, getColumnNum());
            this.f10257e = gridLayoutManager;
            this.f10254b.setLayoutManager(gridLayoutManager);
            this.f10254b.setAdapter(this.f10256d);
            this.f10254b.addOnScrollListener(new C2207a());
        }
    }

    /* renamed from: e */
    public void m13641e() {
        C1120a.m6677i("PhotosTabPresenter", "initItems()");
        C12091d.m72280a0().m72328S();
    }

    /* renamed from: f */
    public void m13642f() {
        C1120a.m6677i("PhotosTabPresenter", "initView()");
        View viewInflate = LayoutInflater.from(this.f9944a).inflate(R$layout.album_manager_photos, this);
        this.f10255c = viewInflate;
        if (viewInflate == null) {
            return;
        }
        this.f10254b = (RecyclerView) C12809f.m76831d(viewInflate, R$id.photos_tab_recyclerview);
        m13640d();
        postDelayed(new Runnable() { // from class: k6.k
            @Override // java.lang.Runnable
            public final void run() {
                PhotosTabPresenter.m13639h();
            }
        }, 800L);
    }

    /* renamed from: g */
    public final boolean m13643g(List<C11424j> list, List<C11424j> list2) {
        if (list == null || list2 == null || list.isEmpty() || list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            C11424j c11424j = list.get(i10);
            C11424j c11424j2 = list2.get(i10);
            String strM68454b = c11424j.m68454b();
            String strM68454b2 = c11424j2.m68454b();
            if (strM68454b == null || strM68454b2 == null || !strM68454b.equals(strM68454b2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    public final void m13644i(List<C11424j> list) {
        if (list == null) {
            C1120a.m6677i("PhotosTabPresenter", "showAlbumRecyclerView newDataList is null.");
            return;
        }
        if (this.f10256d != null) {
            if (C12473f.m74865c().m74867d()) {
                C1120a.m6677i("PhotosTabPresenter", "showAlbumRecyclerView notifyDataSetChanged.");
                this.f10256d.m14732O(getColumnNum(), list);
                this.f10256d.m5213j();
            } else if (m13643g(this.f10256d.m14726I(), list)) {
                C1120a.m6677i("PhotosTabPresenter", "showAlbumRecyclerView isSameALbumList.");
                return;
            } else {
                C1120a.m6677i("PhotosTabPresenter", "showAlbumRecyclerView DiffUtil.");
                C0867f.m5478b(new C1134o(this.f10256d.m14726I(), list), true).m5495c(this.f10256d);
                this.f10256d.m14732O(getColumnNum(), list);
            }
            C1120a.m6677i("PhotosTabPresenter", "showAlbumRecyclerView refreshData.");
        }
    }

    /* renamed from: j */
    public void m13645j() {
        C1120a.m6677i("PhotosTabPresenter", "showAllAlbumInfo");
        m13644i(C12091d.m72280a0().m72366m0());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("PhotosTabPresenter", "click too fast");
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        C1120a.m6677i("PhotosTabPresenter", "onConfigurationChanged.");
        m13640d();
        if (this.f10256d != null) {
            C1120a.m6677i("PhotosTabPresenter", "onConfigurationChanged  notifyDataSetChanged .");
            this.f10257e.setSpanCount(getColumnNum());
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f10256d.m14726I());
            this.f10256d.m14732O(getColumnNum(), arrayList);
            this.f10254b.setAdapter(this.f10256d);
            this.f10256d.m5213j();
        }
    }
}
