package model;

import java.util.List;

public class ListResult {

    private List<Integer> result;
    private String token;

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return result + ":" + token;
    }

}
