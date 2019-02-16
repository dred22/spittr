package spittr.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import spittr.data.dao.SpitterDao;
import spittr.data.models.Spitter;
import spittr.services.SpitterRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class SpitterRepositoryImpl
        implements SpitterRepository {

    @Autowired
    private SpitterDao spitterDao;

    @Value("${defaultUsers}")
    private String defaultUsers;

    private Map<String, String> mapUserAndPassword;

    @Override
    public Spitter save(Spitter spitter) {
        return spitterDao.create(spitter);
    }

    @Override
    public Spitter findByUsername(String username) {
        Spitter defaultSpitter = getDefault(username);
        if (defaultSpitter != null) {
            return defaultSpitter;
        }
        Spitter oneByName = spitterDao.findOneByUsername(username);
        return oneByName;
    }

    private Spitter getDefault(String username) {
        if (mapUserAndPassword == null) {
            String[] split = defaultUsers.split(",");
            mapUserAndPassword = Arrays.stream(split)
                    .collect(Collectors.toMap(x -> x.split(":")[0], x -> x.split(":")[1]));
        }

        Spitter spitter = null;
        if (mapUserAndPassword.get(username) != null) {
            spitter = new Spitter();
            spitter.setUsername(username);
            spitter.setPassword(mapUserAndPassword.get(username));
        }
        return spitter;
    }

    @Override
    public List<Spitter> findSpitters(long max, int count) {
        return Arrays.asList(new Spitter("Maga", LocalDate.now()), new Spitter("Istre", LocalDate.now()));
    }

    @Override
    public Spitter findOne(long i) {


        return null;
    }
}
