package common.controller;


import common.model.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

//Class that make interaction between user and application by 'request' and 'response'
//and realize interaction between model and view
@Controller
public class ReportController {
    //note constructor requires autocomplete Spring dependency injection
    @Autowired
    private ReportRepository reportRepository;

    //First page controller
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getReportForm() {
        //define needed Format of date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, Y", Locale.ENGLISH);
        //get Today date
        LocalDate today = LocalDate.now();
        //get LastYear startDate value
        LocalDate LastYearStartDate = LocalDate.of(today.minusYears(1).getYear(), 1, 1);
        //get LastYear endDate value
        LocalDate LastYearEndDate = LocalDate.of(today.minusYears(2).getYear(), 12, 31);
        //get currentYearToDate startDate value
        LocalDate currentYearToDate = today.minusYears(1);
        //get currentMonthToDate startDate value
        LocalDate currentMonthToDate = today.minusMonths(1);
        //get currentQerToDate startDate value through currentQtrToDate method
        LocalDate currentQerToDate = currentQtrToDate(today);
        //get LastQtrStartDate value through LastQtrStartDate method
        LocalDate LastQtrStartDate = LastQtrStartDate(today);
        //get lastQtrEndDate value through LastQtrEndDate method
        LocalDate LastQtrEndDate = LastQtrEndDate(today);
        //get LastMonthStartDate value through LastMonthStartDate method
        LocalDate LastMonthStartDate = LastMonthStartDate(today);
        //get LastMonthEndDate value through LastMonthEndDate method
        LocalDate LastMonthEndDate = LastMonthEndDate(today);

        //return values for script 'Time period' on page "page"
        ModelAndView model = new ModelAndView("page");
        model.addObject("endDateCurrentQuery", dateTimeFormatter.format(today));
        model.addObject("currentYearToDate", dateTimeFormatter.format(currentYearToDate));
        model.addObject("currentMonthToDate", dateTimeFormatter.format(currentMonthToDate));
        model.addObject("currentQerToDate", dateTimeFormatter.format(currentQerToDate));
        model.addObject("LastQtrStartDate", dateTimeFormatter.format(LastQtrStartDate));
        model.addObject("LastQtrEndDate", dateTimeFormatter.format(LastQtrEndDate));
        model.addObject("LastMonthStartDate", dateTimeFormatter.format(LastMonthStartDate));
        model.addObject("LastMonthEndDate", dateTimeFormatter.format(LastMonthEndDate));
        model.addObject("LastYearStartDate", dateTimeFormatter.format(LastYearStartDate));
        model.addObject("LastYearEndDate", dateTimeFormatter.format(LastYearEndDate));

        return model;
    }

    //Second page controller
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ModelAndView submitQueryForm(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate
            , @RequestParam("performer") String allPerformers) throws ParseException {
        //define needed Format of date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, Y", Locale.ENGLISH);
        //get Today date
        LocalDate today = LocalDate.now();
        //get LastYear startDate value
        LocalDate LastYearStartDate = LocalDate.of(today.minusYears(1).getYear(), 1, 1);
        //get LastYear endDate value
        LocalDate LastYearEndDate = LocalDate.of(today.minusYears(2).getYear(), 12, 31);
        //get currentYearToDate startDate value
        LocalDate currentYearToDate = today.minusYears(1);
        //get currentMonthToDate startDate value
        LocalDate currentMonthToDate = today.minusMonths(1);
        //get currentQerToDate startDate value through currentQtrToDate method
        LocalDate currentQerToDate = currentQtrToDate(today);
        //get LastQtrStartDate value through LastQtrStartDate method
        LocalDate LastQtrStartDate = LastQtrStartDate(today);
        //get lastQtrEndDate value through LastQtrEndDate method
        LocalDate LastQtrEndDate = LastQtrEndDate(today);
        //get LastMonthStartDate value through LastMonthStartDate method
        LocalDate LastMonthStartDate = LastMonthStartDate(today);
        //get LastMonthEndDate value through LastMonthEndDate method
        LocalDate LastMonthEndDate = LastMonthEndDate(today);

        //on condition of that
        if ((allPerformers.equals("All Performers")) || ((endDate.equals("")) && (startDate.equals("")))) {

            //return values for script 'Time period' on page "reports"
            ModelAndView model = new ModelAndView("reports");
            model.addObject("endDateCurrentQuery1", dateTimeFormatter.format(today));
            model.addObject("currentYearToDate1", dateTimeFormatter.format(currentYearToDate));
            model.addObject("currentMonthToDate1", dateTimeFormatter.format(currentMonthToDate));
            model.addObject("currentQerToDate1", dateTimeFormatter.format(currentQerToDate));
            model.addObject("LastQtrStartDate1", dateTimeFormatter.format(LastQtrStartDate));
            model.addObject("LastQtrEndDate1", dateTimeFormatter.format(LastQtrEndDate));
            model.addObject("LastMonthStartDate1", dateTimeFormatter.format(LastMonthStartDate));
            model.addObject("LastMonthEndDate1", dateTimeFormatter.format(LastMonthEndDate));
            model.addObject("LastYearStartDate1", dateTimeFormatter.format(LastYearStartDate));
            model.addObject("LastYearEndDate1", dateTimeFormatter.format(LastYearEndDate));

            //output all values from database
            model.addObject("Reports", reportRepository.findAll());

            return model;
        } else {
            Date startDateValue = null;
            Date endDateValue = null;
            try {
                //transform text values into date values
                startDateValue = convertionStringToDate(startDate);
                endDateValue = convertionStringToDate(endDate);

                //return values for script 'Time period' on page "reports"
                ModelAndView model = new ModelAndView("reports");
                model.addObject("endDateCurrentQuery1", dateTimeFormatter.format(today));
                model.addObject("currentYearToDate1", dateTimeFormatter.format(currentYearToDate));
                model.addObject("currentMonthToDate1", dateTimeFormatter.format(currentMonthToDate));
                model.addObject("currentQerToDate1", dateTimeFormatter.format(currentQerToDate));
                model.addObject("LastQtrStartDate1", dateTimeFormatter.format(LastQtrStartDate));
                model.addObject("LastQtrEndDate1", dateTimeFormatter.format(LastQtrEndDate));
                model.addObject("LastMonthStartDate1", dateTimeFormatter.format(LastMonthStartDate));
                model.addObject("LastMonthEndDate1", dateTimeFormatter.format(LastMonthEndDate));
                model.addObject("LastYearStartDate1", dateTimeFormatter.format(LastYearStartDate));
                model.addObject("LastYearEndDate1", dateTimeFormatter.format(LastYearEndDate));

                //output values from database which suitable to request
                model.addObject("Reports", reportRepository.findBetweenSdateAndEdate(startDateValue, endDateValue));

                return model;

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //return values for script 'Time period' on page "reports"
        ModelAndView model = new ModelAndView("reports");
        model.addObject("endDateCurrentQuery1", dateTimeFormatter.format(today));
        model.addObject("currentYearToDate1", dateTimeFormatter.format(currentYearToDate));
        model.addObject("currentMonthToDate1", dateTimeFormatter.format(currentMonthToDate));
        model.addObject("currentQerToDate1", dateTimeFormatter.format(currentQerToDate));
        model.addObject("LastQtrStartDate1", dateTimeFormatter.format(LastQtrStartDate));
        model.addObject("LastQtrEndDate1", dateTimeFormatter.format(LastQtrEndDate));
        model.addObject("LastMonthStartDate1", dateTimeFormatter.format(LastMonthStartDate));
        model.addObject("LastMonthEndDate1", dateTimeFormatter.format(LastMonthEndDate));
        model.addObject("LastYearStartDate1", dateTimeFormatter.format(LastYearStartDate));
        model.addObject("LastYearEndDate1", dateTimeFormatter.format(LastYearEndDate));

        //Incorrectly filled date report
        model.addObject("IncorFillDate", true);

        return model;
    }

    //Method that translates text into date
    public Date convertionStringToDate(String dateStr) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        java.util.Date date = formatter.parse(dateStr);
        Date sqlDate1 = new Date(date.getTime());

        return sqlDate1;

    }

    //Method that get current qtr to date
    public LocalDate currentQtrToDate(LocalDate today) {

        if ((today.getMonth().getValue() == 1) || (today.getMonth().getValue() == 2) || (today.getMonth().getValue() == 3)) {
            LocalDate currentQtrToDate = LocalDate.of(today.getYear(), 1, 1);
            return currentQtrToDate;
        } else if ((today.getMonth().getValue() == 4) || (today.getMonth().getValue() == 5) || (today.getMonth().getValue() == 6)) {
            LocalDate currentQtrToDate = LocalDate.of(today.getYear(), 4, 1);
            return currentQtrToDate;
        } else if ((today.getMonth().getValue() == 7) || (today.getMonth().getValue() == 8) || (today.getMonth().getValue() == 9)) {
            LocalDate currentQtrToDate = LocalDate.of(today.getYear(), 7, 1);
            return currentQtrToDate;
        } else if ((today.getMonth().getValue() == 10) || (today.getMonth().getValue() == 11) || (today.getMonth().getValue() == 12)) {
            LocalDate currentQtrToDate = LocalDate.of(today.getYear(), 10, 1);
            return currentQtrToDate;
        }
        return today;
    }

    //Method that get last qtr to date
    public LocalDate LastQtrStartDate(LocalDate today) {

        if ((today.getMonth().getValue() == 1) || (today.getMonth().getValue() == 2) || (today.getMonth().getValue() == 3)) {
            LocalDate LastQtr = LocalDate.of(today.minusYears(1).getYear(), 10, 1);
            return LastQtr;
        } else if ((today.getMonth().getValue() == 4) || (today.getMonth().getValue() == 5) || (today.getMonth().getValue() == 6)) {
            LocalDate LastQtr = LocalDate.of(today.getYear(), 1, 1);
            return LastQtr;

        } else if ((today.getMonth().getValue() == 7) || (today.getMonth().getValue() == 8) || (today.getMonth().getValue() == 9)) {
            LocalDate LastQtr = LocalDate.of(today.getYear(), 4, 1);
            return LastQtr;

        } else if ((today.getMonth().getValue() == 10) || (today.getMonth().getValue() == 11) || (today.getMonth().getValue() == 12)) {
            LocalDate LastQtr = LocalDate.of(today.getYear(), 7, 1);
            return LastQtr;
        }
        return today;
    }

    //Method that get last qtr rnd date
    public LocalDate LastQtrEndDate(LocalDate today) {

        if ((today.getMonth().getValue() == 1) || (today.getMonth().getValue() == 2) || (today.getMonth().getValue() == 3)) {

            LocalDate LastQtrStart = LocalDate.of(today.minusYears(2).getYear(), 12, today.lengthOfMonth());
            return LastQtrStart;

        } else if ((today.getMonth().getValue() == 4) || (today.getMonth().getValue() == 5) || (today.getMonth().getValue() == 6)) {

            LocalDate LastQtrStart = LocalDate.of(today.getYear(), 3, today.lengthOfMonth());
            return LastQtrStart;

        } else if ((today.getMonth().getValue() == 7) || (today.getMonth().getValue() == 8) || (today.getMonth().getValue() == 9)) {

            LocalDate LastQtrStart = LocalDate.of(today.getYear(), 6, today.lengthOfMonth());
            return LastQtrStart;

        } else if ((today.getMonth().getValue() == 10) || (today.getMonth().getValue() == 11) || (today.getMonth().getValue() == 12)) {

            LocalDate LastQtrStart = LocalDate.of(today.getYear(), 9, today.lengthOfMonth());
            return LastQtrStart;
        }
        return today;
    }

    //Method that get last month start date
    public LocalDate LastMonthStartDate(LocalDate today) {

        if ((today.getMonth().getValue() == 1)) {
            LocalDate lastMonth = LocalDate.of(today.minusYears(1).getYear(), 12, 1);
            return lastMonth;
        } else {
            LocalDate lastMonth = LocalDate.of(today.getYear(), today.minusMonths(1).getMonth(), 1);
            return lastMonth;
        }
    }

    //Method that get last month end date
    public LocalDate LastMonthEndDate(LocalDate today) {

        if ((today.getMonth().getValue() == 1)) {
            LocalDate lastMonthEnd = LocalDate.of(today.minusYears(2).getYear(), 12, 31);
            return lastMonthEnd;
        } else {
            LocalDate lastMonthEnd = LocalDate.of(today.getYear(), today.minusMonths(1).getMonth(), today.lengthOfMonth());
            return lastMonthEnd;
        }
    }

}






