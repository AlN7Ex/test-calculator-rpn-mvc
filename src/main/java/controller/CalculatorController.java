package controller;

import domain.rpn.ReversePolishNotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController {

    private ReversePolishNotation algorithm;
    @Autowired
    CalculatorController(ReversePolishNotation algorithm) {
        this.algorithm = algorithm;
    }
    @GetMapping("/calculate")
    public String hello() {
        return "calculate";
    }

    @PostMapping("/calculate")
    public String calculate(HttpServletRequest request, Model model) {
        String expression = request.getParameter("expression");
        String calculated = ReversePolishNotation.calculate(expression);

        model.addAttribute("result", calculated);

        return "calculated";
    }
}
