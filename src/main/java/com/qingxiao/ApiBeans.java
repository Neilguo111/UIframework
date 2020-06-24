package com.qingxiao;

public class ApiBeans {
    private String path;
    private String name;
    private String method;
    private String params;
    private int needToken;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMethod(String method){
        this.method = method;
    }

    public String getMethod(){
        return method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getNeedToken() {
        return needToken;
    }

    public void setNeedToken(int needToken) {
        this.needToken = needToken;
    }


    @Override
    public String toString() {
        return "ApiBeans{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                ", needToken=" + needToken +
                '}';
    }
}
