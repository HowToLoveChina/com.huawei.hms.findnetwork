package com.huawei.openalliance.p169ad;

import android.app.Dialog;
import android.content.res.Resources;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import com.huawei.openalliance.p169ad.views.C8148r;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.ui */
/* loaded from: classes8.dex */
public class RunnableC7714ui implements Runnable {

    /* renamed from: a */
    private WeakReference<C8148r> f35773a;

    public RunnableC7714ui(C8148r c8148r) {
        this.f35773a = new WeakReference<>(c8148r);
    }

    /* renamed from: a */
    public static boolean m47374a(Dialog dialog) {
        return dialog != null && dialog.isShowing();
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        C8148r c8148r = this.f35773a.get();
        if (c8148r == null) {
            AbstractC7185ho.m43823c("InterstitialViewNonWifi", "container is null.");
            return;
        }
        if (m47374a(c8148r.getNonwifiDialog())) {
            AbstractC7185ho.m43820b("InterstitialViewNonWifi", "NonWifiDialog already shown.");
            return;
        }
        AbstractC7185ho.m43820b("InterstitialViewNonWifi", "pop up dialog");
        Resources resources = c8148r.getResources();
        c8148r.setNonwifiDialog(AbstractC7846y.m48620a(c8148r.getContext(), "", resources.getString(C6849R.string.hiad_consume_data_to_play_video_no_data_size), resources.getString(C6849R.string.hiad_reward_close_dialog_continue), resources.getString(C6849R.string.hiad_reward_close_dialog_close), new C7713uh(c8148r)));
        c8148r.getNonwifiDialog().setCancelable(false);
    }
}
