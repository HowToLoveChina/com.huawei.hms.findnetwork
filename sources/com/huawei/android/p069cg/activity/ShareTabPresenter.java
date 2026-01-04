package com.huawei.android.p069cg.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.p069cg.R$dimen;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$menu;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.ShareTabPresenter;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1136q;
import p031b7.C1140u;
import p471m6.C11415a;
import p486n6.DialogC11637b;
import p486n6.ViewOnClickListenerC11648m;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareTabPresenter extends AlbumManagerBasePresenter {

    /* renamed from: b */
    public RecyclerView f10647b;

    /* renamed from: c */
    public ImageView f10648c;

    /* renamed from: d */
    public RelativeLayout f10649d;

    /* renamed from: e */
    public RelativeLayout f10650e;

    /* renamed from: f */
    public TextView f10651f;

    /* renamed from: g */
    public TextView f10652g;

    /* renamed from: h */
    public List<C11415a> f10653h;

    /* renamed from: i */
    public C2251e f10654i;

    /* renamed from: j */
    public View f10655j;

    /* renamed from: com.huawei.android.cg.activity.ShareTabPresenter$a */
    public static class ViewOnClickListenerC2247a implements View.OnClickListener {

        /* renamed from: a */
        public ShareTabPresenter f10656a;

        public ViewOnClickListenerC2247a(ShareTabPresenter shareTabPresenter) {
            this.f10656a = shareTabPresenter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id2 = view.getId();
            if (!C0209d.m1226Y0() && id2 == R$id.share_tab_item) {
                C11415a c11415a = (C11415a) view.getTag();
                Intent intent = new Intent(this.f10656a.f9944a, (Class<?>) ShareAlbumHomePageActivity.class);
                intent.putExtra("param_album_id", c11415a.m68362a().getId());
                intent.putExtra("param_album_type", c11415a.m68362a().getShareType());
                C0224k0.m1544N(this.f10656a.f9944a, intent, 101);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareTabPresenter$b */
    public static class C2248b extends AbstractC12367d {

        /* renamed from: a */
        public final Activity f10657a;

        /* renamed from: b */
        public final String f10658b;

        /* renamed from: c */
        public final C11415a f10659c;

        public C2248b(Activity activity, String str, C11415a c11415a) {
            this.f10657a = activity;
            this.f10658b = str;
            this.f10659c = c11415a;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                Inviter inviterM74749c = C12469b.m74746l().m74749c(this.f10658b, "other", "other", "upload", Inviter.INVITE_CODE, true);
                if (inviterM74749c != null) {
                    final String inviterId = inviterM74749c.getInviterId();
                    if (TextUtils.isEmpty(inviterId)) {
                        C1120a.m6676e("ShareTabPresenter", "inviterId isEmpty");
                    }
                    this.f10657a.runOnUiThread(new Runnable() { // from class: k6.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f52077a.lambda$call$0(inviterId);
                        }
                    });
                }
            } catch (Exception e10) {
                C1120a.m6677i("ShareTabPresenter", "initData inviter " + e10.getMessage());
            }
        }

        public final /* synthetic */ void lambda$call$0(String str) {
            String strM7192d = C1140u.m7192d(str);
            DialogC11637b dialogC11637b = new DialogC11637b(this.f10657a, this.f10659c.m68362a(), str, strM7192d);
            C1140u.m7189a(this.f10657a, strM7192d);
            dialogC11637b.show();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareTabPresenter$c */
    public static class C2249c implements PopupMenu.OnMenuItemClickListener {

        /* renamed from: a */
        public ShareTabPresenter f10660a;

        /* renamed from: b */
        public C11415a f10661b;

        public C2249c(ShareTabPresenter shareTabPresenter, C11415a c11415a) {
            this.f10660a = shareTabPresenter;
            this.f10661b = c11415a;
        }

        /* renamed from: b */
        public static /* synthetic */ int m13987b(C11415a c11415a, C11415a c11415a2) {
            return Long.valueOf(c11415a2.m68362a().getEditedTime().m28458c()).compareTo(Long.valueOf(c11415a.m68362a().getEditedTime().m28458c()));
        }

        /* renamed from: c */
        public final void m13988c() {
            Collections.sort(this.f10660a.f10653h, new Comparator() { // from class: k6.x
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ShareTabPresenter.C2249c.m13987b((C11415a) obj, (C11415a) obj2);
                }
            });
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            C11415a c11415a = this.f10661b;
            if (c11415a != null) {
                String id2 = c11415a.m68362a().getId();
                int iIntValue = this.f10661b.m68362a().getShareType().intValue();
                if (itemId == R$id.cloud_add_item_view) {
                    Intent intent = new Intent(this.f10660a.f9944a, (Class<?>) AlbumShareInviteActivity.class);
                    intent.putExtra("param_album_id", id2);
                    intent.putExtra("param_album_relation", "other");
                    C0224k0.m1542L(this.f10660a.f9944a, intent);
                    LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                    linkedHashMapM79497A.put("album_invite_src", "1");
                    linkedHashMapM79497A.put("album_type", String.valueOf(iIntValue));
                    C13224c.m79487f1().m79594r0("SHOW_INVITE_DETAIL_PAGE", linkedHashMapM79497A);
                } else if (itemId == R$id.cloud_payment_item_view) {
                    C12515a.m75110o().m75175e(new C2248b(this.f10660a.f9944a, id2, this.f10661b), false);
                } else if (itemId == R$id.share_album_manage) {
                    Intent intent2 = new Intent(this.f10660a.f9944a, (Class<?>) ShareAlbumManageActivity.class);
                    intent2.putExtra("param_album_id", id2);
                    intent2.putExtra("param_album_type", iIntValue);
                    C12091d.m72280a0().m72343Z0(this.f10661b.m68362a().getPermissions());
                    C12091d.m72280a0();
                    C12091d.m72281a1(this.f10661b);
                    C0224k0.m1544N(this.f10660a.f9944a, intent2, 102);
                } else if (itemId == R$id.top_album_item_view) {
                    if (id2.equals(C1136q.d.m7155s())) {
                        C1136q.d.m7134K("");
                        m13988c();
                        AlbumManageActivity albumManageActivity = this.f10660a.f9944a;
                        C11841o.m70706b(albumManageActivity, albumManageActivity.getString(R$string.album_cancel_top_msg), 0);
                    } else {
                        C13224c.m79487f1().m79593q0("CLICK_SHARE_LIST_TOP_MENU");
                        C1136q.d.m7134K(id2);
                        this.f10660a.f10653h.remove(this.f10661b);
                        m13988c();
                        this.f10660a.f10653h.add(0, this.f10661b);
                        AlbumManageActivity albumManageActivity2 = this.f10660a.f9944a;
                        C11841o.m70706b(albumManageActivity2, albumManageActivity2.getString(R$string.album_top_msg), 0);
                    }
                    this.f10660a.f10654i.m5213j();
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareTabPresenter$d */
    public static class ViewOnClickListenerC2250d implements View.OnClickListener {

        /* renamed from: a */
        public C11415a f10662a;

        /* renamed from: b */
        public PopupMenu f10663b;

        public ViewOnClickListenerC2250d(C11415a c11415a, PopupMenu popupMenu) {
            this.f10662a = c11415a;
            this.f10663b = popupMenu;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItem menuItemFindItem = this.f10663b.getMenu().findItem(R$id.top_album_item_view);
            if (this.f10662a.m68362a().getId().equals(C1136q.d.m7155s())) {
                menuItemFindItem.setTitle(R$string.cancel_topping);
            } else {
                menuItemFindItem.setTitle(R$string.top_album);
            }
            this.f10663b.show();
            this.f10662a.m68373l(true);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareTabPresenter$e */
    public static class C2251e extends RecyclerView.AbstractC0838h {

        /* renamed from: d */
        public Context f10664d;

        /* renamed from: e */
        public LayoutInflater f10665e;

        /* renamed from: f */
        public ShareTabPresenter f10666f;

        /* renamed from: g */
        public int f10667g;

        /* renamed from: com.huawei.android.cg.activity.ShareTabPresenter$e$a */
        public static class a implements PopupMenu.OnDismissListener {

            /* renamed from: a */
            public final C11415a f10668a;

            public a(C11415a c11415a) {
                this.f10668a = c11415a;
            }

            @Override // android.widget.PopupMenu.OnDismissListener
            public void onDismiss(PopupMenu popupMenu) {
                this.f10668a.m68373l(false);
            }
        }

        public C2251e(Context context, ShareTabPresenter shareTabPresenter, int i10) {
            this.f10667g = 2;
            this.f10665e = LayoutInflater.from(context);
            this.f10664d = context;
            this.f10667g = i10;
            this.f10666f = shareTabPresenter;
        }

        /* renamed from: D */
        public final void m13989D(C2252f c2252f, boolean z10) {
            c2252f.f10676z.getMenu().findItem(R$id.cloud_add_item_view).setVisible(z10);
            c2252f.f10676z.getMenu().findItem(R$id.cloud_payment_item_view).setVisible(z10);
            c2252f.f10676z.getMenu().findItem(R$id.share_album_manage).setVisible(z10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: e */
        public int mo721e() {
            return this.f10666f.f10653h.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: s */
        public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
            C11415a c11415a = (C11415a) this.f10666f.f10653h.get(i10);
            Album albumM68362a = c11415a.m68362a();
            C2252f c2252f = (C2252f) abstractC0833c0;
            if (albumM68362a.getShareType().intValue() == 1) {
                C1140u.m7200l(this.f10664d, albumM68362a, c2252f.f10671u);
            } else if (!TextUtils.isEmpty(albumM68362a.getCoverImage())) {
                C12091d.m72280a0().m72396x(albumM68362a, albumM68362a.getCoverImage(), c2252f.f10671u);
            } else if (!C12091d.m72280a0().m72302E(albumM68362a, c2252f.f10671u)) {
                c2252f.f10671u.setImageDrawable(this.f10666f.f9944a.getDrawable(R$drawable.ic_share_album_tab_default));
            }
            c2252f.f10673w.setText(albumM68362a.getAlbumName());
            Resources resources = this.f10666f.f9944a.getResources();
            if (resources == null) {
                return;
            }
            int dimensionPixelSize = c2252f.f10671u.getLayoutParams().width;
            if (C1136q.d.m7155s().equals(albumM68362a.getId())) {
                dimensionPixelSize -= resources.getDimensionPixelSize(R$dimen.cloud_space_18_dp);
                c2252f.f10670B.setVisibility(0);
            } else {
                c2252f.f10670B.setVisibility(8);
            }
            if (TextUtils.isEmpty(c11415a.m68367f())) {
                c2252f.f10675y.setVisibility(8);
                c2252f.f10673w.setMaxWidth(dimensionPixelSize);
            } else {
                TextPaint paint = c2252f.f10675y.getPaint();
                c2252f.f10675y.setText(c11415a.m68367f());
                c2252f.f10673w.setMaxWidth((dimensionPixelSize - ((int) Layout.getDesiredWidth(c11415a.m68367f(), 0, c11415a.m68367f().length(), paint))) - resources.getDimensionPixelSize(R$dimen.cloud_space_18_dp));
                c2252f.f10675y.setVisibility(0);
            }
            if (TextUtils.isEmpty(albumM68362a.getAlbumOwnerId()) || !albumM68362a.getAlbumOwnerId().equals(C13452e.m80781L().m80971t0())) {
                c2252f.f10674x.setText(this.f10666f.f9944a.getString(R$string.share_album_from, albumM68362a.getAlbumOwnerName()));
                m13989D(c2252f, false);
            } else {
                TextView textView = c2252f.f10674x;
                AlbumManageActivity albumManageActivity = this.f10666f.f9944a;
                textView.setText(albumManageActivity.getString(R$string.own_member, albumManageActivity.getString(R$string.share_album_from, albumM68362a.getAlbumOwnerName())));
                m13989D(c2252f, true);
            }
            c2252f.f10672v.setOnClickListener(new ViewOnClickListenerC2250d(c11415a, c2252f.f10676z));
            c2252f.f10669A.setOnClickListener(new ViewOnClickListenerC2247a(this.f10666f));
            c2252f.f10669A.setTag(c11415a);
            c2252f.f10676z.setOnMenuItemClickListener(new C2249c(this.f10666f, c11415a));
            c2252f.f10676z.setOnDismissListener(new a(c11415a));
            if (!c11415a.m68366e()) {
                c2252f.f10676z.dismiss();
                return;
            }
            MenuItem menuItemFindItem = c2252f.f10676z.getMenu().findItem(R$id.top_album_item_view);
            if (c11415a.m68362a().getId().equals(C1136q.d.m7155s())) {
                menuItemFindItem.setTitle(R$string.cancel_topping);
            } else {
                menuItemFindItem.setTitle(R$string.top_album);
            }
            c2252f.f10676z.show();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: u */
        public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
            return new C2252f(this.f10665e.inflate(R$layout.albums_tab_item, viewGroup, false), this.f10664d, this.f10667g);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareTabPresenter$f */
    public static class C2252f extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public RelativeLayout f10669A;

        /* renamed from: B */
        public ImageView f10670B;

        /* renamed from: u */
        public ImageView f10671u;

        /* renamed from: v */
        public ImageView f10672v;

        /* renamed from: w */
        public TextView f10673w;

        /* renamed from: x */
        public TextView f10674x;

        /* renamed from: y */
        public TextView f10675y;

        /* renamed from: z */
        public PopupMenu f10676z;

        public C2252f(View view, Context context, int i10) {
            super(view);
            this.f10671u = (ImageView) C12809f.m76831d(view, R$id.share_tab_item_img);
            this.f10673w = (TextView) C12809f.m76831d(view, R$id.share_tab_item_title);
            this.f10675y = (TextView) C12809f.m76831d(view, R$id.share_tab_item_tag);
            this.f10674x = (TextView) C12809f.m76831d(view, R$id.share_tab_item_sub_title);
            this.f10672v = (ImageView) C12809f.m76831d(view, R$id.share_tab_item_setting);
            this.f10669A = (RelativeLayout) C12809f.m76831d(view, R$id.share_tab_item);
            this.f10670B = (ImageView) C12809f.m76831d(view, R$id.share_tab_album_top_img);
            PopupMenu popupMenu = new PopupMenu(context, this.f10672v, 8388613);
            popupMenu.getMenuInflater().inflate(R$menu.album_item_menu, popupMenu.getMenu());
            this.f10676z = popupMenu;
            m5147I(false);
            if (context != null) {
                ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(new DisplayMetrics());
                int iM70844o = (int) ((((r4.widthPixels - (C11842p.m70844o(context, 10) * 2.0f)) / i10) - C12808e.m76823b()) - C11842p.m70844o(context, 12));
                ViewGroup.LayoutParams layoutParams = this.f10671u.getLayoutParams();
                layoutParams.width = iM70844o;
                layoutParams.height = iM70844o;
                this.f10671u.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareTabPresenter$g */
    public static class ViewOnClickListenerC2253g implements View.OnClickListener {

        /* renamed from: a */
        public ShareTabPresenter f10677a;

        public ViewOnClickListenerC2253g(ShareTabPresenter shareTabPresenter) {
            this.f10677a = shareTabPresenter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id2 = view.getId();
            if (C0209d.m1226Y0()) {
                C1120a.m6678w("ShareTabPresenter", "do not fast click");
                return;
            }
            if (id2 == R$id.album_share_tab_create) {
                C0224k0.m1542L(this.f10677a.f9944a, new Intent(this.f10677a.f9944a, (Class<?>) CreateOrJoinAlbumActivity.class));
                C13224c.m79487f1().m79593q0("CLICK_SHARE_TAB_ADD_ICON");
            } else if (id2 == R$id.share_invite_button) {
                C0224k0.m1542L(this.f10677a.f9944a, new Intent(this.f10677a.f9944a, (Class<?>) CreateOrJoinAlbumActivity.class));
            } else if (id2 == R$id.jion_with_invite_code) {
                ViewOnClickListenerC11648m viewOnClickListenerC11648m = new ViewOnClickListenerC11648m(this.f10677a.f9944a);
                viewOnClickListenerC11648m.show();
                viewOnClickListenerC11648m.m69570p();
                C12091d.m72280a0().m72341Y0("action_code_click_join_share_album", "ShareTabPresenter");
            }
        }
    }

    public ShareTabPresenter(AlbumManageActivity albumManageActivity) {
        super(albumManageActivity);
        this.f10653h = new ArrayList();
        this.f9944a = albumManageActivity;
        m13980e();
    }

    /* renamed from: d */
    public void m13979d() {
        C11839m.m70688i("ShareTabPresenter", "initItems");
        C12091d.m72280a0().m72384s0();
    }

    /* renamed from: e */
    public void m13980e() {
        C11839m.m70688i("ShareTabPresenter", "initView");
        View viewInflate = LayoutInflater.from(this.f9944a).inflate(R$layout.album_manager_share, this);
        this.f10655j = viewInflate;
        if (viewInflate == null) {
            return;
        }
        this.f10649d = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.album_tab_share_tips);
        this.f10650e = (RelativeLayout) C12809f.m76831d(this.f10655j, R$id.no_data_layout);
        this.f10647b = (RecyclerView) C12809f.m76831d(this.f10655j, R$id.share_albums_grid);
        this.f10648c = (ImageView) C12809f.m76831d(this.f10655j, R$id.album_share_tab_create);
        this.f10651f = (TextView) C12809f.m76831d(this.f10655j, R$id.album_manager_share_tips_text_albums);
        this.f10652g = (TextView) C12809f.m76831d(this.f10655j, R$id.album_manager_share_tips_text_pic_video);
        this.f10648c.setOnClickListener(new ViewOnClickListenerC2253g(this));
        ((Button) C12809f.m76831d(this.f10655j, R$id.share_invite_button)).setOnClickListener(new ViewOnClickListenerC2253g(this));
        ((TextView) C12809f.m76831d(this.f10655j, R$id.jion_with_invite_code)).setOnClickListener(new ViewOnClickListenerC2253g(this));
        m13983h();
    }

    /* renamed from: f */
    public void m13981f() {
        m13979d();
    }

    /* renamed from: g */
    public void m13982g(List<C11415a> list, int i10) {
        if (list == null || list.size() == 0) {
            this.f10650e.setVisibility(0);
            this.f10647b.setVisibility(8);
            this.f10649d.setVisibility(8);
            this.f10648c.setVisibility(8);
            return;
        }
        this.f10650e.setVisibility(8);
        this.f10647b.setVisibility(0);
        this.f10649d.setVisibility(0);
        this.f10648c.setVisibility(0);
        this.f10653h.clear();
        this.f10653h.addAll(list);
        this.f10654i.m5213j();
        m13984i(list, i10);
    }

    /* renamed from: h */
    public final void m13983h() {
        if (this.f10647b != null) {
            int iM13320a = m13320a(0);
            this.f10647b.setLayoutManager(new GridLayoutManager(this.f9944a, iM13320a));
            C2251e c2251e = new C2251e(this.f9944a, this, iM13320a);
            this.f10654i = c2251e;
            this.f10647b.setAdapter(c2251e);
            this.f10654i.m5213j();
        }
    }

    /* renamed from: i */
    public final void m13984i(List<C11415a> list, int i10) {
        TextView textView = this.f10651f;
        if (textView != null) {
            textView.setText(this.f9944a.getResources().getQuantityString(R$plurals.tab_album_num, list.size(), Integer.valueOf(list.size())));
        }
        TextView textView2 = this.f10652g;
        if (textView2 != null) {
            textView2.setText(this.f9944a.getResources().getQuantityString(R$plurals.pic_and_video_num, i10, Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        m13983h();
    }
}
