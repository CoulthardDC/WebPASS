package ru.coulthard.webpass.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;
import java.util.Objects;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NoteDto {
    @NotNull(message = "Необходимо указать логин")
    String login;

    @NotBlank(message = "Пароль не может быть пустым")
    @NotEmpty(message = "Пароль не может быть пустым")
    @Size(min = 5, message = "Минимальная длина пароля - 5 символов")
    String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteDto noteDto = (NoteDto) o;
        return Objects.equals(login, noteDto.login) && Objects.equals(password, noteDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
