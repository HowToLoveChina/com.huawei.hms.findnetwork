package com.huawei.android.p069cg.p071ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.R$dimen;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hidisk.common.kvdb.KvDatabaseWrapper;
import fk.C9721b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p009a8.C0069g;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1132m;
import p031b7.C1138s;
import p471m6.C11417c;
import p514o9.C11839m;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class RecyclerMediaArtBlockAdapter extends EmptyLoadRecyclerMediaAdapter {

    /* renamed from: z */
    public Map<Integer, Integer> f11275z;

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$a */
    public static class C2361a extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<ImageView> f11276a;

        /* renamed from: b */
        public WeakReference<Media> f11277b;

        public C2361a(ImageView imageView, Media media) {
            this.f11276a = new WeakReference<>(imageView);
            this.f11277b = new WeakReference<>(media);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Media media = this.f11277b.get();
            ImageView imageView = this.f11276a.get();
            if (media == null || imageView == null) {
                return;
            }
            if (C1122c.m6795j1(media, imageView)) {
                C1120a.m6675d("ThumbLoadTask", "CheckKVDBSuccess, return");
            } else {
                C12091d.m72280a0().m72298C(media, imageView);
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.PIC_TAB_THUMB_UI;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$b */
    public static class C2362b extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<ImageView> f11278a;

        /* renamed from: b */
        public WeakReference<MediaFileBean> f11279b;

        /* renamed from: c */
        public WeakReference<RecyclerMediaAdapter> f11280c;

        public C2362b(ImageView imageView, MediaFileBean mediaFileBean, RecyclerMediaAdapter recyclerMediaAdapter) {
            this.f11278a = new WeakReference<>(imageView);
            this.f11279b = new WeakReference<>(mediaFileBean);
            this.f11280c = new WeakReference<>(recyclerMediaAdapter);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            MediaFileBean mediaFileBean = this.f11279b.get();
            ImageView imageView = this.f11278a.get();
            RecyclerMediaAdapter recyclerMediaAdapter = this.f11280c.get();
            if (mediaFileBean == null || imageView == null || recyclerMediaAdapter == null) {
                return;
            }
            RecyclerMediaArtBlockAdapter.m14807d1(mediaFileBean.m14344o(), mediaFileBean, imageView, recyclerMediaAdapter);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.PIC_TAB_THUMB_UI;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$c */
    public static class C2363c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public View f11281u;

        public C2363c(View view) {
            super(view);
            this.f11281u = C12809f.m76831d(view, R$id.images_thumbs_background);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$d */
    public static class C2364d {

        /* renamed from: a */
        public MediaFileBean f11282a;

        /* renamed from: b */
        public int f11283b;

        /* renamed from: c */
        public MediaFileBean m14837c() {
            return this.f11282a;
        }

        /* renamed from: d */
        public int m14838d() {
            return this.f11283b;
        }

        /* renamed from: e */
        public void m14839e(MediaFileBean mediaFileBean) {
            this.f11282a = mediaFileBean;
        }

        /* renamed from: f */
        public void m14840f(int i10) {
            this.f11283b = i10;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$e */
    public static class C2365e extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public View f11284u;

        /* renamed from: v */
        public View f11285v;

        public C2365e(View view) {
            super(view);
            this.f11284u = C12809f.m76831d(view, R$id.double_left_thumb);
            this.f11285v = C12809f.m76831d(view, R$id.double_right_thumb);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$f */
    public static class C2366f {

        /* renamed from: a */
        public MediaFileBean f11286a;

        /* renamed from: b */
        public MediaFileBean f11287b;

        /* renamed from: c */
        public int f11288c;

        /* renamed from: d */
        public MediaFileBean m14844d() {
            return this.f11286a;
        }

        /* renamed from: e */
        public MediaFileBean m14845e() {
            return this.f11287b;
        }

        /* renamed from: f */
        public int m14846f() {
            return this.f11288c;
        }

        /* renamed from: g */
        public void m14847g(MediaFileBean mediaFileBean) {
            this.f11286a = mediaFileBean;
        }

        /* renamed from: h */
        public void m14848h(MediaFileBean mediaFileBean) {
            this.f11287b = mediaFileBean;
        }

        /* renamed from: i */
        public void m14849i(int i10) {
            this.f11288c = i10;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$g */
    public static class C2367g extends C2373m {
        public C2367g(View view) {
            super(view);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$h */
    public static class C2368h extends C2374n {
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$i */
    public static class C2369i extends C2373m {
        public C2369i(View view) {
            super(view);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$j */
    public static class C2370j extends C2374n {
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$k */
    public static class C2371k extends C2373m {
        public C2371k(View view) {
            super(view);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$l */
    public static class C2372l extends C2374n {
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$m */
    public static class C2373m extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public View f11289u;

        /* renamed from: v */
        public View f11290v;

        /* renamed from: w */
        public View f11291w;

        public C2373m(View view) {
            super(view);
            this.f11289u = C12809f.m76831d(view, R$id.three_first_thumb);
            this.f11290v = C12809f.m76831d(view, R$id.three_second_thumb);
            this.f11291w = C12809f.m76831d(view, R$id.three_third_thumb);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaArtBlockAdapter$n */
    public static class C2374n {

        /* renamed from: a */
        public MediaFileBean f11292a;

        /* renamed from: b */
        public MediaFileBean f11293b;

        /* renamed from: c */
        public MediaFileBean f11294c;

        /* renamed from: d */
        public int f11295d;

        /* renamed from: a */
        public MediaFileBean m14850a() {
            return this.f11292a;
        }

        /* renamed from: b */
        public MediaFileBean m14851b() {
            return this.f11293b;
        }

        /* renamed from: c */
        public int m14852c() {
            return this.f11295d;
        }

        /* renamed from: d */
        public MediaFileBean m14853d() {
            return this.f11294c;
        }

        /* renamed from: e */
        public void m14854e(MediaFileBean mediaFileBean) {
            this.f11292a = mediaFileBean;
        }

        /* renamed from: f */
        public void m14855f(MediaFileBean mediaFileBean) {
            this.f11293b = mediaFileBean;
        }

        /* renamed from: g */
        public void m14856g(int i10) {
            this.f11295d = i10;
        }

        /* renamed from: h */
        public void m14857h(MediaFileBean mediaFileBean) {
            this.f11294c = mediaFileBean;
        }
    }

    public RecyclerMediaArtBlockAdapter(Context context) {
        super(context);
        this.f11275z = new HashMap();
    }

    /* renamed from: d1 */
    public static void m14807d1(Media media, MediaFileBean mediaFileBean, ImageView imageView, RecyclerMediaAdapter recyclerMediaAdapter) {
        KvDatabaseWrapper kvDatabaseWrapperM72352f0;
        Bitmap bitmapM6734S0 = null;
        Bitmap bitmapM7184c = (media == null || !media.containsKey("id")) ? null : C1138s.m7181d().m7184c(media.getId());
        if (bitmapM7184c == null && media != null && media.containsKey("id") && (kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0()) != null) {
            bitmapM7184c = kvDatabaseWrapperM72352f0.m30071b(media.getId());
        }
        if (bitmapM7184c == null) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bitMapCache is null, start get thumb");
            if (mediaFileBean.m14338j() == 2) {
                bitmapM6734S0 = RecyclerMediaAdapter.m14747Q(recyclerMediaAdapter.f11221e, mediaFileBean.m14327d());
            } else if (mediaFileBean.m14338j() == 3) {
                bitmapM6734S0 = RecyclerMediaAdapter.m14750V(recyclerMediaAdapter.f11221e, mediaFileBean.m14327d());
            } else if (mediaFileBean.m14338j() == 5 || mediaFileBean.m14338j() == 4) {
                if (recyclerMediaAdapter.f11231o) {
                    C1120a.m6675d("RecyclerMediaArtBlockAdapter", "isScrolling, stop displayCloudPic");
                } else {
                    C1120a.m6675d("RecyclerMediaArtBlockAdapter", "is not Scrolling, displayLCDPhotoThumb");
                    if (mediaFileBean.m14309L() || !mediaFileBean.m14310M()) {
                        String mediaOwnerId = media.getMediaOwnerId();
                        if (TextUtils.isEmpty(mediaOwnerId) || !mediaOwnerId.equals(C13452e.m80781L().m80971t0())) {
                            C1120a.m6676e("RecyclerMediaArtBlockAdapter", "get thumb, ownerUserId is empty");
                        } else {
                            C12091d.m72280a0().m72298C(media, imageView);
                        }
                    } else {
                        C12091d.m72280a0().m72298C(media, imageView);
                    }
                }
            }
        } else {
            C1120a.m6675d("RecyclerMediaArtBlockAdapter", "use bitmap from cache");
            bitmapM6734S0 = bitmapM7184c;
        }
        Object tag = imageView.getTag();
        if ((tag == null || String.valueOf(tag).equals(mediaFileBean.m14306A())) && bitmapM6734S0 != null) {
            if (imageView.getLayoutParams().width > 0 && imageView.getLayoutParams().height > 0) {
                bitmapM6734S0 = C1122c.m6734S0(bitmapM6734S0, imageView.getLayoutParams().width, imageView.getLayoutParams().height);
            }
            ((Activity) imageView.getContext()).runOnUiThread(new C12091d.q0(bitmapM6734S0, imageView));
        }
    }

    @Override // com.huawei.android.p069cg.p071ui.EmptyLoadRecyclerMediaAdapter
    /* renamed from: D0 */
    public boolean mo14690D0(int i10) {
        int iM14852c;
        Object objM14761R = m14761R(i10);
        if (objM14761R instanceof RecyclerMediaAdapter.C2356h) {
            iM14852c = ((RecyclerMediaAdapter.C2356h) objM14761R).m14794c();
        } else if (objM14761R instanceof C2364d) {
            iM14852c = ((C2364d) objM14761R).m14838d();
        } else if (objM14761R instanceof C2366f) {
            iM14852c = ((C2366f) objM14761R).m14846f();
        } else if (objM14761R instanceof C2368h) {
            iM14852c = ((C2368h) objM14761R).m14852c();
        } else if (objM14761R instanceof C2372l) {
            iM14852c = ((C2372l) objM14761R).m14852c();
        } else {
            if (!(objM14761R instanceof C2370j)) {
                return false;
            }
            iM14852c = ((C2370j) objM14761R).m14852c();
        }
        if (this.f11170x) {
            C12091d.m72280a0().m72333U0(this.f11221e, this.f11165s, iM14852c, this.f11166t);
            return true;
        }
        if (this.f11171y) {
            C12091d.m72280a0().m72337W0(this.f11221e, this.f11165s, iM14852c, this.f11166t);
            return true;
        }
        C12091d.m72280a0().m72323P0(this.f11221e, this.f11165s, iM14852c, this.f11166t);
        return true;
    }

    @Override // com.huawei.android.p069cg.p071ui.EmptyLoadRecyclerMediaAdapter
    /* renamed from: M0 */
    public void mo14684M0(int i10, int i11) {
        if (this.f11169w) {
            int i12 = this.f11167u;
            if (i12 == -1 || i10 - i12 > 10) {
                C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindPictureViewHolder for lastStart, position = " + i11 + ", queryMediaDataFromPicTab");
                if (this.f11170x) {
                    C12091d.m72280a0().m72333U0(this.f11221e, this.f11165s, i10, this.f11166t);
                } else if (this.f11171y) {
                    C12091d.m72280a0().m72337W0(this.f11221e, this.f11165s, i10, this.f11166t);
                } else {
                    C12091d.m72280a0().m72323P0(this.f11221e, this.f11165s, i10, this.f11166t);
                }
                this.f11167u = i10;
                this.f11168v = i10 + 10;
                return;
            }
            return;
        }
        int i13 = this.f11168v;
        if (i13 == -1 || i13 - i10 > 10) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindPictureViewHolder for lastEnd, position = " + i11 + ", queryMediaDataFromPicTab");
            if (this.f11170x) {
                C12091d.m72280a0().m72333U0(this.f11221e, this.f11165s, i10, this.f11166t);
            } else if (this.f11171y) {
                C12091d.m72280a0().m72337W0(this.f11221e, this.f11165s, i10, this.f11166t);
            } else {
                C12091d.m72280a0().m72323P0(this.f11221e, this.f11165s, i10, this.f11166t);
            }
            this.f11168v = i10;
            this.f11167u = i10 - 10;
        }
    }

    /* renamed from: N0 */
    public final void m14808N0(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException, IllegalArgumentException {
        Object objM14761R = m14761R(i10);
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindBigThumbViewHolder, position = " + i10);
        C2363c c2363c = (C2363c) abstractC0833c0;
        C2364d c2364d = (C2364d) objM14761R;
        View view = c2363c.f11281u;
        c2363c.f4327a.setOnClickListener(this);
        m14826g1(view, 2);
        ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.file_icon);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.video_duration);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.rel_video);
        mo14684M0(c2364d.f11283b, i10);
        StringBuilder sb2 = new StringBuilder();
        String str = this.f11166t;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        if (this.f11170x) {
            str2 = "share_home_picture";
        } else if (this.f11171y) {
            str2 = "share_home_vedio";
        }
        sb2.append(str2);
        sb2.append(c2364d.f11283b);
        String string = sb2.toString();
        if (C1132m.m6921c().m6924d(string) != null) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindBigThumbViewHolder, position = " + i10 + ", media not null");
            c2364d.m14839e(C1132m.m6921c().m6925e(string));
        }
        MediaFileBean mediaFileBeanM14837c = c2364d.m14837c();
        if (mediaFileBeanM14837c != null) {
            c2363c.f4327a.setTag(Integer.valueOf(c2364d.f11283b));
            mediaFileBeanM14837c.m14347p0(c2364d.f11283b);
            m14822b1(mediaFileBeanM14837c, imageView, textView);
            m14820Z0(view, mediaFileBeanM14837c, i10);
            return;
        }
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindBigThumbViewHolder, position = " + i10 + ", thumbsHolder.imageIcon.setImageDrawable null");
        imageView.setImageDrawable(null);
        relativeLayout.setVisibility(8);
    }

    /* renamed from: O0 */
    public final void m14809O0(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException, IllegalArgumentException {
        Object objM14761R = m14761R(i10);
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindDoubleThumbLeftViewHolder, position = " + i10);
        C2365e c2365e = (C2365e) abstractC0833c0;
        C2366f c2366f = (C2366f) objM14761R;
        View view = c2365e.f11284u;
        view.setOnClickListener(this);
        m14826g1(view, 3);
        ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.file_icon);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.video_duration);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.rel_video);
        mo14684M0(c2366f.f11288c, i10);
        StringBuilder sb2 = new StringBuilder();
        String str = this.f11166t;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        if (this.f11170x) {
            str2 = "share_home_picture";
        } else if (this.f11171y) {
            str2 = "share_home_vedio";
        }
        sb2.append(str2);
        sb2.append(c2366f.f11288c);
        String string = sb2.toString();
        if (C1132m.m6921c().m6924d(string) != null) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindDoubleThumbLeftViewHolder, position = " + i10 + ", media not null");
            c2366f.m14847g(C1132m.m6921c().m6925e(string));
        }
        MediaFileBean mediaFileBeanM14844d = c2366f.m14844d();
        if (mediaFileBeanM14844d != null) {
            c2365e.f11284u.setTag(Integer.valueOf(c2366f.f11288c));
            mediaFileBeanM14844d.m14347p0(c2366f.f11288c);
            m14822b1(mediaFileBeanM14844d, imageView, textView);
            m14820Z0(view, mediaFileBeanM14844d, i10);
            return;
        }
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindDoubleThumbLeftViewHolder, position = " + i10 + ", thumbsHolder.imageIcon.setImageDrawable null");
        imageView.setImageDrawable(null);
        relativeLayout.setVisibility(8);
    }

    /* renamed from: P0 */
    public final void m14810P0(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException, IllegalArgumentException {
        Object objM14761R = m14761R(i10);
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindDoubleThumbRightViewHolder, position = " + i10);
        C2365e c2365e = (C2365e) abstractC0833c0;
        C2366f c2366f = (C2366f) objM14761R;
        View view = c2365e.f11285v;
        view.setOnClickListener(this);
        m14826g1(view, 3);
        ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.file_icon);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.video_duration);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.rel_video);
        mo14684M0(c2366f.f11288c + 1, i10);
        StringBuilder sb2 = new StringBuilder();
        String str = this.f11166t;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        if (this.f11170x) {
            str2 = "share_home_picture";
        } else if (this.f11171y) {
            str2 = "share_home_vedio";
        }
        sb2.append(str2);
        sb2.append(c2366f.f11288c + 1);
        String string = sb2.toString();
        if (C1132m.m6921c().m6924d(string) != null) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindDoubleThumbRightViewHolder, position = " + i10 + ", media not null");
            c2366f.m14848h(C1132m.m6921c().m6925e(string));
        }
        MediaFileBean mediaFileBeanM14845e = c2366f.m14845e();
        if (mediaFileBeanM14845e != null) {
            c2365e.f11285v.setTag(Integer.valueOf(c2366f.f11288c + 1));
            mediaFileBeanM14845e.m14347p0(c2366f.f11288c + 1);
            m14822b1(mediaFileBeanM14845e, imageView, textView);
            m14820Z0(view, mediaFileBeanM14845e, i10);
            return;
        }
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindDoubleThumbRightViewHolder, position = " + i10 + ", thumbsHolder.imageIcon.setImageDrawable null");
        imageView.setImageDrawable(null);
        relativeLayout.setVisibility(8);
    }

    /* renamed from: Q0 */
    public final void m14811Q0(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11) throws Resources.NotFoundException, IllegalArgumentException {
        Object objM14761R = m14761R(i10);
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbFirstViewHolder, position = " + i10);
        C2373m c2373m = (C2373m) abstractC0833c0;
        C2374n c2374n = (C2374n) objM14761R;
        View view = c2373m.f11289u;
        c2373m.f4327a.setOnClickListener(this);
        if (i11 == 5) {
            m14826g1(view, 4);
        } else {
            m14826g1(view, 5);
        }
        ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.file_icon);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.video_duration);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.rel_video);
        mo14684M0(c2374n.f11295d, i10);
        StringBuilder sb2 = new StringBuilder();
        String str = this.f11166t;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        if (this.f11170x) {
            str2 = "share_home_picture";
        } else if (this.f11171y) {
            str2 = "share_home_vedio";
        }
        sb2.append(str2);
        sb2.append(c2374n.f11295d);
        String string = sb2.toString();
        if (C1132m.m6921c().m6924d(string) != null) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbFirstViewHolder, position = " + i10 + ", media not null");
            c2374n.m14854e(C1132m.m6921c().m6925e(string));
        }
        MediaFileBean mediaFileBeanM14850a = c2374n.m14850a();
        if (mediaFileBeanM14850a != null) {
            c2373m.f4327a.setTag(Integer.valueOf(c2374n.f11295d));
            mediaFileBeanM14850a.m14347p0(c2374n.f11295d);
            m14822b1(mediaFileBeanM14850a, imageView, textView);
            m14820Z0(view, mediaFileBeanM14850a, i10);
            return;
        }
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbFirstViewHolder, position = " + i10 + ", thumbsHolder.imageIcon.setImageDrawable null");
        imageView.setImageDrawable(null);
        relativeLayout.setVisibility(8);
    }

    /* renamed from: R0 */
    public final void m14812R0(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException, IllegalArgumentException {
        Object objM14761R = m14761R(i10);
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbSecondViewHolder, position = " + i10);
        C2373m c2373m = (C2373m) abstractC0833c0;
        C2374n c2374n = (C2374n) objM14761R;
        View view = c2373m.f11290v;
        c2373m.f4327a.setOnClickListener(this);
        m14826g1(view, 5);
        ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.file_icon);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.video_duration);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.rel_video);
        mo14684M0(c2374n.f11295d + 1, i10);
        StringBuilder sb2 = new StringBuilder();
        String str = this.f11166t;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        if (this.f11170x) {
            str2 = "share_home_picture";
        } else if (this.f11171y) {
            str2 = "share_home_vedio";
        }
        sb2.append(str2);
        sb2.append(c2374n.f11295d + 1);
        String string = sb2.toString();
        if (C1132m.m6921c().m6924d(string) != null) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbSecondViewHolder, position = " + i10 + ", media not null");
            c2374n.m14855f(C1132m.m6921c().m6925e(string));
        }
        MediaFileBean mediaFileBeanM14851b = c2374n.m14851b();
        if (mediaFileBeanM14851b != null) {
            c2373m.f4327a.setTag(Integer.valueOf(c2374n.f11295d + 1));
            mediaFileBeanM14851b.m14347p0(c2374n.f11295d + 1);
            m14822b1(mediaFileBeanM14851b, imageView, textView);
            m14820Z0(view, mediaFileBeanM14851b, i10);
            return;
        }
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbSecondViewHolder, position = " + i10 + ", thumbsHolder.imageIcon.setImageDrawable null");
        imageView.setImageDrawable(null);
        relativeLayout.setVisibility(8);
    }

    /* renamed from: S0 */
    public final void m14813S0(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11) throws Resources.NotFoundException, IllegalArgumentException {
        Object objM14761R = m14761R(i10);
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbThirdViewHolder, position = " + i10);
        C2373m c2373m = (C2373m) abstractC0833c0;
        C2374n c2374n = (C2374n) objM14761R;
        View view = c2373m.f11291w;
        c2373m.f4327a.setOnClickListener(this);
        if (i11 == 6) {
            m14826g1(view, 4);
        } else {
            m14826g1(view, 5);
        }
        ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.file_icon);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.video_duration);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.rel_video);
        mo14684M0(c2374n.f11295d + 2, i10);
        StringBuilder sb2 = new StringBuilder();
        String str = this.f11166t;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        if (this.f11170x) {
            str2 = "share_home_picture";
        } else if (this.f11171y) {
            str2 = "share_home_vedio";
        }
        sb2.append(str2);
        sb2.append(c2374n.f11295d + 2);
        String string = sb2.toString();
        if (C1132m.m6921c().m6924d(string) != null) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbThirdViewHolder, position = " + i10 + ", media not null");
            c2374n.m14857h(C1132m.m6921c().m6925e(string));
        }
        MediaFileBean mediaFileBeanM14853d = c2374n.m14853d();
        if (mediaFileBeanM14853d != null) {
            c2373m.f4327a.setTag(Integer.valueOf(c2374n.f11295d + 2));
            mediaFileBeanM14853d.m14347p0(c2374n.f11295d + 2);
            m14822b1(mediaFileBeanM14853d, imageView, textView);
            m14820Z0(view, mediaFileBeanM14853d, i10);
            return;
        }
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindThirdThumbThirdViewHolder, position = " + i10 + ", thumbsHolder.imageIcon.setImageDrawable null");
        imageView.setImageDrawable(null);
        relativeLayout.setVisibility(8);
    }

    /* renamed from: T0 */
    public final RecyclerView.AbstractC0833c0 m14814T0(ViewGroup viewGroup) {
        return new C2363c(this.f11220d.inflate(R$layout.recycler_media_thumbs_item, viewGroup, false));
    }

    /* renamed from: U0 */
    public final RecyclerView.AbstractC0833c0 m14815U0(ViewGroup viewGroup) {
        return new C2365e(this.f11220d.inflate(R$layout.recycler_media_double_thumbs_item, viewGroup, false));
    }

    /* renamed from: V0 */
    public final RecyclerView.AbstractC0833c0 m14816V0(ViewGroup viewGroup) {
        return new C2367g(this.f11220d.inflate(R$layout.recycler_media_left_third_thumbs_item, viewGroup, false));
    }

    /* renamed from: W0 */
    public final RecyclerView.AbstractC0833c0 m14817W0(ViewGroup viewGroup) {
        return new C2369i(this.f11220d.inflate(R$layout.recycler_media_normal_third_thumbs_item, viewGroup, false));
    }

    /* renamed from: X0 */
    public final RecyclerView.AbstractC0833c0 m14818X0(ViewGroup viewGroup) {
        return new C2371k(this.f11220d.inflate(R$layout.recycler_media_right_third_thumbs_item, viewGroup, false));
    }

    /* renamed from: Y0 */
    public Map<Integer, Integer> m14819Y0() {
        return this.f11275z;
    }

    /* renamed from: Z0 */
    public final void m14820Z0(View view, MediaFileBean mediaFileBean, int i10) {
        C11417c c11417cM14343n;
        C11839m.m70688i("RecyclerMediaArtBlockAdapter", "initThumbIconByView start, position = " + i10);
        if (mediaFileBean == null || (c11417cM14343n = mediaFileBean.m14343n()) == null) {
            return;
        }
        m14827h1(C12809f.m76831d(view, R$id.grid_mask_view), c11417cM14343n);
        m14831l1(C12809f.m76831d(view, R$id.show_failed_icon), c11417cM14343n);
        m14832m1(C12809f.m76831d(view, R$id.upload_waiting_small_icon), c11417cM14343n);
        m14834o1(C12809f.m76831d(view, R$id.rel_video), c11417cM14343n);
        m14829j1(C12809f.m76831d(view, R$id.show_pause_icon), c11417cM14343n);
        m14830k1(C12809f.m76831d(view, R$id.show_failed_processing_ll), c11417cM14343n);
        m14828i1(C12809f.m76831d(view, R$id.show_failed_illegal_ll), c11417cM14343n);
        m14833n1(C12809f.m76831d(view, R$id.uploading_small_icon), c11417cM14343n);
    }

    /* renamed from: a1 */
    public void m14821a1(List<DayModeGroup> list, int i10, C4644l c4644l) {
        int i11;
        int i12;
        this.f11232p = i10;
        this.f11224h.clear();
        this.f11275z.clear();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (DayModeGroup dayModeGroup : list) {
            RecyclerMediaAdapter.C2358j c2358j = new RecyclerMediaAdapter.C2358j();
            String dayMode = dayModeGroup.getDayMode();
            String strM14689C0 = m14689C0(dayMode);
            String strM14688B0 = m14688B0(dayMode, c4644l);
            c2358j.m14806f(strM14689C0);
            if (m14763X()) {
                c2358j.m14806f(strM14688B0);
                c2358j.m14805e(strM14689C0);
                c2358j.m14804d(true);
            } else {
                c2358j.m14806f(strM14689C0);
            }
            this.f11224h.add(c2358j);
            int i16 = i14 + 1;
            this.f11275z.put(Integer.valueOf(i14), Integer.valueOf(i15));
            int count = dayModeGroup.getCount();
            int i17 = 0;
            int i18 = 0;
            i15++;
            while (i17 < count) {
                if (i17 == 0 || (i12 = count - i17) == 1) {
                    C2364d c2364d = new C2364d();
                    c2364d.m14840f(i13);
                    this.f11224h.add(c2364d);
                    i11 = i16 + 1;
                    this.f11275z.put(Integer.valueOf(i16), Integer.valueOf(i15));
                    i17++;
                    i13++;
                } else {
                    if (i12 == 2) {
                        C2366f c2366f = new C2366f();
                        c2366f.m14849i(i13);
                        this.f11224h.add(c2366f);
                        i17 += 2;
                        i13 += 2;
                        int i19 = i16 + 1;
                        this.f11275z.put(Integer.valueOf(i16), Integer.valueOf(i15));
                        i16 += 2;
                        this.f11275z.put(Integer.valueOf(i19), Integer.valueOf(i15));
                    } else {
                        int i20 = i18 % 4;
                        if (i20 == 0) {
                            C2364d c2364d2 = new C2364d();
                            c2364d2.m14840f(i13);
                            this.f11224h.add(c2364d2);
                            i17++;
                            i13++;
                            i11 = i16 + 1;
                            this.f11275z.put(Integer.valueOf(i16), Integer.valueOf(i15));
                        } else if (i20 == 1) {
                            C2370j c2370j = new C2370j();
                            c2370j.m14856g(i13);
                            this.f11224h.add(c2370j);
                            i17 += 3;
                            i13 += 3;
                            this.f11275z.put(Integer.valueOf(i16), Integer.valueOf(i15));
                            int i21 = i16 + 2;
                            this.f11275z.put(Integer.valueOf(i16 + 1), Integer.valueOf(i15));
                            i16 += 3;
                            this.f11275z.put(Integer.valueOf(i21), Integer.valueOf(i15));
                        } else if (i20 == 2 && (i18 / 4) % 2 == 0) {
                            C2368h c2368h = new C2368h();
                            c2368h.m14856g(i13);
                            this.f11224h.add(c2368h);
                            i17 += 3;
                            i13 += 3;
                            this.f11275z.put(Integer.valueOf(i16), Integer.valueOf(i15));
                            int i22 = i16 + 2;
                            this.f11275z.put(Integer.valueOf(i16 + 1), Integer.valueOf(i15));
                            i16 += 3;
                            this.f11275z.put(Integer.valueOf(i22), Integer.valueOf(i15));
                        } else if (i20 == 2 && (i18 / 4) % 2 != 0) {
                            C2372l c2372l = new C2372l();
                            c2372l.m14856g(i13);
                            this.f11224h.add(c2372l);
                            i17 += 3;
                            i13 += 3;
                            this.f11275z.put(Integer.valueOf(i16), Integer.valueOf(i15));
                            int i23 = i16 + 2;
                            this.f11275z.put(Integer.valueOf(i16 + 1), Integer.valueOf(i15));
                            i16 += 3;
                            this.f11275z.put(Integer.valueOf(i23), Integer.valueOf(i15));
                        } else if (i20 == 3) {
                            C2366f c2366f2 = new C2366f();
                            c2366f2.m14849i(i13);
                            this.f11224h.add(c2366f2);
                            i17 += 2;
                            i13 += 2;
                            int i24 = i16 + 1;
                            this.f11275z.put(Integer.valueOf(i16), Integer.valueOf(i15));
                            i16 += 2;
                            this.f11275z.put(Integer.valueOf(i24), Integer.valueOf(i15));
                        }
                    }
                    i18++;
                    i15++;
                }
                i16 = i11;
                i18++;
                i15++;
            }
            i14 = i16;
        }
        this.f11164r = i13;
        m5213j();
    }

    /* renamed from: b1 */
    public final void m14822b1(MediaFileBean mediaFileBean, ImageView imageView, TextView textView) throws IllegalArgumentException {
        Bitmap bitmapM7184c;
        Media mediaM14352t = mediaFileBean.m14352t();
        Bitmap bitmapM14823c1 = null;
        if (mediaM14352t != null) {
            Object tag = imageView.getTag();
            if (tag != null && String.valueOf(tag).equals(mediaFileBean.m14306A())) {
                C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindPictureViewHolder, tagObj equal");
                return;
            }
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindPictureViewHolder, tagObj not equal");
            imageView.setTag(mediaFileBean.m14306A());
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindPictureViewHolder, realMedia not null");
            if (TextUtils.isEmpty(mediaM14352t.getId())) {
                bitmapM7184c = null;
            } else {
                C1120a.m6677i("RecyclerMediaArtBlockAdapter", "media id ok, get cache with id");
                bitmapM7184c = C1138s.m7181d().m7184c(mediaM14352t.getId());
            }
            if (bitmapM7184c == null && (bitmapM7184c = C1138s.m7181d().m7184c(C0069g.m479y().m480A(mediaM14352t))) != null) {
                imageView.setTag(C0069g.m479y().m480A(mediaM14352t));
            }
            if (bitmapM7184c == null) {
                C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bitMapCache is null");
                imageView.setImageDrawable(null);
            } else {
                imageView.setImageDrawable(new BitmapDrawable(bitmapM7184c));
            }
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "start get LCD");
            bitmapM14823c1 = m14823c1(mediaM14352t, mediaFileBean, imageView);
        } else {
            C1120a.m6676e("RecyclerMediaArtBlockAdapter", "realMedia is null, perhaps native pic");
        }
        if (bitmapM14823c1 != null) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bindPictureViewHolder cache exist, use cache");
            if (mediaM14352t == null || TextUtils.isEmpty(mediaM14352t.getId())) {
                imageView.setTag(Long.valueOf(mediaFileBean.m14327d()));
            } else {
                imageView.setTag(mediaM14352t.getId());
            }
            imageView.setImageDrawable(new BitmapDrawable(bitmapM14823c1));
        }
        if (mediaFileBean.m14338j() == 3 || mediaFileBean.m14338j() == 5) {
            textView.setTag(mediaFileBean.m14333g().toString());
            RecyclerMediaAdapter.m14751g0(mediaFileBean, textView);
        }
    }

    /* renamed from: c1 */
    public Bitmap m14823c1(Media media, MediaFileBean mediaFileBean, ImageView imageView) {
        if (C1122c.m6819p1(C1122c.m6779f1(media))) {
            C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bitMapCache is null, no full Media, start task");
            C12515a.m75110o().m75175e(new C2362b(imageView, mediaFileBean, this), false);
            return null;
        }
        Media mediaM14344o = mediaFileBean.m14344o();
        C1120a.m6677i("RecyclerMediaArtBlockAdapter", "bitMapCache is null, have full Media, start get thumb");
        if (mediaFileBean.m14338j() == 2 || mediaFileBean.m14338j() == 3) {
            C1120a.m6676e("RecyclerMediaArtBlockAdapter", "native pic, error state");
            return null;
        }
        if (mediaFileBean.m14338j() != 5 && mediaFileBean.m14338j() != 4) {
            return null;
        }
        if (this.f11231o) {
            C1120a.m6675d("RecyclerMediaArtBlockAdapter", "isScrolling, stop displayCloudPic");
            return null;
        }
        C1120a.m6675d("RecyclerMediaArtBlockAdapter", "is not Scrolling, displayLCDPhotoThumb");
        if (!mediaFileBean.m14309L() && mediaFileBean.m14310M()) {
            C12515a.m75110o().m75175e(new C2361a(imageView, mediaM14344o), false);
            return null;
        }
        String mediaOwnerId = mediaM14344o.getMediaOwnerId();
        if (TextUtils.isEmpty(mediaOwnerId) || !mediaOwnerId.equals(C13452e.m80781L().m80971t0())) {
            C1120a.m6676e("RecyclerMediaArtBlockAdapter", "get thumb, ownerUserId is empty");
            return null;
        }
        C12515a.m75110o().m75175e(new C2361a(imageView, mediaM14344o), false);
        return null;
    }

    /* renamed from: e1 */
    public void m14824e1(boolean z10) {
        this.f11170x = z10;
    }

    /* renamed from: f1 */
    public void m14825f1(boolean z10) {
        this.f11171y = z10;
    }

    @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter, androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        try {
            Object obj = this.f11224h.get(i10);
            if (obj instanceof C2364d) {
                return 3;
            }
            if (obj instanceof C2366f) {
                return 4;
            }
            if (obj instanceof C2368h) {
                return 5;
            }
            if (obj instanceof C2372l) {
                return 6;
            }
            if (obj instanceof C2370j) {
                return 7;
            }
            return super.mo749g(i10);
        } catch (Exception e10) {
            C1120a.m6676e("RecyclerMediaArtBlockAdapter", "getItemViewType error: " + e10.getMessage());
            return super.mo749g(i10);
        }
    }

    /* renamed from: g1 */
    public final void m14826g1(View view, int i10) throws Resources.NotFoundException {
        float dimensionPixelSize;
        if (this.f11221e == null) {
            this.f11221e = C0213f.m1377a();
        }
        Resources resources = this.f11221e.getResources();
        if (resources == null) {
            return;
        }
        int iM14749U = RecyclerMediaAdapter.m14749U(this.f11221e);
        int i11 = R$dimen.margin_xs;
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i11);
        int i12 = this.f11222f;
        int i13 = (iM14749U - (dimensionPixelSize2 * (i12 - 1))) / i12;
        if (i10 != 2) {
            if (i10 == 3) {
                dimensionPixelSize = (iM14749U - resources.getDimensionPixelSize(i11)) / 2.0f;
            } else if (i10 == 4) {
                iM14749U = (((int) (((iM14749U - (r7 * 2)) * 2.0f) / 3.0f)) + resources.getDimensionPixelSize(i11)) - 1;
            } else if (i10 != 5) {
                iM14749U = i13;
            } else {
                dimensionPixelSize = (iM14749U - (resources.getDimensionPixelSize(i11) * 2)) / 3.0f;
            }
            iM14749U = (int) dimensionPixelSize;
        }
        ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.file_icon);
        View viewM76831d = C12809f.m76831d(view, R$id.grid_mask_view);
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = iM14749U;
            layoutParams.height = iM14749U;
            imageView.setLayoutParams(layoutParams);
        }
        if (viewM76831d != null) {
            ViewGroup.LayoutParams layoutParams2 = viewM76831d.getLayoutParams();
            layoutParams2.width = iM14749U;
            layoutParams2.height = iM14749U;
            viewM76831d.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: h1 */
    public final void m14827h1(View view, C11417c c11417c) {
        if (c11417c.m68392g()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* renamed from: i1 */
    public final void m14828i1(View view, C11417c c11417c) {
        if (c11417c.m68394k()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* renamed from: j1 */
    public final void m14829j1(View view, C11417c c11417c) {
        if (c11417c.m68395l()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* renamed from: k1 */
    public final void m14830k1(View view, C11417c c11417c) {
        if (c11417c.m68396m()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* renamed from: l1 */
    public final void m14831l1(View view, C11417c c11417c) {
        if (c11417c.m68397n()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* renamed from: m1 */
    public final void m14832m1(View view, C11417c c11417c) {
        if (c11417c.m68399p()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* renamed from: n1 */
    public final void m14833n1(View view, C11417c c11417c) {
        if (c11417c.m68400q()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* renamed from: o1 */
    public final void m14834o1(View view, C11417c c11417c) {
        if (c11417c.m68401r()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    @Override // com.huawei.android.p069cg.p071ui.EmptyLoadRecyclerMediaAdapter, com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter, androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        Object objM14761R = m14761R(i10);
        if ((objM14761R instanceof C2364d) && (abstractC0833c0 instanceof C2363c)) {
            m14808N0(abstractC0833c0, i10);
            return;
        }
        if ((objM14761R instanceof C2366f) && (abstractC0833c0 instanceof C2365e)) {
            m14809O0(abstractC0833c0, i10);
            m14810P0(abstractC0833c0, i10);
            return;
        }
        if ((objM14761R instanceof C2368h) && (abstractC0833c0 instanceof C2373m)) {
            m14811Q0(abstractC0833c0, i10, 5);
            m14812R0(abstractC0833c0, i10);
            m14813S0(abstractC0833c0, i10, 5);
        } else if ((objM14761R instanceof C2372l) && (abstractC0833c0 instanceof C2373m)) {
            m14811Q0(abstractC0833c0, i10, 6);
            m14812R0(abstractC0833c0, i10);
            m14813S0(abstractC0833c0, i10, 6);
        } else {
            if (!(objM14761R instanceof C2370j) || !(abstractC0833c0 instanceof C2373m)) {
                super.mo723s(abstractC0833c0, i10);
                return;
            }
            m14811Q0(abstractC0833c0, i10, 7);
            m14812R0(abstractC0833c0, i10);
            m14813S0(abstractC0833c0, i10, 7);
        }
    }

    @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter, androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: t */
    public void mo5222t(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, List<Object> list) throws Resources.NotFoundException, IllegalArgumentException {
        if (list == null || list.isEmpty()) {
            mo723s(abstractC0833c0, i10);
            return;
        }
        Object objM14761R = m14761R(i10);
        if ((abstractC0833c0 instanceof C2363c) && (objM14761R instanceof C2364d)) {
            m14820Z0(((C2363c) abstractC0833c0).f11281u, ((C2364d) objM14761R).f11282a, i10);
            return;
        }
        if ((abstractC0833c0 instanceof C2365e) && (objM14761R instanceof C2366f)) {
            C2365e c2365e = (C2365e) abstractC0833c0;
            C2366f c2366f = (C2366f) objM14761R;
            m14820Z0(c2365e.f11284u, c2366f.f11286a, i10);
            m14820Z0(c2365e.f11285v, c2366f.f11287b, i10);
            return;
        }
        if ((abstractC0833c0 instanceof C2367g) && (objM14761R instanceof C2368h)) {
            C2367g c2367g = (C2367g) abstractC0833c0;
            C2368h c2368h = (C2368h) objM14761R;
            m14820Z0(c2367g.f11289u, c2368h.f11292a, i10);
            m14820Z0(c2367g.f11290v, c2368h.f11293b, i10);
            m14820Z0(c2367g.f11291w, c2368h.f11294c, i10);
            return;
        }
        if ((abstractC0833c0 instanceof C2371k) && (objM14761R instanceof C2372l)) {
            C2371k c2371k = (C2371k) abstractC0833c0;
            C2372l c2372l = (C2372l) objM14761R;
            m14820Z0(c2371k.f11289u, c2372l.f11292a, i10);
            m14820Z0(c2371k.f11290v, c2372l.f11293b, i10);
            m14820Z0(c2371k.f11291w, c2372l.f11294c, i10);
            return;
        }
        if (!(abstractC0833c0 instanceof C2369i) || !(objM14761R instanceof C2370j)) {
            super.mo5222t(abstractC0833c0, i10, list);
            return;
        }
        C2369i c2369i = (C2369i) abstractC0833c0;
        C2370j c2370j = (C2370j) objM14761R;
        m14820Z0(c2369i.f11289u, c2370j.f11292a, i10);
        m14820Z0(c2369i.f11290v, c2370j.f11293b, i10);
        m14820Z0(c2369i.f11291w, c2370j.f11294c, i10);
    }

    @Override // com.huawei.android.p069cg.p071ui.EmptyLoadRecyclerMediaAdapter, com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter, androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        C1120a.m6675d("RecyclerMediaArtBlockAdapter", "onCreateViewHolder");
        return i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 6 ? i10 != 7 ? super.mo724u(viewGroup, i10) : m14817W0(viewGroup) : m14818X0(viewGroup) : m14816V0(viewGroup) : m14815U0(viewGroup) : m14814T0(viewGroup);
    }
}
