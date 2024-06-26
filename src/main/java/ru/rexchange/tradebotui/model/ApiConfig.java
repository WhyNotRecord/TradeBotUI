package ru.rexchange.tradebotui.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import javax.persistence.*;

@Entity
@Views({
    @View(name="Simple", members="apiName;"),
})
@Getter @Setter
@Table(name="API_CREDENTIALS")
public class ApiConfig {
  @Id
  @Hidden
  @Column(name="api_id")
  long apiId;

  @Column(name="api_type", length=32)
  @Editor("ValidValuesCombo")
  @Enumerated(EnumType.STRING)
  @Hidden
  ApiType apiType;
  enum ApiType {binance, kucoin, mail}

  @Column(name="api_name", length=64)
  @Required
  String apiName;

  @Column(name="api_public_key", length=120)
  @Required
  String apiPublicKey;

  @Column(name="api_private_key", length=120)
  @Required
  String apiPrivateKey;

  @Column(name="api_personal_key", length=64)
  @Required
  String apiPersonalKey;

}
