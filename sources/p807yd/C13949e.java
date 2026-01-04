package p807yd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.LinkedHashMap;
import ne.C11667a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p336he.C10155f;
import p514o9.C11839m;
import p676ud.AbstractC13158e;

/* renamed from: yd.e */
/* loaded from: classes3.dex */
public class C13949e extends AbstractC13158e {

    /* renamed from: b */
    public SyncItemRecyclerAdapter f62560b;

    /* renamed from: c */
    public SyncItemInfo f62561c;

    /* renamed from: d */
    public HwRecyclerView f62562d;

    /* renamed from: e */
    public LinkedHashMap<String, SyncItemInfo> f62563e;

    /* renamed from: yd.e$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C13949e.this.f62560b != null) {
                C13949e.this.f62560b.m25279U(C13949e.this.f62561c);
            }
        }
    }

    public C13949e(SyncItemRecyclerAdapter syncItemRecyclerAdapter, HwRecyclerView hwRecyclerView, LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
        this.f62563e = linkedHashMap;
        if (linkedHashMap == null) {
            this.f62563e = new LinkedHashMap<>();
        }
        if (syncItemRecyclerAdapter != null) {
            this.f62560b = syncItemRecyclerAdapter;
            SyncItemInfo syncItemInfoM25275O = syncItemRecyclerAdapter.m25275O(HNConstants.DataType.MEDIA);
            this.f62561c = syncItemInfoM25275O;
            this.f62561c = m83810v(syncItemInfoM25275O);
            this.f62562d = hwRecyclerView;
        }
    }

    /* renamed from: A */
    public final void m83806A(String str) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62560b;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM25275O = syncItemRecyclerAdapter.m25275O(HNConstants.DataType.MEDIA);
        this.f62561c = syncItemInfoM25275O;
        SyncItemInfo syncItemInfoM83810v = m83810v(syncItemInfoM25275O);
        this.f62561c = syncItemInfoM83810v;
        if (syncItemInfoM83810v != null) {
            syncItemInfoM83810v.setSubTitleText(str);
            this.f62561c.setShowSubTitle(true);
            m83811w();
        }
    }

    /* renamed from: B */
    public final void m83807B(boolean z10) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62560b;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM25275O = syncItemRecyclerAdapter.m25275O(HNConstants.DataType.MEDIA);
        this.f62561c = syncItemInfoM25275O;
        SyncItemInfo syncItemInfoM83810v = m83810v(syncItemInfoM25275O);
        this.f62561c = syncItemInfoM83810v;
        if (syncItemInfoM83810v != null) {
            syncItemInfoM83810v.setShowSubTitle(z10);
            m83811w();
        }
    }

    @Override // p676ud.AbstractC13158e, p676ud.AbstractC13155b
    /* renamed from: a */
    public void mo79141a(Context context, String str) {
        m83814z(context.getString(R$string.cloud_photos_info, str), str);
    }

    @Override // p676ud.AbstractC13158e, p676ud.AbstractC13155b
    /* renamed from: b */
    public void mo79142b(Context context, String str, String str2) {
        m83814z(context.getString(R$string.cloud_pic_and_video_info, str2, str), str);
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: c */
    public boolean mo69536c(Context context) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            return interfaceC9282a.mo58394T(context) == 1;
        }
        C11839m.m70688i("GalleryMainSdkTipHelper", "cloudAlbumRouterImpl is null");
        return false;
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: d */
    public boolean mo69537d() {
        return true;
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: f */
    public void mo69538f() {
        m83812x(true);
    }

    @Override // p676ud.AbstractC13155b
    @SuppressLint({"HandlerLeak"})
    /* renamed from: g */
    public void mo69539g(Context context, long j10) {
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "uploadStatusSuccess context null");
        } else if (j10 != 0) {
            m83809u(context, C11667a.m69662d(context, j10));
        } else {
            m83808t(context);
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: h */
    public void mo69540h(Context context, int i10) {
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showNoNetworkStatus context null");
        } else {
            m83809u(context, 2 == i10 ? context.getString(R$string.sdk_item_no_network_upload_paused) : context.getString(R$string.sdk_item_no_network_sync_paused));
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: i */
    public void mo69541i(Context context) {
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showAsyncFailedStatus context null");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70686d("GalleryMainSdkTipHelper", "showAsyncFailedStatus resources null");
        } else {
            m83809u(context, resources.getString(R$string.sdk_item_update_failed_pause));
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: j */
    public void mo69542j(Context context) {
        if (this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showSdkTipDefaultStatus galleryTips null");
        } else {
            m83808t(context);
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: k */
    public void mo69543k(Context context, int i10) {
        String string;
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showLowBatteryPauseStatus context null");
            return;
        }
        if (2 != i10) {
            string = context.getString(R$string.sdk_item_save_battery_update_paused);
        } else if (mo69536c(context)) {
            m83807B(false);
            return;
        } else {
            m83807B(true);
            string = context.getString(R$string.sdk_item_save_battery_upload_paused);
        }
        m83809u(context, string);
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: l */
    public void mo69544l(Context context) {
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showLowSpaceStatus context null");
            return;
        }
        if (mo69536c(context)) {
            m83807B(false);
            return;
        }
        m83807B(true);
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70686d("GalleryMainSdkTipHelper", "showLowSpaceStatus resources null");
        } else {
            m83809u(context, resources.getString(R$string.sdk_item_no_storage_upload_paused));
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: m */
    public void mo69545m(Context context, int i10) {
        String string;
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showWlanDisconnectedStatus context null");
            return;
        }
        if (2 != i10) {
            string = context.getString(C2783d.m16179s1(R$string.sdk_tip_no_wlan_async_paused, R$string.sdk_tip_no_wifi_async_paused));
        } else if (mo69536c(context)) {
            m83807B(false);
            return;
        } else {
            m83807B(true);
            string = context.getString(C2783d.m16179s1(R$string.sdk_tip_no_wlan_upload_paused, R$string.sdk_tip_no_wifi_upload_paused));
        }
        m83809u(context, string);
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: n */
    public void mo69546n(Context context, int i10) throws Resources.NotFoundException {
        String string;
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showPauseTips context null");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70686d("GalleryMainSdkTipHelper", "showAsyncFailedStatus resources null");
            return;
        }
        if (2 != i10) {
            string = resources.getString(R$string.sdk_item_update_pause);
        } else if (mo69536c(context)) {
            m83807B(false);
            return;
        } else {
            m83807B(true);
            string = resources.getString(R$string.sdk_item_upload_pause);
        }
        m83809u(context, string);
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: o */
    public void mo69547o(Context context, int i10) throws Resources.NotFoundException {
        String string;
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showSdkTipSavePowerTips context null");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70686d("GalleryMainSdkTipHelper", "showSdkTipSavePowerTips resources null");
            return;
        }
        if (2 != i10) {
            string = 1 == i10 ? resources.getString(R$string.sdk_item_save_battery_update_paused) : "";
        } else if (mo69536c(context)) {
            m83807B(false);
            return;
        } else {
            m83807B(true);
            string = resources.getString(R$string.sdk_item_save_battery_upload_paused);
        }
        if (TextUtils.isEmpty(string)) {
            m83807B(false);
        } else {
            m83809u(context, string);
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: p */
    public void mo69548p(Context context) {
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showSyncThumbStatus context null");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70686d("GalleryMainSdkTipHelper", "showSyncThumbStatus resources null");
        } else {
            m83809u(context, resources.getString(R$string.general_append_handling2, context.getString(R$string.sdk_tip_updating)));
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: q */
    public void mo69549q(Context context) {
        if (context == null || this.f62560b == null) {
            C11839m.m70687e("GalleryMainSdkTipHelper", "showSdkTipUploadingStatus context null");
            return;
        }
        if (mo69536c(context)) {
            m83807B(false);
            return;
        }
        m83807B(true);
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70686d("GalleryMainSdkTipHelper", "showSdkTipUploadingStatus resources null");
        } else {
            m83809u(context, resources.getString(R$string.general_append_handling2, context.getString(R$string.sdk_tip_uploading)));
        }
    }

    /* renamed from: t */
    public final void m83808t(Context context) {
        if (!C10155f.m63299w()) {
            C11839m.m70686d("GalleryMainSdkTipHelper", " uploadStatusSuccess isCloudphotoManagerEnable false");
            m83813y(true);
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58460v0(context, "", false, true);
        } else {
            m83813y(true);
        }
    }

    /* renamed from: u */
    public final void m83809u(Context context, String str) {
        if (!C10155f.m63299w()) {
            C11839m.m70686d("GalleryMainSdkTipHelper", " uploadStatusSuccess isCloudphotoManagerEnable false");
            m83806A(str);
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58460v0(context, str, true, true);
        } else {
            m83806A(str);
        }
    }

    /* renamed from: v */
    public final SyncItemInfo m83810v(SyncItemInfo syncItemInfo) {
        if (syncItemInfo != null) {
            return syncItemInfo;
        }
        if (this.f62563e.containsKey(HNConstants.DataType.MEDIA)) {
            return this.f62563e.get(HNConstants.DataType.MEDIA);
        }
        SyncItemInfo syncItemInfo2 = new SyncItemInfo();
        syncItemInfo2.setId(HNConstants.DataType.MEDIA);
        this.f62563e.put(HNConstants.DataType.MEDIA, syncItemInfo2);
        return syncItemInfo2;
    }

    /* renamed from: w */
    public final void m83811w() {
        SyncItemInfo syncItemInfo = this.f62561c;
        if (syncItemInfo != null && !TextUtils.isEmpty(syncItemInfo.getId())) {
            this.f62563e.put(this.f62561c.getId(), this.f62561c);
        }
        this.f62562d.post(new a());
    }

    /* renamed from: x */
    public final void m83812x(boolean z10) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62560b;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM25275O = syncItemRecyclerAdapter.m25275O(HNConstants.DataType.MEDIA);
        this.f62561c = syncItemInfoM25275O;
        SyncItemInfo syncItemInfoM83810v = m83810v(syncItemInfoM25275O);
        this.f62561c = syncItemInfoM83810v;
        if (syncItemInfoM83810v != null) {
            syncItemInfoM83810v.setHideTip(z10);
            m83811w();
        }
    }

    /* renamed from: y */
    public final void m83813y(boolean z10) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62560b;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM25275O = syncItemRecyclerAdapter.m25275O(HNConstants.DataType.MEDIA);
        this.f62561c = syncItemInfoM25275O;
        SyncItemInfo syncItemInfoM83810v = m83810v(syncItemInfoM25275O);
        this.f62561c = syncItemInfoM83810v;
        if (syncItemInfoM83810v != null) {
            syncItemInfoM83810v.setNoSubTitle(z10);
            m83811w();
        }
    }

    /* renamed from: z */
    public final void m83814z(String str, String str2) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62560b;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM25275O = syncItemRecyclerAdapter.m25275O(HNConstants.DataType.MEDIA);
        this.f62561c = syncItemInfoM25275O;
        SyncItemInfo syncItemInfoM83810v = m83810v(syncItemInfoM25275O);
        this.f62561c = syncItemInfoM83810v;
        if (syncItemInfoM83810v != null) {
            syncItemInfoM83810v.setSubTitleSpanClickText(str);
            this.f62561c.setLinkClickText(str2);
            m83811w();
        }
    }
}
