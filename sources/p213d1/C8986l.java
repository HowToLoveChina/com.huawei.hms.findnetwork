package p213d1;

import android.webkit.WebSettings;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import p320gz.C10072a;

/* renamed from: d1.l */
/* loaded from: classes.dex */
public class C8986l {

    /* renamed from: a */
    public final WebkitToCompatConverterBoundaryInterface f45586a;

    public C8986l(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f45586a = webkitToCompatConverterBoundaryInterface;
    }

    /* renamed from: a */
    public C8981g m56814a(WebSettings webSettings) {
        return new C8981g((WebSettingsBoundaryInterface) C10072a.m62693a(WebSettingsBoundaryInterface.class, this.f45586a.convertSettings(webSettings)));
    }
}
