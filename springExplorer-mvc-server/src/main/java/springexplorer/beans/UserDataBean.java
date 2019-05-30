package springexplorer.beans;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserDataBean {

    @NotNull
    private String name;

    private Date birth;

    @Min(0)
    private int age;
}
