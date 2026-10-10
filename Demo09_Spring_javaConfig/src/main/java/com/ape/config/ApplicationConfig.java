package com.ape.config;

import com.ape.controller.IUserController;
import com.ape.controller.UserControllerImp;
import com.ape.dao.IUserDao;
import com.ape.dao.UserDaoImp;
import com.ape.service.IUserService;
import com.ape.service.UserServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public IUserController controller(IUserService service){
        return new UserControllerImp(service);
    }
    @Bean
    public IUserService service(IUserDao dao){
        return new UserServiceImp(dao);
    }
    @Bean
    public IUserDao dao(){
        return new UserDaoImp();
    }

}
