package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import cc.C1417a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$plurals;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.HNConstants;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1010e;
import p422k9.C11019b;
import p514o9.C11839m;
import p684un.C13227f;
import p709vj.C13452e;
import tm.C13040c;

/* loaded from: classes3.dex */
public class OOBEUniformGuideFrontActivity extends OOBEUniformGuideActivity {

    /* renamed from: r1 */
    public Bundle f12458r1 = new Bundle();

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEUniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: C2 */
    public void mo16699C2() {
        C13227f.m79492i1().m79560L(this, C13452e.m80781L().m80971t0());
        m16558F();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEUniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: D2 */
    public void mo16700D2() {
        C13040c.m78609F().m78654j0(C0213f.m1377a(), C13452e.m80781L().m80942m(), true);
        super.mo16700D2();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: D3 */
    public void mo16703D3() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        c10028cM62182c0.m62377p3("is_all_guide_over", false);
        c10028cM62182c0.m62377p3("is_already_configed_NV4", false);
        C13452e.m80781L().m80885a();
        C10028c.m62182c0().m62343j();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: E1 */
    public void mo16704E1() {
        Intent intent = new Intent();
        intent.putExtra("tempKeyBundle", this.f12458r1);
        setResult(1003, intent);
        finish();
    }

    /* renamed from: I3 */
    public final int m16705I3(int i10) {
        if (this.f12569I0.m62395t1("funcfg_contacts") && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12638u0 = true;
            if (!this.f12599Z.isChecked()) {
                i10++;
            }
        }
        if (this.f12569I0.m62395t1("funcfg_calendar")) {
            this.f12637t0++;
            this.f12641x0 = true;
            i10 = m16953S1(i10, this.f12603b0.isChecked());
        }
        if (!this.f12569I0.m62395t1("funcfg_wlan")) {
            return i10;
        }
        this.f12637t0++;
        this.f12643z0 = true;
        return (C0209d.m1166E1() && this.f12607d0.isChecked()) ? i10 : i10 + 1;
    }

    /* renamed from: J3 */
    public final int m16706J3(int i10) {
        if (this.f12569I0.m62395t1("funcfg_contacts") && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12638u0 = true;
            if (this.f12599Z.isChecked()) {
                i10++;
            }
        }
        if (this.f12569I0.m62395t1("funcfg_calendar")) {
            this.f12637t0++;
            this.f12641x0 = true;
            i10 = m16955T1(i10, this.f12603b0.isChecked());
        }
        if (!this.f12569I0.m62395t1("funcfg_wlan")) {
            return i10;
        }
        this.f12637t0++;
        this.f12643z0 = true;
        return (C0209d.m1166E1() && this.f12607d0.isChecked()) ? i10 + 1 : i10;
    }

    /* renamed from: K3 */
    public final boolean m16707K3() {
        RelativeLayout relativeLayout;
        return !this.f12609e0.isChecked() && this.f12642y0 && (relativeLayout = this.f12621k0) != null && relativeLayout.getVisibility() == 0;
    }

    /* renamed from: L3 */
    public final boolean m16708L3() {
        return this.f12609e0.isChecked() && this.f12642y0;
    }

    /* renamed from: M3 */
    public final boolean m16709M3() {
        RelativeLayout relativeLayout;
        return !this.f12603b0.isChecked() && this.f12641x0 && (relativeLayout = this.f12615h0) != null && relativeLayout.getVisibility() == 0;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: N2 */
    public void mo16710N2(SyncConfigService syncConfigService) {
        this.f12598Y0.put(syncConfigService.getId(), Boolean.TRUE);
    }

    /* renamed from: N3 */
    public final boolean m16711N3() {
        return this.f12603b0.isChecked() && this.f12641x0;
    }

    /* renamed from: O3 */
    public final boolean m16712O3() {
        RelativeLayout relativeLayout;
        return !this.f12599Z.isChecked() && this.f12638u0 && (relativeLayout = this.f12611f0) != null && relativeLayout.getVisibility() == 0;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: P2 */
    public void mo16713P2() {
        RelativeLayout relativeLayout = this.f12611f0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f12598Y0.put("addressbook", Boolean.TRUE);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = this.f12613g0;
        if (disableSupportedRelativeLayout != null && disableSupportedRelativeLayout.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12598Y0.put(HNConstants.DataType.MEDIA, Boolean.TRUE);
        }
        RelativeLayout relativeLayout2 = this.f12615h0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.f12598Y0.put("calendar", Boolean.TRUE);
        }
        RelativeLayout relativeLayout3 = this.f12617i0;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
            this.f12598Y0.put("notepad", Boolean.TRUE);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = this.f12619j0;
        if (disableSupportedRelativeLayout2 != null && disableSupportedRelativeLayout2.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12598Y0.put("wlan", Boolean.TRUE);
        }
        RelativeLayout relativeLayout4 = this.f12621k0;
        if (relativeLayout4 != null && relativeLayout4.getVisibility() == 0) {
            this.f12598Y0.put("browser", Boolean.TRUE);
        }
        m16945M2();
    }

    /* renamed from: P3 */
    public final boolean m16714P3() {
        return this.f12599Z.isChecked() && this.f12638u0;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: Q2 */
    public void mo16715Q2(boolean z10) {
        C11839m.m70688i("OOBEUniformGuideFrontActivity", "oobe checkPhoneFinder: " + z10);
        this.f12458r1.putBoolean("phoneFinder", z10);
        m16947O1();
        mo16941K2();
    }

    /* renamed from: Q3 */
    public final boolean m16716Q3() {
        DisableSupportedRelativeLayout disableSupportedRelativeLayout;
        return !this.f12601a0.isChecked() && this.f12639v0 && (disableSupportedRelativeLayout = this.f12613g0) != null && disableSupportedRelativeLayout.getVisibility() == 0;
    }

    /* renamed from: R3 */
    public final boolean m16717R3() {
        return this.f12601a0.isChecked() && this.f12639v0;
    }

    /* renamed from: S3 */
    public final boolean m16718S3() {
        RelativeLayout relativeLayout;
        return !this.f12605c0.isChecked() && this.f12640w0 && (relativeLayout = this.f12617i0) != null && relativeLayout.getVisibility() == 0;
    }

    /* renamed from: T3 */
    public final boolean m16719T3() {
        return this.f12605c0.isChecked() && this.f12640w0;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: U1 */
    public int mo16720U1(int i10) {
        boolean zIsSwitchStatus;
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    this.f12637t0++;
                    zIsSwitchStatus = ((SyncConfigService) next).getSwitchStatus();
                } else if (next instanceof DriveConfigService) {
                    this.f12637t0++;
                    zIsSwitchStatus = ((DriveConfigService) next).isSwitchStatus();
                } else {
                    zIsSwitchStatus = false;
                }
                i10 = m16953S1(i10, zIsSwitchStatus);
            }
        }
        return i10;
    }

    /* renamed from: U3 */
    public final boolean m16721U3() {
        DisableSupportedRelativeLayout disableSupportedRelativeLayout;
        return !this.f12607d0.isChecked() && this.f12643z0 && (disableSupportedRelativeLayout = this.f12619j0) != null && disableSupportedRelativeLayout.getVisibility() == 0;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: V1 */
    public int mo16722V1(int i10) {
        boolean zIsSwitchStatus;
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    this.f12637t0++;
                    zIsSwitchStatus = ((SyncConfigService) next).getSwitchStatus();
                } else if (next instanceof DriveConfigService) {
                    this.f12637t0++;
                    zIsSwitchStatus = ((DriveConfigService) next).isSwitchStatus();
                } else {
                    zIsSwitchStatus = false;
                }
                i10 = m16955T1(i10, zIsSwitchStatus);
            }
        }
        return i10;
    }

    /* renamed from: V3 */
    public final boolean m16723V3() {
        return this.f12607d0.isChecked() && this.f12643z0;
    }

    /* renamed from: W3 */
    public final void m16724W3(CompoundButton compoundButton, boolean z10, int i10) throws IllegalAccessException, IllegalArgumentException {
        if (i10 == R$id.open_backup_switch) {
            if (m16994q1(z10, CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
                return;
            } else {
                m16995q3();
            }
        } else if (i10 == R$id.open_phonefinder_switch) {
            m16954S2(z10);
        } else if (i10 == R$id.open_sync_item_switch) {
            Object tag = compoundButton.getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    m16980k3(str, Boolean.valueOf(z10));
                    this.f12598Y0.put(str, Boolean.valueOf(z10));
                }
            }
        } else if (i10 == R$id.open_sync_switch) {
            m16999s3(false);
        }
        m16726X3(z10, i10);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: X1 */
    public void mo16725X1() {
        this.f12622k1 = C11019b.m66371t().m66391K(this);
        this.f12585S.setCheckedProgrammatically(true);
        this.f12599Z.setChecked(true);
        this.f12605c0.setChecked(true);
        this.f12603b0.setChecked(true);
        this.f12607d0.setChecked(true);
        this.f12603b0.setChecked(true);
        this.f12601a0.setChecked(true);
        this.f12609e0.setChecked(this.f12622k1);
        HashMap<String, Boolean> map = this.f12598Y0;
        Boolean bool = Boolean.TRUE;
        map.put("addressbook", bool);
        this.f12598Y0.put("calendar", bool);
        this.f12598Y0.put(HNConstants.DataType.MEDIA, bool);
        this.f12598Y0.put("notepad", bool);
        this.f12598Y0.put("wlan", bool);
        this.f12598Y0.put("browser", Boolean.valueOf(this.f12622k1));
        if (C1010e.m6125b().m6146l(this, C13452e.m80781L().m80971t0())) {
            m17014y1();
        }
        if (!this.f12604b1) {
            m16935H2();
        }
        mo16727Y1();
    }

    /* renamed from: X3 */
    public final void m16726X3(boolean z10, int i10) {
        UnionSwitch unionSwitch;
        if (!z10 && this.f12602a1) {
            m17000t1();
        }
        if (z10 && this.f12602a1 && (unionSwitch = this.f12597Y) != null && !unionSwitch.isChecked() && m16930F3() && i10 != R$id.open_sync_switch && i10 != R$id.open_backup_switch && i10 != R$id.open_phonefinder_switch) {
            this.f12610e1 = false;
            this.f12597Y.setChecked(true);
        }
        if (this.f12602a1) {
            mo16968b3();
        } else {
            m16965a3();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: Y1 */
    public void mo16727Y1() {
        C1417a c1417a = this.f12590U0;
        if (c1417a == null) {
            return;
        }
        try {
            ArrayList<Object> arrayListM8154d = c1417a.m8154d();
            if (arrayListM8154d == null || arrayListM8154d.size() <= 0) {
                return;
            }
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    SyncConfigService syncConfigService = (SyncConfigService) next;
                    boolean zM62388s = C10028c.m62182c0().m62388s(syncConfigService.getId());
                    syncConfigService.setSwitchStatus(Boolean.valueOf(zM62388s));
                    this.f12598Y0.put(syncConfigService.getId(), Boolean.valueOf(zM62388s));
                } else if (next instanceof DriveConfigService) {
                    DriveConfigService driveConfigService = (DriveConfigService) next;
                    boolean zM62388s2 = C10028c.m62182c0().m62388s(driveConfigService.getId());
                    driveConfigService.setSwitchStatus(zM62388s2);
                    this.f12598Y0.put(driveConfigService.getId(), Boolean.valueOf(zM62388s2));
                }
            }
            this.f12590U0.notifyDataSetChanged();
        } catch (Exception e10) {
            C11839m.m70687e("OOBEUniformGuideFrontActivity", "initDynamicItemsSwitch exception: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: g2 */
    public void mo16728g2() {
        C11839m.m70688i("OOBEUniformGuideFrontActivity", "initSyncItemNotOpenNum");
        int iM16705I3 = m16705I3(0);
        if (this.f12569I0.m62395t1("funcfg_browser") && C11019b.m66371t().m66391K(this) && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12642y0 = true;
            iM16705I3 = m16953S1(iM16705I3, this.f12609e0.isChecked());
        }
        if (this.f12569I0.m62395t1("funcfg_notes") && C0209d.m1215U1(this)) {
            this.f12637t0++;
            this.f12640w0 = true;
            iM16705I3 = m16953S1(iM16705I3, this.f12605c0.isChecked());
        }
        if (!this.f12569I0.m62395t1("funcfg_cloud_backup") || C0209d.m1293p1()) {
            this.f12587T.setVisibility(8);
            View view = this.f12593W;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f12585S.setCheckedProgrammatically(false);
        }
        if (this.f12569I0.m62395t1("funcfg_gallery") && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12639v0 = true;
            iM16705I3 = m16953S1(iM16705I3, this.f12601a0.isChecked());
        }
        if (this.f12561A0 && this.f12590U0 != null) {
            iM16705I3 = mo16720U1(iM16705I3);
        }
        this.f12583R.setText(getResources().getQuantityString(R$plurals.item_num_not_open1, iM16705I3, Integer.valueOf(iM16705I3)));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: g3 */
    public void mo16729g3() {
        this.f12458r1.putBoolean("cloudbackup", this.f12585S.isChecked());
        this.f12458r1.putBoolean("is_agree_to_basic_user", m16987n2());
        Iterator<Map.Entry<String, Boolean>> it = this.f12598Y0.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            Boolean bool = this.f12598Y0.get(key);
            this.f12458r1.putBoolean(key, bool == null ? false : bool.booleanValue());
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: h2 */
    public void mo16730h2() {
        C11839m.m70688i("OOBEUniformGuideFrontActivity", "initSyncItemOpenNum");
        int iM16706J3 = m16706J3(0);
        if (this.f12569I0.m62395t1("funcfg_browser") && C11019b.m66371t().m66391K(this) && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12642y0 = true;
            iM16706J3 = m16955T1(iM16706J3, this.f12609e0.isChecked());
        }
        if (this.f12569I0.m62395t1("funcfg_notes") && C0209d.m1215U1(this)) {
            this.f12637t0++;
            this.f12640w0 = true;
            iM16706J3 = m16955T1(iM16706J3, this.f12605c0.isChecked());
        }
        if (!this.f12569I0.m62395t1("funcfg_cloud_backup") || C0209d.m1293p1()) {
            this.f12587T.setVisibility(8);
            View view = this.f12593W;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f12585S.setCheckedProgrammatically(false);
        }
        if (this.f12569I0.m62395t1("funcfg_gallery") && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12639v0 = true;
            iM16706J3 = m16955T1(iM16706J3, this.f12601a0.isChecked());
        }
        if (this.f12561A0 && this.f12590U0 != null) {
            iM16706J3 = mo16722V1(iM16706J3);
        }
        this.f12583R.setText(getResources().getQuantityString(R$plurals.uniform_sync_item_num, iM16706J3, Integer.valueOf(iM16706J3)));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEUniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: k2 */
    public void mo16702k2() {
        super.mo16702k2();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: n1 */
    public int mo16731n1() {
        int i10 = this.f12637t0;
        if (m16714P3()) {
            i10--;
        }
        if (m16711N3()) {
            i10--;
        }
        if (m16717R3()) {
            i10--;
        }
        if (m16719T3()) {
            i10--;
        }
        if (m16723V3()) {
            i10--;
        }
        if (m16708L3()) {
            i10--;
        }
        return (!this.f12561A0 || this.f12590U0 == null) ? i10 : m16996r1(i10);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: o1 */
    public int mo16732o1() {
        int i10 = this.f12637t0;
        C11839m.m70688i("OOBEUniformGuideFrontActivity", "calculateOpenItemNum supportFeatureNum: " + this.f12637t0);
        if (m16712O3()) {
            i10--;
        }
        if (m16709M3()) {
            i10--;
        }
        if (m16716Q3()) {
            i10--;
        }
        if (m16718S3()) {
            i10--;
        }
        if (m16721U3()) {
            i10--;
        }
        if (m16707K3()) {
            i10--;
        }
        return (!this.f12561A0 || this.f12590U0 == null) ? i10 : mo16733s1(i10);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        int id2 = compoundButton.getId();
        if (id2 == R$id.open_contact_switch) {
            this.f12598Y0.put("addressbook", Boolean.valueOf(z10));
            m16994q1(z10, "addressbook");
        } else if (id2 == R$id.open_gellery_switch) {
            this.f12598Y0.put(HNConstants.DataType.MEDIA, Boolean.valueOf(z10));
            m16994q1(z10, HNConstants.DataType.MEDIA);
        } else if (id2 == R$id.open_calendar_switch) {
            this.f12598Y0.put("calendar", Boolean.valueOf(z10));
            m16994q1(z10, "calendar");
        } else if (id2 == R$id.open_notepad_switch) {
            this.f12598Y0.put("notepad", Boolean.valueOf(z10));
        } else if (id2 == R$id.open_wlan_switch) {
            this.f12598Y0.put("wlan", Boolean.valueOf(z10));
        } else if (id2 == R$id.open_browser_switch) {
            this.f12598Y0.put("browser", Boolean.valueOf(z10));
        }
        m16724W3(compoundButton, z10, id2);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEUniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C10028c.m62182c0().m62288W1();
        super.onCreate(bundle);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: s1 */
    public int mo16733s1(int i10) {
        try {
            ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
            if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
                Iterator<Object> it = arrayListM8154d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof SyncConfigService) {
                        Boolean bool = this.f12598Y0.get(((SyncConfigService) next).getId());
                        if (bool == null) {
                            bool = Boolean.FALSE;
                        }
                        if (!bool.booleanValue()) {
                            i10--;
                        }
                    } else if (next instanceof DriveConfigService) {
                        Boolean bool2 = this.f12598Y0.get(((DriveConfigService) next).getId());
                        if (bool2 == null) {
                            bool2 = Boolean.FALSE;
                        }
                        if (!bool2.booleanValue()) {
                            i10--;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("OOBEUniformGuideFrontActivity", "checkSyncConfigOpenNum exception: " + e10.toString());
        }
        return i10;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: x1 */
    public void mo16734x1(SyncConfigService syncConfigService) {
        this.f12598Y0.put(syncConfigService.getId(), Boolean.FALSE);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: z1 */
    public void mo16735z1() {
        RelativeLayout relativeLayout = this.f12611f0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f12598Y0.put("addressbook", Boolean.FALSE);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = this.f12613g0;
        if (disableSupportedRelativeLayout != null && disableSupportedRelativeLayout.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12598Y0.put(HNConstants.DataType.MEDIA, Boolean.FALSE);
        }
        RelativeLayout relativeLayout2 = this.f12615h0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.f12598Y0.put("calendar", Boolean.FALSE);
        }
        RelativeLayout relativeLayout3 = this.f12617i0;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
            this.f12598Y0.put("notepad", Boolean.FALSE);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = this.f12619j0;
        if (disableSupportedRelativeLayout2 != null && disableSupportedRelativeLayout2.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12598Y0.put("wlan", Boolean.FALSE);
        }
        RelativeLayout relativeLayout4 = this.f12621k0;
        if (relativeLayout4 == null || relativeLayout4.getVisibility() != 0) {
            return;
        }
        this.f12598Y0.put("browser", Boolean.FALSE);
    }
}
