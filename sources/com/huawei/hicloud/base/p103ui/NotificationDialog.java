package com.huawei.hicloud.base.p103ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import com.huawei.hicloud.base.R$id;
import com.huawei.hicloud.base.R$layout;
import com.huawei.hicloud.base.R$style;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p399jk.AbstractC10896a;
import sk.C12809f;

/* loaded from: classes6.dex */
public class NotificationDialog extends Dialog {

    /* renamed from: a */
    public Context f22156a;

    /* renamed from: b */
    public TextView f22157b;

    /* renamed from: c */
    public TextView f22158c;

    public NotificationDialog(Context context) {
        this(context, R$style.permission_dialog_info_style);
    }

    /* renamed from: a */
    public final void m29118a() {
        try {
            Window window = getWindow();
            if (window != null) {
                window.setGravity(49);
                window.setDimAmount(0.0f);
                window.setLayout(-1, -2);
                if (C0209d.m1170F1() || C0209d.m1233a1()) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = C0209d.m1292p0(this.f22156a);
                    window.setAttributes(attributes);
                }
                window.setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK, HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
                window.setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            }
        } catch (Exception unused) {
            AbstractC10896a.m65887i("NotificationDialog", "setDialogTheme err");
        }
    }

    /* renamed from: b */
    public void m29119b(String str, String str2) {
        try {
            TextView textView = this.f22157b;
            if (textView != null) {
                textView.setText(str);
            }
            TextView textView2 = this.f22158c;
            if (textView2 != null) {
                textView2.setText(str2);
            }
            show();
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f22156a.getSystemService("accessibility");
            if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(',');
            sb2.append(str2);
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
            accessibilityEventObtain.setPackageName("com.huawei.hidisk");
            accessibilityEventObtain.getText().add(sb2);
            accessibilityEventObtain.setAction(1);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        } catch (Exception unused) {
            AbstractC10896a.m65887i("NotificationDialog", "showDialog err");
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = View.inflate(this.f22156a, R$layout.dialog_permission_notice, null);
        setContentView(viewInflate);
        m29118a();
        setCancelable(true);
        this.f22157b = (TextView) C12809f.m76831d(viewInflate, R$id.tv_title);
        this.f22158c = (TextView) C12809f.m76831d(viewInflate, R$id.tv_detail);
    }

    public NotificationDialog(Context context, int i10) {
        super(context, i10);
        this.f22156a = context;
    }
}
