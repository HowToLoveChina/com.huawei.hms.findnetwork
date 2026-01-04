package p241dy;

import java.io.IOException;

/* renamed from: dy.b */
/* loaded from: classes9.dex */
public class C9361b extends IOException {
    private static final long serialVersionUID = 1391070005491684483L;

    public C9361b(String str) {
        super("Cannot read encrypted content from " + str + " without a password.");
    }
}
