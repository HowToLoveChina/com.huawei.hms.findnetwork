package com.huawei.android.hicloud.p088ui.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aq.C1011a;
import com.huawei.android.hicloud.commonlib.space.UsedSpaceInfo;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hms.p148ui.SafeIntent;
import hu.C10343b;
import java.util.ArrayList;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0223k;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p431ko.C11079e;
import p514o9.C11839m;
import p616rk.C12515a;
import p664u0.C13108a;
import p703v8.C13368e;
import p709vj.C13452e;
import p732w8.C13551b0;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class CloudCollectionDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public Handler f14183N0 = new HandlerC3200a();

    /* renamed from: O0 */
    public StorageReceiver f14184O0;

    public class StorageReceiver extends BroadcastReceiver {
        public StorageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C10343b c10343b;
            if (intent == null) {
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            try {
                c10343b = new C10343b(hiCloudSafeIntent.getExtras());
            } catch (RuntimeException e10) {
                C11839m.m70688i("CloudCollectionDetailActivity", "StorageReceiver:" + e10.toString());
                c10343b = null;
            }
            if ("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED".equals(hiCloudSafeIntent.getAction())) {
                C11839m.m70688i("CloudCollectionDetailActivity", "receive QUERY_QUOTA_INFO_FINISHED_ACTION");
                if (c10343b != null) {
                    int iM63686h = c10343b.m63686h("result");
                    C11839m.m70688i("CloudCollectionDetailActivity", "STORAGE_QUERY_FINISHED_ACTION result=" + iM63686h);
                    if (iM63686h != 1) {
                        C11839m.m70689w("CloudCollectionDetailActivity", "StorageReceiver: QUERY_QUOTA_INFO_Failed");
                        return;
                    }
                    UsedSpaceInfo usedSpaceInfoM80221J = C13368e.m80184F().m80221J("drive");
                    if (usedSpaceInfoM80221J == null) {
                        C11839m.m70687e("CloudCollectionDetailActivity", "refreshCloudDriveSize() cloudDriveUsedSpace = null return");
                        return;
                    }
                    long used = usedSpaceInfoM80221J.getUsed();
                    CloudCollectionDetailActivity cloudCollectionDetailActivity = CloudCollectionDetailActivity.this;
                    cloudCollectionDetailActivity.f16247z = C0223k.m1525h(cloudCollectionDetailActivity, used, 1024);
                    CloudCollectionDetailActivity cloudCollectionDetailActivity2 = CloudCollectionDetailActivity.this;
                    cloudCollectionDetailActivity2.f16201P.setText(cloudCollectionDetailActivity2.f16247z);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudCollectionDetailActivity$a */
    public class HandlerC3200a extends Handler {
        public HandlerC3200a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0 || i10 == 1) {
                CloudCollectionDetailActivity.this.m19645a3(message.getData().getLong("cloud_drive_recycle_size", 0L));
            }
        }
    }

    /* renamed from: V2 */
    private void m19638V2() {
        if (this.f14184O0 == null) {
            this.f14184O0 = new StorageReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED");
            C13108a.m78878b(this).m78880c(this.f14184O0, intentFilter);
        }
    }

    @SuppressLint({"StringFormatMatches"})
    /* renamed from: W2 */
    private void m19639W2() throws Resources.NotFoundException {
        if (!C0209d.m1269j1() || getPackageManager().getLaunchIntentForPackage("com.hihonor.filemanager") == null) {
            m22417D2(R$id.enter_hyperlink, NextRestoreConstants.PKG_NAME_FILE_MANAGER, "com.huawei.hidisk.filemanager.FileManager", getString(R$string.cloud_collect));
        } else {
            m22417D2(R$id.enter_hyperlink, "com.hihonor.filemanager", "com.huawei.hidisk.filemanager.FileManager", getString(R$string.cloud_collect));
        }
        int i10 = R$string.cloud_collect_detail_new;
        m22365E1(i10);
        this.f16187H.setText(i10);
        m22365E1(i10);
        this.f16187H.setText(i10);
        mo19982C1();
        this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_basic_cloud_disk));
        m22420G2(this, "16.0.0.300");
        this.f16200O.setText(R$string.disk_app_detail_title);
        this.f16201P.setText(this.f16247z);
        this.f16204S.setText(R$string.gallery_detail_title_delete);
        String stringExtra = new SafeIntent(getIntent()).getStringExtra("deeplink_sub_page");
        C11839m.m70688i("CloudCollectionDetailActivity", "subPageFalg " + stringExtra);
        if (!TextUtils.isEmpty(stringExtra) && "ManageSpace_disk".equals(stringExtra)) {
            m22375i1(this, 0);
        }
        m19641Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X2 */
    public /* synthetic */ void m19640X2(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C11839m.m70688i("CloudCollectionDetailActivity", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C11839m.m70688i("CloudCollectionDetailActivity", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C11839m.m70688i("CloudCollectionDetailActivity", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            if (interfaceC9282a != null) {
                C11839m.m70688i("CloudCollectionDetailActivity", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58410a1(userDataStateInfo.getBmGradeState(), userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58399V0(System.currentTimeMillis());
            }
        }
        m19643U2(userDataStateInfo);
    }

    /* renamed from: Y2 */
    private void m19641Y2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        arrayList.add("bs.userdata.overdue.days");
        arrayList.add(NotifyConstants.MashupKey.BS_REMAIN_DAYS);
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: com.huawei.android.hicloud.ui.activity.f3
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
                this.f17607a.m19640X2(userDataStateInfo);
            }
        }, true, arrayList, "CollectionDetail"), false);
    }

    /* renamed from: b3 */
    private void m19642b3() {
        this.f16199N.setVisibility(0);
        if (!ModuleConfigUtil.getInstance().isGeneralVersion() || !C0209d.m1190M0(this, C13843a.m83099u())) {
            this.f16220i0.setVisibility(8);
            return;
        }
        this.f16220i0.setVisibility(0);
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.cloud.CLOUD_DISK_RECENTLY_DELETED");
        C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        if (intent.resolveActivity(getPackageManager()) != null) {
            this.f16228p0.setVisibility(0);
        } else {
            C11839m.m70689w("CloudCollectionDetailActivity", "not find  cloud disk recently deleted activity");
            this.f16228p0.setVisibility(8);
        }
    }

    /* renamed from: U2 */
    public final void m19643U2(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
        if (userDataStateInfo == null) {
            this.f16223l0.setVisibility(8);
            return;
        }
        Resources resources = getResources();
        if (resources == null) {
            this.f16223l0.setVisibility(8);
            return;
        }
        if (C13452e.m80781L().m80791C0()) {
            if (userDataStateInfo.getBmGradeState() == 1) {
                this.f16223l0.m15934g(resources.getString(R$string.cloud_disk_basic_service_fixing_tips, ""), false);
                return;
            }
            if (userDataStateInfo.getBmGradeState() == -1 || userDataStateInfo.getDataRetentionDays() == -1) {
                this.f16223l0.setVisibility(8);
                return;
            }
            if (userDataStateInfo.getDataRetentionDays() > 0 && userDataStateInfo.getUserdataRemainDays() > 0) {
                this.f16223l0.m15934g(resources.getString(R$string.basic_service_cloud_file_tips, resources.getQuantityString(R$plurals.common_days, userDataStateInfo.getDataRetentionDays(), Integer.valueOf(userDataStateInfo.getDataRetentionDays())), resources.getQuantityString(R$plurals.cloudpay_remain_days, userDataStateInfo.getUserdataRemainDays(), C1011a.m6163c(Integer.valueOf(userDataStateInfo.getUserdataRemainDays()))), resources.getString(R$string.basic_service_download_data)), false);
                return;
            }
            C11839m.m70688i("CloudCollectionDetailActivity", "useInfo.getDataRetentionDays() = " + userDataStateInfo.getDataRetentionDays() + " useInfo.getUserdataRemainDays() = " + userDataStateInfo.getUserdataRemainDays());
            this.f16223l0.setVisibility(8);
        }
    }

    /* renamed from: Z2 */
    public final void m19644Z2() {
        C12515a.m75110o().m75172d(new C13551b0(this.f14183N0));
    }

    /* renamed from: a3 */
    public final void m19645a3(long j10) {
        C11839m.m70686d("CloudCollectionDetailActivity", "setOtherDataUsed recycle size:" + j10);
        RelativeLayout relativeLayout = this.f16203R;
        if (relativeLayout != null && this.f16202Q != null) {
            relativeLayout.setVisibility(0);
            this.f16202Q.setVisibility(0);
        }
        String strM1524g = C0223k.m1524g(this, j10);
        TextView textView = this.f16205T;
        if (textView != null) {
            textView.setText(strM1524g);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        m29137U0();
        C11839m.m70688i("CloudCollectionDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(false);
        m19642b3();
        m19639W2();
        m19638V2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m19644Z2();
        C13368e.m80184F().m80250o0();
    }
}
