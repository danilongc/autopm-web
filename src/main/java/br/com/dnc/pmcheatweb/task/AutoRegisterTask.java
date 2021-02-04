package br.com.dnc.pmcheatweb.task;

import br.com.dnc.pmcheatweb.service.RegisterService;
import br.com.dnc.pmcheatweb.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class AutoRegisterTask {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final RegisterService registerService;

    @Autowired
    public AutoRegisterTask(RegisterService registerService){

        this.registerService = registerService;
    }

    @Scheduled(zone = AppConstants.TIME_ZONE, cron = "${cron.punch.1}")
    public void firstIn(){
        log.info("Iniciando primeira entrada.");
        registerService.register();
    }

    @Scheduled(zone = AppConstants.TIME_ZONE, cron = "${cron.punch.2}")
    public void firstOut(){
        log.info("Iniciando primeira saída.");
        registerService.register();
    }

    @Scheduled(zone = AppConstants.TIME_ZONE, cron = "${cron.punch.3}")
    public void secondIn(){
        log.info("Iniciando segunda entrada.");
        registerService.register();
    }

    @Scheduled(zone = AppConstants.TIME_ZONE, cron = "${cron.punch.4}")
    public void secondOut(){
        log.info("Iniciando segunda saída.");
        registerService.register(true);
    }

}
