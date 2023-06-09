//package CaseStudy.Demo.Service;
//
//import CaseStudy.Demo.Config;
//import CaseStudy.Utils.FileUtils;
//
//import java.util.List;
//
//    public class CustomerService {
//        private final String pathCustomer = "D:\\module2\\CaseStudy\\src\\codegym\\data\\customer.txt";
//
//        public List<codegym.Customer> getAllCustomers() {
//            return FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
//        }
//
//        public codegym.Customer findCustomerById(long idCustomer) {
//            List<codegym.Customer> customers = FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
//            for (codegym.Customer c : customers) {
//                if (c.getId() == idCustomer) {
//                    return c;
//                }
//            }
//            return null;
//        }
//
//        public void updateCustomerById(long idCustomer, codegym.Customer customer) {
//            List<codegym.Customer> customers = FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
//            for (codegym.Customer c : customers) {
//                if (c.getId() == idCustomer) {
//                    c.setName(customer.getName());
//                    c.setAddress(customer.getAddress());
//                    c.setTelephone(customer.getTelephone());
//                }
//            }
//            FileUtils.writeFile(pathCustomer, customers);
//        }
//
//        public void deleteCustomerById(long idCustomer) {
//            List<codegym.Customer> customers = FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
//            for (int i = 0; i < customers.size(); i++) {
//                if (customers.get(i).getId() == idCustomer) {
//                    customers.remove(i);
//                    break;
//                }
//            }
//            FileUtils.writeFile(pathCustomer, customers);
//        }
//        public void addCustomer(codegym.Customer customer){
//            List<codegym.Customer> customers = FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
//            customers.add(customer);
//            FileUtils.writeFile(pathCustomer, customers);
//        }
//    }
