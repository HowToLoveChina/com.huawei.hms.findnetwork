package com.huawei.openalliance.p169ad.download.app;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;

/* renamed from: com.huawei.openalliance.ad.download.app.c */
/* loaded from: classes2.dex */
public abstract class AbstractC7044c {
    /* renamed from: a */
    public static void m42340a(Context context, long j10, AbstractC7846y.a aVar) {
        AbstractC7846y.m48620a(context, context.getString(C6849R.string.hiad_prepare_download_title), context.getString(C6849R.string.hiad_mobile_download_prompt, AbstractC7731ae.m47438a(context, j10)), context.getString(C6849R.string.hiad_detail_download_now), AbstractC7806cz.m48150a(context, C6849R.string.hiad_prepare_download, "hiad_prepare_download", new Object[0]), aVar);
    }

    /* renamed from: b */
    public static void m42343b(Context context, AbstractC7846y.a aVar) {
        AbstractC7846y.m48620a(context, context.getString(C6849R.string.hiad_dialog_title_tip), AbstractC7806cz.m48150a(context, C6849R.string.hiad_non_wifi_download_prompt, "hiad_non_wifi_download_prompt", new Object[0]), context.getString(C6849R.string.hiad_continue_download_new), context.getString(C6849R.string.hiad_dialog_cancel), aVar);
    }

    /* renamed from: a */
    public static void m42341a(Context context, AbstractC7846y.a aVar) {
        AbstractC7846y.m48620a(context, context.getString(C6849R.string.hiad_dialog_title_tip), context.getString(C6849R.string.hiad_whether_download), context.getString(C6849R.string.hiad_continue_download_new), context.getString(C6849R.string.hiad_dialog_cancel), aVar);
    }

    /* renamed from: a */
    public static void m42342a(Context context, boolean z10, AbstractC7846y.a aVar) {
        AbstractC7846y.m48620a(context, "", context.getString(z10 ? C6849R.string.hiad_confirm_restore_app : C6849R.string.hiad_confirm_download_app), context.getString(C6849R.string.hiad_download_install), context.getString(C6849R.string.hiad_dialog_cancel), aVar);
    }
}
