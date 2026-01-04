package p219d7;

import android.os.Build;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p031b7.C1120a;

/* renamed from: d7.a */
/* loaded from: classes2.dex */
public class C9045a {

    /* renamed from: d7.a$a */
    public static final class a {
        /* renamed from: b */
        public static void m57016b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = C9046b.m57019a(classLoader, "pathList").get(classLoader);
            List arrayList = (List) C9046b.m57019a(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            arrayList.add(0, file);
            List arrayList2 = (List) C9046b.m57019a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            C9046b.m57019a(obj, "nativeLibraryPathElements").set(obj, (Object[]) C9046b.m57020b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList3, null, new ArrayList()));
        }
    }

    /* renamed from: d7.a$b */
    public static final class b {
        /* renamed from: b */
        public static void m57018b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = C9046b.m57019a(classLoader, "pathList").get(classLoader);
            List arrayList = (List) C9046b.m57019a(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            arrayList.add(0, file);
            List arrayList2 = (List) C9046b.m57019a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            C9046b.m57019a(obj, "nativeLibraryPathElements").set(obj, (Object[]) C9046b.m57020b(obj, "makePathElements", List.class).invoke(obj, arrayList3));
        }
    }

    /* renamed from: a */
    public static void m57014a(ClassLoader classLoader, File file) throws Throwable {
        if (file == null || !file.exists()) {
            C1120a.m6676e("AlbumLoadLibrary", String.format("installNativeLibraryPath, folder %s is illegal", file));
            return;
        }
        try {
            C1120a.m6677i("AlbumLoadLibrary", "installNativeLibraryPath install V25");
            b.m57018b(classLoader, file);
        } catch (Throwable th2) {
            C1120a.m6676e("AlbumLoadLibrary", String.format(Locale.getDefault(), "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th2.getMessage()));
            a.m57016b(classLoader, file);
        }
    }
}
