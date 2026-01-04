package p481n1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: n1.n */
/* loaded from: classes.dex */
public class C11602n {

    /* renamed from: a */
    public static final Set<String> f53840a = new HashSet();

    /* renamed from: a */
    public static <T> Set<T> m69239a(Class<T> cls, ClassLoader classLoader) {
        if (classLoader == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        String str = "META-INF/services/" + cls.getName();
        HashSet hashSet2 = new HashSet();
        try {
            Enumeration<URL> resources = classLoader.getResources(str);
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                Set<String> set = f53840a;
                if (!set.contains(urlNextElement.toString())) {
                    m69240b(urlNextElement, hashSet2);
                    set.add(urlNextElement.toString());
                }
            }
        } catch (Throwable unused) {
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(classLoader.loadClass((String) it.next()).newInstance());
            } catch (Exception unused2) {
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    public static void m69240b(URL url, Set<String> set) throws Throwable {
        InputStream inputStreamOpenStream;
        BufferedReader bufferedReader = null;
        try {
            inputStreamOpenStream = url.openStream();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamOpenStream, "utf-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            C11595g.m69206a(bufferedReader2);
                            C11595g.m69206a(inputStreamOpenStream);
                            return;
                        }
                        int iIndexOf = line.indexOf(35);
                        if (iIndexOf >= 0) {
                            line = line.substring(0, iIndexOf);
                        }
                        String strTrim = line.trim();
                        if (strTrim.length() != 0) {
                            set.add(strTrim);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        C11595g.m69206a(bufferedReader);
                        C11595g.m69206a(inputStreamOpenStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamOpenStream = null;
        }
    }
}
