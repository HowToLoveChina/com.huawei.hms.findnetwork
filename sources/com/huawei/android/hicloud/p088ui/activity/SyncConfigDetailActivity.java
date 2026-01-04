package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import java.util.Iterator;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0240y;
import p514o9.C11829c;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class SyncConfigDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public String f16115N0;

    /* renamed from: O0 */
    public String f16116O0;

    /* renamed from: P0 */
    public Drawable f16117P0;

    /* renamed from: Q0 */
    public String f16118Q0;

    /* renamed from: R0 */
    public String f16119R0;

    /* renamed from: S0 */
    public int f16120S0;

    /* renamed from: T0 */
    public boolean f16121T0;

    /* renamed from: U0 */
    public int f16122U0 = -1;

    /* renamed from: V0 */
    public String f16123V0;

    /* renamed from: W0 */
    public String f16124W0;

    /* renamed from: X0 */
    public String f16125X0;

    /* renamed from: S2 */
    private void m22317S2() throws Resources.NotFoundException {
        m22319W2();
        m22322Z2();
        m22321Y2();
        m22320X2();
        if (this.f16121T0) {
            return;
        }
        this.f16212a0.setVisibility(8);
    }

    /* renamed from: T2 */
    private void m22318T2() {
        Intent intent = getIntent();
        if (intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            this.f16119R0 = safeIntent.getStringExtra("moduleName");
            this.f16196L0 = safeIntent.getStringExtra("title_text");
            this.f16115N0 = safeIntent.getStringExtra("icon_path");
            this.f16116O0 = safeIntent.getStringExtra(MapKeyNames.PACKAGE_NAME);
            this.f16118Q0 = safeIntent.getStringExtra("data_type_name");
            this.f16124W0 = safeIntent.getStringExtra("data_type_name_id");
            this.f16120S0 = safeIntent.getIntExtra("data_recycle_num", 0);
            this.f16121T0 = safeIntent.getBooleanExtra("sync_config_record", false);
            this.f16122U0 = safeIntent.getIntExtra("sync_config_record_index", -1);
            this.f16125X0 = safeIntent.getStringExtra("sync_config_text_name_id");
            C11839m.m70688i("SyncConfigDetailActivity", "record:" + this.f16121T0);
        }
    }

    /* renamed from: W2 */
    private void m22319W2() throws Resources.NotFoundException {
        m22324V2(this.f16196L0);
        this.f16187H.setText(this.f16196L0);
        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(this.f16119R0) && C0209d.m1293p1()) {
            this.f16117P0 = ResourcesCompat.getDrawable(getResources(), R$drawable.hinote_sync_icon, getTheme());
        } else {
            Bitmap bitmapM70501B = C11829c.m70501B(this.f16115N0);
            if (bitmapM70501B != null) {
                this.f16117P0 = new BitmapDrawable((Resources) null, bitmapM70501B);
            }
        }
        this.f16197M.setImageDrawable(this.f16117P0);
        String strM1681c = C0240y.m1681c(this, this.f16116O0);
        C11839m.m70688i("SyncConfigDetailActivity", "packageName = " + this.f16116O0 + ", versionName = " + strM1681c);
        m22420G2(this, strM1681c);
        this.f16123V0 = C2783d.m16125a1();
    }

    /* renamed from: X2 */
    private void m22320X2() {
        if (!TextUtils.isEmpty(this.f16116O0) && C0209d.m1184K0(this, this.f16116O0) && m22323U2(this.f16116O0)) {
            if (this.f16207V != null) {
                if (this.f16203R.getVisibility() == 8 && this.f16199N.getVisibility() == 8) {
                    this.f16207V.setVisibility(8);
                } else {
                    this.f16207V.setVisibility(0);
                }
            }
            this.f16195L.setVisibility(0);
        } else {
            View view = this.f16207V;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        m22418E2(R$id.enter_hyperlink, this.f16116O0, "CLOUD_SYNC_CONFIG_ACTIVITY", this.f16119R0, this.f16122U0);
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, this.f16196L0));
    }

    /* renamed from: Y2 */
    private void m22321Y2() {
        if (this.f16120S0 == 0 || TextUtils.isEmpty(this.f16247z)) {
            this.f16202Q.setVisibility(8);
        } else {
            this.f16202Q.setVisibility(0);
        }
    }

    /* renamed from: Z2 */
    private void m22322Z2() {
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
    public final boolean m22323U2(String str) {
        Iterator<SyncConfigService> it = new SyncConfigOperator().getAllServices().iterator();
        SyncConfigService syncConfigService = null;
        while (true) {
            int i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            SyncConfigService next = it.next();
            String[] applications = next.getApplications();
            int length = applications.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (applications[i10].equals(str)) {
                    syncConfigService = next;
                    break;
                }
                i10++;
            }
        }
        if (syncConfigService == null) {
            C11839m.m70689w("SyncConfigDetailActivity", "isPackageValid: syncConfigService is null, return false.");
            return false;
        }
        if (NotifyUtil.isFingerPrintEmpty(syncConfigService)) {
            return true;
        }
        return NotifyUtil.isAppFingerPrintValid(this, syncConfigService);
    }

    /* renamed from: V2 */
    public void m22324V2(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: h2 */
    public boolean mo19217h2() {
        return C10028c.m62182c0().m62388s(this.f16119R0);
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
        C11839m.m70688i("SyncConfigDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(true);
        m22318T2();
        m22317S2();
        mo19982C1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String currentLanguage = HNUtil.getCurrentLanguage();
        if (TextUtils.isEmpty(this.f16123V0) || TextUtils.equals(this.f16123V0, currentLanguage)) {
            return;
        }
        C11839m.m70688i("SyncConfigDetailActivity", "SyncConfigContryLanguage changed " + this.f16123V0 + " to " + currentLanguage);
        C2783d.m16146h1(currentLanguage);
        this.f16123V0 = currentLanguage;
        String stringFromSyncConfig = NotifyUtil.getStringFromSyncConfig(this.f16125X0);
        m22324V2(stringFromSyncConfig);
        this.f16187H.setText(stringFromSyncConfig);
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, stringFromSyncConfig));
    }
}
