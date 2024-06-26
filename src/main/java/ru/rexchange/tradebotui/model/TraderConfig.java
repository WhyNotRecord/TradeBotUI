package ru.rexchange.tradebotui.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Views({
    @View(name="Simple", members="name, type;"),
})
@Table(name="TRADER_CONFIG")
public class TraderConfig {
  //		{"name": "TV-WAVES", "type": "binance", "api": "V Binance API",
  //		"dealAmountType": "PERCENT_QUOTED", "dealAmount": "4",
  //		"params": [{"name": "telegramNotificationsChat", "value": "291088633"}]
  @Id
  @Hidden // The property is not shown to the user. It's an internal identifier
  @SequenceGenerator(name = "gen", sequenceName = "seq_trader_id", allocationSize = 10)
  @Column()//length=16
  long id;

  @Column(length=32)
  @Required
  String name;

  @Editor("ValidValuesCombo")//see default-editors.xml
  @Column(length=16)
  @Enumerated(EnumType.STRING)
  @Required
  TraderType type;
  enum TraderType {binance_futures, kucoin_futures/*, binance_spot, kucoin_spot*/, mailer}

  //@Column(name="api_id")
  //long apiId;
  @OneToOne(fetch=FetchType.EAGER,  // The reference is loaded on demand
      optional=false)  // The reference must always have a value
  @JoinColumn(name="api_id")  // api_id is the foreign key column
  @NoCreate
  @NoModify
  @ReferenceView("Simple")
  private ApiConfig apiCreds;  // A regular Java reference

  @ManyToOne(fetch=FetchType.LAZY,  // The reference is loaded on demand
      optional=true)  // The reference must always have a value
  @JoinColumn(name="bot_id")  // bot_id is the foreign key column
  @NoCreate
  @NoModify
  @ReferenceView("Simple")
  private BotConfig ownerBot;  // A regular Java reference

  @OneToMany(mappedBy="ownerTrader")
  private List<ParameterConfig> parameters;

}
