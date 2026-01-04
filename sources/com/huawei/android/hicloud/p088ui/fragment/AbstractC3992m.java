package com.huawei.android.hicloud.p088ui.fragment;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.huawei.android.hicloud.p088ui.activity.UpgradeIntroductionActivity;
import com.huawei.android.hicloud.p088ui.uiextend.GifImageView;
import com.huawei.android.hicloud.p088ui.uiextend.bean.DecodeGifResult;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.fragment.m */
/* loaded from: classes3.dex */
public abstract class AbstractC3992m extends Fragment {

    /* renamed from: c0 */
    public View f18342c0;

    /* renamed from: d0 */
    public HwTextView f18343d0;

    /* renamed from: e0 */
    public HwTextView f18344e0;

    /* renamed from: f0 */
    public ImageView f18345f0;

    /* renamed from: g0 */
    public GifImageView f18346g0;

    /* renamed from: h0 */
    public RelativeLayout f18347h0;

    /* renamed from: i0 */
    public Runnable f18348i0;

    /* renamed from: j0 */
    public Handler f18349j0 = new c(this);

    /* renamed from: com.huawei.android.hicloud.ui.fragment.m$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3992m.this.mo24379J1();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.m$b */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            AbstractC3992m.this.f18347h0.getViewTreeObserver().removeOnPreDrawListener(this);
            int height = AbstractC3992m.this.f18347h0.getHeight();
            int top = AbstractC3992m.this.f18347h0.getTop();
            FragmentActivity fragmentActivityM4400f = AbstractC3992m.this.m4400f();
            if (!(fragmentActivityM4400f instanceof UpgradeIntroductionActivity)) {
                return true;
            }
            ((UpgradeIntroductionActivity) fragmentActivityM4400f).m22541y0(height + top);
            return true;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.m$c */
    public static class c extends Handler {

        /* renamed from: a */
        public WeakReference<AbstractC3992m> f18352a;

        public c(AbstractC3992m abstractC3992m) {
            this.f18352a = new WeakReference<>(abstractC3992m);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IOException {
            WeakReference<AbstractC3992m> weakReference;
            AbstractC3992m abstractC3992m;
            if (message == null || (weakReference = this.f18352a) == null || (abstractC3992m = weakReference.get()) == null) {
                return;
            }
            int i10 = message.what;
            if (8 != i10) {
                if (10 == i10) {
                    abstractC3992m.m24377H1(message);
                }
            } else {
                Object obj = message.obj;
                if (obj instanceof DecodeGifResult) {
                    abstractC3992m.mo24383N1((DecodeGifResult) obj);
                }
            }
        }
    }

    /* renamed from: G1 */
    public static boolean m24372G1() {
        return C13452e.m80781L().m80842P0() ? C13452e.m80781L().m80803F0().booleanValue() : C0209d.m1202Q0();
    }

    /* renamed from: C1 */
    public void mo24373C1(Movie movie) {
    }

    /* renamed from: D1 */
    public void m24374D1() {
        this.f18348i0 = new a();
    }

    /* renamed from: E1 */
    public void m24375E1() {
    }

    /* renamed from: F1 */
    public void mo24376F1() {
        View view = this.f18342c0;
        if (view == null) {
            C11839m.m70687e("UpgradeIntroBaseFragment", "initView err, mView is null");
            return;
        }
        this.f18345f0 = (ImageView) C12809f.m76831d(view, R$id.image_background_phone_view);
        this.f18343d0 = (HwTextView) C12809f.m76831d(this.f18342c0, R$id.main_title_text);
        this.f18344e0 = (HwTextView) C12809f.m76831d(this.f18342c0, R$id.sub_title_text);
        this.f18347h0 = (RelativeLayout) C12809f.m76831d(this.f18342c0, R$id.pager_content_region);
        mo24384O1();
        m24381L1();
    }

    /* renamed from: H1 */
    public void m24377H1(Message message) {
    }

    /* renamed from: I1 */
    public void mo24378I1() {
        GifImageView gifImageView = this.f18346g0;
        if (gifImageView != null) {
            gifImageView.resetGif();
        }
        Handler handler = this.f18349j0;
        if (handler != null) {
            handler.removeCallbacks(this.f18348i0);
        }
    }

    /* renamed from: J1 */
    public void mo24379J1() {
        GifImageView gifImageView = this.f18346g0;
        if (gifImageView != null) {
            gifImageView.setCanStartGif(true);
            this.f18346g0.restartGif();
        }
    }

    /* renamed from: K1 */
    public void mo24380K1() {
        Handler handler = this.f18349j0;
        if (handler != null) {
            handler.removeCallbacks(this.f18348i0);
            this.f18349j0.postDelayed(this.f18348i0, 500L);
        }
    }

    /* renamed from: L1 */
    public void m24381L1() {
        RelativeLayout relativeLayout = this.f18347h0;
        if (relativeLayout == null) {
            C11839m.m70687e("UpgradeIntroBaseFragment", "setActivityBackHeight error, mContentRegion is null");
        } else {
            relativeLayout.getViewTreeObserver().addOnPreDrawListener(new b());
        }
    }

    /* renamed from: M1 */
    public void mo24382M1() {
    }

    /* renamed from: N1 */
    public void mo24383N1(DecodeGifResult decodeGifResult) throws IOException {
        C11839m.m70688i("UpgradeIntroBaseFragment", "setGifConfig");
        GifImageView gifImageView = decodeGifResult.gifImageView;
        Movie movie = decodeGifResult.movie;
        int i10 = decodeGifResult.resourceId;
        if (movie == null || gifImageView == null) {
            C11839m.m70687e("UpgradeIntroBaseFragment", "movie or view is null");
            return;
        }
        mo24373C1(movie);
        gifImageView.setImageResource(movie, i10);
        gifImageView.setLayerType(2, null);
    }

    /* renamed from: O1 */
    public void mo24384O1() {
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public View mo4427p0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C11839m.m70688i("UpgradeIntroBaseFragment", "onCreateView");
        Context contextM4426p = m4426p();
        if (contextM4426p == null) {
            C11839m.m70687e("UpgradeIntroBaseFragment", "context is null");
            return null;
        }
        if (C11842p.m70771U0()) {
            this.f18342c0 = layoutInflater.inflate(R$layout.upgrade_intro_pager_view_pad, viewGroup, false);
        } else if (C11842p.m70747M0(contextM4426p)) {
            this.f18342c0 = layoutInflater.inflate(R$layout.upgrade_intro_pager_view_screen_expand, viewGroup, false);
        } else {
            this.f18342c0 = layoutInflater.inflate(R$layout.upgrade_intro_pager_view, viewGroup, false);
        }
        mo24376F1();
        return this.f18342c0;
    }
}
