package org.renaux;

import org.renaux.finance.Wallet;
import org.renaux.model.human.externals.Customer;
import org.renaux.model.human.staff.Staff;
import org.renaux.service.*;
import org.renaux.util.RequestUtil;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Creating the admin
        AdminService adminService = new AdminService();
        Staff admin = adminService.createAdmin(RequestUtil.AdminRequest());
        Wallet wallet = adminService.createStoreWallet();

        //Creating Applicants

        ApplicantService applicantService = new ApplicantService();
        applicantService.createApplicant(RequestUtil.cashierApplicantRequest());
        applicantService.createApplicant(RequestUtil.cashierApplicantRequest2());
        applicantService.createApplicant(RequestUtil.cashierApplicantRequest3());


        //Admin reviewing and employing applicants
        adminService.reviewApplications(AdminService.listedApplicants);


        //Creating products
        ProductService productService = new ProductService();
        productService.createProducts();

        WalletService walletService = new WalletService();

        //Creating Customer Service
        CustomerService customerService = new CustomerService(walletService);
        Customer customer = customerService.createCutomer(RequestUtil.CustomerRequest());
        Customer customer2 = customerService.createCutomer(RequestUtil.CustomerRequest2());
        Customer customer3 = customerService.createCutomer(RequestUtil.CustomerRequest3());

        walletService.fundwallet(customer, 40000);
        walletService.fundwallet(customer2, 22000);
        walletService.fundwallet(customer3, 30000);


        //Cart Service
        customerService.addToCart(customer, "SO1", 2);
        customerService.addToCart(customer2, "SO2", 1);
        customerService.addToCart(customer3, "SO3", 3);

        customerService.addToWishlist(customer, ProductService.inventory.get(0));

        ReceiptService receiptService = new ReceiptService();


        //Cashier Service
        CashierService cashierService = new CashierService(receiptService);
        cashierService.sellProduct(customer, AdminService.listedStaffs.get(0), wallet);
        cashierService.sellProduct(customer2, AdminService.listedStaffs.get(1), wallet);
        cashierService.sellProduct(customer3, AdminService.listedStaffs.get(0), wallet);;
    }
}