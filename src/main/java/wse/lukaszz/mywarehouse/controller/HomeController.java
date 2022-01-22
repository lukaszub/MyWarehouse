package wse.lukaszz.mywarehouse.controller;

import wse.lukaszz.mywarehouse.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Controller
public class HomeController {

    private static final List<Product> PRODUCTS = new ArrayList(List.of(
        new Product("Dwudrzwiowa witryna do salonu Mosaic 15 dąb miodowy meblobranie", "36576", 2, 4220.00f, "Witryna o wymiarach (szer x gł x wys) 107x42x143 cm."),
        new Product("Zestaw mebli ogrodowych na balkon Corfu Weekend Curver Brązowy", "13580", 7, 899.00f, "w skład zestawu balkonowego wchodzą: dwa fotele oraz stolik kawowy meblobranie."),
        new Product("Jasnoszara welurowa sofa 250cm rozkładana na nóżkach Megis Monolith 84", "38990", 12, 2666.00f, "wymiary złożonej sofy (szer/gł/wys) 250x95x90 cm meblobranie")
    ));

    public static void updateProductQuantity (String productNumber, String action) {
        PRODUCTS.stream()
                .filter(it -> it.getProductNumber().equals(productNumber))
                .forEach(it -> {
                    if (action.equals("increase")) {
                        Integer updatedQuantity = it.getQuantity()+1;
                        it.setQuantity(updatedQuantity);
                    } else if(action.equals("decrease")){
                        Integer updatedQuantity = it.getQuantity()-1;
                        if(updatedQuantity < 0) {
                            it.setQuantity(0);
                        } else {
                            it.setQuantity(updatedQuantity);
                        }
                    }
        });
    }

    public static Optional<Product> getProduct (String productNumber) {
        return PRODUCTS.stream()
                .filter(it -> it.getProductNumber().equals(productNumber))
                .findAny();
    }

    @RequestMapping(path = "/updateQuantity/{productNumber}/{action}", method = RequestMethod.POST)
    public String updateQuantity(@PathVariable("productNumber") String productNumber, @PathVariable("action") String action, Model model) {
        updateProductQuantity(productNumber, action);
        model.addAttribute("products", PRODUCTS);
        model.addAttribute("updateQuantity", new String());
        model.addAttribute("newProduct", new Product());
        return "index";
    }

    @RequestMapping(path = "/")
    public String showProducts(Model model) {
        model.addAttribute("products", PRODUCTS);
        model.addAttribute("updateQuantity", new String());
        model.addAttribute("newProduct", new Product());
        return "index";
    }

    @RequestMapping(value = "/product/{productNumber}", method = RequestMethod.GET)
    public String showProductDetails(@PathVariable("productNumber") String productNumber, Model model) {
        Product product = getProduct(productNumber).orElseThrow();
        model.addAttribute("product", product);
        return "product";
    }

}
