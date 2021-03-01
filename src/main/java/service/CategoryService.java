package service;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements BaseService<Category> {
    DBUtil dbUtil = new DBUtil();

    private final String FIND_ALL = "select * from category";
    private final String FIND_BY_ID = "select * from category where id=?";
    private final String SAVE = "insert into category(name,description) values(?,?)";
    private final String UPDATE = "update category set name=?,description=? where id=?";
    private final String DELETE = "delete from category where id=?";

    @Override
    public List<Category> findAll() {
        List<Category> categoryList=new ArrayList<>();
        try(Connection connection= dbUtil.getConnection();
            PreparedStatement statement= connection.prepareStatement(FIND_ALL);
        ) {
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id =rs.getInt("id");
                String name=rs.getString("name");
                String description=rs.getString("description");
                categoryList.add(new Category(id,name,description));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findById(int id) {
        Category category=null;
        try(Connection connection= dbUtil.getConnection();
            PreparedStatement statement= connection.prepareStatement(FIND_BY_ID);
        ) {
            statement.setInt(1,id);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                String description=rs.getString("description");
                category=new Category(id,name,description);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public void save(Category category) {
        try(Connection connection= dbUtil.getConnection();
            PreparedStatement statement= connection.prepareStatement(SAVE);
        ) {
            statement.setString(1,category.getName());
            statement.setString(2, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        try(Connection connection= dbUtil.getConnection();
            PreparedStatement statement= connection.prepareStatement(UPDATE);
        ) {
            statement.setString(1,category.getName());
            statement.setString(2, category.getDescription());
            statement.setInt(3,category.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try(Connection connection= dbUtil.getConnection();
            PreparedStatement statement= connection.prepareStatement(DELETE);
        ) {
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
