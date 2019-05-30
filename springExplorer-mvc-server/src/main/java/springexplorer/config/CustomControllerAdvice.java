package springexplorer.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class CustomControllerAdvice {
    @Autowired
    PropertyEditorRegistrar datePropertyEditorRegistrar;


    /**
     * DataBinder 也是通过 SimpleTypeConverter 作为工具进行转换的<br>
     * 此处的databinder 会被被RequestMappingHandlerAdapter的webBindingInitializer（ConfigurableWebBindingInitializer）初始化
     * 将webBindingInitializer的propertiEditor赋值给databinder<br>
     * 将webBindingInitializer的convertService赋值给databinder<br>
     * 将webBindingInitializer的validator赋值给databinder<br>
     * 同样还有：messageCodesResolver  bindingErrorProcessor  validator  conversionService propertyEditorRegistrars<br>
     * <p>
     * 参考 DefaultDataBinderFactory.createBinder  ConfigurableWebBindingInitializer.initBinder<br>
     * 由此可见除了 @ControllerAdvice  RequestMappingHandlerAdapter 的 ConfigurableWebBindingInitializer 可能是另一个<br>
     * 添加自定了类型转换，数据校验的切入点<br>
     * @param binder <br>
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
                false));

    }

    @InitBinder
    public void initBinder2(WebDataBinder binder) {
        datePropertyEditorRegistrar.registerCustomEditors(binder);
    }
}
