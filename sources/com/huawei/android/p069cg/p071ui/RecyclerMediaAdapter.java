package com.huawei.android.p069cg.p071ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.R$dimen;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.hidisk.common.kvdb.KvDatabaseWrapper;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p009a8.C0069g;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1138s;
import p471m6.C11417c;
import p471m6.C11425k;
import p514o9.C11839m;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class RecyclerMediaAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> implements View.OnClickListener {

    /* renamed from: d */
    public LayoutInflater f11220d;

    /* renamed from: e */
    public Context f11221e;

    /* renamed from: j */
    public GridLayoutManager f11226j;

    /* renamed from: o */
    public boolean f11231o;

    /* renamed from: p */
    public int f11232p;

    /* renamed from: f */
    public int f11222f = 3;

    /* renamed from: g */
    public InterfaceC2353e f11223g = null;

    /* renamed from: h */
    public List f11224h = new ArrayList();

    /* renamed from: i */
    public List<C2354f> f11225i = new ArrayList();

    /* renamed from: k */
    public boolean f11227k = false;

    /* renamed from: l */
    public Map<String, MediaFileBean> f11228l = new HashMap();

    /* renamed from: m */
    public Map<String, Integer> f11229m = new HashMap();

    /* renamed from: n */
    public Map<Integer, MediaFileBean> f11230n = new HashMap();

    /* renamed from: q */
    public boolean f11233q = false;

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$a */
    public class C2349a extends GridLayoutManager.AbstractC0822b {
        public C2349a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.AbstractC0822b
        /* renamed from: f */
        public int mo5102f(int i10) {
            int iMo749g = RecyclerMediaAdapter.this.mo749g(i10);
            if (iMo749g != 1 && iMo749g == 2) {
                return 1;
            }
            return RecyclerMediaAdapter.this.f11222f;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$b */
    public static class C2350b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f11235u;

        public C2350b(View view) {
            super(view);
            m5147I(false);
            this.f11235u = (TextView) C12809f.m76831d(view, R$id.tv_bottom);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$c */
    public static class C2351c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f11236u;

        public C2351c(View view) {
            super(view);
            m5147I(false);
            this.f11236u = (TextView) C12809f.m76831d(view, R$id.tv_tab_photo_desc);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$d */
    public static class C2352d extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<ImageView> f11237a;

        /* renamed from: b */
        public WeakReference<Media> f11238b;

        public C2352d(ImageView imageView, Media media) {
            this.f11237a = new WeakReference<>(imageView);
            this.f11238b = new WeakReference<>(media);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Media media = this.f11238b.get();
            ImageView imageView = this.f11237a.get();
            if (media == null || imageView == null) {
                return;
            }
            if (C1122c.m6795j1(media, imageView)) {
                C1120a.m6675d("ThumbLoadTask", "CheckKVDBSuccess, return");
            } else {
                C12091d.m72280a0().m72304F(media, imageView);
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.PIC_TAB_THUMB_UI;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$e */
    public interface InterfaceC2353e {
        /* renamed from: a */
        void mo13635a(View view, int i10);

        /* renamed from: b */
        void mo13636b(View view, int i10);
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$f */
    public static class C2354f {

        /* renamed from: a */
        public String f11239a;

        public C2354f(String str) {
            this.f11239a = str;
        }

        /* renamed from: a */
        public String m14789a() {
            return this.f11239a;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$g */
    public static class C2355g {

        /* renamed from: a */
        public String f11240a;

        public C2355g(String str) {
            this.f11240a = str;
        }

        /* renamed from: a */
        public String m14790a() {
            return this.f11240a;
        }

        /* renamed from: b */
        public void m14791b(String str) {
            this.f11240a = str;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$h */
    public static class C2356h {

        /* renamed from: a */
        public MediaFileBean f11241a;

        /* renamed from: b */
        public int f11242b;

        /* renamed from: c */
        public int f11243c;

        /* renamed from: d */
        public String f11244d;

        /* renamed from: e */
        public String f11245e;

        /* renamed from: f */
        public int f11246f;

        /* renamed from: a */
        public MediaFileBean m14792a() {
            return this.f11241a;
        }

        /* renamed from: b */
        public String m14793b() {
            return this.f11245e;
        }

        /* renamed from: c */
        public int m14794c() {
            return this.f11243c;
        }

        /* renamed from: d */
        public void m14795d(MediaFileBean mediaFileBean) {
            this.f11241a = mediaFileBean;
        }

        /* renamed from: e */
        public void m14796e(String str) {
            this.f11244d = str;
        }

        /* renamed from: f */
        public void m14797f(String str) {
            this.f11245e = str;
        }

        /* renamed from: g */
        public void m14798g(int i10) {
            this.f11246f = i10;
        }

        /* renamed from: h */
        public void m14799h(int i10) {
            this.f11243c = i10;
        }

        /* renamed from: i */
        public void m14800i(int i10) {
            this.f11242b = i10;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$i */
    public static class C2357i extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public ImageView f11247A;

        /* renamed from: B */
        public LinearLayout f11248B;

        /* renamed from: C */
        public ImageView f11249C;

        /* renamed from: D */
        public ImageView f11250D;

        /* renamed from: E */
        public ProgressBar f11251E;

        /* renamed from: F */
        public View f11252F;

        /* renamed from: G */
        public View f11253G;

        /* renamed from: H */
        public ImageView f11254H;

        /* renamed from: I */
        public ImageView f11255I;

        /* renamed from: J */
        public ImageView f11256J;

        /* renamed from: K */
        public ImageView f11257K;

        /* renamed from: L */
        public ImageView f11258L;

        /* renamed from: M */
        public LinearLayout f11259M;

        /* renamed from: N */
        public LinearLayout f11260N;

        /* renamed from: u */
        public ImageView f11261u;

        /* renamed from: v */
        public ImageView f11262v;

        /* renamed from: w */
        public RelativeLayout f11263w;

        /* renamed from: x */
        public TextView f11264x;

        /* renamed from: y */
        public ImageView f11265y;

        /* renamed from: z */
        public ImageView f11266z;

        public C2357i(View view) {
            super(view);
            this.f11261u = (ImageView) C12809f.m76831d(view, R$id.file_icon);
            this.f11262v = (ImageView) C12809f.m76831d(view, R$id.file_icon_default);
            this.f11263w = (RelativeLayout) C12809f.m76831d(view, R$id.rel_video);
            this.f11264x = (TextView) C12809f.m76831d(view, R$id.video_duration);
            this.f11265y = (ImageView) C12809f.m76831d(view, R$id.delete_icon);
            this.f11266z = (ImageView) C12809f.m76831d(view, R$id.delete_icon_with_background);
            this.f11247A = (ImageView) C12809f.m76831d(view, R$id.upload_success_icon);
            this.f11248B = (LinearLayout) C12809f.m76831d(view, R$id.upload_failed_ll);
            this.f11249C = (ImageView) C12809f.m76831d(view, R$id.upload_waitting_icon);
            this.f11250D = (ImageView) C12809f.m76831d(view, R$id.upload_pause_icon);
            this.f11251E = (ProgressBar) C12809f.m76831d(view, R$id.uploading_progressbar);
            this.f11252F = C12809f.m76831d(view, R$id.grid_mask_view);
            this.f11254H = (ImageView) C12809f.m76831d(view, R$id.favorite_icon);
            this.f11255I = (ImageView) C12809f.m76831d(view, R$id.show_pause_icon);
            this.f11256J = (ImageView) C12809f.m76831d(view, R$id.show_failed_icon);
            this.f11257K = (ImageView) C12809f.m76831d(view, R$id.uploading_small_icon);
            this.f11259M = (LinearLayout) C12809f.m76831d(view, R$id.show_failed_processing_ll);
            this.f11260N = (LinearLayout) C12809f.m76831d(view, R$id.show_failed_illegal_ll);
            this.f11258L = (ImageView) C12809f.m76831d(view, R$id.upload_waiting_small_icon);
            this.f11253G = C12809f.m76831d(view, R$id.upload_mask_view);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$j */
    public static class C2358j {

        /* renamed from: a */
        public String f11267a;

        /* renamed from: b */
        public String f11268b;

        /* renamed from: c */
        public boolean f11269c;

        /* renamed from: a */
        public String m14801a() {
            return this.f11268b;
        }

        /* renamed from: b */
        public String m14802b() {
            return this.f11267a;
        }

        /* renamed from: c */
        public boolean m14803c() {
            return this.f11269c;
        }

        /* renamed from: d */
        public void m14804d(boolean z10) {
            this.f11269c = z10;
        }

        /* renamed from: e */
        public void m14805e(String str) {
            this.f11268b = str;
        }

        /* renamed from: f */
        public void m14806f(String str) {
            this.f11267a = str;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$k */
    public static class C2359k extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f11270u;

        /* renamed from: v */
        public TextView f11271v;

        public C2359k(View view) {
            super(view);
            this.f11270u = (TextView) C12809f.m76831d(view, R$id.type_title);
            this.f11271v = (TextView) C12809f.m76831d(view, R$id.sub_title);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.RecyclerMediaAdapter$l */
    public static class C2360l extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<ImageView> f11272a;

        /* renamed from: b */
        public WeakReference<MediaFileBean> f11273b;

        /* renamed from: c */
        public WeakReference<RecyclerMediaAdapter> f11274c;

        public C2360l(ImageView imageView, MediaFileBean mediaFileBean, RecyclerMediaAdapter recyclerMediaAdapter) {
            this.f11272a = new WeakReference<>(imageView);
            this.f11273b = new WeakReference<>(mediaFileBean);
            this.f11274c = new WeakReference<>(recyclerMediaAdapter);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Media mediaM14352t;
            KvDatabaseWrapper kvDatabaseWrapperM72352f0;
            MediaFileBean mediaFileBean = this.f11273b.get();
            ImageView imageView = this.f11272a.get();
            RecyclerMediaAdapter recyclerMediaAdapter = this.f11274c.get();
            if (mediaFileBean == null || imageView == null || recyclerMediaAdapter == null || (mediaM14352t = mediaFileBean.m14352t()) == null) {
                return;
            }
            Bitmap bitmapM30071b = (TextUtils.isEmpty(mediaM14352t.getId()) || (kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0()) == null) ? null : kvDatabaseWrapperM72352f0.m30071b(mediaM14352t.getId());
            if (bitmapM30071b != null && imageView.getTag().equals(mediaFileBean.m14306A())) {
                if (imageView.getLayoutParams().width > 0 && imageView.getLayoutParams().height > 0) {
                    bitmapM30071b = C1122c.m6734S0(bitmapM30071b, imageView.getLayoutParams().width, imageView.getLayoutParams().height);
                }
                C12091d.q0 q0Var = new C12091d.q0(bitmapM30071b, imageView);
                Context context = imageView.getContext();
                if (context instanceof Activity) {
                    ((Activity) context).runOnUiThread(q0Var);
                    return;
                }
            }
            RecyclerMediaAdapter.m14752h0(mediaFileBean.m14344o(), mediaFileBean, imageView, recyclerMediaAdapter);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.PIC_TAB_THUMB_UI;
        }
    }

    public RecyclerMediaAdapter() {
    }

    /* renamed from: E */
    private void m14743E(C2356h c2356h, RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException, IllegalArgumentException {
        C1120a.m6677i("RecyclerMediaAdapter", "bindPictureViewHolder, position = " + i10);
        C2357i c2357i = (C2357i) abstractC0833c0;
        c2357i.f4327a.setTag(Integer.valueOf(i10));
        c2357i.f11265y.setTag(Integer.valueOf(i10));
        c2357i.f11266z.setTag(Integer.valueOf(i10));
        MediaFileBean mediaFileBeanM14792a = c2356h.m14792a();
        if (mediaFileBeanM14792a != null) {
            mediaFileBeanM14792a.m14347p0(i10);
            this.f11229m.put(mediaFileBeanM14792a.m14306A(), Integer.valueOf(i10));
            int[] iArr = new int[2];
            c2357i.f4327a.getLocationInWindow(iArr);
            mediaFileBeanM14792a.m14341l0(iArr[0]);
            mediaFileBeanM14792a.m14345o0(iArr[1]);
        }
        c2357i.f4327a.setOnClickListener(this);
        c2357i.f11265y.setOnClickListener(this);
        c2357i.f11266z.setOnClickListener(this);
        m14773j0(c2357i);
        Bitmap bitmapM14750V = null;
        if (mediaFileBeanM14792a == null) {
            c2357i.f11261u.setImageDrawable(null);
            return;
        }
        Media mediaM14352t = mediaFileBeanM14792a.m14352t();
        if (mediaM14352t != null) {
            Bitmap bitmapM7184c = C1138s.m7181d().m7184c(C0069g.m479y().m480A(mediaM14352t));
            if (!TextUtils.isEmpty(mediaM14352t.getId()) && bitmapM7184c == null) {
                C1120a.m6677i("RecyclerMediaAdapter", "media id ok, get cache with id");
                bitmapM7184c = C1138s.m7181d().m7184c(mediaM14352t.getId());
            }
            if (bitmapM7184c == null) {
                C1120a.m6677i("RecyclerMediaAdapter", "bitMapCache is null, start get thumb");
                c2357i.f11261u.setImageDrawable(null);
                bitmapM14750V = m14770e0(mediaM14352t, mediaFileBeanM14792a, c2357i.f11261u);
            } else {
                bitmapM14750V = bitmapM7184c;
            }
        } else {
            C1120a.m6676e("RecyclerMediaAdapter", "realMedia is null, perhaps native pic");
            if (mediaFileBeanM14792a.m14338j() == 2) {
                bitmapM14750V = C1122c.m6719N0(m14747Q(this.f11221e, mediaFileBeanM14792a.m14327d()), mediaFileBeanM14792a.m14349r());
            } else if (mediaFileBeanM14792a.m14338j() == 3) {
                bitmapM14750V = m14750V(this.f11221e, mediaFileBeanM14792a.m14327d());
            }
        }
        if (bitmapM14750V != null) {
            C1120a.m6677i("RecyclerMediaAdapter", "bindPictureViewHolder cache exist, use cache");
            if (mediaM14352t == null || TextUtils.isEmpty(mediaM14352t.getId())) {
                c2357i.f11261u.setTag(Long.valueOf(mediaFileBeanM14792a.m14327d()));
            } else {
                c2357i.f11261u.setTag(mediaM14352t.getId());
            }
            c2357i.f11261u.setImageDrawable(new BitmapDrawable(bitmapM14750V));
        }
        if (mediaFileBeanM14792a.m14338j() == 3 || mediaFileBeanM14792a.m14338j() == 5) {
            c2357i.f11264x.setTag(mediaFileBeanM14792a.m14333g().toString());
            m14751g0(mediaFileBeanM14792a, c2357i.f11264x);
        }
        mo14686W(c2356h, c2357i, i10);
    }

    /* renamed from: N */
    public static DisplayMetrics m14744N(Context context) {
        if (context == null) {
            context = C0213f.m1377a();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: O */
    public static String m14745O(long j10) {
        StringBuilder sb2 = new StringBuilder(10);
        if (j10 < 1000) {
            j10 = 1000;
        }
        String elapsedTime = DateUtils.formatElapsedTime(sb2, j10 / 1000);
        C1120a.m6677i("RecyclerMediaAdapter", "getDuration : " + elapsedTime);
        return elapsedTime;
    }

    /* renamed from: P */
    public static String m14746P(String str) throws NumberFormatException {
        long j10;
        if (TextUtils.isEmpty(str)) {
            j10 = 1000;
        } else {
            try {
                j10 = Long.parseLong(str);
            } catch (Exception e10) {
                C1120a.m6676e("RecyclerMediaAdapter", "getDuration exception=: " + e10.toString());
            }
        }
        return m14745O(j10);
    }

    /* renamed from: Q */
    public static Bitmap m14747Q(Context context, long j10) {
        ContentResolver contentResolver = context.getContentResolver();
        if (j10 <= -1) {
            return null;
        }
        try {
            return MediaStore.Images.Thumbnails.getThumbnail(contentResolver, j10, 3, null);
        } catch (Exception e10) {
            C11839m.m70687e("RecyclerMediaAdapter", "getImageThumbnailFromMedia() Exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: T */
    public static List m14748T(List<C11425k> list, int i10, RecyclerMediaAdapter recyclerMediaAdapter) {
        recyclerMediaAdapter.f11232p = i10;
        ArrayList arrayList = new ArrayList();
        for (C11425k c11425k : list) {
            C2358j c2358j = new C2358j();
            c2358j.m14806f(c11425k.m68468d());
            arrayList.add(c2358j);
            int i11 = 0;
            for (MediaFileBean mediaFileBean : c11425k.m68465a()) {
                C2356h c2356h = new C2356h();
                int iM14308K = mediaFileBean.m14308K();
                if (iM14308K == 0) {
                    iM14308K = 1;
                }
                c2356h.m14800i(iM14308K);
                c2356h.m14795d(mediaFileBean);
                arrayList.add(c2356h);
                String strM14306A = mediaFileBean.m14306A();
                recyclerMediaAdapter.f11228l.put(strM14306A, mediaFileBean);
                recyclerMediaAdapter.f11229m.put(strM14306A, Integer.valueOf(i11));
                i11++;
            }
        }
        return arrayList;
    }

    /* renamed from: U */
    public static int m14749U(Context context) {
        return m14744N(context).widthPixels;
    }

    /* renamed from: V */
    public static Bitmap m14750V(Context context, long j10) {
        ContentResolver contentResolver = context.getContentResolver();
        if (j10 <= -1) {
            return null;
        }
        try {
            return MediaStore.Video.Thumbnails.getThumbnail(contentResolver, j10, 1, null);
        } catch (Exception e10) {
            C11839m.m70687e("RecyclerMediaAdapter", "getImageThumbnailFromMedia() Exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: g0 */
    public static void m14751g0(MediaFileBean mediaFileBean, TextView textView) throws IllegalArgumentException {
        if (mediaFileBean.m14325c() != 0) {
            textView.setText(m14745O(mediaFileBean.m14325c()));
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(mediaFileBean.m14333g().toString());
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (strExtractMetadata == null || strExtractMetadata.isEmpty()) {
                return;
            }
            textView.setText(m14746P(strExtractMetadata));
        } catch (Exception e10) {
            C1120a.m6676e("RecyclerMediaAdapter", "setDurationForVideo : " + e10.toString());
        }
    }

    /* renamed from: h0 */
    public static void m14752h0(Media media, MediaFileBean mediaFileBean, ImageView imageView, RecyclerMediaAdapter recyclerMediaAdapter) {
        Bitmap bitmapM14750V = null;
        Bitmap bitmapM7184c = (media == null || !media.containsKey("id")) ? null : C1138s.m7181d().m7184c(media.getId());
        if (bitmapM7184c == null) {
            C1120a.m6677i("RecyclerMediaAdapter", "bitMapCache is null, start get thumb");
            if (mediaFileBean.m14338j() == 2) {
                bitmapM14750V = C1122c.m6719N0(m14747Q(recyclerMediaAdapter.f11221e, mediaFileBean.m14327d()), mediaFileBean.m14349r());
            } else if (mediaFileBean.m14338j() == 3) {
                bitmapM14750V = m14750V(recyclerMediaAdapter.f11221e, mediaFileBean.m14327d());
            } else if (mediaFileBean.m14338j() == 5 || mediaFileBean.m14338j() == 4) {
                if (recyclerMediaAdapter.f11231o) {
                    C1120a.m6675d("RecyclerMediaAdapter", "isScrolling, stop displayCloudPic");
                } else {
                    C1120a.m6675d("RecyclerMediaAdapter", "is not Scrolling, displayPhotoThumb");
                    if (mediaFileBean.m14309L() || !mediaFileBean.m14310M()) {
                        String mediaOwnerId = media.getMediaOwnerId();
                        if (TextUtils.isEmpty(mediaOwnerId) || !mediaOwnerId.equals(C13452e.m80781L().m80971t0())) {
                            C1120a.m6676e("RecyclerMediaAdapter", "get thumb, ownerUserId is empty");
                        } else {
                            C12091d.m72280a0().m72304F(media, imageView);
                        }
                    } else {
                        C12091d.m72280a0().m72304F(media, imageView);
                    }
                }
            }
        } else {
            C1120a.m6675d("RecyclerMediaAdapter", "use bitmap from cache");
            bitmapM14750V = bitmapM7184c;
        }
        if (bitmapM14750V != null) {
            if (media != null) {
                imageView.setTag(media.getId());
            }
            C12091d.q0 q0Var = new C12091d.q0(bitmapM14750V, imageView);
            Activity activityM6730R = C1122c.m6730R(imageView);
            if (activityM6730R != null) {
                activityM6730R.runOnUiThread(q0Var);
            }
        }
    }

    /* renamed from: D */
    public void m14753D(String str) {
        this.f11225i.clear();
        this.f11225i.add(new C2354f(str));
        m5213j();
    }

    /* renamed from: F */
    public void m14754F(C2358j c2358j, RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (c2358j == null) {
            return;
        }
        C2359k c2359k = (C2359k) abstractC0833c0;
        c2359k.f4327a.setTag(Integer.valueOf(i10));
        if (!c2358j.m14803c()) {
            c2359k.f11271v.setVisibility(8);
            c2359k.f11270u.setText(c2358j.m14802b());
        } else {
            c2359k.f11270u.setText(c2358j.m14801a());
            c2359k.f11271v.setText(c2358j.m14802b());
            c2359k.f11271v.setVisibility(0);
        }
    }

    /* renamed from: G */
    public RecyclerView.AbstractC0833c0 m14755G(ViewGroup viewGroup) {
        return new C2350b(this.f11220d.inflate(R$layout.recycler_media_foot_view, viewGroup, false));
    }

    /* renamed from: H */
    public RecyclerView.AbstractC0833c0 m14756H(ViewGroup viewGroup) {
        return new C2351c(this.f11220d.inflate(R$layout.recycler_media_header_view, viewGroup, false));
    }

    /* renamed from: I */
    public RecyclerView.AbstractC0833c0 mo14685I(ViewGroup viewGroup) {
        return new C2357i(this.f11220d.inflate(R$layout.recycler_media_thumbs_item, viewGroup, false));
    }

    /* renamed from: J */
    public RecyclerView.AbstractC0833c0 m14757J(ViewGroup viewGroup) {
        return new C2359k(this.f11220d.inflate(R$layout.recycler_media_title_item, viewGroup, false));
    }

    /* renamed from: K */
    public void m14758K(Object obj) {
        if (obj instanceof C2356h) {
            int iIndexOf = this.f11224h.indexOf(obj);
            int i10 = iIndexOf + 1;
            int i11 = iIndexOf - 1;
            if ((this.f11224h.size() <= i10 || (this.f11224h.get(i10) instanceof C2358j)) && i11 >= 0 && (this.f11224h.get(i11) instanceof C2358j)) {
                this.f11224h.remove((C2358j) this.f11224h.get(i11));
            }
            this.f11224h.remove(obj);
        }
        m5213j();
    }

    /* renamed from: L */
    public Map<Integer, MediaFileBean> m14759L() {
        return this.f11230n;
    }

    /* renamed from: M */
    public List m14760M() {
        return this.f11224h;
    }

    /* renamed from: R */
    public Object m14761R(int i10) {
        if (i10 >= this.f11224h.size() && !this.f11225i.isEmpty()) {
            return this.f11225i.get(0);
        }
        if (this.f11224h.isEmpty()) {
            return null;
        }
        return this.f11224h.get(i10);
    }

    /* renamed from: S */
    public String m14762S(int i10) {
        if (i10 >= 0 && i10 < this.f11224h.size()) {
            Object obj = this.f11224h.get(i10);
            if (obj instanceof C2358j) {
                C2358j c2358j = (C2358j) obj;
                return c2358j.f11269c ? c2358j.m14801a() : c2358j.m14802b();
            }
            if (obj instanceof C2356h) {
                C2356h c2356h = (C2356h) obj;
                return c2356h.m14792a() != null ? c2356h.m14792a().m14355v() : c2356h.m14793b();
            }
        }
        return "";
    }

    /* renamed from: W */
    public void mo14686W(C2356h c2356h, C2357i c2357i, int i10) {
        C11839m.m70688i("RecyclerMediaAdapter", "initThumbsIcon start, position = " + i10);
        MediaFileBean mediaFileBeanM14792a = c2356h.m14792a();
        if (mediaFileBeanM14792a == null) {
            C1120a.m6676e("RecyclerMediaAdapter", "data not ready");
            return;
        }
        C11417c c11417cM14343n = mediaFileBeanM14792a.m14343n();
        if (c11417cM14343n == null) {
            return;
        }
        m14779p0(c2357i, c11417cM14343n);
        m14776m0(c2357i, c11417cM14343n);
        m14777n0(c2357i, c11417cM14343n);
        m14785v0(c2357i, c11417cM14343n);
        m14783t0(c2357i, c11417cM14343n);
        m14786w0(c2357i, c11417cM14343n);
        m14787x0(c2357i, c2356h.m14792a(), c11417cM14343n);
        m14788y0(c2357i, c11417cM14343n);
        m14778o0(c2357i, c11417cM14343n);
        m14781r0(c2357i, c11417cM14343n);
        m14782s0(c2357i, c11417cM14343n);
        m14780q0(c2357i, c11417cM14343n);
        m14784u0(c2357i, c11417cM14343n);
    }

    /* renamed from: X */
    public boolean m14763X() {
        return this.f11233q;
    }

    /* renamed from: Y */
    public boolean m14764Y(int i10) {
        return (i10 >= this.f11224h.size() || this.f11224h.isEmpty() || (this.f11224h.get(i10) instanceof C2358j)) ? false : true;
    }

    /* renamed from: Z */
    public void m14765Z(List<MediaFileBean> list, int i10) {
        this.f11232p = i10;
        this.f11224h.clear();
        for (MediaFileBean mediaFileBean : list) {
            C2356h c2356h = new C2356h();
            int iM14308K = mediaFileBean.m14308K();
            if (iM14308K == 0) {
                iM14308K = 1;
            }
            c2356h.m14800i(iM14308K);
            c2356h.m14795d(mediaFileBean);
            this.f11224h.add(c2356h);
        }
        m5213j();
    }

    /* renamed from: a0 */
    public void m14766a0(List<C11425k> list, int i10) {
        this.f11232p = i10;
        this.f11224h.clear();
        if (4 == i10) {
            this.f11224h.add(new C2355g(""));
        }
        for (C11425k c11425k : list) {
            C2358j c2358j = new C2358j();
            c2358j.m14806f(c11425k.m68468d());
            if (!TextUtils.isEmpty(c11425k.m68467c())) {
                c2358j.m14805e(c11425k.m68467c());
                c2358j.m14804d(true);
            }
            this.f11224h.add(c2358j);
            int i11 = 0;
            for (MediaFileBean mediaFileBean : c11425k.m68465a()) {
                C2356h c2356h = new C2356h();
                int iM14308K = mediaFileBean.m14308K();
                if (iM14308K == 0) {
                    iM14308K = 1;
                }
                c2356h.m14800i(iM14308K);
                c2356h.m14795d(mediaFileBean);
                this.f11224h.add(c2356h);
                String strM14306A = mediaFileBean.m14306A();
                this.f11228l.put(strM14306A, mediaFileBean);
                this.f11229m.put(strM14306A, Integer.valueOf(i11));
                i11++;
            }
        }
        m5213j();
    }

    /* renamed from: b0 */
    public void m14767b0() {
        this.f11225i.clear();
        m5213j();
    }

    /* renamed from: c0 */
    public void m14768c0(boolean z10) {
        this.f11227k = z10;
    }

    /* renamed from: d0 */
    public void m14769d0(boolean z10) {
        this.f11233q = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List list = this.f11224h;
        if (list != null) {
            return list.size() + this.f11225i.size();
        }
        return 0;
    }

    /* renamed from: e0 */
    public Bitmap m14770e0(Media media, MediaFileBean mediaFileBean, ImageView imageView) {
        if (C1122c.m6819p1(C1122c.m6779f1(media))) {
            C1120a.m6677i("RecyclerMediaAdapter", "bitMapCache is null, no full Media, start task");
            C12515a.m75110o().m75175e(new C2360l(imageView, mediaFileBean, this), false);
            return null;
        }
        Media mediaM14344o = mediaFileBean.m14344o();
        C1120a.m6677i("RecyclerMediaAdapter", "bitMapCache is null, have full Media, start get thumb");
        if (mediaFileBean.m14338j() == 2) {
            return C1122c.m6719N0(m14747Q(this.f11221e, mediaFileBean.m14327d()), mediaFileBean.m14349r());
        }
        if (mediaFileBean.m14338j() == 3) {
            return m14750V(this.f11221e, mediaFileBean.m14327d());
        }
        if (mediaFileBean.m14338j() != 5 && mediaFileBean.m14338j() != 4) {
            return null;
        }
        if (this.f11231o) {
            C1120a.m6675d("RecyclerMediaAdapter", "isScrolling, stop displayCloudPic");
            return null;
        }
        C1120a.m6675d("RecyclerMediaAdapter", "is not Scrolling, displayPhotoThumb");
        if (!mediaFileBean.m14309L() && mediaFileBean.m14310M()) {
            C12515a.m75110o().m75175e(new C2352d(imageView, mediaM14344o), false);
            return null;
        }
        String mediaOwnerId = mediaM14344o.getMediaOwnerId();
        if (TextUtils.isEmpty(mediaOwnerId) || !mediaOwnerId.equals(C13452e.m80781L().m80971t0())) {
            C1120a.m6676e("RecyclerMediaAdapter", "get thumb, ownerUserId is empty");
            return null;
        }
        C12515a.m75110o().m75175e(new C2352d(imageView, mediaM14344o), false);
        return null;
    }

    /* renamed from: f0 */
    public void m14771f0(List list) {
        this.f11224h = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        try {
            if (i10 >= this.f11224h.size()) {
                return 8;
            }
            Object obj = this.f11224h.get(i10);
            if (obj instanceof C2358j) {
                return 1;
            }
            if (obj instanceof C2356h) {
                return 2;
            }
            return obj instanceof C2355g ? 9 : 0;
        } catch (Exception e10) {
            C1120a.m6677i("RecyclerMediaAdapter", "getItemViewType error: " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: i0 */
    public void m14772i0(InterfaceC2353e interfaceC2353e) {
        this.f11223g = interfaceC2353e;
    }

    /* renamed from: j0 */
    public void m14773j0(C2357i c2357i) throws Resources.NotFoundException {
        if (this.f11221e == null) {
            this.f11221e = C0213f.m1377a();
        }
        Resources resources = this.f11221e.getResources();
        if (resources == null) {
            return;
        }
        int iM14749U = m14749U(this.f11221e);
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.margin_xs);
        int i10 = this.f11222f;
        int i11 = (iM14749U - (dimensionPixelSize * (i10 - 1))) / i10;
        ImageView imageView = c2357i.f11261u;
        View view = c2357i.f11252F;
        View view2 = c2357i.f11253G;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = i11;
            layoutParams.height = i11;
            imageView.setLayoutParams(layoutParams);
        }
        if (view != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            layoutParams2.width = i11;
            layoutParams2.height = i11;
            view.setLayoutParams(layoutParams2);
        }
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            layoutParams3.width = i11;
            layoutParams3.height = i11;
            view2.setLayoutParams(layoutParams3);
        }
        ImageView imageView2 = c2357i.f11262v;
        if (imageView2 != null) {
            ViewGroup.LayoutParams layoutParams4 = imageView2.getLayoutParams();
            layoutParams4.width = i11;
            layoutParams4.height = i11;
            imageView2.setLayoutParams(layoutParams4);
        }
    }

    /* renamed from: k0 */
    public void m14774k0(boolean z10) {
        this.f11231o = z10;
    }

    /* renamed from: l0 */
    public void m14775l0(int i10) {
        this.f11222f = i10;
    }

    /* renamed from: m0 */
    public final void m14776m0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68390d()) {
            if (this.f11227k) {
                return;
            }
            c2357i.f11265y.setVisibility(0);
        } else {
            if (this.f11227k) {
                return;
            }
            c2357i.f11265y.setVisibility(8);
        }
    }

    /* renamed from: n0 */
    public final void m14777n0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68391f()) {
            c2357i.f11266z.setVisibility(0);
        } else {
            c2357i.f11266z.setVisibility(8);
        }
    }

    /* renamed from: o0 */
    public void m14778o0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68393j()) {
            c2357i.f11254H.setVisibility(0);
        } else {
            c2357i.f11254H.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11223g != null) {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                if (view.getId() == R$id.delete_icon || view.getId() == R$id.delete_icon_with_background) {
                    C1120a.m6677i("RecyclerMediaAdapter", "click delete_icon, tag id = " + tag);
                    this.f11223g.mo13636b(view, ((Integer) tag).intValue());
                    return;
                }
                Integer num = (Integer) tag;
                int i10 = this.f11232p;
                if (i10 == 1) {
                    C11839m.m70688i("RecyclerMediaAdapter", "click thumbs when choosen mode, do nothing");
                    this.f11223g.mo13635a(view, num.intValue());
                    return;
                }
                if (i10 == 2) {
                    C11839m.m70688i("RecyclerMediaAdapter", "click thumbs, tag id = " + tag);
                    this.f11223g.mo13635a(view, num.intValue());
                    return;
                }
                if (i10 == 3) {
                    C11839m.m70688i("RecyclerMediaAdapter", "click thumbs when upload mode, start check item status");
                    this.f11223g.mo13635a(view, num.intValue());
                } else {
                    if (i10 != 4) {
                        return;
                    }
                    C11839m.m70688i("RecyclerMediaAdapter", "click pic tab item, start check item status");
                    this.f11223g.mo13635a(view, num.intValue());
                }
            }
        }
    }

    /* renamed from: p0 */
    public final void m14779p0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68392g()) {
            c2357i.f11252F.setVisibility(0);
        } else {
            c2357i.f11252F.setVisibility(8);
        }
    }

    /* renamed from: q0 */
    public final void m14780q0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68394k()) {
            c2357i.f11260N.setVisibility(0);
        } else {
            c2357i.f11260N.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: r */
    public void mo5221r(RecyclerView recyclerView) {
        super.mo5221r(recyclerView);
        RecyclerView.AbstractC0846p layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.f11226j = gridLayoutManager;
            gridLayoutManager.setSpanSizeLookup(new C2349a());
        }
        this.f11226j.setSpanCount(this.f11222f);
    }

    /* renamed from: r0 */
    public final void m14781r0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68395l()) {
            if (this.f11227k) {
                c2357i.f11255I.setVisibility(0);
                return;
            } else {
                c2357i.f11250D.setVisibility(0);
                return;
            }
        }
        if (this.f11227k) {
            c2357i.f11255I.setVisibility(8);
        } else {
            c2357i.f11250D.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException, IllegalArgumentException {
        Object objM14761R = m14761R(i10);
        if ((objM14761R instanceof C2358j) && (abstractC0833c0 instanceof C2359k)) {
            m14754F((C2358j) objM14761R, abstractC0833c0, i10);
            return;
        }
        if ((objM14761R instanceof C2356h) && (abstractC0833c0 instanceof C2357i)) {
            m14743E((C2356h) objM14761R, abstractC0833c0, i10);
            return;
        }
        if ((objM14761R instanceof C2354f) && (abstractC0833c0 instanceof C2350b)) {
            ((C2350b) abstractC0833c0).f11235u.setText(((C2354f) objM14761R).m14789a());
        } else if ((objM14761R instanceof C2355g) && (abstractC0833c0 instanceof C2351c)) {
            ((C2351c) abstractC0833c0).f11236u.setText(((C2355g) objM14761R).m14790a());
        }
    }

    /* renamed from: s0 */
    public final void m14782s0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68396m()) {
            c2357i.f11259M.setVisibility(0);
        } else {
            c2357i.f11259M.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: t */
    public void mo5222t(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, List<Object> list) throws Resources.NotFoundException, IllegalArgumentException {
        if (list == null || list.isEmpty()) {
            mo723s(abstractC0833c0, i10);
        } else if (abstractC0833c0 instanceof C2357i) {
            Object objM14761R = m14761R(i10);
            if (objM14761R instanceof C2356h) {
                mo14686W((C2356h) objM14761R, (C2357i) abstractC0833c0, i10);
            }
        }
    }

    /* renamed from: t0 */
    public final void m14783t0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68397n()) {
            if (this.f11227k) {
                c2357i.f11256J.setVisibility(0);
                return;
            }
            c2357i.f11248B.setVisibility(0);
            c2357i.f11252F.setVisibility(0);
            c2357i.f11261u.setVisibility(4);
            return;
        }
        if (this.f11227k) {
            c2357i.f11256J.setVisibility(8);
            return;
        }
        c2357i.f11248B.setVisibility(8);
        c2357i.f11252F.setVisibility(8);
        c2357i.f11261u.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        C1120a.m6675d("RecyclerMediaAdapter", "onCreateViewHolder");
        return i10 != 1 ? i10 != 2 ? i10 != 8 ? i10 != 9 ? mo14685I(viewGroup) : m14756H(viewGroup) : m14755G(viewGroup) : mo14685I(viewGroup) : m14757J(viewGroup);
    }

    /* renamed from: u0 */
    public final void m14784u0(C2357i c2357i, C11417c c11417c) {
        if (this.f11227k || !(c11417c.m68399p() || c11417c.m68400q() || c11417c.m68395l())) {
            c2357i.f11253G.setVisibility(8);
        } else {
            c2357i.f11253G.setVisibility(0);
        }
    }

    /* renamed from: v0 */
    public final void m14785v0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68398o()) {
            if (this.f11227k) {
                return;
            }
            c2357i.f11247A.setVisibility(0);
        } else {
            if (this.f11227k) {
                return;
            }
            c2357i.f11247A.setVisibility(8);
        }
    }

    /* renamed from: w0 */
    public final void m14786w0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68399p()) {
            if (this.f11227k) {
                c2357i.f11258L.setVisibility(0);
                return;
            } else {
                c2357i.f11249C.setVisibility(0);
                return;
            }
        }
        if (this.f11227k) {
            c2357i.f11258L.setVisibility(8);
        } else {
            c2357i.f11249C.setVisibility(8);
        }
    }

    /* renamed from: x0 */
    public final void m14787x0(C2357i c2357i, MediaFileBean mediaFileBean, C11417c c11417c) {
        if (!c11417c.m68400q()) {
            if (this.f11227k) {
                c2357i.f11257K.setVisibility(8);
                return;
            } else {
                c2357i.f11251E.setVisibility(8);
                return;
            }
        }
        if (this.f11227k) {
            c2357i.f11257K.setVisibility(0);
        } else {
            c2357i.f11251E.setVisibility(0);
            c2357i.f11251E.setProgress((int) mediaFileBean.m14307I());
        }
    }

    /* renamed from: y0 */
    public void m14788y0(C2357i c2357i, C11417c c11417c) {
        if (c11417c.m68401r()) {
            c2357i.f11263w.setVisibility(0);
        } else {
            c2357i.f11263w.setVisibility(8);
        }
    }

    public RecyclerMediaAdapter(Context context) {
        this.f11221e = context;
        this.f11220d = LayoutInflater.from(context);
    }
}
