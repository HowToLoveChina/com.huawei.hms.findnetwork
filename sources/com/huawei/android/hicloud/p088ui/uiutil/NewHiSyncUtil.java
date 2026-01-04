package com.huawei.android.hicloud.p088ui.uiutil;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$string;
import com.huawei.hms.push.constant.RemoteMessageConst;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class NewHiSyncUtil {

    /* renamed from: a */
    public Context f19299a;

    /* renamed from: com.huawei.android.hicloud.ui.uiutil.NewHiSyncUtil$a */
    public class C4279a extends ClickableSpan {

        /* renamed from: a */
        public int f19300a;

        /* renamed from: b */
        public boolean f19301b;

        /* renamed from: c */
        public Context f19302c;

        public C4279a(int i10, Context context) {
            this.f19300a = i10;
            this.f19302c = context;
        }

        /* renamed from: a */
        public void m25635a(boolean z10) {
            this.f19301b = z10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            int i10 = this.f19300a;
            if (i10 == 9) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.HuaweiPrivacyPolicyActivity"));
                intent.putExtra(RemoteMessageConst.FROM, "oobe");
                intent.putExtra("clickable", false);
                C0209d.m1302r2(intent, "com.android.settings");
                if (intent.resolveActivity(this.f19302c.getPackageManager()) != null) {
                    NewHiSyncUtil.this.f19299a.startActivity(intent);
                    return;
                }
                return;
            }
            if (i10 == 3) {
                try {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.android.settings", "com.android.settings.HuaweiPrivacyPolicyActivity"));
                    NewHiSyncUtil.this.f19299a.startActivity(intent2);
                } catch (ActivityNotFoundException e10) {
                    C11839m.m70687e("NewHiSyncUtil", "HuaweiPrivacyPolicyActivity ActivityNotFoundException : " + e10.toString());
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(NewHiSyncUtil.this.f19299a.getResources().getColor(R$color.emui_functional_blue));
            textPaint.bgColor = NewHiSyncUtil.this.f19299a.getResources().getColor(this.f19301b ? R$color.emui9_list_seletor_color : R$color.transparent);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiutil.NewHiSyncUtil$b */
    public static class C4280b extends LinkMovementMethod {

        /* renamed from: a */
        public C4279a f19304a;

        /* renamed from: a */
        public final C4279a m25636a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int offsetForHorizontal;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y10 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            try {
                offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            } catch (Exception e10) {
                C11839m.m70687e("NewHiSyncUtil", "getOffsetForHorizontal exception:" + e10.toString());
                offsetForHorizontal = 0;
            }
            C4279a[] c4279aArr = (C4279a[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, C4279a.class);
            if (c4279aArr.length > 0) {
                return c4279aArr[0];
            }
            return null;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                C4279a c4279aM25636a = m25636a(textView, spannable, motionEvent);
                this.f19304a = c4279aM25636a;
                if (c4279aM25636a != null) {
                    c4279aM25636a.m25635a(true);
                    Selection.setSelection(spannable, spannable.getSpanStart(this.f19304a), spannable.getSpanEnd(this.f19304a));
                }
            } else if (2 == motionEvent.getAction()) {
                C4279a c4279aM25636a2 = m25636a(textView, spannable, motionEvent);
                C4279a c4279a = this.f19304a;
                if (c4279a != null && c4279aM25636a2 != c4279a) {
                    c4279a.m25635a(false);
                    this.f19304a = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                Selection.removeSelection(spannable);
                C4279a c4279a2 = this.f19304a;
                if (c4279a2 == null) {
                    return true;
                }
                c4279a2.m25635a(false);
                this.f19304a = null;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public NewHiSyncUtil(Context context) {
        this.f19299a = context;
    }

    /* renamed from: b */
    public static String m25632b(String str) {
        ApplicationInfo applicationInfo;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("NewHiSyncUtil", "packageName = " + str);
            return "";
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("NewHiSyncUtil", "context is null");
            return "";
        }
        PackageManager packageManager = contextM1377a.getPackageManager();
        try {
            Pair<String, String> splitOriAppIdAndSplitApkType = SplitAppUtil.getSplitOriAppIdAndSplitApkType(str);
            String str2 = (String) splitOriAppIdAndSplitApkType.first;
            String str3 = (String) splitOriAppIdAndSplitApkType.second;
            PackageInfo packageInfo = packageManager.getPackageInfo(str2, 0);
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
                return "";
            }
            return packageManager.getApplicationLabel(applicationInfo).toString() + str3;
        } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
            C11839m.m70687e("NewHiSyncUtil", "getAppName error：" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: c */
    public static int m25633c(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            return -1;
        }
        return batteryManager.getIntProperty(4);
    }

    /* renamed from: d */
    public static String m25634d(String str, String str2, String str3, String str4, Context context) {
        return TextUtils.isEmpty(str4) ? TextUtils.isEmpty(str3) ? context.getString(R$string.about_recover_tip_null, str2, str) : context.getString(R$string.about_recover_tip, str2, str3, str) : str2;
    }
}
