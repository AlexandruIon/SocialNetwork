package ro.dezertatie.domain.user;


import ro.dezertatie.common.dao.JpaCrudDao;

public class JpaUserDao extends JpaCrudDao<User, String> implements UserDao {
}
