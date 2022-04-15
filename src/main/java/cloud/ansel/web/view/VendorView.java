package cloud.ansel.web.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component("vendorV")
@ApplicationScope
public class VendorView {

    @Value("${ansel.vendor.app-name}")
    private String appName;

    @Value("${ansel.vendor.copyright}")
    private String copyright;

    public String getAppName() {
        return appName;
    }

    public String getCopyright() {
        return copyright;
    }
}
