package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.EnumC1551g;
import p306g2.AbstractC9861m;
import p759x1.C13683h;
import p759x1.EnumC13677b;
import p759x1.InterfaceC13681f;
import p759x1.InterfaceC13688m;
import p829z1.AbstractC14071j;

/* loaded from: classes.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;

    public static RequestOptions bitmapTransform(InterfaceC13688m<Bitmap> interfaceC13688m) {
        return new RequestOptions().transform(interfaceC13688m);
    }

    public static RequestOptions centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new RequestOptions().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new RequestOptions().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    public static RequestOptions circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new RequestOptions().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    public static RequestOptions decodeTypeOf(Class<?> cls) {
        return new RequestOptions().decode(cls);
    }

    public static RequestOptions diskCacheStrategyOf(AbstractC14071j abstractC14071j) {
        return new RequestOptions().diskCacheStrategy(abstractC14071j);
    }

    public static RequestOptions downsampleOf(AbstractC9861m abstractC9861m) {
        return new RequestOptions().downsample(abstractC9861m);
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().encodeFormat(compressFormat);
    }

    public static RequestOptions encodeQualityOf(int i10) {
        return new RequestOptions().encodeQuality(i10);
    }

    public static RequestOptions errorOf(Drawable drawable) {
        return new RequestOptions().error(drawable);
    }

    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new RequestOptions().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    public static RequestOptions formatOf(EnumC13677b enumC13677b) {
        return new RequestOptions().format(enumC13677b);
    }

    public static RequestOptions frameOf(long j10) {
        return new RequestOptions().frame(j10);
    }

    public static RequestOptions noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }

    public static RequestOptions noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new RequestOptions().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    public static <T> RequestOptions option(C13683h<T> c13683h, T t10) {
        return new RequestOptions().set(c13683h, t10);
    }

    public static RequestOptions overrideOf(int i10, int i11) {
        return new RequestOptions().override(i10, i11);
    }

    public static RequestOptions placeholderOf(Drawable drawable) {
        return new RequestOptions().placeholder(drawable);
    }

    public static RequestOptions priorityOf(EnumC1551g enumC1551g) {
        return new RequestOptions().priority(enumC1551g);
    }

    public static RequestOptions signatureOf(InterfaceC13681f interfaceC13681f) {
        return new RequestOptions().signature(interfaceC13681f);
    }

    public static RequestOptions sizeMultiplierOf(float f10) {
        return new RequestOptions().sizeMultiplier(f10);
    }

    public static RequestOptions skipMemoryCacheOf(boolean z10) {
        if (z10) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions timeoutOf(int i10) {
        return new RequestOptions().timeout(i10);
    }

    public static RequestOptions errorOf(int i10) {
        return new RequestOptions().error(i10);
    }

    public static RequestOptions overrideOf(int i10) {
        return overrideOf(i10, i10);
    }

    public static RequestOptions placeholderOf(int i10) {
        return new RequestOptions().placeholder(i10);
    }
}
