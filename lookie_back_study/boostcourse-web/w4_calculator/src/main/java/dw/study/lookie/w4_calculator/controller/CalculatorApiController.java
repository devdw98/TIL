package dw.study.lookie.w4_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dw.study.lookie.w4_calculator.dto.CalculatorResult;
import dw.study.lookie.w4_calculator.service.CalculatorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/api/calculator")
public class CalculatorApiController {

	@Autowired
	private CalculatorService cs;
	
	@ApiOperation(value="µ°º¿ ±∏«œ±‚")
	@ApiResponses({ //Response Message ø° ¥Î«— Swagger º≥∏Ì
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=500, message="Exception")
	})
	
	@GetMapping("/plus")
	public CalculatorResult plus(@RequestParam("value1")int value1, @RequestParam("value2")int value2) {
		CalculatorResult cr = new CalculatorResult();
		cr.setValue1(value1);
		cr.setValue2(value2);
		cr.setOperation(CalculatorResult.PLUS_OPERATION);
		cr.setResult(cs.plus(value1, value2));
		return cr;
	}
	
	@ApiOperation(value="ª¨º¿ ±∏«œ±‚")
	@ApiResponses({ //Response Message ø° ¥Î«— Swagger º≥∏Ì
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=500, message="Exception")
	})
	
	@GetMapping("/minus")
	public CalculatorResult minus(@RequestParam("value1")int value1, @RequestParam("value2")int value2) {
		CalculatorResult cr = new CalculatorResult();
		cr.setValue1(value1);
		cr.setValue2(value2);
		cr.setOperation(CalculatorResult.MINUS_OPERATION);
		cr.setResult(cs.minus(value1, value2));
		return cr;
	}
	
	
}
