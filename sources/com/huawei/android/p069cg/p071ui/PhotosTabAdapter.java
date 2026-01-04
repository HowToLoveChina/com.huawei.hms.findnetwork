package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.PhotosAlbumHomePageActivity;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0224k0;
import p015ak.C0234s;
import p031b7.C1120a;
import p471m6.C11424j;
import p514o9.C11842p;
import p546p6.C12091d;
import p546p6.C12108u;
import p616rk.C12515a;
import p684un.C13224c;
import sk.C12808e;
import sk.C12809f;
import tm.C13040c;

/* loaded from: classes2.dex */
public class PhotosTabAdapter extends RecyclerView.AbstractC0838h<C2347c> {

    /* renamed from: d */
    public List<C11424j> f11204d = new ArrayList();

    /* renamed from: e */
    public Context f11205e;

    /* renamed from: f */
    public int f11206f;

    /* renamed from: com.huawei.android.cg.ui.PhotosTabAdapter$a */
    public class C2345a extends GridLayoutManager.AbstractC0822b {
        public C2345a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.AbstractC0822b
        /* renamed from: f */
        public int mo5102f(int i10) {
            if (PhotosTabAdapter.this.mo749g(i10) == 2) {
                return PhotosTabAdapter.this.m14725H();
            }
            return 1;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.PhotosTabAdapter$b */
    public class ViewOnClickListenerC2346b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C2347c f11208a;

        public ViewOnClickListenerC2346b(C2347c c2347c) {
            this.f11208a = c2347c;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotosTabAdapter.this.m14729L(this.f11208a);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.PhotosTabAdapter$c */
    public class C2347c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public TextView f11210A;

        /* renamed from: B */
        public LinearLayout f11211B;

        /* renamed from: u */
        public LinearLayout f11213u;

        /* renamed from: v */
        public ImageView f11214v;

        /* renamed from: w */
        public ImageView f11215w;

        /* renamed from: x */
        public ImageView f11216x;

        /* renamed from: y */
        public RelativeLayout f11217y;

        /* renamed from: z */
        public TextView f11218z;

        /* renamed from: com.huawei.android.cg.ui.PhotosTabAdapter$c$a */
        public class a implements View.OnClickListener {
            public a() {
            }

            /* renamed from: a */
            public String m14740a(String str) {
                try {
                    return C13040c.m78609F().m78653j() + str;
                } catch (C9721b e10) {
                    C1120a.m6676e("PhotosTabAdapter", "getAlbumFAQUrl() err : " + e10.getMessage());
                    return "";
                }
            }

            /* renamed from: b */
            public void m14741b(String str, String str2) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    C1120a.m6676e("PhotosTabAdapter", "openWebView url or title is null");
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
                    C0209d.m1302r2(intent, "com.huawei.hidisk");
                    intent.putExtra("srcChannel", "0");
                    intent.putExtra("salChannel", "0");
                    intent.putExtra("url", str);
                    intent.putExtra("title", str2);
                    intent.putExtra("isEnableJs", true);
                    intent.putExtra("launch_web_type", -1);
                    intent.putExtra("is_support_orientation", true);
                    intent.putExtra("is_support_dark_mode", true);
                    PhotosTabAdapter.this.f11205e.startActivity(intent);
                } catch (Exception e10) {
                    C1120a.m6676e("PhotosTabAdapter", "openWebView e " + e10.getMessage());
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C0209d.m1226Y0()) {
                    C1120a.m6678w("PhotosTabAdapter", "click too fast");
                    return;
                }
                int id2 = view.getId();
                if (PhotosTabAdapter.this.f11205e == null) {
                    C1120a.m6676e("PhotosTabAdapter", "mContext is null");
                    return;
                }
                if (id2 == R$id.tv_delete_cloud_album_data) {
                    m14741b(m14740a("/weknow/servlet/show/knowContextServlet?knowId=zh-cn00448865"), PhotosTabAdapter.this.f11205e.getString(R$string.delete_cloud_album_data));
                    C13224c.m79487f1().m79593q0("CLICK_DELETE_ALBUM_CLOUD_DATA_FAQ");
                } else if (id2 == R$id.tv_cloud_local_diff) {
                    m14741b(m14740a("/weknow/servlet/show/knowContextServlet?knowId=zh-cn15875891"), PhotosTabAdapter.this.f11205e.getString(R$string.cloud_local_diff));
                    C13224c.m79487f1().m79593q0("CLICK_CLOUD_DATA_DIFF_LOCAL_FAQ");
                } else if (id2 == R$id.tv_delete_data_sync) {
                    m14741b(m14740a("/weknow/servlet/show/knowContextServlet?knowId=zh-cn00724091"), PhotosTabAdapter.this.f11205e.getString(R$string.delete_data_sync));
                    C13224c.m79487f1().m79593q0("CLICK_DELETE_DATA_SYNC_FAQ");
                }
            }

            public /* synthetic */ a(C2347c c2347c, C2345a c2345a) {
                this();
            }
        }

        public C2347c(View view, int i10) {
            super(view);
            if (view == null) {
                C1120a.m6677i("PhotosTabAdapter", "itemView is null");
                return;
            }
            if (i10 == 2) {
                LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(view, R$id.album_faq_container);
                linearLayout.setVisibility(8);
                this.f11211B = linearLayout;
                a aVar = new a(this, null);
                ((TextView) C12809f.m76831d(view, R$id.tv_delete_cloud_album_data)).setOnClickListener(aVar);
                ((TextView) C12809f.m76831d(view, R$id.tv_cloud_local_diff)).setOnClickListener(aVar);
                ((TextView) C12809f.m76831d(view, R$id.tv_delete_data_sync)).setOnClickListener(aVar);
                return;
            }
            this.f11213u = (LinearLayout) C12809f.m76831d(view, R$id.photo_tab_item_container);
            this.f11214v = (ImageView) C12809f.m76831d(view, R$id.album_img);
            this.f11215w = (ImageView) C12809f.m76831d(view, R$id.photos_favorite_icon);
            this.f11218z = (TextView) C12809f.m76831d(view, R$id.album_title);
            this.f11210A = (TextView) C12809f.m76831d(view, R$id.album_num);
            this.f11216x = (ImageView) C12809f.m76831d(view, R$id.album_img_stroke);
            this.f11217y = (RelativeLayout) C12809f.m76831d(view, R$id.album_pic_area);
            if (PhotosTabAdapter.this.f11205e == null || PhotosTabAdapter.this.f11206f <= 0) {
                return;
            }
            ((WindowManager) PhotosTabAdapter.this.f11205e.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(new DisplayMetrics());
            int iM70844o = (int) (((((int) (r3.widthPixels - (C11842p.m70844o(PhotosTabAdapter.this.f11205e, 10) * 2.0f))) / PhotosTabAdapter.this.f11206f) - C12808e.m76823b()) - C11842p.m70844o(PhotosTabAdapter.this.f11205e, 12));
            ViewGroup.LayoutParams layoutParams = this.f11217y.getLayoutParams();
            layoutParams.width = iM70844o;
            layoutParams.height = iM70844o;
            this.f11217y.setLayoutParams(layoutParams);
        }
    }

    public PhotosTabAdapter(Context context) {
        this.f11205e = context;
    }

    /* renamed from: H */
    public final int m14725H() {
        return C11842p.m70753O0(C0213f.m1377a()) ? C11842p.m70771U0() ? 6 : 4 : C11842p.m70771U0() ? 4 : 2;
    }

    /* renamed from: I */
    public List<C11424j> m14726I() {
        return this.f11204d;
    }

    /* renamed from: J */
    public final C11424j m14727J(C2347c c2347c, int i10) {
        C11424j c11424j = this.f11204d.get(i10);
        if (i10 == 0) {
            c2347c.f11218z.setText(R$string.cloud_album_camera);
            c2347c.f11213u.setTag(1);
            c2347c.f11215w.setVisibility(8);
        } else if (i10 == 1) {
            c2347c.f11218z.setText(R$string.cloud_album_video);
            c2347c.f11213u.setTag(2);
            c2347c.f11215w.setVisibility(8);
        } else if (i10 == 2) {
            c2347c.f11218z.setText(R$string.cloud_album_capture_record);
            c2347c.f11213u.setTag(3);
            c2347c.f11215w.setVisibility(8);
        } else if (i10 == 3) {
            c2347c.f11218z.setText(R$string.cloud_album_my_favorites);
            c2347c.f11213u.setTag(4);
            c2347c.f11215w.setVisibility(0);
        } else {
            c2347c.f11218z.setText(c11424j.m68455c());
            c2347c.f11218z.setTag(c11424j.m68454b());
            c2347c.f11213u.setTag(5);
            c2347c.f11215w.setVisibility(8);
        }
        return c11424j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void mo723s(C2347c c2347c, int i10) {
        if (mo749g(i10) != 1) {
            if (c2347c.f11211B != null) {
                String strM1631i = C0234s.m1631i();
                if (C0209d.m1202Q0() && (FeedbackConst.SDK.EMUI_LANGUAGE.equals(strM1631i) || HNConstants.Language.CN_STANDARD.equals(strM1631i))) {
                    c2347c.f11211B.setVisibility(0);
                    return;
                } else {
                    c2347c.f11211B.setVisibility(8);
                    return;
                }
            }
            return;
        }
        if (i10 >= this.f11204d.size()) {
            C1120a.m6676e("PhotosTabAdapter", "onBindViewHolder position >= dataList.size(), position = " + i10);
            return;
        }
        if (c2347c.f11218z == null || c2347c.f11213u == null || c2347c.f11215w == null || c2347c.f11210A == null) {
            C1120a.m6676e("PhotosTabAdapter", "holder.object is null");
            return;
        }
        C11424j c11424jM14727J = m14727J(c2347c, i10);
        c2347c.f11213u.setOnClickListener(new ViewOnClickListenerC2346b(c2347c));
        c2347c.f11210A.setTag(c11424jM14727J.m68454b());
        List<Media> listM68457e = c11424jM14727J.m68457e();
        c2347c.f11210A.setText("");
        m14731N(c2347c, i10, c11424jM14727J, listM68457e);
    }

    /* renamed from: L */
    public final void m14729L(C2347c c2347c) {
        if (C0209d.m1226Y0()) {
            C1120a.m6677i("PhotosTabAdapter", "click too fast.");
            return;
        }
        int iIntValue = ((Integer) c2347c.f11213u.getTag()).intValue();
        Intent intent = new Intent(this.f11205e, (Class<?>) PhotosAlbumHomePageActivity.class);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        String str = (String) c2347c.f11218z.getTag();
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("album_id", str);
        }
        intent.putExtra("album_type", iIntValue);
        intent.putExtra("album_name", c2347c.f11218z.getText());
        C0224k0.m1542L(this.f11205e, intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public C2347c mo724u(ViewGroup viewGroup, int i10) {
        return new C2347c(i10 == 2 ? LayoutInflater.from(this.f11205e).inflate(R$layout.album_manager_photos_faq, viewGroup, false) : LayoutInflater.from(this.f11205e).inflate(R$layout.photo_tab_album_item, viewGroup, false), i10);
    }

    /* renamed from: N */
    public final void m14731N(C2347c c2347c, int i10, C11424j c11424j, List<Media> list) {
        if (list == null) {
            C1120a.m6677i("PhotosTabAdapter", "first,media is null, position = " + i10 + " normalAlbumInfo.getAlbumId() = " + c11424j.m68454b() + " isScrolling");
            c2347c.f11214v.setImageResource(R$color.transparent);
            C12515a.m75110o().m75175e(new C12108u(c11424j, c2347c.f11214v, c2347c.f11210A, c2347c.f11216x), false);
            return;
        }
        C1120a.m6677i("PhotosTabAdapter", "first,media not null, position = " + i10 + " normalAlbumInfo.getAlbumId() = " + c11424j.m68454b());
        if (list.isEmpty()) {
            C1120a.m6677i("PhotosTabAdapter", "first,media not null,but media is empty, position = " + i10 + " normalAlbumInfo.getAlbumId() = " + c11424j.m68454b());
            c2347c.f11214v.setImageResource(R$color.transparent);
            int iM68458f = c11424j.m68458f();
            if (iM68458f >= 0) {
                c2347c.f11210A.setText(NumberFormat.getInstance().format(iM68458f));
                return;
            }
            return;
        }
        Media media = list.get(0);
        String localBigThumbPath = media.getLocalBigThumbPath();
        int iM68458f2 = c11424j.m68458f();
        if (iM68458f2 >= 0) {
            c2347c.f11210A.setText(NumberFormat.getInstance().format(iM68458f2));
        }
        if (TextUtils.isEmpty(localBigThumbPath)) {
            c2347c.f11214v.setImageResource(R$color.transparent);
            C1120a.m6677i("PhotosTabAdapter", "first,media not null, position = " + i10 + " normalAlbumInfo.getAlbumId() = " + c11424j.m68454b() + " path is null");
            C12091d.m72280a0().m72298C(media, c2347c.f11214v);
            return;
        }
        Bitmap bitmapM1311u = C0209d.m1311u(localBigThumbPath);
        C1120a.m6677i("PhotosTabAdapter", "first,media not null, position = " + i10 + " normalAlbumInfo.getAlbumId() = " + c11424j.m68454b() + " path = " + localBigThumbPath);
        if (bitmapM1311u != null) {
            c2347c.f11214v.setImageBitmap(bitmapM1311u);
        }
    }

    /* renamed from: O */
    public void m14732O(int i10, List<C11424j> list) {
        this.f11206f = i10;
        if (list != null) {
            this.f11204d.clear();
            this.f11204d.addAll(list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<C11424j> list = this.f11204d;
        int size = list == null ? 0 : list.size();
        return size > 0 ? size + 1 : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return i10 == mo721e() - 1 ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: r */
    public void mo5221r(RecyclerView recyclerView) {
        super.mo5221r(recyclerView);
        RecyclerView.AbstractC0846p layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new C2345a());
            gridLayoutManager.setSpanCount(m14725H());
        }
    }
}
