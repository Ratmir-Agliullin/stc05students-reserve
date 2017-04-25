package main.services;

import main.models.dao.UserDao;
import main.models.dao.UserDaoImpl;
import main.models.pojo.User;
import org.apache.log4j.Logger;

/**
 * Created by admin on 20.04.2017.
 */
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private static UserDao userDAO = new UserDaoImpl();

    public User auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login, password);
        logger.debug("user: " + user);

        if (user != null && user.isIs_block()) {
            return null;
        }
        logger.debug("user not blocked");

        return user;
    }
}
