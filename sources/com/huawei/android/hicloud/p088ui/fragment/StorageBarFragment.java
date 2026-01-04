package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.TotalStorageInfo;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.HiCloudEndTextLayout;
import com.huawei.android.hicloud.p088ui.uiextend.StorageBar;
import com.huawei.android.hicloud.p088ui.uilistener.CloudSpaceShowDetailsRegionListener;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import p015ak.C0214f0;
import p015ak.C0223k;
import p459lp.C11333k;
import p514o9.C11839m;
import p514o9.C11842p;
import p703v8.C13368e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class StorageBarFragment extends Fragment implements CloudStorageCallback {

    /* renamed from: a */
    public View f18231a;

    /* renamed from: j */
    public ProgressBar f18240j;

    /* renamed from: k */
    public float f18241k;

    /* renamed from: l */
    public float f18242l;

    /* renamed from: m */
    public float f18243m;

    /* renamed from: n */
    public float f18244n;

    /* renamed from: o */
    public long f18245o;

    /* renamed from: p */
    public long f18246p;

    /* renamed from: q */
    public long f18247q;

    /* renamed from: u */
    public ImageView f18251u;

    /* renamed from: w */
    public HiCloudEndTextLayout f18253w;

    /* renamed from: x */
    public Context f18254x;

    /* renamed from: y */
    public HwTextView f18255y;

    /* renamed from: b */
    public HwTextView f18232b = null;

    /* renamed from: c */
    public StorageBar f18233c = null;

    /* renamed from: d */
    public FlexboxLayout f18234d = null;

    /* renamed from: e */
    public TextView f18235e = null;

    /* renamed from: f */
    public RelativeLayout f18236f = null;

    /* renamed from: g */
    public RelativeLayout f18237g = null;

    /* renamed from: h */
    public RelativeLayout f18238h = null;

    /* renamed from: i */
    public RelativeLayout f18239i = null;

    /* renamed from: r */
    public boolean f18248r = false;

    /* renamed from: s */
    public boolean f18249s = false;

    /* renamed from: t */
    public boolean f18250t = false;

    /* renamed from: v */
    public CloudSpaceShowDetailsRegionListener f18252v = null;

    /* renamed from: z */
    public boolean f18256z = false;

    /* renamed from: a */
    private void m24300a() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), "com.huawei.android.ds_spcace_detail_cache", 0);
        sharedPreferencesM1382b.edit().putFloat("cloud_backup_percent_sp_key", this.f18241k).commit();
        sharedPreferencesM1382b.edit().putFloat("gallery_percent_sp_key", this.f18242l).commit();
        sharedPreferencesM1382b.edit().putFloat("cloud_drive_percent_sp_key", this.f18243m).commit();
        sharedPreferencesM1382b.edit().putFloat("app_data_percent_sp_key", this.f18244n).commit();
        sharedPreferencesM1382b.edit().putLong("total_space_sp_key", this.f18245o).commit();
        sharedPreferencesM1382b.edit().putLong("used_space_sp_key", this.f18246p).commit();
        sharedPreferencesM1382b.edit().putLong("available_space_sp_key", this.f18247q).commit();
        sharedPreferencesM1382b.edit().putLong("storage_cache_timestamp", System.currentTimeMillis()).commit();
    }

    /* renamed from: b */
    private void m24301b(long j10, long j11) {
        if (C11333k.m68086b().m68090e(j10)) {
            C11839m.m70688i("StorageBarFragment", "space full, availableSpaceValue=" + j10);
            this.f18233c.showSpaceFull();
            this.f18234d.setVisibility(8);
            this.f18235e.setVisibility(0);
            this.f18235e.setText(getString(R$string.sapce_fill_detail_title));
            return;
        }
        if (j11 != 0) {
            this.f18233c.clearSpaceFull();
            return;
        }
        C11839m.m70688i("StorageBarFragment", "space not used, mUsedSpaceValue=" + j11);
        this.f18234d.setVisibility(8);
        this.f18235e.setVisibility(0);
        this.f18235e.setText(getString(R$string.frag_no_space_use));
        this.f18233c.clearSpaceFull();
    }

    /* renamed from: c */
    private boolean m24302c() {
        return C2783d.m16154k0(C0214f0.m1382b(getContext(), "com.huawei.android.ds_spcace_detail_cache", 0).getLong("storage_cache_timestamp", 0L));
    }

    /* renamed from: e */
    private void m24303e() {
        TotalStorageInfo totalInfo = C13368e.m80184F().m80226P().getTotalInfo();
        if (totalInfo == null) {
            C11839m.m70687e("StorageBarFragment", "refreshUsedTotalSpace totalInfo null");
            m24304d();
            return;
        }
        this.f18247q = totalInfo.getAvailableSize();
        this.f18245o = totalInfo.getTotalSize();
        this.f18246p = totalInfo.getUsedSize();
        String strM1524g = C0223k.m1524g(getContext(), this.f18245o);
        String strM1524g2 = C0223k.m1524g(getContext(), this.f18246p);
        if (TextUtils.isEmpty(strM1524g2) || TextUtils.isEmpty(strM1524g)) {
            C11839m.m70688i("StorageBarFragment", "MSG_GET_CLOUD_SPACE_SUCCESS query storage failed");
            m24304d();
        } else {
            m24305f(getString(R$string.frag_cloud_storage_value, strM1524g2, strM1524g));
            m24301b(this.f18247q, this.f18246p);
        }
    }

    /* renamed from: d */
    public void m24304d() {
        if (!isAdded()) {
            C11839m.m70687e("StorageBarFragment", "onQueryStorageFailed fragment not attached");
            return;
        }
        C11839m.m70688i("StorageBarFragment", "onQueryStorageFailed");
        if (this.f18250t) {
            m24308i();
            return;
        }
        this.f18234d.setVisibility(8);
        this.f18233c.refresh(0.0f, 0.0f, 0.0f, 0.0f);
        this.f18235e.setText(getString(R$string.frag_query_space_failed));
        this.f18235e.setVisibility(0);
    }

    /* renamed from: f */
    public final void m24305f(String str) {
        m24308i();
        this.f18232b.setText(str);
    }

    /* renamed from: g */
    public final void m24306g() {
        if (this.f18255y == null) {
            C11839m.m70687e("StorageBarFragment", "titletext is null");
        } else if ((this.f18254x instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.f18254x)) {
            this.f18255y.setMaxWidth(C11842p.m70770U(this.f18254x) + ((int) C11842p.m70844o(this.f18254x, 40)));
        } else {
            this.f18255y.setMaxWidth(C11842p.m70713B(this.f18254x) + ((int) C11842p.m70844o(this.f18254x, 40)));
        }
    }

    /* renamed from: h */
    public final void m24307h(float f10, float f11, float f12, float f13) {
        if (f10 > 0.0f) {
            this.f18236f.setVisibility(0);
        } else {
            this.f18236f.setVisibility(8);
        }
        if (f12 > 0.0f) {
            this.f18238h.setVisibility(0);
        } else {
            this.f18238h.setVisibility(8);
        }
        if (f11 > 0.0f) {
            this.f18237g.setVisibility(0);
        } else {
            this.f18237g.setVisibility(8);
        }
        if (f13 > 0.0f) {
            this.f18239i.setVisibility(0);
        } else {
            this.f18239i.setVisibility(8);
        }
    }

    /* renamed from: i */
    public final void m24308i() {
        ProgressBar progressBar = this.f18240j;
        if (progressBar == null || this.f18232b == null || this.f18253w == null || this.f18251u == null) {
            C11839m.m70687e("StorageBarFragment", "fragStorageValueFrame mLoadingView or storageText or fragStorageRightArrow is null");
            return;
        }
        progressBar.setVisibility(8);
        this.f18253w.setVisibility(0);
        if (this.f18256z) {
            this.f18251u.setVisibility(0);
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        C11839m.m70688i("StorageBarFragment", "onCreateView");
        C11839m.m70686d("StorageBarFragment", "superview = " + super.onCreateView(layoutInflater, viewGroup, bundle));
        View view = this.f18231a;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18231a);
        }
        View viewInflate = layoutInflater.inflate(R$layout.storage_fragment_layout, viewGroup, false);
        this.f18231a = viewInflate;
        this.f18255y = (HwTextView) C12809f.m76831d(viewInflate, R$id.frag_storage_text_title);
        this.f18232b = (HwTextView) C12809f.m76831d(this.f18231a, R$id.frag_storage_value);
        m24306g();
        StorageBar storageBar = (StorageBar) C12809f.m76831d(this.f18231a, R$id.frag_storage_bar);
        this.f18233c = storageBar;
        storageBar.clearAll();
        this.f18234d = (FlexboxLayout) C12809f.m76831d(this.f18231a, R$id.frag_label_frame);
        this.f18235e = (TextView) C12809f.m76831d(this.f18231a, R$id.frag_storage_tips);
        this.f18236f = (RelativeLayout) C12809f.m76831d(this.f18231a, R$id.cloud_backup_label_frame);
        this.f18237g = (RelativeLayout) C12809f.m76831d(this.f18231a, R$id.cloud_gallery_label_frame);
        this.f18238h = (RelativeLayout) C12809f.m76831d(this.f18231a, R$id.cloud_favorite_label_frame);
        this.f18239i = (RelativeLayout) C12809f.m76831d(this.f18231a, R$id.cloud_app_label_frame);
        this.f18240j = (ProgressBar) C12809f.m76831d(this.f18231a, R$id.frag_storage_value_loading_progress);
        this.f18253w = (HiCloudEndTextLayout) C12809f.m76831d(this.f18231a, R$id.frag_storage_value_frame);
        this.f18251u = (ImageView) C12809f.m76831d(this.f18231a, R$id.frag_storage_right_arrow);
        this.f18235e.setVisibility(0);
        if (!this.f18248r || m24302c()) {
            this.f18235e.setText(getString(R$string.frag_quering_space));
        }
        return this.f18231a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StorageBar storageBar = this.f18233c;
        if (storageBar != null) {
            storageBar.clearAll();
        }
    }

    @Override // android.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        this.f18254x = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.storage_bar);
        this.f18248r = typedArrayObtainStyledAttributes.getBoolean(R$styleable.storage_bar_use_cache, false);
        this.f18249s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.storage_bar_need_loading, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback
    /* renamed from: q */
    public void mo15483q() {
        long totalSize;
        long appSize;
        if (!isAdded()) {
            C11839m.m70687e("StorageBarFragment", "onQueryStorageFinish fragment not attached");
            return;
        }
        C11839m.m70688i("StorageBarFragment", "onQueryStorageFinish");
        this.f18234d.setVisibility(0);
        this.f18235e.setVisibility(8);
        m24303e();
        long jM80237a0 = C13368e.m80184F().m80237a0();
        long jM80236Z = C13368e.m80184F().m80236Z();
        long jM80234X = C13368e.m80184F().m80234X();
        StorageInfo storageInfoM80226P = C13368e.m80184F().m80226P();
        if (storageInfoM80226P != null) {
            appSize = storageInfoM80226P.getAppSize();
            jM80236Z += storageInfoM80226P.getGalleryDeleteSize();
            TotalStorageInfo totalInfo = storageInfoM80226P.getTotalInfo();
            if (totalInfo == null) {
                C11839m.m70688i("StorageBarFragment", "onQueryStorageFinish totalInfo null");
                return;
            }
            totalSize = totalInfo.getTotalSize();
        } else {
            totalSize = -1;
            appSize = 0;
        }
        C11839m.m70688i("StorageBarFragment", "onQueryStorageFinish totalSize=" + totalSize);
        if (totalSize <= 0) {
            m24304d();
            return;
        }
        C11839m.m70688i("StorageBarFragment", "backupSize=" + jM80237a0 + ",gallerySize=" + jM80236Z + ",cloudDriveSize=" + jM80234X + ",appSize=" + appSize + ",totalSize=" + totalSize);
        float f10 = (float) totalSize;
        float f11 = ((float) jM80237a0) / f10;
        this.f18241k = f11;
        float f12 = ((float) jM80236Z) / f10;
        this.f18242l = f12;
        float f13 = ((float) jM80234X) / f10;
        this.f18243m = f13;
        float f14 = ((float) appSize) / f10;
        this.f18244n = f14;
        m24307h(f11, f12, f13, f14);
        this.f18233c.refresh(this.f18241k, this.f18243m, this.f18242l, this.f18244n);
        m24300a();
    }
}
