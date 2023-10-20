package com.sprint3_activity.crm.request;

import com.sprint3_activity.crm.entity.Loja;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class LojaRequest {

	@NotNull
	@NotEmpty(message = "LojaName shouldn't be null!")
	private String name;
	@NotNull
	@NotEmpty(message = "LojaCidade shouldn't be null!")
	private String cidade;
	@NotNull
	@NotEmpty(message = "LojaPais shouldn't be null!")
	private String país;
}
