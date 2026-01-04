package com.huawei.fastengine.fastview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class FastViewInstanceGroup {
    List<FastViewInstance> instances = new ArrayList();

    public void add(FastViewInstance fastViewInstance) {
        this.instances.add(fastViewInstance);
    }

    public void onDestroy() {
        Iterator<FastViewInstance> it = this.instances.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public void onPause() {
        Iterator<FastViewInstance> it = this.instances.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public void onResume() {
        Iterator<FastViewInstance> it = this.instances.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    public void onStart() {
        Iterator<FastViewInstance> it = this.instances.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    public void onStop() {
        Iterator<FastViewInstance> it = this.instances.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public void remove(FastViewInstance fastViewInstance) {
        this.instances.remove(fastViewInstance);
    }
}
