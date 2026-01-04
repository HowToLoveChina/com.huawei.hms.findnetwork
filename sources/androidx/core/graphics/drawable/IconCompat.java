package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.OsType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import p243e0.C9368c;
import p243e0.C9373h;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k */
    public static final PorterDuff.Mode f3433k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f3434a;

    /* renamed from: b */
    public Object f3435b;

    /* renamed from: c */
    public byte[] f3436c;

    /* renamed from: d */
    public Parcelable f3437d;

    /* renamed from: e */
    public int f3438e;

    /* renamed from: f */
    public int f3439f;

    /* renamed from: g */
    public ColorStateList f3440g;

    /* renamed from: h */
    public PorterDuff.Mode f3441h;

    /* renamed from: i */
    public String f3442i;

    /* renamed from: j */
    public String f3443j;

    /* renamed from: androidx.core.graphics.drawable.IconCompat$a */
    public static class C0648a {
        /* renamed from: a */
        public static IconCompat m3922a(Object obj) {
            C9373h.m58745f(obj);
            int iM3925d = m3925d(obj);
            if (iM3925d == 2) {
                return IconCompat.m3908k(null, m3924c(obj), m3923b(obj));
            }
            if (iM3925d == 4) {
                return IconCompat.m3906i(m3926e(obj));
            }
            if (iM3925d == 6) {
                return IconCompat.m3903f(m3926e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f3435b = obj;
            return iconCompat;
        }

        /* renamed from: b */
        public static int m3923b(Object obj) {
            return C0650c.m3931a(obj);
        }

        /* renamed from: c */
        public static String m3924c(Object obj) {
            return C0650c.m3932b(obj);
        }

        /* renamed from: d */
        public static int m3925d(Object obj) {
            return C0650c.m3933c(obj);
        }

        /* renamed from: e */
        public static Uri m3926e(Object obj) {
            return C0650c.m3934d(obj);
        }

        /* renamed from: f */
        public static Drawable m3927f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* renamed from: g */
        public static Icon m3928g(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f3434a) {
                case -1:
                    return (Icon) iconCompat.f3435b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f3435b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.m3914m(), iconCompat.f3438e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f3435b, iconCompat.f3438e, iconCompat.f3439f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f3435b);
                    break;
                case 5:
                    iconCreateWithBitmap = C0649b.m3930b((Bitmap) iconCompat.f3435b);
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        iconCreateWithBitmap = C0651d.m3935a(iconCompat.m3916p());
                        break;
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.m3916p());
                        }
                        InputStream inputStreamM3917q = iconCompat.m3917q(context);
                        if (inputStreamM3917q == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.m3916p());
                        }
                        iconCreateWithBitmap = C0649b.m3930b(BitmapFactory.decodeStream(inputStreamM3917q));
                        break;
                    }
            }
            ColorStateList colorStateList = iconCompat.f3440g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f3441h;
            if (mode != IconCompat.f3433k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    /* renamed from: androidx.core.graphics.drawable.IconCompat$b */
    public static class C0649b {
        /* renamed from: a */
        public static Drawable m3929a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        /* renamed from: b */
        public static Icon m3930b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* renamed from: androidx.core.graphics.drawable.IconCompat$c */
    public static class C0650c {
        /* renamed from: a */
        public static int m3931a(Object obj) {
            return ((Icon) obj).getResId();
        }

        /* renamed from: b */
        public static String m3932b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        /* renamed from: c */
        public static int m3933c(Object obj) {
            return ((Icon) obj).getType();
        }

        /* renamed from: d */
        public static Uri m3934d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* renamed from: androidx.core.graphics.drawable.IconCompat$d */
    public static class C0651d {
        /* renamed from: a */
        public static Icon m3935a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f3434a = -1;
        this.f3436c = null;
        this.f3437d = null;
        this.f3438e = 0;
        this.f3439f = 0;
        this.f3440g = null;
        this.f3441h = f3433k;
        this.f3442i = null;
    }

    /* renamed from: c */
    public static IconCompat m3900c(Icon icon) {
        return C0648a.m3922a(icon);
    }

    /* renamed from: d */
    public static Bitmap m3901d(Bitmap bitmap, boolean z10) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f10 = iMin;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    /* renamed from: e */
    public static IconCompat m3902e(Bitmap bitmap) {
        C9368c.m58731c(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f3435b = bitmap;
        return iconCompat;
    }

    /* renamed from: f */
    public static IconCompat m3903f(Uri uri) {
        C9368c.m58731c(uri);
        return m3904g(uri.toString());
    }

    /* renamed from: g */
    public static IconCompat m3904g(String str) {
        C9368c.m58731c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f3435b = str;
        return iconCompat;
    }

    /* renamed from: h */
    public static IconCompat m3905h(Bitmap bitmap) {
        C9368c.m58731c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f3435b = bitmap;
        return iconCompat;
    }

    /* renamed from: i */
    public static IconCompat m3906i(Uri uri) {
        C9368c.m58731c(uri);
        return m3907j(uri.toString());
    }

    /* renamed from: j */
    public static IconCompat m3907j(String str) {
        C9368c.m58731c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f3435b = str;
        return iconCompat;
    }

    /* renamed from: k */
    public static IconCompat m3908k(Resources resources, String str, int i10) {
        C9368c.m58731c(str);
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f3438e = i10;
        if (resources != null) {
            try {
                iconCompat.f3435b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f3435b = str;
        }
        iconCompat.f3443j = str;
        return iconCompat;
    }

    /* renamed from: n */
    public static Resources m3909n(Context context, String str) throws PackageManager.NameNotFoundException {
        if (OsType.ANDROID.equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", str), e10);
            return null;
        }
    }

    /* renamed from: v */
    public static String m3910v(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: a */
    public void m3911a(Intent intent, Drawable drawable, Context context) throws PackageManager.NameNotFoundException {
        Bitmap bitmapCopy;
        Bitmap bitmapCreateBitmap;
        m3912b(context);
        int i10 = this.f3434a;
        if (i10 == 1) {
            bitmapCopy = (Bitmap) this.f3435b;
            if (drawable != null) {
                bitmapCopy = bitmapCopy.copy(bitmapCopy.getConfig(), true);
            }
        } else if (i10 == 2) {
            try {
                Context contextCreatePackageContext = context.createPackageContext(m3914m(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(contextCreatePackageContext, this.f3438e));
                    return;
                }
                Drawable drawable2 = ContextCompat.getDrawable(contextCreatePackageContext, this.f3438e);
                if (drawable2.getIntrinsicWidth() <= 0 || drawable2.getIntrinsicHeight() <= 0) {
                    int launcherLargeIconSize = ((ActivityManager) contextCreatePackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                    bitmapCreateBitmap = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                } else {
                    bitmapCreateBitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }
                drawable2.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                drawable2.draw(new Canvas(bitmapCreateBitmap));
                bitmapCopy = bitmapCreateBitmap;
            } catch (PackageManager.NameNotFoundException e10) {
                throw new IllegalArgumentException("Can't find package " + this.f3435b, e10);
            }
        } else {
            if (i10 != 5) {
                throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
            bitmapCopy = m3901d((Bitmap) this.f3435b, true);
        }
        if (drawable != null) {
            int width = bitmapCopy.getWidth();
            int height = bitmapCopy.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmapCopy));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmapCopy);
    }

    /* renamed from: b */
    public void m3912b(Context context) {
        Object obj;
        if (this.f3434a != 2 || (obj = this.f3435b) == null) {
            return;
        }
        String str = (String) obj;
        if (str.contains(":")) {
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split("/", -1)[0];
            String str4 = str2.split("/", -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                Log.i("IconCompat", "Found obfuscated resource, not trying to update resource id for it");
                return;
            }
            String strM3914m = m3914m();
            int identifier = m3909n(context, strM3914m).getIdentifier(str4, str3, str5);
            if (this.f3438e != identifier) {
                Log.i("IconCompat", "Id has changed for " + strM3914m + " " + str);
                this.f3438e = identifier;
            }
        }
    }

    /* renamed from: l */
    public int m3913l() {
        int i10 = this.f3434a;
        if (i10 == -1) {
            return C0648a.m3923b(this.f3435b);
        }
        if (i10 == 2) {
            return this.f3438e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    /* renamed from: m */
    public String m3914m() {
        int i10 = this.f3434a;
        if (i10 == -1) {
            return C0648a.m3924c(this.f3435b);
        }
        if (i10 == 2) {
            String str = this.f3443j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f3435b).split(":", -1)[0] : this.f3443j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    /* renamed from: o */
    public int m3915o() {
        int i10 = this.f3434a;
        return i10 == -1 ? C0648a.m3925d(this.f3435b) : i10;
    }

    /* renamed from: p */
    public Uri m3916p() {
        int i10 = this.f3434a;
        if (i10 == -1) {
            return C0648a.m3926e(this.f3435b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f3435b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    /* renamed from: q */
    public InputStream m3917q(Context context) {
        Uri uriM3916p = m3916p();
        String scheme = uriM3916p.getScheme();
        if ("content".equals(scheme) || CloudBackupConstant.Command.PMS_OPTION_ONE_FILE.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriM3916p);
            } catch (Exception e10) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriM3916p, e10);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f3435b));
        } catch (FileNotFoundException e11) {
            Log.w("IconCompat", "Unable to load image from path: " + uriM3916p, e11);
            return null;
        }
    }

    /* renamed from: r */
    public void m3918r() {
        this.f3441h = PorterDuff.Mode.valueOf(this.f3442i);
        switch (this.f3434a) {
            case -1:
                Parcelable parcelable = this.f3437d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f3435b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f3437d;
                if (parcelable2 != null) {
                    this.f3435b = parcelable2;
                    return;
                }
                byte[] bArr = this.f3436c;
                this.f3435b = bArr;
                this.f3434a = 3;
                this.f3438e = 0;
                this.f3439f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f3436c, Charset.forName("UTF-16"));
                this.f3435b = str;
                if (this.f3434a == 2 && this.f3443j == null) {
                    this.f3443j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f3435b = this.f3436c;
                return;
        }
    }

    /* renamed from: s */
    public void m3919s(boolean z10) {
        this.f3442i = this.f3441h.name();
        switch (this.f3434a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f3437d = (Parcelable) this.f3435b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z10) {
                    this.f3437d = (Parcelable) this.f3435b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f3435b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f3436c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f3436c = ((String) this.f3435b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f3436c = (byte[]) this.f3435b;
                return;
            case 4:
            case 6:
                this.f3436c = this.f3435b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Deprecated
    /* renamed from: t */
    public Icon m3920t() {
        return m3921u(null);
    }

    public String toString() {
        if (this.f3434a == -1) {
            return String.valueOf(this.f3435b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(m3910v(this.f3434a));
        switch (this.f3434a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f3435b).getWidth());
                sb2.append(Constants.MULTIPLE_SIGN);
                sb2.append(((Bitmap) this.f3435b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f3443j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(m3913l())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f3438e);
                if (this.f3439f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f3439f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f3435b);
                break;
        }
        if (this.f3440g != null) {
            sb2.append(" tint=");
            sb2.append(this.f3440g);
        }
        if (this.f3441h != f3433k) {
            sb2.append(" mode=");
            sb2.append(this.f3441h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: u */
    public Icon m3921u(Context context) {
        return C0648a.m3928g(this, context);
    }

    public IconCompat(int i10) {
        this.f3436c = null;
        this.f3437d = null;
        this.f3438e = 0;
        this.f3439f = 0;
        this.f3440g = null;
        this.f3441h = f3433k;
        this.f3442i = null;
        this.f3434a = i10;
    }
}
