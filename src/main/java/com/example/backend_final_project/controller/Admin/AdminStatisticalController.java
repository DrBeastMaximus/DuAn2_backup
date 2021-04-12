package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.service.Impl.StatisticalSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Controller
@SessionAttributes({"username", "role"})
@RequestMapping("admin/statistical")
public class AdminStatisticalController {
    @Autowired
    private StatisticalSeviceImpl statisticalSeviceImpl;

    @GetMapping("totalbill")
    @ResponseBody
    public Object Totalbill(){
        Object object = statisticalSeviceImpl.getCountDHandDT();
        return object;
    }

    @GetMapping("countuser")
    @ResponseBody
    public Object CountUser(){
        Object object = statisticalSeviceImpl.getCountUser();
        return object;
    }

    @GetMapping("countusernewyear")
    @ResponseBody
    public Object CountUserNewYear(){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        Object object = statisticalSeviceImpl.getCountUserByyear(year);
        return object;
    }


    @GetMapping("quantityinvoicebyyear/{year}")
    @ResponseBody
    public Object quantitybillbyyear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getQuantityInvoiceByyear(year);
        return object;
    }

    @GetMapping("totalinvoicebyyear/{year}")
    @ResponseBody
    public Object totalbillbyyear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getTotalInvoiceByyear(year);
        return object;
    }
    @GetMapping("quantityuseryear/{year}")
    @ResponseBody
    public Object quantityuserbyyear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getQuantityUserByyear(year);
        return object;
    }

    @GetMapping("topproductbyyear/{year}")
    @ResponseBody
    public Object TopProductByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getTopProductbyyear(year);
        return object;
    }
    @GetMapping("topproductbymonthyear/{month-year}")
    @ResponseBody
    public Object TopProductByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getTopProductbymonthyear(month,year);
        return object;
    }

    @GetMapping("topwishlishbyyear/{year}")
    @ResponseBody
    public Object TopWishlishByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getTopWishlishbyyear(year);
        return object;
    }

    @GetMapping("topwishlishbymonthyear/{month-year}")
    @ResponseBody
    public Object TopWishlishByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getTopWishlishbymonthyear(month,year);
        return object;
    }

    @GetMapping("topuserbyyear/{year}")
    @ResponseBody
    public Object TopuserByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getTopUserbyyear(year);
        return object;
    }

    @GetMapping("topuserbymonthyear/{month-year}")
    @ResponseBody
    public Object TopuserByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getTopUserbymonthyear(month,year);
        return object;
    }

    @GetMapping("productbyyear/{year}")
    @ResponseBody
    public Object productByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getProductbyyear(year);
        return object;
    }
    @GetMapping("productbymonthyear/{month-year}")
    @ResponseBody
    public Object ProductByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getProductbymonthyear(month,year);
        return object;
    }

    @GetMapping("supplierbyyear/{year}")
    @ResponseBody
    public Object SupplierByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getSupplierbyyear(year);
        return object;
    }
    @GetMapping("supplierbymonthyear/{month-year}")
    @ResponseBody
    public Object SupplierByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getSupplierbymonthyear(month,year);
        return object;
    }

    @GetMapping("home")
    public String home(ModelMap model){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        model.addAttribute("year",year);
        model.addAttribute("year_top",year);
        return "main/tables/charts2";
    }
    @PostMapping("home")
    public String getyear(ModelMap model, @RequestParam("year_Total") int year,@RequestParam("yeartop") String yeartop){
        model.addAttribute("year",year);
        model.addAttribute("year_top",yeartop);
        return "main/tables/charts2";
    }

    @GetMapping("selecttop")
    public String select(ModelMap model){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        model.addAttribute("year",year);
        model.addAttribute("year_top",year);
        return "main/tables/charts2";
    }

    @PostMapping("selecttop")
    public String selecttop(ModelMap model,@RequestParam("yeartop") String yeartop,@RequestParam("year") int year){


        model.addAttribute("year",year);
        model.addAttribute("year_top",yeartop);
        return "main/tables/charts2";
    }

    @GetMapping("detail")
    public String selectProductAndSupplier(ModelMap model){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();

        model.addAttribute("year_top",year);
        return "main/tables/thongke";
    }
    @PostMapping("detail")
    public String selectProductAndSupplierByDate(ModelMap model,@RequestParam("yeartop") String yeartop){
        model.addAttribute("year_top",yeartop);
        return "main/tables/thongke";
    }
}
