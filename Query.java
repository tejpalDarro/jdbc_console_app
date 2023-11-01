class Query {
    static String insert = "insert into userdetails(user_name, user_email, user_pass) values (?,?,?)";
    static String select = "select * from userdetails";
    static String update = "update userdetails SET user_name = ? WHERE user_id = ?";
    static String delete = "delete from userdetails WHERE user_id = ?";
}
