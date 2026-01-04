package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupSpaceDetailAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.C4102h;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.ExpandRecyclerView;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p015ak.C0234s;
import p514o9.C11839m;
import p514o9.C11842p;
import p815ym.AbstractC14026a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ManagerBackupDataBasicView extends RelativeLayout {

    /* renamed from: a */
    public C4102h f19503a;

    /* renamed from: b */
    public final Context f19504b;

    /* renamed from: c */
    public View f19505c;

    /* renamed from: d */
    public LinearLayout f19506d;

    /* renamed from: e */
    public TextView f19507e;

    /* renamed from: f */
    public ExpandRecyclerView f19508f;

    /* renamed from: g */
    public AtomicBoolean f19509g;

    /* renamed from: h */
    public List<AppDetailsInfo> f19510h;

    public ManagerBackupDataBasicView(Context context) {
        this(context, null, 0, 0);
    }

    /* renamed from: b */
    public final void m25777b(Context context, TextView textView) {
        if (C0234s.m1643u()) {
            textView.setPadding(0, 0, 0, (int) C11842p.m70844o(context, 2));
        }
    }

    /* renamed from: c */
    public final void m25778c(Context context) {
        this.f19505c = View.inflate(context, R$layout.manager_backup_data_basic_view, this);
        this.f19506d = (LinearLayout) C12809f.m76831d(this, R$id.basic_view_footer);
        TextView textView = (TextView) C12809f.m76831d(this, R$id.tv_expand);
        this.f19507e = textView;
        textView.setCompoundDrawablePadding(C11842p.m70840n(context, 8));
        m25777b(context, this.f19507e);
        this.f19506d.setOnClickListener(new View.OnClickListener() { // from class: de.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45851a.m25779d(view);
            }
        });
        ExpandRecyclerView expandRecyclerView = (ExpandRecyclerView) C12809f.m76831d(this, R$id.expand_rcy_basic_data);
        this.f19508f = expandRecyclerView;
        expandRecyclerView.setNestedScrollingEnabled(true);
        this.f19508f.setLayoutManager(new LinearLayoutManager(this.f19504b));
        this.f19508f.setOverScrollMode(2);
        C4102h c4102h = new C4102h();
        this.f19503a = c4102h;
        this.f19508f.setAdapter(c4102h);
        setClickable(false);
    }

    /* renamed from: d */
    public final /* synthetic */ void m25779d(View view) {
        if (this.f19503a == null) {
            return;
        }
        this.f19509g.set(!r2.get());
        this.f19503a.m25522H(this.f19509g.get());
        this.f19507e.setText(this.f19509g.get() ? R$string.collapse : R$string.backup_detail_more);
        this.f19507e.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f19509g.get() ? getResources().getDrawable(R$drawable.up_arrow) : getResources().getDrawable(R$drawable.down_arrow), (Drawable) null);
    }

    /* renamed from: e */
    public void m25780e(List<AppDetailsInfo> list, boolean z10) {
        if (AbstractC14026a.m84159a(list)) {
            this.f19505c.setVisibility(8);
            C11839m.m70689w("ManagerBackupDataBasicView", "setBaseData basicItemList is empty");
            return;
        }
        this.f19510h = list;
        AtomicBoolean atomicBoolean = this.f19509g;
        if (atomicBoolean == null) {
            atomicBoolean = new AtomicBoolean(false);
        }
        this.f19509g = atomicBoolean;
        if (!z10 || list.size() <= 2) {
            this.f19506d.setVisibility(8);
        } else {
            this.f19506d.setVisibility(0);
        }
        this.f19505c.setVisibility(0);
        if (this.f19503a == null) {
            C4102h c4102h = new C4102h();
            this.f19503a = c4102h;
            this.f19508f.setAdapter(c4102h);
        }
        if (!z10) {
            this.f19503a.m25522H(true);
        }
        this.f19503a.m25523I(list);
    }

    public List<AppDetailsInfo> getBasicItemList() {
        return this.f19510h;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        C4102h c4102h = this.f19503a;
        if (c4102h != null) {
            c4102h.m25524J(onClickListener);
        }
    }

    public void setDeleteBackupModuleListener(BackupSpaceDetailAdapter.DeleteBackupModuleListener deleteBackupModuleListener) {
        C4102h c4102h = this.f19503a;
        if (c4102h != null) {
            c4102h.m25521G(deleteBackupModuleListener);
        }
    }

    public ManagerBackupDataBasicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public ManagerBackupDataBasicView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ManagerBackupDataBasicView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f19504b = context;
        m25778c(context);
    }
}
