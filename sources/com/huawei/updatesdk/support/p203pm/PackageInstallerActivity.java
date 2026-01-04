package com.huawei.updatesdk.support.p203pm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.updatesdk.fileprovider.UpdateSdkFileProvider;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8782d;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p186b.p188b.C8795b;
import com.huawei.updatesdk.p191b.p197d.C8820e;
import java.io.File;

/* loaded from: classes9.dex */
public class PackageInstallerActivity extends Activity {
    /* renamed from: a */
    private Intent m56486a(Context context, String str) {
        if (AbstractC8782d.m56044d(str)) {
            throw new IllegalArgumentException("getNormalInstallIntent: Not a standard path");
        }
        File file = new File(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.INSTALL_PACKAGE");
        intent.addFlags(1);
        String str2 = context.getApplicationContext().getPackageName() + UpdateSdkFileProvider.AUTHORITIES_SUFFIX;
        if (!AbstractC8782d.m56044d(str2)) {
            intent.setData(UpdateSdkFileProvider.getUriForFile(context, str2, file));
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        return intent;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (1000 == i10) {
            if (i11 == 0) {
                C8820e.m56264a(7, 0);
            } else {
                int iM56137a = intent != null ? C8795b.m56136a(intent).m56137a("android.intent.extra.INSTALL_RESULT", -10004) : -10004;
                if (iM56137a != 0 && iM56137a != 1) {
                    C8820e.m56264a(4, iM56137a);
                }
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        requestWindowFeature(1);
        C8789c.m56105f().m56120a(getWindow());
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            str = "PackageInstallerActivity error intent";
        } else {
            C8795b c8795bM56136a = C8795b.m56136a(intent);
            String strM56139a = c8795bM56136a.m56139a(com.huawei.fastengine.fastview.download.install.PackageInstallerActivity.INSTALL_PATH);
            String strM56139a2 = c8795bM56136a.m56139a(com.huawei.fastengine.fastview.download.install.PackageInstallerActivity.INSTALL_PACKAGENAME);
            if (!m56487a(strM56139a, c8795bM56136a.m56139a("apk_sha256"))) {
                try {
                    Intent intentM56486a = m56486a(this, strM56139a);
                    intentM56486a.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                    intentM56486a.putExtra("android.intent.extra.RETURN_RESULT", true);
                    C8777a.m56029c("PackageInstallerActivity", " onCreate filePath:" + strM56139a + ",packageName:" + strM56139a2 + ",taskId:" + getTaskId());
                    startActivityForResult(intentM56486a, 1000);
                    return;
                } catch (Exception unused) {
                    C8777a.m56028b("PackageInstallerActivity", "can not start install action");
                    C8820e.m56264a(4, -2);
                    finish();
                    return;
                }
            }
            C8820e.m56264a(4, -3);
            finish();
            str = "PackageInstallerActivity can not find filePath.";
        }
        C8777a.m56028b("PackageInstallerActivity", str);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        finishActivity(1000);
        super.onDestroy();
    }

    /* renamed from: a */
    private boolean m56487a(String str, String str2) {
        return AbstractC8782d.m56044d(str) || TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase(AbstractC8782d.m56038a(str, "SHA-256"));
    }
}
