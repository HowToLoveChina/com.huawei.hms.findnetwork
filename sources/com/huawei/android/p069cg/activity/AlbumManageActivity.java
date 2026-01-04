package com.huawei.android.p069cg.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.AbstractC0735a0;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$menu;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.dialog.ShareAlbumGuideDialog;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwsubtab.widget.HwSubTab;
import com.huawei.uikit.hwsubtab.widget.HwSubTabListener;
import com.huawei.uikit.phone.hwsubtab.widget.HwSubTabWidget;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p496nn.C11737b;
import p496nn.InterfaceC11736a;
import p514o9.C11839m;
import p514o9.C11842p;
import p546p6.C12091d;
import p604r7.C12473f;
import p664u0.C13108a;
import p684un.C13224c;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class AlbumManageActivity extends UIActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener, HwSubTabListener {

    /* renamed from: E */
    public static long f9921E;

    /* renamed from: A */
    public AlbumShareReceiver f9922A;

    /* renamed from: B */
    public PhotosTabReceiver f9923B;

    /* renamed from: C */
    public ShareAlbumGuideDialog f9924C;

    /* renamed from: p */
    public RelativeLayout f9926p;

    /* renamed from: q */
    public PicTabPresenter f9927q;

    /* renamed from: r */
    public PhotosTabPresenter f9928r;

    /* renamed from: s */
    public ShareTabPresenter f9929s;

    /* renamed from: t */
    public ViewPager f9930t;

    /* renamed from: u */
    public C2173b f9931u;

    /* renamed from: v */
    public HwSubTabWidget f9932v;

    /* renamed from: x */
    public NotchTopFitRelativeLayout f9934x;

    /* renamed from: y */
    public NotchFitRelativeLayout f9935y;

    /* renamed from: z */
    public PopupMenu f9936z;

    /* renamed from: w */
    public List<AlbumManagerBasePresenter> f9933w = new ArrayList();

    /* renamed from: D */
    public InterfaceC11736a f9925D = new C2172a();

    public class AlbumShareReceiver extends BroadcastReceiver {
        public AlbumShareReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6678w("AlbumManageActivity", "intent is null.");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if ("com.huawei.hicloud.getPicTabList".equals(action)) {
                AlbumManageActivity.this.f9927q.m13662C();
                return;
            }
            if ("com.huawei.hicloud.getCloudPhotoTotalSize".equals(action)) {
                AlbumManageActivity.this.f9927q.m13663D(safeIntent);
                return;
            }
            if ("com.huawei.hicloud.refresh.share.album".equals(action)) {
                C1120a.m6677i("AlbumManageActivity", "ACTION_REFRESH_SHARE_ALBUM");
                if (AlbumManageActivity.this.f9929s == null || !CloudAlbumSettings.m14363h().m14383s()) {
                    return;
                }
                AlbumManageActivity.this.f9929s.m13979d();
                return;
            }
            if ("com.huawei.hicloud.getShareAlbumList".equals(action)) {
                AlbumManageActivity.this.f9929s.m13982g(C12091d.m72280a0().m72387t0(), safeIntent.getIntExtra("param_share_count_all", 0));
            } else if ("com.huawei.hicloud.fullMediaDataRefresh".equals(action)) {
                AlbumManageActivity.this.f9927q.m13665F();
            }
        }
    }

    public class PhotosTabReceiver extends BroadcastReceiver {
        public PhotosTabReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6678w("AlbumManageActivity", "intent is null.");
            } else if ("com.huawei.hicloud.getPhotoTabList".equals(new SafeIntent(intent).getAction())) {
                AlbumManageActivity.this.f9928r.m13645j();
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AlbumManageActivity$a */
    public class C2172a implements InterfaceC11736a {
        public C2172a() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: a */
        public void mo13316a() {
            C1120a.m6677i("AlbumManageActivity", "onAlbumChanged");
            AlbumManageActivity.this.m13303U1();
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: b */
        public void mo13317b() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: c */
        public void mo13318c() {
            boolean z10;
            C1120a.m6677i("AlbumManageActivity", "onMediaChanged");
            boolean zM74867d = C12473f.m74865c().m74867d();
            if (C12091d.m72280a0().m72378q0() > 100000) {
                C1120a.m6677i("AlbumManageActivity", "not need initPic in AlbumClientObserver");
                z10 = false;
            } else {
                z10 = true;
            }
            if (AlbumManageActivity.this.f9927q != null && (z10 || zM74867d)) {
                AlbumManageActivity.this.f9927q.m13680u();
                AlbumManageActivity.this.f9927q.m13664E();
            }
            if (AlbumManageActivity.this.f9928r != null && (zM74867d || !AlbumManageActivity.this.m13307a2())) {
                C1120a.m6677i("AlbumManageActivity", "onMediaChanged photosTabPresenter.initItems()");
                AlbumManageActivity.this.f9928r.m13641e();
            }
            if (AlbumManageActivity.this.f9929s == null || !CloudAlbumSettings.m14363h().m14383s()) {
                return;
            }
            AlbumManageActivity.this.f9929s.m13979d();
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: d */
        public void mo13319d() {
            C1120a.m6677i("AlbumManageActivity", "onDownloadSyncCompleted");
            AlbumManageActivity.this.m13303U1();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AlbumManageActivity$b */
    public static class C2173b extends AbstractC0984a {

        /* renamed from: h */
        public List<AlbumManagerBasePresenter> f9940h;

        /* renamed from: i */
        public AlbumManageActivity f9941i;

        public C2173b(AlbumManageActivity albumManageActivity, List<AlbumManagerBasePresenter> list) {
            this.f9941i = albumManageActivity;
            this.f9940h = list;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            if (obj == null || !(obj instanceof AlbumManagerBasePresenter)) {
                return;
            }
            viewGroup.removeView((AlbumManagerBasePresenter) obj);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            List<AlbumManagerBasePresenter> list = this.f9940h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            List<AlbumManagerBasePresenter> list = this.f9940h;
            if (list == null || list.isEmpty()) {
                return new PicTabPresenter(this.f9941i);
            }
            AlbumManagerBasePresenter albumManagerBasePresenter = this.f9940h.get(i10);
            viewGroup.addView(albumManagerBasePresenter);
            return albumManagerBasePresenter;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AlbumManageActivity$c */
    public static class C2174c implements ViewPager.InterfaceC0980i {

        /* renamed from: a */
        public ViewPager f9942a;

        /* renamed from: b */
        public AlbumManageActivity f9943b;

        public C2174c(AlbumManageActivity albumManageActivity, ViewPager viewPager) {
            this.f9942a = viewPager;
            this.f9943b = albumManageActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 2) {
                C11839m.m70688i("AlbumManageActivity", "childcount：" + this.f9942a.getChildCount());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
            this.f9943b.m13312f2(i10, f10);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) throws Resources.NotFoundException {
            C11839m.m70688i("AlbumManageActivity", "onPageSelected：" + i10);
            this.f9943b.m13315i2(i10);
            this.f9943b.m13308b2(i10);
            this.f9943b.m13313g2(i10);
        }
    }

    /* renamed from: V1 */
    private void m13301V1() {
        setContentView(R$layout.gallery_manage);
    }

    /* renamed from: Z1 */
    private void m13302Z1() throws Resources.NotFoundException {
        this.f9930t = (ViewPager) C12809f.m76829b(this, R$id.vp_album_mange);
        C2173b c2173b = new C2173b(this, this.f9933w);
        this.f9931u = c2173b;
        this.f9930t.setAdapter(c2173b);
        this.f9930t.setOffscreenPageLimit(3);
        ViewPager viewPager = this.f9930t;
        viewPager.addOnPageChangeListener(new C2174c(this, viewPager));
        if (CloudAlbumSettings.m14363h().m14382r()) {
            HwSubTab hwSubTabNewSubTab = this.f9932v.newSubTab(getResources().getString(R$string.album_pics));
            hwSubTabNewSubTab.setTag(0);
            hwSubTabNewSubTab.setSubTabListener(this);
            this.f9932v.addSubTab(hwSubTabNewSubTab, false);
            HwSubTab hwSubTabNewSubTab2 = this.f9932v.newSubTab(getResources().getString(R$string.album_albums));
            hwSubTabNewSubTab2.setTag(1);
            hwSubTabNewSubTab2.setSubTabListener(this);
            this.f9932v.addSubTab(hwSubTabNewSubTab2, false);
        }
        if (CloudAlbumSettings.m14363h().m14383s()) {
            HwSubTab hwSubTabNewSubTab3 = this.f9932v.newSubTab(getResources().getString(R$string.non_baby_album_new));
            hwSubTabNewSubTab3.setTag(2);
            hwSubTabNewSubTab3.setSubTabListener(this);
            this.f9932v.addSubTab(hwSubTabNewSubTab3, true);
        }
        this.f9934x = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f9935y = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_all);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.ic_back_hot_space);
        this.f9926p = relativeLayout;
        relativeLayout.setOnClickListener(this);
        ((RelativeLayout) C12809f.m76829b(this, R$id.ic_more_hot_space)).setOnClickListener(this);
        ((TextView) C12809f.m76829b(this, R$id.action_bar_title)).setText(R$string.album_cloud_photos);
        m22368H1();
    }

    /* renamed from: U1 */
    public final void m13303U1() {
        PicTabPresenter picTabPresenter = this.f9927q;
        if (picTabPresenter != null) {
            picTabPresenter.m13680u();
        }
        PhotosTabPresenter photosTabPresenter = this.f9928r;
        if (photosTabPresenter != null) {
            photosTabPresenter.m13641e();
        }
        if (this.f9929s == null || !CloudAlbumSettings.m14363h().m14383s()) {
            return;
        }
        this.f9929s.m13979d();
    }

    /* renamed from: W1 */
    public final void m13304W1() {
        this.f9923B = new PhotosTabReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.getPhotoTabList");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        if (c13108aM78878b != null) {
            c13108aM78878b.m78880c(this.f9923B, intentFilter);
        }
    }

    /* renamed from: X1 */
    public final void m13305X1() {
        this.f9932v = (HwSubTabWidget) C12809f.m76829b(this, R$id.subTab_layout);
        if (CloudAlbumSettings.m14363h().m14382r()) {
            PicTabPresenter picTabPresenter = new PicTabPresenter(this);
            this.f9927q = picTabPresenter;
            this.f9933w.add(picTabPresenter);
            PhotosTabPresenter photosTabPresenter = new PhotosTabPresenter(this);
            this.f9928r = photosTabPresenter;
            this.f9933w.add(photosTabPresenter);
        }
        if (CloudAlbumSettings.m14363h().m14383s()) {
            ShareTabPresenter shareTabPresenter = new ShareTabPresenter(this);
            this.f9929s = shareTabPresenter;
            this.f9933w.add(shareTabPresenter);
        }
    }

    /* renamed from: Y1 */
    public final void m13306Y1() {
        this.f9922A = new AlbumShareReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.getPicTabList");
        intentFilter.addAction("com.huawei.hicloud.getCloudPhotoTotalSize");
        intentFilter.addAction("com.huawei.hicloud.refresh.share.album");
        intentFilter.addAction("com.huawei.hicloud.fullMediaDataRefresh");
        intentFilter.addAction("com.huawei.hicloud.getShareAlbumList");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        if (c13108aM78878b != null) {
            c13108aM78878b.m78880c(this.f9922A, intentFilter);
        }
        m13304W1();
    }

    /* renamed from: a2 */
    public final boolean m13307a2() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f9921E < RippleView.SINGLE_RIPPLE_TIME) {
            return true;
        }
        f9921E = jCurrentTimeMillis;
        return false;
    }

    /* renamed from: b2 */
    public final void m13308b2(int i10) {
        if (i10 == 0) {
            C13224c.m79487f1().m79593q0("CLICK_PICTURE_TAB");
        } else if (i10 == 1) {
            C13224c.m79487f1().m79593q0("CLICK_ALBUM_TAB");
        } else {
            if (i10 != 2) {
                return;
            }
            C13224c.m79487f1().m79593q0("CLICK_SHARE_TAB");
        }
    }

    /* renamed from: c2 */
    public final boolean m13309c2(int i10) {
        boolean zM1354d = C0212e0.m1354d(this, "sp_have_show_cloud_photo", "key_have_show_cloud_photo", false);
        C1120a.m6677i("AlbumManageActivity", "haveShowGuide " + zM1354d);
        boolean z10 = i10 == 0 || i10 == 1;
        C1120a.m6677i("AlbumManageActivity", "isPicOrAlbumTab " + z10);
        return z10 && !zM1354d;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f9934x);
        arrayList.add(this.f9935y);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m13310d2(int i10) throws Resources.NotFoundException {
        if (i10 >= this.f9933w.size()) {
            i10 = this.f9933w.size() - 1;
        }
        this.f9930t.setCurrentItem(i10);
    }

    /* renamed from: e2 */
    public final void m13311e2(View view) {
        C1120a.m6677i("AlbumManageActivity", "setMoreHotSpace");
        PopupMenu popupMenu = new PopupMenu(this, view, 8388613);
        this.f9936z = popupMenu;
        popupMenu.getMenuInflater().inflate(R$menu.album_manage_menu, this.f9936z.getMenu());
        this.f9936z.setOnMenuItemClickListener(this);
        this.f9936z.show();
    }

    /* renamed from: f2 */
    public final void m13312f2(int i10, float f10) {
        this.f9932v.setSubTabScrollingOffsets(i10, f10);
    }

    /* renamed from: g2 */
    public final void m13313g2(int i10) throws Resources.NotFoundException {
        this.f9932v.setSubTabSelected(i10);
    }

    /* renamed from: h2 */
    public final void m13314h2(int i10) {
        if (m13309c2(i10)) {
            C0212e0.m1365o(this, "sp_have_show_cloud_photo", "key_have_show_cloud_photo", true);
            ShareAlbumGuideDialog shareAlbumGuideDialog = new ShareAlbumGuideDialog(this);
            this.f9924C = shareAlbumGuideDialog;
            shareAlbumGuideDialog.showDialog();
        }
    }

    /* renamed from: i2 */
    public final void m13315i2(int i10) {
        int i11 = !CloudAlbumSettings.m14363h().m14383s() ? 2 : 3;
        if (i10 <= -1 || i10 >= i11) {
            i10 = 0;
        }
        m13314h2(i10);
        C12473f.m74865c().m74868e();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        ShareTabPresenter shareTabPresenter;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 306 && i11 == 305) {
            PicTabPresenter picTabPresenter = this.f9927q;
            if (picTabPresenter != null) {
                picTabPresenter.getDeleteRequestCodeRsult();
                return;
            }
            return;
        }
        if ((i10 == 102 || i10 == 101) && i11 == 102 && (shareTabPresenter = this.f9929s) != null) {
            shareTabPresenter.m13979d();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.album_manager_tab_pic) {
            this.f9930t.setCurrentItem(0);
            m13315i2(0);
            return;
        }
        if (id2 == R$id.album_manager_tab_photo) {
            this.f9930t.setCurrentItem(1);
            m13315i2(1);
            return;
        }
        if (id2 == R$id.album_manager_tab_share) {
            this.f9930t.setCurrentItem(2);
            m13315i2(2);
        } else if (id2 == R$id.ic_back_hot_space) {
            finish();
        } else {
            if (id2 != R$id.ic_more_hot_space || C0209d.m1226Y0()) {
                return;
            }
            m13311e2(view);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        PicTabPresenter picTabPresenter = this.f9927q;
        if (picTabPresenter != null) {
            picTabPresenter.m13661B();
        }
        PhotosTabPresenter photosTabPresenter = this.f9928r;
        if (photosTabPresenter != null) {
            photosTabPresenter.onConfigurationChanged(configuration);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        m13306Y1();
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        m13301V1();
        C11737b.m70035b().m70036a(this.f9925D);
        m13305X1();
        m13302Z1();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        int intExtra = hiCloudSafeIntent.getIntExtra("show_tab_id", -1);
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("from_cloud_main_page", false);
        C1120a.m6675d("AlbumManageActivity", "isFromMainPage " + booleanExtra);
        m13315i2(intExtra);
        if (intExtra >= this.f9933w.size()) {
            intExtra = this.f9933w.size() - 1;
        }
        this.f9930t.setCurrentItem(intExtra);
        mo19005p1();
        C11842p.m70889z0(this);
        if (!C0209d.m1208S0(this)) {
            Toast.makeText(this, R$string.album_media_download_network_error, 0).show();
        }
        if (booleanExtra) {
            C0224k0.m1542L(this, new Intent(this, (Class<?>) CreateOrJoinAlbumActivity.class));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11737b.m70035b().m70041g(this.f9925D);
        C13108a.m78878b(this).m78883f(this.f9922A);
        C13108a.m78878b(this).m78883f(this.f9923B);
        C12091d.m72280a0().m72380r();
        C1122c.m6817p();
        ShareAlbumGuideDialog shareAlbumGuideDialog = this.f9924C;
        if (shareAlbumGuideDialog != null) {
            shareAlbumGuideDialog.dismiss();
        }
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R$id.to_setting) {
            C0224k0.m1542L(this, new Intent(this, (Class<?>) MobileDataTipsSettingActivity.class));
            return false;
        }
        if (itemId != R$id.to_gallery_setting) {
            return false;
        }
        startActivity(getPackageManager().getLaunchIntentForPackage(C13843a.m83054F(this)));
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShareTabPresenter shareTabPresenter = this.f9929s;
        if (shareTabPresenter != null) {
            shareTabPresenter.m13981f();
        }
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabListener
    public void onSubTabReselected(HwSubTab hwSubTab, AbstractC0735a0 abstractC0735a0) {
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabListener
    public void onSubTabSelected(HwSubTab hwSubTab, AbstractC0735a0 abstractC0735a0) throws Resources.NotFoundException {
        int iIntValue = ((Integer) hwSubTab.getTag()).intValue();
        C1120a.m6677i("AlbumManageActivity", "currentTab: " + iIntValue);
        m13310d2(iIntValue);
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabListener
    public void onSubTabUnselected(HwSubTab hwSubTab, AbstractC0735a0 abstractC0735a0) {
    }
}
