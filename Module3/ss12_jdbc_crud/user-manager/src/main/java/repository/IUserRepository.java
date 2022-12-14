package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
     void insertUser(User user) throws SQLException;

     User selectUser(int id);

     List<User> selectAllUsers() throws SQLException;

     boolean deleteUser(int id) throws SQLException;

     boolean updateUser(User user) throws SQLException;

     List<User> findByCountry(String country);
     List<User> sortUser(String name) throws SQLException;
     User getUserById(int id);

     void insertUserStore(User user) throws SQLException;
     void addUserTransaction();
}
