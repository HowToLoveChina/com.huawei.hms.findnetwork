package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.resource.bitmap.C1599a;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.request.BaseRequestOptions;
import java.util.Map;
import p245e2.C9391a;
import p306g2.AbstractC9861m;
import p306g2.C9851c;
import p306g2.C9857i;
import p306g2.C9858j;
import p306g2.C9859k;
import p306g2.C9862n;
import p306g2.C9864p;
import p306g2.C9866r;
import p415k2.C10973b;
import p415k2.C10976e;
import p415k2.C10979h;
import p599r2.C12458a;
import p630s2.C12667b;
import p630s2.C12676k;
import p630s2.C12677l;
import p759x1.C13682g;
import p759x1.C13683h;
import p759x1.C13684i;
import p759x1.EnumC13677b;
import p759x1.InterfaceC13681f;
import p759x1.InterfaceC13688m;
import p829z1.AbstractC14071j;

/* loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;
    private AbstractC14071j diskCacheStrategy = AbstractC14071j.f62958e;
    private EnumC1551g priority = EnumC1551g.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private InterfaceC13681f signature = C12458a.m74713c();
    private boolean isTransformationAllowed = true;
    private C13684i options = new C13684i();
    private Map<Class<?>, InterfaceC13688m<?>> transformations = new C12667b();
    private Class<?> resourceClass = Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    private static boolean isSet(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    private T optionalScaleOnlyTransform(AbstractC9861m abstractC9861m, InterfaceC13688m<Bitmap> interfaceC13688m) {
        return (T) scaleOnlyTransform(abstractC9861m, interfaceC13688m, false);
    }

    private T scaleOnlyTransform(AbstractC9861m abstractC9861m, InterfaceC13688m<Bitmap> interfaceC13688m) {
        return (T) scaleOnlyTransform(abstractC9861m, interfaceC13688m, true);
    }

    private T self() {
        return this;
    }

    public T apply(BaseRequestOptions<?> baseRequestOptions) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().apply(baseRequestOptions);
        }
        if (isSet(baseRequestOptions.fields, 2)) {
            this.sizeMultiplier = baseRequestOptions.sizeMultiplier;
        }
        if (isSet(baseRequestOptions.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = baseRequestOptions.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(baseRequestOptions.fields, 1048576)) {
            this.useAnimationPool = baseRequestOptions.useAnimationPool;
        }
        if (isSet(baseRequestOptions.fields, 4)) {
            this.diskCacheStrategy = baseRequestOptions.diskCacheStrategy;
        }
        if (isSet(baseRequestOptions.fields, 8)) {
            this.priority = baseRequestOptions.priority;
        }
        if (isSet(baseRequestOptions.fields, 16)) {
            this.errorPlaceholder = baseRequestOptions.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(baseRequestOptions.fields, 32)) {
            this.errorId = baseRequestOptions.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(baseRequestOptions.fields, 64)) {
            this.placeholderDrawable = baseRequestOptions.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(baseRequestOptions.fields, 128)) {
            this.placeholderId = baseRequestOptions.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(baseRequestOptions.fields, 256)) {
            this.isCacheable = baseRequestOptions.isCacheable;
        }
        if (isSet(baseRequestOptions.fields, 512)) {
            this.overrideWidth = baseRequestOptions.overrideWidth;
            this.overrideHeight = baseRequestOptions.overrideHeight;
        }
        if (isSet(baseRequestOptions.fields, 1024)) {
            this.signature = baseRequestOptions.signature;
        }
        if (isSet(baseRequestOptions.fields, 4096)) {
            this.resourceClass = baseRequestOptions.resourceClass;
        }
        if (isSet(baseRequestOptions.fields, 8192)) {
            this.fallbackDrawable = baseRequestOptions.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(baseRequestOptions.fields, 16384)) {
            this.fallbackId = baseRequestOptions.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(baseRequestOptions.fields, 32768)) {
            this.theme = baseRequestOptions.theme;
        }
        if (isSet(baseRequestOptions.fields, 65536)) {
            this.isTransformationAllowed = baseRequestOptions.isTransformationAllowed;
        }
        if (isSet(baseRequestOptions.fields, 131072)) {
            this.isTransformationRequired = baseRequestOptions.isTransformationRequired;
        }
        if (isSet(baseRequestOptions.fields, 2048)) {
            this.transformations.putAll(baseRequestOptions.transformations);
            this.isScaleOnlyOrNoTransform = baseRequestOptions.isScaleOnlyOrNoTransform;
        }
        if (isSet(baseRequestOptions.fields, 524288)) {
            this.onlyRetrieveFromCache = baseRequestOptions.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i10 = this.fields;
            this.isTransformationRequired = false;
            this.fields = i10 & (-133121);
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= baseRequestOptions.fields;
        this.options.m82285d(baseRequestOptions.options);
        return (T) selfOrThrowIfLocked();
    }

    public T autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return (T) lock();
    }

    public T centerCrop() {
        return (T) transform(AbstractC9861m.f48434e, new C9857i());
    }

    public T centerInside() {
        return (T) scaleOnlyTransform(AbstractC9861m.f48433d, new C9858j());
    }

    public T circleCrop() {
        return (T) transform(AbstractC9861m.f48433d, new C9859k());
    }

    public T decode(Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().decode(cls);
        }
        this.resourceClass = (Class) C12676k.m76276d(cls);
        this.fields |= 4096;
        return (T) selfOrThrowIfLocked();
    }

    public T disallowHardwareConfig() {
        return (T) set(C9862n.f48446j, Boolean.FALSE);
    }

    public T diskCacheStrategy(AbstractC14071j abstractC14071j) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().diskCacheStrategy(abstractC14071j);
        }
        this.diskCacheStrategy = (AbstractC14071j) C12676k.m76276d(abstractC14071j);
        this.fields |= 4;
        return (T) selfOrThrowIfLocked();
    }

    public T dontAnimate() {
        return (T) set(C10979h.f52036b, Boolean.TRUE);
    }

    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().dontTransform();
        }
        this.transformations.clear();
        int i10 = this.fields;
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (i10 & (-133121)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return (T) selfOrThrowIfLocked();
    }

    public T downsample(AbstractC9861m abstractC9861m) {
        return (T) set(AbstractC9861m.f48437h, C12676k.m76276d(abstractC9861m));
    }

    public T encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (T) set(C9851c.f48415c, C12676k.m76276d(compressFormat));
    }

    public T encodeQuality(int i10) {
        return (T) set(C9851c.f48414b, Integer.valueOf(i10));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        return Float.compare(baseRequestOptions.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == baseRequestOptions.errorId && C12677l.m76280c(this.errorPlaceholder, baseRequestOptions.errorPlaceholder) && this.placeholderId == baseRequestOptions.placeholderId && C12677l.m76280c(this.placeholderDrawable, baseRequestOptions.placeholderDrawable) && this.fallbackId == baseRequestOptions.fallbackId && C12677l.m76280c(this.fallbackDrawable, baseRequestOptions.fallbackDrawable) && this.isCacheable == baseRequestOptions.isCacheable && this.overrideHeight == baseRequestOptions.overrideHeight && this.overrideWidth == baseRequestOptions.overrideWidth && this.isTransformationRequired == baseRequestOptions.isTransformationRequired && this.isTransformationAllowed == baseRequestOptions.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == baseRequestOptions.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == baseRequestOptions.onlyRetrieveFromCache && this.diskCacheStrategy.equals(baseRequestOptions.diskCacheStrategy) && this.priority == baseRequestOptions.priority && this.options.equals(baseRequestOptions.options) && this.transformations.equals(baseRequestOptions.transformations) && this.resourceClass.equals(baseRequestOptions.resourceClass) && C12677l.m76280c(this.signature, baseRequestOptions.signature) && C12677l.m76280c(this.theme, baseRequestOptions.theme);
    }

    public T error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i10 = this.fields | 16;
        this.errorId = 0;
        this.fields = i10 & (-33);
        return (T) selfOrThrowIfLocked();
    }

    public T fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i10 = this.fields | 8192;
        this.fallbackId = 0;
        this.fields = i10 & (-16385);
        return (T) selfOrThrowIfLocked();
    }

    public T fitCenter() {
        return (T) scaleOnlyTransform(AbstractC9861m.f48432c, new C9866r());
    }

    public T format(EnumC13677b enumC13677b) {
        C12676k.m76276d(enumC13677b);
        return (T) set(C9862n.f48442f, enumC13677b).set(C10979h.f52035a, enumC13677b);
    }

    public T frame(long j10) {
        return (T) set(C1599a.f7080d, Long.valueOf(j10));
    }

    public final AbstractC14071j getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final C13684i getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final EnumC1551g getPriority() {
        return this.priority;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final InterfaceC13681f getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map<Class<?>, InterfaceC13688m<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return C12677l.m76291n(this.theme, C12677l.m76291n(this.signature, C12677l.m76291n(this.resourceClass, C12677l.m76291n(this.transformations, C12677l.m76291n(this.options, C12677l.m76291n(this.priority, C12677l.m76291n(this.diskCacheStrategy, C12677l.m76292o(this.onlyRetrieveFromCache, C12677l.m76292o(this.useUnlimitedSourceGeneratorsPool, C12677l.m76292o(this.isTransformationAllowed, C12677l.m76292o(this.isTransformationRequired, C12677l.m76290m(this.overrideWidth, C12677l.m76290m(this.overrideHeight, C12677l.m76292o(this.isCacheable, C12677l.m76291n(this.fallbackDrawable, C12677l.m76290m(this.fallbackId, C12677l.m76291n(this.placeholderDrawable, C12677l.m76290m(this.placeholderId, C12677l.m76291n(this.errorPlaceholder, C12677l.m76290m(this.errorId, C12677l.m76288k(this.sizeMultiplier)))))))))))))))))))));
    }

    public final boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return C12677l.m76296s(this.overrideWidth, this.overrideHeight);
    }

    public T lock() {
        this.isLocked = true;
        return (T) self();
    }

    public T onlyRetrieveFromCache(boolean z10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().onlyRetrieveFromCache(z10);
        }
        this.onlyRetrieveFromCache = z10;
        this.fields |= 524288;
        return (T) selfOrThrowIfLocked();
    }

    public T optionalCenterCrop() {
        return (T) optionalTransform(AbstractC9861m.f48434e, new C9857i());
    }

    public T optionalCenterInside() {
        return (T) optionalScaleOnlyTransform(AbstractC9861m.f48433d, new C9858j());
    }

    public T optionalCircleCrop() {
        return (T) optionalTransform(AbstractC9861m.f48434e, new C9859k());
    }

    public T optionalFitCenter() {
        return (T) optionalScaleOnlyTransform(AbstractC9861m.f48432c, new C9866r());
    }

    public <Y> T optionalTransform(Class<Y> cls, InterfaceC13688m<Y> interfaceC13688m) {
        return (T) transform(cls, interfaceC13688m, false);
    }

    public T override(int i10, int i11) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().override(i10, i11);
        }
        this.overrideWidth = i10;
        this.overrideHeight = i11;
        this.fields |= 512;
        return (T) selfOrThrowIfLocked();
    }

    public T placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i10 = this.fields | 64;
        this.placeholderId = 0;
        this.fields = i10 & (-129);
        return (T) selfOrThrowIfLocked();
    }

    public T priority(EnumC1551g enumC1551g) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().priority(enumC1551g);
        }
        this.priority = (EnumC1551g) C12676k.m76276d(enumC1551g);
        this.fields |= 8;
        return (T) selfOrThrowIfLocked();
    }

    public final T selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) self();
    }

    public <Y> T set(C13683h<Y> c13683h, Y y10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().set(c13683h, y10);
        }
        C12676k.m76276d(c13683h);
        C12676k.m76276d(y10);
        this.options.m82286e(c13683h, y10);
        return (T) selfOrThrowIfLocked();
    }

    public T signature(InterfaceC13681f interfaceC13681f) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().signature(interfaceC13681f);
        }
        this.signature = (InterfaceC13681f) C12676k.m76276d(interfaceC13681f);
        this.fields |= 1024;
        return (T) selfOrThrowIfLocked();
    }

    public T sizeMultiplier(float f10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().sizeMultiplier(f10);
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = f10;
        this.fields |= 2;
        return (T) selfOrThrowIfLocked();
    }

    public T skipMemoryCache(boolean z10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().skipMemoryCache(true);
        }
        this.isCacheable = !z10;
        this.fields |= 256;
        return (T) selfOrThrowIfLocked();
    }

    public T theme(Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().theme(theme);
        }
        C12676k.m76276d(theme);
        this.theme = theme;
        this.fields |= 32768;
        return (T) set(ResourceDrawableDecoder.f7091b, theme);
    }

    public T timeout(int i10) {
        return (T) set(C9391a.f46914b, Integer.valueOf(i10));
    }

    public <Y> T transform(Class<Y> cls, InterfaceC13688m<Y> interfaceC13688m) {
        return (T) transform(cls, interfaceC13688m, true);
    }

    @Deprecated
    public T transforms(InterfaceC13688m<Bitmap>... interfaceC13688mArr) {
        return (T) transform((InterfaceC13688m<Bitmap>) new C13682g(interfaceC13688mArr), true);
    }

    public T useAnimationPool(boolean z10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().useAnimationPool(z10);
        }
        this.useAnimationPool = z10;
        this.fields |= 1048576;
        return (T) selfOrThrowIfLocked();
    }

    public T useUnlimitedSourceGeneratorsPool(boolean z10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().useUnlimitedSourceGeneratorsPool(z10);
        }
        this.useUnlimitedSourceGeneratorsPool = z10;
        this.fields |= 262144;
        return (T) selfOrThrowIfLocked();
    }

    private boolean isSet(int i10) {
        return isSet(this.fields, i10);
    }

    @Override // 
    /* renamed from: clone */
    public T mo85641clone() {
        try {
            T t10 = (T) super.clone();
            C13684i c13684i = new C13684i();
            t10.options = c13684i;
            c13684i.m82285d(this.options);
            C12667b c12667b = new C12667b();
            t10.transformations = c12667b;
            c12667b.putAll(this.transformations);
            t10.isLocked = false;
            t10.isAutoCloneEnabled = false;
            return t10;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    private T scaleOnlyTransform(AbstractC9861m abstractC9861m, InterfaceC13688m<Bitmap> interfaceC13688m, boolean z10) {
        T t10;
        if (z10) {
            t10 = (T) transform(abstractC9861m, interfaceC13688m);
        } else {
            t10 = (T) optionalTransform(abstractC9861m, interfaceC13688m);
        }
        t10.isScaleOnlyOrNoTransform = true;
        return t10;
    }

    public T optionalTransform(InterfaceC13688m<Bitmap> interfaceC13688m) {
        return (T) transform(interfaceC13688m, false);
    }

    public T transform(InterfaceC13688m<Bitmap> interfaceC13688m) {
        return (T) transform(interfaceC13688m, true);
    }

    public final T optionalTransform(AbstractC9861m abstractC9861m, InterfaceC13688m<Bitmap> interfaceC13688m) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().optionalTransform(abstractC9861m, interfaceC13688m);
        }
        downsample(abstractC9861m);
        return (T) transform(interfaceC13688m, false);
    }

    public final T transform(AbstractC9861m abstractC9861m, InterfaceC13688m<Bitmap> interfaceC13688m) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().transform(abstractC9861m, interfaceC13688m);
        }
        downsample(abstractC9861m);
        return (T) transform(interfaceC13688m);
    }

    public T override(int i10) {
        return (T) override(i10, i10);
    }

    public T error(int i10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().error(i10);
        }
        this.errorId = i10;
        int i11 = this.fields | 32;
        this.errorPlaceholder = null;
        this.fields = i11 & (-17);
        return (T) selfOrThrowIfLocked();
    }

    public T fallback(int i10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().fallback(i10);
        }
        this.fallbackId = i10;
        int i11 = this.fields | 16384;
        this.fallbackDrawable = null;
        this.fields = i11 & (-8193);
        return (T) selfOrThrowIfLocked();
    }

    public T placeholder(int i10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().placeholder(i10);
        }
        this.placeholderId = i10;
        int i11 = this.fields | 128;
        this.placeholderDrawable = null;
        this.fields = i11 & (-65);
        return (T) selfOrThrowIfLocked();
    }

    public T transform(InterfaceC13688m<Bitmap>... interfaceC13688mArr) {
        if (interfaceC13688mArr.length > 1) {
            return (T) transform((InterfaceC13688m<Bitmap>) new C13682g(interfaceC13688mArr), true);
        }
        if (interfaceC13688mArr.length == 1) {
            return (T) transform(interfaceC13688mArr[0]);
        }
        return (T) selfOrThrowIfLocked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T transform(InterfaceC13688m<Bitmap> interfaceC13688m, boolean z10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().transform(interfaceC13688m, z10);
        }
        C9864p c9864p = new C9864p(interfaceC13688m, z10);
        transform(Bitmap.class, interfaceC13688m, z10);
        transform(Drawable.class, c9864p, z10);
        transform(BitmapDrawable.class, c9864p.m61289c(), z10);
        transform(C10973b.class, new C10976e(interfaceC13688m), z10);
        return (T) selfOrThrowIfLocked();
    }

    public <Y> T transform(Class<Y> cls, InterfaceC13688m<Y> interfaceC13688m, boolean z10) {
        if (this.isAutoCloneEnabled) {
            return (T) mo85641clone().transform(cls, interfaceC13688m, z10);
        }
        C12676k.m76276d(cls);
        C12676k.m76276d(interfaceC13688m);
        this.transformations.put(cls, interfaceC13688m);
        int i10 = this.fields;
        this.isTransformationAllowed = true;
        this.fields = 67584 | i10;
        this.isScaleOnlyOrNoTransform = false;
        if (z10) {
            this.fields = i10 | 198656;
            this.isTransformationRequired = true;
        }
        return (T) selfOrThrowIfLocked();
    }
}
