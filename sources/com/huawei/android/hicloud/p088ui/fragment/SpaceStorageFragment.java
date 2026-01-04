package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.hicloud.p088ui.views.GradientCircleProgress;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.bean.SpaceFormatSplit;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import gl.C9961b;
import hu.C10343b;
import java.lang.ref.WeakReference;
import p015ak.C0223k;
import p459lp.C11333k;
import p514o9.C11839m;
import p664u0.C13108a;
import p703v8.C13368e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SpaceStorageFragment extends Fragment {

    /* renamed from: a */
    public View f18222a;

    /* renamed from: b */
    public GradientCircleProgress f18223b;

    /* renamed from: c */
    public HwTextView f18224c;

    /* renamed from: d */
    public HwTextView f18225d;

    /* renamed from: e */
    public C3975c f18226e;

    /* renamed from: f */
    public HandlerC3974b f18227f;

    /* renamed from: g */
    public boolean f18228g = false;

    /* renamed from: com.huawei.android.hicloud.ui.fragment.SpaceStorageFragment$b */
    public static class HandlerC3974b extends Handler {

        /* renamed from: a */
        public final WeakReference<SpaceStorageFragment> f18229a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SpaceStorageFragment spaceStorageFragment = this.f18229a.get();
            if (spaceStorageFragment == null) {
                C11839m.m70689w("SpaceStorageFragment", "fragment null");
                return;
            }
            C11839m.m70688i("SpaceStorageFragment", "handleMessage: " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                spaceStorageFragment.m24299h();
            } else if (i10 == 2) {
                spaceStorageFragment.f18228g = true;
            }
        }

        public HandlerC3974b(SpaceStorageFragment spaceStorageFragment) {
            super(Looper.getMainLooper());
            this.f18229a = new WeakReference<>(spaceStorageFragment);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.SpaceStorageFragment$c */
    public static class C3975c extends BroadcastReceiver {

        /* renamed from: a */
        public final Handler f18230a;

        public C3975c(Handler handler) {
            this.f18230a = handler;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70689w("SpaceStorageFragment", "intent null");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (!"com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED".equals(hiCloudSafeIntent.getAction())) {
                if ("ACTION_BACKUP_DEVICE_DELETE_REFRESH".equals(hiCloudSafeIntent.getAction())) {
                    C11839m.m70688i("SpaceStorageFragment", "queryQuotaInfo refreshing");
                    Handler handler = this.f18230a;
                    if (handler != null) {
                        Message.obtain(handler, 2).sendToTarget();
                        return;
                    }
                    return;
                }
                return;
            }
            int iM63686h = new C10343b(hiCloudSafeIntent.getExtras()).m63686h("result");
            C11839m.m70688i("SpaceStorageFragment", "storage_query_finished_action result=" + iM63686h);
            Handler handler2 = this.f18230a;
            if (handler2 != null) {
                Message.obtain(handler2, 1, Integer.valueOf(iM63686h)).sendToTarget();
            }
        }
    }

    /* renamed from: c */
    public final int m24294c(QuotaSpaceInfo quotaSpaceInfo) {
        if (quotaSpaceInfo == null || quotaSpaceInfo.getTotal() == 0) {
            return 0;
        }
        int used = (int) ((quotaSpaceInfo.getUsed() * 100.0f) / quotaSpaceInfo.getTotal());
        if (quotaSpaceInfo.getUsed() == 0 || used != 0) {
            return used;
        }
        return 1;
    }

    /* renamed from: d */
    public final void m24295d() {
        C11839m.m70688i("SpaceStorageFragment", "queryQuotaInfo");
        C9961b.m61788i().m61810x(C13368e.m80184F().m80224M());
        C13368e.m80184F().m80250o0();
    }

    /* renamed from: e */
    public final void m24296e() {
        if (this.f18226e == null) {
            this.f18226e = new C3975c(this.f18227f);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED");
            intentFilter.addAction("ACTION_BACKUP_DEVICE_DELETE_REFRESH");
            C13108a.m78878b(getActivity()).m78880c(this.f18226e, intentFilter);
        }
    }

    /* renamed from: f */
    public final void m24297f() {
        this.f18223b = (GradientCircleProgress) C12809f.m76831d(this.f18222a, R$id.storage_used_progress);
        this.f18224c = (HwTextView) C12809f.m76831d(this.f18222a, R$id.storage_tips_text);
        this.f18225d = (HwTextView) C12809f.m76831d(this.f18222a, R$id.storage_size_text);
    }

    /* renamed from: g */
    public final void m24298g() {
        if (this.f18228g) {
            this.f18228g = false;
            C11839m.m70688i("SpaceStorageFragment", "refreshing");
            C13368e.m80184F().m80250o0();
        }
    }

    /* renamed from: h */
    public final void m24299h() {
        C11839m.m70686d("SpaceStorageFragment", "refreshUsedTotalSpace");
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L == null) {
            C11839m.m70687e("SpaceStorageFragment", "refreshUsedTotalSpace totalInfo null");
            return;
        }
        long available = quotaSpaceInfoM80223L.getAvailable();
        long used = quotaSpaceInfoM80223L.getUsed();
        long total = quotaSpaceInfoM80223L.getTotal();
        SpaceFormatSplit spaceFormatSplitM83088j = C13843a.m83088j(getActivity(), used);
        String strM1526i = C0223k.m1526i(getActivity(), used, 1024, true, true);
        String strM1526i2 = C0223k.m1526i(getActivity(), total, 1024, true, true);
        if (spaceFormatSplitM83088j == null || TextUtils.isEmpty(spaceFormatSplitM83088j.getUnit()) || TextUtils.isEmpty(strM1526i2)) {
            C11839m.m70688i("SpaceStorageFragment", "msg_get_cloud_space_success query storage failed");
        } else {
            boolean zM68090e = C11333k.m68086b().m68090e(available);
            String string = getString(R$string.used_space, getString(R$string.main_space_display_divider, strM1526i, strM1526i2));
            HwTextView hwTextView = this.f18225d;
            if (hwTextView != null) {
                hwTextView.setText(string);
            }
            if (zM68090e) {
                HwTextView hwTextView2 = this.f18224c;
                if (hwTextView2 != null) {
                    hwTextView2.setText(R$string.sapce_fill_detail_title);
                }
                GradientCircleProgress gradientCircleProgress = this.f18223b;
                if (gradientCircleProgress != null) {
                    gradientCircleProgress.setProgress(m24294c(quotaSpaceInfoM80223L));
                }
            } else if (available < total / 10) {
                HwTextView hwTextView3 = this.f18224c;
                if (hwTextView3 != null) {
                    hwTextView3.setText(R$string.sapce_detail_will_fill_title);
                }
                GradientCircleProgress gradientCircleProgress2 = this.f18223b;
                if (gradientCircleProgress2 != null) {
                    gradientCircleProgress2.setProgress(m24294c(quotaSpaceInfoM80223L));
                }
            } else {
                HwTextView hwTextView4 = this.f18224c;
                if (hwTextView4 != null) {
                    hwTextView4.setText(R$string.space_clear_space_enough);
                }
                GradientCircleProgress gradientCircleProgress3 = this.f18223b;
                if (gradientCircleProgress3 != null) {
                    gradientCircleProgress3.setProgress(m24294c(quotaSpaceInfoM80223L));
                }
            }
        }
        C9961b.m61788i().m61810x(quotaSpaceInfoM80223L);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        View view = this.f18222a;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18222a);
        }
        this.f18222a = layoutInflater.inflate(R$layout.item_space_clear_storage, viewGroup, false);
        this.f18227f = new HandlerC3974b();
        m24297f();
        m24296e();
        m24295d();
        return this.f18222a;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f18226e != null) {
            C13108a.m78878b(getActivity()).m78883f(this.f18226e);
            this.f18226e = null;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m24298g();
    }
}
