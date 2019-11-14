package apiakademiksample.mongo.service;

import apiakademiksample.mongo.entitas.Parkir;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkirService {
    Page<Parkir> getAll(Pageable pageable);

    Parkir getById(String id) throws Exception;

    String save(Parkir parkir);

    void delete(String id);
}
