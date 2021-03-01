package service;

import model.Category;
import model.Post;
import model.StatisticDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostService implements BaseService<Post> {
    DBUtil dbUtil = new DBUtil();

    private final String FIND_ALL = "select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id";
    private final String FIND_BY_ID = "select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id where p.id=?";
    private final String SAVE = "insert into post(title,short_content,long_content,image,id_category) values(?,?,?,?,?)";
    private final String UPDATE = "update post set title=?,short_content=?,long_content=?,image=?,id_category=? where id=?";
    private final String DELETE = "delete from post where id=?";

    private final String FIND_TOP2 ="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id order by p.pulish_date desc limit 2";
    private final String FIND_TOP6="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id order by p.pulish_date desc limit 6";
    private final String FIND_TOP6_DOWN="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id order by p.pulish_date limit 6";
    private final String FIND_TOP1_VIEWS="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id order by p.views desc limit 1";
    private final String FIND_TOP3_VIEWS="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id order by p.views desc limit 3";
    private final String FIND_TOP4_VIEWS="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id order by p.views desc limit 4";
    private final String FIND_TOP2_TOURNAMENTS="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id where c.name='Tournaments' order by p.pulish_date desc limit 2";
    private final String FIND_TOP1_REVIEW_VIEWS="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id where c.name='Review' order by p.views desc limit 1";
    private final String FIND_TOP1_GAMEPLAY_VIEWS="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id where c.name='New GamePlay Today Live' order by p.views desc limit 1";
    private final String FIND_TOP1_HIGHLIGHT_VIEWS="select p.*,c.name as name_category from post p inner join category c on p.id_category=c.id where c.name='Highlight' order by p.views desc limit 1";

    private final String SUM_CATEGORY="select p.id_category,count(p.id) as sum_post,c.name as name_category from post p inner join category c on p.id_category =c.id where c.name in ('News','Preview','Tournaments','Highlight') group by id_category";



    @Override
    public List<Post> findAll() {
        List<Post> postList=new ArrayList<>();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_ALL)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                postList.add(new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }

    @Override
    public Post findById(int id) {
        Post post=null;
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_BY_ID)
        ){
            statement.setInt(1,id);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                String title=rs.getString("title");
                String longContent=rs.getString("long_content");
                String shortContent=rs.getString("short_content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                int idCategory=rs.getInt("id_category");
                String image=rs.getString("image");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                post=new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }

    @Override
    public void save(Post post) {
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(SAVE)
        ){
            statement.setString(1,post.getTitle());
            statement.setString(2,post.getShortContent());
            statement.setString(3,post.getLongContent());
            statement.setString(4,post.getImage());
            statement.setInt(5,post.getCategory().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Post post) {
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(UPDATE)
        ){
            statement.setString(1,post.getTitle());
            statement.setString(2,post.getShortContent());
            statement.setString(3,post.getLongContent());
            statement.setInt(4,post.getCategory().getId());
            statement.setString(5,post.getImage());
            statement.setInt(6,post.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE)
        ){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Post> findTop2(){
        List<Post> postList=new ArrayList<>();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP2)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                postList.add(new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }

    public List<Post> findTop6(){
        List<Post> postList=new ArrayList<>();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP6)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                postList.add(new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }

    public List<Post> findTop6Down(){
        List<Post> postList=new ArrayList<>();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP6_DOWN)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                postList.add(new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }
    public Post findTop1Views(){
        Post post=new Post();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP1_VIEWS)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                post=new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }

    public List<Post> findTop3Views(){
        List<Post> postList=new ArrayList<>();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP3_VIEWS)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                postList.add(new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }

    public List<Post> findTop4Views(){
        List<Post> postList=new ArrayList<>();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP4_VIEWS)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                postList.add(new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }

    public List<Post> findTop2Tournaments(){
        List<Post> postList=new ArrayList<>();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP2_TOURNAMENTS)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                postList.add(new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }

    public Post findTop1ReviewViews(){
        Post post=new Post();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP1_REVIEW_VIEWS)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                post=new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }

    public Post findTop1GameplayViews(){
        Post post=new Post();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP1_GAMEPLAY_VIEWS)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                post=new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }

    public Post findTop1HighlightViews(){
        Post post=new Post();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_TOP1_HIGHLIGHT_VIEWS)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String shortContent=rs.getString("short_content");
                String longContent=rs.getString("long_Content");
                String date=rs.getString("pulish_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime pulishDate = LocalDateTime.parse(date, formatter);
                String image=rs.getString("image");
                int idCategory=rs.getInt("id_category");
                String nameCategory=rs.getString("name_category");
                int views=rs.getInt("views");
                post=new Post(id,title,shortContent,longContent,pulishDate,image,new Category(idCategory,nameCategory),views);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }

    public List<StatisticDTO> sumCategory(){
        List<StatisticDTO> list=new ArrayList<>();
        try(Connection connection=dbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(SUM_CATEGORY)
        ){
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                String nameCategory=rs.getString("name_category");
                int sumCategory=rs.getInt("sum_post");
                list.add(new StatisticDTO(new Category(nameCategory),sumCategory));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
