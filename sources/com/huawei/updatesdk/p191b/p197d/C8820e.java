package com.huawei.updatesdk.p191b.p197d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.appgallery.marketinstallerservice.api.Constant;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p186b.p188b.C8795b;
import com.huawei.updatesdk.p191b.p199f.C8829c;
import com.huawei.updatesdk.support.p203pm.PackageInstallerActivity;
import java.io.File;

/* renamed from: com.huawei.updatesdk.b.d.e */
/* loaded from: classes9.dex */
public class C8820e {
    /* renamed from: a */
    public static void m56264a(int i10, int i11) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("INSTALL_STATE", i10);
        bundle.putInt("INSTALL_TYPE", i11);
        intent.putExtras(bundle);
        C8829c.m56292b().m56295c(C8795b.m56136a(intent));
    }

    /* renamed from: a */
    public static void m56265a(Context context, String str, String str2, String str3) {
        m56264a(3, 1);
        File file = new File(str);
        if (!file.exists() || !file.isFile() || file.length() <= 0) {
            C8777a.m56028b("InstallProcess", "system install failed,file not existed filePath:" + str);
            m56264a(4, -10003);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) PackageInstallerActivity.class);
        intent.putExtra(com.huawei.fastengine.fastview.download.install.PackageInstallerActivity.INSTALL_PATH, str);
        intent.putExtra(com.huawei.fastengine.fastview.download.install.PackageInstallerActivity.INSTALL_PACKAGENAME, str2);
        intent.putExtra("apk_sha256", str3);
        if (!(context instanceof Activity)) {
            intent.setFlags(402653184);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            m56264a(4, Constant.INSTALL_FAILED_SHA256_EEROR);
            C8777a.m56027a("InstallProcess", " can not start install !", e10);
        }
    }
}
