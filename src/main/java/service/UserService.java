package service;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements BaseService<User> {

    DBUtil dbUtil = new DBUtil();

    private final String FIND_ALL = "select * from users";
    private final String FIND_BY_ID = "select * from users where id=?";
    private final String SAVE = "insert into users(username,password,fullname) values(?,?,?)";
    private final String SAVE_WITH_STATUS="insert into users(username,password,fullname,status) values(?,?,?,?)";
    private final String UPDATE = "update users set username=?,password=?,fullname=?,status=? where id=?";
    private final String DELETE = "delete from users where id=?";
    private final String FIND_BY_NAME_PASSWORD="select * from users where username like(?) and password like(?);";


    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                int status =rs.getInt("status");
                userList.add(new User(id, username, password, fullname,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname= rs.getString("fullname");
                int status =rs.getInt("status");
               user=new User(id, username, password, fullname,status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user) {
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveWithStatus(User user){
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_WITH_STATUS)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.setInt(4,user.getStatus());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.setInt(4,user.getStatus());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User findUserByUANDP(String username,String password){
        User user=null;
        try(Connection connection= dbUtil.getConnection();
        PreparedStatement statement=connection.prepareStatement(FIND_BY_NAME_PASSWORD)){
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String fullname=rs.getString("fullname");
                int status=rs.getInt("status");
                user=new User(id,username,password,fullname,status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
