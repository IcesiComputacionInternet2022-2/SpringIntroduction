package com.icesi.demo.dto;

//import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class AnagramResponseDTO {
	private boolean result;
	
	public AnagramResponseDTO(boolean result) {
		this.result = result;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	
	
}
