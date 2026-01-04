package com.huawei.android.p069cg.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.activity.fragment.PicTabAlbumFileViewFragment;

/* loaded from: classes2.dex */
public class PicTabAlbumFileViewActivity extends AlbumFileViewActivity {
    @Override // com.huawei.android.p069cg.activity.AlbumFileViewActivity
    /* renamed from: L1 */
    public void mo13290L1() {
        FragmentManager fragmentManager = getFragmentManager();
        this.f9918p = fragmentManager;
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        if (this.f9919q == null) {
            this.f9919q = new PicTabAlbumFileViewFragment();
        }
        PicTabAlbumFileViewFragment picTabAlbumFileViewFragment = new PicTabAlbumFileViewFragment();
        this.f9919q = picTabAlbumFileViewFragment;
        fragmentTransactionBeginTransaction.replace(R$id.fragment_container, picTabAlbumFileViewFragment);
        fragmentTransactionBeginTransaction.commit();
    }
}
