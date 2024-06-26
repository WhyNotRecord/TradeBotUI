package ru.rexchange.tradebotui.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@Table(name="MODEL_CONFIG")
public class ModelConfig {
//		{"name": "Bitcoin", "type": "binance", "baseCurrency": "BTC", "quotedCurrency": "USDT", "length": "100"},
	@Id
	@Column()//length=16
	@Hidden
	long id;

	@Column(length=32)
	@Required
	String name;

	@Column(length=16)
	@Required
	String type;

	@Column(name="base_cur", length=8)
	@Required
	String baseCurrency;

	@Column(name="quot_cur", length=8)
	@Required
	String quotCurrency;

	@Column()
	@Required
	int capacity = 200;
}
