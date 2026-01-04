package com.huawei.openalliance.p169ad;

import android.os.FileObserver;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.dm */
/* loaded from: classes8.dex */
public class FileObserverC7024dm extends FileObserver {

    /* renamed from: a */
    private Map<String, Integer> f32235a;

    public FileObserverC7024dm(File file) {
        super(file);
        this.f32235a = new ConcurrentHashMap();
    }

    /* renamed from: b */
    private boolean m42018b(String str) {
        return this.f32235a.containsKey(str) && this.f32235a.get(str).intValue() > 0;
    }

    /* renamed from: c */
    private void m42019c(String str) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("FileListener", "setNotAccessed, accessMap = %s", Arrays.asList(this.f32235a));
        }
        AbstractC7185ho.m43818a("FileListener", "setAccessed, accessMap = %s", Arrays.asList(this.f32235a));
        boolean zContainsKey = this.f32235a.containsKey(str);
        Map<String, Integer> map = this.f32235a;
        map.put(str, zContainsKey ? Integer.valueOf(map.get(str).intValue() + 1) : 1);
    }

    /* renamed from: d */
    private void m42020d(String str) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("FileListener", "setNotAccessed, accessMap = %s", Arrays.asList(this.f32235a));
        }
        if (this.f32235a.containsKey(str)) {
            int iIntValue = this.f32235a.get(str).intValue();
            Map<String, Integer> map = this.f32235a;
            if (iIntValue > 1) {
                map.put(str, Integer.valueOf(map.get(str).intValue() - 1));
            } else {
                map.remove(str);
            }
        }
    }

    /* renamed from: a */
    public boolean m42021a(String str) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("FileListener", "accessMap = %s", Arrays.asList(this.f32235a));
        }
        return m42018b(str);
    }

    @Override // android.os.FileObserver
    public void onEvent(int i10, String str) {
        if (i10 == 16) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("FileListener", "CLOSE_NOWRITE, path= %s", str);
            }
            m42020d(str);
        } else {
            if (i10 != 32) {
                return;
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("FileListener", "OPEN, path= %s", str);
            }
            m42019c(str);
        }
    }

    public FileObserverC7024dm(String str) {
        super(str);
        this.f32235a = new ConcurrentHashMap();
    }
}
