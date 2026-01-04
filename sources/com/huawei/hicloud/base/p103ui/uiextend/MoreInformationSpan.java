package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.hicloud.base.R$color;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.List;
import p015ak.C0209d;
import p399jk.AbstractC10896a;

/* loaded from: classes6.dex */
public class MoreInformationSpan extends ClickableSpan {

    /* renamed from: a */
    public String f22160a;

    /* renamed from: b */
    public Context f22161b;

    public MoreInformationSpan(Context context) {
        this.f22160a = "SF-10044873_f001";
        this.f22161b = context;
    }

    /* renamed from: a */
    public static boolean m29121a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.tips.JUMP_TO_TIPS");
        intent.addCategory("android.intent.category.DEFAULT");
        C0209d.m1302r2(intent, "com.huawei.tips");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (!m29121a(this.f22161b)) {
            AbstractC10896a.m65887i("MoreInformationSpan", "action  not exist ");
            return;
        }
        try {
            Intent intent = new Intent("com.huawei.tips.JUMP_TO_TIPS");
            intent.addCategory("android.intent.category.DEFAULT");
            C0209d.m1302r2(intent, "com.huawei.tips");
            intent.putExtra("featureID", this.f22160a);
            String packageName = this.f22161b.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                intent.putExtra(SdkCfgSha256Record.PKGNAME, packageName);
            }
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            this.f22161b.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            AbstractC10896a.m65887i("MoreInformationSpan", "ActivityNotFoundException ：" + e10.toString());
        } catch (Exception e11) {
            AbstractC10896a.m65887i("MoreInformationSpan", "intent Exception ：" + e11.toString());
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f22161b.getColor(R$color.emui_functional_blue));
        textPaint.setUnderlineText(false);
    }

    public MoreInformationSpan(Context context, String str) {
        this.f22161b = context;
        this.f22160a = str;
    }
}
