package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: h */
    public static final Object f3295h = new Object();

    /* renamed from: i */
    public static final HashMap<ComponentName, AbstractC0603f> f3296i = new HashMap<>();

    /* renamed from: a */
    public InterfaceC0599b f3297a;

    /* renamed from: b */
    public AbstractC0603f f3298b;

    /* renamed from: c */
    public AsyncTaskC0598a f3299c;

    /* renamed from: d */
    public boolean f3300d = false;

    /* renamed from: e */
    public boolean f3301e = false;

    /* renamed from: f */
    public boolean f3302f = false;

    /* renamed from: g */
    public final ArrayList<C0600c> f3303g = null;

    /* renamed from: androidx.core.app.JobIntentService$a */
    public final class AsyncTaskC0598a extends AsyncTask<Void, Void, Void> {
        public AsyncTaskC0598a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                InterfaceC0601d interfaceC0601dM3781a = JobIntentService.this.m3781a();
                if (interfaceC0601dM3781a == null) {
                    return null;
                }
                JobIntentService.this.m3784d(interfaceC0601dM3781a.getIntent());
                interfaceC0601dM3781a.mo3792a();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.m3786f();
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.m3786f();
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$b */
    public interface InterfaceC0599b {
        /* renamed from: a */
        IBinder mo3790a();

        /* renamed from: b */
        InterfaceC0601d mo3791b();
    }

    /* renamed from: androidx.core.app.JobIntentService$c */
    public final class C0600c implements InterfaceC0601d {

        /* renamed from: a */
        public final Intent f3305a;

        /* renamed from: b */
        public final int f3306b;

        public C0600c(Intent intent, int i10) {
            this.f3305a = intent;
            this.f3306b = i10;
        }

        @Override // androidx.core.app.JobIntentService.InterfaceC0601d
        /* renamed from: a */
        public void mo3792a() {
            JobIntentService.this.stopSelf(this.f3306b);
        }

        @Override // androidx.core.app.JobIntentService.InterfaceC0601d
        public Intent getIntent() {
            return this.f3305a;
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$d */
    public interface InterfaceC0601d {
        /* renamed from: a */
        void mo3792a();

        Intent getIntent();
    }

    /* renamed from: androidx.core.app.JobIntentService$e */
    public static final class JobServiceEngineC0602e extends JobServiceEngine implements InterfaceC0599b {

        /* renamed from: a */
        public final JobIntentService f3308a;

        /* renamed from: b */
        public final Object f3309b;

        /* renamed from: c */
        public JobParameters f3310c;

        /* renamed from: androidx.core.app.JobIntentService$e$a */
        public final class a implements InterfaceC0601d {

            /* renamed from: a */
            public final JobWorkItem f3311a;

            public a(JobWorkItem jobWorkItem) {
                this.f3311a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.InterfaceC0601d
            /* renamed from: a */
            public void mo3792a() {
                synchronized (JobServiceEngineC0602e.this.f3309b) {
                    try {
                        JobParameters jobParameters = JobServiceEngineC0602e.this.f3310c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f3311a);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.InterfaceC0601d
            public Intent getIntent() {
                return this.f3311a.getIntent();
            }
        }

        public JobServiceEngineC0602e(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f3309b = new Object();
            this.f3308a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.InterfaceC0599b
        /* renamed from: a */
        public IBinder mo3790a() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.InterfaceC0599b
        /* renamed from: b */
        public InterfaceC0601d mo3791b() {
            synchronized (this.f3309b) {
                try {
                    JobParameters jobParameters = this.f3310c;
                    if (jobParameters == null) {
                        return null;
                    }
                    JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f3308a.getClassLoader());
                    return new a(jobWorkItemDequeueWork);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f3310c = jobParameters;
            this.f3308a.m3783c(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zM3782b = this.f3308a.m3782b();
            synchronized (this.f3309b) {
                this.f3310c = null;
            }
            return zM3782b;
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$f */
    public static abstract class AbstractC0603f {
        /* renamed from: a */
        public abstract void m3793a();

        /* renamed from: b */
        public abstract void m3794b();

        /* renamed from: c */
        public abstract void m3795c();
    }

    /* renamed from: a */
    public InterfaceC0601d m3781a() {
        InterfaceC0599b interfaceC0599b = this.f3297a;
        if (interfaceC0599b != null) {
            return interfaceC0599b.mo3791b();
        }
        synchronized (this.f3303g) {
            try {
                if (this.f3303g.size() <= 0) {
                    return null;
                }
                return this.f3303g.remove(0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public boolean m3782b() {
        AsyncTaskC0598a asyncTaskC0598a = this.f3299c;
        if (asyncTaskC0598a != null) {
            asyncTaskC0598a.cancel(this.f3300d);
        }
        this.f3301e = true;
        return m3785e();
    }

    /* renamed from: c */
    public void m3783c(boolean z10) {
        if (this.f3299c == null) {
            this.f3299c = new AsyncTaskC0598a();
            this.f3299c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: d */
    public abstract void m3784d(Intent intent);

    /* renamed from: e */
    public boolean m3785e() {
        return true;
    }

    /* renamed from: f */
    public void m3786f() {
        ArrayList<C0600c> arrayList = this.f3303g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f3299c = null;
                    ArrayList<C0600c> arrayList2 = this.f3303g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        m3783c(false);
                    } else if (!this.f3302f) {
                        this.f3298b.m3793a();
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterfaceC0599b interfaceC0599b = this.f3297a;
        if (interfaceC0599b != null) {
            return interfaceC0599b.mo3790a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f3297a = new JobServiceEngineC0602e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<C0600c> arrayList = this.f3303g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f3302f = true;
                this.f3298b.m3793a();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (this.f3303g == null) {
            return 2;
        }
        this.f3298b.m3795c();
        synchronized (this.f3303g) {
            ArrayList<C0600c> arrayList = this.f3303g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new C0600c(intent, i11));
            m3783c(true);
        }
        return 3;
    }
}
