import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

    private String uname;
    private String email;
    private String password;
    private String city;
    private String picture;

    Connection conn;
    PreparedStatement pstmt;


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int register(){
        conn = JDBCUtil.connection();
        String query = "Insert into user (name,email,password,city,picture) values (?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,uname);
            pstmt.setString(2,email);
            pstmt.setString(3,password);
            pstmt.setString(4,city);
            pstmt.setString(5,picture);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void close(){
        if(conn != null){
            try {
                conn.close();
                if(pstmt != null){
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
