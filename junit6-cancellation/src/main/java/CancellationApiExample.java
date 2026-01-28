import org.junit.platform.engine.CancellationToken;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.*;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class CancellationApiExample {
    public static void main(String[] args) {
        CancellationToken token = CancellationToken.create();

        LauncherExecutionRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(CancellationTest.class))
                .forExecution()
                .cancellationToken(token)
                .listeners(new CancellationListener(token))
                .build();

        LauncherFactory.openSession().getLauncher().execute(request);
    }
}
