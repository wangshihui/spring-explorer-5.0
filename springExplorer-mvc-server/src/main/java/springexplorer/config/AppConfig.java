package springexplorer.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvc
@ComponentScan("springexplorer")
public class AppConfig {

    /**
     * 注册自定义的PropertyEditor
     *
     * @return
     */
    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer retuslt = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> map = new HashMap<>();
        map.put(Date.class, DatePe.class);
        // 这样注册的PE 可以被BeanFactory 使用,
        // 所以可以在 BeanFactory解析bean元数据转化的包括bean的依赖注入时对属性进行解析
        // 但是并非beanFactory 可以管理的对象
        retuslt.setCustomEditors(map);
        // AbstractBeanFactory.getTypeConverter 可以看到  这两种注册方式没有区别
        // 最终都是通过 SimpleTypeConverter 最为中介使用，
        // 当然如果在 beanFactory 中注册了
        PropertyEditorRegistrar[] registar = new PropertyEditorRegistrar[1];
        registar[0]=new CustomPropertyEditorRegistrar();
        retuslt.setPropertyEditorRegistrars(registar);
        return retuslt;
    }

    /**
     * 自定义的PropertyEditor
     */
    static class DatePe extends PropertyEditorSupport {
        public void setAsText(String text) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            try {
                setValue(sdf.parse(text));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Bean
    public  PropertyEditorRegistrar datePropertyEditorRegistrar(){
        return new CustomPropertyEditorRegistrar();
    }

    /**
     *  Registrar 注冊人，代理一批PropertyEditor 负责向注册中心registry 注册PropertyEditor
     *
     *  可以通过 spring 的依赖注入进行管理
     *
     */
    public static class CustomPropertyEditorRegistrar implements
            PropertyEditorRegistrar {
        public void registerCustomEditors(PropertyEditorRegistry registry) {
                // it is expected that new PropertyEditor instances are created
            registry.registerCustomEditor(Date.class, new DatePe());
            // you could register as many custom property editors as are required
        }

    }

}
