package p275f2;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Log;
import android.util.Size;
import com.huawei.openalliance.p169ad.constant.Constants;
import p306g2.AbstractC9861m;
import p306g2.C9862n;
import p306g2.C9867s;
import p759x1.C13683h;
import p759x1.C13684i;
import p759x1.EnumC13677b;
import p759x1.EnumC13685j;

/* renamed from: f2.a */
/* loaded from: classes.dex */
public final class C9644a implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a */
    public final C9867s f47770a = C9867s.m61291b();

    /* renamed from: b */
    public final int f47771b;

    /* renamed from: c */
    public final int f47772c;

    /* renamed from: d */
    public final EnumC13677b f47773d;

    /* renamed from: e */
    public final AbstractC9861m f47774e;

    /* renamed from: f */
    public final boolean f47775f;

    /* renamed from: g */
    public final EnumC13685j f47776g;

    /* renamed from: f2.a$a */
    public class a implements ImageDecoder.OnPartialImageListener {
        public a() {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public C9644a(int i10, int i11, C13684i c13684i) {
        this.f47771b = i10;
        this.f47772c = i11;
        this.f47773d = (EnumC13677b) c13684i.m82284c(C9862n.f48442f);
        this.f47774e = (AbstractC9861m) c13684i.m82284c(AbstractC9861m.f48437h);
        C13683h<Boolean> c13683h = C9862n.f48446j;
        this.f47775f = c13684i.m82284c(c13683h) != null && ((Boolean) c13684i.m82284c(c13683h)).booleanValue();
        this.f47776g = (EnumC13685j) c13684i.m82284c(C9862n.f48443g);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.f47770a.m61298e(this.f47771b, this.f47772c, this.f47775f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f47773d == EnumC13677b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        Size size = imageInfo.getSize();
        int width = this.f47771b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f47772c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fMo61258b = this.f47774e.mo61258b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fMo61258b);
        int iRound2 = Math.round(size.getHeight() * fMo61258b);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + Constants.MULTIPLE_SIGN + size.getHeight() + "] to [" + iRound + Constants.MULTIPLE_SIGN + iRound2 + "] scaleFactor: " + fMo61258b);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        EnumC13685j enumC13685j = this.f47776g;
        if (enumC13685j != null) {
            imageDecoder.setTargetColorSpace(ColorSpace.get((enumC13685j == EnumC13685j.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        }
    }
}
