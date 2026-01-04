package p482n2;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* renamed from: n2.b */
/* loaded from: classes.dex */
public final class C11605b {

    /* renamed from: a */
    public final List<ImageHeaderParser> f53894a = new ArrayList();

    /* renamed from: a */
    public synchronized void m69341a(ImageHeaderParser imageHeaderParser) {
        this.f53894a.add(imageHeaderParser);
    }

    /* renamed from: b */
    public synchronized List<ImageHeaderParser> m69342b() {
        return this.f53894a;
    }
}
