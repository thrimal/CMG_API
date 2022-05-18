package lk.ijse.springboot.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userSchema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements SuperEntity{
    @Id
    private String id;
    private String name;
    private String email;
    private int contact;
    private String userName;
    private String password;
    private String userType;
    private String nic;
    private String employeeId;
}
