package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.IntelligentRecommendationCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.IntelligentRecommendationDialog;
import com.huawei.android.p073ds.R$anim;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0214f0;
import p015ak.C0234s;
import p478mj.C11474b;
import p514o9.C11839m;
import p742wj.C13612b;
import sk.C12808e;

/* loaded from: classes3.dex */
public class IntelligentRecommendationActivity extends Activity implements IntelligentRecommendationCallback {

    /* renamed from: a */
    public IntelligentRecommendationDialog f15159a;

    /* renamed from: b */
    public C11474b f15160b;

    /* renamed from: c */
    public String f15161c = "";

    /* renamed from: a */
    public final boolean m20943a() {
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i("IntelligentRecommendationActivity", "isRecommendation PrivacyUser return false");
            return false;
        }
        if (C0209d.m1293p1()) {
            C11839m.m70688i("IntelligentRecommendationActivity", "isRecommendation isInkScreen return false");
            return false;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70688i("IntelligentRecommendationActivity", "isRecommendation isOwnerUser return false");
            return false;
        }
        if (!C13612b.m81829B().isLogin()) {
            return true;
        }
        long j10 = C0214f0.m1382b(getApplicationContext(), "com.huawei.android.ds_spcace_detail_cache", 0).getLong("available_space_sp_key", -1L);
        if (j10 < 524288000) {
            C11839m.m70688i("IntelligentRecommendationActivity", "isRecommendation usedSize " + j10);
            return false;
        }
        boolean zM62388s = C10028c.m62183d0(this).m62388s("backup_key");
        if (!zM62388s) {
            if (C10028c.m62183d0(this).m62395t1("funcfg_cloud_backup")) {
                return true;
            }
            C11839m.m70688i("IntelligentRecommendationActivity", "isRecommendation isModuleEnable return false");
            return false;
        }
        C11839m.m70688i("IntelligentRecommendationActivity", "isRecommendation backupState " + zM62388s);
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.IntelligentRecommendationCallback
    public void onClickEnable() {
        C11839m.m70686d("IntelligentRecommendationActivity", "onClickEnable");
        IntelligentRecommendationDialog intelligentRecommendationDialog = this.f15159a;
        if (intelligentRecommendationDialog != null && intelligentRecommendationDialog.isShowing()) {
            this.f15159a.dismiss();
        }
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        try {
            C11474b c11474b = new C11474b();
            this.f15160b = c11474b;
            c11474b.m68612e(this);
            Intent intent = zM62221H1 ? new Intent(this, (Class<?>) MainActivity.class) : new Intent(this, (Class<?>) NewHiSyncSettingActivity.class);
            if (!TextUtils.isEmpty(this.f15161c)) {
                intent.putExtra("channel_of_open_switch", this.f15161c);
            }
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70688i("IntelligentRecommendationActivity", "intent error e:" + e10.toString());
        }
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.IntelligentRecommendationCallback
    public void onClickKnow() {
        IntelligentRecommendationDialog intelligentRecommendationDialog = this.f15159a;
        if (intelligentRecommendationDialog != null && intelligentRecommendationDialog.isShowing()) {
            this.f15159a.dismiss();
        }
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C12808e.m76822a(this);
        if (!m20943a()) {
            finish();
            return;
        }
        try {
            IntelligentRecommendationDialog intelligentRecommendationDialog = new IntelligentRecommendationDialog(this, this);
            this.f15159a = intelligentRecommendationDialog;
            intelligentRecommendationDialog.setCanceledOnTouchOutside(false);
            this.f15159a.show();
        } catch (Exception e10) {
            C11839m.m70687e("IntelligentRecommendationActivity", "get type error:" + e10.toString());
        }
        this.f15161c = "6";
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R$anim.activity_close, 0);
        IntelligentRecommendationDialog intelligentRecommendationDialog = this.f15159a;
        if (intelligentRecommendationDialog != null && intelligentRecommendationDialog.isShowing()) {
            this.f15159a.dismiss();
            this.f15159a = null;
        }
        C11474b c11474b = this.f15160b;
        if (c11474b != null) {
            c11474b.m68617j(this);
        }
    }
}
