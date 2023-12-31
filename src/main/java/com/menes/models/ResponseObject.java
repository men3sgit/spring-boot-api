package com.menes.models;

public class ResponseObject {
    private int code;
    private String description;
    private Object data;

    public ResponseObject(int code, String description, Object data) {
        this.code = code;
        this.description = description;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
