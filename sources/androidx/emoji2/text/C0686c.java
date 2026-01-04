package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.emoji2.text.C0688e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p042c0.C1372e;
import p243e0.C9373h;

/* renamed from: androidx.emoji2.text.c */
/* loaded from: classes.dex */
public final class C0686c {

    /* renamed from: androidx.emoji2.text.c$a */
    public static class a {

        /* renamed from: a */
        public final b f3591a;

        public a(b bVar) {
            this.f3591a = bVar == null ? m4207e() : bVar;
        }

        /* renamed from: e */
        public static b m4207e() {
            return new d();
        }

        /* renamed from: a */
        public final C0688e.c m4208a(Context context, C1372e c1372e) {
            if (c1372e == null) {
                return null;
            }
            return new C0693j(context, c1372e);
        }

        /* renamed from: b */
        public final List<List<byte[]>> m4209b(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        /* renamed from: c */
        public C0688e.c m4210c(Context context) {
            return m4208a(context, m4214h(context));
        }

        /* renamed from: d */
        public final C1372e m4211d(ProviderInfo providerInfo, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new C1372e(str, str2, "emojicompat-emoji-font", m4209b(this.f3591a.mo4216b(packageManager, str2)));
        }

        /* renamed from: f */
        public final boolean m4212f(ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        /* renamed from: g */
        public final ProviderInfo m4213g(PackageManager packageManager) {
            Iterator<ResolveInfo> it = this.f3591a.mo4217c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (it.hasNext()) {
                ProviderInfo providerInfoMo4215a = this.f3591a.mo4215a(it.next());
                if (m4212f(providerInfoMo4215a)) {
                    return providerInfoMo4215a;
                }
            }
            return null;
        }

        /* renamed from: h */
        public C1372e m4214h(Context context) {
            PackageManager packageManager = context.getPackageManager();
            C9373h.m58746g(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfoM4213g = m4213g(packageManager);
            if (providerInfoM4213g == null) {
                return null;
            }
            try {
                return m4211d(providerInfoM4213g, packageManager);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e10);
                return null;
            }
        }
    }

    /* renamed from: androidx.emoji2.text.c$b */
    public static class b {
        /* renamed from: a */
        public ProviderInfo mo4215a(ResolveInfo resolveInfo) {
            throw null;
        }

        /* renamed from: b */
        public Signature[] mo4216b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            throw null;
        }

        /* renamed from: c */
        public List<ResolveInfo> mo4217c(PackageManager packageManager, Intent intent, int i10) {
            throw null;
        }
    }

    /* renamed from: androidx.emoji2.text.c$c */
    public static class c extends b {
        @Override // androidx.emoji2.text.C0686c.b
        /* renamed from: a */
        public ProviderInfo mo4215a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.C0686c.b
        /* renamed from: c */
        public List<ResolveInfo> mo4217c(PackageManager packageManager, Intent intent, int i10) {
            return packageManager.queryIntentContentProviders(intent, i10);
        }
    }

    /* renamed from: androidx.emoji2.text.c$d */
    public static class d extends c {
        @Override // androidx.emoji2.text.C0686c.b
        /* renamed from: b */
        public Signature[] mo4216b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    /* renamed from: a */
    public static C0693j m4206a(Context context) {
        return (C0693j) new a(null).m4210c(context);
    }
}
