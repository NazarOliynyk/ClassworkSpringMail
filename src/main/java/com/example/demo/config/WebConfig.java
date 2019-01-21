package com.example.demo.config;




        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

        import org.springframework.core.env.Environment;
        import org.springframework.format.FormatterRegistry;
        import org.springframework.http.converter.HttpMessageConverter;
        import org.springframework.mail.javamail.JavaMailSenderImpl;
        import org.springframework.validation.MessageCodesResolver;
        import org.springframework.validation.Validator;

        import org.springframework.web.method.support.HandlerMethodArgumentResolver;
        import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
        import org.springframework.web.servlet.HandlerExceptionResolver;
        import org.springframework.web.servlet.config.annotation.*;

        import java.io.File;
        import java.util.List;
        import java.util.Properties;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    Environment env;
//    @Bean
//    public JavaMailSenderImpl mailSender() {
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//
//        javaMailSender.setProtocol("SMTP");
//        javaMailSender.setHost("127.0.0.1");
//        javaMailSender.setPort(587);
//
//        return javaMailSender;
//    }
//    @Bean
//    public JavaMailSenderImpl javaMailSender(){
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(env.getProperty("email.host"));
//        mailSender.setPort(Integer.parseInt(env.getProperty("email.port")));
//        mailSender.setUsername(env.getProperty("email.username"));
//        mailSender.setPassword(env.getProperty("email.password"));
//        Properties properties = mailSender.getJavaMailProperties();
//        properties.put(env.getProperty("email.protocol"), env.getProperty("email.protocol.val"));
//        properties.put(env.getProperty("email.auth"), env.getProperty("email.auth.val"));
//        properties.put(env.getProperty("email.starttls"), env.getProperty("email.starttls.val"));
//        properties.put(env.getProperty("email.mail.debug"), env.getProperty("email.mail.debug.val"));
//
//        return mailSender;
//    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

        String pathToFolder = System.getProperty("user.home")+ File.separator + "images" +File.separator;
        String pathToFolder2 = System.getProperty("user.home")+ File.separator + "cssFiles" +File.separator;

        resourceHandlerRegistry.addResourceHandler("/ava/**").addResourceLocations("file:///"+pathToFolder);
        resourceHandlerRegistry.addResourceHandler("/css/**").addResourceLocations("file:///"+pathToFolder2);
    }

    // this method is for security purposes, just works as a GetController
    // sends to a page login having an url /login.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // it calls login template having the url /login called
        registry.addViewController("/login").setViewName("/login");

    }
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }



    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
