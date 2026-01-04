package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0240y;
import p514o9.C11829c;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class DriveConfigDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public String f14758N0;

    /* renamed from: O0 */
    public String f14759O0;

    /* renamed from: P0 */
    public BitmapDrawable f14760P0;

    /* renamed from: Q0 */
    public String f14761Q0;

    /* renamed from: R0 */
    public boolean f14762R0;

    /* renamed from: S0 */
    public int f14763S0 = -1;

    /* renamed from: T0 */
    public String f14764T0;

    /* renamed from: U0 */
    public String f14765U0;

    /* renamed from: S2 */
    private void m20402S2() throws Resources.NotFoundException {
        m20407V2();
        m20405Y2();
        m20404X2();
        m20408W2();
        if (this.f14762R0) {
            return;
        }
        this.f16212a0.setVisibility(8);
    }

    /* renamed from: T2 */
    private void m20403T2() {
        Intent intent = getIntent();
        if (intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            this.f14761Q0 = safeIntent.getStringExtra("moduleName");
            this.f16196L0 = safeIntent.getStringExtra("title_text");
            this.f14758N0 = safeIntent.getStringExtra("icon_path");
            this.f14759O0 = safeIntent.getStringExtra(MapKeyNames.PACKAGE_NAME);
            this.f14762R0 = safeIntent.getBooleanExtra("sync_config_record", false);
            this.f14763S0 = safeIntent.getIntExtra("sync_config_record_index", -1);
            this.f14765U0 = safeIntent.getStringExtra("sync_config_text_name_id");
            C11839m.m70688i("DriveConfigDetailActivity", "driveConfig record:" + this.f14762R0);
        }
    }

    /* renamed from: X2 */
    private void m20404X2() {
        this.f16202Q.setVisibility(8);
    }

    /* renamed from: Y2 */
    private void m20405Y2() {
        C11839m.m70688i("DriveConfigDetailActivity", "driveConfig showDataSize size = " + this.f16247z);
        if (TextUtils.isEmpty(this.f16247z)) {
            this.f16199N.setVisibility(8);
            this.f16202Q.setVisibility(8);
        } else {
            this.f16199N.setVisibility(0);
            this.f16202Q.setVisibility(0);
            this.f16200O.setText(R$string.disk_app_detail_title);
            this.f16201P.setText(this.f16247z);
        }
    }

    /* renamed from: U2 */
    public void m20406U2(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
    }

    /* renamed from: V2 */
    public final void m20407V2() throws Resources.NotFoundException {
        m20406U2(this.f16196L0);
        this.f16187H.setText(this.f16196L0);
        Bitmap bitmapM70501B = C11829c.m70501B(this.f14758N0);
        if (bitmapM70501B != null) {
            this.f14760P0 = new BitmapDrawable((Resources) null, bitmapM70501B);
        }
        this.f16197M.setImageDrawable(this.f14760P0);
        String strM1681c = C0240y.m1681c(this, this.f14759O0);
        C11839m.m70688i("DriveConfigDetailActivity", "driveConfig packageName = " + this.f14759O0 + ", versionName = " + strM1681c);
        m22420G2(this, strM1681c);
        this.f14764T0 = C2783d.m16125a1();
    }

    /* renamed from: W2 */
    public final void m20408W2() {
        if (TextUtils.isEmpty(this.f14759O0) || !C0209d.m1184K0(this, this.f14759O0)) {
            View view = this.f16207V;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            if (this.f16207V != null) {
                if (this.f16199N.getVisibility() != 8) {
                    this.f16207V.setVisibility(0);
                } else {
                    this.f16207V.setVisibility(8);
                }
            }
            this.f16195L.setVisibility(0);
        }
        m22418E2(R$id.enter_hyperlink, this.f14759O0, "CLOUD_SYNC_CONFIG_ACTIVITY", this.f14761Q0, this.f14763S0);
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, this.f16196L0));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: h2 */
    public boolean mo19217h2() {
        return C10028c.m62182c0().m62388s(this.f14761Q0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C11839m.m70688i("DriveConfigDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(true);
        m20403T2();
        m20402S2();
        mo19982C1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String currentLanguage = HNUtil.getCurrentLanguage();
        if (TextUtils.isEmpty(this.f14764T0) || TextUtils.equals(this.f14764T0, currentLanguage)) {
            return;
        }
        C11839m.m70688i("DriveConfigDetailActivity", "DriveConfigContryLanguage changed " + this.f14764T0 + " to " + currentLanguage);
        C2783d.m16146h1(currentLanguage);
        this.f14764T0 = currentLanguage;
        String stringFromDriveConfig = NotifyUtil.getStringFromDriveConfig(this.f14765U0);
        m20406U2(stringFromDriveConfig);
        this.f16187H.setText(stringFromDriveConfig);
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, stringFromDriveConfig));
    }
}
