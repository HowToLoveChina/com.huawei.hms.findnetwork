package p213d1;

import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* renamed from: d1.e */
/* loaded from: classes.dex */
public class C8979e implements InterfaceC8984j {

    /* renamed from: a */
    public static final String[] f45523a = new String[0];

    @Override // p213d1.InterfaceC8984j
    /* renamed from: a */
    public String[] mo56804a() {
        return f45523a;
    }

    @Override // p213d1.InterfaceC8984j
    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    @Override // p213d1.InterfaceC8984j
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }
}
