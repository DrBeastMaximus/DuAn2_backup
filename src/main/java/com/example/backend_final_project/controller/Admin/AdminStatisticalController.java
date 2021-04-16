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

    //api thông kê số lượng hóa đơn và tổng tiền của hóa đơn đã bán thành công
    @GetMapping("totalbill")
    @ResponseBody
    public Object Totalbill(){
        Object object = statisticalSeviceImpl.getCountDHandDT();
        return object;
    }
//api thống kê tổng số lượng user có trang db với trạng thái chưa xóa
    @GetMapping("countuser")
    @ResponseBody
    public Object CountUser(){
        Object object = statisticalSeviceImpl.getCountUser();
        return object;
    }
//api thống kê tổng số lượng user đã đăng kí vào năm hiện tại với trạng thái chưa xóa
    @GetMapping("countusernewyear")
    @ResponseBody
    public Object CountUserNewYear(){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        Object object = statisticalSeviceImpl.getCountUserByyear(year);
        return object;
    }

//api thống kê số lượng sản phẩm của các tháng đã bán thành công theo năm
    @GetMapping("quantityinvoicebyyear/{year}")
    @ResponseBody
    public Object quantitybillbyyear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getQuantityInvoiceByyear(year);
        return object;
    }
//api thống kê tổng tiền thu được của từng tháng  theo năm
    @GetMapping("totalinvoicebyyear/{year}")
    @ResponseBody
    public Object totalbillbyyear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getTotalInvoiceByyear(year);
        return object;
    }

    //api thống kê tông user đã đăng kí của từng tháng theo năm
    @GetMapping("quantityuseryear/{year}")
    @ResponseBody
    public Object quantityuserbyyear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getQuantityUserByyear(year);
        return object;
    }

    //api thống kê top 10 sản phẩm bán chạy nhất theo năm
    @GetMapping("topproductbyyear/{year}")
    @ResponseBody
    public Object TopProductByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getTopProductbyyear(year);
        return object;
    }

    //api thống kê top 10 sản phẩm bán chạy nhất theo tháng
    @GetMapping("topproductbymonthyear/{month-year}")
    @ResponseBody
    public Object TopProductByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getTopProductbymonthyear(month,year);
        return object;
    }

    //api thống kê top 10 sản phẩm được yêu thích nhất theo năm
    @GetMapping("topwishlishbyyear/{year}")
    @ResponseBody
    public Object TopWishlishByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getTopWishlishbyyear(year);
        return object;
    }

    //api thông kê top 10 sản phẩm được yêu thích nhất theo tháng
    @GetMapping("topwishlishbymonthyear/{month-year}")
    @ResponseBody
    public Object TopWishlishByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getTopWishlishbymonthyear(month,year);
        return object;
    }

    //api thống kê top 10 khách hàng mua sắm nhiều nhất theo năm
    @GetMapping("topuserbyyear/{year}")
    @ResponseBody
    public Object TopuserByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getTopUserbyyear(year);
        return object;
    }

    //api thống kê top 10 khách hàng mua sắm nhiều nhất theo tháng
    @GetMapping("topuserbymonthyear/{month-year}")
    @ResponseBody
    public Object TopuserByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getTopUserbymonthyear(month,year);
        return object;
    }

    //api thống kê danh thu từng sản phẩm theo năm
    @GetMapping("productbyyear/{year}")
    @ResponseBody
    public Object productByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getProductbyyear(year);
        return object;
    }
    //api thống kê danh thu từng sản phẩm theo tháng
    @GetMapping("productbymonthyear/{month-year}")
    @ResponseBody
    public Object ProductByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getProductbymonthyear(month,year);
        return object;
    }

    //api thống kê danh thu từng nhà cung cấp theo năm
    @GetMapping("supplierbyyear/{year}")
    @ResponseBody
    public Object SupplierByYear(@PathVariable("year") int year){
        Object object = statisticalSeviceImpl.getSupplierbyyear(year);
        return object;
    }
    //api thống kê danh thu từng nhà cung cấp theo tháng
    @GetMapping("supplierbymonthyear/{month-year}")
    @ResponseBody
    public Object SupplierByMonthYear(@PathVariable("month-year") String MonthYear){
        String[] parts = MonthYear.split("-");
        int month = Integer.parseInt(parts[0]);
        int  year = Integer.parseInt(parts[1]);
        Object object = statisticalSeviceImpl.getSupplierbymonthyear(month,year);
        return object;
    }

    //trả về trang thống kê tổng
    @GetMapping("home")
    public String home(ModelMap model){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        model.addAttribute("year",year);
        model.addAttribute("year_top",year);
        return "main/tables/charts2";
    }

    //tìm kiếm user,hóa đơn, tổng tiền của từng tháng theo năm
    @PostMapping("home")
    public String getyear(ModelMap model, @RequestParam("year_Total") int year,@RequestParam("yeartop") String yeartop){
        model.addAttribute("year",year);
        model.addAttribute("year_top",yeartop);
        return "main/tables/charts2";
    }

    //trả về trang thống kê tổng
    @GetMapping("selecttop")
    public String select(ModelMap model){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        model.addAttribute("year",year);
        model.addAttribute("year_top",year);
        return "main/tables/charts2";
    }

    // tìm kiếm top sản phẩm bán chạy, sản phẩm yêu thích, khách hàng mua sắm nhiều nhất
    @PostMapping("selecttop")
    public String selecttop(ModelMap model,@RequestParam("yeartop") String yeartop,@RequestParam("year") int year){


        model.addAttribute("year",year);
        model.addAttribute("year_top",yeartop);
        return "main/tables/charts2";
    }

    // trả về trang thống kê sản phẩm và nhà cung cấp
    @GetMapping("detail")
    public String selectProductAndSupplier(ModelMap model){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();

        model.addAttribute("year_top",year);
        return "main/tables/thongke";
    }

    //tìm kiếm danh thu từng sản phẩm và nhà cung cấp
    @PostMapping("detail")
    public String selectProductAndSupplierByDate(ModelMap model,@RequestParam("yeartop") String yeartop){
        model.addAttribute("year_top",yeartop);
        return "main/tables/thongke";
    }
}
