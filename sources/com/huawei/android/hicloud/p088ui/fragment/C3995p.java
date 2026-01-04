package com.huawei.android.hicloud.p088ui.fragment;

import android.graphics.Movie;
import android.os.Handler;
import android.view.View;
import com.huawei.android.hicloud.p088ui.uiextend.GifImageView;
import com.huawei.android.hicloud.p088ui.uiextend.bean.DecodeGifResult;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import java.io.IOException;
import java.lang.ref.WeakReference;
import p514o9.C11836j;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.fragment.p */
/* loaded from: classes3.dex */
public class C3995p extends AbstractC3992m {
    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: C1 */
    public void mo24373C1(Movie movie) {
        C11836j.m70658k().m70676s(new WeakReference<>(movie));
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: F1 */
    public void mo24376F1() {
        super.mo24376F1();
        View view = this.f18342c0;
        if (view == null) {
            C11839m.m70687e("UpgradeIntroStrongBackupFragment", "initView err, mView is null");
            return;
        }
        this.f18346g0 = (GifImageView) C12809f.m76831d(view, R$id.gif_image_view);
        m24375E1();
        m24374D1();
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: I1 */
    public void mo24378I1() {
        C11839m.m70688i("UpgradeIntroStrongBackupFragment", "resetGif");
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
    /* renamed from: J1 */
    public void mo24379J1() {
        C11839m.m70688i("UpgradeIntroStrongBackupFragment", "restartGif");
        GifImageView gifImageView = this.f18346g0;
        if (gifImageView != null) {
            gifImageView.setCanStartGif(true);
            if (this.f18346g0.restartGif()) {
                C11839m.m70686d("UpgradeIntroStrongBackupFragment", "restartGif");
                m24385P1(false);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: K1 */
    public void mo24380K1() {
        C11839m.m70688i("UpgradeIntroStrongBackupFragment", "restartGifWithDelay");
        super.mo24380K1();
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: M1 */
    public void mo24382M1() {
        m24385P1(true);
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: N1 */
    public void mo24383N1(DecodeGifResult decodeGifResult) throws IOException {
        C11839m.m70686d("UpgradeIntroStrongBackupFragment", "setGifConfig");
        super.mo24383N1(decodeGifResult);
        m24385P1(false);
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: O1 */
    public void mo24384O1() {
        super.mo24384O1();
        this.f18343d0.setText(R$string.intro_strong_backup_title);
        if (AbstractC3992m.m24372G1()) {
            this.f18344e0.setText(R$string.intro_strong_backup_sub_title);
        } else {
            this.f18344e0.setText(R$string.intro_strong_backup_oversea_sub_title);
        }
    }

    /* renamed from: P1 */
    public void m24385P1(boolean z10) {
        if (this.f18345f0 != null) {
            if (!z10) {
                C11839m.m70686d("UpgradeIntroStrongBackupFragment", "hide mBackPhoneImageView");
                this.f18345f0.setVisibility(4);
                return;
            }
            C11839m.m70686d("UpgradeIntroStrongBackupFragment", "set mBackPhoneImageView");
            this.f18345f0.setVisibility(0);
            if (AbstractC3992m.m24372G1()) {
                this.f18345f0.setImageResource(R$drawable.upgrade_intro_backup_more_phon_china);
            } else {
                this.f18345f0.setImageResource(R$drawable.upgrade_intro_backup_more_phon_oversea);
            }
        }
    }
}
