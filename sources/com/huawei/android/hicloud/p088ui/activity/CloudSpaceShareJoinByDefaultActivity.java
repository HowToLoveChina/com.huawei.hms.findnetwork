package com.huawei.android.hicloud.p088ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.bean.RetResult;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import dj.C9158a;
import java.lang.reflect.InvocationTargetException;
import p364ib.C10465b;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11293p;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class CloudSpaceShareJoinByDefaultActivity extends CloudSpaceShareActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity
    /* renamed from: Q2 */
    public void mo20170Q2(FamilyShareInfoResult familyShareInfoResult) {
        if (familyShareInfoResult == null) {
            C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "get space share info failed,response null");
            m20191m3(8, FamilyShareConstants.OpenCloudShareResultInfo.DESC_FAMILY_SHARE_INFO_FAIL);
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_SHARE_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
            return;
        }
        int retCode = familyShareInfoResult.getRetCode();
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "getshareinfo,retcode:" + retCode);
        if (retCode != 0) {
            m20191m3(8, FamilyShareConstants.OpenCloudShareResultInfo.DESC_FAMILY_SHARE_INFO_FAIL);
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_SHARE_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, retCode);
            m20204x3(8, 8, 8, 8, 0, 8);
            return;
        }
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "getshareinfo success");
        m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_SHARE_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_SUCCESS, retCode);
        this.f14543O0 = familyShareInfoResult;
        this.f14597B = familyShareInfoResult.getFamilyShareEnable();
        this.f14598C = this.f14543O0.getSpaceShareEnable();
        this.f14599D = this.f14543O0.getSpaceShareRole();
        this.f14600E = this.f14543O0.getCanSpaceShareEnable();
        this.f14602G = this.f14543O0.getSpaceShareOwner();
        this.f14601F = this.f14543O0.getPurchased();
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "space share status, familyShareEnable: " + this.f14597B + " spaceShareEnable: " + this.f14598C + " spaceShareRole: " + this.f14599D + " canSpaceShareEnable: " + this.f14600E);
        C10465b.m64309s(familyShareInfoResult);
        if (this.f14597B == 0) {
            if (this.f14607L == 4) {
                C10465b.m64300j(this);
            }
            C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "familyshareenable not open");
            m20191m3(9, FamilyShareConstants.OpenCloudShareResultInfo.DESC_FAMILY_SHARE_NOT_OPEN);
            return;
        }
        if (this.f14598C == 1) {
            m20191m3(10, FamilyShareConstants.OpenCloudShareResultInfo.DESC_SPACE_SHARE_OPENED);
            return;
        }
        if (this.f14602G == -1) {
            m20191m3(11, FamilyShareConstants.OpenCloudShareResultInfo.DESC_NOBODY_SHARE_SPACE);
            return;
        }
        if (this.f14570d1) {
            this.f14570d1 = false;
            C9158a.m57503F().m57533c(this.f14572e1, 1);
            return;
        }
        if (this.f14606K) {
            m20163J2();
            return;
        }
        if (this.f14601F == 0) {
            C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "no purchased,use cloudspace share ");
            m20245z2(this.f14572e1);
            return;
        }
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "purchased,use cloudspace share ");
        m20201v3(false);
        this.f14562Z0 = false;
        C11060c c11060c = new C11060c();
        c11060c.m66664t("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        C9158a.m57503F().m57516N(this.f14572e1, c11060c, false, "ShareJoinDefaultActivity");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity
    /* renamed from: R2 */
    public void mo20171R2(Message message) {
        m20191m3(14, FamilyShareConstants.OpenCloudShareResultInfo.DESC_QUERY_USERPACKAGE_FAILED);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity
    /* renamed from: S1 */
    public void mo20215S1(Message message, Handler handler) {
        if (this.f14552U0 != 0) {
            super.mo20215S1(message, handler);
            return;
        }
        int i10 = message.what;
        if (i10 != 2000) {
            mo20222Z1(i10);
            C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "join space share failed " + i10);
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.JOIN_FAMILY_SHARE, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
            return;
        }
        RetResult retResult = (RetResult) message.obj;
        if (retResult == null) {
            C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "join space share failed,response null");
            return;
        }
        int retCode = retResult.getRetCode();
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "join space share,retcode:" + retCode);
        m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.JOIN_FAMILY_SHARE, FamilyShareConstants.Report.SPACE_SHARE_RESULT_SUCCESS, retCode);
        if (retCode != 0) {
            mo20222Z1(retCode);
            return;
        }
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "join space share success " + retCode);
        mo20223a2(handler);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity
    /* renamed from: S2 */
    public void mo20172S2(Message message) {
        Object obj = message.obj;
        if (obj == null || !(obj instanceof UserPackage)) {
            m20204x3(8, 8, 8, 8, 0, 8);
            return;
        }
        UserPackage userPackage = (UserPackage) obj;
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(userPackage);
        CloudSpace cloudSpaceM67759c = C11293p.m67759c(userPackage, 2);
        this.f14552U0 = userPackage.getUserPayType();
        C11839m.m70686d("CloudSpaceShareJoinByDefaultActivity", "getuserpackage,userPayType:" + this.f14552U0);
        if (this.f14552U0 == 0) {
            m20245z2(this.f14572e1);
            return;
        }
        if (cloudSpaceM67757a == null && cloudSpaceM67759c == null) {
            m20204x3(8, 8, 8, 8, 0, 8);
            return;
        }
        long capacity = cloudSpaceM67757a == null ? this.f14550T0 : cloudSpaceM67757a.getCapacity();
        this.f14550T0 = capacity;
        if (cloudSpaceM67759c != null) {
            capacity += cloudSpaceM67759c.getCapacity();
        }
        this.f14550T0 = capacity;
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "getuserpackage,capacity:" + this.f14550T0);
        if (m20200u3(4)) {
            m20204x3(8, 8, 0, 8, 8, 8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity
    /* renamed from: Z1 */
    public void mo20222Z1(int i10) {
        if (this.f14552U0 != 0) {
            m20204x3(8, 8, 8, 8, 8, 0);
            return;
        }
        m20191m3(12, "join space share failed, " + i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity
    /* renamed from: a2 */
    public void mo20223a2(Handler handler) {
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "joinSpaceShareSuccess,finish");
        m20228f2(this.f14607L, this.f14608M, FamilyShareConstants.Report.JOIN_FAMILY_SHARE, FamilyShareConstants.Report.SPACE_SHARE_RESULT_SUCCESS, 0, this.f14552U0);
        m20191m3(0, FamilyShareConstants.OpenCloudShareResultInfo.DESC_JOIN_SPACE_SHARE_SUCCESS);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity
    /* renamed from: k3 */
    public void mo20189k3() {
        m20191m3(7, FamilyShareConstants.OpenCloudShareResultInfo.DESC_FAMILY_SHARE_RESULT_FAIL);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity
    /* renamed from: l3 */
    public void mo20190l3() {
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "not join space share,finish");
        m20191m3(13, FamilyShareConstants.OpenCloudShareResultInfo.DESC_NOT_JOIN_SPACE_SHARE);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C11839m.m70688i("CloudSpaceShareJoinByDefaultActivity", "onBackPressed");
        m20191m3(15, FamilyShareConstants.OpenCloudShareResultInfo.DESC_USER_CLICK_BACK);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity, com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity, com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity
    /* renamed from: y2 */
    public void mo20205y2() {
    }
}
