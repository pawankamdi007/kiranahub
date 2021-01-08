package KiranaHub.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
	            AppContext.class
	        };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
	            WebMvcConfig.class
	        };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}


}
