package ru.rexchange.tradebotui.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Views({
    @View(name="Simple", members="name, type;"),
    })
@Getter @Setter
@Table(name="BOT_CONFIG")
public class BotConfig {
//    {"name": "B-WAVES-ML-1H", "type": "3", "runPeriod": "3600", "active": "true",
//    "traders": ["T-Waves-ML-1h-kuk"],
//    "strategies": ["waves_ml_1h_ext"],
//    "filters": [],
//    "stopStrategies": ["stop.ema"],
//    "model": "Waves-1h-ml", "tradeDirection": "0", "riskLevel": "2",
//    "params": [{"name": "closeBySignals", "value": "LOW_LOSS"}]
  @Id
  @Hidden
  @Column()//length=16
  long id;

  @Column(length=32)
  @Required
  String name;

  @Editor("ValidValuesCombo")
  @Column()
  @Required
  @Enumerated(EnumType.ORDINAL)
  BotType type;//http://www.gabiaxel.com/2011/01/better-enum-mapping-with-hibernate.html
  enum BotType {NullBot, RegisteringBot, SecondBot, ThirdBot}

  @Column(name="run_period")
  long runPeriod = 3600;

  @Column(name="active")
  @Required
  boolean active;

  @OneToMany(mappedBy="ownerBot")
  private List<TraderConfig> traders;  // A regular Java collection (3)

  @OneToMany(mappedBy="ownerBot")
  private List<ParameterConfig> parameters;
}
