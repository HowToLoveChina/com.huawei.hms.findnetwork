package com.huawei.openalliance.p169ad.activity;

import android.R;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

/* renamed from: com.huawei.openalliance.ad.activity.c */
/* loaded from: classes8.dex */
public abstract class AbstractActivityC6903c extends AbstractActivityC6905e {
    @TargetApi(21)
    /* renamed from: a */
    private void m38784a(final View view) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            final Toolbar toolbar = (Toolbar) view.getParent();
            if (toolbar != null) {
                toolbar.setLayoutParams(layoutParams);
            }
            view.post(new Runnable() { // from class: com.huawei.openalliance.ad.activity.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TypedValue typedValue = new TypedValue();
                        int iMax = Math.max(view.getHeight(), AbstractActivityC6903c.this.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, AbstractActivityC6903c.this.getResources().getDisplayMetrics()) : 0);
                        if (iMax > 0) {
                            toolbar.setMinimumHeight(iMax);
                        }
                    } catch (Throwable unused) {
                        AbstractC7185ho.m43823c("BasePureWebActivity", "set toolBar min height error.");
                    }
                }
            });
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("BasePureWebActivity", "setCustomToolBar error.");
        }
    }

    /* renamed from: d */
    private void m38785d() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null || !m38786e()) {
            return;
        }
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        if (m38787c() == 0 && AbstractC7806cz.m48165b(mo38589b())) {
            return;
        }
        if (C6982bz.m41152b(this)) {
            if (AbstractC7806cz.m48165b(mo38589b())) {
                actionBar.setTitle(m38787c());
                return;
            } else {
                actionBar.setTitle(mo38589b());
                return;
            }
        }
        View viewInflate = getLayoutInflater().inflate(C6849R.layout.action_bar_title_layout, (ViewGroup) null);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(viewInflate);
        m38784a(viewInflate);
        if (AbstractC7806cz.m48165b(mo38589b())) {
            ((TextView) findViewById(C6849R.id.custom_action_bar_title)).setText(m38787c());
        } else {
            ((TextView) findViewById(C6849R.id.custom_action_bar_title)).setText(mo38589b());
        }
    }

    /* renamed from: e */
    private boolean m38786e() {
        return true;
    }

    /* renamed from: b */
    public String mo38589b() {
        return "";
    }

    /* renamed from: c */
    public int m38787c() {
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m38785d();
    }
}
