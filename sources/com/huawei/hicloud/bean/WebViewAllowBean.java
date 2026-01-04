package com.huawei.hicloud.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class WebViewAllowBean {
    private Configuration configurations;
    private String date;

    /* renamed from: id */
    private String f22235id;
    private long version;

    public static class Configuration {
        private List<Allow> allowList;
        private List<Policy> policyList;

        public static class Allow {
            private String policyId;
            private String url;

            public String getPolicyId() {
                return this.policyId;
            }

            public String getUrl() {
                return this.url;
            }

            public void setPolicyId(String str) {
                this.policyId = str;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public static class Policy {
            private int controlType;
            private int index;
            private String interfaceList;
            private String name;
            private String policyId;

            public int getControlType() {
                return this.controlType;
            }

            public int getIndex() {
                return this.index;
            }

            public String getInterfaceList() {
                return this.interfaceList;
            }

            public String getName() {
                return this.name;
            }

            public String getPolicyId() {
                return this.policyId;
            }

            public void setControlType(int i10) {
                this.controlType = i10;
            }

            public void setIndex(int i10) {
                this.index = i10;
            }

            public void setInterfaceList(String str) {
                this.interfaceList = str;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setPolicyId(String str) {
                this.policyId = str;
            }

            public String toString() {
                return "Policy{controlType=" + this.controlType + ", index=" + this.index + ", policyId='" + this.policyId + "', interfaceList='" + this.interfaceList + "', name='" + this.name + "'}";
            }
        }

        public List<Allow> getAllowList() {
            return this.allowList;
        }

        public List<Policy> getPolicyList() {
            return this.policyList;
        }

        public void setAllowList(List<Allow> list) {
            this.allowList = list;
        }

        public void setPolicyList(List<Policy> list) {
            this.policyList = list;
        }
    }

    public Configuration getConfigurations() {
        return this.configurations;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22235id;
    }

    public long getVersion() {
        return this.version;
    }

    public void setConfigurations(Configuration configuration) {
        this.configurations = configuration;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22235id = str;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }
}
