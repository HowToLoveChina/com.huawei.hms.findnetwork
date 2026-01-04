package p829z1;

import p759x1.EnumC13676a;
import p759x1.EnumC13678c;

/* renamed from: z1.j */
/* loaded from: classes.dex */
public abstract class AbstractC14071j {

    /* renamed from: a */
    public static final AbstractC14071j f62954a = new a();

    /* renamed from: b */
    public static final AbstractC14071j f62955b = new b();

    /* renamed from: c */
    public static final AbstractC14071j f62956c = new c();

    /* renamed from: d */
    public static final AbstractC14071j f62957d = new d();

    /* renamed from: e */
    public static final AbstractC14071j f62958e = new e();

    /* renamed from: z1.j$a */
    public class a extends AbstractC14071j {
        @Override // p829z1.AbstractC14071j
        /* renamed from: a */
        public boolean mo84352a() {
            return true;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: b */
        public boolean mo84353b() {
            return true;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: c */
        public boolean mo84354c(EnumC13676a enumC13676a) {
            return enumC13676a == EnumC13676a.REMOTE;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: d */
        public boolean mo84355d(boolean z10, EnumC13676a enumC13676a, EnumC13678c enumC13678c) {
            return (enumC13676a == EnumC13676a.RESOURCE_DISK_CACHE || enumC13676a == EnumC13676a.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: z1.j$b */
    public class b extends AbstractC14071j {
        @Override // p829z1.AbstractC14071j
        /* renamed from: a */
        public boolean mo84352a() {
            return false;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: b */
        public boolean mo84353b() {
            return false;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: c */
        public boolean mo84354c(EnumC13676a enumC13676a) {
            return false;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: d */
        public boolean mo84355d(boolean z10, EnumC13676a enumC13676a, EnumC13678c enumC13678c) {
            return false;
        }
    }

    /* renamed from: z1.j$c */
    public class c extends AbstractC14071j {
        @Override // p829z1.AbstractC14071j
        /* renamed from: a */
        public boolean mo84352a() {
            return true;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: b */
        public boolean mo84353b() {
            return false;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: c */
        public boolean mo84354c(EnumC13676a enumC13676a) {
            return (enumC13676a == EnumC13676a.DATA_DISK_CACHE || enumC13676a == EnumC13676a.MEMORY_CACHE) ? false : true;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: d */
        public boolean mo84355d(boolean z10, EnumC13676a enumC13676a, EnumC13678c enumC13678c) {
            return false;
        }
    }

    /* renamed from: z1.j$d */
    public class d extends AbstractC14071j {
        @Override // p829z1.AbstractC14071j
        /* renamed from: a */
        public boolean mo84352a() {
            return false;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: b */
        public boolean mo84353b() {
            return true;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: c */
        public boolean mo84354c(EnumC13676a enumC13676a) {
            return false;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: d */
        public boolean mo84355d(boolean z10, EnumC13676a enumC13676a, EnumC13678c enumC13678c) {
            return (enumC13676a == EnumC13676a.RESOURCE_DISK_CACHE || enumC13676a == EnumC13676a.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: z1.j$e */
    public class e extends AbstractC14071j {
        @Override // p829z1.AbstractC14071j
        /* renamed from: a */
        public boolean mo84352a() {
            return true;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: b */
        public boolean mo84353b() {
            return true;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: c */
        public boolean mo84354c(EnumC13676a enumC13676a) {
            return enumC13676a == EnumC13676a.REMOTE;
        }

        @Override // p829z1.AbstractC14071j
        /* renamed from: d */
        public boolean mo84355d(boolean z10, EnumC13676a enumC13676a, EnumC13678c enumC13678c) {
            return ((z10 && enumC13676a == EnumC13676a.DATA_DISK_CACHE) || enumC13676a == EnumC13676a.LOCAL) && enumC13678c == EnumC13678c.TRANSFORMED;
        }
    }

    /* renamed from: a */
    public abstract boolean mo84352a();

    /* renamed from: b */
    public abstract boolean mo84353b();

    /* renamed from: c */
    public abstract boolean mo84354c(EnumC13676a enumC13676a);

    /* renamed from: d */
    public abstract boolean mo84355d(boolean z10, EnumC13676a enumC13676a, EnumC13678c enumC13678c);
}
