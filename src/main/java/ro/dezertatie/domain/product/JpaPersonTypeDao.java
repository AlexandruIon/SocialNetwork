package ro.dezertatie.domain.product;


import ro.dezertatie.common.dao.JpaCrudDao;
import ro.dezertatie.domain.person.PersonType;
import ro.dezertatie.domain.person.PersonTypeDao;

public class JpaPersonTypeDao extends JpaCrudDao<PersonType, String> implements PersonTypeDao {
}
