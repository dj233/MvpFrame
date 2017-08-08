package lib.data.avatar.xiehouyu;

/**
 * Created by 军军 on 2017/8/8.
 */

public class Rsp<T> {

    /**
     * error_code : 0
     * reason : Succes
     * total : 673
     * result : t
     */

    private int error_code;
    private String reason;
    private int total;
    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
