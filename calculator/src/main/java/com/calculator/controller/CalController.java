package com.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.response.CalResponse;
import com.calculator.response.MinMaxRequest;
import com.calculator.response.MinMaxResponse;

@RestController
@RequestMapping("/calculatorapi/v1")
public class CalController {
	
	@GetMapping(path = "/addition")
	public CalResponse addition(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Double add = num1 + num2;
		String message=(num1.toString()) + " + " + (num2.toString()) + " = " + (add.toString());
		CalResponse response = setResponse(add, message);
		return response;
	}

	@GetMapping(path = "/subtraction")
	public CalResponse subtraction(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Double subtract = num1 - num2;
		String message=(num1.toString()) + " - " + (num2.toString()) + " = " + (subtract.toString());
		CalResponse response = setResponse(subtract, message);
		return response;
	}
	
	@GetMapping(path = "/multiplication")
	public CalResponse multiplication(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Double multiplication = num1 * num2;
		String message=(num1.toString()) + " * " + (num2.toString()) + " = " + (multiplication.toString());
		CalResponse response = setResponse(multiplication, message);
		return response;
	}

	@GetMapping(path = "/division")
	public CalResponse division(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		
			Double division = num1 / num2;
			String message=(num1.toString()) + " / " + (num2.toString()) + " = " + (division.toString());
			CalResponse response = setResponse(division, message);
			return response;
	}
	
	@GetMapping(path = "/square/{number}")
	public CalResponse getSquare(@PathVariable Double number) {
		Double square = number * number;
		String message=("square of " + number + " = " + (square.toString()));
		CalResponse response = setResponse(square, message);
		return response;
		
	}
	
	@GetMapping(path = "/factorial/{num}")
	public CalResponse getFactorial(@PathVariable Double num) {
		Double result = getFac(num);
		String message=(num.toString()) + "!" + " = " + (result.toString());
		CalResponse response = setResponse(result, message);
		return response;
		}

	private Double getFac(Double num) {
		if (num == 1 || num == 0)
			return (double) 1;
		else
			return (num * getFac(num - 1));
	}
	
	
	@PostMapping("/min-max")
	public MinMaxResponse getMinMax(@RequestBody MinMaxRequest minMaxRequest) {
		int max = minMaxRequest.getNumbers().stream().max(Integer::compare).get();
		int min = minMaxRequest.getNumbers().stream().min(Integer::compare).get();
		MinMaxResponse minMaxResponse=new MinMaxResponse();
		minMaxResponse.setMax(max);
		minMaxResponse.setMin(min);
		return minMaxResponse;
	}
	
	private CalResponse setResponse(Double add, String message) {
		CalResponse response=new CalResponse();
		response.setAnswer(add);
		response.setDetail(message);
		return response;
	}

	
	
	

}
