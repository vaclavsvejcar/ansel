package cloud.ansel.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import jakarta.faces.webapp.FacesServlet;
import jakarta.servlet.ServletContext;

@Configuration
public class JsfConfig {

    @Bean
    ServletRegistrationBean<FacesServlet> facesServletRegistration(ServletContext servletContext) {
        // spring boot only works if this is set
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());

        // FacesServlet registration
        final ServletRegistrationBean<FacesServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new FacesServlet());
        bean.setUrlMappings(List.of("*.xhtml"));
        bean.setLoadOnStartup(1);
        return bean;
    }
}
