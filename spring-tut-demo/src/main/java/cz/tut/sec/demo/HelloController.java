package cz.tut.sec.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@Log4j2
public class HelloController {
    @GetMapping("/hello")
    public String hello(Authentication authentication){
        return "Hello: "+authentication.getName();
    }

    @GetMapping("/bye")
    public String byeBye(Authentication authentication){
        log.info("ThreadLocal: "+Thread.currentThread().getName());
        return "bey bey: "+authentication.getName();
    }

    @GetMapping("/ciao")
    public String ciao(){
        Callable<String> task = () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            return context.getAuthentication().getName();
        };
        String message = "";
        ExecutorService e = Executors.newCachedThreadPool();
        try {
            message = "Ciao, " + e.submit(task).get() + "!";
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (ExecutionException executionException) {
            executionException.printStackTrace();
        } finally {
            e.shutdown();
        }
        return message;
    }

    @GetMapping("/hola")
    public String hole(){
        Callable<String> task = () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            return context.getAuthentication().getName();
        };
        String message = null;
        ExecutorService ex = Executors.newCachedThreadPool();
        ex = new DelegatingSecurityContextExecutorService(ex);

        try {
           message = ex.submit(task).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            ex.shutdown();
        }

        return "Hola "+message+" !";
    }
}
