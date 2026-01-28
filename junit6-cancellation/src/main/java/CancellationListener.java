import org.junit.platform.engine.CancellationToken;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

class CancellationListener implements TestExecutionListener {
    private final CancellationToken token;

    CancellationListener(CancellationToken token) {
        this.token = token;
    }

    public void executionFinished(TestIdentifier id, TestExecutionResult result) {
        if (id.isTest()) {
            System.out.println(id.getDisplayName() + " - " + result.getStatus());
            if (result.getStatus() == TestExecutionResult.Status.FAILED) {
                token.cancel();
            }
        }
    }

    public void executionSkipped(TestIdentifier id, String reason) {
        if (id.isTest()) {
            System.out.println(id.getDisplayName() + " - SKIPPED");
        }
    }
}
