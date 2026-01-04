package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.C4083c;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.ExpandRecyclerView;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p015ak.C0234s;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupOptionBasicDataView extends RelativeLayout {

    /* renamed from: a */
    public C4083c f19353a;

    /* renamed from: b */
    public View f19354b;

    /* renamed from: c */
    public LinearLayout f19355c;

    /* renamed from: d */
    public TextView f19356d;

    /* renamed from: e */
    public ExpandRecyclerView f19357e;

    /* renamed from: f */
    public AtomicBoolean f19358f;

    /* renamed from: g */
    public List<BackupOptionItem> f19359g;

    public BackupOptionBasicDataView(Context context) {
        this(context, null, 0, 0);
    }

    /* renamed from: b */
    public final void m25669b(Context context, TextView textView) {
        if (C0234s.m1643u()) {
            textView.setPadding(0, 0, 0, (int) C11842p.m70844o(context, 2));
        }
    }

    /* renamed from: c */
    public final void m25670c(Context context) {
        this.f19354b = View.inflate(context, R$layout.backup_option_basic_view, this);
        this.f19355c = (LinearLayout) C12809f.m76831d(this, R$id.basic_view_footer);
        TextView textView = (TextView) C12809f.m76831d(this, R$id.tv_expand);
        this.f19356d = textView;
        textView.setCompoundDrawablePadding(C11842p.m70840n(context, 8));
        m25669b(context, this.f19356d);
        this.f19355c.setOnClickListener(new View.OnClickListener() { // from class: de.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45836a.m25671d(view);
            }
        });
        ExpandRecyclerView expandRecyclerView = (ExpandRecyclerView) C12809f.m76831d(this, R$id.expand_rcy_basic_data);
        this.f19357e = expandRecyclerView;
        expandRecyclerView.setNestedScrollingEnabled(true);
        this.f19357e.setLayoutManager(new LinearLayoutManager(context));
        this.f19357e.setOverScrollMode(2);
        C4083c c4083c = new C4083c();
        this.f19353a = c4083c;
        this.f19357e.setAdapter(c4083c);
        setClickable(false);
    }

    /* renamed from: d */
    public final /* synthetic */ void m25671d(View view) {
        if (this.f19353a == null) {
            return;
        }
        this.f19358f.set(!r2.get());
        this.f19353a.m25367H(this.f19358f.get());
        this.f19356d.setText(this.f19358f.get() ? R$string.collapse : R$string.backup_detail_more);
        this.f19356d.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f19358f.get() ? getResources().getDrawable(R$drawable.up_arrow) : getResources().getDrawable(R$drawable.down_arrow), (Drawable) null);
    }

    /* renamed from: e */
    public void m25672e(BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener) {
        C4083c c4083c = this.f19353a;
        if (c4083c != null) {
            c4083c.m25366G(updateOptionStatusListener);
        }
    }

    /* renamed from: f */
    public void m25673f(List<BackupOptionItem> list, boolean z10) {
        if (AbstractC14026a.m84159a(list) || !C13452e.m80781L().m80887a1()) {
            this.f19354b.setVisibility(8);
            C11839m.m70689w("BackupOptionBasicDataView", "setBaseData basicItemList is empty");
            return;
        }
        C11839m.m70688i("BackupOptionBasicDataView", "basic header setBaseData:" + list.size());
        this.f19359g = list;
        AtomicBoolean atomicBoolean = this.f19358f;
        if (atomicBoolean == null) {
            atomicBoolean = new AtomicBoolean(false);
        }
        this.f19358f = atomicBoolean;
        if (!z10 || list.size() <= 3) {
            this.f19355c.setVisibility(8);
        } else {
            this.f19355c.setVisibility(0);
        }
        this.f19354b.setVisibility(0);
        if (this.f19353a == null) {
            C4083c c4083c = new C4083c();
            this.f19353a = c4083c;
            this.f19357e.setAdapter(c4083c);
        }
        if (!z10) {
            this.f19353a.m25367H(true);
        }
        this.f19353a.m25368I(list);
    }

    public void setModuleSwitch(List<BackupOptionItem> list) {
        if (AbstractC14026a.m84159a(list)) {
            this.f19354b.setVisibility(8);
            C11839m.m70689w("BackupOptionBasicDataView", "setBaseData basicItemList is empty");
            return;
        }
        this.f19359g = list;
        if (this.f19353a == null) {
            C4083c c4083c = new C4083c();
            this.f19353a = c4083c;
            this.f19357e.setAdapter(c4083c);
        }
        this.f19353a.m25368I(list);
    }

    public BackupOptionBasicDataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public BackupOptionBasicDataView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public BackupOptionBasicDataView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        m25670c(context);
    }
}
