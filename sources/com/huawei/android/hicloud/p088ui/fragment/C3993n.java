package com.huawei.android.hicloud.p088ui.fragment;

import android.graphics.Movie;
import android.os.Handler;
import android.view.View;
import com.huawei.android.hicloud.p088ui.uiextend.GifImageView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import java.lang.ref.WeakReference;
import p514o9.C11836j;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.fragment.n */
/* loaded from: classes3.dex */
public class C3993n extends AbstractC3992m {
    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: C1 */
    public void mo24373C1(Movie movie) {
        C11836j.m70658k().m70675r(new WeakReference<>(movie));
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: F1 */
    public void mo24376F1() {
        super.mo24376F1();
        View view = this.f18342c0;
        if (view == null) {
            C11839m.m70687e("UpgradeIntroChooseBackupItemFragment", "initView err, mView is null");
            return;
        }
        this.f18346g0 = (GifImageView) C12809f.m76831d(view, R$id.gif_image_view);
        m24375E1();
        m24374D1();
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: I1 */
    public void mo24378I1() {
        C11839m.m70688i("UpgradeIntroChooseBackupItemFragment", "resetGif");
        GifImageView gifImageView = this.f18346g0;
        if (gifImageView != null) {
            gifImageView.resetGif();
        }
        Handler handler = this.f18349j0;
        if (handler != null) {
            handler.removeCallbacks(this.f18348i0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: K1 */
    public void mo24380K1() {
        GifImageView gifImageView = this.f18346g0;
        if (gifImageView != null) {
            gifImageView.setCanStartGif(true);
        }
        super.mo24380K1();
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: O1 */
    public void mo24384O1() {
        this.f18343d0.setText(R$string.intro_backup_title);
        this.f18344e0.setText(R$string.intro_backup_sub_title);
    }
}
