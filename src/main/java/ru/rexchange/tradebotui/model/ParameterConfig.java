package ru.rexchange.tradebotui.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="PARAMETER_CONFIG")
public class ParameterConfig {
  @Id
  @Column()
  @SequenceGenerator(name = "gen", sequenceName = "seq_param_id", allocationSize = 10)
  @Hidden
  long id;

  @Column(name="param_name", length=64)
  @Required
  String name;

  @Column(name="param_value",length=128)
  @Required
  String value;

  //TODO при создании из форм трейдера и бота поле должно заполняться автоматически
  @Column(name="owner_id")
  @Hidden
  long ownerId;

  //TODO скрыть с формы параметров ссылки на бота и трейдера
  @ManyToOne(fetch=FetchType.EAGER,  // The reference is loaded on demand
      optional=true)  // The reference can be null
  @JoinColumn(name="owner_id", insertable = false, updatable = false)  // owner_id is the foreign key column
  @NoCreate
  @NoModify
  @ReferenceView("Simple")
  private BotConfig ownerBot;  // A regular Java reference

  @ManyToOne(fetch=FetchType.EAGER,  // The reference is loaded on demand
      optional=true)  // The reference can be null
  @JoinColumn(name="owner_id", insertable = false, updatable = false)  // owner_id is the foreign key column
  @NoCreate
  @NoModify
  @ReferenceView("Simple")
  private TraderConfig ownerTrader;  // A regular Java reference

}
