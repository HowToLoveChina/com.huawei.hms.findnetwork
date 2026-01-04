package p306g2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import p003a2.C0010e;
import p003a2.InterfaceC0009d;
import p275f2.C9644a;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.d */
/* loaded from: classes.dex */
public final class C9852d implements InterfaceC13686k<ImageDecoder.Source, Bitmap> {

    /* renamed from: a */
    public final InterfaceC0009d f48417a = new C0010e();

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Bitmap> mo9147b(ImageDecoder.Source source, int i10, int i11, C13684i c13684i) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new C9644a(i10, i11, c13684i));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + Constants.MULTIPLE_SIGN + bitmapDecodeBitmap.getHeight() + "] for [" + i10 + Constants.MULTIPLE_SIGN + i11 + "]");
        }
        return new C9853e(bitmapDecodeBitmap, this.f48417a);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(ImageDecoder.Source source, C13684i c13684i) throws IOException {
        return true;
    }
}
