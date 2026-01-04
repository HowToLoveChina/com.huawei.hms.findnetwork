package p213d1;

import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import p320gz.C10072a;

/* renamed from: d1.k */
/* loaded from: classes.dex */
public class C8985k implements InterfaceC8984j {

    /* renamed from: a */
    public final WebViewProviderFactoryBoundaryInterface f45585a;

    public C8985k(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f45585a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // p213d1.InterfaceC8984j
    /* renamed from: a */
    public String[] mo56804a() {
        return this.f45585a.getSupportedFeatures();
    }

    @Override // p213d1.InterfaceC8984j
    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        return (DropDataContentProviderBoundaryInterface) C10072a.m62693a(DropDataContentProviderBoundaryInterface.class, this.f45585a.getDropDataProvider());
    }

    @Override // p213d1.InterfaceC8984j
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) C10072a.m62693a(WebkitToCompatConverterBoundaryInterface.class, this.f45585a.getWebkitToCompatConverter());
    }
}
