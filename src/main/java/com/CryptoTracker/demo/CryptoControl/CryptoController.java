package com.CryptoTracker.demo.CryptoControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.CryptoTracker.demo.models.CryptoCoin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class CryptoController {

    @Autowired
    private com.CryptoTracker.demo.CryptoService.CryptoService cryptoService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/track")
    public String track(@RequestParam ("Coins") String coins , Model model){
        List<String> coinList = Arrays.asList(coins.split(","));
        List<CryptoCoin> result = cryptoService.getCryptoprices(coinList);
        model.addAttribute("coins",result);
        return "result";
    }

}
