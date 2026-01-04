package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.huawei.hiar.ARImageMetadata;

/* loaded from: classes.dex */
public final class MemorySizeCalculator {

    /* renamed from: a */
    public final int f6973a;

    /* renamed from: b */
    public final int f6974b;

    /* renamed from: c */
    public final Context f6975c;

    /* renamed from: d */
    public final int f6976d;

    public static final class Builder {

        /* renamed from: i */
        public static final int f6977i = 1;

        /* renamed from: a */
        public final Context f6978a;

        /* renamed from: b */
        public ActivityManager f6979b;

        /* renamed from: c */
        public InterfaceC1578b f6980c;

        /* renamed from: e */
        public float f6982e;

        /* renamed from: d */
        public float f6981d = 2.0f;

        /* renamed from: f */
        public float f6983f = 0.4f;

        /* renamed from: g */
        public float f6984g = 0.33f;

        /* renamed from: h */
        public int f6985h = 4194304;

        public Builder(Context context) {
            this.f6982e = f6977i;
            this.f6978a = context;
            this.f6979b = (ActivityManager) context.getSystemService("activity");
            this.f6980c = new C1577a(context.getResources().getDisplayMetrics());
            if (MemorySizeCalculator.m9057e(this.f6979b)) {
                this.f6982e = 0.0f;
            }
        }

        /* renamed from: a */
        public MemorySizeCalculator m9062a() {
            return new MemorySizeCalculator(this);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.MemorySizeCalculator$a */
    public static final class C1577a implements InterfaceC1578b {

        /* renamed from: a */
        public final DisplayMetrics f6986a;

        public C1577a(DisplayMetrics displayMetrics) {
            this.f6986a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.InterfaceC1578b
        /* renamed from: a */
        public int mo9063a() {
            return this.f6986a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.InterfaceC1578b
        /* renamed from: b */
        public int mo9064b() {
            return this.f6986a.widthPixels;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.MemorySizeCalculator$b */
    public interface InterfaceC1578b {
        /* renamed from: a */
        int mo9063a();

        /* renamed from: b */
        int mo9064b();
    }

    public MemorySizeCalculator(Builder builder) {
        this.f6975c = builder.f6978a;
        int i10 = m9057e(builder.f6979b) ? builder.f6985h / 2 : builder.f6985h;
        this.f6976d = i10;
        int iM9056c = m9056c(builder.f6979b, builder.f6983f, builder.f6984g);
        float fMo9064b = builder.f6980c.mo9064b() * builder.f6980c.mo9063a() * 4;
        int iRound = Math.round(builder.f6982e * fMo9064b);
        int iRound2 = Math.round(fMo9064b * builder.f6981d);
        int i11 = iM9056c - i10;
        int i12 = iRound2 + iRound;
        if (i12 <= i11) {
            this.f6974b = iRound2;
            this.f6973a = iRound;
        } else {
            float f10 = i11;
            float f11 = builder.f6982e;
            float f12 = builder.f6981d;
            float f13 = f10 / (f11 + f12);
            this.f6974b = Math.round(f12 * f13);
            this.f6973a = Math.round(f13 * builder.f6982e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(m9061f(this.f6974b));
            sb2.append(", pool size: ");
            sb2.append(m9061f(this.f6973a));
            sb2.append(", byte array size: ");
            sb2.append(m9061f(i10));
            sb2.append(", memory class limited? ");
            sb2.append(i12 > iM9056c);
            sb2.append(", max size: ");
            sb2.append(m9061f(iM9056c));
            sb2.append(", memoryClass: ");
            sb2.append(builder.f6979b.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(m9057e(builder.f6979b));
            Log.d("MemorySizeCalculator", sb2.toString());
        }
    }

    /* renamed from: c */
    public static int m9056c(ActivityManager activityManager, float f10, float f11) {
        float memoryClass = activityManager.getMemoryClass() * ARImageMetadata.SHADING_MODE;
        if (m9057e(activityManager)) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    @TargetApi(19)
    /* renamed from: e */
    public static boolean m9057e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    /* renamed from: a */
    public int m9058a() {
        return this.f6976d;
    }

    /* renamed from: b */
    public int m9059b() {
        return this.f6973a;
    }

    /* renamed from: d */
    public int m9060d() {
        return this.f6974b;
    }

    /* renamed from: f */
    public final String m9061f(int i10) {
        return Formatter.formatFileSize(this.f6975c, i10);
    }
}
