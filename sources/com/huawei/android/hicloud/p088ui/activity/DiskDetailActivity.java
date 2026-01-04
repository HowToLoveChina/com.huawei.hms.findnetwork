package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.hisync.model.DiskDetailItem;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import p015ak.C0209d;
import p514o9.C11842p;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DiskDetailActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public TextView f14738p = null;

    /* renamed from: q */
    public TextView f14739q = null;

    /* renamed from: r */
    public ImageView f14740r;

    /* renamed from: L1 */
    private void m20387L1() {
        DiskDetailItem diskDetailItem;
        Intent intent = getIntent();
        if (intent == null || (diskDetailItem = (DiskDetailItem) new SafeIntent(intent).getParcelableExtra("disk_item_param")) == null) {
            return;
        }
        this.f14738p.setText(diskDetailItem.m16394a());
        this.f14739q.setText(getString(R$string.disk_detail_size_tips_20170209, diskDetailItem.m16395c()));
    }

    /* renamed from: M1 */
    private void m20388M1() {
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.disk_detail_main_layout);
        this.f14739q = (TextView) C12809f.m76829b(this, R$id.disk_detail_page_tip);
        this.f14738p = (TextView) C12809f.m76829b(this, R$id.disk_detail_page_title);
        ((TextView) C12809f.m76829b(this, R$id.disk_storage_to_file_manager)).setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.disk_detail_image_frame);
        if (getResources().getConfiguration().orientation == 2) {
            DisplayMetrics displayMetricsM70876w = C11842p.m70876w(this);
            RelativeLayout relativeLayout3 = (RelativeLayout) C12809f.m76829b(this, R$id.gellery_detail_page_left_frame);
            if (relativeLayout3 != null) {
                ViewGroup.LayoutParams layoutParams = relativeLayout3.getLayoutParams();
                layoutParams.width = (displayMetricsM70876w.widthPixels * 5) / 12;
                relativeLayout3.setLayoutParams(layoutParams);
            }
            if (C11842p.m70771U0()) {
                C11842p.m70775V1(this, relativeLayout);
            }
        }
        if (!C11842p.m70771U0() && getResources().getConfiguration().orientation == 1) {
            C11842p.m70826j1(this, relativeLayout2);
        }
        this.f14740r = (ImageView) C12809f.m76829b(this, R$id.disk_detail_page_icon);
        if (C0209d.m1269j1()) {
            this.f14740r.setImageDrawable(getResources().getDrawable(R$drawable.ic_home_disk_normal_honor));
        } else {
            this.f14740r.setImageDrawable(getResources().getDrawable(R$drawable.ic_home_disk_normal));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.disk_storage_to_file_manager) {
            m22375i1(this, 0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.disk_detail);
        m20388M1();
        m20387L1();
        m22365E1(R$string.cloud_collect);
    }
}
