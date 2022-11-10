package repositoy.impl;

import model.Customer;
import repositoy.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static final String INSERT_CUSTOMER = "insert into customer values (?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where id = ?";
    private static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?, name  = ?, day_of_birth = ?, gender = ?, id_card =?, phone_number = ?, email = ?, address = ? where id = ?";
    private static final String GET_CUSTOMER_BY_ID = "select * from customer where  id = ?";

    public static class BaseRepository {
        private static final String URL = "jdbc:mysql://localhost:3306/case_study_module3_tables"; // sửa lại tên của csdl
        private static final String USER = "root";// mặc định của mysql
        private static final String PASS = "241204L";// do cài đặt khi cài đặt mysql

        public static Connection getConnectDB() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASS);
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
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
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
                customerList.add(new Customer(id, customer_type_id, name, day_of_birth, gender, id_card, phone_number, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Customer customer) {
        boolean rowUpdate = false;
        try {
            try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER)) {
                preparedStatement.setInt(1, customer.getCustomerType());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getBirthday());
                preparedStatement.setBoolean(4, customer.isGender());
                preparedStatement.setString(5, customer.getIdCard());
                preparedStatement.setString(6, customer.getPhoneNumber());
                preparedStatement.setString(7, customer.getEmail());
                preparedStatement.setString(8, customer.getAddress());
                preparedStatement.setInt(9, customer.getId());
                rowUpdate = preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customer_type_id = rs.getInt("customer_type_id");
                String name = rs.getString("name");
                String day_of_birth = rs.getString("day_of_birth");
                boolean gender = rs.getBoolean("gender");
                String id_card = rs.getString("id_card");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id, customer_type_id, name, day_of_birth, gender, id_card, phone_number, email, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER)) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setInt(2, customer.getCustomerType());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getBirthday());
            preparedStatement.setBoolean(5, customer.isGender());
            preparedStatement.setString(6, customer.getIdCard());
            preparedStatement.setString(7, customer.getPhoneNumber());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Customer> search(int id) {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customer_type_id = rs.getInt("customer_type_id");
                String name = rs.getString("name");
                String day_of_birth = rs.getString("day_of_birth");
                boolean gender = rs.getBoolean("gender");
                String id_card = rs.getString("id_card");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Customer customer = new Customer(id, customer_type_id, name, day_of_birth, gender, id_card, phone_number, email, address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
