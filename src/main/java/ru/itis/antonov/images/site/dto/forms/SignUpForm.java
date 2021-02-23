package ru.itis.antonov.images.site.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.antonov.images.site.validators.EqualsPasswords;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsPasswords(message = "password incorrect", password = "password", passwordRepeat = "passwordRepeat")
public class SignUpForm {
    @Size(max = 20, message = "too long nick (25 characters max)")
    private String nickName;
    @Email(message = "incorrect email")
    private String email;
    private String password;
    private String passwordRepeat;
}
