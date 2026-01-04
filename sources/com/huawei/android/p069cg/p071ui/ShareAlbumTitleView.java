package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.p069cg.R$dimen;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import p031b7.C1140u;
import p336he.C10159j;
import p471m6.C11415a;
import p546p6.C12091d;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumTitleView extends LinearLayout {

    /* renamed from: n */
    public static final List<String> f11307n = Arrays.asList("father", "mother", "grandpa", "grandma", "grandfather", "grandmother");

    /* renamed from: a */
    public Context f11308a;

    /* renamed from: b */
    public View f11309b;

    /* renamed from: c */
    public C11415a f11310c;

    /* renamed from: d */
    public View.OnClickListener f11311d;

    /* renamed from: e */
    public TextView f11312e;

    /* renamed from: f */
    public TextView f11313f;

    /* renamed from: g */
    public TextView f11314g;

    /* renamed from: h */
    public RelativeLayout f11315h;

    /* renamed from: i */
    public C2377a f11316i;

    /* renamed from: j */
    public RelativeLayout f11317j;

    /* renamed from: k */
    public ImageView f11318k;

    /* renamed from: l */
    public LinearLayout f11319l;

    /* renamed from: m */
    public List<Permission> f11320m;

    /* renamed from: com.huawei.android.cg.ui.ShareAlbumTitleView$a */
    public static class C2377a extends RecyclerView.AbstractC0838h {

        /* renamed from: d */
        public Context f11321d;

        /* renamed from: e */
        public LayoutInflater f11322e;

        /* renamed from: f */
        public List<Permission> f11323f;

        /* renamed from: g */
        public View.OnClickListener f11324g;

        public C2377a(Context context, List<Permission> list, View.OnClickListener onClickListener) {
            this.f11322e = LayoutInflater.from(context);
            this.f11321d = context;
            this.f11323f = list;
            this.f11324g = onClickListener;
        }

        /* renamed from: D */
        public final void m14862D(int i10, C2378b c2378b) {
            if (i10 != 0) {
                c2378b.f11328x.setVisibility(8);
                c2378b.f11326v.setVisibility(0);
                c2378b.f11327w.setVisibility(8);
            } else {
                c2378b.f11328x.setVisibility(0);
                c2378b.f11326v.setVisibility(8);
                c2378b.f11327w.setVisibility(8);
                C12091d.m72280a0().m72296B(this.f11323f.get(0).getUserId(), c2378b.f11325u);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: e */
        public int mo721e() {
            List<Permission> list = this.f11323f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            if (this.f11323f.size() == 1) {
                return this.f11323f.size() + 1;
            }
            if (this.f11323f.size() < 2 || this.f11323f.size() > 3) {
                return 4;
            }
            return this.f11323f.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: s */
        public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
            C2378b c2378b = (C2378b) abstractC0833c0;
            c2378b.f11329y.setOnClickListener(this.f11324g);
            if (this.f11323f.size() == 1) {
                m14862D(i10, c2378b);
                return;
            }
            if (this.f11323f.size() >= 2 && this.f11323f.size() <= 3) {
                c2378b.f11328x.setVisibility(0);
                c2378b.f11326v.setVisibility(8);
                c2378b.f11327w.setVisibility(8);
                C12091d.m72280a0().m72296B(this.f11323f.get(i10).getUserId(), c2378b.f11325u);
                return;
            }
            if (i10 >= 3) {
                c2378b.f11328x.setVisibility(8);
                c2378b.f11326v.setVisibility(8);
                c2378b.f11327w.setVisibility(0);
                c2378b.f11330z.setText(this.f11321d.getString(R$string.album_member_num, String.valueOf(this.f11323f.size() - 3)));
                return;
            }
            c2378b.f11328x.setVisibility(0);
            c2378b.f11326v.setVisibility(8);
            c2378b.f11327w.setVisibility(8);
            C12091d.m72280a0().m72296B(this.f11323f.get(i10).getUserId(), c2378b.f11325u);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: u */
        public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
            return new C2378b(this.f11322e.inflate(R$layout.album_member_head_item, viewGroup, false), this.f11321d);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.ShareAlbumTitleView$b */
    public static class C2378b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f11325u;

        /* renamed from: v */
        public RelativeLayout f11326v;

        /* renamed from: w */
        public RelativeLayout f11327w;

        /* renamed from: x */
        public RelativeLayout f11328x;

        /* renamed from: y */
        public RelativeLayout f11329y;

        /* renamed from: z */
        public TextView f11330z;

        public C2378b(View view, Context context) {
            super(view);
            this.f11329y = (RelativeLayout) C12809f.m76831d(view, R$id.share_member_head_item);
            this.f11325u = (ImageView) C12809f.m76831d(view, R$id.ic_member_head);
            this.f11330z = (TextView) C12809f.m76831d(view, R$id.member_num);
            this.f11327w = (RelativeLayout) C12809f.m76831d(view, R$id.rl_memeber_num);
            this.f11326v = (RelativeLayout) C12809f.m76831d(view, R$id.rl_member_add);
            this.f11328x = (RelativeLayout) C12809f.m76831d(view, R$id.rl_member_head);
        }
    }

    public ShareAlbumTitleView(Context context, C11415a c11415a, View.OnClickListener onClickListener) {
        super(context);
        this.f11308a = context;
        this.f11310c = c11415a;
        this.f11311d = onClickListener;
        m14859a();
    }

    /* renamed from: a */
    public void m14859a() {
        View viewInflate = LayoutInflater.from(this.f11308a).inflate(R$layout.share_album_title_view, this);
        this.f11309b = viewInflate;
        if (viewInflate == null) {
            return;
        }
        this.f11312e = (TextView) C12809f.m76831d(this, R$id.album_name);
        this.f11313f = (TextView) C12809f.m76831d(this, R$id.album_age);
        this.f11314g = (TextView) C12809f.m76831d(this, R$id.tv_index_stub);
        this.f11315h = (RelativeLayout) C12809f.m76831d(this, R$id.album_title_layout);
        ((RelativeLayout) C12809f.m76831d(this, R$id.ll_album_title)).setOnClickListener(this.f11311d);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(this, R$id.ll_head);
        this.f11319l = linearLayout;
        linearLayout.setOnClickListener(this.f11311d);
        this.f11315h.setOnClickListener(this.f11311d);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(this, R$id.baby_cover_layout);
        this.f11317j = relativeLayout;
        relativeLayout.setOnClickListener(this.f11311d);
        this.f11318k = (ImageView) C12809f.m76831d(this, R$id.baby_cover);
        boolean z10 = this.f11310c.m68362a().getShareType().intValue() == 1;
        setAlbumName(this.f11310c.m68363b());
        RecyclerView recyclerView = (RecyclerView) C12809f.m76831d(this, R$id.member_head_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f11308a);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Permission> listM14861c = m14861c(this.f11310c.m68362a().getPermissions(), z10);
        this.f11320m = listM14861c;
        C2377a c2377a = new C2377a(this.f11308a, listM14861c, this.f11311d);
        this.f11316i = c2377a;
        recyclerView.setAdapter(c2377a);
        this.f11313f.setText(this.f11308a.getString(R$string.album_create_time, C10159j.m63334j(new Date(this.f11310c.m68362a().getCreatedTime().m28458c()))));
        String strValueOf = String.valueOf(100);
        this.f11314g.setText(this.f11308a.getString(R$string.album_index, strValueOf, strValueOf));
        this.f11314g.setVisibility(4);
        if (z10 && this.f11310c.m68362a().getBabyInfo().getBirthday() != null) {
            this.f11313f.setText(C12091d.m72280a0().m72332U(this.f11308a, System.currentTimeMillis(), this.f11310c.m68362a().getBabyInfo().getBirthday().m28458c()));
        }
        Resources resources = this.f11308a.getResources();
        if (resources == null) {
            return;
        }
        if (z10) {
            this.f11317j.setVisibility(0);
            this.f11317j.setAlpha(1.0f);
            C1140u.m7201m(this.f11308a, this.f11310c.m68362a(), this.f11318k);
            this.f11315h.setPaddingRelative(0, 0, resources.getDimensionPixelSize(R$dimen.cloud_space_71_dp), resources.getDimensionPixelSize(R$dimen.cloud_space_6_dp));
        } else {
            this.f11317j.setVisibility(8);
            this.f11315h.setPaddingRelative(0, 0, resources.getDimensionPixelSize(R$dimen.cloud_space_12_dp), resources.getDimensionPixelSize(R$dimen.cloud_space_6_dp));
        }
        this.f11315h.setVisibility(0);
        this.f11319l.setVisibility(0);
    }

    /* renamed from: b */
    public void m14860b() {
        C1140u.m7201m(this.f11308a, this.f11310c.m68362a(), this.f11318k);
    }

    /* renamed from: c */
    public final List<Permission> m14861c(List<Permission> list, boolean z10) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<Permission> arrayList = new ArrayList();
        arrayList.addAll(list);
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String albumOwnerId = this.f11310c.m68362a().getAlbumOwnerId();
        for (Permission permission : arrayList) {
            if (TextUtils.equals(permission.getUserId(), albumOwnerId)) {
                arrayList2.add(permission);
            } else if (TextUtils.equals(permission.getUserId(), strM80971t0)) {
                arrayList3.add(permission);
            } else if (!z10) {
                arrayList5.add(permission);
            } else if (TextUtils.equals(permission.getKinship(), "other") || TextUtils.isEmpty(permission.getKinship())) {
                arrayList5.add(permission);
            } else {
                map.put(permission.getKinship(), permission);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        arrayList6.addAll(arrayList2);
        arrayList6.addAll(arrayList3);
        if (z10) {
            for (String str : f11307n) {
                if (map.containsKey(str)) {
                    arrayList4.add((Permission) map.get(str));
                }
            }
            arrayList6.addAll(arrayList4);
        }
        arrayList6.addAll(arrayList5);
        return arrayList6;
    }

    public void setAlbumName(String str) {
        this.f11312e.setText(str);
    }

    public void setEffectTime(String str) {
        this.f11313f.setText(str);
    }

    public void setTitleVisible(boolean z10) {
        if (z10) {
            this.f11315h.setVisibility(0);
        } else {
            this.f11315h.setVisibility(4);
        }
    }

    public ShareAlbumTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11308a = context;
        m14859a();
    }

    public ShareAlbumTitleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m14859a();
    }
}
