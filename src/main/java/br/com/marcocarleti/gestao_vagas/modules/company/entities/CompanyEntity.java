package br.com.marcocarleti.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
  private String username;

  @Email(message = "O campo [email] deve conter um e-mail válido")
  private String email;

  @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
  private String password;

  private String website;
  private String name;
  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
