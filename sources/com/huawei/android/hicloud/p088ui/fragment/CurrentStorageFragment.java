package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.android.hicloud.task.simple.C3098y;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.BackUpOverMonthRecordConstants;
import p015ak.C0209d;
import p015ak.C0214f0;
import p459lp.C11333k;
import p514o9.C11836j;
import p514o9.C11839m;
import p616rk.C12515a;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CurrentStorageFragment extends Fragment {

    /* renamed from: d */
    public View f18084d;

    /* renamed from: a */
    public TextView f18081a = null;

    /* renamed from: b */
    public TextView f18082b = null;

    /* renamed from: c */
    public ProgressBar f18083c = null;

    /* renamed from: e */
    public Handler f18085e = new HandlerC3957a();

    /* renamed from: com.huawei.android.hicloud.ui.fragment.CurrentStorageFragment$a */
    public class HandlerC3957a extends Handler {
        public HandlerC3957a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            if (17034 == message.what && CurrentStorageFragment.this.isAdded() && (data = message.getData()) != null) {
                String string = data.getString(BackUpOverMonthRecordConstants.Report.AVAILABLE_SPACE);
                long j10 = data.getLong("available_space_value");
                String string2 = data.getString("total_space");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    return;
                }
                CurrentStorageFragment.this.f18081a.setText(CurrentStorageFragment.this.getString(R$string.current_storage_new, string));
                if (C13843a.m83067S()) {
                    CurrentStorageFragment.this.f18082b.setText(CurrentStorageFragment.this.getString(R$string.current_total_storage, string2));
                } else {
                    CurrentStorageFragment.this.f18082b.setText(" " + CurrentStorageFragment.this.getString(R$string.current_total_storage, string2));
                }
                float f10 = data.getFloat("available_percentage");
                C11839m.m70688i("CurrentStorageFragment", "handleMessage percentage = " + f10 + " availableStorageValue = " + j10);
                CurrentStorageFragment.this.m24131e(f10, j10);
            }
        }
    }

    /* renamed from: d */
    public void m24130d() {
        m24132f();
        if (C0209d.m1208S0(getContext())) {
            C12515a.m75110o().m75175e(new C3098y(getContext(), this.f18085e), false);
        }
    }

    /* renamed from: e */
    public final void m24131e(float f10, long j10) {
        int i10 = 10000 - ((int) (f10 * 10000.0f));
        boolean zM68091f = C11333k.m68086b().m68091f(j10);
        C11839m.m70688i("CurrentStorageFragment", "refreshUsageBar spaceFlags = " + zM68091f + " availableStorage = " + j10);
        if (zM68091f) {
            this.f18083c.setProgressDrawable(getResources().getDrawable(R$drawable.storage_progress_layer_red));
            this.f18083c.setProgress(i10);
        } else {
            this.f18083c.setProgressDrawable(getResources().getDrawable(R$drawable.storage_progress_layer));
            this.f18083c.setProgress(i10);
        }
    }

    /* renamed from: f */
    public final void m24132f() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext().getApplicationContext(), "com.huawei.android.ds_spcace_detail_cache", 0);
        long j10 = sharedPreferencesM1382b.getLong("cloudSpaceAvailableSizeValue", -1L);
        String str = "";
        String string = sharedPreferencesM1382b.getString("cloudSpaceAvailableSize", "");
        String string2 = sharedPreferencesM1382b.getString("cloudSpaceTotalSize", "");
        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string2)) {
            string2 = "";
        } else {
            str = string;
        }
        this.f18081a.setText(getString(R$string.current_storage_new, str));
        if (C13843a.m83067S()) {
            this.f18082b.setText(getString(R$string.current_total_storage, string2));
        } else {
            this.f18082b.setText(" " + getString(R$string.current_total_storage, string2));
        }
        C11839m.m70688i("CurrentStorageFragment", "usingStorageCache availableStr = " + str + " mLong " + j10);
        m24131e(C11836j.m70658k().m70668j(), j10);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        C11839m.m70686d("CurrentStorageFragment", "superview = " + super.onCreateView(layoutInflater, viewGroup, bundle));
        View view = this.f18084d;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18084d);
        }
        View viewInflate = layoutInflater.inflate(R$layout.current_storage, viewGroup, false);
        this.f18084d = viewInflate;
        this.f18081a = (TextView) C12809f.m76831d(viewInflate, R$id.current_storage);
        this.f18082b = (TextView) C12809f.m76831d(this.f18084d, R$id.current_total_storage);
        this.f18083c = (ProgressBar) C12809f.m76831d(this.f18084d, R$id.storage_progress);
        return this.f18084d;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m24130d();
    }
}
