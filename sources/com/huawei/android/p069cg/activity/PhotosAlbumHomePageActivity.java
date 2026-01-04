package com.huawei.android.p069cg.activity;

import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.EmptyLoadNormalRecyclerMediaAdapter;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.sync.R$color;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p514o9.C11839m;
import p546p6.C12091d;
import p664u0.C13108a;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class PhotosAlbumHomePageActivity extends UIActivity {

    /* renamed from: B */
    public Handler f10236B;

    /* renamed from: C */
    public GridLayoutManager f10237C;

    /* renamed from: p */
    public EmptyLoadNormalRecyclerMediaAdapter f10239p;

    /* renamed from: q */
    public RecyclerView f10240q;

    /* renamed from: r */
    public LinearLayout f10241r;

    /* renamed from: s */
    public TextView f10242s;

    /* renamed from: t */
    public NotchTopFitRelativeLayout f10243t;

    /* renamed from: u */
    public NotchFitRelativeLayout f10244u;

    /* renamed from: w */
    public String f10246w;

    /* renamed from: y */
    public NormalAlbumPicListBroadcastReceiver f10248y;

    /* renamed from: z */
    public boolean f10249z;

    /* renamed from: v */
    public int f10245v = 0;

    /* renamed from: x */
    public List<MediaFileBean> f10247x = new ArrayList();

    /* renamed from: A */
    public boolean f10235A = true;

    /* renamed from: D */
    public RecyclerMediaAdapter.InterfaceC2353e f10238D = new C2204a();

    public class NormalAlbumPicListBroadcastReceiver extends BroadcastReceiver {
        public NormalAlbumPicListBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6678w("PhotosAlbumHomePageActivity", "intent is null.");
                return;
            }
            String action = new SafeIntent(intent).getAction();
            if ("com.huawei.hicloud.getNormalAlbum.picList".equals(action)) {
                PhotosAlbumHomePageActivity.this.m13632S1();
            } else if ("com.huawei.hicloud.fullMediaDataRefresh".equals(action)) {
                PhotosAlbumHomePageActivity.this.m13633T1(new HiCloudSafeIntent(PhotosAlbumHomePageActivity.this.getIntent()));
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.PhotosAlbumHomePageActivity$a */
    public class C2204a implements RecyclerMediaAdapter.InterfaceC2353e {
        public C2204a() {
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: a */
        public void mo13635a(View view, int i10) {
            if (C0209d.m1226Y0()) {
                C1120a.m6675d("PhotosAlbumHomePageActivity", " do not fast click to show image");
                return;
            }
            Object objM14761R = PhotosAlbumHomePageActivity.this.f10239p.m14761R(i10);
            if (objM14761R instanceof RecyclerMediaAdapter.C2356h) {
                RecyclerMediaAdapter.C2356h c2356h = (RecyclerMediaAdapter.C2356h) objM14761R;
                Intent intent = new Intent(PhotosAlbumHomePageActivity.this, (Class<?>) PicTabAlbumFileViewActivity.class);
                if (c2356h.m14792a() == null) {
                    C1120a.m6676e("PhotosAlbumHomePageActivity", "data not ready");
                    return;
                }
                intent.putExtra("param_media_index", c2356h.m14794c());
                intent.putExtra("param_is_share_cloud_album", false);
                intent.putExtra("param_is_viewer_sum_number", PhotosAlbumHomePageActivity.this.f10239p.m14687A0());
                intent.putExtra("param_album_id", PhotosAlbumHomePageActivity.this.f10246w);
                PhotosAlbumHomePageActivity.this.startActivityForResult(intent, 306);
            }
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: b */
        public void mo13636b(View view, int i10) {
            PhotosAlbumHomePageActivity.this.f10239p.m14758K(PhotosAlbumHomePageActivity.this.f10239p.m14761R(i10));
        }
    }

    /* renamed from: com.huawei.android.cg.activity.PhotosAlbumHomePageActivity$b */
    public class HandlerC2205b extends Handler {
        public HandlerC2205b() {
            super(PhotosAlbumHomePageActivity.this.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException, IllegalArgumentException {
            if (message.what == 1042) {
                int iFindLastVisibleItemPosition = PhotosAlbumHomePageActivity.this.f10237C.findLastVisibleItemPosition();
                for (int iFindFirstVisibleItemPosition = PhotosAlbumHomePageActivity.this.f10237C.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
                    PhotosAlbumHomePageActivity.this.f10239p.mo723s(PhotosAlbumHomePageActivity.this.f10240q.findViewHolderForLayoutPosition(iFindFirstVisibleItemPosition), iFindFirstVisibleItemPosition);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.PhotosAlbumHomePageActivity$c */
    public class C2206c extends RecyclerView.AbstractC0850t {
        public C2206c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0 && !PhotosAlbumHomePageActivity.this.f10240q.canScrollVertically(1) && PhotosAlbumHomePageActivity.this.f10249z) {
                PhotosAlbumHomePageActivity.this.f10242s.setVisibility(0);
            }
        }
    }

    /* renamed from: U1 */
    private void m13629U1() {
        this.f10248y = new NormalAlbumPicListBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.getNormalAlbum.picList");
        intentFilter.addAction("com.huawei.hicloud.fullMediaDataRefresh");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        if (c13108aM78878b != null) {
            c13108aM78878b.m78880c(this.f10248y, intentFilter);
        }
    }

    /* renamed from: V1 */
    private void m13630V1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f10243t = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10244u = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_view);
        this.f10240q = (RecyclerView) C12809f.m76829b(this, R$id.photos_album_recyclerview);
        this.f10241r = (LinearLayout) C12809f.m76829b(this, R$id.has_no_photo_and_video);
        this.f10242s = (TextView) C12809f.m76829b(this, R$id.tv_loading_more);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        this.f10237C = gridLayoutManager;
        this.f10240q.setLayoutManager(gridLayoutManager);
        this.f10240q.addOnScrollListener(new C2206c());
        EmptyLoadNormalRecyclerMediaAdapter emptyLoadNormalRecyclerMediaAdapter = new EmptyLoadNormalRecyclerMediaAdapter(this);
        this.f10239p = emptyLoadNormalRecyclerMediaAdapter;
        emptyLoadNormalRecyclerMediaAdapter.m14775l0(C12091d.m72280a0().m72397x0(this));
        Resources resources = getResources();
        if (resources != null) {
            int color = resources.getColor(R$color.hicloud_hmos_bg);
            C0209d.m1306s2(getActionBar(), this, color);
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(color);
            }
        }
    }

    /* renamed from: W1 */
    private void m13631W1() {
        EmptyLoadNormalRecyclerMediaAdapter emptyLoadNormalRecyclerMediaAdapter = this.f10239p;
        if (emptyLoadNormalRecyclerMediaAdapter != null) {
            emptyLoadNormalRecyclerMediaAdapter.m14772i0(this.f10238D);
            this.f10240q.setAdapter(this.f10239p);
            C12091d.m72280a0().m72312J(this.f10246w);
        }
    }

    /* renamed from: S1 */
    public void m13632S1() {
        C1120a.m6675d("PhotosAlbumHomePageActivity", "handReposeData start");
        List<DayModeGroup> listM72401z0 = C12091d.m72280a0().m72401z0(this.f10246w);
        if (C0212e0.m1354d(C0213f.m1377a(), "sp_pic_tab_info", "key_pic_tab_show_all", true)) {
            this.f10242s.setVisibility(8);
        } else {
            this.f10242s.setVisibility(0);
        }
        if (listM72401z0 == null || listM72401z0.isEmpty()) {
            this.f10240q.setVisibility(8);
            this.f10241r.setVisibility(0);
            return;
        }
        this.f10240q.setVisibility(0);
        this.f10241r.setVisibility(8);
        this.f10239p.m14772i0(this.f10238D);
        this.f10239p.m14699L0(this.f10236B);
        this.f10240q.setAdapter(this.f10239p);
        this.f10239p.m14692E0(listM72401z0, 2);
    }

    /* renamed from: T1 */
    public final void m13633T1(HiCloudSafeIntent hiCloudSafeIntent) {
        int intExtra = hiCloudSafeIntent.getIntExtra("album_type", -1);
        this.f10245v = intExtra;
        if (intExtra == 1) {
            this.f10246w = "album_id_camera";
        } else if (intExtra == 2) {
            this.f10246w = "album_id_video";
        } else if (intExtra == 3) {
            this.f10246w = "album_id_screenshot";
        } else if (intExtra == 4) {
            this.f10246w = "album_id_collection";
        } else if (intExtra == 5) {
            this.f10246w = hiCloudSafeIntent.getStringExtra("album_id");
        }
        this.f10239p.m14696I0(this.f10246w);
        if (this.f10239p.mo721e() == 0) {
            this.f10239p.m14692E0(C12091d.m72280a0().m72401z0(this.f10246w), 2);
        }
        C12091d.m72280a0().m72312J(this.f10246w);
    }

    /* renamed from: X1 */
    public final void m13634X1(HiCloudSafeIntent hiCloudSafeIntent) {
        this.f10245v = hiCloudSafeIntent.getIntExtra("album_type", 0);
        String stringExtra = hiCloudSafeIntent.getStringExtra("album_name");
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70687e("PhotosAlbumHomePageActivity", "onCreate actionBar is null.");
            return;
        }
        int i10 = this.f10245v;
        if (i10 == 1) {
            actionBar.setTitle(R$string.cloud_album_camera);
            return;
        }
        if (i10 == 2) {
            actionBar.setTitle(R$string.cloud_album_video);
            return;
        }
        if (i10 == 3) {
            actionBar.setTitle(R$string.cloud_album_capture_record);
        } else if (i10 != 4) {
            actionBar.setTitle(stringExtra);
        } else {
            actionBar.setTitle(R$string.cloud_album_my_favorites);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10243t);
        arrayList.add(this.f10244u);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        EmptyLoadNormalRecyclerMediaAdapter emptyLoadNormalRecyclerMediaAdapter;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 306 && i11 == 305 && (emptyLoadNormalRecyclerMediaAdapter = this.f10239p) != null) {
            emptyLoadNormalRecyclerMediaAdapter.m14765Z(C1122c.m6736T(this.f10246w), 2);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        this.f10239p.m14775l0(C12091d.m72280a0().m72397x0(this));
        m13631W1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.activity_photos_album_home);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f10236B = new HandlerC2205b();
        m13634X1(hiCloudSafeIntent);
        m13630V1();
        m13629U1();
        m13633T1(hiCloudSafeIntent);
        mo19005p1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C13108a.m78878b(this).m78883f(this.f10248y);
    }
}
