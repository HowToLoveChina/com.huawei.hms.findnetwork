package com.huawei.openalliance.p169ad;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.android.app.ActionBarEx;
import com.huawei.android.app.ActivityManagerEx;
import com.huawei.android.app.HwMultiWindowEx;
import com.huawei.android.app.PackageManagerEx;
import com.huawei.android.content.pm.ApplicationInfoEx;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.provider.SettingsEx;
import com.huawei.android.view.DisplaySideRegionEx;
import com.huawei.android.view.WindowManagerEx;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.openalliance.p169ad.utils.C7772bs;
import com.huawei.openalliance.p169ad.utils.InterfaceC7769bp;

/* renamed from: com.huawei.openalliance.ad.cl */
/* loaded from: classes8.dex */
public class C6995cl extends C6988ce {

    /* renamed from: a */
    private static InterfaceC7000cq f32129a;

    /* renamed from: b */
    private static final byte[] f32130b = new byte[0];

    private C6995cl(Context context) {
    }

    /* renamed from: b */
    public static InterfaceC7000cq m41224b(Context context) {
        return m41225c(context);
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public int mo41198a(Context context) {
        return SettingsEx.getIntForUser(context.getContentResolver(), "accessibility_screenreader_enabled", -1, ActivityManagerEx.getCurrentUser());
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: c */
    public int mo41206c() {
        return HwFoldScreenManagerEx.getDisplayMode();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: d */
    public boolean mo41207d() {
        return HwFoldScreenManagerEx.isFoldable();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: e */
    public String mo41208e() {
        return EmuiUtil.BUILDEX_VERSION;
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: f */
    public String mo41209f() {
        return "com.huawei.android.os.BuildEx";
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: g */
    public boolean mo41210g() {
        return PackageManagerEx.hasHwSystemFeature("com.huawei.hardware.screen.type.eink");
    }

    /* renamed from: c */
    private static InterfaceC7000cq m41225c(Context context) {
        InterfaceC7000cq interfaceC7000cq;
        synchronized (f32130b) {
            try {
                if (f32129a == null) {
                    f32129a = new C6995cl(context);
                }
                interfaceC7000cq = f32129a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7000cq;
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public int mo41199a(ApplicationInfo applicationInfo) {
        return new ApplicationInfoEx(applicationInfo).getHwFlags();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: b */
    public boolean mo41205b() {
        return HwMultiWindowEx.isInMultiWindowMode();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public Rect mo41200a(WindowInsets windowInsets) {
        DisplaySideRegionEx displaySideRegion = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
        if (displaySideRegion != null) {
            return displaySideRegion.getSafeInsets();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public InterfaceC7769bp mo41201a() {
        return new C7772bs();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public void mo41202a(ActionBar actionBar, boolean z10, Drawable drawable, View.OnClickListener onClickListener) {
        ActionBarEx.setStartIcon(actionBar, true, (Drawable) null, onClickListener);
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public void mo41203a(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        new WindowManagerEx.LayoutParamsEx(layoutParams).setDisplaySideMode(1);
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public boolean mo41204a(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return ActivityManagerEx.getActivityWindowMode(activity) == 102;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("HwSysApiImpl", "isFreedomWindowMode error");
            return false;
        }
    }
}
