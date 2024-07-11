package spring_mvc_tes.belajar_spring_mvc.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloRequest {

    private String name;

    public String helloName(){
        return name;
    }
}
