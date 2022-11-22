package com.nursery.front_end.fcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	
	@RequestMapping("/payment")
	@CrossOrigin(origins = "*", maxAge=3600)
	public String payment(Model model)
	{
		model.addAttribute("title", "Payment - Omega-Pproject");
		return "payment";
	}
}
