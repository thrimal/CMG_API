package lk.ijse.springboot.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
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
