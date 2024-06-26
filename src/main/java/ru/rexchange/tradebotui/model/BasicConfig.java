package ru.rexchange.tradebotui.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name="APP_CONFIG")
public class BasicConfig {
  @Id
  @Column(name="config_id")
  @Hidden
  long configId;

  @Column(name="password_default", length=32)
  @Required
  String passwordDefault;

  @Column(name="tg_token", length=120)
  @Required
  String tgToken;

  /*{"name": "temp_dir_path", "domain": {"type": "string", "size": 255}},
  {"name": "mail_login_default", "domain": {"type": "string", "size": 32}},
  {"name": "mail_pass_default", "domain": {"type": "string", "size": 32}}*/

}
