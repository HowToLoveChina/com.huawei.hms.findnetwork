package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.huawei.openalliance.p169ad.constant.OsType;
import java.util.List;
import p355i2.C10416b;
import p355i2.C10418d;
import p630s2.C12676k;
import p759x1.C13683h;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* loaded from: classes.dex */
public class ResourceDrawableDecoder implements InterfaceC13686k<Uri, Drawable> {

    /* renamed from: b */
    public static final C13683h<Resources.Theme> f7091b = C13683h.m82278e("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");

    /* renamed from: a */
    public final Context f7092a;

    public ResourceDrawableDecoder(Context context) {
        this.f7092a = context.getApplicationContext();
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Drawable> mo9147b(Uri uri, int i10, int i11, C13684i c13684i) {
        String authority = uri.getAuthority();
        Context contextM9157d = m9157d(uri, authority);
        int iM9160g = m9160g(contextM9157d, uri);
        Resources.Theme theme = (Resources.Theme) c13684i.m82284c(f7091b);
        C12676k.m76273a(contextM9157d.getPackageName().equals(authority) || theme == null, "Can't get a theme from another package");
        return C10418d.m63963e(theme == null ? C10416b.m63958b(this.f7092a, contextM9157d, iM9160g) : C10416b.m63957a(this.f7092a, iM9160g, theme));
    }

    /* renamed from: d */
    public final Context m9157d(Uri uri, String str) {
        if (str.equals(this.f7092a.getPackageName())) {
            return this.f7092a;
        }
        try {
            return this.f7092a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            if (str.contains(this.f7092a.getPackageName())) {
                return this.f7092a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e10);
        }
    }

    /* renamed from: e */
    public final int m9158e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e10) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e10);
        }
    }

    /* renamed from: f */
    public final int m9159f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, OsType.ANDROID);
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    /* renamed from: g */
    public final int m9160g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return m9159f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return m9158e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(Uri uri, C13684i c13684i) {
        return uri.getScheme().equals("android.resource");
    }
}
