package com.huawei.uikit.phone.hwsubtab.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import com.huawei.uikit.hwsubtab.widget.HwSubTab;
import com.huawei.uikit.hwsubtab.widget.HwSubTabWidget;
import com.huawei.uikit.phone.hwsubtab.C8768R;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwKeyEventDetector;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes9.dex */
public class HwSubTabWidget extends com.huawei.uikit.hwsubtab.widget.HwSubTabWidget {

    /* renamed from: j */
    private static final int f45033j = 8;

    /* renamed from: k */
    private static final int f45034k = 28;

    /* renamed from: l */
    private static final int f45035l = 32;

    /* renamed from: m */
    private static final float f45036m = 1.75f;

    /* renamed from: a */
    private int f45037a;

    /* renamed from: b */
    private HwColumnSystem f45038b;

    /* renamed from: c */
    private String f45039c;

    /* renamed from: d */
    private boolean f45040d;

    /* renamed from: e */
    private int f45041e;

    /* renamed from: f */
    private int f45042f;

    /* renamed from: g */
    private float f45043g;

    /* renamed from: h */
    private Context f45044h;

    /* renamed from: i */
    private SubTabView f45045i;

    public class SubTabView extends HwSubTabWidget.SubTabView {
        public SubTabView(Context context, HwSubTab hwSubTab) {
            super(context, hwSubTab);
        }

        @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabWidget.SubTabView, android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            if (accessibilityNodeInfo == null) {
                return;
            }
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (getEventBadgeDrawable() == null || getEventBadgeDrawable().getBadgeCount() == 0) {
                return;
            }
            accessibilityNodeInfo.setHintText(HwSubTabWidget.this.f45039c);
        }

        @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabWidget.SubTabView
        public void setViewHorizontalPadding() {
            if (HwSubTabWidget.this.f45038b.getTotalColumnCount() >= 8) {
                setPadding(HwSubTabWidget.this.getSubTabItemPaddingSecondary(), 0, HwSubTabWidget.this.getSubTabItemPaddingSecondary(), 0);
                HwSubTabWidget.this.setSubTabLeftScrollPadding(32);
            } else {
                setPadding(HwSubTabWidget.this.getSubTabItemPadding(), 0, HwSubTabWidget.this.getSubTabItemPadding(), 0);
                HwSubTabWidget.this.setSubTabLeftScrollPadding(28);
            }
        }
    }

    public HwSubTabWidget(Context context) {
        this(context, null);
    }

    public void configureColumn(int i10, int i11, float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 > 0 && i11 > 0 && f10 > 0.0f) {
            this.f45041e = i10;
            this.f45042f = i11;
            this.f45043g = f10;
            this.f45040d = true;
            m56006b(this.f45038b);
        } else {
            if (!this.f45040d) {
                return;
            }
            this.f45040d = false;
            m56004a(this.f45038b);
        }
        SubTabView subTabView = this.f45045i;
        if (subTabView != null) {
            subTabView.setViewHorizontalPadding();
        }
    }

    public int getStartOriginPadding() {
        return this.mSubTabContainer.getStartOriginPadding();
    }

    public int getStartScrollPadding() {
        return this.mSubTabContainer.getStartScrollPadding();
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabWidget, android.view.View
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onConfigurationChanged(configuration);
        if (this.f45040d) {
            m56006b(this.f45038b);
        } else {
            m56004a(this.f45038b);
        }
    }

    public HwSubTabWidget(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.f45037a = -1;
        m56003a(context, attributeSet);
    }

    /* renamed from: a */
    private void m56003a(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f45044h = context;
        this.f45039c = getResources().getString(C8768R.string.new_message);
        HwColumnSystem hwColumnSystem = new HwColumnSystem(context);
        this.f45038b = hwColumnSystem;
        hwColumnSystem.setColumnType(this.f45037a);
        this.f45038b.updateConfigation(context);
        m56002a();
    }

    /* renamed from: b */
    private void m56006b(HwColumnSystem hwColumnSystem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        hwColumnSystem.setColumnType(-1);
        hwColumnSystem.updateConfigation(this.f45044h, this.f45041e, this.f45042f, this.f45043g);
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabWidget
    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(getContext());
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabWidget
    public SubTabView getSubTabView(HwSubTab hwSubTab) {
        SubTabView subTabView = new SubTabView(getContext(), hwSubTab);
        this.f45045i = subTabView;
        return subTabView;
    }

    public HwSubTabWidget(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i10);
        this.f45037a = -1;
        m56003a(context, attributeSet);
    }

    /* renamed from: a */
    private void m56002a() {
        if (Float.compare(this.f45044h.getResources().getConfiguration().fontScale, 1.75f) >= 0) {
            setActivatedTextSize(this.f45044h.getResources().getDimensionPixelSize(C8768R.dimen.emui_text_size_headline6_medium), this.f45044h.getResources().getDimensionPixelSize(C8768R.dimen.emui_text_size_headline7_medium));
            setSubTabItemPadding(this.f45044h.getResources().getDimensionPixelSize(C8768R.dimen.hwsubtab_item_padding_larger));
        }
    }

    /* renamed from: a */
    private void m56004a(HwColumnSystem hwColumnSystem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        hwColumnSystem.setColumnType(-1);
        hwColumnSystem.updateConfigation(this.f45044h);
    }
}
