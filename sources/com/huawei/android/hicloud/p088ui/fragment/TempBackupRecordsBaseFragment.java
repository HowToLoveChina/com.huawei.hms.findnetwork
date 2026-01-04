package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public abstract class TempBackupRecordsBaseFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    public Context f18261a;

    /* renamed from: b */
    public View f18262b;

    /* renamed from: c */
    public HwRecyclerView f18263c;

    /* renamed from: d */
    public ScrollDisabledListView f18264d;

    /* renamed from: a */
    public abstract void mo24310a();

    /* renamed from: b */
    public abstract void mo24311b(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        mo24311b(view);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        C11839m.m70688i("TempBackupRecordsBaseFragment", "onCreateView: ");
        View view = this.f18262b;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18262b);
        }
        View viewInflate = layoutInflater.inflate(R$layout.fragment_temp_backup_records, viewGroup, false);
        this.f18262b = viewInflate;
        viewInflate.setVisibility(8);
        this.f18263c = (HwRecyclerView) C12809f.m76831d(this.f18262b, R$id.temp_devices_recycler_view);
        this.f18264d = (ScrollDisabledListView) C12809f.m76831d(this.f18262b, R$id.temp_devices_list_view);
        mo24310a();
        return this.f18262b;
    }

    @Override // android.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        C11839m.m70688i("TempBackupRecordsBaseFragment", "onInflate: ");
        super.onInflate(context, attributeSet, bundle);
        this.f18261a = context;
    }
}
