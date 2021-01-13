package KiranaHub.config;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "KiranaHub"
})
public class WebMvcConfig implements WebMvcConfigurer {

	
	  @Bean 
	  public InternalResourceViewResolver resolver() {
	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	  resolver.setViewClass(JstlView.class); 
	 // resolver.setPrefix("/admininclude/");
	   
	  resolver.setPrefix("/views/");
	  resolver.setSuffix(".jsp");
	  resolver.setOrder(2);
	  return resolver; 
	  }
	  
	  @Bean
		 public ResourceBundleViewResolver resolver1() {
			 ResourceBundleViewResolver resolver1 = new ResourceBundleViewResolver();
			 resolver1.setBasename("views");
			 resolver1.setOrder(1);
			return resolver1;
		 
	  
	  }
	
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("/resources/");
    }
    
}
    
