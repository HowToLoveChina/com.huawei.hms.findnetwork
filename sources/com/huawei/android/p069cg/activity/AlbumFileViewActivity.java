package com.huawei.android.p069cg.activity;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment;

/* loaded from: classes2.dex */
public class AlbumFileViewActivity extends UIActivity {

    /* renamed from: p */
    public FragmentManager f9918p;

    /* renamed from: q */
    public AlbumFileViewFragment f9919q;

    /* renamed from: r */
    public ActionBar f9920r;

    /* renamed from: L1 */
    public void mo13290L1() {
        FragmentManager fragmentManager = getFragmentManager();
        this.f9918p = fragmentManager;
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        if (this.f9919q == null) {
            this.f9919q = new AlbumFileViewFragment();
        }
        AlbumFileViewFragment albumFileViewFragment = new AlbumFileViewFragment();
        this.f9919q = albumFileViewFragment;
        fragmentTransactionBeginTransaction.replace(R$id.fragment_container, albumFileViewFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    /* renamed from: M1 */
    public void m13291M1() {
        setContentView(R$layout.album_file_view_main_view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(9);
        super.onCreate(bundle);
        Window window = getWindow();
        int i10 = R$color.transparent;
        window.setNavigationBarColor(getColor(i10));
        getWindow().setStatusBarColor(getColor(i10));
        getWindow().setNavigationBarContrastEnforced(false);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        this.f9920r = getActionBar();
        m13291M1();
        mo13290L1();
    }
}
