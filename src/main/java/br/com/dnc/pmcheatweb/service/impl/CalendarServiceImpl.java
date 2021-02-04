package br.com.dnc.pmcheatweb.service.impl;

import br.com.dnc.pmcheatweb.dto.calendar.CalendarResponse;
import br.com.dnc.pmcheatweb.service.CalendarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class CalendarServiceImpl implements CalendarService {

    private static final Logger log = LoggerFactory.getLogger(CalendarServiceImpl.class);

    public static final String YEAR = "year";
    public static final String IBGE = "ibge";

    @Value("${calendar.api.url}")
    public String url;

    private List<String> weekDays = Arrays.asList("MON", "TUE", "WED", "THU", "FRI");

    private SimpleDateFormat dfWeekDay = new SimpleDateFormat("E", Locale.US);
    private SimpleDateFormat yearDf = new SimpleDateFormat("yyyy");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public Boolean isFreeDay(String ibgeCityCode) {

        String weekDay = dfWeekDay.format(new Date()).toUpperCase();

        if(!weekDays.contains(weekDay)){
            return true;
        }

        if(StringUtils.isEmpty(ibgeCityCode)){
            return false;
        }

        String year = yearDf.format(new Date());

        HttpResponse<String> response = Unirest
            .get(url)
            .routeParam(YEAR, year)
            .routeParam(IBGE, ibgeCityCode)
            .asString();

        if(!response.isSuccess()){
            log.error("API de calendário retornou erro - {}", response.getBody());
            return false;
        }

        try {

            String strToday = dateFormat.format(new Date());

            log.info("strToday - {}", strToday);

            String xlmResponseFixed = response.getBody()
                .replaceFirst("<event>", "<listEvents><event>")
                .replace("</event>\n</events>", "</event></listEvents></events>");

            XmlMapper mapper = new XmlMapper();
            CalendarResponse calendarResponse = mapper
                .readValue(xlmResponseFixed, CalendarResponse.class);

            return calendarResponse.getListEvents()
                .stream()
                .anyMatch(p -> p.getDate().equals(strToday) && (p.getType_code().equals("1") || p.getType_code().equals("4") || p.getType_code().equals("3")));


        } catch (JsonProcessingException e) {
            log.error("Falha ao converter a resposta da API de Calendário - {}", e);
            return false;
        }

    }


}
