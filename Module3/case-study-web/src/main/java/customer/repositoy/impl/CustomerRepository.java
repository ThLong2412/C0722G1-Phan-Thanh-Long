package customer.repositoy.impl;

import customer.model.Customer;
import customer.repositoy.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  CustomerRepository implements ICustomerRepository {

    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    public static class BaseRepository {
        private static final String URL ="jdbc:mysql://localhost:3306/case_study_module3_tables"; // sửa lại tên của csdl
        private static final String USER ="root";// mặc định của mysql
        private static final String PASS ="241204L";// do cài đặt khi cài đặt mysql
        public static Connection getConnectDB(){
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection= DriverManager.getConnection(URL,USER,PASS);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return connection;
        }
    }

    @Override
    public List<Customer> listCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int customer_type_id = rs.getInt("customer_type_id");
                String name = rs.getString("name");
                String day_of_birth = rs.getString("day_of_birth");
                boolean gender = rs.getBoolean("gender");
                String id_card = rs.getString("id_card");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customerList.add(new Customer(id,customer_type_id,name,day_of_birth,gender,id_card,phone_number,email,address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
