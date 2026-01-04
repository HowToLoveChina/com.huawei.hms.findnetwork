package p680ui;

import com.huawei.cloud.base.util.C4635e0;
import com.huawei.cloud.base.util.C4647o;
import com.huawei.cloud.base.util.C4655w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

/* renamed from: ui.g */
/* loaded from: classes.dex */
public class C13183g extends AbstractC13178b {

    /* renamed from: e */
    public static final Logger f59709e = Logger.getLogger(C13183g.class.getName());

    /* renamed from: d */
    public final File f59710d;

    /* renamed from: ui.g$a */
    public static class a<V extends Serializable> extends C13179c<V> {

        /* renamed from: e */
        public final File f59711e;

        public a(C13183g c13183g, File file, String str) throws IOException {
            super(c13183g, str);
            File file2 = new File(file, str);
            this.f59711e = file2;
            if (C4647o.m28479f(file2)) {
                throw new IOException("unable to use a symbolic link: " + file2);
            }
            if (!file2.createNewFile()) {
                this.f59707c = (HashMap) C4647o.m28477d(new FileInputStream(file2));
            } else {
                this.f59707c = C4655w.m28495a();
                mo79230d();
            }
        }

        @Override // p680ui.C13179c
        /* renamed from: d */
        public void mo79230d() throws IOException {
            C4647o.m28480g(this.f59707c, new FileOutputStream(this.f59711e));
        }
    }

    public C13183g(File file) throws Throwable {
        File canonicalFile = file.getCanonicalFile();
        this.f59710d = canonicalFile;
        if (C4647o.m28479f(canonicalFile)) {
            throw new IOException("unable to use a symbolic link: " + canonicalFile);
        }
        if (canonicalFile.exists() || canonicalFile.mkdirs()) {
            m79232c(canonicalFile);
            return;
        }
        throw new IOException("unable to create directory: " + canonicalFile);
    }

    /* renamed from: c */
    public static void m79232c(File file) throws Throwable {
        try {
            Class cls = Boolean.TYPE;
            Method method = File.class.getMethod("setReadable", cls, cls);
            Method method2 = File.class.getMethod("setWritable", cls, cls);
            Method method3 = File.class.getMethod("setExecutable", cls, cls);
            Boolean bool = Boolean.FALSE;
            if (!((Boolean) method.invoke(file, bool, bool)).booleanValue() || !((Boolean) method2.invoke(file, bool, bool)).booleanValue() || !((Boolean) method3.invoke(file, bool, bool)).booleanValue()) {
                f59709e.warning("unable to change permissions for everybody: " + file);
            }
            Boolean bool2 = Boolean.TRUE;
            if (((Boolean) method.invoke(file, bool2, bool2)).booleanValue() && ((Boolean) method2.invoke(file, bool2, bool2)).booleanValue() && ((Boolean) method3.invoke(file, bool2, bool2)).booleanValue()) {
                return;
            }
            f59709e.warning("unable to change permissions for owner: " + file);
        } catch (IllegalAccessException e10) {
            f59709e.info(e10.toString());
        } catch (IllegalArgumentException e11) {
            f59709e.info(e11.toString());
        } catch (NoSuchMethodException unused) {
            f59709e.warning("Unable to set permissions for " + file + ", likely because you are running a version of Java prior to 1.6");
        } catch (SecurityException e12) {
            f59709e.info(e12.toString());
        } catch (InvocationTargetException e13) {
            Throwable cause = e13.getCause();
            C4635e0.m28410c(cause, IOException.class);
            throw new IOException(cause);
        }
    }

    @Override // p680ui.AbstractC13178b
    /* renamed from: a */
    public <V extends Serializable> InterfaceC13180d<V> mo79225a(String str) throws IOException {
        return new a(this, this.f59710d, str);
    }
}
