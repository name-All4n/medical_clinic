package br.com.med.voll.api.consultation.validation;

import br.com.med.voll.api.consultation.DataScheduleConsultation;
import br.com.med.voll.api.infra.exeption.ValidationExeption;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ClinicOperationHours implements ValidationScheduleConsultation {

    @Override
    public void validation(DataScheduleConsultation data){
        var dataConsultation = data.date();
        var sunDay = dataConsultation.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeTheClinicOpened = dataConsultation.getHour() < 7;
        var afterTheClinicCloses = dataConsultation.getHour() >= 18;
        if (sunDay || beforeTheClinicOpened || afterTheClinicCloses) {
            throw new ValidationExeption("consultation outside of the clinic operation hours");
        }
    }
}
