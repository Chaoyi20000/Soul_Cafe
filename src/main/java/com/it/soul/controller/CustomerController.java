package com.it.soul.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.soul.common.R;
import com.it.soul.model.Customer;
import com.it.soul.service.CustomerService;
import com.it.soul.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public R<Customer> login(HttpServletRequest request, @RequestBody Customer customer){

        String password = customer.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Customer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Customer::getUsername,customer.getUsername());
        Customer c = customerService.getOne(queryWrapper);

        if(c == null){
            return R.error("Incorrect username or password");
        }
        if(!c.getPassword().equals(password)){
            return R.error("Incorrect username or password");
        }
        request.getSession().setAttribute("customer", c.getId());
        String token = TokenUtils.generateToken(c);
        c.setToken(token);
        return R.success(c);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request, @RequestParam String token){
        request.getSession().removeAttribute("customer");
        TokenUtils.remove(token);
        return R.success("logout successfully");
    }

    @GetMapping("/check")
    public R<String> checkLoggedIn(@RequestParam String token){
        if(!TokenUtils.verify(token)){
            return R.error("NOT LOGIN");
        }
        return R.success("");
    }

    @PostMapping("/register")
    public R<String> register(@RequestBody Customer customer){
        customer.setPassword( DigestUtils.md5DigestAsHex(customer.getPassword().getBytes()));
        customerService.save(customer);
        return R.success("register success");
    }





}
