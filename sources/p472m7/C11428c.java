package p472m7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$color;
import fk.C9721b;
import java.util.LinkedHashMap;
import p514o9.C11827a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import tm.C13040c;

/* renamed from: m7.c */
/* loaded from: classes2.dex */
public class C11428c extends ClickableSpan {

    /* renamed from: a */
    public Context f53264a;

    /* renamed from: b */
    public String f53265b;

    /* renamed from: c */
    public boolean f53266c;

    /* renamed from: m7.c$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f53267a;

        /* renamed from: b */
        public final /* synthetic */ String f53268b;

        public a(Context context, String str) {
            this.f53267a = context;
            this.f53268b = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78669v;
            try {
                strM78669v = C13040c.m78609F().m78669v();
            } catch (C9721b e10) {
                C11839m.m70687e("TermsClickSpan", "getTermsUrlHost error " + e10.toString());
                strM78669v = "";
            }
            C11428c.m68475c(strM78669v, this.f53267a, this.f53268b);
        }
    }

    public C11428c(Context context, String str) {
        this.f53264a = context;
        this.f53265b = str;
    }

    /* renamed from: b */
    public static void m68474b(Context context, String str) {
        C12515a.m75110o().m75175e(new a(context, str), false);
    }

    /* renamed from: c */
    public static void m68475c(String str, Context context, String str2) {
        String str3 = str + C11827a.m70483h(str2);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str3));
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null && intent.resolveActivity(packageManager) != null) {
            context.startActivity(intent);
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("productType", str2);
        C13227f.m79492i1().m79591l0("mecloud_agrenment_click", linkedHashMapM79499C);
        UBAAnalyze.m29957R("PVC", "mecloud_agrenment_click", "1", "34", "productType", str2);
    }

    /* renamed from: d */
    public void m68476d(boolean z10) {
        this.f53266c = z10;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Context context = this.f53264a;
        if (context == null) {
            return;
        }
        m68474b(context, this.f53265b);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f53264a.getResources().getColor(R$color.emui_functional_blue));
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.f53264a.getResources().getColor(this.f53266c ? R$color.emui9_list_seletor_color : R$color.transparent);
    }
}
