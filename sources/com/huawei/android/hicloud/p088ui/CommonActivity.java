package com.huawei.android.hicloud.p088ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p681uj.C13195l;
import sk.C12806c;
import sk.C12808e;

/* loaded from: classes3.dex */
public class CommonActivity extends EntrancePermissionCheckActivity {

    /* renamed from: h */
    public List<View> f13428h = new ArrayList();

    /* renamed from: X0 */
    public List<View> mo18477X0() {
        return null;
    }

    /* renamed from: Y0 */
    public void m18478Y0() {
        if (!C11842p.m70753O0(this) || C11842p.m70771U0()) {
            C0209d.m1159C2(this);
            return;
        }
        Window window = getWindow();
        if (window == null) {
            C11839m.m70687e("CommonActivity", "hideStatusBar window is null!");
        } else {
            window.addFlags(1024);
        }
    }

    /* renamed from: Z0 */
    public void m18479Z0() {
        List<View> listMo18477X0 = mo18477X0();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listMo18477X0);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listMo18477X0);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m18480a1(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: a1 */
    public void m18480a1(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f13428h.addAll(list);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8801) {
            C13195l.m79272J().m79301Q(this, i10, i11, intent);
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C12806c.m76820k(this, this.f13428h);
        m18478Y0();
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C11829c.m70591k1(this);
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024);
        }
        C12808e.m76822a(this);
        m18478Y0();
    }
}
