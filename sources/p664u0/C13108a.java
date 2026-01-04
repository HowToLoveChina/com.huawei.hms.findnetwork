package p664u0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* renamed from: u0.a */
/* loaded from: classes.dex */
public final class C13108a {

    /* renamed from: f */
    public static final Object f59583f = new Object();

    /* renamed from: g */
    public static C13108a f59584g;

    /* renamed from: a */
    public final Context f59585a;

    /* renamed from: b */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f59586b = new HashMap<>();

    /* renamed from: c */
    public final HashMap<String, ArrayList<c>> f59587c = new HashMap<>();

    /* renamed from: d */
    public final ArrayList<b> f59588d = new ArrayList<>();

    /* renamed from: e */
    public final Handler f59589e;

    /* renamed from: u0.a$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                C13108a.this.m78879a();
            }
        }
    }

    /* renamed from: u0.a$b */
    public static final class b {

        /* renamed from: a */
        public final Intent f59591a;

        /* renamed from: b */
        public final ArrayList<c> f59592b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f59591a = intent;
            this.f59592b = arrayList;
        }
    }

    /* renamed from: u0.a$c */
    public static final class c {

        /* renamed from: a */
        public final IntentFilter f59593a;

        /* renamed from: b */
        public final BroadcastReceiver f59594b;

        /* renamed from: c */
        public boolean f59595c;

        /* renamed from: d */
        public boolean f59596d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f59593a = intentFilter;
            this.f59594b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f59594b);
            sb2.append(" filter=");
            sb2.append(this.f59593a);
            if (this.f59596d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    public C13108a(Context context) {
        this.f59585a = context;
        this.f59589e = new a(context.getMainLooper());
    }

    /* renamed from: b */
    public static C13108a m78878b(Context context) {
        C13108a c13108a;
        synchronized (f59583f) {
            try {
                if (f59584g == null) {
                    f59584g = new C13108a(context.getApplicationContext());
                }
                c13108a = f59584g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13108a;
    }

    /* renamed from: a */
    public void m78879a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f59586b) {
                try {
                    size = this.f59588d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f59588d.toArray(bVarArr);
                    this.f59588d.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f59592b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = bVar.f59592b.get(i11);
                    if (!cVar.f59596d) {
                        cVar.f59594b.onReceive(this.f59585a, bVar.f59591a);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public void m78880c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f59586b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList<c> arrayList = this.f59586b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f59586b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                    String action = intentFilter.getAction(i10);
                    ArrayList<c> arrayList2 = this.f59587c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f59587c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public boolean m78881d(Intent intent) {
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f59586b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f59585a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z10 = (intent.getFlags() & 8) != 0;
                if (z10) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<c> arrayList3 = this.f59587c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z10) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i11 = 0;
                    while (i11 < arrayList3.size()) {
                        c cVar = arrayList3.get(i11);
                        if (z10) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f59593a);
                        }
                        if (cVar.f59595c) {
                            if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            i10 = i11;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = strResolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i10 = i11;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = strResolveTypeIfNeeded;
                            int iMatch = cVar.f59593a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z10) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(cVar);
                                cVar.f59595c = true;
                                i11 = i10 + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                strResolveTypeIfNeeded = str2;
                            } else if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : Constants.CONTENT_SERVER_REALM : Constants.AUTOCONTENT_CATEGORY));
                            }
                        }
                        arrayList4 = arrayList;
                        i11 = i10 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                            ((c) arrayList5.get(i12)).f59595c = false;
                        }
                        this.f59588d.add(new b(intent, arrayList5));
                        if (!this.f59589e.hasMessages(1)) {
                            this.f59589e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public void m78882e(Intent intent) {
        if (m78881d(intent)) {
            m78879a();
        }
    }

    /* renamed from: f */
    public void m78883f(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f59586b) {
            try {
                ArrayList<c> arrayListRemove = this.f59586b.remove(broadcastReceiver);
                if (arrayListRemove == null) {
                    return;
                }
                for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                    c cVar = arrayListRemove.get(size);
                    cVar.f59596d = true;
                    for (int i10 = 0; i10 < cVar.f59593a.countActions(); i10++) {
                        String action = cVar.f59593a.getAction(i10);
                        ArrayList<c> arrayList = this.f59587c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.f59594b == broadcastReceiver) {
                                    cVar2.f59596d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f59587c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
