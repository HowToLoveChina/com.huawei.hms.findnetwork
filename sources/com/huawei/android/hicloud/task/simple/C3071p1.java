package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import gp.C10028c;
import hu.C10343b;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0236u;
import p020ap.C1006a;
import p020ap.C1008c;
import p335hd.C10147j;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13225d;
import p742wj.C13612b;
import p746wn.C13622a;

/* renamed from: com.huawei.android.hicloud.task.simple.p1 */
/* loaded from: classes3.dex */
public class C3071p1 extends AbstractC12367d {

    /* renamed from: a */
    public C10343b f13353a;

    /* renamed from: c */
    public Context f13355c;

    /* renamed from: b */
    public String f13354b = "";

    /* renamed from: d */
    public ArrayList<String> f13356d = new ArrayList<>();

    public C3071p1(Context context, Bundle bundle) {
        this.f13355c = context;
        this.f13353a = new C10343b(bundle);
    }

    /* renamed from: c */
    public void m18367c() {
        C13612b.m81829B().m81870k0(this.f13355c.getApplicationContext());
        String strM81958d = C13622a.m81958d("03003");
        C11839m.m70688i("OOBEInitTask", "Open sync switch, traceId: " + strM81958d);
        C12515a.m75110o().m75172d(new C10147j(this.f13355c.getApplicationContext(), this.f13356d, "03003", strM81958d));
        C1008c.m6035v().m6085l0(this.f13355c);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        boolean z10 = false;
        C0236u.m1655f(false);
        this.f13354b = this.f13353a.m63694p("channel_of_open_switch");
        m18369e("uploadphotokey", this.f13353a.m63681c("oobe_gellery"));
        m18369e("addressbook", this.f13353a.m63681c("oobe_contact") && !C0209d.m1293p1());
        m18369e("calendar", this.f13353a.m63681c("oobe_calendar"));
        m18369e("notepad", this.f13353a.m63681c("oobe_notepad") && C0209d.m1215U1(this.f13355c));
        if (this.f13353a.m63681c("oobe_browser") && !C0209d.m1293p1()) {
            z10 = true;
        }
        m18369e("browser", z10);
        m18369e("wlan", this.f13353a.m63681c("oobe_wlan"));
        m18369e("backup_key", this.f13353a.m63681c("oobe_backup"));
        if (this.f13356d.size() > 0) {
            m18367c();
            if (C10028c.m62182c0().m62388s("backup_key")) {
                CloudBackupService.getInstance().cloudbackupOpr(true);
            }
        }
        C11839m.m70688i("OOBEInitTask", "oobe switch to ds");
        C1008c.m6035v().m6061Z("dsswitch");
    }

    /* renamed from: d */
    public void m18368d(String str) {
        C10028c.m62182c0().m62336h2(str, true);
    }

    /* renamed from: e */
    public void m18369e(String str, boolean z10) {
        C10028c.m62182c0().m62336h2(str, z10);
        if (z10) {
            if ("uploadphotokey".equals(str)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("GeneralAblum", true);
                bundle.putBoolean("ShareAlbum", true);
                C1006a.m5936k().m5943G(this.f13355c, bundle, 9);
                this.f13356d.add("atlas");
                return;
            }
            if ("addressbook".equals(str)) {
                m18368d("addressbook");
                this.f13356d.add(str);
                return;
            }
            if ("calendar".equals(str)) {
                m18368d("calendar");
                this.f13356d.add(str);
                return;
            }
            if ("notepad".equals(str)) {
                m18368d("notepad");
                this.f13356d.add(str);
                return;
            }
            if ("browser".equals(str)) {
                m18368d("browser");
                this.f13356d.add(str);
            } else if ("wlan".equals(str)) {
                m18368d("wlan");
                this.f13356d.add(str);
            } else if ("backup_key".equals(str)) {
                CloudBackupService.getInstance().cloudbackupOpr(true);
                C13225d.m79490f1().m79558J0(this.f13354b);
            }
        }
    }
}
