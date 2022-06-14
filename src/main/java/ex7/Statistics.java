package ex7;

public class Statistics {
    private long success;
    private long failure;

    public long getSuccess() {
        return success;
    }

    public long getFailure() {
        return failure;
    }

    public void collect(boolean sent) {
        if (sent) {
            success++;
        } else {
            failure++;
        }
    }
}
